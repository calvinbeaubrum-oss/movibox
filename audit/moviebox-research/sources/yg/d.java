package yg;

import tg.b0;
import tg.c0;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f81342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f81343b;

    /* JADX INFO: compiled from: source.java */
    public class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f81344a;

        public a(b0 b0Var) {
            this.f81344a = b0Var;
        }

        @Override // tg.b0
        public long getDurationUs() {
            return this.f81344a.getDurationUs();
        }

        @Override // tg.b0
        public b0.a getSeekPoints(long j11) {
            b0.a seekPoints = this.f81344a.getSeekPoints(j11);
            c0 c0Var = seekPoints.f76991a;
            c0 c0Var2 = new c0(c0Var.f76996a, c0Var.f76997b + d.this.f81342a);
            c0 c0Var3 = seekPoints.f76992b;
            return new b0.a(c0Var2, new c0(c0Var3.f76996a, c0Var3.f76997b + d.this.f81342a));
        }

        @Override // tg.b0
        public boolean isSeekable() {
            return this.f81344a.isSeekable();
        }
    }

    public d(long j11, n nVar) {
        this.f81342a = j11;
        this.f81343b = nVar;
    }

    @Override // tg.n
    public void endTracks() {
        this.f81343b.endTracks();
    }

    @Override // tg.n
    public void g(b0 b0Var) {
        this.f81343b.g(new a(b0Var));
    }

    @Override // tg.n
    public e0 track(int i11, int i12) {
        return this.f81343b.track(i11, i12);
    }
}
