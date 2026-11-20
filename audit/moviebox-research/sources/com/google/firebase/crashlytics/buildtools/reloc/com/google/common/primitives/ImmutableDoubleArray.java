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
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: compiled from: source.java */
    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        public AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
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
                if (obj2 instanceof Double) {
                    int i12 = i11 + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i11], ((Double) obj2).doubleValue())) {
                        i11 = i12;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int i11) {
            return Double.valueOf(this.parent.get(i11));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Double> spliterator() {
            return this.parent.spliterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i11, int i12) {
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
        public double[] f39871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39872b = 0;

        public b(int i11) {
            this.f39871a = new double[i11];
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

        public b a(double d11) {
            e(1);
            double[] dArr = this.f39871a;
            int i11 = this.f39872b;
            dArr[i11] = d11;
            this.f39872b = i11 + 1;
            return this;
        }

        public b b(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().doubleValue());
            }
            return this;
        }

        public b c(Collection<Double> collection) {
            e(collection.size());
            for (Double d11 : collection) {
                double[] dArr = this.f39871a;
                int i11 = this.f39872b;
                this.f39872b = i11 + 1;
                dArr[i11] = d11.doubleValue();
            }
            return this;
        }

        public ImmutableDoubleArray d() {
            if (this.f39872b == 0) {
                return ImmutableDoubleArray.EMPTY;
            }
            return new ImmutableDoubleArray(this.f39871a, 0, this.f39872b);
        }

        public final void e(int i11) {
            int i12 = this.f39872b + i11;
            double[] dArr = this.f39871a;
            if (i12 > dArr.length) {
                double[] dArr2 = new double[f(dArr.length, i12)];
                System.arraycopy(this.f39871a, 0, dArr2, 0, this.f39872b);
                this.f39871a = dArr2;
            }
        }
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    private ImmutableDoubleArray(double[] dArr, int i11, int i12) {
        this.array = dArr;
        this.start = i11;
        this.end = i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areEqual(double d11, double d12) {
        return Double.doubleToLongBits(d11) == Double.doubleToLongBits(d12);
    }

    public static b builder() {
        return new b(10);
    }

    public static b builder(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 >= 0, "Invalid initialCapacity: %s", i11);
        return new b(i11);
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        return iterable instanceof Collection ? copyOf((Collection<Double>) iterable) : builder().b(iterable).d();
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.h(collection));
    }

    public static ImmutableDoubleArray copyOf(DoubleStream doubleStream) {
        double[] array = doubleStream.toArray();
        return array.length == 0 ? EMPTY : new ImmutableDoubleArray(array);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static ImmutableDoubleArray of(double d11) {
        return new ImmutableDoubleArray(new double[]{d11});
    }

    public static ImmutableDoubleArray of(double d11, double d12) {
        return new ImmutableDoubleArray(new double[]{d11, d12});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13, double d14) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13, d14});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13, double d14, double d15) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13, d14, d15});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13, double d14, double d15, double d16) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13, d14, d15, d16});
    }

    public static ImmutableDoubleArray of(double d11, double... dArr) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d11;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfDouble spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d11) {
        return indexOf(d11) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length(); i11++) {
            if (!areEqual(get(i11), immutableDoubleArray.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public void forEach(DoubleConsumer doubleConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(doubleConsumer);
        for (int i11 = this.start; i11 < this.end; i11++) {
            doubleConsumer.accept(this.array[i11]);
        }
    }

    public double get(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, length());
        return this.array[this.start + i11];
    }

    public int hashCode() {
        int iD = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            iD = (iD * 31) + Doubles.d(this.array[i11]);
        }
        return iD;
    }

    public int indexOf(double d11) {
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (areEqual(this.array[i11], d11)) {
                return i11 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d11) {
        int i11 = this.end;
        do {
            i11--;
            if (i11 < this.start) {
                return -1;
            }
        } while (!areEqual(this.array[i11], d11));
        return i11 - this.start;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public DoubleStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableDoubleArray subArray(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, length());
        if (i11 == i12) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i13 = this.start;
        return new ImmutableDoubleArray(dArr, i11 + i13, i13 + i12);
    }

    public double[] toArray() {
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

    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }
}
