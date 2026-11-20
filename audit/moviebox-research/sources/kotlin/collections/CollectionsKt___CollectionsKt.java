package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public class CollectionsKt___CollectionsKt extends m {
    public static <T> T A0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) B0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T B0(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> T C0(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T extends Comparable<? super T>> List<T> D0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listL0 = L0(iterable);
            j.y(listL0);
            return listL0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return J0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        ArraysKt___ArraysJvmKt.B((Comparable[]) array);
        return ArraysKt___ArraysJvmKt.g(array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> E0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listL0 = L0(iterable);
            j.z(listL0, comparator);
            return listL0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return J0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        ArraysKt___ArraysJvmKt.C(array, comparator);
        return ArraysKt___ArraysJvmKt.g(array);
    }

    public static <T> List<T> F0(Iterable<? extends T> iterable, int i11) {
        Intrinsics.g(iterable, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        }
        if (i11 == 0) {
            return g.l();
        }
        if (iterable instanceof Collection) {
            if (i11 >= ((Collection) iterable).size()) {
                return J0(iterable);
            }
            if (i11 == 1) {
                return f.e(d0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i11);
        Iterator<? extends T> it = iterable.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i12++;
            if (i12 == i11) {
                break;
            }
        }
        return g.r(arrayList);
    }

    public static <T> List<T> G0(List<? extends T> list, int i11) {
        Intrinsics.g(list, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        }
        if (i11 == 0) {
            return g.l();
        }
        int size = list.size();
        if (i11 >= size) {
            return J0(list);
        }
        if (i11 == 1) {
            return f.e(q0(list));
        }
        ArrayList arrayList = new ArrayList(i11);
        if (list instanceof RandomAccess) {
            for (int i12 = size - i11; i12 < size; i12++) {
                arrayList.add(list.get(i12));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i11);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C H0(Iterable<? extends T> iterable, C destination) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static int[] I0(Collection<Integer> collection) {
        Intrinsics.g(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = it.next().intValue();
            i11++;
        }
        return iArr;
    }

    public static <T> List<T> J0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return g.r(L0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return g.l();
        }
        if (size != 1) {
            return M0(collection);
        }
        return f.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static long[] K0(Collection<Long> collection) {
        Intrinsics.g(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            jArr[i11] = it.next().longValue();
            i11++;
        }
        return jArr;
    }

    public static final <T> List<T> L0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        return iterable instanceof Collection ? M0((Collection) iterable) : (List) H0(iterable, new ArrayList());
    }

    public static <T> List<T> M0(Collection<? extends T> collection) {
        Intrinsics.g(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final <T> Set<T> N0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) H0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> O0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return w.h((Set) H0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return w.f();
        }
        if (size != 1) {
            return (Set) H0(iterable, new LinkedHashSet(r.e(collection.size())));
        }
        return v.d(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @SinceKotlin
    public static final <T> List<List<T>> P0(Iterable<? extends T> iterable, int i11, int i12, boolean z11) {
        Intrinsics.g(iterable, "<this>");
        SlidingWindowKt.a(i11, i12);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = SlidingWindowKt.b(iterable.iterator(), i11, i12, z11, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i12) + (size % i12 == 0 ? 0 : 1));
        int i13 = 0;
        while (i13 >= 0 && i13 < size) {
            int iG = kotlin.ranges.a.g(i11, size - i13);
            if (iG < i11 && !z11) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iG);
            for (int i14 = 0; i14 < iG; i14++) {
                arrayList3.add(list.get(i14 + i13));
            }
            arrayList2.add(arrayList3);
            i13 += i12;
        }
        return arrayList2;
    }

    public static <T, R> List<Pair<T, R>> Q0(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(h.v(iterable, 10), h.v(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> Sequence<T> V(final Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    @SinceKotlin
    public static <T> List<List<T>> W(Iterable<? extends T> iterable, int i11) {
        Intrinsics.g(iterable, "<this>");
        return P0(iterable, i11, i11, true);
    }

    public static <T> boolean X(Iterable<? extends T> iterable, T t11) {
        Intrinsics.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t11);
        }
        return i0(iterable, t11) >= 0;
    }

    public static <T> List<T> Y(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        return J0(N0(iterable));
    }

    public static <T> List<T> Z(Iterable<? extends T> iterable, int i11) {
        ArrayList arrayList;
        Intrinsics.g(iterable, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        }
        if (i11 == 0) {
            return J0(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i11;
            if (size <= 0) {
                return g.l();
            }
            if (size == 1) {
                return f.e(p0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i11 < size2) {
                        arrayList.add(((List) iterable).get(i11));
                        i11++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i11);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i12 = 0;
        for (T t11 : iterable) {
            if (i12 >= i11) {
                arrayList.add(t11);
            } else {
                i12++;
            }
        }
        return g.r(arrayList);
    }

    public static <T> List<T> a0(List<? extends T> list, int i11) {
        Intrinsics.g(list, "<this>");
        if (i11 >= 0) {
            return F0(list, kotlin.ranges.a.d(list.size() - i11, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static <T> List<T> b0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        return (List) c0(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C c0(Iterable<? extends T> iterable, C destination) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(destination, "destination");
        for (T t11 : iterable) {
            if (t11 != null) {
                destination.add(t11);
            }
        }
        return destination;
    }

    public static <T> T d0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) e0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T e0(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T f0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T g0(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T h0(List<? extends T> list, int i11) {
        Intrinsics.g(list, "<this>");
        if (i11 < 0 || i11 > g.n(list)) {
            return null;
        }
        return list.get(i11);
    }

    public static final <T> int i0(Iterable<? extends T> iterable, T t11) {
        Intrinsics.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t11);
        }
        int i11 = 0;
        for (T t12 : iterable) {
            if (i11 < 0) {
                g.u();
            }
            if (Intrinsics.b(t11, t12)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static <T> int j0(List<? extends T> list, T t11) {
        Intrinsics.g(list, "<this>");
        return list.indexOf(t11);
    }

    public static <T> Set<T> k0(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(other, "other");
        Set<T> setN0 = N0(iterable);
        k.L(setN0, other);
        return setN0;
    }

    public static final <T, A extends Appendable> A l0(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(buffer, "buffer");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        buffer.append(prefix);
        int i12 = 0;
        for (T t11 : iterable) {
            i12++;
            if (i12 > 1) {
                buffer.append(separator);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            kotlin.text.e.a(buffer, t11, function1);
        }
        if (i11 >= 0 && i12 > i11) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable m0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        return l0(iterable, appendable, (charSequence & 2) != 0 ? ", " : charSequence, (charSequence & 4) != 0 ? "" : charSequence2, (charSequence & 8) == 0 ? charSequence3 : "", (charSequence & 16) != 0 ? -1 : i11, (charSequence & 32) != 0 ? "..." : charSequence4, (charSequence & 64) != 0 ? null : function1);
    }

    public static final <T> String n0(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        String string = ((StringBuilder) l0(iterable, new StringBuilder(), separator, prefix, postfix, i11, truncated, function1)).toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String o0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        int i13 = (i12 & 8) != 0 ? -1 : i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return n0(iterable, charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    public static <T> T p0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) q0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T q0(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(g.n(list));
    }

    public static <T> T r0(List<? extends T> list) {
        Intrinsics.g(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @SinceKotlin
    public static <T extends Comparable<? super T>> T s0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin
    public static <T> T t0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin
    public static <T extends Comparable<? super T>> T u0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> v0(Iterable<? extends T> iterable, T t11) {
        Intrinsics.g(iterable, "<this>");
        ArrayList arrayList = new ArrayList(h.v(iterable, 10));
        boolean z11 = false;
        for (T t12 : iterable) {
            boolean z12 = true;
            if (!z11 && Intrinsics.b(t12, t11)) {
                z11 = true;
                z12 = false;
            }
            if (z12) {
                arrayList.add(t12);
            }
        }
        return arrayList;
    }

    public static <T> List<T> w0(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(elements, "elements");
        if (iterable instanceof Collection) {
            return x0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        k.A(arrayList, iterable);
        k.A(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> x0(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.g(collection, "<this>");
        Intrinsics.g(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            k.A(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> y0(Collection<? extends T> collection, T t11) {
        Intrinsics.g(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t11);
        return arrayList;
    }

    public static <T> List<T> z0(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return J0(iterable);
        }
        List<T> listL0 = L0(iterable);
        m.U(listL0);
        return listL0;
    }
}
