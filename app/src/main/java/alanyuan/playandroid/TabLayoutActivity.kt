package alanyuan.playandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_tablayout.*

import java.util.ArrayList

/**
 * Created by alanyuan on 2018/10/23
 */
class TabLayoutActivity : AppCompatActivity() {
    private val tabs = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_tablayout)
        for (i in 0..15) {
            tabs.add("ABC$i")
        }
        layout_tab.setData(tabs)
    }
}
