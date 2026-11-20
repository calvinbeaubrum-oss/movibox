package q;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f74070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f74071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f74072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, f> f74073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f74074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f74075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f74076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f74077i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f74078j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f74079k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f74080l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f74081m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f74082n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f74083o;

    public b(String appId, String str, Map<String, Long> chainsStartMap, Map<String, Long> chainsEndMap, Map<String, f> pages, int i11, int i12, int i13, int i14, boolean z11, String h5ProgressCollectList, String isDomContentLoaded, String navigationType, String homePageRandomIdByGAId, boolean z12) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(chainsStartMap, "chainsStartMap");
        Intrinsics.g(chainsEndMap, "chainsEndMap");
        Intrinsics.g(pages, "pages");
        Intrinsics.g(h5ProgressCollectList, "h5ProgressCollectList");
        Intrinsics.g(isDomContentLoaded, "isDomContentLoaded");
        Intrinsics.g(navigationType, "navigationType");
        Intrinsics.g(homePageRandomIdByGAId, "homePageRandomIdByGAId");
        this.f74069a = appId;
        this.f74070b = str;
        this.f74071c = chainsStartMap;
        this.f74072d = chainsEndMap;
        this.f74073e = pages;
        this.f74074f = i11;
        this.f74075g = i12;
        this.f74076h = i13;
        this.f74077i = i14;
        this.f74078j = z11;
        this.f74079k = h5ProgressCollectList;
        this.f74080l = isDomContentLoaded;
        this.f74081m = navigationType;
        this.f74082n = homePageRandomIdByGAId;
        this.f74083o = z12;
    }

    public final boolean a() {
        return this.f74083o;
    }

    public final Map<String, Long> b() {
        return this.f74072d;
    }

    public final void c(boolean z11) {
        this.f74078j = z11;
    }

    public final Map<String, Long> d() {
        return this.f74071c;
    }

    public final int e() {
        return this.f74075g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f74069a, bVar.f74069a) && Intrinsics.b(this.f74070b, bVar.f74070b) && Intrinsics.b(this.f74071c, bVar.f74071c) && Intrinsics.b(this.f74072d, bVar.f74072d) && Intrinsics.b(this.f74073e, bVar.f74073e) && this.f74074f == bVar.f74074f && this.f74075g == bVar.f74075g && this.f74076h == bVar.f74076h && this.f74077i == bVar.f74077i && this.f74078j == bVar.f74078j && Intrinsics.b(this.f74079k, bVar.f74079k) && Intrinsics.b(this.f74080l, bVar.f74080l) && Intrinsics.b(this.f74081m, bVar.f74081m) && Intrinsics.b(this.f74082n, bVar.f74082n) && this.f74083o == bVar.f74083o;
    }

    public final int f() {
        return this.f74074f;
    }

    public final String g() {
        return this.f74070b;
    }

    public final String h() {
        return this.f74079k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f74069a.hashCode() * 31;
        String str = this.f74070b;
        int iHashCode2 = (this.f74077i + ((this.f74076h + ((this.f74075g + ((this.f74074f + ((this.f74073e.hashCode() + ((this.f74072d.hashCode() + ((this.f74071c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z11 = this.f74078j;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iHashCode3 = (this.f74082n.hashCode() + ((this.f74081m.hashCode() + ((this.f74080l.hashCode() + ((this.f74079k.hashCode() + ((iHashCode2 + r11) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z12 = this.f74083o;
        return iHashCode3 + (z12 ? 1 : z12);
    }

    public final String i() {
        return this.f74082n;
    }

    public final String j() {
        return this.f74081m;
    }

    public final Map<String, f> k() {
        return this.f74073e;
    }

    public final int l() {
        return this.f74077i;
    }

    public final int m() {
        return this.f74076h;
    }

    public final boolean n() {
        return this.f74078j;
    }

    public final String o() {
        return this.f74080l;
    }

    public String toString() {
        return "AppChainData(appId=" + this.f74069a + ", homePagePath=" + this.f74070b + ", chainsStartMap=" + this.f74071c + ", chainsEndMap=" + this.f74072d + ", pages=" + this.f74073e + ", downloadFrameworkMode=" + this.f74074f + ", downloadAppMode=" + this.f74075g + ", zipFrameworkMode=" + this.f74076h + ", zipAppMode=" + this.f74077i + ", isReport=" + this.f74078j + ", h5ProgressCollectList=" + this.f74079k + ", isDomContentLoaded=" + this.f74080l + ", navigationType=" + this.f74081m + ", homePageRandomIdByGAId=" + this.f74082n + ", offScreenRender=" + this.f74083o + ')';
    }
}
