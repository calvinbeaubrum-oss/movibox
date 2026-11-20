package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.ie;
import com.applovin.impl.yp;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends com.applovin.impl.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.q f20722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f20723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20724c = yp.l(com.applovin.impl.sdk.j.l());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0187a f20725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ie f20726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20729h;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0187a {
        void b(ie ieVar);
    }

    public a(com.applovin.impl.sdk.j jVar) {
        this.f20723b = jVar.J();
        this.f20722a = jVar.e();
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20723b.a("AdActivityObserver", "Cancelling...");
        }
        this.f20722a.b(this);
        this.f20725d = null;
        this.f20726e = null;
        this.f20728g = 0;
        this.f20729h = false;
    }

    public void a(ie ieVar, InterfaceC0187a interfaceC0187a) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20723b.a("AdActivityObserver", "Starting for ad " + ieVar.getAdUnitId() + "...");
        }
        a();
        this.f20725d = interfaceC0187a;
        this.f20726e = ieVar;
        this.f20722a.a(this);
    }

    public void a(boolean z11) {
        this.f20727f = z11;
    }

    @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getClass().getName().equals(this.f20724c) && (this.f20726e.w0() || this.f20727f)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20723b.a("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
            }
            if (this.f20725d != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20723b.a("AdActivityObserver", "Invoking callback...");
                }
                this.f20725d.b(this.f20726e);
            }
            a();
            return;
        }
        if (!this.f20729h) {
            this.f20729h = true;
        }
        this.f20728g++;
        if (com.applovin.impl.sdk.n.a()) {
            this.f20723b.a("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f20728g);
        }
    }

    @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f20729h) {
            this.f20728g--;
            if (com.applovin.impl.sdk.n.a()) {
                this.f20723b.a("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f20728g);
            }
            if (this.f20728g <= 0) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20723b.a("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.f20725d != null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20723b.a("AdActivityObserver", "Invoking callback...");
                    }
                    this.f20725d.b(this.f20726e);
                }
                a();
            }
        }
    }
}
