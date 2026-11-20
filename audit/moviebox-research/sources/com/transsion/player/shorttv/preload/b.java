package com.transsion.player.shorttv.preload;

import androidx.media3.common.b0;
import androidx.media3.exoplayer.offline.DownloadRequest;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z3.u0;

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
public final class b extends androidx.media3.exoplayer.offline.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.datasource.cache.a.c f54798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f54799e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(androidx.media3.datasource.cache.a.c cacheDataSourceFactory, Executor executor) {
        super(cacheDataSourceFactory, executor);
        Intrinsics.g(cacheDataSourceFactory, "cacheDataSourceFactory");
        Intrinsics.g(executor, "executor");
        this.f54798d = cacheDataSourceFactory;
        this.f54799e = executor;
    }

    @Override // androidx.media3.exoplayer.offline.b, androidx.media3.exoplayer.offline.p
    public androidx.media3.exoplayer.offline.o a(DownloadRequest request) {
        Intrinsics.g(request, "request");
        int iC0 = u0.C0(request.uri, request.mimeType);
        if (iC0 == 0 || iC0 == 1 || iC0 == 2) {
            androidx.media3.exoplayer.offline.o oVarA = super.a(request);
            Intrinsics.f(oVarA, "super.createDownloader(\n…    request\n            )");
            return oVarA;
        }
        if (iC0 == 4) {
            return new VideoProgressiveDownloader(new b0.c().i(request.uri).b(request.customCacheKey).a(), this.f54798d, this.f54799e);
        }
        throw new IllegalArgumentException("Unsupported type: " + iC0);
    }
}
