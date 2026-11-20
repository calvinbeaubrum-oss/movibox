package com.cloud.tmc.miniapp.bridge;

import OooO0o0.o000000;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cc.c;
import cc.f;
import cc.g;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import hd.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import tb.b;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PrivacyBridge implements BridgeExtension {
    public static final a Companion = new a();
    public static final ConcurrentHashMap<String, o000000> OooO0O0 = new ConcurrentHashMap<>();
    public final String OooO00o = "PrivacyBridge";

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void checkEnableMfah(@c bc.a aVar) {
        boolean configBoolean = true;
        try {
            configBoolean = ((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("enableForceAddHome", true);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(configBoolean));
                aVar.d(jsonObject);
            } catch (Throwable th2) {
                callbackFail(aVar, String.valueOf(th2.getMessage()), Boolean.FALSE);
            }
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void checkLoadingSuccess(@f(App.class) App app, @c(isSticky = true) bc.a aVar) {
        String appId = app != null ? app.getAppId() : null;
        if (aVar == null) {
            TmcLogger.c(this.OooO00o, "checkLoadingSuccess callback is null");
            return;
        }
        if (appId == null || appId.length() == 0) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("error", "appid is null");
            aVar.e(jsonObject);
            aVar.close();
            return;
        }
        if (app.getHideMiniAppLoadingStatus()) {
            TmcLogger.c(this.OooO00o, "checkLoadingSuccesshide MiniAppLoadingStatus is true");
            f0.f31050a.k(appId, aVar);
        } else {
            k.a("checkLoadingSuccess appId: ", appId, this.OooO00o);
            f0.f31050a.a(appId, aVar);
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void getForceAddHomeList(@g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @c bc.a aVar) {
        String configString = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "appId is null or empty", Boolean.FALSE);
            return;
        }
        try {
            configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("mfahList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("forceList", configString);
                aVar.d(jsonObject);
            } catch (Throwable th2) {
                callbackFail(aVar, String.valueOf(th2.getMessage()), Boolean.FALSE);
            }
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void getPrivacyWhiteList(@g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @c bc.a aVar) {
        String configString = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "appId is null or empty", Boolean.FALSE);
            return;
        }
        try {
            configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("privacyAgreementDialogWhiteListV4", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("privacyWhiteList", configString);
                aVar.d(jsonObject);
            } catch (Throwable th2) {
                callbackFail(aVar, String.valueOf(th2.getMessage()), Boolean.FALSE);
            }
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void isAutoAgreePrivacy(@f(App.class) App app, @c bc.a aVar) {
        Context context;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null && MiniAppConfigHelper.f30370a.b("autoAgreePrivacy", true) && AppUtils.f31011a.u(context)) {
                    if (aVar != null) {
                        aVar.d(z.a().b("autoAgree", Boolean.TRUE).e());
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (aVar != null) {
            aVar.d(z.a().b("autoAgree", Boolean.FALSE).e());
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b3  */
    @zb.a
    @e(ExecutorType.UI)
    public final void privacyAgreementDialogHide(@f(App.class) App app, @c bc.a aVar) {
        String strValueOf;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext == null || appContext.getContext() == null) {
                    strValueOf = "app error";
                } else {
                    ConcurrentHashMap<String, o000000> concurrentHashMap = OooO0O0;
                    if (concurrentHashMap.containsKey(app.getAppId())) {
                        o000000 o000000Var = concurrentHashMap.get(app.getAppId());
                        if (o000000Var != null) {
                            o000000Var.l();
                        }
                        concurrentHashMap.remove(app.getAppId());
                        f0 f0Var = f0.f31050a;
                        AppModel appModel = app.getAppModel();
                        f0Var.j(appModel != null ? appModel.getAppId() : null);
                        PermissionDialogPoint permissionDialogPoint = (PermissionDialogPoint) ib.a.b(PermissionDialogPoint.class).d();
                        String appId = app.getAppId();
                        Intrinsics.f(appId, "app.appId");
                        permissionDialogPoint.privacyDialogDismiss(appId, app.getStartToken());
                        if (aVar != null) {
                            aVar.g();
                        }
                        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                        String appId2 = app.getAppId();
                        Bundle bundle = new Bundle();
                        bundle.putString("miniappid", app.getAppId());
                        bundle.putString("type", "3");
                        Unit unit = Unit.f68710a;
                        performanceAnalyseProxy.recordForCommon(appId2, "appstart_add_click", bundle);
                        return;
                    }
                    strValueOf = "appId:" + app.getAppId() + " cant foud privacyDialog exist";
                }
            } catch (Throwable th2) {
                strValueOf = String.valueOf(th2.getMessage());
            }
        } else {
            strValueOf = "app error";
        }
        callbackFail(aVar, strValueOf, Boolean.FALSE);
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void privacyAgreementDialogShow(@g({"showLogo"}) Boolean bool, @g({CampaignEx.JSON_KEY_TITLE}) String str, @g({"titleMaxLine"}) Integer num, @g({"baseContent"}) String str2, @g({"privacyPolocyContent"}) String str3, @g({"userAgreementContent"}) String str4, @g({"buttonText"}) String str5, @g({"privacyPolocyUrl"}) String str6, @g({"userAgreementUrl"}) String str7, @g({"showAddHome"}) boolean z11, @g({"showPrivacy"}) boolean z12, @g({"isNewUser"}) boolean z13, @g({"useCustomPrivacyContent"}) boolean z14, @g({"gdprNoticeContent"}) String gdprNoticeContent, @g({"privacyCancelTv"}) String privacyCancelTv, @g({"privacyAgreeTv"}) String privacyAgreeTv, @g({"addhomeCancelTv"}) String addhomeCancelTv, @f(App.class) App app, @c(isSticky = true) bc.a aVar) {
        String strValueOf;
        b appContext;
        Context context;
        Intrinsics.g(gdprNoticeContent, "gdprNoticeContent");
        Intrinsics.g(privacyCancelTv, "privacyCancelTv");
        Intrinsics.g(privacyAgreeTv, "privacyAgreeTv");
        Intrinsics.g(addhomeCancelTv, "addhomeCancelTv");
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "title is null or empty", Boolean.TRUE);
            return;
        }
        if (z12) {
            if (str2 == null || TextUtils.isEmpty(str2)) {
                callbackFail(aVar, "baseContent is null or empty", Boolean.TRUE);
                return;
            }
            if (str3 == null || TextUtils.isEmpty(str3)) {
                callbackFail(aVar, "privacyPolocyContent is null or empty", Boolean.TRUE);
                return;
            } else if (str4 == null || TextUtils.isEmpty(str4)) {
                callbackFail(aVar, "userAgreementContent is null or empty", Boolean.TRUE);
                return;
            }
        }
        if (str5 == null || TextUtils.isEmpty(str5)) {
            callbackFail(aVar, "buttonText is null or empty", Boolean.TRUE);
            return;
        }
        if (bool != null) {
            bool.booleanValue();
        }
        int iIntValue = num != null ? num.intValue() : 1;
        try {
            f0.f31050a.b(app != null ? app.getAppId() : null);
            if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
                TmcLogger.c(this.OooO00o, "privacyAgreementDialogShow -> " + app.getAppId());
                ConcurrentHashMap<String, o000000> concurrentHashMap = OooO0O0;
                if (concurrentHashMap.containsKey(app.getAppId())) {
                    o000000 o000000Var = concurrentHashMap.get(app.getAppId());
                    if (o000000Var != null) {
                        o000000Var.l();
                    }
                    concurrentHashMap.remove(app.getAppId());
                }
                o000000 o000000VarW = new o000000(context, app, aVar).w(str, iIntValue, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5, str6 == null ? "" : str6, str7 == null ? "" : str7, z11, z12, z13, z14, gdprNoticeContent, privacyCancelTv, privacyAgreeTv, addhomeCancelTv, false, false);
                o000000VarW.q();
                try {
                    if (MiniAppConfigHelper.f30370a.b("fpnav", true)) {
                        o000000VarW.V();
                    }
                } catch (Throwable th2) {
                    TmcLogger.g(this.OooO00o, "setNavigationBarColor error", th2);
                }
                ConcurrentHashMap<String, o000000> concurrentHashMap2 = OooO0O0;
                String appId = app.getAppId();
                Intrinsics.f(appId, "app.appId");
                concurrentHashMap2.put(appId, o000000VarW);
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
                    aVar.d(jsonObject);
                    return;
                }
                return;
            }
            strValueOf = "app error";
        } catch (Throwable th3) {
            strValueOf = String.valueOf(th3.getMessage());
        }
        callbackFail(aVar, strValueOf, Boolean.TRUE);
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void privacyAgreementTwoInOneDialogShow(@g({"privacyDialogType"}) String str, @g({CampaignEx.JSON_KEY_TITLE}) String str2, @g({"privacyTitle"}) String str3, @g({"baseContent"}) String str4, @g({"privacyPolocyContent"}) String str5, @g({"userAgreementContent"}) String str6, @g({"privacyPolocyUrl"}) String str7, @g({"userAgreementUrl"}) String str8, @g({"secondPrivacyTitle"}) String str9, @g({"secondBaseContent"}) String str10, @g({"secondPrivacyPolocyContent"}) String str11, @g({"secondUserAgreementContent"}) String str12, @g({"secondPrivacyPolocyUrl"}) String str13, @g({"secondUserAgreementUrl"}) String str14, @g({"gdprNoticeContent"}) String str15, @g({"highlightContent"}) String str16, @g({"privacyCancelTv"}) String str17, @g({"privacyAgreeTv"}) String str18, @g({"titleMaxLine"}) Integer num, @g({"useCustomPrivacyContent"}) Boolean bool, @g(booleanDefault = true, value = {"onlyEnglish"}) Boolean bool2, @f(App.class) App app, @c(isSticky = true) bc.a aVar) {
        String strValueOf;
        b appContext;
        Context context;
        try {
            f0.f31050a.b(app != null ? app.getAppId() : null);
            strValueOf = "";
            if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
                TmcLogger.c(this.OooO00o, "privacyAgreementDialogShow -> " + app.getAppId());
                ConcurrentHashMap<String, o000000> concurrentHashMap = OooO0O0;
                if (concurrentHashMap.containsKey(app.getAppId())) {
                    o000000 o000000Var = concurrentHashMap.get(app.getAppId());
                    if (o000000Var != null) {
                        o000000Var.l();
                    }
                    concurrentHashMap.remove(app.getAppId());
                }
                o000000 o000000VarX = new o000000(context, app, aVar).x(str == null ? "1" : str, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5 == null ? "" : str5, str6 == null ? "" : str6, str7 == null ? "" : str7, str8 == null ? "" : str8, str9 == null ? "" : str9, str10 == null ? "" : str10, str11 == null ? "" : str11, str12 == null ? "" : str12, str13 == null ? "" : str13, str14 == null ? "" : str14, str15 == null ? "" : str15, str16 == null ? "" : str16, str17 == null ? "" : str17, str18 == null ? "" : str18, num != null ? num.intValue() : 1, bool != null ? bool.booleanValue() : false, bool2 != null ? bool2.booleanValue() : true);
                o000000VarX.q();
                try {
                    if (MiniAppConfigHelper.f30370a.b("fpnav", true)) {
                        o000000VarX.V();
                    }
                } catch (Throwable th2) {
                    TmcLogger.g(this.OooO00o, "setNavigationBarColor error", th2);
                }
                ConcurrentHashMap<String, o000000> concurrentHashMap2 = OooO0O0;
                String appId = app.getAppId();
                Intrinsics.f(appId, "app.appId");
                concurrentHashMap2.put(appId, o000000VarX);
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
                    aVar.d(jsonObject);
                    return;
                }
                return;
            }
        } catch (Throwable th3) {
            strValueOf = String.valueOf(th3.getMessage());
        }
        callbackFail(aVar, strValueOf, Boolean.FALSE);
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void syncMfahStatus(@f(App.class) App app, @c bc.a aVar) {
        Context context;
        if (app != null) {
            try {
                String appId = app.getAppId();
                if (appId != null && appId.length() > 0) {
                    f0 f0Var = f0.f31050a;
                    f0Var.q(app.getAppId());
                    b appContext = app.getAppContext();
                    if (appContext != null && (context = appContext.getContext()) != null) {
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "100000", "isNewUser", false);
                        ConcurrentHashMap<String, Boolean> concurrentHashMapI = f0Var.i();
                        String appId2 = app.getAppId();
                        if (appId2 == null) {
                            appId2 = "";
                        }
                        concurrentHashMapI.remove(appId2);
                        ((LauncherReportProxy) tc.a.a(LauncherReportProxy.class)).reportCacheData(app.getAppId());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (aVar != null) {
            try {
                aVar.g();
            } catch (Throwable unused2) {
                aVar.g();
            }
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void syncUserAllowStatus(@f(App.class) App app, @g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @g({"isClick"}) Boolean bool, @c bc.a aVar) {
        Context context;
        if (app != null) {
            try {
                String appId = app.getAppId();
                if (appId != null && appId.length() > 0) {
                    f0.f31050a.j(app != null ? app.getAppId() : null);
                }
            } catch (Throwable unused) {
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        }
        try {
            ((LauncherReportProxy) tc.a.a(LauncherReportProxy.class)).reportAllCacheData(app != null ? app.getAppId() : null);
        } catch (Throwable unused2) {
        }
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "100000", "isNewUser", false);
                    ConcurrentHashMap<String, o000000> concurrentHashMap = OooO0O0;
                    if (!concurrentHashMap.containsKey(app.getAppId())) {
                        if (Intrinsics.b(bool, Boolean.FALSE)) {
                        }
                    }
                    concurrentHashMap.remove(app.getAppId());
                    if (aVar != null) {
                        aVar.g();
                    }
                    PermissionDialogPoint permissionDialogPoint = (PermissionDialogPoint) ib.a.b(PermissionDialogPoint.class).d();
                    String appId2 = app.getAppId();
                    Intrinsics.f(appId2, "app.appId");
                    permissionDialogPoint.privacyDialogDismiss(appId2, app.getStartToken());
                    return;
                }
            } catch (Throwable unused3) {
            }
        }
        if (aVar != null) {
            aVar.g();
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void updatePrivacyDialogUI(@g({CampaignEx.JSON_KEY_TITLE}) String str, @g({"titleMaxLine"}) Integer num, @g({"baseContent"}) String str2, @g({"privacyPolocyContent"}) String str3, @g({"userAgreementContent"}) String str4, @g({"buttonText"}) String str5, @g({"privacyPolocyUrl"}) String str6, @g({"userAgreementUrl"}) String str7, @g({"showAddHome"}) boolean z11, @g({"showPrivacy"}) boolean z12, @g({"isNewUser"}) boolean z13, @g({"useCustomPrivacyContent"}) boolean z14, @g({"gdprNoticeContent"}) String gdprNoticeContent, @g({"privacyCancelTv"}) String privacyCancelTv, @g({"privacyAgreeTv"}) String privacyAgreeTv, @g({"addhomeCancelTv"}) String addhomeCancelTv, @f(App.class) App app, @c bc.a aVar) {
        String strValueOf;
        String appId;
        Intrinsics.g(gdprNoticeContent, "gdprNoticeContent");
        Intrinsics.g(privacyCancelTv, "privacyCancelTv");
        Intrinsics.g(privacyAgreeTv, "privacyAgreeTv");
        Intrinsics.g(addhomeCancelTv, "addhomeCancelTv");
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable th2) {
                strValueOf = String.valueOf(th2.getMessage());
            }
        } else {
            appId = null;
        }
        if (appId != null && appId.length() != 0) {
            if (str != null && !TextUtils.isEmpty(str)) {
                if (z12) {
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        if (str3 != null && !TextUtils.isEmpty(str3)) {
                            if (str4 == null || TextUtils.isEmpty(str4)) {
                                callbackFail(aVar, "userAgreementContent is null or empty", Boolean.TRUE);
                                return;
                            }
                        }
                        callbackFail(aVar, "privacyPolocyContent is null or empty", Boolean.TRUE);
                        return;
                    }
                    callbackFail(aVar, "baseContent is null or empty", Boolean.TRUE);
                    return;
                }
                if (str5 != null && !TextUtils.isEmpty(str5)) {
                    int iIntValue = num != null ? num.intValue() : 1;
                    ConcurrentHashMap<String, o000000> concurrentHashMap = OooO0O0;
                    if (!concurrentHashMap.containsKey(appId)) {
                        strValueOf = "dialog is not showing";
                        callbackFail(aVar, strValueOf, Boolean.FALSE);
                        return;
                    }
                    o000000 o000000Var = concurrentHashMap.get(appId);
                    if (o000000Var != null) {
                        o000000Var.E(str, iIntValue, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5, str6 == null ? "" : str6, str7 == null ? "" : str7, z11, z12, z13, z14, gdprNoticeContent, privacyCancelTv, privacyAgreeTv, addhomeCancelTv, app, false, false);
                    }
                    if (aVar != null) {
                        aVar.g();
                        return;
                    }
                    return;
                }
                callbackFail(aVar, "buttonText is null or empty", Boolean.TRUE);
                return;
            }
            callbackFail(aVar, "title is null or empty", Boolean.TRUE);
            return;
        }
        callbackFail(aVar, "appId is null or empty", Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.cloud.tmc.kernel.extension.BridgeExtension] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.cloud.tmc.kernel.extension.BridgeExtension] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [bc.a] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9, types: [bc.a] */
    @zb.a
    @e(ExecutorType.UI)
    public final void updateTwoInOnePrivacyDialogUI(@g({"privacyDialogType"}) String str, @g({CampaignEx.JSON_KEY_TITLE}) String str2, @g({"baseContent"}) String str3, @g({"privacyPolocyContent"}) String str4, @g({"userAgreementContent"}) String str5, @g({"privacyPolocyUrl"}) String str6, @g({"userAgreementUrl"}) String str7, @g({"gdprNoticeContent"}) String str8, @g({"privacyCancelTv"}) String str9, @g({"privacyAgreeTv"}) String str10, @g({"titleMaxLine"}) Integer num, @g({"useCustomPrivacyContent"}) Boolean bool, @g(booleanDefault = true, value = {"onlyEnglish"}) Boolean bool2, @f(App.class) App app, @c bc.a aVar) {
        String appId;
        ?? r11;
        ?? r12;
        ?? r13;
        String strValueOf;
        ?? r14 = this;
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable th2) {
                th = th2;
                r11 = aVar;
            }
        } else {
            appId = null;
        }
        try {
            if (appId != null) {
                try {
                    if (appId.length() != 0) {
                        ConcurrentHashMap<String, o000000> concurrentHashMap = OooO0O0;
                        if (!concurrentHashMap.containsKey(appId)) {
                            strValueOf = "dialog is not showing";
                            r12 = aVar;
                            r13 = this;
                            r13.callbackFail(r12, strValueOf, Boolean.FALSE);
                            return;
                        }
                        o000000 o000000Var = concurrentHashMap.get(appId);
                        if (o000000Var != null) {
                            o000000Var.F(str == null ? "2" : str, str2 == null ? "" : str2, num != null ? num.intValue() : 1, str3 == null ? "" : str3, str4 == null ? "" : str4, str5 == null ? "" : str5, "", str6 == null ? "" : str6, str7 != null ? str7 : "", bool != null ? bool.booleanValue() : false, str8, str9, str10, "", bool2 != null ? bool2.booleanValue() : true, app);
                        }
                        if (aVar != null) {
                            aVar.g();
                            return;
                        }
                        return;
                        strValueOf = String.valueOf(th.getMessage());
                        r13 = r14;
                        r12 = r11;
                        r13.callbackFail(r12, strValueOf, Boolean.FALSE);
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r14 = aVar;
                    r11 = r14;
                    r14 = this;
                }
            }
            r11 = aVar;
            r14 = this;
            try {
                r14.callbackFail(r11, "appId is null or empty", Boolean.FALSE);
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
