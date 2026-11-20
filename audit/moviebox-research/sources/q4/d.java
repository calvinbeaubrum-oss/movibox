package q4;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import o5.t;
import u4.l0;
import u4.m0;
import u4.q;
import u4.q0;
import u4.r0;
import u4.s;
import u4.u;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements u, f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f74302k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l0 f74303l = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f74304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f74305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f74306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<a> f74307d = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f74308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public f.b f74309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f74310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m0 f74311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y[] f74312j;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final y f74315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q f74316d = new q();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public y f74317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public r0 f74318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f74319g;

        public a(int i11, int i12, @Nullable y yVar) {
            this.f74313a = i11;
            this.f74314b = i12;
            this.f74315c = yVar;
        }

        @Override // u4.r0
        public void a(c0 c0Var, int i11, int i12) {
            ((r0) u0.i(this.f74318f)).c(c0Var, i11);
        }

        @Override // u4.r0
        public void b(y yVar) {
            y yVar2 = this.f74315c;
            if (yVar2 != null) {
                yVar = yVar.n(yVar2);
            }
            this.f74317e = yVar;
            ((r0) u0.i(this.f74318f)).b(this.f74317e);
        }

        @Override // u4.r0
        public /* synthetic */ void c(c0 c0Var, int i11) {
            q0.b(this, c0Var, i11);
        }

        @Override // u4.r0
        public /* synthetic */ int d(androidx.media3.common.l lVar, int i11, boolean z11) {
            return q0.a(this, lVar, i11, z11);
        }

        @Override // u4.r0
        public int e(androidx.media3.common.l lVar, int i11, boolean z11, int i12) throws IOException {
            return ((r0) u0.i(this.f74318f)).d(lVar, i11, z11);
        }

        @Override // u4.r0
        public void f(long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
            long j12 = this.f74319g;
            if (j12 != C.TIME_UNSET && j11 >= j12) {
                this.f74318f = this.f74316d;
            }
            ((r0) u0.i(this.f74318f)).f(j11, i11, i12, i13, aVar);
        }

        public void g(@Nullable f.b bVar, long j11) {
            if (bVar == null) {
                this.f74318f = this.f74316d;
                return;
            }
            this.f74319g = j11;
            r0 r0VarTrack = bVar.track(this.f74313a, this.f74314b);
            this.f74318f = r0VarTrack;
            y yVar = this.f74317e;
            if (yVar != null) {
                r0VarTrack.b(yVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o5.s.a f74320a = new o5.h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f74321b;

        @Override // q4.f.a
        public y c(y yVar) {
            String str;
            if (!this.f74321b || !this.f74320a.a(yVar)) {
                return yVar;
            }
            y.b bVarQ = yVar.b().k0("application/x-media3-cues").Q(this.f74320a.b(yVar));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(yVar.f9501m);
            if (yVar.f9498j != null) {
                str = " " + yVar.f9498j;
            } else {
                str = "";
            }
            sb2.append(str);
            return bVarQ.M(sb2.toString()).o0(Long.MAX_VALUE).I();
        }

        @Override // q4.f.a
        @Nullable
        public f d(int i11, y yVar, boolean z11, List<y> list, @Nullable r0 r0Var, x3 x3Var) {
            s gVar;
            String str = yVar.f9500l;
            if (!f0.r(str)) {
                if (f0.q(str)) {
                    gVar = new j5.e(this.f74320a, this.f74321b ? 1 : 3);
                } else if (Objects.equals(str, "image/jpeg")) {
                    gVar = new b5.a(1);
                } else if (Objects.equals(str, "image/png")) {
                    gVar = new n5.a();
                } else {
                    int i12 = z11 ? 4 : 0;
                    if (!this.f74321b) {
                        i12 |= 32;
                    }
                    gVar = new l5.g(this.f74320a, i12, null, null, list, r0Var);
                }
            } else {
                if (!this.f74321b) {
                    return null;
                }
                gVar = new o5.n(this.f74320a.c(yVar), yVar);
            }
            if (this.f74321b && !f0.r(str) && !(gVar.c() instanceof l5.g) && !(gVar.c() instanceof j5.e)) {
                gVar = new t(gVar, this.f74320a);
            }
            return new d(gVar, i11, yVar);
        }

        @Override // q4.f.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b b(boolean z11) {
            this.f74321b = z11;
            return this;
        }

        @Override // q4.f.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public b a(o5.s.a aVar) {
            this.f74320a = (o5.s.a) z3.a.e(aVar);
            return this;
        }
    }

    public d(s sVar, int i11, y yVar) {
        this.f74304a = sVar;
        this.f74305b = i11;
        this.f74306c = yVar;
    }

    @Override // q4.f
    public boolean a(u4.t tVar) throws IOException {
        int iD = this.f74304a.d(tVar, f74303l);
        z3.a.g(iD != 1);
        return iD == 0;
    }

    @Override // q4.f
    @Nullable
    public u4.h b() {
        m0 m0Var = this.f74311i;
        if (m0Var instanceof u4.h) {
            return (u4.h) m0Var;
        }
        return null;
    }

    @Override // q4.f
    @Nullable
    public y[] c() {
        return this.f74312j;
    }

    @Override // q4.f
    public void d(@Nullable f.b bVar, long j11, long j12) {
        this.f74309g = bVar;
        this.f74310h = j12;
        if (!this.f74308f) {
            this.f74304a.f(this);
            if (j11 != C.TIME_UNSET) {
                this.f74304a.seek(0L, j11);
            }
            this.f74308f = true;
            return;
        }
        s sVar = this.f74304a;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        sVar.seek(0L, j11);
        for (int i11 = 0; i11 < this.f74307d.size(); i11++) {
            this.f74307d.valueAt(i11).g(bVar, j12);
        }
    }

    @Override // u4.u
    public void endTracks() {
        y[] yVarArr = new y[this.f74307d.size()];
        for (int i11 = 0; i11 < this.f74307d.size(); i11++) {
            yVarArr[i11] = (y) z3.a.i(this.f74307d.valueAt(i11).f74317e);
        }
        this.f74312j = yVarArr;
    }

    @Override // u4.u
    public void f(m0 m0Var) {
        this.f74311i = m0Var;
    }

    @Override // q4.f
    public void release() {
        this.f74304a.release();
    }

    @Override // u4.u
    public r0 track(int i11, int i12) {
        a aVar = this.f74307d.get(i11);
        if (aVar == null) {
            z3.a.g(this.f74312j == null);
            aVar = new a(i11, i12, i12 == this.f74305b ? this.f74306c : null);
            aVar.g(this.f74309g, this.f74310h);
            this.f74307d.put(i11, aVar);
        }
        return aVar;
    }
}
