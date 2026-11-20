package pl;

import androidx.annotation.NonNull;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.e f73881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cl.g f73882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bl.b<m> f73883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bl.b<cg.h> f73884d;

    public a(@NonNull jj.e eVar, @NonNull cl.g gVar, @NonNull bl.b<m> bVar, @NonNull bl.b<cg.h> bVar2) {
        this.f73881a = eVar;
        this.f73882b = gVar;
        this.f73883c = bVar;
        this.f73884d = bVar2;
    }

    public nl.a a() {
        return nl.a.g();
    }

    public jj.e b() {
        return this.f73881a;
    }

    public cl.g c() {
        return this.f73882b;
    }

    public bl.b<m> d() {
        return this.f73883c;
    }

    public RemoteConfigManager e() {
        return RemoteConfigManager.getInstance();
    }

    public SessionManager f() {
        return SessionManager.getInstance();
    }

    public bl.b<cg.h> g() {
        return this.f73884d;
    }
}
