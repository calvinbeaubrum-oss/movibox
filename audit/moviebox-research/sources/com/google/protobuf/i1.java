package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i1 f41288f = new i1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f41290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f41291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41293e;

    public i1() {
        this(0, new int[8], new Object[8], true);
    }

    public i1(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.f41292d = -1;
        this.f41289a = i11;
        this.f41290b = iArr;
        this.f41291c = objArr;
        this.f41293e = z11;
    }

    public static i1 c() {
        return f41288f;
    }

    public static int f(int[] iArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        return i12;
    }

    public static int g(Object[] objArr, int i11) {
        int iHashCode = 17;
        for (int i12 = 0; i12 < i11; i12++) {
            iHashCode = (iHashCode * 31) + objArr[i12].hashCode();
        }
        return iHashCode;
    }

    public static i1 i(i1 i1Var, i1 i1Var2) {
        int i11 = i1Var.f41289a + i1Var2.f41289a;
        int[] iArrCopyOf = Arrays.copyOf(i1Var.f41290b, i11);
        System.arraycopy(i1Var2.f41290b, 0, iArrCopyOf, i1Var.f41289a, i1Var2.f41289a);
        Object[] objArrCopyOf = Arrays.copyOf(i1Var.f41291c, i11);
        System.arraycopy(i1Var2.f41291c, 0, objArrCopyOf, i1Var.f41289a, i1Var2.f41289a);
        return new i1(i11, iArrCopyOf, objArrCopyOf, true);
    }

    public static i1 j() {
        return new i1();
    }

    public static boolean k(Object[] objArr, Object[] objArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (!objArr[i12].equals(objArr2[i12])) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(int[] iArr, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (iArr[i12] != iArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    public static void p(int i11, Object obj, Writer writer) throws IOException {
        int iA = WireFormat.a(i11);
        int iB = WireFormat.b(i11);
        if (iB == 0) {
            writer.z(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            writer.x(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            writer.j(iA, (ByteString) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
            }
            writer.d(iA, ((Integer) obj).intValue());
        } else if (writer.y() == Writer.FieldOrder.ASCENDING) {
            writer.C(iA);
            ((i1) obj).q(writer);
            writer.I(iA);
        } else {
            writer.I(iA);
            ((i1) obj).q(writer);
            writer.C(iA);
        }
    }

    public void a() {
        if (!this.f41293e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b() {
        int i11 = this.f41289a;
        int[] iArr = this.f41290b;
        if (i11 == iArr.length) {
            int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
            this.f41290b = Arrays.copyOf(iArr, i12);
            this.f41291c = Arrays.copyOf(this.f41291c, i12);
        }
    }

    public int d() {
        int iY;
        int i11 = this.f41292d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f41289a; i13++) {
            int i14 = this.f41290b[i13];
            int iA = WireFormat.a(i14);
            int iB = WireFormat.b(i14);
            if (iB == 0) {
                iY = CodedOutputStream.Y(iA, ((Long) this.f41291c[i13]).longValue());
            } else if (iB == 1) {
                iY = CodedOutputStream.p(iA, ((Long) this.f41291c[i13]).longValue());
            } else if (iB == 2) {
                iY = CodedOutputStream.h(iA, (ByteString) this.f41291c[i13]);
            } else if (iB == 3) {
                iY = (CodedOutputStream.V(iA) * 2) + ((i1) this.f41291c[i13]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                }
                iY = CodedOutputStream.n(iA, ((Integer) this.f41291c[i13]).intValue());
            }
            i12 += iY;
        }
        this.f41292d = i12;
        return i12;
    }

    public int e() {
        int i11 = this.f41292d;
        if (i11 != -1) {
            return i11;
        }
        int iJ = 0;
        for (int i12 = 0; i12 < this.f41289a; i12++) {
            iJ += CodedOutputStream.J(WireFormat.a(this.f41290b[i12]), (ByteString) this.f41291c[i12]);
        }
        this.f41292d = iJ;
        return iJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        int i11 = this.f41289a;
        return i11 == i1Var.f41289a && n(this.f41290b, i1Var.f41290b, i11) && k(this.f41291c, i1Var.f41291c, this.f41289a);
    }

    public void h() {
        this.f41293e = false;
    }

    public int hashCode() {
        int i11 = this.f41289a;
        return ((((527 + i11) * 31) + f(this.f41290b, i11)) * 31) + g(this.f41291c, this.f41289a);
    }

    public final void l(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.f41289a; i12++) {
            p0.c(sb2, i11, String.valueOf(WireFormat.a(this.f41290b[i12])), this.f41291c[i12]);
        }
    }

    public void m(int i11, Object obj) {
        a();
        b();
        int[] iArr = this.f41290b;
        int i12 = this.f41289a;
        iArr[i12] = i11;
        this.f41291c[i12] = obj;
        this.f41289a = i12 + 1;
    }

    public void o(Writer writer) throws IOException {
        if (writer.y() == Writer.FieldOrder.DESCENDING) {
            for (int i11 = this.f41289a - 1; i11 >= 0; i11--) {
                writer.c(WireFormat.a(this.f41290b[i11]), this.f41291c[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.f41289a; i12++) {
            writer.c(WireFormat.a(this.f41290b[i12]), this.f41291c[i12]);
        }
    }

    public void q(Writer writer) throws IOException {
        if (this.f41289a == 0) {
            return;
        }
        if (writer.y() == Writer.FieldOrder.ASCENDING) {
            for (int i11 = 0; i11 < this.f41289a; i11++) {
                p(this.f41290b[i11], this.f41291c[i11], writer);
            }
            return;
        }
        for (int i12 = this.f41289a - 1; i12 >= 0; i12--) {
            p(this.f41290b[i12], this.f41291c[i12], writer);
        }
    }
}
