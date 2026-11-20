package com.transsion.publish.view;

import android.text.Editable;
import com.transsion.publish.api.LinkEntity;
import kotlin.Metadata;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56708a = 200;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f56709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Editable f56710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkEntity f56711d;

    public final a a() {
        return this.f56709b;
    }

    public final Editable b() {
        return this.f56710c;
    }

    public final int c() {
        return this.f56708a;
    }

    public final LinkEntity d() {
        return this.f56711d;
    }
}
