package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0373a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList<C0374a> f35381a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.e$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public static final class C0374a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Handler f35382a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final a f35383b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public boolean f35384c;

                public C0374a(Handler handler, a aVar) {
                    this.f35382a = handler;
                    this.f35383b = aVar;
                }

                public void d() {
                    this.f35384c = true;
                }
            }

            public static /* synthetic */ void d(C0374a c0374a, int i11, long j11, long j12) {
                c0374a.f35383b.onBandwidthSample(i11, j11, j12);
            }

            public void b(Handler handler, a aVar) {
                com.google.android.exoplayer2.util.a.e(handler);
                com.google.android.exoplayer2.util.a.e(aVar);
                e(aVar);
                this.f35381a.add(new C0374a(handler, aVar));
            }

            public void c(final int i11, final long j11, final long j12) {
                for (final C0374a c0374a : this.f35381a) {
                    if (!c0374a.f35384c) {
                        c0374a.f35382a.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0373a.d(c0374a, i11, j11, j12);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                for (C0374a c0374a : this.f35381a) {
                    if (c0374a.f35383b == aVar) {
                        c0374a.d();
                        this.f35381a.remove(c0374a);
                    }
                }
            }
        }

        void onBandwidthSample(int i11, long j11, long j12);
    }

    long a();

    @Nullable
    k0 b();

    void d(a aVar);

    void f(Handler handler, a aVar);

    long getBitrateEstimate();
}
