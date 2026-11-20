package xl;

import java.util.Iterator;
import java.util.Set;
import rj.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f80591b;

    public c(Set<f> set, d dVar) {
        this.f80590a = e(set);
        this.f80591b = dVar;
    }

    public static rj.c<i> c() {
        return rj.c.c(i.class).b(r.m(f.class)).f(new rj.h() { // from class: xl.b
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return c.d(eVar);
            }
        }).d();
    }

    public static /* synthetic */ i d(rj.e eVar) {
        return new c(eVar.c(f.class), d.a());
    }

    public static String e(Set<f> set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb2.append(next.b());
            sb2.append('/');
            sb2.append(next.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // xl.i
    public String a() {
        if (this.f80591b.b().isEmpty()) {
            return this.f80590a;
        }
        return this.f80590a + ' ' + e(this.f80591b.b());
    }
}
