package x6;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<u> f80287a = new ArrayList();

    public void a(u uVar) {
        this.f80287a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f80287a.size() - 1; size >= 0; size--) {
            g7.l.b(path, this.f80287a.get(size));
        }
    }
}
