package ck;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o[] f14933c;

    public a(String str, String str2, o[] oVarArr) {
        this.f14931a = (String) fk.a.g(str, "Name");
        this.f14932b = str2;
        if (oVarArr != null) {
            this.f14933c = oVarArr;
        } else {
            this.f14933c = new o[0];
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14931a.equals(aVar.f14931a) && fk.e.a(this.f14932b, aVar.f14932b) && fk.e.b(this.f14933c, aVar.f14933c);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e
    public String getName() {
        return this.f14931a;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e
    public o[] getParameters() {
        return (o[]) this.f14933c.clone();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e
    public String getValue() {
        return this.f14932b;
    }

    public int hashCode() {
        int iD = fk.e.d(fk.e.d(17, this.f14931a), this.f14932b);
        for (o oVar : this.f14933c) {
            iD = fk.e.d(iD, oVar);
        }
        return iD;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14931a);
        if (this.f14932b != null) {
            sb2.append("=");
            sb2.append(this.f14932b);
        }
        for (o oVar : this.f14933c) {
            sb2.append("; ");
            sb2.append(oVar);
        }
        return sb2.toString();
    }
}
