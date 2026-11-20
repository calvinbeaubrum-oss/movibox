package com.transsnet.downloader.util;

import android.os.Build;
import com.blankj.utilcode.util.h0;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import kotlin.Metadata;

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
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f61163a = new k();

    public final boolean a() {
        String value;
        Long lN;
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        long j11 = roomAppMMKV.a().getLong("key_download_st_show_last_time", 0L);
        long j12 = roomAppMMKV.a().getLong("key_download_st_showed_times", 0L);
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "key_storage_per_total_show_times", false, 2, null);
        long jLongValue = (configBeanC == null || (value = configBeanC.getValue()) == null || (lN = kotlin.text.k.n(value)) == null) ? 3L : lN.longValue();
        return Build.VERSION.SDK_INT >= 23 && !h0.f(j11) && (jLongValue > 0 ? jLongValue : 3L) > j12;
    }
}
