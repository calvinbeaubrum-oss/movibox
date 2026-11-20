package androidx.compose.runtime;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3556e;

    public q0(int i11, Object obj, int i12, int i13, int i14) {
        this.f3552a = i11;
        this.f3553b = obj;
        this.f3554c = i12;
        this.f3555d = i13;
        this.f3556e = i14;
    }

    public final int a() {
        return this.f3552a;
    }

    public final int b() {
        return this.f3554c;
    }

    public final int c() {
        return this.f3555d;
    }

    public final Object d() {
        return this.f3553b;
    }
}
