package yl;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f81524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f81525b;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f81526a = 60;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f81527b = com.google.firebase.remoteconfig.internal.b.f41079j;

        @NonNull
        public h c() {
            return new h(this);
        }

        @NonNull
        public b d(long j11) throws IllegalArgumentException {
            if (j11 < 0) {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j11)));
            }
            this.f81526a = j11;
            return this;
        }

        @NonNull
        public b e(long j11) {
            if (j11 >= 0) {
                this.f81527b = j11;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j11 + " is an invalid argument");
        }
    }

    public h(b bVar) {
        this.f81524a = bVar.f81526a;
        this.f81525b = bVar.f81527b;
    }

    public long a() {
        return this.f81524a;
    }

    public long b() {
        return this.f81525b;
    }
}
