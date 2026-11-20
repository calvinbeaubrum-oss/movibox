package t;

import hd.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f76645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gd.b f76646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f76647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public uc.c f76648e;

    public a(String appId, ConcurrentHashMap<String, e> pages, gd.b bVar, int i11, uc.c cVar) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(pages, "pages");
        this.f76644a = appId;
        this.f76645b = pages;
        this.f76646c = bVar;
        this.f76647d = i11;
        this.f76648e = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f76644a, aVar.f76644a) && Intrinsics.b(this.f76645b, aVar.f76645b) && Intrinsics.b(this.f76646c, aVar.f76646c) && this.f76647d == aVar.f76647d && Intrinsics.b(this.f76648e, aVar.f76648e);
    }

    public int hashCode() {
        int iHashCode = (this.f76645b.hashCode() + (this.f76644a.hashCode() * 31)) * 31;
        gd.b bVar = this.f76646c;
        int iHashCode2 = (this.f76647d + ((iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31)) * 31;
        uc.c cVar = this.f76648e;
        return iHashCode2 + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbA = j.a("AppData(appId=");
        sbA.append(this.f76644a);
        sbA.append(", pages=");
        sbA.append(this.f76645b);
        sbA.append(", worker=");
        sbA.append(this.f76646c);
        sbA.append(", workerConnectionStatus=");
        sbA.append(this.f76647d);
        sbA.append(", workerSubscriber=");
        sbA.append(this.f76648e);
        sbA.append(')');
        return sbA.toString();
    }
}
