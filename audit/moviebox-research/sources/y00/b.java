package y00;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.vungle.warren.AdConfig;
import com.vungle.warren.AdLoader;
import com.vungle.warren.AdRequest;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.m;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f81028d = "y00.b";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f81029e = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VungleApiClient f81030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Repository f81031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AdLoader f81032c;

    public b(@NonNull VungleApiClient vungleApiClient, @NonNull Repository repository, AdLoader adLoader) {
        this.f81030a = vungleApiClient;
        this.f81031b = repository;
        this.f81032c = adLoader;
    }

    public static g c() {
        return new g(f81028d).m(0).p(true);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        Repository repository;
        String str = f81028d;
        if (this.f81030a == null || (repository = this.f81031b) == null) {
            Log.e(str, "CacheBustJob finished - no client or repository");
            return 1;
        }
        try {
            com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) repository.T("cacheBustSettings", com.vungle.warren.model.j.class).get();
            if (jVar == null) {
                jVar = new com.vungle.warren.model.j("cacheBustSettings");
            }
            com.vungle.warren.model.j jVar2 = jVar;
            v00.e<JsonObject> eVarExecute = this.f81030a.e(jVar2.c("last_cache_bust").longValue()).execute();
            List<com.vungle.warren.model.h> arrayList = new ArrayList<>();
            List<com.vungle.warren.model.h> listO = this.f81031b.O();
            if (listO != null && !listO.isEmpty()) {
                arrayList.addAll(listO);
            }
            Gson gson = new Gson();
            if (eVarExecute.e()) {
                JsonObject jsonObjectA = eVarExecute.a();
                if (jsonObjectA != null && jsonObjectA.has("cache_bust")) {
                    JsonObject asJsonObject = jsonObjectA.getAsJsonObject("cache_bust");
                    if (asJsonObject.has("last_updated") && asJsonObject.get("last_updated").getAsLong() > 0) {
                        jVar2.e("last_cache_bust", Long.valueOf(asJsonObject.get("last_updated").getAsLong()));
                        this.f81031b.h0(jVar2);
                    }
                    d(asJsonObject, "campaign_ids", 1, "cannot save campaignBust=", arrayList, gson);
                    d(asJsonObject, "creative_ids", 2, "cannot save creativeBust=", arrayList, gson);
                }
                Log.e(str, "CacheBustJob finished - no jsonObject or cache_bust in it");
                return 1;
            }
            e(arrayList);
            h(bundle, jVar2);
            f();
            return 2;
        } catch (DatabaseHelper.DBException e11) {
            Log.e(f81028d, "CacheBustJob failed - DBException", e11);
            return 2;
        } catch (IOException e12) {
            Log.e(f81028d, "CacheBustJob failed - IOException", e12);
            return 2;
        }
    }

    public final void b(com.vungle.warren.model.c cVar, com.vungle.warren.model.h hVar) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bustAd: deleting ");
            sb2.append(cVar.v());
            this.f81032c.z(cVar.v());
            this.f81031b.u(cVar.v());
            Repository repository = this.f81031b;
            m mVar = (m) repository.T(repository.N(cVar), m.class).get();
            if (mVar != null) {
                new AdConfig().c(mVar.b());
                if (mVar.l()) {
                    this.f81032c.V(mVar, mVar.b(), 0L, false);
                } else if (mVar.i()) {
                    this.f81032c.S(new AdLoader.c(new AdRequest(mVar.d(), false), mVar.b(), 0L, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, 5, 1, 0, false, mVar.c(), new com.vungle.warren.m[0]));
                }
            }
            hVar.j(System.currentTimeMillis());
            this.f81031b.h0(hVar);
        } catch (DatabaseHelper.DBException e11) {
            Log.e(f81028d, "bustAd: cannot drop cache or delete advertisement for " + cVar, e11);
        }
    }

    public final void d(JsonObject jsonObject, String str, int i11, String str2, List<com.vungle.warren.model.h> list, Gson gson) {
        if (jsonObject.has(str)) {
            Iterator<JsonElement> it = jsonObject.getAsJsonArray(str).iterator();
            while (it.hasNext()) {
                com.vungle.warren.model.h hVar = (com.vungle.warren.model.h) gson.fromJson(it.next(), com.vungle.warren.model.h.class);
                hVar.i(hVar.e() * 1000);
                hVar.h(i11);
                list.add(hVar);
                try {
                    this.f81031b.h0(hVar);
                } catch (DatabaseHelper.DBException unused) {
                    VungleLogger.c(b.class.getSimpleName() + "#onRunJob", str2 + hVar);
                }
            }
        }
    }

    public final void e(Iterable<com.vungle.warren.model.h> iterable) {
        for (com.vungle.warren.model.h hVar : iterable) {
            List<com.vungle.warren.model.c> listG = hVar.d() == 1 ? this.f81031b.G(hVar.c()) : this.f81031b.I(hVar.c());
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (com.vungle.warren.model.c cVar : listG) {
                if (cVar.B() < hVar.e() && g(cVar)) {
                    linkedList.add(cVar.v());
                    linkedList2.add(cVar);
                }
            }
            if (linkedList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("processBust: bust has no relevant ads, deleting ");
                sb2.append(hVar);
                try {
                    this.f81031b.s(hVar);
                } catch (DatabaseHelper.DBException e11) {
                    VungleLogger.c(b.class.getSimpleName() + "#processBust", "Cannot delete obsolete bust " + hVar + " because of " + e11);
                }
            } else {
                hVar.g((String[]) linkedList.toArray(f81029e));
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    b((com.vungle.warren.model.c) it.next(), hVar);
                }
            }
        }
    }

    public final void f() {
        List<com.vungle.warren.model.h> list = (List) this.f81031b.V(com.vungle.warren.model.h.class).get();
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.vungle.warren.model.h hVar : list) {
            if (hVar.f() != 0) {
                linkedList.add(hVar);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        try {
            v00.e<JsonObject> eVarExecute = this.f81030a.A(linkedList).execute();
            if (!eVarExecute.e()) {
                Log.e(f81028d, "sendAnalytics: not successful, aborting, response is " + eVarExecute);
                return;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                try {
                    this.f81031b.s((com.vungle.warren.model.h) it.next());
                } catch (DatabaseHelper.DBException unused) {
                    VungleLogger.c(com.vungle.warren.g.class.getSimpleName() + "#sendAnalytics", "can't delete bust \" + cacheBust");
                }
            }
        } catch (IOException e11) {
            Log.e(f81028d, "sendAnalytics: can't execute API call", e11);
        }
    }

    public final boolean g(com.vungle.warren.model.c cVar) {
        return (cVar.D() == 2 || cVar.D() == 3) ? false : true;
    }

    public void h(Bundle bundle, com.vungle.warren.model.j jVar) throws DatabaseHelper.DBException {
        long j11 = bundle.getLong("cache_bust_interval");
        if (j11 != 0) {
            jVar.e("next_cache_bust", Long.valueOf(SystemClock.elapsedRealtime() + j11));
        }
        this.f81031b.h0(jVar);
    }
}
