package androidx.compose.animation.core;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class p {
    public static final k a(float f11) {
        return new k(f11);
    }

    public static final l b(float f11, float f12) {
        return new l(f11, f12);
    }

    public static final m c(float f11, float f12, float f13) {
        return new m(f11, f12, f13);
    }

    public static final n d(float f11, float f12, float f13, float f14) {
        return new n(f11, f12, f13, f14);
    }

    public static final <T extends o> T e(T t11) {
        T t12 = (T) g(t11);
        int iB = t12.b();
        for (int i11 = 0; i11 < iB; i11++) {
            t12.e(i11, t11.a(i11));
        }
        return t12;
    }

    public static final <T extends o> void f(T t11, T t12) {
        int iB = t11.b();
        for (int i11 = 0; i11 < iB; i11++) {
            t11.e(i11, t12.a(i11));
        }
    }

    public static final <T extends o> T g(T t11) {
        T t12 = (T) t11.c();
        Intrinsics.e(t12, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return t12;
    }
}
