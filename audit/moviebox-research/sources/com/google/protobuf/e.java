package com.google.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41226a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41226a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41226a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41226a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41226a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41226a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41226a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41226a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41226a[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41226a[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41226a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41226a[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41226a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41226a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41226a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41226a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41226a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41226a[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f41226a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f41228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f41229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final p f41230d;

        public b(p pVar) {
            pVar.getClass();
            this.f41230d = pVar;
        }
    }

    public static int A(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        x xVar = (x) jVar;
        int I = I(bArr, i12, bVar);
        xVar.n(j.b(bVar.f41227a));
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            I = I(bArr, I2, bVar);
            xVar.n(j.b(bVar.f41227a));
        }
        return I;
    }

    public static int B(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        f0 f0Var = (f0) jVar;
        int iL = L(bArr, i12, bVar);
        f0Var.g(j.c(bVar.f41228b));
        while (iL < i13) {
            int I = I(bArr, iL, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            iL = L(bArr, I, bVar);
            f0Var.g(j.c(bVar.f41228b));
        }
        return iL;
    }

    public static int C(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 == 0) {
            bVar.f41229c = "";
            return I;
        }
        bVar.f41229c = new String(bArr, I, i12, y.f41435a);
        return I + i12;
    }

    public static int D(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i12, bVar);
        int i14 = bVar.f41227a;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 == 0) {
            jVar.add("");
        } else {
            jVar.add(new String(bArr, I, i14, y.f41435a));
            I += i14;
        }
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            I = I(bArr, I2, bVar);
            int i15 = bVar.f41227a;
            if (i15 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i15 == 0) {
                jVar.add("");
            } else {
                jVar.add(new String(bArr, I, i15, y.f41435a));
                I += i15;
            }
        }
        return I;
    }

    public static int E(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i12, bVar);
        int i14 = bVar.f41227a;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 == 0) {
            jVar.add("");
        } else {
            int i15 = I + i14;
            if (!Utf8.t(bArr, I, i15)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            jVar.add(new String(bArr, I, i14, y.f41435a));
            I = i15;
        }
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            I = I(bArr, I2, bVar);
            int i16 = bVar.f41227a;
            if (i16 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i16 == 0) {
                jVar.add("");
            } else {
                int i17 = I + i16;
                if (!Utf8.t(bArr, I, i17)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                jVar.add(new String(bArr, I, i16, y.f41435a));
                I = i17;
            }
        }
        return I;
    }

    public static int F(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 == 0) {
            bVar.f41229c = "";
            return I;
        }
        bVar.f41229c = Utf8.h(bArr, I, i12);
        return I + i12;
    }

    public static int G(int i11, byte[] bArr, int i12, int i13, i1 i1Var, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i11) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int iB = WireFormat.b(i11);
        if (iB == 0) {
            int iL = L(bArr, i12, bVar);
            i1Var.m(i11, Long.valueOf(bVar.f41228b));
            return iL;
        }
        if (iB == 1) {
            i1Var.m(i11, Long.valueOf(j(bArr, i12)));
            return i12 + 8;
        }
        if (iB == 2) {
            int I = I(bArr, i12, bVar);
            int i14 = bVar.f41227a;
            if (i14 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i14 > bArr.length - I) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i14 == 0) {
                i1Var.m(i11, ByteString.EMPTY);
            } else {
                i1Var.m(i11, ByteString.copyFrom(bArr, I, i14));
            }
            return I + i14;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            i1Var.m(i11, Integer.valueOf(h(bArr, i12)));
            return i12 + 4;
        }
        i1 i1VarJ = i1.j();
        int i15 = (i11 & (-8)) | 4;
        int i16 = 0;
        while (i12 < i13) {
            int I2 = I(bArr, i12, bVar);
            int i17 = bVar.f41227a;
            if (i17 == i15) {
                i16 = i17;
                i12 = I2;
                break;
            }
            i16 = i17;
            i12 = G(i17, bArr, I2, i13, i1VarJ, bVar);
        }
        if (i12 > i13 || i16 != i15) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        i1Var.m(i11, i1VarJ);
        return i12;
    }

    public static int H(int i11, byte[] bArr, int i12, b bVar) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            bVar.f41227a = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Ascii.DEL) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            bVar.f41227a = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            bVar.f41227a = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            bVar.f41227a = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] >= 0) {
                bVar.f41227a = i22;
                return i23;
            }
            i21 = i23;
        }
    }

    public static int I(byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return H(b11, bArr, i12, bVar);
        }
        bVar.f41227a = b11;
        return i12;
    }

    public static int J(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        x xVar = (x) jVar;
        int I = I(bArr, i12, bVar);
        xVar.n(bVar.f41227a);
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            I = I(bArr, I2, bVar);
            xVar.n(bVar.f41227a);
        }
        return I;
    }

    public static int K(long j11, byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        long j12 = (j11 & 127) | (((long) (b11 & Ascii.DEL)) << 7);
        int i13 = 7;
        while (b11 < 0) {
            int i14 = i12 + 1;
            byte b12 = bArr[i12];
            i13 += 7;
            j12 |= ((long) (b12 & Ascii.DEL)) << i13;
            i12 = i14;
            b11 = b12;
        }
        bVar.f41228b = j12;
        return i12;
    }

    public static int L(byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        if (j11 < 0) {
            return K(j11, bArr, i12, bVar);
        }
        bVar.f41228b = j11;
        return i12;
    }

    public static int M(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        f0 f0Var = (f0) jVar;
        int iL = L(bArr, i12, bVar);
        f0Var.g(bVar.f41228b);
        while (iL < i13) {
            int I = I(bArr, iL, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            iL = L(bArr, I, bVar);
            f0Var.g(bVar.f41228b);
        }
        return iL;
    }

    public static int N(int i11, byte[] bArr, int i12, int i13, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i11) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int iB = WireFormat.b(i11);
        if (iB == 0) {
            return L(bArr, i12, bVar);
        }
        if (iB == 1) {
            return i12 + 8;
        }
        if (iB == 2) {
            return I(bArr, i12, bVar) + bVar.f41227a;
        }
        if (iB != 3) {
            if (iB == 5) {
                return i12 + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i14 = (i11 & (-8)) | 4;
        int i15 = 0;
        while (i12 < i13) {
            i12 = I(bArr, i12, bVar);
            i15 = bVar.f41227a;
            if (i15 == i14) {
                break;
            }
            i12 = N(i15, bArr, i12, i13, bVar);
        }
        if (i12 > i13 || i15 != i14) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i12;
    }

    public static int a(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        g gVar = (g) jVar;
        int iL = L(bArr, i12, bVar);
        gVar.g(bVar.f41228b != 0);
        while (iL < i13) {
            int I = I(bArr, iL, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            iL = L(bArr, I, bVar);
            gVar.g(bVar.f41228b != 0);
        }
        return iL;
    }

    public static int b(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 > bArr.length - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i12 == 0) {
            bVar.f41229c = ByteString.EMPTY;
            return I;
        }
        bVar.f41229c = ByteString.copyFrom(bArr, I, i12);
        return I + i12;
    }

    public static int c(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i12, bVar);
        int i14 = bVar.f41227a;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 > bArr.length - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i14 == 0) {
            jVar.add(ByteString.EMPTY);
        } else {
            jVar.add(ByteString.copyFrom(bArr, I, i14));
            I += i14;
        }
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            I = I(bArr, I2, bVar);
            int i15 = bVar.f41227a;
            if (i15 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i15 > bArr.length - I) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i15 == 0) {
                jVar.add(ByteString.EMPTY);
            } else {
                jVar.add(ByteString.copyFrom(bArr, I, i15));
                I += i15;
            }
        }
        return I;
    }

    public static double d(byte[] bArr, int i11) {
        return Double.longBitsToDouble(j(bArr, i11));
    }

    public static int e(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        m mVar = (m) jVar;
        mVar.f(d(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            mVar.f(d(bArr, I));
            i14 = I + 8;
        }
        return i14;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int f(int i11, byte[] bArr, int i12, int i13, GeneratedMessageLite.c<?, ?> cVar, GeneratedMessageLite.e<?, ?> eVar, h1<i1, i1> h1Var, b bVar) throws IOException {
        Object objI;
        u<GeneratedMessageLite.d> uVar = cVar.extensions;
        int i14 = i11 >>> 3;
        Object objValueOf = null;
        if (eVar.f41183b.N() && eVar.f41183b.isPacked()) {
            switch (a.f41226a[eVar.a().ordinal()]) {
                case 1:
                    m mVar = new m();
                    int iS = s(bArr, i12, mVar, bVar);
                    uVar.x(eVar.f41183b, mVar);
                    return iS;
                case 2:
                    v vVar = new v();
                    int iV = v(bArr, i12, vVar, bVar);
                    uVar.x(eVar.f41183b, vVar);
                    return iV;
                case 3:
                case 4:
                    f0 f0Var = new f0();
                    int iZ = z(bArr, i12, f0Var, bVar);
                    uVar.x(eVar.f41183b, f0Var);
                    return iZ;
                case 5:
                case 6:
                    x xVar = new x();
                    int iY = y(bArr, i12, xVar, bVar);
                    uVar.x(eVar.f41183b, xVar);
                    return iY;
                case 7:
                case 8:
                    f0 f0Var2 = new f0();
                    int iU = u(bArr, i12, f0Var2, bVar);
                    uVar.x(eVar.f41183b, f0Var2);
                    return iU;
                case 9:
                case 10:
                    x xVar2 = new x();
                    int iT = t(bArr, i12, xVar2, bVar);
                    uVar.x(eVar.f41183b, xVar2);
                    return iT;
                case 11:
                    g gVar = new g();
                    int iR = r(bArr, i12, gVar, bVar);
                    uVar.x(eVar.f41183b, gVar);
                    return iR;
                case 12:
                    x xVar3 = new x();
                    int iW = w(bArr, i12, xVar3, bVar);
                    uVar.x(eVar.f41183b, xVar3);
                    return iW;
                case 13:
                    f0 f0Var3 = new f0();
                    int iX = x(bArr, i12, f0Var3, bVar);
                    uVar.x(eVar.f41183b, f0Var3);
                    return iX;
                case 14:
                    x xVar4 = new x();
                    int iY2 = y(bArr, i12, xVar4, bVar);
                    i1 i1Var = cVar.unknownFields;
                    i1 i1Var2 = (i1) d1.z(i14, xVar4, eVar.f41183b.b(), i1Var != i1.c() ? i1Var : null, h1Var);
                    if (i1Var2 != null) {
                        cVar.unknownFields = i1Var2;
                    }
                    uVar.x(eVar.f41183b, xVar4);
                    return iY2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f41183b.O());
            }
        }
        if (eVar.a() != WireFormat.FieldType.ENUM) {
            switch (a.f41226a[eVar.a().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(d(bArr, i12));
                    i12 += 8;
                    break;
                case 2:
                    objValueOf = Float.valueOf(l(bArr, i12));
                    i12 += 4;
                    break;
                case 3:
                case 4:
                    i12 = L(bArr, i12, bVar);
                    objValueOf = Long.valueOf(bVar.f41228b);
                    break;
                case 5:
                case 6:
                    i12 = I(bArr, i12, bVar);
                    objValueOf = Integer.valueOf(bVar.f41227a);
                    break;
                case 7:
                case 8:
                    objValueOf = Long.valueOf(j(bArr, i12));
                    i12 += 8;
                    break;
                case 9:
                case 10:
                    objValueOf = Integer.valueOf(h(bArr, i12));
                    i12 += 4;
                    break;
                case 11:
                    i12 = L(bArr, i12, bVar);
                    objValueOf = Boolean.valueOf(bVar.f41228b != 0);
                    break;
                case 12:
                    i12 = I(bArr, i12, bVar);
                    objValueOf = Integer.valueOf(j.b(bVar.f41227a));
                    break;
                case 13:
                    i12 = L(bArr, i12, bVar);
                    objValueOf = Long.valueOf(j.c(bVar.f41228b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i12 = b(bArr, i12, bVar);
                    objValueOf = bVar.f41229c;
                    break;
                case 16:
                    i12 = C(bArr, i12, bVar);
                    objValueOf = bVar.f41229c;
                    break;
                case 17:
                    i12 = n(x0.a().d(eVar.b().getClass()), bArr, i12, i13, (i14 << 3) | 4, bVar);
                    objValueOf = bVar.f41229c;
                    break;
                case 18:
                    i12 = p(x0.a().d(eVar.b().getClass()), bArr, i12, i13, bVar);
                    objValueOf = bVar.f41229c;
                    break;
            }
        } else {
            i12 = I(bArr, i12, bVar);
            if (eVar.f41183b.b().a(bVar.f41227a) == null) {
                i1 i1VarJ = cVar.unknownFields;
                if (i1VarJ == i1.c()) {
                    i1VarJ = i1.j();
                    cVar.unknownFields = i1VarJ;
                }
                d1.L(i14, bVar.f41227a, i1VarJ, h1Var);
                return i12;
            }
            objValueOf = Integer.valueOf(bVar.f41227a);
        }
        if (eVar.d()) {
            uVar.a(eVar.f41183b, objValueOf);
        } else {
            int i15 = a.f41226a[eVar.a().ordinal()];
            if ((i15 == 17 || i15 == 18) && (objI = uVar.i(eVar.f41183b)) != null) {
                objValueOf = y.h(objI, objValueOf);
            }
            uVar.x(eVar.f41183b, objValueOf);
        }
        return i12;
    }

    public static int g(int i11, byte[] bArr, int i12, int i13, Object obj, n0 n0Var, h1<i1, i1> h1Var, b bVar) throws IOException {
        GeneratedMessageLite.e eVarA = bVar.f41230d.a(n0Var, i11 >>> 3);
        if (eVarA == null) {
            return G(i11, bArr, i12, i13, q0.w(obj), bVar);
        }
        GeneratedMessageLite.c cVar = (GeneratedMessageLite.c) obj;
        cVar.Q();
        return f(i11, bArr, i12, i13, cVar, eVarA, h1Var, bVar);
    }

    public static int h(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int i(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        x xVar = (x) jVar;
        xVar.n(h(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            xVar.n(h(bArr, I));
            i14 = I + 4;
        }
        return i14;
    }

    public static long j(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    public static int k(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        f0 f0Var = (f0) jVar;
        f0Var.g(j(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            f0Var.g(j(bArr, I));
            i14 = I + 8;
        }
        return i14;
    }

    public static float l(byte[] bArr, int i11) {
        return Float.intBitsToFloat(h(bArr, i11));
    }

    public static int m(int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) {
        v vVar = (v) jVar;
        vVar.f(l(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            vVar.f(l(bArr, I));
            i14 = I + 4;
        }
        return i14;
    }

    public static int n(b1 b1Var, byte[] bArr, int i11, int i12, int i13, b bVar) throws IOException {
        q0 q0Var = (q0) b1Var;
        Object objF = q0Var.f();
        int iD0 = q0Var.d0(objF, bArr, i11, i12, i13, bVar);
        q0Var.c(objF);
        bVar.f41229c = objF;
        return iD0;
    }

    public static int o(b1 b1Var, int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) throws IOException {
        int i14 = (i11 & (-8)) | 4;
        int iN = n(b1Var, bArr, i12, i13, i14, bVar);
        jVar.add(bVar.f41229c);
        while (iN < i13) {
            int I = I(bArr, iN, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            iN = n(b1Var, bArr, I, i13, i14, bVar);
            jVar.add(bVar.f41229c);
        }
        return iN;
    }

    public static int p(b1 b1Var, byte[] bArr, int i11, int i12, b bVar) throws IOException {
        int iH = i11 + 1;
        int i13 = bArr[i11];
        if (i13 < 0) {
            iH = H(i13, bArr, iH, bVar);
            i13 = bVar.f41227a;
        }
        int i14 = iH;
        if (i13 < 0 || i13 > i12 - i14) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        Object objF = b1Var.f();
        int i15 = i13 + i14;
        b1Var.i(objF, bArr, i14, i15, bVar);
        b1Var.c(objF);
        bVar.f41229c = objF;
        return i15;
    }

    public static int q(b1<?> b1Var, int i11, byte[] bArr, int i12, int i13, y.j<?> jVar, b bVar) throws IOException {
        int iP = p(b1Var, bArr, i12, i13, bVar);
        jVar.add(bVar.f41229c);
        while (iP < i13) {
            int I = I(bArr, iP, bVar);
            if (i11 != bVar.f41227a) {
                break;
            }
            iP = p(b1Var, bArr, I, i13, bVar);
            jVar.add(bVar.f41229c);
        }
        return iP;
    }

    public static int r(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        g gVar = (g) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            I = L(bArr, I, bVar);
            gVar.g(bVar.f41228b != 0);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int s(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        m mVar = (m) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            mVar.f(d(bArr, I));
            I += 8;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int t(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        x xVar = (x) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            xVar.n(h(bArr, I));
            I += 4;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int u(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        f0 f0Var = (f0) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            f0Var.g(j(bArr, I));
            I += 8;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int v(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        v vVar = (v) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            vVar.f(l(bArr, I));
            I += 4;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int w(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        x xVar = (x) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            I = I(bArr, I, bVar);
            xVar.n(j.b(bVar.f41227a));
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int x(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        f0 f0Var = (f0) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            I = L(bArr, I, bVar);
            f0Var.g(j.c(bVar.f41228b));
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int y(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        x xVar = (x) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            I = I(bArr, I, bVar);
            xVar.n(bVar.f41227a);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int z(byte[] bArr, int i11, y.j<?> jVar, b bVar) throws IOException {
        f0 f0Var = (f0) jVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f41227a + I;
        while (I < i12) {
            I = L(bArr, I, bVar);
            f0Var.g(bVar.f41228b);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
