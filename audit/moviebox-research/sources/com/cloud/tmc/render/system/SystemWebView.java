package com.cloud.tmc.render.system;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.render.IRenderWebivewStrategyCache;
import com.cloud.tmc.render.utils.ADJSI;
import com.cloud.tmc.render.utils.FullScreenJSI;
import com.cloud.tmc.render.utils.WebViewExtensionKt;
import com.transsion.push.PushConstants;
import fe.d;
import fe.f;
import ge.c;
import ge.j;
import ge.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc.k;
import zc.m;
import zc.o;
import zc.p;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SystemWebView extends WebView implements k, yc.a {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f32120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f32121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zc.a f32122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f32123d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Node f32125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f32126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f32128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ge.b f32129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f32130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f32131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FullScreenJSI f32132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ADJSI f32133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WebMessagePort f32134p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends WebMessagePort.WebMessageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference<p> f32135a;

        public b(WeakReference<p> weakReference) {
            this.f32135a = weakReference;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort port, WebMessage message) {
            Intrinsics.g(port, "port");
            Intrinsics.g(message, "message");
            p pVar = this.f32135a.get();
            if (pVar != null) {
                pVar.onConsoleMessage(message.getData());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SystemWebView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f32127i = MiniAppType.NORMAL.getType();
        this.f32128j = new f(this);
        this.f32131m = true;
        this.f32132n = new FullScreenJSI();
        this.f32133o = new ADJSI();
    }

    public /* synthetic */ SystemWebView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public final String a(String str) {
        Context context = getContext();
        Intrinsics.f(context, "context");
        String strA = r.a(str, "_transsion_dlt_miniapp_dark_theme_is_enabled", String.valueOf(com.cloud.tmc.kernel.utils.f.a(context)));
        Intrinsics.f(strA, "addParam(\n            ur…ext).toString()\n        )");
        return strA;
    }

    @Override // zc.k
    @SuppressLint({"JavascriptInterface"})
    public void create() {
        String str;
        Node node;
        p pVar = this.f32121b;
        o oVar = this.f32120a;
        String str2 = this.f32124f;
        if (str2 == null) {
            Intrinsics.y(PushConstants.PROVIDER_FIELD_APP_ID);
            str = null;
        } else {
            str = str2;
        }
        Node node2 = this.f32125g;
        if (node2 == null) {
            Intrinsics.y("node");
            node = null;
        } else {
            node = node2;
        }
        c cVar = new c(pVar, oVar, str, node, this);
        this.f32123d = cVar;
        setWebViewClient(cVar);
        Context context = getContext();
        Intrinsics.f(context, "context");
        l lVar = new l(context, this.f32121b, this.f32128j, this.f32122c);
        this.f32129k = lVar;
        setWebChromeClient(lVar);
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        addJavascriptInterface("", "");
        WebViewExtensionKt.c(this, this.f32132n);
        WebViewExtensionKt.b(this, this.f32133o);
    }

    @Override // android.webkit.WebView, zc.k
    public void destroy() {
        WebMessagePort webMessagePort;
        if (((IRenderWebivewStrategyCache) tc.a.a(IRenderWebivewStrategyCache.class)).getSystemWebviewCacheStrategy()) {
            clearCache(false);
        }
        clearHistory();
        c cVar = this.f32123d;
        if (cVar != null) {
            cVar.c();
        }
        this.f32123d = null;
        ge.b bVar = this.f32129k;
        if (bVar != null) {
            bVar.a();
        }
        this.f32129k = null;
        this.f32120a = null;
        this.f32121b = null;
        this.f32122c = null;
        if (Build.VERSION.SDK_INT >= 23 && (webMessagePort = this.f32134p) != null) {
            webMessagePort.close();
        }
        try {
            if (((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("enableSystemDestory", true)) {
                super.destroy();
                TmcLogger.c("SystemWebView", "systemWebview Destory");
            }
        } catch (Throwable th2) {
            TmcLogger.g("SystemWebView", PushConstants.PROVIDER_FIELD_DESTROY, th2);
        }
    }

    public final ge.b getMWebChromeClient() {
        return this.f32129k;
    }

    @Override // zc.k
    public int getMiniAppType() {
        return this.f32127i;
    }

    public final WebMessagePort getPort0() {
        return this.f32134p;
    }

    @Override // zc.k
    public ac.a getRenderBridge() {
        return this.f32128j.a(this);
    }

    public final f getWebviewBridgeHelper() {
        return this.f32128j;
    }

    @Override // android.webkit.WebView, zc.k
    public void goBack() {
        super.goBack();
    }

    @Override // yc.a
    public Boolean isRenderProcessGone() {
        return Boolean.valueOf(this.f32130l);
    }

    public boolean isResume() {
        return this.f32131m;
    }

    @Override // zc.k
    public void load(String url) {
        Intrinsics.g(url, "url");
        load(url, new HashMap<>());
    }

    @Override // zc.k
    public void load(String url, HashMap<String, String> additionalHttpHeaders) {
        String strA;
        Intrinsics.g(url, "url");
        Intrinsics.g(additionalHttpHeaders, "additionalHttpHeaders");
        try {
            String str = this.f32126h;
            if (str == null || str.length() == 0) {
                strA = url;
            } else {
                strA = r.a(url, "bgColor", this.f32126h);
                Intrinsics.f(strA, "addParam(url, \"bgColor\", bgColor)");
            }
            url = a(strA);
        } catch (Throwable th2) {
            TmcLogger.g("SystemWebView", "add bgColor parameter is fail!", th2);
        }
        TmcLogger.c("SystemWebView", "[Render]:[load Url]: " + url);
        super.loadUrl(url, additionalHttpHeaders);
    }

    @Override // zc.k
    public void loadData(String str, String data, String str2, String str3, String str4) {
        Intrinsics.g(data, "data");
        super.loadDataWithBaseURL(str, data, str2, str3, str4);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onCheckIsTextEditor() {
        boolean zOnCheckIsTextEditor = false;
        try {
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                zOnCheckIsTextEditor = super.onCheckIsTextEditor();
            } else {
                TmcLogger.f("SystemWebView", "onCheckIsTextEditor() does not run in the main thread");
            }
        } catch (Throwable th2) {
            TmcLogger.g("SystemWebView", "Probable deadlock detected due to WebView API being called on incorrect thread while the UI thread is blocked.", th2);
        }
        return zOnCheckIsTextEditor;
    }

    @Override // android.webkit.WebView, zc.k
    public void onPause() {
        super.onPause();
        this.f32131m = false;
    }

    @Override // yc.a
    public void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f32130l = true;
        ((IOnRenderProcessGoneProxy) tc.a.a(IOnRenderProcessGoneProxy.class)).received(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebView, zc.k
    public void onResume() {
        super.onResume();
        this.f32131m = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
    }

    @Override // zc.k
    public void registerCustomViewVisiableCallback(zc.a aVar) {
        this.f32122c = aVar;
    }

    @Override // zc.k
    @RequiresApi(23)
    public void registerMessageChannel() {
        WeakReference weakReference = new WeakReference(this.f32121b);
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = createWebMessageChannel();
        Intrinsics.f(webMessagePortArrCreateWebMessageChannel, "this.createWebMessageChannel()");
        WebMessagePort webMessagePort = webMessagePortArrCreateWebMessageChannel[0];
        this.f32134p = webMessagePort;
        if (webMessagePort != null) {
            webMessagePort.setWebMessageCallback(ge.f.a(new b(weakReference)));
        }
        d.a();
        postWebMessage(j.a("mini_init", new WebMessagePort[]{webMessagePortArrCreateWebMessageChannel[1]}), Uri.EMPTY);
    }

    @Override // zc.k
    public void registerPageCallback(o oVar) {
        this.f32120a = oVar;
    }

    @Override // zc.k
    public void registerPageEventCallback(p pVar) {
        this.f32121b = pVar;
    }

    @Override // android.webkit.WebView, zc.k
    public void reload() {
        super.reload();
    }

    @Override // zc.k
    public void setAppId(String appId) {
        Intrinsics.g(appId, "appId");
        this.f32124f = appId;
        c cVar = this.f32123d;
        if (!(cVar instanceof ge.d)) {
            cVar = null;
        }
        if (cVar != null) {
            cVar.b(appId);
        }
    }

    @Override // zc.k
    public void setBgColor(String color) {
        Intrinsics.g(color, "color");
        try {
            if (color.length() > 0) {
                setBackgroundColor(Color.parseColor(color));
                this.f32126h = color;
            }
        } catch (Exception e11) {
            TmcLogger.g("SystemWebView", "set content background color error", e11);
        }
    }

    public void setCommonresId(String str) {
        if (str != null) {
            try {
                c cVar = this.f32123d;
                if (cVar != null) {
                    cVar.d(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void setMWebChromeClient(ge.b bVar) {
        this.f32129k = bVar;
    }

    @Override // zc.k
    public void setMiniAppType(int i11) {
        this.f32127i = i11;
    }

    @Override // zc.k
    public void setNode(Node node) {
        Intrinsics.g(node, "node");
        this.f32125g = node;
        c cVar = this.f32123d;
        if (!(cVar instanceof ge.d)) {
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(node);
        }
        this.f32132n.setNode(node);
        this.f32133o.setNode(node);
    }

    public final void setPort0(WebMessagePort webMessagePort) {
        this.f32134p = webMessagePort;
    }

    public void setScrollChangedCallback(m mVar) {
    }

    @Override // zc.k
    public void setSupportFullScreen(boolean z11) {
    }

    public final void setWebviewBridgeHelper(f fVar) {
        Intrinsics.g(fVar, "<set-?>");
        this.f32128j = fVar;
    }
}
