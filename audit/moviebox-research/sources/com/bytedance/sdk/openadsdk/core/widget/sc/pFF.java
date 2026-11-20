package com.bytedance.sdk.openadsdk.core.widget.sc;

import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.Xc;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements sc {
    private final boolean ExN;
    private final MessageQueue We;
    private com.bytedance.sdk.component.Ol.We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    HJN f28563sc;
    private final AtomicInteger zY;

    public pFF(int i11, boolean z11, MessageQueue messageQueue) {
        this.zY = new AtomicInteger(i11);
        this.ExN = z11;
        this.We = messageQueue;
    }

    private void sc(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null || we2.getWebView() == null) {
            return;
        }
        try {
            zY.sc(Xc.sc()).sc(false).sc(we2.getWebView());
            we2.setVerticalScrollBarEnabled(false);
            we2.setHorizontalScrollBarEnabled(false);
            zY.sc(we2);
            we2.WH();
            we2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we2.getWebView(), BuildConfig.VERSION_CODE));
            we2.setMixedContentMode(0);
            we2.setJavaScriptEnabled(true);
            we2.setJavaScriptCanOpenWindowsAutomatically(true);
            we2.setDomStorageEnabled(true);
            we2.setDatabaseEnabled(true);
            we2.setCacheMode(-1);
            we2.setAllowFileAccess(false);
            we2.setSupportZoom(true);
            we2.setBuiltInZoomControls(true);
            we2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            we2.setUseWideViewPort(true);
        } catch (Throwable th2) {
            Tf.sc("WebViewPool", th2.toString());
        }
    }

    public void pFF() {
        if (this.zY.get() <= 0) {
            return;
        }
        Objects.toString(this.zY);
        String strWe = com.bytedance.sdk.component.adexpress.sc.pFF.pFF.We(null);
        if (this.ExN) {
            String strWe2 = com.bytedance.sdk.component.adexpress.sc.pFF.pFF.We("v3");
            if (strWe != null && strWe.equals(strWe2)) {
                return;
            } else {
                strWe = strWe2;
            }
        }
        if (TextUtils.isEmpty(strWe)) {
            return;
        }
        try {
            com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(new MutableContextWrapper(Xc.sc()));
            this.pFF = we2;
            if (we2.getWebView() == null) {
                return;
            }
            this.pFF.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.widget.sc.pFF.1
                @Override // android.webkit.WebViewClient
                public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                    return true;
                }
            });
            sc(this.pFF);
            Uri uriBuild = Uri.parse(strWe).buildUpon().appendQueryParameter("isPreLoad", "1").build();
            HJN hjn = new HJN(this.pFF.getContext());
            this.f28563sc = hjn;
            hjn.pFF(this.pFF).sc(this).sc(this.pFF);
            com.bytedance.sdk.component.adexpress.ExN.ExN.sc().sc(this.pFF, this.f28563sc);
            this.pFF.a_(uriBuild.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.sc
    public void sc() {
        MessageQueue messageQueue;
        if (this.ExN) {
            com.bytedance.sdk.component.adexpress.ExN.ExN.sc().pFF(this.pFF);
        } else {
            com.bytedance.sdk.component.adexpress.ExN.ExN.sc().zY(this.pFF);
        }
        try {
            this.zY.get();
            this.zY.decrementAndGet();
            if (this.zY.get() <= 0 || (messageQueue = this.We) == null) {
                return;
            }
            messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.widget.sc.pFF.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    new pFF(pFF.this.zY.get(), pFF.this.ExN, pFF.this.We).pFF();
                    return false;
                }
            });
        } catch (Exception e11) {
            e11.getMessage();
        }
    }
}
