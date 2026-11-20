package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import com.google.android.gms.common.api.Api;
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
public final class Ints {

    /* JADX INFO: compiled from: source.java */
    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        public IntArrayAsList(int[] iArr, int i11, int i12) {
            this.array = iArr;
            this.start = i11;
            this.end = i12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.f(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != intArrayAsList.array[intArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, size());
            return Integer.valueOf(this.array[this.start + i11]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iE = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                iE = (iE * 31) + Ints.e(this.array[i11]);
            }
            return iE;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iF;
            if (!(obj instanceof Integer) || (iF = Ints.f(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Integer) || (iG = Ints.g(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iG - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i11, Integer num) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, size());
            int[] iArr = this.array;
            int i12 = this.start;
            int i13 = iArr[i12 + i11];
            iArr[i12 + i11] = ((Integer) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(num)).intValue();
            return Integer.valueOf(i13);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator.OfInt spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i11, int i12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i13 = this.start;
            return new IntArrayAsList(iArr, i11 + i13, i13 + i12);
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
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

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iD = Ints.d(iArr[i11], iArr2[i11]);
                if (iD != 0) {
                    return iD;
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    public static int c(long j11) {
        int i11 = (int) j11;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(((long) i11) == j11, "Out of range: %s", j11);
        return i11;
    }

    public static int d(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }

    public static int e(int i11) {
        return i11;
    }

    public static int f(int[] iArr, int i11, int i12, int i13) {
        while (i12 < i13) {
            if (iArr[i12] == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    public static int g(int[] iArr, int i11, int i12, int i13) {
        for (int i14 = i13 - 1; i14 >= i12; i14--) {
            if (iArr[i14] == i11) {
                return i14;
            }
        }
        return -1;
    }

    public static int h(int... iArr) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(iArr.length > 0);
        int i11 = iArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            if (i13 < i11) {
                i11 = i13;
            }
        }
        return i11;
    }

    public static int i(long j11) {
        if (j11 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }

    public static int[] j(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = ((Number) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(array[i11])).intValue();
        }
        return iArr;
    }
}
