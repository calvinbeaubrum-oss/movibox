package u4;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f78268a;

    public e0(m0 m0Var) {
        this.f78268a = m0Var;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f78268a.getDurationUs();
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        return this.f78268a.getSeekPoints(j11);
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return this.f78268a.isSeekable();
    }
}
