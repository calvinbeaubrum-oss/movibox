package androidx.collection;

import java.util.ConcurrentModificationException;
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
public final class d {
    public static final <E> void a(b<E> bVar, int i11) {
        Intrinsics.g(bVar, "<this>");
        bVar.s(new int[i11]);
        bVar.r(new Object[i11]);
    }

    public static final <E> int b(b<E> bVar, int i11) {
        Intrinsics.g(bVar, "<this>");
        try {
            return m1.a.a(bVar.f(), bVar.i(), i11);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> int c(b<E> bVar, Object obj, int i11) {
        Intrinsics.g(bVar, "<this>");
        int i12 = bVar.i();
        if (i12 == 0) {
            return -1;
        }
        int iB = b(bVar, i11);
        if (iB < 0 || Intrinsics.b(obj, bVar.e()[iB])) {
            return iB;
        }
        int i13 = iB + 1;
        while (i13 < i12 && bVar.f()[i13] == i11) {
            if (Intrinsics.b(obj, bVar.e()[i13])) {
                return i13;
            }
            i13++;
        }
        for (int i14 = iB - 1; i14 >= 0 && bVar.f()[i14] == i11; i14--) {
            if (Intrinsics.b(obj, bVar.e()[i14])) {
                return i14;
            }
        }
        return ~i13;
    }

    public static final <E> int d(b<E> bVar) {
        Intrinsics.g(bVar, "<this>");
        return c(bVar, null, 0);
    }
}
