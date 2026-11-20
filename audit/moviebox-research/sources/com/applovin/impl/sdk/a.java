package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.j8;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f22401f = TimeUnit.SECONDS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f22403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet f22404c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f22405d = new Object();

    /* JADX INFO: renamed from: com.applovin.impl.sdk.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0199a {
        void onAdExpired(j8 j8Var);
    }

    public a(j jVar) {
        this.f22402a = jVar;
        this.f22403b = jVar.J();
    }

    private void a() {
        synchronized (this.f22405d) {
            try {
                Iterator it = this.f22404c.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private b b(j8 j8Var) {
        synchronized (this.f22405d) {
            try {
                if (j8Var == null) {
                    return null;
                }
                for (b bVar : this.f22404c) {
                    if (j8Var == bVar.b()) {
                        return bVar;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void b() {
        HashSet<b> hashSet = new HashSet();
        synchronized (this.f22405d) {
            try {
                for (b bVar : this.f22404c) {
                    j8 j8VarB = bVar.b();
                    if (j8VarB == null) {
                        hashSet.add(bVar);
                    } else {
                        long timeToLiveMillis = j8VarB.getTimeToLiveMillis();
                        if (timeToLiveMillis <= 0) {
                            if (n.a()) {
                                this.f22403b.a("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + j8VarB);
                            }
                            hashSet.add(bVar);
                        } else {
                            if (n.a()) {
                                this.f22403b.a("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + j8VarB);
                            }
                            bVar.a(timeToLiveMillis);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (b bVar2 : hashSet) {
            a(bVar2);
            bVar2.d();
        }
    }

    public void a(j8 j8Var) {
        synchronized (this.f22405d) {
            try {
                b bVarB = b(j8Var);
                if (bVarB != null) {
                    if (n.a()) {
                        this.f22403b.a("AdExpirationManager", "Cancelling expiration timer for ad: " + j8Var);
                    }
                    bVarB.a();
                    a(bVarB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.f22405d) {
            try {
                this.f22404c.remove(bVar);
                if (this.f22404c.isEmpty()) {
                    AppLovinBroadcastManager.unregisterReceiver(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean a(j8 j8Var, InterfaceC0199a interfaceC0199a) {
        synchronized (this.f22405d) {
            try {
                if (b(j8Var) != null) {
                    if (n.a()) {
                        this.f22403b.a("AdExpirationManager", "Ad expiration already scheduled for ad: " + j8Var);
                    }
                    return true;
                }
                if (j8Var.getTimeToLiveMillis() <= f22401f) {
                    if (n.a()) {
                        this.f22403b.a("AdExpirationManager", "Ad has already expired: " + j8Var);
                    }
                    j8Var.setExpired();
                    return false;
                }
                if (n.a()) {
                    this.f22403b.a("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(j8Var.getTimeToLiveMillis()) + " seconds from now for " + j8Var + "...");
                }
                if (this.f22404c.isEmpty()) {
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                }
                this.f22404c.add(b.a(j8Var, interfaceC0199a, this.f22402a));
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            a();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            b();
        }
    }
}
