package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f41435a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f41436b = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f41437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f41438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.protobuf.j f41439e;

    /* JADX INFO: compiled from: source.java */
    public interface a extends j<Boolean> {
    }

    /* JADX INFO: compiled from: source.java */
    public interface b extends j<Double> {
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        int getNumber();
    }

    /* JADX INFO: compiled from: source.java */
    public interface d<T extends c> {
        T a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        boolean a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface f extends j<Float> {
    }

    /* JADX INFO: compiled from: source.java */
    public interface g extends j<Integer> {
        @Override // com.google.protobuf.y.j
        j<Integer> c(int i11);

        int getInt(int i11);

        void n(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class h<F, T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<F> f41440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<F, T> f41441b;

        /* JADX INFO: compiled from: source.java */
        public interface a<F, T> {
            T a(F f11);
        }

        public h(List<F> list, a<F, T> aVar) {
            this.f41440a = list;
            this.f41441b = aVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i11) {
            return (T) this.f41441b.a(this.f41440a.get(i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f41440a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface i extends j<Long> {
    }

    /* JADX INFO: compiled from: source.java */
    public interface j<E> extends List<E>, RandomAccess {
        j<E> c(int i11);

        void k();

        boolean m();
    }

    static {
        byte[] bArr = new byte[0];
        f41437c = bArr;
        f41438d = ByteBuffer.wrap(bArr);
        f41439e = com.google.protobuf.j.j(bArr);
    }

    public static <T> T a(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T b(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i11, int i12) {
        int i13 = i(i12, bArr, i11, i12);
        if (i13 == 0) {
            return 1;
        }
        return i13;
    }

    public static int f(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.s(bArr);
    }

    public static Object h(Object obj, Object obj2) {
        return ((n0) obj).b().i((n0) obj2).u();
    }

    public static int i(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f41435a);
    }
}
