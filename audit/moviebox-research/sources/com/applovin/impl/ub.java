package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ub {

    /* JADX INFO: compiled from: source.java */
    public static class a extends AbstractList implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f23562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f23563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f23564c;

        public a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        public a(int[] iArr, int i11, int i12) {
            this.f23562a = iArr;
            this.f23563b = i11;
            this.f23564c = i12;
        }

        public int[] a() {
            return Arrays.copyOfRange(this.f23562a, this.f23563b, this.f23564c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && ub.c(this.f23562a, ((Integer) obj).intValue(), this.f23563b, this.f23564c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.f23562a[this.f23563b + i11] != aVar.f23562a[aVar.f23563b + i11]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Integer.valueOf(this.f23562a[this.f23563b + i11]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iA = 1;
            for (int i11 = this.f23563b; i11 < this.f23564c; i11++) {
                iA = (iA * 31) + ub.a(this.f23562a[i11]);
            }
            return iA;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iC;
            if (!(obj instanceof Integer) || (iC = ub.c(this.f23562a, ((Integer) obj).intValue(), this.f23563b, this.f23564c)) < 0) {
                return -1;
            }
            return iC - this.f23563b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iD;
            if (!(obj instanceof Integer) || (iD = ub.d(this.f23562a, ((Integer) obj).intValue(), this.f23563b, this.f23564c)) < 0) {
                return -1;
            }
            return iD - this.f23563b;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i11, Integer num) {
            Preconditions.checkElementIndex(i11, size());
            int[] iArr = this.f23562a;
            int i12 = this.f23563b + i11;
            int i13 = iArr[i12];
            iArr[i12] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i13);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f23564c - this.f23563b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            int[] iArr = this.f23562a;
            int i13 = this.f23563b;
            return new a(iArr, i11 + i13, i13 + i12);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
            sb2.append('[');
            sb2.append(this.f23562a[this.f23563b]);
            int i11 = this.f23563b;
            while (true) {
                i11++;
                if (i11 >= this.f23564c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.f23562a[i11]);
            }
        }
    }

    public static int a(int i11) {
        return i11;
    }

    public static int a(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }

    public static int a(long j11) {
        int i11 = (int) j11;
        Preconditions.checkArgument(((long) i11) == j11, "Out of range: %s", j11);
        return i11;
    }

    public static List a(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int[] a(Collection collection) {
        if (collection instanceof a) {
            return ((a) collection).a();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).intValue();
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int[] iArr, int i11, int i12, int i13) {
        while (i12 < i13) {
            if (iArr[i12] == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int[] iArr, int i11, int i12, int i13) {
        for (int i14 = i13 - 1; i14 >= i12; i14--) {
            if (iArr[i14] == i11) {
                return i14;
            }
        }
        return -1;
    }
}
