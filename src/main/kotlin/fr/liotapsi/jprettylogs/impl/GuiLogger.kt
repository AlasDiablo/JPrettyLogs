package fr.liotapsi.jprettylogs.impl

import java.awt.Dimension
import java.awt.Image
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

/**
 * Implementation of GUI logger
 * @author AlasDiablo
 * @since 3.0.0
 * @param title title of the gui
 * @param icon icon of the gui
 * @param critical enable or not critical output
 * @param error enable or not error output
 * @param info enable or not info output
 * @param debug enable or not debug output
 * @param warning enable or not warning output
 */
class GuiLogger(
    title: String = "JPrettyLogs",
    icon: Image? = null,
    critical: Boolean = true,
    error: Boolean = true,
    info: Boolean = false,
    debug: Boolean = false,
    warning: Boolean = false
) : SimpleLogger(critical = critical, error = error, info = info, debug = debug, warning = warning) {


    private val text: JTextArea = JTextArea()
    private val frame: JFrame

    init {
        text.isEditable = false
        val scroll = JScrollPane(
            this.text,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        )
        this.frame = JFrame()
        frame.add(scroll)
        frame.size = Dimension(350, 500)
        frame.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        frame.title = title
        if (icon != null) frame.iconImage = icon
        frame.isVisible = true
    }

    fun close() {
        this.frame.dispose()
    }

    override fun println(message: String) {
        this.text.append("$message\n")
    }

    override fun printMessage(message: Array<String>, prefix: String) {
        this.println("    $prefix    | ${message[0]}")

        for (i in 1 until message.size step 1)
            this.println("           | ${message[i]}")
    }
}