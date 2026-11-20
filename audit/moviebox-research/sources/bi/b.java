package bi;

import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vh.b[] f14275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f14276b;

    public b(vh.b[] bVarArr, long[] jArr) {
        this.f14275a = bVarArr;
        this.f14276b = jArr;
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        vh.b bVar;
        int i11 = o0.i(this.f14276b, j11, true, false);
        return (i11 == -1 || (bVar = this.f14275a[i11]) == vh.b.f78816s) ? Collections.emptyList() : Collections.singletonList(bVar);
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        com.google.android.exoplayer2.util.a.a(i11 < this.f14276b.length);
        return this.f14276b[i11];
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return this.f14276b.length;
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        int iE = o0.e(this.f14276b, j11, false, false);
        if (iE < this.f14276b.length) {
            return iE;
        }
        return -1;
    }
}
