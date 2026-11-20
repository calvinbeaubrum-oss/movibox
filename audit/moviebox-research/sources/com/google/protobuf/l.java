package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CodedOutputStream f41354a;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41355a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41355a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41355a[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41355a[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41355a[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41355a[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41355a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41355a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41355a[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41355a[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41355a[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41355a[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41355a[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public l(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) y.b(codedOutputStream, "output");
        this.f41354a = codedOutputStream2;
        codedOutputStream2.f41156a = this;
    }

    public static l P(CodedOutputStream codedOutputStream) {
        l lVar = codedOutputStream.f41156a;
        return lVar != null ? lVar : new l(codedOutputStream);
    }

    @Override // com.google.protobuf.Writer
    public void A(int i11, boolean z11) throws IOException {
        this.f41354a.i0(i11, z11);
    }

    @Override // com.google.protobuf.Writer
    public void B(int i11, int i12) throws IOException {
        this.f41354a.K0(i11, i12);
    }

    @Override // com.google.protobuf.Writer
    public void C(int i11) throws IOException {
        this.f41354a.U0(i11, 3);
    }

    @Override // com.google.protobuf.Writer
    public void D(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.u0(i11, list.get(i12).longValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iQ = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iQ += CodedOutputStream.q(list.get(i13).longValue());
        }
        this.f41354a.W0(iQ);
        while (i12 < list.size()) {
            this.f41354a.v0(list.get(i12).longValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void E(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.K0(i11, list.get(i12).intValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iM = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iM += CodedOutputStream.M(list.get(i13).intValue());
        }
        this.f41354a.W0(iM);
        while (i12 < list.size()) {
            this.f41354a.L0(list.get(i12).intValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void F(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.i0(i11, list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iF = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iF += CodedOutputStream.f(list.get(i13).booleanValue());
        }
        this.f41354a.W0(iF);
        while (i12 < list.size()) {
            this.f41354a.j0(list.get(i12).booleanValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void G(int i11, h0.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.f41354a.d0()) {
            T(i11, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f41354a.U0(i11, 2);
            this.f41354a.W0(h0.b(aVar, entry.getKey(), entry.getValue()));
            h0.e(this.f41354a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void H(int i11, float f11) throws IOException {
        this.f41354a.w0(i11, f11);
    }

    @Override // com.google.protobuf.Writer
    public void I(int i11) throws IOException {
        this.f41354a.U0(i11, 4);
    }

    @Override // com.google.protobuf.Writer
    public void J(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.O0(i11, list.get(i12).intValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iQ = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iQ += CodedOutputStream.Q(list.get(i13).intValue());
        }
        this.f41354a.W0(iQ);
        while (i12 < list.size()) {
            this.f41354a.P0(list.get(i12).intValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void K(int i11, int i12) throws IOException {
        this.f41354a.q0(i11, i12);
    }

    @Override // com.google.protobuf.Writer
    public void L(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.E0(i11, list.get(i12).longValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iZ = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZ += CodedOutputStream.z(list.get(i13).longValue());
        }
        this.f41354a.W0(iZ);
        while (i12 < list.size()) {
            this.f41354a.F0(list.get(i12).longValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void M(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.o0(i11, list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iK = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iK += CodedOutputStream.k(list.get(i13).doubleValue());
        }
        this.f41354a.W0(iK);
        while (i12 < list.size()) {
            this.f41354a.p0(list.get(i12).doubleValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void N(int i11, int i12) throws IOException {
        this.f41354a.O0(i11, i12);
    }

    @Override // com.google.protobuf.Writer
    public void O(int i11, List<ByteString> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f41354a.m0(i11, list.get(i12));
        }
    }

    public final <V> void Q(int i11, boolean z11, V v11, h0.a<Boolean, V> aVar) throws IOException {
        this.f41354a.U0(i11, 2);
        this.f41354a.W0(h0.b(aVar, Boolean.valueOf(z11), v11));
        h0.e(this.f41354a, aVar, Boolean.valueOf(z11), v11);
    }

    public final <V> void R(int i11, h0.a<Integer, V> aVar, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            iArr[i12] = it.next().intValue();
            i12++;
        }
        Arrays.sort(iArr);
        for (int i13 = 0; i13 < size; i13++) {
            int i14 = iArr[i13];
            V v11 = map.get(Integer.valueOf(i14));
            this.f41354a.U0(i11, 2);
            this.f41354a.W0(h0.b(aVar, Integer.valueOf(i14), v11));
            h0.e(this.f41354a, aVar, Integer.valueOf(i14), v11);
        }
    }

    public final <V> void S(int i11, h0.a<Long, V> aVar, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            jArr[i12] = it.next().longValue();
            i12++;
        }
        Arrays.sort(jArr);
        for (int i13 = 0; i13 < size; i13++) {
            long j11 = jArr[i13];
            V v11 = map.get(Long.valueOf(j11));
            this.f41354a.U0(i11, 2);
            this.f41354a.W0(h0.b(aVar, Long.valueOf(j11), v11));
            h0.e(this.f41354a, aVar, Long.valueOf(j11), v11);
        }
    }

    public final <K, V> void T(int i11, h0.a<K, V> aVar, Map<K, V> map) throws IOException {
        switch (a.f41355a[aVar.f41284a.ordinal()]) {
            case 1:
                V v11 = map.get(Boolean.FALSE);
                if (v11 != null) {
                    Q(i11, false, v11, aVar);
                }
                V v12 = map.get(Boolean.TRUE);
                if (v12 != null) {
                    Q(i11, true, v12, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i11, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i11, aVar, map);
                return;
            case 12:
                U(i11, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f41284a);
        }
    }

    public final <V> void U(int i11, h0.a<String, V> aVar, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            strArr[i12] = it.next();
            i12++;
        }
        Arrays.sort(strArr);
        for (int i13 = 0; i13 < size; i13++) {
            String str = strArr[i13];
            V v11 = map.get(str);
            this.f41354a.U0(i11, 2);
            this.f41354a.W0(h0.b(aVar, str, v11));
            h0.e(this.f41354a, aVar, str, v11);
        }
    }

    public final void V(int i11, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f41354a.S0(i11, (String) obj);
        } else {
            this.f41354a.m0(i11, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void a(int i11, List<?> list, b1 b1Var) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            w(i11, list.get(i12), b1Var);
        }
    }

    @Override // com.google.protobuf.Writer
    public void b(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.w0(i11, list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iS = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iS += CodedOutputStream.s(list.get(i13).floatValue());
        }
        this.f41354a.W0(iS);
        while (i12 < list.size()) {
            this.f41354a.x0(list.get(i12).floatValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public final void c(int i11, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f41354a.J0(i11, (ByteString) obj);
        } else {
            this.f41354a.I0(i11, (n0) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void d(int i11, int i12) throws IOException {
        this.f41354a.s0(i11, i12);
    }

    @Override // com.google.protobuf.Writer
    public void e(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (!(list instanceof d0)) {
            while (i12 < list.size()) {
                this.f41354a.S0(i11, list.get(i12));
                i12++;
            }
        } else {
            d0 d0Var = (d0) list;
            while (i12 < list.size()) {
                V(i11, d0Var.t(i12));
                i12++;
            }
        }
    }

    @Override // com.google.protobuf.Writer
    public void f(int i11, String str) throws IOException {
        this.f41354a.S0(i11, str);
    }

    @Override // com.google.protobuf.Writer
    public void g(int i11, long j11) throws IOException {
        this.f41354a.X0(i11, j11);
    }

    @Override // com.google.protobuf.Writer
    public void h(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.C0(i11, list.get(i12).intValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iX = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iX += CodedOutputStream.x(list.get(i13).intValue());
        }
        this.f41354a.W0(iX);
        while (i12 < list.size()) {
            this.f41354a.D0(list.get(i12).intValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void i(int i11, Object obj, b1 b1Var) throws IOException {
        this.f41354a.z0(i11, (n0) obj, b1Var);
    }

    @Override // com.google.protobuf.Writer
    public void j(int i11, ByteString byteString) throws IOException {
        this.f41354a.m0(i11, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void k(int i11, int i12) throws IOException {
        this.f41354a.C0(i11, i12);
    }

    @Override // com.google.protobuf.Writer
    public void l(int i11, long j11) throws IOException {
        this.f41354a.M0(i11, j11);
    }

    @Override // com.google.protobuf.Writer
    public void m(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.s0(i11, list.get(i12).intValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iO = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iO += CodedOutputStream.o(list.get(i13).intValue());
        }
        this.f41354a.W0(iO);
        while (i12 < list.size()) {
            this.f41354a.t0(list.get(i12).intValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void n(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.V0(i11, list.get(i12).intValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iX = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iX += CodedOutputStream.X(list.get(i13).intValue());
        }
        this.f41354a.W0(iX);
        while (i12 < list.size()) {
            this.f41354a.W0(list.get(i12).intValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void o(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.Q0(i11, list.get(i12).longValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iS = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iS += CodedOutputStream.S(list.get(i13).longValue());
        }
        this.f41354a.W0(iS);
        while (i12 < list.size()) {
            this.f41354a.R0(list.get(i12).longValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void p(int i11, long j11) throws IOException {
        this.f41354a.Q0(i11, j11);
    }

    @Override // com.google.protobuf.Writer
    public void q(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.q0(i11, list.get(i12).intValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iM = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iM += CodedOutputStream.m(list.get(i13).intValue());
        }
        this.f41354a.W0(iM);
        while (i12 < list.size()) {
            this.f41354a.r0(list.get(i12).intValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void r(int i11, List<?> list, b1 b1Var) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            i(i11, list.get(i12), b1Var);
        }
    }

    @Override // com.google.protobuf.Writer
    public void s(int i11, int i12) throws IOException {
        this.f41354a.V0(i11, i12);
    }

    @Override // com.google.protobuf.Writer
    public void t(int i11, double d11) throws IOException {
        this.f41354a.o0(i11, d11);
    }

    @Override // com.google.protobuf.Writer
    public void u(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.M0(i11, list.get(i12).longValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iO = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iO += CodedOutputStream.O(list.get(i13).longValue());
        }
        this.f41354a.W0(iO);
        while (i12 < list.size()) {
            this.f41354a.N0(list.get(i12).longValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void v(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.f41354a.X0(i11, list.get(i12).longValue());
                i12++;
            }
            return;
        }
        this.f41354a.U0(i11, 2);
        int iZ = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZ += CodedOutputStream.Z(list.get(i13).longValue());
        }
        this.f41354a.W0(iZ);
        while (i12 < list.size()) {
            this.f41354a.Y0(list.get(i12).longValue());
            i12++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void w(int i11, Object obj, b1 b1Var) throws IOException {
        this.f41354a.G0(i11, (n0) obj, b1Var);
    }

    @Override // com.google.protobuf.Writer
    public void x(int i11, long j11) throws IOException {
        this.f41354a.u0(i11, j11);
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder y() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.protobuf.Writer
    public void z(int i11, long j11) throws IOException {
        this.f41354a.E0(i11, j11);
    }
}
