package com.applovin.impl.sdk;

import com.applovin.impl.go;
import com.applovin.impl.j8;
import com.applovin.impl.sj;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f22469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f22470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private go f22471d;

    private b(j8 j8Var, a.InterfaceC0199a interfaceC0199a, j jVar) {
        this.f22469b = new WeakReference(j8Var);
        this.f22470c = new WeakReference(interfaceC0199a);
        this.f22468a = jVar;
    }

    public static b a(j8 j8Var, a.InterfaceC0199a interfaceC0199a, j jVar) {
        b bVar = new b(j8Var, interfaceC0199a, jVar);
        bVar.a(j8Var.getTimeToLiveMillis());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f22468a.f().a(this);
    }

    public void a() {
        go goVar = this.f22471d;
        if (goVar != null) {
            goVar.a();
            this.f22471d = null;
        }
    }

    public void a(long j11) {
        a();
        if (((Boolean) this.f22468a.a(sj.f23022o1)).booleanValue() || !this.f22468a.f0().isApplicationPaused()) {
            this.f22471d = go.a(j11, this.f22468a, new Runnable() { // from class: com.applovin.impl.sdk.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22406a.c();
                }
            });
        }
    }

    public j8 b() {
        return (j8) this.f22469b.get();
    }

    public void d() {
        a();
        j8 j8VarB = b();
        if (j8VarB == null) {
            return;
        }
        j8VarB.setExpired();
        a.InterfaceC0199a interfaceC0199a = (a.InterfaceC0199a) this.f22470c.get();
        if (interfaceC0199a == null) {
            return;
        }
        interfaceC0199a.onAdExpired(j8VarB);
    }
}
