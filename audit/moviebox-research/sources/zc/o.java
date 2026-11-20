package zc;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface o {
    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str);

    void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);
}
