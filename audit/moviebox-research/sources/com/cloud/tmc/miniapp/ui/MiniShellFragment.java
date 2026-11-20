package com.cloud.tmc.miniapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.defaultImpl.InjectJSProxyImp;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.proxy.AuthorityProxy;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.MiniShellUtils;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.integration.utils.t;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.base.MiniAppH5BaseFragment;
import com.cloud.tmc.miniapp.ui.MiniShellFragment;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.ImmersiveTitleBarView;
import com.cloud.tmc.miniapp.widget.PageContainerView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import com.cloud.tmc.render.IMonitorWebviewManagerProxy;
import com.cloud.tmc.render.system.ShellWebView;
import com.cloud.tmc.worker.WorkerManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e0.w;
import id.i;
import id.j;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import okhttp3.HttpUrl;
import ua.g;
import zc.f;
import zc.h;
import zc.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class MiniShellFragment extends MiniAppH5BaseFragment implements h, f, hc.a, uc.c, i, g, j {
    public static final /* synthetic */ int U = 0;
    public g.a H;
    public Page I;
    public boolean J;
    public boolean K;
    public uc.b L;
    public String M = "";
    public boolean N;
    public View O;
    public WebChromeClient.CustomViewCallback P;
    public int Q;
    public View R;
    public boolean S;
    public StatusLayout T;

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniShellFragment$hideCustomView$1", f = "MiniShellFragment.kt", l = {747, 748}, m = "invokeSuspend")
    public static final class OooO0O0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;

        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniShellFragment$hideCustomView$1$1", f = "MiniShellFragment.kt", l = {}, m = "invokeSuspend")
        public static final class OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public final /* synthetic */ MiniShellFragment OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(MiniShellFragment miniShellFragment, Continuation<? super OooO00o> continuation) {
                super(2, continuation);
                this.OooO00o = miniShellFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new OooO00o(this.OooO00o, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return new OooO00o(this.OooO00o, continuation).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                ResultKt.b(obj);
                if (this.OooO00o.R == null) {
                    Intrinsics.y("contextView");
                }
                View view = this.OooO00o.R;
                if (view == null) {
                    Intrinsics.y("contextView");
                    view = null;
                }
                view.scrollTo(0, this.OooO00o.Q);
                return Unit.f68710a;
            }
        }

        public OooO0O0(Continuation<? super OooO0O0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MiniShellFragment.this.new OooO0O0(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return MiniShellFragment.this.new OooO0O0(continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.OooO00o;
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            this.OooO00o = 1;
            if (r0.a(500L, this) == objE) {
                return objE;
            }
            a2 a2VarC = w0.c();
            OooO00o oooO00o = new OooO00o(MiniShellFragment.this, null);
            this.OooO00o = 2;
            if (kotlinx.coroutines.h.g(a2VarC, oooO00o, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<Handler> {
        public static final OooO0OO OooO00o = new OooO0OO();

        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniShellFragment$onResume$1", f = "MiniShellFragment.kt", l = {209, 210}, m = "invokeSuspend")
    public static final class OooOO0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;

        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniShellFragment$onResume$1$1", f = "MiniShellFragment.kt", l = {}, m = "invokeSuspend")
        public static final class OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public final /* synthetic */ MiniShellFragment OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(MiniShellFragment miniShellFragment, Continuation<? super OooO00o> continuation) {
                super(2, continuation);
                this.OooO00o = miniShellFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new OooO00o(this.OooO00o, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return new OooO00o(this.OooO00o, continuation).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                ResultKt.b(obj);
                if (this.OooO00o.R == null) {
                    Intrinsics.y("contextView");
                }
                View view = this.OooO00o.R;
                if (view == null) {
                    Intrinsics.y("contextView");
                    view = null;
                }
                view.scrollTo(0, this.OooO00o.Q);
                return Unit.f68710a;
            }
        }

        public OooOO0(Continuation<? super OooOO0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MiniShellFragment.this.new OooOO0(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return MiniShellFragment.this.new OooOO0(continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.OooO00o;
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            this.OooO00o = 1;
            if (r0.a(300L, this) == objE) {
                return objE;
            }
            a2 a2VarC = w0.c();
            OooO00o oooO00o = new OooO00o(MiniShellFragment.this, null);
            this.OooO00o = 2;
            if (kotlinx.coroutines.h.g(a2VarC, oooO00o, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements uc.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uc.b f31712b;

        public a(uc.b bVar) {
            this.f31712b = bVar;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            fe.f webviewBridgeHelper;
            zc.i render;
            zc.i render2;
            Page page = MiniShellFragment.this.f30954a;
            if (!l.w((page == null || (render2 = page.getRender()) == null) ? null : render2.b(), aVar != null ? aVar.b() : null, false, 2, null)) {
                return false;
            }
            Page page2 = MiniShellFragment.this.f30954a;
            View view = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
            ShellWebView shellWebView = view instanceof ShellWebView ? (ShellWebView) view : null;
            if (shellWebView != null && (webviewBridgeHelper = shellWebView.getWebviewBridgeHelper()) != null) {
                webviewBridgeHelper.b();
            }
            MiniShellFragment.b3(MiniShellFragment.this);
            this.f31712b.c("renderOnMessageReady", this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f31713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MiniShellFragment f31714b;

        public b(boolean z11, MiniShellFragment miniShellFragment) {
            this.f31713a = z11;
            this.f31714b = miniShellFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Page page;
            Intrinsics.g(animation, "animation");
            if (this.f31713a) {
                MiniShellFragment miniShellFragment = this.f31714b;
                if (miniShellFragment.K || miniShellFragment.M0(miniShellFragment.getAppLoadResult()) || (page = this.f31714b.f30954a) == null || page.isDestroyed()) {
                    return;
                }
                MiniShellFragment miniShellFragment2 = this.f31714b;
                miniShellFragment2.K = true;
                Page page2 = miniShellFragment2.f30954a;
                if (page2 != null) {
                    page2.getApp();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.g(animation, "animation");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements StatusLayout.b {
        public c() {
        }

        @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
        public void a(StatusLayout statusLayout) {
            Context context = MiniShellFragment.this.getContext();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                oooO0OO.f31730p = true;
            }
            App app = MiniShellFragment.this.f30955b;
            if (app != null) {
                Page page = MiniShellFragment.this.f30954a;
                String pageURI = page != null ? page.getPageURI() : null;
                if (pageURI == null) {
                    pageURI = "";
                }
                app.putPageType(pageURI, 2);
            }
            App app2 = MiniShellFragment.this.f30955b;
            if (app2 != null) {
                Page page2 = MiniShellFragment.this.f30954a;
                String pageURI2 = page2 != null ? page2.getPageURI() : null;
                if (pageURI2 == null) {
                    pageURI2 = "";
                }
                app2.putRouteType(pageURI2, "redirectTo");
            }
            App app3 = MiniShellFragment.this.f30955b;
            if (app3 != null) {
                Page page3 = MiniShellFragment.this.f30954a;
                String pageURI3 = page3 != null ? page3.getPageURI() : null;
                String str = pageURI3 != null ? pageURI3 : "";
                App app4 = MiniShellFragment.this.f30955b;
                Bundle startParams = app4 != null ? app4.getStartParams() : null;
                App app5 = MiniShellFragment.this.f30955b;
                app3.redirectTo(str, startParams, app5 != null ? app5.getSceneParams() : null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements zc.d {
        public d() {
        }

        @Override // zc.d
        public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            FrameLayout frameLayout;
            MiniShellFragment.this.L0().set(true);
            MiniShellFragment miniShellFragment = MiniShellFragment.this;
            if (miniShellFragment.O != null) {
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                return;
            }
            miniShellFragment.O = view;
            g.a aVar = miniShellFragment.H;
            if (aVar == null || (frameLayout = aVar.f65295c) == null) {
                return;
            }
            frameLayout.setVisibility(0);
            FragmentActivity it = miniShellFragment.getActivity();
            if (it != null) {
                Intrinsics.f(it, "it");
                h0.g.e(miniShellFragment, frameLayout, it);
            }
            frameLayout.addView(miniShellFragment.O, 0);
            View view2 = miniShellFragment.R;
            View view3 = null;
            if (view2 == null) {
                Intrinsics.y("contextView");
                view2 = null;
            }
            if (view2 != null) {
                View view4 = miniShellFragment.R;
                if (view4 == null) {
                    Intrinsics.y("contextView");
                } else {
                    view3 = view4;
                }
                miniShellFragment.Q = view3.getScrollY();
            }
            miniShellFragment.P = customViewCallback;
        }

        @Override // zc.d
        public void b() {
            MiniShellFragment.this.L0().set(false);
            MiniShellFragment miniShellFragment = MiniShellFragment.this;
            int i11 = MiniShellFragment.U;
            miniShellFragment.X2(false);
        }
    }

    public MiniShellFragment() {
        LazyKt__LazyJVMKt.b(OooO0OO.OooO00o);
    }

    public static final void Q2(Page page, MiniShellFragment this$0) {
        zc.i render;
        PageContainerView pageContainerView;
        String pageRandomIdByGAId;
        View view;
        zc.i render2;
        String preHtmlCache;
        zc.i render3;
        View view2;
        zc.i render4;
        App app;
        PageContainerView pageContainerView2;
        zc.i render5;
        App app2;
        AppModel appModel;
        Intrinsics.g(this$0, "this$0");
        boolean zCheckFullScreenAuthority = ((AuthorityProxy) tc.a.a(AuthorityProxy.class)).checkFullScreenAuthority(page);
        zc.i render6 = page.getRender();
        if (render6 != null) {
            render6.setSupportFullScreen(zCheckFullScreenAuthority);
        }
        zc.i render7 = page.getRender();
        if (render7 != null) {
            render7.d(this$0);
        }
        zc.i render8 = page.getRender();
        KeyEvent.Callback view3 = render8 != null ? render8.getView() : null;
        k kVar = view3 instanceof k ? (k) view3 : null;
        if (kVar != null) {
            App app3 = this$0.f30955b;
            kVar.setMiniAppType((app3 == null || (appModel = app3.getAppModel()) == null) ? 0 : appModel.getAppinfoCategoryType());
        }
        zc.i render9 = page.getRender();
        View view4 = render9 != null ? render9.getView() : null;
        WebView webView = view4 instanceof WebView ? (WebView) view4 : null;
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings != null) {
            settings.setDomStorageEnabled(true);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            g.a aVar = this$0.H;
            h0.g.h(this$0, page, aVar != null ? aVar.f65295c : null, activity, this$0.f30955b, this$0);
        }
        zc.i render10 = page.getRender();
        if (render10 != null) {
            render10.y(this$0.new d());
        }
        this$0.initView();
        AppLoadResult appLoadResult = this$0.getAppLoadResult();
        Page page2 = this$0.f30954a;
        if (page2 != null && (app2 = page2.getApp()) != null) {
            app2.setData(AppLoadResult.class, appLoadResult);
        }
        try {
            Boolean boolIsDebug = ((BuildConfigProxy) tc.a.a(BuildConfigProxy.class)).isDebug();
            Intrinsics.f(boolIsDebug, "get(BuildConfigProxy::class.java).isDebug");
            if (boolIsDebug.booleanValue() || AppUtils.h()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        } catch (Throwable unused) {
        }
        Page page3 = this$0.f30954a;
        View view5 = (page3 == null || (render5 = page3.getRender()) == null) ? null : render5.getView();
        if (view5 == null) {
            return;
        }
        this$0.R = view5;
        AppLoadResult appLoadResult2 = this$0.getAppLoadResult();
        Page page4 = this$0.f30954a;
        MiniAppConfigModel.WindowBean windowBeanF = d0.f(appLoadResult2, page4 != null ? page4.getPagePath() : null);
        if (windowBeanF != null) {
            try {
                String contentBgColor = windowBeanF.getContentBgColor();
                if (contentBgColor != null && contentBgColor.length() > 0) {
                    int color = Color.parseColor(contentBgColor);
                    g.a aVar2 = this$0.H;
                    if (aVar2 != null && (pageContainerView = aVar2.f65294b) != null) {
                        pageContainerView.setBackgroundColor(color);
                    }
                    Page page5 = this$0.f30954a;
                    if (page5 != null && (render = page5.getRender()) != null) {
                        render.setBgColor(contentBgColor);
                    }
                }
            } catch (Exception e11) {
                TmcLogger.g("MiniShellFragment", "set content background color error", e11);
            }
            Boolean enablePullDownRefresh = windowBeanF.getEnablePullDownRefresh();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.b(enablePullDownRefresh, bool) || Intrinsics.b(windowBeanF.getEnablePullUpRefresh(), bool)) {
                View view6 = this$0.R;
                if (view6 == null) {
                    Intrinsics.y("contextView");
                    view6 = null;
                }
                this$0.R = this$0.u0(view6, windowBeanF);
            }
        }
        g.a aVar3 = this$0.H;
        if (aVar3 != null && (pageContainerView2 = aVar3.f65294b) != null) {
            View view7 = this$0.R;
            if (view7 == null) {
                Intrinsics.y("contextView");
                view7 = null;
            }
            xb.i.b(view7);
            pageContainerView2.addView(view7);
        }
        FragmentActivity activity2 = this$0.getActivity();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity2 instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity2 : null;
        if (oooO0OO != null) {
            oooO0OO.T(MiniAppLaunch.f31784a.Q());
        }
        Page page6 = this$0.f30954a;
        if (page6 != null && (render4 = page6.getRender()) != null && render4.c()) {
            PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class);
            Page page7 = this$0.f30954a;
            performanceImprovesProxy.addPeroformanceImprove((page7 == null || (app = page7.getApp()) == null) ? null : app.getAppId(), "webview");
        }
        Page page8 = this$0.f30954a;
        zc.i render11 = page8 != null ? page8.getRender() : null;
        Page page9 = this$0.f30954a;
        App app4 = page9 != null ? page9.getApp() : null;
        zc.l lVar = new zc.l();
        Page page10 = this$0.f30954a;
        lVar.f81893a = page10 != null ? page10.getPageURI() : null;
        Page page11 = this$0.f30954a;
        lVar.f81894b = page11 != null ? page11.getPagePath() : null;
        lVar.f81895c = app4 != null ? app4.getAppId() : null;
        this$0.n2();
        this$0.l2();
        this$0.c2();
        this$0.a2();
        this$0.r2();
        this$0.p2();
        this$0.j2();
        Page page12 = this$0.f30954a;
        String strValueOf = String.valueOf(page12 != null ? page12.getPageURI() : null);
        Page page13 = this$0.f30954a;
        this$0.o2(strValueOf, String.valueOf(page13 != null ? page13.getPageId() : null));
        Page page14 = this$0.f30954a;
        String strValueOf2 = String.valueOf(page14 != null ? page14.getPageURI() : null);
        Page page15 = this$0.f30954a;
        this$0.m2(strValueOf2, String.valueOf(page15 != null ? page15.getPageId() : null));
        Page page16 = this$0.f30954a;
        String strValueOf3 = String.valueOf(page16 != null ? page16.getPageURI() : null);
        Page page17 = this$0.f30954a;
        this$0.d2(strValueOf3, String.valueOf(page17 != null ? page17.getPageId() : null));
        Page page18 = this$0.f30954a;
        String strValueOf4 = String.valueOf(page18 != null ? page18.getPageURI() : null);
        Page page19 = this$0.f30954a;
        this$0.b2(strValueOf4, String.valueOf(page19 != null ? page19.getPageId() : null));
        Page page20 = this$0.f30954a;
        String strValueOf5 = String.valueOf(page20 != null ? page20.getPageURI() : null);
        Page page21 = this$0.f30954a;
        this$0.s2(strValueOf5, String.valueOf(page21 != null ? page21.getPageId() : null));
        Page page22 = this$0.f30954a;
        String strValueOf6 = String.valueOf(page22 != null ? page22.getPageURI() : null);
        Page page23 = this$0.f30954a;
        this$0.q2(strValueOf6, String.valueOf(page23 != null ? page23.getPageId() : null));
        Page page24 = this$0.f30954a;
        String strValueOf7 = String.valueOf(page24 != null ? page24.getPageURI() : null);
        Page page25 = this$0.f30954a;
        this$0.u2(strValueOf7, String.valueOf(page25 != null ? page25.getPageId() : null));
        Page page26 = this$0.f30954a;
        String strValueOf8 = String.valueOf(page26 != null ? page26.getPageURI() : null);
        Page page27 = this$0.f30954a;
        this$0.t2(strValueOf8, String.valueOf(page27 != null ? page27.getPageId() : null));
        Page page28 = this$0.f30954a;
        String strValueOf9 = String.valueOf(page28 != null ? page28.getPageURI() : null);
        Page page29 = this$0.f30954a;
        this$0.k2(strValueOf9, String.valueOf(page29 != null ? page29.getPageId() : null));
        Page page30 = this$0.f30954a;
        if (page30 == null || (pageRandomIdByGAId = page30.getPageRandomIdByGAId()) == null) {
            pageRandomIdByGAId = "null";
        }
        this$0.O1(pageRandomIdByGAId);
        Context context = this$0.getContext();
        if (context != null && render11 != null && (view2 = render11.getView()) != null) {
            Integer num = 2;
            view2.setBackgroundColor(z2.a.getColor(context, (num != null && num.intValue() == 2) ? R$color.mini_color_white : R$color.mini_color_bg_01));
        }
        Page page31 = this$0.f30954a;
        View view8 = (page31 == null || (render3 = page31.getRender()) == null) ? null : render3.getView();
        this$0.K1(view8 instanceof WebView ? (WebView) view8 : null, InjectJSProxyImp.STRATEGY_INJECT_JS_IN_PRELOADURL);
        if (render11 != null) {
            try {
                view = render11.getView();
            } catch (Throwable th2) {
                this$0.N = false;
                if (render11 != null) {
                    render11.k(lVar);
                }
                TmcLogger.h("MiniShellFragment", th2);
            }
        } else {
            view = null;
        }
        ShellWebView shellWebView = view instanceof ShellWebView ? (ShellWebView) view : null;
        if (shellWebView == null || !shellWebView.isOffScreenRender()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load Shell url -> ");
            sb2.append(render11 != null ? Boolean.valueOf(render11.c()) : null);
            TmcLogger.c("nevermore", sb2.toString());
            if (MiniAppConfigHelper.f30370a.b("enableShellPreRequest", true)) {
                String md5 = com.cloud.tmc.miniutils.util.h.b(lVar.f81893a);
                TmcLogger.c("MiniShellFragment", "md5 -> " + md5);
                Context context2 = this$0.getContext();
                if (context2 != null) {
                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) tc.a.a(PreHtmStrategyProxy.class);
                    Intrinsics.f(md5, "md5");
                    preHtmlCache = preHtmStrategyProxy.getPreHtmlCache(context2, md5, 1, true);
                    if (preHtmlCache == null) {
                        preHtmlCache = "";
                    }
                } else {
                    preHtmlCache = "";
                }
                String str = preHtmlCache;
                if (str.length() > 0) {
                    this$0.N = true;
                    this$0.J2(true);
                    String str2 = lVar.f81893a;
                    Intrinsics.f(str2, "loadParams.url");
                    this$0.M = str2;
                    if (render11 != null) {
                        render11.n(lVar, str, "text/html", "UTF-8", null);
                    }
                    TmcLogger.c("MiniShellFragment", "use loadDataWithBaseURL -> url is " + lVar.f81893a);
                    ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app4 != null ? app4.getAppId() : null, "preHtml");
                } else {
                    TmcLogger.c("MiniShellFragment", "use http -> url is " + lVar.f81893a);
                    if (render11 != null) {
                        render11.k(lVar);
                    }
                }
            } else {
                TmcLogger.c("MiniShellFragment", "use http -> url is " + lVar.f81893a);
                if (render11 != null) {
                    render11.k(lVar);
                }
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("load Shell offscreen -> warmup: ");
            sb3.append(render11 != null ? Boolean.valueOf(render11.c()) : null);
            sb3.append(", loadDataWithBaseURL: ");
            View view9 = render11 != null ? render11.getView() : null;
            ShellWebView shellWebView2 = view9 instanceof ShellWebView ? (ShellWebView) view9 : null;
            sb3.append(shellWebView2 != null ? Boolean.valueOf(shellWebView2.isLoadDataWithBaseURL()) : null);
            TmcLogger.c("nevermore", sb3.toString());
            View view10 = render11.getView();
            ShellWebView shellWebView3 = view10 instanceof ShellWebView ? (ShellWebView) view10 : null;
            if (shellWebView3 != null && shellWebView3.isLoadDataWithBaseURL()) {
                this$0.N = true;
                this$0.J2(true);
                String str3 = lVar.f81893a;
                Intrinsics.f(str3, "loadParams.url");
                this$0.M = str3;
                ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app4 != null ? app4.getAppId() : null, "preHtml");
            }
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app4 != null ? app4.getAppId() : null, "offScreenRender");
        }
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app4);
        if (eventCenterInstance != null) {
            fc.a aVar4 = new fc.a("pageEnter");
            Page page32 = this$0.f30954a;
            aVar4.d((page32 == null || (render2 = page32.getRender()) == null) ? null : render2.b());
            Unit unit = Unit.f68710a;
            eventCenterInstance.d("renderOnMessageReady", aVar4);
        }
        this$0.J1(2);
        Page page33 = this$0.f30954a;
        String strValueOf10 = String.valueOf(page33 != null ? page33.getPageURI() : null);
        Page page34 = this$0.f30954a;
        MiniAppH5BaseFragment.g2(this$0, strValueOf10, String.valueOf(page34 != null ? page34.getPageId() : null), false, 4, null);
    }

    public static final void R2(MiniShellFragment this$0, int i11, int i12, long j11) {
        Intrinsics.g(this$0, "this$0");
        this$0.changeNavigationBarProgress(i11 + 1, i12, j11);
    }

    public static final void S2(MiniShellFragment this$0, View view) {
        zc.i render;
        Intrinsics.g(this$0, "this$0");
        Page page = this$0.f30954a;
        View view2 = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        WebView webView = view2 instanceof WebView ? (WebView) view2 : null;
        if (this$0.u1(webView)) {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView != null ? webView.copyBackForwardList() : null;
            if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() != 0) {
                Page page2 = this$0.f30954a;
                if (page2 != null) {
                    page2.setNavigationBarTitleVisible(false);
                    return;
                }
                return;
            }
            Page page3 = this$0.f30954a;
            if (page3 != null) {
                page3.hideHomeButton();
            }
            Page page4 = this$0.f30954a;
            if (page4 != null) {
                page4.setNavigationBarTitleVisible(true);
            }
        }
    }

    public static final void T2(MiniShellFragment this$0, Page page) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(page, "$page");
        g.a aVar = this$0.H;
        if ((aVar != null ? aVar.f65293a : null) == null) {
            this$0.I = page;
            return;
        }
        this$0.I2(String.valueOf(page.getPageURI()), true, String.valueOf(page.getPageId()));
        String strValueOf = String.valueOf(page.getPageURI());
        String strValueOf2 = String.valueOf(page.getPageId());
        PageChainContext pageChainContext = this$0.f30956c;
        Intrinsics.f(pageChainContext, "pageChainContext");
        this$0.t1("", "", strValueOf, strValueOf2, pageChainContext);
        this$0.V1(String.valueOf(page.getPageURI()), String.valueOf(page.getPageId()));
        this$0.U1(String.valueOf(page.getPageURI()), String.valueOf(page.getPageId()));
        this$0.y2();
        this$0.P2(page);
        try {
            App app = this$0.f30955b;
            if ((app != null ? app.getAppLifecycleCallback() : null) == null) {
                TmcLogger.c("MiniShellFragment", "setMiniappLifecycleCallback");
                App app2 = this$0.f30955b;
                if (app2 != null) {
                    FragmentActivity activity = this$0.getActivity();
                    app2.setMiniappLifecycleCallback(activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniShellFragment", th2);
        }
    }

    public static final void U2(com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO, View view) {
        if (oooO0OO != null) {
            oooO0OO.m0((1 & 1) != 0 ? "0" : null);
        }
    }

    public static final void Z2(MiniShellFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.X2(false);
    }

    public static final void a3(com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO, View view) {
        if (oooO0OO != null) {
            oooO0OO.I0();
        }
    }

    public static final void b3(MiniShellFragment miniShellFragment) {
        gd.b workerById;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app2;
        IEngine engineProxy2;
        App app3;
        App app4;
        Bundle startParams;
        miniShellFragment.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
        String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
        Page page = miniShellFragment.f30954a;
        bundle.putString(str, String.valueOf((page == null || (app4 = page.getApp()) == null || (startParams = app4.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
        String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page2 = miniShellFragment.f30954a;
        bundle.putString(str2, miniShellFragment.D1(String.valueOf(page2 != null ? page2.getPageURI() : null)));
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page3 = miniShellFragment.f30954a;
        performanceAnalyseProxy.record((page3 == null || (app3 = page3.getApp()) == null) ? null : app3.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31228p, bundle);
        FragmentActivity activity = miniShellFragment.getActivity();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        if (oooO0OO != null && oooO0OO.f31727m) {
            MiniAppBaseFragment.R0(miniShellFragment, "appReady", null, 2, null);
            FragmentActivity activity2 = miniShellFragment.getActivity();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO2 = activity2 instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity2 : null;
            if (oooO0OO2 == null) {
                return;
            }
            oooO0OO2.f31727m = false;
            return;
        }
        MiniAppBaseFragment.R0(miniShellFragment, "pageReady", null, 2, null);
        Page page4 = miniShellFragment.f30954a;
        if (page4 == null || (app = page4.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            workerById = null;
        } else {
            Page page5 = miniShellFragment.f30954a;
            workerById = engineRouter.getWorkerById((page5 == null || (app2 = page5.getApp()) == null || (engineProxy2 = app2.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (workerById != null && Intrinsics.b(workerById.n(), Boolean.TRUE)) {
            MiniAppBaseFragment.V0(miniShellFragment, null, 1, null);
            return;
        }
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
        Page page6 = miniShellFragment.f30954a;
        uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(page6 != null ? page6.getApp() : null);
        if (eventCenterInstance != null) {
            eventCenterInstance.b(WorkerManager.f32140n.a(), new w(miniShellFragment));
        }
    }

    public static final void c3(MiniShellFragment this$0) {
        gd.b workerById;
        zc.i render;
        App app;
        zc.i render2;
        App app2;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app3;
        IEngine engineProxy2;
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        String appId = null;
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        if (oooO0OO != null) {
            oooO0OO.f31727m = true;
        }
        Page page = this$0.f30954a;
        if (page == null || (app2 = page.getApp()) == null || (engineProxy = app2.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            workerById = null;
        } else {
            Page page2 = this$0.f30954a;
            workerById = engineRouter.getWorkerById((page2 == null || (app3 = page2.getApp()) == null || (engineProxy2 = app3.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (workerById != null) {
            workerById.f();
        }
        Page page3 = this$0.f30954a;
        View view = (page3 == null || (render2 = page3.getRender()) == null) ? null : render2.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        }
        if (this$0.getAppLoadResult() != null) {
            uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this$0.f30955b);
            if (eventCenterInstance != null) {
                eventCenterInstance.b("renderOnMessageReady", this$0.new a(eventCenterInstance));
            }
            zc.l lVar = new zc.l();
            Page page4 = this$0.f30954a;
            lVar.f81893a = page4 != null ? page4.getPageURI() : null;
            Page page5 = this$0.f30954a;
            lVar.f81894b = page5 != null ? page5.getPagePath() : null;
            Page page6 = this$0.f30954a;
            if (page6 != null && (app = page6.getApp()) != null) {
                appId = app.getAppId();
            }
            lVar.f81895c = appId;
            Page page7 = this$0.f30954a;
            if (page7 == null || (render = page7.getRender()) == null) {
                return;
            }
            render.k(lVar);
        }
    }

    public static final void d3(MiniShellFragment this$0) {
        boolean z11;
        Intrinsics.g(this$0, "this$0");
        try {
            c cVar = this$0.new c();
            int i11 = R$string.loading_error_tv;
            App app = this$0.f30955b;
            String appId = app != null ? app.getAppId() : null;
            FragmentActivity activity = this$0.getActivity();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
            i.a.e(this$0, cVar, i11, "", appId, oooO0OO != null ? h0.k.a(oooO0OO) : null);
            Integer num = 2;
            if (num != null) {
                z11 = true;
                if (num.intValue() == 1) {
                }
                this$0.setCapsuleStyle(z11);
            }
            z11 = false;
            this$0.setCapsuleStyle(z11);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, id.g
    public void I() {
        super.I();
        TmcLogger.b("[MiniFragment]：onRefreshEvent");
        MiniAppBaseFragment.T0(this, "onPullDownRefresh", true, null, 4, null);
    }

    @Override // uc.c
    public boolean O(uc.a aVar) {
        Map<String, Object> data;
        if (aVar == null) {
            return false;
        }
        try {
            String name = aVar.getName();
            if (name == null) {
                return false;
            }
            Page page = this.f30954a;
            if (!name.equals(page != null ? page.getPageId() : null) || (data = aVar.getData()) == null || !data.containsKey("eventData")) {
                return false;
            }
            Object obj = data.get("eventData");
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
            ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Page page2 = this.f30954a;
                iCommunicationTimeProxy.plusTime(page2 != null ? page2.getPageId() : null, jLongValue);
                Page page3 = this.f30954a;
                iCommunicationTimeProxy.plusNum(page3 != null ? page3.getPageId() : null, 1);
            }
            return false;
        } catch (Exception unused) {
            p.e("miniapp", "parse consumeTime from EventCenter fail");
            return false;
        }
    }

    public final void O2() {
        try {
            Page page = this.f30954a;
            if (page == null || !page.isShow()) {
                return;
            }
            Page page2 = this.f30954a;
            if (page2 != null) {
                page2.hideHomeButton();
            }
            Page page3 = this.f30954a;
            if (page3 != null) {
                page3.setNavigationBarIconStyle(false);
            }
            g.a aVar = this.H;
            ProgressBar progressBar = aVar != null ? aVar.f65297f : null;
            if (progressBar == null) {
                return;
            }
            MiniAppConfigModel.WindowBean window = getWindow();
            progressBar.setTag(Boolean.valueOf(window != null ? Intrinsics.b(window.getEnableNavigationBarLoading(), Boolean.TRUE) : false));
        } catch (Throwable th2) {
            TmcLogger.h("MiniShellFragment", th2);
        }
    }

    public final void P2(final Page page) {
        try {
            this.f30954a = page;
            ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).start(this.f30955b, String.valueOf(page.getPageURI()));
            FragmentActivity activity = getActivity();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
            page.bindContext(this, Boolean.valueOf(oooO0OO != null ? oooO0OO.f31727m : false), new Page.b() { // from class: qd.m
                @Override // com.cloud.tmc.integration.structure.Page.b
                public final void success() {
                    MiniShellFragment.Q2(page, this);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniShellFragment", "setPageOnMain error", th2);
        }
    }

    @Override // ua.g
    public void Q(zc.i iVar, zc.l loadParams) {
        Intrinsics.g(loadParams, "loadParams");
        StringBuilder sb2 = new StringBuilder();
        Node nodeI = iVar != null ? iVar.i() : null;
        PageNode pageNode = nodeI instanceof PageNode ? (PageNode) nodeI : null;
        sb2.append(pageNode != null ? pageNode.getPageId() : null);
        sb2.append('_');
        sb2.append(B1().addAndGet(1));
        String string = sb2.toString();
        V2(iVar, loadParams, string);
        if (iVar != null) {
            iVar.k(loadParams);
        }
        W2(loadParams, string);
    }

    @Override // tb.d
    public ProgressBar S() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65297f;
        }
        return null;
    }

    public final void V2(zc.i iVar, zc.l lVar, String str) {
        String pageRandomIdByGAId;
        App app;
        try {
            String strD = r.d(String.valueOf(lVar.f81893a));
            String str2 = "";
            if (strD == null) {
                strD = "";
            }
            I2(strD, true, str);
            String strD2 = r.d(String.valueOf(lVar.f81893a));
            String str3 = strD2 == null ? "" : strD2;
            PageChainContext pageChainContext = new PageChainContext();
            App app2 = this.f30955b;
            String appId = null;
            pageChainContext.E(app2 != null ? app2.getAppChainContext() : null);
            Unit unit = Unit.f68710a;
            t1("", "", str3, str, pageChainContext);
            y2();
            FragmentActivity activity = getActivity();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
            if (oooO0OO != null && !oooO0OO.f31727m) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Node nodeI = iVar != null ? iVar.i() : null;
                PageNode pageNode = nodeI instanceof PageNode ? (PageNode) nodeI : null;
                if (pageNode != null && (app = pageNode.getApp()) != null) {
                    appId = app.getAppId();
                }
                performanceAnalyseProxy.record(appId, PointAnalyseType.POINT_PAGE_PV, "");
            }
            Y1();
            W1();
            n2();
            l2();
            c2();
            a2();
            r2();
            p2();
            j2();
            String strD3 = r.d(String.valueOf(lVar.f81893a));
            if (strD3 == null) {
                strD3 = "";
            }
            V1(strD3, str);
            String strD4 = r.d(String.valueOf(lVar.f81893a));
            if (strD4 == null) {
                strD4 = "";
            }
            U1(strD4, str);
            String strD5 = r.d(String.valueOf(lVar.f81893a));
            if (strD5 == null) {
                strD5 = "";
            }
            Z1(strD5, str);
            String strD6 = r.d(String.valueOf(lVar.f81893a));
            if (strD6 == null) {
                strD6 = "";
            }
            X1(strD6, str);
            String strD7 = r.d(String.valueOf(lVar.f81893a));
            if (strD7 == null) {
                strD7 = "";
            }
            o2(strD7, str);
            String strD8 = r.d(String.valueOf(lVar.f81893a));
            if (strD8 == null) {
                strD8 = "";
            }
            m2(strD8, str);
            String strD9 = r.d(String.valueOf(lVar.f81893a));
            if (strD9 == null) {
                strD9 = "";
            }
            d2(strD9, str);
            String strD10 = r.d(String.valueOf(lVar.f81893a));
            if (strD10 == null) {
                strD10 = "";
            }
            b2(strD10, str);
            String strD11 = r.d(String.valueOf(lVar.f81893a));
            if (strD11 == null) {
                strD11 = "";
            }
            s2(strD11, str);
            String strD12 = r.d(String.valueOf(lVar.f81893a));
            if (strD12 == null) {
                strD12 = "";
            }
            q2(strD12, str);
            String strD13 = r.d(String.valueOf(lVar.f81893a));
            if (strD13 == null) {
                strD13 = "";
            }
            u2(strD13, str);
            String strD14 = r.d(String.valueOf(lVar.f81893a));
            if (strD14 == null) {
                strD14 = "";
            }
            t2(strD14, str);
            String strD15 = r.d(String.valueOf(lVar.f81893a));
            if (strD15 != null) {
                str2 = strD15;
            }
            k2(str2, str);
            Page page = this.f30954a;
            if (page == null || (pageRandomIdByGAId = page.getPageRandomIdByGAId()) == null) {
                pageRandomIdByGAId = "null";
            }
            O1(pageRandomIdByGAId);
        } catch (Throwable unused) {
        }
    }

    public final void W2(zc.l lVar, String str) {
        try {
            String strD = r.d(String.valueOf(lVar.f81893a));
            if (strD == null) {
                strD = "";
            }
            MiniAppH5BaseFragment.g2(this, strD, str, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    public final boolean X2(boolean z11) {
        FrameLayout frameLayout;
        if (this.O == null) {
            return false;
        }
        if (z11) {
            this.S = true;
        }
        kotlinx.coroutines.j.d(l0.a(w0.a()), null, null, new OooO0O0(null), 3, null);
        g.a aVar = this.H;
        if (aVar != null && (frameLayout = aVar.f65295c) != null) {
            frameLayout.setVisibility(8);
            frameLayout.removeView(this.O);
        }
        View view = this.O;
        if (view != null) {
            view.setVisibility(8);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.P;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.O = null;
        this.P = null;
        if (E0()) {
            j1();
        }
        h0.g.l(this);
        return true;
    }

    @Override // tb.d
    public ub.b a0() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65298g;
        }
        return null;
    }

    @Override // vb.c
    public void changeNavigationBarProgress(final int i11, final int i12, final long j11) {
        ProgressBar progressBar;
        if (i11 > i12) {
            b1(false);
            return;
        }
        b1(true);
        g.a aVar = this.H;
        if (aVar != null && (progressBar = aVar.f65297f) != null) {
            progressBar.postDelayed(new Runnable() { // from class: qd.l
                @Override // java.lang.Runnable
                public final void run() {
                    MiniShellFragment.R2(this.f74521a, i11, i12, j11);
                }
            }, j11);
        }
        onProgressChanged(null, i11);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, id.g
    public void d0() {
        super.d0();
        TmcLogger.b("[MiniFragment]：onLoadMoreEvent");
        MiniAppBaseFragment.T0(this, "onReachBottom", true, null, 4, null);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, tb.d
    public void destroy() {
        zc.i render;
        zc.i render2;
        zc.i render3;
        uc.b bVar = this.L;
        if (bVar != null) {
            bVar.c("consumeTime", this);
        }
        h0.g.f(this, this.f30954a);
        IScreenInspectProxy iScreenInspectProxy = (IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class);
        Page page = this.f30954a;
        App app = page != null ? page.getApp() : null;
        Page page2 = this.f30954a;
        iScreenInspectProxy.destroy(app, String.valueOf(page2 != null ? page2.getPageURI() : null));
        Page page3 = this.f30954a;
        if (page3 == null || (render2 = page3.getRender()) == null || !render2.c()) {
            Page page4 = this.f30954a;
            if (page4 != null && (render = page4.getRender()) != null) {
                render.destroy();
            }
        } else {
            IInnerRenderPool iInnerRenderPool = (IInnerRenderPool) tc.a.a(IInnerRenderPool.class);
            Page page5 = this.f30954a;
            iInnerRenderPool.removeRender((page5 == null || (render3 = page5.getRender()) == null) ? null : render3.b());
            Object objA = tc.a.a(IInnerH5WebviewPool.class);
            Intrinsics.f(objA, "get(IInnerH5WebviewPool::class.java)");
            IInnerH5WebviewPool iInnerH5WebviewPool = (IInnerH5WebviewPool) objA;
            Page page6 = this.f30954a;
            IInnerH5WebviewPool.a.a(iInnerH5WebviewPool, page6 != null ? page6.getRender() : null, false, 2, null);
            OffScreenWebviewPool offScreenWebviewPool = OffScreenWebviewPool.f30871a;
            Page page7 = this.f30954a;
            offScreenWebviewPool.h(page7 != null ? page7.getRender() : null);
        }
        try {
            Page page8 = this.f30954a;
            App app2 = page8 != null ? page8.getApp() : null;
            if (app2 == null) {
                return;
            }
            app2.setLoadHtmlDataCallback(null);
        } catch (Throwable th2) {
            TmcLogger.h("MiniShellFragment", th2);
        }
    }

    @Override // hc.a
    public void f() {
        hc.b.f66421b = true;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: qd.j
                @Override // java.lang.Runnable
                public final void run() {
                    MiniShellFragment.c3(this.f74515a);
                }
            });
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public boolean f1() {
        zc.i render;
        Page page = this.f30954a;
        View view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        return u1(view instanceof WebView ? (WebView) view : null);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.TmcFragment
    public Boolean g0() {
        return Boolean.FALSE;
    }

    @Override // id.i
    public StatusLayout getStatusLayout() {
        return this.T;
    }

    @Override // id.i
    public Integer getViewThemeMode() {
        return 2;
    }

    @Override // vb.c
    public void hideNavigationBarLoading() {
        ProgressBar progressBar;
        g.a aVar = this.H;
        ProgressBar progressBar2 = aVar != null ? aVar.f65297f : null;
        if (progressBar2 != null) {
            progressBar2.setTag(Boolean.FALSE);
        }
        g.a aVar2 = this.H;
        if (aVar2 == null || (progressBar = aVar2.f65297f) == null) {
            return;
        }
        xb.i.c(progressBar);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void initView() {
        String navigationBarTitleText;
        super.initView();
        FragmentActivity activity = getActivity();
        String str = null;
        final com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        EntryInfo entryInfoD0 = D0();
        g.a aVar = this.H;
        if (aVar != null) {
            ImmersiveTitleBarView immersiveTitleBarView = aVar.f65299h;
            immersiveTitleBarView.attachPage(this.f30954a);
            MiniAppConfigModel.WindowBean window = getWindow();
            if (window != null && (navigationBarTitleText = window.getNavigationBarTitleText()) != null) {
                str = navigationBarTitleText;
            } else if (entryInfoD0 != null) {
                str = entryInfoD0.title;
            }
            immersiveTitleBarView.setTitle(str);
            immersiveTitleBarView.setOnAddScreenClickListener(new View.OnClickListener() { // from class: qd.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniShellFragment.U2(oooO0OO, view);
                }
            });
            immersiveTitleBarView.setOnHomeClickListener(new View.OnClickListener() { // from class: qd.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniShellFragment.a3(oooO0OO, view);
                }
            });
            immersiveTitleBarView.setOnBackClickListener(new View.OnClickListener() { // from class: qd.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniShellFragment.S2(this.f74537a, view);
                }
            });
            TabBarView v11 = aVar.f65298g;
            Intrinsics.f(v11, "v");
            Page page = this.f30954a;
            xb.i.f(v11, page != null && page.isTabPage());
            Page page2 = this.f30954a;
            if (page2 != null && page2.isTabPage()) {
                ub.b.a.a(v11, d0.d(getAppLoadResult()), this.f30954a, null, 4, null);
            }
        }
        try {
            O2();
        } catch (Throwable th2) {
            TmcLogger.g("MiniShellFragment", "", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, com.cloud.tmc.integration.ui.fragment.TmcFragment
    public void j0(final Page page) {
        AppModel appModel;
        ExtendModel extend;
        Intrinsics.g(page, "page");
        g.a aVar = this.H;
        if ((aVar != null ? aVar.f65293a : null) == null) {
            App app = page.getApp();
            String h5Url = (app == null || (appModel = app.getAppModel()) == null || (extend = appModel.getExtend()) == null) ? null : extend.getH5Url();
            App app2 = page.getApp();
            String strB = com.cloud.tmc.kernel.utils.i.b(h5Url, app2 != null ? app2.getStartParams() : null);
            if (h5Url != null) {
                F1().put(h5Url, strB);
            }
            PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
            if (pageNode != null) {
                pageNode.setPageURI(strB);
            }
        }
        this.f30954a = page;
        App app3 = (App) page.bubbleFindNode(App.class);
        this.f30955b = app3;
        if (app3 != null) {
            Page page2 = this.f30954a;
            String pageURI = page2 != null ? page2.getPageURI() : null;
            if (pageURI == null) {
                pageURI = "";
            }
            app3.putPageType(pageURI, 2);
        }
        e.f(new Runnable() { // from class: qd.k
            @Override // java.lang.Runnable
            public final void run() {
                MiniShellFragment.T2(this.f74518a, page);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        try {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), i12);
            Intrinsics.f(animationLoadAnimation, "loadAnimation(activity, nextAnim)");
            animationLoadAnimation.setAnimationListener(new b(z11, this));
            return animationLoadAnimation;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View viewV0;
        Intrinsics.g(inflater, "inflater");
        this.H = g.a.a(inflater);
        Page page = this.f30954a;
        if (page == null || !page.isTabPage()) {
            g.a aVar = this.H;
            Intrinsics.d(aVar);
            ConstraintLayout constraintLayout = aVar.f65293a;
            Intrinsics.f(constraintLayout, "binding!!.root");
            viewV0 = v0(constraintLayout);
        } else {
            g.a aVar2 = this.H;
            Intrinsics.d(aVar2);
            viewV0 = aVar2.f65293a;
            Intrinsics.f(viewV0, "binding!!.root");
        }
        this.T = (StatusLayout) viewV0.findViewById(R$id.sl_status);
        xb.i.b(viewV0);
        return viewV0;
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IMonitorWebviewManagerProxy) tc.a.a(IMonitorWebviewManagerProxy.class)).unRegisterMonitorListener(this);
        i0(TmcFragment.ExitType.BACK);
        Q1();
        S1();
        x1();
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        PageContainerView pageContainerView;
        super.onDestroyView();
        hc.c.c(this);
        g.a aVar = this.H;
        if (aVar != null && (pageContainerView = aVar.f65294b) != null) {
            pageContainerView.removeAllViews();
        }
        this.H = null;
        Page page = this.f30954a;
        if (page != null) {
            ((EngineRouter) tc.a.a(EngineRouter.class)).unRegisterRender(page.getPageId());
        }
    }

    @Override // zc.f
    public void onPageFinished(WebView webView, String str) {
        boolean z11;
        App app;
        String appId;
        zc.i render;
        zc.i render2;
        O2();
        if (webView != null && webView.getProgress() == 100) {
            Page page = this.f30954a;
            View view = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
            K1(view instanceof WebView ? (WebView) view : null, InjectJSProxyImp.STRATEGY_INJECT_JS_IN_PAGEFINISHED);
            Page page2 = this.f30954a;
            View view2 = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
            WebView webView2 = view2 instanceof WebView ? (WebView) view2 : null;
            if (webView2 != null) {
                StringBuilder sbA = hd.j.a("javascript:window.pageId=");
                Page page3 = this.f30954a;
                sbA.append(page3 != null ? page3.getPageId() : null);
                sbA.append(';');
                webView2.loadUrl(sbA.toString());
            }
            h0.g.d(this);
            Page page4 = this.f30954a;
            if (page4 != null && (app = page4.getApp()) != null && (appId = app.getAppId()) != null) {
                ((IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
            }
            x2(webView, str);
        }
        try {
            Integer num = 2;
            if (num != null) {
                z11 = true;
                if (num.intValue() == 1) {
                }
                setCapsuleStyle(z11);
            }
            z11 = false;
            setCapsuleStyle(z11);
        } catch (Throwable th2) {
            TmcLogger.g("MiniShellFragment", "", th2);
        }
    }

    @Override // zc.f
    public void onPageStarted(WebView webView, String str) {
        App app;
        String appId;
        zc.i render;
        try {
            Page page = this.f30954a;
            View view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
            K1(view instanceof WebView ? (WebView) view : null, InjectJSProxyImp.STRATEGY_INJECT_JS_IN_PAGESTAET);
            if (this.N || Intrinsics.b(this.M, str)) {
                Page page2 = this.f30954a;
                if (page2 != null && (app = page2.getApp()) != null && (appId = app.getAppId()) != null) {
                    TmcLogger.c("MiniShellFragment", "load htmlData ,close loading page");
                    ((IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
                }
                this.N = false;
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniShellFragment", th2);
        }
        G2(webView, str);
        D2(webView, str);
        J1(2);
    }

    @Override // zc.h
    public void onProgressChanged(WebView webView, int i11) {
        ProgressBar progressBar;
        App app;
        String appId;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        ProgressBar progressBar5;
        g.a aVar;
        ProgressBar progressBar6;
        g.a aVar2 = this.H;
        if (aVar2 != null && (progressBar4 = aVar2.f65297f) != null && Intrinsics.b(progressBar4.getTag(), Boolean.FALSE)) {
            g.a aVar3 = this.H;
            if (aVar3 == null || (progressBar5 = aVar3.f65297f) == null || !xb.i.a(progressBar5) || (aVar = this.H) == null || (progressBar6 = aVar.f65297f) == null) {
                return;
            }
            xb.i.c(progressBar6);
            return;
        }
        if (this.J) {
            this.J = false;
            g.a aVar4 = this.H;
            if (aVar4 != null && (progressBar3 = aVar4.f65297f) != null) {
                xb.i.e(progressBar3);
            }
        }
        if (i11 == 0) {
            g.a aVar5 = this.H;
            if (aVar5 != null && (progressBar = aVar5.f65297f) != null) {
                xb.i.e(progressBar);
            }
        } else if (i11 != 100) {
            g.a aVar6 = this.H;
            ProgressBar progressBar7 = aVar6 != null ? aVar6.f65297f : null;
            if (progressBar7 != null) {
                progressBar7.setProgress(i11);
            }
        } else if (!this.J) {
            this.J = true;
            g.a aVar7 = this.H;
            if (aVar7 != null && (progressBar2 = aVar7.f65297f) != null) {
                xb.i.c(progressBar2);
            }
        }
        if (i11 == 100) {
            Page page = this.f30954a;
            if (page != null && (app = page.getApp()) != null && (appId = app.getAppId()) != null) {
                ((IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
            }
            MiniAppH5BaseFragment.ProgressStep progressStep = MiniAppH5BaseFragment.ProgressStep.STEP_100;
            L2(progressStep);
            M2(progressStep);
            N1();
            z2(webView);
            return;
        }
        A2(webView, i11);
        if (i11 >= 70) {
            MiniAppH5BaseFragment.ProgressStep progressStep2 = MiniAppH5BaseFragment.ProgressStep.STEP_70;
            L2(progressStep2);
            M2(progressStep2);
        } else if (i11 >= 50) {
            MiniAppH5BaseFragment.ProgressStep progressStep3 = MiniAppH5BaseFragment.ProgressStep.STEP_50;
            L2(progressStep3);
            M2(progressStep3);
        } else if (i11 >= 30) {
            MiniAppH5BaseFragment.ProgressStep progressStep4 = MiniAppH5BaseFragment.ProgressStep.STEP_30;
            L2(progressStep4);
            M2(progressStep4);
        } else {
            MiniAppH5BaseFragment.ProgressStep progressStep5 = MiniAppH5BaseFragment.ProgressStep.INIT;
            L2(progressStep5);
            M2(progressStep5);
        }
    }

    @Override // zc.f
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest != null) {
            try {
                if (webResourceRequest.isForMainFrame()) {
                    M1();
                    Context context = getContext();
                    com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
                    long j11 = (oooO0OO == null || !oooO0OO.f31730p) ? 1L : 500L;
                    Context context2 = getContext();
                    com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO2 = context2 instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context2 : null;
                    if (oooO0OO2 != null) {
                        oooO0OO2.f31730p = false;
                    }
                    e.g(new Runnable() { // from class: qd.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniShellFragment.d3(this.f74509a);
                        }
                    }, j11);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // zc.f
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // zc.h
    public /* synthetic */ void onReceivedIcon(Bitmap bitmap) {
        zc.g.a(this, bitmap);
    }

    @Override // zc.h
    public /* synthetic */ void onReceivedTitle(String str) {
        zc.g.b(this, str);
    }

    @Override // zc.h
    public /* synthetic */ void onRequestFocus() {
        zc.g.c(this);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        zc.i render;
        super.onResume();
        if (this.S) {
            this.S = false;
            kotlinx.coroutines.j.d(l0.a(w0.a()), null, null, new OooOO0(null), 3, null);
        }
        O2();
        Page page = this.f30954a;
        View view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ImageView imageView;
        App app;
        App app2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        ((IMonitorWebviewManagerProxy) tc.a.a(IMonitorWebviewManagerProxy.class)).registerMonitorListener(this);
        PageChainContext pageChainContext = this.f30956c;
        App app3 = this.f30955b;
        pageChainContext.E(app3 != null ? app3.getAppChainContext() : null);
        Page page = this.f30954a;
        if (page != null) {
            page.setPageChainContext(this.f30956c);
        }
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f30955b);
        this.L = eventCenterInstance;
        if (eventCenterInstance != null) {
            eventCenterInstance.b("consumeTime", this);
        }
        w1();
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page2 = this.f30954a;
        performanceAnalyseProxy.record((page2 == null || (app2 = page2.getApp()) == null) ? null : app2.getAppId(), PointAnalyseType.POINT_PAGE_CREATE, "");
        FragmentActivity activity = getActivity();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        if (oooO0OO != null && !oooO0OO.f31727m) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page3 = this.f30954a;
            performanceAnalyseProxy2.record((page3 == null || (app = page3.getApp()) == null) ? null : app.getAppId(), PointAnalyseType.POINT_PAGE_PV, "");
        }
        Page page4 = this.I;
        if (page4 != null) {
            Intrinsics.d(page4);
            j0(page4);
            this.I = null;
        }
        showNavigationBarLoading();
        hc.c.a(this, this);
        g.a aVar = this.H;
        if (aVar != null && (imageView = aVar.f65296d) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: qd.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MiniShellFragment.Z2(this.f74511a, view2);
                }
            });
        }
        try {
            Page page5 = this.f30954a;
            App app4 = page5 != null ? page5.getApp() : null;
            if (app4 == null) {
                return;
            }
            app4.setLoadHtmlDataCallback(this);
        } catch (Throwable th2) {
            TmcLogger.h("MiniShellFragment", th2);
        }
    }

    @Override // ua.g
    public boolean p(zc.i iVar, zc.l loadParams) {
        String preHtmlCache;
        Intrinsics.g(loadParams, "loadParams");
        try {
            if (MiniAppConfigHelper.f30370a.b("enableShellPreRequest", true)) {
                String md5 = com.cloud.tmc.miniutils.util.h.b(loadParams.f81893a);
                TmcLogger.c("MiniShellFragment", "md5 -> " + md5);
                Context context = getContext();
                if (context != null) {
                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) tc.a.a(PreHtmStrategyProxy.class);
                    Intrinsics.f(md5, "md5");
                    preHtmlCache = preHtmStrategyProxy.getPreHtmlCache(context, md5, 1, true);
                    if (preHtmlCache == null) {
                        preHtmlCache = "";
                    }
                } else {
                    preHtmlCache = "";
                }
                String str = preHtmlCache;
                if (str.length() <= 0) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                Node nodeI = iVar != null ? iVar.i() : null;
                PageNode pageNode = nodeI instanceof PageNode ? (PageNode) nodeI : null;
                sb2.append(pageNode != null ? pageNode.getPageId() : null);
                sb2.append('_');
                sb2.append(B1().addAndGet(1));
                String string = sb2.toString();
                V2(iVar, loadParams, string);
                this.N = true;
                J2(true);
                String str2 = loadParams.f81893a;
                Intrinsics.f(str2, "loadParams.url");
                this.M = str2;
                if (iVar != null) {
                    iVar.n(loadParams, str, "text/html", "UTF-8", null);
                }
                TmcLogger.c("MiniShellFragment", "use loadDataWithBaseURL -> url is " + loadParams.f81893a);
                PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class);
                App app = this.f30955b;
                performanceImprovesProxy.addPeroformanceImprove(app != null ? app.getAppId() : null, "preHtml");
                W2(loadParams, string);
                return true;
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniShellFragment", th2);
        }
        return false;
    }

    @Override // ee.i
    public void reportDomLoadTime(int i11, String uniqueId) {
        Intrinsics.g(uniqueId, "uniqueId");
        if (i11 == 2) {
            K2();
        }
    }

    @Override // vb.c
    public void setCapsuleStyle(boolean z11) {
        CapsuleView capsuleViewU0;
        int i11 = !z11 ? 1 : 0;
        FragmentActivity activity = getActivity();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        if (oooO0OO == null || (capsuleViewU0 = oooO0OO.u0()) == null) {
            return;
        }
        CapsuleView.OooO00o(capsuleViewU0, i11, null, 2);
    }

    @Override // vb.c
    public void setNavigationBarIconStyle(boolean z11) {
        ImmersiveTitleBarView immersiveTitleBarView;
        int i11 = !z11 ? 1 : 0;
        g.a aVar = this.H;
        if (aVar == null || (immersiveTitleBarView = aVar.f65299h) == null) {
            return;
        }
        immersiveTitleBarView.setThemeMode(i11);
    }

    @Override // zc.f
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String string;
        Uri url2;
        Intent intent;
        H2(webView, webResourceRequest);
        B2(webView, webResourceRequest);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (webResourceRequest != null && (url2 = webResourceRequest.getUrl()) != null) {
            String string2 = url2.toString();
            Intrinsics.f(string2, "it.toString()");
            boolean zBooleanValue = false;
            if (!l.L(string2, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
                try {
                    Object objFromJson = new Gson().fromJson(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("shellSchemeFilter", "[\"whatsapp\",\"sms\",\"tel\"]"), (Class<Object>) List.class);
                    List list = objFromJson instanceof List ? (List) objFromJson : null;
                    if (list != null && CollectionsKt___CollectionsKt.X(list, url2.getScheme())) {
                        if ("intent".equals(url2.getScheme())) {
                            intent = Intent.parseUri(url2.toString(), 1);
                            Intrinsics.f(intent, "parseUri(it.toString(), Intent.URI_INTENT_SCHEME)");
                        } else {
                            intent = new Intent("android.intent.action.VIEW", Uri.parse(url2.toString()));
                            intent.setFlags(805306368);
                        }
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            activity.startActivity(intent);
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                return Boolean.TRUE;
            }
            MiniShellUtils miniShellUtils = MiniShellUtils.f31019a;
            App app = this.f30955b;
            String string3 = url2.toString();
            Intrinsics.f(string3, "it.toString()");
            boolean zA = miniShellUtils.a(app, string3);
            TmcLogger.c("MiniShellFragment", "是否支持内部打开：" + zA);
            if (!zA) {
                try {
                    String shellPathFilterConfig = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("shellPathFilter", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    Intrinsics.f(shellPathFilterConfig, "shellPathFilterConfig");
                    Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$shouldOverrideUrlLoading$1$shellPathFilter$1
                    }.getType();
                    Intrinsics.f(type, "object :\n               …ayList<String>>() {}.type");
                    ArrayList arrayList = (ArrayList) TmcGsonUtils.e(shellPathFilterConfig, type);
                    String host = url2.getHost();
                    String str = url2.getScheme() + "://" + url2.getHost() + url2.getPath();
                    String strA1 = A1(webView);
                    String host2 = "";
                    if (strA1 == null) {
                        strA1 = "";
                    }
                    try {
                        host2 = Uri.parse(strA1).getHost();
                    } catch (Throwable th2) {
                        TmcLogger.h("MiniShellFragment", th2);
                    }
                    if (arrayList.contains(str) || !Intrinsics.b(host2, host)) {
                        Context context = getContext();
                        if (context != null) {
                            t.a aVar = t.f31130a;
                            Intrinsics.f(context, "context");
                            zBooleanValue = Boolean.valueOf(aVar.a(context, url2.toString())).booleanValue();
                        }
                        booleanRef.element = zBooleanValue;
                    }
                } catch (Throwable th3) {
                    TmcLogger.h("MiniShellFragment", th3);
                }
            }
        }
        if (booleanRef.element) {
            return Boolean.TRUE;
        }
        String strA2 = A1(webView);
        if (strA2 == null) {
            return Boolean.FALSE;
        }
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (string = url.toString()) == null) {
            return Boolean.FALSE;
        }
        E2(strA2, string);
        return Boolean.FALSE;
    }

    @Override // id.i
    public void showError(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.e(this, bVar, i11, str, str2, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, @StringRes int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.g(this, i11, i12, i13, bVar, z11, z12, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.h(this, i11, i12, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.i(this, drawable, charSequence, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.j(this, drawable, charSequence, charSequence2, bVar, str, z11, z12, aVar);
    }

    @Override // vb.c
    public void showNavigationBarLoading() {
        ProgressBar progressBar;
        g.a aVar = this.H;
        ProgressBar progressBar2 = aVar != null ? aVar.f65297f : null;
        if (progressBar2 != null) {
            progressBar2.setTag(Boolean.TRUE);
        }
        g.a aVar2 = this.H;
        if (aVar2 == null || (progressBar = aVar2.f65297f) == null) {
            return;
        }
        xb.i.e(progressBar);
    }

    @Override // id.i
    public void showNoNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.r(this, bVar, i11, str, str2, aVar);
    }

    @Override // id.i
    public void showUnstableNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.u(this, bVar, i11, str, str2, aVar);
    }

    @Override // tb.d
    public ub.a u() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65294b;
        }
        return null;
    }

    @Override // tb.d
    public ViewGroup v() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65293a;
        }
        return null;
    }

    @Override // tb.d
    public ub.c x() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65299h;
        }
        return null;
    }
}
