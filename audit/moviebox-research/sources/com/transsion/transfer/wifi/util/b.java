package com.transsion.transfer.wifi.util;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f59245a = new b();

    public final String a(String s11) {
        Intrinsics.g(s11, "s");
        if (TextUtils.isEmpty(s11)) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = s11.getBytes(Charsets.f69091b);
            Intrinsics.f(bytes, "getBytes(...)");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] md2 = messageDigest.digest();
            char[] cArr2 = new char[md2.length * 2];
            Intrinsics.f(md2, "md");
            int i11 = 0;
            for (byte b11 : md2) {
                int i12 = i11 + 1;
                cArr2[i11] = cArr[(b11 >>> 4) & 15];
                i11 += 2;
                cArr2[i12] = cArr[b11 & Ascii.SI];
            }
            return new String(cArr2);
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
