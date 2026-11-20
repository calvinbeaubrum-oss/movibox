package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
import z20.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f73019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f73020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f73021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f73022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f73023h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f73016a = new byte[4160];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f73017b = new int[1040];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f73018c = new e();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f73024i = 0;

    public static void a(a aVar, boolean z11) {
        if (aVar.f73020e) {
            int i11 = ((aVar.f73023h << 2) + ((aVar.f73022g + 7) >> 3)) - 8;
            int i12 = aVar.f73024i;
            if (i11 > i12) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z11 && i11 != i12) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(a aVar) throws IOException {
        InputStream inputStream = aVar.f73019d;
        aVar.f73019d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void c(a aVar, byte[] bArr, int i11, int i12) {
        if ((aVar.f73022g & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i13 = aVar.f73022g;
            if (i13 == 64 || i12 == 0) {
                break;
            }
            bArr[i11] = (byte) (aVar.f73021f >>> i13);
            aVar.f73022g = i13 + 8;
            i12--;
            i11++;
        }
        if (i12 == 0) {
            return;
        }
        int iMin = Math.min(f(aVar), i12 >> 2);
        if (iMin > 0) {
            int i14 = iMin << 2;
            System.arraycopy(aVar.f73016a, aVar.f73023h << 2, bArr, i11, i14);
            i11 += i14;
            i12 -= i14;
            aVar.f73023h += iMin;
        }
        if (i12 == 0) {
            return;
        }
        if (f(aVar) <= 0) {
            while (i12 > 0) {
                try {
                    int i15 = aVar.f73019d.read(bArr, i11, i12);
                    if (i15 == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i11 += i15;
                    i12 -= i15;
                } catch (IOException e11) {
                    throw new BrotliRuntimeException("Failed to read input", e11);
                }
            }
            return;
        }
        d(aVar);
        while (i12 != 0) {
            long j11 = aVar.f73021f;
            int i16 = aVar.f73022g;
            bArr[i11] = (byte) (j11 >>> i16);
            aVar.f73022g = i16 + 8;
            i12--;
            i11++;
        }
        a(aVar, false);
    }

    public static void d(a aVar) {
        int i11 = aVar.f73022g;
        if (i11 >= 32) {
            int[] iArr = aVar.f73017b;
            int i12 = aVar.f73023h;
            aVar.f73023h = i12 + 1;
            aVar.f73021f = (((long) iArr[i12]) << 32) | (aVar.f73021f >>> 32);
            aVar.f73022g = i11 - 32;
        }
    }

    public static void e(a aVar, InputStream inputStream) {
        if (aVar.f73019d != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        e.b(aVar.f73018c, aVar.f73016a, aVar.f73017b);
        aVar.f73019d = inputStream;
        aVar.f73021f = 0L;
        aVar.f73022g = 64;
        aVar.f73023h = 1024;
        aVar.f73020e = false;
        h(aVar);
    }

    public static int f(a aVar) {
        return (aVar.f73020e ? (aVar.f73024i + 3) >> 2 : 1024) - aVar.f73023h;
    }

    public static void g(a aVar) {
        int i11 = (64 - aVar.f73022g) & 7;
        if (i11 != 0 && i(aVar, i11) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(a aVar) {
        j(aVar);
        a(aVar, false);
        d(aVar);
        d(aVar);
    }

    public static int i(a aVar, int i11) {
        d(aVar);
        long j11 = aVar.f73021f;
        int i12 = aVar.f73022g;
        int i13 = ((int) (j11 >>> i12)) & ((1 << i11) - 1);
        aVar.f73022g = i12 + i11;
        return i13;
    }

    public static void j(a aVar) {
        int i11 = aVar.f73023h;
        if (i11 <= 1015) {
            return;
        }
        if (aVar.f73020e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i12 = i11 << 2;
        int i13 = 4096 - i12;
        byte[] bArr = aVar.f73016a;
        System.arraycopy(bArr, i12, bArr, 0, i13);
        aVar.f73023h = 0;
        while (i13 < 4096) {
            try {
                int i14 = aVar.f73019d.read(aVar.f73016a, i13, 4096 - i13);
                if (i14 <= 0) {
                    aVar.f73020e = true;
                    aVar.f73024i = i13;
                    i13 += 3;
                    break;
                }
                i13 += i14;
            } catch (IOException e11) {
                throw new BrotliRuntimeException("Failed to read input", e11);
            }
        }
        e.a(aVar.f73018c, i13 >> 2);
    }

    public static void k(a aVar) {
        if (aVar.f73022g == 64) {
            h(aVar);
        }
    }
}
