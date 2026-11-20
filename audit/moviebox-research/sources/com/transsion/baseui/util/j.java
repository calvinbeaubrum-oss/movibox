package com.transsion.baseui.util;

import android.annotation.SuppressLint;
import java.math.BigDecimal;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class j {
    public static final String a(long j11) {
        if (j11 < 0) {
            uo.b.a.f(uo.b.f78622a, "error", "formatNumber count< 0", false, 4, null);
            return "0";
        }
        if (j11 < 1000) {
            return String.valueOf(j11);
        }
        if (j11 < 1000000) {
            BigDecimal bigDecimalDivide = new BigDecimal(j11).divide(new BigDecimal(1000), 1, 4);
            Intrinsics.f(bigDecimalDivide, "bigDecimal.divide(BigDec…BigDecimal.ROUND_HALF_UP)");
            return bigDecimalDivide + " k";
        }
        BigDecimal bigDecimalDivide2 = new BigDecimal(j11).divide(new BigDecimal(1000000), 1, 4);
        Intrinsics.f(bigDecimalDivide2, "bigDecimal.divide(BigDec…BigDecimal.ROUND_HALF_UP)");
        return bigDecimalDivide2 + " m";
    }

    @SuppressLint({"DefaultLocale"})
    public static final String b(Integer num) {
        if (num == null) {
            return "";
        }
        num.intValue();
        return (num.intValue() / 3600) + "h " + ((num.intValue() % 3600) / 60) + "m";
    }
}
