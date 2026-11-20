package ph;

import com.google.android.exoplayer2.util.s;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f73786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.p[] f73787b;

    public c(int[] iArr, com.google.android.exoplayer2.source.p[] pVarArr) {
        this.f73786a = iArr;
        this.f73787b = pVarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f73787b.length];
        int i11 = 0;
        while (true) {
            com.google.android.exoplayer2.source.p[] pVarArr = this.f73787b;
            if (i11 >= pVarArr.length) {
                return iArr;
            }
            iArr[i11] = pVarArr[i11].G();
            i11++;
        }
    }

    public void b(long j11) {
        for (com.google.android.exoplayer2.source.p pVar : this.f73787b) {
            pVar.a0(j11);
        }
    }

    @Override // ph.g.b
    public e0 track(int i11, int i12) {
        int i13 = 0;
        while (true) {
            int[] iArr = this.f73786a;
            if (i13 >= iArr.length) {
                s.c("BaseMediaChunkOutput", "Unmatched track of type: " + i12);
                return new tg.k();
            }
            if (i12 == iArr[i13]) {
                return this.f73787b[i13];
            }
            i13++;
        }
    }
}
