package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import e20.b;
import h20.c;
import h20.d;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CommonNavigator extends FrameLayout implements f20.a, b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HorizontalScrollView f71806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f71807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f71808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f71809d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h20.a f71810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f71811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f71812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f71813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f71814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f71816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f71817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f71818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f71819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f71820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f71821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<i20.a> f71822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DataSetObserver f71823s;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.f71811g.m(CommonNavigator.this.f71810f.a());
            CommonNavigator.this.d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f71814j = 0.5f;
        this.f71815k = true;
        this.f71816l = true;
        this.f71821q = true;
        this.f71822r = new ArrayList();
        this.f71823s = new a();
        b bVar = new b();
        this.f71811g = bVar;
        bVar.k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        removeAllViews();
        View viewInflate = this.f71812h ? LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        this.f71806a = (HorizontalScrollView) viewInflate.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.title_container);
        this.f71807b = linearLayout;
        linearLayout.setPadding(this.f71818n, 0, this.f71817m, 0);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R$id.indicator_container);
        this.f71808c = linearLayout2;
        if (this.f71819o) {
            linearLayout2.getParent().bringChildToFront(this.f71808c);
        }
        e();
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams;
        int iG = this.f71811g.g();
        for (int i11 = 0; i11 < iG; i11++) {
            Object objC = this.f71810f.c(getContext(), i11);
            if (objC instanceof View) {
                View view = (View) objC;
                if (this.f71812h) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f71810f.d(getContext(), i11);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f71807b.addView(view, layoutParams);
            }
        }
        h20.a aVar = this.f71810f;
        if (aVar != null) {
            c cVarB = aVar.b(getContext());
            this.f71809d = cVarB;
            if (cVarB instanceof View) {
                this.f71808c.addView((View) this.f71809d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        this.f71822r.clear();
        int iG = this.f71811g.g();
        for (int i11 = 0; i11 < iG; i11++) {
            i20.a aVar = new i20.a();
            View childAt = this.f71807b.getChildAt(i11);
            if (childAt != 0) {
                aVar.f66885a = childAt.getLeft();
                aVar.f66886b = childAt.getTop();
                aVar.f66887c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f66888d = bottom;
                if (childAt instanceof h20.b) {
                    h20.b bVar = (h20.b) childAt;
                    aVar.f66889e = bVar.getContentLeft();
                    aVar.f66890f = bVar.getContentTop();
                    aVar.f66891g = bVar.getContentRight();
                    aVar.f66892h = bVar.getContentBottom();
                } else {
                    aVar.f66889e = aVar.f66885a;
                    aVar.f66890f = aVar.f66886b;
                    aVar.f66891g = aVar.f66887c;
                    aVar.f66892h = bottom;
                }
            }
            this.f71822r.add(aVar);
        }
    }

    public h20.a getAdapter() {
        return this.f71810f;
    }

    public int getLeftPadding() {
        return this.f71818n;
    }

    public c getPagerIndicator() {
        return this.f71809d;
    }

    public d getPagerTitleView(int i11) {
        LinearLayout linearLayout = this.f71807b;
        if (linearLayout == null) {
            return null;
        }
        return (d) linearLayout.getChildAt(i11);
    }

    public int getRightPadding() {
        return this.f71817m;
    }

    public float getScrollPivotX() {
        return this.f71814j;
    }

    public LinearLayout getTitleContainer() {
        return this.f71807b;
    }

    public boolean isAdjustMode() {
        return this.f71812h;
    }

    public boolean isEnablePivotScroll() {
        return this.f71813i;
    }

    public boolean isFollowTouch() {
        return this.f71816l;
    }

    public boolean isIndicatorOnTop() {
        return this.f71819o;
    }

    public boolean isReselectWhenLayout() {
        return this.f71821q;
    }

    public boolean isSkimOver() {
        return this.f71820p;
    }

    public boolean isSmoothScroll() {
        return this.f71815k;
    }

    @Override // f20.a
    public void notifyDataSetChanged() {
        h20.a aVar = this.f71810f;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // f20.a
    public void onAttachToMagicIndicator() {
        d();
    }

    @Override // e20.b.a
    public void onDeselected(int i11, int i12) {
        LinearLayout linearLayout = this.f71807b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onDeselected(i11, i12);
        }
    }

    @Override // f20.a
    public void onDetachFromMagicIndicator() {
    }

    @Override // e20.b.a
    public void onEnter(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f71807b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onEnter(i11, i12, f11, z11);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f71810f != null) {
            f();
            c cVar = this.f71809d;
            if (cVar != null) {
                cVar.onPositionDataProvide(this.f71822r);
            }
            if (this.f71821q && this.f71811g.f() == 0) {
                onPageSelected(this.f71811g.e());
                onPageScrolled(this.f71811g.e(), 0.0f, 0);
            }
        }
    }

    @Override // e20.b.a
    public void onLeave(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f71807b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onLeave(i11, i12, f11, z11);
        }
    }

    @Override // f20.a
    public void onPageScrollStateChanged(int i11) {
        if (this.f71810f != null) {
            this.f71811g.h(i11);
            c cVar = this.f71809d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i11);
            }
        }
    }

    @Override // f20.a
    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.f71810f != null) {
            this.f71811g.i(i11, f11, i12);
            c cVar = this.f71809d;
            if (cVar != null) {
                cVar.onPageScrolled(i11, f11, i12);
            }
            if (this.f71806a == null || this.f71822r.size() <= 0 || i11 < 0 || i11 >= this.f71822r.size() || !this.f71816l) {
                return;
            }
            int iMin = Math.min(this.f71822r.size() - 1, i11);
            int iMin2 = Math.min(this.f71822r.size() - 1, i11 + 1);
            i20.a aVar = this.f71822r.get(iMin);
            i20.a aVar2 = this.f71822r.get(iMin2);
            float fA = aVar.a() - (this.f71806a.getWidth() * this.f71814j);
            this.f71806a.scrollTo((int) (fA + (((aVar2.a() - (this.f71806a.getWidth() * this.f71814j)) - fA) * f11)), 0);
        }
    }

    @Override // f20.a
    public void onPageSelected(int i11) {
        if (this.f71810f != null) {
            this.f71811g.j(i11);
            c cVar = this.f71809d;
            if (cVar != null) {
                cVar.onPageSelected(i11);
            }
        }
    }

    @Override // e20.b.a
    public void onSelected(int i11, int i12) {
        LinearLayout linearLayout = this.f71807b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onSelected(i11, i12);
        }
        if (this.f71812h || this.f71816l || this.f71806a == null || this.f71822r.size() <= 0) {
            return;
        }
        i20.a aVar = this.f71822r.get(Math.min(this.f71822r.size() - 1, i11));
        if (this.f71813i) {
            float fA = aVar.a() - (this.f71806a.getWidth() * this.f71814j);
            if (this.f71815k) {
                this.f71806a.smoothScrollTo((int) fA, 0);
                return;
            } else {
                this.f71806a.scrollTo((int) fA, 0);
                return;
            }
        }
        int scrollX = this.f71806a.getScrollX();
        int i13 = aVar.f66885a;
        if (scrollX > i13) {
            if (this.f71815k) {
                this.f71806a.smoothScrollTo(i13, 0);
                return;
            } else {
                this.f71806a.scrollTo(i13, 0);
                return;
            }
        }
        int scrollX2 = this.f71806a.getScrollX() + getWidth();
        int i14 = aVar.f66887c;
        if (scrollX2 < i14) {
            if (this.f71815k) {
                this.f71806a.smoothScrollTo(i14 - getWidth(), 0);
            } else {
                this.f71806a.scrollTo(i14 - getWidth(), 0);
            }
        }
    }

    public void setAdapter(h20.a aVar) {
        h20.a aVar2 = this.f71810f;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.g(this.f71823s);
        }
        this.f71810f = aVar;
        if (aVar == null) {
            this.f71811g.m(0);
            d();
            return;
        }
        aVar.f(this.f71823s);
        this.f71811g.m(this.f71810f.a());
        if (this.f71807b != null) {
            this.f71810f.e();
        }
    }

    public void setAdjustMode(boolean z11) {
        this.f71812h = z11;
    }

    public void setEnablePivotScroll(boolean z11) {
        this.f71813i = z11;
    }

    public void setFollowTouch(boolean z11) {
        this.f71816l = z11;
    }

    public void setIndicatorOnTop(boolean z11) {
        this.f71819o = z11;
    }

    public void setLeftPadding(int i11) {
        this.f71818n = i11;
    }

    public void setReselectWhenLayout(boolean z11) {
        this.f71821q = z11;
    }

    public void setRightPadding(int i11) {
        this.f71817m = i11;
    }

    public void setScrollPivotX(float f11) {
        this.f71814j = f11;
    }

    public void setSkimOver(boolean z11) {
        this.f71820p = z11;
        this.f71811g.l(z11);
    }

    public void setSmoothScroll(boolean z11) {
        this.f71815k = z11;
    }
}
