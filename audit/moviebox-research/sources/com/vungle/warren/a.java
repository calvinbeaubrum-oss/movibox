package com.vungle.warren;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements b10.b.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f61882m = "com.vungle.warren.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Repository f61883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AdLoader f61884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y00.h f61885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f61886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Boolean> f61887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f61888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AdRequest f61889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f61890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f61891i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f61892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.vungle.warren.model.m f61893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.vungle.warren.model.c f61894l;

    public a(@NonNull AdRequest adRequest, @NonNull Map<String, Boolean> map, @Nullable q qVar, @NonNull Repository repository, @NonNull AdLoader adLoader, @NonNull y00.h hVar, @NonNull v vVar, @Nullable com.vungle.warren.model.m mVar, @Nullable com.vungle.warren.model.c cVar) {
        this.f61889g = adRequest;
        this.f61887e = map;
        this.f61888f = qVar;
        this.f61883a = repository;
        this.f61884b = adLoader;
        this.f61885c = hVar;
        this.f61886d = vVar;
        this.f61893k = mVar;
        this.f61894l = cVar;
        map.put(adRequest.getPlacementId(), Boolean.TRUE);
    }

    @Override // b10.b.a
    public void a(@NonNull String str, String str2, String str3) {
        q qVar;
        q qVar2;
        c();
        if (this.f61894l == null) {
            Log.e(f61882m, "No Advertisement for ID");
            e();
            q qVar3 = this.f61888f;
            if (qVar3 != null) {
                qVar3.onError(this.f61889g.getPlacementId(), new VungleException(10));
                VungleLogger.c("AdEventListener#PlayAdCallback", str3 + ": AD_UNABLE_TO_PLAY");
                return;
            }
            return;
        }
        d();
        if (this.f61893k == null) {
            Log.e(f61882m, "No Placement for ID");
            e();
            q qVar4 = this.f61888f;
            if (qVar4 != null) {
                qVar4.onError(this.f61889g.getPlacementId(), new VungleException(13));
                VungleLogger.c("AdEventListener#PlayAdCallback", "PLACEMENT_NOT_FOUND: " + str3);
                return;
            }
            return;
        }
        try {
            boolean z11 = false;
            if (str.equals("start")) {
                this.f61883a.k0(this.f61894l, str3, 2);
                q qVar5 = this.f61888f;
                if (qVar5 != null) {
                    qVar5.onAdStart(str3);
                    VungleLogger.b("AdEventListener#PlayAdCallback", "onAdStart: " + str3);
                }
                this.f61891i = 0;
                com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) this.f61883a.T(this.f61889g.getPlacementId(), com.vungle.warren.model.m.class).get();
                this.f61893k = mVar;
                if (mVar != null) {
                    this.f61884b.V(mVar, mVar.b(), 0L, this.f61889g.getIsExplicit());
                }
                if (this.f61886d.d()) {
                    this.f61886d.e(this.f61894l.q(), this.f61894l.o(), this.f61894l.i());
                    return;
                }
                return;
            }
            if (str.equals(TtmlNode.END)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cleaning up metadata and assets for placement ");
                sb2.append(str3);
                sb2.append(" and advertisement ");
                sb2.append(this.f61894l.v());
                this.f61883a.k0(this.f61894l, str3, 3);
                this.f61883a.o0(str3, this.f61894l.j(), 0, 1);
                this.f61885c.a(y00.k.b(false));
                e();
                q qVar6 = this.f61888f;
                if (qVar6 != null) {
                    boolean z12 = this.f61890h || this.f61891i >= 80;
                    if (str2 != null && str2.equals("isCTAClicked")) {
                        z11 = true;
                    }
                    qVar6.onAdEnd(str3, z12, z11);
                    this.f61888f.onAdEnd(str3);
                    SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.DID_CLOSE).a(SessionAttribute.EVENT_ID, this.f61894l.v()).c());
                    VungleLogger.b("AdEventListener#PlayAdCallback", "onAdEnd: " + str3);
                    return;
                }
                return;
            }
            if (str.equals("successfulView") && this.f61893k.k()) {
                this.f61890h = true;
                if (this.f61892j) {
                    return;
                }
                this.f61892j = true;
                q qVar7 = this.f61888f;
                if (qVar7 != null) {
                    qVar7.onAdRewarded(str3);
                    SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.REWARDED).a(SessionAttribute.EVENT_ID, this.f61894l.v()).c());
                    VungleLogger.b("AdEventListener#PlayAdCallback", "onAdRewarded: " + str3);
                    return;
                }
                return;
            }
            if (str.startsWith("percentViewed") && this.f61893k.k()) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length == 2) {
                    this.f61891i = Integer.parseInt(strArrSplit[1]);
                }
                if (this.f61892j || this.f61891i < 80) {
                    return;
                }
                this.f61892j = true;
                q qVar8 = this.f61888f;
                if (qVar8 != null) {
                    qVar8.onAdRewarded(str3);
                    SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.REWARDED).a(SessionAttribute.EVENT_ID, this.f61894l.v()).c());
                    VungleLogger.b("AdEventListener#PlayAdCallback", "onAdRewarded: " + str3);
                    return;
                }
                return;
            }
            if (!"open".equals(str) || this.f61888f == null) {
                if ("adViewed".equals(str) && (qVar2 = this.f61888f) != null) {
                    qVar2.onAdViewed(str3);
                    return;
                } else {
                    if (!"attach".equals(str) || (qVar = this.f61888f) == null) {
                        return;
                    }
                    qVar.creativeId(str2);
                    return;
                }
            }
            if ("adClick".equals(str2)) {
                this.f61888f.onAdClick(str3);
                VungleLogger.b("AdEventListener#PlayAdCallback", "onAdClick: " + str3);
                return;
            }
            if ("adLeftApplication".equals(str2)) {
                this.f61888f.onAdLeftApplication(str3);
                VungleLogger.b("AdEventListener#PlayAdCallback", "onAdLeftApplication: " + str3);
            }
        } catch (DatabaseHelper.DBException unused) {
            b(new VungleException(26), str3);
        }
    }

    @Override // b10.b.a
    public void b(VungleException vungleException, String str) {
        c();
        if (this.f61894l != null && vungleException.getExceptionCode() == 27) {
            this.f61884b.z(this.f61894l.v());
            return;
        }
        if (this.f61894l != null && vungleException.getExceptionCode() != 15 && vungleException.getExceptionCode() != 25 && vungleException.getExceptionCode() != 36) {
            try {
                this.f61883a.k0(this.f61894l, str, 4);
                d();
                com.vungle.warren.model.m mVar = this.f61893k;
                if (mVar != null) {
                    this.f61884b.V(mVar, mVar.b(), 0L, false);
                }
            } catch (DatabaseHelper.DBException unused) {
                vungleException = new VungleException(26);
            }
        }
        e();
        q qVar = this.f61888f;
        if (qVar != null) {
            qVar.onError(str, vungleException);
            VungleLogger.c("AdEventListener#PlayAdCallback", vungleException.getLocalizedMessage() + " :" + str);
        }
    }

    public final void c() {
        if (this.f61894l == null) {
            this.f61894l = this.f61883a.C(this.f61889g.getPlacementId(), this.f61889g.getEventId()).get();
        }
    }

    public final void d() {
        if (this.f61893k == null) {
            this.f61893k = (com.vungle.warren.model.m) this.f61883a.T(this.f61889g.getPlacementId(), com.vungle.warren.model.m.class).get();
        }
    }

    public void e() {
        this.f61887e.remove(this.f61889g.getPlacementId());
    }
}
