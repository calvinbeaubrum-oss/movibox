package com.cloud.tmc.integration.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import bc.a;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.R$string;
import com.cloud.tmc.integration.broadcast.ShortCutBroadcast;
import com.cloud.tmc.integration.model.AddToHomeScreenStore;
import com.cloud.tmc.integration.model.MiniAddHomeModel;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.o;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.e;
import com.google.gson.JsonObject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ShortCutBroadcast extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30660a = "ShortCutBroadcast";

    public static final void b(Context context, String str, boolean z11, ShortCutBroadcast this$0, int i11, String extraAddHomeLocation) {
        Boolean boolValueOf;
        AddToHomeScreenStore addToHomeScreenStore;
        HashMap<String, a> store;
        a aVarRemove;
        Resources resources;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(extraAddHomeLocation, "$extraAddHomeLocation");
        String string = null;
        if (context != null) {
            try {
                boolValueOf = Boolean.valueOf(((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "miniKeyStorageAddHome", "addHomeStatus_" + str, false));
            } catch (Throwable th2) {
                TmcLogger.h(this$0.f30660a, th2);
                return;
            }
        } else {
            boolValueOf = null;
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Bundle bundle = new Bundle();
        bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, extraAddHomeLocation);
        Boolean bool = Boolean.TRUE;
        bundle.putString("old_state", Intrinsics.b(boolValueOf, bool) ? "0" : "1");
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.recordForCommon(str, "add_succ", bundle);
        if (context != null) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniKeyStorageAddHome", "addHomeStatus_" + str, true);
        }
        if (z11) {
            ToastProxy toastProxy = (ToastProxy) tc.a.a(ToastProxy.class);
            if (context != null && (resources = context.getResources()) != null) {
                string = resources.getString(R$string.smallapp_create_success);
            }
            toastProxy.toast(string);
        }
        TmcLogger.c(this$0.f30660a, "检查 addHomeToScreen 设置桌面快捷方式 callback");
        o oVar = o.f31082a;
        App app = oVar.f().get(str);
        if (app != null && (addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) != null && (store = addToHomeScreenStore.getStore()) != null && (aVarRemove = store.remove(str)) != null) {
            JsonObject jsonObject = new JsonObject();
            TmcLogger.c(this$0.f30660a, "发送 addHomeToScreen callback received");
            jsonObject.addProperty("isExist", bool);
            aVarRemove.d(jsonObject);
        }
        if (i11 == 1) {
            App app2 = oVar.f().get(str);
            if (app2 != null) {
                app2.backPressed();
                return;
            }
            return;
        }
        if (i11 == 2) {
            App app3 = oVar.f().get(str);
            if (app3 != null) {
                app3.exit();
                return;
            }
            return;
        }
        try {
            App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str);
            if (appFindApp != null) {
                appFindApp.hideMiniAppAddHomeBar();
            }
        } catch (Throwable th3) {
            TmcLogger.g(this$0.f30660a, "onReceive error: ", th3);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String stringExtra;
        String location;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("miniAppId");
            } catch (Throwable th2) {
                TmcLogger.g(this.f30660a, "onReceive error: ", th2);
                return;
            }
        } else {
            stringExtra = null;
        }
        final String str = stringExtra;
        if (str != null && str.length() != 0) {
            MiniAddHomeModel miniAddHomeModel = o.f31082a.d().get(str);
            final int sourceType = miniAddHomeModel != null ? miniAddHomeModel.getSourceType() : -1;
            if (miniAddHomeModel == null || (location = miniAddHomeModel.getLocation()) == null) {
                location = "";
            }
            final String str2 = location;
            final boolean showSuccessToast = miniAddHomeModel != null ? miniAddHomeModel.getShowSuccessToast() : true;
            TmcLogger.c(this.f30660a, "appId -> " + str);
            TmcLogger.c(this.f30660a, "exteaAddHomeType:->" + sourceType);
            TmcLogger.c(this.f30660a, "showSuccessToast:->" + showSuccessToast);
            TmcLogger.c(this.f30660a, "extraAddHomeLocation:->" + str2);
            e.f(new Runnable() { // from class: ta.a
                @Override // java.lang.Runnable
                public final void run() {
                    ShortCutBroadcast.b(context, str, showSuccessToast, this, sourceType, str2);
                }
            });
            return;
        }
        TmcLogger.c(this.f30660a, "appid is null");
    }
}
