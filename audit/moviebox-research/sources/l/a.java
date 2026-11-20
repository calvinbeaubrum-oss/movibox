package l;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zc.p f69720a;

    public a(Context context, zc.p pVar) {
        Intrinsics.g(context, "context");
        this.f69720a = pVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i11) {
        super.onProgressChanged(webView, i11);
        zc.p pVar = this.f69720a;
        if (pVar != null) {
            pVar.onProgressChanged(webView, i11);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        zc.p pVar = this.f69720a;
        if (pVar != null) {
            pVar.onReceivedIcon(bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        zc.p pVar = this.f69720a;
        if (pVar != null) {
            pVar.onReceivedTitle(str);
        }
    }
}
