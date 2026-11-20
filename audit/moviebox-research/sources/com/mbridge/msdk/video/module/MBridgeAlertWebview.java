package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.g.a;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.download.d;
import com.mbridge.msdk.videocommon.download.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeAlertWebview extends MBridgeH5EndCardView {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f47788x;

    public MBridgeAlertWebview(Context context) {
        super(context);
    }

    public MBridgeAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final String a() {
        if (TextUtils.isEmpty(this.unitId)) {
            return "";
        }
        b.a().a(c.m().k(), this.unitId, false);
        String str = com.mbridge.msdk.videocommon.d.c.f48481a;
        this.f47788x = str;
        return !TextUtils.isEmpty(str) ? d.a().a(this.f47788x) : "";
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String strA = a();
        if (!this.f47795f || this.f47791b == null || TextUtils.isEmpty(strA)) {
            this.f47794e.a(101, "");
            return;
        }
        a aVar = new a(this.f47791b);
        aVar.a(this.f47791b.getAppName());
        this.f47842q.setDownloadListener(aVar);
        this.f47842q.setCampaignId(this.f47791b.getId());
        setCloseVisible(8);
        this.f47842q.setApiManagerJSFactory(bVar);
        this.f47842q.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.video.module.MBridgeAlertWebview.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i11) {
                String str;
                super.a(webView, i11);
                ad.b("MBridgeAlertWebview", "readyState  :  " + i11);
                MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                if (mBridgeAlertWebview.f47846u) {
                    return;
                }
                boolean z11 = i11 == 1;
                mBridgeAlertWebview.f47845t = z11;
                if (z11) {
                    str = "readyState state is " + i11;
                } else {
                    str = "";
                }
                String str2 = str;
                MBridgeAlertWebview mBridgeAlertWebview2 = MBridgeAlertWebview.this;
                q.a(mBridgeAlertWebview2.f47790a, mBridgeAlertWebview2.f47791b, mBridgeAlertWebview2.f47788x, MBridgeAlertWebview.this.unitId, i11, str2, 1);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i11, String str, String str2) {
                super.a(webView, i11, str, str2);
                ad.b("MBridgeAlertWebview", "onReceivedError");
                if (MBridgeAlertWebview.this.f47846u) {
                    return;
                }
                ad.a(MBridgeBaseView.TAG, "onReceivedError,url:" + str2);
                MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                q.a(mBridgeAlertWebview.f47790a, mBridgeAlertWebview.f47791b, mBridgeAlertWebview.f47788x, MBridgeAlertWebview.this.unitId, 2, str, 1);
                MBridgeAlertWebview.this.f47846u = true;
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                ad.b("MBridgeAlertWebview", "finish+" + str);
                g.a().a(webView);
            }
        });
        setHtmlSource(e.a().b(strA));
        this.f47845t = false;
        if (TextUtils.isEmpty(this.f47844s)) {
            ad.a(MBridgeBaseView.TAG, "load url:" + strA);
            this.f47842q.loadUrl(strA);
        } else {
            ad.a(MBridgeBaseView.TAG, "load html...");
            this.f47842q.loadDataWithBaseURL(strA, this.f47844s, "text/html", "UTF-8", null);
        }
        this.f47842q.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void webviewshow() {
        RelativeLayout relativeLayout = this.f47840o;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(0);
        }
        super.webviewshow();
        q.a(this.f47790a, this.f47791b, this.f47788x, this.unitId, 2, 1);
    }
}
