package u5;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import o5.k;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f78479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f78480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, g> f78481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, e> f78482d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f78483f;

    public h(c cVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.f78479a = cVar;
        this.f78482d = map2;
        this.f78483f = map3;
        this.f78481c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f78480b = cVar.j();
    }

    @Override // o5.k
    public List<y3.a> getCues(long j11) {
        return this.f78479a.h(j11, this.f78481c, this.f78482d, this.f78483f);
    }

    @Override // o5.k
    public long getEventTime(int i11) {
        return this.f78480b[i11];
    }

    @Override // o5.k
    public int getEventTimeCount() {
        return this.f78480b.length;
    }

    @Override // o5.k
    public int getNextEventTimeIndex(long j11) {
        int iD = u0.d(this.f78480b, j11, false, false);
        if (iD < this.f78480b.length) {
            return iD;
        }
        return -1;
    }
}
