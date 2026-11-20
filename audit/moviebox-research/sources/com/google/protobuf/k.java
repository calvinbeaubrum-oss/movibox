package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f41341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41344d = 0;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41345a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41345a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41345a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41345a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41345a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41345a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41345a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41345a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41345a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41345a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41345a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41345a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41345a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41345a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41345a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41345a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41345a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41345a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public k(j jVar) {
        j jVar2 = (j) y.b(jVar, "input");
        this.f41341a = jVar2;
        jVar2.f41297d = this;
    }

    public static k P(j jVar) {
        k kVar = jVar.f41297d;
        return kVar != null ? kVar : new k(jVar);
    }

    private Object Q(WireFormat.FieldType fieldType, Class<?> cls, p pVar) throws IOException {
        switch (a.f41345a[fieldType.ordinal()]) {
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

    private <T> T R(b1<T> b1Var, p pVar) throws IOException {
        int i11 = this.f41343c;
        this.f41343c = WireFormat.c(WireFormat.a(this.f41342b), 4);
        try {
            T tF = b1Var.f();
            b1Var.h(tF, this, pVar);
            b1Var.c(tF);
            if (this.f41342b != this.f41343c) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.f41343c = i11;
            return tF;
        } catch (Throwable th2) {
            this.f41343c = i11;
            throw th2;
        }
    }

    private <T> T S(b1<T> b1Var, p pVar) throws IOException {
        int iE = this.f41341a.E();
        j jVar = this.f41341a;
        if (jVar.f41294a >= jVar.f41295b) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int iN = jVar.n(iE);
        T tF = b1Var.f();
        this.f41341a.f41294a++;
        b1Var.h(tF, this, pVar);
        b1Var.c(tF);
        this.f41341a.a(0);
        j jVar2 = this.f41341a;
        jVar2.f41294a--;
        jVar2.m(iN);
        return tF;
    }

    private void U(int i11) throws IOException {
        if (this.f41341a.d() != i11) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void V(int i11) throws IOException {
        if (WireFormat.b(this.f41342b) != i11) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void W(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void X(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // com.google.protobuf.a1
    public void A(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof f0)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f41341a.y()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iE = this.f41341a.E();
            X(iE);
            int iD3 = this.f41341a.d() + iE;
            do {
                list.add(Long.valueOf(this.f41341a.y()));
            } while (this.f41341a.d() < iD3);
            return;
        }
        f0 f0Var = (f0) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 1) {
            do {
                f0Var.g(this.f41341a.y());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iE2 = this.f41341a.E();
        X(iE2);
        int iD4 = this.f41341a.d() + iE2;
        do {
            f0Var.g(this.f41341a.y());
        } while (this.f41341a.d() < iD4);
    }

    @Override // com.google.protobuf.a1
    public void B(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof x)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f41341a.v()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Integer.valueOf(this.f41341a.v()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        x xVar = (x) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                xVar.n(this.f41341a.v());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            xVar.n(this.f41341a.v());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public void C(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof x)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 2) {
                int iE = this.f41341a.E();
                W(iE);
                int iD3 = this.f41341a.d() + iE;
                do {
                    list.add(Integer.valueOf(this.f41341a.s()));
                } while (this.f41341a.d() < iD3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f41341a.s()));
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD = this.f41341a.D();
                }
            } while (iD == this.f41342b);
            this.f41344d = iD;
            return;
        }
        x xVar = (x) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 2) {
            int iE2 = this.f41341a.E();
            W(iE2);
            int iD4 = this.f41341a.d() + iE2;
            do {
                xVar.n(this.f41341a.s());
            } while (this.f41341a.d() < iD4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            xVar.n(this.f41341a.s());
            if (this.f41341a.e()) {
                return;
            } else {
                iD2 = this.f41341a.D();
            }
        } while (iD2 == this.f41342b);
        this.f41344d = iD2;
    }

    @Override // com.google.protobuf.a1
    public long D() throws IOException {
        V(0);
        return this.f41341a.A();
    }

    @Override // com.google.protobuf.a1
    public String E() throws IOException {
        V(2);
        return this.f41341a.B();
    }

    @Override // com.google.protobuf.a1
    public int F() throws IOException {
        int i11 = this.f41344d;
        if (i11 != 0) {
            this.f41342b = i11;
            this.f41344d = 0;
        } else {
            this.f41342b = this.f41341a.D();
        }
        int i12 = this.f41342b;
        return (i12 == 0 || i12 == this.f41343c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : WireFormat.a(i12);
    }

    @Override // com.google.protobuf.a1
    public void G(List<String> list) throws IOException {
        T(list, false);
    }

    @Override // com.google.protobuf.a1
    public <T> T H(b1<T> b1Var, p pVar) throws IOException {
        V(2);
        return (T) S(b1Var, pVar);
    }

    @Override // com.google.protobuf.a1
    public void I(List<Float> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof v)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 2) {
                int iE = this.f41341a.E();
                W(iE);
                int iD3 = this.f41341a.d() + iE;
                do {
                    list.add(Float.valueOf(this.f41341a.u()));
                } while (this.f41341a.d() < iD3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.f41341a.u()));
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD = this.f41341a.D();
                }
            } while (iD == this.f41342b);
            this.f41344d = iD;
            return;
        }
        v vVar = (v) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 2) {
            int iE2 = this.f41341a.E();
            W(iE2);
            int iD4 = this.f41341a.d() + iE2;
            do {
                vVar.f(this.f41341a.u());
            } while (this.f41341a.d() < iD4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            vVar.f(this.f41341a.u());
            if (this.f41341a.e()) {
                return;
            } else {
                iD2 = this.f41341a.D();
            }
        } while (iD2 == this.f41342b);
        this.f41344d = iD2;
    }

    @Override // com.google.protobuf.a1
    public boolean J() throws IOException {
        int i11;
        if (this.f41341a.e() || (i11 = this.f41342b) == this.f41343c) {
            return false;
        }
        return this.f41341a.G(i11);
    }

    @Override // com.google.protobuf.a1
    public int K() throws IOException {
        V(5);
        return this.f41341a.x();
    }

    @Override // com.google.protobuf.a1
    public void L(List<ByteString> list) throws IOException {
        int iD;
        if (WireFormat.b(this.f41342b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(r());
            if (this.f41341a.e()) {
                return;
            } else {
                iD = this.f41341a.D();
            }
        } while (iD == this.f41342b);
        this.f41344d = iD;
    }

    @Override // com.google.protobuf.a1
    public void M(List<Double> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof m)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.f41341a.q()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iE = this.f41341a.E();
            X(iE);
            int iD3 = this.f41341a.d() + iE;
            do {
                list.add(Double.valueOf(this.f41341a.q()));
            } while (this.f41341a.d() < iD3);
            return;
        }
        m mVar = (m) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 1) {
            do {
                mVar.f(this.f41341a.q());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iE2 = this.f41341a.E();
        X(iE2);
        int iD4 = this.f41341a.d() + iE2;
        do {
            mVar.f(this.f41341a.q());
        } while (this.f41341a.d() < iD4);
    }

    @Override // com.google.protobuf.a1
    public long N() throws IOException {
        V(0);
        return this.f41341a.w();
    }

    @Override // com.google.protobuf.a1
    public String O() throws IOException {
        V(2);
        return this.f41341a.C();
    }

    public void T(List<String> list, boolean z11) throws IOException {
        int iD;
        int iD2;
        if (WireFormat.b(this.f41342b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (!(list instanceof d0) || z11) {
            do {
                list.add(z11 ? O() : E());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD = this.f41341a.D();
                }
            } while (iD == this.f41342b);
            this.f41344d = iD;
            return;
        }
        d0 d0Var = (d0) list;
        do {
            d0Var.d(r());
            if (this.f41341a.e()) {
                return;
            } else {
                iD2 = this.f41341a.D();
            }
        } while (iD2 == this.f41342b);
        this.f41344d = iD2;
    }

    @Override // com.google.protobuf.a1
    public long a() throws IOException {
        V(1);
        return this.f41341a.t();
    }

    @Override // com.google.protobuf.a1
    public void b(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof x)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 2) {
                int iE = this.f41341a.E();
                W(iE);
                int iD3 = this.f41341a.d() + iE;
                do {
                    list.add(Integer.valueOf(this.f41341a.x()));
                } while (this.f41341a.d() < iD3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f41341a.x()));
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD = this.f41341a.D();
                }
            } while (iD == this.f41342b);
            this.f41344d = iD;
            return;
        }
        x xVar = (x) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 2) {
            int iE2 = this.f41341a.E();
            W(iE2);
            int iD4 = this.f41341a.d() + iE2;
            do {
                xVar.n(this.f41341a.x());
            } while (this.f41341a.d() < iD4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            xVar.n(this.f41341a.x());
            if (this.f41341a.e()) {
                return;
            } else {
                iD2 = this.f41341a.D();
            }
        } while (iD2 == this.f41342b);
        this.f41344d = iD2;
    }

    @Override // com.google.protobuf.a1
    public void c(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof f0)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f41341a.A()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Long.valueOf(this.f41341a.A()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        f0 f0Var = (f0) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                f0Var.g(this.f41341a.A());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            f0Var.g(this.f41341a.A());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.a1
    public <T> void d(List<T> list, b1<T> b1Var, p pVar) throws IOException {
        int iD;
        if (WireFormat.b(this.f41342b) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i11 = this.f41342b;
        do {
            list.add(R(b1Var, pVar));
            if (this.f41341a.e() || this.f41344d != 0) {
                return;
            } else {
                iD = this.f41341a.D();
            }
        } while (iD == i11);
        this.f41344d = iD;
    }

    @Override // com.google.protobuf.a1
    public boolean e() throws IOException {
        V(0);
        return this.f41341a.o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.a1
    public <T> void f(List<T> list, b1<T> b1Var, p pVar) throws IOException {
        int iD;
        if (WireFormat.b(this.f41342b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i11 = this.f41342b;
        do {
            list.add(S(b1Var, pVar));
            if (this.f41341a.e() || this.f41344d != 0) {
                return;
            } else {
                iD = this.f41341a.D();
            }
        } while (iD == i11);
        this.f41344d = iD;
    }

    @Override // com.google.protobuf.a1
    public long g() throws IOException {
        V(1);
        return this.f41341a.y();
    }

    @Override // com.google.protobuf.a1
    public int getTag() {
        return this.f41342b;
    }

    @Override // com.google.protobuf.a1
    public void h(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof f0)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f41341a.F()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Long.valueOf(this.f41341a.F()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        f0 f0Var = (f0) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                f0Var.g(this.f41341a.F());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            f0Var.g(this.f41341a.F());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public int i() throws IOException {
        V(0);
        return this.f41341a.E();
    }

    @Override // com.google.protobuf.a1
    public void j(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof f0)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f41341a.w()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Long.valueOf(this.f41341a.w()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        f0 f0Var = (f0) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                f0Var.g(this.f41341a.w());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            f0Var.g(this.f41341a.w());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public void k(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof x)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f41341a.r()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Integer.valueOf(this.f41341a.r()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        x xVar = (x) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                xVar.n(this.f41341a.r());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            xVar.n(this.f41341a.r());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public int l() throws IOException {
        V(0);
        return this.f41341a.r();
    }

    @Override // com.google.protobuf.a1
    public int m() throws IOException {
        V(0);
        return this.f41341a.z();
    }

    @Override // com.google.protobuf.a1
    public void n(List<Boolean> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof g)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.f41341a.o()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Boolean.valueOf(this.f41341a.o()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        g gVar = (g) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                gVar.g(this.f41341a.o());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            gVar.g(this.f41341a.o());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public <T> T o(Class<T> cls, p pVar) throws IOException {
        V(3);
        return (T) R(x0.a().d(cls), pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.a1
    public <K, V> void p(Map<K, V> map, h0.a<K, V> aVar, p pVar) throws IOException {
        V(2);
        int iN = this.f41341a.n(this.f41341a.E());
        Object objQ = aVar.f41285b;
        Object objQ2 = aVar.f41287d;
        while (true) {
            try {
                int iF = F();
                if (iF == Integer.MAX_VALUE || this.f41341a.e()) {
                    break;
                }
                if (iF == 1) {
                    objQ = Q(aVar.f41284a, null, null);
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
                    objQ2 = Q(aVar.f41286c, aVar.f41287d.getClass(), pVar);
                }
            } catch (Throwable th2) {
                this.f41341a.m(iN);
                throw th2;
            }
        }
        map.put(objQ, objQ2);
        this.f41341a.m(iN);
    }

    @Override // com.google.protobuf.a1
    public void q(List<String> list) throws IOException {
        T(list, true);
    }

    @Override // com.google.protobuf.a1
    public ByteString r() throws IOException {
        V(2);
        return this.f41341a.p();
    }

    @Override // com.google.protobuf.a1
    public double readDouble() throws IOException {
        V(1);
        return this.f41341a.q();
    }

    @Override // com.google.protobuf.a1
    public float readFloat() throws IOException {
        V(5);
        return this.f41341a.u();
    }

    @Override // com.google.protobuf.a1
    public int s() throws IOException {
        V(0);
        return this.f41341a.v();
    }

    @Override // com.google.protobuf.a1
    public void t(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof f0)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f41341a.t()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iE = this.f41341a.E();
            X(iE);
            int iD3 = this.f41341a.d() + iE;
            do {
                list.add(Long.valueOf(this.f41341a.t()));
            } while (this.f41341a.d() < iD3);
            return;
        }
        f0 f0Var = (f0) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 1) {
            do {
                f0Var.g(this.f41341a.t());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iE2 = this.f41341a.E();
        X(iE2);
        int iD4 = this.f41341a.d() + iE2;
        do {
            f0Var.g(this.f41341a.t());
        } while (this.f41341a.d() < iD4);
    }

    @Override // com.google.protobuf.a1
    public void u(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof x)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f41341a.z()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Integer.valueOf(this.f41341a.z()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        x xVar = (x) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                xVar.n(this.f41341a.z());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            xVar.n(this.f41341a.z());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public long v() throws IOException {
        V(0);
        return this.f41341a.F();
    }

    @Override // com.google.protobuf.a1
    public void w(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof x)) {
            int iB = WireFormat.b(this.f41342b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f41341a.E()));
                    if (this.f41341a.e()) {
                        return;
                    } else {
                        iD = this.f41341a.D();
                    }
                } while (iD == this.f41342b);
                this.f41344d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int iD3 = this.f41341a.d() + this.f41341a.E();
            do {
                list.add(Integer.valueOf(this.f41341a.E()));
            } while (this.f41341a.d() < iD3);
            U(iD3);
            return;
        }
        x xVar = (x) list;
        int iB2 = WireFormat.b(this.f41342b);
        if (iB2 == 0) {
            do {
                xVar.n(this.f41341a.E());
                if (this.f41341a.e()) {
                    return;
                } else {
                    iD2 = this.f41341a.D();
                }
            } while (iD2 == this.f41342b);
            this.f41344d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int iD4 = this.f41341a.d() + this.f41341a.E();
        do {
            xVar.n(this.f41341a.E());
        } while (this.f41341a.d() < iD4);
        U(iD4);
    }

    @Override // com.google.protobuf.a1
    public <T> T x(Class<T> cls, p pVar) throws IOException {
        V(2);
        return (T) S(x0.a().d(cls), pVar);
    }

    @Override // com.google.protobuf.a1
    public int y() throws IOException {
        V(5);
        return this.f41341a.s();
    }

    @Override // com.google.protobuf.a1
    public <T> T z(b1<T> b1Var, p pVar) throws IOException {
        V(3);
        return (T) R(b1Var, pVar);
    }
}
