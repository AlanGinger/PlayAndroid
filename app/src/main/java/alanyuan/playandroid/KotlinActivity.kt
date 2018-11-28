package alanyuan.playandroid

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import java.io.File
import kotlin.random.Random

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_kotlin)
        main()
    }

    private fun main() {
    }

    private fun playRun() {
        val random = Random.nextInt(10)
        run {
            val random = Random.nextInt(10)
            if (random >= 5)
                Dialog(this)
            else
                BottomSheetDialog(this)
        }.show()
    }

    private fun playWith() {
        var webView: WebView = WebView(this)
        with(webView.settings) {
            javaScriptEnabled = true
            blockNetworkImage = true
        }

        webView.settings.run {
            javaScriptEnabled = true
            blockNetworkImage = true
        }
    }

    private fun playLet() {
        val abc: String? = "abc"
        abc?.run {
            println("字符串的长度为${this.length}")
        }
        abc?.let {
            println("字符串的长度为${it.length}")
        }
    }

    private fun playAlso(path: String?) : File? {
        return path?.let {
            File(it)
        }?.also {
            it.mkdirs()
        }
    }

    private fun playApply() {
        var intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("")

        intent = Intent().apply {
            action = Intent.ACTION_VIEW
            putExtra("abc", true)
            data = Uri.EMPTY
        }
    }

}