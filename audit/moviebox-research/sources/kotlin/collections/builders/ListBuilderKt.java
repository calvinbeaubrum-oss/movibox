package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ListBuilderKt {
    public static final <E> E[] d(int i11) {
        if (i11 >= 0) {
            return (E[]) new Object[i11];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] e(T[] tArr, int i11) {
        Intrinsics.g(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i11);
        Intrinsics.f(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void f(E[] eArr, int i11) {
        Intrinsics.g(eArr, "<this>");
        eArr[i11] = null;
    }

    public static final <E> void g(E[] eArr, int i11, int i12) {
        Intrinsics.g(eArr, "<this>");
        while (i11 < i12) {
            f(eArr, i11);
            i11++;
        }
    }

    public static final <T> boolean h(T[] tArr, int i11, int i12, List<?> list) {
        if (i12 != list.size()) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!Intrinsics.b(tArr[i11 + i13], list.get(i13))) {
                return false;
            }
        }
        return true;
    }

    public static final <T> int i(T[] tArr, int i11, int i12) {
        int iHashCode = 1;
        for (int i13 = 0; i13 < i12; i13++) {
            T t11 = tArr[i11 + i13];
            iHashCode = (iHashCode * 31) + (t11 != null ? t11.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final <T> String j(T[] tArr, int i11, int i12, Collection<? extends T> collection) {
        StringBuilder sb2 = new StringBuilder((i12 * 3) + 2);
        sb2.append("[");
        for (int i13 = 0; i13 < i12; i13++) {
            if (i13 > 0) {
                sb2.append(", ");
            }
            T t11 = tArr[i11 + i13];
            if (t11 == collection) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(t11);
            }
        }
        sb2.append("]");
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }
}
