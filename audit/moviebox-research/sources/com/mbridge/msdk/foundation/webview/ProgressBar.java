package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ProgressBar extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f45134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f45135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f45136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f45137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f45138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f45139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f45140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f45141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f45142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f45143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f45144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f45145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f45146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f45147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f45148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c.a f45149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f45150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Rect f45151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Drawable f45152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f45153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f45154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f45155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f45156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f45157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f45158y;

    public ProgressBar(Context context) {
        super(context);
        this.f45134a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.f45140g = 25L;
        this.f45141h = new Handler(Looper.getMainLooper());
        this.f45144k = false;
        this.f45147n = 0.95f;
        this.f45148o = false;
        this.f45151r = new Rect();
        setWillNotDraw(false);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45134a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.f45140g = 25L;
        this.f45141h = new Handler(Looper.getMainLooper());
        this.f45144k = false;
        this.f45147n = 0.95f;
        this.f45148o = false;
        this.f45151r = new Rect();
        setWillNotDraw(false);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2;
        if (!this.f45144k) {
            this.f45144k = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = this.f45148o ? 0L : jCurrentTimeMillis - this.f45146m;
        float fAbs = Math.abs(j11 / 1000.0f);
        this.f45137d = fAbs;
        this.f45146m = jCurrentTimeMillis;
        long j12 = this.f45158y + j11;
        this.f45158y = j12;
        boolean z11 = this.f45154u;
        float f11 = 0.4f;
        if (z11) {
            if (this.f45145l) {
                f11 = 1.0f;
            }
        } else if (j12 >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            f11 = 0.05f;
        } else if (this.f45156w != 1) {
            if (this.f45155v == 1) {
                if (!this.f45145l) {
                }
            } else if (!this.f45145l) {
                f11 = 0.05f;
            }
            f11 = 0.2f;
        } else if (this.f45145l) {
            f11 = 1.0f;
        }
        this.f45136c = f11;
        float f12 = this.f45135b + (f11 * fAbs);
        this.f45135b = f12;
        if (!z11) {
            float f13 = this.f45147n;
            if (f12 > f13) {
                this.f45135b = f13;
            }
        }
        this.f45151r.right = (int) (this.f45135b * this.f45153t);
        this.f45141h.removeCallbacksAndMessages(null);
        this.f45141h.postDelayed(this.f45134a, this.f45140g);
        super.draw(canvas);
        float f14 = this.f45137d;
        if (this.f45154u) {
            float f15 = this.f45139f;
            float f16 = this.f45153t;
            int i11 = (int) ((1.0f - (f15 / (f16 * 0.5f))) * 255.0f);
            if (i11 < 0) {
                i11 = 0;
            }
            if (f15 > f16 * 0.5f) {
                setVisible(false);
            }
            Drawable drawable3 = this.f45152s;
            if (drawable3 != null) {
                drawable3.setAlpha(i11);
            }
            Drawable drawable4 = this.f45138e;
            if (drawable4 != null) {
                drawable4.setAlpha(i11);
            }
            Drawable drawable5 = this.f45150q;
            if (drawable5 != null) {
                drawable5.setAlpha(i11);
            }
            canvas.save();
            canvas.translate(this.f45139f, 0.0f);
        }
        if (this.f45152s != null && this.f45150q != null) {
            int iWidth = (int) (this.f45151r.width() - (this.f45150q.getIntrinsicWidth() * 0.05f));
            Drawable drawable6 = this.f45152s;
            drawable6.setBounds(0, 0, iWidth, drawable6.getIntrinsicHeight());
            this.f45152s.draw(canvas);
        }
        if (this.f45154u && (drawable2 = this.f45138e) != null && this.f45150q != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            Drawable drawable7 = this.f45138e;
            drawable7.setBounds(0, 0, intrinsicWidth, drawable7.getIntrinsicHeight());
            canvas.save();
            canvas.translate(-intrinsicWidth, 0.0f);
            this.f45138e.draw(canvas);
            canvas.restore();
        }
        if (this.f45150q != null) {
            canvas.save();
            canvas.translate(this.f45151r.width() - getWidth(), 0.0f);
            this.f45150q.draw(canvas);
            canvas.restore();
        }
        if (!this.f45154u && Math.abs(this.f45135b - this.f45147n) < 1.0E-5f && (drawable = this.f45142i) != null) {
            int i12 = (int) (this.f45143j + (f14 * 0.2f * this.f45153t));
            this.f45143j = i12;
            if (i12 + drawable.getIntrinsicWidth() >= this.f45151r.width()) {
                this.f45143j = -this.f45142i.getIntrinsicWidth();
            }
            canvas.save();
            canvas.translate(this.f45143j, 0.0f);
            this.f45142i.draw(canvas);
            canvas.restore();
        }
        if (this.f45154u) {
            canvas.restore();
        }
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z11) {
        return null;
    }

    public float getProgress() {
        return this.f45135b;
    }

    public void initResource(boolean z11) {
        if (z11 || (this.f45142i == null && this.f45150q == null && this.f45152s == null && this.f45138e == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f45142i = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f45142i.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f45150q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f45150q.getIntrinsicHeight());
            }
            this.f45152s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f45138e = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f45153t = getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.f45144k) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        Drawable drawable = this.f45142i;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (((double) drawable.getIntrinsicWidth()) * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f45150q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z11) {
        this.f45148o = z11;
        if (z11) {
            return;
        }
        this.f45146m = System.currentTimeMillis();
    }

    public void setProgress(float f11, boolean z11) {
        if (!z11 || f11 < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    public void setProgressBarListener(c.a aVar) {
        this.f45149p = aVar;
    }

    public void setProgressState(int i11) {
        if (i11 == 5) {
            this.f45155v = 1;
            this.f45156w = 0;
            this.f45157x = 0;
            this.f45158y = 0L;
            return;
        }
        if (i11 == 6) {
            this.f45156w = 1;
            if (this.f45157x == 1) {
                startEndAnimation();
            }
            this.f45158y = 0L;
            return;
        }
        if (i11 == 7) {
            startEndAnimation();
        } else {
            if (i11 != 8) {
                return;
            }
            this.f45157x = 1;
            if (this.f45156w == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 == 0) {
            c.a aVar = this.f45149p;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        c.a aVar2 = this.f45149p;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    public void setVisible(boolean z11) {
        if (!z11) {
            setVisibility(4);
            return;
        }
        this.f45145l = true;
        this.f45146m = System.currentTimeMillis();
        this.f45137d = 0.0f;
        this.f45158y = 0L;
        this.f45154u = false;
        this.f45139f = 0.0f;
        this.f45135b = 0.0f;
        this.f45153t = getMeasuredWidth();
        this.f45148o = false;
        this.f45155v = 0;
        this.f45156w = 0;
        this.f45157x = 0;
        Drawable drawable = this.f45142i;
        if (drawable != null) {
            this.f45143j = -drawable.getIntrinsicWidth();
        } else {
            this.f45143j = 0;
        }
        Drawable drawable2 = this.f45152s;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        Drawable drawable3 = this.f45138e;
        if (drawable3 != null) {
            drawable3.setAlpha(255);
        }
        Drawable drawable4 = this.f45150q;
        if (drawable4 != null) {
            drawable4.setAlpha(255);
        }
        setVisibility(0);
        invalidate();
    }

    public void startEndAnimation() {
        if (this.f45154u) {
            return;
        }
        this.f45154u = true;
        this.f45139f = 0.0f;
    }
}
