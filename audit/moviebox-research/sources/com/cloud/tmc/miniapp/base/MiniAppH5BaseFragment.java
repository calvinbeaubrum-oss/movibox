package com.cloud.tmc.miniapp.base;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.defaultImpl.InjectJSProxyImp;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.h0;
import com.cloud.tmc.integration.utils.m0;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.base.MiniAppH5BaseFragment;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.IPageChainCallback;
import com.cloud.tmc.render.bean.InjectStrategy;
import com.cloud.tmc.render.proxy.InjectJSProxy;
import com.mbridge.msdk.MBridgeConstans;
import ee.i;
import hd.j;
import java.net.URL;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kd.l;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import l.p;
import xa.d;
import xa.e;
import xa.g;
import xa.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public abstract class MiniAppH5BaseFragment extends MiniAppBaseFragment implements i {
    public boolean B;
    public uc.c F;
    public uc.b G;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f31410x;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f31406t = "h5PointTrack";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f31407u = "h5PointTrackNew";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f31408v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Stack<b> f31409w = new Stack<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicInteger f31411y = new AtomicInteger(0);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f31412z = "0";
    public final Map<String, String> A = new LinkedHashMap();
    public final String C = "h5Redirect";
    public final Stack<String> D = new Stack<>();
    public final List<String> E = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public enum ProgressStep {
        INIT(0),
        STEP_30(30),
        STEP_50(50),
        STEP_70(70),
        STEP_100(100);

        private final int step;

        ProgressStep(int i11) {
            this.step = i11;
        }

        /* synthetic */ ProgressStep(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11);
        }

        public final int getStep() {
            return this.step;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SourceDebugExtension
    public final class a implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final App f31413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Page f31414b;

        public a(App app, Page page) {
            this.f31413a = app;
            this.f31414b = page;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            l lVar;
            Stack<com.cloud.tmc.miniapp.base.a> stackA;
            Map<String, Object> data;
            try {
                TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> 执行回调");
                App app = this.f31413a;
                if (app != null && (lVar = (l) app.getData(l.class)) != null && (stackA = lVar.a()) != null) {
                    if (stackA.size() == 0) {
                        TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> showPages.size == 0 return");
                        return true;
                    }
                    com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                    if (aVarPeek == null) {
                        return true;
                    }
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> originalUrl:" + aVarPeek.b());
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> url        :" + aVarPeek.i());
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> requestUrl :" + aVarPeek.g());
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> showPages:" + aVarPeek);
                    if (aVarPeek.h().getType() != ShowPageStatus.PAGE_START.getType()) {
                        TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> showPage.status != ShowPageStatus.PAGE_START return");
                        return true;
                    }
                    Object obj = (aVar == null || (data = aVar.getData()) == null) ? null : data.get("params");
                    String str = obj instanceof String ? (String) obj : null;
                    if (str == null) {
                        str = "";
                    }
                    Object objD = k.d(str, IPageChainCallback.OnPageFinishedData.class);
                    Intrinsics.f(objD, "fromJson(params, IPageCh…FinishedData::class.java)");
                    IPageChainCallback.OnPageFinishedData onPageFinishedData = (IPageChainCallback.OnPageFinishedData) objD;
                    String url = onPageFinishedData.getUrl();
                    long fcpCurrentTimeMillis = onPageFinishedData.getFcpCurrentTimeMillis();
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> FCPUrl:" + url);
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> FCPTime:" + fcpCurrentTimeMillis);
                    if (!Intrinsics.b(aVarPeek.i(), url)) {
                        TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> url != FCPUrl return");
                        return true;
                    }
                    boolean z11 = false;
                    if (MiniAppH5BaseFragment.this.E1()) {
                        MiniAppH5BaseFragment.this.J2(false);
                        z11 = true;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, aVarPeek.g());
                    bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, aVarPeek.j());
                    bundle.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31226n0, fcpCurrentTimeMillis);
                    bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
                    bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U, "2");
                    bundle.putBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31214h0, z11);
                    Page page = this.f31414b;
                    bundle.putString("pageRandomId", String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
                    bundle.putString("pageUniqueId", q.d() + '_' + aVarPeek.j());
                    App app2 = this.f31413a;
                    if (app2 != null) {
                        app2.setMiniAppLoadStatus(true);
                    }
                    aVarPeek.p(ShowPageStatus.PAGE_PROGRESS100);
                    FragmentActivity activity = MiniAppH5BaseFragment.this.getActivity();
                    if (activity != null) {
                        h0 h0Var = h0.f31062a;
                        App app3 = this.f31413a;
                        h0Var.b(activity, app3 != null ? app3.getAppId() : null);
                    }
                    new g(bundle).f(MiniAppH5BaseFragment.this.C1(aVarPeek.j()));
                    TmcLogger.c(MiniAppH5BaseFragment.this.f31407u, "juggist[FCP] -> 静态资源渲染成功");
                }
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f31416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f31417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f31418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f31419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f31420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f31421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f31422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ConcurrentHashMap<Integer, Long> f31423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ProgressStep f31424i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f31425j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f31426k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f31427l;

        public b() {
            this(null, false, false, false, false, false, null, null, null, 0L, false, 2047, null);
        }

        public b(String url, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String virtual_h5PageId, ConcurrentHashMap<Integer, Long> progressCollectList, ProgressStep progressStep, long j11, boolean z16) {
            Intrinsics.g(url, "url");
            Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
            Intrinsics.g(progressCollectList, "progressCollectList");
            this.f31416a = url;
            this.f31417b = z11;
            this.f31418c = z12;
            this.f31419d = z13;
            this.f31420e = z14;
            this.f31421f = z15;
            this.f31422g = virtual_h5PageId;
            this.f31423h = progressCollectList;
            this.f31424i = progressStep;
            this.f31425j = j11;
            this.f31426k = z16;
            this.f31427l = "";
        }

        public /* synthetic */ b(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str2, ConcurrentHashMap concurrentHashMap, ProgressStep progressStep, long j11, boolean z16, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12, (i11 & 8) != 0 ? false : z13, (i11 & 16) != 0 ? false : z14, (i11 & 32) != 0 ? false : z15, (i11 & 64) != 0 ? "0" : str2, (i11 & 128) != 0 ? new ConcurrentHashMap() : concurrentHashMap, (i11 & 256) != 0 ? null : progressStep, (i11 & 512) != 0 ? System.currentTimeMillis() : j11, (i11 & 1024) == 0 ? z16 : false);
        }

        public final boolean a() {
            return this.f31421f;
        }

        public final String b() {
            return this.f31427l;
        }

        public final ConcurrentHashMap<Integer, Long> c() {
            return this.f31423h;
        }

        public final ProgressStep d() {
            return this.f31424i;
        }

        public final long e() {
            return this.f31425j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f31416a, bVar.f31416a) && this.f31417b == bVar.f31417b && this.f31418c == bVar.f31418c && this.f31419d == bVar.f31419d && this.f31420e == bVar.f31420e && this.f31421f == bVar.f31421f && Intrinsics.b(this.f31422g, bVar.f31422g) && Intrinsics.b(this.f31423h, bVar.f31423h) && this.f31424i == bVar.f31424i && this.f31425j == bVar.f31425j && this.f31426k == bVar.f31426k;
        }

        public final String f() {
            return this.f31416a;
        }

        public final String g() {
            return this.f31422g;
        }

        public final boolean h() {
            return this.f31426k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iHashCode = this.f31416a.hashCode() * 31;
            boolean z11 = this.f31417b;
            ?? r11 = z11;
            if (z11) {
                r11 = 1;
            }
            int i11 = (iHashCode + r11) * 31;
            boolean z12 = this.f31418c;
            ?? r12 = z12;
            if (z12) {
                r12 = 1;
            }
            int i12 = (i11 + r12) * 31;
            boolean z13 = this.f31419d;
            ?? r13 = z13;
            if (z13) {
                r13 = 1;
            }
            int i13 = (i12 + r13) * 31;
            boolean z14 = this.f31420e;
            ?? r14 = z14;
            if (z14) {
                r14 = 1;
            }
            int i14 = (i13 + r14) * 31;
            boolean z15 = this.f31421f;
            ?? r15 = z15;
            if (z15) {
                r15 = 1;
            }
            int iHashCode2 = (this.f31423h.hashCode() + ((this.f31422g.hashCode() + ((i14 + r15) * 31)) * 31)) * 31;
            ProgressStep progressStep = this.f31424i;
            int iA = (p.a(this.f31425j) + ((iHashCode2 + (progressStep == null ? 0 : progressStep.hashCode())) * 31)) * 31;
            boolean z16 = this.f31426k;
            return iA + (z16 ? 1 : z16);
        }

        public final boolean i() {
            return this.f31420e;
        }

        public final boolean j() {
            return this.f31418c;
        }

        public final boolean k() {
            return this.f31417b;
        }

        public final void l(boolean z11) {
            this.f31421f = z11;
        }

        public final void m(boolean z11) {
            this.f31426k = z11;
        }

        public final void n(boolean z11) {
            this.f31420e = z11;
        }

        public final void o(String value) {
            Intrinsics.g(value, "value");
            this.f31427l = value;
        }

        public final void p(boolean z11) {
            this.f31417b = z11;
        }

        public final void q(ProgressStep progressStep) {
            this.f31424i = progressStep;
        }

        public final void r(long j11) {
            this.f31425j = j11;
        }

        public String toString() {
            return "PageStatus(url=" + this.f31416a + ", isProgressChangedTo100=" + this.f31417b + ", isPageFinished=" + this.f31418c + ", isHomePage=" + this.f31419d + ", isLoadError=" + this.f31420e + ", canGoBack=" + this.f31421f + ", virtual_h5PageId=" + this.f31422g + ", progressCollectList=" + this.f31423h + ", progressCurrentStep=" + this.f31424i + ", progressStartTime=" + this.f31425j + ", isDomContentLoaded=" + this.f31426k + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31428a;

        static {
            int[] iArr = new int[ProgressStep.values().length];
            try {
                iArr[ProgressStep.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProgressStep.STEP_30.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProgressStep.STEP_50.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProgressStep.STEP_70.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProgressStep.STEP_100.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f31428a = iArr;
        }
    }

    public static /* synthetic */ void I1(MiniAppH5BaseFragment miniAppH5BaseFragment, TmcFragment.ExitType exitType, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goBackNew");
        }
        if ((i11 & 1) != 0) {
            exitType = TmcFragment.ExitType.BACK;
        }
        miniAppH5BaseFragment.H1(exitType);
    }

    public static final void L1(String injectJSStrategy, String scriptWrapper, String str) {
        Intrinsics.g(injectJSStrategy, "$injectJSStrategy");
        Intrinsics.g(scriptWrapper, "$scriptWrapper");
        TmcLogger.c(InjectJSProxyImp.TAG, injectJSStrategy + " inject success script:\n" + scriptWrapper + '\n');
    }

    public static /* synthetic */ void g2(MiniAppH5BaseFragment miniAppH5BaseFragment, String str, String str2, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pointTrackDrawViewEndForApp");
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        miniAppH5BaseFragment.f2(str, str2, z11);
    }

    public final String A1(WebView webView) {
        String url;
        if (webView != null && (url = webView.getUrl()) != null && kotlin.text.l.L(url, "about:blank", false, 2, null)) {
            return this.f31408v;
        }
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    public final void A2(WebView webView, int i11) {
        l lVar;
        if (webView == null) {
            return;
        }
        try {
            TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> webView.originalUrl:" + webView.getOriginalUrl());
            TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> webView.url:" + webView.getUrl());
            TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> webView.progress:" + i11);
            App app = this.f30955b;
            if (app != null && (lVar = (l) app.getData(l.class)) != null) {
                Stack<com.cloud.tmc.miniapp.base.a> stackA = lVar.a();
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                if (aVarPeek == null) {
                    return;
                }
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> originalUrl:" + aVarPeek.b());
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> url        :" + aVarPeek.i());
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> requestUrl :" + aVarPeek.g());
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> showPage:" + aVarPeek);
                if (aVarPeek.h() == ShowPageStatus.PAGE_START) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChangedNew] -> 修改showPage的originalUrl和url");
                    aVarPeek.l(String.valueOf(webView.getOriginalUrl()));
                    aVarPeek.q(String.valueOf(webView.getUrl()));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final AtomicInteger B1() {
        return this.f31411y;
    }

    public final void B2(WebView webView, WebResourceRequest webResourceRequest) {
        boolean zIsRedirect = (Build.VERSION.SDK_INT < 24 || webResourceRequest == null) ? false : webResourceRequest.isRedirect();
        kd.k.a(j.a("juggist[pointTrackShouldOverrideUrlLoadingNew] -> originalUrl:"), webView != null ? webView.getOriginalUrl() : null, this.f31407u);
        kd.k.a(j.a("juggist[pointTrackShouldOverrideUrlLoadingNew] -> url        :"), webView != null ? webView.getUrl() : null, this.f31407u);
        String str = this.f31407u;
        StringBuilder sbA = j.a("juggist[pointTrackShouldOverrideUrlLoadingNew] -> requestUrl :");
        sbA.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        sbA.append(", isRedirect:");
        sbA.append(zIsRedirect);
        TmcLogger.c(str, sbA.toString());
        String strZ1 = z1(webView);
        if (strZ1 == null) {
            strZ1 = "";
        }
        String strA1 = A1(webView);
        C2(strZ1, strA1 != null ? strA1 : "", String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null), zIsRedirect);
    }

    public final PageChainContext C1(String str) {
        l lVar;
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        App app = this.f30955b;
        if (app == null || (lVar = (l) app.getData(l.class)) == null || (stackA = lVar.a()) == null) {
            return null;
        }
        for (com.cloud.tmc.miniapp.base.a aVar : stackA) {
            if (Intrinsics.b(aVar.j(), str)) {
                return aVar.c();
            }
        }
        return null;
    }

    public final void C2(String originalUrl, String url, String requestUrl, boolean z11) {
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        Intrinsics.g(originalUrl, "originalUrl");
        Intrinsics.g(url, "url");
        Intrinsics.g(requestUrl, "requestUrl");
        try {
            App app = this.f30955b;
            l lVar = app != null ? (l) app.getData(l.class) : null;
            if (lVar == null) {
                App app2 = this.f30955b;
                if (app2 != null) {
                    app2.setData(l.class, new l());
                }
                App app3 = this.f30955b;
                lVar = app3 != null ? (l) app3.getData(l.class) : null;
            }
            if (lVar != null && (stackA = lVar.a()) != null) {
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                Intrinsics.f(aVarPeek, "showPages.peek()");
                com.cloud.tmc.miniapp.base.a aVar = aVarPeek;
                TmcLogger.c(this.f31407u, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> showPages:" + aVar);
                if (Intrinsics.b(aVar.g(), requestUrl)) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> currentPage.requestUrl == requestUrl return");
                    return;
                }
                int type = aVar.h().getType();
                ShowPageStatus showPageStatus = ShowPageStatus.SHOULDOVERRIDEURKLOADING;
                if (type == showPageStatus.getType()) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> currentPage.status == ShowPageStatus.SHOULDOVERRIDEURKLOADING pointTrackClearNew");
                    com.cloud.tmc.miniapp.base.a aVarPop = stackA.pop();
                    if (aVarPop != null) {
                        i0(TmcFragment.ExitType.NEW_PAGE_ENTER);
                        T1(aVarPop.g(), aVarPop.j(), aVarPop);
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                Page page = this.f30954a;
                sb2.append(page != null ? page.getPageId() : null);
                sb2.append('_');
                sb2.append(this.f31411y.addAndGet(1));
                String string = sb2.toString();
                TmcLogger.c(this.f31407u, "Add New Page -> requestUrl:" + requestUrl);
                PageChainContext pageChainContext = new PageChainContext();
                App app4 = this.f30955b;
                pageChainContext.E(app4 != null ? app4.getAppChainContext() : null);
                Unit unit = Unit.f68710a;
                stackA.add(new com.cloud.tmc.miniapp.base.a(originalUrl, url, requestUrl, string, showPageStatus, false, "", pageChainContext, false, null, null, 0L, 3840, null));
                s1(requestUrl, string, false);
            }
        } catch (Throwable unused) {
        }
    }

    public final String D1(String str) {
        String key;
        if (str == null) {
            return "";
        }
        for (Map.Entry<String, String> entry : this.A.entrySet()) {
            if (Intrinsics.b(entry.getValue(), str)) {
                key = entry.getKey();
                TmcLogger.c("oldChain", "getReportOriginalUrl -> realUrl:" + str + ", originalUrl:" + key);
                return key;
            }
        }
        key = str;
        TmcLogger.c("oldChain", "getReportOriginalUrl -> realUrl:" + str + ", originalUrl:" + key);
        return key;
    }

    public final void D2(WebView webView, String str) {
        l lVar;
        try {
            String str2 = this.f31407u;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("juggist[pointTrackPageStepStart] -> originalUrl:");
            sb2.append(webView != null ? webView.getOriginalUrl() : null);
            TmcLogger.c(str2, sb2.toString());
            String str3 = this.f31407u;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("juggist[pointTrackPageStepStart] -> url        :");
            sb3.append(webView != null ? webView.getUrl() : null);
            TmcLogger.c(str3, sb3.toString());
            TmcLogger.c(this.f31407u, "juggist[pointTrackPageStepStart] -> requestUrl :" + str);
            App app = this.f30955b;
            if (app != null && (lVar = (l) app.getData(l.class)) != null) {
                Stack<com.cloud.tmc.miniapp.base.a> stackA = lVar.a();
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackPageStepStart] -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                if (aVarPeek == null) {
                    return;
                }
                TmcLogger.c(this.f31407u, "juggist[pointTrackPageStepStart] -> showPages:" + aVarPeek);
                if (!Intrinsics.b(aVarPeek.g(), str)) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackPageStepStart] -> showPage.requestUrl != url return");
                    return;
                }
                if (aVarPeek.h().getType() == ShowPageStatus.SHOULDOVERRIDEURKLOADING.getType() || aVarPeek.h().getType() == ShowPageStatus.PAGE_START.getType()) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackPageStepStart] -> change showPage.status = ShowPageStatus.PAGE_START");
                    aVarPeek.p(ShowPageStatus.PAGE_START);
                    String strZ1 = z1(webView);
                    String str4 = "";
                    if (strZ1 == null) {
                        strZ1 = "";
                    }
                    aVarPeek.l(strZ1);
                    String strA1 = A1(webView);
                    if (strA1 != null) {
                        str4 = strA1;
                    }
                    aVarPeek.q(str4);
                    aVarPeek.o(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean E1() {
        return this.B;
    }

    public final void E2(String webviewUrl, String webResourceRequestUrl) {
        Intrinsics.g(webviewUrl, "webviewUrl");
        Intrinsics.g(webResourceRequestUrl, "webResourceRequestUrl");
        try {
            TmcLogger.c(this.f31406t, "redirect => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
            URL url = new URL(webviewUrl);
            URL url2 = new URL(webResourceRequestUrl);
            String str = url.getHost() + url.getPath();
            String str2 = url2.getHost() + url2.getPath();
            TmcLogger.c(this.f31406t, "webviewURLCombine:" + str);
            TmcLogger.c(this.f31406t, "webResourceRequestURLCombine:" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (Intrinsics.b(str, str2)) {
                    TmcLogger.c(this.f31406t, "redirect  进入backForward栈 => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
                    this.f31409w.peek().l(true);
                    return;
                }
                TmcLogger.c(this.f31406t, "redirect  开始加载 => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
                StringBuilder sb2 = new StringBuilder();
                Page page = this.f30954a;
                sb2.append(page != null ? page.getPageId() : null);
                sb2.append('_');
                sb2.append(this.f31411y.addAndGet(1));
                I2(webResourceRequestUrl, false, sb2.toString());
                Page page2 = this.f30954a;
                String strCreatePageRandomIdByGAID = page2 != null ? page2.createPageRandomIdByGAID() : null;
                if (strCreatePageRandomIdByGAID == null) {
                    strCreatePageRandomIdByGAID = "null";
                }
                m0.a(this.f30954a, "shouldOverrideUrl", this.f31408v, strCreatePageRandomIdByGAID);
                O1(strCreatePageRandomIdByGAID);
                y2();
                Y1();
                W1();
                n2();
                l2();
                c2();
                a2();
                r2();
                p2();
                j2();
            }
        } catch (Throwable unused) {
        }
    }

    public final Map<String, String> F1() {
        return this.A;
    }

    public final boolean F2(WebView webView) {
        String str = this.C;
        StringBuilder sbA = j.a("redirectCanGoBack => originalUrl:");
        sbA.append(z1(webView));
        sbA.append(" , url:");
        sbA.append(A1(webView));
        TmcLogger.c(str, sbA.toString());
        if (webView != null) {
            try {
                if (webView.canGoBack()) {
                    String strPop = this.D.pop();
                    if (strPop == null) {
                        return false;
                    }
                    TmcLogger.c(this.C, "exitPage:" + strPop);
                    WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
                    Intrinsics.f(webBackForwardListCopyBackForwardList, "webView.copyBackForwardList()");
                    TmcLogger.c(this.C, "WebBackForwardList.size:" + webBackForwardListCopyBackForwardList.getSize());
                    int i11 = -1;
                    int i12 = -1;
                    for (int size = webBackForwardListCopyBackForwardList.getSize() - 1; -1 < size; size--) {
                        TmcLogger.c(this.C, "WebBackForwardList(" + size + ") => originalUrl:" + webBackForwardListCopyBackForwardList.getItemAtIndex(size).getOriginalUrl() + " , url:" + webBackForwardListCopyBackForwardList.getItemAtIndex(size).getUrl());
                        if (Intrinsics.b(webBackForwardListCopyBackForwardList.getItemAtIndex(size).getUrl(), strPop)) {
                            if (i12 == -1) {
                                i12 = size;
                            }
                            i11 = size;
                        }
                    }
                    String strY1 = y1();
                    if (strY1 == null) {
                        return false;
                    }
                    TmcLogger.c(this.C, "prePage:" + strY1);
                    WebHistoryItem webHistoryItem = null;
                    int i13 = 1;
                    for (int i14 = i11 + (-1); -1 < i14; i14--) {
                        WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(i14);
                        if (Intrinsics.b(strY1, itemAtIndex.getUrl())) {
                            i13 = i14;
                            webHistoryItem = itemAtIndex;
                        }
                    }
                    if (webHistoryItem != null) {
                        int i15 = i13 - i11;
                        webView.goBackOrForward(i15);
                        I1(this, null, 1, null);
                        G1();
                        TmcLogger.c(this.C, "goBackOrForward(" + i15 + ')');
                        return true;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.f(this.C, "redirectCanGoBack fail:" + th2);
            }
        }
        TmcLogger.c(this.C, "redirectCanGoBack -> 直接退出");
        return false;
    }

    public final void G1() {
        try {
            if (this.f31409w.size() > 1) {
                b bVarPop = this.f31409w.pop();
                R1(bVarPop.f(), bVarPop.b());
                b bVarPeek = this.f31409w.peek();
                TmcLogger.c(this.f31406t, "goBack => exitPage: " + bVarPop + ", showPage: " + bVarPeek);
                I2(bVarPeek.f(), false, bVarPeek.g());
                if (!bVarPop.a()) {
                    TmcLogger.c(this.f31406t, "goBack 页面未入栈，继续退出 => exitPage: " + bVarPop + ", showPage: " + bVarPeek);
                    G1();
                }
            } else {
                TmcLogger.f(this.f31406t, "goBack fail: backForwardStack.size <= 1");
            }
        } catch (Throwable th2) {
            TmcLogger.e("goback fail: " + th2);
        }
    }

    public final void G2(WebView webView, String str) {
        TmcLogger.c(this.C, "redirectPageStarted ==================>");
        try {
            TmcLogger.c(this.C, "webView.original:" + z1(webView));
            TmcLogger.c(this.C, "webView.url:" + A1(webView));
            TmcLogger.c(this.C, "url:" + str);
            String strA1 = A1(webView);
            if (strA1 != null) {
                this.D.add(strA1);
            }
        } catch (Throwable unused) {
        }
        TmcLogger.c(this.C, "redirectPageStarted <==================");
    }

    public final void H1(TmcFragment.ExitType exitType) {
        l lVar;
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        Intrinsics.g(exitType, "exitType");
        try {
            App app = this.f30955b;
            if (app != null && (lVar = (l) app.getData(l.class)) != null && (stackA = lVar.a()) != null) {
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "goBackNew currentPage -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPop = stackA.pop();
                if (aVarPop == null) {
                    return;
                }
                TmcLogger.c(this.f31407u, "goBackNew currentPage -> " + aVarPop);
                i0(exitType);
                T1(aVarPop.g(), aVarPop.j(), aVarPop);
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "goBackNew prePage= -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                if (aVarPeek == null) {
                    return;
                }
                TmcLogger.c(this.f31407u, "goBackNew prePage -> " + aVarPeek);
                if (aVarPeek.h().getType() == ShowPageStatus.SHOULDOVERRIDEURKLOADING.getType() || aVarPeek.h().getType() == ShowPageStatus.PAGE_START.getType()) {
                    TmcLogger.c(this.f31407u, "goBackNew -> prePage.status == ShowPageStatus.SHOULDOVERRIDEURKLOADING || prePage.status == ShowPageStatus.PAGE_START 主动清除页面栈内的页面");
                    H1(TmcFragment.ExitType.BACK_CLEAR_PRE_PAGE);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("goback fail: " + th2);
        }
    }

    public final void H2(WebView webView, WebResourceRequest webResourceRequest) {
        String strA1;
        TmcLogger.c(this.C, "redirectShouldOverrideUrlLoading ==================>");
        try {
            if (Build.VERSION.SDK_INT >= 24 && webResourceRequest != null && webResourceRequest.isRedirect() && (strA1 = A1(webView)) != null) {
                this.E.add(strA1);
                TmcLogger.c(this.C, "webview.original:" + z1(webView));
                TmcLogger.c(this.C, "webview.url:" + strA1);
                String str = this.C;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("request.url:");
                sb2.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
                TmcLogger.c(str, sb2.toString());
            }
        } catch (Throwable unused) {
        }
        TmcLogger.c(this.C, "redirectShouldOverrideUrlLoading <==================");
    }

    public final void I2(String loadingUrl, boolean z11, String virtualH5PageId) {
        Intrinsics.g(loadingUrl, "loadingUrl");
        Intrinsics.g(virtualH5PageId, "virtualH5PageId");
        String str = this.f31406t;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setLoadingUrl => loadingUrl: ");
        sb2.append(loadingUrl);
        sb2.append(" , isFirstLoadHomePage: ");
        sb2.append(z11);
        sb2.append(", virtual_h5PageId:");
        kd.k.a(sb2, this.f31412z, str);
        this.f31408v = loadingUrl;
        this.f31410x = z11;
        this.f31412z = virtualH5PageId;
    }

    public final void J1(int i11) {
        zc.i render;
        try {
            if (v1(i11)) {
                Page page = this.f30954a;
                View view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
                WebView webView = view instanceof WebView ? (WebView) view : null;
                if (webView != null) {
                    webView.loadUrl("javascript:document.addEventListener('DOMContentLoaded', function() {window.dltMonitor.reportDomLoadTime(" + i11 + ',' + hashCode() + ");});");
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g(this.f31406t, "domLoadMonitorInit error", th2);
        }
    }

    public final void J2(boolean z11) {
        this.B = z11;
    }

    public final void K1(WebView webView, final String injectJSStrategy) {
        String script;
        Intrinsics.g(injectJSStrategy, "injectJSStrategy");
        InjectJSProxy injectJSProxy = (InjectJSProxy) tc.a.a(InjectJSProxy.class);
        App app = this.f30955b;
        String appId = app != null ? app.getAppId() : null;
        if (appId == null) {
            appId = "";
        }
        InjectStrategy injectStrategy = injectJSProxy.getInjectStrategy(appId).get(injectJSStrategy);
        if (injectStrategy == null || (script = injectStrategy.getScript()) == null) {
            return;
        }
        final String str = ";(function (window, document) {\n    function inject() {\n        " + script + "    }\n    if (document && document.head) {\n        console.log('立即Inject');\n        inject();\n    }\n    else{\n        const observerOptions = {\n            childList: true,\n            subtree: true,\n        };\n        const observer = new MutationObserver(observerFunc);\n        observer.observe(document.getRootNode(), observerOptions);\n        let isInjected = false;\n        function observerFunc() {\n            if ((!isInjected) && document && document.head) {\n                console.log('监听callback后Inject');\n                inject();\n                isInjected = true;\n                observer.disconnect();\n            }\n        }\n    }\n\n})(window, document);\n" + StringsKt__StringsKt.Z0("\n").toString();
        if (webView != null) {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: kd.j
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    MiniAppH5BaseFragment.L1(injectJSStrategy, str, (String) obj);
                }
            });
        }
    }

    public final void K2() {
        App app;
        App app2;
        Bundle startParams;
        App app3;
        App app4;
        Bundle startParams2;
        try {
            TmcLogger.c(this.f31406t, "updateDomContentLoaded");
            if (this.f31409w.size() <= 0) {
                TmcLogger.f(this.f31406t, "updateDomContentLoaded fail: backForwardStack.size = 0");
                return;
            }
            b bVarPeek = this.f31409w.peek();
            TmcLogger.c(this.f31406t, "updateDomContentLoaded => loadingUrl: " + this.f31408v + ", isProgressChangedTo100:" + bVarPeek.k() + ", isPageFinished: " + bVarPeek.j());
            if (!Intrinsics.b(this.f31408v, bVarPeek.f())) {
                TmcLogger.f(this.f31406t, "updateDomContentLoaded fail: url不匹配, loadingUrl:" + this.f31408v + " , pageStatus.url:" + bVarPeek.f());
                return;
            }
            if (bVarPeek.i()) {
                TmcLogger.f(this.f31406t, "updateDomContentLoaded fail: 加载页面失败, loadingUrl: " + this.f31408v);
                return;
            }
            if (bVarPeek.h()) {
                return;
            }
            bVarPeek.m(true);
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page = this.f30954a;
            String appId = null;
            bundle.putString(str, (page == null || (app4 = page.getApp()) == null || (startParams2 = app4.getStartParams()) == null) ? null : startParams2.getString("uniqueChainID", "-1"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31222l0, String.valueOf(bVarPeek.h()));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page2 = this.f30954a;
            String appId2 = (page2 == null || (app3 = page2.getApp()) == null) ? null : app3.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_INSERT;
            performanceAnalyseProxy.record(appId2, pointAnalyseType, "", bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page3 = this.f30954a;
            bundle2.putString(str2, (page3 == null || (app2 = page3.getApp()) == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"));
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31224m0, String.valueOf(bVarPeek.h()));
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(bVarPeek.f()));
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page4 = this.f30954a;
            if (page4 != null && (app = page4.getApp()) != null) {
                appId = app.getAppId();
            }
            performanceAnalyseProxy2.record(appId, pointAnalyseType, "", bundle2);
            TmcLogger.c(this.f31406t, "updateDomContentLoaded report");
        } catch (EmptyStackException e11) {
            TmcLogger.f(this.f31406t, "updateDomContentLoaded fail: " + e11);
        }
    }

    public final void L2(ProgressStep step) {
        App app;
        App app2;
        Bundle startParams;
        App app3;
        App app4;
        Bundle startParams2;
        Intrinsics.g(step, "step");
        try {
            if (this.f31409w.size() <= 0) {
                TmcLogger.f(this.f31406t, "updateProgressStep fail: backForwardStack.size = 0");
                return;
            }
            b bVarPeek = this.f31409w.peek();
            TmcLogger.c(this.f31406t, "updateProgressStep => loadingUrl: " + this.f31408v + ", isProgressChangedTo100:" + bVarPeek.k() + ", isPageFinished: " + bVarPeek.j());
            if (!Intrinsics.b(this.f31408v, bVarPeek.f())) {
                TmcLogger.f(this.f31406t, "updateProgressStep fail: url不匹配, loadingUrl:" + this.f31408v + " , pageStatus.url:" + bVarPeek.f());
                return;
            }
            if (bVarPeek.i()) {
                TmcLogger.f(this.f31406t, "updateProgressStep fail: 加载页面失败, loadingUrl: " + this.f31408v);
                return;
            }
            if (bVarPeek.d() == null) {
                bVarPeek.r(System.currentTimeMillis());
            }
            bVarPeek.q(step);
            int i11 = c.f31428a[step.ordinal()];
            if (i11 == 2) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapC = bVarPeek.c();
                ProgressStep progressStep = ProgressStep.STEP_30;
                if (!concurrentHashMapC.containsKey(Integer.valueOf(progressStep.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
            } else if (i11 == 3) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapC2 = bVarPeek.c();
                ProgressStep progressStep2 = ProgressStep.STEP_30;
                if (!concurrentHashMapC2.containsKey(Integer.valueOf(progressStep2.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep2.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapC3 = bVarPeek.c();
                ProgressStep progressStep3 = ProgressStep.STEP_50;
                if (!concurrentHashMapC3.containsKey(Integer.valueOf(progressStep3.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep3.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
            } else if (i11 == 4) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapC4 = bVarPeek.c();
                ProgressStep progressStep4 = ProgressStep.STEP_30;
                if (!concurrentHashMapC4.containsKey(Integer.valueOf(progressStep4.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep4.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapC5 = bVarPeek.c();
                ProgressStep progressStep5 = ProgressStep.STEP_50;
                if (!concurrentHashMapC5.containsKey(Integer.valueOf(progressStep5.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep5.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapC6 = bVarPeek.c();
                ProgressStep progressStep6 = ProgressStep.STEP_70;
                if (!concurrentHashMapC6.containsKey(Integer.valueOf(progressStep6.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep6.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
            } else if (i11 == 5) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapC7 = bVarPeek.c();
                ProgressStep progressStep7 = ProgressStep.STEP_30;
                if (!concurrentHashMapC7.containsKey(Integer.valueOf(progressStep7.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep7.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapC8 = bVarPeek.c();
                ProgressStep progressStep8 = ProgressStep.STEP_50;
                if (!concurrentHashMapC8.containsKey(Integer.valueOf(progressStep8.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep8.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapC9 = bVarPeek.c();
                ProgressStep progressStep9 = ProgressStep.STEP_70;
                if (!concurrentHashMapC9.containsKey(Integer.valueOf(progressStep9.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep9.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapC10 = bVarPeek.c();
                ProgressStep progressStep10 = ProgressStep.STEP_100;
                if (!concurrentHashMapC10.containsKey(Integer.valueOf(progressStep10.getStep()))) {
                    bVarPeek.c().put(Integer.valueOf(progressStep10.getStep()), Long.valueOf(System.currentTimeMillis() - bVarPeek.e()));
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page = this.f30954a;
            String appId = null;
            bundle.putString(str, (page == null || (app4 = page.getApp()) == null || (startParams2 = app4.getStartParams()) == null) ? null : startParams2.getString("uniqueChainID", "-1"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31216i0, k.j(bVarPeek.c()));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page2 = this.f30954a;
            String appId2 = (page2 == null || (app3 = page2.getApp()) == null) ? null : app3.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_INSERT;
            performanceAnalyseProxy.record(appId2, pointAnalyseType, "", bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page3 = this.f30954a;
            bundle2.putString(str2, (page3 == null || (app2 = page3.getApp()) == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"));
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31220k0, k.j(bVarPeek.c()));
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(bVarPeek.f()));
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Page page4 = this.f30954a;
            if (page4 != null && (app = page4.getApp()) != null) {
                appId = app.getAppId();
            }
            performanceAnalyseProxy2.record(appId, pointAnalyseType, "", bundle2);
            TmcLogger.c(this.f31406t, "updateProgressStep: progressCurrentStep=" + bVarPeek.d() + ", progressCollectList=" + bVarPeek.c());
        } catch (EmptyStackException e11) {
            TmcLogger.f(this.f31406t, "updateProgressStep fail: " + e11);
        }
    }

    public final void M1() {
        l lVar;
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        try {
            TmcLogger.c(this.f31406t, "loadingUrlError => loadingUrl: " + this.f31408v);
            this.f31409w.peek().n(true);
            App app = this.f30955b;
            com.cloud.tmc.miniapp.base.a aVarPeek = (app == null || (lVar = (l) app.getData(l.class)) == null || (stackA = lVar.a()) == null) ? null : stackA.peek();
            if (aVarPeek == null) {
                return;
            }
            aVarPeek.k(true);
        } catch (Throwable unused) {
        }
    }

    public final void M2(ProgressStep step) {
        l lVar;
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        Intrinsics.g(step, "step");
        try {
            App app = this.f30955b;
            com.cloud.tmc.miniapp.base.a aVarPeek = (app == null || (lVar = (l) app.getData(l.class)) == null || (stackA = lVar.a()) == null) ? null : stackA.peek();
            if (aVarPeek == null) {
                return;
            }
            TmcLogger.c(this.f31406t, "updateProgressStep => status:" + aVarPeek.h());
            if (aVarPeek.a()) {
                TmcLogger.f(this.f31406t, "updateProgressStep fail: 加载页面失败, loadingUrl: " + aVarPeek.g());
                return;
            }
            if (aVarPeek.e() == null) {
                aVarPeek.n(System.currentTimeMillis());
            }
            aVarPeek.m(step);
            int i11 = c.f31428a[step.ordinal()];
            if (i11 == 2) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapD = aVarPeek.d();
                ProgressStep progressStep = ProgressStep.STEP_30;
                if (!concurrentHashMapD.containsKey(Integer.valueOf(progressStep.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
            } else if (i11 == 3) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapD2 = aVarPeek.d();
                ProgressStep progressStep2 = ProgressStep.STEP_30;
                if (!concurrentHashMapD2.containsKey(Integer.valueOf(progressStep2.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep2.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapD3 = aVarPeek.d();
                ProgressStep progressStep3 = ProgressStep.STEP_50;
                if (!concurrentHashMapD3.containsKey(Integer.valueOf(progressStep3.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep3.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
            } else if (i11 == 4) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapD4 = aVarPeek.d();
                ProgressStep progressStep4 = ProgressStep.STEP_30;
                if (!concurrentHashMapD4.containsKey(Integer.valueOf(progressStep4.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep4.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapD5 = aVarPeek.d();
                ProgressStep progressStep5 = ProgressStep.STEP_50;
                if (!concurrentHashMapD5.containsKey(Integer.valueOf(progressStep5.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep5.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapD6 = aVarPeek.d();
                ProgressStep progressStep6 = ProgressStep.STEP_70;
                if (!concurrentHashMapD6.containsKey(Integer.valueOf(progressStep6.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep6.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
            } else if (i11 == 5) {
                ConcurrentHashMap<Integer, Long> concurrentHashMapD7 = aVarPeek.d();
                ProgressStep progressStep7 = ProgressStep.STEP_30;
                if (!concurrentHashMapD7.containsKey(Integer.valueOf(progressStep7.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep7.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapD8 = aVarPeek.d();
                ProgressStep progressStep8 = ProgressStep.STEP_50;
                if (!concurrentHashMapD8.containsKey(Integer.valueOf(progressStep8.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep8.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapD9 = aVarPeek.d();
                ProgressStep progressStep9 = ProgressStep.STEP_70;
                if (!concurrentHashMapD9.containsKey(Integer.valueOf(progressStep9.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep9.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
                ConcurrentHashMap<Integer, Long> concurrentHashMapD10 = aVarPeek.d();
                ProgressStep progressStep10 = ProgressStep.STEP_100;
                if (!concurrentHashMapD10.containsKey(Integer.valueOf(progressStep10.getStep()))) {
                    aVarPeek.d().put(Integer.valueOf(progressStep10.getStep()), Long.valueOf(System.currentTimeMillis() - aVarPeek.f()));
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31216i0, k.j(aVarPeek.d()));
            cb.a aVar = new cb.a(bundle);
            App app2 = this.f30955b;
            aVar.f(app2 != null ? app2.getAppChainContext() : null);
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31220k0, k.j(aVarPeek.d()));
            new cb.b(bundle2).f(C1(aVarPeek.j()));
            TmcLogger.c(this.f31406t, "updateProgressStep: progressCurrentStep=" + aVarPeek.e() + ", progressCollectList=" + aVarPeek.d());
        } catch (EmptyStackException e11) {
            TmcLogger.f(this.f31406t, "updateProgressStep fail: " + e11);
        }
    }

    public final void N1() {
        try {
            if (this.f31409w.size() <= 0) {
                TmcLogger.f(this.f31406t, "loadingUrlFinish fail: backForwardStack.size = 0");
                return;
            }
            b bVarPeek = this.f31409w.peek();
            TmcLogger.c(this.f31406t, "loadingUrlFinish => loadingUrl: " + this.f31408v + ", isProgressChangedTo100:" + bVarPeek.k() + ", isPageFinished: " + bVarPeek.j());
            if (!Intrinsics.b(this.f31408v, bVarPeek.f())) {
                TmcLogger.f(this.f31406t, "loadingUrlFinish fail: url不匹配, loadingUrl:" + this.f31408v + " , pageStatus.url:" + bVarPeek.f());
                return;
            }
            if (bVarPeek.i()) {
                TmcLogger.f(this.f31406t, "loadingUrlFinish fail: 加载页面失败, loadingUrl: " + this.f31408v);
                return;
            }
            if (bVarPeek.k()) {
                return;
            }
            TmcLogger.c(this.f31406t, "loadingUrlFinish => reportDate");
            bVarPeek.p(true);
            e2();
            w2(bVarPeek.b());
            P1(bVarPeek.b());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                h0 h0Var = h0.f31062a;
                App app = this.f30955b;
                h0Var.b(activity, app != null ? app.getAppId() : null);
            }
        } catch (EmptyStackException e11) {
            TmcLogger.f(this.f31406t, "loadingUrlFinish fail: " + e11);
        }
    }

    public final void O1(String pageRandomIdByGAID) {
        Intrinsics.g(pageRandomIdByGAID, "pageRandomIdByGAID");
        kd.k.a(j.a("loadingUrlStart => loadingUrl: "), this.f31408v, this.f31406t);
        Stack<b> stack = this.f31409w;
        b bVar = new b(this.f31408v, false, false, this.f31410x, false, false, this.f31412z, null, null, 0L, false, 1920, null);
        bVar.o(pageRandomIdByGAID);
        stack.add(bVar);
    }

    public final void P1(String pageRandomIdByGAID) {
        App app;
        Bundle startParams;
        Intrinsics.g(pageRandomIdByGAID, "pageRandomIdByGAID");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page = this.f30954a;
            bundle.putString(str, (page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.O, this.f31408v);
            bundle.putString("pageRandomId", pageRandomIdByGAID);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void Q1() {
        String strB;
        try {
            if (this.f31409w.size() > 1) {
                strB = this.f31409w.peek().b();
            } else {
                TmcLogger.f(this.f31406t, "pointTrackClear fail: backForwardStack.size <= 1");
                strB = "";
            }
        } catch (Throwable th2) {
            TmcLogger.e("pointTrackClear fail: " + th2);
        }
        R1(this.f31408v, strB);
    }

    public final void R1(String pagePath, String pageRandomIdByGAID) {
        Bundle startParams;
        Intrinsics.g(pagePath, "pagePath");
        Intrinsics.g(pageRandomIdByGAID, "pageRandomIdByGAID");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            String string = null;
            String appId = app != null ? app.getAppId() : null;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_CLEAR;
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app2 = this.f30955b;
            if (app2 != null && (startParams = app2.getStartParams()) != null) {
                string = startParams.getString("uniqueChainID", "-1");
            }
            bundle.putString(str, String.valueOf(string));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(pagePath));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.O, pagePath);
            bundle.putString("pageRandomId", pageRandomIdByGAID);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "clear", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void S1() {
        l lVar;
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        com.cloud.tmc.miniapp.base.a aVarPop;
        try {
            App app = this.f30955b;
            if (app == null || (lVar = (l) app.getData(l.class)) == null || (stackA = lVar.a()) == null || (aVarPop = stackA.pop()) == null) {
                return;
            }
            T1(aVarPop.g(), aVarPop.j(), aVarPop);
        } catch (Throwable unused) {
        }
    }

    public final void T1(String pagePath, String virtual_h5PageId, com.cloud.tmc.miniapp.base.a showPageData) {
        Intrinsics.g(pagePath, "pagePath");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        Intrinsics.g(showPageData, "showPageData");
        try {
            TmcLogger.c(this.f31407u, "juggist[pointTrackClearNew] -> requestUrl :" + pagePath);
            TmcLogger.c(this.f31407u, "juggist[pointTrackClearNew] -> virtual_h5PageId: " + virtual_h5PageId + ' ');
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31210f0, this.f30957d.getDes());
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(pagePath));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            Page page = this.f30954a;
            bundle.putString("pageRandomId", String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_CLEAR, "clear", bundle);
            new cb.b(bundle).f(showPageData.c());
            PageChainContext pageChainContextC = showPageData.c();
            if (pageChainContextC != null) {
                pageChainContextC.d(bundle);
            }
        } catch (Throwable unused) {
        }
    }

    public final void U1(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle);
            new xa.c(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void V1(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F, bundle);
            new db.c(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void W1() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.X;
            Page page = this.f30954a;
            bundle.putString(str2, page != null ? page.getPageId() : null);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31221l, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void X1(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle);
            new d(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void Y1() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.X;
            Page page = this.f30954a;
            bundle.putString(str2, page != null ? page.getPageId() : null);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31221l, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void Z1(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle);
            new db.d(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void a2() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31225n, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void b2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle);
            new e(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void c2() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31225n, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void d2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle);
            new db.e(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void e2() {
        App app;
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page = this.f30954a;
            bundle.putString(str, (page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31228p, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void f2(String url, String virtual_h5PageId, boolean z11) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            bundle.putBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31214h0, z11);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void h2(String url, String virtual_h5PageId, boolean z11) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U, "1");
            bundle.putBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31214h0, z11);
            Page page = this.f30954a;
            bundle.putString("pageRandomId", String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
            bundle.putString("pageUniqueId", q.d() + '_' + virtual_h5PageId);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle);
            App app2 = this.f30955b;
            if (app2 != null) {
                app2.setMiniAppLoadStatus(true);
            }
            new g(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void i2(String url, String virtual_h5PageId, boolean z11) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31210f0, "网络异常");
            bundle.putBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31214h0, z11);
            new cb.b(bundle).f(C1(virtual_h5PageId));
            new ya.b(bundle).f(C1(virtual_h5PageId));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_FAIL, "pageOpenFail", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void j2() {
        App app;
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            Page page = this.f30954a;
            bundle.putString(str, String.valueOf((page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31228p, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void k2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle);
            new db.g(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void l2() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31223m, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void m2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle);
            new xa.l(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void n2() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31223m, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void o2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle);
            new db.l(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void p2() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31227o, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void q2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle);
            new n(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void r2() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app = this.f30955b;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31227o, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void s1(String str, String str2, boolean z11) {
        TmcLogger.c(this.f31407u, "addNewPageTrack");
        if (!z11) {
            V1(str, str2);
            U1(str, str2);
        }
        Z1(str, str2);
        X1(str, str2);
        o2(str, str2);
        m2(str, str2);
        d2(str, str2);
        b2(str, str2);
        s2(str, str2);
        q2(str, str2);
        u2(str, str2);
        t2(str, str2);
        k2(str, str2);
    }

    public final void s2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle);
            new db.n(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void t1(String originalUrl, String url, String requestUrl, String virtual_h5PageId, PageChainContext pageChainContext) {
        String pageRandomIdByGAId;
        Intrinsics.g(originalUrl, "originalUrl");
        Intrinsics.g(url, "url");
        Intrinsics.g(requestUrl, "requestUrl");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        Intrinsics.g(pageChainContext, "pageChainContext");
        try {
            TmcLogger.c(this.f31407u, "Add New Home Page -> requestUrl:" + requestUrl);
            App app = this.f30955b;
            if (app != null) {
                if (app.getData(l.class) == null) {
                    app.setData(l.class, new l());
                }
                l lVar = (l) app.getData(l.class);
                if (lVar != null) {
                    Stack<com.cloud.tmc.miniapp.base.a> stackA = lVar.a();
                    ShowPageStatus showPageStatus = ShowPageStatus.SHOULDOVERRIDEURKLOADING;
                    Page page = this.f30954a;
                    if (page == null || (pageRandomIdByGAId = page.getPageRandomIdByGAId()) == null) {
                        pageRandomIdByGAId = "null";
                    }
                    String str = pageRandomIdByGAId;
                    Intrinsics.f(str, "page?.pageRandomIdByGAId ?: \"null\"");
                    stackA.add(new com.cloud.tmc.miniapp.base.a(originalUrl, url, requestUrl, virtual_h5PageId, showPageStatus, false, str, pageChainContext, false, null, null, 0L, 3840, null));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void t2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, url);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            Page page = this.f30954a;
            bundle.putString("pageRandomId", String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
            bundle.putString("pageUniqueId", q.d() + '_' + virtual_h5PageId);
            new xa.a(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final boolean u1(WebView webView) {
        String str = this.C;
        StringBuilder sbA = j.a("canGoBack => originalUrl:");
        sbA.append(z1(webView));
        sbA.append(" , url:");
        sbA.append(A1(webView));
        TmcLogger.c(str, sbA.toString());
        if (webView != null) {
            try {
                if (webView.canGoBack()) {
                    if (!this.E.isEmpty()) {
                        TmcLogger.c(this.C, "canGoBack => 重定向回退");
                        return F2(webView);
                    }
                    TmcLogger.c(this.C, "canGoBack => 正常回退");
                    webView.goBack();
                    I1(this, null, 1, null);
                    G1();
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        TmcLogger.c(this.C, "canGoBack => 直接退出");
        return false;
    }

    public final void u2(String url, String virtual_h5PageId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, url);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, virtual_h5PageId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, "2");
            new db.a(bundle).f(C1(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final boolean v1(int i11) {
        if (i11 == 1) {
            return MiniAppConfigHelper.f30370a.b("enableH5DomMonitor", true);
        }
        if (i11 != 2) {
            return false;
        }
        return MiniAppConfigHelper.f30370a.b("enableShellDomMonitor", true);
    }

    public final void v2(String url) {
        Bundle startParams;
        Intrinsics.g(url, "url");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app = this.f30955b;
            String string = null;
            String appId = app != null ? app.getAppId() : null;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_H5_PAGE_ONFINISHED;
            Bundle bundle = new Bundle();
            String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
            App app2 = this.f30955b;
            if (app2 != null && (startParams = app2.getStartParams()) != null) {
                string = startParams.getString("uniqueChainID", "-1");
            }
            bundle.putString(str, String.valueOf(string));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(url));
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void w1() {
        Page page;
        try {
            App app = this.f30955b;
            if (app == null || (page = this.f30954a) == null) {
                return;
            }
            this.G = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(page);
            a aVar = new a(app, page);
            this.F = aVar;
            uc.b bVar = this.G;
            if (bVar != null) {
                bVar.b("h5OnPageFinished", aVar);
            }
        } catch (Throwable unused) {
        }
    }

    public final void w2(String pageRandomIdByGAID) {
        App app;
        Bundle startParams;
        Intrinsics.g(pageRandomIdByGAID, "pageRandomIdByGAID");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            Page page = this.f30954a;
            String strValueOf = String.valueOf((page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, strValueOf);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.O, this.f31408v);
            bundle.putString("pageRandomId", pageRandomIdByGAID);
            m0.c(this.f30954a, this.f31408v);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q, bundle);
            App app3 = this.f30955b;
            m0.d(app3 != null ? app3.getAppId() : null, strValueOf, this.f31408v);
        } catch (Throwable unused) {
        }
    }

    public final void x1() {
        uc.b bVar;
        try {
            uc.c cVar = this.F;
            if (cVar == null || (bVar = this.G) == null) {
                return;
            }
            bVar.c("h5OnPageFinished", cVar);
        } catch (Throwable unused) {
        }
    }

    public final void x2(WebView webView, String str) {
        l lVar;
        try {
            String str2 = this.f31407u;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("juggist[pointTrackPageFinishedNew] -> originalUrl:");
            sb2.append(webView != null ? webView.getOriginalUrl() : null);
            TmcLogger.c(str2, sb2.toString());
            String str3 = this.f31407u;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("juggist[pointTrackPageFinishedNew] -> url        :");
            sb3.append(webView != null ? webView.getUrl() : null);
            TmcLogger.c(str3, sb3.toString());
            TmcLogger.c(this.f31407u, "juggist[pointTrackPageFinishedNew] -> requestUrl :" + str);
            App app = this.f30955b;
            if (app != null && (lVar = (l) app.getData(l.class)) != null) {
                Stack<com.cloud.tmc.miniapp.base.a> stackA = lVar.a();
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackPageFinishedNew] -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                if (aVarPeek == null) {
                    return;
                }
                TmcLogger.c(this.f31407u, "juggist[pointTrackPageFinishedNew] -> showPages:" + aVarPeek);
                if (!Intrinsics.b(aVarPeek.g(), str)) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackPageFinishedNew] -> showPage.requestUrl != url return");
                } else {
                    if (aVarPeek.h().getType() != ShowPageStatus.PAGE_PROGRESS100.getType()) {
                        TmcLogger.c(this.f31407u, "juggist[pointTrackPageFinishedNew] -> showPage.status != ShowPageStatus.PAGE_PROGRESS100 return");
                        return;
                    }
                    TmcLogger.c(this.f31407u, "所有资源渲染结束");
                    aVarPeek.p(ShowPageStatus.PAGE_FINISHED);
                    v2(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final String y1() {
        try {
            String strPeek = this.D.peek();
            if (strPeek == null) {
                return null;
            }
            if (!CollectionsKt___CollectionsKt.X(this.E, strPeek)) {
                return strPeek;
            }
            this.D.pop();
            return y1();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void y2() {
        App app;
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            Page page = this.f30954a;
            String strValueOf = String.valueOf((page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, strValueOf);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, D1(this.f31408v));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            App app2 = this.f30955b;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q, bundle);
            App app3 = this.f30955b;
            String appId = app3 != null ? app3.getAppId() : null;
            String str = this.f31408v;
            Page page2 = this.f30954a;
            m0.g(appId, strValueOf, str, "shouldOverrideUrl", page2 != null ? page2.getPageRandomIdByGAId() : null);
        } catch (Throwable unused) {
        }
    }

    public final String z1(WebView webView) {
        String url;
        if (webView != null && (url = webView.getUrl()) != null && kotlin.text.l.L(url, "about:blank", false, 2, null)) {
            return this.f31408v;
        }
        if (webView != null) {
            return webView.getOriginalUrl();
        }
        return null;
    }

    public final void z2(WebView webView) {
        l lVar;
        try {
            String str = this.f31407u;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("juggist[pointTrackProgressChanged100New] -> webView.originalUrl:");
            sb2.append(webView != null ? webView.getOriginalUrl() : null);
            TmcLogger.c(str, sb2.toString());
            String str2 = this.f31407u;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("juggist[pointTrackProgressChanged100New] -> webView.url:");
            sb3.append(webView != null ? webView.getUrl() : null);
            TmcLogger.c(str2, sb3.toString());
            App app = this.f30955b;
            if (app != null && (lVar = (l) app.getData(l.class)) != null) {
                Stack<com.cloud.tmc.miniapp.base.a> stackA = lVar.a();
                if (stackA.size() == 0) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChanged100New] -> showPages.size == 0 return");
                    return;
                }
                com.cloud.tmc.miniapp.base.a aVarPeek = stackA.peek();
                if (aVarPeek == null) {
                    return;
                }
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChanged100New] -> originalUrl:" + aVarPeek.b());
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChanged100New] -> url        :" + aVarPeek.i());
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChanged100New] -> requestUrl :" + aVarPeek.g());
                TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChanged100New] -> showPages:" + aVarPeek);
                if (aVarPeek.h().getType() != ShowPageStatus.PAGE_START.getType()) {
                    TmcLogger.c(this.f31407u, "juggist[pointTrackProgressChanged100New] -> showPage.status != ShowPageStatus.PAGE_START return");
                    return;
                }
                String str3 = this.f31407u;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("静态资源渲染结束,渲染成功结果:");
                boolean z11 = true;
                sb4.append(!aVarPeek.a());
                TmcLogger.c(str3, sb4.toString());
                aVarPeek.p(ShowPageStatus.PAGE_PROGRESS100);
                if (this.B) {
                    this.B = false;
                } else {
                    z11 = false;
                }
                if (aVarPeek.a()) {
                    i2(aVarPeek.g(), aVarPeek.j(), z11);
                    return;
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    h0 h0Var = h0.f31062a;
                    App app2 = this.f30955b;
                    h0Var.b(activity, app2 != null ? app2.getAppId() : null);
                }
                h2(aVarPeek.g(), aVarPeek.j(), z11);
            }
        } catch (Throwable unused) {
        }
    }
}
