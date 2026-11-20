package rl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ql.a f75612b = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.firebase.perf.v1.c f75613a;

    public a(com.google.firebase.perf.v1.c cVar) {
        this.f75613a = cVar;
    }

    @Override // rl.e
    public boolean c() {
        if (g()) {
            return true;
        }
        f75612b.j("ApplicationInfo is invalid");
        return false;
    }

    public final boolean g() {
        com.google.firebase.perf.v1.c cVar = this.f75613a;
        if (cVar == null) {
            f75612b.j("ApplicationInfo is null");
            return false;
        }
        if (!cVar.c0()) {
            f75612b.j("GoogleAppId is null");
            return false;
        }
        if (!this.f75613a.a0()) {
            f75612b.j("AppInstanceId is null");
            return false;
        }
        if (!this.f75613a.b0()) {
            f75612b.j("ApplicationProcessState is null");
            return false;
        }
        if (!this.f75613a.Z()) {
            return true;
        }
        if (!this.f75613a.W().V()) {
            f75612b.j("AndroidAppInfo.packageName is null");
            return false;
        }
        if (this.f75613a.W().W()) {
            return true;
        }
        f75612b.j("AndroidAppInfo.sdkVersion is null");
        return false;
    }
}
