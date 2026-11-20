package t1;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
public final class x {
    public static final int f(int i11, int i12) {
        return (i11 >> i12) & 31;
    }

    public static final <K, V> Object[] g(Object[] objArr, int i11, K k11, V v11) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt___ArraysJvmKt.p(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt___ArraysJvmKt.l(objArr, objArr2, i11 + 2, i11, objArr.length);
        objArr2[i11] = k11;
        objArr2[i11 + 1] = v11;
        return objArr2;
    }

    public static final Object[] h(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt___ArraysJvmKt.p(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt___ArraysJvmKt.l(objArr, objArr2, i11, i11 + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] i(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.p(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt___ArraysJvmKt.l(objArr, objArr2, i11, i11 + 1, objArr.length);
        return objArr2;
    }

    public static final Object[] j(Object[] objArr, int i11, int i12, t<?, ?> tVar) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.p(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt___ArraysJvmKt.l(objArr, objArr2, i11, i11 + 2, i12);
        objArr2[i12 - 2] = tVar;
        ArraysKt___ArraysJvmKt.l(objArr, objArr2, i12 - 1, i12, objArr.length);
        return objArr2;
    }

    public static final <K, V> Object[] k(Object[] objArr, int i11, int i12, K k11, V v11) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        ArraysKt___ArraysJvmKt.l(objArrCopyOf, objArrCopyOf, i11 + 2, i11 + 1, objArr.length);
        ArraysKt___ArraysJvmKt.l(objArrCopyOf, objArrCopyOf, i12 + 2, i12, i11);
        objArrCopyOf[i12] = k11;
        objArrCopyOf[i12 + 1] = v11;
        return objArrCopyOf;
    }
}
