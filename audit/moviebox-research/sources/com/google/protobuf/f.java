package com.google.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class f implements a1 {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41255a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41255a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41255a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41255a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41255a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41255a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41255a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41255a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41255a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41255a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41255a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41255a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41255a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41255a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41255a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41255a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41255a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41255a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f41256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f41257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f41260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41262g;

        public b(ByteBuffer byteBuffer, boolean z11) {
            super(null);
            this.f41256a = z11;
            this.f41257b = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f41258c = iArrayOffset;
            this.f41259d = iArrayOffset;
            this.f41260e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        @Override // com.google.protobuf.a1
        public void A(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof f0)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(g()));
                        if (Q()) {
                            return;
                        } else {
                            i11 = this.f41258c;
                        }
                    } while (b0() == this.f41261f);
                    this.f41258c = i11;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB0 = b0();
                m0(iB0);
                int i13 = this.f41258c + iB0;
                while (this.f41258c < i13) {
                    list.add(Long.valueOf(X()));
                }
                return;
            }
            f0 f0Var = (f0) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 1) {
                do {
                    f0Var.g(g());
                    if (Q()) {
                        return;
                    } else {
                        i12 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i12;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iB1 = b0();
            m0(iB1);
            int i14 = this.f41258c + iB1;
            while (this.f41258c < i14) {
                f0Var.g(X());
            }
        }

        @Override // com.google.protobuf.a1
        public void B(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof x)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 0) {
                    do {
                        list.add(Integer.valueOf(s()));
                        if (Q()) {
                            return;
                        } else {
                            i11 = this.f41258c;
                        }
                    } while (b0() == this.f41261f);
                    this.f41258c = i11;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB0 = this.f41258c + b0();
                while (this.f41258c < iB0) {
                    list.add(Integer.valueOf(b0()));
                }
                f0(iB0);
                return;
            }
            x xVar = (x) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 0) {
                do {
                    xVar.n(s());
                    if (Q()) {
                        return;
                    } else {
                        i12 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i12;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iB1 = this.f41258c + b0();
            while (this.f41258c < iB1) {
                xVar.n(b0());
            }
            f0(iB1);
        }

        @Override // com.google.protobuf.a1
        public void C(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof x)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i13 = this.f41258c + iB0;
                    while (this.f41258c < i13) {
                        list.add(Integer.valueOf(V()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(y()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            x xVar = (x) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 2) {
                int iB1 = b0();
                l0(iB1);
                int i14 = this.f41258c + iB1;
                while (this.f41258c < i14) {
                    xVar.n(V());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                xVar.n(y());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        @Override // com.google.protobuf.a1
        public long D() throws IOException {
            g0(0);
            return j.c(c0());
        }

        @Override // com.google.protobuf.a1
        public String E() throws IOException {
            return Z(false);
        }

        @Override // com.google.protobuf.a1
        public int F() throws IOException {
            if (Q()) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            int iB0 = b0();
            this.f41261f = iB0;
            return iB0 == this.f41262g ? Api.BaseClientBuilder.API_PRIORITY_OTHER : WireFormat.a(iB0);
        }

        @Override // com.google.protobuf.a1
        public void G(List<String> list) throws IOException {
            a0(list, false);
        }

        @Override // com.google.protobuf.a1
        public <T> T H(b1<T> b1Var, p pVar) throws IOException {
            g0(2);
            return (T) Y(b1Var, pVar);
        }

        @Override // com.google.protobuf.a1
        public void I(List<Float> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof v)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i13 = this.f41258c + iB0;
                    while (this.f41258c < i13) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            v vVar = (v) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 2) {
                int iB1 = b0();
                l0(iB1);
                int i14 = this.f41258c + iB1;
                while (this.f41258c < i14) {
                    vVar.f(Float.intBitsToFloat(V()));
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                vVar.f(readFloat());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        @Override // com.google.protobuf.a1
        public boolean J() throws IOException {
            int i11;
            if (Q() || (i11 = this.f41261f) == this.f41262g) {
                return false;
            }
            int iB = WireFormat.b(i11);
            if (iB == 0) {
                j0();
                return true;
            }
            if (iB == 1) {
                h0(8);
                return true;
            }
            if (iB == 2) {
                h0(b0());
                return true;
            }
            if (iB == 3) {
                i0();
                return true;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            h0(4);
            return true;
        }

        @Override // com.google.protobuf.a1
        public int K() throws IOException {
            g0(5);
            return U();
        }

        @Override // com.google.protobuf.a1
        public void L(List<ByteString> list) throws IOException {
            int i11;
            if (WireFormat.b(this.f41261f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(r());
                if (Q()) {
                    return;
                } else {
                    i11 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i11;
        }

        @Override // com.google.protobuf.a1
        public void M(List<Double> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof m)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (Q()) {
                            return;
                        } else {
                            i11 = this.f41258c;
                        }
                    } while (b0() == this.f41261f);
                    this.f41258c = i11;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB0 = b0();
                m0(iB0);
                int i13 = this.f41258c + iB0;
                while (this.f41258c < i13) {
                    list.add(Double.valueOf(Double.longBitsToDouble(X())));
                }
                return;
            }
            m mVar = (m) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 1) {
                do {
                    mVar.f(readDouble());
                    if (Q()) {
                        return;
                    } else {
                        i12 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i12;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iB1 = b0();
            m0(iB1);
            int i14 = this.f41258c + iB1;
            while (this.f41258c < i14) {
                mVar.f(Double.longBitsToDouble(X()));
            }
        }

        @Override // com.google.protobuf.a1
        public long N() throws IOException {
            g0(0);
            return c0();
        }

        @Override // com.google.protobuf.a1
        public String O() throws IOException {
            return Z(true);
        }

        public final boolean Q() {
            return this.f41258c == this.f41260e;
        }

        public final byte R() throws IOException {
            int i11 = this.f41258c;
            if (i11 == this.f41260e) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f41257b;
            this.f41258c = i11 + 1;
            return bArr[i11];
        }

        public final Object S(WireFormat.FieldType fieldType, Class<?> cls, p pVar) throws IOException {
            switch (a.f41255a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(e());
                case 2:
                    return r();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(l());
                case 5:
                    return Integer.valueOf(y());
                case 6:
                    return Long.valueOf(a());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(s());
                case 9:
                    return Long.valueOf(N());
                case 10:
                    return x(cls, pVar);
                case 11:
                    return Integer.valueOf(K());
                case 12:
                    return Long.valueOf(g());
                case 13:
                    return Integer.valueOf(m());
                case 14:
                    return Long.valueOf(D());
                case 15:
                    return O();
                case 16:
                    return Integer.valueOf(i());
                case 17:
                    return Long.valueOf(v());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        public final <T> T T(b1<T> b1Var, p pVar) throws IOException {
            int i11 = this.f41262g;
            this.f41262g = WireFormat.c(WireFormat.a(this.f41261f), 4);
            try {
                T tF = b1Var.f();
                b1Var.h(tF, this, pVar);
                b1Var.c(tF);
                if (this.f41261f != this.f41262g) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                this.f41262g = i11;
                return tF;
            } catch (Throwable th2) {
                this.f41262g = i11;
                throw th2;
            }
        }

        public final int U() throws IOException {
            e0(4);
            return V();
        }

        public final int V() {
            int i11 = this.f41258c;
            byte[] bArr = this.f41257b;
            this.f41258c = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public final long W() throws IOException {
            e0(8);
            return X();
        }

        public final long X() {
            int i11 = this.f41258c;
            byte[] bArr = this.f41257b;
            this.f41258c = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        public final <T> T Y(b1<T> b1Var, p pVar) throws IOException {
            int iB0 = b0();
            e0(iB0);
            int i11 = this.f41260e;
            int i12 = this.f41258c + iB0;
            this.f41260e = i12;
            try {
                T tF = b1Var.f();
                b1Var.h(tF, this, pVar);
                b1Var.c(tF);
                if (this.f41258c != i12) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                this.f41260e = i11;
                return tF;
            } catch (Throwable th2) {
                this.f41260e = i11;
                throw th2;
            }
        }

        public String Z(boolean z11) throws IOException {
            g0(2);
            int iB0 = b0();
            if (iB0 == 0) {
                return "";
            }
            e0(iB0);
            if (z11) {
                byte[] bArr = this.f41257b;
                int i11 = this.f41258c;
                if (!Utf8.t(bArr, i11, i11 + iB0)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.f41257b, this.f41258c, iB0, y.f41435a);
            this.f41258c += iB0;
            return str;
        }

        @Override // com.google.protobuf.a1
        public long a() throws IOException {
            g0(1);
            return W();
        }

        public void a0(List<String> list, boolean z11) throws IOException {
            int i11;
            int i12;
            if (WireFormat.b(this.f41261f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if (!(list instanceof d0) || z11) {
                do {
                    list.add(Z(z11));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            d0 d0Var = (d0) list;
            do {
                d0Var.d(r());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        @Override // com.google.protobuf.a1
        public void b(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof x)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i13 = this.f41258c + iB0;
                    while (this.f41258c < i13) {
                        list.add(Integer.valueOf(V()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(K()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            x xVar = (x) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 2) {
                int iB1 = b0();
                l0(iB1);
                int i14 = this.f41258c + iB1;
                while (this.f41258c < i14) {
                    xVar.n(V());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                xVar.n(K());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        public final int b0() throws IOException {
            int i11;
            int i12 = this.f41258c;
            int i13 = this.f41260e;
            if (i13 == i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f41257b;
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            if (b11 >= 0) {
                this.f41258c = i14;
                return b11;
            }
            if (i13 - i14 < 9) {
                return (int) d0();
            }
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
                                            if (bArr[i17] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i15 = i23;
                                            i11 = i22;
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
            this.f41258c = i15;
            return i11;
        }

        @Override // com.google.protobuf.a1
        public void c(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof f0)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int iB0 = this.f41258c + b0();
                    while (this.f41258c < iB0) {
                        list.add(Long.valueOf(j.c(c0())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(D()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            f0 f0Var = (f0) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB1 = this.f41258c + b0();
                while (this.f41258c < iB1) {
                    f0Var.g(j.c(c0()));
                }
                return;
            }
            do {
                f0Var.g(D());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        public long c0() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11 = this.f41258c;
            int i12 = this.f41260e;
            if (i12 == i11) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f41257b;
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            if (b11 >= 0) {
                this.f41258c = i13;
                return b11;
            }
            if (i12 - i13 < 9) {
                return d0();
            }
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
                                            if (bArr[i14] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i14 = i22;
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
            this.f41258c = i14;
            return j11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.a1
        public <T> void d(List<T> list, b1<T> b1Var, p pVar) throws IOException {
            int i11;
            if (WireFormat.b(this.f41261f) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i12 = this.f41261f;
            do {
                list.add(T(b1Var, pVar));
                if (Q()) {
                    return;
                } else {
                    i11 = this.f41258c;
                }
            } while (b0() == i12);
            this.f41258c = i11;
        }

        public final long d0() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte bR = R();
                j11 |= ((long) (bR & Ascii.DEL)) << i11;
                if ((bR & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.a1
        public boolean e() throws IOException {
            g0(0);
            return b0() != 0;
        }

        public final void e0(int i11) throws IOException {
            if (i11 < 0 || i11 > this.f41260e - this.f41258c) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.a1
        public <T> void f(List<T> list, b1<T> b1Var, p pVar) throws IOException {
            int i11;
            if (WireFormat.b(this.f41261f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i12 = this.f41261f;
            do {
                list.add(Y(b1Var, pVar));
                if (Q()) {
                    return;
                } else {
                    i11 = this.f41258c;
                }
            } while (b0() == i12);
            this.f41258c = i11;
        }

        public final void f0(int i11) throws IOException {
            if (this.f41258c != i11) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.a1
        public long g() throws IOException {
            g0(1);
            return W();
        }

        public final void g0(int i11) throws IOException {
            if (WireFormat.b(this.f41261f) != i11) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.a1
        public int getTag() {
            return this.f41261f;
        }

        @Override // com.google.protobuf.a1
        public void h(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof f0)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(v()));
                        if (Q()) {
                            return;
                        } else {
                            i11 = this.f41258c;
                        }
                    } while (b0() == this.f41261f);
                    this.f41258c = i11;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB0 = this.f41258c + b0();
                while (this.f41258c < iB0) {
                    list.add(Long.valueOf(c0()));
                }
                f0(iB0);
                return;
            }
            f0 f0Var = (f0) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 0) {
                do {
                    f0Var.g(v());
                    if (Q()) {
                        return;
                    } else {
                        i12 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i12;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iB1 = this.f41258c + b0();
            while (this.f41258c < iB1) {
                f0Var.g(c0());
            }
            f0(iB1);
        }

        public final void h0(int i11) throws IOException {
            e0(i11);
            this.f41258c += i11;
        }

        @Override // com.google.protobuf.a1
        public int i() throws IOException {
            g0(0);
            return b0();
        }

        public final void i0() throws IOException {
            int i11 = this.f41262g;
            this.f41262g = WireFormat.c(WireFormat.a(this.f41261f), 4);
            while (F() != Integer.MAX_VALUE && J()) {
            }
            if (this.f41261f != this.f41262g) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.f41262g = i11;
        }

        @Override // com.google.protobuf.a1
        public void j(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof f0)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(N()));
                        if (Q()) {
                            return;
                        } else {
                            i11 = this.f41258c;
                        }
                    } while (b0() == this.f41261f);
                    this.f41258c = i11;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB0 = this.f41258c + b0();
                while (this.f41258c < iB0) {
                    list.add(Long.valueOf(c0()));
                }
                f0(iB0);
                return;
            }
            f0 f0Var = (f0) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 0) {
                do {
                    f0Var.g(N());
                    if (Q()) {
                        return;
                    } else {
                        i12 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i12;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iB1 = this.f41258c + b0();
            while (this.f41258c < iB1) {
                f0Var.g(c0());
            }
            f0(iB1);
        }

        public final void j0() throws IOException {
            int i11 = this.f41260e;
            int i12 = this.f41258c;
            if (i11 - i12 >= 10) {
                byte[] bArr = this.f41257b;
                int i13 = 0;
                while (i13 < 10) {
                    int i14 = i12 + 1;
                    if (bArr[i12] >= 0) {
                        this.f41258c = i14;
                        return;
                    } else {
                        i13++;
                        i12 = i14;
                    }
                }
            }
            k0();
        }

        @Override // com.google.protobuf.a1
        public void k(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof x)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int iB0 = this.f41258c + b0();
                    while (this.f41258c < iB0) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(l()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            x xVar = (x) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB1 = this.f41258c + b0();
                while (this.f41258c < iB1) {
                    xVar.n(b0());
                }
                return;
            }
            do {
                xVar.n(l());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        public final void k0() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (R() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.a1
        public int l() throws IOException {
            g0(0);
            return b0();
        }

        public final void l0(int i11) throws IOException {
            e0(i11);
            if ((i11 & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // com.google.protobuf.a1
        public int m() throws IOException {
            g0(0);
            return j.b(b0());
        }

        public final void m0(int i11) throws IOException {
            e0(i11);
            if ((i11 & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // com.google.protobuf.a1
        public void n(List<Boolean> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof g)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int iB0 = this.f41258c + b0();
                    while (this.f41258c < iB0) {
                        list.add(Boolean.valueOf(b0() != 0));
                    }
                    f0(iB0);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(e()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            g gVar = (g) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB1 = this.f41258c + b0();
                while (this.f41258c < iB1) {
                    gVar.g(b0() != 0);
                }
                f0(iB1);
                return;
            }
            do {
                gVar.g(e());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        @Override // com.google.protobuf.a1
        public <T> T o(Class<T> cls, p pVar) throws IOException {
            g0(3);
            return (T) T(x0.a().d(cls), pVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.a1
        public <K, V> void p(Map<K, V> map, h0.a<K, V> aVar, p pVar) throws IOException {
            g0(2);
            int iB0 = b0();
            e0(iB0);
            int i11 = this.f41260e;
            this.f41260e = this.f41258c + iB0;
            try {
                Object objS = aVar.f41285b;
                Object objS2 = aVar.f41287d;
                while (true) {
                    int iF = F();
                    if (iF == Integer.MAX_VALUE) {
                        map.put(objS, objS2);
                        this.f41260e = i11;
                        return;
                    } else if (iF == 1) {
                        objS = S(aVar.f41284a, null, null);
                    } else if (iF != 2) {
                        try {
                            if (!J()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!J()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        objS2 = S(aVar.f41286c, aVar.f41287d.getClass(), pVar);
                    }
                }
            } catch (Throwable th2) {
                this.f41260e = i11;
                throw th2;
            }
        }

        @Override // com.google.protobuf.a1
        public void q(List<String> list) throws IOException {
            a0(list, true);
        }

        @Override // com.google.protobuf.a1
        public ByteString r() throws IOException {
            g0(2);
            int iB0 = b0();
            if (iB0 == 0) {
                return ByteString.EMPTY;
            }
            e0(iB0);
            ByteString byteStringWrap = this.f41256a ? ByteString.wrap(this.f41257b, this.f41258c, iB0) : ByteString.copyFrom(this.f41257b, this.f41258c, iB0);
            this.f41258c += iB0;
            return byteStringWrap;
        }

        @Override // com.google.protobuf.a1
        public double readDouble() throws IOException {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // com.google.protobuf.a1
        public float readFloat() throws IOException {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        @Override // com.google.protobuf.a1
        public int s() throws IOException {
            g0(0);
            return b0();
        }

        @Override // com.google.protobuf.a1
        public void t(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof f0)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(a()));
                        if (Q()) {
                            return;
                        } else {
                            i11 = this.f41258c;
                        }
                    } while (b0() == this.f41261f);
                    this.f41258c = i11;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB0 = b0();
                m0(iB0);
                int i13 = this.f41258c + iB0;
                while (this.f41258c < i13) {
                    list.add(Long.valueOf(X()));
                }
                return;
            }
            f0 f0Var = (f0) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 == 1) {
                do {
                    f0Var.g(a());
                    if (Q()) {
                        return;
                    } else {
                        i12 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i12;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iB1 = b0();
            m0(iB1);
            int i14 = this.f41258c + iB1;
            while (this.f41258c < i14) {
                f0Var.g(X());
            }
        }

        @Override // com.google.protobuf.a1
        public void u(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof x)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int iB0 = this.f41258c + b0();
                    while (this.f41258c < iB0) {
                        list.add(Integer.valueOf(j.b(b0())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(m()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            x xVar = (x) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB1 = this.f41258c + b0();
                while (this.f41258c < iB1) {
                    xVar.n(j.b(b0()));
                }
                return;
            }
            do {
                xVar.n(m());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        @Override // com.google.protobuf.a1
        public long v() throws IOException {
            g0(0);
            return c0();
        }

        @Override // com.google.protobuf.a1
        public void w(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (!(list instanceof x)) {
                int iB = WireFormat.b(this.f41261f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int iB0 = this.f41258c + b0();
                    while (this.f41258c < iB0) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(i()));
                    if (Q()) {
                        return;
                    } else {
                        i11 = this.f41258c;
                    }
                } while (b0() == this.f41261f);
                this.f41258c = i11;
                return;
            }
            x xVar = (x) list;
            int iB2 = WireFormat.b(this.f41261f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int iB1 = this.f41258c + b0();
                while (this.f41258c < iB1) {
                    xVar.n(b0());
                }
                return;
            }
            do {
                xVar.n(i());
                if (Q()) {
                    return;
                } else {
                    i12 = this.f41258c;
                }
            } while (b0() == this.f41261f);
            this.f41258c = i12;
        }

        @Override // com.google.protobuf.a1
        public <T> T x(Class<T> cls, p pVar) throws IOException {
            g0(2);
            return (T) Y(x0.a().d(cls), pVar);
        }

        @Override // com.google.protobuf.a1
        public int y() throws IOException {
            g0(5);
            return U();
        }

        @Override // com.google.protobuf.a1
        public <T> T z(b1<T> b1Var, p pVar) throws IOException {
            g0(3);
            return (T) T(b1Var, pVar);
        }
    }

    public f() {
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f P(ByteBuffer byteBuffer, boolean z11) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z11);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
