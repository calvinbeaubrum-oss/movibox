package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f2005a = new Object();

    public static final <E> E c(w0<E> w0Var, int i11) {
        E e11;
        Intrinsics.g(w0Var, "<this>");
        int iA = m1.a.a(w0Var.f2002b, w0Var.f2004d, i11);
        if (iA < 0 || (e11 = (E) w0Var.f2003c[iA]) == f2005a) {
            return null;
        }
        return e11;
    }

    public static final <E> E d(w0<E> w0Var, int i11, E e11) {
        E e12;
        Intrinsics.g(w0Var, "<this>");
        int iA = m1.a.a(w0Var.f2002b, w0Var.f2004d, i11);
        return (iA < 0 || (e12 = (E) w0Var.f2003c[iA]) == f2005a) ? e11 : e12;
    }

    public static final <E> void e(w0<E> w0Var, int i11) {
        Intrinsics.g(w0Var, "<this>");
        int iA = m1.a.a(w0Var.f2002b, w0Var.f2004d, i11);
        if (iA >= 0) {
            Object[] objArr = w0Var.f2003c;
            Object obj = objArr[iA];
            Object obj2 = f2005a;
            if (obj != obj2) {
                objArr[iA] = obj2;
                w0Var.f2001a = true;
            }
        }
    }

    public static final <E> void f(w0<E> w0Var) {
        int i11 = w0Var.f2004d;
        int[] iArr = w0Var.f2002b;
        Object[] objArr = w0Var.f2003c;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != f2005a) {
                if (i13 != i12) {
                    iArr[i12] = iArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        w0Var.f2001a = false;
        w0Var.f2004d = i12;
    }
}
