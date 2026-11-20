package x5;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;
import u4.l0;
import u4.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements u4.s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u4.y f79937d = new u4.y() { // from class: x5.d
        @Override // u4.y
        public /* synthetic */ u4.y a(o5.s.a aVar) {
            return u4.x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ u4.s[] b(Uri uri, Map map) {
            return u4.x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ u4.y c(boolean z11) {
            return u4.x.b(this, z11);
        }

        @Override // u4.y
        public final u4.s[] createExtractors() {
            return e.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f79938a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.c0 f79939b = new z3.c0(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f79940c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ u4.s[] e() {
        return new u4.s[]{new e()};
    }

    @Override // u4.s
    public boolean b(u4.t tVar) throws IOException {
        z3.c0 c0Var = new z3.c0(10);
        int i11 = 0;
        while (true) {
            tVar.peekFully(c0Var.e(), 0, 10);
            c0Var.U(0);
            if (c0Var.K() != 4801587) {
                break;
            }
            c0Var.V(3);
            int iG = c0Var.G();
            i11 += iG + 10;
            tVar.advancePeekPosition(iG);
        }
        tVar.resetPeekPosition();
        tVar.advancePeekPosition(i11);
        int i12 = i11;
        while (true) {
            int i13 = 0;
            while (true) {
                tVar.peekFully(c0Var.e(), 0, 7);
                c0Var.U(0);
                int iN = c0Var.N();
                if (iN == 44096 || iN == 44097) {
                    i13++;
                    if (i13 >= 4) {
                        return true;
                    }
                    int iE = u4.c.e(c0Var.e(), iN);
                    if (iE == -1) {
                        return false;
                    }
                    tVar.advancePeekPosition(iE - 7);
                }
            }
            tVar.resetPeekPosition();
            i12++;
            if (i12 - i11 >= 8192) {
                return false;
            }
            tVar.advancePeekPosition(i12);
        }
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(u4.t tVar, l0 l0Var) throws IOException {
        int i11 = tVar.read(this.f79939b.e(), 0, 16384);
        if (i11 == -1) {
            return -1;
        }
        this.f79939b.U(0);
        this.f79939b.T(i11);
        if (!this.f79940c) {
            this.f79938a.c(0L, 4);
            this.f79940c = true;
        }
        this.f79938a.b(this.f79939b);
        return 0;
    }

    @Override // u4.s
    public void f(u4.u uVar) {
        this.f79938a.d(uVar, new i0.d(0, 1));
        uVar.endTracks();
        uVar.f(new m0.b(C.TIME_UNSET));
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f79940c = false;
        this.f79938a.seek();
    }
}
