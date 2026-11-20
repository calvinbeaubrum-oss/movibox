package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f34493l = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f34494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f34495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f34497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte f34499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f34500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f34501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f34502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f34503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f34504k;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f34505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f34506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte f34507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f34508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f34509e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f34510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f34511g = g.f34493l;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte[] f34512h = g.f34493l;

        public g i() {
            return new g(this);
        }

        public b j(byte[] bArr) {
            com.google.android.exoplayer2.util.a.e(bArr);
            this.f34511g = bArr;
            return this;
        }

        public b k(boolean z11) {
            this.f34506b = z11;
            return this;
        }

        public b l(boolean z11) {
            this.f34505a = z11;
            return this;
        }

        public b m(byte[] bArr) {
            com.google.android.exoplayer2.util.a.e(bArr);
            this.f34512h = bArr;
            return this;
        }

        public b n(byte b11) {
            this.f34507c = b11;
            return this;
        }

        public b o(int i11) {
            com.google.android.exoplayer2.util.a.a(i11 >= 0 && i11 <= 65535);
            this.f34508d = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            return this;
        }

        public b p(int i11) {
            this.f34510f = i11;
            return this;
        }

        public b q(long j11) {
            this.f34509e = j11;
            return this;
        }
    }

    public g(b bVar) {
        this.f34494a = (byte) 2;
        this.f34495b = bVar.f34505a;
        this.f34496c = false;
        this.f34498e = bVar.f34506b;
        this.f34499f = bVar.f34507c;
        this.f34500g = bVar.f34508d;
        this.f34501h = bVar.f34509e;
        this.f34502i = bVar.f34510f;
        byte[] bArr = bVar.f34511g;
        this.f34503j = bArr;
        this.f34497d = (byte) (bArr.length / 4);
        this.f34504k = bVar.f34512h;
    }

    public static int b(int i11) {
        return com.google.common.math.d.g(i11 + 1, 65536);
    }

    public static int c(int i11) {
        return com.google.common.math.d.g(i11 - 1, 65536);
    }

    @Nullable
    public static g d(com.google.android.exoplayer2.util.c0 c0Var) {
        byte[] bArr;
        if (c0Var.a() < 12) {
            return null;
        }
        int iD = c0Var.D();
        byte b11 = (byte) (iD >> 6);
        boolean z11 = ((iD >> 5) & 1) == 1;
        byte b12 = (byte) (iD & 15);
        if (b11 != 2) {
            return null;
        }
        int iD2 = c0Var.D();
        boolean z12 = ((iD2 >> 7) & 1) == 1;
        byte b13 = (byte) (iD2 & 127);
        int iJ = c0Var.J();
        long jF = c0Var.F();
        int iN = c0Var.n();
        if (b12 > 0) {
            bArr = new byte[b12 * 4];
            for (int i11 = 0; i11 < b12; i11++) {
                c0Var.j(bArr, i11 * 4, 4);
            }
        } else {
            bArr = f34493l;
        }
        byte[] bArr2 = new byte[c0Var.a()];
        c0Var.j(bArr2, 0, c0Var.a());
        return new b().l(z11).k(z12).n(b13).o(iJ).q(jF).p(iN).j(bArr).m(bArr2).i();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f34499f == gVar.f34499f && this.f34500g == gVar.f34500g && this.f34498e == gVar.f34498e && this.f34501h == gVar.f34501h && this.f34502i == gVar.f34502i;
    }

    public int hashCode() {
        int i11 = (((((527 + this.f34499f) * 31) + this.f34500g) * 31) + (this.f34498e ? 1 : 0)) * 31;
        long j11 = this.f34501h;
        return ((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f34502i;
    }

    public String toString() {
        return o0.C("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f34499f), Integer.valueOf(this.f34500g), Long.valueOf(this.f34501h), Integer.valueOf(this.f34502i), Boolean.valueOf(this.f34498e));
    }
}
