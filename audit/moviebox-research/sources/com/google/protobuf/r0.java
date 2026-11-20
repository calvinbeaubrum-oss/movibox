package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r0<T> implements b1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f41411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h1<?, ?> f41412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f41413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q<?> f41414d;

    public r0(h1<?, ?> h1Var, q<?> qVar, n0 n0Var) {
        this.f41412b = h1Var;
        this.f41413c = qVar.e(n0Var);
        this.f41414d = qVar;
        this.f41411a = n0Var;
    }

    private <UT, UB> int k(h1<UT, UB> h1Var, T t11) {
        return h1Var.i(h1Var.g(t11));
    }

    private <UT, UB, ET extends u.b<ET>> void l(h1<UT, UB> h1Var, q<ET> qVar, T t11, a1 a1Var, p pVar) throws IOException {
        UB ubF = h1Var.f(t11);
        u<ET> uVarD = qVar.d(t11);
        while (a1Var.F() != Integer.MAX_VALUE) {
            try {
                if (!n(a1Var, pVar, qVar, uVarD, h1Var, ubF)) {
                    return;
                }
            } finally {
                h1Var.o(t11, ubF);
            }
        }
    }

    public static <T> r0<T> m(h1<?, ?> h1Var, q<?> qVar, n0 n0Var) {
        return new r0<>(h1Var, qVar, n0Var);
    }

    @Override // com.google.protobuf.b1
    public void a(T t11, T t12) {
        d1.G(this.f41412b, t11, t12);
        if (this.f41413c) {
            d1.E(this.f41414d, t11, t12);
        }
    }

    @Override // com.google.protobuf.b1
    public void b(T t11, Writer writer) throws IOException {
        Iterator itS = this.f41414d.c(t11).s();
        while (itS.hasNext()) {
            Map.Entry entry = (Map.Entry) itS.next();
            u.b bVar = (u.b) entry.getKey();
            if (bVar.Q() != WireFormat.JavaType.MESSAGE || bVar.N() || bVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof a0.b) {
                writer.c(bVar.getNumber(), ((a0.b) entry).a().e());
            } else {
                writer.c(bVar.getNumber(), entry.getValue());
            }
        }
        o(this.f41412b, t11, writer);
    }

    @Override // com.google.protobuf.b1
    public void c(T t11) {
        this.f41412b.j(t11);
        this.f41414d.f(t11);
    }

    @Override // com.google.protobuf.b1
    public final boolean d(T t11) {
        return this.f41414d.c(t11).p();
    }

    @Override // com.google.protobuf.b1
    public int e(T t11) {
        int iK = k(this.f41412b, t11);
        return this.f41413c ? iK + this.f41414d.c(t11).j() : iK;
    }

    @Override // com.google.protobuf.b1
    public T f() {
        return (T) this.f41411a.j().u();
    }

    @Override // com.google.protobuf.b1
    public int g(T t11) {
        int iHashCode = this.f41412b.g(t11).hashCode();
        return this.f41413c ? (iHashCode * 53) + this.f41414d.c(t11).hashCode() : iHashCode;
    }

    @Override // com.google.protobuf.b1
    public void h(T t11, a1 a1Var, p pVar) throws IOException {
        l(this.f41412b, this.f41414d, t11, a1Var, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cb A[EDGE_INSN: B:58:0x00cb->B:34:0x00cb BREAK  A[LOOP:1: B:18:0x006d->B:61:0x006d], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.b1
    public void i(T t11, byte[] bArr, int i11, int i12, e.b bVar) throws IOException {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t11;
        i1 i1VarJ = generatedMessageLite.unknownFields;
        if (i1VarJ == i1.c()) {
            i1VarJ = i1.j();
            generatedMessageLite.unknownFields = i1VarJ;
        }
        u<GeneratedMessageLite.d> uVarQ = ((GeneratedMessageLite.c) t11).Q();
        GeneratedMessageLite.e eVar = null;
        while (i11 < i12) {
            int I = e.I(bArr, i11, bVar);
            int i13 = bVar.f41227a;
            if (i13 == WireFormat.f41202a) {
                int i14 = 0;
                ByteString byteString = null;
                while (I < i12) {
                    I = e.I(bArr, I, bVar);
                    int i15 = bVar.f41227a;
                    int iA = WireFormat.a(i15);
                    int iB = WireFormat.b(i15);
                    if (iA != 2) {
                        if (iA == 3) {
                            if (eVar != null) {
                                I = e.p(x0.a().d(eVar.b().getClass()), bArr, I, i12, bVar);
                                uVarQ.x(eVar.f41183b, bVar.f41229c);
                            } else if (iB == 2) {
                                I = e.b(bArr, I, bVar);
                                byteString = (ByteString) bVar.f41229c;
                            }
                        }
                        if (i15 == WireFormat.f41203b) {
                            break;
                        } else {
                            I = e.N(i15, bArr, I, i12, bVar);
                        }
                    } else if (iB == 0) {
                        I = e.I(bArr, I, bVar);
                        i14 = bVar.f41227a;
                        eVar = (GeneratedMessageLite.e) this.f41414d.b(bVar.f41230d, this.f41411a, i14);
                    } else {
                        if (i15 == WireFormat.f41203b) {
                            break;
                            break;
                        }
                        I = e.N(i15, bArr, I, i12, bVar);
                    }
                }
                if (byteString != null) {
                    i1VarJ.m(WireFormat.c(i14, 2), byteString);
                }
                i11 = I;
            } else if (WireFormat.b(i13) == 2) {
                GeneratedMessageLite.e eVar2 = (GeneratedMessageLite.e) this.f41414d.b(bVar.f41230d, this.f41411a, WireFormat.a(i13));
                if (eVar2 != null) {
                    i11 = e.p(x0.a().d(eVar2.b().getClass()), bArr, I, i12, bVar);
                    uVarQ.x(eVar2.f41183b, bVar.f41229c);
                } else {
                    i11 = e.G(i13, bArr, I, i12, i1VarJ, bVar);
                }
                eVar = eVar2;
            } else {
                i11 = e.N(i13, bArr, I, i12, bVar);
            }
        }
        if (i11 != i12) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // com.google.protobuf.b1
    public boolean j(T t11, T t12) {
        if (!this.f41412b.g(t11).equals(this.f41412b.g(t12))) {
            return false;
        }
        if (this.f41413c) {
            return this.f41414d.c(t11).equals(this.f41414d.c(t12));
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <UT, UB, ET extends u.b<ET>> boolean n(a1 a1Var, p pVar, q<ET> qVar, u<ET> uVar, h1<UT, UB> h1Var, UB ub2) throws IOException {
        int tag = a1Var.getTag();
        if (tag != WireFormat.f41202a) {
            if (WireFormat.b(tag) != 2) {
                return a1Var.J();
            }
            Object objB = qVar.b(pVar, this.f41411a, WireFormat.a(tag));
            if (objB == null) {
                return h1Var.m(ub2, a1Var);
            }
            qVar.h(a1Var, objB, pVar, uVar);
            return true;
        }
        Object objB2 = null;
        ByteString byteStringR = null;
        int i11 = 0;
        while (a1Var.F() != Integer.MAX_VALUE) {
            int tag2 = a1Var.getTag();
            if (tag2 == WireFormat.f41204c) {
                i11 = a1Var.i();
                objB2 = qVar.b(pVar, this.f41411a, i11);
            } else if (tag2 == WireFormat.f41205d) {
                if (objB2 != null) {
                    qVar.h(a1Var, objB2, pVar, uVar);
                } else {
                    byteStringR = a1Var.r();
                }
            } else if (!a1Var.J()) {
                break;
            }
        }
        if (a1Var.getTag() != WireFormat.f41203b) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        if (byteStringR != null) {
            if (objB2 != null) {
                qVar.i(byteStringR, objB2, pVar, uVar);
            } else {
                h1Var.d(ub2, i11, byteStringR);
            }
        }
        return true;
    }

    public final <UT, UB> void o(h1<UT, UB> h1Var, T t11, Writer writer) throws IOException {
        h1Var.s(h1Var.g(t11), writer);
    }
}
