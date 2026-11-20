package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d {
    public byte[] A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public byte[] H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public byte[] Z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73034b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f73036d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f73039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f73040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f73041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f73042j;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f73055w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f73056x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f73057y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public byte[] f73058z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f73033a = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f73035c = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f73037e = new int[3240];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f73038f = new int[3240];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z20.d f73043k = new z20.d();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z20.d f73044l = new z20.d();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z20.d f73045m = new z20.d();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f73046n = new int[3];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f73047o = new int[3];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f73048p = new int[6];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int[] f73049q = {16, 15, 11, 4};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f73050r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f73051s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f73052t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f73053u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f73054v = 0;
    public int Q = 0;
    public long R = 0;
    public byte[] S = new byte[0];
    public int T = 0;

    public static void a(d dVar) throws IOException {
        int i11 = dVar.f73033a;
        if (i11 == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (i11 == 11) {
            return;
        }
        dVar.f73033a = 11;
        a.b(dVar.f73035c);
    }

    public static int b(a aVar) {
        if (a.i(aVar, 1) == 0) {
            return 16;
        }
        int i11 = a.i(aVar, 3);
        if (i11 != 0) {
            return i11 + 17;
        }
        int i12 = a.i(aVar, 3);
        if (i12 != 0) {
            return i12 + 8;
        }
        return 17;
    }

    public static void c(d dVar, InputStream inputStream) {
        if (dVar.f73033a != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.e(dVar.f73035c, inputStream);
        int iB = b(dVar.f73035c);
        if (iB == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        int i11 = 1 << iB;
        dVar.P = i11;
        dVar.O = i11 - 16;
        dVar.f73033a = 1;
    }
}
