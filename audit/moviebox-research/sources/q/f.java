package q;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f74085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f74086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f74087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f74088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f74089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f74090g;

    public f(String pagePath, String renderId, Map<String, Long> chainsStartMap, Map<String, Long> chainsEndMap, String h5ProgressCollectList, String isDomContentLoaded, String navigationType) {
        Intrinsics.g(pagePath, "pagePath");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(chainsStartMap, "chainsStartMap");
        Intrinsics.g(chainsEndMap, "chainsEndMap");
        Intrinsics.g(h5ProgressCollectList, "h5ProgressCollectList");
        Intrinsics.g(isDomContentLoaded, "isDomContentLoaded");
        Intrinsics.g(navigationType, "navigationType");
        this.f74084a = pagePath;
        this.f74085b = renderId;
        this.f74086c = chainsStartMap;
        this.f74087d = chainsEndMap;
        this.f74088e = h5ProgressCollectList;
        this.f74089f = isDomContentLoaded;
        this.f74090g = navigationType;
    }

    public final Map<String, Long> a() {
        return this.f74087d;
    }

    public final Map<String, Long> b() {
        return this.f74086c;
    }

    public final String c() {
        return this.f74088e;
    }

    public final String d() {
        return this.f74090g;
    }

    public final String e() {
        return this.f74089f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.b(this.f74084a, fVar.f74084a) && Intrinsics.b(this.f74085b, fVar.f74085b) && Intrinsics.b(this.f74086c, fVar.f74086c) && Intrinsics.b(this.f74087d, fVar.f74087d) && Intrinsics.b(this.f74088e, fVar.f74088e) && Intrinsics.b(this.f74089f, fVar.f74089f) && Intrinsics.b(this.f74090g, fVar.f74090g);
    }

    public final String f() {
        return this.f74085b;
    }

    public int hashCode() {
        return this.f74090g.hashCode() + ((this.f74089f.hashCode() + ((this.f74088e.hashCode() + ((this.f74087d.hashCode() + ((this.f74086c.hashCode() + ((this.f74085b.hashCode() + (this.f74084a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbA = hd.j.a("PageChainData(pagePath=");
        sbA.append(this.f74084a);
        sbA.append(", renderId=");
        sbA.append(this.f74085b);
        sbA.append(", chainsStartMap=");
        sbA.append(this.f74086c);
        sbA.append(", chainsEndMap=");
        sbA.append(this.f74087d);
        sbA.append(", h5ProgressCollectList=");
        sbA.append(this.f74088e);
        sbA.append(", isDomContentLoaded=");
        sbA.append(this.f74089f);
        sbA.append(", navigationType=");
        sbA.append(this.f74090g);
        sbA.append(')');
        return sbA.toString();
    }
}
