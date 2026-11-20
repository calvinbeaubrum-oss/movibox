package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
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
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f31066a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PowerManager.WakeLock f31067b;

    public final void a(Context context) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        Intrinsics.g(context, "context");
        PowerManager powerManagerA = xb.f.a(context);
        if (powerManagerA != null) {
            wakeLockNewWakeLock = powerManagerA.newWakeLock(268435466, context.getPackageName() + ":ScreenUtils");
        } else {
            wakeLockNewWakeLock = null;
        }
        f31067b = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock != null) {
            wakeLockNewWakeLock.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
        }
    }

    public final void b() {
        PowerManager.WakeLock wakeLock = f31067b;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
        f31067b = null;
    }
}
