package com.transsion.player.longvideo.helper;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mv.i f54409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f54410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kv.a.b f54411c;

    public final kv.a.b a() {
        return this.f54411c;
    }

    public final mv.i b() {
        return this.f54409a;
    }

    public void c(String str, mv.i viewBinding) {
        Intrinsics.g(viewBinding, "viewBinding");
        this.f54410b = str;
        this.f54409a = viewBinding;
    }

    public final void d(kv.a.b bVar) {
        this.f54411c = bVar;
    }
}
