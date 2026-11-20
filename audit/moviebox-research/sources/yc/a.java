package yc;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    Boolean isRenderProcessGone();

    void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);
}
