package eg;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m> f64133a;

    public c(List<m> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f64133a = list;
    }

    @Override // eg.i
    @NonNull
    public List<m> c() {
        return this.f64133a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return this.f64133a.equals(((i) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f64133a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f64133a + "}";
    }
}
