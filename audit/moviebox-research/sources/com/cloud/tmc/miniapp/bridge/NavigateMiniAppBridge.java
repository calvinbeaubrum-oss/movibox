package com.cloud.tmc.miniapp.bridge;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import cc.c;
import cc.f;
import cc.g;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import tb.b;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class NavigateMiniAppBridge implements BridgeExtension {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void navigateToMiniProgram(@g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @g({MBridgeConstans.DYNAMIC_VIEW_WX_PATH}) String str2, @g({"extraData"}) String str3, @f(App.class) App app, @f(Page.class) Page page, @c bc.a aVar) {
        Context context;
        Uri uri;
        String path;
        String str4;
        String str5;
        Boolean boolY0;
        String str6;
        Boolean boolY1;
        String str7;
        if (app != null && app.getAppContext() != null) {
            b appContext = app.getAppContext();
            if ((appContext != null ? appContext.getContext() : null) != null && str != null && str.length() != 0) {
                b appContext2 = app.getAppContext();
                if (appContext2 == null || (context = appContext2.getContext()) == null || !(context instanceof Activity)) {
                    return;
                }
                Application application = ((Activity) context).getApplication();
                Intrinsics.f(application, "it.application");
                Bundle bundle = new Bundle();
                if ((str2 != null && l.L(str2, "http://", false, 2, null)) || (str2 != null && l.L(str2, AgentPageJsBridge.HTTPS, false, 2, null))) {
                    bundle.putString("page", str2);
                } else if (str2 != null) {
                    try {
                        String strD = r.d(str2);
                        uri = (strD == null || strD.length() == 0) ? null : Uri.parse(strD);
                    } catch (Throwable th2) {
                        TmcLogger.g("NavigateMiniAppBridge", "Unable to decode", th2);
                    }
                    if (uri != null && (path = uri.getPath()) != null && path.length() != 0) {
                        bundle.putString("page", uri.getPath());
                        bundle.putString("query", uri.getQuery());
                    }
                }
                try {
                    Map mapG = TmcGsonUtils.g(str3);
                    bundle.putString(TrackingKey.SCENE_ID, xb.e.a(mapG != null ? (String) mapG.get(TrackingKey.SCENE_ID) : null, "100000"));
                    String str8 = mapG != null ? (String) mapG.get("feedback_miniappId") : null;
                    String str9 = mapG != null ? (String) mapG.get("feedback_miniappVersion") : null;
                    if (str8 != null) {
                        bundle.putString("feedback_miniappId", str8);
                    }
                    if (str9 != null) {
                        bundle.putString("feedback_miniappVersion", str9);
                    }
                    if (mapG != null && (str7 = (String) mapG.get("extraMiniBackToUrl")) != null) {
                        bundle.putString("extraMiniBackToUrl", str7);
                    }
                    if (mapG != null && (str6 = (String) mapG.get("extraMiniClearAllPages")) != null && (boolY1 = StringsKt__StringsKt.Y0(str6)) != null) {
                        bundle.putBoolean("extraMiniClearAllPages", boolY1.booleanValue());
                    }
                    if (mapG != null && (str5 = (String) mapG.get("quickMode")) != null && (boolY0 = StringsKt__StringsKt.Y0(str5)) != null) {
                        bundle.putBoolean("quickMode", boolY0.booleanValue());
                    }
                    if (mapG != null && (str4 = (String) mapG.get("mfah")) != null) {
                        bundle.putString("mfah", str4);
                    }
                    bundle.putString("extraData", str3);
                } catch (Throwable th3) {
                    TmcLogger.h("NavigateMiniAppBridge", th3);
                }
                Unit unit = Unit.f68710a;
                MiniAppLaunch.d0(application, str, bundle);
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
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
}
