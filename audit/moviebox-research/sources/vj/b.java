package vj;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public final byte f78928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f78929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f78933f;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f78934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f78935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f78936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f78937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f78938e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f78939f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f78940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f78941h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.f78936c), Integer.valueOf(this.f78940g), Boolean.valueOf(this.f78939f), Integer.valueOf(this.f78934a), Long.valueOf(this.f78935b), Integer.valueOf(this.f78941h), Integer.valueOf(this.f78937d), Integer.valueOf(this.f78938e));
        }
    }

    public b(int i11, int i12, int i13, int i14) {
        this(i11, i12, i13, i14, (byte) 61);
    }

    public b(int i11, int i12, int i13, int i14, byte b11) {
        this.f78928a = (byte) 61;
        this.f78930c = i11;
        this.f78931d = i12;
        this.f78932e = (i13 <= 0 || i14 <= 0) ? 0 : (i13 / i12) * i12;
        this.f78933f = i14;
        this.f78929b = b11;
    }

    public int a(a aVar) {
        if (aVar.f78936c != null) {
            return aVar.f78937d - aVar.f78938e;
        }
        return 0;
    }

    public boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b11 : bArr) {
            if (this.f78929b == b11 || h(b11)) {
                return true;
            }
        }
        return false;
    }

    public abstract void c(byte[] bArr, int i11, int i12, a aVar);

    public byte[] d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        c(bArr, 0, bArr.length, aVar);
        c(bArr, 0, -1, aVar);
        int i11 = aVar.f78937d - aVar.f78938e;
        byte[] bArr2 = new byte[i11];
        i(bArr2, 0, i11, aVar);
        return bArr2;
    }

    public byte[] e(int i11, a aVar) {
        byte[] bArr = aVar.f78936c;
        return (bArr == null || bArr.length < aVar.f78937d + i11) ? j(aVar) : bArr;
    }

    public int f() {
        return 8192;
    }

    public long g(byte[] bArr) {
        int length = bArr.length;
        int i11 = this.f78930c;
        long j11 = ((long) (((length + i11) - 1) / i11)) * ((long) this.f78931d);
        int i12 = this.f78932e;
        return i12 > 0 ? j11 + ((((((long) i12) + j11) - 1) / ((long) i12)) * ((long) this.f78933f)) : j11;
    }

    public abstract boolean h(byte b11);

    public int i(byte[] bArr, int i11, int i12, a aVar) {
        if (aVar.f78936c == null) {
            return aVar.f78939f ? -1 : 0;
        }
        int iMin = Math.min(a(aVar), i12);
        System.arraycopy(aVar.f78936c, aVar.f78938e, bArr, i11, iMin);
        int i13 = aVar.f78938e + iMin;
        aVar.f78938e = i13;
        if (i13 >= aVar.f78937d) {
            aVar.f78936c = null;
        }
        return iMin;
    }

    public final byte[] j(a aVar) {
        byte[] bArr = aVar.f78936c;
        if (bArr == null) {
            aVar.f78936c = new byte[f()];
            aVar.f78937d = 0;
            aVar.f78938e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f78936c = bArr2;
        }
        return aVar.f78936c;
    }
}
