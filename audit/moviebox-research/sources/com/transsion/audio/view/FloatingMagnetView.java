package com.transsion.audio.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class FloatingMagnetView extends FrameLayout {
    public static final int MARGIN_EDGE = 13;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MoveAnimator f50882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50885d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f50886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f50887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f50888h;

    /* JADX INFO: compiled from: source.java */
    public class MoveAnimator implements Runnable {
        private float destinationX;
        private float destinationY;
        private final Handler handler = new Handler(Looper.getMainLooper());
        private long startingTime;

        public MoveAnimator() {
        }

        private void stop() {
            this.handler.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingMagnetView.this.getRootView() == null || FloatingMagnetView.this.getRootView().getParent() == null) {
                return;
            }
            float fMin = Math.min(1.0f, (System.currentTimeMillis() - this.startingTime) / 400.0f);
            FloatingMagnetView.this.g((this.destinationX - FloatingMagnetView.this.getX()) * fMin, (this.destinationY - FloatingMagnetView.this.getY()) * fMin);
            if (fMin < 1.0f) {
                this.handler.post(this);
            }
        }

        public void start(float f11, float f12) {
            this.destinationX = f11;
            this.destinationY = f12;
            this.startingTime = System.currentTimeMillis();
            this.handler.post(this);
        }
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f50885d = true;
        this.f50887g = 0.0f;
        this.f50888h = 0.0f;
        d();
    }

    public abstract void attach(Context context);

    public final void c() {
        this.f50886f = 0.0f;
    }

    public final void d() {
        this.f50882a = new MoveAnimator();
        setClickable(true);
    }

    public final /* synthetic */ void e(boolean z11) {
        i();
        h(this.f50885d, z11);
    }

    public abstract void expanded();

    public final void f(boolean z11) {
        if (z11) {
            this.f50886f = getY();
        }
    }

    public final void g(float f11, float f12) {
        setX(getX() + f11);
        setY(getY() + f12);
    }

    public final void h(boolean z11, boolean z12) {
        float f11 = z11 ? 13.0f : this.f50883b - 13;
        float y11 = getY();
        if (!z12) {
            float f12 = this.f50886f;
            if (f12 != 0.0f) {
                c();
                y11 = f12;
            }
        }
        this.f50882a.start(f11, Math.min(Math.max(0.0f, y11), this.f50884c - getHeight()));
    }

    public final void i() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            this.f50883b = viewGroup.getWidth() - getWidth();
            this.f50884c = viewGroup.getHeight();
        }
    }

    public abstract boolean isPackUp();

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            final boolean z11 = configuration.orientation == 2;
            f(z11);
            ((ViewGroup) getParent()).post(new Runnable() { // from class: com.transsion.audio.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f50891a.e(z11);
                }
            });
        }
    }

    public abstract void onProgress(int i11);

    public abstract void onSlideTheLeft();

    public abstract void onStateChanged(int i11);

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f50887g = motionEvent.getRawX();
        } else if (action == 2) {
            float rawX = motionEvent.getRawX();
            this.f50888h = rawX;
            float f11 = this.f50887g;
            if (rawX < f11 && Math.abs(rawX - f11) > 50.0f) {
                onSlideTheLeft();
                return true;
            }
        } else if ((action == 1 || action == 3) && Math.abs(motionEvent.getRawX() - this.f50887g) < 10.0f) {
            onViewClick();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public abstract void onViewClick();

    public abstract void packUp();

    public abstract void packUpAnimation();

    public abstract void prepare();

    public abstract void setOnOptionListener(EnFloatingView.f fVar);
}
