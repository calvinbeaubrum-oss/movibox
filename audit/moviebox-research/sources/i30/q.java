package i30;

import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final q f67014n = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f67015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short f67016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f67017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f67018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f67019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short f67020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f67021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public short f67022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public short f67023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n f67024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f67025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k f67026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q f67027m;

    public final void a(r rVar, boolean z11) {
        short s11;
        rVar.o(this);
        if (!z11 || (s11 = this.f67016b) == 0) {
            return;
        }
        rVar.q(s11 & 65535, this);
        if (this.f67017c == null) {
            return;
        }
        int i11 = 1;
        while (true) {
            int[] iArr = this.f67017c;
            if (i11 > iArr[0]) {
                return;
            }
            rVar.q(iArr[i11], this);
            i11++;
        }
    }

    public final void b(int i11, int i12, int i13) {
        if (this.f67019e == null) {
            this.f67019e = new int[6];
        }
        int[] iArr = this.f67019e;
        int i14 = iArr[0];
        if (i14 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f67019e = iArr2;
        }
        int[] iArr3 = this.f67019e;
        iArr3[i14 + 1] = i11;
        int i15 = i14 + 2;
        iArr3[i15] = i12 | i13;
        iArr3[0] = i15;
    }

    public final void c(int i11) {
        if (this.f67016b == 0) {
            this.f67016b = (short) i11;
            return;
        }
        if (this.f67017c == null) {
            this.f67017c = new int[4];
        }
        int[] iArr = this.f67017c;
        int i12 = iArr[0] + 1;
        iArr[0] = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f67017c = iArr2;
        }
        this.f67017c[i12] = i11;
    }

    public final void d(q qVar) {
        q qVar2 = f67014n;
        this.f67027m = qVar2;
        q qVar3 = qVar2;
        q qVarG = this;
        while (qVarG != f67014n) {
            q qVar4 = qVarG.f67027m;
            qVarG.f67027m = qVar3;
            if ((qVarG.f67015a & 64) != 0 && qVarG.f67023i != qVar.f67023i) {
                qVarG.f67026l = new k(qVarG.f67021g, qVar.f67026l.f66979b, qVarG.f67026l);
            }
            qVar3 = qVarG;
            qVarG = qVarG.g(qVar4);
        }
        while (qVar3 != f67014n) {
            q qVar5 = qVar3.f67027m;
            qVar3.f67027m = null;
            qVar3 = qVar5;
        }
    }

    public final q e() {
        n nVar = this.f67024j;
        return nVar == null ? this : nVar.f66994a;
    }

    public final void f(short s11) {
        this.f67027m = f67014n;
        q qVarG = this;
        while (qVarG != f67014n) {
            q qVar = qVarG.f67027m;
            qVarG.f67027m = null;
            if (qVarG.f67023i == 0) {
                qVarG.f67023i = s11;
                qVarG = qVarG.g(qVar);
            } else {
                qVarG = qVar;
            }
        }
    }

    public final q g(q qVar) {
        for (k kVar = this.f67026l; kVar != null; kVar = kVar.f66980c) {
            if ((this.f67015a & 16) == 0 || kVar != this.f67026l.f66980c) {
                q qVar2 = kVar.f66979b;
                if (qVar2.f67027m == null) {
                    qVar2.f67027m = qVar;
                    qVar = qVar2;
                }
            }
        }
        return qVar;
    }

    public final void h(d dVar, int i11, boolean z11) {
        if ((this.f67015a & 4) != 0) {
            if (z11) {
                dVar.i(this.f67018d - i11);
                return;
            } else {
                dVar.k(this.f67018d - i11);
                return;
            }
        }
        if (z11) {
            b(i11, ASTNode.DISCARD, dVar.f66921b);
            dVar.i(-1);
        } else {
            b(i11, ASTNode.DEOP, dVar.f66921b);
            dVar.k(-1);
        }
    }

    public final boolean i(byte[] bArr, int i11) {
        this.f67015a = (short) (this.f67015a | 4);
        this.f67018d = i11;
        int[] iArr = this.f67019e;
        boolean z11 = false;
        if (iArr == null) {
            return false;
        }
        for (int i12 = iArr[0]; i12 > 0; i12 -= 2) {
            int[] iArr2 = this.f67019e;
            int i13 = iArr2[i12 - 1];
            int i14 = iArr2[i12];
            int i15 = i11 - i13;
            int i16 = 268435455 & i14;
            if ((i14 & (-268435456)) == 268435456) {
                if (i15 < -32768 || i15 > 32767) {
                    int i17 = bArr[i13] & 255;
                    if (i17 < 198) {
                        bArr[i13] = (byte) (i17 + 49);
                    } else {
                        bArr[i13] = (byte) (i17 + 20);
                    }
                    z11 = true;
                }
                bArr[i16] = (byte) (i15 >>> 8);
                bArr[i16 + 1] = (byte) i15;
            } else {
                bArr[i16] = (byte) (i15 >>> 24);
                bArr[i16 + 1] = (byte) (i15 >>> 16);
                bArr[i16 + 2] = (byte) (i15 >>> 8);
                bArr[i16 + 3] = (byte) i15;
            }
        }
        return z11;
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
