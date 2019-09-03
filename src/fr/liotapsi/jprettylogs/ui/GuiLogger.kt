package fr.liotapsi.jprettylogs.ui

import fr.liotapsi.jprettylogs.ILogger
import java.awt.Dimension
import java.awt.Image
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea



class GuiLogger : ILogger {
    override fun error(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    [!]    | ${tmp[0]}"
        this.text.append("$str1\n")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.text.append("$str2\n")
        }
    }

    override fun info(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    [i]    | ${tmp[0]}"
        this.text.append("$str1\n")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.text.append("$str2\n")
        }
    }

    override fun debug(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    ...    | ${tmp[0]}"
        this.text.append("$str1\n")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.text.append("$str2\n")
        }
    }

    override fun warning(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    /!\\    | ${tmp[0]}"
        this.text.append("$str1\n")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.text.append("$str2\n")
        }
    }

    override fun critical(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    !!!    | ${tmp[0]}"
        this.text.append("$str1\n")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.text.append("$str2\n")
        }
    }

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
        frame.isVisible = true
    }

    fun defaultCloseOperation(type: Int): GuiLogger {
        this.frame.defaultCloseOperation = type
        return this
    }

    fun closeGui() {
        this.frame.dispose()
    }
    
    fun setIcon(image: Image): GuiLogger {
        this.frame.iconImage = image
        return this
    }
}