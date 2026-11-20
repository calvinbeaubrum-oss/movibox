package sm;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rm.b f76399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rm.b f76400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rm.c f76401c;

    public b(rm.b bVar, rm.b bVar2, rm.c cVar) {
        this.f76399a = bVar;
        this.f76400b = bVar2;
        this.f76401c = cVar;
    }

    public rm.c a() {
        return this.f76401c;
    }

    public rm.b b() {
        return this.f76399a;
    }

    public rm.b c() {
        return this.f76400b;
    }

    public boolean d() {
        return this.f76400b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f76399a, bVar.f76399a) && Objects.equals(this.f76400b, bVar.f76400b) && Objects.equals(this.f76401c, bVar.f76401c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f76399a) ^ Objects.hashCode(this.f76400b)) ^ Objects.hashCode(this.f76401c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.f76399a);
        sb2.append(" , ");
        sb2.append(this.f76400b);
        sb2.append(" : ");
        rm.c cVar = this.f76401c;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
