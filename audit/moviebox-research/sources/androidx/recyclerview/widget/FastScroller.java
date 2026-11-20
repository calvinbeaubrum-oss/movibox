package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class FastScroller extends RecyclerView.l implements RecyclerView.q {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.r C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f12463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f12464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f12467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f12468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12475o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12476p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f12479s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f12486z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12477q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12478r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12480t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12481u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12482v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12483w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f12484x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f12485y = new int[2];

    /* JADX INFO: compiled from: source.java */
    public class a extends RecyclerView.r {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            FastScroller.this.v(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12488a = false;

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12488a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f12488a) {
                this.f12488a = false;
                return;
            }
            if (((Float) FastScroller.this.f12486z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.A = 0;
                fastScroller.s(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.A = 2;
                fastScroller2.p();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f12463c.setAlpha(iFloatValue);
            FastScroller.this.f12464d.setAlpha(iFloatValue);
            FastScroller.this.p();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i11, int i12, int i13) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f12486z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public void run() {
                FastScroller.this.k(500);
            }
        };
        this.C = new a();
        this.f12463c = stateListDrawable;
        this.f12464d = drawable;
        this.f12467g = stateListDrawable2;
        this.f12468h = drawable2;
        this.f12465e = Math.max(i11, stateListDrawable.getIntrinsicWidth());
        this.f12466f = Math.max(i11, drawable.getIntrinsicWidth());
        this.f12469i = Math.max(i11, stateListDrawable2.getIntrinsicWidth());
        this.f12470j = Math.max(i11, drawable2.getIntrinsicWidth());
        this.f12461a = i12;
        this.f12462b = i13;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.addUpdateListener(new c());
        d(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.f12482v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zO = o(motionEvent.getX(), motionEvent.getY());
            boolean zN = n(motionEvent.getX(), motionEvent.getY());
            if (zO || zN) {
                if (zN) {
                    this.f12483w = 1;
                    this.f12476p = (int) motionEvent.getX();
                } else if (zO) {
                    this.f12483w = 2;
                    this.f12473m = (int) motionEvent.getY();
                }
                s(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f12482v == 2) {
            this.f12473m = 0.0f;
            this.f12476p = 0.0f;
            s(1);
            this.f12483w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f12482v == 2) {
            u();
            if (this.f12483w == 1) {
                l(motionEvent.getX());
            }
            if (this.f12483w == 2) {
                w(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean b(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i11 = this.f12482v;
        if (i11 == 1) {
            boolean zO = o(motionEvent.getX(), motionEvent.getY());
            boolean zN = n(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zO && !zN) {
                return false;
            }
            if (zN) {
                this.f12483w = 1;
                this.f12476p = (int) motionEvent.getX();
            } else if (zO) {
                this.f12483w = 2;
                this.f12473m = (int) motionEvent.getY();
            }
            s(2);
        } else if (i11 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z11) {
    }

    public void d(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f12479s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f12479s = recyclerView;
        if (recyclerView != null) {
            t();
        }
    }

    public final void e() {
        this.f12479s.removeCallbacks(this.B);
    }

    public final void f() {
        this.f12479s.removeItemDecoration(this);
        this.f12479s.removeOnItemTouchListener(this);
        this.f12479s.removeOnScrollListener(this.C);
        e();
    }

    public final void g(Canvas canvas) {
        int i11 = this.f12478r;
        int i12 = this.f12469i;
        int i13 = i11 - i12;
        int i14 = this.f12475o;
        int i15 = this.f12474n;
        int i16 = i14 - (i15 / 2);
        this.f12467g.setBounds(0, 0, i15, i12);
        this.f12468h.setBounds(0, 0, this.f12477q, this.f12470j);
        canvas.translate(0.0f, i13);
        this.f12468h.draw(canvas);
        canvas.translate(i16, 0.0f);
        this.f12467g.draw(canvas);
        canvas.translate(-i16, -i13);
    }

    public final void h(Canvas canvas) {
        int i11 = this.f12477q;
        int i12 = this.f12465e;
        int i13 = i11 - i12;
        int i14 = this.f12472l;
        int i15 = this.f12471k;
        int i16 = i14 - (i15 / 2);
        this.f12463c.setBounds(0, 0, i12, i15);
        this.f12464d.setBounds(0, 0, this.f12466f, this.f12478r);
        if (!m()) {
            canvas.translate(i13, 0.0f);
            this.f12464d.draw(canvas);
            canvas.translate(0.0f, i16);
            this.f12463c.draw(canvas);
            canvas.translate(-i13, -i16);
            return;
        }
        this.f12464d.draw(canvas);
        canvas.translate(this.f12465e, i16);
        canvas.scale(-1.0f, 1.0f);
        this.f12463c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f12465e, -i16);
    }

    public final int[] i() {
        int[] iArr = this.f12485y;
        int i11 = this.f12462b;
        iArr[0] = i11;
        iArr[1] = this.f12477q - i11;
        return iArr;
    }

    public final int[] j() {
        int[] iArr = this.f12484x;
        int i11 = this.f12462b;
        iArr[0] = i11;
        iArr[1] = this.f12478r - i11;
        return iArr;
    }

    public void k(int i11) {
        int i12 = this.A;
        if (i12 == 1) {
            this.f12486z.cancel();
        } else if (i12 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f12486z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f12486z.setDuration(i11);
        this.f12486z.start();
    }

    public final void l(float f11) {
        int[] iArrI = i();
        float fMax = Math.max(iArrI[0], Math.min(iArrI[1], f11));
        if (Math.abs(this.f12475o - fMax) < 2.0f) {
            return;
        }
        int iR = r(this.f12476p, fMax, iArrI, this.f12479s.computeHorizontalScrollRange(), this.f12479s.computeHorizontalScrollOffset(), this.f12477q);
        if (iR != 0) {
            this.f12479s.scrollBy(iR, 0);
        }
        this.f12476p = fMax;
    }

    public final boolean m() {
        return ViewCompat.getLayoutDirection(this.f12479s) == 1;
    }

    public boolean n(float f11, float f12) {
        if (f12 >= this.f12478r - this.f12469i) {
            int i11 = this.f12475o;
            int i12 = this.f12474n;
            if (f11 >= i11 - (i12 / 2) && f11 <= i11 + (i12 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean o(float f11, float f12) {
        if (!m() ? f11 >= this.f12477q - this.f12465e : f11 <= this.f12465e) {
            int i11 = this.f12472l;
            int i12 = this.f12471k;
            if (f12 >= i11 - (i12 / 2) && f12 <= i11 + (i12 / 2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if (this.f12477q != this.f12479s.getWidth() || this.f12478r != this.f12479s.getHeight()) {
            this.f12477q = this.f12479s.getWidth();
            this.f12478r = this.f12479s.getHeight();
            s(0);
        } else if (this.A != 0) {
            if (this.f12480t) {
                h(canvas);
            }
            if (this.f12481u) {
                g(canvas);
            }
        }
    }

    public void p() {
        this.f12479s.invalidate();
    }

    public final void q(int i11) {
        e();
        this.f12479s.postDelayed(this.B, i11);
    }

    public final int r(float f11, float f12, int[] iArr, int i11, int i12, int i13) {
        int i14 = iArr[1] - iArr[0];
        if (i14 == 0) {
            return 0;
        }
        int i15 = i11 - i13;
        int i16 = (int) (((f12 - f11) / i14) * i15);
        int i17 = i12 + i16;
        if (i17 >= i15 || i17 < 0) {
            return 0;
        }
        return i16;
    }

    public void s(int i11) {
        if (i11 == 2 && this.f12482v != 2) {
            this.f12463c.setState(D);
            e();
        }
        if (i11 == 0) {
            p();
        } else {
            u();
        }
        if (this.f12482v == 2 && i11 != 2) {
            this.f12463c.setState(E);
            q(1200);
        } else if (i11 == 1) {
            q(1500);
        }
        this.f12482v = i11;
    }

    public final void t() {
        this.f12479s.addItemDecoration(this);
        this.f12479s.addOnItemTouchListener(this);
        this.f12479s.addOnScrollListener(this.C);
    }

    public void u() {
        int i11 = this.A;
        if (i11 != 0) {
            if (i11 != 3) {
                return;
            } else {
                this.f12486z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f12486z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f12486z.setDuration(500L);
        this.f12486z.setStartDelay(0L);
        this.f12486z.start();
    }

    public void v(int i11, int i12) {
        int iComputeVerticalScrollRange = this.f12479s.computeVerticalScrollRange();
        int i13 = this.f12478r;
        this.f12480t = iComputeVerticalScrollRange - i13 > 0 && i13 >= this.f12461a;
        int iComputeHorizontalScrollRange = this.f12479s.computeHorizontalScrollRange();
        int i14 = this.f12477q;
        boolean z11 = iComputeHorizontalScrollRange - i14 > 0 && i14 >= this.f12461a;
        this.f12481u = z11;
        boolean z12 = this.f12480t;
        if (!z12 && !z11) {
            if (this.f12482v != 0) {
                s(0);
                return;
            }
            return;
        }
        if (z12) {
            float f11 = i13;
            this.f12472l = (int) ((f11 * (i12 + (f11 / 2.0f))) / iComputeVerticalScrollRange);
            this.f12471k = Math.min(i13, (i13 * i13) / iComputeVerticalScrollRange);
        }
        if (this.f12481u) {
            float f12 = i14;
            this.f12475o = (int) ((f12 * (i11 + (f12 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f12474n = Math.min(i14, (i14 * i14) / iComputeHorizontalScrollRange);
        }
        int i15 = this.f12482v;
        if (i15 == 0 || i15 == 1) {
            s(1);
        }
    }

    public final void w(float f11) {
        int[] iArrJ = j();
        float fMax = Math.max(iArrJ[0], Math.min(iArrJ[1], f11));
        if (Math.abs(this.f12472l - fMax) < 2.0f) {
            return;
        }
        int iR = r(this.f12473m, fMax, iArrJ, this.f12479s.computeVerticalScrollRange(), this.f12479s.computeVerticalScrollOffset(), this.f12478r);
        if (iR != 0) {
            this.f12479s.scrollBy(0, iR);
        }
        this.f12473m = fMax;
    }
}
