package cl;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource<String> f14967a;

    public j(TaskCompletionSource<String> taskCompletionSource) {
        this.f14967a = taskCompletionSource;
    }

    @Override // cl.m
    public boolean a(Exception exc) {
        return false;
    }

    @Override // cl.m
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.l() && !bVar.k() && !bVar.i()) {
            return false;
        }
        this.f14967a.trySetResult(bVar.d());
        return true;
    }
}
