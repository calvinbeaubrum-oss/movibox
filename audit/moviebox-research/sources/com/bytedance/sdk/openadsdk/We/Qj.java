package com.bytedance.sdk.openadsdk.We;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    private final boolean ExN;
    private final WebView Qj;
    private int TRI;
    private long WH;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27323qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Sfl f27324sc;
    private String Ol = "landingpage";
    private final Map<Integer, Long> pFF = new HashMap();
    private final List<Integer> zY = new ArrayList();
    private final Map<Integer, String> We = new HashMap();

    public Qj(Sfl sfl, WebView webView, boolean z11) {
        this.f27324sc = sfl;
        this.Qj = webView;
        this.ExN = z11;
    }

    private void pFF(boolean z11) {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = this.Qj.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                if (z11) {
                    int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                    this.TRI = currentIndex + 1;
                    if (this.ExN) {
                        this.TRI = currentIndex + 2;
                        return;
                    }
                    return;
                }
                int currentIndex2 = webBackForwardListCopyBackForwardList.getCurrentIndex();
                this.f27323qr = currentIndex2 + 1;
                if (this.ExN) {
                    this.f27323qr = currentIndex2 + 2;
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("ArbitrageLandingLog", th2.toString());
        }
    }

    private boolean sc(boolean z11) {
        int i11 = z11 ? this.TRI : this.f27323qr;
        pFF(z11);
        int i12 = z11 ? this.TRI : this.f27323qr;
        return i12 > 0 && i12 != i11;
    }

    public void pFF(String str) {
        String str2 = this.We.get(Integer.valueOf(this.TRI));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String str3 = str2;
        int i11 = this.TRI;
        if (i11 > 0) {
            zY.sc(this.f27324sc, this.Ol, i11, str3, str, 1);
        }
    }

    public void sc(WebView webView, String str) {
        Sfl sfl = this.f27324sc;
        if (sfl == null || !com.bytedance.sdk.component.Ol.pFF.sc(sfl.UFX().zY(), str)) {
            return;
        }
        String str2 = this.We.get(Integer.valueOf(this.TRI));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        zY.sc(this.f27324sc, this.Ol, this.TRI, str2, str, 2);
    }

    public void sc(String str) {
        if (sc(false)) {
            zY.sc(this.f27324sc, this.Ol, this.TRI, str, SystemClock.elapsedRealtime() - this.WH);
        }
    }

    public void sc(String str, int i11) {
        if (this.ExN) {
            i11++;
        }
        if (sc(true)) {
            zY.sc(this.f27324sc, this.Ol, this.TRI, str, i11);
            this.We.put(Integer.valueOf(this.TRI), str);
            this.WH = SystemClock.elapsedRealtime();
        }
    }

    public void zY(String str) {
        this.Ol = str;
    }
}
