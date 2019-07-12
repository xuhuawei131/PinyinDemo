package com.xuhuawei.pinyindemo.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.xuhuawei.pinyindemo.utils.ChineseCharacter2Spell;
import com.xuhuawei.pinyindemo.utils.ConvertUtils;

@SuppressLint("AppCompatCustomView")
public class SingleSpellTextView extends TextView {
    private String pinyin="Aabcdefeigyuz";
    private TextPaint textPaintSpell = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint textPaintLine = new TextPaint(Paint.ANTI_ALIAS_FLAG);


    private int colorSpell = Color.parseColor("#1b97d6");

    public SingleSpellTextView(Context context) {
        super(context);
        initTextPaint();
    }

    public SingleSpellTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTextPaint();
    }

    public SingleSpellTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTextPaint();
    }

    public void initTextPaint() {
//        float denity = getResources().getDisplayMetrics().density;
//        textPaintSpell.setStrokeWidth(denity);

        textPaintSpell.setTextAlign(Paint.Align.LEFT);


        //设置字体大小
        textPaintSpell.setTextSize(50);
        textPaintSpell.setColor(colorSpell);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaintSpell.getFontMetrics();
        float FontSpacing=textPaintSpell.getFontSpacing();
        float top=fontMetrics.top;
        float bottom=fontMetrics.bottom;
        float ascent=fontMetrics.ascent;
        float descent=fontMetrics.descent;
        float leading=fontMetrics.leading;


        Log.v("xhw","top "+top+" bottom "+bottom+" ascent "+ascent+" descent "+descent+" leading "+leading+" FontSpacing "+FontSpacing);

        Rect rectA=getTextTextBounds(pinyin);
        Rect rectB=getTextTextBounds("b");
        Rect rectG=getTextTextBounds("g");
        Rect rectY=getTextTextBounds("y");

        Log.v("xhw","bottom "+rectA.bottom+" height"+rectA.height());

        float y1=bottom-top;
        float y2=ascent-top;
//        float y3=Math.abs(top);
        float y3=Math.abs(ascent);
        float y4=0;


        canvas.drawText(pinyin, 0, y3, textPaintSpell);
        //最下面的线
        canvas.drawLine(0,y1,ConvertUtils.dp2px(getContext(),100),y1,textPaintLine);
        //baseline的线
        canvas.drawLine(0,y3,ConvertUtils.dp2px(getContext(),100),y3,textPaintLine);
        //ascent线
        canvas.drawLine(0,y2,ConvertUtils.dp2px(getContext(),100),y2,textPaintLine);
        //top线
        canvas.drawLine(0,y4,ConvertUtils.dp2px(getContext(),100),y4,textPaintLine);



    }

    private Rect getTextTextBounds(String str){
        Paint paint = new Paint();
        paint.set(textPaintSpell);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

}
