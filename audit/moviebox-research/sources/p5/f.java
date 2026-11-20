package p5;

import java.util.Collections;
import java.util.List;
import o5.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y3.a> f73704a;

    public f(List<y3.a> list) {
        this.f73704a = list;
    }

    @Override // o5.k
    public List<y3.a> getCues(long j11) {
        return j11 >= 0 ? this.f73704a : Collections.emptyList();
    }

    @Override // o5.k
    public long getEventTime(int i11) {
        z3.a.a(i11 == 0);
        return 0L;
    }

    @Override // o5.k
    public int getEventTimeCount() {
        return 1;
    }

    @Override // o5.k
    public int getNextEventTimeIndex(long j11) {
        return j11 < 0 ? 0 : -1;
    }
}
