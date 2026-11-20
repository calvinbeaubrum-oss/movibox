package hj;

import com.google.common.base.m;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public abstract Reader a() throws IOException;

    public <T> T b(j<T> jVar) throws Throwable {
        m.p(jVar);
        f fVarA = f.a();
        try {
            T t11 = (T) d.b((Reader) fVarA.b(a()), jVar);
            fVarA.close();
            return t11;
        } catch (Throwable th2) {
            try {
                throw fVarA.c(th2);
            } catch (Throwable th3) {
                fVarA.close();
                throw th3;
            }
        }
    }
}
