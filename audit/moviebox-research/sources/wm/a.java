package wm;

import com.google.zxing.ChecksumException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f79551a = b.f79552f;

    public int a(int[] iArr, int i11, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.f79551a, iArr);
        int[] iArr3 = new int[i11];
        boolean z11 = false;
        for (int i12 = i11; i12 > 0; i12--) {
            int iB = cVar.b(this.f79551a.c(i12));
            iArr3[i11 - i12] = iB;
            if (iB != 0) {
                z11 = true;
            }
        }
        if (!z11) {
            return 0;
        }
        c cVarD = this.f79551a.d();
        if (iArr2 != null) {
            for (int i13 : iArr2) {
                int iC = this.f79551a.c((iArr.length - 1) - i13);
                b bVar = this.f79551a;
                cVarD = cVarD.g(new c(bVar, new int[]{bVar.j(0, iC), 1}));
            }
        }
        c[] cVarArrD = d(this.f79551a.b(i11, 1), new c(this.f79551a, iArr3), i11);
        c cVar2 = cVarArrD[0];
        c cVar3 = cVarArrD[1];
        int[] iArrB = b(cVar2);
        int[] iArrC = c(cVar3, cVar2, iArrB);
        for (int i14 = 0; i14 < iArrB.length; i14++) {
            int length = (iArr.length - 1) - this.f79551a.h(iArrB[i14]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.f79551a.j(iArr[length], iArrC[i14]);
        }
        return iArrB.length;
    }

    public final int[] b(c cVar) throws ChecksumException {
        int iD = cVar.d();
        int[] iArr = new int[iD];
        int i11 = 0;
        for (int i12 = 1; i12 < this.f79551a.e() && i11 < iD; i12++) {
            if (cVar.b(i12) == 0) {
                iArr[i11] = this.f79551a.g(i12);
                i11++;
            }
        }
        if (i11 == iD) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    public final int[] c(c cVar, c cVar2, int[] iArr) {
        int iD = cVar2.d();
        if (iD < 1) {
            return new int[0];
        }
        int[] iArr2 = new int[iD];
        for (int i11 = 1; i11 <= iD; i11++) {
            iArr2[iD - i11] = this.f79551a.i(i11, cVar2.c(i11));
        }
        c cVar3 = new c(this.f79551a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            int iG = this.f79551a.g(iArr[i12]);
            iArr3[i12] = this.f79551a.i(this.f79551a.j(0, cVar.b(iG)), this.f79551a.g(cVar3.b(iG)));
        }
        return iArr3;
    }

    public final c[] d(c cVar, c cVar2, int i11) throws ChecksumException {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarF = this.f79551a.f();
        c cVarD = this.f79551a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarD;
            c cVar5 = cVarF;
            cVarF = cVar4;
            if (cVar.d() < i11 / 2) {
                int iC = cVarF.c(0);
                if (iC == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int iG = this.f79551a.g(iC);
                return new c[]{cVarF.f(iG), cVar.f(iG)};
            }
            if (cVar.e()) {
                throw ChecksumException.getChecksumInstance();
            }
            c cVarF2 = this.f79551a.f();
            int iG2 = this.f79551a.g(cVar.c(cVar.d()));
            while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                int iD = cVar2.d() - cVar.d();
                int i12 = this.f79551a.i(cVar2.c(cVar2.d()), iG2);
                cVarF2 = cVarF2.a(this.f79551a.b(iD, i12));
                cVar2 = cVar2.j(cVar.h(iD, i12));
            }
            cVarD = cVarF2.g(cVarF).j(cVar5).i();
        }
    }
}
