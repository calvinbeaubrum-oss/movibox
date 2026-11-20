package com.transsion.baselib.utils;

import android.location.Location;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f51319a = new l();

    public final String a(double d11, double d12, double d13, double d14) {
        float f11;
        try {
            float[] fArr = new float[1];
            Location.distanceBetween(d11, d12, d13, d14, fArr);
            f11 = fArr[0];
        } catch (Throwable unused) {
            f11 = -1.0f;
        }
        if (f11 < 0.1f) {
            return "<0.1m";
        }
        if (f11 < 1000.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format("%.1fm", Arrays.copyOf(new Object[]{Float.valueOf(f11)}, 1));
            Intrinsics.f(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
        String str2 = String.format("%.1fkm", Arrays.copyOf(new Object[]{Float.valueOf(f11 / 1000)}, 1));
        Intrinsics.f(str2, "format(...)");
        return str2;
    }

    public final float b(double d11, double d12, double d13, double d14) {
        try {
            float[] fArr = new float[1];
            Location.distanceBetween(d11, d12, d13, d14, fArr);
            return fArr[0];
        } catch (Throwable unused) {
            return -1.0f;
        }
    }
}
