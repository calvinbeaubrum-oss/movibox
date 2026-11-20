package com.transsion.subtitle.fragment;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f58235c;

    public g(String name, int i11, int i12) {
        Intrinsics.g(name, "name");
        this.f58233a = name;
        this.f58234b = i11;
        this.f58235c = i12;
    }

    public final int a() {
        return this.f58235c;
    }

    public final String b() {
        return this.f58233a;
    }

    public final int c() {
        return this.f58234b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.b(this.f58233a, gVar.f58233a) && this.f58234b == gVar.f58234b && this.f58235c == gVar.f58235c;
    }

    public int hashCode() {
        return (((this.f58233a.hashCode() * 31) + this.f58234b) * 31) + this.f58235c;
    }

    public String toString() {
        return "SubtitleSearchKeyword(name=" + this.f58233a + ", season=" + this.f58234b + ", episode=" + this.f58235c + ")";
    }
}
