package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e {

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: androidx.media3.exoplayer.upstream.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0105a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList<C0106a> f11449a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: androidx.media3.exoplayer.upstream.e$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public static final class C0106a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Handler f11450a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final a f11451b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public boolean f11452c;

                public C0106a(Handler handler, a aVar) {
                    this.f11450a = handler;
                    this.f11451b = aVar;
                }

                public void d() {
                    this.f11452c = true;
                }
            }

            public static /* synthetic */ void d(C0106a c0106a, int i11, long j11, long j12) {
                c0106a.f11451b.onBandwidthSample(i11, j11, j12);
            }

            public void b(Handler handler, a aVar) {
                z3.a.e(handler);
                z3.a.e(aVar);
                e(aVar);
                this.f11449a.add(new C0106a(handler, aVar));
            }

            public void c(final int i11, final long j11, final long j12) {
                for (final C0106a c0106a : this.f11449a) {
                    if (!c0106a.f11452c) {
                        c0106a.f11450a.post(new Runnable() { // from class: androidx.media3.exoplayer.upstream.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0105a.d(c0106a, i11, j11, j12);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                for (C0106a c0106a : this.f11449a) {
                    if (c0106a.f11451b == aVar) {
                        c0106a.d();
                        this.f11449a.remove(c0106a);
                    }
                }
            }
        }

        void onBandwidthSample(int i11, long j11, long j12);
    }

    long a();

    @Nullable
    c4.o b();

    void c(a aVar);

    void d(Handler handler, a aVar);

    long getBitrateEstimate();
}
