package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.i0;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class VibrateBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("VibrateBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("VibrateBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void vibrate(@cc.g(name = {"milliseconds"}) long j11, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            if (j11 <= 0) {
                callback.b();
                return;
            }
            if (j11 > 1000) {
                j11 = 1000;
            }
            i0.c(j11);
            callback.g();
        } catch (Throwable th2) {
            TmcLogger.h("VibrateBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void vibrateLong(@cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        vibrate(400L, callback);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void vibrateShort(@cc.g({"type"}) String type, @cc.c bc.a callback) {
        Intrinsics.g(type, "type");
        Intrinsics.g(callback, "callback");
        try {
            long[] jArr = {0, 50};
            long[] jArr2 = {0, 25, 25};
            long[] jArr3 = {0, 12, 12, 12, 12};
            int iHashCode = type.hashCode();
            if (iHashCode == -1078030475) {
                if (type.equals("medium")) {
                    jArr = jArr2;
                    i0.d(jArr, -1);
                    callback.g();
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", type + " is not supported: V10001");
                callback.e(jsonObject);
            }
            if (iHashCode == 99152071) {
                if (type.equals("heavy")) {
                    i0.d(jArr, -1);
                    callback.g();
                }
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", type + " is not supported: V10001");
                callback.e(jsonObject2);
            }
            if (iHashCode == 102970646 && type.equals("light")) {
                jArr = jArr3;
                i0.d(jArr, -1);
                callback.g();
            } else {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("errMsg", type + " is not supported: V10001");
                callback.e(jsonObject3);
            }
        } catch (Throwable th2) {
            TmcLogger.h("VibrateBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void vibrationCancel(@cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            i0.a();
            callback.g();
        } catch (Throwable th2) {
            TmcLogger.h("VibrateBridge", th2);
            callback.b();
        }
    }
}
