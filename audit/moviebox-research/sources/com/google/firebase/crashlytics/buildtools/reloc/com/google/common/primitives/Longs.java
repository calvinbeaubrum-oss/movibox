package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Longs {

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iC = Longs.c(jArr[i11], jArr2[i11]);
                if (iC != 0) {
                    return iC;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        public LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        public LongArrayAsList(long[] jArr, int i11, int i12) {
            this.array = jArr;
            this.start = i11;
            this.end = i12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.f(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != longArrayAsList.array[longArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, size());
            return Long.valueOf(this.array[this.start + i11]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iE = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                iE = (iE * 31) + Longs.e(this.array[i11]);
            }
            return iE;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iF;
            if (!(obj instanceof Long) || (iF = Longs.f(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iF - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iG;
            if (!(obj instanceof Long) || (iG = Longs.g(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iG - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long set(int i11, Long l11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, size());
            long[] jArr = this.array;
            int i12 = this.start;
            long j11 = jArr[i12 + i11];
            jArr[i12 + i11] = ((Long) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(l11)).longValue();
            return Long.valueOf(j11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator.OfLong spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i11, int i12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i13 = this.start;
            return new LongArrayAsList(jArr, i11 + i13, i13 + i12);
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 10);
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
    }

    public static int c(long j11, long j12) {
        if (j11 < j12) {
            return -1;
        }
        return j11 > j12 ? 1 : 0;
    }

    public static long d(byte b11, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17, byte b18) {
        return ((((long) b12) & 255) << 48) | ((((long) b11) & 255) << 56) | ((((long) b13) & 255) << 40) | ((((long) b14) & 255) << 32) | ((((long) b15) & 255) << 24) | ((((long) b16) & 255) << 16) | ((((long) b17) & 255) << 8) | (((long) b18) & 255);
    }

    public static int e(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int f(long[] jArr, long j11, int i11, int i12) {
        while (i11 < i12) {
            if (jArr[i11] == j11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int g(long[] jArr, long j11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (jArr[i13] == j11) {
                return i13;
            }
        }
        return -1;
    }

    public static long[] h(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i11 = 0; i11 < length; i11++) {
            jArr[i11] = ((Number) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(array[i11])).longValue();
        }
        return jArr;
    }
}
