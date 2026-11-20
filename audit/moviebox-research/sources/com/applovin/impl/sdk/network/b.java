package com.applovin.impl.sdk.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.applovin.impl.gc;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f22756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f22758d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f22759f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f22760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f22761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f22762i;

    /* JADX INFO: compiled from: source.java */
    public class a implements AppLovinPostbackListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f22763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinPostbackListener f22764b;

        public a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
            this.f22763a = dVar;
            this.f22764b = appLovinPostbackListener;
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i11) {
            n unused = b.this.f22756b;
            if (n.a()) {
                b.this.f22756b.d("PersistentPostbackManager", "Failed to submit postback: " + this.f22763a + " with error code: " + i11 + "; will retry later...");
            }
            b.this.d(this.f22763a);
            gc.a(this.f22764b, str, i11);
            if (this.f22763a.c() == 1) {
                b.this.f22755a.E().a("dispatchPostback", str, i11);
            }
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            b.this.a(this.f22763a);
            n unused = b.this.f22756b;
            if (n.a()) {
                b.this.f22756b.a("PersistentPostbackManager", "Successfully submit postback: " + this.f22763a);
            }
            b.this.c();
            gc.a(this.f22764b, str);
        }
    }

    public b(j jVar) {
        ArrayList arrayList = new ArrayList();
        this.f22760g = arrayList;
        this.f22761h = new HashSet();
        this.f22762i = new ArrayList();
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f22755a = jVar;
        this.f22756b = jVar.J();
        int iIntValue = ((Integer) jVar.a(sj.Y2)).intValue();
        this.f22757c = iIntValue;
        if (!((Boolean) jVar.a(sj.f22921b3)).booleanValue()) {
            this.f22758d = null;
            return;
        }
        c cVar = new c(this, jVar);
        this.f22758d = cVar;
        if (yp.a(sj.f23014n1, jVar) && yp.h()) {
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22800a.f();
                }
            }, true, true);
        } else {
            arrayList.addAll(cVar.a(iIntValue));
        }
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        synchronized (this.f22759f) {
            this.f22761h.remove(dVar);
            this.f22760g.remove(dVar);
        }
        if (n.a()) {
            this.f22756b.a("PersistentPostbackManager", "Dequeued postback: " + dVar);
        }
    }

    private void a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        if (n.a()) {
            this.f22756b.a("PersistentPostbackManager", "Preparing to submit postback: " + dVar);
        }
        if (this.f22755a.x0() && !dVar.m()) {
            if (n.a()) {
                this.f22756b.a("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(dVar.k())) {
            if (n.a()) {
                this.f22756b.b("PersistentPostbackManager", "Skipping empty postback dispatch...");
                return;
            }
            return;
        }
        synchronized (this.f22759f) {
            try {
                if (this.f22761h.contains(dVar)) {
                    if (n.a()) {
                        this.f22756b.a("PersistentPostbackManager", "Skipping in progress postback: " + dVar.k());
                    }
                    return;
                }
                dVar.l();
                Integer num = (Integer) this.f22755a.a(sj.X2);
                if (dVar.c() > num.intValue()) {
                    if (n.a()) {
                        this.f22756b.k("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + num + ". Dequeuing postback: " + dVar);
                    }
                    a(dVar);
                    return;
                }
                synchronized (this.f22759f) {
                    this.f22761h.add(dVar);
                }
                e eVarB = e.b(this.f22755a).b(dVar.k()).a(dVar.d()).b(dVar.i()).c(dVar.h()).a(dVar.g()).a(dVar.j() != null ? new JSONObject(dVar.j()) : null).b(dVar.o()).a(dVar.n()).a(dVar.f()).h(dVar.p()).e(dVar.e()).a();
                if (n.a()) {
                    this.f22756b.a("PersistentPostbackManager", "Submitting postback: " + dVar);
                }
                this.f22755a.Y().dispatchPostbackRequest(eVarB, new a(dVar, appLovinPostbackListener));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void a(Runnable runnable, boolean z11, boolean z12) {
        if (!z11) {
            runnable.run();
        } else {
            this.f22755a.j0().a((yl) new jn(this.f22755a, z12, "runPostbackTask", runnable), tm.b.OTHER);
        }
    }

    private void b(d dVar) {
        a(dVar, (AppLovinPostbackListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        synchronized (this.f22759f) {
            c(dVar);
            a(dVar, appLovinPostbackListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f22759f) {
            try {
                Iterator it = this.f22762i.iterator();
                while (it.hasNext()) {
                    b((d) it.next());
                }
                this.f22762i.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void c(d dVar) {
        synchronized (this.f22759f) {
            while (this.f22760g.size() > this.f22757c) {
                try {
                    this.f22760g.remove(0);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f22760g.add(dVar);
        }
        if (n.a()) {
            this.f22756b.a("PersistentPostbackManager", "Enqueued postback: " + dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d dVar) {
        synchronized (this.f22759f) {
            this.f22761h.remove(dVar);
            this.f22762i.add(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        synchronized (this.f22759f) {
            try {
                Iterator it = new ArrayList(this.f22760g).iterator();
                while (it.hasNext()) {
                    b((d) it.next());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        synchronized (this.f22759f) {
            this.f22760g.addAll(0, this.f22758d.a(this.f22757c));
        }
    }

    public void a() {
        synchronized (this.f22759f) {
            this.f22760g.clear();
            this.f22762i.clear();
        }
        this.f22755a.j0().a((yl) this.f22758d, tm.b.OTHER);
    }

    public void a(d dVar, boolean z11) {
        a(dVar, z11, (AppLovinPostbackListener) null);
    }

    public void a(final d dVar, boolean z11, final AppLovinPostbackListener appLovinPostbackListener) {
        if (TextUtils.isEmpty(dVar.k())) {
            if (n.a()) {
                this.f22756b.b("PersistentPostbackManager", "Requested a postback dispatch for empty URL; nothing to do...");
            }
        } else {
            if (z11) {
                dVar.a();
            }
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22801a.b(dVar, appLovinPostbackListener);
                }
            }, yp.h(), dVar.m());
        }
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.sdk.network.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f22804a.e();
            }
        }, true, false);
    }

    public List d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f22759f) {
            try {
                if (((Boolean) this.f22755a.a(sj.f22914a3)).booleanValue()) {
                    arrayList.ensureCapacity(this.f22762i.size());
                    arrayList.addAll(this.f22762i);
                } else {
                    arrayList.ensureCapacity(this.f22760g.size());
                    arrayList.addAll(this.f22760g);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public void e(d dVar) {
        a(dVar, true);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        this.f22755a.j0().a((yl) this.f22758d, tm.b.OTHER);
    }
}
