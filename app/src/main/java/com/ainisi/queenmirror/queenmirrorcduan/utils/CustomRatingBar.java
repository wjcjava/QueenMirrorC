package com.ainisi.queenmirror.queenmirrorcduan.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;


/**
 * Created by Xuan on 2017/7/4.
 * 自定义星级条
 */

public class CustomRatingBar extends View {
    //星星个数
    private int mStarNum;
    //星星之间的距离
    private int mStarDistance;
    //星星的大小
    private int mStarSize;
    //空星星图片
    private Drawable mEmptyStar;
    //填充的星星的照片
    private Bitmap mFillStar;
    //星星的进度
    private float mTouchStarMark;
    //触摸模式 1--单个星星   2--随意进度
    //3--半个星星
    private int mMode;
    //是否可以触摸
    private boolean mTouchAble;
    private Paint mPaint;

    //星星变化接口
    public interface onStarChangedListener {
        void onStarChange(CustomRatingBar ratingBar, float mark);
    }

    private onStarChangedListener mOnStarChangeListener;

    public void setmOnStarChangeListener(onStarChangedListener mOnStarChangeListener) {
        this.mOnStarChangeListener = mOnStarChangeListener;
    }

    public CustomRatingBar(Context context) {
        this(context, null);
    }

    public CustomRatingBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!mTouchAble) {
            return super.onTouchEvent(event);
        }
        float x = event.getX();
        if (x == 0 || x > (mStarNum * (mStarSize + mStarDistance) - mStarDistance)) {
            return true;
        } else {
            int n = (int) (x / (mStarDistance + mStarSize));
            float touchStar = n + (x - n * (mStarDistance + mStarSize)) / mStarSize;
            switch (mMode) {
                case 1://整个星星
                    touchStar = (float) Math.ceil(touchStar);
                    break;
                case 2://随意
                    touchStar = (float) Math.ceil(touchStar);
                    break;
                case 3: {
                    touchStar = (float) Math.ceil(touchStar);
                    break;
                }
            }
            /**
             * 触摸后最小值为0.5
             */
            if (touchStar <= 0) {
                touchStar = 0;
            }
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    setRating(touchStar);
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    setRating(touchStar);
                    break;
                }
                case MotionEvent.ACTION_UP:
                    break;
            }
        }
        invalidate();

        return true;
    }


    /**
     * 设置评分
     */
    public void setRating(float touchStar) {
        if (mOnStarChangeListener != null) {
            this.mOnStarChangeListener.onStarChange(this, touchStar);
        }
        mTouchStarMark = touchStar;
        invalidate();
    }

    /**
     * 获得评分
     */
    public float getRating() {
        return mTouchStarMark;
    }

    /**
     * 设置是否可以点击
     */
    public void setTouchAble(boolean mTouchAble) {
        this.mTouchAble = mTouchAble;
    }

    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomRatingBar);
        mStarNum = array.getInteger(R.styleable.CustomRatingBar_starNum, 5);
        mStarDistance = array.getDimensionPixelSize(R.styleable.CustomRatingBar_starDistance, DensityUtils.dp2px(context, 0));
        mStarSize = array.getDimensionPixelSize(R.styleable.CustomRatingBar_starSize, DensityUtils.dp2px(context, 20));
        mEmptyStar = array.getDrawable(R.styleable.CustomRatingBar_starEmpty);
        mFillStar = drawableToBitmap(array.getDrawable(R.styleable.CustomRatingBar_starFill));
        mMode = array.getInt(R.styleable.CustomRatingBar_mode, 3);
        mTouchAble = array.getBoolean(R.styleable.CustomRatingBar_touchAble, true);
        mTouchStarMark = array.getInt(R.styleable.CustomRatingBar_ratingProgress, 0);
        array.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(new BitmapShader(mFillStar, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = getPaddingLeft() + mStarNum * mStarSize
                    + (mStarNum - 1) * mStarDistance + getPaddingRight();
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = getPaddingTop() + mStarSize + getPaddingBottom();
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mEmptyStar == null) {
            return;
        }
        for (int i = 0; i < mStarNum; i++) {
            mEmptyStar.setBounds(i * (mStarSize + mStarDistance), 0
                    , mStarSize + i * (mStarSize + mStarDistance), mStarSize);
            mEmptyStar.draw(canvas);
        }

        if (mTouchStarMark < 1) {
            canvas.drawRect(0, 0, mStarSize * mTouchStarMark, mStarSize, mPaint);
        } else {
            canvas.drawRect(0, 0, mStarSize, mStarSize, mPaint);

            for (int i = 1; i <= mTouchStarMark - 1; i++) {
                canvas.translate(mStarDistance + mStarSize, 0);
                canvas.drawRect(0, 0, mStarSize, mStarSize, mPaint);
            }
            float lastMark = mTouchStarMark - (int) mTouchStarMark;
            canvas.translate((mStarDistance + mStarSize), 0);
            canvas.drawRect(0, 0, mStarSize * lastMark, mStarSize, mPaint);
        }
    }

    /**
     * drawable转bitmap
     *
     * @param drawable
     * @return
     */
    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) return null;
        Bitmap bitmap = Bitmap.createBitmap(mStarSize, mStarSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, mStarSize, mStarSize);
        drawable.draw(canvas);
        return bitmap;
    }
}

