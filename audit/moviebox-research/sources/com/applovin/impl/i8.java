package com.applovin.impl;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i8 implements ol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c5 f19642a = new c5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final rl f19643b = new rl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Deque f19644c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19646e;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements nl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final eb f19648b;

        public a(long j11, eb ebVar) {
            this.f19647a = j11;
            this.f19648b = ebVar;
        }

        @Override // com.applovin.impl.nl
        public int a() {
            return 1;
        }

        @Override // com.applovin.impl.nl
        public int a(long j11) {
            return this.f19647a > j11 ? 0 : -1;
        }

        @Override // com.applovin.impl.nl
        public long a(int i11) {
            b1.a(i11 == 0);
            return this.f19647a;
        }

        @Override // com.applovin.impl.nl
        public List b(long j11) {
            return j11 >= this.f19647a ? this.f19648b : eb.h();
        }
    }

    public i8() {
        for (int i11 = 0; i11 < 2; i11++) {
            this.f19644c.addFirst(new fk(new zg.a() { // from class: com.applovin.impl.ny
                @Override // com.applovin.impl.zg.a
                public final void a(zg zgVar) {
                    this.f21432a.a((sl) zgVar);
                }
            }));
        }
        this.f19645d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sl slVar) {
        b1.b(this.f19644c.size() < 2);
        b1.a(!this.f19644c.contains(slVar));
        slVar.b();
        this.f19644c.addFirst(slVar);
    }

    @Override // com.applovin.impl.m5
    public void a() {
        this.f19646e = true;
    }

    @Override // com.applovin.impl.ol
    public void a(long j11) {
    }

    @Override // com.applovin.impl.m5
    public void a(rl rlVar) {
        b1.b(!this.f19646e);
        b1.b(this.f19645d == 1);
        b1.a(this.f19643b == rlVar);
        this.f19645d = 2;
    }

    @Override // com.applovin.impl.m5
    public void b() {
        b1.b(!this.f19646e);
        this.f19643b.b();
        this.f19645d = 0;
    }

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public rl d() {
        b1.b(!this.f19646e);
        if (this.f19645d != 0) {
            return null;
        }
        this.f19645d = 1;
        return this.f19643b;
    }

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public sl c() {
        b1.b(!this.f19646e);
        if (this.f19645d != 2 || this.f19644c.isEmpty()) {
            return null;
        }
        sl slVar = (sl) this.f19644c.removeFirst();
        if (this.f19643b.e()) {
            slVar.b(4);
        } else {
            rl rlVar = this.f19643b;
            slVar.a(this.f19643b.f21657f, new a(rlVar.f21657f, this.f19642a.a(((ByteBuffer) b1.a(rlVar.f21655c)).array())), 0L);
        }
        this.f19643b.b();
        this.f19645d = 0;
        return slVar;
    }
}
