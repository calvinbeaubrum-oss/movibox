package com.cloud.tmc.offline.download.utils;

import com.cloud.tmc.kernel.log.TmcLogger;
import java.text.DecimalFormat;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32086a = new a();

    public static /* synthetic */ String b(a aVar, long j11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1024;
        }
        return aVar.a(j11, i11);
    }

    public final String a(long j11, int i11) {
        DecimalFormat decimalFormat = new DecimalFormat("####.00");
        String string = "0 B";
        if (j11 >= 0) {
            try {
                if (j11 < i11) {
                    string = j11 + " B";
                } else {
                    int i12 = i11 * i11;
                    if (j11 < i12) {
                        string = decimalFormat.format(j11 / ((double) i11)) + " KB";
                    } else if (j11 < i12 * i11) {
                        StringBuilder sb2 = new StringBuilder();
                        double d11 = i11;
                        sb2.append(decimalFormat.format((j11 / d11) / d11));
                        sb2.append(" MB");
                        string = sb2.toString();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        double d12 = i11;
                        sb3.append(decimalFormat.format(((j11 / d12) / d12) / d12));
                        sb3.append(" GB");
                        string = sb3.toString();
                    }
                }
            } catch (Throwable th2) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("convert size to ");
                sb4.append(j11);
                sb4.append(" is failed.");
                TmcLogger.g("TmcOfflineDownload: ConvertUtils", sb4.toString(), th2);
            }
        }
        return string;
    }
}
