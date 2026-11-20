package ge;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class c extends WebViewClient implements d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f65484h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f65485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f65486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f65487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Node f65488d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yc.a f65489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f65490g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(p pVar, o oVar, String appId, Node node, yc.a renderProcessListener) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(node, "node");
        Intrinsics.g(renderProcessListener, "renderProcessListener");
        this.f65485a = pVar;
        this.f65486b = oVar;
        this.f65487c = appId;
        this.f65488d = node;
        this.f65489f = renderProcessListener;
        this.f65490g = "";
    }

    @Override // ge.d
    public void a(Node node) {
        Intrinsics.g(node, "node");
        this.f65488d = node;
    }

    @Override // ge.d
    public void b(String id2) {
        Intrinsics.g(id2, "id");
        this.f65487c = id2;
    }

    public final void c() {
        this.f65485a = null;
        this.f65486b = null;
    }

    public final void d(String id2) {
        Intrinsics.g(id2, "id");
        this.f65490g = id2;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f65487c, RenderAnalyseType.LOAD_FINISH, webView != null ? webView.getUrl() : null);
        o oVar = this.f65486b;
        if (oVar != null) {
            oVar.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f65487c, RenderAnalyseType.LOAD_URL, webView != null ? webView.getUrl() : null);
        o oVar = this.f65486b;
        if (oVar != null) {
            oVar.onPageStarted(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f65487c, RenderAnalyseType.ERROR, "[onReceivedError]:" + str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        o oVar = this.f65486b;
        if (oVar != null) {
            oVar.onReceivedError(webView, webResourceRequest, webResourceError);
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str = this.f65487c;
        RenderAnalyseType renderAnalyseType = RenderAnalyseType.ERROR;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[onReceivedError]:");
        sb2.append((Object) (webResourceError != null ? webResourceError.getDescription() : null));
        performanceAnalyseProxy.record(str, renderAnalyseType, sb2.toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        o oVar = this.f65486b;
        if (oVar != null) {
            oVar.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f65487c, RenderAnalyseType.ERROR, "[onReceivedHttpError]:" + webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f65487c, RenderAnalyseType.ERROR, "[onReceivedSslError]:" + sslError);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f65489f.onRenderProcessGone(webView, renderProcessGoneDetail);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request.url:");
        sb2.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        TmcLogger.f("juggit", sb2.toString());
        IResourceProcessor iResourceProcessor = (IResourceProcessor) tc.a.a(IResourceProcessor.class);
        WebResourceResponse webResourceResponse = this.f65490g.length() > 0 ? iResourceProcessor.get(webResourceRequest, this.f65487c, this.f65490g, this.f65488d) : iResourceProcessor.get(webResourceRequest, this.f65487c, this.f65488d);
        return webResourceResponse == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            try {
                Uri url = webResourceRequest.getUrl();
                if (url != null && Intrinsics.b(url.getScheme(), "bytebridge")) {
                    String strDecode = URLDecoder.decode(url.toString(), "utf-8");
                    Intrinsics.f(strDecode, "decode(it.toString(), \"utf-8\")");
                    String strF = kotlin.text.l.F(strDecode, "bytebridge://", "", false, 4, null);
                    TmcLogger.f("miniapp", "renderSendToNative shouldOverrideUrlLoadingBridge!!");
                    p pVar = this.f65485a;
                    if (pVar != null) {
                        pVar.onConsoleMessage(strF);
                    }
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.e("renderSendToNative shouldOverrideUrlLoadingBridge fail!:" + th2);
            }
        }
        o oVar = this.f65486b;
        if (oVar == null || !Intrinsics.b(oVar.shouldOverrideUrlLoading(webView, webResourceRequest), Boolean.TRUE)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return true;
    }
}
