package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final b.c f13572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final b.C0128b f13573b;

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {

        /* JADX INFO: compiled from: source.java */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f13574a;

            public a(@NonNull Throwable th2) {
                this.f13574a = th2;
            }

            @NonNull
            public Throwable a() {
                return this.f13574a;
            }

            @NonNull
            public String toString() {
                return "FAILURE (" + this.f13574a.getMessage() + ")";
            }
        }

        /* JADX INFO: renamed from: androidx.work.l$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0128b extends b {
            public C0128b() {
            }

            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class c extends b {
            public c() {
            }

            @NonNull
            public String toString() {
                return "SUCCESS";
            }
        }
    }

    static {
        f13572a = new b.c();
        f13573b = new b.C0128b();
    }
}
