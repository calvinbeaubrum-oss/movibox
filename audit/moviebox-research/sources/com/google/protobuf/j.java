package com.google.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f41297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41298e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f41299f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f41300g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f41301h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f41302i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f41303j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f41304k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f41305l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f41306m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f41307n;

        public b(byte[] bArr, int i11, int i12, boolean z11) {
            super();
            this.f41307n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f41299f = bArr;
            this.f41301h = i12 + i11;
            this.f41303j = i11;
            this.f41304k = i11;
            this.f41300g = z11;
        }

        @Override // com.google.protobuf.j
        public long A() throws IOException {
            return j.c(M());
        }

        @Override // com.google.protobuf.j
        public String B() throws IOException {
            int iL = L();
            if (iL > 0) {
                int i11 = this.f41301h;
                int i12 = this.f41303j;
                if (iL <= i11 - i12) {
                    String str = new String(this.f41299f, i12, iL, y.f41435a);
                    this.f41303j += iL;
                    return str;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.j
        public String C() throws IOException {
            int iL = L();
            if (iL > 0) {
                int i11 = this.f41301h;
                int i12 = this.f41303j;
                if (iL <= i11 - i12) {
                    String strH = Utf8.h(this.f41299f, i12, iL);
                    this.f41303j += iL;
                    return strH;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.j
        public int D() throws IOException {
            if (e()) {
                this.f41305l = 0;
                return 0;
            }
            int iL = L();
            this.f41305l = iL;
            if (WireFormat.a(iL) != 0) {
                return this.f41305l;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.j
        public int E() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public long F() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public boolean G(int i11) throws IOException {
            int iB = WireFormat.b(i11);
            if (iB == 0) {
                R();
                return true;
            }
            if (iB == 1) {
                Q(8);
                return true;
            }
            if (iB == 2) {
                Q(L());
                return true;
            }
            if (iB == 3) {
                P();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            Q(4);
            return true;
        }

        public byte H() throws IOException {
            int i11 = this.f41303j;
            if (i11 == this.f41301h) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f41299f;
            this.f41303j = i11 + 1;
            return bArr[i11];
        }

        public byte[] I(int i11) throws IOException {
            if (i11 > 0) {
                int i12 = this.f41301h;
                int i13 = this.f41303j;
                if (i11 <= i12 - i13) {
                    int i14 = i11 + i13;
                    this.f41303j = i14;
                    return Arrays.copyOfRange(this.f41299f, i13, i14);
                }
            }
            if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                return y.f41437c;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public int J() throws IOException {
            int i11 = this.f41303j;
            if (this.f41301h - i11 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f41299f;
            this.f41303j = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public long K() throws IOException {
            int i11 = this.f41303j;
            if (this.f41301h - i11 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f41299f;
            this.f41303j = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        public int L() throws IOException {
            int i11;
            int i12 = this.f41303j;
            int i13 = this.f41301h;
            if (i13 != i12) {
                byte[] bArr = this.f41299f;
                int i14 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 >= 0) {
                    this.f41303j = i14;
                    return b11;
                }
                if (i13 - i14 >= 9) {
                    int i15 = i12 + 2;
                    int i16 = (bArr[i14] << 7) ^ b11;
                    if (i16 < 0) {
                        i11 = i16 ^ (-128);
                    } else {
                        int i17 = i12 + 3;
                        int i18 = (bArr[i15] << Ascii.SO) ^ i16;
                        if (i18 >= 0) {
                            i11 = i18 ^ 16256;
                        } else {
                            int i19 = i12 + 4;
                            int i21 = i18 ^ (bArr[i17] << Ascii.NAK);
                            if (i21 < 0) {
                                i11 = (-2080896) ^ i21;
                            } else {
                                i17 = i12 + 5;
                                byte b12 = bArr[i19];
                                int i22 = (i21 ^ (b12 << Ascii.FS)) ^ 266354560;
                                if (b12 < 0) {
                                    i19 = i12 + 6;
                                    if (bArr[i17] < 0) {
                                        i17 = i12 + 7;
                                        if (bArr[i19] < 0) {
                                            i19 = i12 + 8;
                                            if (bArr[i17] < 0) {
                                                i17 = i12 + 9;
                                                if (bArr[i19] < 0) {
                                                    int i23 = i12 + 10;
                                                    if (bArr[i17] >= 0) {
                                                        i15 = i23;
                                                        i11 = i22;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i22;
                                }
                                i11 = i22;
                            }
                            i15 = i19;
                        }
                        i15 = i17;
                    }
                    this.f41303j = i15;
                    return i11;
                }
            }
            return (int) N();
        }

        public long M() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11 = this.f41303j;
            int i12 = this.f41301h;
            if (i12 != i11) {
                byte[] bArr = this.f41299f;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.f41303j = i13;
                    return b11;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b11;
                    if (i15 < 0) {
                        j11 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << Ascii.SO) ^ i15;
                        if (i17 >= 0) {
                            j11 = i17 ^ 16256;
                            i14 = i16;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << Ascii.NAK);
                            if (i19 < 0) {
                                long j14 = (-2080896) ^ i19;
                                i14 = i18;
                                j11 = j14;
                            } else {
                                long j15 = i19;
                                i14 = i11 + 5;
                                long j16 = j15 ^ (((long) bArr[i18]) << 28);
                                if (j16 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    int i21 = i11 + 6;
                                    long j17 = j16 ^ (((long) bArr[i14]) << 35);
                                    if (j17 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i14 = i11 + 7;
                                        j16 = j17 ^ (((long) bArr[i21]) << 42);
                                        if (j16 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            i21 = i11 + 8;
                                            j17 = j16 ^ (((long) bArr[i14]) << 49);
                                            if (j17 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                i14 = i11 + 9;
                                                long j18 = (j17 ^ (((long) bArr[i21]) << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    int i22 = i11 + 10;
                                                    if (bArr[i14] >= 0) {
                                                        i14 = i22;
                                                    }
                                                }
                                                j11 = j18;
                                            }
                                        }
                                    }
                                    j11 = j17 ^ j12;
                                    i14 = i21;
                                }
                                j11 = j16 ^ j13;
                            }
                        }
                    }
                    this.f41303j = i14;
                    return j11;
                }
            }
            return N();
        }

        public long N() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte bH = H();
                j11 |= ((long) (bH & Ascii.DEL)) << i11;
                if ((bH & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void O() {
            int i11 = this.f41301h + this.f41302i;
            this.f41301h = i11;
            int i12 = i11 - this.f41304k;
            int i13 = this.f41307n;
            if (i12 <= i13) {
                this.f41302i = 0;
                return;
            }
            int i14 = i12 - i13;
            this.f41302i = i14;
            this.f41301h = i11 - i14;
        }

        public void P() throws IOException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void Q(int i11) throws IOException {
            if (i11 >= 0) {
                int i12 = this.f41301h;
                int i13 = this.f41303j;
                if (i11 <= i12 - i13) {
                    this.f41303j = i13 + i11;
                    return;
                }
            }
            if (i11 >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public final void R() throws IOException {
            if (this.f41301h - this.f41303j >= 10) {
                S();
            } else {
                T();
            }
        }

        public final void S() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                byte[] bArr = this.f41299f;
                int i12 = this.f41303j;
                this.f41303j = i12 + 1;
                if (bArr[i12] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void T() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (H() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.j
        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f41305l != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return this.f41303j - this.f41304k;
        }

        @Override // com.google.protobuf.j
        public boolean e() throws IOException {
            return this.f41303j == this.f41301h;
        }

        @Override // com.google.protobuf.j
        public void m(int i11) {
            this.f41307n = i11;
            O();
        }

        @Override // com.google.protobuf.j
        public int n(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int iD = i11 + d();
            if (iD < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i12 = this.f41307n;
            if (iD > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41307n = iD;
            O();
            return i12;
        }

        @Override // com.google.protobuf.j
        public boolean o() throws IOException {
            return M() != 0;
        }

        @Override // com.google.protobuf.j
        public ByteString p() throws IOException {
            int iL = L();
            if (iL > 0) {
                int i11 = this.f41301h;
                int i12 = this.f41303j;
                if (iL <= i11 - i12) {
                    ByteString byteStringWrap = (this.f41300g && this.f41306m) ? ByteString.wrap(this.f41299f, i12, iL) : ByteString.copyFrom(this.f41299f, i12, iL);
                    this.f41303j += iL;
                    return byteStringWrap;
                }
            }
            return iL == 0 ? ByteString.EMPTY : ByteString.wrap(I(iL));
        }

        @Override // com.google.protobuf.j
        public double q() throws IOException {
            return Double.longBitsToDouble(K());
        }

        @Override // com.google.protobuf.j
        public int r() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public int s() throws IOException {
            return J();
        }

        @Override // com.google.protobuf.j
        public long t() throws IOException {
            return K();
        }

        @Override // com.google.protobuf.j
        public float u() throws IOException {
            return Float.intBitsToFloat(J());
        }

        @Override // com.google.protobuf.j
        public int v() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public long w() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public int x() throws IOException {
            return J();
        }

        @Override // com.google.protobuf.j
        public long y() throws IOException {
            return K();
        }

        @Override // com.google.protobuf.j
        public int z() throws IOException {
            return j.b(L());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Iterable<ByteBuffer> f41308f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Iterator<ByteBuffer> f41309g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ByteBuffer f41310h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f41311i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f41312j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f41313k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f41314l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f41315m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f41316n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f41317o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f41318p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f41319q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f41320r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f41321s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f41322t;

        public c(Iterable<ByteBuffer> iterable, int i11, boolean z11) {
            super();
            this.f41315m = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f41313k = i11;
            this.f41308f = iterable;
            this.f41309g = iterable.iterator();
            this.f41311i = z11;
            this.f41317o = 0;
            this.f41318p = 0;
            if (i11 != 0) {
                W();
                return;
            }
            this.f41310h = y.f41438d;
            this.f41319q = 0L;
            this.f41320r = 0L;
            this.f41322t = 0L;
            this.f41321s = 0L;
        }

        private void Q() {
            int i11 = this.f41313k + this.f41314l;
            this.f41313k = i11;
            int i12 = i11 - this.f41318p;
            int i13 = this.f41315m;
            if (i12 <= i13) {
                this.f41314l = 0;
                return;
            }
            int i14 = i12 - i13;
            this.f41314l = i14;
            this.f41313k = i11 - i14;
        }

        private void U() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.j
        public long A() throws IOException {
            return j.c(O());
        }

        @Override // com.google.protobuf.j
        public String B() throws IOException {
            int iN = N();
            if (iN > 0) {
                long j11 = iN;
                long j12 = this.f41322t;
                long j13 = this.f41319q;
                if (j11 <= j12 - j13) {
                    byte[] bArr = new byte[iN];
                    l1.p(j13, bArr, 0L, j11);
                    String str = new String(bArr, y.f41435a);
                    this.f41319q += j11;
                    return str;
                }
            }
            if (iN > 0 && iN <= R()) {
                byte[] bArr2 = new byte[iN];
                K(bArr2, 0, iN);
                return new String(bArr2, y.f41435a);
            }
            if (iN == 0) {
                return "";
            }
            if (iN < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.j
        public String C() throws IOException {
            int iN = N();
            if (iN > 0) {
                long j11 = iN;
                long j12 = this.f41322t;
                long j13 = this.f41319q;
                if (j11 <= j12 - j13) {
                    String strG = Utf8.g(this.f41310h, (int) (j13 - this.f41320r), iN);
                    this.f41319q += j11;
                    return strG;
                }
            }
            if (iN >= 0 && iN <= R()) {
                byte[] bArr = new byte[iN];
                K(bArr, 0, iN);
                return Utf8.h(bArr, 0, iN);
            }
            if (iN == 0) {
                return "";
            }
            if (iN <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.j
        public int D() throws IOException {
            if (e()) {
                this.f41316n = 0;
                return 0;
            }
            int iN = N();
            this.f41316n = iN;
            if (WireFormat.a(iN) != 0) {
                return this.f41316n;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.j
        public int E() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.j
        public long F() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.j
        public boolean G(int i11) throws IOException {
            int iB = WireFormat.b(i11);
            if (iB == 0) {
                U();
                return true;
            }
            if (iB == 1) {
                T(8);
                return true;
            }
            if (iB == 2) {
                T(N());
                return true;
            }
            if (iB == 3) {
                S();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            T(4);
            return true;
        }

        public final long H() {
            return this.f41322t - this.f41319q;
        }

        public final void I() throws InvalidProtocolBufferException {
            if (!this.f41309g.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            W();
        }

        public byte J() throws IOException {
            if (H() == 0) {
                I();
            }
            long j11 = this.f41319q;
            this.f41319q = 1 + j11;
            return l1.w(j11);
        }

        public final void K(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 < 0 || i12 > R()) {
                if (i12 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i12 != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i13 = i12;
            while (i13 > 0) {
                if (H() == 0) {
                    I();
                }
                int iMin = Math.min(i13, (int) H());
                long j11 = iMin;
                l1.p(this.f41319q, bArr, (i12 - i13) + i11, j11);
                i13 -= iMin;
                this.f41319q += j11;
            }
        }

        public int L() throws IOException {
            if (H() < 4) {
                return (J() & 255) | ((J() & 255) << 8) | ((J() & 255) << 16) | ((J() & 255) << 24);
            }
            long j11 = this.f41319q;
            this.f41319q = 4 + j11;
            return ((l1.w(j11 + 3) & 255) << 24) | (l1.w(j11) & 255) | ((l1.w(1 + j11) & 255) << 8) | ((l1.w(2 + j11) & 255) << 16);
        }

        public long M() throws IOException {
            if (H() < 8) {
                return (((long) J()) & 255) | ((((long) J()) & 255) << 8) | ((((long) J()) & 255) << 16) | ((((long) J()) & 255) << 24) | ((((long) J()) & 255) << 32) | ((((long) J()) & 255) << 40) | ((((long) J()) & 255) << 48) | ((((long) J()) & 255) << 56);
            }
            long j11 = this.f41319q;
            this.f41319q = 8 + j11;
            return ((((long) l1.w(j11 + 7)) & 255) << 56) | ((((long) l1.w(2 + j11)) & 255) << 16) | (((long) l1.w(j11)) & 255) | ((((long) l1.w(1 + j11)) & 255) << 8) | ((((long) l1.w(3 + j11)) & 255) << 24) | ((((long) l1.w(4 + j11)) & 255) << 32) | ((((long) l1.w(5 + j11)) & 255) << 40) | ((((long) l1.w(6 + j11)) & 255) << 48);
        }

        public int N() throws IOException {
            int i11;
            long j11 = this.f41319q;
            if (this.f41322t != j11) {
                long j12 = j11 + 1;
                byte bW = l1.w(j11);
                if (bW >= 0) {
                    this.f41319q++;
                    return bW;
                }
                if (this.f41322t - this.f41319q >= 10) {
                    long j13 = 2 + j11;
                    int iW = (l1.w(j12) << 7) ^ bW;
                    if (iW < 0) {
                        i11 = iW ^ (-128);
                    } else {
                        long j14 = 3 + j11;
                        int iW2 = (l1.w(j13) << Ascii.SO) ^ iW;
                        if (iW2 >= 0) {
                            i11 = iW2 ^ 16256;
                        } else {
                            long j15 = 4 + j11;
                            int iW3 = iW2 ^ (l1.w(j14) << Ascii.NAK);
                            if (iW3 < 0) {
                                i11 = (-2080896) ^ iW3;
                            } else {
                                j14 = 5 + j11;
                                byte bW2 = l1.w(j15);
                                int i12 = (iW3 ^ (bW2 << Ascii.FS)) ^ 266354560;
                                if (bW2 < 0) {
                                    j15 = 6 + j11;
                                    if (l1.w(j14) < 0) {
                                        j14 = 7 + j11;
                                        if (l1.w(j15) < 0) {
                                            j15 = 8 + j11;
                                            if (l1.w(j14) < 0) {
                                                j14 = 9 + j11;
                                                if (l1.w(j15) < 0) {
                                                    long j16 = j11 + 10;
                                                    if (l1.w(j14) >= 0) {
                                                        i11 = i12;
                                                        j13 = j16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i12;
                                }
                                i11 = i12;
                            }
                            j13 = j15;
                        }
                        j13 = j14;
                    }
                    this.f41319q = j13;
                    return i11;
                }
            }
            return (int) P();
        }

        public long O() throws IOException {
            long j11;
            long j12;
            long j13;
            long j14 = this.f41319q;
            if (this.f41322t != j14) {
                long j15 = j14 + 1;
                byte bW = l1.w(j14);
                if (bW >= 0) {
                    this.f41319q++;
                    return bW;
                }
                if (this.f41322t - this.f41319q >= 10) {
                    long j16 = 2 + j14;
                    int iW = (l1.w(j15) << 7) ^ bW;
                    if (iW < 0) {
                        j11 = iW ^ (-128);
                    } else {
                        long j17 = 3 + j14;
                        int iW2 = (l1.w(j16) << Ascii.SO) ^ iW;
                        if (iW2 >= 0) {
                            j11 = iW2 ^ 16256;
                            j16 = j17;
                        } else {
                            long j18 = 4 + j14;
                            int iW3 = iW2 ^ (l1.w(j17) << Ascii.NAK);
                            if (iW3 < 0) {
                                j11 = (-2080896) ^ iW3;
                                j16 = j18;
                            } else {
                                long j19 = 5 + j14;
                                long jW = (((long) l1.w(j18)) << 28) ^ ((long) iW3);
                                if (jW >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j21 = 6 + j14;
                                    long jW2 = jW ^ (((long) l1.w(j19)) << 35);
                                    if (jW2 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j19 = 7 + j14;
                                        jW = jW2 ^ (((long) l1.w(j21)) << 42);
                                        if (jW >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j21 = 8 + j14;
                                            jW2 = jW ^ (((long) l1.w(j19)) << 49);
                                            if (jW2 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                j19 = 9 + j14;
                                                long jW3 = (jW2 ^ (((long) l1.w(j21)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j22 = j14 + 10;
                                                    if (l1.w(j19) >= 0) {
                                                        j11 = jW3;
                                                        j16 = j22;
                                                    }
                                                } else {
                                                    j11 = jW3;
                                                    j16 = j19;
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ jW2;
                                    j16 = j21;
                                }
                                j11 = j13 ^ jW;
                                j16 = j19;
                            }
                        }
                    }
                    this.f41319q = j16;
                    return j11;
                }
            }
            return P();
        }

        public long P() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte bJ = J();
                j11 |= ((long) (bJ & Ascii.DEL)) << i11;
                if ((bJ & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int R() {
            return (int) ((((long) (this.f41313k - this.f41317o)) - this.f41319q) + this.f41320r);
        }

        public void S() throws IOException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void T(int i11) throws IOException {
            if (i11 < 0 || i11 > (((long) (this.f41313k - this.f41317o)) - this.f41319q) + this.f41320r) {
                if (i11 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i11 > 0) {
                if (H() == 0) {
                    I();
                }
                int iMin = Math.min(i11, (int) H());
                i11 -= iMin;
                this.f41319q += (long) iMin;
            }
        }

        public final ByteBuffer V(int i11, int i12) throws IOException {
            int iPosition = this.f41310h.position();
            int iLimit = this.f41310h.limit();
            try {
                try {
                    this.f41310h.position(i11);
                    this.f41310h.limit(i12);
                    ByteBuffer byteBufferSlice = this.f41310h.slice();
                    this.f41310h.position(iPosition);
                    this.f41310h.limit(iLimit);
                    return byteBufferSlice;
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } catch (Throwable th2) {
                this.f41310h.position(iPosition);
                this.f41310h.limit(iLimit);
                throw th2;
            }
        }

        public final void W() {
            ByteBuffer next = this.f41309g.next();
            this.f41310h = next;
            this.f41317o += (int) (this.f41319q - this.f41320r);
            long jPosition = next.position();
            this.f41319q = jPosition;
            this.f41320r = jPosition;
            this.f41322t = this.f41310h.limit();
            long jK = l1.k(this.f41310h);
            this.f41321s = jK;
            this.f41319q += jK;
            this.f41320r += jK;
            this.f41322t += jK;
        }

        @Override // com.google.protobuf.j
        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f41316n != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return (int) ((((long) (this.f41317o - this.f41318p)) + this.f41319q) - this.f41320r);
        }

        @Override // com.google.protobuf.j
        public boolean e() throws IOException {
            return (((long) this.f41317o) + this.f41319q) - this.f41320r == ((long) this.f41313k);
        }

        @Override // com.google.protobuf.j
        public void m(int i11) {
            this.f41315m = i11;
            Q();
        }

        @Override // com.google.protobuf.j
        public int n(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int iD = i11 + d();
            int i12 = this.f41315m;
            if (iD > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41315m = iD;
            Q();
            return i12;
        }

        @Override // com.google.protobuf.j
        public boolean o() throws IOException {
            return O() != 0;
        }

        @Override // com.google.protobuf.j
        public ByteString p() throws IOException {
            int iN = N();
            if (iN > 0) {
                long j11 = iN;
                long j12 = this.f41322t;
                long j13 = this.f41319q;
                if (j11 <= j12 - j13) {
                    if (this.f41311i && this.f41312j) {
                        int i11 = (int) (j13 - this.f41321s);
                        ByteString byteStringWrap = ByteString.wrap(V(i11, iN + i11));
                        this.f41319q += j11;
                        return byteStringWrap;
                    }
                    byte[] bArr = new byte[iN];
                    l1.p(j13, bArr, 0L, j11);
                    this.f41319q += j11;
                    return ByteString.wrap(bArr);
                }
            }
            if (iN <= 0 || iN > R()) {
                if (iN == 0) {
                    return ByteString.EMPTY;
                }
                if (iN < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.f41311i || !this.f41312j) {
                byte[] bArr2 = new byte[iN];
                K(bArr2, 0, iN);
                return ByteString.wrap(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (iN > 0) {
                if (H() == 0) {
                    I();
                }
                int iMin = Math.min(iN, (int) H());
                int i12 = (int) (this.f41319q - this.f41321s);
                arrayList.add(ByteString.wrap(V(i12, i12 + iMin)));
                iN -= iMin;
                this.f41319q += (long) iMin;
            }
            return ByteString.copyFrom(arrayList);
        }

        @Override // com.google.protobuf.j
        public double q() throws IOException {
            return Double.longBitsToDouble(M());
        }

        @Override // com.google.protobuf.j
        public int r() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.j
        public int s() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public long t() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public float u() throws IOException {
            return Float.intBitsToFloat(L());
        }

        @Override // com.google.protobuf.j
        public int v() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.j
        public long w() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.j
        public int x() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public long y() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public int z() throws IOException {
            return j.b(N());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final InputStream f41323f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f41324g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f41325h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f41326i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f41327j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f41328k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f41329l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f41330m;

        public d(InputStream inputStream, int i11) {
            super();
            this.f41330m = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            y.b(inputStream, "input");
            this.f41323f = inputStream;
            this.f41324g = new byte[i11];
            this.f41325h = 0;
            this.f41327j = 0;
            this.f41329l = 0;
        }

        public static int H(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        public static int I(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
            try {
                return inputStream.read(bArr, i11, i12);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private void T() {
            int i11 = this.f41325h + this.f41326i;
            this.f41325h = i11;
            int i12 = this.f41329l + i11;
            int i13 = this.f41330m;
            if (i12 <= i13) {
                this.f41326i = 0;
                return;
            }
            int i14 = i12 - i13;
            this.f41326i = i14;
            this.f41325h = i11 - i14;
        }

        public static long V(InputStream inputStream, long j11) throws IOException {
            try {
                return inputStream.skip(j11);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private void Z() throws IOException {
            if (this.f41325h - this.f41327j >= 10) {
                a0();
            } else {
                b0();
            }
        }

        private void a0() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                byte[] bArr = this.f41324g;
                int i12 = this.f41327j;
                this.f41327j = i12 + 1;
                if (bArr[i12] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void b0() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (K() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.j
        public long A() throws IOException {
            return j.c(R());
        }

        @Override // com.google.protobuf.j
        public String B() throws IOException {
            int iQ = Q();
            if (iQ > 0) {
                int i11 = this.f41325h;
                int i12 = this.f41327j;
                if (iQ <= i11 - i12) {
                    String str = new String(this.f41324g, i12, iQ, y.f41435a);
                    this.f41327j += iQ;
                    return str;
                }
            }
            if (iQ == 0) {
                return "";
            }
            if (iQ > this.f41325h) {
                return new String(L(iQ, false), y.f41435a);
            }
            U(iQ);
            String str2 = new String(this.f41324g, this.f41327j, iQ, y.f41435a);
            this.f41327j += iQ;
            return str2;
        }

        @Override // com.google.protobuf.j
        public String C() throws IOException {
            byte[] bArrL;
            int iQ = Q();
            int i11 = this.f41327j;
            int i12 = this.f41325h;
            if (iQ <= i12 - i11 && iQ > 0) {
                bArrL = this.f41324g;
                this.f41327j = i11 + iQ;
            } else {
                if (iQ == 0) {
                    return "";
                }
                i11 = 0;
                if (iQ <= i12) {
                    U(iQ);
                    bArrL = this.f41324g;
                    this.f41327j = iQ;
                } else {
                    bArrL = L(iQ, false);
                }
            }
            return Utf8.h(bArrL, i11, iQ);
        }

        @Override // com.google.protobuf.j
        public int D() throws IOException {
            if (e()) {
                this.f41328k = 0;
                return 0;
            }
            int iQ = Q();
            this.f41328k = iQ;
            if (WireFormat.a(iQ) != 0) {
                return this.f41328k;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.j
        public int E() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.j
        public long F() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.j
        public boolean G(int i11) throws IOException {
            int iB = WireFormat.b(i11);
            if (iB == 0) {
                Z();
                return true;
            }
            if (iB == 1) {
                X(8);
                return true;
            }
            if (iB == 2) {
                X(Q());
                return true;
            }
            if (iB == 3) {
                W();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            X(4);
            return true;
        }

        public final ByteString J(int i11) throws IOException {
            byte[] bArrM = M(i11);
            if (bArrM != null) {
                return ByteString.copyFrom(bArrM);
            }
            int i12 = this.f41327j;
            int i13 = this.f41325h;
            int length = i13 - i12;
            this.f41329l += i13;
            this.f41327j = 0;
            this.f41325h = 0;
            List<byte[]> listN = N(i11 - length);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f41324g, i12, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        public byte K() throws IOException {
            if (this.f41327j == this.f41325h) {
                U(1);
            }
            byte[] bArr = this.f41324g;
            int i11 = this.f41327j;
            this.f41327j = i11 + 1;
            return bArr[i11];
        }

        public final byte[] L(int i11, boolean z11) throws IOException {
            byte[] bArrM = M(i11);
            if (bArrM != null) {
                return z11 ? (byte[]) bArrM.clone() : bArrM;
            }
            int i12 = this.f41327j;
            int i13 = this.f41325h;
            int length = i13 - i12;
            this.f41329l += i13;
            this.f41327j = 0;
            this.f41325h = 0;
            List<byte[]> listN = N(i11 - length);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f41324g, i12, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] M(int i11) throws IOException {
            if (i11 == 0) {
                return y.f41437c;
            }
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = this.f41329l;
            int i13 = this.f41327j;
            int i14 = i12 + i13 + i11;
            if (i14 - this.f41296c > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i15 = this.f41330m;
            if (i14 > i15) {
                X((i15 - i12) - i13);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i16 = this.f41325h - i13;
            int i17 = i11 - i16;
            if (i17 >= 4096 && i17 > H(this.f41323f)) {
                return null;
            }
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f41324g, this.f41327j, bArr, 0, i16);
            this.f41329l += this.f41325h;
            this.f41327j = 0;
            this.f41325h = 0;
            while (i16 < i11) {
                int I = I(this.f41323f, bArr, i16, i11 - i16);
                if (I == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.f41329l += I;
                i16 += I;
            }
            return bArr;
        }

        public final List<byte[]> N(int i11) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i11 > 0) {
                int iMin = Math.min(i11, 4096);
                byte[] bArr = new byte[iMin];
                int i12 = 0;
                while (i12 < iMin) {
                    int i13 = this.f41323f.read(bArr, i12, iMin - i12);
                    if (i13 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.f41329l += i13;
                    i12 += i13;
                }
                i11 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int O() throws IOException {
            int i11 = this.f41327j;
            if (this.f41325h - i11 < 4) {
                U(4);
                i11 = this.f41327j;
            }
            byte[] bArr = this.f41324g;
            this.f41327j = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public long P() throws IOException {
            int i11 = this.f41327j;
            if (this.f41325h - i11 < 8) {
                U(8);
                i11 = this.f41327j;
            }
            byte[] bArr = this.f41324g;
            this.f41327j = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        public int Q() throws IOException {
            int i11;
            int i12 = this.f41327j;
            int i13 = this.f41325h;
            if (i13 != i12) {
                byte[] bArr = this.f41324g;
                int i14 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 >= 0) {
                    this.f41327j = i14;
                    return b11;
                }
                if (i13 - i14 >= 9) {
                    int i15 = i12 + 2;
                    int i16 = (bArr[i14] << 7) ^ b11;
                    if (i16 < 0) {
                        i11 = i16 ^ (-128);
                    } else {
                        int i17 = i12 + 3;
                        int i18 = (bArr[i15] << Ascii.SO) ^ i16;
                        if (i18 >= 0) {
                            i11 = i18 ^ 16256;
                        } else {
                            int i19 = i12 + 4;
                            int i21 = i18 ^ (bArr[i17] << Ascii.NAK);
                            if (i21 < 0) {
                                i11 = (-2080896) ^ i21;
                            } else {
                                i17 = i12 + 5;
                                byte b12 = bArr[i19];
                                int i22 = (i21 ^ (b12 << Ascii.FS)) ^ 266354560;
                                if (b12 < 0) {
                                    i19 = i12 + 6;
                                    if (bArr[i17] < 0) {
                                        i17 = i12 + 7;
                                        if (bArr[i19] < 0) {
                                            i19 = i12 + 8;
                                            if (bArr[i17] < 0) {
                                                i17 = i12 + 9;
                                                if (bArr[i19] < 0) {
                                                    int i23 = i12 + 10;
                                                    if (bArr[i17] >= 0) {
                                                        i15 = i23;
                                                        i11 = i22;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i22;
                                }
                                i11 = i22;
                            }
                            i15 = i19;
                        }
                        i15 = i17;
                    }
                    this.f41327j = i15;
                    return i11;
                }
            }
            return (int) S();
        }

        public long R() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11 = this.f41327j;
            int i12 = this.f41325h;
            if (i12 != i11) {
                byte[] bArr = this.f41324g;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.f41327j = i13;
                    return b11;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b11;
                    if (i15 < 0) {
                        j11 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << Ascii.SO) ^ i15;
                        if (i17 >= 0) {
                            j11 = i17 ^ 16256;
                            i14 = i16;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << Ascii.NAK);
                            if (i19 < 0) {
                                long j14 = (-2080896) ^ i19;
                                i14 = i18;
                                j11 = j14;
                            } else {
                                long j15 = i19;
                                i14 = i11 + 5;
                                long j16 = j15 ^ (((long) bArr[i18]) << 28);
                                if (j16 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    int i21 = i11 + 6;
                                    long j17 = j16 ^ (((long) bArr[i14]) << 35);
                                    if (j17 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i14 = i11 + 7;
                                        j16 = j17 ^ (((long) bArr[i21]) << 42);
                                        if (j16 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            i21 = i11 + 8;
                                            j17 = j16 ^ (((long) bArr[i14]) << 49);
                                            if (j17 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                i14 = i11 + 9;
                                                long j18 = (j17 ^ (((long) bArr[i21]) << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    int i22 = i11 + 10;
                                                    if (bArr[i14] >= 0) {
                                                        i14 = i22;
                                                    }
                                                }
                                                j11 = j18;
                                            }
                                        }
                                    }
                                    j11 = j17 ^ j12;
                                    i14 = i21;
                                }
                                j11 = j16 ^ j13;
                            }
                        }
                    }
                    this.f41327j = i14;
                    return j11;
                }
            }
            return S();
        }

        public long S() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte bK = K();
                j11 |= ((long) (bK & Ascii.DEL)) << i11;
                if ((bK & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void U(int i11) throws IOException {
            if (c0(i11)) {
                return;
            }
            if (i11 <= (this.f41296c - this.f41329l) - this.f41327j) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        public void W() throws IOException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void X(int i11) throws IOException {
            int i12 = this.f41325h;
            int i13 = this.f41327j;
            if (i11 > i12 - i13 || i11 < 0) {
                Y(i11);
            } else {
                this.f41327j = i13 + i11;
            }
        }

        public final void Y(int i11) throws IOException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = this.f41329l;
            int i13 = this.f41327j;
            int i14 = i12 + i13 + i11;
            int i15 = this.f41330m;
            if (i14 > i15) {
                X((i15 - i12) - i13);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41329l = i12 + i13;
            int i16 = this.f41325h - i13;
            this.f41325h = 0;
            this.f41327j = 0;
            while (i16 < i11) {
                try {
                    long j11 = i11 - i16;
                    long jV = V(this.f41323f, j11);
                    if (jV < 0 || jV > j11) {
                        throw new IllegalStateException(this.f41323f.getClass() + "#skip returned invalid result: " + jV + "\nThe InputStream implementation is buggy.");
                    }
                    if (jV == 0) {
                        break;
                    } else {
                        i16 += (int) jV;
                    }
                } catch (Throwable th2) {
                    this.f41329l += i16;
                    T();
                    throw th2;
                }
            }
            this.f41329l += i16;
            T();
            if (i16 >= i11) {
                return;
            }
            int i17 = this.f41325h;
            int i18 = i17 - this.f41327j;
            this.f41327j = i17;
            U(1);
            while (true) {
                int i19 = i11 - i18;
                int i21 = this.f41325h;
                if (i19 <= i21) {
                    this.f41327j = i19;
                    return;
                } else {
                    i18 += i21;
                    this.f41327j = i21;
                    U(1);
                }
            }
        }

        @Override // com.google.protobuf.j
        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f41328k != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public final boolean c0(int i11) throws IOException {
            int i12 = this.f41327j;
            int i13 = i12 + i11;
            int i14 = this.f41325h;
            if (i13 <= i14) {
                throw new IllegalStateException("refillBuffer() called when " + i11 + " bytes were already available in buffer");
            }
            int i15 = this.f41296c;
            int i16 = this.f41329l;
            if (i11 > (i15 - i16) - i12 || i16 + i12 + i11 > this.f41330m) {
                return false;
            }
            if (i12 > 0) {
                if (i14 > i12) {
                    byte[] bArr = this.f41324g;
                    System.arraycopy(bArr, i12, bArr, 0, i14 - i12);
                }
                this.f41329l += i12;
                this.f41325h -= i12;
                this.f41327j = 0;
            }
            InputStream inputStream = this.f41323f;
            byte[] bArr2 = this.f41324g;
            int i17 = this.f41325h;
            int I = I(inputStream, bArr2, i17, Math.min(bArr2.length - i17, (this.f41296c - this.f41329l) - i17));
            if (I == 0 || I < -1 || I > this.f41324g.length) {
                throw new IllegalStateException(this.f41323f.getClass() + "#read(byte[]) returned invalid result: " + I + "\nThe InputStream implementation is buggy.");
            }
            if (I <= 0) {
                return false;
            }
            this.f41325h += I;
            T();
            if (this.f41325h >= i11) {
                return true;
            }
            return c0(i11);
        }

        @Override // com.google.protobuf.j
        public int d() {
            return this.f41329l + this.f41327j;
        }

        @Override // com.google.protobuf.j
        public boolean e() throws IOException {
            return this.f41327j == this.f41325h && !c0(1);
        }

        @Override // com.google.protobuf.j
        public void m(int i11) {
            this.f41330m = i11;
            T();
        }

        @Override // com.google.protobuf.j
        public int n(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = i11 + this.f41329l + this.f41327j;
            int i13 = this.f41330m;
            if (i12 > i13) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41330m = i12;
            T();
            return i13;
        }

        @Override // com.google.protobuf.j
        public boolean o() throws IOException {
            return R() != 0;
        }

        @Override // com.google.protobuf.j
        public ByteString p() throws IOException {
            int iQ = Q();
            int i11 = this.f41325h;
            int i12 = this.f41327j;
            if (iQ > i11 - i12 || iQ <= 0) {
                return iQ == 0 ? ByteString.EMPTY : J(iQ);
            }
            ByteString byteStringCopyFrom = ByteString.copyFrom(this.f41324g, i12, iQ);
            this.f41327j += iQ;
            return byteStringCopyFrom;
        }

        @Override // com.google.protobuf.j
        public double q() throws IOException {
            return Double.longBitsToDouble(P());
        }

        @Override // com.google.protobuf.j
        public int r() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.j
        public int s() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.j
        public long t() throws IOException {
            return P();
        }

        @Override // com.google.protobuf.j
        public float u() throws IOException {
            return Float.intBitsToFloat(O());
        }

        @Override // com.google.protobuf.j
        public int v() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.j
        public long w() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.j
        public int x() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.j
        public long y() throws IOException {
            return P();
        }

        @Override // com.google.protobuf.j
        public int z() throws IOException {
            return j.b(Q());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ByteBuffer f41331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f41332g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f41333h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f41334i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f41335j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f41336k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f41337l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f41338m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f41339n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f41340o;

        public e(ByteBuffer byteBuffer, boolean z11) {
            super();
            this.f41340o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f41331f = byteBuffer;
            long jK = l1.k(byteBuffer);
            this.f41333h = jK;
            this.f41334i = ((long) byteBuffer.limit()) + jK;
            long jPosition = jK + ((long) byteBuffer.position());
            this.f41335j = jPosition;
            this.f41336k = jPosition;
            this.f41332g = z11;
        }

        public static boolean I() {
            return l1.J();
        }

        private void P() {
            long j11 = this.f41334i + ((long) this.f41337l);
            this.f41334i = j11;
            int i11 = (int) (j11 - this.f41336k);
            int i12 = this.f41340o;
            if (i11 <= i12) {
                this.f41337l = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f41337l = i13;
            this.f41334i = j11 - ((long) i13);
        }

        private int Q() {
            return (int) (this.f41334i - this.f41335j);
        }

        private void T() throws IOException {
            if (Q() >= 10) {
                U();
            } else {
                V();
            }
        }

        private void U() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                long j11 = this.f41335j;
                this.f41335j = 1 + j11;
                if (l1.w(j11) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void V() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.j
        public long A() throws IOException {
            return j.c(N());
        }

        @Override // com.google.protobuf.j
        public String B() throws IOException {
            int iM = M();
            if (iM <= 0 || iM > Q()) {
                if (iM == 0) {
                    return "";
                }
                if (iM < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[iM];
            long j11 = iM;
            l1.p(this.f41335j, bArr, 0L, j11);
            String str = new String(bArr, y.f41435a);
            this.f41335j += j11;
            return str;
        }

        @Override // com.google.protobuf.j
        public String C() throws IOException {
            int iM = M();
            if (iM > 0 && iM <= Q()) {
                String strG = Utf8.g(this.f41331f, H(this.f41335j), iM);
                this.f41335j += (long) iM;
                return strG;
            }
            if (iM == 0) {
                return "";
            }
            if (iM <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.j
        public int D() throws IOException {
            if (e()) {
                this.f41338m = 0;
                return 0;
            }
            int iM = M();
            this.f41338m = iM;
            if (WireFormat.a(iM) != 0) {
                return this.f41338m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.j
        public int E() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public long F() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.j
        public boolean G(int i11) throws IOException {
            int iB = WireFormat.b(i11);
            if (iB == 0) {
                T();
                return true;
            }
            if (iB == 1) {
                S(8);
                return true;
            }
            if (iB == 2) {
                S(M());
                return true;
            }
            if (iB == 3) {
                R();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            S(4);
            return true;
        }

        public final int H(long j11) {
            return (int) (j11 - this.f41333h);
        }

        public byte J() throws IOException {
            long j11 = this.f41335j;
            if (j11 == this.f41334i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41335j = 1 + j11;
            return l1.w(j11);
        }

        public int K() throws IOException {
            long j11 = this.f41335j;
            if (this.f41334i - j11 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41335j = 4 + j11;
            return ((l1.w(j11 + 3) & 255) << 24) | (l1.w(j11) & 255) | ((l1.w(1 + j11) & 255) << 8) | ((l1.w(2 + j11) & 255) << 16);
        }

        public long L() throws IOException {
            long j11 = this.f41335j;
            if (this.f41334i - j11 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41335j = 8 + j11;
            return ((((long) l1.w(j11 + 7)) & 255) << 56) | (((long) l1.w(j11)) & 255) | ((((long) l1.w(1 + j11)) & 255) << 8) | ((((long) l1.w(2 + j11)) & 255) << 16) | ((((long) l1.w(3 + j11)) & 255) << 24) | ((((long) l1.w(4 + j11)) & 255) << 32) | ((((long) l1.w(5 + j11)) & 255) << 40) | ((((long) l1.w(6 + j11)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.l1.w(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int M() throws IOException {
            int i11;
            long j11 = this.f41335j;
            if (this.f41334i != j11) {
                long j12 = 1 + j11;
                byte bW = l1.w(j11);
                if (bW >= 0) {
                    this.f41335j = j12;
                    return bW;
                }
                if (this.f41334i - j12 >= 9) {
                    long j13 = 2 + j11;
                    int iW = (l1.w(j12) << 7) ^ bW;
                    if (iW < 0) {
                        i11 = iW ^ (-128);
                    } else {
                        long j14 = 3 + j11;
                        int iW2 = iW ^ (l1.w(j13) << Ascii.SO);
                        if (iW2 >= 0) {
                            i11 = iW2 ^ 16256;
                        } else {
                            j13 = 4 + j11;
                            int iW3 = iW2 ^ (l1.w(j14) << Ascii.NAK);
                            if (iW3 < 0) {
                                i11 = (-2080896) ^ iW3;
                            } else {
                                j14 = 5 + j11;
                                byte bW2 = l1.w(j13);
                                int i12 = (iW3 ^ (bW2 << Ascii.FS)) ^ 266354560;
                                if (bW2 < 0) {
                                    j13 = 6 + j11;
                                    if (l1.w(j14) < 0) {
                                        j14 = 7 + j11;
                                        if (l1.w(j13) < 0) {
                                            j13 = 8 + j11;
                                            if (l1.w(j14) < 0) {
                                                j14 = j11 + 9;
                                                if (l1.w(j13) < 0) {
                                                    j13 = 10 + j11;
                                                }
                                            }
                                        }
                                    }
                                    i11 = i12;
                                }
                                i11 = i12;
                            }
                        }
                        j13 = j14;
                    }
                    this.f41335j = j13;
                    return i11;
                }
            }
            return (int) O();
        }

        public long N() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11;
            long j14 = this.f41335j;
            if (this.f41334i != j14) {
                long j15 = 1 + j14;
                byte bW = l1.w(j14);
                if (bW >= 0) {
                    this.f41335j = j15;
                    return bW;
                }
                if (this.f41334i - j15 >= 9) {
                    long j16 = 2 + j14;
                    int iW = (l1.w(j15) << 7) ^ bW;
                    if (iW >= 0) {
                        long j17 = 3 + j14;
                        int iW2 = iW ^ (l1.w(j16) << Ascii.SO);
                        if (iW2 >= 0) {
                            j11 = iW2 ^ 16256;
                            j16 = j17;
                        } else {
                            j16 = 4 + j14;
                            int iW3 = iW2 ^ (l1.w(j17) << Ascii.NAK);
                            if (iW3 < 0) {
                                i11 = (-2080896) ^ iW3;
                            } else {
                                long j18 = 5 + j14;
                                long jW = ((long) iW3) ^ (((long) l1.w(j16)) << 28);
                                if (jW >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j19 = 6 + j14;
                                    long jW2 = jW ^ (((long) l1.w(j18)) << 35);
                                    if (jW2 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j18 = 7 + j14;
                                        jW = jW2 ^ (((long) l1.w(j19)) << 42);
                                        if (jW >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j19 = 8 + j14;
                                            jW2 = jW ^ (((long) l1.w(j18)) << 49);
                                            if (jW2 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                long j21 = j14 + 9;
                                                long jW3 = (jW2 ^ (((long) l1.w(j19)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j22 = j14 + 10;
                                                    if (l1.w(j21) >= 0) {
                                                        j16 = j22;
                                                        j11 = jW3;
                                                    }
                                                } else {
                                                    j11 = jW3;
                                                    j16 = j21;
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ jW2;
                                    j16 = j19;
                                }
                                j11 = j13 ^ jW;
                                j16 = j18;
                            }
                        }
                        this.f41335j = j16;
                        return j11;
                    }
                    i11 = iW ^ (-128);
                    j11 = i11;
                    this.f41335j = j16;
                    return j11;
                }
            }
            return O();
        }

        public long O() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte bJ = J();
                j11 |= ((long) (bJ & Ascii.DEL)) << i11;
                if ((bJ & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void R() throws IOException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void S(int i11) throws IOException {
            if (i11 >= 0 && i11 <= Q()) {
                this.f41335j += (long) i11;
            } else {
                if (i11 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public final ByteBuffer W(long j11, long j12) throws IOException {
            int iPosition = this.f41331f.position();
            int iLimit = this.f41331f.limit();
            try {
                try {
                    this.f41331f.position(H(j11));
                    this.f41331f.limit(H(j12));
                    ByteBuffer byteBufferSlice = this.f41331f.slice();
                    this.f41331f.position(iPosition);
                    this.f41331f.limit(iLimit);
                    return byteBufferSlice;
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } catch (Throwable th2) {
                this.f41331f.position(iPosition);
                this.f41331f.limit(iLimit);
                throw th2;
            }
        }

        @Override // com.google.protobuf.j
        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f41338m != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return (int) (this.f41335j - this.f41336k);
        }

        @Override // com.google.protobuf.j
        public boolean e() throws IOException {
            return this.f41335j == this.f41334i;
        }

        @Override // com.google.protobuf.j
        public void m(int i11) {
            this.f41340o = i11;
            P();
        }

        @Override // com.google.protobuf.j
        public int n(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int iD = i11 + d();
            int i12 = this.f41340o;
            if (iD > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f41340o = iD;
            P();
            return i12;
        }

        @Override // com.google.protobuf.j
        public boolean o() throws IOException {
            return N() != 0;
        }

        @Override // com.google.protobuf.j
        public ByteString p() throws IOException {
            int iM = M();
            if (iM <= 0 || iM > Q()) {
                if (iM == 0) {
                    return ByteString.EMPTY;
                }
                if (iM < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.f41332g && this.f41339n) {
                long j11 = this.f41335j;
                long j12 = iM;
                ByteBuffer byteBufferW = W(j11, j11 + j12);
                this.f41335j += j12;
                return ByteString.wrap(byteBufferW);
            }
            byte[] bArr = new byte[iM];
            long j13 = iM;
            l1.p(this.f41335j, bArr, 0L, j13);
            this.f41335j += j13;
            return ByteString.wrap(bArr);
        }

        @Override // com.google.protobuf.j
        public double q() throws IOException {
            return Double.longBitsToDouble(L());
        }

        @Override // com.google.protobuf.j
        public int r() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public int s() throws IOException {
            return K();
        }

        @Override // com.google.protobuf.j
        public long t() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public float u() throws IOException {
            return Float.intBitsToFloat(K());
        }

        @Override // com.google.protobuf.j
        public int v() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.j
        public long w() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.j
        public int x() throws IOException {
            return K();
        }

        @Override // com.google.protobuf.j
        public long y() throws IOException {
            return L();
        }

        @Override // com.google.protobuf.j
        public int z() throws IOException {
            return j.b(M());
        }
    }

    public j() {
        this.f41295b = 100;
        this.f41296c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f41298e = false;
    }

    public static int b(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long c(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static j f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static j g(InputStream inputStream, int i11) {
        if (i11 > 0) {
            return inputStream == null ? j(y.f41437c) : new d(inputStream, i11);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static j h(Iterable<ByteBuffer> iterable, boolean z11) {
        int i11 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : iterable) {
            iRemaining += byteBuffer.remaining();
            i11 = byteBuffer.hasArray() ? i11 | 1 : byteBuffer.isDirect() ? i11 | 2 : i11 | 4;
        }
        return i11 == 2 ? new c(iterable, iRemaining, z11) : f(new z(iterable));
    }

    public static j i(ByteBuffer byteBuffer, boolean z11) {
        if (byteBuffer.hasArray()) {
            return l(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z11);
        }
        if (byteBuffer.isDirect() && e.I()) {
            return new e(byteBuffer, z11);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return l(bArr, 0, iRemaining, true);
    }

    public static j j(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static j k(byte[] bArr, int i11, int i12) {
        return l(bArr, i11, i12, false);
    }

    public static j l(byte[] bArr, int i11, int i12, boolean z11) {
        b bVar = new b(bArr, i11, i12, z11);
        try {
            bVar.n(i12);
            return bVar;
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public abstract long A() throws IOException;

    public abstract String B() throws IOException;

    public abstract String C() throws IOException;

    public abstract int D() throws IOException;

    public abstract int E() throws IOException;

    public abstract long F() throws IOException;

    public abstract boolean G(int i11) throws IOException;

    public abstract void a(int i11) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void m(int i11);

    public abstract int n(int i11) throws InvalidProtocolBufferException;

    public abstract boolean o() throws IOException;

    public abstract ByteString p() throws IOException;

    public abstract double q() throws IOException;

    public abstract int r() throws IOException;

    public abstract int s() throws IOException;

    public abstract long t() throws IOException;

    public abstract float u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public abstract int z() throws IOException;
}
