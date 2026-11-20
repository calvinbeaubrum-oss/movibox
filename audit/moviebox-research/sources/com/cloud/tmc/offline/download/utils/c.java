package com.cloud.tmc.offline.download.utils;

import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import com.cloud.tmc.kernel.log.TmcLogger;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32089a = new c();

    public final void a(String str, Lifecycle lifecycle) {
        if (str == null || str.length() == 0 || lifecycle == null) {
            TmcLogger.c("TmcOfflineDownload: LifecycleUtils", "appId or lifecycle is null or empty");
        } else if (Intrinsics.b(Looper.getMainLooper(), Looper.myLooper())) {
            lifecycle.a(new xd.a(str));
        } else {
            TmcLogger.c("TmcOfflineDownload: LifecycleUtils", "当前不在主线程中，不允许注册观察者");
        }
    }
}
