package alanyuan.azeroth;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

import com.blankj.utilcode.util.ConvertUtils;

/**
 * 使TextView中不同大小字体垂直居中
 */
public class CustomVerticalCenterSpan extends ReplacementSpan {
    private int fontSize;    //字体大小dp

    public CustomVerticalCenterSpan(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        text = text.subSequence(start, end);
        Paint p = getCustomTextPaint(paint);
        return (int) p.measureText(text.toString());
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        text = text.subSequence(start, end);
        Paint p = getCustomTextPaint(paint);
        Paint.FontMetricsInt fm = p.getFontMetricsInt();
        canvas.drawText(text.toString(), x, (bottom + top) / 2 - (fm.descent + fm.ascent) / 2, p);    //此处重新计算y坐标，使字体居中
    }

    private TextPaint getCustomTextPaint(Paint srcPaint) {
        TextPaint paint = new TextPaint(srcPaint);
        paint.setTextSize(ConvertUtils.dp2px(fontSize));   //设定字体大小, dp转换为px
        return paint;
    }
}