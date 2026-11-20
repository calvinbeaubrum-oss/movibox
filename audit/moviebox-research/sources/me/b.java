package me;

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
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Node f70997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yc.a f70998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f70999d;

    public b(String str, Node node, yc.a renderProcessListener) {
        Intrinsics.g(renderProcessListener, "renderProcessListener");
        this.f70996a = str;
        this.f70997b = node;
        this.f70998c = renderProcessListener;
        this.f70999d = "";
    }

    public final void a(String id2) {
        Intrinsics.g(id2, "id");
        this.f70999d = id2;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f70998c.onRenderProcessGone(webView, renderProcessGoneDetail);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String string = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString();
        if (string == null || string.length() == 0 || !StringsKt__StringsKt.Q(string, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        IResourceProcessor iResourceProcessor = (IResourceProcessor) tc.a.a(IResourceProcessor.class);
        String str = this.f70999d;
        WebResourceResponse webResourceResponse = (str == null || str.length() <= 0) ? iResourceProcessor.get(webResourceRequest, this.f70996a, this.f70997b) : iResourceProcessor.get(webResourceRequest, this.f70996a, this.f70999d, this.f70997b);
        return webResourceResponse == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
