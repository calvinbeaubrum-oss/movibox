package com.cloud.hisavana.sdk;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class j1 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.a f29828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f29829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29830c;

    public j1(j.a admHandlerListener) {
        Intrinsics.g(admHandlerListener, "admHandlerListener");
        this.f29828a = admHandlerListener;
        this.f29829b = "AdmWebClient";
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        z.a().d(this.f29829b, "onPageFinished");
        if (webView == null || webView.getProgress() != 100) {
            return;
        }
        this.f29830c = true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String string;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        int i11 = Build.VERSION.SDK_INT;
        if (this.f29830c || webResourceRequest == null || !webResourceRequest.isForMainFrame()) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        if (url == null || (string = url.toString()) == null) {
            string = "";
        }
        this.f29828a.a(string, (i11 < 23 || webResourceError == null) ? TaErrorCode.CODE_ADM_LOAD_FAILED : webResourceError.getErrorCode());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String string = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString();
        return string != null ? this.f29828a.a(string) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
