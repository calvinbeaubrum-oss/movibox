package zc;

import android.graphics.Bitmap;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface p {
    void onConsoleMessage(String str);

    void onProgressChanged(WebView webView, int i11);

    void onReceivedIcon(Bitmap bitmap);

    void onReceivedTitle(String str);

    void onRequestFocus();
}
