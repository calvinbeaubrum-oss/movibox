package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import ph.f;
import tg.d0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f33905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f33906b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public rh.c f33910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f33911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f33912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f33914k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TreeMap<Long, Long> f33909f = new TreeMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f33908d = o0.x(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ih.a f33907c = new ih.a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f33915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33916b;

        public a(long j11, long j12) {
            this.f33915a = j11;
            this.f33916b = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(long j11);

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f33917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n1 f33918b = new n1();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final gh.d f33919c = new gh.d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f33920d = C.TIME_UNSET;

        public c(com.google.android.exoplayer2.upstream.b bVar) {
            this.f33917a = p.l(bVar);
        }

        @Override // tg.e0
        public int a(g gVar, int i11, boolean z11, int i12) throws IOException {
            return this.f33917a.b(gVar, i11, z11);
        }

        @Override // tg.e0
        public /* synthetic */ int b(g gVar, int i11, boolean z11) {
            return d0.a(this, gVar, i11, z11);
        }

        @Override // tg.e0
        public /* synthetic */ void c(c0 c0Var, int i11) {
            d0.b(this, c0Var, i11);
        }

        @Override // tg.e0
        public void d(long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
            this.f33917a.d(j11, i11, i12, i13, aVar);
            l();
        }

        @Override // tg.e0
        public void e(m1 m1Var) {
            this.f33917a.e(m1Var);
        }

        @Override // tg.e0
        public void f(c0 c0Var, int i11, int i12) {
            this.f33917a.c(c0Var, i11);
        }

        @Nullable
        public final gh.d g() {
            this.f33919c.b();
            if (this.f33917a.S(this.f33918b, this.f33919c, 0, false) != -4) {
                return null;
            }
            this.f33919c.o();
            return this.f33919c;
        }

        public boolean h(long j11) {
            return d.this.j(j11);
        }

        public void i(f fVar) {
            long j11 = this.f33920d;
            if (j11 == C.TIME_UNSET || fVar.f73813h > j11) {
                this.f33920d = fVar.f73813h;
            }
            d.this.m(fVar);
        }

        public boolean j(f fVar) {
            long j11 = this.f33920d;
            return d.this.n(j11 != C.TIME_UNSET && j11 < fVar.f73812g);
        }

        public final void k(long j11, long j12) {
            d.this.f33908d.sendMessage(d.this.f33908d.obtainMessage(1, new a(j11, j12)));
        }

        public final void l() {
            while (this.f33917a.K(false)) {
                gh.d dVarG = g();
                if (dVarG != null) {
                    long j11 = dVarG.f33032f;
                    Metadata metadataA = d.this.f33907c.a(dVarG);
                    if (metadataA != null) {
                        EventMessage eventMessage = (EventMessage) metadataA.get(0);
                        if (d.h(eventMessage.schemeIdUri, eventMessage.value)) {
                            m(j11, eventMessage);
                        }
                    }
                }
            }
            this.f33917a.s();
        }

        public final void m(long j11, EventMessage eventMessage) {
            long jF = d.f(eventMessage);
            if (jF == C.TIME_UNSET) {
                return;
            }
            k(j11, jF);
        }

        public void n() {
            this.f33917a.T();
        }
    }

    public d(rh.c cVar, b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        this.f33910g = cVar;
        this.f33906b = bVar;
        this.f33905a = bVar2;
    }

    public static long f(EventMessage eventMessage) {
        try {
            return o0.J0(o0.D(eventMessage.messageData));
        } catch (ParserException unused) {
            return C.TIME_UNSET;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @Nullable
    public final Map.Entry<Long, Long> e(long j11) {
        return this.f33909f.ceilingEntry(Long.valueOf(j11));
    }

    public final void g(long j11, long j12) {
        Long l11 = this.f33909f.get(Long.valueOf(j12));
        if (l11 == null) {
            this.f33909f.put(Long.valueOf(j12), Long.valueOf(j11));
        } else if (l11.longValue() > j11) {
            this.f33909f.put(Long.valueOf(j12), Long.valueOf(j11));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f33914k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f33915a, aVar.f33916b);
        return true;
    }

    public final void i() {
        if (this.f33912i) {
            this.f33913j = true;
            this.f33912i = false;
            this.f33906b.b();
        }
    }

    public boolean j(long j11) {
        rh.c cVar = this.f33910g;
        boolean z11 = false;
        if (!cVar.f75397d) {
            return false;
        }
        if (this.f33913j) {
            return true;
        }
        Map.Entry<Long, Long> entryE = e(cVar.f75401h);
        if (entryE != null && entryE.getValue().longValue() < j11) {
            this.f33911h = entryE.getKey().longValue();
            l();
            z11 = true;
        }
        if (z11) {
            i();
        }
        return z11;
    }

    public c k() {
        return new c(this.f33905a);
    }

    public final void l() {
        this.f33906b.a(this.f33911h);
    }

    public void m(f fVar) {
        this.f33912i = true;
    }

    public boolean n(boolean z11) {
        if (!this.f33910g.f75397d) {
            return false;
        }
        if (this.f33913j) {
            return true;
        }
        if (!z11) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f33914k = true;
        this.f33908d.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator<Map.Entry<Long, Long>> it = this.f33909f.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f33910g.f75401h) {
                it.remove();
            }
        }
    }

    public void q(rh.c cVar) {
        this.f33913j = false;
        this.f33911h = C.TIME_UNSET;
        this.f33910g = cVar;
        p();
    }
}
