package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r extends q<GeneratedMessageLite.d> {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41410a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41410a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41410a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41410a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41410a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41410a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41410a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41410a[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41410a[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41410a[WireFormat.FieldType.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41410a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41410a[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41410a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41410a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41410a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41410a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41410a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41410a[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f41410a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.google.protobuf.q
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).getNumber();
    }

    @Override // com.google.protobuf.q
    public Object b(p pVar, n0 n0Var, int i11) {
        return pVar.a(n0Var, i11);
    }

    @Override // com.google.protobuf.q
    public u<GeneratedMessageLite.d> c(Object obj) {
        return ((GeneratedMessageLite.c) obj).extensions;
    }

    @Override // com.google.protobuf.q
    public u<GeneratedMessageLite.d> d(Object obj) {
        return ((GeneratedMessageLite.c) obj).Q();
    }

    @Override // com.google.protobuf.q
    public boolean e(n0 n0Var) {
        return n0Var instanceof GeneratedMessageLite.c;
    }

    @Override // com.google.protobuf.q
    public void f(Object obj) {
        c(obj).t();
    }

    @Override // com.google.protobuf.q
    public <UT, UB> UB g(a1 a1Var, Object obj, p pVar, u<GeneratedMessageLite.d> uVar, UB ub2, h1<UT, UB> h1Var) throws IOException {
        Object objValueOf;
        Object objI;
        ArrayList arrayList;
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        int iC = eVar.c();
        if (eVar.f41183b.N() && eVar.f41183b.isPacked()) {
            switch (a.f41410a[eVar.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    a1Var.M(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    a1Var.I(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    a1Var.j(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    a1Var.h(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    a1Var.B(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    a1Var.t(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    a1Var.C(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    a1Var.n(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    a1Var.w(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    a1Var.b(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    a1Var.A(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    a1Var.u(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    a1Var.c(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    a1Var.k(arrayList);
                    ub2 = (UB) d1.z(iC, arrayList, eVar.f41183b.b(), ub2, h1Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f41183b.O());
            }
            uVar.x(eVar.f41183b, arrayList);
        } else {
            if (eVar.a() != WireFormat.FieldType.ENUM) {
                switch (a.f41410a[eVar.a().ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(a1Var.readDouble());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(a1Var.readFloat());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(a1Var.N());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(a1Var.v());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(a1Var.s());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(a1Var.a());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(a1Var.y());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(a1Var.e());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(a1Var.i());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(a1Var.K());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(a1Var.g());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(a1Var.m());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(a1Var.D());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = a1Var.r();
                        break;
                    case 16:
                        objValueOf = a1Var.E();
                        break;
                    case 17:
                        objValueOf = a1Var.o(eVar.b().getClass(), pVar);
                        break;
                    case 18:
                        objValueOf = a1Var.x(eVar.b().getClass(), pVar);
                        break;
                    default:
                        objValueOf = null;
                        break;
                }
            } else {
                int iS = a1Var.s();
                if (eVar.f41183b.b().a(iS) == null) {
                    return (UB) d1.L(iC, iS, ub2, h1Var);
                }
                objValueOf = Integer.valueOf(iS);
            }
            if (eVar.d()) {
                uVar.a(eVar.f41183b, objValueOf);
            } else {
                int i11 = a.f41410a[eVar.a().ordinal()];
                if ((i11 == 17 || i11 == 18) && (objI = uVar.i(eVar.f41183b)) != null) {
                    objValueOf = y.h(objI, objValueOf);
                }
                uVar.x(eVar.f41183b, objValueOf);
            }
        }
        return ub2;
    }

    @Override // com.google.protobuf.q
    public void h(a1 a1Var, Object obj, p pVar, u<GeneratedMessageLite.d> uVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        uVar.x(eVar.f41183b, a1Var.x(eVar.b().getClass(), pVar));
    }

    @Override // com.google.protobuf.q
    public void i(ByteString byteString, Object obj, p pVar, u<GeneratedMessageLite.d> uVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        n0 n0VarU = eVar.b().j().u();
        f fVarP = f.P(ByteBuffer.wrap(byteString.toByteArray()), true);
        x0.a().b(n0VarU, fVarP, pVar);
        uVar.x(eVar.f41183b, n0VarU);
        if (fVarP.F() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    @Override // com.google.protobuf.q
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (!dVar.N()) {
            switch (a.f41410a[dVar.O().ordinal()]) {
                case 1:
                    writer.t(dVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    writer.H(dVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    writer.z(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    writer.g(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    writer.k(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    writer.x(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    writer.d(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    writer.A(dVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    writer.s(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    writer.B(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    writer.l(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    writer.N(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    writer.p(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    writer.k(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    writer.j(dVar.getNumber(), (ByteString) entry.getValue());
                    break;
                case 16:
                    writer.f(dVar.getNumber(), (String) entry.getValue());
                    break;
                case 17:
                    writer.i(dVar.getNumber(), entry.getValue(), x0.a().d(entry.getValue().getClass()));
                    break;
                case 18:
                    writer.w(dVar.getNumber(), entry.getValue(), x0.a().d(entry.getValue().getClass()));
                    break;
            }
        }
        switch (a.f41410a[dVar.O().ordinal()]) {
            case 1:
                d1.P(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 2:
                d1.T(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 3:
                d1.W(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 4:
                d1.e0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 5:
                d1.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 6:
                d1.S(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 7:
                d1.R(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 8:
                d1.N(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 9:
                d1.d0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 10:
                d1.Y(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 11:
                d1.Z(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 12:
                d1.a0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 13:
                d1.b0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 14:
                d1.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 15:
                d1.O(dVar.getNumber(), (List) entry.getValue(), writer);
                break;
            case 16:
                d1.c0(dVar.getNumber(), (List) entry.getValue(), writer);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    d1.U(dVar.getNumber(), (List) entry.getValue(), writer, x0.a().d(list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    d1.X(dVar.getNumber(), (List) entry.getValue(), writer, x0.a().d(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
