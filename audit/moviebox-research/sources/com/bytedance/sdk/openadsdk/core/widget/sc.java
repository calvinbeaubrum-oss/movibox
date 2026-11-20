package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class sc extends com.bytedance.sdk.openadsdk.core.ExN.We {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f28553sc;

    public sc(Context context) {
        super(context);
        this.f28553sc = 0;
        this.pFF = 0;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        return paint;
    }

    private int getRadius() {
        if (this.f28553sc == 0) {
            this.f28553sc = getWidth();
        }
        if (this.pFF == 0) {
            this.pFF = getHeight();
        }
        int i11 = this.f28553sc;
        int i12 = this.pFF;
        if (i11 >= i12) {
            i11 = i12;
        }
        return i11 / 2;
    }

    private boolean pFF() {
        if (getDrawable().getClass() != NinePatchDrawable.class) {
            return (getDrawable() instanceof BitmapDrawable) && ((BitmapDrawable) getDrawable()).getBitmap() == null;
        }
        return true;
    }

    private Bitmap sc(Bitmap bitmap, int i11) {
        Bitmap bitmapCreateBitmap;
        int i12 = i11 * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else {
            bitmapCreateBitmap = height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        }
        if (bitmapCreateBitmap != null) {
            bitmap = bitmapCreateBitmap;
        }
        if (bitmap.getWidth() != i12 || bitmap.getHeight() != i12) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i12, i12, true);
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = getPaint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap2;
    }

    private boolean sc() {
        return getDrawable() == null || getWidth() == 0 || getHeight() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmapCopy;
        Bitmap bitmapSc;
        if (sc()) {
            return;
        }
        measure(0, 0);
        if (pFF()) {
            return;
        }
        try {
            bitmapCopy = ((BitmapDrawable) getDrawable()).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmapCopy = null;
        }
        if (bitmapCopy == null) {
            super.onDraw(canvas);
            return;
        }
        int radius = getRadius();
        try {
            bitmapSc = sc(bitmapCopy, radius);
        } catch (Throwable unused2) {
            bitmapSc = null;
        }
        if (bitmapSc == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmapSc, (this.f28553sc / 2) - radius, (this.pFF / 2) - radius, (Paint) null);
        }
    }
}
