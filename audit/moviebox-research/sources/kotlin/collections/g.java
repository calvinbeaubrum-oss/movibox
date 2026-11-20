package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public class g extends f {
    public static <T> ArrayList<T> h(T... elements) {
        Intrinsics.g(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new a(elements, true));
    }

    public static final <T> Collection<T> i(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        return new a(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int j(List<? extends T> list, T t11, int i11, int i12) {
        Intrinsics.g(list, "<this>");
        s(list.size(), i11, i12);
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int iD = kotlin.comparisons.b.d(list.get(i14), t11);
            if (iD < 0) {
                i11 = i14 + 1;
            } else {
                if (iD <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static /* synthetic */ int k(List list, Comparable comparable, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = list.size();
        }
        return j(list, comparable, i11, i12);
    }

    public static <T> List<T> l() {
        return EmptyList.INSTANCE;
    }

    public static IntRange m(Collection<?> collection) {
        Intrinsics.g(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int n(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> o(T... elements) {
        Intrinsics.g(elements, "elements");
        return elements.length > 0 ? ArraysKt___ArraysJvmKt.g(elements) : l();
    }

    public static <T> List<T> p(T... elements) {
        Intrinsics.g(elements, "elements");
        return d.M(elements);
    }

    public static <T> List<T> q(T... elements) {
        Intrinsics.g(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new a(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> r(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : f.e(list.get(0));
        }
        return l();
    }

    public static final void s(int i11, int i12, int i13) {
        if (i12 > i13) {
            throw new IllegalArgumentException("fromIndex (" + i12 + ") is greater than toIndex (" + i13 + ").");
        }
        if (i12 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i12 + ") is less than zero.");
        }
        if (i13 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i13 + ") is greater than size (" + i11 + ").");
    }

    @SinceKotlin
    @PublishedApi
    public static void t() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin
    @PublishedApi
    public static void u() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
