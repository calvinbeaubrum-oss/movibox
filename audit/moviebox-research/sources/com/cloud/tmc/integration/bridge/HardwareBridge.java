package com.cloud.tmc.integration.bridge;

import android.app.ActivityManager;
import android.content.Context;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import kotlin.Metadata;
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
public final class HardwareBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getHardwareInfo(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        Context context;
        Intrinsics.g(app, "app");
        JsonObject jsonObject = new JsonObject();
        String appId = app.getAppId();
        if (appId == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            tb.b appContext = app.getAppContext();
            if (appContext == null || (context = appContext.getContext()) == null) {
                return;
            }
            Object systemService = context.getApplicationContext().getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            jsonObject.addProperty(TrackingKey.PLATFORM, "android");
            long j11 = 1024;
            jsonObject.addProperty("memorySize", Integer.valueOf((int) ((memoryInfo.totalMem / j11) / j11)));
            if (aVar != null) {
                aVar.d(jsonObject);
            }
            TmcLogger.b("getHardwareInfo = " + jsonObject);
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.b();
            }
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
