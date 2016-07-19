package com.stay4cold.ninesquareview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Author:  wangchenghao
 * Email:   wangchenghao123@126.com
 * Date:    16/7/18
 * Description:
 */
public class NineSquareView extends ViewGroup {

    private static final String TAG = NineSquareView.class.getSimpleName();

    private Context mContext;

    //默认的宫格之间的间隔(dp)
    private static final int DEFAULT_GAP = 4;

    //宫格的最大数量
    private static final int MAX_COUNT = 9;

    //宫格之间的间隔
    private int mGap;

    //每个宫格的宽度和高度
    private int mSquareWidth, mSquareHeight;

    //行数和列数
    private int mRows, mColums;

    //图片的链接集合
    private ArrayList<SquareViewInfo> mViewInfos = new ArrayList<>();

    private OnItemClickListener mItemClickListener;

    private ViewCreator mCreator;

    public NineSquareView(Context context) {
        super(context);
        this.mContext = context;
        init(null);
    }

    public NineSquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    public NineSquareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NineSquareView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.NineSquareView);
        mGap = (int) typedArray.getDimension(R.styleable.NineSquareView_gap, DEFAULT_GAP);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mViewInfos == null || mViewInfos.size() == 0) {
            setVisibility(GONE);
            return;
        }

        int count = mViewInfos.size();
        int totalWidth = resolveSizeAndState(getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight(), widthMeasureSpec, 0);
        int innerWidth = totalWidth - getPaddingLeft() - getPaddingRight();

        mSquareWidth = (innerWidth - 2 * mGap) / 3;
        mSquareHeight = mSquareWidth;

        if (count == 1) {
            int imgWidth = mViewInfos.get(0).obtainWidth();
            int imgHeight = mViewInfos.get(0).obtainHeight();

            float inWidthSampleSize = (float) imgWidth / (float) (2 * mSquareWidth + mGap);
            float imHeightSampleSize = (float) imgHeight / (float) (2 * mSquareHeight + mGap);

            float inSampleSize = Math.max(inWidthSampleSize, imHeightSampleSize);

            mSquareWidth = (int) ((float) imgWidth / inSampleSize);
            mSquareHeight = (int) ((float) imgHeight / inSampleSize);

            Log.e("ministorm", "sample width = " + mSquareWidth + " height = " + mSquareHeight);
        }

        totalWidth = mColums * mSquareWidth + (mColums - 1) * mGap + getPaddingLeft() + getPaddingRight();

        int totalHeight = mRows * mSquareHeight + (mRows - 1) * mGap + getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(totalWidth, totalHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (mViewInfos == null || mViewInfos.isEmpty()) {
            return;
        }

        int count = mViewInfos.size();

        for (int index = 0; index < count; index++) {
            View view = getChildAt(index);

            if (view == null) {

                view = getViewCreator().createView(mContext);
                addView(view);

                final int position = index;

                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mItemClickListener != null) {
                            mItemClickListener.onItemClick(v, position);
                        }
                    }
                });
            }
            view.setVisibility(VISIBLE);

            left = index % mColums * (mSquareWidth + mGap) + getPaddingLeft();
            top = index / mColums * (mSquareHeight + mGap) + getPaddingTop();
            right = left + mSquareWidth;
            bottom = top + mSquareHeight;

            view.layout(left, top, right, bottom);

            getViewCreator().loadView(mContext, mViewInfos.get(index), view);
        }

        if (count < getChildCount()) {
            for (int i = count; i < getChildCount(); i++) {
                getChildAt(i).setVisibility(GONE);
            }
        }
    }

    public void setViewInfos(ArrayList<SquareViewInfo> infos) {
        mViewInfos = infos;

        if (mViewInfos == null || mViewInfos.isEmpty()) {
            setVisibility(GONE);
            return;
        }

        if (mViewInfos.size() > MAX_COUNT) {
            throw new IllegalArgumentException(TAG + " image's count can't over " + MAX_COUNT + " and current is " + mViewInfos
                    .size());
        }

        setVisibility(VISIBLE);

        generateRowAndColum(infos.size());

        requestLayout();
    }

    /**
     * 根据count计算row和colum
     * @param count
     */
    private void generateRowAndColum(int count) {
        mRows = (count - 1) / 3 + 1;
        mColums = (count - 1) % 3 + 1;

        if (count == 4) {
            mColums = 2;
        } else if (count > 4) {
            mColums = 3;
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    /**
     * 设置自定义的creator
     *
     * @param creator
     */
    public void setViewCreator(ViewCreator creator) {
        mCreator = creator;
    }

    private ViewCreator getViewCreator() {
        if (mCreator == null) {
            mCreator = new DefaultViewCreator();
        }

        return mCreator;
    }

    /**
     * 宫格图片点击事件
     */
    public interface OnItemClickListener {

        /**
         * @param view  当前点击的view
         * @param index view所在的index
         */
        void onItemClick(View view, int index);
    }

    /**
     * 可以定制生成view以及自定义load view的方法
     *
     * @param <T> 生成的view类型
     */
    public interface ViewCreator<T extends View> {
        T createView(Context context);

        void loadView(Context context, SquareViewInfo squareInfo, T view);
    }
}
