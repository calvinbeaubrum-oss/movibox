package sm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f76402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f76403b;

    public c(List<b> list, int i11) {
        this.f76402a = new ArrayList(list);
        this.f76403b = i11;
    }

    public List<b> a() {
        return this.f76402a;
    }

    public int b() {
        return this.f76403b;
    }

    public boolean c(List<b> list) {
        return this.f76402a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f76402a.equals(((c) obj).f76402a);
        }
        return false;
    }

    public int hashCode() {
        return this.f76402a.hashCode();
    }

    public String toString() {
        return "{ " + this.f76402a + " }";
    }
}
