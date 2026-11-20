package com.transsion.postdetail.util;

import android.annotation.SuppressLint;
import com.blankj.utilcode.util.h0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class i {
    public static final String a(long j11) {
        int i11 = Calendar.getInstance().get(1);
        String strI = h0.i(j11, h0.d("yyyy-MM-dd HH:mm:ss"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(h0.j(strI));
        if (i11 == calendar.get(1)) {
            String strI2 = h0.i(j11, h0.d("MM-dd HH:mm"));
            Intrinsics.f(strI2, "{\n        TimeUtils.mill…mat(\"MM-dd HH:mm\"))\n    }");
            return strI2;
        }
        String strI3 = h0.i(j11, h0.d("yyyy-MM-dd HH:mm"));
        Intrinsics.f(strI3, "{\n        TimeUtils.mill…yyyy-MM-dd HH:mm\"))\n    }");
        return strI3;
    }

    public static final String b(long j11) {
        if (j11 == 0) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        int i11 = calendar.get(1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j11);
        boolean z11 = calendar2.get(1) == i11;
        boolean z12 = calendar2.get(6) == Calendar.getInstance().get(6);
        if (z11 && z12) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j11));
            Intrinsics.f(str, "SimpleDateFormat(\"HH:mm\"…).format(Date(timestamp))");
            return str;
        }
        if (!z11 || z12) {
            String str2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j11));
            Intrinsics.f(str2, "SimpleDateFormat(\"dd/MM/…).format(Date(timestamp))");
            return str2;
        }
        String str3 = new SimpleDateFormat("dd/MM", Locale.getDefault()).format(new Date(j11));
        Intrinsics.f(str3, "SimpleDateFormat(\"dd/MM\"…).format(Date(timestamp))");
        return str3;
    }

    public static final String c(int i11) {
        Object objValueOf;
        Object objValueOf2;
        int i12 = i11 / 1000;
        int i13 = i12 % 60;
        int i14 = (i12 / 60) % 60;
        int i15 = i12 / 3600;
        if (i15 <= 0) {
            Object objValueOf3 = i14 > 0 ? Integer.valueOf(i14) : "0";
            if (i13 < 10) {
                objValueOf = "0" + i13;
            } else {
                objValueOf = Integer.valueOf(i13);
            }
            return objValueOf3 + ":" + objValueOf;
        }
        if (i13 < 10) {
            objValueOf2 = "0" + i13;
        } else {
            objValueOf2 = Integer.valueOf(i13);
        }
        return i15 + ":" + i14 + ":" + objValueOf2;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static final String d(long j11) {
        SimpleDateFormat simpleDateFormat = j11 >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String str = simpleDateFormat.format(Long.valueOf(j11));
        Intrinsics.f(str, "format.format(mislls)");
        return str;
    }
}
