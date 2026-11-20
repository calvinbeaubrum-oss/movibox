package com.github.mmin18.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.github.mmin18.realtimeblurview.R$styleable;
import zf.b;
import zf.c;
import zf.d;
import zf.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class RealtimeBlurView extends View {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f32482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f32483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static StopException f32484s = new StopException(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f32485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f32487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f32488d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f32489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f32490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f32491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Canvas f32492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f32493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f32494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f32495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f32496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f32497n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f32498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f32499p;

    /* JADX INFO: compiled from: source.java */
    public static class StopException extends RuntimeException {
        private StopException() {
        }

        public /* synthetic */ StopException(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int[] iArr = new int[2];
            Bitmap bitmap = RealtimeBlurView.this.f32491h;
            View view = RealtimeBlurView.this.f32497n;
            if (view != null && RealtimeBlurView.this.isShown() && RealtimeBlurView.this.l()) {
                boolean z11 = RealtimeBlurView.this.f32491h != bitmap;
                view.getLocationOnScreen(iArr);
                int i11 = -iArr[0];
                int i12 = -iArr[1];
                RealtimeBlurView.this.getLocationOnScreen(iArr);
                int i13 = i11 + iArr[0];
                int i14 = i12 + iArr[1];
                RealtimeBlurView.this.f32490g.eraseColor(RealtimeBlurView.this.f32486b & 16777215);
                int iSave = RealtimeBlurView.this.f32492i.save();
                RealtimeBlurView.this.f32493j = true;
                RealtimeBlurView.g();
                try {
                    RealtimeBlurView.this.f32492i.scale((RealtimeBlurView.this.f32490g.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.f32490g.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                    RealtimeBlurView.this.f32492i.translate(-i13, -i14);
                    if (view.getBackground() != null) {
                        view.getBackground().draw(RealtimeBlurView.this.f32492i);
                    }
                    view.draw(RealtimeBlurView.this.f32492i);
                } catch (StopException unused) {
                } finally {
                    RealtimeBlurView.this.f32493j = false;
                    RealtimeBlurView.h();
                    RealtimeBlurView.this.f32492i.restoreToCount(iSave);
                }
                RealtimeBlurView realtimeBlurView = RealtimeBlurView.this;
                realtimeBlurView.j(realtimeBlurView.f32490g, RealtimeBlurView.this.f32491h);
                if (z11 || RealtimeBlurView.this.f32498o) {
                    RealtimeBlurView.this.invalidate();
                }
            }
            return true;
        }
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32495l = new Rect();
        this.f32496m = new Rect();
        this.f32499p = new a();
        this.f32488d = getBlurImpl();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RealtimeBlurView);
        this.f32487c = typedArrayObtainStyledAttributes.getDimension(R$styleable.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.f32485a = typedArrayObtainStyledAttributes.getFloat(R$styleable.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.f32486b = typedArrayObtainStyledAttributes.getColor(R$styleable.RealtimeBlurView_realtimeOverlayColor, -1426063361);
        typedArrayObtainStyledAttributes.recycle();
        this.f32494k = new Paint();
    }

    public static /* synthetic */ int g() {
        int i11 = f32482q;
        f32482q = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int h() {
        int i11 = f32482q;
        f32482q = i11 - 1;
        return i11;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f32493j) {
            throw f32484s;
        }
        if (f32482q > 0) {
            return;
        }
        super.draw(canvas);
    }

    public View getActivityDecorView() {
        Context context = getContext();
        for (int i11 = 0; i11 < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper); i11++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    public c getBlurImpl() {
        if (f32483r == 0) {
            try {
                zf.a aVar = new zf.a();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                aVar.b(getContext(), bitmapCreateBitmap, 4.0f);
                aVar.release();
                bitmapCreateBitmap.recycle();
                f32483r = 3;
            } catch (Throwable unused) {
            }
        }
        if (f32483r == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                b bVar = new b();
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                bVar.b(getContext(), bitmapCreateBitmap2, 4.0f);
                bVar.release();
                bitmapCreateBitmap2.recycle();
                f32483r = 1;
            } catch (Throwable unused2) {
            }
        }
        if (f32483r == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                e eVar = new e();
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                eVar.b(getContext(), bitmapCreateBitmap3, 4.0f);
                eVar.release();
                bitmapCreateBitmap3.recycle();
                f32483r = 2;
            } catch (Throwable unused3) {
            }
        }
        if (f32483r == 0) {
            f32483r = -1;
        }
        int i11 = f32483r;
        if (i11 == 1) {
            return new b();
        }
        if (i11 != 2) {
            return i11 != 3 ? new d() : new zf.a();
        }
        return new e();
    }

    public void j(Bitmap bitmap, Bitmap bitmap2) {
        this.f32488d.a(bitmap, bitmap2);
    }

    public void k(Canvas canvas, Bitmap bitmap, int i11) {
        if (bitmap != null) {
            this.f32495l.right = bitmap.getWidth();
            this.f32495l.bottom = bitmap.getHeight();
            this.f32496m.right = getWidth();
            this.f32496m.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.f32495l, this.f32496m, (Paint) null);
        }
        this.f32494k.setColor(i11);
        canvas.drawRect(this.f32496m, this.f32494k);
    }

    public boolean l() {
        Bitmap bitmap;
        float f11 = this.f32487c;
        if (f11 == 0.0f) {
            m();
            return false;
        }
        float f12 = this.f32485a;
        float f13 = f11 / f12;
        if (f13 > 25.0f) {
            f12 = (f12 * f13) / 25.0f;
            f13 = 25.0f;
        }
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(1, (int) (width / f12));
        int iMax2 = Math.max(1, (int) (height / f12));
        boolean z11 = this.f32489f;
        if (this.f32492i != null && (bitmap = this.f32491h) != null && bitmap.getWidth() == iMax && this.f32491h.getHeight() == iMax2) {
            if (z11) {
            }
            return true;
        }
        n();
        try {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, config);
            this.f32490g = bitmapCreateBitmap;
            if (bitmapCreateBitmap == null) {
                m();
                return false;
            }
            this.f32492i = new Canvas(this.f32490g);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMax, iMax2, config);
            this.f32491h = bitmapCreateBitmap2;
            if (bitmapCreateBitmap2 == null) {
                m();
                return false;
            }
        } catch (OutOfMemoryError unused) {
            m();
            return false;
        } catch (Throwable unused2) {
            m();
            return false;
        }
        if (!this.f32488d.b(getContext(), this.f32490g, f13)) {
            return false;
        }
        this.f32489f = false;
        return true;
    }

    public void m() {
        n();
        this.f32488d.release();
    }

    public final void n() {
        Bitmap bitmap = this.f32490g;
        if (bitmap != null) {
            bitmap.recycle();
            this.f32490g = null;
        }
        Bitmap bitmap2 = this.f32491h;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f32491h = null;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.f32497n = activityDecorView;
        if (activityDecorView == null) {
            this.f32498o = false;
            return;
        }
        activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.f32499p);
        boolean z11 = this.f32497n.getRootView() != getRootView();
        this.f32498o = z11;
        if (z11) {
            this.f32497n.postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        View view = this.f32497n;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.f32499p);
        }
        m();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k(canvas, this.f32491h, this.f32486b);
    }

    public void setBlurRadius(float f11) {
        if (this.f32487c != f11) {
            this.f32487c = f11;
            this.f32489f = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f11) {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.f32485a != f11) {
            this.f32485a = f11;
            this.f32489f = true;
            n();
            invalidate();
        }
    }

    public void setOverlayColor(int i11) {
        if (this.f32486b != i11) {
            this.f32486b = i11;
            invalidate();
        }
    }
}
