package com.applovin.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class am extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f17735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Activity f17736i;

    public am(List list, Activity activity, com.applovin.impl.sdk.j jVar) {
        super("TaskAutoInitAdapters", jVar, true);
        this.f17735h = list;
        this.f17736i = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(pe peVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Auto-initing adapter: " + peVar);
        }
        this.f24689a.L().b(peVar, this.f17736i);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f17735h.size() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f24691c;
                String str = this.f24690b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Auto-initing ");
                sb2.append(this.f17735h.size());
                sb2.append(" adapters");
                sb2.append(this.f24689a.l0().c() ? " in test mode" : "");
                sb2.append("...");
                nVar.a(str, sb2.toString());
            }
            if (TextUtils.isEmpty(this.f24689a.O())) {
                this.f24689a.e(AppLovinMediationProvider.MAX);
            } else if (!this.f24689a.A0()) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f24689a.O());
            }
            if (this.f17736i == null) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (final pe peVar : this.f17735h) {
                if (peVar.t()) {
                    this.f24689a.j0().a(new Runnable() { // from class: com.applovin.impl.vs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f23981a.a(peVar);
                        }
                    }, tm.b.MEDIATION);
                } else {
                    this.f24689a.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24689a.J().a(this.f24690b, "Skipping eager auto-init for adapter " + peVar);
                    }
                }
            }
        }
    }
}
