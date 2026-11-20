package com.transsion.player.longvideo.helper;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

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
public final class w extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<Pair<String, String>> f54444a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<vx.a> f54445b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<List<vx.a>> f54446c = new c0<>();

    public final c0<vx.a> b() {
        return this.f54445b;
    }

    public final c0<List<vx.a>> c() {
        return this.f54446c;
    }

    public final c0<Pair<String, String>> d() {
        return this.f54444a;
    }
}
