package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import bc.a;
import cc.c;
import cc.g;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.transsion.push.PushConstants;
import dd.f;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb.b;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class NotifyMessageBridge implements BridgeExtension {
    public final String OooO00o = "NotifyMessageBridge";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    public final String getTAG() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public f permit() {
        return null;
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void updateMessageScopeStatus(@cc.f(App.class) App app, @g({PushConstants.PROVIDER_FIELD_APP_ID}) String appId, @g({"appName"}) String appName, @g({"appLogo"}) String appLogo, @g({NotificationCompat.CATEGORY_STATUS}) boolean z11, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appLogo, "appLogo");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.c(this.OooO00o, "updateMessageScopeStatus:appId->" + appId + ",status->" + z11);
            ScopeUtils.f31808a.f(context, "notifyMessage", appId, z11, appName, appLogo, false, true);
            callback.g();
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void updateNotifyMessageStatus(@cc.f(App.class) App app, @g({NotificationCompat.CATEGORY_STATUS}) boolean z11, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        try {
            b appContext = app.getAppContext();
            if (appContext == null || (context = appContext.getContext()) == null) {
                unit = null;
            } else {
                TmcLogger.c(this.OooO00o, "updateNotifyMessageStatus:->" + z11);
                Intrinsics.g(context, "context");
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniMsgKvId", "miniNewMsgStatus", z11);
                if (!z11) {
                    Intrinsics.g(context, "context");
                    Intrinsics.g("", "msgStr");
                    try {
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", "miniLatestUnreadMsg", "");
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniMsgKvId", "miniNewMsgStatus", !Intrinsics.b("", ""));
                    } catch (Throwable th2) {
                        TmcLogger.h("MiniappMsgDataProvider", th2);
                    }
                }
                callback.g();
                unit = Unit.f68710a;
            }
            if (unit == null) {
                callback.b();
            }
        } catch (Throwable th3) {
            TmcLogger.h(this.OooO00o, th3);
        }
    }
}
