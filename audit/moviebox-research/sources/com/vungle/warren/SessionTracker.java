package com.vungle.warren;

import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.utility.ActivityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class SessionTracker {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f61780o = "SessionTracker";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static SessionTracker f61781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f61782q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.vungle.warren.utility.v f61783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f61784b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f61786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f61787e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VungleApiClient f61791i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f61794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Repository f61795m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f61785c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.vungle.warren.model.p> f61788f = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f61789g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, com.vungle.warren.model.p> f61790h = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f61792j = 40;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtomicInteger f61793k = new AtomicInteger();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ActivityManager.e f61796n = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends ActivityManager.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f61797a;

        public a() {
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void c() {
            if (this.f61797a <= 0) {
                return;
            }
            long jA = SessionTracker.this.f61783a.a() - this.f61797a;
            if (SessionTracker.this.j() > -1 && jA > 0 && jA >= SessionTracker.this.j() * 1000 && SessionTracker.this.f61787e != null) {
                SessionTracker.this.f61787e.a();
            }
            SessionTracker.this.w(new com.vungle.warren.model.p.b().d(SessionEvent.APP_FOREGROUND).c());
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void d() {
            SessionTracker.this.w(new com.vungle.warren.model.p.b().d(SessionEvent.APP_BACKGROUND).c());
            this.f61797a = SessionTracker.this.f61783a.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();
    }

    public static SessionTracker l() {
        if (f61781p == null) {
            f61781p = new SessionTracker();
        }
        return f61781p;
    }

    public void i() {
        this.f61788f.clear();
    }

    public long j() {
        return this.f61786d;
    }

    public long k() {
        return f61782q;
    }

    public String m(int i11) {
        if (i11 == 0) {
            return "portrait";
        }
        if (i11 == 1) {
            return "landscape";
        }
        if (i11 != 2) {
            return i11 != 3 ? DevicePublicKeyStringDef.NONE : "match_video";
        }
        return "auto_rotate";
    }

    public synchronized boolean n(com.vungle.warren.model.p pVar) {
        SessionEvent sessionEvent = SessionEvent.INIT;
        SessionEvent sessionEvent2 = pVar.f62228a;
        if (sessionEvent == sessionEvent2) {
            this.f61794l++;
            return false;
        }
        if (SessionEvent.INIT_END == sessionEvent2) {
            int i11 = this.f61794l;
            if (i11 <= 0) {
                return true;
            }
            this.f61794l = i11 - 1;
            return false;
        }
        if (SessionEvent.LOAD_AD == sessionEvent2) {
            this.f61789g.add(pVar.e(SessionAttribute.PLACEMENT_ID));
            return false;
        }
        if (SessionEvent.LOAD_AD_END == sessionEvent2) {
            List<String> list = this.f61789g;
            SessionAttribute sessionAttribute = SessionAttribute.PLACEMENT_ID;
            if (!list.contains(pVar.e(sessionAttribute))) {
                return true;
            }
            this.f61789g.remove(pVar.e(sessionAttribute));
            return false;
        }
        if (SessionEvent.ADS_CACHED != sessionEvent2) {
            return false;
        }
        SessionAttribute sessionAttribute2 = SessionAttribute.VIDEO_CACHED;
        if (pVar.e(sessionAttribute2) == null) {
            this.f61790h.put(pVar.e(SessionAttribute.URL), pVar);
            return true;
        }
        Map<String, com.vungle.warren.model.p> map = this.f61790h;
        SessionAttribute sessionAttribute3 = SessionAttribute.URL;
        com.vungle.warren.model.p pVar2 = map.get(pVar.e(sessionAttribute3));
        if (pVar2 == null) {
            return !pVar.e(sessionAttribute2).equals(x00.a.f79786a);
        }
        this.f61790h.remove(pVar.e(sessionAttribute3));
        pVar.g(sessionAttribute3);
        SessionAttribute sessionAttribute4 = SessionAttribute.EVENT_ID;
        pVar.a(sessionAttribute4, pVar2.e(sessionAttribute4));
        return false;
    }

    public void o(b bVar, com.vungle.warren.utility.v vVar, final Repository repository, ExecutorService executorService, VungleApiClient vungleApiClient, final boolean z11, int i11) {
        this.f61787e = bVar;
        this.f61783a = vVar;
        this.f61784b = executorService;
        this.f61795m = repository;
        this.f61785c = z11;
        this.f61791i = vungleApiClient;
        if (i11 <= 0) {
            i11 = 40;
        }
        this.f61792j = i11;
        if (z11) {
            executorService.submit(new Runnable() { // from class: com.vungle.warren.SessionTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SessionTracker.this.f61788f.isEmpty() && z11) {
                        Iterator it = SessionTracker.this.f61788f.iterator();
                        while (it.hasNext()) {
                            SessionTracker.this.w((com.vungle.warren.model.p) it.next());
                        }
                    }
                    SessionTracker.this.f61788f.clear();
                    for (List list : com.vungle.warren.utility.m.a((List) repository.V(com.vungle.warren.model.p.class).get(), SessionTracker.this.f61792j)) {
                        if (list.size() >= SessionTracker.this.f61792j) {
                            try {
                                SessionTracker.this.q(list);
                            } catch (DatabaseHelper.DBException e11) {
                                Log.e(SessionTracker.f61780o, "Unable to retrieve data to send " + e11.getLocalizedMessage());
                            }
                        } else {
                            SessionTracker.this.f61793k.set(list.size());
                        }
                    }
                }
            });
        } else {
            i();
        }
    }

    public void p() {
        ActivityManager.p().n(this.f61796n);
    }

    public final synchronized void q(List<com.vungle.warren.model.p> list) throws DatabaseHelper.DBException {
        if (this.f61785c && !list.isEmpty()) {
            JsonArray jsonArray = new JsonArray();
            Iterator<com.vungle.warren.model.p> it = list.iterator();
            while (it.hasNext()) {
                JsonElement string = JsonParser.parseString(it.next().b());
                if (string != null && string.isJsonObject()) {
                    jsonArray.add(string.getAsJsonObject());
                }
            }
            try {
                v00.e<JsonObject> eVarExecute = this.f61791i.C(jsonArray).execute();
                for (com.vungle.warren.model.p pVar : list) {
                    if (eVarExecute.e() || pVar.d() >= this.f61792j) {
                        this.f61795m.s(pVar);
                    } else {
                        pVar.f();
                        this.f61795m.h0(pVar);
                    }
                }
            } catch (IOException e11) {
                Log.e(f61780o, "Sending session analytics failed " + e11.getLocalizedMessage());
            }
            this.f61793k.set(0);
        }
    }

    public void r(long j11) {
        this.f61786d = j11;
    }

    public void s(long j11) {
        f61782q = j11;
    }

    public final synchronized void t(final com.vungle.warren.model.p pVar) {
        ExecutorService executorService = this.f61784b;
        if (executorService == null) {
            return;
        }
        executorService.submit(new Runnable() { // from class: com.vungle.warren.SessionTracker.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SessionTracker.this.f61795m != null && pVar != null) {
                        SessionTracker.this.f61795m.h0(pVar);
                        SessionTracker.this.f61793k.incrementAndGet();
                        String unused = SessionTracker.f61780o;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Session Count: ");
                        sb2.append(SessionTracker.this.f61793k);
                        sb2.append(" ");
                        sb2.append(pVar.f62228a);
                        if (SessionTracker.this.f61793k.get() >= SessionTracker.this.f61792j) {
                            SessionTracker sessionTracker = SessionTracker.this;
                            sessionTracker.q((List) sessionTracker.f61795m.V(com.vungle.warren.model.p.class).get());
                            String unused2 = SessionTracker.f61780o;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("SendData ");
                            sb3.append(SessionTracker.this.f61793k);
                        }
                    }
                } catch (DatabaseHelper.DBException unused3) {
                    VungleLogger.c(SessionTracker.f61780o, "Could not save event to DB");
                }
            }
        });
    }

    public void u(AdConfig adConfig) {
        if (adConfig != null && adConfig.f62011c) {
            w(new com.vungle.warren.model.p.b().d(SessionEvent.MUTE).b(SessionAttribute.MUTED, (adConfig.b() & 1) == 1).c());
        }
        if (adConfig == null || !adConfig.f61700f) {
            return;
        }
        w(new com.vungle.warren.model.p.b().d(SessionEvent.ORIENTATION).a(SessionAttribute.ORIENTATION, m(adConfig.e())).c());
    }

    public void v(c cVar) {
        if (cVar == null || !cVar.f62011c) {
            return;
        }
        w(new com.vungle.warren.model.p.b().d(SessionEvent.MUTE).b(SessionAttribute.MUTED, (cVar.b() & 1) == 1).c());
    }

    public synchronized void w(com.vungle.warren.model.p pVar) {
        if (pVar == null) {
            return;
        }
        if (!this.f61785c) {
            this.f61788f.add(pVar);
        } else {
            if (!n(pVar)) {
                t(pVar);
            }
        }
    }
}
