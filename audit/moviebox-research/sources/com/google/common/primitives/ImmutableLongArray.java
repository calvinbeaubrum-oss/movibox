package com.google.common.primitives;

import com.google.android.gms.common.api.Api;
import com.google.common.base.m;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ImmutableLongArray implements Serializable {
    private static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    private final long[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: compiled from: source.java */
    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

        public AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
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
                if (obj2 instanceof Long) {
                    int i12 = i11 + 1;
                    if (this.parent.array[i11] == ((Long) obj2).longValue()) {
                        i11 = i12;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i11) {
            return Long.valueOf(this.parent.get(i11));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i11, int i12) {
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
        public long[] f38805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38806b = 0;

        public b(int i11) {
            this.f38805a = new long[i11];
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

        public b a(long j11) {
            e(1);
            long[] jArr = this.f38805a;
            int i11 = this.f38806b;
            jArr[i11] = j11;
            this.f38806b = i11 + 1;
            return this;
        }

        public b b(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().longValue());
            }
            return this;
        }

        public b c(Collection<Long> collection) {
            e(collection.size());
            for (Long l11 : collection) {
                long[] jArr = this.f38805a;
                int i11 = this.f38806b;
                this.f38806b = i11 + 1;
                jArr[i11] = l11.longValue();
            }
            return this;
        }

        public ImmutableLongArray d() {
            if (this.f38806b == 0) {
                return ImmutableLongArray.EMPTY;
            }
            return new ImmutableLongArray(this.f38805a, 0, this.f38806b);
        }

        public final void e(int i11) {
            int i12 = this.f38806b + i11;
            long[] jArr = this.f38805a;
            if (i12 > jArr.length) {
                this.f38805a = Arrays.copyOf(jArr, f(jArr.length, i12));
            }
        }
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private ImmutableLongArray(long[] jArr, int i11, int i12) {
        this.array = jArr;
        this.start = i11;
        this.end = i12;
    }

    public static b builder() {
        return new b(10);
    }

    public static b builder(int i11) {
        m.g(i11 >= 0, "Invalid initialCapacity: %s", i11);
        return new b(i11);
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        return iterable instanceof Collection ? copyOf((Collection<Long>) iterable) : builder().b(iterable).d();
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableLongArray(Longs.j(collection));
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        return jArr.length == 0 ? EMPTY : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public static ImmutableLongArray of(long j11) {
        return new ImmutableLongArray(new long[]{j11});
    }

    public static ImmutableLongArray of(long j11, long j12) {
        return new ImmutableLongArray(new long[]{j11, j12});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13) {
        return new ImmutableLongArray(new long[]{j11, j12, j13});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13, long j14) {
        return new ImmutableLongArray(new long[]{j11, j12, j13, j14});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13, long j14, long j15) {
        return new ImmutableLongArray(new long[]{j11, j12, j13, j14, j15});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13, long j14, long j15, long j16) {
        return new ImmutableLongArray(new long[]{j11, j12, j13, j14, j15, j16});
    }

    public static ImmutableLongArray of(long j11, long... jArr) {
        m.e(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j11;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }

    public List<Long> asList() {
        return new AsList();
    }

    public boolean contains(long j11) {
        return indexOf(j11) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length(); i11++) {
            if (get(i11) != immutableLongArray.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i11) {
        m.n(i11, length());
        return this.array[this.start + i11];
    }

    public int hashCode() {
        int iE = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            iE = (iE * 31) + Longs.e(this.array[i11]);
        }
        return iE;
    }

    public int indexOf(long j11) {
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (this.array[i11] == j11) {
                return i11 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j11) {
        int i11;
        int i12 = this.end;
        do {
            i12--;
            i11 = this.start;
            if (i12 < i11) {
                return -1;
            }
        } while (this.array[i12] != j11);
        return i12 - i11;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableLongArray subArray(int i11, int i12) {
        m.u(i11, i12, length());
        if (i11 == i12) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i13 = this.start;
        return new ImmutableLongArray(jArr, i11 + i13, i13 + i12);
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        return isPartialView() ? new ImmutableLongArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }
}
