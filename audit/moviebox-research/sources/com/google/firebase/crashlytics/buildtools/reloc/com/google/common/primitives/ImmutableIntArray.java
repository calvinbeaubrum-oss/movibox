package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: compiled from: source.java */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        public AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i11 = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i12 = i11 + 1;
                    if (this.parent.array[i11] == ((Integer) obj2).intValue()) {
                        i11 = i12;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i11) {
            return Integer.valueOf(this.parent.get(i11));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Integer> spliterator() {
            return this.parent.spliterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i11, int i12) {
            return this.parent.subArray(i11, i12).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f39873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39874b = 0;

        public b(int i11) {
            this.f39873a = new int[i11];
        }

        public static int f(int i11, int i12) {
            if (i12 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i11 + (i11 >> 1) + 1;
            if (iHighestOneBit < i12) {
                iHighestOneBit = Integer.highestOneBit(i12 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }

        public b a(int i11) {
            e(1);
            int[] iArr = this.f39873a;
            int i12 = this.f39874b;
            iArr[i12] = i11;
            this.f39874b = i12 + 1;
            return this;
        }

        public b b(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().intValue());
            }
            return this;
        }

        public b c(Collection<Integer> collection) {
            e(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f39873a;
                int i11 = this.f39874b;
                this.f39874b = i11 + 1;
                iArr[i11] = num.intValue();
            }
            return this;
        }

        public ImmutableIntArray d() {
            if (this.f39874b == 0) {
                return ImmutableIntArray.EMPTY;
            }
            return new ImmutableIntArray(this.f39873a, 0, this.f39874b);
        }

        public final void e(int i11) {
            int i12 = this.f39874b + i11;
            int[] iArr = this.f39873a;
            if (i12 > iArr.length) {
                int[] iArr2 = new int[f(iArr.length, i12)];
                System.arraycopy(this.f39873a, 0, iArr2, 0, this.f39874b);
                this.f39873a = iArr2;
            }
        }
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    private ImmutableIntArray(int[] iArr, int i11, int i12) {
        this.array = iArr;
        this.start = i11;
        this.end = i12;
    }

    public static b builder() {
        return new b(10);
    }

    public static b builder(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 >= 0, "Invalid initialCapacity: %s", i11);
        return new b(i11);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        return iterable instanceof Collection ? copyOf((Collection<Integer>) iterable) : builder().b(iterable).d();
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.j(collection));
    }

    public static ImmutableIntArray copyOf(IntStream intStream) {
        int[] array = intStream.toArray();
        return array.length == 0 ? EMPTY : new ImmutableIntArray(array);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public static ImmutableIntArray of(int i11) {
        return new ImmutableIntArray(new int[]{i11});
    }

    public static ImmutableIntArray of(int i11, int i12) {
        return new ImmutableIntArray(new int[]{i11, i12});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13) {
        return new ImmutableIntArray(new int[]{i11, i12, i13});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13, int i14) {
        return new ImmutableIntArray(new int[]{i11, i12, i13, i14});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13, int i14, int i15) {
        return new ImmutableIntArray(new int[]{i11, i12, i13, i14, i15});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13, int i14, int i15, int i16) {
        return new ImmutableIntArray(new int[]{i11, i12, i13, i14, i15, i16});
    }

    public static ImmutableIntArray of(int i11, int... iArr) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i11;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfInt spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i11) {
        return indexOf(i11) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length(); i11++) {
            if (get(i11) != immutableIntArray.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public void forEach(IntConsumer intConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(intConsumer);
        for (int i11 = this.start; i11 < this.end; i11++) {
            intConsumer.accept(this.array[i11]);
        }
    }

    public int get(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, length());
        return this.array[this.start + i11];
    }

    public int hashCode() {
        int iE = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            iE = (iE * 31) + Ints.e(this.array[i11]);
        }
        return iE;
    }

    public int indexOf(int i11) {
        for (int i12 = this.start; i12 < this.end; i12++) {
            if (this.array[i12] == i11) {
                return i12 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i11) {
        int i12;
        int i13 = this.end;
        do {
            i13--;
            i12 = this.start;
            if (i13 < i12) {
                return -1;
            }
        } while (this.array[i13] != i11);
        return i13 - i12;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public IntStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableIntArray subArray(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, length());
        if (i11 == i12) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i13 = this.start;
        return new ImmutableIntArray(iArr, i11 + i13, i13 + i12);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
        sb2.append('[');
        sb2.append(this.array[this.start]);
        int i11 = this.start;
        while (true) {
            i11++;
            if (i11 >= this.end) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(", ");
            sb2.append(this.array[i11]);
        }
    }

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }
}
