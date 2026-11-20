package i30;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f66956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f66957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object[] f66958d;

    public h(String str, String str2, o oVar, Object... objArr) {
        this.f66955a = str;
        this.f66956b = str2;
        this.f66957c = oVar;
        this.f66958d = objArr;
    }

    public o a() {
        return this.f66957c;
    }

    public Object[] b() {
        return this.f66958d;
    }

    public String c() {
        return this.f66956b;
    }

    public String d() {
        return this.f66955a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f66955a.equals(hVar.f66955a) && this.f66956b.equals(hVar.f66956b) && this.f66957c.equals(hVar.f66957c) && Arrays.equals(this.f66958d, hVar.f66958d);
    }

    public int hashCode() {
        return ((this.f66955a.hashCode() ^ Integer.rotateLeft(this.f66956b.hashCode(), 8)) ^ Integer.rotateLeft(this.f66957c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.f66958d), 24);
    }

    public String toString() {
        return this.f66955a + " : " + this.f66956b + ' ' + this.f66957c + ' ' + Arrays.toString(this.f66958d);
    }
}
