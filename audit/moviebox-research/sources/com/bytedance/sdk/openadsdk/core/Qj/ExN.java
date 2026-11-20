package com.bytedance.sdk.openadsdk.core.Qj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.cD;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.hisavana.common.tracking.TrackingKey;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends com.bytedance.sdk.component.Ol.We implements com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY {
    private uEA ExN;
    private int Ol;
    private String Qj;
    private long Ql;
    private zY TRI;
    private int Tf;
    private pFF UFX;
    private List<String> WH;
    AtomicBoolean We;
    protected boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.model.Sfl f28045qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected boolean f28046sc;
    AtomicBoolean zY;

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void e_();

        View pFF();

        View sc();

        void sc(int i11, int i12);

        void sc(View view, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc extends com.bytedance.sdk.component.Ol.We.sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public static final Set<String> f28051sc = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Qj.ExN.sc.1
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY pFF;

        public sc(com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY interfaceC0285zY) {
            this.pFF = interfaceC0285zY;
        }

        private void sc(String str) {
            int iLastIndexOf;
            com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY interfaceC0285zY;
            if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(InstructionFileId.DOT)) > 0) {
                if (!f28051sc.contains(str.substring(iLastIndexOf).toLowerCase()) || (interfaceC0285zY = this.pFF) == null) {
                    return;
                }
                interfaceC0285zY.pFF(str);
            }
        }

        private void sc(String str, int i11, String str2) {
            com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY interfaceC0285zY = this.pFF;
            if (interfaceC0285zY != null) {
                interfaceC0285zY.sc(106, i11);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY interfaceC0285zY = this.pFF;
            if (interfaceC0285zY != null) {
                interfaceC0285zY.sc();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return;
            }
            sc(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                sc(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            sc(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.pFF.sc(str);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        protected int f28052sc = 0;
        private com.bytedance.sdk.openadsdk.core.Tf.TRI pFF = com.bytedance.sdk.openadsdk.core.Tf.TRI.sc();

        public void pFF() {
            sc();
        }

        public void sc() {
            com.bytedance.sdk.openadsdk.core.Tf.TRI tri;
            int i11 = this.f28052sc;
            if (i11 != 0 && i11 != 4 && (tri = this.pFF) != null) {
                tri.We();
            }
            this.f28052sc = 4;
            this.pFF = null;
        }

        public void sc(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.Tf.TRI tri = this.pFF;
            if (tri != null) {
                tri.sc(view, friendlyObstructionPurpose);
            }
        }

        public void sc(WebView webView) {
            if (webView != null && this.f28052sc == 0) {
                if (this.pFF == null) {
                    this.pFF = com.bytedance.sdk.openadsdk.core.Tf.TRI.sc();
                }
                this.pFF.sc(webView);
                this.pFF.pFF();
                this.f28052sc = 1;
            }
        }

        public void sc(boolean z11) {
            com.bytedance.sdk.openadsdk.core.Tf.TRI tri;
            if (this.f28052sc == 1 && z11 && (tri = this.pFF) != null) {
                tri.zY();
                this.f28052sc = 3;
            }
        }
    }

    public ExN(Context context) {
        super(context);
        this.f28046sc = false;
        this.pFF = false;
        this.zY = new AtomicBoolean(false);
        this.We = new AtomicBoolean(false);
        this.Ol = 0;
    }

    private void Xc() {
        if (this.WH == null) {
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.f28045qr, this.Qj, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.We.zY.sc(new com.bytedance.sdk.component.Qj.Qj("dsp_html_error_url") { // from class: com.bytedance.sdk.openadsdk.core.Qj.ExN.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ExN.this.WH != null && ExN.this.We.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = ExN.this.WH.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.We.zY.pFF(ExN.this.f28045qr, ExN.this.Qj, "dsp_html_error_url", jSONObject);
                            ExN.this.WH = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void BT() {
        pFF pff = this.UFX;
        if (pff != null) {
            pff.e_();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.Ql);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.f28045qr, this.Qj, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.component.Ol.We
    public void Tf() {
        this.TRI.pFF();
        super.Tf();
    }

    public void dE() {
        this.zY.set(false);
        String strVZ = this.f28045qr.VZ();
        if (TextUtils.isEmpty(strVZ)) {
            return;
        }
        String strSc = com.bytedance.sdk.openadsdk.core.Tf.ExN.sc(strVZ);
        String str = TextUtils.isEmpty(strSc) ? strVZ : strSc;
        this.Ol = 0;
        sc(null, str, "text/html", "UTF-8", null);
        this.Ql = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.sdk.component.Ol.We, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f28046sc) {
            this.TRI.sc(getWebView());
        }
    }

    @Override // com.bytedance.sdk.component.Ol.We, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.TRI.sc();
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.Tf / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.f28045qr, this.Qj, "load_rate", jSONObject);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        boolean z11 = i11 == 0;
        this.pFF = z11;
        this.TRI.sc(z11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY
    public void pFF(String str) {
        if (this.WH == null) {
            this.WH = new ArrayList();
        }
        this.WH.add(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY
    public void sc() {
        if (this.zY.compareAndSet(false, true)) {
            this.f28046sc = true;
            this.TRI.sc(getWebView());
            this.TRI.sc(this.pFF);
            BT();
            Xc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY
    public void sc(int i11, int i12) {
        pFF pff = this.UFX;
        if (pff != null) {
            pff.sc(i11, i12);
        }
        this.Ol = i12;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackingKey.ERROR_CODE, i12);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.Ql);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.f28045qr, this.Qj, "render_html_fail", jSONObject);
    }

    public void sc(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.TRI.sc(view, friendlyObstructionPurpose);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, pFF pff, String str) {
        this.UFX = pff;
        this.f28045qr = sfl;
        this.Qj = str;
        this.TRI = new zY();
        this.ExN = new uEA(getContext());
        setWebViewClient(new sc(this));
        setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.core.Qj.ExN.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                ExN.this.Tf = i11;
                super.onProgressChanged(webView, i11);
                if (i11 >= 100) {
                    ExN.this.sc();
                }
            }
        });
        com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.ExN.2
            @Override // java.lang.Runnable
            @SuppressLint({"ClickableViewAccessibility"})
            public void run() {
                WebView webView = ExN.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.Qj.ExN.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ExN.this.ExN.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:46:0x010c  */
    /* JADX WARN: Code duplicated, block: B:47:0x010f  */
    /* JADX WARN: Code duplicated, block: B:51:0x011a  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.Qj.zY.InterfaceC0285zY
    public void sc(String str) {
        String str2;
        boolean zSc;
        String str3;
        uEA uea;
        pFF pff;
        View view;
        int i11;
        if (TextUtils.isEmpty(str) || this.f28045qr == null || !this.ExN.pFF()) {
            return;
        }
        int iSc = cJ.sc(this.Qj);
        View view2 = null;
        if (com.bytedance.sdk.component.utils.BT.sc(str) || !(this.f28045qr.otH() == null || TextUtils.isEmpty(this.f28045qr.otH().sc()))) {
            str2 = str;
        } else {
            com.bytedance.sdk.openadsdk.core.model.UFX ufx = new com.bytedance.sdk.openadsdk.core.model.UFX();
            ufx.sc(str);
            this.f28045qr.sc(ufx);
            str2 = null;
        }
        this.f28045qr.sc(true);
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28045qr;
        if (sfl != null && sfl.otH() != null && !TextUtils.isEmpty(this.f28045qr.otH().sc())) {
            zSc = cD.sc(getContext(), this.f28045qr, iSc, this.Qj, true, (Map<String, Object>) null);
            if (!zSc && !TextUtils.isEmpty(this.f28045qr.otH().pFF())) {
                String strPFF = this.f28045qr.otH().pFF();
                com.bytedance.sdk.openadsdk.We.zY.sc(this.f28045qr, this.Qj, "open_fallback_url", (Map<String, Object>) null);
                str3 = strPFF;
            }
            if (!zSc) {
                if (!TextUtils.isEmpty(str3)) {
                    return;
                } else {
                    cD.sc(getContext(), this.f28045qr, iSc, (PAGNativeAd) null, (PangleAd) null, this.Qj, true, str3);
                }
            }
            if (this.ExN != null) {
                pff = this.UFX;
                if (pff != null) {
                    View viewSc = pff.sc();
                    View viewPFF = this.UFX.pFF();
                    this.UFX.sc(this, 2);
                    view2 = viewPFF;
                    view = viewSc;
                } else {
                    view = null;
                }
                com.bytedance.sdk.openadsdk.core.model.WH whSc = this.ExN.sc(getContext(), view2, view);
                HashMap map = new HashMap();
                map.put("click_scence", 1);
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.f28045qr;
                String str4 = this.Qj;
                if (this.ExN.pFF()) {
                    i11 = 1;
                } else {
                    i11 = 2;
                }
                com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl2, whSc, str4, true, (Map<String, Object>) map, i11);
            }
            uea = this.ExN;
            if (uea != null) {
                uea.sc();
            }
        }
        zSc = false;
        str3 = str2;
        if (!zSc) {
            if (!TextUtils.isEmpty(str3)) {
                return;
            } else {
                cD.sc(getContext(), this.f28045qr, iSc, (PAGNativeAd) null, (PangleAd) null, this.Qj, true, str3);
            }
        }
        if (this.ExN != null) {
            pff = this.UFX;
            if (pff != null) {
                View viewSc2 = pff.sc();
                View viewPFF2 = this.UFX.pFF();
                this.UFX.sc(this, 2);
                view2 = viewPFF2;
                view = viewSc2;
            } else {
                view = null;
            }
            com.bytedance.sdk.openadsdk.core.model.WH whSc2 = this.ExN.sc(getContext(), view2, view);
            HashMap map2 = new HashMap();
            map2.put("click_scence", 1);
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl3 = this.f28045qr;
            String str5 = this.Qj;
            if (this.ExN.pFF()) {
                i11 = 1;
            } else {
                i11 = 2;
            }
            com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl3, whSc2, str5, true, (Map<String, Object>) map2, i11);
        }
        uea = this.ExN;
        if (uea != null) {
            uea.sc();
        }
    }
}
