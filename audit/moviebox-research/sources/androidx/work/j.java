package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f13567a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile j f13568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13569c = 20;

    /* JADX INFO: compiled from: source.java */
    public static class a extends j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f13570d;

        public a(int i11) {
            super(i11);
            this.f13570d = i11;
        }

        @Override // androidx.work.j
        public void a(@NonNull String str, @NonNull String str2) {
        }

        @Override // androidx.work.j
        public void b(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        }

        @Override // androidx.work.j
        public void c(@NonNull String str, @NonNull String str2) {
            if (this.f13570d <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // androidx.work.j
        public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
            if (this.f13570d <= 6) {
                Log.e(str, str2, th2);
            }
        }

        @Override // androidx.work.j
        public void f(@NonNull String str, @NonNull String str2) {
        }

        @Override // androidx.work.j
        public void g(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        }

        @Override // androidx.work.j
        public void j(@NonNull String str, @NonNull String str2) {
            if (this.f13570d <= 2) {
                Log.v(str, str2);
            }
        }

        @Override // androidx.work.j
        public void k(@NonNull String str, @NonNull String str2) {
            if (this.f13570d <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // androidx.work.j
        public void l(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
            if (this.f13570d <= 5) {
                Log.w(str, str2, th2);
            }
        }
    }

    public j(int i11) {
    }

    @NonNull
    public static j e() {
        j jVar;
        synchronized (f13567a) {
            try {
                if (f13568b == null) {
                    f13568b = new a(3);
                }
                jVar = f13568b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jVar;
    }

    public static void h(@NonNull j jVar) {
        synchronized (f13567a) {
            f13568b = jVar;
        }
    }

    @NonNull
    public static String i(@NonNull String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        int i11 = f13569c;
        if (length >= i11) {
            sb2.append(str.substring(0, i11));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public abstract void a(@NonNull String str, @NonNull String str2);

    public abstract void b(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);

    public abstract void c(@NonNull String str, @NonNull String str2);

    public abstract void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);

    public abstract void f(@NonNull String str, @NonNull String str2);

    public abstract void g(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);

    public abstract void j(@NonNull String str, @NonNull String str2);

    public abstract void k(@NonNull String str, @NonNull String str2);

    public abstract void l(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);
}
