package zt;

import com.transsion.core.log.ObjectLogUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f82155d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f82156a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f82157b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjectLogUtils f82158c = new ObjectLogUtils.a().o(true).r(true).q(false).m();

    public static b b() {
        if (f82155d == null) {
            synchronized (b.class) {
                try {
                    if (f82155d == null) {
                        f82155d = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f82155d;
    }

    @Override // zt.c
    public void a(boolean z11) {
        if (z11 != this.f82156a) {
            this.f82156a = z11;
        }
    }

    public boolean c() {
        return this.f82156a;
    }

    @Override // zt.c
    public void d(String str, String str2) {
        f(2, str, str2);
    }

    @Override // zt.c
    public void e(String str, String str2) {
        f(6, str, str2);
    }

    @Override // zt.c
    public void e(String str, String str2, Throwable th2) {
        g(6, str, str2, th2);
    }

    public void f(int i11, String str, String str2) {
        g(i11, str, str2, null);
    }

    public void g(int i11, String str, String str2, Throwable th2) {
        if (c() && h(i11)) {
            if (i11 == 2) {
                this.f82158c.y(str, str2, th2);
                return;
            }
            if (i11 == 3) {
                this.f82158c.h(str, str2, th2);
                return;
            }
            if (i11 == 4) {
                this.f82158c.o(str, str2, th2);
            } else if (i11 == 5) {
                this.f82158c.A(str, str2, th2);
            } else {
                if (i11 != 6) {
                    return;
                }
                this.f82158c.j(str, str2, th2);
            }
        }
    }

    public boolean h(int i11) {
        return i11 >= this.f82157b;
    }

    @Override // zt.c
    public void v(String str, String str2) {
        f(2, str, str2);
    }
}
