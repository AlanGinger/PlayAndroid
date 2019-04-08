package alanyuan.playandroid

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class TouchEventViewGroup @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val TAG: String = tag as String

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        Log.d(TAG, "$TAG ${event.action} dispatchTouchEvent begin")
        val result = super.dispatchTouchEvent(event)
        Log.d(TAG, "$TAG ${event.action} dispatchTouchEvent end $result")
        return result
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        val result : Boolean
        if (TAG == "B") {
            result = true
        } else {
            result = super.onInterceptTouchEvent(event)
        }
        Log.d(TAG, "$TAG ${event.action} onInterceptTouchEvent $result")
        return result
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val consume: Boolean
        if (TAG == "C") {
            consume = true
        } else {
            consume = super.onTouchEvent(event)
        }
        Log.d(TAG, "$TAG ${event.action} onTouchEvent $consume")
        return consume
    }
}