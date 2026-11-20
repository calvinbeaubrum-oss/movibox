package l5;

import org.mvel2.ast.ASTNode;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f69962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f69964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f69965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f69966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f69967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f69968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f69969h;

    public s(p pVar, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        z3.a.a(iArr.length == jArr2.length);
        z3.a.a(jArr.length == jArr2.length);
        z3.a.a(iArr2.length == jArr2.length);
        this.f69962a = pVar;
        this.f69964c = jArr;
        this.f69965d = iArr;
        this.f69966e = i11;
        this.f69967f = jArr2;
        this.f69968g = iArr2;
        this.f69969h = j11;
        this.f69963b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | ASTNode.DISCARD;
        }
    }

    public int a(long j11) {
        for (int iH = u0.h(this.f69967f, j11, true, false); iH >= 0; iH--) {
            if ((this.f69968g[iH] & 1) != 0) {
                return iH;
            }
        }
        return -1;
    }

    public int b(long j11) {
        for (int iD = u0.d(this.f69967f, j11, true, false); iD < this.f69967f.length; iD++) {
            if ((this.f69968g[iD] & 1) != 0) {
                return iD;
            }
        }
        return -1;
    }
}
