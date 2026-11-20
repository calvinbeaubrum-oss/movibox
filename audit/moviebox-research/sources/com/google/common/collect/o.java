package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f38718a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f38719b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f38720c = new b(1);

    /* JADX INFO: compiled from: source.java */
    public class a extends o {
        public a() {
            super(null);
        }

        @Override // com.google.common.collect.o
        public o d(int i11, int i12) {
            return l(Ints.e(i11, i12));
        }

        @Override // com.google.common.collect.o
        public o e(long j11, long j12) {
            return l(Longs.c(j11, j12));
        }

        @Override // com.google.common.collect.o
        public o f(Comparable<?> comparable, Comparable<?> comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.o
        public <T> o g(T t11, T t12, Comparator<T> comparator) {
            return l(comparator.compare(t11, t12));
        }

        @Override // com.google.common.collect.o
        public o h(boolean z11, boolean z12) {
            return l(Booleans.a(z11, z12));
        }

        @Override // com.google.common.collect.o
        public o i(boolean z11, boolean z12) {
            return l(Booleans.a(z12, z11));
        }

        @Override // com.google.common.collect.o
        public int j() {
            return 0;
        }

        public o l(int i11) {
            if (i11 < 0) {
                return o.f38719b;
            }
            return i11 > 0 ? o.f38720c : o.f38718a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f38721d;

        public b(int i11) {
            super(null);
            this.f38721d = i11;
        }

        @Override // com.google.common.collect.o
        public o d(int i11, int i12) {
            return this;
        }

        @Override // com.google.common.collect.o
        public o e(long j11, long j12) {
            return this;
        }

        @Override // com.google.common.collect.o
        public o f(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.o
        public <T> o g(T t11, T t12, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.o
        public o h(boolean z11, boolean z12) {
            return this;
        }

        @Override // com.google.common.collect.o
        public o i(boolean z11, boolean z12) {
            return this;
        }

        @Override // com.google.common.collect.o
        public int j() {
            return this.f38721d;
        }
    }

    public o() {
    }

    public /* synthetic */ o(a aVar) {
        this();
    }

    public static o k() {
        return f38718a;
    }

    public abstract o d(int i11, int i12);

    public abstract o e(long j11, long j12);

    public abstract o f(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> o g(T t11, T t12, Comparator<T> comparator);

    public abstract o h(boolean z11, boolean z12);

    public abstract o i(boolean z11, boolean z12);

    public abstract int j();
}
