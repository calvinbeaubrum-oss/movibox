package xl;

import android.content.Context;
import rj.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        String a(T t11);
    }

    public static rj.c<?> b(String str, String str2) {
        return rj.c.l(f.a(str, str2), f.class);
    }

    public static rj.c<?> c(final String str, final a<Context> aVar) {
        return rj.c.m(f.class).b(r.j(Context.class)).f(new rj.h() { // from class: xl.g
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return h.d(str, aVar, eVar);
            }
        }).d();
    }

    public static /* synthetic */ f d(String str, a aVar, rj.e eVar) {
        return f.a(str, aVar.a((Context) eVar.b(Context.class)));
    }
}
