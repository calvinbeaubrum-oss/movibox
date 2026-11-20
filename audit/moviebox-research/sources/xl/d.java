package xl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f80592b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<f> f80593a = new HashSet();

    public static d a() {
        d dVar = f80592b;
        if (dVar == null) {
            synchronized (d.class) {
                try {
                    dVar = f80592b;
                    if (dVar == null) {
                        dVar = new d();
                        f80592b = dVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return dVar;
    }

    public Set<f> b() {
        Set<f> setUnmodifiableSet;
        synchronized (this.f80593a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f80593a);
        }
        return setUnmodifiableSet;
    }
}
