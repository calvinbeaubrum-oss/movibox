package gk;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d implements gk.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f65560c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bl.a<gk.a> f65561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<gk.a> f65562b = new AtomicReference<>(null);

    /* JADX INFO: compiled from: source.java */
    public static final class b implements g {
        public b() {
        }

        @Override // gk.g
        public File a() {
            return null;
        }

        @Override // gk.g
        public File b() {
            return null;
        }

        @Override // gk.g
        public File c() {
            return null;
        }

        @Override // gk.g
        public File d() {
            return null;
        }

        @Override // gk.g
        public File e() {
            return null;
        }

        @Override // gk.g
        public File f() {
            return null;
        }
    }

    public d(bl.a<gk.a> aVar) {
        this.f65561a = aVar;
        aVar.a(new bl.a.InterfaceC0146a() { // from class: gk.b
            @Override // bl.a.InterfaceC0146a
            public final void a(bl.b bVar) {
                this.f65555a.g(bVar);
            }
        });
    }

    public static /* synthetic */ void h(String str, String str2, long j11, kk.f fVar, bl.b bVar) {
        ((gk.a) bVar.get()).c(str, str2, j11, fVar);
    }

    @Override // gk.a
    @NonNull
    public g a(@NonNull String str) {
        gk.a aVar = this.f65562b.get();
        return aVar == null ? f65560c : aVar.a(str);
    }

    @Override // gk.a
    public boolean b() {
        gk.a aVar = this.f65562b.get();
        return aVar != null && aVar.b();
    }

    @Override // gk.a
    public void c(@NonNull final String str, @NonNull final String str2, final long j11, @NonNull final kk.f fVar) {
        f.f().i("Deferring native open session: " + str);
        this.f65561a.a(new bl.a.InterfaceC0146a() { // from class: gk.c
            @Override // bl.a.InterfaceC0146a
            public final void a(bl.b bVar) {
                d.h(str, str2, j11, fVar, bVar);
            }
        });
    }

    @Override // gk.a
    public boolean d(@NonNull String str) {
        gk.a aVar = this.f65562b.get();
        return aVar != null && aVar.d(str);
    }

    public final /* synthetic */ void g(bl.b bVar) {
        f.f().b("Crashlytics native component now available.");
        this.f65562b.set((gk.a) bVar.get());
    }
}
