package s;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f75889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f75890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f75891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f75892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, r.a> f75893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f75894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f75895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f75896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f75897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f75898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f75899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f75900m;

    public a(String appId, String str, Map<String, Long> stageStartMap, Map<String, Long> stageEndMap, Map<String, Long> stageTime, Map<String, r.a> pages, int i11, int i12, int i13, int i14, boolean z11, boolean z12, boolean z13) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(stageStartMap, "stageStartMap");
        Intrinsics.g(stageEndMap, "stageEndMap");
        Intrinsics.g(stageTime, "stageTime");
        Intrinsics.g(pages, "pages");
        this.f75888a = appId;
        this.f75889b = str;
        this.f75890c = stageStartMap;
        this.f75891d = stageEndMap;
        this.f75892e = stageTime;
        this.f75893f = pages;
        this.f75894g = i11;
        this.f75895h = i12;
        this.f75896i = i13;
        this.f75897j = i14;
        this.f75898k = z11;
        this.f75899l = z12;
        this.f75900m = z13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f75888a, aVar.f75888a) && Intrinsics.b(this.f75889b, aVar.f75889b) && Intrinsics.b(this.f75890c, aVar.f75890c) && Intrinsics.b(this.f75891d, aVar.f75891d) && Intrinsics.b(this.f75892e, aVar.f75892e) && Intrinsics.b(this.f75893f, aVar.f75893f) && this.f75894g == aVar.f75894g && this.f75895h == aVar.f75895h && this.f75896i == aVar.f75896i && this.f75897j == aVar.f75897j && this.f75898k == aVar.f75898k && this.f75899l == aVar.f75899l && this.f75900m == aVar.f75900m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f75888a.hashCode() * 31;
        String str = this.f75889b;
        int iHashCode2 = (this.f75897j + ((this.f75896i + ((this.f75895h + ((this.f75894g + ((this.f75893f.hashCode() + ((this.f75892e.hashCode() + ((this.f75891d.hashCode() + ((this.f75890c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z11 = this.f75898k;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode2 + r11) * 31;
        boolean z12 = this.f75899l;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.f75900m;
        return i12 + (z13 ? 1 : z13);
    }

    public String toString() {
        return "AppOpenPointData(appId=" + this.f75888a + ", homePagePath=" + this.f75889b + ", stageStartMap=" + this.f75890c + ", stageEndMap=" + this.f75891d + ", stageTime=" + this.f75892e + ", pages=" + this.f75893f + ", updateAppInfoMode=" + this.f75894g + ", updateFrameworkInfoMode=" + this.f75895h + ", downloadAppMode=" + this.f75896i + ", downloadFrameworkMode=" + this.f75897j + ", isAddHomePage=" + this.f75898k + ", isReport=" + this.f75899l + ", isOpenSuccess=" + this.f75900m + ')';
    }
}
