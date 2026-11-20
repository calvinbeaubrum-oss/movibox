package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f41222a = B();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h1<?, ?> f41223b = C(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h1<?, ?> f41224c = C(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h1<?, ?> f41225d = new j1();

    public static <UT, UB> UB A(int i11, List<Integer> list, y.e eVar, UB ub2, h1<UT, UB> h1Var) {
        if (eVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int iIntValue = list.get(i13).intValue();
                if (eVar.a(iIntValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(iIntValue));
                    }
                    i12++;
                } else {
                    ub2 = (UB) L(i11, iIntValue, ub2, h1Var);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!eVar.a(iIntValue2)) {
                    ub2 = (UB) L(i11, iIntValue2, ub2, h1Var);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static Class<?> B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static h1<?, ?> C(boolean z11) {
        try {
            Class<?> clsD = D();
            if (clsD == null) {
                return null;
            }
            return (h1) clsD.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z11));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends u.b<FT>> void E(q<FT> qVar, T t11, T t12) {
        u<T> uVarC = qVar.c(t12);
        if (uVarC.n()) {
            return;
        }
        qVar.d(t11).u(uVarC);
    }

    public static <T> void F(i0 i0Var, T t11, T t12, long j11) {
        l1.W(t11, j11, i0Var.a(l1.G(t11, j11), l1.G(t12, j11)));
    }

    public static <T, UT, UB> void G(h1<UT, UB> h1Var, T t11, T t12) {
        h1Var.p(t11, h1Var.k(h1Var.g(t11), h1Var.g(t12)));
    }

    public static h1<?, ?> H() {
        return f41223b;
    }

    public static h1<?, ?> I() {
        return f41224c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f41222a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB L(int i11, int i12, UB ub2, h1<UT, UB> h1Var) {
        if (ub2 == null) {
            ub2 = h1Var.n();
        }
        h1Var.e(ub2, i11, i12);
        return ub2;
    }

    public static h1<?, ?> M() {
        return f41225d;
    }

    public static void N(int i11, List<Boolean> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.F(i11, list, z11);
    }

    public static void O(int i11, List<ByteString> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.O(i11, list);
    }

    public static void P(int i11, List<Double> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.M(i11, list, z11);
    }

    public static void Q(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.q(i11, list, z11);
    }

    public static void R(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.m(i11, list, z11);
    }

    public static void S(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.D(i11, list, z11);
    }

    public static void T(int i11, List<Float> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.b(i11, list, z11);
    }

    public static void U(int i11, List<?> list, Writer writer, b1 b1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.r(i11, list, b1Var);
    }

    public static void V(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.h(i11, list, z11);
    }

    public static void W(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.L(i11, list, z11);
    }

    public static void X(int i11, List<?> list, Writer writer, b1 b1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i11, list, b1Var);
    }

    public static void Y(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.E(i11, list, z11);
    }

    public static void Z(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.u(i11, list, z11);
    }

    public static int a(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(size) : size * CodedOutputStream.e(i11, true);
    }

    public static void a0(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.J(i11, list, z11);
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.o(i11, list, z11);
    }

    public static int c(int i11, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = size * CodedOutputStream.V(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            iV += CodedOutputStream.i(list.get(i12));
        }
        return iV;
    }

    public static void c0(int i11, List<String> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.e(i11, list);
    }

    public static int d(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iE) : iE + (size * CodedOutputStream.V(i11));
    }

    public static void d0(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.n(i11, list, z11);
    }

    public static int e(List<Integer> list) {
        int iM;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            iM = 0;
            while (i11 < size) {
                iM += CodedOutputStream.m(xVar.getInt(i11));
                i11++;
            }
        } else {
            iM = 0;
            while (i11 < size) {
                iM += CodedOutputStream.m(list.get(i11).intValue());
                i11++;
            }
        }
        return iM;
    }

    public static void e0(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.v(i11, list, z11);
    }

    public static int f(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(size * 4) : size * CodedOutputStream.n(i11, 0);
    }

    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static int h(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(size * 8) : size * CodedOutputStream.p(i11, 0L);
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i11, List<n0> list, b1 b1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i12 = 0; i12 < size; i12++) {
            iT += CodedOutputStream.t(i11, list.get(i12), b1Var);
        }
        return iT;
    }

    public static int k(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iL) : iL + (size * CodedOutputStream.V(i11));
    }

    public static int l(List<Integer> list) {
        int iX;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            iX = 0;
            while (i11 < size) {
                iX += CodedOutputStream.x(xVar.getInt(i11));
                i11++;
            }
        } else {
            iX = 0;
            while (i11 < size) {
                iX += CodedOutputStream.x(list.get(i11).intValue());
                i11++;
            }
        }
        return iX;
    }

    public static int m(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iN) : iN + (list.size() * CodedOutputStream.V(i11));
    }

    public static int n(List<Long> list) {
        int iZ;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            iZ = 0;
            while (i11 < size) {
                iZ += CodedOutputStream.z(f0Var.o(i11));
                i11++;
            }
        } else {
            iZ = 0;
            while (i11 < size) {
                iZ += CodedOutputStream.z(list.get(i11).longValue());
                i11++;
            }
        }
        return iZ;
    }

    public static int o(int i11, Object obj, b1 b1Var) {
        return obj instanceof b0 ? CodedOutputStream.B(i11, (b0) obj) : CodedOutputStream.G(i11, (n0) obj, b1Var);
    }

    public static int p(int i11, List<?> list, b1 b1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = CodedOutputStream.V(i11) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            iV += obj instanceof b0 ? CodedOutputStream.C((b0) obj) : CodedOutputStream.I((n0) obj, b1Var);
        }
        return iV;
    }

    public static int q(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iR) : iR + (size * CodedOutputStream.V(i11));
    }

    public static int r(List<Integer> list) {
        int iQ;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            iQ = 0;
            while (i11 < size) {
                iQ += CodedOutputStream.Q(xVar.getInt(i11));
                i11++;
            }
        } else {
            iQ = 0;
            while (i11 < size) {
                iQ += CodedOutputStream.Q(list.get(i11).intValue());
                i11++;
            }
        }
        return iQ;
    }

    public static int s(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iT) : iT + (size * CodedOutputStream.V(i11));
    }

    public static int t(List<Long> list) {
        int iS;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            iS = 0;
            while (i11 < size) {
                iS += CodedOutputStream.S(f0Var.o(i11));
                i11++;
            }
        } else {
            iS = 0;
            while (i11 < size) {
                iS += CodedOutputStream.S(list.get(i11).longValue());
                i11++;
            }
        }
        return iS;
    }

    public static int u(int i11, List<?> list) {
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        int iV = CodedOutputStream.V(i11) * size;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            while (i12 < size) {
                Object objT = d0Var.t(i12);
                iV += objT instanceof ByteString ? CodedOutputStream.i((ByteString) objT) : CodedOutputStream.U((String) objT);
                i12++;
            }
        } else {
            while (i12 < size) {
                Object obj = list.get(i12);
                iV += obj instanceof ByteString ? CodedOutputStream.i((ByteString) obj) : CodedOutputStream.U((String) obj);
                i12++;
            }
        }
        return iV;
    }

    public static int v(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iW) : iW + (size * CodedOutputStream.V(i11));
    }

    public static int w(List<Integer> list) {
        int iX;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            iX = 0;
            while (i11 < size) {
                iX += CodedOutputStream.X(xVar.getInt(i11));
                i11++;
            }
        } else {
            iX = 0;
            while (i11 < size) {
                iX += CodedOutputStream.X(list.get(i11).intValue());
                i11++;
            }
        }
        return iX;
    }

    public static int x(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z11 ? CodedOutputStream.V(i11) + CodedOutputStream.D(iY) : iY + (size * CodedOutputStream.V(i11));
    }

    public static int y(List<Long> list) {
        int iZ;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            iZ = 0;
            while (i11 < size) {
                iZ += CodedOutputStream.Z(f0Var.o(i11));
                i11++;
            }
        } else {
            iZ = 0;
            while (i11 < size) {
                iZ += CodedOutputStream.Z(list.get(i11).longValue());
                i11++;
            }
        }
        return iZ;
    }

    public static <UT, UB> UB z(int i11, List<Integer> list, y.d<?> dVar, UB ub2, h1<UT, UB> h1Var) {
        if (dVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int iIntValue = list.get(i13).intValue();
                if (dVar.a(iIntValue) != null) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(iIntValue));
                    }
                    i12++;
                } else {
                    ub2 = (UB) L(i11, iIntValue, ub2, h1Var);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (dVar.a(iIntValue2) == null) {
                    ub2 = (UB) L(i11, iIntValue2, ub2, h1Var);
                    it.remove();
                }
            }
        }
        return ub2;
    }
}
