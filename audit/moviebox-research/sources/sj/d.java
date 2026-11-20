package sj;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bl.a<nj.a> f76365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile hk.a f76366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile ik.b f76367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ik.a> f76368d;

    public d(bl.a<nj.a> aVar) {
        this(aVar, new ik.c(), new hk.f());
    }

    public d(bl.a<nj.a> aVar, @NonNull ik.b bVar, @NonNull hk.a aVar2) {
        this.f76365a = aVar;
        this.f76367c = bVar;
        this.f76368d = new ArrayList();
        this.f76366b = aVar2;
        f();
    }

    public static nj.a.InterfaceC0771a j(@NonNull nj.a aVar, @NonNull e eVar) {
        nj.a.InterfaceC0771a interfaceC0771aC = aVar.c("clx", eVar);
        if (interfaceC0771aC == null) {
            gk.f.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            interfaceC0771aC = aVar.c(AppMeasurement.CRASH_ORIGIN, eVar);
            if (interfaceC0771aC != null) {
                gk.f.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return interfaceC0771aC;
    }

    public hk.a d() {
        return new hk.a() { // from class: sj.b
            @Override // hk.a
            public final void a(String str, Bundle bundle) {
                this.f76363a.g(str, bundle);
            }
        };
    }

    public ik.b e() {
        return new ik.b() { // from class: sj.a
            @Override // ik.b
            public final void a(ik.a aVar) {
                this.f76362a.h(aVar);
            }
        };
    }

    public final void f() {
        this.f76365a.a(new bl.a.InterfaceC0146a() { // from class: sj.c
            @Override // bl.a.InterfaceC0146a
            public final void a(bl.b bVar) {
                this.f76364a.i(bVar);
            }
        });
    }

    public final /* synthetic */ void g(String str, Bundle bundle) {
        this.f76366b.a(str, bundle);
    }

    public final /* synthetic */ void h(ik.a aVar) {
        synchronized (this) {
            try {
                if (this.f76367c instanceof ik.c) {
                    this.f76368d.add(aVar);
                }
                this.f76367c.a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ void i(bl.b bVar) {
        gk.f.f().b("AnalyticsConnector now available.");
        nj.a aVar = (nj.a) bVar.get();
        hk.e eVar = new hk.e(aVar);
        e eVar2 = new e();
        if (j(aVar, eVar2) == null) {
            gk.f.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        gk.f.f().b("Registered Firebase Analytics listener.");
        hk.d dVar = new hk.d();
        hk.c cVar = new hk.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (this) {
            try {
                Iterator<ik.a> it = this.f76368d.iterator();
                while (it.hasNext()) {
                    dVar.a(it.next());
                }
                eVar2.d(dVar);
                eVar2.e(cVar);
                this.f76367c = dVar;
                this.f76366b = cVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
