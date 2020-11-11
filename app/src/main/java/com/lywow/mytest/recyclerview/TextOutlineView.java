package com.lywow.mytest.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.lywow.mytest.R;

import java.lang.reflect.Field;

public class TextOutlineView extends AppCompatTextView {
    private TextView outlineTextView = null;
    private int mBorderWidth;
    private int mOutlineColor;

    public TextOutlineView(Context context) {
        super(context);

        outlineTextView = new TextView(context);
        init();
    }

    public TextOutlineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextOutlineView);//获取自定义的XML属性名称
        mOutlineColor = a.getColor(R.styleable.TextOutlineView_outlineColor, 0xffffff);
        mBorderWidth = a.getInteger(R.styleable.TextOutlineView_borderWidth, 0);
        outlineTextView = new TextView(context, attrs);
        init();
    }

    public TextOutlineView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextOutlineView);//获取自定义的XML属性名称
        mOutlineColor = a.getColor(R.styleable.TextOutlineView_outlineColor, 0xffffff);
        mBorderWidth = a.getInteger(R.styleable.TextOutlineView_borderWidth, 0);
        outlineTextView = new TextView(context, attrs, defStyle);
        init();
    }

    public void init() {
        TextPaint paint = outlineTextView.getPaint();
        paint.setStrokeWidth(mBorderWidth);// 描边宽度
        paint.setStyle(Paint.Style.STROKE);
        outlineTextView.setTextColor(mOutlineColor);// 描边颜色
        outlineTextView.setGravity(getGravity());
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        outlineTextView.setLayoutParams(params);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 设置轮廓文字
        CharSequence outlineText = outlineTextView.getText();
        if (outlineText == null || !outlineText.equals(this.getText())) {
            outlineTextView.setText(getText());
            postInvalidate();
        }
        outlineTextView.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        outlineTextView.layout(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        outlineTextView.draw(canvas);
        super.onDraw(canvas);
    }

//    private TextPaint mTextPaint;
//
//    private int mBorderWidth;
//    private int mInnerColor;
//    private int mOuterColor;
//
//    public TextOutlineView(Context context, int outerColor, int innnerColor) {
//        super(context);
//        mTextPaint = this.getPaint();
//        this.mInnerColor = innnerColor;
//        this.mOuterColor = outerColor;
//    }
//
//    public TextOutlineView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        mTextPaint = getPaint();
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextOutlineView);//获取自定义的XML属性名称
//        mInnerColor = a.getColor(R.styleable.TextOutlineView_innerColor, 0xffffff);//获取对应的属性值
//        mOuterColor = a.getColor(R.styleable.TextOutlineView_outerColor, 0xffffff);
//        mBorderWidth = a.getInteger(R.styleable.TextOutlineView_borderWidth, 0);
//    }
//
//    public TextOutlineView(Context context, AttributeSet attrs, int defStyle, int outerColor, int innnerColor) {
//        super(context, attrs, defStyle);
//        mTextPaint = this.getPaint();
//        this.mInnerColor = innnerColor;
//        this.mOuterColor = outerColor;
//    }
//
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        if (mBorderWidth > 0) {
//            // 描外层
//            // super.setTextColor(Color.BLUE); // 不能直接这么设，如此会导致递归
//            // setTextColorUseReflection(Color.YELLOW);
////            setTextColorUseReflection(mOuterColor);
//            mTextPaint.setStrokeWidth(mBorderWidth); // 描边宽度
//            mTextPaint.setColor(mOuterColor);
//            mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE); // 描边种类
//            mTextPaint.setFakeBoldText(true); // 外层text采用粗体
//            //radius：阴影半径  dx：X轴方向的偏移量  dy：Y轴方向的偏移量  color：阴影颜色
//            mTextPaint.setShadowLayer(5, 0, 0, 0); // 字体的阴影效果，可以忽略
//            super.onDraw(canvas);
//            // 描内层，恢复原先的画笔
//            // super.setTextColor(Color.BLUE); // 不能直接这么设，如此会导致递归
////            setTextColorUseReflection(mInnerColor);
//            mTextPaint.setColor(mInnerColor);
//            mTextPaint.setStrokeWidth(0);
////            m_TextPaint.setStyle(Style.FILL_AND_STROKE);
//            mTextPaint.setFakeBoldText(false);
//            mTextPaint.setShadowLayer(0, 0, 0, 0);
//
//        }
//        super.onDraw(canvas);
//    }
//
//    /**
//     * 使用反射的方法进行字体颜色的设置
//     *
//     * @param color
//     */
//    private void setTextColorUseReflection(int color) {
//        Field textColorField;
//        try {
//            textColorField = TextView.class.getDeclaredField("mCurTextColor");
//            textColorField.setAccessible(true);
//            textColorField.set(this, color);
//            textColorField.setAccessible(false);
//        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        mTextPaint.setColor(color);
//    }
}
