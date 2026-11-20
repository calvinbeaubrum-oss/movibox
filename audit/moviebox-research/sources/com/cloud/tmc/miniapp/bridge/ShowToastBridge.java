package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import cc.c;
import cc.f;
import cc.g;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.model.AlertBeforeUnloadCache;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$string;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import n0.j;
import tb.b;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class ShowToastBridge implements BridgeExtension {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<Unit> {
        public final /* synthetic */ bc.a OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO(bc.a aVar) {
            super(0);
            this.OooO00o = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            bc.a aVar = this.OooO00o;
            if (aVar != null) {
                aVar.g();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ bc.a OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(bc.a aVar) {
            super(0);
            this.OooO00o = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            bc.a aVar = this.OooO00o;
            if (aVar != null) {
                aVar.g();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<Unit> {
        public final /* synthetic */ bc.a OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(bc.a aVar) {
            super(0);
            this.OooO00o = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            bc.a aVar = this.OooO00o;
            if (aVar != null) {
                aVar.g();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<Unit> {
        public final /* synthetic */ bc.a OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0o(bc.a aVar) {
            super(0);
            this.OooO00o = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            bc.a aVar = this.OooO00o;
            if (aVar != null) {
                aVar.g();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void disableAlertBeforeUnload(@f(App.class) App app, @f(Page.class) Page page, @c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null || page == null || Intrinsics.b(app.getFirstPage(), page) || page.isTabPage()) {
            callback.b();
            return;
        }
        AlertBeforeUnloadCache alertBeforeUnloadCache = (AlertBeforeUnloadCache) page.getData(AlertBeforeUnloadCache.class);
        if (alertBeforeUnloadCache == null) {
            callback.g();
        } else {
            alertBeforeUnloadCache.setEnabled(false);
            callback.g();
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void enableAlertBeforeUnload(@g({"message"}) String message, @f(App.class) App app, @f(Page.class) Page page, @c bc.a callback) {
        Intrinsics.g(message, "message");
        Intrinsics.g(callback, "callback");
        if (app == null || page == null || Intrinsics.b(app.getFirstPage(), page) || page.isTabPage() || message.length() == 0) {
            callback.b();
        } else {
            page.setData(AlertBeforeUnloadCache.class, new AlertBeforeUnloadCache(true, message));
            callback.g();
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void hideLoading(@g(name = {"noConflict"}) boolean z11, @c bc.a aVar) {
        if (z11) {
            j.f();
            j.a();
        } else {
            j.a();
        }
        if (aVar != null) {
            aVar.g();
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void hideToast(@g(name = {"noConflict"}) boolean z11, @c bc.a aVar) {
        if (z11) {
            j.f();
            j.a();
        } else {
            j.f();
        }
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("showToast", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("showToast", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showActionSheet(@g(name = {"itemList", "actions"}) JsonArray jsonArray, @g(name = {"itemColor"}, stringDefault = "#191F2B") String itemColor, @g(name = {"type"}, stringDefault = MimeTypes.BASE_TYPE_TEXT) String type, @g(name = {CampaignEx.JSON_KEY_TITLE}) String str, @g(name = {"alertText", AppLovinEventTypes.USER_VIEWED_CONTENT}) String str2, @g(booleanDefault = true, name = {"showCancel"}) boolean z11, @g(name = {"cancelText"}, stringDefault = "Cancel") String cancelText, @g(name = {"cancelColor"}, stringDefault = "#191F2B") String cancelColor, @f(App.class) App app, @c bc.a aVar) {
        b appContext;
        Intrinsics.g(itemColor, "itemColor");
        Intrinsics.g(type, "type");
        Intrinsics.g(cancelText, "cancelText");
        Intrinsics.g(cancelColor, "cancelColor");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        String appId = app != null ? app.getAppId() : null;
        if (context == null || appId == null || appId.length() == 0 || jsonArray == null) {
            if (aVar != null) {
                f.a.a("errMsg", "Parameter error: AS10001", aVar);
            }
        } else {
            if (Intrinsics.b(type, MimeTypes.BASE_TYPE_TEXT) || Intrinsics.b(type, RewardPlus.ICON)) {
                ((ToastProxy) tc.a.a(ToastProxy.class)).showActionSheet(jsonArray, type, str, str2, itemColor, z11, cancelText, cancelColor, context, appId, aVar);
                return;
            }
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", type + " is not supported: AS10002");
                aVar.e(jsonObject);
            }
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showAddHomeTipsToast(@f(App.class) App app, @g({"showType"}) int i11, @g({"showDelayTime"}) long j11, @g({"closeDelayTime"}) long j12, @g({"message"}) String message, @g({"iconUrl"}) String iconUrl, @c bc.a callback) {
        b appContext;
        Intrinsics.g(message, "message");
        Intrinsics.g(iconUrl, "iconUrl");
        Intrinsics.g(callback, "callback");
        try {
            if (!kotlin.collections.g.o(1, 2).contains(Integer.valueOf(i11))) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", i11 + " is not supported: AS10002");
                callback.e(jsonObject);
                return;
            }
            if (AddHomeToScreenUtils.f30986a.i(81, app)) {
                return;
            }
            Context context = null;
            if (PermissionScopeBridge.Companion.a(app != null ? app.getAppId() : null)) {
                TmcLogger.c("showToast", "dev dialog is showing, return");
                return;
            }
            if (app != null && (appContext = app.getAppContext()) != null) {
                context = appContext.getContext();
            }
            if (!(context instanceof com.cloud.tmc.miniapp.ui.OooO0OO)) {
                callback.b();
            } else {
                ((com.cloud.tmc.miniapp.ui.OooO0OO) context).R(i11, j11, j12, message, iconUrl);
                callback.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("showToast", th2);
            callback.b();
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showLoading(@g(name = {CampaignEx.JSON_KEY_TITLE}) String msg, @g(intDefault = 1, name = {"duration"}) int i11, @g(booleanDefault = true, name = {"mask"}) boolean z11, @f(App.class) App app, @c bc.a aVar) {
        Context context;
        Intrinsics.g(msg, "msg");
        if (app == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (msg.length() == 0) {
                b appContext = app.getAppContext();
                msg = (appContext == null || (context = appContext.getContext()) == null) ? null : context.getString(R$string.dialog_loading_tv);
            }
            showToast(xb.e.a(msg, ""), "loading", null, i11, z11, app, aVar);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showModal(@g(name = {CampaignEx.JSON_KEY_TITLE}) String str, @g(name = {AppLovinEventTypes.USER_VIEWED_CONTENT}) String str2, @g(name = {"showCancel"}) boolean z11, @g(name = {"editable"}) boolean z12, @g(name = {"placeholderText"}) String str3, @g(name = {"cancelText"}) String str4, @g(name = {"cancelColor"}) String str5, @g(name = {"confirmText"}) String str6, @g(name = {"confirmColor"}) String str7, @f(App.class) App app, @c bc.a aVar) {
        b appContext;
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context != null) {
            ((ToastProxy) tc.a.a(ToastProxy.class)).showModal(str, str2, z11, z12, str3, str4, str5, str6, str7, context, aVar);
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showToast(@g(name = {NotificationCompat.CATEGORY_MESSAGE, CampaignEx.JSON_KEY_TITLE}) String msg, @g(name = {RewardPlus.ICON}, stringDefault = DevicePublicKeyStringDef.NONE) String icon, @g(name = {"image"}) String str, @g(intDefault = 1500, name = {"duration"}) int i11, @g(name = {"mask"}) boolean z11, @f(App.class) App app, @c bc.a aVar) {
        int i12 = i11;
        Intrinsics.g(msg, "msg");
        Intrinsics.g(icon, "icon");
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (i12 == 1) {
            i12 = 1;
        } else if (i12 == 0 || i12 > 60000 || i12 < 1000) {
            i12 = 0;
        }
        File fileH = (str == null || str.length() == 0) ? null : FileUtil.H(app, str);
        o0.a.d dVar = o0.a.d.f72242b;
        if (Intrinsics.b(icon, "success")) {
            j.d(msg, dVar, i12, 0L, z11, fileH, new OooO0O0(aVar), 8);
            return;
        }
        o0.a.C0774a c0774a = o0.a.C0774a.f72239b;
        if (Intrinsics.b(icon, "error")) {
            j.d(msg, c0774a, i12, 0L, z11, fileH, new OooO0OO(aVar), 8);
            return;
        }
        o0.a.b bVar = o0.a.b.f72240b;
        if (Intrinsics.b(icon, "loading")) {
            j.d(msg, bVar, i12, 0L, z11, fileH, new OooO0o(aVar), 8);
        } else if (Intrinsics.b(icon, DevicePublicKeyStringDef.NONE)) {
            j.c(msg, i12, 0L, z11, new OooO(aVar), 4);
        } else if (aVar != null) {
            aVar.b();
        }
    }
}
