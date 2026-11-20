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
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.render.IPageChainCallback;
import com.cloud.tmc.render.method.ByteH5BridgeJsInterface;
import com.cloud.tmc.render.method.LocalChannelInterface;
import com.cloud.tmc.render.method.MonitorLoadingInterface;
import com.cloud.tmc.render.method.ShellGameJsInterface;
import com.cloud.tmc.render.utils.FullScreenJSI;
import com.cloud.tmc.render.utils.WebViewExtensionKt;
import com.transsion.push.PushConstants;
import fe.d;
import fe.f;
import ge.c;
import ge.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc.j;
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
public final class ShellWebView extends WebView implements k, yc.a, IPageChainCallback {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f32102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f32103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zc.a f32104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f32105d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Node f32107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f32108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f32110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ge.b f32111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ByteH5BridgeJsInterface f32112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f32113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FullScreenJSI f32114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LocalChannelInterface f32115o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f32116p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f32117q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WebMessagePort f32118r;

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
        public final /* synthetic */ WeakReference<p> f32119a;

        public b(WeakReference<p> weakReference) {
            this.f32119a = weakReference;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort port, WebMessage message) {
            Intrinsics.g(port, "port");
            Intrinsics.g(message, "message");
            p pVar = this.f32119a.get();
            if (pVar != null) {
                pVar.onConsoleMessage(message.getData());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ShellWebView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShellWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f32109i = MiniAppType.SHELL.getType();
        this.f32110j = new f(this);
        this.f32112l = new ByteH5BridgeJsInterface();
        this.f32114n = new FullScreenJSI();
        this.f32115o = new LocalChannelInterface(this);
    }

    public /* synthetic */ ShellWebView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    @Override // zc.k
    @SuppressLint({"JavascriptInterface"})
    public void create() {
        String str;
        Node node;
        p pVar = this.f32103b;
        o oVar = this.f32102a;
        String str2 = this.f32106f;
        if (str2 == null) {
            Intrinsics.y(PushConstants.PROVIDER_FIELD_APP_ID);
            str = null;
        } else {
            str = str2;
        }
        Node node2 = this.f32107g;
        if (node2 == null) {
            Intrinsics.y("node");
            node = null;
        } else {
            node = node2;
        }
        c cVar = new c(pVar, oVar, str, node, this);
        this.f32105d = cVar;
        setWebViewClient(cVar);
        Context context = getContext();
        Intrinsics.f(context, "context");
        l lVar = new l(context, this.f32103b, this.f32110j, this.f32104c);
        this.f32111k = lVar;
        setWebChromeClient(lVar);
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        this.f32112l.setWebviewPageEventCallback(this.f32103b);
        addJavascriptInterface("", "");
        addJavascriptInterface(new ShellGameJsInterface(), "dltms");
        addJavascriptInterface(this.f32115o, "dltLocalChannel");
        addJavascriptInterface(new MonitorLoadingInterface(), "dltMonitor");
        addJavascriptInterface(this.f32112l, "dlth5bridge");
        WebViewExtensionKt.c(this, this.f32114n);
    }

    @Override // android.webkit.WebView, zc.k
    public void destroy() {
        WebMessagePort webMessagePort;
        clearHistory();
        this.f32115o.clear();
        this.f32112l.clear();
        c cVar = this.f32105d;
        if (cVar != null) {
            cVar.c();
        }
        this.f32105d = null;
        ge.b bVar = this.f32111k;
        if (bVar != null) {
            bVar.a();
        }
        this.f32111k = null;
        this.f32102a = null;
        this.f32103b = null;
        this.f32104c = null;
        if (Build.VERSION.SDK_INT >= 23 && (webMessagePort = this.f32118r) != null) {
            webMessagePort.close();
        }
        try {
            if (((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("enableShellDestory", false)) {
                super.destroy();
                TmcLogger.c("ShellWebView", "shellWebView Destory");
            }
        } catch (Throwable th2) {
            TmcLogger.g("ShellWebView", PushConstants.PROVIDER_FIELD_DESTROY, th2);
        }
    }

    public final ByteH5BridgeJsInterface getByteH5BridgeJsInterface() {
        return this.f32112l;
    }

    public final ge.b getMWebChromeClient() {
        return this.f32111k;
    }

    @Override // zc.k
    public int getMiniAppType() {
        return this.f32109i;
    }

    public final WebMessagePort getPort0() {
        return this.f32118r;
    }

    @Override // zc.k
    public ac.a getRenderBridge() {
        return this.f32110j.a(this);
    }

    public final f getWebviewBridgeHelper() {
        return this.f32110j;
    }

    @Override // android.webkit.WebView, zc.k
    public void goBack() {
        super.goBack();
    }

    public final boolean isLoadDataWithBaseURL() {
        return this.f32117q;
    }

    public final boolean isOffScreenRender() {
        return this.f32116p;
    }

    @Override // yc.a
    public Boolean isRenderProcessGone() {
        return Boolean.valueOf(this.f32113m);
    }

    public /* bridge */ /* synthetic */ boolean isResume() {
        return j.a(this);
    }

    @Override // zc.k
    public void load(String url) {
        Intrinsics.g(url, "url");
        load(url, new HashMap<>());
    }

    @Override // zc.k
    public void load(String url, HashMap<String, String> additionalHttpHeaders) {
        Intrinsics.g(url, "url");
        Intrinsics.g(additionalHttpHeaders, "additionalHttpHeaders");
        TmcLogger.c("ShellWebView", "[Render]:[load Url]: " + url);
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
                TmcLogger.f("ShellWebView", "onCheckIsTextEditor() does not run in the main thread");
            }
        } catch (Throwable th2) {
            TmcLogger.g("ShellWebView", "Probable deadlock detected due to WebView API being called on incorrect thread while the UI thread is blocked.", th2);
        }
        return zOnCheckIsTextEditor;
    }

    @Override // com.cloud.tmc.render.IPageChainCallback
    public void onConsoleMessage(String params) {
        Intrinsics.g(params, "params");
        p pVar = this.f32103b;
        if (pVar != null) {
            pVar.onConsoleMessage(params);
        }
    }

    @Override // com.cloud.tmc.render.IPageChainCallback
    public void onPageFinished(String params) {
        Intrinsics.g(params, "params");
        try {
            if (this.f32107g == null) {
                Intrinsics.y("node");
            }
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
            Node node = this.f32107g;
            if (node == null) {
                Intrinsics.y("node");
                node = null;
            }
            uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(node);
            if (eventCenterInstance != null) {
                fc.a aVar = new fc.a("h5OnPageFinished");
                aVar.c(r.f(TuplesKt.a("params", params)));
                Unit unit = Unit.f68710a;
                eventCenterInstance.d("h5OnPageFinished", aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, zc.k
    public void onPause() {
        super.onPause();
    }

    @Override // yc.a
    public void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f32113m = true;
        ((IOnRenderProcessGoneProxy) tc.a.a(IOnRenderProcessGoneProxy.class)).received(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebView, zc.k
    public void onResume() {
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
    }

    @Override // zc.k
    public void registerCustomViewVisiableCallback(zc.a aVar) {
        this.f32104c = aVar;
    }

    @Override // zc.k
    @RequiresApi(23)
    public void registerMessageChannel() {
        WeakReference weakReference = new WeakReference(this.f32103b);
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = createWebMessageChannel();
        Intrinsics.f(webMessagePortArrCreateWebMessageChannel, "this.createWebMessageChannel()");
        WebMessagePort webMessagePort = webMessagePortArrCreateWebMessageChannel[0];
        this.f32118r = webMessagePort;
        if (webMessagePort != null) {
            webMessagePort.setWebMessageCallback(ge.f.a(new b(weakReference)));
        }
        d.a();
        postWebMessage(ge.j.a("mini_init", new WebMessagePort[]{webMessagePortArrCreateWebMessageChannel[1]}), Uri.EMPTY);
    }

    @Override // zc.k
    public void registerPageCallback(o oVar) {
        this.f32102a = oVar;
    }

    @Override // zc.k
    public void registerPageEventCallback(p pVar) {
        this.f32103b = pVar;
    }

    @Override // android.webkit.WebView, zc.k
    public void reload() {
        super.reload();
    }

    @Override // zc.k
    public void setAppId(String appId) {
        Intrinsics.g(appId, "appId");
        this.f32106f = appId;
        c cVar = this.f32105d;
        if (!(cVar instanceof ge.d)) {
            cVar = null;
        }
        if (cVar != null) {
            cVar.b(appId);
        }
        this.f32115o.setAppId(appId);
    }

    @Override // zc.k
    public void setBgColor(String color) {
        Intrinsics.g(color, "color");
        try {
            if (color.length() > 0) {
                setBackgroundColor(Color.parseColor(color));
                this.f32108h = color;
            }
        } catch (Exception e11) {
            TmcLogger.g("ShellWebView", "set content background color error", e11);
        }
    }

    public final void setByteH5BridgeJsInterface(ByteH5BridgeJsInterface byteH5BridgeJsInterface) {
        Intrinsics.g(byteH5BridgeJsInterface, "<set-?>");
        this.f32112l = byteH5BridgeJsInterface;
    }

    public void setCommonresId(String str) {
        if (str != null) {
            try {
                c cVar = this.f32105d;
                if (cVar != null) {
                    cVar.d(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void setLoadDataWithBaseURL(boolean z11) {
        this.f32117q = z11;
    }

    public final void setMWebChromeClient(ge.b bVar) {
        this.f32111k = bVar;
    }

    @Override // zc.k
    public void setMiniAppType(int i11) {
        this.f32109i = i11;
    }

    @Override // zc.k
    public void setNode(Node node) {
        Intrinsics.g(node, "node");
        this.f32107g = node;
        c cVar = this.f32105d;
        if (!(cVar instanceof ge.d)) {
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(node);
        }
        this.f32114n.setNode(node);
    }

    public final void setOffScreenRender(boolean z11) {
        this.f32116p = z11;
    }

    public final void setPort0(WebMessagePort webMessagePort) {
        this.f32118r = webMessagePort;
    }

    public void setScrollChangedCallback(m mVar) {
    }

    @Override // zc.k
    public void setSupportFullScreen(boolean z11) {
        if (z11) {
            return;
        }
        Context context = getContext();
        Intrinsics.f(context, "context");
        ge.b bVar = new ge.b(context, this.f32103b, this.f32110j);
        this.f32111k = bVar;
        setWebChromeClient(bVar);
    }

    public final void setWebviewBridgeHelper(f fVar) {
        Intrinsics.g(fVar, "<set-?>");
        this.f32110j = fVar;
    }
}
