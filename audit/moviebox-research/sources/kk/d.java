package kk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f68632c;

    public d(String str, String str2, boolean z11) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f68630a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f68631b = str2;
        this.f68632c = z11;
    }

    @Override // kk.f.c
    public boolean b() {
        return this.f68632c;
    }

    @Override // kk.f.c
    public String c() {
        return this.f68631b;
    }

    @Override // kk.f.c
    public String d() {
        return this.f68630a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.c)) {
            return false;
        }
        f.c cVar = (f.c) obj;
        return this.f68630a.equals(cVar.d()) && this.f68631b.equals(cVar.c()) && this.f68632c == cVar.b();
    }

    public int hashCode() {
        return ((((this.f68630a.hashCode() ^ 1000003) * 1000003) ^ this.f68631b.hashCode()) * 1000003) ^ (this.f68632c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f68630a + ", osCodeName=" + this.f68631b + ", isRooted=" + this.f68632c + "}";
    }
}
