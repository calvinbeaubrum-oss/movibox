package th;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f77129b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f77131d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f77133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f77135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f77136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f77137j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77130c = C.TIME_UNSET;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77132e = -1;

    public e(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77128a = jVar;
    }

    public static long e(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 90000L);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f77129b);
        int iE = c0Var.e();
        int iJ = c0Var.J();
        boolean z12 = (iJ & 1024) > 0;
        if ((iJ & 512) != 0 || (iJ & 504) != 0 || (iJ & 7) != 0) {
            s.i("RtpH263Reader", "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
            return;
        }
        if (!z12) {
            int iB = com.google.android.exoplayer2.source.rtsp.g.b(this.f77132e);
            if (i11 != iB) {
                s.i("RtpH263Reader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i11)));
                return;
            }
        } else if ((c0Var.h() & 252) < 128) {
            s.i("RtpH263Reader", "Picture start Code (PSC) missing, dropping packet.");
            return;
        } else {
            c0Var.d()[iE] = 0;
            c0Var.d()[iE + 1] = 0;
            c0Var.P(iE);
        }
        if (this.f77131d == 0) {
            d(c0Var, this.f77136i);
            if (!this.f77136i && this.f77135h) {
                int i12 = this.f77133f;
                m1 m1Var = this.f77128a.f34552c;
                if (i12 != m1Var.f33450r || this.f77134g != m1Var.f33451s) {
                    this.f77129b.e(m1Var.b().j0(this.f77133f).Q(this.f77134g).E());
                }
                this.f77136i = true;
            }
        }
        int iA = c0Var.a();
        this.f77129b.c(c0Var, iA);
        this.f77131d += iA;
        if (z11) {
            if (this.f77130c == C.TIME_UNSET) {
                this.f77130c = j11;
            }
            this.f77129b.d(e(this.f77137j, j11, this.f77130c), this.f77135h ? 1 : 0, this.f77131d, 0, null);
            this.f77131d = 0;
            this.f77135h = false;
        }
        this.f77132e = i11;
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 2);
        this.f77129b = e0VarTrack;
        e0VarTrack.e(this.f77128a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
    }

    public final void d(c0 c0Var, boolean z11) {
        int iE = c0Var.e();
        if (((c0Var.F() >> 10) & 63) != 32) {
            c0Var.P(iE);
            this.f77135h = false;
            return;
        }
        int iH = c0Var.h();
        int i11 = (iH >> 1) & 1;
        if (!z11 && i11 == 0) {
            int i12 = (iH >> 2) & 7;
            if (i12 == 1) {
                this.f77133f = 128;
                this.f77134g = 96;
            } else {
                int i13 = i12 - 2;
                this.f77133f = 176 << i13;
                this.f77134g = 144 << i13;
            }
        }
        c0Var.P(iE);
        this.f77135h = i11 == 0;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77130c = j11;
        this.f77131d = 0;
        this.f77137j = j12;
    }
}
