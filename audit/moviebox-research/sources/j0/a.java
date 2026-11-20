package j0;

import hd.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f67800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f67801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f67802c;

    public a(boolean z11, boolean z12, boolean z13) {
        this.f67800a = z11;
        this.f67801b = z12;
        this.f67802c = z13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f67800a == aVar.f67800a && this.f67801b == aVar.f67801b && this.f67802c == aVar.f67802c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z11 = this.f67800a;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.f67801b;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.f67802c;
        return i12 + (z13 ? 1 : z13);
    }

    public String toString() {
        StringBuilder sbA = j.a("AthenaReportBean(setCache=");
        sbA.append(this.f67800a);
        sbA.append(", clearCache=");
        sbA.append(this.f67801b);
        sbA.append(", isMfah=");
        sbA.append(this.f67802c);
        sbA.append(')');
        return sbA.toString();
    }
}
