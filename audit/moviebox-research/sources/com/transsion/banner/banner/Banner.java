package com.transsion.banner.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.f0;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.logging.type.LogSeverity;
import com.transsion.banner.R$id;
import com.transsion.banner.R$string;
import com.transsion.banner.R$styleable;
import com.transsion.banner.banner.config.BannerType;
import com.transsion.banner.banner.util.ScrollSpeedManger;
import com.transsion.banner.view.MaskView;
import com.transsion.moviedetailapi.bean.BannerData;
import ir.a;
import java.lang.ref.WeakReference;
import java.util.List;
import wp.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class Banner<T, BA extends ir.a<T, ? extends RecyclerView.a0>> extends FrameLayout implements nr.a {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_VALUE = -1;
    public static final int VERTICAL = 1;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public float I;
    public float J;
    public boolean K;
    public boolean L;
    public Paint M;
    public Paint N;
    public final RecyclerView.g O;
    public boolean P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f50973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AutoLoopTask f50974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f50975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BA f50976d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public wp.a f50977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CompositePageTransformer f50978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Banner<T, BA>.b f50979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f50982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50983l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f50984m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f50985n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f50986o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f50987p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f50988q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f50989r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f50990s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f50991t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f50992u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f50993v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f50994w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f50995x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f50996y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f50997z;

    /* JADX INFO: compiled from: source.java */
    public static class AutoLoopTask implements Runnable {
        private final WeakReference<Banner> reference;

        public AutoLoopTask(Banner banner) {
            this.reference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.reference.get();
            if (banner == null || !banner.f50981j || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.setCurrentItem((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.f50974b, banner.f50982k);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public class a extends RecyclerView.g {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            if (Banner.this.getItemCount() <= 1) {
                Banner.this.stop();
            } else {
                Banner.this.start();
            }
            Banner.this.setIndicatorPageChange();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public class b extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f50999a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f51000b;

        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            if (i11 == 1 || i11 == 2) {
                this.f51000b = true;
            } else if (i11 == 0) {
                this.f51000b = false;
                if (this.f50999a != -1 && Banner.this.f50980i) {
                    int i12 = this.f50999a;
                    if (i12 == 0) {
                        Banner banner = Banner.this;
                        banner.setCurrentItem(banner.getRealCount(), false);
                    } else if (i12 == Banner.this.getItemCount() - 1) {
                        Banner.this.setCurrentItem(1, false);
                    }
                }
            }
            if (Banner.this.f50975c != null) {
                Banner.this.f50975c.onPageScrollStateChanged(i11);
            }
            if (Banner.this.getIndicator() != null) {
                Banner.this.getIndicator().onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            int iB = nr.c.b(Banner.this.isInfiniteLoop(), i11, Banner.this.getRealCount());
            if (Banner.this.f50975c != null && iB == Banner.this.getCurrentItem() - 1) {
                Banner.this.f50975c.onPageScrolled(iB, f11, i12);
            }
            if (Banner.this.getIndicator() == null || iB != Banner.this.getCurrentItem() - 1) {
                return;
            }
            Banner.this.getIndicator().onPageScrolled(iB, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (this.f51000b) {
                this.f50999a = i11;
                Banner.this.getAdapter().g(i11);
                int iF = Banner.this.getAdapter().f(i11);
                if (Banner.this.f50975c != null) {
                    Banner.this.f50975c.onPageSelected(iF);
                }
                if (Banner.this.getIndicator() != null) {
                    Banner.this.getIndicator().onPageSelected(iF);
                }
                if (Banner.this.P) {
                    Banner.this.findViewById(R$id.banner_mask_id).setVisibility(((BannerData) Banner.this.f50976d.d(Banner.this.f50976d.f(i11))).getType() == BannerType.AD.ordinal() ? 4 : 0);
                }
            }
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
        this.f50980i = true;
        this.f50981j = true;
        this.f50982k = 3000L;
        this.f50983l = LogSeverity.CRITICAL_VALUE;
        this.f50984m = 1;
        this.f50985n = 0.0f;
        this.f50990s = jr.a.f68125a;
        this.f50991t = jr.a.f68126b;
        this.f50992u = -1996488705;
        this.f50993v = -2013265920;
        this.f50994w = 1;
        this.D = jr.a.f68129e;
        this.E = jr.a.f68130f;
        this.F = -1;
        this.G = 0;
        this.L = true;
        this.O = new a();
        this.P = false;
        p(context, attributeSet);
        l(context);
    }

    private void l(Context context) {
        this.H = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f50978g = new CompositePageTransformer();
        this.f50979h = new b();
        this.f50974b = new AutoLoopTask(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f50973a = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, this.F));
        this.f50973a.setOffscreenPageLimit(2);
        this.f50973a.registerOnPageChangeCallback(this.f50979h);
        this.f50973a.setPageTransformer(this.f50978g);
        ScrollSpeedManger.f(this);
        addView(this.f50973a);
        Paint paint = new Paint();
        this.M = paint;
        paint.setColor(-1);
        this.M.setAntiAlias(true);
        this.M.setStyle(Paint.Style.FILL);
        this.M.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.N = paint2;
        paint2.setXfermode(null);
        setOrientation(this.G);
        q();
    }

    public Banner addBannerLifecycleObserver(u uVar) {
        if (uVar != null) {
            uVar.getLifecycle().a(new nr.b(uVar, this));
        }
        return this;
    }

    public Banner addItemDecoration(RecyclerView.l lVar) {
        getViewPager2().addItemDecoration(lVar);
        return this;
    }

    public Banner addItemDecoration(RecyclerView.l lVar, int i11) {
        getViewPager2().addItemDecoration(lVar, i11);
        return this;
    }

    public Banner addOnPageChangeListener(c cVar) {
        this.f50975c = cVar;
        return this;
    }

    public Banner addPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f50978g.addTransformer(pageTransformer);
        return this;
    }

    public void destroy() {
        if (getViewPager2() != null && this.f50979h != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.f50979h);
            this.f50979h = null;
        }
        stop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f50985n <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.N, 31);
        super.dispatchDraw(canvas);
        if (!this.f50987p && !this.f50986o && !this.f50989r && !this.f50988q) {
            j(canvas);
            k(canvas);
            h(canvas);
            i(canvas);
            canvas.restore();
            return;
        }
        if (this.f50986o) {
            j(canvas);
        }
        if (this.f50987p) {
            k(canvas);
        }
        if (this.f50988q) {
            h(canvas);
        }
        if (this.f50989r) {
            i(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            start();
        } else if (actionMasked == 0) {
            stop();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ir.a getAdapter() {
        return this.f50976d;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public wp.a getIndicator() {
        return this.f50977f;
    }

    public com.tn.lib.view.indicator.a getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() != null) {
            return getAdapter().getItemCount();
        }
        return 0;
    }

    public int getRealCount() {
        if (getAdapter() != null) {
            return getAdapter().e();
        }
        return 0;
    }

    public int getScrollTime() {
        return this.f50983l;
    }

    public int getStartPosition() {
        return this.f50984m;
    }

    public ViewPager2 getViewPager2() {
        return this.f50973a;
    }

    public final void h(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f11 = height;
        path.moveTo(0.0f, f11 - this.f50985n);
        path.lineTo(0.0f, f11);
        path.lineTo(this.f50985n, f11);
        float f12 = this.f50985n;
        path.arcTo(new RectF(0.0f, f11 - (f12 * 2.0f), f12 * 2.0f, f11), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.M);
    }

    public final void i(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f11 = width;
        float f12 = height;
        path.moveTo(f11 - this.f50985n, f12);
        path.lineTo(f11, f12);
        path.lineTo(f11, f12 - this.f50985n);
        float f13 = this.f50985n;
        path.arcTo(new RectF(f11 - (f13 * 2.0f), f12 - (f13 * 2.0f), f11, f12), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.M);
    }

    public Banner isAutoLoop(boolean z11) {
        this.f50981j = z11;
        return this;
    }

    public boolean isInfiniteLoop() {
        return this.f50980i;
    }

    public final void j(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.f50985n);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f50985n, 0.0f);
        float f11 = this.f50985n;
        path.arcTo(new RectF(0.0f, 0.0f, f11 * 2.0f, f11 * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.M);
    }

    public final void k(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f11 = width;
        path.moveTo(f11 - this.f50985n, 0.0f);
        path.lineTo(f11, 0.0f);
        path.lineTo(f11, this.f50985n);
        float f12 = this.f50985n;
        path.arcTo(new RectF(f11 - (f12 * 2.0f), 0.0f, f11, f12 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.M);
    }

    public final void m() {
        if (getIndicator() == null || getAdapter() == null) {
            return;
        }
        if (getIndicator().getIndicatorConfig().l()) {
            removeIndicator();
            addView(getIndicator().getIndicatorView());
        }
        n();
        setIndicatorPageChange();
    }

    public final void n() {
        int i11 = this.f50996y;
        if (i11 != 0) {
            setIndicatorMargins(new com.tn.lib.view.indicator.a.C0540a(i11));
        } else {
            int i12 = this.f50997z;
            if (i12 != 0 || this.A != 0 || this.B != 0 || this.C != 0) {
                setIndicatorMargins(new com.tn.lib.view.indicator.a.C0540a(i12, this.A, this.B, this.C));
            }
        }
        int i13 = this.f50995x;
        if (i13 > 0) {
            setIndicatorSpace(i13);
        }
        int i14 = this.f50994w;
        if (i14 != 1) {
            setIndicatorGravity(i14);
        }
        int i15 = this.f50990s;
        if (i15 > 0) {
            setIndicatorNormalWidth(i15);
        }
        int i16 = this.f50991t;
        if (i16 > 0) {
            setIndicatorSelectedWidth(i16);
        }
        int i17 = this.D;
        if (i17 > 0) {
            setIndicatorHeight(i17);
        }
        int i18 = this.E;
        if (i18 > 0) {
            setIndicatorRadius(i18);
        }
        setIndicatorNormalColor(this.f50992u);
        setIndicatorSelectedColor(this.f50993v);
    }

    public final void o() {
        MaskView maskView = (MaskView) findViewById(R$id.banner_mask_id);
        if (maskView == null) {
            maskView = new MaskView(getContext());
            maskView.setId(R$id.banner_mask_id);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f0.a(96.0f));
            layoutParams.gravity = 80;
            maskView.setLayoutParams(layoutParams);
            addView(maskView);
        }
        if (this.f50976d.getItemCount() <= 0 || ((BannerData) this.f50976d.d(0)).getType() != BannerType.AD.ordinal()) {
            return;
        }
        maskView.setVisibility(4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // nr.a
    public void onDestroy(u uVar) {
        destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled() || !this.L) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.I = motionEvent.getX();
            this.J = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float fAbs = Math.abs(x11 - this.I);
            float fAbs2 = Math.abs(y11 - this.J);
            if (getViewPager2().getOrientation() == 0) {
                this.K = fAbs > ((float) this.H) && fAbs > fAbs2;
            } else {
                this.K = fAbs2 > ((float) this.H) && fAbs2 > fAbs;
            }
            getParent().requestDisallowInterceptTouchEvent(this.K);
        } else if (action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // nr.a
    public void onStart(u uVar) {
        start();
    }

    @Override // nr.a
    public void onStop(u uVar) {
        stop();
    }

    public final void p(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Banner);
            this.f50985n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_radius, 0);
            this.f50982k = typedArrayObtainStyledAttributes.getInt(R$styleable.Banner_banner_loop_time, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            this.f50981j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_auto_loop, true);
            this.f50980i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_infinite_loop, true);
            this.f50990s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_normal_width, jr.a.f68125a);
            this.f50991t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_selected_width, jr.a.f68126b);
            this.f50992u = typedArrayObtainStyledAttributes.getColor(R$styleable.Banner_banner_indicator_normal_color, -1996488705);
            this.f50993v = typedArrayObtainStyledAttributes.getColor(R$styleable.Banner_banner_indicator_selected_color, -2013265920);
            this.f50994w = typedArrayObtainStyledAttributes.getInt(R$styleable.Banner_banner_indicator_gravity, 1);
            this.f50995x = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_space, 0);
            this.f50996y = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_margin, 0);
            this.f50997z = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginLeft, 0);
            this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginTop, 0);
            this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginRight, 0);
            this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginBottom, 0);
            this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_height, jr.a.f68129e);
            this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_radius, jr.a.f68130f);
            this.G = typedArrayObtainStyledAttributes.getInt(R$styleable.Banner_banner_orientation, 0);
            this.f50986o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_top_left, false);
            this.f50987p = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_top_right, false);
            this.f50988q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_bottom_left, false);
            this.f50989r = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_bottom_right, false);
            this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_viewpager_height, -1);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void q() {
        if (!isInfiniteLoop()) {
            isAutoLoop(false);
        }
        setStartPosition(isInfiniteLoop() ? this.f50984m : 0);
    }

    public final void r(int i11, int i12) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(this.f50973a.getPaddingLeft(), i11, this.f50973a.getPaddingRight(), i12);
        } else {
            recyclerView.setPadding(i11, this.f50973a.getPaddingTop(), i12, this.f50973a.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
    }

    public Banner removeIndicator() {
        if (getIndicator() != null) {
            removeView(getIndicator().getIndicatorView());
        }
        return this;
    }

    public Banner removeTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.f50978g.removeTransformer(pageTransformer);
        return this;
    }

    public Banner setAdapter(BA ba2) {
        if (ba2 == null) {
            throw new NullPointerException(getContext().getString(R$string.banner_adapter_null_error));
        }
        this.f50976d = ba2;
        if (!isInfiniteLoop()) {
            getAdapter().i(0);
        }
        getAdapter().registerAdapterDataObserver(this.O);
        this.f50973a.setAdapter(ba2);
        setCurrentItem(this.f50984m, false);
        if (this.P) {
            o();
        }
        m();
        if (ba2.getItemCount() == 1) {
            this.f50973a.setUserInputEnabled(false);
        }
        return this;
    }

    public Banner setAdapter(BA ba2, boolean z11) {
        this.f50980i = z11;
        q();
        setAdapter(ba2);
        return this;
    }

    public Banner setAdapter(BA ba2, boolean z11, boolean z12) {
        this.P = z12;
        setAdapter(ba2, z11);
        return this;
    }

    public Banner setBannerGalleryEffect(int i11, int i12) {
        return setBannerGalleryEffect(i11, i12, 0.85f);
    }

    public Banner setBannerGalleryEffect(int i11, int i12, float f11) {
        return setBannerGalleryEffect(i11, i11, i12, f11);
    }

    public Banner setBannerGalleryEffect(int i11, int i12, int i13) {
        return setBannerGalleryEffect(i11, i12, i13, 0.85f);
    }

    public Banner setBannerGalleryEffect(int i11, int i12, int i13, float f11) {
        if (i13 > 0) {
            addPageTransformer(new MarginPageTransformer(nr.c.a(i13)));
        }
        if (f11 < 1.0f && f11 > 0.0f) {
            addPageTransformer(new mr.c(f11));
        }
        r(i11 > 0 ? nr.c.a(i11 + i13) : 0, i12 > 0 ? nr.c.a(i12 + i13) : 0);
        return this;
    }

    public Banner setBannerGalleryMZ(int i11) {
        return setBannerGalleryMZ(i11, 0.88f);
    }

    public Banner setBannerGalleryMZ(int i11, float f11) {
        if (f11 < 1.0f && f11 > 0.0f) {
            addPageTransformer(new mr.b(f11));
        }
        setRecyclerViewPadding(nr.c.a(i11));
        return this;
    }

    public Banner setBannerRound(float f11) {
        this.f50985n = f11;
        return this;
    }

    @RequiresApi(api = 21)
    public Banner setBannerRound2(float f11) {
        nr.c.c(this, f11);
        return this;
    }

    public Banner setCurrentItem(int i11) {
        return setCurrentItem(i11, true);
    }

    public Banner setCurrentItem(int i11, boolean z11) {
        getViewPager2().setCurrentItem(i11, z11);
        return this;
    }

    public Banner setDatas(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().h(list);
            setCurrentItem(this.f50984m, false);
            setIndicatorPageChange();
            start();
        }
        return this;
    }

    public Banner setIndicator(wp.a aVar) {
        return setIndicator(aVar, true);
    }

    public Banner setIndicator(wp.a aVar, boolean z11) {
        removeIndicator();
        aVar.getIndicatorConfig().m(z11);
        this.f50977f = aVar;
        m();
        return this;
    }

    public Banner setIndicatorGravity(int i11) {
        if (getIndicatorConfig() != null && getIndicatorConfig().l()) {
            getIndicatorConfig().o(i11);
            getIndicator().getIndicatorView().postInvalidate();
        }
        return this;
    }

    public Banner setIndicatorHeight(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().p(i11);
        }
        return this;
    }

    public Banner setIndicatorMargins(com.tn.lib.view.indicator.a.C0540a c0540a) {
        if (getIndicatorConfig() != null && getIndicatorConfig().l()) {
            getIndicatorConfig().s(c0540a);
            getIndicator().getIndicatorView().requestLayout();
        }
        return this;
    }

    public Banner setIndicatorNormalColor(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().t(i11);
        }
        return this;
    }

    public Banner setIndicatorNormalColorRes(int i11) {
        setIndicatorNormalColor(z2.a.getColor(getContext(), i11));
        return this;
    }

    public Banner setIndicatorNormalWidth(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().u(i11);
        }
        return this;
    }

    public Banner setIndicatorPageChange() {
        if (getIndicator() != null) {
            getIndicator().onPageChanged(getRealCount(), nr.c.b(isInfiniteLoop(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public Banner setIndicatorRadius(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().v(i11);
        }
        return this;
    }

    public Banner setIndicatorSelectedColor(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().w(i11);
        }
        return this;
    }

    public Banner setIndicatorSelectedColorRes(int i11) {
        setIndicatorSelectedColor(z2.a.getColor(getContext(), i11));
        return this;
    }

    public Banner setIndicatorSelectedWidth(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().x(i11);
        }
        return this;
    }

    public Banner setIndicatorSpace(int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().r(i11);
        }
        return this;
    }

    public Banner setIndicatorWidth(int i11, int i12) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().u(i11);
            getIndicatorConfig().x(i12);
        }
        return this;
    }

    public Banner setIntercept(boolean z11) {
        this.L = z11;
        return this;
    }

    public Banner setLoopTime(long j11) {
        this.f50982k = j11;
        return this;
    }

    public Banner setOnBannerListener(lr.a<T> aVar) {
        if (getAdapter() != null) {
            getAdapter().j(aVar);
        }
        return this;
    }

    public Banner setOrientation(int i11) {
        getViewPager2().setOrientation(i11);
        return this;
    }

    public Banner setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public void setRecyclerViewPadding(int i11) {
        r(i11, i11);
    }

    public Banner setScrollTime(int i11) {
        this.f50983l = i11;
        return this;
    }

    public Banner setStartPosition(int i11) {
        this.f50984m = i11;
        return this;
    }

    public Banner setTouchSlop(int i11) {
        this.H = i11;
        return this;
    }

    public Banner setUserInputEnabled(boolean z11) {
        getViewPager2().setUserInputEnabled(z11);
        return this;
    }

    public Banner start() {
        if (this.f50981j) {
            stop();
            postDelayed(this.f50974b, this.f50982k);
        }
        return this;
    }

    public Banner stop() {
        if (this.f50981j) {
            removeCallbacks(this.f50974b);
        }
        return this;
    }
}
