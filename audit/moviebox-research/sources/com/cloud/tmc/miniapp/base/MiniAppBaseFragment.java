package com.cloud.tmc.miniapp.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabBarBadgeMessage;
import com.cloud.tmc.integration.model.TabBarMessageStore;
import com.cloud.tmc.integration.model.TabBarRedDotMessage;
import com.cloud.tmc.integration.model.TabBarStyle;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import h.f;
import h.h;
import id.e;
import id.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public abstract class MiniAppBaseFragment extends TmcFragment implements g, e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f31388s = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jb.a f31391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f31392i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f31394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f31395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f31396m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f31397n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f31399p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f31389f = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$swipeBackManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            return new h();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f31390g = LazyKt__LazyJVMKt.b(new Function0<f>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$refreshManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final f invoke() {
            return new f();
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f31398o = new AnimatorSet();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AtomicBoolean f31400q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final nc.a f31401r = new b();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements nc.a {
        public b() {
        }

        @Override // nc.a
        public void onKeyBoardChanged(int i11, int i12) {
            try {
                TmcLogger.c("MiniAppBaseFragment", "onKeyboardListener: keyboardHeight: " + i11 + ", screenHeight: " + i12);
                MiniAppBaseFragment.this.o1(i11, i12);
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppBaseFragment", "onKeyBoardChanged failed", th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements rb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IEventCenterFactory f31403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final uc.a f31404b;

        public c() {
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
            this.f31403a = iEventCenterFactory;
            this.f31404b = iEventCenterFactory.createEvent("onKeyboardHeightChange");
        }

        @Override // rb.a
        public void a(int i11) {
            TmcLogger.c("MiniAppBaseFragment", "Keyboard height:" + i11);
            this.f31404b.c(s.j(TuplesKt.a("page", MiniAppBaseFragment.this.f30954a), TuplesKt.a("height", String.valueOf(i11))));
            uc.b eventCenterInstance = this.f31403a.getEventCenterInstance(MiniAppBaseFragment.this.f30955b);
            if (eventCenterInstance != null) {
                eventCenterInstance.d("onKeyboardHeightChange", this.f31404b);
            }
        }

        @Override // rb.a
        public void b() {
            TmcLogger.c("MiniAppBaseFragment", "Keyboard anim start");
        }

        @Override // rb.a
        public void c() {
            TmcLogger.c("MiniAppBaseFragment", "Keyboard anim end");
        }
    }

    public static final void A0(MiniAppBaseFragment this$0) {
        View content;
        Intrinsics.g(this$0, "this$0");
        try {
            MiniAppConfigModel.WindowBean window = this$0.getWindow();
            String strA = xb.e.a(window != null ? window.getRefreshHeaderStyle() : null, TmcEngineFactory.ENGINE_TYPE_DEFAULT);
            float fD = xb.a.d(e0.a());
            ub.c cVarX = this$0.x();
            float fD2 = (cVarX == null || (content = cVarX.getContent()) == null) ? -1.0f : xb.a.d(content.getHeight());
            Page page = this$0.f30954a;
            float intValue = page != null ? page.getIntValue("capsuleTranslationY") : 0.0f;
            Page page2 = this$0.f30954a;
            float fC = xb.a.c(intValue + (page2 != null ? page2.getIntValue("capsuleHeight") : 0.0f));
            if (!Intrinsics.b(strA, "custom")) {
                fC = fD2 == -1.0f ? fD + xb.a.c(19.2f) : (fD2 / 5) * 3;
            }
            if (Intrinsics.b(strA, "custom")) {
                fD = 0.0f;
            }
            this$0.F0().n(fC);
            this$0.F0().d(fD);
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "Error refreshing", th2);
        }
    }

    public static final void J0(MiniAppBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            ViewGroup viewGroupV = this$0.v();
            FrameLayout frameLayout = viewGroupV != null ? (FrameLayout) viewGroupV.findViewById(R$id.fl_loading_mask) : null;
            if ((frameLayout == null || frameLayout.getVisibility() != 8) && frameLayout != null) {
                i.c(frameLayout);
            }
            this$0.w0();
            ViewGroup viewGroupV2 = this$0.v();
            ImageView imageView = viewGroupV2 != null ? (ImageView) viewGroupV2.findViewById(R$id.iv_loading) : null;
            if (imageView != null) {
                this$0.P0(imageView);
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "", th2);
        }
    }

    public static final void O0(FragmentActivity fragmentActivity) {
        ((OooO0OO) fragmentActivity).N0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void R0(MiniAppBaseFragment miniAppBaseFragment, String str, Map map, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendAppOrPageReadyToRender");
        }
        if ((i11 & 2) != 0) {
            map = null;
        }
        miniAppBaseFragment.Q0(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void T0(MiniAppBaseFragment miniAppBaseFragment, String str, boolean z11, Map map, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEventOrLifecycleToWorker");
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            map = null;
        }
        miniAppBaseFragment.S0(str, z11, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V0(MiniAppBaseFragment miniAppBaseFragment, Map map, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPageEnterToWorker");
        }
        if ((i11 & 1) != 0) {
            map = null;
        }
        miniAppBaseFragment.U0(map);
    }

    public static final void X0(MiniAppBaseFragment this$0, CapsuleView v11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(v11, "$v");
        Page page = this$0.f30954a;
        if (page != null) {
            page.putIntValue("capsuleHeight", v11.getHeight());
            page.putIntValue("capsuleWidth", v11.getWidth());
            page.putIntValue("capsuleTop", (int) v11.getY());
            page.putIntValue("capsuleRight", v11.getWidth() + ((int) v11.getX()));
            page.putIntValue("capsuleBottom", v11.getHeight() + ((int) v11.getY()));
            page.putIntValue("capsuleLeft", (int) v11.getX());
            page.putIntValue("capsuleTranslationX", (int) v11.getTranslationX());
            page.putIntValue("capsuleTranslationY", (int) v11.getTranslationY());
        }
    }

    public static final void a1(String color, MiniAppBaseFragment this$0, Page page) {
        StatusLayout statusLayout;
        tb.b appContext;
        Intrinsics.g(color, "$color");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(page, "$page");
        try {
            TmcLogger.c("MiniAppBaseFragment", "setHostActivityStatusBackground: contentBackground: : " + color);
            int color2 = Color.parseColor(color);
            FragmentActivity activity = this$0.getActivity();
            OooO0OO oooO0OO = null;
            OooO0OO oooO0OO2 = activity instanceof OooO0OO ? (OooO0OO) activity : null;
            if (oooO0OO2 == null) {
                App app = page.getApp();
                Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
                if (context instanceof OooO0OO) {
                    oooO0OO = (OooO0OO) context;
                }
            } else {
                oooO0OO = oooO0OO2;
            }
            if (oooO0OO != null && (statusLayout = oooO0OO.getStatusLayout()) != null) {
                statusLayout.setBackgroundColor(color2);
                TmcLogger.c("MiniAppBaseFragment", "setHostActivityStatusBackground: 设置 activity 的状态布局背景色成功");
            }
            TmcLogger.c("MiniAppBaseFragment", "setHostActivityStatusBackground: 执行完毕");
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "setHostActivityStatusBackground parse color failed!!!", th2);
        }
    }

    public static /* synthetic */ void d1(MiniAppBaseFragment miniAppBaseFragment, float f11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setParallaxOffset");
        }
        if ((i11 & 1) != 0) {
            f11 = 0.5f;
        }
        miniAppBaseFragment.c1(f11);
    }

    public static final void h1(final MiniAppBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            ViewGroup viewGroupV = this$0.v();
            FrameLayout frameLayout = viewGroupV != null ? (FrameLayout) viewGroupV.findViewById(R$id.fl_loading_mask) : null;
            ViewGroup viewGroupV2 = this$0.v();
            ImageView imageView = viewGroupV2 != null ? (ImageView) viewGroupV2.findViewById(R$id.iv_loading) : null;
            if (imageView == null) {
                return;
            }
            if ((frameLayout == null || frameLayout.getVisibility() != 0) && frameLayout != null) {
                i.e(frameLayout);
            }
            this$0.P0(imageView);
            this$0.k1(imageView);
            this$0.N0(imageView, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, new Runnable() { // from class: kd.g
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.i1(this.f68534a);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "", th2);
        }
    }

    public static final void i1(MiniAppBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.I0();
    }

    public void B0(boolean z11) {
        this.f31393j = z11;
        F0().e(z11);
    }

    @Override // vb.c
    public boolean C() {
        return this.f31396m;
    }

    public void C0(boolean z11) {
        this.f31392i = z11;
        F0().r(z11);
    }

    public final EntryInfo D0() {
        return (EntryInfo) com.cloud.tmc.kernel.utils.a.d(getSceneParams(), "entryInfo");
    }

    public final boolean E0() {
        return this.f31397n;
    }

    public final l0.a F0() {
        return (l0.a) this.f31390g.getValue();
    }

    public final l0.b G0() {
        return (l0.b) this.f31389f.getValue();
    }

    public final boolean H0(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i11 = displayMetrics.heightPixels;
        int i12 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i12 - displayMetrics2.widthPixels > 0 || i11 - displayMetrics2.heightPixels > 0;
    }

    public void I() {
        Integer num;
        int iIntValue;
        if (!this.f31392i || (num = this.f31394k) == null || (iIntValue = num.intValue()) <= 0) {
            return;
        }
        F0().m(iIntValue, false);
    }

    public final void I0() {
        try {
            TmcLogger.c("MiniAppBaseFragment", "hideLoadingDialog");
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: kd.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.J0(this.f68532a);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "", th2);
        }
    }

    public final void K0() {
        View decorView = requireActivity().getWindow().getDecorView();
        Intrinsics.f(decorView, "requireActivity().window.decorView");
        decorView.setSystemUiVisibility(2050);
    }

    public final AtomicBoolean L0() {
        return this.f31400q;
    }

    public final boolean M0(AppLoadResult appLoadResult) {
        return AppUtils.r(this.f30954a, appLoadResult);
    }

    public boolean N0(Object obj, long j11, Runnable runnable) {
        return e.b.d(this, obj, j11, runnable);
    }

    public void P0(Object obj) {
        e.b.h(this, obj);
    }

    public final void Q0(String eventName, Map<String, String> map) {
        Intrinsics.g(eventName, "eventName");
        AppUtils.x(this.f30954a, eventName, map);
    }

    public final void S0(String eventName, boolean z11, Map<String, ? extends Object> map) {
        Intrinsics.g(eventName, "eventName");
        AppUtils.y(this.f30954a, eventName, z11, map);
    }

    public final void U0(Map<String, ? extends Object> map) {
        String routeType;
        Integer numValueOf;
        App app;
        Page prePage;
        App app2;
        Page page = this.f30954a;
        String pageId = null;
        if (page == null || (app2 = page.getApp()) == null) {
            routeType = null;
        } else {
            Page page2 = this.f30954a;
            String pagePath = page2 != null ? page2.getPagePath() : null;
            if (pagePath == null) {
                pagePath = "";
            }
            routeType = app2.getRouteType(pagePath);
        }
        String strA = xb.e.a(xb.e.c(routeType), "navigateTo");
        String str = Intrinsics.b(strA, AppLovinMediationProvider.UNKNOWN) ? "navigateTo" : strA;
        App app3 = this.f30955b;
        if (app3 != null) {
            Page page3 = this.f30954a;
            String pagePath2 = page3 != null ? page3.getPagePath() : null;
            if (pagePath2 == null) {
                pagePath2 = "";
            }
            numValueOf = Integer.valueOf(app3.getPageType(pagePath2));
        } else {
            numValueOf = null;
        }
        HashMap map2 = new HashMap();
        map2.put("delta", 0);
        map2.put("routeType", str);
        boolean z11 = true;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            z11 = false;
        }
        map2.put("isMixedPage", Boolean.valueOf(z11));
        Page page4 = this.f30954a;
        if (page4 != null && (app = page4.getApp()) != null && (prePage = app.getPrePage()) != null) {
            pageId = prePage.getPageId();
        }
        map2.put("preRenderId", pageId != null ? pageId : "");
        if (map != null) {
            map2.putAll(map);
        }
        S0("pageEnter", false, map2);
    }

    public final void W0() {
        FragmentActivity activity = getActivity();
        OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
        final CapsuleView capsuleViewU0 = oooO0OO != null ? oooO0OO.u0() : null;
        if (capsuleViewU0 != null) {
            capsuleViewU0.post(new Runnable() { // from class: kd.i
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.X0(this.f68536a, capsuleViewU0);
                }
            });
        }
    }

    @Override // vb.b
    public boolean X(int i11, MiniAppConfigModel.TabBarBean.ListBean tab) {
        Intrinsics.g(tab, "tab");
        Page page = this.f30954a;
        if (page != null) {
            ub.b bVarA0 = a0();
            Boolean boolValueOf = bVarA0 != null ? Boolean.valueOf(bVarA0.updateTabItem(i11, tab, page)) : null;
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        TmcLogger.c("MiniAppBaseFragment", "set tab item for index " + i11 + " with tab " + tab + " is failed");
        return false;
    }

    public final void Y0(int i11) {
        G0().c(i11);
    }

    public final void Z0(final Page page) {
        try {
            TmcLogger.c("MiniAppBaseFragment", "setHostActivityStatusBackground page: " + page.getPagePath());
            App app = page.getApp();
            AppNode appNode = app instanceof AppNode ? (AppNode) app : null;
            AppLoadResult appLoadResult = appNode != null ? appNode.getmAppLoadResult() : null;
            if (appLoadResult == null) {
                TmcLogger.c("MiniAppBaseFragment", "setHostActivityStatusBackground: appLoadResult is null");
                return;
            }
            MiniAppConfigModel.WindowBean windowBeanF = d0.f(appLoadResult, page.getPagePath());
            final String contentBgColor = windowBeanF != null ? windowBeanF.getContentBgColor() : null;
            if (contentBgColor == null || contentBgColor.length() <= 0) {
                return;
            }
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: kd.c
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.a1(contentBgColor, this, page);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "setHostActivityStatusBackground parse color failed!", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.node.a
    public void addOnKeyboardListener(nc.a listener) {
        Intrinsics.g(listener, "listener");
        jb.a aVar = this.f31391h;
        if (aVar != null) {
            aVar.a(listener);
        }
    }

    public final void b1(boolean z11) {
        this.f31396m = z11;
    }

    public final void c1(float f11) {
        G0().d(f11);
    }

    public void d0() {
        Integer num;
        int iIntValue;
        if (!this.f31393j || (num = this.f31395l) == null || (iIntValue = num.intValue()) <= 0) {
            return;
        }
        F0().i(iIntValue, false);
    }

    public void destroy() {
        try {
            I0();
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "remove callbacks and messages", th2);
        }
    }

    public final void e1(Page page) {
        try {
            TmcLogger.c("MiniAppBaseFragment", "setShowLoading");
            if (v() == null) {
                TmcLogger.c("MiniAppBaseFragment", "setShowLoading 当面页面未渲染，不再执行");
                return;
            }
            App app = page.getApp();
            String stringValue = app != null ? app.getStringValue("firstStartedPagePath") : null;
            if (stringValue == null) {
                return;
            }
            TmcLogger.c("MiniAppBaseFragment", "setShowLoading firstStartedPagePath: " + stringValue);
            String pagePath = page.getPagePath();
            if (pagePath == null) {
                return;
            }
            TmcLogger.c("MiniAppBaseFragment", "setShowLoading current pagePath: " + pagePath);
            if (Intrinsics.b(stringValue, pagePath)) {
                TmcLogger.c("MiniAppBaseFragment", "setShowLoading 首个启动页面不展示页面Loading");
                return;
            }
            if (n0.h(pagePath)) {
                TmcLogger.c("MiniAppBaseFragment", "setShowLoading 混合页面不支持显示页面Loading");
                return;
            }
            App app2 = page.getApp();
            boolean booleanValue = app2 != null ? app2.getBooleanValue("firstNormalPageOpened") : false;
            TmcLogger.c("MiniAppBaseFragment", "setShowLoading 首个正常小程序页面是否打开过：" + booleanValue);
            MiniAppConfigModel.WindowBean window = getWindow();
            boolean zB = window != null ? Intrinsics.b(window.getEnablePageLoading(), Boolean.TRUE) : false;
            TmcLogger.c("MiniAppBaseFragment", "setShowLoading 业务小程序配置Loading的开关：" + zB);
            if (n0.h(stringValue) && !booleanValue) {
                TmcLogger.c("MiniAppBaseFragment", "setShowLoading 首个页面为H5混合页，首个正常小程序页面尚未打开过");
            } else if (!zB) {
                TmcLogger.c("MiniAppBaseFragment", "setShowLoading 关闭页面调整Loading");
                return;
            }
            g1();
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "setShowLoading fail!!!", th2);
        }
    }

    public boolean f1() {
        return x0();
    }

    public final void g1() {
        try {
            TmcLogger.c("MiniAppBaseFragment", "showLoadingDialog");
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: kd.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.h1(this.f68531a);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "", th2);
        }
    }

    public final AppLoadResult getAppLoadResult() {
        return (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(getSceneParams(), "appLoadResult");
    }

    public final Bundle getSceneParams() {
        App app;
        Page page = this.f30954a;
        if (page == null || (app = page.getApp()) == null) {
            return null;
        }
        return app.getSceneParams();
    }

    public final MiniAppConfigModel.WindowBean getWindow() {
        AppLoadResult appLoadResult = getAppLoadResult();
        Page page = this.f30954a;
        return d0.f(appLoadResult, page != null ? page.getPagePath() : null);
    }

    @Override // vb.b
    public boolean hideTabBar(boolean z11) {
        ub.b bVarA0 = a0();
        if (bVarA0 != null) {
            return bVarA0.hideTabBar(z11);
        }
        return false;
    }

    @Override // vb.b
    public boolean hideTabBarRedDot(int i11) {
        HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap;
        App app;
        ub.b bVarA0 = a0();
        boolean unreadVisible = bVarA0 != null ? bVarA0.setUnreadVisible(i11, false) : false;
        if (unreadVisible) {
            Page page = this.f30954a;
            TabBarRedDotMessage tabBarRedDotMessage = null;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null && (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) != null) {
                tabBarRedDotMessage = redDotMessageHashMap.get(Integer.valueOf(i11));
            }
            if (tabBarRedDotMessage != null) {
                tabBarRedDotMessage.setShowRedDot(false);
            }
        }
        return unreadVisible;
    }

    @Override // vb.b
    public boolean hideTabBarUnreadIcon(int i11) {
        HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap;
        App app;
        ub.b bVarA0 = a0();
        boolean unreadIconVisible = bVarA0 != null ? bVarA0.setUnreadIconVisible(i11, false) : false;
        if (unreadIconVisible) {
            Page page = this.f30954a;
            TabBarRedDotMessage tabBarRedDotMessage = null;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null && (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) != null) {
                tabBarRedDotMessage = redDotMessageHashMap.get(Integer.valueOf(i11));
            }
            if (tabBarRedDotMessage != null) {
                tabBarRedDotMessage.setShowUnreadIcon(false);
            }
        }
        return unreadIconVisible;
    }

    public void initView() {
        W0();
    }

    @Override // vb.b
    public boolean j(ArrayList<MiniAppConfigModel.TabBarBean.ListBean> tabs) {
        Intrinsics.g(tabs, "tabs");
        Page page = this.f30954a;
        if (page != null) {
            ub.b bVarA0 = a0();
            Boolean boolValueOf = bVarA0 != null ? Boolean.valueOf(bVarA0.updateAllTabs(tabs, page)) : null;
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        TmcLogger.c("MiniAppBaseFragment", "set tab items is failed");
        return false;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.TmcFragment
    public void j0(Page page) {
        Intrinsics.g(page, "page");
        try {
            try {
                App app = this.f30955b;
                if ((app != null ? app.getAppLifecycleCallback() : null) == null) {
                    TmcLogger.c("MiniAppBaseFragment", "setMiniappLifecycleCallback");
                    App app2 = this.f30955b;
                    if (app2 != null) {
                        FragmentActivity activity = getActivity();
                        app2.setMiniappLifecycleCallback(activity instanceof OooO0OO ? (OooO0OO) activity : null);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppBaseFragment", th2);
            }
            Z0(page);
            e1(page);
        } catch (Throwable th3) {
            TmcLogger.g("MiniAppBaseFragment", "setPage fail!", th3);
        }
    }

    public final void j1() {
        View decorView = requireActivity().getWindow().getDecorView();
        Intrinsics.f(decorView, "requireActivity().window.decorView");
        decorView.setSystemUiVisibility(1024);
    }

    public final synchronized void k1(ImageView imageView) {
        try {
            TmcLogger.c("MiniAppBaseFragment", "startAnimator");
            if (this.f31399p) {
                return;
            }
            if (imageView != null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
                Intrinsics.f(objectAnimatorOfFloat, "ofFloat(it, \"rotation\", 0F, 360F)");
                objectAnimatorOfFloat.setDuration(600L);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat.setRepeatCount(-1);
                this.f31398o.play(objectAnimatorOfFloat);
                this.f31398o.start();
                this.f31399p = true;
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppBaseFragment", th2);
        }
    }

    public boolean l1() {
        if (this.f31392i) {
            return F0().f();
        }
        return false;
    }

    public boolean m1() {
        if (this.f31393j) {
            F0().k();
        }
        return this.f31393j;
    }

    @Override // vb.b
    public boolean n(MiniAppConfigModel.TabBarBean tabBar, String str) {
        Intrinsics.g(tabBar, "tabBar");
        ub.b bVarA0 = a0();
        boolean z11 = false;
        if (bVarA0 == null || !(bVarA0 instanceof TabBarView)) {
            return false;
        }
        TabBarView tabBarView = (TabBarView) bVarA0;
        Page page = this.f30954a;
        if (page != null && page.isTabPage()) {
            z11 = true;
        }
        i.f(tabBarView, z11);
        Page page2 = this.f30954a;
        if (page2 != null && page2.isTabPage()) {
            Page page3 = this.f30954a;
            if (str == null) {
                str = "";
            }
            tabBarView.setTabs(tabBar, page3, str);
        }
        return true;
    }

    public boolean n1() {
        if (this.f31392i) {
            F0().l();
        }
        return this.f31392i;
    }

    public final void o1(int i11, int i12) {
        try {
            MiniAppConfigModel.WindowBean window = getWindow();
            if (window != null && Intrinsics.b(window.getEnableTabBarAdjustPan(), Boolean.TRUE)) {
                Page page = this.f30954a;
                if (page != null && page.isTabPage()) {
                    Page page2 = this.f30954a;
                    if (Intrinsics.b(page2 != null ? page2.getStringValue("isApiShowTabBarEnabled") : null, "hideTabBar")) {
                        Page page3 = this.f30954a;
                        if (page3 != null) {
                            page3.hideTabBar(false);
                            return;
                        }
                        return;
                    }
                    if (i11 > ((double) i12) * 0.15d) {
                        Page page4 = this.f30954a;
                        if (page4 != null) {
                            page4.hideTabBar(false);
                            return;
                        }
                        return;
                    }
                    Page page5 = this.f30954a;
                    if (page5 != null) {
                        page5.showTabBar(false);
                        return;
                    }
                    return;
                }
                TmcLogger.c("MiniAppBaseFragment", "onTabBarAdjustPan: page is not tabPage " + this.f30954a);
                return;
            }
            TmcLogger.c("MiniAppBaseFragment", "onTabBarAdjustPan enableTabBarAdjustPan is not enabled");
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "tabBarAdjustPan failed", th2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        this.f31397n = H0(contextRequireContext);
        Page page = this.f30954a;
        if (page == null || !page.isTabPage()) {
            G0().e(this, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        G0().OooO00o();
        if (this.f31392i || this.f31393j) {
            F0().OooO00o();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            G0().b();
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).releaseKeyBoardChange(requireView());
            jb.a aVar = this.f31391h;
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "onDestroyView failed", th2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        G0().OooO00o(z11);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        super.onPause();
        try {
            View view = getView();
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.f31391h);
            }
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).setKeyBoardListener(null);
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "onPause failed", th2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        jb.a aVar;
        ViewTreeObserver viewTreeObserver;
        super.onResume();
        try {
            View view = getView();
            if (view != null && (aVar = this.f31391h) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(aVar);
            }
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).setKeyBoardListener(new c());
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", "onResume failed", th2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).initKeyBoardChange(requireView());
        jb.a aVar = new jb.a(this);
        aVar.a(this.f31401r);
        this.f31391h = aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        d1(this, 0.0f, 1, null);
    }

    @Override // id.e
    public boolean postAtTime(Runnable runnable, long j11) {
        return e.b.c(this, runnable, j11);
    }

    @Override // id.e
    public boolean postDelayed(Runnable runnable, long j11) {
        return e.b.e(this, runnable, j11);
    }

    @Override // tb.d
    public void refreshApp() {
        final FragmentActivity activity = getActivity();
        if (activity instanceof OooO0OO) {
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                ((OooO0OO) activity).N0();
            } else {
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.UI, new Runnable() { // from class: kd.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppBaseFragment.O0(activity);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.kernel.node.a
    public void removeOnKeyboardListener(nc.a listener) {
        Intrinsics.g(listener, "listener");
        jb.a aVar = this.f31391h;
        if (aVar != null) {
            aVar.c(listener);
        }
    }

    @Override // vb.b
    public boolean removeTabBarBadge(int i11) {
        HashMap<Integer, TabBarBadgeMessage> badgeMessageHashMap;
        TabBarBadgeMessage tabBarBadgeMessage;
        App app;
        ub.b bVarA0 = a0();
        boolean zRemoveTabBarBadge = bVarA0 != null ? bVarA0.removeTabBarBadge(i11) : false;
        if (zRemoveTabBarBadge) {
            Page page = this.f30954a;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null && (badgeMessageHashMap = tabBarMessageStore.getBadgeMessageHashMap()) != null && (tabBarBadgeMessage = badgeMessageHashMap.get(Integer.valueOf(i11))) != null) {
                tabBarBadgeMessage.setShowBadge(false);
                tabBarBadgeMessage.setText(null);
            }
        }
        return zRemoveTabBarBadge;
    }

    @Override // vb.b
    public boolean setTabBarBadge(int i11, String str) {
        HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap;
        App app;
        ub.b bVarA0 = a0();
        boolean tabBarBadge = bVarA0 != null ? bVarA0.setTabBarBadge(i11, str) : false;
        if (tabBarBadge) {
            Page page = this.f30954a;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            TabBarRedDotMessage tabBarRedDotMessage = (tabBarMessageStore == null || (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) == null) ? null : redDotMessageHashMap.get(Integer.valueOf(i11));
            if (tabBarRedDotMessage != null) {
                tabBarRedDotMessage.setShowRedDot(false);
            }
            HashMap<Integer, TabBarBadgeMessage> badgeMessageHashMap = tabBarMessageStore != null ? tabBarMessageStore.getBadgeMessageHashMap() : null;
            if (badgeMessageHashMap != null) {
                badgeMessageHashMap.put(Integer.valueOf(i11), new TabBarBadgeMessage(i11, true, str));
            }
        }
        return tabBarBadge;
    }

    @Override // vb.b
    public boolean setTabBarStyle(String str, String str2, String str3, String str4) {
        App app;
        ub.b bVarA0 = a0();
        boolean tabBarStyle = bVarA0 != null ? bVarA0.setTabBarStyle(str, str2, str3, str4) : false;
        if (tabBarStyle) {
            Page page = this.f30954a;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null) {
                tabBarMessageStore.setTabBarStyle(new TabBarStyle(str, str2, str3, str4));
            }
        }
        return tabBarStyle;
    }

    @Override // vb.b
    public boolean showTabBar(boolean z11) {
        ub.b bVarA0 = a0();
        if (bVarA0 != null) {
            return bVarA0.showTabBar(z11);
        }
        return false;
    }

    @Override // vb.b
    public boolean showTabBarRedDot(int i11) {
        HashMap<Integer, TabBarBadgeMessage> badgeMessageHashMap;
        TabBarBadgeMessage tabBarBadgeMessage;
        App app;
        ub.b bVarA0 = a0();
        boolean unreadVisible = bVarA0 != null ? bVarA0.setUnreadVisible(i11, true) : false;
        if (unreadVisible) {
            Page page = this.f30954a;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap = tabBarMessageStore != null ? tabBarMessageStore.getRedDotMessageHashMap() : null;
            if (redDotMessageHashMap != null) {
                redDotMessageHashMap.put(Integer.valueOf(i11), new TabBarRedDotMessage(i11, true, null, false, 12, null));
            }
            if (tabBarMessageStore != null && (badgeMessageHashMap = tabBarMessageStore.getBadgeMessageHashMap()) != null && (tabBarBadgeMessage = badgeMessageHashMap.get(Integer.valueOf(i11))) != null) {
                tabBarBadgeMessage.setShowBadge(false);
                tabBarBadgeMessage.setText(null);
            }
        }
        return unreadVisible;
    }

    @Override // vb.b
    public void showTabBarUnreadIcon(final int i11, final String iconPath, final Function1<? super Boolean, Unit> function1) {
        ub.b bVarA0;
        Intrinsics.g(iconPath, "iconPath");
        Page page = this.f30954a;
        if (page == null || (bVarA0 = a0()) == null) {
            return;
        }
        bVarA0.showTabBarUnreadIcon(i11, iconPath, page, new Function1<Boolean, Unit>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$showTabBarUnreadIcon$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap;
                HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap2;
                App app;
                if (z11) {
                    Page page2 = this.this$0.f30954a;
                    TabBarRedDotMessage tabBarRedDotMessage = null;
                    TabBarMessageStore tabBarMessageStore = (page2 == null || (app = page2.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
                    TabBarRedDotMessage tabBarRedDotMessage2 = (tabBarMessageStore == null || (redDotMessageHashMap2 = tabBarMessageStore.getRedDotMessageHashMap()) == null) ? null : redDotMessageHashMap2.get(Integer.valueOf(i11));
                    if (tabBarRedDotMessage2 != null) {
                        tabBarRedDotMessage2.setUnreadIcon(iconPath);
                    }
                    if (tabBarMessageStore != null && (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) != null) {
                        tabBarRedDotMessage = redDotMessageHashMap.get(Integer.valueOf(i11));
                    }
                    if (tabBarRedDotMessage != null) {
                        tabBarRedDotMessage.setShowUnreadIcon(true);
                    }
                }
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(Boolean.valueOf(z11));
                }
            }
        });
    }

    public final View u0(View view, MiniAppConfigModel.WindowBean window) {
        Intrinsics.g(view, "view");
        Intrinsics.g(window, "window");
        this.f31394k = window.getRefreshHeaderDelayed();
        this.f31395l = window.getRefreshFooterDelayed();
        l0.a aVarF0 = F0();
        i.b(view);
        Unit unit = Unit.f68710a;
        View viewJ = aVarF0.j(this, view);
        Boolean enablePullDownRefresh = window.getEnablePullDownRefresh();
        Boolean bool = Boolean.TRUE;
        C0(Intrinsics.b(enablePullDownRefresh, bool));
        B0(Intrinsics.b(window.getEnablePullUpRefresh(), bool));
        String refreshHeaderStyle = window.getRefreshHeaderStyle();
        if (refreshHeaderStyle != null && Intrinsics.b(refreshHeaderStyle, "custom")) {
            i0.i iVar = i0.i.f66819a;
            File fileA = iVar.a(window.getRefreshHeaderCustomLoadingGif(), this.f30955b, true);
            File fileA2 = iVar.a(window.getRefreshHeaderCustomSuccessGif(), this.f30955b, true);
            File fileA3 = iVar.a(window.getRefreshHeaderCustomLoading(), this.f30955b, false);
            File fileA4 = iVar.a(window.getRefreshHeaderCustomSuccess(), this.f30955b, false);
            if (fileA != null && fileA2 != null && fileA3 != null && fileA4 != null) {
                F0().a("custom");
                F0().q(Intrinsics.b(window.getRefreshHeaderCustomTextEnable(), bool));
                F0().o(fileA, fileA2, fileA3, fileA4);
            }
        }
        z0(Intrinsics.b(window.getRefreshHeaderTranslationContent(), bool));
        try {
            String refreshHeaderAccentColor = window.getRefreshHeaderAccentColor();
            if (refreshHeaderAccentColor != null && refreshHeaderAccentColor.length() > 0) {
                F0().h(Color.parseColor(refreshHeaderAccentColor));
            }
        } catch (Exception e11) {
            TmcLogger.g("MiniAppBaseFragment", "set header accent color error", e11);
        }
        try {
            String refreshHeaderBackgroundColor = window.getRefreshHeaderBackgroundColor();
            if (refreshHeaderBackgroundColor != null && refreshHeaderBackgroundColor.length() > 0) {
                F0().p(Color.parseColor(refreshHeaderBackgroundColor));
            }
        } catch (Exception e12) {
            TmcLogger.g("MiniAppBaseFragment", "set header background color error", e12);
        }
        try {
            String refreshFooterAccentColor = window.getRefreshFooterAccentColor();
            if (refreshFooterAccentColor != null && refreshFooterAccentColor.length() > 0) {
                F0().c(Color.parseColor(refreshFooterAccentColor));
            }
        } catch (Exception e13) {
            TmcLogger.g("MiniAppBaseFragment", "set footer accent color error", e13);
        }
        try {
            String refreshFooterBackgroundColor = window.getRefreshFooterBackgroundColor();
            if (refreshFooterBackgroundColor != null && refreshFooterBackgroundColor.length() > 0) {
                F0().g(Color.parseColor(refreshFooterBackgroundColor));
            }
        } catch (Exception e14) {
            TmcLogger.g("MiniAppBaseFragment", "set footer background color error", e14);
        }
        return viewJ;
    }

    public final View v0(View view) {
        Intrinsics.g(view, "view");
        l0.b bVarG0 = G0();
        i.b(view);
        Y0(xb.a.b(25));
        return bVarG0.a(view);
    }

    public final synchronized void w0() {
        try {
            TmcLogger.c("MiniAppBaseFragment", "cancelAnimator");
            if (!this.f31399p) {
                return;
            }
            this.f31398o.cancel();
            this.f31399p = false;
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppBaseFragment", th2);
        }
    }

    public final boolean x0() {
        Page page = this.f30954a;
        if (page != null) {
            return xb.c.a(page, new Function0<Unit>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$checkAlertBeforeUnload$1
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
                    FragmentActivity activity = this.this$0.getActivity();
                    OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
                    if (oooO0OO != null) {
                        oooO0OO.G0();
                    }
                }
            });
        }
        return false;
    }

    public final void y0() {
        IBackPressedProcessor backPressedProcessor;
        List<qb.a> interceptors;
        Object next;
        App app;
        IBackPressedProcessor backPressedProcessor2;
        try {
            App app2 = this.f30955b;
            if (app2 == null || (backPressedProcessor = app2.getBackPressedProcessor()) == null || (interceptors = backPressedProcessor.getInterceptors()) == null) {
                return;
            }
            Iterator<T> it = interceptors.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((qb.a) next).a(), "BackToPageIntercept"));
            qb.a aVar = (qb.a) next;
            if (aVar == null || (app = this.f30955b) == null || (backPressedProcessor2 = app.getBackPressedProcessor()) == null) {
                return;
            }
            backPressedProcessor2.removeInterceptors(aVar);
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppBaseFragment", th2.getMessage(), th2);
        }
    }

    public void z0(boolean z11) {
        MiniAppConfigModel.WindowBean window;
        View view;
        if (this.f31392i) {
            F0().OooO00o(z11);
            if (z11 || (window = getWindow()) == null || !Intrinsics.b(window.getEnableTransparentStatusBar(), Boolean.TRUE) || (view = getView()) == null) {
                return;
            }
            view.post(new Runnable() { // from class: kd.h
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.A0(this.f68535a);
                }
            });
        }
    }
}
