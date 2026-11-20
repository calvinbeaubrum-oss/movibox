package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import li.e;
import li.f;
import li.g;
import li.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CarouselLayoutManager extends RecyclerView.m implements li.b, RecyclerView.w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36462d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f36463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public f f36464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public com.google.android.material.carousel.c f36465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public com.google.android.material.carousel.b f36466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public Map<Integer, com.google.android.material.carousel.b> f36468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f36469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View.OnLayoutChangeListener f36470m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36471n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36472o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f36473p;

    /* JADX INFO: compiled from: source.java */
    public class a extends h {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.w
        @Nullable
        public PointF a(int i11) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i11);
        }

        @Override // androidx.recyclerview.widget.h
        public int t(View view, int i11) {
            if (CarouselLayoutManager.this.f36465h == null || !CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.h
        public int u(View view, int i11) {
            if (CarouselLayoutManager.this.f36465h == null || CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f36475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f36476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f36477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f36478d;

        public b(View view, float f11, float f12, d dVar) {
            this.f36475a = view;
            this.f36476b = f11;
            this.f36477c = f12;
            this.f36478d = dVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f36479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<com.google.android.material.carousel.b.c> f36480b;

        public c() {
            Paint paint = new Paint();
            this.f36479a = paint;
            this.f36480b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void d(List<com.google.android.material.carousel.b.c> list) {
            this.f36480b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.x xVar) {
            super.onDrawOver(canvas, recyclerView, xVar);
            this.f36479a.setStrokeWidth(recyclerView.getResources().getDimension(R$dimen.m3_carousel_debug_keyline_width));
            for (com.google.android.material.carousel.b.c cVar : this.f36480b) {
                this.f36479a.setColor(c3.b.c(-65281, -16776961, cVar.f36503c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).d()) {
                    canvas.drawLine(cVar.f36502b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).K(), cVar.f36502b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).F(), this.f36479a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).H(), cVar.f36502b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).I(), cVar.f36502b, this.f36479a);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.material.carousel.b.c f36481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.material.carousel.b.c f36482b;

        public d(com.google.android.material.carousel.b.c cVar, com.google.android.material.carousel.b.c cVar2) {
            i.a(cVar.f36501a <= cVar2.f36501a);
            this.f36481a = cVar;
            this.f36482b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new j());
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f36462d = false;
        this.f36463f = new c();
        this.f36467j = 0;
        this.f36470m = new View.OnLayoutChangeListener() { // from class: li.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21) {
                this.f70290a.S(view, i13, i14, i15, i16, i17, i18, i19, i21);
            }
        };
        this.f36472o = -1;
        this.f36473p = 0;
        c0(new j());
        b0(context, attributeSet);
    }

    public CarouselLayoutManager(@NonNull f fVar) {
        this(fVar, 0);
    }

    public CarouselLayoutManager(@NonNull f fVar, int i11) {
        this.f36462d = false;
        this.f36463f = new c();
        this.f36467j = 0;
        this.f36470m = new View.OnLayoutChangeListener() { // from class: li.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21) {
                this.f70290a.S(view, i13, i14, i15, i16, i17, i18, i19, i21);
            }
        };
        this.f36472o = -1;
        this.f36473p = 0;
        c0(fVar);
        setOrientation(i11);
    }

    public static d O(List<com.google.android.material.carousel.b.c> list, float f11, boolean z11) {
        float f12 = Float.MAX_VALUE;
        float f13 = Float.MAX_VALUE;
        float f14 = Float.MAX_VALUE;
        float f15 = -3.4028235E38f;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < list.size(); i15++) {
            com.google.android.material.carousel.b.c cVar = list.get(i15);
            float f16 = z11 ? cVar.f36502b : cVar.f36501a;
            float fAbs = Math.abs(f16 - f11);
            if (f16 <= f11 && fAbs <= f12) {
                i11 = i15;
                f12 = fAbs;
            }
            if (f16 > f11 && fAbs <= f13) {
                i13 = i15;
                f13 = fAbs;
            }
            if (f16 <= f14) {
                i12 = i15;
                f14 = f16;
            }
            if (f16 > f15) {
                i14 = i15;
                f15 = f16;
            }
        }
        if (i11 == -1) {
            i11 = i12;
        }
        if (i13 == -1) {
            i13 = i14;
        }
        return new d(list.get(i11), list.get(i13));
    }

    private int convertFocusDirectionToLayoutDirection(int i11) {
        int orientation = getOrientation();
        if (i11 == 1) {
            return -1;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 == 17) {
            if (orientation == 0) {
                return P() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i11 == 33) {
            return orientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i11 == 66) {
            if (orientation == 0) {
                return P() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i11 == 130) {
            return orientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown focus request:");
        sb2.append(i11);
        return Integer.MIN_VALUE;
    }

    private int scrollBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        if (this.f36465h == null) {
            W(tVar);
        }
        int iV = v(i11, this.f36459a, this.f36460b, this.f36461c);
        this.f36459a += iV;
        e0(this.f36465h);
        float f11 = this.f36466i.f() / 2.0f;
        float fS = s(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f12 = P() ? this.f36466i.h().f36502b : this.f36466i.a().f36502b;
        float f13 = Float.MAX_VALUE;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            float fAbs = Math.abs(f12 - V(childAt, fS, f11, rect));
            if (childAt != null && fAbs < f13) {
                this.f36472o = getPosition(childAt);
                f13 = fAbs;
            }
            fS = m(fS, this.f36466i.f());
        }
        x(tVar, xVar);
        return iV;
    }

    public static int v(int i11, int i12, int i13, int i14) {
        int i15 = i12 + i11;
        if (i15 < i13) {
            return i13 - i12;
        }
        return i15 > i14 ? i14 - i12 : i11;
    }

    public final int A() {
        int i11;
        int i12;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.n nVar = (RecyclerView.n) getChildAt(0).getLayoutParams();
        if (this.f36469l.f70292a == 0) {
            i11 = ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
            i12 = ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        } else {
            i11 = ((ViewGroup.MarginLayoutParams) nVar).topMargin;
            i12 = ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }
        return i11 + i12;
    }

    public final com.google.android.material.carousel.b B(int i11) {
        com.google.android.material.carousel.b bVar;
        Map<Integer, com.google.android.material.carousel.b> map = this.f36468k;
        return (map == null || (bVar = map.get(Integer.valueOf(g3.a.b(i11, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f36465h.g() : bVar;
    }

    public final int C() {
        if (getClipToPadding() || !this.f36464g.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingTop() : getPaddingLeft();
    }

    public final float D(float f11, d dVar) {
        com.google.android.material.carousel.b.c cVar = dVar.f36481a;
        float f12 = cVar.f36504d;
        com.google.android.material.carousel.b.c cVar2 = dVar.f36482b;
        return ii.b.b(f12, cVar2.f36504d, cVar.f36502b, cVar2.f36502b, f11);
    }

    public int E(int i11, @NonNull com.google.android.material.carousel.b bVar) {
        return M(i11, bVar) - this.f36459a;
    }

    public final int F() {
        return this.f36469l.g();
    }

    public final int G() {
        return this.f36469l.h();
    }

    public final int H() {
        return this.f36469l.i();
    }

    public final int I() {
        return this.f36469l.j();
    }

    public final int J() {
        return this.f36469l.k();
    }

    public final int K() {
        return this.f36469l.l();
    }

    public final int L() {
        if (getClipToPadding() || !this.f36464g.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingBottom() : getPaddingRight();
    }

    public final int M(int i11, com.google.android.material.carousel.b bVar) {
        return P() ? (int) (((y() - bVar.h().f36501a) - (i11 * bVar.f())) - (bVar.f() / 2.0f)) : (int) (((i11 * bVar.f()) - bVar.a().f36501a) + (bVar.f() / 2.0f));
    }

    public final int N(int i11, @NonNull com.google.android.material.carousel.b bVar) {
        int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (com.google.android.material.carousel.b.c cVar : bVar.e()) {
            float f11 = (i11 * bVar.f()) + (bVar.f() / 2.0f);
            int iY = (P() ? (int) ((y() - cVar.f36501a) - f11) : (int) (f11 - cVar.f36501a)) - this.f36459a;
            if (Math.abs(i12) > Math.abs(iY)) {
                i12 = iY;
            }
        }
        return i12;
    }

    public boolean P() {
        return d() && getLayoutDirection() == 1;
    }

    public final boolean Q(float f11, d dVar) {
        float fN = n(f11, D(f11, dVar) / 2.0f);
        if (P()) {
            if (fN >= 0.0f) {
                return false;
            }
        } else if (fN <= y()) {
            return false;
        }
        return true;
    }

    public final boolean R(float f11, d dVar) {
        float fM = m(f11, D(f11, dVar) / 2.0f);
        if (P()) {
            if (fM <= y()) {
                return false;
            }
        } else if (fM >= 0.0f) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void S(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 == i15 && i12 == i16 && i13 == i17 && i14 == i18) {
            return;
        }
        view.post(new Runnable() { // from class: li.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f70291a.X();
            }
        });
    }

    public final void T() {
        if (this.f36462d && Log.isLoggable("CarouselLayoutManager", 3)) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                float fZ = z(childAt);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("item position ");
                sb2.append(getPosition(childAt));
                sb2.append(", center:");
                sb2.append(fZ);
                sb2.append(", child index:");
                sb2.append(i11);
            }
        }
    }

    public final b U(RecyclerView.t tVar, float f11, int i11) {
        View viewO = tVar.o(i11);
        measureChildWithMargins(viewO, 0, 0);
        float fM = m(f11, this.f36466i.f() / 2.0f);
        d dVarO = O(this.f36466i.g(), fM, false);
        return new b(viewO, fM, r(viewO, fM, dVarO), dVarO);
    }

    public final float V(View view, float f11, float f12, Rect rect) {
        float fM = m(f11, f12);
        d dVarO = O(this.f36466i.g(), fM, false);
        float fR = r(view, fM, dVarO);
        super.getDecoratedBoundsWithMargins(view, rect);
        d0(view, fM, dVarO);
        this.f36469l.o(view, rect, f12, fR);
        return fR;
    }

    public final void W(RecyclerView.t tVar) {
        View viewO = tVar.o(0);
        measureChildWithMargins(viewO, 0, 0);
        com.google.android.material.carousel.b bVarG = this.f36464g.g(this, viewO);
        if (P()) {
            bVarG = com.google.android.material.carousel.b.n(bVarG, y());
        }
        this.f36465h = com.google.android.material.carousel.c.f(this, bVarG, A(), C(), L());
    }

    public final void X() {
        this.f36465h = null;
        requestLayout();
    }

    public final void Y(RecyclerView.t tVar) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float fZ = z(childAt);
            if (!R(fZ, O(this.f36466i.g(), fZ, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, tVar);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float fZ2 = z(childAt2);
            if (!Q(fZ2, O(this.f36466i.g(), fZ2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, tVar);
            }
        }
    }

    public final void Z(RecyclerView recyclerView, int i11) {
        if (d()) {
            recyclerView.scrollBy(i11, 0);
        } else {
            recyclerView.scrollBy(0, i11);
        }
    }

    @Override // li.b
    public int a() {
        return getWidth();
    }

    public void a0(int i11) {
        this.f36473p = i11;
        X();
    }

    @Override // li.b
    public int b() {
        return getHeight();
    }

    public final void b0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            a0(typedArrayObtainStyledAttributes.getInt(R$styleable.Carousel_carousel_alignment, 0));
            setOrientation(typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // li.b
    public int c() {
        return this.f36473p;
    }

    public void c0(@NonNull f fVar) {
        this.f36464g = fVar;
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return !d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.x xVar) {
        if (getChildCount() == 0 || this.f36465h == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f36465h.g().f() / computeHorizontalScrollRange(xVar)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.x xVar) {
        return this.f36459a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(@NonNull RecyclerView.x xVar) {
        return this.f36461c - this.f36460b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    @Nullable
    public PointF computeScrollVectorForPosition(int i11) {
        if (this.f36465h == null) {
            return null;
        }
        int iE = E(i11, B(i11));
        return d() ? new PointF(iE, 0.0f) : new PointF(0.0f, iE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollExtent(@NonNull RecyclerView.x xVar) {
        if (getChildCount() == 0 || this.f36465h == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f36465h.g().f() / computeVerticalScrollRange(xVar)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(@NonNull RecyclerView.x xVar) {
        return this.f36459a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(@NonNull RecyclerView.x xVar) {
        return this.f36461c - this.f36460b;
    }

    @Override // li.b
    public boolean d() {
        return this.f36469l.f70292a == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d0(View view, float f11, d dVar) {
        if (view instanceof g) {
            com.google.android.material.carousel.b.c cVar = dVar.f36481a;
            float f12 = cVar.f36503c;
            com.google.android.material.carousel.b.c cVar2 = dVar.f36482b;
            float fB = ii.b.b(f12, cVar2.f36503c, cVar.f36501a, cVar2.f36501a, f11);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFF = this.f36469l.f(height, width, ii.b.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), ii.b.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fR = r(view, f11, dVar);
            RectF rectF = new RectF(fR - (rectFF.width() / 2.0f), fR - (rectFF.height() / 2.0f), fR + (rectFF.width() / 2.0f), (rectFF.height() / 2.0f) + fR);
            RectF rectF2 = new RectF(H(), K(), I(), F());
            if (this.f36464g.f()) {
                this.f36469l.a(rectFF, rectF, rectF2);
            }
            this.f36469l.n(rectFF, rectF, rectF2);
            ((g) view).setMaskRectF(rectFF);
        }
    }

    public final void e0(@NonNull com.google.android.material.carousel.c cVar) {
        int i11 = this.f36461c;
        int i12 = this.f36460b;
        if (i11 <= i12) {
            this.f36466i = P() ? cVar.h() : cVar.l();
        } else {
            this.f36466i = cVar.j(this.f36459a, i12, i11);
        }
        this.f36463f.d(this.f36466i.g());
    }

    public final void f0() {
        int itemCount = getItemCount();
        int i11 = this.f36471n;
        if (itemCount == i11 || this.f36465h == null) {
            return;
        }
        if (this.f36464g.h(this, i11)) {
            X();
        }
        this.f36471n = itemCount;
    }

    public final void g0() {
        if (!this.f36462d || getChildCount() < 1) {
            return;
        }
        int i11 = 0;
        while (i11 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i11));
            int i12 = i11 + 1;
            int position2 = getPosition(getChildAt(i12));
            if (position > position2) {
                T();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i11 + "] had adapter position [" + position + "] and child at index [" + i12 + "] had adapter position [" + position2 + "].");
            }
            i11 = i12;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return new RecyclerView.n(-2, -2);
    }

    public final View getChildClosestToEnd() {
        return getChildAt(P() ? 0 : getChildCount() - 1);
    }

    public final View getChildClosestToStart() {
        return getChildAt(P() ? getChildCount() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (d()) {
            fCenterY = rect.centerX();
        }
        float fD = D(fCenterY, O(this.f36466i.g(), fCenterY, true));
        float fWidth = d() ? (rect.width() - fD) / 2.0f : 0.0f;
        float fHeight = d() ? 0.0f : (rect.height() - fD) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public int getOrientation() {
        return this.f36469l.f70292a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public final void l(View view, int i11, b bVar) {
        float f11 = this.f36466i.f() / 2.0f;
        addView(view, i11);
        float f12 = bVar.f36477c;
        this.f36469l.m(view, (int) (f12 - f11), (int) (f12 + f11));
        d0(view, bVar.f36476b, bVar.f36478d);
    }

    public final float m(float f11, float f12) {
        return P() ? f11 - f12 : f11 + f12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void measureChildWithMargins(@NonNull View view, int i11, int i12) {
        if (!(view instanceof g)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i13 = i11 + rect.left + rect.right;
        int i14 = i12 + rect.top + rect.bottom;
        com.google.android.material.carousel.c cVar = this.f36465h;
        float f11 = (cVar == null || this.f36469l.f70292a != 0) ? ((ViewGroup.MarginLayoutParams) nVar).width : cVar.g().f();
        com.google.android.material.carousel.c cVar2 = this.f36465h;
        view.measure(RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin + i13, (int) f11, canScrollHorizontally()), RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin + i14, (int) ((cVar2 == null || this.f36469l.f70292a != 1) ? ((ViewGroup.MarginLayoutParams) nVar).height : cVar2.g().f()), canScrollVertically()));
    }

    public final float n(float f11, float f12) {
        return P() ? f11 + f12 : f11 - f12;
    }

    public final void o(@NonNull RecyclerView.t tVar, int i11, int i12) {
        if (i11 < 0 || i11 >= getItemCount()) {
            return;
        }
        b bVarU = U(tVar, s(i11), i11);
        l(bVarU.f36475a, i12, bVarU);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f36464g.e(recyclerView.getContext());
        X();
        recyclerView.addOnLayoutChangeListener(this.f36470m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        recyclerView.removeOnLayoutChangeListener(this.f36470m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @Nullable
    public View onFocusSearchFailed(@NonNull View view, int i11, @NonNull RecyclerView.t tVar, @NonNull RecyclerView.x xVar) {
        int iConvertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            o(tVar, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        o(tVar, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i11, int i12) {
        super.onItemsAdded(recyclerView, i11, i12);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i11, int i12) {
        super.onItemsRemoved(recyclerView, i11, i12);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (xVar.b() <= 0 || y() <= 0.0f) {
            removeAndRecycleAllViews(tVar);
            this.f36467j = 0;
            return;
        }
        boolean zP = P();
        boolean z11 = this.f36465h == null;
        if (z11) {
            W(tVar);
        }
        int iW = w(this.f36465h);
        int iT = t(xVar, this.f36465h);
        this.f36460b = zP ? iT : iW;
        if (zP) {
            iT = iW;
        }
        this.f36461c = iT;
        if (z11) {
            this.f36459a = iW;
            this.f36468k = this.f36465h.i(getItemCount(), this.f36460b, this.f36461c, P());
            int i11 = this.f36472o;
            if (i11 != -1) {
                this.f36459a = M(i11, B(i11));
            }
        }
        int i12 = this.f36459a;
        this.f36459a = i12 + v(0, i12, this.f36460b, this.f36461c);
        this.f36467j = g3.a.b(this.f36467j, 0, xVar.b());
        e0(this.f36465h);
        detachAndScrapAttachedViews(tVar);
        x(tVar, xVar);
        this.f36471n = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        if (getChildCount() == 0) {
            this.f36467j = 0;
        } else {
            this.f36467j = getPosition(getChildAt(0));
        }
        g0();
    }

    public final void p(RecyclerView.t tVar, RecyclerView.x xVar, int i11) {
        float fS = s(i11);
        while (i11 < xVar.b()) {
            b bVarU = U(tVar, fS, i11);
            if (Q(bVarU.f36477c, bVarU.f36478d)) {
                return;
            }
            fS = m(fS, this.f36466i.f());
            if (!R(bVarU.f36477c, bVarU.f36478d)) {
                l(bVarU.f36475a, -1, bVarU);
            }
            i11++;
        }
    }

    public final void q(RecyclerView.t tVar, int i11) {
        float fS = s(i11);
        while (i11 >= 0) {
            b bVarU = U(tVar, fS, i11);
            if (R(bVarU.f36477c, bVarU.f36478d)) {
                return;
            }
            fS = n(fS, this.f36466i.f());
            if (!Q(bVarU.f36477c, bVarU.f36478d)) {
                l(bVarU.f36475a, 0, bVarU);
            }
            i11--;
        }
    }

    public final float r(View view, float f11, d dVar) {
        com.google.android.material.carousel.b.c cVar = dVar.f36481a;
        float f12 = cVar.f36502b;
        com.google.android.material.carousel.b.c cVar2 = dVar.f36482b;
        float fB = ii.b.b(f12, cVar2.f36502b, cVar.f36501a, cVar2.f36501a, f11);
        if (dVar.f36482b != this.f36466i.c() && dVar.f36481a != this.f36466i.j()) {
            return fB;
        }
        float fE = this.f36469l.e((RecyclerView.n) view.getLayoutParams()) / this.f36466i.f();
        com.google.android.material.carousel.b.c cVar3 = dVar.f36482b;
        return fB + ((f11 - cVar3.f36501a) * ((1.0f - cVar3.f36503c) + fE));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z11, boolean z12) {
        int iN;
        if (this.f36465h == null || (iN = N(getPosition(view), B(getPosition(view)))) == 0) {
            return false;
        }
        Z(recyclerView, N(getPosition(view), this.f36465h.j(this.f36459a + v(iN, this.f36459a, this.f36460b, this.f36461c), this.f36460b, this.f36461c)));
        return true;
    }

    public final float s(int i11) {
        return m(J() - this.f36459a, this.f36466i.f() * i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (canScrollHorizontally()) {
            return scrollBy(i11, tVar, xVar);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        this.f36472o = i11;
        if (this.f36465h == null) {
            return;
        }
        this.f36459a = M(i11, B(i11));
        this.f36467j = g3.a.b(i11, 0, Math.max(0, getItemCount() - 1));
        e0(this.f36465h);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (canScrollVertically()) {
            return scrollBy(i11, tVar, xVar);
        }
        return 0;
    }

    public void setOrientation(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i11);
        }
        assertNotInLayoutOrScroll(null);
        e eVar = this.f36469l;
        if (eVar == null || i11 != eVar.f70292a) {
            this.f36469l = e.c(this, i11);
            X();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i11) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i11);
        startSmoothScroll(aVar);
    }

    public final int t(RecyclerView.x xVar, com.google.android.material.carousel.c cVar) {
        boolean zP = P();
        com.google.android.material.carousel.b bVarL = zP ? cVar.l() : cVar.h();
        com.google.android.material.carousel.b.c cVarA = zP ? bVarL.a() : bVarL.h();
        int iB = (int) (((((xVar.b() - 1) * bVarL.f()) * (zP ? -1.0f : 1.0f)) - (cVarA.f36501a - J())) + (G() - cVarA.f36501a) + (zP ? -cVarA.f36507g : cVarA.f36508h));
        return zP ? Math.min(0, iB) : Math.max(0, iB);
    }

    public int u(int i11) {
        return (int) (this.f36459a - M(i11, B(i11)));
    }

    public final int w(@NonNull com.google.android.material.carousel.c cVar) {
        boolean zP = P();
        com.google.android.material.carousel.b bVarH = zP ? cVar.h() : cVar.l();
        return (int) (J() - n((zP ? bVarH.h() : bVarH.a()).f36501a, bVarH.f() / 2.0f));
    }

    public final void x(RecyclerView.t tVar, RecyclerView.x xVar) {
        Y(tVar);
        if (getChildCount() == 0) {
            q(tVar, this.f36467j - 1);
            p(tVar, xVar, this.f36467j);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            q(tVar, position - 1);
            p(tVar, xVar, position2 + 1);
        }
        g0();
    }

    public final int y() {
        return d() ? a() : b();
    }

    public final float z(View view) {
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        return d() ? rect.centerX() : rect.centerY();
    }
}
