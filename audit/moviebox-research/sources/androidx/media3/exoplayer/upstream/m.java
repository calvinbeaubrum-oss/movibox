package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface m {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11493d;

        public a(int i11, int i12, int i13, int i14) {
            this.f11490a = i11;
            this.f11491b = i12;
            this.f11492c = i13;
            this.f11493d = i14;
        }

        public boolean a(int i11) {
            if (i11 == 1) {
                if (this.f11490a - this.f11491b <= 1) {
                    return false;
                }
            } else if (this.f11492c - this.f11493d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11495b;

        public b(int i11, long j11) {
            z3.a.a(j11 >= 0);
            this.f11494a = i11;
            this.f11495b = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p4.n f11496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p4.o f11497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IOException f11498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11499d;

        public c(p4.n nVar, p4.o oVar, IOException iOException, int i11) {
            this.f11496a = nVar;
            this.f11497b = oVar;
            this.f11498c = iOException;
            this.f11499d = i11;
        }
    }

    int a(int i11);

    void b(long j11);

    long c(c cVar);

    @Nullable
    b d(a aVar, c cVar);
}
