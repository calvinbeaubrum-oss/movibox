package com.transsion.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.f0;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.home.R$layout;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.HotSearchKeyWord;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.fragment.tab.CustomTabAdView;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.startup.pref.al.UpdateUtils;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DiffUpdateResultEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

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
public final class HomeSearchViewManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lt.k f52406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HomeFragment f52407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HomeGameCenterProvider f52408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f52409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<String> f52410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f52411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f52412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonNavigator f52413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f52414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f52415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ConstraintLayout.b f52416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f52417l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends h20.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AppTab f52418b;

        /* JADX INFO: renamed from: com.transsion.home.fragment.HomeSearchViewManager$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0572a extends com.transsion.baseui.util.f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ HomeSearchViewManager f52420f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f52421g;

            public C0572a(HomeSearchViewManager homeSearchViewManager, int i11) {
                this.f52420f = homeSearchViewManager;
                this.f52421g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                this.f52420f.f52407b.H0(this.f52421g);
                this.f52420f.f52406a.f70468p.setCurrentItem(this.f52421g, false);
                this.f52420f.f52406a.f70461i.onPageScrolled(this.f52421g, 0.0f, 0);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b extends com.transsion.baseui.util.f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ HomeSearchViewManager f52422f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f52423g;

            public b(HomeSearchViewManager homeSearchViewManager, int i11) {
                this.f52422f = homeSearchViewManager;
                this.f52423g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                this.f52422f.f52407b.H0(this.f52423g);
                this.f52422f.f52406a.f70468p.setCurrentItem(this.f52423g, false);
                this.f52422f.f52406a.f70461i.onPageScrolled(this.f52423g, 0.0f, 0);
            }
        }

        public a(AppTab appTab) {
            this.f52418b = appTab;
        }

        @Override // h20.a
        public int a() {
            List<HomeTabItem> homeTabs;
            AppTab appTab = this.f52418b;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                return 1;
            }
            return homeTabs.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            Context context2 = HomeSearchViewManager.this.f52409d;
            if (context2 == null) {
                Intrinsics.y("context");
                context2 = null;
            }
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context2);
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = z2.a.getColor(context, R$color.transparent);
            gradientLinePagerIndicator.setColors(color, color, color);
            return gradientLinePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            List<HomeTabItem> homeTabs;
            HomeTabItem homeTabItem;
            List<HomeTabItem> homeTabs2;
            List<HomeTabItem> homeTabs3;
            HomeTabItem homeTabItem2;
            AppTab appTab = this.f52418b;
            String name = null;
            homeTabItem = null;
            HomeTabItem homeTabItem3 = null;
            name = null;
            name = null;
            if (((appTab == null || (homeTabs3 = appTab.getHomeTabs()) == null || (homeTabItem2 = homeTabs3.get(i11)) == null) ? null : homeTabItem2.getNameImage()) != null) {
                Context context2 = HomeSearchViewManager.this.f52409d;
                if (context2 == null) {
                    Intrinsics.y("context");
                    context2 = null;
                }
                CustomTabAdView customTabAdView = new CustomTabAdView(context2);
                customTabAdView.setOnClickListener(new C0572a(HomeSearchViewManager.this, i11));
                AppTab appTab2 = this.f52418b;
                if (appTab2 != null && (homeTabs2 = appTab2.getHomeTabs()) != null) {
                    homeTabItem3 = homeTabs2.get(i11);
                }
                customTabAdView.showData(homeTabItem3);
                return customTabAdView;
            }
            int iA = f0.a(10.0f);
            Context context3 = HomeSearchViewManager.this.f52409d;
            if (context3 == null) {
                Intrinsics.y("context");
                context3 = null;
            }
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context3, 17, iA);
            HomeSearchViewManager homeSearchViewManager = HomeSearchViewManager.this;
            AppTab appTab3 = this.f52418b;
            if (appTab3 != null && (homeTabs = appTab3.getHomeTabs()) != null && (homeTabItem = homeTabs.get(i11)) != null) {
                name = homeTabItem.getName();
            }
            customPagerTitleView.setText(name);
            customPagerTitleView.setTextSize(16.0f);
            customPagerTitleView.setOnClickListener(new b(homeSearchViewManager, i11));
            return customPagerTitleView;
        }

        public final void h(AppTab appTab) {
            this.f52418b = appTab;
            e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52424a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52424a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52424a;
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
            this.f52424a.invoke(obj);
        }
    }

    public HomeSearchViewManager(lt.k mViewBinding, HomeFragment mFragment) {
        Intrinsics.g(mViewBinding, "mViewBinding");
        Intrinsics.g(mFragment, "mFragment");
        this.f52406a = mViewBinding;
        this.f52407b = mFragment;
        this.f52410e = new ArrayList<>();
        this.f52417l = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.transsion.home.fragment.d
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return HomeSearchViewManager.G(this.f52444a, message);
            }
        });
    }

    public static final View B(HomeSearchViewManager this$0) {
        Intrinsics.g(this$0, "this$0");
        return LayoutInflater.from(this$0.f52407b.requireContext()).inflate(R$layout.view_text, (ViewGroup) null);
    }

    public static /* synthetic */ void F(HomeSearchViewManager homeSearchViewManager, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        homeSearchViewManager.E(z11);
    }

    public static final boolean G(HomeSearchViewManager this$0, Message it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        if (it.what == 100) {
            int i11 = this$0.f52411f + 1;
            this$0.f52411f = i11;
            ArrayList<String> arrayList = this$0.f52410e;
            String str = arrayList.get(i11 % arrayList.size());
            this$0.f52412g = str;
            this$0.f52406a.f70463k.setText(str);
            M(this$0, false, 1, null);
        }
        return true;
    }

    public static /* synthetic */ void M(HomeSearchViewManager homeSearchViewManager, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        homeSearchViewManager.L(z11);
    }

    public static final void r(HomeSearchViewManager this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.f52406a.f70459g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeSearchViewManager.s(view2);
            }
        });
    }

    public static final void s(View view) {
        UpdateUtils.f57967a.h("app_center");
    }

    public static final void w(HomeSearchViewManager this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        F(this$0, false, 1, null);
    }

    public static final void x(HomeSearchViewManager this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E(true);
    }

    public static final void y(View view) {
    }

    public final void A(List<HotSearchKeyWord> list) {
        this.f52406a.f70465m.setTextWithString("");
        this.f52410e.clear();
        for (HotSearchKeyWord hotSearchKeyWord : list) {
            ArrayList<String> arrayList = this.f52410e;
            String title = hotSearchKeyWord.getTitle();
            if (title == null) {
                title = "";
            }
            arrayList.add(title);
        }
        TextSwitcher textSwitcher = this.f52406a.f70463k;
        if (textSwitcher.getChildCount() == 0) {
            textSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.transsion.home.fragment.j
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    return HomeSearchViewManager.B(this.f52448a);
                }
            });
        }
        int i11 = this.f52411f;
        if (i11 >= 0 && i11 < this.f52410e.size()) {
            String str = this.f52410e.get(this.f52411f);
            this.f52412g = str;
            textSwitcher.setText(str);
        }
        textSwitcher.setInAnimation(t());
        textSwitcher.setOutAnimation(I());
        M(this, false, 1, null);
    }

    public final void C(AppTab appTab) {
        Object objM163constructorimpl;
        Context contextRequireContext = this.f52407b.requireContext();
        Intrinsics.f(contextRequireContext, "mFragment.requireContext()");
        this.f52409d = contextRequireContext;
        ViewGroup.LayoutParams layoutParams = this.f52406a.f70467o.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = f0.a(4.0f) + com.blankj.utilcode.util.d.c();
        this.f52406a.f70467o.setLayoutParams(bVar);
        this.f52416k = bVar;
        q();
        z(appTab);
        v();
        try {
            Result.Companion companion = Result.Companion;
            HomeGameCenterProvider homeGameCenterProvider = new HomeGameCenterProvider();
            this.f52408c = homeGameCenterProvider;
            FrameLayout frameLayout = this.f52406a.f70455b;
            Intrinsics.f(frameLayout, "mViewBinding.flGameCenter");
            FrameLayout frameLayout2 = this.f52406a.f70456c;
            Intrinsics.f(frameLayout2, "mViewBinding.flPhoneCenter");
            AppCompatImageView appCompatImageView = this.f52406a.f70457d;
            Intrinsics.f(appCompatImageView, "mViewBinding.ivMbLogo");
            homeGameCenterProvider.d(frameLayout, frameLayout2, appCompatImageView, v.a(this.f52407b));
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.a.j(uo.b.f78622a, "zxb_icon", "HomeSearchViewManager --> initGameCenter() --> it --> " + thM166exceptionOrNullimpl, false, 4, null);
        }
        AppCompatImageView appCompatImageView2 = this.f52406a.f70458f;
        Intrinsics.f(appCompatImageView2, "mViewBinding.ivNovelEnter");
        new pt.b(appCompatImageView2);
    }

    public final boolean D() {
        return this.f52415j;
    }

    public final void E(boolean z11) {
        String str;
        com.transsion.home.view.g.f52730a.c(false);
        es.b bVar = (es.b) es.a.f64348a.a(es.b.class);
        if (z11) {
            if (bVar != null) {
                String str2 = this.f52412g;
                String str3 = str2 == null ? "" : str2;
                str = str2 != null ? str2 : "";
                ArrayList<String> arrayList = this.f52410e;
                Context contextRequireContext = this.f52407b.requireContext();
                Intrinsics.f(contextRequireContext, "mFragment.requireContext()");
                bVar.a(str3, str, arrayList, contextRequireContext);
            }
        } else if (bVar != null) {
            String str4 = this.f52412g;
            str = str4 != null ? str4 : "";
            ArrayList<String> arrayList2 = this.f52410e;
            Context contextRequireContext2 = this.f52407b.requireContext();
            Intrinsics.f(contextRequireContext2, "mFragment.requireContext()");
            bVar.b(str, arrayList2, contextRequireContext2);
        }
        J(z11);
    }

    public final void H(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        if (this.f52410e.isEmpty()) {
            PreloadTrendingData.f52790o.a().C();
        }
    }

    public final AnimationSet I() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public final void J(boolean z11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", z11 ? "search_button" : AppLovinEventTypes.USER_EXECUTED_SEARCH);
        String str = this.f52412g;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("hot_search_word", str);
        com.transsion.baselib.helper.a.f51183a.h(HomeTabType.TAB_CODE_TRENDING, linkedHashMap);
    }

    public final void K() {
        this.f52417l.removeCallbacksAndMessages(null);
    }

    public final void L(boolean z11) {
        if (this.f52410e.size() <= 0) {
            return;
        }
        if (this.f52411f >= this.f52410e.size()) {
            this.f52411f %= this.f52410e.size();
        }
        if (z11) {
            K();
            this.f52417l.sendEmptyMessageDelayed(100, 500L);
        } else {
            K();
            this.f52417l.sendEmptyMessageDelayed(100, 5000L);
        }
    }

    public final void N(AppTab appTab) {
        Intrinsics.g(appTab, "appTab");
        a aVar = this.f52414i;
        if (aVar != null) {
            aVar.h(appTab);
        }
        if (this.f52415j) {
            n(true);
        }
    }

    public final void m(boolean z11) {
        this.f52415j = z11;
        n(z11);
    }

    public final void n(boolean z11) {
        LinearLayout linearLayout;
        CommonNavigator commonNavigator = this.f52413h;
        if (commonNavigator != null) {
            int color = z2.a.getColor(commonNavigator.getContext(), R$color.common_white);
            int color2 = z2.a.getColor(commonNavigator.getContext(), R$color.transparent);
            LinearLayout linearLayout2 = (LinearLayout) commonNavigator.findViewById(R$id.title_container);
            int childCount = linearLayout2.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = linearLayout2.getChildAt(i11);
                if (childAt instanceof CustomPagerTitleView) {
                    CustomPagerTitleView customPagerTitleView = (CustomPagerTitleView) childAt;
                    customPagerTitleView.setNormalColor(z2.a.getColor(linearLayout2.getContext(), R$color.white_60));
                    customPagerTitleView.setSelectedColor(color);
                    if (i11 == this.f52407b.w0()) {
                        customPagerTitleView.setTextColor(color);
                    } else {
                        customPagerTitleView.setTextColor(z2.a.getColor(linearLayout2.getContext(), R$color.white_60));
                    }
                    ViewGroup.LayoutParams layoutParams = customPagerTitleView.getLayoutParams();
                    Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.width = -2;
                    layoutParams2.height = -1;
                    customPagerTitleView.setLayoutParams(layoutParams2);
                } else if (childAt instanceof CustomTabAdView) {
                    CustomTabAdView customTabAdView = (CustomTabAdView) childAt;
                    customTabAdView.changeTextColor(z2.a.getColor(linearLayout2.getContext(), R$color.white_60), z2.a.getColor(linearLayout2.getContext(), R$color.common_white));
                    if (i11 == this.f52407b.w0()) {
                        customTabAdView.setTextColor(color);
                    } else {
                        customTabAdView.setTextColor(z2.a.getColor(linearLayout2.getContext(), R$color.white_60));
                    }
                }
            }
            CommonNavigator commonNavigator2 = this.f52413h;
            if (commonNavigator2 == null || (linearLayout = (LinearLayout) commonNavigator2.findViewById(R$id.indicator_container)) == null) {
                return;
            }
            Intrinsics.f(linearLayout, "findViewById<LinearLayou…R.id.indicator_container)");
            int childCount2 = linearLayout.getChildCount();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = linearLayout.getChildAt(i12);
                if (childAt2 instanceof GradientLinePagerIndicator) {
                    ((GradientLinePagerIndicator) childAt2).setColors(color2, color2, color2);
                }
            }
        }
    }

    public final void o() {
        HomeGameCenterProvider homeGameCenterProvider = this.f52408c;
        if (homeGameCenterProvider != null) {
            homeGameCenterProvider.c();
        }
    }

    public final ConstraintLayout.b p() {
        ViewGroup.LayoutParams layoutParams = this.f52406a.f70467o.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = this.f52406a.f70467o.getWidth();
        this.f52416k = bVar;
        return bVar;
    }

    public final void q() {
        UpdateUtils updateUtils = UpdateUtils.f57967a;
        if (!updateUtils.c() || !updateUtils.e()) {
            this.f52406a.f70459g.setVisibility(8);
        } else {
            this.f52406a.f70459g.setVisibility(0);
            this.f52406a.f70459g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeSearchViewManager.r(this.f52447a, view);
                }
            });
        }
    }

    public final AnimationSet t() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public final void u() {
        Intent intent;
        this.f52406a.f70465m.setLocalChangeListener(new Function0<Unit>() { // from class: com.transsion.home.fragment.HomeSearchViewManager$initLanguageRestart$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PreloadTrendingData.f52790o.a().t();
            }
        });
        FragmentActivity activity = this.f52407b.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra("extra_language_activity_restart", false)) {
            return;
        }
        PreloadTrendingData.f52790o.a().t();
    }

    public final void v() {
        this.f52406a.f70467o.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.w(this.f52445a, view);
            }
        });
        this.f52406a.f70466n.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.x(this.f52446a, view);
            }
        });
        this.f52406a.f70457d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.y(view);
            }
        });
        u();
        PreloadTrendingData.f52790o.a().D().j(this.f52407b, new b(new Function1<HotSubjectEntity, Unit>() { // from class: com.transsion.home.fragment.HomeSearchViewManager$initListener$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HotSubjectEntity hotSubjectEntity) {
                invoke2(hotSubjectEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HotSubjectEntity hotSubjectEntity) {
                List<HotSearchKeyWord> everyoneSearch;
                if (hotSubjectEntity == null || (everyoneSearch = hotSubjectEntity.getEveryoneSearch()) == null) {
                    return;
                }
                this.this$0.A(everyoneSearch);
            }
        }));
        HomeFragment homeFragment = this.f52407b;
        Function1<DiffUpdateResultEvent, Unit> function1 = new Function1<DiffUpdateResultEvent, Unit>() { // from class: com.transsion.home.fragment.HomeSearchViewManager$initListener$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DiffUpdateResultEvent diffUpdateResultEvent) {
                invoke2(diffUpdateResultEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DiffUpdateResultEvent it) {
                Intrinsics.g(it, "it");
                this.this$0.q();
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DiffUpdateResultEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(homeFragment, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void z(AppTab appTab) {
        Context context = this.f52409d;
        if (context == null) {
            Intrinsics.y("context");
            context = null;
        }
        this.f52413h = new CommonNavigator(context);
        a aVar = new a(appTab);
        this.f52414i = aVar;
        CommonNavigator commonNavigator = this.f52413h;
        if (commonNavigator != null) {
            commonNavigator.setAdapter(aVar);
        }
        this.f52406a.f70461i.setNavigator(this.f52413h);
    }
}
