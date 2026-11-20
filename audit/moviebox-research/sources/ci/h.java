package ci;

import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f14921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f14922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, g> f14923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, e> f14924d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f14925f;

    public h(d dVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.f14921a = dVar;
        this.f14924d = map2;
        this.f14925f = map3;
        this.f14923c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f14922b = dVar.j();
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        return this.f14921a.h(j11, this.f14923c, this.f14924d, this.f14925f);
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        return this.f14922b[i11];
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return this.f14922b.length;
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        int iE = o0.e(this.f14922b, j11, false, false);
        if (iE < this.f14922b.length) {
            return iE;
        }
        return -1;
    }
}
