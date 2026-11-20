package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
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
public class k extends j {
    public static <T> boolean A(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.g(collection, "<this>");
        Intrinsics.g(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> boolean B(Collection<? super T> collection, T[] elements) {
        Intrinsics.g(collection, "<this>");
        Intrinsics.g(elements, "elements");
        return collection.addAll(ArraysKt___ArraysJvmKt.g(elements));
    }

    public static <T> Collection<T> C(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = CollectionsKt___CollectionsKt.J0(iterable);
        }
        return (Collection) iterable;
    }

    public static final <T> boolean D(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z11) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z11) {
                it.remove();
                z12 = true;
            }
        }
        return z12;
    }

    public static final <T> boolean E(List<T> list, Function1<? super T, Boolean> function1, boolean z11) {
        if (!(list instanceof RandomAccess)) {
            Intrinsics.e(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return D(TypeIntrinsics.b(list), function1, z11);
        }
        IntIterator it = new IntRange(0, g.n(list)).iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int iA = it.a();
            T t11 = list.get(iA);
            if (function1.invoke(t11).booleanValue() != z11) {
                if (i11 != iA) {
                    list.set(i11, t11);
                }
                i11++;
            }
        }
        if (i11 >= list.size()) {
            return false;
        }
        int iN = g.n(list);
        if (i11 > iN) {
            return true;
        }
        while (true) {
            list.remove(iN);
            if (iN == i11) {
                return true;
            }
            iN--;
        }
    }

    public static <T> boolean F(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(predicate, "predicate");
        return D(iterable, predicate, true);
    }

    public static <T> boolean G(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(list, "<this>");
        Intrinsics.g(predicate, "predicate");
        return E(list, predicate, true);
    }

    @SinceKotlin
    @WasExperimental
    public static <T> T H(List<T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @SinceKotlin
    @WasExperimental
    public static <T> T I(List<T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @SinceKotlin
    @WasExperimental
    public static <T> T J(List<T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(g.n(list));
    }

    public static <T> boolean K(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(predicate, "predicate");
        return D(iterable, predicate, false);
    }

    public static final <T> boolean L(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.g(collection, "<this>");
        Intrinsics.g(elements, "elements");
        return collection.retainAll(C(elements));
    }

    public static <T> boolean M(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(list, "<this>");
        Intrinsics.g(predicate, "predicate");
        return E(list, predicate, false);
    }
}
