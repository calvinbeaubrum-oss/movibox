package com.vungle.warren.ui.view;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.m;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class VungleWebClient extends WebViewClient implements h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f62510p = "VungleWebClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f62511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.vungle.warren.model.c f62512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f62513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h.a f62514d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebView f62516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f62517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f62518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f62519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f62520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f62521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f62522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h.b f62523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public com.vungle.warren.omsdk.b f62524o;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a extends WebViewRenderProcessClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h.b f62525a;

        public a(h.b bVar) {
            this.f62525a = bVar;
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            String str = VungleWebClient.f62510p;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRenderProcessUnresponsive(Title = ");
            sb2.append(webView.getTitle());
            sb2.append(", URL = ");
            sb2.append(webView.getOriginalUrl());
            sb2.append(", (webViewRenderProcess != null) = ");
            sb2.append(webViewRenderProcess != null);
            Log.w(str, sb2.toString());
            h.b bVar = this.f62525a;
            if (bVar != null) {
                bVar.t(webView, webViewRenderProcess);
            }
        }
    }

    public VungleWebClient(com.vungle.warren.model.c cVar, m mVar, ExecutorService executorService) {
        this.f62512b = cVar;
        this.f62513c = mVar;
        this.f62511a = executorService;
    }

    @Override // com.vungle.warren.ui.view.h
    public void a(boolean z11) {
        this.f62522m = Boolean.valueOf(z11);
        c(false);
    }

    @Override // com.vungle.warren.ui.view.h
    public void b(h.b bVar) {
        this.f62523n = bVar;
    }

    @Override // com.vungle.warren.ui.view.h
    public void c(boolean z11) {
        if (this.f62516g != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("width", Integer.valueOf(this.f62516g.getWidth()));
            jsonObject2.addProperty("height", Integer.valueOf(this.f62516g.getHeight()));
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("x", (Number) 0);
            jsonObject3.addProperty("y", (Number) 0);
            jsonObject3.addProperty("width", Integer.valueOf(this.f62516g.getWidth()));
            jsonObject3.addProperty("height", Integer.valueOf(this.f62516g.getHeight()));
            JsonObject jsonObject4 = new JsonObject();
            Boolean bool = Boolean.FALSE;
            jsonObject4.addProperty("sms", bool);
            jsonObject4.addProperty("tel", bool);
            jsonObject4.addProperty("calendar", bool);
            jsonObject4.addProperty("storePicture", bool);
            jsonObject4.addProperty("inlineVideo", bool);
            jsonObject.add("maxSize", jsonObject2);
            jsonObject.add("screenSize", jsonObject2);
            jsonObject.add("defaultPosition", jsonObject3);
            jsonObject.add("currentPosition", jsonObject3);
            jsonObject.add("supports", jsonObject4);
            jsonObject.addProperty("placementType", this.f62512b.F());
            Boolean bool2 = this.f62522m;
            if (bool2 != null) {
                jsonObject.addProperty("isViewable", bool2);
            }
            jsonObject.addProperty("os", "android");
            jsonObject.addProperty("osVersion", Integer.toString(Build.VERSION.SDK_INT));
            jsonObject.addProperty("incentivized", Boolean.valueOf(this.f62513c.k()));
            jsonObject.addProperty("enableBackImmediately", Boolean.valueOf(this.f62512b.C(this.f62513c.k()) == 0));
            jsonObject.addProperty("version", "1.0");
            if (this.f62515f) {
                jsonObject.addProperty("consentRequired", Boolean.TRUE);
                jsonObject.addProperty("consentTitleText", this.f62518i);
                jsonObject.addProperty("consentBodyText", this.f62519j);
                jsonObject.addProperty("consentAcceptButtonText", this.f62520k);
                jsonObject.addProperty("consentDenyButtonText", this.f62521l);
            } else {
                jsonObject.addProperty("consentRequired", bool);
            }
            jsonObject.addProperty(PushConstants.PROVIDER_FIELD_SDK_VERSION, "6.12.1");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadJsjavascript:window.vungle.mraidBridge.notifyPropertiesChange(");
            sb2.append(jsonObject);
            sb2.append(",");
            sb2.append(z11);
            sb2.append(")");
            k(this.f62516g, "window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z11 + ")");
        }
    }

    @Override // com.vungle.warren.ui.view.h
    public void d(h.a aVar) {
        this.f62514d = aVar;
    }

    @Override // com.vungle.warren.ui.view.h
    public void e(com.vungle.warren.omsdk.b bVar) {
        this.f62524o = bVar;
    }

    @Override // com.vungle.warren.ui.view.h
    public void f(boolean z11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.f62515f = z11;
        this.f62518i = str;
        this.f62519j = str2;
        this.f62520k = str3;
        this.f62521l = str4;
    }

    public final void i(String str, String str2) {
        boolean zJ = j(str2);
        String str3 = str2 + " " + str;
        h.b bVar = this.f62523n;
        if (bVar != null) {
            bVar.g(str3, zJ);
        }
    }

    public final boolean j(String str) {
        com.vungle.warren.model.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = this.f62512b) == null) {
            return false;
        }
        return cVar.t().containsValue(str);
    }

    public final void k(@NonNull WebView webView, @NonNull String str) {
        webView.evaluateJavascript(str, null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        int iH = this.f62512b.h();
        if (iH == 0) {
            k(webView, "function actionClicked(action){Android.performAction(action);};");
        } else {
            if (iH != 1) {
                throw new IllegalArgumentException("Unknown Client Type!");
            }
            this.f62516g = webView;
            webView.setVisibility(0);
            c(true);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(new a(this.f62523n));
        }
        com.vungle.warren.omsdk.b bVar = this.f62524o;
        if (bVar != null) {
            bVar.a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            String str3 = f62510p;
            Log.e(str3, "Error desc " + str);
            Log.e(str3, "Error for URL " + str2);
            i(str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            String str = f62510p;
            Log.e(str, "Error desc " + webResourceError.getDescription().toString());
            Log.e(str, "Error for URL " + webResourceRequest.getUrl().toString());
            i(webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        String str = f62510p;
        Log.e(str, "Error desc " + webResourceResponse.getStatusCode());
        Log.e(str, "Error for URL " + webResourceRequest.getUrl().toString());
        i(String.valueOf(webResourceResponse.getStatusCode()), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Log.w(f62510p, "onRenderProcessGone url: " + webView.getUrl() + ",  did crash: " + renderProcessGoneDetail.didCrash());
        this.f62516g = null;
        h.b bVar = this.f62523n;
        return bVar != null ? bVar.i(webView, renderProcessGoneDetail.didCrash()) : super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
        String str2 = f62510p;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MRAID Command ");
        sb2.append(str);
        if (TextUtils.isEmpty(str)) {
            Log.e(str2, "Invalid URL ");
            return false;
        }
        Uri uri = Uri.parse(str);
        if (uri.getScheme() != null) {
            String scheme = uri.getScheme();
            if (scheme.equals(CampaignEx.JSON_KEY_MRAID)) {
                final String host = uri.getHost();
                if (host == null) {
                    return false;
                }
                if ("propertiesChangeCompleted".equals(host) && !this.f62517h) {
                    k(webView, "window.vungle.mraidBridge.notifyReadyEvent(" + this.f62512b.c() + ")");
                    this.f62517h = true;
                } else if (this.f62514d != null) {
                    final JsonObject jsonObject = new JsonObject();
                    for (String str3 : uri.getQueryParameterNames()) {
                        jsonObject.addProperty(str3, uri.getQueryParameter(str3));
                    }
                    final Handler handler = new Handler();
                    this.f62511a.submit(new Runnable() { // from class: com.vungle.warren.ui.view.VungleWebClient.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VungleWebClient.this.f62514d.f(host, jsonObject)) {
                                handler.post(new Runnable() { // from class: com.vungle.warren.ui.view.VungleWebClient.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        VungleWebClient.this.k(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
                                    }
                                });
                            }
                        }
                    });
                }
                return true;
            }
            if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Open URL");
                sb3.append(str);
                if (this.f62514d != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("url", str);
                    this.f62514d.f("openNonMraid", jsonObject2);
                }
                return true;
            }
        }
        return false;
    }
}
