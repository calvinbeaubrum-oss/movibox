package ai;

import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<vh.b>> f573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f574b;

    public d(List<List<vh.b>> list, List<Long> list2) {
        this.f573a = list;
        this.f574b = list2;
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        int iG = o0.g(this.f574b, Long.valueOf(j11), true, false);
        return iG == -1 ? Collections.emptyList() : this.f573a.get(iG);
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        com.google.android.exoplayer2.util.a.a(i11 < this.f574b.size());
        return this.f574b.get(i11).longValue();
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return this.f574b.size();
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        int iD = o0.d(this.f574b, Long.valueOf(j11), false, false);
        if (iD < this.f574b.size()) {
            return iD;
        }
        return -1;
    }
}
