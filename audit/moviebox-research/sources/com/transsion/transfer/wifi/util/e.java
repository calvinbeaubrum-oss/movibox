package com.transsion.transfer.wifi.util;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f59248a = new e();

    public final Map<String, String> a(String urlString) {
        Object objM163constructorimpl;
        Intrinsics.g(urlString, "urlString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Result.Companion companion = Result.Companion;
            Uri uri = Uri.parse(urlString);
            Intrinsics.f(uri, "parse(urlString)");
            linkedHashMap.put("urlPath", uri.getPath());
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Intrinsics.f(queryParameterNames, "uri.queryParameterNames");
            for (String str : queryParameterNames) {
                linkedHashMap.put(str, uri.getQueryParameter(str));
            }
            objM163constructorimpl = Result.m163constructorimpl(linkedHashMap);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Object obj = linkedHashMap;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
            obj = objM163constructorimpl;
        }
        return (Map) obj;
    }
}
