package t;

import hd.j;
import kotlin.jvm.internal.Intrinsics;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f76658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uc.c f76660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public uc.c f76661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f76662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.cloud.tmc.miniapp.performanceanalyse.screen.a f76663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f76664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f76665h;

    public e() {
        this(null, 0, null, null, 0, null, false, false, 255);
    }

    public e(i iVar, int i11, uc.c cVar, uc.c cVar2, int i12, com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar, boolean z11, boolean z12) {
        this.f76658a = iVar;
        this.f76659b = i11;
        this.f76660c = cVar;
        this.f76661d = cVar2;
        this.f76662e = i12;
        this.f76663f = aVar;
        this.f76664g = z11;
        this.f76665h = z12;
    }

    public /* synthetic */ e(i iVar, int i11, uc.c cVar, uc.c cVar2, int i12, com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar, boolean z11, boolean z12, int i13) {
        this(null, (i13 & 2) != 0 ? 0 : i11, null, null, (i13 & 16) != 0 ? 0 : i12, null, (i13 & 64) != 0 ? false : z11, (i13 & 128) != 0 ? false : z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.b(this.f76658a, eVar.f76658a) && this.f76659b == eVar.f76659b && Intrinsics.b(this.f76660c, eVar.f76660c) && Intrinsics.b(this.f76661d, eVar.f76661d) && this.f76662e == eVar.f76662e && Intrinsics.b(this.f76663f, eVar.f76663f) && this.f76664g == eVar.f76664g && this.f76665h == eVar.f76665h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        i iVar = this.f76658a;
        int iHashCode = (this.f76659b + ((iVar == null ? 0 : iVar.hashCode()) * 31)) * 31;
        uc.c cVar = this.f76660c;
        int iHashCode2 = (iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31;
        uc.c cVar2 = this.f76661d;
        int iHashCode3 = (this.f76662e + ((iHashCode2 + (cVar2 == null ? 0 : cVar2.hashCode())) * 31)) * 31;
        com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar = this.f76663f;
        int iHashCode4 = (iHashCode3 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        boolean z11 = this.f76664g;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode4 + r11) * 31;
        boolean z12 = this.f76665h;
        return i11 + (z12 ? 1 : z12);
    }

    public String toString() {
        StringBuilder sbA = j.a("PageData(render=");
        sbA.append(this.f76658a);
        sbA.append(", renderConnectionStatus=");
        sbA.append(this.f76659b);
        sbA.append(", renderSubscriber=");
        sbA.append(this.f76660c);
        sbA.append(", checkWhiteScreenSubscriber=");
        sbA.append(this.f76661d);
        sbA.append(", renderStatus=");
        sbA.append(this.f76662e);
        sbA.append(", timeCountTask=");
        sbA.append(this.f76663f);
        sbA.append(", checkFinished=");
        sbA.append(this.f76664g);
        sbA.append(", onPageReady=");
        sbA.append(this.f76665h);
        sbA.append(')');
        return sbA.toString();
    }
}
