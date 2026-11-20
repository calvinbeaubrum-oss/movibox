package com.applovin.impl.mediation;

import com.applovin.impl.ie;
import com.applovin.impl.x1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f20865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f20866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x1 f20867d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(ie ieVar);
    }

    public c(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f20864a = jVar;
        this.f20865b = jVar.J();
        this.f20866c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ie ieVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20865b.a("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.f20866c.a(ieVar);
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20865b.a("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        x1 x1Var = this.f20867d;
        if (x1Var != null) {
            x1Var.a();
            this.f20867d = null;
        }
    }

    public void a(final ie ieVar, long j11) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20865b.a("AdHiddenCallbackTimeoutManager", "Scheduling in " + j11 + "ms...");
        }
        this.f20867d = x1.a(j11, this.f20864a, new Runnable() { // from class: com.applovin.impl.mediation.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f21107a.a(ieVar);
            }
        });
    }
}
