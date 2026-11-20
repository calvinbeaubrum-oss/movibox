package iq;

import okhttp3.Call;
import okhttp3.EventListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g implements EventListener.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EventListener.Factory f67645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f67647c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f67651g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f67648d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f67649e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f67650f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f67652h = "All";

    public g(EventListener.Factory factory, int i11, boolean z11) {
        this.f67645a = factory;
        this.f67646b = i11;
        this.f67647c = z11;
    }

    public void a(String str) {
        this.f67651g = str;
    }

    public void b(boolean z11) {
        this.f67650f = z11;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        EventListener.Factory factory = this.f67645a;
        EventListener eventListenerCreate = factory != null ? factory.create(call) : null;
        String strHost = call.request().url().host();
        if (d.d() || d.a(strHost)) {
            o.f67667a.h("NetworkMonitor", "==== MonitorFactory host : ${host} matches ====");
            return new f(eventListenerCreate, this.f67646b, this.f67647c, this.f67652h, this.f67650f, this.f67651g, this.f67648d, this.f67649e);
        }
        o.f67667a.h("NetworkMonitor", "==== MonitorFactory host : ${host} does not matche ====");
        return eventListenerCreate == null ? EventListener.NONE : eventListenerCreate;
    }
}
