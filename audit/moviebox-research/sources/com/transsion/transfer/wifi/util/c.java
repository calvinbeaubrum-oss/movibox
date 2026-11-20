package com.transsion.transfer.wifi.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f59246a = new c();

    public final long a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public final String b() {
        return (((int) ((((a() / 1024.0f) / 1024.0f) / 1024.0f) * 10)) / 10.0f) + "GB";
    }

    public final String c(Context context) {
        Intrinsics.g(context, "context");
        return (((int) (((d(context) / 1024.0f) / 1024.0f) * 10)) / 10.0f) + "GB";
    }

    public final long d(Context context) {
        Intrinsics.g(context, "context");
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            long j11 = memoryInfo.totalMem;
            return j11 > 0 ? j11 / ((long) 1024) : j11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0L;
        }
    }

    public final boolean e() {
        String MODEL = Build.MODEL;
        Intrinsics.f(MODEL, "MODEL");
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = MODEL.toLowerCase(locale);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        return l.L(lowerCase, "itel", false, 2, null) || l.L(lowerCase, "tecno", false, 2, null) || l.L(lowerCase, "infinix", false, 2, null) || l.L(lowerCase, "spice", false, 2, null);
    }
}
