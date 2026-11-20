package com.transsion.home.adapter.suboperate.provider;

import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.gslb.Utils;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubHorizontalBannerProvider extends BaseItemProvider<OperateItem> implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BaseHomeSubFragment<?> f52131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f52132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f52133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager2 f52134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f52135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f52136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f52137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f52138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q1 f52139o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OperateItem f52140p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SubHorizontalViewPagerAdapter f52141q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f52142r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateItem f52143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubHorizontalBannerProvider f52144b;

        public a(OperateItem operateItem, SubHorizontalBannerProvider subHorizontalBannerProvider) {
            this.f52143a = operateItem;
            this.f52144b = subHorizontalBannerProvider;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            List<BannerData> banners;
            BannerData bannerData;
            Image image;
            String averageHueLight;
            List<BannerData> banners2;
            BannerBean banner = this.f52143a.getBanner();
            if (banner != null && Intrinsics.b(banner.getAutoPlay(), Boolean.TRUE)) {
                Handler handler = this.f52144b.f52133i;
                if (handler != null) {
                    handler.removeCallbacks(this.f52144b.f52142r);
                }
                Handler handler2 = this.f52144b.f52133i;
                if (handler2 != null) {
                    handler2.postDelayed(this.f52144b.f52142r, this.f52144b.f52136l);
                }
            }
            this.f52144b.f52135k = i11;
            BannerBean banner2 = this.f52143a.getBanner();
            int size = i11 % ((banner2 == null || (banners2 = banner2.getBanners()) == null) ? 1 : banners2.size());
            BannerBean banner3 = this.f52143a.getBanner();
            if (banner3 != null && (banners = banner3.getBanners()) != null && (bannerData = banners.get(size)) != null && (image = bannerData.getImage()) != null && (averageHueLight = image.getAverageHueLight()) != null) {
                SubHorizontalBannerProvider subHorizontalBannerProvider = this.f52144b;
                View view = null;
                GradientDrawable gradientDrawableC = ot.a.c(kotlin.text.l.F(averageHueLight, Utils.SEPARATOR, "#ff", false, 4, null), kotlin.text.l.F(averageHueLight, Utils.SEPARATOR, "#00", false, 4, null), null, 4, null);
                View view2 = subHorizontalBannerProvider.f52137m;
                if (view2 == null) {
                    Intrinsics.y("bgColorView");
                } else {
                    view = view2;
                }
                view.setBackground(gradientDrawableC);
            }
            this.f52144b.H(this.f52143a, size);
        }
    }

    public SubHorizontalBannerProvider(int i11, BaseHomeSubFragment<?> fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f52130f = i11;
        this.f52131g = fragment;
        this.f52132h = new LinkedHashSet();
        this.f52135k = -1;
        this.f52136l = 5000L;
        this.f52142r = new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.m
            @Override // java.lang.Runnable
            public final void run() {
                SubHorizontalBannerProvider.I(this.f52196a);
            }
        };
    }

    private final void D() {
        Handler handler = this.f52133i;
        if (handler != null) {
            handler.postDelayed(this.f52142r, this.f52136l);
        }
    }

    private final boolean F(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f52132h.add(str);
    }

    private final void G() {
        if (this.f52130f != HomeTabId.Education.getValue()) {
            return;
        }
        this.f52139o = kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubHorizontalBannerProvider$registerCourse$1(this, null), 3, null);
    }

    public static final void I(SubHorizontalBannerProvider this$0) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.f52131g.isVisible()) {
            if (this$0.f52131g.isAdded()) {
                this$0.D();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = this$0.f52134j;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager3 = this$0.f52134j;
        if (viewPager3 == null) {
            Intrinsics.y("viewPager2");
            viewPager3 = null;
        }
        int currentItem = viewPager3.getCurrentItem() + 1;
        ViewPager2 viewPager4 = this$0.f52134j;
        if (viewPager4 == null) {
            Intrinsics.y("viewPager2");
            viewPager4 = null;
        }
        RecyclerView.Adapter adapter = viewPager4.getAdapter();
        Integer numValueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.d(numValueOf);
        viewPager2.setCurrentItem(currentItem % numValueOf.intValue());
    }

    private final void J() {
        q1 q1Var = this.f52139o;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f52139o = null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        List<BannerData> arrayList;
        String interval;
        Integer numL;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        this.f52134j = (ViewPager2) helper.getView(R$id.sub_operation_horizontal_view_pager);
        this.f52137m = helper.getView(R$id.sub_operation_banner_bg);
        int iMin = Math.min(d0.e(), d0.c()) - f0.a(112.0f);
        int i11 = (int) ((iMin * 9.0f) / 16);
        ViewPager2 viewPager2 = this.f52134j;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        viewPager2.getLayoutParams().height = i11;
        ((OperateScrollableHost) helper.getView(R$id.sub_operation_view_scroll_helper)).interceptAllEvent(true);
        int iN0 = this.f52131g.n0();
        helper.getView(R$id.sub_operation_banner_space).getLayoutParams().height = iN0;
        View view = this.f52137m;
        if (view == null) {
            Intrinsics.y("bgColorView");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewPager2 viewPager4 = this.f52134j;
        if (viewPager4 == null) {
            Intrinsics.y("viewPager2");
            viewPager4 = null;
        }
        layoutParams.height = iN0 + viewPager4.getLayoutParams().height;
        BannerBean banner = item.getBanner();
        if (banner == null || (arrayList = banner.getBanners()) == null) {
            arrayList = new ArrayList<>();
        }
        ViewPager2 viewPager5 = this.f52134j;
        if (viewPager5 == null) {
            Intrinsics.y("viewPager2");
            viewPager5 = null;
        }
        viewPager5.setPageTransformer(new CompositePageTransformer());
        ViewPager2 viewPager6 = this.f52134j;
        if (viewPager6 == null) {
            Intrinsics.y("viewPager2");
            viewPager6 = null;
        }
        viewPager6.setOffscreenPageLimit(3);
        ViewPager2 viewPager7 = this.f52134j;
        if (viewPager7 == null) {
            Intrinsics.y("viewPager2");
            viewPager7 = null;
        }
        viewPager7.setAdapter(new SubHorizontalViewPagerAdapter(arrayList, this.f52130f, item, iMin, i11));
        if (arrayList.isEmpty()) {
            return;
        }
        Handler handler = this.f52133i;
        if (handler != null) {
            handler.removeCallbacks(this.f52142r);
        }
        this.f52133i = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager8 = this.f52134j;
        if (viewPager8 == null) {
            Intrinsics.y("viewPager2");
            viewPager8 = null;
        }
        viewPager8.registerOnPageChangeCallback(new a(item, this));
        BannerBean banner2 = item.getBanner();
        long jIntValue = ((long) ((banner2 == null || (interval = banner2.getInterval()) == null || (numL = kotlin.text.k.l(interval)) == null) ? 0 : numL.intValue())) * 1000;
        if (jIntValue <= 0) {
            jIntValue = this.f52136l;
        }
        this.f52136l = jIntValue;
        int size = this.f52135k;
        if (size < 0) {
            size = 1073741823 - (1073741823 % arrayList.size());
        }
        ViewPager2 viewPager9 = this.f52134j;
        if (viewPager9 == null) {
            Intrinsics.y("viewPager2");
            viewPager9 = null;
        }
        viewPager9.setCurrentItem(size, false);
        ViewPager2 viewPager10 = this.f52134j;
        if (viewPager10 == null) {
            Intrinsics.y("viewPager2");
        } else {
            viewPager3 = viewPager10;
        }
        RecyclerView.Adapter adapter = viewPager3.getAdapter();
        Intrinsics.e(adapter, "null cannot be cast to non-null type com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter");
        this.f52141q = (SubHorizontalViewPagerAdapter) adapter;
        this.f52140p = item;
    }

    public final void H(OperateItem operateItem, int i11) {
        List<BannerData> banners;
        BannerBean banner = operateItem.getBanner();
        BannerData bannerData = (banner == null || (banners = banner.getBanners()) == null) ? null : banners.get(i11);
        if (F(bannerData != null ? bannerData.getSubjectId() : null)) {
            HashMap map = new HashMap();
            map.put("event_type", "browse_banner");
            map.put("sequence", String.valueOf(i11));
            map.put("tabId", String.valueOf(this.f52130f));
            if (bannerData != null) {
                ot.b.b(bannerData, map);
            }
            ot.b.a(operateItem, map);
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52130f), map);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.HORIZONTAL_BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_horizontal_banner;
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public void onPause(androidx.lifecycle.u owner) {
        Handler handler;
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.c(this, owner);
        if (!this.f52138n || (handler = this.f52133i) == null) {
            return;
        }
        handler.removeCallbacks(this.f52142r);
    }

    @Override // androidx.lifecycle.f
    public void onResume(androidx.lifecycle.u owner) {
        Handler handler;
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.d(this, owner);
        if (!this.f52138n || (handler = this.f52133i) == null) {
            return;
        }
        handler.postDelayed(this.f52142r, this.f52136l);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.e(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.f(this, uVar);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void p(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.p(holder);
        this.f52138n = true;
        Handler handler = this.f52133i;
        if (handler != null) {
            handler.postDelayed(this.f52142r, this.f52136l);
        }
        G();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        this.f52138n = false;
        Handler handler = this.f52133i;
        if (handler != null) {
            handler.removeCallbacks(this.f52142r);
        }
        J();
    }
}
