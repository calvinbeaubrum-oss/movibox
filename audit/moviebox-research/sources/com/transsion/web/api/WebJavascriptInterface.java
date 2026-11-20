package com.transsion.web.api;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.mbtools.CalendarBean;
import com.transsion.mbtools.CalendarRemindUtils;
import com.transsion.web.bean.JsCallbackData;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public class WebJavascriptInterface extends BridgeWebView.BaseJavascriptInterface {
    private final BridgeWebView customWebView;
    private final ILoginApi mLoginApi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebJavascriptInterface(BridgeWebView customWebView) {
        super(customWebView.getCallbacks());
        Intrinsics.g(customWebView, "customWebView");
        this.customWebView = customWebView;
        this.mLoginApi = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getClientInfo$lambda$3(WebJavascriptInterface this$0, String response, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(response, "$response");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse(response, callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNativeStatusBarHeight$lambda$9$lambda$8(WebJavascriptInterface this$0, float f11, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse(Float.valueOf(f11), callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getToken$lambda$4(WebJavascriptInterface this$0, String str, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse(str, callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUserInfo$lambda$2(WebJavascriptInterface this$0, String str, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse(str, callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nativeLogin$lambda$6(WebJavascriptInterface this$0, Context context, JSONObject jSONObject) {
        Intrinsics.g(this$0, "this$0");
        ILoginApi iLoginApi = this$0.mLoginApi;
        if (iLoginApi != null) {
            Intrinsics.f(context, "context");
            Intent intentO1 = iLoginApi.o1(context);
            if (intentO1 != null) {
                Intent intentPutExtra = intentO1.putExtra("source", jSONObject != null ? jSONObject.optString("H5Source") : null);
                if (intentPutExtra != null) {
                    context.startActivity(intentPutExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postCallback(final JsCallbackData jsCallbackData, final String str) {
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.g
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.postCallback$lambda$7(this.f60169a, jsCallbackData, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postCallback$lambda$7(WebJavascriptInterface this$0, JsCallbackData callback, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callback, "$callback");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse(callback, callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDetectList$lambda$1(WebJavascriptInterface this$0, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse("submitFromWeb response from native", callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitFromWeb$lambda$0(WebJavascriptInterface this$0, String callbackId) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callbackId, "$callbackId");
        this$0.customWebView.sendResponse("submitFromWeb response from native", callbackId);
    }

    @JavascriptInterface
    public final void calendarRemind(String data, final String callbackId) {
        CalendarBean calendarBean;
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calendarRemind:");
        sb2.append(data);
        try {
            calendarBean = (CalendarBean) new Gson().fromJson(data, CalendarBean.class);
        } catch (Exception unused) {
            calendarBean = null;
        }
        if (calendarBean != null) {
            CalendarRemindUtils.f53115a.d(calendarBean, new Function0<Unit>() { // from class: com.transsion.web.api.WebJavascriptInterface.calendarRemind.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WebJavascriptInterface.this.postCallback(new JsCallbackData(null, "0", 1, null), callbackId);
                }
            }, new Function1<String, Unit>() { // from class: com.transsion.web.api.WebJavascriptInterface.calendarRemind.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.g(it, "it");
                    WebJavascriptInterface.this.postCallback(new JsCallbackData(it, "-1"), callbackId);
                }
            });
            return;
        }
        postCallback(new JsCallbackData("data error:" + data, "-1"), callbackId);
    }

    @JavascriptInterface
    public void close(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void closeLoading(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void closeToast(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void deeplink(String deeplink, String callbackId) {
        Intrinsics.g(deeplink, "deeplink");
        Intrinsics.g(callbackId, "callbackId");
        ArouterUtil arouterUtil = ArouterUtil.f51292a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        ArouterUtil.c(arouterUtil, applicationA, deeplink, null, 4, null);
    }

    @JavascriptInterface
    public final void getClientInfo(String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getClientInfo:");
        sb2.append(data);
        sb2.append(", callbackId: ");
        sb2.append(callbackId);
        sb2.append(" ");
        sb2.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        final String strC = fp.b.f65208a.c();
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.d
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.getClientInfo$lambda$3(this.f60160a, strC, callbackId);
            }
        });
    }

    public final ILoginApi getMLoginApi() {
        return this.mLoginApi;
    }

    @JavascriptInterface
    public final void getNativeStatusBarHeight(String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        try {
            Result.Companion companion = Result.Companion;
            String name = Thread.currentThread().getName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getNativeStatBarHeight() --> data = ");
            sb2.append(data);
            sb2.append(" --> callbackId = ");
            sb2.append(callbackId);
            sb2.append(" --> thread.name = ");
            sb2.append(name);
            if (!TextUtils.isEmpty(callbackId)) {
                final float statusBarHeight = ImmersionBar.getStatusBarHeight(Utils.a()) / Utils.a().getResources().getDisplayMetrics().density;
                this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebJavascriptInterface.getNativeStatusBarHeight$lambda$9$lambda$8(this.f60163a, statusBarHeight, callbackId);
                    }
                });
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @JavascriptInterface
    public final void getToken(String data, final String callbackId) {
        UserInfo userInfoP;
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getToken:");
        sb2.append(data);
        sb2.append(", callbackId: ");
        sb2.append(callbackId);
        sb2.append(" ");
        sb2.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        ILoginApi iLoginApi = this.mLoginApi;
        final String token = (iLoginApi == null || (userInfoP = iLoginApi.P()) == null) ? null : userInfoP.getToken();
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.f
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.getToken$lambda$4(this.f60166a, token, callbackId);
            }
        });
    }

    @JavascriptInterface
    public final void getUserInfo(String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getUserInfo:");
        sb2.append(data);
        sb2.append(", callbackId: ");
        sb2.append(callbackId);
        sb2.append(" ");
        sb2.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        ILoginApi iLoginApi = this.mLoginApi;
        final String strJ = null;
        try {
            strJ = n.j(iLoginApi != null ? iLoginApi.P() : null);
        } catch (Exception unused) {
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.b
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.getUserInfo$lambda$2(this.f60155a, strJ, callbackId);
            }
        });
    }

    @JavascriptInterface
    public void goBack(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void h5ShareNative(String data, String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public final void nativeLogin(String data, String callbackId) {
        final JSONObject jSONObject;
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeLogin:");
        sb2.append(data);
        final Context context = this.customWebView.getContext();
        try {
            jSONObject = new JSONObject(data);
        } catch (Exception unused) {
            jSONObject = null;
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.a
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.nativeLogin$lambda$6(this.f60152a, context, jSONObject);
            }
        });
    }

    @JavascriptInterface
    public void nativeShare(String data, String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void openApp(String data, String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void openLoading(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void openToast(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void request(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebView.BaseJavascriptInterface
    public String send(String s11) {
        Intrinsics.g(s11, "s");
        return "send";
    }

    @JavascriptInterface
    public final void showDetectList(String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showDetectList:");
        sb2.append(data);
        sb2.append(", callbackId: ");
        sb2.append(callbackId);
        sb2.append(" ");
        sb2.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.h
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.showDetectList$lambda$1(this.f60172a, callbackId);
            }
        });
    }

    @JavascriptInterface
    public void startPage(String str, String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
    }

    @JavascriptInterface
    public final void submitFromWeb(String data, final String callbackId) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(data);
        sb2.append(", callbackId: ");
        sb2.append(callbackId);
        sb2.append(" ");
        sb2.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.c
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.submitFromWeb$lambda$0(this.f60158a, callbackId);
            }
        });
    }
}
