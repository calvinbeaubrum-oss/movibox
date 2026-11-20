package com.bytedance.sdk.openadsdk.core.widget.sc;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.WH;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.utils.YIK;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends com.bytedance.sdk.component.Ol.We.sc {
    private static final HashSet<String> YIK;
    private final Stack<String> BT;
    protected final String ExN;
    protected boolean Ol;
    protected boolean Qj;
    private com.bytedance.sdk.openadsdk.common.We Ql;
    private String SR;
    private Sfl Sfl;
    protected UFX TRI;
    private boolean Tf;
    private Map<String, Object> UFX;
    private WH WH;
    protected final Context We;
    private TTCeilingLandingPageActivity.sc Xc;
    private boolean dE;
    private String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected boolean f28554qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final boolean f28555sc;
    private JSONObject wjp;
    protected final HJN zY;

    static {
        HashSet<String> hashSet = new HashSet<>();
        YIK = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    public ExN(Context context, HJN hjn, String str, UFX ufx, boolean z11) {
        this.f28554qr = true;
        this.Qj = true;
        this.Ol = false;
        this.We = context;
        this.zY = hjn;
        this.ExN = str;
        this.TRI = ufx;
        this.f28555sc = z11;
        this.BT = new Stack<>();
    }

    public ExN(Context context, HJN hjn, String str, com.bytedance.sdk.openadsdk.common.We we2, UFX ufx, boolean z11) {
        this(context, hjn, str, ufx, z11);
        this.Ql = we2;
    }

    public ExN(Context context, HJN hjn, String str, com.bytedance.sdk.openadsdk.common.We we2, UFX ufx, boolean z11, boolean z12, TTCeilingLandingPageActivity.sc scVar) {
        this(context, hjn, str, we2, ufx, z11);
        this.dE = z12;
        this.Xc = scVar;
    }

    private boolean ExN(String str) {
        if (Xc.Qj(this.Sfl)) {
            return TextUtils.equals(this.Sfl.HBq(), str);
        }
        return false;
    }

    public static String We(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !YIK.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/".concat(strSubstring);
    }

    private void sc(String str, String str2) {
        if ((ExN(str) || "market".equals(str)) && ((this.WH != null || this.wjp != null) && pFF(str2))) {
            pFF();
        }
        this.WH = null;
        this.wjp = null;
    }

    private boolean sc(WebView webView, String str) {
        if (!cJ.We(this.Sfl) || this.Sfl.UFX() == null || webView == null) {
            return false;
        }
        int iPFF = this.Sfl.UFX().pFF();
        int size = this.BT.size();
        if (this.dE) {
            size++;
        }
        if (size + 1 != iPFF) {
            return false;
        }
        YIK.sc(this.We, str, this.Sfl, com.bytedance.sdk.openadsdk.We.pFF.sc.We);
        TTCeilingLandingPageActivity.sc scVar = this.Xc;
        if (scVar != null) {
            scVar.sc();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        UFX ufx = this.TRI;
        if (ufx != null) {
            ufx.sc(webView, str, this.f28555sc);
        }
        com.bytedance.sdk.openadsdk.common.We we2 = this.Ql;
        if (we2 != null) {
            we2.pFF(webView, str, this.f28555sc);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Sfl sfl;
        super.onPageStarted(webView, str, bitmap);
        Sfl sfl2 = this.Sfl;
        int iSc = (sfl2 != null && sfl2.yL() && com.bytedance.sdk.openadsdk.YIK.sc.sc("opt_web_index", false)) ? cJ.sc(webView) : -1;
        UFX ufx = this.TRI;
        if (ufx != null) {
            ufx.sc(webView, str, bitmap, this.f28555sc, iSc);
        }
        com.bytedance.sdk.openadsdk.common.We we2 = this.Ql;
        if (we2 != null) {
            we2.zY(webView, str, this.f28555sc);
        }
        if (this.f28555sc && (sfl = this.Sfl) != null && sfl.yL() && this.Sfl.UFX().pFF() >= 2) {
            if (!TextUtils.isEmpty(str) && !str.equals(this.SR)) {
                if (this.BT.contains(str)) {
                    while (!str.equals(this.BT.peek())) {
                        this.BT.pop();
                    }
                } else {
                    this.BT.push(str);
                }
            }
            this.SR = str;
        }
        if (!this.Qj || this.Ol) {
            return;
        }
        this.Ol = true;
        zY.sc(this.We).sc(true).pFF(webView.getSettings().getBuiltInZoomControls()).sc(webView);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        if (Build.VERSION.SDK_INT < 23 && this.TRI != null) {
            this.TRI.sc(webView, i11, str, str2, We(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT < 23 || this.TRI == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        String str = requestHeaders.containsKey("accept") ? requestHeaders.get("accept") : "";
        this.TRI.sc(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str, webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.TRI == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        String str = requestHeaders.containsKey("accept") ? requestHeaders.get("accept") : "";
        this.TRI.sc(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str, webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.TRI != null) {
            int primaryError = 0;
            String strConcat = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    strConcat = "SslError: ".concat(String.valueOf(sslError));
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str = url;
            this.TRI.sc(webView, primaryError, strConcat, str, We(str), true);
        }
    }

    @Override // com.bytedance.sdk.component.Ol.We.sc, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            com.bytedance.sdk.component.adexpress.ExN.ExN.sc().pFF();
        } catch (Exception unused) {
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void pFF() {
        if (TextUtils.isEmpty(this.pFF) || !Xc.qr(this.Sfl) || this.Tf) {
            return;
        }
        WH wh2 = this.WH;
        if (wh2 != null) {
            com.bytedance.sdk.openadsdk.We.zY.sc("click", this.Sfl, wh2, this.pFF, true, this.UFX, 1);
            this.Tf = true;
            return;
        }
        JSONObject jSONObject = this.wjp;
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.We.zY.sc(this.Sfl, this.pFF, "click", jSONObject);
            this.Tf = true;
        }
    }

    public boolean pFF(String str) {
        String strZY;
        String strSc;
        if (this.We == null) {
            return false;
        }
        Sfl sfl = this.Sfl;
        if (sfl == null || sfl.NP() == null) {
            strZY = "";
            strSc = "";
        } else {
            strZY = this.Sfl.NP().zY();
            strSc = this.Sfl.NP().sc();
        }
        if (!com.bytedance.sdk.openadsdk.wjp.sc.sc.zY.sc()) {
            return com.bytedance.sdk.openadsdk.wjp.sc.sc.sc.sc(str, this.We, this.pFF, this.Sfl, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.wjp.sc.sc.sc.sc(this.Sfl, strZY, this.We, this.pFF, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.wjp.sc.sc.We.sc(this.We, strSc, strZY, this.pFF, this.Sfl);
        }
        Context context = this.We;
        Sfl sfl2 = this.Sfl;
        return com.bytedance.sdk.openadsdk.wjp.sc.sc.zY.sc(context, str, sfl2, cJ.pFF(sfl2), null, true) || com.bytedance.sdk.openadsdk.wjp.sc.sc.ExN.sc(this.Sfl, strZY, this.We, this.pFF, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.wjp.sc.sc.ExN.sc(this.We, strSc, strZY, this.pFF, this.Sfl);
    }

    public void sc(Sfl sfl) {
        this.Sfl = sfl;
    }

    public void sc(WH wh2) {
        this.WH = wh2;
    }

    public void sc(String str) {
        this.pFF = str;
    }

    public void sc(Map<String, Object> map) {
        this.UFX = map;
    }

    public void sc(JSONObject jSONObject) {
        this.wjp = jSONObject;
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        UFX ufx = this.TRI;
        if (ufx != null) {
            ufx.pFF(webView, str, this.f28555sc);
        }
        com.bytedance.sdk.openadsdk.common.We we2 = this.Ql;
        if (we2 != null) {
            we2.sc(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        UFX ufx = this.TRI;
        if (ufx != null) {
            ufx.sc(str, this.f28555sc);
        }
        com.bytedance.sdk.openadsdk.common.We we2 = this.Ql;
        if (we2 != null) {
            we2.sc(webView, str, this.f28555sc);
        }
        if (sc(webView, str)) {
            return true;
        }
        try {
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                com.bytedance.sdk.openadsdk.utils.Xc.sc(uri, this.zY);
                return true;
            }
            if (zY(str)) {
                return true;
            }
            if (!BT.sc(str)) {
                if (Xc.Qj(this.Sfl)) {
                    sc(lowerCase, str);
                    return true;
                }
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    intent.addFlags(ASTNode.DEOP);
                    com.bytedance.sdk.component.utils.pFF.sc(this.We, intent, null);
                } catch (Throwable unused) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Throwable unused2) {
            HJN hjn = this.zY;
            if (hjn != null && hjn.We()) {
                return true;
            }
        }
    }

    public boolean zY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if ("play.google.com".equals(uri.getHost())) {
                if (Xc.Qj(this.Sfl) && this.wjp == null && this.WH == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.We instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                intent.setData(uri);
                intent.setPackage("com.android.vending");
                this.We.startActivity(intent);
                pFF();
                this.wjp = null;
                this.WH = null;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
