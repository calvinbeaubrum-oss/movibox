package com.transsion.lib_web.zip;

import android.content.Context;
import com.blankj.utilcode.util.k;
import com.transsion.lib_web.zip.db.WebViewCacheConfigData;
import com.transsion.lib_web.zip.loader.WebViewCacheTask;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f53072a = new b();

    public final Object a(Context context, WebViewCacheConfigData webViewCacheConfigData, Continuation<? super Unit> continuation) {
        Object objI;
        return (webViewCacheConfigData.getZipUrl().length() != 0 && (objI = new WebViewCacheTask(context, webViewCacheConfigData).i(continuation)) == kotlin.coroutines.intrinsics.a.e()) ? objI : Unit.f68710a;
    }

    public final void b(Context context, WebViewCacheConfigData cacheConfigData) {
        Intrinsics.g(context, "context");
        Intrinsics.g(cacheConfigData, "cacheConfigData");
        try {
            Result.Companion companion = Result.Companion;
            File fileC = f53072a.c(context, cacheConfigData);
            if (fileC != null && fileC.exists()) {
                ku.a.f69641a.a(fileC);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final File c(Context context, WebViewCacheConfigData configData) {
        Intrinsics.g(context, "context");
        Intrinsics.g(configData, "configData");
        String htmlUrl = configData.getHtmlUrl();
        if (htmlUrl.length() == 0) {
            return null;
        }
        return new File(d(context), k.b(htmlUrl) + "_" + configData.getZipMd5());
    }

    public final File d(Context context) {
        Intrinsics.g(context, "context");
        return new File(context.getCacheDir(), "webViewCache");
    }
}
