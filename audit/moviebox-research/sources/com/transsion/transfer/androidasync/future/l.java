package com.transsion.transfer.androidasync.future;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l {
    public static <T, F> f<T> c(Iterable<F> iterable, z<T, F> zVar) {
        w wVar = new w();
        e(iterable.iterator(), zVar, wVar, null);
        return wVar;
    }

    public static <T, F> f<T> d(F[] fArr, z<T, F> zVar) {
        return c(Arrays.asList(fArr), zVar);
    }

    public static <T, F> void e(final Iterator<F> it, final z<T, F> zVar, final w<T> wVar, Exception e11) {
        while (it.hasNext()) {
            try {
                f<T> fVarThen = zVar.then(it.next());
                Objects.requireNonNull(wVar);
                fVarThen.s(new x() { // from class: com.transsion.transfer.androidasync.future.j
                    @Override // com.transsion.transfer.androidasync.future.x
                    public final void a(Object obj) {
                        wVar.J(obj);
                    }
                }).i(new d() { // from class: com.transsion.transfer.androidasync.future.k
                    @Override // com.transsion.transfer.androidasync.future.d
                    public final void a(Exception exc) {
                        l.e(it, zVar, wVar, exc);
                    }
                });
                return;
            } catch (Exception e12) {
                e11 = e12;
            }
        }
        if (e11 == null) {
            wVar.G(new Exception("empty list"));
        } else {
            wVar.G(e11);
        }
    }
}
