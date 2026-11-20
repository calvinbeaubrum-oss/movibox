package jk;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f68037c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nk.f f68038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jk.a f68039b;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements jk.a {
        public b() {
        }

        @Override // jk.a
        public void a() {
        }

        @Override // jk.a
        public String b() {
            return null;
        }

        @Override // jk.a
        public byte[] c() {
            return null;
        }

        @Override // jk.a
        public void d() {
        }

        @Override // jk.a
        public void e(long j11, String str) {
        }
    }

    public c(nk.f fVar) {
        this.f68038a = fVar;
        this.f68039b = f68037c;
    }

    public c(nk.f fVar, String str) {
        this(fVar);
        e(str);
    }

    public void a() {
        this.f68039b.d();
    }

    public byte[] b() {
        return this.f68039b.c();
    }

    @Nullable
    public String c() {
        return this.f68039b.b();
    }

    public final File d(String str) {
        return this.f68038a.o(str, "userlog");
    }

    public final void e(String str) {
        this.f68039b.a();
        this.f68039b = f68037c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i11) {
        this.f68039b = new f(file, i11);
    }

    public void g(long j11, String str) {
        this.f68039b.e(j11, str);
    }
}
