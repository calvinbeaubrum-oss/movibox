package OooOO0;

import OooOO0.OooO0o;
import OooOO0o.OooO0O0;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniutils.util.c;
import com.cloud.tmc.miniutils.util.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import hd.j;
import hd.k;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.l;
import zc.n;
import zc.o;
import zc.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooO0o extends FrameLayout implements p, o, nc.a {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public long f167OooO;
    public final String OooO00o;
    public final WeakReference<Activity> OooO0O0;
    public final String OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f168OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public m.a f169OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final OooO0O0 f170OooO0o0;
    public String OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public String f171OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final Stack<a> f172OooOO0;
    public boolean OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public ge.a f173OooOO0o;
    public final String OooOOO;
    public boolean OooOOO0;
    public final Stack<String> OooOOOO;
    public final List<String> OooOOOo;
    public boolean OooOOo;
    public int OooOOo0;
    public long OooOOoo;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<FrameLayout> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) OooO0o.this.findViewById(R$id.baseLayout);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ConcurrentHashMap<Integer, Long> f181h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f182i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f183j;

        public a() {
            this(null, false, false, false, false, false, null, null, 0L, false, 1023);
        }

        public a(String url, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String virtual_h5PageId, ConcurrentHashMap<Integer, Long> progressCollectList, long j11, boolean z16) {
            Intrinsics.g(url, "url");
            Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
            Intrinsics.g(progressCollectList, "progressCollectList");
            this.f174a = url;
            this.f175b = z11;
            this.f176c = z12;
            this.f177d = z13;
            this.f178e = z14;
            this.f179f = z15;
            this.f180g = virtual_h5PageId;
            this.f181h = progressCollectList;
            this.f182i = j11;
            this.f183j = z16;
        }

        public /* synthetic */ a(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str2, ConcurrentHashMap concurrentHashMap, long j11, boolean z16, int i11) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12, (i11 & 8) != 0 ? false : z13, (i11 & 16) != 0 ? false : z14, (i11 & 32) != 0 ? false : z15, (i11 & 64) != 0 ? "0" : null, (i11 & 128) != 0 ? new ConcurrentHashMap() : null, (i11 & 256) != 0 ? System.currentTimeMillis() : j11, (i11 & 512) == 0 ? z16 : false);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f174a, aVar.f174a) && this.f175b == aVar.f175b && this.f176c == aVar.f176c && this.f177d == aVar.f177d && this.f178e == aVar.f178e && this.f179f == aVar.f179f && Intrinsics.b(this.f180g, aVar.f180g) && Intrinsics.b(this.f181h, aVar.f181h) && this.f182i == aVar.f182i && this.f183j == aVar.f183j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v17, types: [int] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iHashCode = this.f174a.hashCode() * 31;
            boolean z11 = this.f175b;
            ?? r11 = z11;
            if (z11) {
                r11 = 1;
            }
            int i11 = (iHashCode + r11) * 31;
            boolean z12 = this.f176c;
            ?? r12 = z12;
            if (z12) {
                r12 = 1;
            }
            int i12 = (i11 + r12) * 31;
            boolean z13 = this.f177d;
            ?? r13 = z13;
            if (z13) {
                r13 = 1;
            }
            int i13 = (i12 + r13) * 31;
            boolean z14 = this.f178e;
            ?? r14 = z14;
            if (z14) {
                r14 = 1;
            }
            int i14 = (i13 + r14) * 31;
            boolean z15 = this.f179f;
            ?? r15 = z15;
            if (z15) {
                r15 = 1;
            }
            int iA = (l.p.a(this.f182i) + ((this.f181h.hashCode() + ((this.f180g.hashCode() + ((i14 + r15) * 31)) * 31)) * 31)) * 31;
            boolean z16 = this.f183j;
            return iA + (z16 ? 1 : z16);
        }

        public String toString() {
            StringBuilder sbA = j.a("PageStatus(url=");
            sbA.append(this.f174a);
            sbA.append(", isProgressChangedTo100=");
            sbA.append(this.f175b);
            sbA.append(", isPageFinished=");
            sbA.append(this.f176c);
            sbA.append(", isHomePage=");
            sbA.append(this.f177d);
            sbA.append(", isLoadError=");
            sbA.append(this.f178e);
            sbA.append(", canGoBack=");
            sbA.append(this.f179f);
            sbA.append(", virtual_h5PageId=");
            sbA.append(this.f180g);
            sbA.append(", progressCollectList=");
            sbA.append(this.f181h);
            sbA.append(", progressStartTime=");
            sbA.append(this.f182i);
            sbA.append(", isDomContentLoaded=");
            sbA.append(this.f183j);
            sbA.append(')');
            return sbA.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f184a;

        static {
            int[] iArr = new int[BaseComponentLifecycle.ViewAction.values().length];
            try {
                iArr[BaseComponentLifecycle.ViewAction.ON_ADD_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BaseComponentLifecycle.ViewAction.ON_UPDATE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f184a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0o(String viewId, Context context, WeakReference<Activity> weakReference, AttributeSet attributeSet) {
        super(context, null);
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(context, "context");
        this.OooO00o = viewId;
        this.OooO0O0 = weakReference;
        this.OooO0OO = "WebviewComponentView";
        this.f168OooO0Oo = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.OooO0oO = "";
        this.f171OooO0oo = "";
        this.f172OooOO0 = new Stack<>();
        LayoutInflater.from(getContext()).inflate(R$layout.layout_mini_webview_view, (ViewGroup) this, true);
        OooO0O0 oooO0O0 = new OooO0O0(context, null, 2);
        oooO0O0.OooO00o((o) this);
        oooO0O0.OooO00o((p) this);
        oooO0O0.setBackgroundColor(-1);
        this.f170OooO0o0 = oooO0O0;
        FrameLayout frameLayout = getFrameLayout();
        if (frameLayout != null) {
            frameLayout.addView(oooO0O0);
        }
        oooO0O0.OooO00o();
        try {
            Activity activity = weakReference.get();
            if (activity != null) {
                this.OooOOO0 = c.g(activity);
                TmcLogger.c("WebviewComponentView", "isNavBarVisible ->" + this.OooOOO0);
            }
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO0OO, th2);
        }
        this.OooOOO = "h5Redirect";
        this.OooOOOO = new Stack<>();
        this.OooOOOo = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO00o(long j11, OooO0o this$0, Ref.ObjectRef url, String str) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(url, "$url");
        try {
            if (j11 <= this$0.f167OooO) {
                ge.a aVar = this$0.f173OooOO0o;
                if (aVar != null) {
                    aVar.onDownloadStart((String) url.element, null, null, str, j11);
                }
            } else {
                JsonObject jsonObjectE = z.a().d("errorCode", "60001").b("success", Boolean.FALSE).e();
                Intrinsics.f(jsonObjectE, "create().addProperty(\n  …\"success\", false).build()");
                ge.a aVar2 = this$0.f173OooOO0o;
                if (aVar2 != null) {
                    aVar2.a(jsonObjectE);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h(this$0.OooO0OO, th2);
        }
    }

    public static final void OooO00o(OooO0o this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            this$0.setLayoutParams(new AbsoluteLayout.LayoutParams(this$0.getWidth(), this$0.OooOOo0, this$0.getTop(), this$0.getLeft()));
        } catch (Throwable th2) {
            TmcLogger.h(this$0.OooO0OO, th2);
        }
    }

    public static final void OooO00o(OooO0o this$0, String url) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(url, "$url");
        OooO0O0 oooO0O0 = this$0.f170OooO0o0;
        oooO0O0.getClass();
        Intrinsics.g(url, "url");
        TmcLogger.c("NativeWebView", "[load Url]: " + url);
        oooO0O0.loadUrl(url);
    }

    public static final void OooO00o(OooO0o this$0, String baseUrl, String data, String mimeType, String encoding) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseUrl, "$baseUrl");
        Intrinsics.g(data, "$data");
        Intrinsics.g(mimeType, "$mimeType");
        Intrinsics.g(encoding, "$encoding");
        k.a("loadDataWithBaseURL baseUrl:", baseUrl, this$0.OooO0OO);
        this$0.f170OooO0o0.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, null);
    }

    public static final void OooO00o(OooO0o this$0, String str, String str2, String str3, String str4, long j11) {
        Intrinsics.g(this$0, "this$0");
        ge.a aVar = this$0.f173OooOO0o;
        if (aVar != null) {
            aVar.onDownloadStart(str, str2, str3, str4, j11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO00o(final Ref.ObjectRef url, final OooO0o this$0, final String str) {
        Intrinsics.g(url, "$url");
        Intrinsics.g(this$0, "this$0");
        final long jA = m.a((String) url.element);
        e.f(new Runnable() { // from class: l.h
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO00o(jA, this$0, url, str);
            }
        });
    }

    public static final void OooO0O0(OooO0o this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            this$0.setLayoutParams(new AbsoluteLayout.LayoutParams(this$0.getWidth(), this$0.OooOOo0, this$0.getTop(), this$0.getLeft()));
        } catch (Throwable th2) {
            TmcLogger.h(this$0.OooO0OO, th2);
        }
    }

    public static final void OooO0OO(OooO0o this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f170OooO0o0.reload();
    }

    private final FrameLayout getFrameLayout() {
        return (FrameLayout) this.f168OooO0Oo.getValue();
    }

    public final void OooO() {
        JsonObject jsonObjectE = z.a().d("type", "onResume").d("pageUrl", this.f170OooO0o0.getUrl()).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…URL, webView.url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onResume", jsonObjectE);
        }
    }

    public final void OooO00o(Node node) {
        Intrinsics.g(node, "node");
        try {
            this.f173OooOO0o = new ge.a(node);
            this.f170OooO0o0.setDownloadListener(new DownloadListener() { // from class: l.o
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
                    OooO0o.OooO00o(this.f69748a, str, str2, str3, str4, j11);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO0OO, "registerDownloadListener", th2);
        }
    }

    public final void OooO00o(JsonObject jsonObject, BaseComponentLifecycle.ViewAction viewAction) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        Intrinsics.g(viewAction, "viewAction");
        try {
            String str = this.OooO0OO;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" parse json = ");
            sb2.append(jsonObject != null ? jsonObject.toString() : null);
            TmcLogger.f(str, sb2.toString());
            if (jsonObject != null && (jsonElement2 = jsonObject.get("src")) != null) {
                String loadUrl = jsonElement2.getAsString();
                int i11 = b.f184a[viewAction.ordinal()];
                if (i11 == 1) {
                    Intrinsics.f(loadUrl, "loadUrl");
                    this.f171OooO0oo = loadUrl;
                    OooO0O0(loadUrl);
                } else if (i11 == 2 && !TextUtils.isEmpty(loadUrl) && !Intrinsics.b(loadUrl, this.f171OooO0oo)) {
                    Intrinsics.f(loadUrl, "loadUrl");
                    this.f171OooO0oo = loadUrl;
                    OooO0O0(loadUrl);
                }
            }
            if (jsonObject == null || (jsonElement = jsonObject.get("maxContentLength")) == null) {
                return;
            }
            try {
                String string = jsonElement.toString();
                Intrinsics.f(string, "it.toString()");
                this.f167OooO = Long.parseLong(string);
                TmcLogger.c(this.OooO0OO, "maxContentLength:->" + this.f167OooO);
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO0OO, th2);
            }
        } catch (Throwable th3) {
            TmcLogger.g(this.OooO0OO, "parseJson", th3);
        }
    }

    public final void OooO00o(String webviewUrl, String webResourceRequestUrl) {
        Intrinsics.g(webviewUrl, "webviewUrl");
        Intrinsics.g(webResourceRequestUrl, "webResourceRequestUrl");
        try {
            TmcLogger.c(this.OooO0OO, "redirect => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
            URL url = new URL(webviewUrl);
            URL url2 = new URL(webResourceRequestUrl);
            String str = url.getHost() + url.getPath();
            String str2 = url2.getHost() + url2.getPath();
            TmcLogger.c(this.OooO0OO, "webviewURLCombine:" + str);
            TmcLogger.c(this.OooO0OO, "webResourceRequestURLCombine:" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (Intrinsics.b(str, str2)) {
                    TmcLogger.c(this.OooO0OO, "redirect  进入backForward栈 => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
                    this.f172OooOO0.peek().f179f = true;
                } else {
                    TmcLogger.c(this.OooO0OO, "redirect  开始加载 => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
                    OooO00o(webResourceRequestUrl, false);
                    OooO0o0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o(final String baseUrl, final String data, final String mimeType, final String encoding) {
        Intrinsics.g(baseUrl, "baseUrl");
        Intrinsics.g(data, "data");
        Intrinsics.g(mimeType, "mimeType");
        Intrinsics.g(encoding, "encoding");
        e.f(new Runnable() { // from class: l.l
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO00o(this.f69739a, baseUrl, data, mimeType, encoding);
            }
        });
    }

    public final void OooO00o(String loadingUrl, boolean z11) {
        Intrinsics.g(loadingUrl, "loadingUrl");
        TmcLogger.c(this.OooO0OO, "setLoadingUrl => loadingUrl: " + loadingUrl + " , isFirstLoadHomePage: " + z11);
        this.OooO0oO = loadingUrl;
        this.OooOO0O = z11;
    }

    public final boolean OooO00o() {
        String str = this.OooOOO;
        StringBuilder sbA = j.a("canGoBack => originalUrl:");
        OooO0O0 oooO0O0 = this.f170OooO0o0;
        sbA.append(oooO0O0 != null ? oooO0O0.getOriginalUrl() : null);
        sbA.append(" , url:");
        OooO0O0 oooO0O1 = this.f170OooO0o0;
        kd.k.a(sbA, oooO0O1 != null ? oooO0O1.getUrl() : null, str);
        try {
            if (this.f170OooO0o0.canGoBack()) {
                if (!this.OooOOOo.isEmpty()) {
                    TmcLogger.c(this.OooOOO, "canGoBack => 重定向回退");
                    return OooO00o(this.f170OooO0o0);
                }
                TmcLogger.c(this.OooOOO, "canGoBack => 正常回退");
                this.f170OooO0o0.goBack();
                OooO0OO();
                return true;
            }
        } catch (Throwable unused) {
        }
        TmcLogger.c(this.OooOOO, "canGoBack => 直接退出");
        return false;
    }

    public final boolean OooO00o(WebView webView) {
        String str = this.OooOOO;
        StringBuilder sbA = j.a("redirectCanGoBack => originalUrl:");
        WebHistoryItem webHistoryItem = null;
        sbA.append(webView != null ? webView.getOriginalUrl() : null);
        sbA.append(" , url:");
        kd.k.a(sbA, webView != null ? webView.getUrl() : null, str);
        if (webView != null) {
            try {
                if (webView.canGoBack()) {
                    String strPop = this.OooOOOO.pop();
                    if (strPop == null) {
                        return false;
                    }
                    TmcLogger.c(this.OooOOO, "exitPage:" + strPop);
                    WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
                    Intrinsics.f(webBackForwardListCopyBackForwardList, "webView.copyBackForwardList()");
                    TmcLogger.c(this.OooOOO, "WebBackForwardList.size:" + webBackForwardListCopyBackForwardList.getSize());
                    int i11 = -1;
                    int i12 = -1;
                    for (int size = webBackForwardListCopyBackForwardList.getSize() - 1; -1 < size; size--) {
                        TmcLogger.c(this.OooOOO, "WebBackForwardList(" + size + ") => originalUrl:" + webBackForwardListCopyBackForwardList.getItemAtIndex(size).getOriginalUrl() + " , url:" + webBackForwardListCopyBackForwardList.getItemAtIndex(size).getUrl());
                        if (Intrinsics.b(webBackForwardListCopyBackForwardList.getItemAtIndex(size).getUrl(), strPop)) {
                            if (i12 == -1) {
                                i12 = size;
                            }
                            i11 = size;
                        }
                    }
                    String strOooO0O0 = OooO0O0();
                    if (strOooO0O0 == null) {
                        return false;
                    }
                    TmcLogger.c(this.OooOOO, "prePage:" + strOooO0O0);
                    int i13 = 1;
                    for (int i14 = i11 + (-1); -1 < i14; i14--) {
                        WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(i14);
                        if (Intrinsics.b(strOooO0O0, itemAtIndex.getUrl())) {
                            i13 = i14;
                            webHistoryItem = itemAtIndex;
                        }
                    }
                    if (webHistoryItem != null) {
                        int i15 = i13 - i11;
                        webView.goBackOrForward(i15);
                        OooO0OO();
                        TmcLogger.c(this.OooOOO, "goBackOrForward(" + i15 + ')');
                        return true;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.f(this.OooOOO, "redirectCanGoBack fail:" + th2);
            }
        }
        TmcLogger.c(this.OooOOO, "redirectCanGoBack -> 直接退出");
        return false;
    }

    public final boolean OooO00o(String str) {
        try {
            String path = new URL(str).getPath();
            Object objD = com.cloud.tmc.miniutils.util.k.d(MiniAppConfigHelper.f30370a.e("nativeWebviewDownloadConfig", "[\".pdf\",\".jpg\",\".png\",\".mp3\",\".mp4\",\".apk\",\".txt\",\".zip\"]"), List.class);
            List<String> arrayList = objD instanceof List ? (List) objD : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (String str2 : arrayList) {
                Intrinsics.f(path, "path");
                if (l.u(path, str2, false, 2, null)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final String OooO0O0() {
        try {
            String strPeek = this.OooOOOO.peek();
            if (strPeek == null) {
                return null;
            }
            if (!CollectionsKt___CollectionsKt.X(this.OooOOOo, strPeek)) {
                return strPeek;
            }
            this.OooOOOO.pop();
            return OooO0O0();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void OooO0O0(WebView webView) {
        TmcLogger.c(this.OooOOO, "redirectShouldOverrideUrlLoading ==================>");
        kd.k.a(j.a("webview.url:"), webView != null ? webView.getUrl() : null, this.OooOOO);
        TmcLogger.c(this.OooOOO, "redirectShouldOverrideUrlLoading <==================");
    }

    public final void OooO0O0(final String url) {
        Intrinsics.g(url, "url");
        e.f(new Runnable() { // from class: l.k
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO00o(this.f69737a, url);
            }
        });
    }

    public final void OooO0OO() {
        try {
            if (this.f172OooOO0.size() > 1) {
                a aVarPop = this.f172OooOO0.pop();
                a aVarPeek = this.f172OooOO0.peek();
                TmcLogger.c(this.OooO0OO, "goBack => exitPage: " + aVarPop + ", showPage: " + aVarPeek);
                OooO00o(aVarPeek.f174a, false);
                if (!aVarPop.f179f) {
                    TmcLogger.c(this.OooO0OO, "goBack 页面未入栈，继续退出 => exitPage: " + aVarPop + ", showPage: " + aVarPeek);
                    OooO0OO();
                }
            } else {
                TmcLogger.f(this.OooO0OO, "goBack fail: backForwardStack.size <= 1");
            }
        } catch (Throwable th2) {
            TmcLogger.e("goback fail: " + th2);
        }
    }

    public final boolean OooO0Oo() {
        return this.OooOOo || System.currentTimeMillis() - this.OooOOoo <= 200;
    }

    public final void OooO0o() {
        JsonObject jsonObjectE = z.a().d("type", "onDestory").d("pageUrl", this.f170OooO0o0.getUrl()).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…URL, webView.url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onDestory", jsonObjectE);
        }
        this.f169OooO0o = null;
        try {
            this.f170OooO0o0.setDownloadListener(null);
            this.f173OooOO0o = null;
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO0OO, "unRegisterDownloadListener", th2);
        }
    }

    public final void OooO0o0() {
        kd.k.a(j.a("loadingUrlStart => loadingUrl: "), this.OooO0oO, this.OooO0OO);
        this.f172OooOO0.add(new a(this.OooO0oO, false, false, this.OooOO0O, false, false, null, null, 0L, false, 960));
    }

    public final void OooO0oO() {
        JsonObject jsonObjectE = z.a().d("type", "onPause").d("pageUrl", this.f170OooO0o0.getUrl()).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…URL, webView.url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onPause", jsonObjectE);
        }
    }

    public final void OooO0oo() {
        JsonObject jsonObjectE = z.a().d("type", "onRemove").d("pageUrl", this.f170OooO0o0.getUrl()).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…URL, webView.url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onRemove", jsonObjectE);
        }
        this.f169OooO0o = null;
    }

    public final void OooOO0() {
        JsonObject jsonObjectE = z.a().d("type", "onStop").d("pageUrl", this.f170OooO0o0.getUrl()).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…URL, webView.url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onStop", jsonObjectE);
        }
    }

    public final void OooOO0O() {
        e.f(new Runnable() { // from class: l.m
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO0OO(this.f69744a);
            }
        });
    }

    public final void OooOO0o() {
        JsonObject jsonObjectE = z.a().d("type", "syncPageStack").b("canGoBack", Boolean.valueOf(this.f170OooO0o0.canGoBack())).b("canGoForward", Boolean.valueOf(this.f170OooO0o0.canGoForward())).e();
        Intrinsics.f(jsonObjectE, "create()\n            .ad…d())\n            .build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("syncPageStack", jsonObjectE);
        }
    }

    public final WeakReference<Activity> getActivity() {
        return this.OooO0O0;
    }

    public final String getPageUrl() {
        String url = this.f170OooO0o0.getUrl();
        return url == null ? "" : url;
    }

    public final String getViewId() {
        return this.OooO00o;
    }

    @Override // zc.p
    public void onConsoleMessage(String str) {
    }

    @Override // nc.a
    public void onKeyBoardChanged(int i11, int i12) {
        int iC = this.OooOOO0 ? c.c() : 0;
        String str = this.OooO0OO;
        StringBuilder sbA = j.a("isNavBarVisible -> ");
        sbA.append(this.OooOOO0);
        TmcLogger.c(str, sbA.toString());
        try {
            TmcLogger.c(this.OooO0OO, "onKeyBoardChanged height -> " + getHeight());
            if (this.OooOOo0 == 0) {
                this.OooOOo0 = getHeight();
            }
            int i13 = i11 - iC;
            if (i13 < 100) {
                TmcLogger.c(this.OooO0OO, "hide keyboard ->" + i13);
                this.OooOOo = false;
                this.OooOOoo = System.currentTimeMillis();
                postDelayed(new Runnable() { // from class: l.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0o.OooO00o(this.f69735a);
                    }
                }, 150L);
            } else if (i13 != 0) {
                TmcLogger.c(this.OooO0OO, "show keyboard");
                this.OooOOo = true;
                setLayoutParams(new AbsoluteLayout.LayoutParams(getWidth(), this.OooOOo0 - i13, getTop(), getLeft()));
            } else {
                TmcLogger.c(this.OooO0OO, "hide keyboard else  ->" + i13);
                this.OooOOo = false;
                this.OooOOoo = System.currentTimeMillis();
                postDelayed(new Runnable() { // from class: l.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0o.OooO0O0(this.f69736a);
                    }
                }, 150L);
            }
            TmcLogger.c(this.OooO0OO, "newKeyboardHeight->" + i13 + ", keyboardHeight->" + i11 + ",screenHeight->" + i12);
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO0OO, th2);
        }
    }

    @Override // zc.o
    public void onPageFinished(WebView webView, String str) {
        JsonObject jsonObjectE = z.a().d("type", "onPageFinished").d("pageUrl", str).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…EW_PAGE_URL, url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onPageFinished", jsonObjectE);
        }
        if (webView != null) {
            StringBuilder sbA = j.a("javascript:function getFaviconUrl() {var favicon = '';var links = document.getElementsByTagName('link');for (var i = 0; i < links.length; i++) {if (links[i].rel.indexOf('icon') >= 0) {favicon = links[i].href;}}return favicon;}window.dltNativeWebview.receiveUrlIcon(getFaviconUrl(),'");
            sbA.append(this.OooO00o);
            sbA.append("');");
            webView.loadUrl(sbA.toString());
        }
        if (webView != null) {
            StringBuilder sbA2 = j.a("javascript:var scrolled = false;window.addEventListener('scroll', function (e) {if (!scrolled) {window.dltNativeWebview.onScrollChanged('");
            sbA2.append(this.OooO00o);
            sbA2.append("');scrolled = true;}});var innerHeight = window.innerHeight;window.addEventListener('resize', () => {var newInnerHeight = window.innerHeight;if (innerHeight <= newInnerHeight) {scrolled = false;}});");
            webView.loadUrl(sbA2.toString());
        }
        OooOO0o();
    }

    @Override // zc.o
    public void onPageStarted(WebView webView, String str) {
        String url;
        TmcLogger.c(this.OooOOO, "redirectPageStarted ==================>");
        try {
            String str2 = this.OooOOO;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("webView.original:");
            sb2.append(webView != null ? webView.getOriginalUrl() : null);
            TmcLogger.c(str2, sb2.toString());
            String str3 = this.OooOOO;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("webView.url:");
            sb3.append(webView != null ? webView.getUrl() : null);
            TmcLogger.c(str3, sb3.toString());
            TmcLogger.c(this.OooOOO, "url:" + str);
            if (webView != null && (url = webView.getUrl()) != null) {
                this.OooOOOO.add(url);
            }
        } catch (Throwable unused) {
        }
        TmcLogger.c(this.OooOOO, "redirectPageStarted <==================");
        JsonObject jsonObjectE = z.a().d("type", "onPageStarted").d("pageUrl", str).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…EW_PAGE_URL, url).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onPageStarted", jsonObjectE);
        }
    }

    @Override // zc.p
    public void onProgressChanged(WebView webView, int i11) {
        JsonObject jsonObjectE = z.a().d("type", "onProgressChanged").c("newProgress", Integer.valueOf(i11)).e();
        Intrinsics.f(jsonObjectE, "create()\n               …ESS, newProgress).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onProgressChanged", jsonObjectE);
        }
    }

    @Override // zc.o
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        CharSequence description;
        Uri url;
        z.a aVarD = z.a().d("type", "onReceivedError").b("isForMainFrame", webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null).d("pageUrl", (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString()).c("errorCode", webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null).d("isForMainFrame", (webResourceError == null || (description = webResourceError.getDescription()) == null) ? null : description.toString());
        Intrinsics.f(aVarD, "create().addProperty(KEY….description?.toString())");
        if (Build.VERSION.SDK_INT >= 24) {
            aVarD.b("isRedirect", webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isRedirect()) : null);
        }
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            JsonObject jsonObjectE = aVarD.e();
            Intrinsics.f(jsonObjectE, "builder.build()");
            aVar.a("onReceivedError", jsonObjectE);
        }
    }

    @Override // zc.o
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String reasonPhrase;
        Uri url;
        z.a aVarC = z.a().d("type", "onReceivedHttpError").b("isForMainFrame", webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null).d("pageUrl", (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString()).c("errorCode", webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
        if (webResourceResponse == null || (reasonPhrase = webResourceResponse.getReasonPhrase()) == null) {
            reasonPhrase = null;
        }
        z.a aVarD = aVarC.d("reasonPhrase", reasonPhrase);
        Intrinsics.f(aVarD, "create()\n            .ad…reasonPhrase?.toString())");
        if (Build.VERSION.SDK_INT >= 24) {
            aVarD.b("isRedirect", webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isRedirect()) : null);
        }
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            JsonObject jsonObjectE = aVarD.e();
            Intrinsics.f(jsonObjectE, "builder.build()");
            aVar.a("onReceivedHttpError", jsonObjectE);
        }
    }

    @Override // zc.p
    public void onReceivedIcon(Bitmap bitmap) {
    }

    @Override // zc.p
    public void onReceivedTitle(String str) {
        JsonObject jsonObjectE = z.a().d("type", "onReceivedTitle").d(CampaignEx.JSON_KEY_TITLE, str).e();
        Intrinsics.f(jsonObjectE, "create().addProperty(KEY…IEW_TITLE, title).build()");
        m.a aVar = this.f169OooO0o;
        if (aVar != null) {
            aVar.a("onReceivedTitle", jsonObjectE);
        }
    }

    public /* bridge */ /* synthetic */ Boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return n.a(this, webView, renderProcessGoneDetail);
    }

    @Override // zc.p
    public void onRequestFocus() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.String] */
    @Override // zc.o
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String url;
        Uri url2;
        String string;
        try {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? ValueOf = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
            objectRef.element = ValueOf;
            if (OooO00o((String) ValueOf)) {
                final String strE = r.e((String) objectRef.element);
                e.a(ExecutorType.IO, new Runnable() { // from class: l.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0o.OooO00o(objectRef, this, strE);
                    }
                });
                return Boolean.TRUE;
            }
            if (!l.L((String) objectRef.element, "http://", false, 2, null) && !l.L((String) objectRef.element, AgentPageJsBridge.HTTPS, false, 2, null)) {
                TmcLogger.c(this.OooO0OO, "外跳事件，当前全部屏蔽状态,交由业务方处理");
                String schemeUrl = (String) objectRef.element;
                Intrinsics.g(schemeUrl, "schemeUrl");
                JsonObject jsonObjectE = z.a().d("type", "onReceivedSchemeUrl").d("schemeUrl", schemeUrl).e();
                Intrinsics.f(jsonObjectE, "create()\n            .ad…Url)\n            .build()");
                m.a aVar = this.f169OooO0o;
                if (aVar != null) {
                    aVar.a("onReceivedSchemeUrl", jsonObjectE);
                }
                return Boolean.TRUE;
            }
            OooO0O0(webView);
            if (webView != null && (url = webView.getUrl()) != null) {
                if (webResourceRequest != null && (url2 = webResourceRequest.getUrl()) != null && (string = url2.toString()) != null) {
                    OooO00o(url, string);
                    try {
                        ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).hideKeyboard(this);
                    } catch (Throwable th2) {
                        TmcLogger.h(this.OooO0OO, th2);
                    }
                    Boolean boolB = n.b(this, webView, webResourceRequest);
                    Intrinsics.f(boolB, "super.shouldOverrideUrlLoading(view, request)");
                    return boolB;
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        } catch (Throwable th3) {
            TmcLogger.g(this.OooO0OO, "shouldOverrideUrlLoading", th3);
            Boolean boolB2 = n.b(this, webView, webResourceRequest);
            Intrinsics.f(boolB2, "super.shouldOverrideUrlLoading(view, request)");
            return boolB2;
        }
    }
}
