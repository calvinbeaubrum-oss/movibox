package com.applovin.impl;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface y1 {

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: com.applovin.impl.y1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0205a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList f24452a = new CopyOnWriteArrayList();

            /* JADX INFO: renamed from: com.applovin.impl.y1$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public static final class C0206a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Handler f24453a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final a f24454b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private boolean f24455c;

                public C0206a(Handler handler, a aVar) {
                    this.f24453a = handler;
                    this.f24454b = aVar;
                }

                public void a() {
                    this.f24455c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void a(C0206a c0206a, int i11, long j11, long j12) {
                c0206a.f24454b.a(i11, j11, j12);
            }

            public void a(final int i11, final long j11, final long j12) {
                for (final C0206a c0206a : this.f24452a) {
                    if (!c0206a.f24455c) {
                        c0206a.f24453a.post(new Runnable() { // from class: com.applovin.impl.l90
                            @Override // java.lang.Runnable
                            public final void run() {
                                y1.a.C0205a.a(c0206a, i11, j11, j12);
                            }
                        });
                    }
                }
            }

            public void a(Handler handler, a aVar) {
                b1.a(handler);
                b1.a(aVar);
                a(aVar);
                this.f24452a.add(new C0206a(handler, aVar));
            }

            public void a(a aVar) {
                for (C0206a c0206a : this.f24452a) {
                    if (c0206a.f24454b == aVar) {
                        c0206a.a();
                        this.f24452a.remove(c0206a);
                    }
                }
            }
        }

        void a(int i11, long j11, long j12);
    }

    xo a();

    void a(Handler handler, a aVar);

    void a(a aVar);
}
