package ql;

import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f74799c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f74800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f74801b;

    public a() {
        this(null);
    }

    public a(c cVar) {
        this.f74801b = false;
        this.f74800a = cVar == null ? c.c() : cVar;
    }

    public static a e() {
        if (f74799c == null) {
            synchronized (a.class) {
                try {
                    if (f74799c == null) {
                        f74799c = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f74799c;
    }

    public void a(String str) {
        if (this.f74801b) {
            this.f74800a.a(str);
        }
    }

    public void b(String str, Object... objArr) {
        if (this.f74801b) {
            this.f74800a.a(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void c(String str) {
        if (this.f74801b) {
            this.f74800a.b(str);
        }
    }

    public void d(String str, Object... objArr) {
        if (this.f74801b) {
            this.f74800a.b(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void f(String str) {
        if (this.f74801b) {
            this.f74800a.d(str);
        }
    }

    public void g(String str, Object... objArr) {
        if (this.f74801b) {
            this.f74800a.d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public boolean h() {
        return this.f74801b;
    }

    public void i(boolean z11) {
        this.f74801b = z11;
    }

    public void j(String str) {
        if (this.f74801b) {
            this.f74800a.e(str);
        }
    }

    public void k(String str, Object... objArr) {
        if (this.f74801b) {
            this.f74800a.e(String.format(Locale.ENGLISH, str, objArr));
        }
    }
}
