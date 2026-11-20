package fl;

import cl.n;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f65109d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f65110e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f65111a = n.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f65112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f65113c;

    public static boolean c(int i11) {
        return i11 == 429 || (i11 >= 500 && i11 < 600);
    }

    public static boolean d(int i11) {
        return (i11 >= 200 && i11 < 300) || i11 == 401 || i11 == 404;
    }

    public final synchronized long a(int i11) {
        if (c(i11)) {
            return (long) Math.min(Math.pow(2.0d, this.f65113c) + this.f65111a.e(), f65110e);
        }
        return f65109d;
    }

    public synchronized boolean b() {
        return this.f65113c == 0 || this.f65111a.a() > this.f65112b;
    }

    public final synchronized void e() {
        this.f65113c = 0;
    }

    public synchronized void f(int i11) {
        if (d(i11)) {
            e();
            return;
        }
        this.f65113c++;
        this.f65112b = this.f65111a.a() + a(i11);
    }
}
