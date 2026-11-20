package com.to.aboomy.pager2banner;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class Banner extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2.OnPageChangeCallback f50209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositePageTransformer f50210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f50211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPager2 f50212d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.to.aboomy.pager2banner.a f50213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f50217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f50218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f50220m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f50221n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f50222o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f50223p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f50224q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f50225r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f50226s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f50227t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RecyclerView.g f50228u;

    /* JADX INFO: compiled from: source.java */
    public class a extends RecyclerView.g {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            Banner banner = Banner.this;
            banner.t(banner.getCurrentPager());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onItemRangeInserted(int i11, int i12) {
            if (i11 > 1) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onItemRangeMoved(int i11, int i12, int i13) {
            onChanged();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f50230a;

        public b(float f11) {
            this.f50230a = f11;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f50230a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends RecyclerView.Adapter<RecyclerView.a0> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RecyclerView.Adapter f50232i;

        public c() {
        }

        public int e() {
            RecyclerView.Adapter adapter = this.f50232i;
            if (adapter == null) {
                return 0;
            }
            return adapter.getItemCount();
        }

        public void f(RecyclerView.Adapter adapter) {
            RecyclerView.Adapter adapter2 = this.f50232i;
            if (adapter2 != null) {
                adapter2.unregisterAdapterDataObserver(Banner.this.f50228u);
            }
            this.f50232i = adapter;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(Banner.this.f50228u);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return e() > 1 ? e() + Banner.this.f50219l : e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return this.f50232i.getItemId(Banner.this.u(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i11) {
            return this.f50232i.getItemViewType(Banner.this.u(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.a0 a0Var, int i11) {
            this.f50232i.onBindViewHolder(a0Var, Banner.this.u(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.a0 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
            return this.f50232i.onCreateViewHolder(viewGroup, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends ViewPager2.OnPageChangeCallback {
        public d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            if (i11 == 1) {
                if (Banner.this.f50221n == Banner.this.f50220m - 1) {
                    Banner.this.f50215h = false;
                    Banner.this.f50212d.setCurrentItem(Banner.this.getRealCount() + Banner.this.f50221n, false);
                } else if (Banner.this.f50221n == Banner.this.getRealCount() + Banner.this.f50220m) {
                    Banner.this.f50215h = false;
                    Banner.this.f50212d.setCurrentItem(Banner.this.f50220m, false);
                } else {
                    Banner.this.f50215h = true;
                }
            }
            if (Banner.this.f50209a != null) {
                Banner.this.f50209a.onPageScrollStateChanged(i11);
            }
            if (Banner.this.f50213f != null) {
                Banner.this.f50213f.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            int iU = Banner.this.u(i11);
            if (Banner.this.f50209a != null) {
                Banner.this.f50209a.onPageScrolled(iU, f11, i12);
            }
            if (Banner.this.f50213f != null) {
                Banner.this.f50213f.onPageScrolled(iU, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (Banner.this.getRealCount() > 1) {
                Banner.this.f50221n = i11;
            }
            if (Banner.this.f50215h) {
                int iU = Banner.this.u(i11);
                if (Banner.this.f50209a != null) {
                    Banner.this.f50209a.onPageSelected(iU);
                }
                if (Banner.this.f50213f != null) {
                    Banner.this.f50213f.onPageSelected(iU);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.m f50235a;

        /* JADX INFO: compiled from: source.java */
        public class a extends h {
            public a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.h
            public int w(int i11) {
                return (int) (Banner.this.f50218k * 0.6644d);
            }
        }

        public e(Context context, LinearLayoutManager linearLayoutManager) {
            super(context, linearLayoutManager.getOrientation(), false);
            this.f50235a = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.x xVar, @NonNull int[] iArr) {
            try {
                Method declaredMethod = this.f50235a.getClass().getDeclaredMethod("calculateExtraLayoutSpace", xVar.getClass(), iArr.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f50235a, xVar, iArr);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (NoSuchMethodException e12) {
                e12.printStackTrace();
            } catch (InvocationTargetException e13) {
                e13.printStackTrace();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.t tVar, @NonNull RecyclerView.x xVar, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.f50235a.onInitializeAccessibilityNodeInfo(tVar, xVar, accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean performAccessibilityAction(@NonNull RecyclerView.t tVar, @NonNull RecyclerView.x xVar, int i11, @Nullable Bundle bundle) {
            return this.f50235a.performAccessibilityAction(tVar, xVar, i11, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z11, boolean z12) {
            return this.f50235a.requestChildRectangleOnScreen(recyclerView, view, rect, z11, z12);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i11) {
            a aVar = new a(recyclerView.getContext());
            aVar.p(i11);
            startSmoothScroll(aVar);
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f50214g = true;
        this.f50215h = true;
        this.f50217j = 2500L;
        this.f50218k = 800L;
        this.f50219l = 2;
        this.f50220m = 2 / 2;
        this.f50227t = new Runnable() { // from class: com.to.aboomy.pager2banner.Banner.1
            @Override // java.lang.Runnable
            public void run() {
                if (Banner.this.isAutoPlay()) {
                    Banner.i(Banner.this);
                    if (Banner.this.f50221n == Banner.this.getRealCount() + Banner.this.f50220m + 1) {
                        Banner.this.f50215h = false;
                        Banner.this.f50212d.setCurrentItem(Banner.this.f50220m, false);
                        Banner banner = Banner.this;
                        banner.post(banner.f50227t);
                        return;
                    }
                    Banner.this.f50215h = true;
                    Banner.this.f50212d.setCurrentItem(Banner.this.f50221n);
                    Banner banner2 = Banner.this;
                    banner2.postDelayed(banner2.f50227t, Banner.this.f50217j);
                }
            }
        };
        this.f50228u = new a();
        this.f50226s = ViewConfiguration.get(context).getScaledTouchSlop() >> 1;
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealCount() {
        return this.f50211c.e();
    }

    public static /* synthetic */ int i(Banner banner) {
        int i11 = banner.f50221n;
        banner.f50221n = i11 + 1;
        return i11;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.l lVar) {
        this.f50212d.addItemDecoration(lVar);
        return this;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.l lVar, int i11) {
        this.f50212d.addItemDecoration(lVar, i11);
        return this;
    }

    public Banner addPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.f50210b.addTransformer(pageTransformer);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isAutoPlay() && this.f50212d.isUserInputEnabled()) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startTurning();
            } else if (action == 0) {
                stopTurning();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f50211c.f50232i;
    }

    public int getCurrentPager() {
        return Math.max(u(this.f50221n), 0);
    }

    public ViewPager2 getViewPager2() {
        return this.f50212d;
    }

    public boolean isAutoPlay() {
        return this.f50214g && getRealCount() > 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAutoPlay()) {
            startTurning();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isAutoPlay()) {
            stopTurning();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.f50224q = rawX;
            this.f50222o = rawX;
            float rawY = motionEvent.getRawY();
            this.f50225r = rawY;
            this.f50223p = rawY;
        } else {
            boolean z11 = false;
            if (action == 2) {
                this.f50224q = motionEvent.getRawX();
                this.f50225r = motionEvent.getRawY();
                if (this.f50212d.isUserInputEnabled()) {
                    float fAbs = Math.abs(this.f50224q - this.f50222o);
                    float fAbs2 = Math.abs(this.f50225r - this.f50223p);
                    if (this.f50212d.getOrientation() != 0 ? !(fAbs2 <= this.f50226s || fAbs2 <= fAbs) : !(fAbs <= this.f50226s || fAbs <= fAbs2)) {
                        z11 = true;
                    }
                    getParent().requestDisallowInterceptTouchEvent(z11);
                }
            } else if (action == 3 || action == 1) {
                return Math.abs(this.f50224q - this.f50222o) > ((float) this.f50226s) || Math.abs(this.f50225r - this.f50223p) > ((float) this.f50226s);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void r() {
        try {
            RecyclerView recyclerView = (RecyclerView) this.f50212d.getChildAt(0);
            recyclerView.setOverScrollMode(2);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            e eVar = new e(getContext(), linearLayoutManager);
            recyclerView.setLayoutManager(eVar);
            Field declaredField = RecyclerView.m.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            declaredField.set(linearLayoutManager, recyclerView);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField2.setAccessible(true);
            declaredField2.set(this.f50212d, eVar);
            Field declaredField3 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField3.setAccessible(true);
            Object obj = declaredField3.get(this.f50212d);
            if (obj != null) {
                Field declaredField4 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, eVar);
            }
            Field declaredField5 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField5.setAccessible(true);
            Object obj2 = declaredField5.get(this.f50212d);
            if (obj2 != null) {
                Field declaredField6 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField6.setAccessible(true);
                declaredField6.set(obj2, eVar);
            }
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
        }
    }

    public final void s(Context context) {
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f50212d = viewPager2;
        viewPager2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewPager2 viewPager3 = this.f50212d;
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        this.f50210b = compositePageTransformer;
        viewPager3.setPageTransformer(compositePageTransformer);
        this.f50212d.registerOnPageChangeCallback(new d());
        ViewPager2 viewPager4 = this.f50212d;
        c cVar = new c();
        this.f50211c = cVar;
        viewPager4.setAdapter(cVar);
        setOffscreenPageLimit(1);
        r();
        addView(this.f50212d);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        setAdapter(adapter, 0);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter, int i11) {
        this.f50211c.f(adapter);
        t(i11);
    }

    public Banner setAutoPlay(boolean z11) {
        this.f50214g = z11;
        if (z11 && getRealCount() > 1) {
            startTurning();
        }
        return this;
    }

    public Banner setAutoTurningTime(long j11) {
        this.f50217j = j11;
        return this;
    }

    public void setCurrentItem(int i11) {
        setCurrentItem(i11, true);
    }

    public void setCurrentItem(int i11, boolean z11) {
        int i12 = i11 + this.f50220m;
        this.f50221n = i12;
        this.f50212d.setCurrentItem(i12, z11);
    }

    public Banner setIndicator(com.to.aboomy.pager2banner.a aVar) {
        return setIndicator(aVar, true);
    }

    public Banner setIndicator(com.to.aboomy.pager2banner.a aVar, boolean z11) {
        com.to.aboomy.pager2banner.a aVar2 = this.f50213f;
        if (aVar2 != null) {
            removeView(aVar2.getView());
        }
        if (aVar != null) {
            this.f50213f = aVar;
            if (z11) {
                addView(aVar.getView(), this.f50213f.getParams());
            }
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i11) {
        this.f50212d.setOffscreenPageLimit(i11);
        return this;
    }

    public Banner setOrientation(int i11) {
        this.f50212d.setOrientation(i11);
        return this;
    }

    public Banner setOuterPageChangeListener(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f50209a = onPageChangeCallback;
        return this;
    }

    public Banner setPageMargin(int i11, int i12) {
        return setPageMargin(i11, i11, i12);
    }

    public Banner setPageMargin(int i11, int i12, int i13) {
        if (i13 < 0) {
            i13 = 0;
        }
        addPageTransformer(new MarginPageTransformer(i13));
        RecyclerView recyclerView = (RecyclerView) this.f50212d.getChildAt(0);
        if (this.f50212d.getOrientation() == 1) {
            recyclerView.setPadding(this.f50212d.getPaddingLeft(), i11 + Math.abs(i13), this.f50212d.getPaddingRight(), i12 + Math.abs(i13));
        } else {
            recyclerView.setPadding(i11 + Math.abs(i13), this.f50212d.getPaddingTop(), i12 + Math.abs(i13), this.f50212d.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
        this.f50219l = 4;
        this.f50220m = 2;
        return this;
    }

    public Banner setPagerScrollDuration(long j11) {
        this.f50218k = j11;
        return this;
    }

    @RequiresApi(api = 21)
    public Banner setRoundCorners(float f11) {
        setOutlineProvider(new b(f11));
        setClipToOutline(true);
        return this;
    }

    public void startTurning() {
        stopTurning();
        postDelayed(this.f50227t, this.f50217j);
        this.f50216i = true;
    }

    public void stopTurning() {
        if (this.f50216i) {
            removeCallbacks(this.f50227t);
            this.f50216i = false;
        }
    }

    public final void t(int i11) {
        if (this.f50220m == 2) {
            this.f50212d.setAdapter(this.f50211c);
        } else {
            this.f50211c.notifyDataSetChanged();
        }
        setCurrentItem(i11, false);
        com.to.aboomy.pager2banner.a aVar = this.f50213f;
        if (aVar != null) {
            aVar.initIndicatorCount(getRealCount(), getCurrentPager());
        }
        if (isAutoPlay()) {
            startTurning();
        }
    }

    public final int u(int i11) {
        int realCount = getRealCount() > 1 ? (i11 - this.f50220m) % getRealCount() : 0;
        return realCount < 0 ? realCount + getRealCount() : realCount;
    }
}
