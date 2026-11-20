package com.applovin.impl;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ce {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final be.a f18181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f18182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f18183d;

        /* JADX INFO: renamed from: com.applovin.impl.ce$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0180a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f18184a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public ce f18185b;

            public C0180a(Handler handler, ce ceVar) {
                this.f18184a = handler;
                this.f18185b = ceVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i11, be.a aVar, long j11) {
            this.f18182c = copyOnWriteArrayList;
            this.f18180a = i11;
            this.f18181b = aVar;
            this.f18183d = j11;
        }

        private long a(long j11) {
            long jB = t2.b(j11);
            return jB == C.TIME_UNSET ? C.TIME_UNSET : this.f18183d + jB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ce ceVar, nc ncVar, ud udVar) {
            ceVar.a(this.f18180a, this.f18181b, ncVar, udVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ce ceVar, nc ncVar, ud udVar, IOException iOException, boolean z11) {
            ceVar.a(this.f18180a, this.f18181b, ncVar, udVar, iOException, z11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ce ceVar, ud udVar) {
            ceVar.a(this.f18180a, this.f18181b, udVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ce ceVar, nc ncVar, ud udVar) {
            ceVar.c(this.f18180a, this.f18181b, ncVar, udVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(ce ceVar, nc ncVar, ud udVar) {
            ceVar.b(this.f18180a, this.f18181b, ncVar, udVar);
        }

        public a a(int i11, be.a aVar, long j11) {
            return new a(this.f18182c, i11, aVar, j11);
        }

        public void a(int i11, f9 f9Var, int i12, Object obj, long j11) {
            a(new ud(1, i11, f9Var, i12, obj, a(j11), C.TIME_UNSET));
        }

        public void a(Handler handler, ce ceVar) {
            b1.a(handler);
            b1.a(ceVar);
            this.f18182c.add(new C0180a(handler, ceVar));
        }

        public void a(ce ceVar) {
            for (C0180a c0180a : this.f18182c) {
                if (c0180a.f18185b == ceVar) {
                    this.f18182c.remove(c0180a);
                }
            }
        }

        public void a(nc ncVar, int i11, int i12, f9 f9Var, int i13, Object obj, long j11, long j12) {
            a(ncVar, new ud(i11, i12, f9Var, i13, obj, a(j11), a(j12)));
        }

        public void a(nc ncVar, int i11, int i12, f9 f9Var, int i13, Object obj, long j11, long j12, IOException iOException, boolean z11) {
            a(ncVar, new ud(i11, i12, f9Var, i13, obj, a(j11), a(j12)), iOException, z11);
        }

        public void a(final nc ncVar, final ud udVar) {
            for (C0180a c0180a : this.f18182c) {
                final ce ceVar = c0180a.f18185b;
                xp.a(c0180a.f18184a, new Runnable() { // from class: com.applovin.impl.pu
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21852a.a(ceVar, ncVar, udVar);
                    }
                });
            }
        }

        public void a(final nc ncVar, final ud udVar, final IOException iOException, final boolean z11) {
            for (C0180a c0180a : this.f18182c) {
                final ce ceVar = c0180a.f18185b;
                xp.a(c0180a.f18184a, new Runnable() { // from class: com.applovin.impl.ru
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22194a.a(ceVar, ncVar, udVar, iOException, z11);
                    }
                });
            }
        }

        public void a(final ud udVar) {
            for (C0180a c0180a : this.f18182c) {
                final ce ceVar = c0180a.f18185b;
                xp.a(c0180a.f18184a, new Runnable() { // from class: com.applovin.impl.su
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23135a.a(ceVar, udVar);
                    }
                });
            }
        }

        public void b(nc ncVar, int i11, int i12, f9 f9Var, int i13, Object obj, long j11, long j12) {
            b(ncVar, new ud(i11, i12, f9Var, i13, obj, a(j11), a(j12)));
        }

        public void b(final nc ncVar, final ud udVar) {
            for (C0180a c0180a : this.f18182c) {
                final ce ceVar = c0180a.f18185b;
                xp.a(c0180a.f18184a, new Runnable() { // from class: com.applovin.impl.tu
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23428a.b(ceVar, ncVar, udVar);
                    }
                });
            }
        }

        public void c(nc ncVar, int i11, int i12, f9 f9Var, int i13, Object obj, long j11, long j12) {
            c(ncVar, new ud(i11, i12, f9Var, i13, obj, a(j11), a(j12)));
        }

        public void c(final nc ncVar, final ud udVar) {
            for (C0180a c0180a : this.f18182c) {
                final ce ceVar = c0180a.f18185b;
                xp.a(c0180a.f18184a, new Runnable() { // from class: com.applovin.impl.qu
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21987a.c(ceVar, ncVar, udVar);
                    }
                });
            }
        }
    }

    void a(int i11, be.a aVar, nc ncVar, ud udVar);

    void a(int i11, be.a aVar, nc ncVar, ud udVar, IOException iOException, boolean z11);

    void a(int i11, be.a aVar, ud udVar);

    void b(int i11, be.a aVar, nc ncVar, ud udVar);

    void c(int i11, be.a aVar, nc ncVar, ud udVar);
}
