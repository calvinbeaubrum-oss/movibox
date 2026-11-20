package com.cloud.h5update.utils;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f28917a = new i();

    public final String a(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.f(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            sb2.append(charArray[(b11 >> 4) & 15]);
            sb2.append(charArray[b11 & Ascii.SI]);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "r.toString()");
        return string;
    }

    public final String b(File file) {
        h.a aVar = h.f28910a;
        String strA = "";
        if (!aVar.r(file)) {
            return "";
        }
        InputStream inputStreamN = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                inputStreamN = aVar.n(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    Intrinsics.d(inputStreamN);
                    int i11 = inputStreamN.read(bArr);
                    if (i11 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i11);
                }
                byte[] bArrDigest = messageDigest.digest();
                Intrinsics.f(bArrDigest, "digest.digest()");
                strA = a(bArrDigest);
                h.f28910a.e(inputStreamN);
            } catch (Exception e11) {
                po.b.f73956a.e(e11);
                h.f28910a.e(inputStreamN);
            }
            return strA;
        } catch (Throwable th2) {
            h.f28910a.e(inputStreamN);
            throw th2;
        }
    }
}
