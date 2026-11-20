package wh;

import java.util.Collections;
import java.util.List;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<vh.b> f79518a;

    public f(List<vh.b> list) {
        this.f79518a = list;
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        return j11 >= 0 ? this.f79518a : Collections.emptyList();
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
