package androidx.media3.exoplayer.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.l;
import androidx.media3.common.y;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.t1;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import q4.e;
import u4.q0;
import u4.r0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f10189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f10190b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h4.c f10194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10198k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TreeMap<Long, Long> f10193f = new TreeMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f10192d = u0.B(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e5.a f10191c = new e5.a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10200b;

        public a(long j11, long j12) {
            this.f10199a = j11;
            this.f10200b = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(long j11);

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f10201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t1 f10202b = new t1();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c5.b f10203c = new c5.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f10204d = C.TIME_UNSET;

        public c(androidx.media3.exoplayer.upstream.b bVar) {
            this.f10201a = s.l(bVar);
        }

        @Override // u4.r0
        public void a(c0 c0Var, int i11, int i12) {
            this.f10201a.c(c0Var, i11);
        }

        @Override // u4.r0
        public void b(y yVar) {
            this.f10201a.b(yVar);
        }

        @Override // u4.r0
        public /* synthetic */ void c(c0 c0Var, int i11) {
            q0.b(this, c0Var, i11);
        }

        @Override // u4.r0
        public /* synthetic */ int d(l lVar, int i11, boolean z11) {
            return q0.a(this, lVar, i11, z11);
        }

        @Override // u4.r0
        public int e(l lVar, int i11, boolean z11, int i12) throws IOException {
            return this.f10201a.d(lVar, i11, z11);
        }

        @Override // u4.r0
        public void f(long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
            this.f10201a.f(j11, i11, i12, i13, aVar);
            l();
        }

        @Nullable
        public final c5.b g() {
            this.f10203c.clear();
            if (this.f10201a.T(this.f10202b, this.f10203c, 0, false) != -4) {
                return null;
            }
            this.f10203c.c();
            return this.f10203c;
        }

        public boolean h(long j11) {
            return d.this.j(j11);
        }

        public void i(e eVar) {
            long j11 = this.f10204d;
            if (j11 == C.TIME_UNSET || eVar.f74329h > j11) {
                this.f10204d = eVar.f74329h;
            }
            d.this.m(eVar);
        }

        public boolean j(e eVar) {
            long j11 = this.f10204d;
            return d.this.n(j11 != C.TIME_UNSET && j11 < eVar.f74328g);
        }

        public final void k(long j11, long j12) {
            d.this.f10192d.sendMessage(d.this.f10192d.obtainMessage(1, new a(j11, j12)));
        }

        public final void l() {
            while (this.f10201a.L(false)) {
                c5.b bVarG = g();
                if (bVarG != null) {
                    long j11 = bVarG.f9782f;
                    Metadata metadataA = d.this.f10191c.a(bVarG);
                    if (metadataA != null) {
                        EventMessage eventMessage = (EventMessage) metadataA.get(0);
                        if (d.h(eventMessage.schemeIdUri, eventMessage.value)) {
                            m(j11, eventMessage);
                        }
                    }
                }
            }
            this.f10201a.s();
        }

        public final void m(long j11, EventMessage eventMessage) {
            long jF = d.f(eventMessage);
            if (jF == C.TIME_UNSET) {
                return;
            }
            k(j11, jF);
        }

        public void n() {
            this.f10201a.U();
        }
    }

    public d(h4.c cVar, b bVar, androidx.media3.exoplayer.upstream.b bVar2) {
        this.f10194g = cVar;
        this.f10190b = bVar;
        this.f10189a = bVar2;
    }

    public static long f(EventMessage eventMessage) {
        try {
            return u0.Z0(u0.H(eventMessage.messageData));
        } catch (ParserException unused) {
            return C.TIME_UNSET;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @Nullable
    public final Map.Entry<Long, Long> e(long j11) {
        return this.f10193f.ceilingEntry(Long.valueOf(j11));
    }

    public final void g(long j11, long j12) {
        Long l11 = this.f10193f.get(Long.valueOf(j12));
        if (l11 == null) {
            this.f10193f.put(Long.valueOf(j12), Long.valueOf(j11));
        } else if (l11.longValue() > j11) {
            this.f10193f.put(Long.valueOf(j12), Long.valueOf(j11));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f10198k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f10199a, aVar.f10200b);
        return true;
    }

    public final void i() {
        if (this.f10196i) {
            this.f10197j = true;
            this.f10196i = false;
            this.f10190b.b();
        }
    }

    public boolean j(long j11) {
        h4.c cVar = this.f10194g;
        boolean z11 = false;
        if (!cVar.f66255d) {
            return false;
        }
        if (this.f10197j) {
            return true;
        }
        Map.Entry<Long, Long> entryE = e(cVar.f66259h);
        if (entryE != null && entryE.getValue().longValue() < j11) {
            this.f10195h = entryE.getKey().longValue();
            l();
            z11 = true;
        }
        if (z11) {
            i();
        }
        return z11;
    }

    public c k() {
        return new c(this.f10189a);
    }

    public final void l() {
        this.f10190b.a(this.f10195h);
    }

    public void m(e eVar) {
        this.f10196i = true;
    }

    public boolean n(boolean z11) {
        if (!this.f10194g.f66255d) {
            return false;
        }
        if (this.f10197j) {
            return true;
        }
        if (!z11) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f10198k = true;
        this.f10192d.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator<Map.Entry<Long, Long>> it = this.f10193f.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f10194g.f66259h) {
                it.remove();
            }
        }
    }

    public void q(h4.c cVar) {
        this.f10197j = false;
        this.f10195h = C.TIME_UNSET;
        this.f10194g = cVar;
        p();
    }
}
