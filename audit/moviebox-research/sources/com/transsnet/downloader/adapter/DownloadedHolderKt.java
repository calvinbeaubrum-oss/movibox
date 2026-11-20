package com.transsnet.downloader.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.baseui.image.ImageHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class DownloadedHolderKt {
    public static final void a(Context context, ImageView imageView, String url, String str) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        Intrinsics.g(url, "url");
        if (!StringsKt__StringsKt.Q(url, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new DownloadedHolderKt$loadImageWithBuiltIn$1(context, url, imageView, null), 3, null);
            return;
        }
        int iA = com.blankj.utilcode.util.f0.a(120.0f);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        companion.q(context, imageView, url, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : str == null ? "" : str, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }
}
