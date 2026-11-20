package zk;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f82056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f82057b;

    public a(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f82056a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f82057b = list;
    }

    @Override // zk.o
    public List<String> b() {
        return this.f82057b;
    }

    @Override // zk.o
    public String c() {
        return this.f82056a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f82056a.equals(oVar.c()) && this.f82057b.equals(oVar.b());
    }

    public int hashCode() {
        return ((this.f82056a.hashCode() ^ 1000003) * 1000003) ^ this.f82057b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f82056a + ", usedDates=" + this.f82057b + "}";
    }
}
