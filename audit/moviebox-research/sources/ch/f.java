package ch;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;
import tg.m;
import tg.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f14824j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f14825k = new c0(255);

    public boolean a(m mVar, boolean z11) throws IOException {
        b();
        this.f14825k.L(27);
        if (!o.b(mVar, this.f14825k.d(), 0, 27, z11) || this.f14825k.F() != 1332176723) {
            return false;
        }
        int iD = this.f14825k.D();
        this.f14815a = iD;
        if (iD != 0) {
            if (z11) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.f14816b = this.f14825k.D();
        this.f14817c = this.f14825k.r();
        this.f14818d = this.f14825k.t();
        this.f14819e = this.f14825k.t();
        this.f14820f = this.f14825k.t();
        int iD2 = this.f14825k.D();
        this.f14821g = iD2;
        this.f14822h = iD2 + 27;
        this.f14825k.L(iD2);
        if (!o.b(mVar, this.f14825k.d(), 0, this.f14821g, z11)) {
            return false;
        }
        for (int i11 = 0; i11 < this.f14821g; i11++) {
            this.f14824j[i11] = this.f14825k.D();
            this.f14823i += this.f14824j[i11];
        }
        return true;
    }

    public void b() {
        this.f14815a = 0;
        this.f14816b = 0;
        this.f14817c = 0L;
        this.f14818d = 0L;
        this.f14819e = 0L;
        this.f14820f = 0L;
        this.f14821g = 0;
        this.f14822h = 0;
        this.f14823i = 0;
    }

    public boolean c(m mVar) throws IOException {
        return d(mVar, -1L);
    }

    public boolean d(m mVar, long j11) throws IOException {
        com.google.android.exoplayer2.util.a.a(mVar.getPosition() == mVar.getPeekPosition());
        this.f14825k.L(4);
        while (true) {
            if ((j11 != -1 && mVar.getPosition() + 4 >= j11) || !o.b(mVar, this.f14825k.d(), 0, 4, true)) {
                break;
            }
            this.f14825k.P(0);
            if (this.f14825k.F() == 1332176723) {
                mVar.resetPeekPosition();
                return true;
            }
            mVar.skipFully(1);
        }
        do {
            if (j11 != -1 && mVar.getPosition() >= j11) {
                break;
            }
        } while (mVar.skip(1) != -1);
        return false;
    }
}
