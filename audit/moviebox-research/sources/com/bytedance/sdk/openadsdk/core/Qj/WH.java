package com.bytedance.sdk.openadsdk.core.Qj;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH extends com.bytedance.sdk.openadsdk.core.widget.sc.ExN {
    private com.bytedance.sdk.component.adexpress.pFF.Ql WH;
    private final com.bytedance.sdk.openadsdk.core.model.Sfl pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public ArrayList<Integer> f28081sc;

    public WH(Context context, HJN hjn, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.openadsdk.We.UFX ufx, com.bytedance.sdk.component.adexpress.pFF.Ql ql2) {
        super(context, hjn, sfl.kDg(), ufx, false);
        this.f28081sc = new ArrayList<>();
        this.pFF = sfl;
        this.WH = ql2;
    }

    private WebResourceResponse ExN(String str) {
        InputStream inputStreamSc;
        if (TextUtils.isEmpty(str) || (inputStreamSc = com.bytedance.sdk.openadsdk.core.We.sc.sc().sc(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse("audio/*", "UTF-8", inputStreamSc);
        sc(webResourceResponse);
        return webResourceResponse;
    }

    private WebResourceResponse We() {
        InputStream inputStreamOpenRawResource;
        int iQr = com.bytedance.sdk.openadsdk.core.Ol.pFF().qr();
        if (iQr == 0) {
            return null;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.Xc.sc().getResources();
        if (resources != null) {
            try {
                inputStreamOpenRawResource = resources.openRawResource(iQr);
            } catch (Resources.NotFoundException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("ExpressClient", e11.toString());
                inputStreamOpenRawResource = null;
            }
        } else {
            inputStreamOpenRawResource = null;
        }
        if (inputStreamOpenRawResource != null) {
            return new WebResourceResponse(com.bytedance.sdk.component.adexpress.We.WH.sc.IMAGE.sc(), "UTF-8", inputStreamOpenRawResource);
        }
        return null;
    }

    private WebResourceResponse sc(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamSc = com.bytedance.sdk.openadsdk.Ol.We.sc(str, str2);
            if (inputStreamSc == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(com.bytedance.sdk.component.adexpress.We.WH.sc.IMAGE.sc(), "utf-8", inputStreamSc);
            try {
                sc(webResourceResponse2);
                return webResourceResponse2;
            } catch (Throwable th2) {
                th = th2;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        com.bytedance.sdk.component.utils.Tf.sc("ExpressClient", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }

    private com.bytedance.sdk.component.adexpress.sc.pFF.sc sc(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.model.BT bt2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("local://pag_open_icon_id") || str.equals(com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.f28096sc)) {
            com.bytedance.sdk.component.adexpress.sc.pFF.sc scVar = new com.bytedance.sdk.component.adexpress.sc.pFF.sc();
            scVar.sc(5);
            scVar.sc(We());
            return scVar;
        }
        com.bytedance.sdk.openadsdk.core.model.Sfl.sc scVarJoC = this.pFF.JoC();
        if (scVarJoC != null && !TextUtils.isEmpty(str) && str.equals(scVarJoC.We())) {
            com.bytedance.sdk.component.adexpress.sc.pFF.sc scVar2 = new com.bytedance.sdk.component.adexpress.sc.pFF.sc();
            scVar2.sc(5);
            WebResourceResponse webResourceResponseExN = ExN(str);
            scVar2.sc(webResourceResponseExN);
            com.bytedance.sdk.openadsdk.core.We.sc.sc().sc(webResourceResponseExN != null);
            return scVar2;
        }
        com.bytedance.sdk.component.adexpress.We.WH.sc scVarSc = com.bytedance.sdk.component.adexpress.We.WH.sc(str);
        if (scVarSc != com.bytedance.sdk.component.adexpress.We.WH.sc.IMAGE) {
            for (com.bytedance.sdk.openadsdk.core.model.BT bt3 : this.pFF.ht()) {
                if (!TextUtils.isEmpty(bt3.sc()) && !TextUtils.isEmpty(str)) {
                    String strSc = bt3.sc();
                    if (strSc.startsWith("https")) {
                        strSc = strSc.replaceFirst("https", HttpHost.DEFAULT_SCHEME_NAME);
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", HttpHost.DEFAULT_SCHEME_NAME) : str).equals(strSc)) {
                        bt2 = bt3;
                        break;
                    }
                }
            }
        }
        if (scVarSc != com.bytedance.sdk.component.adexpress.We.WH.sc.IMAGE && bt2 == null) {
            return com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc(str, scVarSc, "", zY());
        }
        com.bytedance.sdk.component.adexpress.sc.pFF.sc scVar3 = new com.bytedance.sdk.component.adexpress.sc.pFF.sc();
        scVar3.sc(5);
        scVar3.sc(sc(str, com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc(this.pFF, str)));
        return scVar3;
    }

    private void sc(long j11, long j12, String str, int i11) {
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.TRI;
        if (ufx == null || ufx.pFF() == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.We.WH.sc scVarSc = com.bytedance.sdk.component.adexpress.We.WH.sc(str);
        if (scVarSc == com.bytedance.sdk.component.adexpress.We.WH.sc.HTML) {
            this.TRI.pFF().sc(str, j11, j12, i11);
        } else if (scVarSc == com.bytedance.sdk.component.adexpress.We.WH.sc.JS) {
            this.TRI.pFF().pFF(str, j11, j12, i11);
        }
    }

    private void sc(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        webResourceResponse.setResponseHeaders(map);
    }

    private String zY() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.pFF;
        if (sfl == null) {
            return null;
        }
        if (sfl.JoC() != null) {
            return this.pFF.JoC().Ql();
        }
        if (this.pFF.qKn() != null) {
            return "v3";
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f28554qr = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.Qj = false;
        super.onPageStarted(webView, str, bitmap);
    }

    public int sc() {
        for (Integer num : this.f28081sc) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(zY()) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("ExpressClient", "shouldInterceptRequest error1", th2);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.sc.pFF.sc scVarSc = sc(webView, str);
            sc(jCurrentTimeMillis, System.currentTimeMillis(), str, (scVarSc == null || scVarSc.sc() == null) ? 2 : 1);
            if (scVarSc != null && scVarSc.pFF() != 5) {
                scVarSc.pFF();
                this.f28081sc.add(Integer.valueOf(scVarSc.pFF()));
            }
            if (scVarSc != null && scVarSc.sc() != null) {
                return scVarSc.sc();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("ExpressClient", "shouldInterceptRequest error2", th2);
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
