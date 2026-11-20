package bh;

import com.google.android.exoplayer2.util.o0;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f14263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f14265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f14266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f14268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f14269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f14270h;

    public r(o oVar, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        com.google.android.exoplayer2.util.a.a(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(iArr2.length == jArr2.length);
        this.f14263a = oVar;
        this.f14265c = jArr;
        this.f14266d = iArr;
        this.f14267e = i11;
        this.f14268f = jArr2;
        this.f14269g = iArr2;
        this.f14270h = j11;
        this.f14264b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | ASTNode.DISCARD;
        }
    }

    public int a(long j11) {
        for (int i11 = o0.i(this.f14268f, j11, true, false); i11 >= 0; i11--) {
            if ((this.f14269g[i11] & 1) != 0) {
                return i11;
            }
        }
        return -1;
    }

    public int b(long j11) {
        for (int iE = o0.e(this.f14268f, j11, true, false); iE < this.f14268f.length; iE++) {
            if ((this.f14269g[iE] & 1) != 0) {
                return iE;
            }
        }
        return -1;
    }
}
