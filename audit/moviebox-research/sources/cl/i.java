package cl;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f14965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<k> f14966b;

    public i(n nVar, TaskCompletionSource<k> taskCompletionSource) {
        this.f14965a = nVar;
        this.f14966b = taskCompletionSource;
    }

    @Override // cl.m
    public boolean a(Exception exc) {
        this.f14966b.trySetException(exc);
        return true;
    }

    @Override // cl.m
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.k() || this.f14965a.f(bVar)) {
            return false;
        }
        this.f14966b.setResult(k.a().b(bVar.b()).d(bVar.c()).c(bVar.h()).a());
        return true;
    }
}
