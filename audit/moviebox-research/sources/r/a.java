package r;

import hd.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f75013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f75014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f75015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f75016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f75017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f75018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f75019h;

    public a(String pagePath, String pageId, Map<String, Long> stageStartMap, Map<String, Long> stageEndMap, Map<String, Long> stageTime, boolean z11, boolean z12, boolean z13) {
        Intrinsics.g(pagePath, "pagePath");
        Intrinsics.g(pageId, "pageId");
        Intrinsics.g(stageStartMap, "stageStartMap");
        Intrinsics.g(stageEndMap, "stageEndMap");
        Intrinsics.g(stageTime, "stageTime");
        this.f75012a = pagePath;
        this.f75013b = pageId;
        this.f75014c = stageStartMap;
        this.f75015d = stageEndMap;
        this.f75016e = stageTime;
        this.f75017f = z11;
        this.f75018g = z12;
        this.f75019h = z13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f75012a, aVar.f75012a) && Intrinsics.b(this.f75013b, aVar.f75013b) && Intrinsics.b(this.f75014c, aVar.f75014c) && Intrinsics.b(this.f75015d, aVar.f75015d) && Intrinsics.b(this.f75016e, aVar.f75016e) && this.f75017f == aVar.f75017f && this.f75018g == aVar.f75018g && this.f75019h == aVar.f75019h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = (this.f75016e.hashCode() + ((this.f75015d.hashCode() + ((this.f75014c.hashCode() + ((this.f75013b.hashCode() + (this.f75012a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z11 = this.f75017f;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        boolean z12 = this.f75018g;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.f75019h;
        return i12 + (z13 ? 1 : z13);
    }

    public String toString() {
        StringBuilder sbA = j.a("PageOpenPointData(pagePath=");
        sbA.append(this.f75012a);
        sbA.append(", pageId=");
        sbA.append(this.f75013b);
        sbA.append(", stageStartMap=");
        sbA.append(this.f75014c);
        sbA.append(", stageEndMap=");
        sbA.append(this.f75015d);
        sbA.append(", stageTime=");
        sbA.append(this.f75016e);
        sbA.append(", isHomePage=");
        sbA.append(this.f75017f);
        sbA.append(", isReportFail=");
        sbA.append(this.f75018g);
        sbA.append(", isPageOpenSuccessed=");
        sbA.append(this.f75019h);
        sbA.append(')');
        return sbA.toString();
    }
}
