package k7;

import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f68466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f68469d;

    public final void a(int i11, int i12, int i13) {
        if (this.f68469d == null) {
            this.f68469d = new int[6];
        }
        int i14 = this.f68468c;
        int[] iArr = this.f68469d;
        if (i14 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f68469d = iArr2;
        }
        int[] iArr3 = this.f68469d;
        int i15 = this.f68468c;
        iArr3[i15] = i11;
        this.f68468c = i15 + 2;
        iArr3[i15 + 1] = i12 | i13;
    }

    public void b(i iVar, a aVar, int i11, boolean z11) {
        if ((this.f68466a & 2) != 0) {
            if (z11) {
                aVar.f(this.f68467b - i11);
                return;
            } else {
                aVar.g(this.f68467b - i11);
                return;
            }
        }
        if (z11) {
            a(i11, aVar.f68428b, ASTNode.DISCARD);
            aVar.f(-1);
        } else {
            a(i11, aVar.f68428b, ASTNode.DEOP);
            aVar.g(-1);
        }
    }

    public void c(i iVar, int i11, byte[] bArr) {
        this.f68466a |= 2;
        this.f68467b = i11;
        int i12 = 0;
        while (i12 < this.f68468c) {
            int[] iArr = this.f68469d;
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            i12 += 2;
            int i15 = iArr[i13];
            int i16 = 268435455 & i15;
            int i17 = i11 - i14;
            if ((i15 & (-268435456)) == 268435456) {
                bArr[i16] = (byte) (i17 >>> 8);
                bArr[i16 + 1] = (byte) i17;
            } else {
                bArr[i16] = (byte) (i17 >>> 24);
                bArr[i16 + 1] = (byte) (i17 >>> 16);
                bArr[i16 + 2] = (byte) (i17 >>> 8);
                bArr[i16 + 3] = (byte) i17;
            }
        }
    }
}
