package p010OooOooo;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
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
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AbilitiesUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.base.MiniAppH5BaseFragment;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.ImmersiveTitleBarView;
import com.cloud.tmc.miniapp.widget.PageContainerView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import com.cloud.tmc.render.IMonitorWebviewManagerProxy;
import com.cloud.tmc.render.method.HybridPageJsInterface;
import com.cloud.tmc.render.system.ShellWebView;
import com.cloud.tmc.worker.WorkerManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.Gson;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import e0.v;
import h0.g;
import h0.k;
import id.i;
import id.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import p010OooOooo.o0000oo;
import zc.f;
import zc.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o0000oo extends MiniAppH5BaseFragment implements h, f, hc.a, uc.c, i, j {
    public static final /* synthetic */ int V = 0;
    public g.a H;
    public Page I;
    public boolean J;
    public boolean K;
    public uc.b L;
    public View M;
    public WebChromeClient.CustomViewCallback N;
    public int O;
    public View P;
    public boolean Q;
    public boolean R;
    public StatusLayout S;
    public String T = "";
    public boolean U;

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniH5Fragment$hideCustomView$1", f = "MiniH5Fragment.kt", l = {738, 739}, m = "invokeSuspend")
    public static final class OooO0O0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;

        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniH5Fragment$hideCustomView$1$1", f = "MiniH5Fragment.kt", l = {}, m = "invokeSuspend")
        public static final class OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public final /* synthetic */ o0000oo OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(o0000oo o0000ooVar, Continuation<? super OooO00o> continuation) {
                super(2, continuation);
                this.OooO00o = o0000ooVar;
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
                if (this.OooO00o.P == null) {
                    Intrinsics.y("contextView");
                }
                View view = this.OooO00o.P;
                if (view == null) {
                    Intrinsics.y("contextView");
                    view = null;
                }
                view.scrollTo(0, this.OooO00o.O);
                return Unit.f68710a;
            }
        }

        public OooO0O0(Continuation<? super OooO0O0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o0000oo.this.new OooO0O0(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return o0000oo.this.new OooO0O0(continuation).invokeSuspend(Unit.f68710a);
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
            OooO00o oooO00o = new OooO00o(o0000oo.this, null);
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
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniH5Fragment$onResume$1", f = "MiniH5Fragment.kt", l = {188, PsExtractor.PRIVATE_STREAM_1}, m = "invokeSuspend")
    public static final class OooOO0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;

        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniH5Fragment$onResume$1$1", f = "MiniH5Fragment.kt", l = {}, m = "invokeSuspend")
        public static final class OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public final /* synthetic */ o0000oo OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(o0000oo o0000ooVar, Continuation<? super OooO00o> continuation) {
                super(2, continuation);
                this.OooO00o = o0000ooVar;
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
                if (this.OooO00o.P == null) {
                    Intrinsics.y("contextView");
                }
                View view = this.OooO00o.P;
                if (view == null) {
                    Intrinsics.y("contextView");
                    view = null;
                }
                view.scrollTo(0, this.OooO00o.O);
                return Unit.f68710a;
            }
        }

        public OooOO0(Continuation<? super OooOO0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o0000oo.this.new OooOO0(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return o0000oo.this.new OooOO0(continuation).invokeSuspend(Unit.f68710a);
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
            OooO00o oooO00o = new OooO00o(o0000oo.this, null);
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
        public final /* synthetic */ uc.b f216b;

        public a(uc.b bVar) {
            this.f216b = bVar;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            fe.f webviewBridgeHelper;
            zc.i render;
            zc.i render2;
            Page page = o0000oo.this.f30954a;
            if (!l.w((page == null || (render2 = page.getRender()) == null) ? null : render2.b(), aVar != null ? aVar.b() : null, false, 2, null)) {
                return false;
            }
            Page page2 = o0000oo.this.f30954a;
            View view = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
            ShellWebView shellWebView = view instanceof ShellWebView ? (ShellWebView) view : null;
            if (shellWebView != null && (webviewBridgeHelper = shellWebView.getWebviewBridgeHelper()) != null) {
                webviewBridgeHelper.b();
            }
            o0000oo.b3(o0000oo.this);
            this.f216b.c("renderOnMessageReady", this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0000oo f218b;

        public b(boolean z11, o0000oo o0000ooVar) {
            this.f217a = z11;
            this.f218b = o0000ooVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Page page;
            Intrinsics.g(animation, "animation");
            if (this.f217a) {
                o0000oo o0000ooVar = this.f218b;
                if (o0000ooVar.K || o0000ooVar.M0(o0000ooVar.getAppLoadResult()) || (page = this.f218b.f30954a) == null || page.isDestroyed()) {
                    return;
                }
                o0000oo o0000ooVar2 = this.f218b;
                o0000ooVar2.K = true;
                Page page2 = o0000ooVar2.f30954a;
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
            App app = o0000oo.this.f30955b;
            if (app != null) {
                Page page = o0000oo.this.f30954a;
                String pagePath = page != null ? page.getPagePath() : null;
                if (pagePath == null) {
                    pagePath = "";
                }
                app.putPageType(pagePath, 2);
            }
            App app2 = o0000oo.this.f30955b;
            if (app2 != null) {
                Page page2 = o0000oo.this.f30954a;
                String pagePath2 = page2 != null ? page2.getPagePath() : null;
                if (pagePath2 == null) {
                    pagePath2 = "";
                }
                app2.putRouteType(pagePath2, "redirectTo");
            }
            App app3 = o0000oo.this.f30955b;
            if (app3 != null) {
                Page page3 = o0000oo.this.f30954a;
                String pagePath3 = page3 != null ? page3.getPagePath() : null;
                String str = pagePath3 != null ? pagePath3 : "";
                App app4 = o0000oo.this.f30955b;
                Bundle startParams = app4 != null ? app4.getStartParams() : null;
                App app5 = o0000oo.this.f30955b;
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
            o0000oo.this.L0().set(true);
            o0000oo o0000ooVar = o0000oo.this;
            if (o0000ooVar.M != null) {
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                return;
            }
            o0000ooVar.M = view;
            g.a aVar = o0000ooVar.H;
            if (aVar == null || (frameLayout = aVar.f65295c) == null) {
                return;
            }
            frameLayout.setVisibility(0);
            FragmentActivity it = o0000ooVar.getActivity();
            if (it != null) {
                Intrinsics.f(it, "it");
                g.e(o0000ooVar, frameLayout, it);
            }
            frameLayout.addView(o0000ooVar.M, 0);
            View view2 = o0000ooVar.P;
            View view3 = null;
            if (view2 == null) {
                Intrinsics.y("contextView");
                view2 = null;
            }
            if (view2 != null) {
                View view4 = o0000ooVar.P;
                if (view4 == null) {
                    Intrinsics.y("contextView");
                } else {
                    view3 = view4;
                }
                o0000ooVar.O = view3.getScrollY();
            }
            o0000ooVar.N = customViewCallback;
        }

        @Override // zc.d
        public void b() {
            o0000oo.this.L0().set(false);
            o0000oo o0000ooVar = o0000oo.this;
            int i11 = o0000oo.V;
            o0000ooVar.W2(false);
        }
    }

    public o0000oo() {
        LazyKt__LazyJVMKt.b(OooO0OO.OooO00o);
    }

    public static final void P2(o0000oo this$0, int i11, int i12, long j11) {
        Intrinsics.g(this$0, "this$0");
        this$0.changeNavigationBarProgress(i11 + 1, i12, j11);
    }

    public static final void Q2(o0000oo this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.W2(false);
    }

    public static final void R2(o0000oo this$0, Page page) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(page, "$page");
        g.a aVar = this$0.H;
        if ((aVar != null ? aVar.f65293a : null) == null) {
            this$0.I = page;
            return;
        }
        this$0.I2(String.valueOf(page.getPagePath()), true, String.valueOf(page.getPageId()));
        String strValueOf = String.valueOf(page.getPagePath());
        String strValueOf2 = String.valueOf(page.getPageId());
        PageChainContext pageChainContext = this$0.f30956c;
        Intrinsics.f(pageChainContext, "pageChainContext");
        this$0.t1("", "", strValueOf, strValueOf2, pageChainContext);
        this$0.V1(String.valueOf(page.getPagePath()), String.valueOf(page.getPageId()));
        this$0.U1(String.valueOf(page.getPagePath()), String.valueOf(page.getPageId()));
        this$0.y2();
        this$0.T2(page);
        try {
            App app = this$0.f30955b;
            if ((app != null ? app.getAppLifecycleCallback() : null) == null) {
                TmcLogger.c("MiniH5Fragment", "setMiniappLifecycleCallback");
                App app2 = this$0.f30955b;
                if (app2 != null) {
                    FragmentActivity activity = this$0.getActivity();
                    app2.setMiniappLifecycleCallback(activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniH5Fragment", th2);
        }
    }

    public static final void S2(o0000oo this$0, com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y0();
        if (oooO0OO != null) {
            oooO0OO.I0();
        }
    }

    public static final void U2(Page page, o0000oo this$0) {
        zc.i render;
        PageContainerView pageContainerView;
        String pageRandomIdByGAId;
        View view;
        gd.b workerById;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app2;
        IEngine engineProxy2;
        zc.i render2;
        String string;
        zc.i render3;
        View view2;
        zc.i render4;
        App app3;
        PageContainerView pageContainerView2;
        zc.i render5;
        App app4;
        zc.i render6;
        zc.i render7;
        zc.i render8;
        zc.i render9;
        Intrinsics.g(this$0, "this$0");
        if (page != null && (render9 = page.getRender()) != null) {
            render9.d(this$0);
        }
        View view3 = (page == null || (render8 = page.getRender()) == null) ? null : render8.getView();
        WebView webView = view3 instanceof WebView ? (WebView) view3 : null;
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings != null) {
            settings.setDomStorageEnabled(true);
        }
        View view4 = (page == null || (render7 = page.getRender()) == null) ? null : render7.getView();
        WebView webView2 = view4 instanceof WebView ? (WebView) view4 : null;
        if (webView2 != null) {
            webView2.addJavascriptInterface(new HybridPageJsInterface(), "dlthp");
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            g.a aVar = this$0.H;
            g.h(this$0, page, aVar != null ? aVar.f65295c : null, activity, this$0.f30955b, this$0);
        }
        if (page != null && (render6 = page.getRender()) != null) {
            render6.y(this$0.new d());
        }
        this$0.initView();
        AppLoadResult appLoadResult = this$0.getAppLoadResult();
        Page page2 = this$0.f30954a;
        if (page2 != null && (app4 = page2.getApp()) != null) {
            app4.setData(AppLoadResult.class, appLoadResult);
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
        this$0.P = view5;
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
                TmcLogger.g("MiniH5Fragment", "set content background color error", e11);
            }
            Boolean enablePullDownRefresh = windowBeanF.getEnablePullDownRefresh();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.b(enablePullDownRefresh, bool) || Intrinsics.b(windowBeanF.getEnablePullUpRefresh(), bool)) {
                View view6 = this$0.P;
                if (view6 == null) {
                    Intrinsics.y("contextView");
                    view6 = null;
                }
                this$0.P = this$0.u0(view6, windowBeanF);
            }
        }
        g.a aVar3 = this$0.H;
        if (aVar3 != null && (pageContainerView2 = aVar3.f65294b) != null) {
            View view7 = this$0.P;
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
            oooO0OO.hideStatusLoading();
        }
        Page page6 = this$0.f30954a;
        if (page6 != null && (render4 = page6.getRender()) != null && render4.c()) {
            PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class);
            Page page7 = this$0.f30954a;
            performanceImprovesProxy.addPeroformanceImprove((page7 == null || (app3 = page7.getApp()) == null) ? null : app3.getAppId(), "webview");
        }
        Page page8 = this$0.f30954a;
        zc.i render10 = page8 != null ? page8.getRender() : null;
        Page page9 = this$0.f30954a;
        App app5 = page9 != null ? page9.getApp() : null;
        zc.l lVar = new zc.l();
        Page page10 = this$0.f30954a;
        lVar.f81893a = page10 != null ? page10.getPagePath() : null;
        Page page11 = this$0.f30954a;
        lVar.f81894b = page11 != null ? page11.getPagePath() : null;
        lVar.f81895c = app5 != null ? app5.getAppId() : null;
        this$0.n2();
        this$0.l2();
        this$0.c2();
        this$0.a2();
        this$0.r2();
        this$0.p2();
        this$0.j2();
        Page page12 = this$0.f30954a;
        String strValueOf = String.valueOf(page12 != null ? page12.getPagePath() : null);
        Page page13 = this$0.f30954a;
        this$0.o2(strValueOf, String.valueOf(page13 != null ? page13.getPageId() : null));
        Page page14 = this$0.f30954a;
        String strValueOf2 = String.valueOf(page14 != null ? page14.getPagePath() : null);
        Page page15 = this$0.f30954a;
        this$0.m2(strValueOf2, String.valueOf(page15 != null ? page15.getPageId() : null));
        Page page16 = this$0.f30954a;
        String strValueOf3 = String.valueOf(page16 != null ? page16.getPagePath() : null);
        Page page17 = this$0.f30954a;
        this$0.d2(strValueOf3, String.valueOf(page17 != null ? page17.getPageId() : null));
        Page page18 = this$0.f30954a;
        String strValueOf4 = String.valueOf(page18 != null ? page18.getPagePath() : null);
        Page page19 = this$0.f30954a;
        this$0.b2(strValueOf4, String.valueOf(page19 != null ? page19.getPageId() : null));
        Page page20 = this$0.f30954a;
        String strValueOf5 = String.valueOf(page20 != null ? page20.getPagePath() : null);
        Page page21 = this$0.f30954a;
        this$0.s2(strValueOf5, String.valueOf(page21 != null ? page21.getPageId() : null));
        Page page22 = this$0.f30954a;
        String strValueOf6 = String.valueOf(page22 != null ? page22.getPagePath() : null);
        Page page23 = this$0.f30954a;
        this$0.q2(strValueOf6, String.valueOf(page23 != null ? page23.getPageId() : null));
        Page page24 = this$0.f30954a;
        String strValueOf7 = String.valueOf(page24 != null ? page24.getPagePath() : null);
        Page page25 = this$0.f30954a;
        this$0.u2(strValueOf7, String.valueOf(page25 != null ? page25.getPageId() : null));
        Page page26 = this$0.f30954a;
        String strValueOf8 = String.valueOf(page26 != null ? page26.getPagePath() : null);
        Page page27 = this$0.f30954a;
        this$0.t2(strValueOf8, String.valueOf(page27 != null ? page27.getPageId() : null));
        Page page28 = this$0.f30954a;
        String strValueOf9 = String.valueOf(page28 != null ? page28.getPagePath() : null);
        Page page29 = this$0.f30954a;
        this$0.k2(strValueOf9, String.valueOf(page29 != null ? page29.getPageId() : null));
        Page page30 = this$0.f30954a;
        if (page30 == null || (pageRandomIdByGAId = page30.getPageRandomIdByGAId()) == null) {
            pageRandomIdByGAId = "null";
        }
        this$0.O1(pageRandomIdByGAId);
        Context context = this$0.getContext();
        if (context != null && render10 != null && (view2 = render10.getView()) != null) {
            Integer num = 2;
            view2.setBackgroundColor(z2.a.getColor(context, (num != null && num.intValue() == 2) ? R$color.mini_color_white : R$color.mini_color_bg_01));
        }
        Page page31 = this$0.f30954a;
        View view8 = (page31 == null || (render3 = page31.getRender()) == null) ? null : render3.getView();
        this$0.K1(view8 instanceof WebView ? (WebView) view8 : null, InjectJSProxyImp.STRATEGY_INJECT_JS_IN_PRELOADURL);
        if (render10 != null) {
            try {
                view = render10.getView();
            } catch (Throwable th2) {
                this$0.R = false;
                if (render10 != null) {
                    render10.k(lVar);
                }
                TmcLogger.h("MiniH5Fragment", th2);
            }
        } else {
            view = null;
        }
        ShellWebView shellWebView = view instanceof ShellWebView ? (ShellWebView) view : null;
        if (shellWebView == null || !shellWebView.isOffScreenRender()) {
            TmcLogger.c("nevermore", "load url H5");
            if (MiniAppConfigHelper.f30370a.b("enableSharpNewsPreRequest", true)) {
                String strB = com.cloud.tmc.miniutils.util.h.b(lVar.f81893a);
                Context context2 = this$0.getContext();
                if (context2 == null || (string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context2, "miniSyncSharpNews", strB)) == null) {
                    string = "";
                }
                String str = string;
                if (str.length() > 0) {
                    this$0.R = true;
                    this$0.J2(true);
                    String str2 = lVar.f81893a;
                    Intrinsics.f(str2, "loadParams.url");
                    this$0.T = str2;
                    if (render10 != null) {
                        render10.n(lVar, str, "text/html", "UTF-8", null);
                    }
                    TmcLogger.c("MiniH5Fragment", "use loadDataWithBaseURL -> url is " + lVar.f81893a);
                    ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app5 != null ? app5.getAppId() : null, "preHtml");
                } else if (render10 != null) {
                    render10.k(lVar);
                }
            } else if (render10 != null) {
                render10.k(lVar);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load Shell offscreen -> warmup: ");
            sb2.append(render10 != null ? Boolean.valueOf(render10.c()) : null);
            sb2.append(", loadDataWithBaseURL: ");
            View view9 = render10 != null ? render10.getView() : null;
            ShellWebView shellWebView2 = view9 instanceof ShellWebView ? (ShellWebView) view9 : null;
            sb2.append(shellWebView2 != null ? Boolean.valueOf(shellWebView2.isLoadDataWithBaseURL()) : null);
            TmcLogger.c("nevermore", sb2.toString());
            View view10 = render10.getView();
            ShellWebView shellWebView3 = view10 instanceof ShellWebView ? (ShellWebView) view10 : null;
            if (shellWebView3 != null && shellWebView3.isLoadDataWithBaseURL()) {
                this$0.R = true;
                this$0.J2(true);
                String str3 = lVar.f81893a;
                Intrinsics.f(str3, "loadParams.url");
                this$0.T = str3;
                ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app5 != null ? app5.getAppId() : null, "preHtml");
            }
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app5 != null ? app5.getAppId() : null, "offScreenRender");
        }
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app5);
        if (eventCenterInstance != null) {
            fc.a aVar4 = new fc.a("pageEnter");
            Page page32 = this$0.f30954a;
            aVar4.d((page32 == null || (render2 = page32.getRender()) == null) ? null : render2.b());
            Unit unit = Unit.f68710a;
            eventCenterInstance.d("renderOnMessageReady", aVar4);
        }
        this$0.J1(1);
        Page page33 = this$0.f30954a;
        if (page33 == null || (app = page33.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            workerById = null;
        } else {
            Page page34 = this$0.f30954a;
            workerById = engineRouter.getWorkerById((page34 == null || (app2 = page34.getApp()) == null || (engineProxy2 = app2.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (workerById != null && Intrinsics.b(workerById.n(), Boolean.TRUE) && !this$0.U) {
            this$0.U = true;
            MiniAppBaseFragment.V0(this$0, null, 1, null);
        }
        Page page35 = this$0.f30954a;
        String strValueOf10 = String.valueOf(page35 != null ? page35.getPagePath() : null);
        Page page36 = this$0.f30954a;
        this$0.f2(strValueOf10, String.valueOf(page36 != null ? page36.getPageId() : null), this$0.R);
    }

    public static final void V2(com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO, View view) {
        if (oooO0OO != null) {
            oooO0OO.m0((1 & 1) != 0 ? "0" : null);
        }
    }

    public static final void Z2(o0000oo this$0, com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO, View view) {
        ActivityHelper activityHelper;
        App app;
        zc.i render;
        Intrinsics.g(this$0, "this$0");
        Page page = this$0.f30954a;
        View view2 = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        if (this$0.u1(view2 instanceof WebView ? (WebView) view2 : null) || oooO0OO == null || (activityHelper = oooO0OO.f31719d) == null || (app = activityHelper.getApp()) == null) {
            return;
        }
        app.backPressed();
    }

    public static final void b3(o0000oo o0000ooVar) {
        gd.b workerById;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app2;
        IEngine engineProxy2;
        FragmentActivity activity = o0000ooVar.getActivity();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        if (oooO0OO != null && oooO0OO.f31727m) {
            MiniAppBaseFragment.R0(o0000ooVar, "appReady", null, 2, null);
            FragmentActivity activity2 = o0000ooVar.getActivity();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO2 = activity2 instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity2 : null;
            if (oooO0OO2 == null) {
                return;
            }
            oooO0OO2.f31727m = false;
            return;
        }
        MiniAppBaseFragment.R0(o0000ooVar, "pageReady", null, 2, null);
        Page page = o0000ooVar.f30954a;
        if (page == null || (app = page.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            workerById = null;
        } else {
            Page page2 = o0000ooVar.f30954a;
            workerById = engineRouter.getWorkerById((page2 == null || (app2 = page2.getApp()) == null || (engineProxy2 = app2.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (workerById != null && Intrinsics.b(workerById.n(), Boolean.TRUE)) {
            MiniAppBaseFragment.V0(o0000ooVar, null, 1, null);
            return;
        }
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
        Page page3 = o0000ooVar.f30954a;
        uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(page3 != null ? page3.getApp() : null);
        if (eventCenterInstance != null) {
            eventCenterInstance.b(WorkerManager.f32140n.a(), new v(o0000ooVar));
        }
    }

    public static final void c3(o0000oo this$0) {
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
            lVar.f81893a = page4 != null ? page4.getPagePath() : null;
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
        boolean zB;
        App app = this.f30955b;
        if (app != null) {
            AbilitiesUtils abilitiesUtils = AbilitiesUtils.f30983a;
            String appId = app.getAppId();
            Intrinsics.f(appId, "it.appId");
            zB = abilitiesUtils.b(appId, "title_bar_add_home");
        } else {
            zB = true;
        }
        Page page = this.f30954a;
        String stringValue = page != null ? page.getStringValue("isApiAddScreenEnabled") : null;
        if (Intrinsics.b(stringValue, "showAddScreenButton")) {
            if (zB) {
                Page page2 = this.f30954a;
                if (page2 != null) {
                    page2.showAddScreenButton();
                    return;
                }
                return;
            }
            Page page3 = this.f30954a;
            if (page3 != null) {
                page3.hideAddScreenButton();
                return;
            }
            return;
        }
        if (Intrinsics.b(stringValue, "hideAddScreenButton")) {
            Page page4 = this.f30954a;
            if (page4 != null) {
                page4.hideAddScreenButton();
                return;
            }
            return;
        }
        if (zB) {
            Page page5 = this.f30954a;
            if (page5 != null) {
                page5.showAddScreenButton();
                return;
            }
            return;
        }
        Page page6 = this.f30954a;
        if (page6 != null) {
            page6.hideAddScreenButton();
        }
    }

    @Override // tb.d
    public ProgressBar S() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65297f;
        }
        return null;
    }

    public final void T2(final Page page) {
        try {
            this.f30954a = page;
            ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).start(this.f30955b, String.valueOf(page.getPagePath()));
            FragmentActivity activity = getActivity();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
            page.bindContext(this, Boolean.valueOf(oooO0OO != null ? oooO0OO.f31727m : false), new Page.b() { // from class: e0.c0
                @Override // com.cloud.tmc.integration.structure.Page.b
                public final void success() {
                    o0000oo.U2(page, this);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniH5Fragment", "setPageOnMain error", th2);
        }
    }

    public final boolean W2(boolean z11) {
        FrameLayout frameLayout;
        if (this.M == null) {
            return false;
        }
        if (z11) {
            this.Q = true;
        }
        kotlinx.coroutines.j.d(l0.a(w0.a()), null, null, new OooO0O0(null), 3, null);
        g.a aVar = this.H;
        if (aVar != null && (frameLayout = aVar.f65295c) != null) {
            frameLayout.setVisibility(8);
            frameLayout.removeView(this.M);
        }
        View view = this.M;
        if (view != null) {
            view.setVisibility(8);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.N;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.M = null;
        this.N = null;
        if (E0()) {
            j1();
        }
        g.l(this);
        return true;
    }

    public final void Y2() {
        try {
            Page page = this.f30954a;
            if (page == null || !page.isShow()) {
                return;
            }
            a3();
            O2();
        } catch (Throwable unused) {
        }
    }

    @Override // tb.d
    public ub.b a0() {
        g.a aVar = this.H;
        if (aVar != null) {
            return aVar.f65298g;
        }
        return null;
    }

    public final void a3() {
        try {
            Page page = this.f30954a;
            if (page != null) {
                page.setNavigationBarTitleVisible(false);
            }
            Page page2 = this.f30954a;
            if (page2 != null) {
                page2.showHomeButton();
            }
            Page page3 = this.f30954a;
            if (page3 != null) {
                page3.setHomeAction(d0.g("all"), true);
            }
            O2();
            Page page4 = this.f30954a;
            if (page4 != null) {
                page4.setNavigationBarIconStyle(false);
            }
            Page page5 = this.f30954a;
            if (page5 != null) {
                page5.setNavigationBarTitleColor(false);
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniH5Fragment", th2);
        }
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
            progressBar.postDelayed(new Runnable() { // from class: e0.a0
                @Override // java.lang.Runnable
                public final void run() {
                    o0000oo.P2(this.f63568a, i11, i12, j11);
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
        g.f(this, this.f30954a);
        IScreenInspectProxy iScreenInspectProxy = (IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class);
        Page page = this.f30954a;
        App app = page != null ? page.getApp() : null;
        Page page2 = this.f30954a;
        iScreenInspectProxy.destroy(app, String.valueOf(page2 != null ? page2.getPagePath() : null));
        Page page3 = this.f30954a;
        if (page3 == null || (render2 = page3.getRender()) == null || !render2.c()) {
            Page page4 = this.f30954a;
            if (page4 == null || (render = page4.getRender()) == null) {
                return;
            }
            render.destroy();
            return;
        }
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

    @Override // hc.a
    public void f() {
        hc.b.f66421b = true;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: e0.y
                @Override // java.lang.Runnable
                public final void run() {
                    o0000oo.c3(this.f63619a);
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
        return this.S;
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
            immersiveTitleBarView.setOnAddScreenClickListener(new View.OnClickListener() { // from class: e0.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0000oo.V2(oooO0OO, view);
                }
            });
            immersiveTitleBarView.setOnHomeClickListener(new View.OnClickListener() { // from class: e0.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0000oo.S2(this.f63582a, oooO0OO, view);
                }
            });
            immersiveTitleBarView.setOnBackClickListener(new View.OnClickListener() { // from class: e0.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0000oo.Z2(this.f63588a, oooO0OO, view);
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
            Y2();
        } catch (Throwable th2) {
            TmcLogger.g("MiniH5Fragment", "", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, com.cloud.tmc.integration.ui.fragment.TmcFragment
    public void j0(final Page page) {
        Bundle startParams;
        String string;
        AppModel appModel;
        ExtendModel extend;
        Intrinsics.g(page, "page");
        String h5Url = null;
        PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
        if (pageNode != null) {
            App app = page.getApp();
            if (app != null && (appModel = app.getAppModel()) != null && (extend = appModel.getExtend()) != null) {
                h5Url = extend.getH5Url();
            }
            String string2 = "";
            if (h5Url != null) {
                Uri uri = Uri.parse(h5Url);
                String query = uri.getQuery();
                String str = query == null ? "" : query;
                Intrinsics.f(str, "uri.query ?: \"\"");
                List listE0 = StringsKt__StringsKt.E0(str, new String[]{"&"}, false, 0, 6, null);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = listE0.size();
                for (int i11 = 0; i11 < size; i11++) {
                    List listE1 = StringsKt__StringsKt.E0((CharSequence) listE0.get(i11), new String[]{"="}, false, 0, 6, null);
                    if (listE1.size() == 2) {
                        linkedHashMap.put((String) listE1.get(0), (String) listE1.get(1));
                    }
                }
                Page page2 = this.f30954a;
                String str2 = (page2 == null || (startParams = page2.getStartParams()) == null || (string = startParams.getString("query")) == null) ? "" : string;
                Intrinsics.f(str2, "page?.startParams?.getSt…Activity.KEY_QUERY) ?: \"\"");
                List listE2 = StringsKt__StringsKt.E0(str2, new String[]{"&"}, false, 0, 6, null);
                int size2 = listE2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    List listE3 = StringsKt__StringsKt.E0((CharSequence) listE2.get(i12), new String[]{"="}, false, 0, 6, null);
                    if (listE3.size() == 2) {
                        linkedHashMap.put((String) listE3.get(0), (String) listE3.get(1));
                    }
                }
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.clearQuery();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                string2 = builderBuildUpon.build().toString();
                Intrinsics.f(string2, "newUri.build().toString()");
            }
            pageNode.setPageURI(string2);
        }
        this.f30954a = page;
        this.f30955b = (App) page.bubbleFindNode(App.class);
        e.f(new Runnable() { // from class: e0.b0
            @Override // java.lang.Runnable
            public final void run() {
                o0000oo.R2(this.f63573a, page);
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
        this.S = (StatusLayout) viewV0.findViewById(R$id.sl_status);
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
            zc.i render = page.getRender();
            if (render != null) {
                render.destroy();
            }
            ((EngineRouter) tc.a.a(EngineRouter.class)).unRegisterRender(page.getPageId());
        }
    }

    @Override // zc.f
    public void onPageFinished(WebView webView, String str) {
        boolean z11;
        zc.i render;
        zc.i render2;
        Y2();
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
            g.d(this);
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
            TmcLogger.g("MiniH5Fragment", "", th2);
        }
    }

    @Override // zc.f
    public void onPageStarted(WebView webView, String str) {
        zc.i render;
        zc.i render2;
        try {
            Page page = this.f30954a;
            View view = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
            K1(view instanceof WebView ? (WebView) view : null, InjectJSProxyImp.STRATEGY_INJECT_JS_IN_PAGESTAET);
            if (this.R || Intrinsics.b(this.T, str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("javascript:localStorage.setItem('pageUrl','");
                Page page2 = this.f30954a;
                sb2.append(page2 != null ? page2.getPagePath() : null);
                sb2.append("');");
                String string = sb2.toString();
                Page page3 = this.f30954a;
                View view2 = (page3 == null || (render = page3.getRender()) == null) ? null : render.getView();
                WebView webView2 = view2 instanceof WebView ? (WebView) view2 : null;
                if (webView2 != null) {
                    webView2.loadUrl(string);
                }
                this.R = false;
            }
            J1(1);
        } catch (Throwable th2) {
            TmcLogger.h("MiniH5Fragment", th2);
        }
        G2(webView, str);
        D2(webView, str);
    }

    @Override // zc.h
    public void onProgressChanged(WebView webView, int i11) {
        ProgressBar progressBar;
        zc.i render;
        zc.i render2;
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
            MiniAppH5BaseFragment.ProgressStep progressStep = MiniAppH5BaseFragment.ProgressStep.STEP_100;
            L2(progressStep);
            M2(progressStep);
            N1();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("pointTrackProgressChanged100New ->");
            Page page = this.f30954a;
            View view = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
            WebView webView2 = view instanceof WebView ? (WebView) view : null;
            sb2.append(webView2 != null ? webView2.getUrl() : null);
            TmcLogger.c("MiniH5Fragment", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("pointTrackProgressChanged100New ->");
            Page page2 = this.f30954a;
            View view2 = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
            WebView webView3 = view2 instanceof WebView ? (WebView) view2 : null;
            sb3.append(Intrinsics.b(webView3 != null ? webView3.getUrl() : null, this.T));
            TmcLogger.c("MiniH5Fragment", sb3.toString());
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
            boolean zIsForMainFrame = webResourceRequest.isForMainFrame();
            boolean z11 = true;
            if (zIsForMainFrame) {
                M1();
                c cVar = new c();
                int i11 = R$string.loading_error_tv;
                App app = this.f30955b;
                String appId = app != null ? app.getAppId() : null;
                FragmentActivity activity = getActivity();
                com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
                i.a.e(this, cVar, i11, "", appId, oooO0OO != null ? k.a(oooO0OO) : null);
                try {
                    Integer num = 2;
                    if (num == null || num.intValue() != 1) {
                        z11 = false;
                    }
                    setCapsuleStyle(z11);
                } catch (Throwable th2) {
                    TmcLogger.g("MiniH5Fragment", "", th2);
                }
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
    public void onReceivedTitle(String str) {
    }

    @Override // zc.h
    public /* synthetic */ void onRequestFocus() {
        zc.g.c(this);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        zc.i render;
        super.onResume();
        if (this.Q) {
            this.Q = false;
            kotlinx.coroutines.j.d(l0.a(w0.a()), null, null, new OooOO0(null), 3, null);
        }
        Y2();
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
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        ((IMonitorWebviewManagerProxy) tc.a.a(IMonitorWebviewManagerProxy.class)).registerMonitorListener(this);
        PageChainContext pageChainContext = this.f30956c;
        App app = this.f30955b;
        pageChainContext.E(app != null ? app.getAppChainContext() : null);
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
        App app2 = this.f30955b;
        performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CREATE, "");
        FragmentActivity activity = getActivity();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = activity instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) activity : null;
        if (oooO0OO != null && !oooO0OO.f31727m) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app3 = this.f30955b;
            performanceAnalyseProxy2.record(app3 != null ? app3.getAppId() : null, PointAnalyseType.POINT_PAGE_PV, "");
        }
        Page page2 = this.I;
        if (page2 != null) {
            Intrinsics.d(page2);
            j0(page2);
            this.I = null;
        }
        showNavigationBarLoading();
        hc.c.a(this, this);
        g.a aVar = this.H;
        if (aVar == null || (imageView = aVar.f65296d) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: e0.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o0000oo.Q2(this.f63620a, view2);
            }
        });
    }

    @Override // ee.i
    public void reportDomLoadTime(int i11, String uniqueId) {
        Intrinsics.g(uniqueId, "uniqueId");
        if (i11 == 1) {
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
        Intent intent;
        String string;
        H2(webView, webResourceRequest);
        B2(webView, webResourceRequest);
        if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
            String string2 = url.toString();
            Intrinsics.f(string2, "it.toString()");
            if (!l.L(string2, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
                try {
                    Object objFromJson = new Gson().fromJson(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("shellSchemeFilter", "[\"whatsapp\",\"sms\",\"tel\"]"), (Class<Object>) List.class);
                    List list = objFromJson instanceof List ? (List) objFromJson : null;
                    if (list != null && CollectionsKt___CollectionsKt.X(list, url.getScheme())) {
                        if ("intent".equals(url.getScheme())) {
                            intent = Intent.parseUri(url.toString(), 1);
                            Intrinsics.f(intent, "parseUri(it.toString(), Intent.URI_INTENT_SCHEME)");
                        } else {
                            intent = new Intent("android.intent.action.VIEW", Uri.parse(url.toString()));
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
            String strA1 = A1(webView);
            if (strA1 == null) {
                return Boolean.FALSE;
            }
            Uri url2 = webResourceRequest.getUrl();
            if (url2 == null || (string = url2.toString()) == null) {
                return Boolean.FALSE;
            }
            E2(strA1, string);
        }
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
