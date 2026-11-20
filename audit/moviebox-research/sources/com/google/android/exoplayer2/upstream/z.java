package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface z {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35524d;

        public a(int i11, int i12, int i13, int i14) {
            this.f35521a = i11;
            this.f35522b = i12;
            this.f35523c = i13;
            this.f35524d = i14;
        }

        public boolean a(int i11) {
            if (i11 == 1) {
                if (this.f35521a - this.f35522b <= 1) {
                    return false;
                }
            } else if (this.f35523c - this.f35524d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35526b;

        public b(int i11, long j11) {
            com.google.android.exoplayer2.util.a.a(j11 >= 0);
            this.f35525a = i11;
            this.f35526b = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final nh.n f35527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final nh.o f35528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IOException f35529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35530d;

        public c(nh.n nVar, nh.o oVar, IOException iOException, int i11) {
            this.f35527a = nVar;
            this.f35528b = oVar;
            this.f35529c = iOException;
            this.f35530d = i11;
        }
    }

    int a(int i11);

    void b(long j11);

    long c(c cVar);

    @Nullable
    b d(a aVar, c cVar);
}
