package m5;

import androidx.media3.common.ParserException;
import java.io.IOException;
import u4.t;
import u4.v;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f70819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f70821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f70822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f70823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f70824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f70825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f70826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f70827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f70828j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f70829k = new c0(255);

    public boolean a(t tVar, boolean z11) throws IOException {
        b();
        this.f70829k.Q(27);
        if (!v.b(tVar, this.f70829k.e(), 0, 27, z11) || this.f70829k.J() != 1332176723) {
            return false;
        }
        int iH = this.f70829k.H();
        this.f70819a = iH;
        if (iH != 0) {
            if (z11) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.f70820b = this.f70829k.H();
        this.f70821c = this.f70829k.v();
        this.f70822d = this.f70829k.x();
        this.f70823e = this.f70829k.x();
        this.f70824f = this.f70829k.x();
        int iH2 = this.f70829k.H();
        this.f70825g = iH2;
        this.f70826h = iH2 + 27;
        this.f70829k.Q(iH2);
        if (!v.b(tVar, this.f70829k.e(), 0, this.f70825g, z11)) {
            return false;
        }
        for (int i11 = 0; i11 < this.f70825g; i11++) {
            this.f70828j[i11] = this.f70829k.H();
            this.f70827i += this.f70828j[i11];
        }
        return true;
    }

    public void b() {
        this.f70819a = 0;
        this.f70820b = 0;
        this.f70821c = 0L;
        this.f70822d = 0L;
        this.f70823e = 0L;
        this.f70824f = 0L;
        this.f70825g = 0;
        this.f70826h = 0;
        this.f70827i = 0;
    }

    public boolean c(t tVar) throws IOException {
        return d(tVar, -1L);
    }

    public boolean d(t tVar, long j11) throws IOException {
        z3.a.a(tVar.getPosition() == tVar.getPeekPosition());
        this.f70829k.Q(4);
        while (true) {
            if ((j11 != -1 && tVar.getPosition() + 4 >= j11) || !v.b(tVar, this.f70829k.e(), 0, 4, true)) {
                break;
            }
            this.f70829k.U(0);
            if (this.f70829k.J() == 1332176723) {
                tVar.resetPeekPosition();
                return true;
            }
            tVar.skipFully(1);
        }
        do {
            if (j11 != -1 && tVar.getPosition() >= j11) {
                break;
            }
        } while (tVar.skip(1) != -1);
        return false;
    }
}
