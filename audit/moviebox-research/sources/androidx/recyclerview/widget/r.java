package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface r {

    /* JADX INFO: compiled from: source.java */
    public static class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12694a = 0;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.r$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0116a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final v<Long> f12695a = new v<>();

            public C0116a() {
            }

            @Override // androidx.recyclerview.widget.r.d
            public long a(long j11) {
                Long lF = this.f12695a.f(j11);
                if (lF == null) {
                    lF = Long.valueOf(a.this.b());
                    this.f12695a.l(j11, lF);
                }
                return lF.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.r
        @NonNull
        public d a() {
            return new C0116a();
        }

        public long b() {
            long j11 = this.f12694a;
            this.f12694a = 1 + j11;
            return j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f12697a = new a();

        /* JADX INFO: compiled from: source.java */
        public class a implements d {
            public a() {
            }

            @Override // androidx.recyclerview.widget.r.d
            public long a(long j11) {
                return -1L;
            }
        }

        @Override // androidx.recyclerview.widget.r
        @NonNull
        public d a() {
            return this.f12697a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f12699a = new a();

        /* JADX INFO: compiled from: source.java */
        public class a implements d {
            public a() {
            }

            @Override // androidx.recyclerview.widget.r.d
            public long a(long j11) {
                return j11;
            }
        }

        @Override // androidx.recyclerview.widget.r
        @NonNull
        public d a() {
            return this.f12699a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        long a(long j11);
    }

    @NonNull
    d a();
}
