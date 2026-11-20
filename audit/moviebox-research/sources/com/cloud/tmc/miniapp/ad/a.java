package com.cloud.tmc.miniapp.ad;

import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.integration.structure.App;
import ia.b;
import ia.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements ia.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdManager f31376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ App f31377b;

    public a(AdManager adManager, App app) {
        this.f31376a = adManager;
        this.f31377b = app;
    }

    @Override // ia.a
    public void a(String triggerId, AdClickBean adClickBean) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        c cVar;
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(adClickBean, "adClickBean");
        AdManager.a aVar = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar == null || (concurrentHashMap = aVar.f31331f) == null || (cVar = concurrentHashMap.get(triggerId)) == null) {
            return;
        }
        cVar.a(triggerId, adClickBean);
    }

    @Override // ia.a
    public void b(String triggerId, boolean z11) {
        ConcurrentHashMap<String, b> concurrentHashMap;
        ConcurrentHashMap<String, b> concurrentHashMap2;
        b bVar;
        Intrinsics.g(triggerId, "triggerId");
        if (!z11) {
            this.f31376a.OooO00o(triggerId, this.f31377b, "");
            return;
        }
        AdManager.a aVar = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar != null && (concurrentHashMap2 = aVar.f31330e) != null && (bVar = concurrentHashMap2.get(triggerId)) != null) {
            bVar.b(triggerId, true);
        }
        AdManager.a aVar2 = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar2 == null || (concurrentHashMap = aVar2.f31330e) == null) {
            return;
        }
        concurrentHashMap.remove(triggerId);
    }

    @Override // ia.a
    public void c(String triggerId, boolean z11, AdShowBean adShowBean) {
        jd.b bVar;
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(adShowBean, "adShowBean");
        if (!z11) {
            this.f31376a.OooO0O0(triggerId, this.f31377b, "");
            return;
        }
        AdManager.a aVar = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar != null) {
            AdManager adManager = this.f31376a;
            App app = this.f31377b;
            aVar.f31332g.add(triggerId);
            c cVar = aVar.f31331f.get(triggerId);
            if (cVar != null) {
                cVar.c(triggerId, true, adShowBean);
            }
            jd.b bVar2 = aVar.f31327b.get(triggerId);
            if (((bVar2 == null || !bVar2.f67984x) && ((bVar = aVar.f31328c.get(triggerId)) == null || !bVar.f67984x)) || adShowBean.getShowReportTimeType() != 3) {
                return;
            }
            adManager.OooO00o(triggerId, app);
        }
    }

    @Override // ia.a
    public void d(String triggerId) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        c cVar;
        Intrinsics.g(triggerId, "triggerId");
        ia.a.C0707a.b(this, triggerId);
        AdManager.a aVar = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar == null || (concurrentHashMap = aVar.f31331f) == null || (cVar = concurrentHashMap.get(triggerId)) == null) {
            return;
        }
        cVar.d(triggerId);
    }

    @Override // ia.a
    public void e(String triggerId) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        c cVar;
        Intrinsics.g(triggerId, "triggerId");
        ia.a.C0707a.c(this, triggerId);
        AdManager.a aVar = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar == null || (concurrentHashMap = aVar.f31331f) == null || (cVar = concurrentHashMap.get(triggerId)) == null) {
            return;
        }
        cVar.e(triggerId);
    }

    @Override // ia.a
    public void f(String triggerId, DownUpPointBean pointBean, String str) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        c cVar;
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(pointBean, "pointBean");
        AdManager.a aVar = (AdManager.a) this.f31376a.OooO00o.get(this.f31377b.getAppId());
        if (aVar == null || (concurrentHashMap = aVar.f31331f) == null || (cVar = concurrentHashMap.get(triggerId)) == null) {
            return;
        }
        cVar.f(triggerId, pointBean, str);
    }
}
