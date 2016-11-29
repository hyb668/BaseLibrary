package com.gosuncn.core.common.util;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Glide圆矩形TransForm
 */
public class RoundRectTransForm extends BitmapTransformation {

    private Context context;

    public RoundRectTransForm(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return rectCrop(pool,toTransform);
    }

    private Bitmap rectCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        int size = Math.min(source.getWidth(), source.getHeight());

        Bitmap squared = Bitmap.createBitmap(source, 0, 0, size, size);

        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        //圆矩形
        float radius = TypedValue.applyDimension(1, 4, context.getResources().getDisplayMetrics());
        canvas.drawRoundRect(new RectF(0,0,size,size), radius, radius, paint);
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }



}
