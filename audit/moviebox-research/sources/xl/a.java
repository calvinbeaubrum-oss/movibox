package xl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f80589b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f80588a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f80589b = str2;
    }

    @Override // xl.f
    public String b() {
        return this.f80588a;
    }

    @Override // xl.f
    public String c() {
        return this.f80589b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f80588a.equals(fVar.b()) && this.f80589b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.f80588a.hashCode() ^ 1000003) * 1000003) ^ this.f80589b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f80588a + ", version=" + this.f80589b + "}";
    }
}
