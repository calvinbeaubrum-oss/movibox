package com.transsion.web.fragment;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.v;
import com.alibaba.android.arouter.facade.Postcard;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.transsion.web.api.WebJavascriptInterface;
import com.transsion.web.bean.ApiRequestData;
import com.transsion.web.share.WebShareUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w0;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WebFragmentV2$addJsInterface$2 extends WebJavascriptInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebFragmentV2 f60184a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragmentV2$addJsInterface$2(WebFragmentV2 webFragmentV2, BridgeWebView bridgeWebView) {
        super(bridgeWebView);
        this.f60184a = webFragmentV2;
    }

    public static final void r(WebFragmentV2 this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void s(WebFragmentV2 this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.n0().f67707h.setVisibility(8);
    }

    public static final void t(WebFragmentV2 this$0) {
        Intrinsics.g(this$0, "this$0");
        BridgeWebView bridgeWebViewS0 = this$0.s0();
        if (bridgeWebViewS0.canGoBack()) {
            bridgeWebViewS0.goBack();
        }
    }

    public static final void u(WebFragmentV2 this$0, String data, String callbackId) {
        WebShareUtil webShareUtil;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(data, "$data");
        Intrinsics.g(callbackId, "$callbackId");
        if (this$0.getActivity() == null || (webShareUtil = this$0.f60176j) == null) {
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.d(activity);
        webShareUtil.j(activity, data, callbackId);
    }

    public static final void v(WebFragmentV2 this$0, String data, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(data, "$data");
        Intrinsics.g(callbackId, "$callbackId");
        WebShareUtil webShareUtil = this$0.f60176j;
        if (webShareUtil != null) {
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "this@WebFragmentV2.childFragmentManager");
            webShareUtil.k(data, callbackId, childFragmentManager);
        }
    }

    public static final void w(WebFragmentV2 this$0, final String data) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(data, "$data");
        final BridgeWebView bridgeWebViewS0 = this$0.s0();
        bridgeWebViewS0.post(new Runnable() { // from class: com.transsion.web.fragment.j
            @Override // java.lang.Runnable
            public final void run() {
                WebFragmentV2$addJsInterface$2.x(bridgeWebViewS0, data);
            }
        });
    }

    public static final void x(BridgeWebView it, String data) {
        Intrinsics.g(it, "$it");
        Intrinsics.g(data, "$data");
        try {
            it.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(data)));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static final void y(WebFragmentV2 this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.n0().f67707h.setVisibility(0);
    }

    public static final void z(String str) {
        com.tn.lib.widget.toast.core.h.f50034a.l(str);
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void close(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        super.close(str, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.e
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.r(webFragmentV2);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void closeLoading(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        super.closeLoading(str, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.s(webFragmentV2);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void goBack(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        super.goBack(str, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.g
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.t(webFragmentV2);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void h5ShareNative(final String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        super.h5ShareNative(data, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.u(webFragmentV2, data, callbackId);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void nativeShare(final String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        super.nativeShare(data, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.v(webFragmentV2, data, callbackId);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void openApp(final String data, String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        super.openApp(data, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.f
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.w(webFragmentV2, data);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void openLoading(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        super.openLoading(str, callbackId);
        FragmentActivity activity = this.f60184a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f60184a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2.y(webFragmentV2);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void openToast(final String str, String callbackId) {
        FragmentActivity activity;
        Intrinsics.g(callbackId, "callbackId");
        super.openToast(str, callbackId);
        if (str == null || (activity = this.f60184a.getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                WebFragmentV2$addJsInterface$2.z(str);
            }
        });
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void request(String str, String callbackId) {
        String api;
        String methods;
        Intrinsics.g(callbackId, "callbackId");
        super.request(str, callbackId);
        try {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = WebFragmentV2.f60174r.a();
            Intrinsics.f(TAG, "TAG");
            aVar.c(TAG, "request :" + str + ", callbackId:" + callbackId, true);
            ApiRequestData apiRequestDataC = c00.a.f14537a.c(str);
            if (apiRequestDataC != null && (api = apiRequestDataC.getApi()) != null && api.length() != 0 && (methods = apiRequestDataC.getMethods()) != null && methods.length() != 0) {
                String host = apiRequestDataC.getHost();
                if (host == null) {
                    host = cp.a.f62775a.a();
                }
                kotlinx.coroutines.j.d(v.a(this.f60184a), w0.b(), null, new WebFragmentV2$addJsInterface$2$request$1(apiRequestDataC, this.f60184a, host + apiRequestDataC.getApi(), callbackId, null), 2, null);
                return;
            }
            this.f60184a.s0().sendResponse("", callbackId);
        } catch (Throwable th2) {
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = WebFragmentV2.f60174r.a();
            Intrinsics.f(TAG2, "TAG");
            aVar2.c(TAG2, "requestm error :" + th2, true);
            this.f60184a.s0().sendResponse("", callbackId);
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void startPage(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        super.startPage(str, callbackId);
        try {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = WebFragmentV2.f60174r.a();
            Intrinsics.f(TAG, "TAG");
            aVar.c(TAG, "startPage :" + str, true);
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("pageName");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b(strOptString);
            c00.a aVar2 = c00.a.f14537a;
            Intrinsics.f(postcardB, "this");
            aVar2.b(postcardB, aVar2.a(jSONObjectOptJSONObject));
            postcardB.navigation();
        } catch (Exception unused) {
        }
    }
}
