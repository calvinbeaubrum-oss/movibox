package com.transsion.baseui.image.blurhash;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BlurHash {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f51387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LruCache<String, BitmapDrawable> f51389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f51390d;

    public BlurHash(Context context, int i11, float f11) {
        Intrinsics.g(context, "context");
        this.f51387a = context;
        this.f51388b = f11;
        this.f51389c = new LruCache<>(i11);
        this.f51390d = l0.a(w0.c());
    }

    public final void e(String str, BitmapDrawable bitmapDrawable) {
        this.f51389c.put(str, bitmapDrawable);
    }

    public final void f(String blurString, int i11, int i12, Function1<? super BitmapDrawable, Unit> response) {
        Intrinsics.g(blurString, "blurString");
        Intrinsics.g(response, "response");
        j.d(this.f51390d, null, null, new BlurHash$execute$1(this, blurString, response, i11, i12, null), 3, null);
    }

    public final BitmapDrawable g(String str) {
        return this.f51389c.get(str);
    }
}
