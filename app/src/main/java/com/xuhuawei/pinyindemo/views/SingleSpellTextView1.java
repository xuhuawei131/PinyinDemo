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
public class SingleSpellTextView1 extends TextView {
    private String pinyin= "Aabcdefeigyuz"+ChineseCharacter2Spell.getPinyinString("许华维")[0];
//    private String pinyin="Aabcdefeigyuz";
    private TextPaint textPaintSpell = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint textPaintLine = new TextPaint(Paint.ANTI_ALIAS_FLAG);


    private int colorSpell = Color.parseColor("#1b97d6");

    public SingleSpellTextView1(Context context) {
        super(context);
        initTextPaint();
    }

    public SingleSpellTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTextPaint();
    }

    public SingleSpellTextView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTextPaint();
    }

    public void initTextPaint() {
        textPaintSpell.setTextAlign(Paint.Align.LEFT);
        //设置字体大小
        textPaintSpell.setTextSize(50);
        textPaintSpell.setColor(colorSpell);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Rect rect=getTextTextBounds("aiezyg");
        int height=rect.height()*3;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float baseY=100;
        Paint.FontMetrics fontMetrics = textPaintSpell.getFontMetrics();
        float top=fontMetrics.top+baseY;
        float bottom=fontMetrics.bottom+baseY;
        float ascent=fontMetrics.ascent+baseY;
        float descent=fontMetrics.descent+baseY;
        float leading=fontMetrics.leading;

        float letterHeight=fontMetrics.ascent*0.569f+baseY;

        float itemHeight=Math.abs(fontMetrics.ascent*0.569f);


        Log.v("xhw","top "+top+" bottom "+bottom+" ascent "+ascent+" descent "+descent+" leading "+leading+" letterHeight "+letterHeight);

        canvas.drawText(pinyin, 0, baseY, textPaintSpell);

//        //bottom
//        canvas.drawLine(0,bottom,ConvertUtils.dp2px(getContext(),200),bottom,textPaintLine);
//         //descent
//        canvas.drawLine(0,descent,ConvertUtils.dp2px(getContext(),200),descent,textPaintLine);

        //baseline的线下面的线
        canvas.drawLine(0,baseY+itemHeight,ConvertUtils.dp2px(getContext(),200),baseY+itemHeight,textPaintLine);

        //baseline的线
        canvas.drawLine(0,baseY,ConvertUtils.dp2px(getContext(),200),baseY,textPaintLine);
        //字母的上线
        canvas.drawLine(0,letterHeight,ConvertUtils.dp2px(getContext(),200),letterHeight,textPaintLine);
        //字母的上线的上
        canvas.drawLine(0,letterHeight-itemHeight,ConvertUtils.dp2px(getContext(),200),letterHeight-itemHeight,textPaintLine);


//        //ascent线
//        canvas.drawLine(0,ascent,ConvertUtils.dp2px(getContext(),200),ascent,textPaintLine);
//        //top线
//        canvas.drawLine(0,top,ConvertUtils.dp2px(getContext(),200),top,textPaintLine);



    }

    private Rect getTextTextBounds(String str){
        Paint paint = new Paint();
        paint.set(textPaintSpell);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

}
