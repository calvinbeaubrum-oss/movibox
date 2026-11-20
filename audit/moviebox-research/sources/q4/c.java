package q4;

import androidx.media3.exoplayer.source.s;
import u4.q;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f74300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s[] f74301b;

    public c(int[] iArr, s[] sVarArr) {
        this.f74300a = iArr;
        this.f74301b = sVarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f74301b.length];
        int i11 = 0;
        while (true) {
            s[] sVarArr = this.f74301b;
            if (i11 >= sVarArr.length) {
                return iArr;
            }
            iArr[i11] = sVarArr[i11].H();
            i11++;
        }
    }

    public void b(long j11) {
        for (s sVar : this.f74301b) {
            sVar.b0(j11);
        }
    }

    @Override // q4.f.b
    public r0 track(int i11, int i12) {
        int i13 = 0;
        while (true) {
            int[] iArr = this.f74300a;
            if (i13 >= iArr.length) {
                z3.o.c("BaseMediaChunkOutput", "Unmatched track of type: " + i12);
                return new q();
            }
            if (i12 == iArr[i13]) {
                return this.f74301b[i13];
            }
            i13++;
        }
    }
}
