package alanyuan.playandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Scroller
import kotlin.random.Random

class RandomBall @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()
    private val mScroller = Scroller(context)
    private lateinit var mRollPair: Pair<Int, Int>

    init {
        rollNumber()
        rollRGB()
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
    }

    fun randomScroll() {
        val randomX = mRollPair.first
        val randomY = mRollPair.second
        Log.d("RandomBall", "scrollX$scrollX randomX$randomX scrollY$scrollY randomY$randomY")
        Log.d("RandomBall", "X${x - scrollX} Y${y - scrollY}")
        Log.d("RandomBall", "X${x - scrollX + width - (parent as View).width} Y${y - scrollY + height - (parent as View).height}")
        while ((randomX + scrollX) > x || (randomY + scrollY) > y || x + width - randomX - scrollX > (parent as View).width || y + height - randomY - scrollY > (parent as View).height) {
            rollNumber()
            rollRGB()
            randomScroll()
            return
        }
        mScroller.startScroll(scrollX, scrollY, randomX, randomY, 10)
        invalidate()
    }

    override fun computeScroll() {
        super.computeScroll()
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX, mScroller.currY)
            postInvalidate()
        } else {
            randomScroll()
        }
    }

    private fun rollNumber() {
        val rollX = Random.nextInt(-50, 50)
        val rollY = Random.nextInt(-50, 50)
        mRollPair = Pair(rollX, rollY)
    }

    private fun rollRGB() {
        mPaint.color = Color.rgb(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2F
        val centerY = height / 2F
        canvas.drawCircle(centerX, centerY, (width / 2).toFloat(), mPaint)
    }
}