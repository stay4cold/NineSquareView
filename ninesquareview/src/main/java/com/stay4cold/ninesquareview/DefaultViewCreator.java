package com.stay4cold.ninesquareview;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Author:  wangchenghao
 * Email:   wangchenghao123@126.com
 * Date:    16/7/18
 * Description:
 */
public class DefaultViewCreator implements NineSquareView.ViewCreator<ImageView> {

    @Override
    public ImageView createView(Context context) {
        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return view;
    }

    @Override
    public void loadView(Context context, SquareViewInfo squareInfo, ImageView view) {
        Glide.with(context).load(squareInfo.getImageUrl()).into(view);
    }
}
