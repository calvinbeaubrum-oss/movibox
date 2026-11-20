package com.transsion.transfer.impl.util;

import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.d;
import kotlin.jvm.functions.Function1;
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
public final class StringExtKt {
    public static final String a(String str) {
        Object objM163constructorimpl;
        Intrinsics.g(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(Charsets.f69091b);
            Intrinsics.f(bytes, "getBytes(...)");
            byte[] digest = messageDigest.digest(bytes);
            Intrinsics.f(digest, "digest");
            objM163constructorimpl = Result.m163constructorimpl(d.h0(digest, "", null, null, 0, null, new Function1<Byte, CharSequence>() { // from class: com.transsion.transfer.impl.util.StringExtKt$md5$1$1
                public final CharSequence invoke(byte b11) {
                    String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b11)}, 1));
                    Intrinsics.f(str2, "format(...)");
                    return str2;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Byte b11) {
                    return invoke(b11.byteValue());
                }
            }, 30, null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Object obj = str;
        if (!Result.m169isFailureimpl(objM163constructorimpl)) {
            obj = objM163constructorimpl;
        }
        return (String) obj;
    }
}
