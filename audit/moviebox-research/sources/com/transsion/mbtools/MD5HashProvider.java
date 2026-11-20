package com.transsion.mbtools;

import android.os.Build;
import com.applovin.exoplayer2.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.b;
import kotlin.text.n;

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
public final class MD5HashProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MD5HashProvider f53123a = new MD5HashProvider();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f53124b = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.transsion.mbtools.MD5HashProvider$SYSTEM_SALT$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String ID = Build.ID;
            Intrinsics.f(ID, "ID");
            String strSubstring = ID.substring(0, 4);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.f(MANUFACTURER, "MANUFACTURER");
            return strSubstring + n.e1(MANUFACTURER);
        }
    });

    public final String a(String content) throws NoSuchAlgorithmException {
        Intrinsics.g(content, "content");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = (b() + content).getBytes(Charsets.f69091b);
        Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] hashBytes = messageDigest.digest(bytes);
        StringBuilder sb2 = new StringBuilder();
        Intrinsics.f(hashBytes, "hashBytes");
        for (byte b11 : hashBytes) {
            sb2.append(b.f((b11 & 255) >> 4, 16));
            sb2.append(b.f(b11 & Ascii.SI, 16));
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String b() {
        return (String) f53124b.getValue();
    }
}
