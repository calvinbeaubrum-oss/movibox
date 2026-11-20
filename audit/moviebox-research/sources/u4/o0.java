package u4;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f78372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f78374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f78375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f78376g;

    public o0(int i11, int i12, String str) {
        this.f78370a = i11;
        this.f78371b = i12;
        this.f78372c = str;
    }

    public final void a(String str) {
        r0 r0VarTrack = this.f78375f.track(1024, 4);
        this.f78376g = r0VarTrack;
        r0VarTrack.b(new androidx.media3.common.y.b().k0(str).I());
        this.f78375f.endTracks();
        this.f78375f.f(new p0(C.TIME_UNSET));
        this.f78374e = 1;
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        z3.a.g((this.f78370a == -1 || this.f78371b == -1) ? false : true);
        z3.c0 c0Var = new z3.c0(this.f78371b);
        tVar.peekFully(c0Var.e(), 0, this.f78371b);
        return c0Var.N() == this.f78370a;
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        int i11 = this.f78374e;
        if (i11 == 1) {
            e(tVar);
            return 0;
        }
        if (i11 == 2) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public final void e(t tVar) throws IOException {
        int iD = ((r0) z3.a.e(this.f78376g)).d(tVar, 1024, true);
        if (iD != -1) {
            this.f78373d += iD;
            return;
        }
        this.f78374e = 2;
        this.f78376g.f(0L, 1, this.f78373d, 0, null);
        this.f78373d = 0;
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f78375f = uVar;
        a(this.f78372c);
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        if (j11 == 0 || this.f78374e == 1) {
            this.f78374e = 1;
            this.f78373d = 0;
        }
    }
}
