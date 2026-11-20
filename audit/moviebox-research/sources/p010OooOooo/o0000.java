package p010OooOooo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabBarBadgeMessage;
import com.cloud.tmc.integration.model.TabBarManualConfigStore;
import com.cloud.tmc.integration.model.TabBarMessageStore;
import com.cloud.tmc.integration.model.TabBarRedDotMessage;
import com.cloud.tmc.integration.model.TabBarStyle;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.proxy.AnimtionProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
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
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.ImmersiveTitleBarView;
import com.cloud.tmc.miniapp.widget.PageContainerView;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.miniutils.util.z;
import com.cloud.tmc.render.system.SystemWebView;
import com.cloud.tmc.worker.WorkerManager;
import com.google.gson.JsonObject;
import db.n;
import e0.u;
import h0.g;
import id.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import p010OooOooo.o0000;
import zc.f;
import zc.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o0000 extends MiniAppBaseFragment implements h, f, hc.a, uc.c {
    public static final /* synthetic */ int K = 0;
    public View A;
    public WebChromeClient.CustomViewCallback B;
    public int C;
    public View D;
    public boolean E;
    public boolean F;
    public boolean G;
    public String H;
    public boolean I;
    public String J;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g.a f200t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Page f201u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f202v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public uc.b f203w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public uc.b f204x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public uc.c f205y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public uc.c f206z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<Boolean> {
        public static final OooO OooO00o = new OooO();

        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            boolean zIsLowClient;
            try {
                zIsLowClient = ((AnimtionProxy) tc.a.a(AnimtionProxy.class)).isLowClient();
            } catch (Throwable th2) {
                TmcLogger.h("MiniFragment", th2);
                zIsLowClient = true;
            }
            return Boolean.valueOf(zIsLowClient);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Fragment> f207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Page> f208b;

        /* JADX INFO: renamed from: OooOooo.o0000$OooO00o$OooO00o, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$CreateMiniAppFail$onEvent$1", f = "MiniFragment.kt", l = {}, m = "invokeSuspend")
        public static final class C0011OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public C0011OooO00o(Continuation<? super C0011OooO00o> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return OooO00o.this.new C0011OooO00o(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return OooO00o.this.new C0011OooO00o(continuation).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                ResultKt.b(obj);
                Fragment fragment = OooO00o.this.f207a.get();
                FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
                i iVar = activity instanceof i ? (i) activity : null;
                if (iVar != null) {
                    Integer numA = OooO00o.this.a();
                    i.a.k(iVar, (numA != null && numA.intValue() == 2) ? R$drawable.mini_ic_error_normal_mode : R$drawable.mini_ic_error, R$string.loading_error_miniapp_went_wrong, R$string.loading_error_miniapp_cant_open_now, null, false, false, null, 112, null);
                }
                return Unit.f68710a;
            }
        }

        public OooO00o(Fragment context, Page page) {
            Intrinsics.g(context, "context");
            this.f207a = new WeakReference<>(context);
            this.f208b = new WeakReference<>(page);
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            App app;
            IEngine engineProxy;
            Page page = this.f208b.get();
            if (!Intrinsics.b((page == null || (app = page.getApp()) == null || (engineProxy = app.getEngineProxy()) == null) ? null : engineProxy.getWorkerId(), aVar != null ? aVar.getName() : null)) {
                Page page2 = this.f208b.get();
                if (!Intrinsics.b(page2 != null ? page2.getPageId() : null, aVar != null ? aVar.getName() : null)) {
                    return false;
                }
            }
            if (!Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                j.d(l0.a(w0.c()), null, null, new C0011OooO00o(null), 3, null);
                return true;
            }
            Fragment fragment = this.f207a.get();
            FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
            i iVar = activity instanceof i ? (i) activity : null;
            if (iVar == null) {
                return true;
            }
            Integer numA = a();
            i.a.k(iVar, (numA != null && numA.intValue() == 2) ? R$drawable.mini_ic_error_normal_mode : R$drawable.mini_ic_error, R$string.loading_error_miniapp_went_wrong, R$string.loading_error_miniapp_cant_open_now, null, false, false, null, 112, null);
            return true;
        }

        public final Integer a() {
            Fragment fragment = this.f207a.get();
            KeyEventDispatcher.Component activity = fragment != null ? fragment.getActivity() : null;
            i iVar = activity instanceof i ? (i) activity : null;
            if (iVar != null) {
                return iVar.getViewThemeMode();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$hideCustomView$1", f = "MiniFragment.kt", l = {822, 823}, m = "invokeSuspend")
    public static final class OooO0o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;

        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$hideCustomView$1$1", f = "MiniFragment.kt", l = {}, m = "invokeSuspend")
        public static final class OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public final /* synthetic */ o0000 OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(o0000 o0000Var, Continuation<? super OooO00o> continuation) {
                super(2, continuation);
                this.OooO00o = o0000Var;
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
                if (this.OooO00o.D == null) {
                    Intrinsics.y("contextView");
                }
                View view = this.OooO00o.D;
                if (view == null) {
                    Intrinsics.y("contextView");
                    view = null;
                }
                view.scrollTo(0, this.OooO00o.C);
                return Unit.f68710a;
            }
        }

        public OooO0o(Continuation<? super OooO0o> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o0000.this.new OooO0o(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return o0000.this.new OooO0o(continuation).invokeSuspend(Unit.f68710a);
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
            OooO00o oooO00o = new OooO00o(o0000.this, null);
            this.OooO00o = 2;
            if (kotlinx.coroutines.h.g(a2VarC, oooO00o, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$onResume$1$1", f = "MiniFragment.kt", l = {242, 243}, m = "invokeSuspend")
    public static final class OooOO0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;

        /* JADX INFO: compiled from: source.java */
        @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$onResume$1$1$1", f = "MiniFragment.kt", l = {}, m = "invokeSuspend")
        public static final class OooO00o extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            public final /* synthetic */ o0000 OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(o0000 o0000Var, Continuation<? super OooO00o> continuation) {
                super(2, continuation);
                this.OooO00o = o0000Var;
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
                if (this.OooO00o.D == null) {
                    Intrinsics.y("contextView");
                }
                View view = this.OooO00o.D;
                if (view == null) {
                    Intrinsics.y("contextView");
                    view = null;
                }
                view.scrollTo(0, this.OooO00o.C);
                return Unit.f68710a;
            }
        }

        public OooOO0(Continuation<? super OooOO0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o0000.this.new OooOO0(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return o0000.this.new OooOO0(continuation).invokeSuspend(Unit.f68710a);
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
            OooO00o oooO00o = new OooO00o(o0000.this, null);
            this.OooO00o = 2;
            if (kotlinx.coroutines.h.g(a2VarC, oooO00o, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<o0000> f209a;

        public a(o0000 context) {
            Intrinsics.g(context, "context");
            this.f209a = new WeakReference<>(context);
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            o0000 o0000Var = this.f209a.get();
            if (o0000Var != null) {
                g.d(o0000Var);
            }
            try {
                o0000 o0000Var2 = this.f209a.get();
                if (o0000Var2 != null) {
                    o0000 o0000Var3 = this.f209a.get();
                    o0000Var2.F = o0000Var3 != null ? o0000Var3.G : false;
                }
                o0000 o0000Var4 = this.f209a.get();
                if (o0000Var4 == null) {
                    return true;
                }
                int i11 = o0000.K;
                o0000Var4.J1();
                return true;
            } catch (Throwable th2) {
                TmcLogger.g("MiniFragment", "", th2);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements uc.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uc.b f211b;

        public b(uc.b bVar) {
            this.f211b = bVar;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            fe.f webviewBridgeHelper;
            zc.i render;
            zc.i render2;
            Page page = o0000.this.f30954a;
            if (!l.w((page == null || (render2 = page.getRender()) == null) ? null : render2.b(), aVar != null ? aVar.b() : null, false, 2, null)) {
                return false;
            }
            Page page2 = o0000.this.f30954a;
            View view = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
            SystemWebView systemWebView = view instanceof SystemWebView ? (SystemWebView) view : null;
            if (systemWebView != null && (webviewBridgeHelper = systemWebView.getWebviewBridgeHelper()) != null) {
                webviewBridgeHelper.b();
            }
            o0000.this.H1();
            this.f211b.c("renderOnMessageReady", this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements uc.c {
        public c() {
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            MiniAppBaseFragment.V0(o0000.this, null, 1, null);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements uc.c {
        public d() {
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            if (aVar == null) {
                return true;
            }
            o0000.this.U0(aVar.getData());
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements zc.d {
        public e() {
        }

        @Override // zc.d
        public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            FrameLayout frameLayout;
            o0000.this.L0().set(true);
            o0000 o0000Var = o0000.this;
            if (o0000Var.A != null) {
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                return;
            }
            o0000Var.A = view;
            g.a aVar = o0000Var.f200t;
            if (aVar != null && (frameLayout = aVar.f65295c) != null) {
                frameLayout.setVisibility(0);
                FragmentActivity it = o0000Var.getActivity();
                if (it != null) {
                    Intrinsics.f(it, "it");
                    g.e(o0000Var, frameLayout, it);
                }
                frameLayout.addView(o0000Var.A, 0);
            }
            if (o0000Var.D == null) {
                Intrinsics.y("contextView");
            }
            View view2 = o0000Var.D;
            if (view2 == null) {
                Intrinsics.y("contextView");
                view2 = null;
            }
            o0000Var.C = view2.getScrollY();
            o0000Var.B = customViewCallback;
        }

        @Override // zc.d
        public void b() {
            o0000.this.L0().set(false);
            o0000 o0000Var = o0000.this;
            int i11 = o0000.K;
            o0000Var.C1(false);
        }
    }

    public o0000() {
        LazyKt__LazyJVMKt.b(OooO.OooO00o);
        this.H = "";
        this.J = "";
    }

    public static final void A1(OooO0OO oooO0OO, View view) {
        if (oooO0OO != null) {
            oooO0OO.G0();
        }
    }

    public static final boolean B1(o0000 this$0, uc.a aVar) {
        Intrinsics.g(this$0, "this$0");
        this$0.I0();
        return false;
    }

    public static final void E1(o0000 this$0) {
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
        OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
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
                eventCenterInstance.b("renderOnMessageReady", this$0.new b(eventCenterInstance));
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

    public static final void F1(OooO0OO oooO0OO, View view) {
        if (oooO0OO != null) {
            oooO0OO.m0((1 & 1) != 0 ? "0" : null);
        }
    }

    public static final boolean G1(o0000 this$0, uc.a aVar) {
        Intrinsics.g(this$0, "this$0");
        this$0.D1();
        return false;
    }

    public static final void I1(o0000 this$0) {
        Intrinsics.g(this$0, "this$0");
        TmcLogger.c("MiniFragment", "showWebViewMask 执行超时关闭遮罩");
        this$0.D1();
    }

    public static final void s1(int i11, View maskView, final o0000 this$0) {
        Intrinsics.g(maskView, "$maskView");
        Intrinsics.g(this$0, "this$0");
        if (i11 != 0) {
            try {
                maskView.setBackgroundColor(i11);
                TmcLogger.c("MiniFragment", "showWebViewMask maskView background 设置成功");
            } catch (Throwable th2) {
                TmcLogger.g("MiniFragment", "", th2);
                return;
            }
        }
        if (!xb.i.a(maskView)) {
            xb.i.e(maskView);
            TmcLogger.c("MiniFragment", "showWebViewMask maskView 显示成功");
        }
        this$0.N0(maskView, 5000L, new Runnable() { // from class: e0.d
            @Override // java.lang.Runnable
            public final void run() {
                o0000.I1(this.f63578a);
            }
        });
        TmcLogger.c("MiniFragment", "showWebViewMask 执行完毕");
    }

    public static final void t1(o0000 this$0, int i11, int i12, long j11) {
        Intrinsics.g(this$0, "this$0");
        this$0.changeNavigationBarProgress(i11 + 1, i12, j11);
    }

    public static final void u1(o0000 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.C1(false);
    }

    public static final void v1(o0000 this$0, Page page) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(page, "$page");
        g.a aVar = this$0.f200t;
        if ((aVar != null ? aVar.f65293a : null) != null) {
            this$0.y1(page);
        } else {
            this$0.f201u = page;
        }
    }

    public static final void w1(o0000 this$0, OooO0OO oooO0OO, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y0();
        if (oooO0OO != null) {
            oooO0OO.I0();
        }
    }

    public static final void x1(View maskView) {
        Intrinsics.g(maskView, "$maskView");
        try {
            if (maskView.getVisibility() != 4) {
                xb.i.d(maskView);
                TmcLogger.c("MiniFragment", "hideWebViewMask maskView 隐藏成功");
            }
            TmcLogger.c("MiniFragment", "hideWebViewMask 执行完毕");
        } catch (Throwable th2) {
            TmcLogger.g("MiniFragment", "", th2);
        }
    }

    public static final void z1(Page page, o0000 this$0) {
        zc.i render;
        zc.i render2;
        PageContainerView pageContainerView;
        App app;
        App app2;
        App app3;
        Bundle startParams;
        zc.i render3;
        zc.i render4;
        PageContainerView pageContainerView2;
        zc.i render5;
        App app4;
        zc.i render6;
        zc.i render7;
        Intrinsics.g(this$0, "this$0");
        if (page != null && (render7 = page.getRender()) != null) {
            render7.d(this$0);
        }
        g.g(this$0, page, this$0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            g.a aVar = this$0.f200t;
            g.h(this$0, page, aVar != null ? aVar.f65295c : null, activity, this$0.f30955b, this$0);
        }
        if (page != null && (render6 = page.getRender()) != null) {
            render6.y(this$0.new e());
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
        View view = (page3 == null || (render5 = page3.getRender()) == null) ? null : render5.getView();
        if (view == null) {
            return;
        }
        this$0.D = view;
        AppLoadResult appLoadResult2 = this$0.getAppLoadResult();
        Page page4 = this$0.f30954a;
        MiniAppConfigModel.WindowBean windowBeanF = d0.f(appLoadResult2, page4 != null ? page4.getPagePath() : null);
        if (windowBeanF != null) {
            try {
                String contentBgColor = windowBeanF.getContentBgColor();
                if (contentBgColor != null && contentBgColor.length() > 0) {
                    int color = Color.parseColor(contentBgColor);
                    this$0.r1(color);
                    g.a aVar2 = this$0.f200t;
                    if (aVar2 != null && (pageContainerView = aVar2.f65294b) != null) {
                        pageContainerView.setBackgroundColor(color);
                    }
                    Page page5 = this$0.f30954a;
                    if (page5 != null && (render2 = page5.getRender()) != null) {
                        render2.setBgColor(contentBgColor);
                    }
                }
            } catch (Exception e11) {
                TmcLogger.g("MiniFragment", "set content background color error", e11);
            }
            Boolean enablePullDownRefresh = windowBeanF.getEnablePullDownRefresh();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.b(enablePullDownRefresh, bool) || Intrinsics.b(windowBeanF.getEnablePullUpRefresh(), bool)) {
                View view2 = this$0.D;
                if (view2 == null) {
                    Intrinsics.y("contextView");
                    view2 = null;
                }
                this$0.D = this$0.u0(view2, windowBeanF);
            }
            try {
                if (Intrinsics.b(windowBeanF.getLimitTextZoom(), bool)) {
                    Page page6 = this$0.f30954a;
                    View view3 = (page6 == null || (render = page6.getRender()) == null) ? null : render.getView();
                    WebView webView = view3 instanceof WebView ? (WebView) view3 : null;
                    WebSettings settings = webView != null ? webView.getSettings() : null;
                    if (settings != null) {
                        settings.setTextZoom(100);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        g.a aVar3 = this$0.f200t;
        if (aVar3 != null && (pageContainerView2 = aVar3.f65294b) != null) {
            View view4 = this$0.D;
            if (view4 == null) {
                Intrinsics.y("contextView");
                view4 = null;
            }
            xb.i.b(view4);
            pageContainerView2.addView(view4);
        }
        Page page7 = this$0.f30954a;
        if (page7 == null || (render4 = page7.getRender()) == null || !render4.c()) {
            uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this$0.f30955b);
            if (eventCenterInstance != null) {
                eventCenterInstance.b("renderOnMessageReady", new u(this$0, eventCenterInstance));
            }
        } else {
            Bundle bundle = new Bundle();
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page8 = this$0.f30954a;
            bundle.putString(str, String.valueOf(page8 != null ? page8.getPagePath() : null));
            String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page9 = this$0.f30954a;
            bundle.putString(str2, String.valueOf(page9 != null ? page9.getPageId() : null));
            this$0.H1();
        }
        Page page10 = this$0.f30954a;
        zc.i render8 = page10 != null ? page10.getRender() : null;
        Page page11 = this$0.f30954a;
        App app5 = page11 != null ? page11.getApp() : null;
        kb.a aVar4 = kb.a.f68517a;
        String appId = app5 != null ? app5.getAppId() : null;
        if (appId == null) {
            appId = "";
        }
        String strB = render8 != null ? render8.b() : null;
        aVar4.a(appId, strB != null ? strB : "");
        Page page12 = this$0.f30954a;
        if (page12 == null || (render3 = page12.getRender()) == null || !render3.c()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, String.valueOf((app5 == null || (startParams = app5.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            String str3 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page13 = this$0.f30954a;
            bundle2.putString(str3, String.valueOf(page13 != null ? page13.getPagePath() : null));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page14 = this$0.f30954a;
            performanceAnalyseProxy.record((page14 == null || (app3 = page14.getApp()) == null) ? null : app3.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31223m, bundle2);
            Bundle bundle3 = new Bundle();
            String str4 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page15 = this$0.f30954a;
            bundle3.putString(str4, String.valueOf(page15 != null ? page15.getPagePath() : null));
            String str5 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page16 = this$0.f30954a;
            bundle3.putString(str5, String.valueOf(page16 != null ? page16.getPageId() : null));
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page17 = this$0.f30954a;
            performanceAnalyseProxy2.record((page17 == null || (app2 = page17.getApp()) == null) ? null : app2.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle3);
            PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page18 = this$0.f30954a;
            performanceAnalyseProxy3.record((page18 == null || (app = page18.getApp()) == null) ? null : app.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle3);
            db.l lVar = new db.l(bundle3);
            Page page19 = this$0.f30954a;
            lVar.f(page19 != null ? page19.getPageChainContext() : null);
            zc.l lVar2 = new zc.l();
            Page page20 = this$0.f30954a;
            lVar2.f81893a = page20 != null ? page20.getPageURI() : null;
            Page page21 = this$0.f30954a;
            lVar2.f81894b = page21 != null ? page21.getPagePath() : null;
            lVar2.f81895c = app5 != null ? app5.getAppId() : null;
            if (render8 != null) {
                render8.k(lVar2);
            }
            View view5 = render8 != null ? render8.getView() : null;
            WebView webView2 = view5 instanceof WebView ? (WebView) view5 : null;
            if (webView2 != null) {
                webView2.setVerticalScrollBarEnabled(false);
                webView2.setHorizontalScrollBarEnabled(false);
            }
        }
        FragmentActivity activity2 = this$0.getActivity();
        OooO0OO oooO0OO = activity2 instanceof OooO0OO ? (OooO0OO) activity2 : null;
        if (oooO0OO != null) {
            oooO0OO.T(MiniAppLaunch.f31784a.R());
        }
    }

    public final boolean C1(boolean z11) {
        FrameLayout frameLayout;
        if (this.A == null) {
            return false;
        }
        if (z11) {
            this.E = true;
        }
        j.d(l0.a(w0.a()), null, null, new OooO0o(null), 3, null);
        g.a aVar = this.f200t;
        if (aVar != null && (frameLayout = aVar.f65295c) != null) {
            frameLayout.setVisibility(8);
            frameLayout.removeView(this.A);
        }
        View view = this.A;
        if (view != null) {
            view.setVisibility(8);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.B;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.A = null;
        this.B = null;
        if (E0()) {
            j1();
        }
        g.l(this);
        return true;
    }

    public final void D1() {
        g.a aVar;
        final View view;
        try {
            boolean zF = MiniAppLaunch.f31784a.F();
            TmcLogger.c("MiniFragment", "hideWebViewMask enableWebViewMask: " + zF);
            if (zF && (aVar = this.f200t) != null && (view = aVar.f65300i) != null) {
                P0(view);
                com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: e0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        o0000.x1(view);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniFragment", "", th2);
        }
    }

    public final void H1() {
        gd.b workerById;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app2;
        IEngine engineProxy2;
        Page page;
        App app3;
        App app4;
        App app5;
        App app6;
        Bundle startParams;
        zc.i render;
        App app7;
        try {
            Page page2 = this.f30954a;
            AppModel appModel = (page2 == null || (app7 = page2.getApp()) == null) ? null : app7.getAppModel();
            if (appModel != null && AppUtils.f31011a.g(appModel.getMiniappSubtype())) {
                Page page3 = this.f30954a;
                View view = (page3 == null || (render = page3.getRender()) == null) ? null : render.getView();
                SystemWebView systemWebView = view instanceof SystemWebView ? (SystemWebView) view : null;
                if (systemWebView != null) {
                    systemWebView.setCommonresId(appModel.getTemplateMiniappId());
                }
                TmcLogger.c("MiniFragment", "use commonres miniapp, commonresId is " + appModel.getTemplateMiniappId());
            }
        } catch (Throwable unused) {
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
        String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
        Page page4 = this.f30954a;
        bundle.putString(str, String.valueOf((page4 == null || (app6 = page4.getApp()) == null || (startParams = app6.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
        String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page5 = this.f30954a;
        bundle.putString(str2, String.valueOf(page5 != null ? page5.getPagePath() : null));
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page6 = this.f30954a;
        performanceAnalyseProxy.record((page6 == null || (app5 = page6.getApp()) == null) ? null : app5.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31228p, bundle);
        Page page7 = this.f30954a;
        boolean booleanValue = (page7 == null || (app4 = page7.getApp()) == null) ? false : app4.getBooleanValue("firstNormalPageOpened");
        TmcLogger.c("MiniFragment", "Check first page opened: " + booleanValue);
        if (!booleanValue && (page = this.f30954a) != null && (app3 = page.getApp()) != null) {
            app3.putBooleanValue("firstNormalPageOpened", true);
        }
        TmcLogger.c("subPkg", "openPage");
        FragmentActivity activity = getActivity();
        OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
        if (oooO0OO == null || !oooO0OO.f31727m) {
            TmcLogger.c("subPkg", "pageReady");
            MiniAppBaseFragment.R0(this, "pageReady", null, 2, null);
            Bundle bundle2 = new Bundle();
            String str3 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page8 = this.f30954a;
            bundle2.putString(str3, String.valueOf(page8 != null ? page8.getPagePath() : null));
            String str4 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page9 = this.f30954a;
            bundle2.putString(str4, String.valueOf(page9 != null ? page9.getPageId() : null));
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app8 = this.f30955b;
            performanceAnalyseProxy2.record(app8 != null ? app8.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle2);
            PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app9 = this.f30955b;
            performanceAnalyseProxy3.record(app9 != null ? app9.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle2);
            Page page10 = this.f30954a;
            if (page10 == null || (app = page10.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
                workerById = null;
            } else {
                Page page11 = this.f30954a;
                workerById = engineRouter.getWorkerById((page11 == null || (app2 = page11.getApp()) == null || (engineProxy2 = app2.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
            }
            Bundle bundle3 = new Bundle();
            String str5 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page12 = this.f30954a;
            bundle3.putString(str5, String.valueOf(page12 != null ? page12.getPagePath() : null));
            String str6 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page13 = this.f30954a;
            bundle3.putString(str6, String.valueOf(page13 != null ? page13.getPageId() : null));
            bundle3.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, System.currentTimeMillis());
            db.e eVar = new db.e(bundle3);
            Page page14 = this.f30954a;
            eVar.f(page14 != null ? page14.getPageChainContext() : null);
            xa.e eVar2 = new xa.e(bundle3);
            Page page15 = this.f30954a;
            eVar2.f(page15 != null ? page15.getPageChainContext() : null);
            Bundle bundle4 = new Bundle();
            bundle4.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, System.currentTimeMillis());
            String str7 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page16 = this.f30954a;
            bundle4.putString(str7, String.valueOf(page16 != null ? page16.getPagePath() : null));
            String str8 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page17 = this.f30954a;
            bundle4.putString(str8, String.valueOf(page17 != null ? page17.getPageId() : null));
            n nVar = new n(bundle4);
            Page page18 = this.f30954a;
            nVar.f(page18 != null ? page18.getPageChainContext() : null);
            xa.n nVar2 = new xa.n(bundle4);
            Page page19 = this.f30954a;
            nVar2.f(page19 != null ? page19.getPageChainContext() : null);
            db.a aVar = new db.a(bundle4);
            Page page20 = this.f30954a;
            aVar.f(page20 != null ? page20.getPageChainContext() : null);
            if (workerById == null || !Intrinsics.b(workerById.n(), Boolean.TRUE)) {
                IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
                Page page21 = this.f30954a;
                uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(page21 != null ? page21.getApp() : null);
                if (eventCenterInstance != null) {
                    eventCenterInstance.b(WorkerManager.f32140n.a(), new c());
                }
            } else {
                MiniAppBaseFragment.V0(this, null, 1, null);
            }
        } else {
            TmcLogger.c("subPkg", "appReady");
            MiniAppBaseFragment.R0(this, "appReady", null, 2, null);
            FragmentActivity activity2 = getActivity();
            OooO0OO oooO0OO2 = activity2 instanceof OooO0OO ? (OooO0OO) activity2 : null;
            if (oooO0OO2 != null) {
                oooO0OO2.f31727m = false;
            }
        }
        try {
            uc.b eventCenterInstance2 = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f30954a);
            if (eventCenterInstance2 != null) {
                eventCenterInstance2.b("slaveLoaded", new uc.c() { // from class: e0.h
                    @Override // uc.c
                    public final boolean O(uc.a aVar2) {
                        return o0000.B1(this.f63597a, aVar2);
                    }
                });
            }
            uc.b eventCenterInstance3 = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f30954a);
            if (eventCenterInstance3 != null) {
                eventCenterInstance3.b("slaveAttached", new uc.c() { // from class: e0.i
                    @Override // uc.c
                    public final boolean O(uc.a aVar2) {
                        return o0000.G1(this.f63600a, aVar2);
                    }
                });
            }
            uc.b eventCenterInstance4 = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f30954a);
            if (eventCenterInstance4 != null) {
                eventCenterInstance4.b("onSwitchTab", new d());
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniFragment", "", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, id.g
    public void I() {
        super.I();
        TmcLogger.b("[MiniFragment]：onRefreshEvent");
        MiniAppBaseFragment.T0(this, "onPullDownRefresh", true, null, 4, null);
    }

    public final void J1() {
        boolean zB;
        Page page;
        App app = this.f30955b;
        if (app != null) {
            AbilitiesUtils abilitiesUtils = AbilitiesUtils.f30983a;
            String appId = app.getAppId();
            Intrinsics.f(appId, "it.appId");
            zB = abilitiesUtils.b(appId, "title_bar_add_home");
        } else {
            zB = true;
        }
        Page page2 = this.f30954a;
        String stringValue = page2 != null ? page2.getStringValue("isApiAddScreenEnabled") : null;
        if (Intrinsics.b(stringValue, "showAddScreenButton")) {
            if (zB) {
                Page page3 = this.f30954a;
                if (page3 != null) {
                    page3.showAddScreenButton();
                }
            } else {
                Page page4 = this.f30954a;
                if (page4 != null) {
                    page4.hideAddScreenButton();
                }
            }
        } else if (Intrinsics.b(stringValue, "hideAddScreenButton")) {
            Page page5 = this.f30954a;
            if (page5 != null) {
                page5.hideAddScreenButton();
            }
        } else if (zB) {
            Page page6 = this.f30954a;
            if (page6 != null) {
                page6.showAddScreenButton();
            }
        } else {
            Page page7 = this.f30954a;
            if (page7 != null) {
                page7.hideAddScreenButton();
            }
        }
        MiniAppConfigModel.WindowBean window = getWindow();
        if (window != null && window.navigationStyleIsHide()) {
            Page page8 = this.f30954a;
            if (page8 != null) {
                page8.setTitleBarVisible(false);
            }
            Page page9 = this.f30954a;
            if (page9 != null) {
                page9.setNavigationBarTitleColor(window.navigationBarTextStyleIsWhite());
            }
            Page page10 = this.f30954a;
            if (page10 != null) {
                page10.setNavigationBarIconStyle(window.navigationBarIconStyleIsWhite());
                return;
            }
            return;
        }
        Page page11 = this.f30954a;
        String stringValue2 = page11 != null ? page11.getStringValue("isApiShowHomeEnabled") : null;
        if (Intrinsics.b(stringValue2, "showHomeButton")) {
            if (M0(getAppLoadResult())) {
                Page page12 = this.f30954a;
                if (page12 != null) {
                    page12.hideHomeButton();
                }
            } else {
                Page page13 = this.f30954a;
                if (page13 != null) {
                    page13.showHomeButton();
                }
            }
        } else if (Intrinsics.b(stringValue2, "hideHomeButton")) {
            Page page14 = this.f30954a;
            if (page14 != null) {
                page14.hideHomeButton();
            }
        } else if (M0(getAppLoadResult())) {
            Page page15 = this.f30954a;
            if (page15 != null) {
                page15.hideHomeButton();
            }
        } else {
            Page page16 = this.f30954a;
            if (page16 != null) {
                page16.showHomeButton();
            }
        }
        g.a aVar = this.f200t;
        ProgressBar progressBar = aVar != null ? aVar.f65297f : null;
        if (progressBar != null) {
            progressBar.setTag(Boolean.valueOf(window != null ? Intrinsics.b(window.getEnableNavigationBarLoading(), Boolean.TRUE) : false));
        }
        if (window == null || !window.navigationStyleIsCustom()) {
            Page page17 = this.f30954a;
            if (page17 != null) {
                page17.setNavigationBarTitleColor(this.F);
            }
            Page page18 = this.f30954a;
            if (page18 != null) {
                page18.setNavigationBarBackgroundColor(eb.a.f64071a.a(getContext()));
            }
            Page page19 = this.f30954a;
            if (page19 != null) {
                page19.setNavigationBarTransparent(false);
            }
            Page page20 = this.f30954a;
            if (page20 != null) {
                page20.setNavigationBarIconStyle(this.F);
                return;
            }
            return;
        }
        if (window != null) {
            Page page21 = this.f30954a;
            if (page21 != null) {
                page21.setNavigationBarTitleColor(window.navigationBarTextStyleIsWhite());
            }
            Page page22 = this.f30954a;
            if (page22 != null) {
                page22.setNavigationBarBackgroundColor(window.getNavigationBgColor());
            }
            Page page23 = this.f30954a;
            if (page23 != null) {
                page23.setNavigationBarTransparent(Intrinsics.b(window.getEnableTransparentStatusBar(), Boolean.TRUE));
            }
            String navigationBarHomeAction = window.getNavigationBarHomeAction();
            if (navigationBarHomeAction != null && (page = this.f30954a) != null) {
                page.setHomeAction(d0.g(navigationBarHomeAction), false);
            }
            this.G = window.navigationBarIconStyleIsWhite();
            Page page24 = this.f30954a;
            if (page24 != null) {
                page24.setNavigationBarIconStyle(this.F);
            }
        }
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

    @Override // tb.d
    public ProgressBar S() {
        g.a aVar = this.f200t;
        if (aVar != null) {
            return aVar.f65297f;
        }
        return null;
    }

    @Override // tb.d
    public ub.b a0() {
        g.a aVar = this.f200t;
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
        g.a aVar = this.f200t;
        if (aVar != null && (progressBar = aVar.f65297f) != null) {
            progressBar.postDelayed(new Runnable() { // from class: e0.f
                @Override // java.lang.Runnable
                public final void run() {
                    o0000.t1(this.f63584a, i11, i12, j11);
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
        Bundle startParams;
        App app;
        uc.b eventCenterInstance;
        super.destroy();
        uc.b bVar = this.f203w;
        if (bVar != null) {
            bVar.c("consumeTime", this);
        }
        uc.b bVar2 = this.f203w;
        if (bVar2 != null) {
            bVar2.c("create_miniapp_worker_fail", this.f205y);
        }
        uc.b bVar3 = this.f204x;
        if (bVar3 != null) {
            bVar3.c("create_miniapp_worker_fail", this.f205y);
        }
        g.f(this, this.f30954a);
        Page page = this.f30954a;
        Intrinsics.g(this, "<this>");
        if (page != null && (eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(page)) != null) {
            StringBuilder sbA = hd.j.a("eventAD_");
            sbA.append(page.getNodeId());
            eventCenterInstance.a(sbA.toString());
        }
        uc.b bVar4 = this.f204x;
        if (bVar4 != null) {
            bVar4.c("onPageReady", this.f206z);
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page2 = this.f30954a;
        String strB = null;
        String appId = (page2 == null || (app = page2.getApp()) == null) ? null : app.getAppId();
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_CLEAR;
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
        String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
        App app2 = this.f30955b;
        bundle.putString(str, String.valueOf((app2 == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
        String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page3 = this.f30954a;
        bundle.putString(str2, String.valueOf(page3 != null ? page3.getPagePath() : null));
        Page page4 = this.f30954a;
        bundle.putString("pageRandomId", page4 != null ? page4.getPageRandomIdByGAId() : null);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record(appId, pointAnalyseType, "clear", bundle);
        IScreenInspectProxy iScreenInspectProxy = (IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class);
        Page page5 = this.f30954a;
        App app3 = page5 != null ? page5.getApp() : null;
        Page page6 = this.f30954a;
        iScreenInspectProxy.destroy(app3, String.valueOf(page6 != null ? page6.getPagePath() : null));
        Page page7 = this.f30954a;
        if (page7 == null || (render2 = page7.getRender()) == null || !render2.c()) {
            Page page8 = this.f30954a;
            if (page8 == null || (render = page8.getRender()) == null) {
                return;
            }
            render.destroy();
            return;
        }
        IInnerRenderPool iInnerRenderPool = (IInnerRenderPool) tc.a.a(IInnerRenderPool.class);
        Page page9 = this.f30954a;
        if (page9 != null && (render3 = page9.getRender()) != null) {
            strB = render3.b();
        }
        iInnerRenderPool.removeRender(strB);
    }

    @Override // hc.a
    public void f() {
        hc.b.f66421b = true;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: e0.g
                @Override // java.lang.Runnable
                public final void run() {
                    o0000.E1(this.f63590a);
                }
            });
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.TmcFragment
    public Boolean g0() {
        return Boolean.valueOf(C1(false));
    }

    @Override // vb.c
    public void hideNavigationBarLoading() {
        ProgressBar progressBar;
        g.a aVar = this.f200t;
        ProgressBar progressBar2 = aVar != null ? aVar.f65297f : null;
        if (progressBar2 != null) {
            progressBar2.setTag(Boolean.FALSE);
        }
        g.a aVar2 = this.f200t;
        if (aVar2 == null || (progressBar = aVar2.f65297f) == null) {
            return;
        }
        xb.i.c(progressBar);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void initView() {
        String navigationBarTitleText;
        String templateMiniappId;
        App app;
        AppModel appModel;
        AppModel appModel2;
        MiniAppConfigModel miniAppConfigModel;
        super.initView();
        FragmentActivity activity = getActivity();
        Integer miniappSubtype = null;
        final OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
        EntryInfo entryInfoD0 = D0();
        g.a aVar = this.f200t;
        if (aVar != null) {
            ImmersiveTitleBarView immersiveTitleBarView = aVar.f65299h;
            immersiveTitleBarView.attachPage(this.f30954a);
            MiniAppConfigModel.WindowBean window = getWindow();
            if (window == null || (navigationBarTitleText = window.getNavigationBarTitleText()) == null) {
                navigationBarTitleText = entryInfoD0 != null ? entryInfoD0.title : null;
            }
            immersiveTitleBarView.setTitle(navigationBarTitleText);
            immersiveTitleBarView.setOnAddScreenClickListener(new View.OnClickListener() { // from class: e0.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0000.F1(oooO0OO, view);
                }
            });
            immersiveTitleBarView.setOnHomeClickListener(new View.OnClickListener() { // from class: e0.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0000.w1(this.f63607a, oooO0OO, view);
                }
            });
            immersiveTitleBarView.setOnBackClickListener(new View.OnClickListener() { // from class: e0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0000.A1(oooO0OO, view);
                }
            });
            AppLoadResult appLoadResult = getAppLoadResult();
            if (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null || !miniAppConfigModel.tabBarManual()) {
                MiniAppConfigModel.TabBarBean tabBarBeanD = d0.d(appLoadResult);
                AppUtils appUtils = AppUtils.f31011a;
                App app2 = this.f30955b;
                if (app2 != null && (appModel2 = app2.getAppModel()) != null) {
                    miniappSubtype = appModel2.getMiniappSubtype();
                }
                if (!appUtils.g(miniappSubtype) || (app = this.f30955b) == null || (appModel = app.getAppModel()) == null || (templateMiniappId = appModel.getTemplateMiniappId()) == null) {
                    templateMiniappId = "";
                }
                n(tabBarBeanD, templateMiniappId);
            }
        }
        try {
            q1();
        } catch (Throwable th2) {
            TmcLogger.g("MiniFragment", "", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, com.cloud.tmc.integration.ui.fragment.TmcFragment
    public void j0(final Page page) {
        ua.f appLifecycleCallback;
        Intrinsics.g(page, "page");
        super.j0(page);
        this.f30954a = page;
        App app = (App) page.bubbleFindNode(App.class);
        this.f30955b = app;
        if (app != null) {
            try {
                appLifecycleCallback = app.getAppLifecycleCallback();
            } catch (Throwable th2) {
                TmcLogger.h("MiniFragment", th2);
            }
        } else {
            appLifecycleCallback = null;
        }
        if (appLifecycleCallback == null) {
            TmcLogger.c("MiniFragment", "setMiniappLifecycleCallback");
            App app2 = this.f30955b;
            if (app2 != null) {
                FragmentActivity activity = getActivity();
                app2.setMiniappLifecycleCallback(activity instanceof OooO0OO ? (OooO0OO) activity : null);
            }
        }
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: e0.e
            @Override // java.lang.Runnable
            public final void run() {
                o0000.v1(this.f63580a, page);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View viewV0;
        Intrinsics.g(inflater, "inflater");
        this.F = z.a(getContext());
        this.f200t = g.a.a(inflater);
        Page page = this.f30954a;
        if (page == null || !page.isTabPage()) {
            g.a aVar = this.f200t;
            Intrinsics.d(aVar);
            ConstraintLayout constraintLayout = aVar.f65293a;
            Intrinsics.f(constraintLayout, "binding!!.root");
            viewV0 = v0(constraintLayout);
        } else {
            g.a aVar2 = this.f200t;
            Intrinsics.d(aVar2);
            viewV0 = aVar2.f65293a;
            Intrinsics.f(viewV0, "binding!!.root");
        }
        xb.i.b(viewV0);
        return viewV0;
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PageChainContext pageChainContext;
        zc.i render;
        zc.i render2;
        kb.a aVar = kb.a.f68517a;
        App app = this.f30955b;
        String appId = app != null ? app.getAppId() : null;
        Page page = this.f30954a;
        aVar.e(appId, (page == null || (render2 = page.getRender()) == null) ? null : render2.b());
        Page page2 = this.f30954a;
        View view = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31210f0, this.f30957d.getDes());
        String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page3 = this.f30954a;
        bundle.putString(str, String.valueOf(page3 != null ? page3.getPagePath() : null));
        String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
        Page page4 = this.f30954a;
        bundle.putString(str2, String.valueOf(page4 != null ? page4.getPageId() : null));
        Page page5 = this.f30954a;
        bundle.putString("pageRandomId", String.valueOf(page5 != null ? page5.getPageRandomIdByGAId() : null));
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        App app2 = this.f30955b;
        performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_CLEAR, "clear", bundle);
        cb.b bVar = new cb.b(bundle);
        Page page6 = this.f30954a;
        bVar.f(page6 != null ? page6.getPageChainContext() : null);
        Page page7 = this.f30954a;
        if (page7 == null || (pageChainContext = page7.getPageChainContext()) == null) {
            return;
        }
        pageChainContext.d(bundle);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        PageContainerView pageContainerView;
        super.onDestroyView();
        hc.c.c(this);
        g.a aVar = this.f200t;
        if (aVar != null && (pageContainerView = aVar.f65294b) != null) {
            pageContainerView.removeAllViews();
        }
        this.f200t = null;
        Page page = this.f30954a;
        if (page != null) {
            ((EngineRouter) tc.a.a(EngineRouter.class)).unRegisterRender(page.getPageId());
        }
    }

    @Override // zc.f
    public void onPageFinished(WebView webView, String str) {
    }

    @Override // zc.f
    public void onPageStarted(WebView webView, String str) {
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        zc.i render;
        zc.i render2;
        String strB;
        super.onPause();
        Page page = this.f30954a;
        if (page != null && (render2 = page.getRender()) != null && (strB = render2.b()) != null) {
            kb.a.f68517a.f(strB);
        }
        Page page2 = this.f30954a;
        View view = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // zc.h
    public void onProgressChanged(WebView webView, int i11) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        g.a aVar;
        ProgressBar progressBar5;
        g.a aVar2 = this.f200t;
        if (aVar2 != null && (progressBar3 = aVar2.f65297f) != null && Intrinsics.b(progressBar3.getTag(), Boolean.FALSE)) {
            g.a aVar3 = this.f200t;
            if (aVar3 == null || (progressBar4 = aVar3.f65297f) == null || !xb.i.a(progressBar4) || (aVar = this.f200t) == null || (progressBar5 = aVar.f65297f) == null) {
                return;
            }
            xb.i.c(progressBar5);
            return;
        }
        if (i11 == 0) {
            g.a aVar4 = this.f200t;
            if (aVar4 == null || (progressBar2 = aVar4.f65297f) == null) {
                return;
            }
            xb.i.e(progressBar2);
            return;
        }
        if (i11 == 100 && !this.f202v) {
            this.f202v = true;
            g.a aVar5 = this.f200t;
            if (aVar5 != null && (progressBar = aVar5.f65297f) != null) {
                xb.i.c(progressBar);
            }
        }
        g.a aVar6 = this.f200t;
        ProgressBar progressBar6 = aVar6 != null ? aVar6.f65297f : null;
        if (progressBar6 == null) {
            return;
        }
        progressBar6.setProgress(i11);
    }

    @Override // zc.f
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
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
        String strB;
        zc.i render2;
        super.onResume();
        try {
            Page page = this.f30954a;
            if (page == null || (render = page.getRender()) == null || (strB = render.b()) == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("resume:->");
            Page page2 = this.f30954a;
            sb2.append(page2 != null ? page2.getPagePath() : null);
            TmcLogger.c("MiniFragment", sb2.toString());
            App app = this.f30955b;
            if (Intrinsics.b(app != null ? app.getActivePage() : null, this.f30954a)) {
                if (this.E) {
                    this.E = false;
                    j.d(l0.a(w0.a()), null, null, new OooOO0(null), 3, null);
                }
                q1();
                Page page3 = this.f30954a;
                View view = (page3 == null || (render2 = page3.getRender()) == null) ? null : render2.getView();
                WebView webView = view instanceof WebView ? (WebView) view : null;
                if (webView != null) {
                    webView.onResume();
                }
                kb.a.f68517a.g(strB);
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniFragment", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        zc.i render;
        String strB;
        super.onStop();
        TmcLogger.c("MiniFragment", "onStop");
        Page page = this.f30954a;
        if (page != null && (render = page.getRender()) != null && (strB = render.b()) != null) {
            kb.a.f68517a.h(strB);
        }
        C1(true);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ImageView imageView;
        App app;
        App app2;
        App app3;
        App app4;
        Bundle startParams;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        PageChainContext pageChainContext = this.f30956c;
        App app5 = this.f30955b;
        pageChainContext.E(app5 != null ? app5.getAppChainContext() : null);
        Page page = this.f30954a;
        if (page != null) {
            page.setPageChainContext(this.f30956c);
        }
        Bundle bundle2 = new Bundle();
        String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page2 = this.f30954a;
        String pagePath = page2 != null ? page2.getPagePath() : null;
        if (pagePath == null) {
            pagePath = "";
        } else {
            Intrinsics.f(pagePath, "page?.pagePath ?: \"\"");
        }
        bundle2.putString(str, pagePath);
        String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
        Page page3 = this.f30954a;
        String pageId = page3 != null ? page3.getPageId() : null;
        if (pageId == null) {
            pageId = "";
        } else {
            Intrinsics.f(pageId, "page?.pageId ?: \"\"");
        }
        bundle2.putString(str2, pageId);
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        App app6 = this.f30955b;
        performanceAnalyseProxy.record(app6 != null ? app6.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle2);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        App app7 = this.f30955b;
        performanceAnalyseProxy2.record(app7 != null ? app7.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle2);
        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        App app8 = this.f30955b;
        performanceAnalyseProxy3.record(app8 != null ? app8.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle2);
        PerformanceAnalyseProxy performanceAnalyseProxy4 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        App app9 = this.f30955b;
        performanceAnalyseProxy4.record(app9 != null ? app9.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle2);
        new db.c(bundle2).f(this.f30956c);
        new xa.c(bundle2).f(this.f30956c);
        this.f205y = new OooO00o(this, this.f30954a);
        this.f203w = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f30955b);
        if (getActivity() != null) {
            this.f206z = new a(this);
        }
        this.f204x = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f30954a);
        uc.b bVar = this.f203w;
        if (bVar != null) {
            bVar.b("consumeTime", this);
        }
        uc.b bVar2 = this.f203w;
        if (bVar2 != null) {
            bVar2.b("create_miniapp_worker_fail", this.f205y);
        }
        uc.b bVar3 = this.f204x;
        if (bVar3 != null) {
            bVar3.b("onPageReady", this.f206z);
        }
        uc.b bVar4 = this.f204x;
        if (bVar4 != null) {
            bVar4.b("create_miniapp_worker_fail", this.f205y);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
        String str3 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
        Page page4 = this.f30954a;
        bundle3.putString(str3, String.valueOf((page4 == null || (app4 = page4.getApp()) == null || (startParams = app4.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
        String str4 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page5 = this.f30954a;
        bundle3.putString(str4, String.valueOf(page5 != null ? page5.getPagePath() : null));
        PerformanceAnalyseProxy performanceAnalyseProxy5 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page6 = this.f30954a;
        performanceAnalyseProxy5.record((page6 == null || (app3 = page6.getApp()) == null) ? null : app3.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q, bundle3);
        PerformanceAnalyseProxy performanceAnalyseProxy6 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page7 = this.f30954a;
        performanceAnalyseProxy6.record((page7 == null || (app2 = page7.getApp()) == null) ? null : app2.getAppId(), PointAnalyseType.POINT_PAGE_CREATE, "");
        FragmentActivity activity = getActivity();
        OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
        if (oooO0OO != null && !oooO0OO.f31727m) {
            PerformanceAnalyseProxy performanceAnalyseProxy7 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page8 = this.f30954a;
            performanceAnalyseProxy7.record((page8 == null || (app = page8.getApp()) == null) ? null : app.getAppId(), PointAnalyseType.POINT_PAGE_PV, "");
        }
        Page page9 = this.f201u;
        if (page9 != null) {
            Intrinsics.d(page9);
            j0(page9);
            this.f201u = null;
        }
        hc.c.a(this, this);
        g.a aVar = this.f200t;
        if (aVar == null || (imageView = aVar.f65296d) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: e0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o0000.u1(this.f63567a, view2);
            }
        });
    }

    public final void q1() {
        App app;
        TabBarMessageStore tabBarMessageStore;
        Page page;
        MiniAppConfigModel miniAppConfigModel;
        MiniAppConfigModel.TabBarBean tabBarConfig;
        MiniAppConfigModel.TabBarBean tabBarBeanC;
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        String templateMiniappId;
        App app2;
        AppModel appModel;
        AppModel appModel2;
        App app3;
        Page page2 = this.f30954a;
        if (page2 == null || !page2.isShow()) {
            return;
        }
        AppLoadResult appLoadResult = getAppLoadResult();
        if (appLoadResult != null && (miniAppConfigModel = appLoadResult.appConfigModel) != null && miniAppConfigModel.tabBarManual()) {
            Page page3 = this.f30954a;
            Integer miniappSubtype = null;
            TabBarManualConfigStore tabBarManualConfigStore = (page3 == null || (app3 = page3.getApp()) == null) ? null : (TabBarManualConfigStore) app3.getData(TabBarManualConfigStore.class);
            if (tabBarManualConfigStore != null && (tabBarConfig = tabBarManualConfigStore.getTabBarConfig()) != null && (list = (tabBarBeanC = d0.c(tabBarConfig)).list) != null) {
                Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    String str = it.next().pagePath;
                    Page page4 = this.f30954a;
                    if (Intrinsics.b(str, page4 != null ? page4.getPagePath() : null)) {
                        if (i11 == -1) {
                            break;
                        }
                        Page page5 = this.f30954a;
                        if (page5 != null) {
                            page5.setTabPage(true);
                        }
                        AppUtils appUtils = AppUtils.f31011a;
                        App app4 = this.f30955b;
                        if (app4 != null && (appModel2 = app4.getAppModel()) != null) {
                            miniappSubtype = appModel2.getMiniappSubtype();
                        }
                        if (!appUtils.g(miniappSubtype) || (app2 = this.f30955b) == null || (appModel = app2.getAppModel()) == null || (templateMiniappId = appModel.getTemplateMiniappId()) == null) {
                            templateMiniappId = "";
                        }
                        n(tabBarBeanC, templateMiniappId);
                        break;
                    }
                    i11++;
                }
            }
        }
        J1();
        Page page6 = this.f30954a;
        if (page6 == null || !page6.isTabPage()) {
            return;
        }
        try {
            Page page7 = this.f30954a;
            if (page7 != null && (app = page7.getApp()) != null && (tabBarMessageStore = (TabBarMessageStore) app.getData(TabBarMessageStore.class)) != null) {
                Iterator<Map.Entry<Integer, TabBarRedDotMessage>> it2 = tabBarMessageStore.getRedDotMessageHashMap().entrySet().iterator();
                while (it2.hasNext()) {
                    TabBarRedDotMessage value = it2.next().getValue();
                    if (value.getShowRedDot()) {
                        Page page8 = this.f30954a;
                        if (page8 != null) {
                            page8.showTabBarRedDot(value.getIndex());
                        }
                    } else {
                        Page page9 = this.f30954a;
                        if (page9 != null) {
                            page9.hideTabBarRedDot(value.getIndex());
                        }
                    }
                    if (value.getShowUnreadIcon()) {
                        Page page10 = this.f30954a;
                        if (page10 != null) {
                            Intrinsics.f(page10, "page");
                            int index = value.getIndex();
                            String unreadIcon = value.getUnreadIcon();
                            com.cloud.tmc.kernel.node.e.a.a(page10, index, unreadIcon == null ? "" : unreadIcon, null, 4, null);
                        }
                    } else {
                        Page page11 = this.f30954a;
                        if (page11 != null) {
                            page11.hideTabBarUnreadIcon(value.getIndex());
                        }
                    }
                }
                Iterator<Map.Entry<Integer, TabBarBadgeMessage>> it3 = tabBarMessageStore.getBadgeMessageHashMap().entrySet().iterator();
                while (it3.hasNext()) {
                    TabBarBadgeMessage value2 = it3.next().getValue();
                    if (value2.getShowBadge()) {
                        Page page12 = this.f30954a;
                        if (page12 != null) {
                            page12.setTabBarBadge(value2.getIndex(), value2.getText());
                        }
                    } else {
                        Page page13 = this.f30954a;
                        if (page13 != null) {
                            page13.removeTabBarBadge(value2.getIndex());
                        }
                    }
                }
                TabBarStyle tabBarStyle = tabBarMessageStore.getTabBarStyle();
                if (tabBarStyle == null || (page = this.f30954a) == null) {
                    return;
                }
                page.setTabBarStyle(tabBarStyle.getColor(), tabBarStyle.getSelectedColor(), tabBarStyle.getBackgroundColor(), tabBarStyle.getBorderStyle());
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniFragment", th2);
        }
    }

    public final void r1(final int i11) {
        g.a aVar;
        final View view;
        try {
            boolean zF = MiniAppLaunch.f31784a.F();
            TmcLogger.c("MiniFragment", "showWebViewMask enableWebViewMask: " + zF);
            if (zF && (aVar = this.f200t) != null && (view = aVar.f65300i) != null) {
                P0(view);
                com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: e0.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        o0000.s1(i11, view, this);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniFragment", "", th2);
        }
    }

    @Override // vb.c
    public void setCapsuleStyle(boolean z11) {
        CapsuleView capsuleViewU0;
        int i11 = !z11 ? 1 : 0;
        FragmentActivity activity = getActivity();
        OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
        if (oooO0OO == null || (capsuleViewU0 = oooO0OO.u0()) == null) {
            return;
        }
        CapsuleView.OooO00o(capsuleViewU0, i11, null, 2);
    }

    @Override // vb.c
    public void setNavigationBarIconStyle(boolean z11) {
        ImmersiveTitleBarView immersiveTitleBarView;
        int i11 = !z11 ? 1 : 0;
        g.a aVar = this.f200t;
        if (aVar == null || (immersiveTitleBarView = aVar.f65299h) == null) {
            return;
        }
        immersiveTitleBarView.setThemeMode(i11);
    }

    @Override // zc.f
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string;
        zc.i render;
        ac.a renderBridge;
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (string = url.toString()) == null) {
            string = "";
        }
        if (l.L(string, "https://100000", false, 2, null) || !Intrinsics.b(this.H, "ad_click") || !this.I) {
            Boolean boolA = zc.e.a(this, webView, webResourceRequest);
            Intrinsics.f(boolA, "super.shouldOverrideUrlLoading(view, request)");
            return boolA;
        }
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.addProperty("abilityName", "callback");
        Page page = this.f30954a;
        jsonObject.addProperty("renderId", String.valueOf(page != null ? page.getPageId() : null));
        jsonObject.addProperty("target", "native");
        jsonObject.addProperty("source", "render");
        jsonObject.addProperty("callbackId", this.J);
        jsonObject2.addProperty("dataJson", k.j(s.j(TuplesKt.a("adUrl", string))));
        jsonObject2.addProperty("callbackId", this.J);
        jsonObject.add("dataJson", jsonObject2);
        Page page2 = this.f30954a;
        ac.b.a aVarI = ac.b.b(page2 != null ? page2.getRender() : null).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject);
        Page page3 = this.f30954a;
        if (page3 != null && (render = page3.getRender()) != null && (renderBridge = render.getRenderBridge()) != null) {
            renderBridge.a(aVarI.h(), null);
        }
        this.H = "";
        this.I = false;
        this.J = "";
        return Boolean.TRUE;
    }

    @Override // vb.c
    public void showNavigationBarLoading() {
        ProgressBar progressBar;
        g.a aVar = this.f200t;
        ProgressBar progressBar2 = aVar != null ? aVar.f65297f : null;
        if (progressBar2 != null) {
            progressBar2.setTag(Boolean.TRUE);
        }
        g.a aVar2 = this.f200t;
        if (aVar2 == null || (progressBar = aVar2.f65297f) == null) {
            return;
        }
        xb.i.e(progressBar);
    }

    @Override // tb.d
    public ub.a u() {
        g.a aVar = this.f200t;
        if (aVar != null) {
            return aVar.f65294b;
        }
        return null;
    }

    @Override // tb.d
    public ViewGroup v() {
        g.a aVar = this.f200t;
        if (aVar != null) {
            return aVar.f65293a;
        }
        return null;
    }

    @Override // tb.d
    public ub.c x() {
        g.a aVar = this.f200t;
        if (aVar != null) {
            return aVar.f65299h;
        }
        return null;
    }

    public final void y1(final Page page) {
        try {
            this.f30954a = page;
            ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).start(this.f30955b, String.valueOf(page != null ? page.getPagePath() : null));
            if (page != null) {
                FragmentActivity activity = getActivity();
                OooO0OO oooO0OO = activity instanceof OooO0OO ? (OooO0OO) activity : null;
                page.bindContext(this, Boolean.valueOf(oooO0OO != null ? oooO0OO.f31727m : false), new Page.b() { // from class: e0.j
                    @Override // com.cloud.tmc.integration.structure.Page.b
                    public final void success() {
                        o0000.z1(page, this);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniFragment", "setPageOnMain error", th2);
        }
    }
}
