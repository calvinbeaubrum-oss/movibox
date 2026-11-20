package com.transsion.home.adapter.suboperate.provider;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.baseui.recycler.InterceptView;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter;
import com.transsion.home.adapter.suboperate.adapter.SubViewPagerAdapter;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadDialogShowEvent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class SubBannerProvider extends BaseItemProvider<OperateItem> implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BaseHomeSubFragment<?> f52097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f52098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f52099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager2 f52100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPager2 f52101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InterceptView f52102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f52103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f52104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f52105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SubViewPagerAdapter f52106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SubBannerChildPagerAdapter f52107q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SubViewPagerAdapter f52108r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f52109s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateItem f52110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubBannerProvider f52111b;

        public a(OperateItem operateItem, SubBannerProvider subBannerProvider) {
            this.f52110a = operateItem;
            this.f52111b = subBannerProvider;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            BannerBean banner = this.f52110a.getBanner();
            if (banner != null && Intrinsics.b(banner.getAutoPlay(), Boolean.TRUE)) {
                Handler handler = this.f52111b.f52099i;
                if (handler != null) {
                    handler.removeCallbacks(this.f52111b.f52109s);
                }
                Handler handler2 = this.f52111b.f52099i;
                if (handler2 != null) {
                    handler2.postDelayed(this.f52111b.f52109s, this.f52111b.f52104n);
                }
            }
            boolean z11 = this.f52111b.f52103m != -1;
            this.f52111b.f52103m = i11;
            this.f52111b.O(i11, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            int iH = SubBannerProvider.this.H();
            if (iH != -1) {
                SubBannerProvider.this.M(iH);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f52113a;

        public c(BaseViewHolder baseViewHolder) {
            this.f52113a = baseViewHolder;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = this.f52113a.itemView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.TRENDING_END, 0L, 2, null));
            return true;
        }
    }

    public SubBannerProvider(int i11, BaseHomeSubFragment<?> fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f52096f = i11;
        this.f52097g = fragment;
        this.f52098h = new LinkedHashSet();
        this.f52103m = -1;
        this.f52104n = 5000L;
        L();
        this.f52109s = new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.d
            @Override // java.lang.Runnable
            public final void run() {
                SubBannerProvider.N(this.f52177a);
            }
        };
    }

    public static final void N(SubBannerProvider this$0) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.f52097g.isVisible()) {
            if (this$0.f52097g.isAdded()) {
                this$0.F();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = this$0.f52100j;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager3 = this$0.f52100j;
        if (viewPager3 == null) {
            Intrinsics.y("viewPager2");
            viewPager3 = null;
        }
        int currentItem = viewPager3.getCurrentItem() + 1;
        ViewPager2 viewPager4 = this$0.f52100j;
        if (viewPager4 == null) {
            Intrinsics.y("viewPager2");
            viewPager4 = null;
        }
        RecyclerView.Adapter adapter = viewPager4.getAdapter();
        Integer numValueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.d(numValueOf);
        viewPager2.setCurrentItem(currentItem % numValueOf.intValue());
    }

    public final List<BannerData> E(List<BannerData> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            BannerData bannerData = (BannerData) obj;
            if ((bannerData != null ? bannerData.getAdData() : null) == null) {
                arrayList.add(obj);
            }
        }
        final List<BannerData> listM0 = CollectionsKt___CollectionsKt.M0(arrayList);
        if (listM0.isEmpty()) {
            return listM0;
        }
        BannerADDataHelper.f52219a.e(new Function2<AdPlans, Integer, Unit>() { // from class: com.transsion.home.adapter.suboperate.provider.SubBannerProvider$checkAdData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AdPlans adPlans, Integer num) {
                invoke(adPlans, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(AdPlans adPlans, int i11) {
                if (adPlans == null) {
                    return;
                }
                if (listM0.size() > i11) {
                    listM0.add(i11, new BannerData(null, null, null, 0, false, null, 0, null, null, null, null, adPlans, 2047, null));
                } else {
                    listM0.add(new BannerData(null, null, null, 0, false, null, 0, null, null, null, null, adPlans, 2047, null));
                }
            }
        });
        return listM0;
    }

    public final void F() {
        Handler handler = this.f52099i;
        if (handler != null) {
            handler.postDelayed(this.f52109s, this.f52104n);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        List<BannerData> arrayList;
        String interval;
        Integer numL;
        List<BannerData> banners;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        View viewFindViewById = helper.itemView.findViewById(R$id.sub_operation_view_pager);
        Intrinsics.f(viewFindViewById, "helper.itemView.findView…sub_operation_view_pager)");
        this.f52100j = (ViewPager2) viewFindViewById;
        this.f52101k = (ViewPager2) helper.getView(R$id.cardPager);
        InterceptView interceptView = (InterceptView) helper.getView(R$id.interestLayout);
        this.f52102l = interceptView;
        ViewPager2 viewPager2 = null;
        if (interceptView == null) {
            Intrinsics.y("interestLayout");
            interceptView = null;
        }
        ViewPager2 viewPager3 = this.f52101k;
        if (viewPager3 == null) {
            Intrinsics.y("cardPager");
            viewPager3 = null;
        }
        interceptView.setPostView(viewPager3);
        ((OperateScrollableHost) helper.getView(R$id.sub_operation_view_scroll_helper)).interceptAllEvent(true);
        ((OperateScrollableHost) helper.getView(R$id.sub_operation_card_helper)).interceptAllEvent(true);
        BannerBean banner = item.getBanner();
        if (banner == null || (banners = banner.getBanners()) == null || (arrayList = CollectionsKt___CollectionsKt.M0(banners)) == null) {
            arrayList = new ArrayList<>();
        }
        List<BannerData> listE = E(arrayList);
        BannerBean banner2 = item.getBanner();
        if (banner2 != null) {
            banner2.setBanners(listE);
        }
        if (listE.isEmpty()) {
            return;
        }
        SubViewPagerAdapter subViewPagerAdapter = this.f52108r;
        if (subViewPagerAdapter == null) {
            this.f52108r = new SubViewPagerAdapter(listE, this.f52096f, this, item);
        } else if (subViewPagerAdapter != null) {
            subViewPagerAdapter.g(listE);
        }
        this.f52106p = this.f52108r;
        ViewPager2 viewPager4 = this.f52100j;
        if (viewPager4 == null) {
            Intrinsics.y("viewPager2");
            viewPager4 = null;
        }
        viewPager4.setAdapter(this.f52106p);
        J(listE, item);
        Handler handler = this.f52099i;
        if (handler != null) {
            handler.removeCallbacks(this.f52109s);
        }
        this.f52099i = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager5 = this.f52100j;
        if (viewPager5 == null) {
            Intrinsics.y("viewPager2");
            viewPager5 = null;
        }
        viewPager5.registerOnPageChangeCallback(new a(item, this));
        BannerBean banner3 = item.getBanner();
        long jIntValue = ((long) ((banner3 == null || (interval = banner3.getInterval()) == null || (numL = kotlin.text.k.l(interval)) == null) ? 0 : numL.intValue())) * 1000;
        if (jIntValue <= 0) {
            jIntValue = this.f52104n;
        }
        this.f52104n = jIntValue;
        int I = this.f52103m;
        if (I < 0) {
            I = I(listE.size());
        }
        ViewPager2 viewPager6 = this.f52100j;
        if (viewPager6 == null) {
            Intrinsics.y("viewPager2");
            viewPager6 = null;
        }
        viewPager6.setCurrentItem(I, false);
        ViewPager2 viewPager7 = this.f52101k;
        if (viewPager7 == null) {
            Intrinsics.y("cardPager");
        } else {
            viewPager2 = viewPager7;
        }
        viewPager2.setCurrentItem(I, false);
    }

    public final int H() {
        ViewPager2 viewPager2 = this.f52101k;
        if (viewPager2 == null) {
            Intrinsics.y("cardPager");
            viewPager2 = null;
        }
        return viewPager2.getCurrentItem();
    }

    public final int I(int i11) {
        return 1073741823 - (1073741823 % i11);
    }

    public final void J(List<BannerData> list, OperateItem operateItem) {
        ViewPager2 viewPager2 = this.f52101k;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.y("cardPager");
            viewPager2 = null;
        }
        viewPager2.setPageTransformer(new CompositePageTransformer());
        ViewPager2 viewPager4 = this.f52101k;
        if (viewPager4 == null) {
            Intrinsics.y("cardPager");
            viewPager4 = null;
        }
        viewPager4.setOffscreenPageLimit(3);
        this.f52107q = new SubBannerChildPagerAdapter(list, this.f52096f, operateItem);
        ViewPager2 viewPager5 = this.f52101k;
        if (viewPager5 == null) {
            Intrinsics.y("cardPager");
            viewPager5 = null;
        }
        viewPager5.setAdapter(this.f52107q);
        ViewPager2 viewPager6 = this.f52101k;
        if (viewPager6 == null) {
            Intrinsics.y("cardPager");
        } else {
            viewPager3 = viewPager6;
        }
        viewPager3.registerOnPageChangeCallback(new b());
    }

    public final boolean K(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f52098h.add(str);
    }

    public final void L() {
        BaseHomeSubFragment<?> baseHomeSubFragment = this.f52097g;
        Function1<DownloadDialogShowEvent, Unit> function1 = new Function1<DownloadDialogShowEvent, Unit>() { // from class: com.transsion.home.adapter.suboperate.provider.SubBannerProvider$observeDownloadDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadDialogShowEvent downloadDialogShowEvent) {
                invoke2(downloadDialogShowEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadDialogShowEvent value) {
                Intrinsics.g(value, "value");
                if (this.this$0.f52105o) {
                    if (value.getShow()) {
                        Handler handler = this.this$0.f52099i;
                        if (handler != null) {
                            handler.removeCallbacks(this.this$0.f52109s);
                            return;
                        }
                        return;
                    }
                    Handler handler2 = this.this$0.f52099i;
                    if (handler2 != null) {
                        handler2.postDelayed(this.this$0.f52109s, this.this$0.f52104n);
                    }
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(baseHomeSubFragment, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void M(int i11) {
        ViewPager2 viewPager2 = this.f52100j;
        ViewPager2 viewPager3 = null;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        if (i11 != viewPager2.getCurrentItem()) {
            ViewPager2 viewPager4 = this.f52100j;
            if (viewPager4 == null) {
                Intrinsics.y("viewPager2");
            } else {
                viewPager3 = viewPager4;
            }
            viewPager3.setCurrentItem(i11, true);
        }
    }

    public final void O(int i11, boolean z11) {
        if (i11 != H()) {
            ViewPager2 viewPager2 = this.f52101k;
            if (viewPager2 == null) {
                Intrinsics.y("cardPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(i11, z11);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_banner;
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
        if (!this.f52105o || (handler = this.f52099i) == null) {
            return;
        }
        handler.removeCallbacks(this.f52109s);
    }

    @Override // androidx.lifecycle.f
    public void onResume(androidx.lifecycle.u owner) {
        Handler handler;
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.d(this, owner);
        if (!this.f52105o || (handler = this.f52099i) == null) {
            return;
        }
        handler.postDelayed(this.f52109s, this.f52104n);
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
        this.f52105o = true;
        Handler handler = this.f52099i;
        if (handler != null) {
            handler.postDelayed(this.f52109s, this.f52104n);
        }
        holder.itemView.getViewTreeObserver().addOnPreDrawListener(new c(holder));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        this.f52105o = false;
        Handler handler = this.f52099i;
        if (handler != null) {
            handler.removeCallbacks(this.f52109s);
        }
    }
}
