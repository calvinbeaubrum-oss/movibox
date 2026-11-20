package f4;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f64568a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f64568a.post(runnable);
    }
}
