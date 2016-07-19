# NineSquareView
实现类似朋友圈和新浪微博的九宫格视图
![screent1](https://github.com/stay4cold/NineSquareView/blob/master/screen.gif?raw=true)

## 介绍

1. 单张图片的时候可以实现根据图片的原始尺寸来进行缩放，保持宽高比，并且整体大小限制在左上角四个宫格的区域内
2. 根据数据源来自动确定宫格数量以及排布
3. 可以为每个宫格的图片设置OnItenClickListener

## 使用

    <com.stay4cold.ninesquareview.NineSquareView
        android:id="@+id/nine_view"
        app:gap="6dp"
        android:paddingLeft="10dp"
        android:paddingRight="20dp"
        android:paddingTop="10dp"
        android:paddingBottom="20dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

1. app:gap="6dp"  设置gap值(即宫格之间的间距)
2. setViewCreator 设置自定义的view生成器
3. setViewInfos   设置数据源(注意接收格式)

## Download

Add the dependency

    dependencies {
            compile 'com.github.stay4cold:ninesquareview:1.0.1'
    }

## About Me

天津Android开发者

Email: <wangchenghao123@126.com>
