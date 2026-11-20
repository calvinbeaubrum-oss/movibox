package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends ShapeDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f47588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f47589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f47590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f47591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f47592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f47593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f47594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f47595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f47596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Matrix f47597j;

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0524a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RectShape f47598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f47599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap f47600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f47601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f47602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f47605h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f47606i;

        private C0524a() {
            this.f47603f = 100;
            this.f47604g = 10;
            this.f47598a = new RectShape();
        }

        public final b a(float f11) {
            this.f47605h = f11;
            return this;
        }

        public final b a(int i11) {
            this.f47602e = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b a(Bitmap bitmap) {
            this.f47599b = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b a(boolean z11) {
            this.f47601d = z11;
            return this;
        }

        public final a a() {
            return new a(this);
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b b(float f11) {
            this.f47606i = f11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b b(Bitmap bitmap) {
            this.f47600c = bitmap;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        b a(Bitmap bitmap);

        b a(boolean z11);

        b b(float f11);

        b b(Bitmap bitmap);
    }

    private a(C0524a c0524a) {
        super(c0524a.f47598a);
        this.f47595h = false;
        this.f47593f = c0524a.f47599b;
        this.f47594g = c0524a.f47600c;
        this.f47595h = c0524a.f47601d;
        this.f47588a = c0524a.f47602e;
        this.f47591d = c0524a.f47603f;
        this.f47592e = c0524a.f47604g;
        this.f47589b = c0524a.f47605h;
        this.f47590c = c0524a.f47606i;
        Paint paint = new Paint();
        this.f47596i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f47596i.setAntiAlias(true);
        this.f47597j = new Matrix();
    }

    public static C0524a a() {
        return new C0524a();
    }

    private void a(Canvas canvas, Path path) {
        this.f47596i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.f47596i);
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas == null || path == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            float fMax = Math.max(this.f47589b / bitmap.getWidth(), this.f47590c / bitmap.getHeight());
            if (this.f47597j == null) {
                this.f47597j = new Matrix();
            }
            this.f47597j.reset();
            this.f47597j.preScale(fMax, fMax);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(this.f47597j);
        this.f47596i.setShader(bitmapShader);
        canvas.drawPath(path, this.f47596i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f47588a == 1) {
            float f11 = this.f47590c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (this.f47591d + f11) - this.f47592e);
            path.lineTo(this.f47589b, (f11 - this.f47591d) - this.f47592e);
            path.lineTo(this.f47589b, 0.0f);
            if (this.f47595h) {
                try {
                    a(canvas, path);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f47593f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f47593f);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, this.f47591d + f11 + this.f47592e);
            path2.lineTo(0.0f, this.f47590c);
            path2.lineTo(this.f47589b, this.f47590c);
            path2.lineTo(this.f47589b, (f11 - this.f47591d) + this.f47592e);
            if (this.f47595h) {
                try {
                    a(canvas, path2);
                    return;
                } catch (Exception e13) {
                    e13.printStackTrace();
                    return;
                }
            }
            Bitmap bitmap2 = this.f47594g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            try {
                a(canvas, path2, this.f47594g);
                return;
            } catch (Exception e14) {
                e14.printStackTrace();
                return;
            }
        }
        float f12 = this.f47589b / 2.0f;
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(0.0f, this.f47590c);
        path3.lineTo((f12 - this.f47591d) - this.f47592e, this.f47590c);
        path3.lineTo((this.f47591d + f12) - this.f47592e, 0.0f);
        if (this.f47595h) {
            try {
                a(canvas, path3);
            } catch (Exception e15) {
                e15.printStackTrace();
            }
        } else {
            Bitmap bitmap3 = this.f47593f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f47593f);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        Path path4 = new Path();
        path4.moveTo(this.f47591d + f12 + this.f47592e, 0.0f);
        path4.lineTo(this.f47589b, 0.0f);
        path4.lineTo(this.f47589b, this.f47590c);
        path4.lineTo((f12 - this.f47591d) + this.f47592e, this.f47590c);
        if (this.f47595h) {
            try {
                a(canvas, path4);
                return;
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
        Bitmap bitmap4 = this.f47594g;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        try {
            a(canvas, path4, this.f47594g);
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }
}
