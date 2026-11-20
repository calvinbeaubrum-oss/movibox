package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f67003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f67004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f67005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f67006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f67007e;

    public o(int i11, String str, String str2, String str3, boolean z11) {
        this.f67003a = i11;
        this.f67004b = str;
        this.f67005c = str2;
        this.f67006d = str3;
        this.f67007e = z11;
    }

    public String a() {
        return this.f67006d;
    }

    public String b() {
        return this.f67005c;
    }

    public String c() {
        return this.f67004b;
    }

    public int d() {
        return this.f67003a;
    }

    public boolean e() {
        return this.f67007e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f67003a == oVar.f67003a && this.f67007e == oVar.f67007e && this.f67004b.equals(oVar.f67004b) && this.f67005c.equals(oVar.f67005c) && this.f67006d.equals(oVar.f67006d);
    }

    public int hashCode() {
        return this.f67003a + (this.f67007e ? 64 : 0) + (this.f67004b.hashCode() * this.f67005c.hashCode() * this.f67006d.hashCode());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f67004b);
        sb2.append('.');
        sb2.append(this.f67005c);
        sb2.append(this.f67006d);
        sb2.append(" (");
        sb2.append(this.f67003a);
        sb2.append(this.f67007e ? " itf" : "");
        sb2.append(')');
        return sb2.toString();
    }
}
