package com.applovin.impl;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class a3 implements ol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque f17422a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f17423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityQueue f17424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f17425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17427f;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends rl implements Comparable {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f17428k;

        private b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (e() != bVar.e()) {
                return e() ? 1 : -1;
            }
            long j11 = this.f21657f - bVar.f21657f;
            if (j11 == 0) {
                j11 = this.f17428k - bVar.f17428k;
                if (j11 == 0) {
                    return 0;
                }
            }
            return j11 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends sl {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private zg.a f17429g;

        public c(zg.a aVar) {
            this.f17429g = aVar;
        }

        @Override // com.applovin.impl.zg
        public final void g() {
            this.f17429g.a(this);
        }
    }

    public a3() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.f17422a.add(new b());
        }
        this.f17423b = new ArrayDeque();
        for (int i12 = 0; i12 < 2; i12++) {
            this.f17423b.add(new c(new zg.a() { // from class: com.applovin.impl.is
                @Override // com.applovin.impl.zg.a
                public final void a(zg zgVar) {
                    this.f19772a.a((sl) zgVar);
                }
            }));
        }
        this.f17424c = new PriorityQueue();
    }

    private void a(b bVar) {
        bVar.b();
        this.f17422a.add(bVar);
    }

    @Override // com.applovin.impl.m5
    public void a() {
    }

    @Override // com.applovin.impl.ol
    public void a(long j11) {
        this.f17426e = j11;
    }

    public abstract void a(rl rlVar);

    public void a(sl slVar) {
        slVar.b();
        this.f17423b.add(slVar);
    }

    @Override // com.applovin.impl.m5
    public void b() {
        this.f17427f = 0L;
        this.f17426e = 0L;
        while (!this.f17424c.isEmpty()) {
            a((b) xp.a((b) this.f17424c.poll()));
        }
        b bVar = this.f17425d;
        if (bVar != null) {
            a(bVar);
            this.f17425d = null;
        }
    }

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(rl rlVar) {
        b1.a(rlVar == this.f17425d);
        b bVar = (b) rlVar;
        if (bVar.d()) {
            a(bVar);
        } else {
            long j11 = this.f17427f;
            this.f17427f = 1 + j11;
            bVar.f17428k = j11;
            this.f17424c.add(bVar);
        }
        this.f17425d = null;
    }

    public abstract nl e();

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public rl d() {
        b1.b(this.f17425d == null);
        if (this.f17422a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.f17422a.pollFirst();
        this.f17425d = bVar;
        return bVar;
    }

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public sl c() {
        if (this.f17423b.isEmpty()) {
            return null;
        }
        while (!this.f17424c.isEmpty() && ((b) xp.a((b) this.f17424c.peek())).f21657f <= this.f17426e) {
            b bVar = (b) xp.a((b) this.f17424c.poll());
            if (bVar.e()) {
                sl slVar = (sl) xp.a((sl) this.f17423b.pollFirst());
                slVar.b(4);
                a(bVar);
                return slVar;
            }
            a((rl) bVar);
            if (j()) {
                nl nlVarE = e();
                sl slVar2 = (sl) xp.a((sl) this.f17423b.pollFirst());
                slVar2.a(bVar.f21657f, nlVarE, Long.MAX_VALUE);
                a(bVar);
                return slVar2;
            }
            a(bVar);
        }
        return null;
    }

    public final sl h() {
        return (sl) this.f17423b.pollFirst();
    }

    public final long i() {
        return this.f17426e;
    }

    public abstract boolean j();
}
