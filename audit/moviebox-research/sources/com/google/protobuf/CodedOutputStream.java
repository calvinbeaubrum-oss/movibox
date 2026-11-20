package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class CodedOutputStream extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f41154c = Logger.getLogger(CodedOutputStream.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f41155d = l1.I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f41156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f41157b;

    /* JADX INFO: compiled from: source.java */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }

        public OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static class b extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f41158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41159f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f41160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f41161h;

        public b(byte[] bArr, int i11, int i12) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i13 = i11 + i12;
            if ((i11 | i12 | (bArr.length - i13)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            this.f41158e = bArr;
            this.f41159f = i11;
            this.f41161h = i11;
            this.f41160g = i13;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void C0(int i11, int i12) throws IOException {
            U0(i11, 0);
            D0(i12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void D0(int i11) throws IOException {
            if (i11 >= 0) {
                W0(i11);
            } else {
                Y0(i11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void G0(int i11, n0 n0Var, b1 b1Var) throws IOException {
            U0(i11, 2);
            W0(((com.google.protobuf.a) n0Var).r(b1Var));
            b1Var.b(n0Var, this.f41156a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void H0(n0 n0Var) throws IOException {
            W0(n0Var.g());
            n0Var.l(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void I0(int i11, n0 n0Var) throws IOException {
            U0(1, 3);
            V0(2, i11);
            b1(3, n0Var);
            U0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void J0(int i11, ByteString byteString) throws IOException {
            U0(1, 3);
            V0(2, i11);
            m0(3, byteString);
            U0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void S0(int i11, String str) throws IOException {
            U0(i11, 2);
            T0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void T0(String str) throws IOException {
            int i11 = this.f41161h;
            try {
                int iX = CodedOutputStream.X(str.length() * 3);
                int iX2 = CodedOutputStream.X(str.length());
                if (iX2 == iX) {
                    int i12 = i11 + iX2;
                    this.f41161h = i12;
                    int i13 = Utf8.i(str, this.f41158e, i12, g0());
                    this.f41161h = i11;
                    W0((i13 - i11) - iX2);
                    this.f41161h = i13;
                } else {
                    W0(Utf8.j(str));
                    this.f41161h = Utf8.i(str, this.f41158e, this.f41161h, g0());
                }
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.f41161h = i11;
                c0(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException(e12);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void U0(int i11, int i12) throws IOException {
            W0(WireFormat.c(i11, i12));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void V0(int i11, int i12) throws IOException {
            U0(i11, 0);
            W0(i12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void W0(int i11) throws IOException {
            if (!CodedOutputStream.f41155d || d.c() || g0() < 5) {
                while ((i11 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f41158e;
                        int i12 = this.f41161h;
                        this.f41161h = i12 + 1;
                        bArr[i12] = (byte) ((i11 & 127) | 128);
                        i11 >>>= 7;
                    } catch (IndexOutOfBoundsException e11) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), 1), e11);
                    }
                }
                byte[] bArr2 = this.f41158e;
                int i13 = this.f41161h;
                this.f41161h = i13 + 1;
                bArr2[i13] = (byte) i11;
                return;
            }
            if ((i11 & (-128)) == 0) {
                byte[] bArr3 = this.f41158e;
                int i14 = this.f41161h;
                this.f41161h = i14 + 1;
                l1.P(bArr3, i14, (byte) i11);
                return;
            }
            byte[] bArr4 = this.f41158e;
            int i15 = this.f41161h;
            this.f41161h = i15 + 1;
            l1.P(bArr4, i15, (byte) (i11 | 128));
            int i16 = i11 >>> 7;
            if ((i16 & (-128)) == 0) {
                byte[] bArr5 = this.f41158e;
                int i17 = this.f41161h;
                this.f41161h = i17 + 1;
                l1.P(bArr5, i17, (byte) i16);
                return;
            }
            byte[] bArr6 = this.f41158e;
            int i18 = this.f41161h;
            this.f41161h = i18 + 1;
            l1.P(bArr6, i18, (byte) (i16 | 128));
            int i19 = i11 >>> 14;
            if ((i19 & (-128)) == 0) {
                byte[] bArr7 = this.f41158e;
                int i21 = this.f41161h;
                this.f41161h = i21 + 1;
                l1.P(bArr7, i21, (byte) i19);
                return;
            }
            byte[] bArr8 = this.f41158e;
            int i22 = this.f41161h;
            this.f41161h = i22 + 1;
            l1.P(bArr8, i22, (byte) (i19 | 128));
            int i23 = i11 >>> 21;
            if ((i23 & (-128)) == 0) {
                byte[] bArr9 = this.f41158e;
                int i24 = this.f41161h;
                this.f41161h = i24 + 1;
                l1.P(bArr9, i24, (byte) i23);
                return;
            }
            byte[] bArr10 = this.f41158e;
            int i25 = this.f41161h;
            this.f41161h = i25 + 1;
            l1.P(bArr10, i25, (byte) (i23 | 128));
            byte[] bArr11 = this.f41158e;
            int i26 = this.f41161h;
            this.f41161h = i26 + 1;
            l1.P(bArr11, i26, (byte) (i11 >>> 28));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void X0(int i11, long j11) throws IOException {
            U0(i11, 0);
            Y0(j11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Y0(long j11) throws IOException {
            if (CodedOutputStream.f41155d && g0() >= 10) {
                while ((j11 & (-128)) != 0) {
                    byte[] bArr = this.f41158e;
                    int i11 = this.f41161h;
                    this.f41161h = i11 + 1;
                    l1.P(bArr, i11, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr2 = this.f41158e;
                int i12 = this.f41161h;
                this.f41161h = i12 + 1;
                l1.P(bArr2, i12, (byte) j11);
                return;
            }
            while ((j11 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f41158e;
                    int i13 = this.f41161h;
                    this.f41161h = i13 + 1;
                    bArr3[i13] = (byte) ((((int) j11) & 127) | 128);
                    j11 >>>= 7;
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), 1), e11);
                }
            }
            byte[] bArr4 = this.f41158e;
            int i14 = this.f41161h;
            this.f41161h = i14 + 1;
            bArr4[i14] = (byte) j11;
        }

        public final void Z0(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f41158e, this.f41161h, iRemaining);
                this.f41161h += iRemaining;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), Integer.valueOf(iRemaining)), e11);
            }
        }

        @Override // com.google.protobuf.i
        public final void a(ByteBuffer byteBuffer) throws IOException {
            Z0(byteBuffer);
        }

        public final void a1(byte[] bArr, int i11, int i12) throws IOException {
            try {
                System.arraycopy(bArr, i11, this.f41158e, this.f41161h, i12);
                this.f41161h += i12;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), Integer.valueOf(i12)), e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.i
        public final void b(byte[] bArr, int i11, int i12) throws IOException {
            a1(bArr, i11, i12);
        }

        public final void b1(int i11, n0 n0Var) throws IOException {
            U0(i11, 2);
            H0(n0Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int g0() {
            return this.f41160g - this.f41161h;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void h0(byte b11) throws IOException {
            try {
                byte[] bArr = this.f41158e;
                int i11 = this.f41161h;
                this.f41161h = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), 1), e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void i0(int i11, boolean z11) throws IOException {
            U0(i11, 0);
            h0(z11 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void l0(byte[] bArr, int i11, int i12) throws IOException {
            W0(i12);
            a1(bArr, i11, i12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void m0(int i11, ByteString byteString) throws IOException {
            U0(i11, 2);
            n0(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void n0(ByteString byteString) throws IOException {
            W0(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void s0(int i11, int i12) throws IOException {
            U0(i11, 5);
            t0(i12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void t0(int i11) throws IOException {
            try {
                byte[] bArr = this.f41158e;
                int i12 = this.f41161h;
                bArr[i12] = (byte) (i11 & 255);
                bArr[i12 + 1] = (byte) ((i11 >> 8) & 255);
                bArr[i12 + 2] = (byte) ((i11 >> 16) & 255);
                this.f41161h = i12 + 4;
                bArr[i12 + 3] = (byte) ((i11 >> 24) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), 1), e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void u0(int i11, long j11) throws IOException {
            U0(i11, 1);
            v0(j11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void v0(long j11) throws IOException {
            try {
                byte[] bArr = this.f41158e;
                int i11 = this.f41161h;
                bArr[i11] = (byte) (((int) j11) & 255);
                bArr[i11 + 1] = (byte) (((int) (j11 >> 8)) & 255);
                bArr[i11 + 2] = (byte) (((int) (j11 >> 16)) & 255);
                bArr[i11 + 3] = (byte) (((int) (j11 >> 24)) & 255);
                bArr[i11 + 4] = (byte) (((int) (j11 >> 32)) & 255);
                bArr[i11 + 5] = (byte) (((int) (j11 >> 40)) & 255);
                bArr[i11 + 6] = (byte) (((int) (j11 >> 48)) & 255);
                this.f41161h = i11 + 8;
                bArr[i11 + 7] = (byte) (((int) (j11 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f41161h), Integer.valueOf(this.f41160g), 1), e11);
            }
        }
    }

    public CodedOutputStream() {
    }

    public static int A(int i11, b0 b0Var) {
        return (V(1) * 2) + W(2, i11) + B(3, b0Var);
    }

    public static int B(int i11, b0 b0Var) {
        return V(i11) + C(b0Var);
    }

    public static int C(b0 b0Var) {
        return D(b0Var.b());
    }

    public static int D(int i11) {
        return X(i11) + i11;
    }

    public static int E(int i11, n0 n0Var) {
        return (V(1) * 2) + W(2, i11) + F(3, n0Var);
    }

    public static int F(int i11, n0 n0Var) {
        return V(i11) + H(n0Var);
    }

    public static int G(int i11, n0 n0Var, b1 b1Var) {
        return V(i11) + I(n0Var, b1Var);
    }

    public static int H(n0 n0Var) {
        return D(n0Var.g());
    }

    public static int I(n0 n0Var, b1 b1Var) {
        return D(((com.google.protobuf.a) n0Var).r(b1Var));
    }

    public static int J(int i11, ByteString byteString) {
        return (V(1) * 2) + W(2, i11) + h(3, byteString);
    }

    @Deprecated
    public static int K(int i11) {
        return X(i11);
    }

    public static int L(int i11, int i12) {
        return V(i11) + M(i12);
    }

    public static int M(int i11) {
        return 4;
    }

    public static int N(int i11, long j11) {
        return V(i11) + O(j11);
    }

    public static int O(long j11) {
        return 8;
    }

    public static int P(int i11, int i12) {
        return V(i11) + Q(i12);
    }

    public static int Q(int i11) {
        return X(a0(i11));
    }

    public static int R(int i11, long j11) {
        return V(i11) + S(j11);
    }

    public static int S(long j11) {
        return Z(b0(j11));
    }

    public static int T(int i11, String str) {
        return V(i11) + U(str);
    }

    public static int U(String str) {
        int length;
        try {
            length = Utf8.j(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(y.f41435a).length;
        }
        return D(length);
    }

    public static int V(int i11) {
        return X(WireFormat.c(i11, 0));
    }

    public static int W(int i11, int i12) {
        return V(i11) + X(i12);
    }

    public static int X(int i11) {
        if ((i11 & (-128)) == 0) {
            return 1;
        }
        if ((i11 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i11) == 0) {
            return 3;
        }
        return (i11 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Y(int i11, long j11) {
        return V(i11) + Z(j11);
    }

    public static int Z(long j11) {
        int i11;
        if (((-128) & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if (((-34359738368L) & j11) != 0) {
            j11 >>>= 28;
            i11 = 6;
        } else {
            i11 = 2;
        }
        if (((-2097152) & j11) != 0) {
            i11 += 2;
            j11 >>>= 14;
        }
        return (j11 & (-16384)) != 0 ? i11 + 1 : i11;
    }

    public static int a0(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    public static long b0(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int e(int i11, boolean z11) {
        return V(i11) + f(z11);
    }

    public static CodedOutputStream e0(byte[] bArr) {
        return f0(bArr, 0, bArr.length);
    }

    public static int f(boolean z11) {
        return 1;
    }

    public static CodedOutputStream f0(byte[] bArr, int i11, int i12) {
        return new b(bArr, i11, i12);
    }

    public static int g(byte[] bArr) {
        return D(bArr.length);
    }

    public static int h(int i11, ByteString byteString) {
        return V(i11) + i(byteString);
    }

    public static int i(ByteString byteString) {
        return D(byteString.size());
    }

    public static int j(int i11, double d11) {
        return V(i11) + k(d11);
    }

    public static int k(double d11) {
        return 8;
    }

    public static int l(int i11, int i12) {
        return V(i11) + m(i12);
    }

    public static int m(int i11) {
        return x(i11);
    }

    public static int n(int i11, int i12) {
        return V(i11) + o(i12);
    }

    public static int o(int i11) {
        return 4;
    }

    public static int p(int i11, long j11) {
        return V(i11) + q(j11);
    }

    public static int q(long j11) {
        return 8;
    }

    public static int r(int i11, float f11) {
        return V(i11) + s(f11);
    }

    public static int s(float f11) {
        return 4;
    }

    @Deprecated
    public static int t(int i11, n0 n0Var, b1 b1Var) {
        return (V(i11) * 2) + v(n0Var, b1Var);
    }

    @Deprecated
    public static int u(n0 n0Var) {
        return n0Var.g();
    }

    @Deprecated
    public static int v(n0 n0Var, b1 b1Var) {
        return ((com.google.protobuf.a) n0Var).r(b1Var);
    }

    public static int w(int i11, int i12) {
        return V(i11) + x(i12);
    }

    public static int x(int i11) {
        if (i11 >= 0) {
            return X(i11);
        }
        return 10;
    }

    public static int y(int i11, long j11) {
        return V(i11) + z(j11);
    }

    public static int z(long j11) {
        return Z(j11);
    }

    @Deprecated
    public final void A0(n0 n0Var) throws IOException {
        n0Var.l(this);
    }

    @Deprecated
    public final void B0(n0 n0Var, b1 b1Var) throws IOException {
        b1Var.b(n0Var, this.f41156a);
    }

    public abstract void C0(int i11, int i12) throws IOException;

    public abstract void D0(int i11) throws IOException;

    public final void E0(int i11, long j11) throws IOException {
        X0(i11, j11);
    }

    public final void F0(long j11) throws IOException {
        Y0(j11);
    }

    public abstract void G0(int i11, n0 n0Var, b1 b1Var) throws IOException;

    public abstract void H0(n0 n0Var) throws IOException;

    public abstract void I0(int i11, n0 n0Var) throws IOException;

    public abstract void J0(int i11, ByteString byteString) throws IOException;

    public final void K0(int i11, int i12) throws IOException {
        s0(i11, i12);
    }

    public final void L0(int i11) throws IOException {
        t0(i11);
    }

    public final void M0(int i11, long j11) throws IOException {
        u0(i11, j11);
    }

    public final void N0(long j11) throws IOException {
        v0(j11);
    }

    public final void O0(int i11, int i12) throws IOException {
        V0(i11, a0(i12));
    }

    public final void P0(int i11) throws IOException {
        W0(a0(i11));
    }

    public final void Q0(int i11, long j11) throws IOException {
        X0(i11, b0(j11));
    }

    public final void R0(long j11) throws IOException {
        Y0(b0(j11));
    }

    public abstract void S0(int i11, String str) throws IOException;

    public abstract void T0(String str) throws IOException;

    public abstract void U0(int i11, int i12) throws IOException;

    public abstract void V0(int i11, int i12) throws IOException;

    public abstract void W0(int i11) throws IOException;

    public abstract void X0(int i11, long j11) throws IOException;

    public abstract void Y0(long j11) throws IOException;

    @Override // com.google.protobuf.i
    public abstract void b(byte[] bArr, int i11, int i12) throws IOException;

    public final void c0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f41154c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(y.f41435a);
        try {
            W0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e11) {
            throw e11;
        } catch (IndexOutOfBoundsException e12) {
            throw new OutOfSpaceException(e12);
        }
    }

    public final void d() {
        if (g0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public boolean d0() {
        return this.f41157b;
    }

    public abstract int g0();

    public abstract void h0(byte b11) throws IOException;

    public abstract void i0(int i11, boolean z11) throws IOException;

    public final void j0(boolean z11) throws IOException {
        h0(z11 ? (byte) 1 : (byte) 0);
    }

    public final void k0(byte[] bArr) throws IOException {
        l0(bArr, 0, bArr.length);
    }

    public abstract void l0(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void m0(int i11, ByteString byteString) throws IOException;

    public abstract void n0(ByteString byteString) throws IOException;

    public final void o0(int i11, double d11) throws IOException {
        u0(i11, Double.doubleToRawLongBits(d11));
    }

    public final void p0(double d11) throws IOException {
        v0(Double.doubleToRawLongBits(d11));
    }

    public final void q0(int i11, int i12) throws IOException {
        C0(i11, i12);
    }

    public final void r0(int i11) throws IOException {
        D0(i11);
    }

    public abstract void s0(int i11, int i12) throws IOException;

    public abstract void t0(int i11) throws IOException;

    public abstract void u0(int i11, long j11) throws IOException;

    public abstract void v0(long j11) throws IOException;

    public final void w0(int i11, float f11) throws IOException {
        s0(i11, Float.floatToRawIntBits(f11));
    }

    public final void x0(float f11) throws IOException {
        t0(Float.floatToRawIntBits(f11));
    }

    @Deprecated
    public final void y0(int i11, n0 n0Var) throws IOException {
        U0(i11, 3);
        A0(n0Var);
        U0(i11, 4);
    }

    @Deprecated
    public final void z0(int i11, n0 n0Var, b1 b1Var) throws IOException {
        U0(i11, 3);
        B0(n0Var, b1Var);
        U0(i11, 4);
    }
}
