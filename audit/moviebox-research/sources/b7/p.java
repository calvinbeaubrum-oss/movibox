package b7;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p<V, O> implements o<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h7.a<V>> f14060a;

    public p(List<h7.a<V>> list) {
        this.f14060a = list;
    }

    @Override // b7.o
    public List<h7.a<V>> b() {
        return this.f14060a;
    }

    @Override // b7.o
    public boolean c() {
        if (this.f14060a.isEmpty()) {
            return true;
        }
        return this.f14060a.size() == 1 && this.f14060a.get(0).i();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f14060a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f14060a.toArray()));
        }
        return sb2.toString();
    }
}
