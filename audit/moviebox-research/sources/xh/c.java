package xh;

import java.util.List;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<vh.b> f80563a;

    public c(List<vh.b> list) {
        this.f80563a = list;
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        return this.f80563a;
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        return 0L;
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        return -1;
    }
}
