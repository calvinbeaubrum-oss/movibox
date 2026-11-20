package com.transsion.home.fragment;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.fragment.tab.EmptyFragment;
import com.transsion.home.fragment.tab.MovieFragment;
import com.transsion.home.fragment.tab.SubShortTvFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.fragment.tab.TopRoomFragment;
import com.transsion.home.fragment.tab.TrendingFragment;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.view.SearchGuideDialog;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.web.api.WebConstants;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class HomeFragment extends BaseFragment<lt.k> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f52386l = new a(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f52387m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f52388n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppTab f52389a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TrendingFragment f52391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f52392d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HomeSearchViewManager f52394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bundle f52395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f52396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f52397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f52398k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f52390b = f52388n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f52393f = "{\"country\":\"All\",\"year\":\"All\",\"genre\":\"All\",\"sort\":\"ForYou\"}";

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52399a;

        static {
            int[] iArr = new int[HomeTabType.values().length];
            try {
                iArr[HomeTabType.SUB_OPERATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeTabType.SUBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HomeTabType.H5TAB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HomeTabType.TRENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HomeTabType.SHORT_TV_TAB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HomeTabType.SUB_ROOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f52399a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        public static final void b(HomeFragment this$0, int i11) {
            MagicIndicator magicIndicator;
            Intrinsics.g(this$0, "this$0");
            lt.k mViewBinding = this$0.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f70461i) == null) {
                return;
            }
            magicIndicator.onPageSelected(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            lt.k mViewBinding = HomeFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f70461i) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            lt.k mViewBinding = HomeFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f70461i) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i11) {
            MagicIndicator magicIndicator;
            String name;
            List<HomeTabItem> homeTabs;
            List<HomeTabItem> homeTabs2;
            super.onPageSelected(i11);
            if (HomeFragment.this.f52396i || i11 < 0) {
                return;
            }
            AppTab appTab = HomeFragment.this.f52389a;
            HomeTabItem homeTabItem = (appTab == null || (homeTabs2 = appTab.getHomeTabs()) == null) ? null : homeTabs2.get(i11);
            if (homeTabItem == null || !homeTabItem.isOpenLandPage()) {
                HomeFragment.this.f52397j = i11;
                lt.k mViewBinding = HomeFragment.this.getMViewBinding();
                if (mViewBinding != null && (magicIndicator = mViewBinding.f70461i) != null) {
                    final HomeFragment homeFragment = HomeFragment.this;
                    magicIndicator.post(new Runnable() { // from class: com.transsion.home.fragment.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeFragment.c.b(homeFragment, i11);
                        }
                    });
                }
            } else {
                HomeFragment.this.f52396i = true;
                com.transsion.baselib.utils.i.e(homeTabItem.getUrl(), null, 1, null);
            }
            AppTab appTab2 = HomeFragment.this.f52389a;
            HomeTabItem homeTabItem2 = (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null) ? null : homeTabs.get(i11);
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
            String strX0 = HomeFragment.this.x0();
            if (homeTabItem2 == null || (name = homeTabItem2.getName()) == null) {
                name = "";
            }
            aVar.l(strX0, name);
            HomeFragment.this.f52390b = i11;
            if (HomeFragment.this.isAdded()) {
                Fragment fragmentFindFragmentByTag = HomeFragment.this.getChildFragmentManager().findFragmentByTag("f" + HomeFragment.this.f52390b);
                if (fragmentFindFragmentByTag instanceof BaseHomeSubFragment) {
                    ((BaseHomeSubFragment) fragmentFindFragmentByTag).u0();
                } else {
                    HomeFragment.this.s0(false);
                }
            }
            if (Intrinsics.b(homeTabItem2 != null ? homeTabItem2.getTabCode() : null, "Education")) {
                CourseManager courseManager = CourseManager.f51853a;
                FragmentManager supportFragmentManager = HomeFragment.this.requireActivity().getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "requireActivity().supportFragmentManager");
                courseManager.e(supportFragmentManager);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class d extends FragmentStateAdapter {
        public d() {
            super(HomeFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return HomeFragment.this.t0(i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<HomeTabItem> homeTabs;
            AppTab appTab = HomeFragment.this.f52389a;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                return 0;
            }
            return homeTabs.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class e implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52402a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52402a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52402a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52402a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class f implements com.tn.lib.util.networkinfo.g {
        public f() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            HomeSearchViewManager homeSearchViewManager = HomeFragment.this.f52394g;
            if (homeSearchViewManager != null) {
                homeSearchViewManager.H(network, networkCapabilities);
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    public static final void E0(HomeFragment this$0, int i11) {
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        Intrinsics.g(this$0, "this$0");
        if (this$0.isAdded()) {
            lt.k mViewBinding = this$0.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f70461i) != null) {
                magicIndicator.onPageSelected(i11);
            }
            lt.k mViewBinding2 = this$0.getMViewBinding();
            if (mViewBinding2 != null && (viewPager2 = mViewBinding2.f70468p) != null) {
                viewPager2.setCurrentItem(i11, false);
            }
            this$0.f52396i = false;
            this$0.f52390b = i11;
            this$0.s0(false);
        }
    }

    private final void F0() {
        A0();
        G0();
    }

    private final void initViewPager() {
        if (isAdded()) {
            uo.b.a.f(uo.b.f78622a, "HomeFragment", "fragment count " + getChildFragmentManager().getFragments().size(), false, 4, null);
            lt.k mViewBinding = getMViewBinding();
            ViewPager2 viewPager2 = mViewBinding != null ? mViewBinding.f70468p : null;
            if (viewPager2 != null) {
                viewPager2.setAdapter(new d());
            }
            r0();
        }
    }

    private final void r0() {
        ViewPager2 viewPager2;
        List<HomeTabItem> homeTabs;
        ViewPager2 viewPager3;
        lt.k mViewBinding = getMViewBinding();
        if (mViewBinding != null && (viewPager3 = mViewBinding.f70468p) != null) {
            viewPager3.registerOnPageChangeCallback(new c());
        }
        AppTab appTab = this.f52389a;
        if (appTab != null && (homeTabs = appTab.getHomeTabs()) != null) {
            int i11 = 0;
            for (Object obj : homeTabs) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                HomeTabItem homeTabItem = (HomeTabItem) obj;
                if (Intrinsics.b(homeTabItem != null ? homeTabItem.getTabCode() : null, HomeTabType.TAB_CODE_TRENDING)) {
                    f52388n = i11;
                    this.f52390b = i11;
                }
                i11 = i12;
            }
        }
        lt.k mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (viewPager2 = mViewBinding2.f70468p) != null) {
            viewPager2.setCurrentItem(this.f52390b, false);
        }
        lt.k mViewBinding3 = getMViewBinding();
        ViewPager2 viewPager4 = mViewBinding3 != null ? mViewBinding3.f70468p : null;
        if (viewPager4 == null) {
            return;
        }
        viewPager4.setOffscreenPageLimit(1);
    }

    public final void A0() {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            Intrinsics.f(declaredField, "ViewPager2::class.java.g…redField(\"mRecyclerView\")");
            declaredField.setAccessible(true);
            lt.k mViewBinding = getMViewBinding();
            Object obj = declaredField.get(mViewBinding != null ? mViewBinding.f70468p : null);
            Intrinsics.e(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            Intrinsics.f(declaredField2, "RecyclerView::class.java…claredField(\"mTouchSlop\")");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 2));
            uo.b.a.f(uo.b.f78622a, "invoke", "testOver", false, 4, null);
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, "invoke", "Exception " + e11.getMessage(), false, 4, null);
        }
    }

    public final boolean B0() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("f" + this.f52390b);
        return (fragmentFindFragmentByTag instanceof WebFragmentV2) && ((WebFragmentV2) fragmentFindFragmentByTag).X0();
    }

    public final void C0() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("f" + this.f52390b);
        if (fragmentFindFragmentByTag instanceof BaseHomeSubFragment) {
            ((BaseHomeSubFragment) fragmentFindFragmentByTag).v0();
        }
    }

    public final void D0() {
        ConstraintLayout root;
        final int i11 = this.f52397j;
        lt.k mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.E0(this.f52438a, i11);
            }
        }, 1000L);
    }

    public final void G0() {
        setNetListener(new f());
    }

    public final void H0(int i11) {
        this.f52390b = i11;
    }

    public final void I0() {
        if (com.transsion.home.view.g.f52730a.a()) {
            SearchGuideDialog searchGuideDialogB = SearchGuideDialog.f52680g.b();
            searchGuideDialogB.p0(new Function0<Unit>() { // from class: com.transsion.home.fragment.HomeFragment$showSearchGuideDialogIfNeed$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    com.transsion.home.view.g.d(com.transsion.home.view.g.f52730a, false, 1, null);
                    es.b bVar = (es.b) es.a.f64348a.a(es.b.class);
                    if (bVar == null) {
                        return null;
                    }
                    Context contextRequireContext = this.this$0.requireContext();
                    Intrinsics.f(contextRequireContext, "this.requireContext()");
                    bVar.c("", contextRequireContext);
                    return Unit.f68710a;
                }
            });
            HomeSearchViewManager homeSearchViewManager = this.f52394g;
            searchGuideDialogB.r0(homeSearchViewManager != null ? homeSearchViewManager.p() : null);
            searchGuideDialogB.k0(this, "search_guide");
            uo.b.a.f(uo.b.f78622a, "HomeFragment", "show dialog for search guide", false, 4, null);
        }
    }

    public final void J0(String tabCode, int i11) {
        ViewPager2 viewPager2;
        Intrinsics.g(tabCode, "tabCode");
        int iV0 = v0(tabCode, i11);
        lt.k mViewBinding = getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.f70468p) == null) {
            return;
        }
        viewPager2.setCurrentItem(iV0, false);
    }

    public final void K0() {
        ViewPager2 viewPager2;
        TrendingFragment trendingFragment = this.f52391c;
        if (trendingFragment != null) {
            trendingFragment.M1();
        }
        lt.k mViewBinding = getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.f70468p) == null) {
            return;
        }
        viewPager2.setCurrentItem(f52388n, false);
    }

    public final void L0(AppTab appTab) {
        List<HomeTabItem> homeTabs;
        List<HomeTabItem> homeTabs2;
        List<HomeTabItem> homeTabs3;
        HomeTabItem homeTabItem;
        HomeTabItem homeTabItem2;
        if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null || homeTabs.size() <= 0) {
            return;
        }
        String version = appTab.getVersion();
        AppTab appTab2 = this.f52389a;
        if (Intrinsics.b(version, appTab2 != null ? appTab2.getVersion() : null)) {
            List<HomeTabItem> homeTabs4 = appTab.getHomeTabs();
            String name = (homeTabs4 == null || (homeTabItem2 = homeTabs4.get(0)) == null) ? null : homeTabItem2.getName();
            AppTab appTab3 = this.f52389a;
            if (Intrinsics.b(name, (appTab3 == null || (homeTabs3 = appTab3.getHomeTabs()) == null || (homeTabItem = homeTabs3.get(0)) == null) ? null : homeTabItem.getName())) {
                List<HomeTabItem> homeTabs5 = appTab.getHomeTabs();
                Integer numValueOf = homeTabs5 != null ? Integer.valueOf(homeTabs5.size()) : null;
                AppTab appTab4 = this.f52389a;
                if (Intrinsics.b(numValueOf, (appTab4 == null || (homeTabs2 = appTab4.getHomeTabs()) == null) ? null : Integer.valueOf(homeTabs2.size()))) {
                    return;
                }
            }
        }
        this.f52389a = appTab;
        this.f52391c = null;
        initViewPager();
        HomeSearchViewManager homeSearchViewManager = this.f52394g;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.N(appTab);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        DownloadSDCardUtil.f61130a.c();
        VideoFloatManager.f60019a.b().d();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        v.a(this);
        this.f52395h = bundle;
        this.f52390b = bundle != null ? bundle.getInt("current_tab", f52388n) : this.f52390b;
        z0();
        F0();
        lt.k mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            HomeSearchViewManager homeSearchViewManager = new HomeSearchViewManager(mViewBinding, this);
            this.f52394g = homeSearchViewManager;
            homeSearchViewManager.C(this.f52389a);
        }
        if (Build.VERSION.SDK_INT <= 23) {
            lt.k mViewBinding2 = getMViewBinding();
            BlurredSectorView blurredSectorView = mViewBinding2 != null ? mViewBinding2.f70464l : null;
            if (blurredSectorView == null) {
                return;
            }
            blurredSectorView.setVisibility(8);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.f52398k != 0) {
            FirebaseAnalyticsManager.f51235a.o("home", Long.valueOf(SystemClock.elapsedRealtime() - this.f52398k), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.f52398k = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void newIntent(Intent intent) {
        String stringExtra;
        super.newIntent(intent);
        try {
            if (!isAdded()) {
                setArguments(intent != null ? intent.getExtras() : null);
                return;
            }
            if (intent == null || (stringExtra = intent.getStringExtra("topTab")) == null) {
                stringExtra = HomeTabType.TAB_CODE_TRENDING;
            }
            this.f52390b = v0(stringExtra, intent != null ? intent.getIntExtra("secondTabIndex", -1) : -1);
            lt.k mViewBinding = getMViewBinding();
            ViewPager2 viewPager2 = mViewBinding != null ? mViewBinding.f70468p : null;
            if (viewPager2 == null) {
                return;
            }
            viewPager2.setCurrentItem(this.f52390b);
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, "HomeFragment", "error= " + e11.getMessage(), false, 4, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DownloadSDCardUtil.f61130a.e();
        PreloadTrendingData.f52790o.a().x().p(this);
        HomeSearchViewManager homeSearchViewManager = this.f52394g;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.K();
        }
        HomeSearchViewManager homeSearchViewManager2 = this.f52394g;
        if (homeSearchViewManager2 != null) {
            homeSearchViewManager2.o();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
                HomeSearchViewManager homeSearchViewManager = this.f52394g;
                if (homeSearchViewManager != null) {
                    homeSearchViewManager.K();
                }
            } else {
                logResume();
                HomeSearchViewManager homeSearchViewManager2 = this.f52394g;
                if (homeSearchViewManager2 != null) {
                    homeSearchViewManager2.L(true);
                }
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
        uo.b.f78622a.d("onPause fragment count " + getChildFragmentManager().getFragments().size(), true);
        HomeSearchViewManager homeSearchViewManager = this.f52394g;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.K();
        }
        if (this.f52396i) {
            D0();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible() + " fragment:" + this, 1, null);
        HomeSearchViewManager homeSearchViewManager = this.f52394g;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.L(true);
        }
        Bundle bundle = this.f52395h;
        Integer numValueOf = bundle != null ? Integer.valueOf(bundle.getInt("saved_search_color", 2)) : null;
        if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 1)) {
            Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("f" + this.f52390b);
            if (fragmentFindFragmentByTag instanceof BaseHomeSubFragment) {
                ((BaseHomeSubFragment) fragmentFindFragmentByTag).g0(numValueOf != null && numValueOf.intValue() == 1);
            } else {
                s0(numValueOf != null && numValueOf.intValue() == 1);
            }
            this.f52395h = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("current_tab", this.f52390b);
        HomeSearchViewManager homeSearchViewManager = this.f52394g;
        int i11 = 0;
        if (homeSearchViewManager != null && homeSearchViewManager.D()) {
            i11 = 1;
        }
        outState.putInt("saved_search_color", i11);
    }

    public final void s0(boolean z11) {
        FragmentActivity activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null) {
            baseActivity.changeStatusFontColor(z11, true);
        }
        HomeSearchViewManager homeSearchViewManager = this.f52394g;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.m(z11);
        }
    }

    public final Fragment t0(int i11) {
        Integer tabId;
        Integer tabId2;
        Integer tabId3;
        String str;
        List<HomeTabItem> homeTabs;
        AppTab appTab = this.f52389a;
        HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : homeTabs.get(i11);
        uo.b.a aVar = uo.b.f78622a;
        int iIntValue = 1;
        aVar.c("HomeFragment", "getFragment: " + (homeTabItem != null ? homeTabItem.getType() : null) + "&position:" + i11 + "&tabCode:" + (homeTabItem != null ? homeTabItem.getTabCode() : null) + "&displayType:" + (homeTabItem != null ? homeTabItem.getDisplayType() : null), true);
        HomeTabType.a aVar2 = HomeTabType.Companion;
        if (aVar2.a(homeTabItem != null ? homeTabItem.getType() : null) == HomeTabType.SUB_NOVEL) {
            cs.a aVar3 = cs.a.f62808a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            aVar3.d(applicationA);
        }
        if (homeTabItem != null && homeTabItem.isOpenLandPage()) {
            uo.b.a.f(aVar, "HomeFragment", "getFragment isOpenLandPage", false, 4, null);
            return new EmptyFragment();
        }
        HomeTabType homeTabTypeA = aVar2.a(homeTabItem != null ? homeTabItem.getType() : null);
        switch (homeTabTypeA == null ? -1 : b.f52399a[homeTabTypeA.ordinal()]) {
            case 1:
                SubTabFragment.a aVar4 = SubTabFragment.f52541r;
                if (homeTabItem != null && (tabId = homeTabItem.getTabId()) != null) {
                    iIntValue = tabId.intValue();
                }
                return aVar4.b(iIntValue, homeTabItem != null ? homeTabItem.getTabCode() : null);
            case 2:
                return MovieFragment.a.b(MovieFragment.A, (homeTabItem == null || (tabId2 = homeTabItem.getTabId()) == null) ? 1 : tabId2.intValue(), false, null, homeTabItem != null ? homeTabItem.getTabCode() : null, 6, null);
            case 3:
                WebFragmentV2 webFragmentV2B = WebFragmentV2.f60174r.b();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.a("url", homeTabItem != null ? homeTabItem.getUrl() : null);
                Boolean bool = Boolean.TRUE;
                pairArr[1] = TuplesKt.a(WebConstants.FIELD_TOOL_BAR_HIDDEN, bool);
                pairArr[2] = TuplesKt.a(WebConstants.TAB_CODE, homeTabItem != null ? homeTabItem.getTabCode() : null);
                pairArr[3] = TuplesKt.a(WebConstants.NEED_HEADER, bool);
                pairArr[4] = TuplesKt.a(WebConstants.HEADER_BG, Integer.valueOf(R$drawable.home_title_gradient_bg));
                webFragmentV2B.setArguments(androidx.core.os.c.b(pairArr));
                return webFragmentV2B;
            case 4:
                TrendingFragment trendingFragment = this.f52391c;
                if (trendingFragment != null) {
                    Intrinsics.d(trendingFragment);
                    return trendingFragment;
                }
                TrendingFragment.a aVar5 = TrendingFragment.f52560y;
                if (homeTabItem != null && (tabId3 = homeTabItem.getTabId()) != null) {
                    iIntValue = tabId3.intValue();
                }
                TrendingFragment trendingFragmentA = aVar5.a(iIntValue, homeTabItem != null ? homeTabItem.getTabCode() : null);
                this.f52391c = trendingFragmentA;
                if (trendingFragmentA != null) {
                    trendingFragmentA.R1(new Function0<Unit>() { // from class: com.transsion.home.fragment.HomeFragment$getFragmentByType$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            this.this$0.I0();
                        }
                    });
                }
                TrendingFragment trendingFragment2 = this.f52391c;
                Intrinsics.d(trendingFragment2);
                return trendingFragment2;
            case 5:
                return new SubShortTvFragment();
            case 6:
                return new TopRoomFragment();
            default:
                Fragment fragmentU0 = u0(i11);
                if (!(fragmentU0 instanceof MovieFragment) || (str = this.f52392d) == null || str.length() <= 0) {
                    return fragmentU0;
                }
                ((MovieFragment) fragmentU0).O1(this.f52392d, this.f52393f);
                return fragmentU0;
        }
    }

    public final Fragment u0(int i11) {
        Integer tabId;
        List<HomeTabItem> homeTabs;
        AppTab appTab = this.f52389a;
        HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : homeTabs.get(i11);
        return MovieFragment.a.b(MovieFragment.A, (homeTabItem == null || (tabId = homeTabItem.getTabId()) == null) ? 1 : tabId.intValue(), false, null, homeTabItem != null ? homeTabItem.getTabCode() : null, 6, null);
    }

    public final int v0(String str, int i11) {
        List<HomeTabItem> homeTabs;
        AppTab appTab;
        List<HomeTabItem> homeTabs2;
        Integer tabId;
        int i12 = 0;
        if (i11 >= 0 && (appTab = this.f52389a) != null && (homeTabs2 = appTab.getHomeTabs()) != null) {
            int i13 = 0;
            for (Object obj : homeTabs2) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    kotlin.collections.g.u();
                }
                HomeTabItem homeTabItem = (HomeTabItem) obj;
                if (homeTabItem != null && (tabId = homeTabItem.getTabId()) != null && tabId.intValue() == i11) {
                    return i13;
                }
                i13 = i14;
            }
        }
        AppTab appTab2 = this.f52389a;
        if (appTab2 != null && (homeTabs = appTab2.getHomeTabs()) != null) {
            for (Object obj2 : homeTabs) {
                int i15 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                HomeTabItem homeTabItem2 = (HomeTabItem) obj2;
                if (Intrinsics.b(homeTabItem2 != null ? homeTabItem2.getTabCode() : null, str)) {
                    return i12;
                }
                i12 = i15;
            }
        }
        return f52388n;
    }

    public final int w0() {
        return this.f52390b;
    }

    public final String x0() {
        HomeTabItem homeTabItem;
        String tabCode;
        AppTab appTab = this.f52389a;
        List<HomeTabItem> homeTabs = appTab != null ? appTab.getHomeTabs() : null;
        int i11 = this.f52390b;
        if (i11 >= 0) {
            return (i11 >= (homeTabs != null ? homeTabs.size() : 0) || homeTabs == null || (homeTabItem = homeTabs.get(this.f52390b)) == null || (tabCode = homeTabItem.getTabCode()) == null) ? "" : tabCode;
        }
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public lt.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.k kVarC = lt.k.c(inflater);
        Intrinsics.f(kVarC, "inflate(inflater)");
        return kVarC;
    }

    public final void z0() {
        List<HomeTabItem> homeTabs;
        PreloadTrendingData.a aVar = PreloadTrendingData.f52790o;
        AppTab appTabF = aVar.a().w().f();
        this.f52389a = appTabF;
        uo.b.a.f(uo.b.f78622a, "HomeFragment", "homeTabFromCache = " + appTabF, false, 4, null);
        if (this.f52389a == null) {
            aVar.a().w().j(getViewLifecycleOwner(), new e(new Function1<AppTab, Unit>() { // from class: com.transsion.home.fragment.HomeFragment$initHomeTab$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AppTab appTab) {
                    invoke2(appTab);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppTab appTab) {
                    uo.b.a.f(uo.b.f78622a, "HomeFragment", "homeTabFromCache2 = " + appTab, false, 4, null);
                    if (this.this$0.isAdded()) {
                        this.this$0.L0(appTab);
                    }
                    PreloadTrendingData.f52790o.a().w().p(this.this$0);
                }
            }));
        }
        aVar.a().x().p(this);
        aVar.a().x().j(getViewLifecycleOwner(), new e(new HomeFragment$initHomeTab$2(this)));
        AppTab appTab = this.f52389a;
        if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null || !(!homeTabs.isEmpty())) {
            return;
        }
        initViewPager();
    }
}
