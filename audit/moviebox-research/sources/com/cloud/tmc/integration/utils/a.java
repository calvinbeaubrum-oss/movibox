package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31023a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f31024b = "";

    @JvmStatic
    @RequiresApi(api = 19)
    public static final String a(String privateString) {
        Intrinsics.g(privateString, "privateString");
        a aVar = f31023a;
        try {
            byte[] bytes = aVar.b().getBytes(Charsets.f69091b);
            Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] bArr = new byte[12];
            new SecureRandom().nextBytes(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr));
            Charset charsetForName = Charset.forName("UTF8");
            Intrinsics.f(charsetForName, "forName(charsetName)");
            byte[] bytes2 = privateString.getBytes(charsetForName);
            Intrinsics.f(bytes2, "this as java.lang.String).getBytes(charset)");
            byte[] bArrDoFinal = cipher.doFinal(bytes2);
            byte[] bArr2 = new byte[bArrDoFinal.length + 12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(bArrDoFinal, 0, bArr2, 12, bArrDoFinal.length);
            return aVar.f(bArr2);
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public final String b() {
        if (TextUtils.isEmpty(f31024b)) {
            f31024b = "sOWGI8Lv" + c(1, 2) + e() + d();
        }
        return f31024b;
    }

    public final String c(int i11, int i12) {
        int i13 = i11 * i12;
        if (1 <= i13) {
            while (true) {
                int i14 = ((i14 % i11 == 0 && i14 % i12 == 0) || i14 == i13) ? 1 : i14 + 1;
            }
        }
        return "FnvyH19r";
    }

    public final String d() {
        return "rUOL6ott";
    }

    public final String e() {
        return "s2DytdII";
    }

    public final String f(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b11 : bArr) {
            String string = Integer.toString(b11 & 255, kotlin.text.a.a(16));
            Intrinsics.f(string, "toString(this, checkRadix(radix))");
            if (string.length() == 1) {
                string = '0' + string;
            }
            String upperCase = string.toUpperCase();
            Intrinsics.f(upperCase, "this as java.lang.String).toUpperCase()");
            stringBuffer.append(upperCase);
        }
        return stringBuffer.toString();
    }
}
