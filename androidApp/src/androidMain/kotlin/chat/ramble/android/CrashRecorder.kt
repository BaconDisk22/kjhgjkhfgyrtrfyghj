package chat.ramble.android

import android.content.Context
import android.os.Build
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Keeps the stack trace of the last crash, so the next launch can offer to
 * share it. Android keeps no crash log a user can reach without a computer,
 * and a report of "it closed" with no trace leaves nothing to go on.
 *
 * The handler writes the file and then hands the crash on to the previous
 * handler, so the system's own crash handling is unchanged. One file, the
 * latest crash only, removed once the user shares or dismisses it.
 */
object CrashRecorder {
    private const val FILE_NAME = "last_crash.txt"

    fun install(context: Context) {
        val app = context.applicationContext
        val previous = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, error ->
            // Nothing here may throw: a failure while recording must not
            // hide the crash it was recording.
            runCatching { file(app).writeText(report(app, thread, error)) }
            previous?.uncaughtException(thread, error)
        }
    }

    /** The recorded crash report, or null when the last run did not crash. */
    fun pending(context: Context): String? =
        runCatching { file(context).takeIf { it.exists() }?.readText() }.getOrNull()

    fun clear(context: Context) {
        runCatching { file(context).delete() }
    }

    private fun file(context: Context) = File(context.filesDir, FILE_NAME)

    private fun report(context: Context, thread: Thread, error: Throwable): String {
        val version = runCatching {
            context.packageManager.getPackageInfo(context.packageName, 0).versionName
        }.getOrNull() ?: "?"
        val trace = StringWriter().also { error.printStackTrace(PrintWriter(it)) }
        val time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US).format(Date())
        return buildString {
            appendLine("Ramble $version crash")
            appendLine("Time: $time")
            appendLine("Device: ${Build.MANUFACTURER} ${Build.MODEL}, Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
            appendLine("Thread: ${thread.name}")
            appendLine()
            append(trace)
        }
    }
}
