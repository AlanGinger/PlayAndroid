package alanyuan.playandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_random_ball.*

class RandomBallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_random_ball)
        init()
    }

    private fun init() {
        ball.setOnClickListener {
            ball.randomScroll()
        }
    }


}
