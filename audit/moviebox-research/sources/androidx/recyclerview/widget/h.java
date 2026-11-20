package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends RecyclerView.w {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SuppressLint({"UnknownNullness"})
    public PointF f12671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f12672l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12674n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f12669i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f12670j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12673m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12675o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12676p = 0;

    @SuppressLint({"UnknownNullness"})
    public h(Context context) {
        this.f12672l = context.getResources().getDisplayMetrics();
    }

    public final float A() {
        if (!this.f12673m) {
            this.f12674n = v(this.f12672l);
            this.f12673m = true;
        }
        return this.f12674n;
    }

    public int B() {
        PointF pointF = this.f12671k;
        if (pointF != null) {
            float f11 = pointF.y;
            if (f11 != 0.0f) {
                return f11 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public void C(RecyclerView.w.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.f12671k = pointFA;
        this.f12675o = (int) (pointFA.x * 10000.0f);
        this.f12676p = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.f12675o * 1.2f), (int) (this.f12676p * 1.2f), (int) (x(10000) * 1.2f), this.f12669i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    @SuppressLint({"UnknownNullness"})
    public void l(int i11, int i12, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f12675o = y(this.f12675o, i11);
        int iY = y(this.f12676p, i12);
        this.f12676p = iY;
        if (this.f12675o == 0 && iY == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void n() {
        this.f12676p = 0;
        this.f12675o = 0;
        this.f12671k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    @SuppressLint({"UnknownNullness"})
    public void o(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            aVar.d(-iT, -iU, iW, this.f12670j);
        }
    }

    public int s(int i11, int i12, int i13, int i14, int i15) {
        if (i15 == -1) {
            return i13 - i11;
        }
        if (i15 != 0) {
            if (i15 == 1) {
                return i14 - i12;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i16 = i13 - i11;
        if (i16 > 0) {
            return i16;
        }
        int i17 = i14 - i12;
        if (i17 < 0) {
            return i17;
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public int t(View view, int i11) {
        RecyclerView.m mVarE = e();
        if (mVarE == null || !mVarE.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return s(mVarE.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, mVarE.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, mVarE.getPaddingLeft(), mVarE.getWidth() - mVarE.getPaddingRight(), i11);
    }

    @SuppressLint({"UnknownNullness"})
    public int u(View view, int i11) {
        RecyclerView.m mVarE = e();
        if (mVarE == null || !mVarE.canScrollVertically()) {
            return 0;
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return s(mVarE.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, mVarE.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin, mVarE.getPaddingTop(), mVarE.getHeight() - mVarE.getPaddingBottom(), i11);
    }

    @SuppressLint({"UnknownNullness"})
    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int w(int i11) {
        return (int) Math.ceil(((double) x(i11)) / 0.3356d);
    }

    public int x(int i11) {
        return (int) Math.ceil(Math.abs(i11) * A());
    }

    public final int y(int i11, int i12) {
        int i13 = i11 - i12;
        if (i11 * i13 <= 0) {
            return 0;
        }
        return i13;
    }

    public int z() {
        PointF pointF = this.f12671k;
        if (pointF != null) {
            float f11 = pointF.x;
            if (f11 != 0.0f) {
                return f11 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
