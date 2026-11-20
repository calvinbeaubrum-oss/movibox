package ei;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements vh.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<vh.b> f64214a;

    public b(List<vh.b> list) {
        this.f64214a = Collections.unmodifiableList(list);
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        return j11 >= 0 ? this.f64214a : Collections.emptyList();
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 == 0);
        return 0L;
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        return j11 < 0 ? 0 : -1;
    }
}
