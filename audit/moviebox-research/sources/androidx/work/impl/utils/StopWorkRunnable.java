package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.impl.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class StopWorkRunnable implements Runnable {
    private static final String TAG = androidx.work.j.i("StopWorkRunnable");
    private final boolean mStopInForeground;
    private final androidx.work.impl.u mToken;
    private final d0 mWorkManagerImpl;

    public StopWorkRunnable(@NonNull d0 d0Var, @NonNull androidx.work.impl.u uVar, boolean z11) {
        this.mWorkManagerImpl = d0Var;
        this.mToken = uVar;
        this.mStopInForeground = z11;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zT = this.mStopInForeground ? this.mWorkManagerImpl.r().t(this.mToken) : this.mWorkManagerImpl.r().u(this.mToken);
        androidx.work.j.e().a(TAG, "StopWorkRunnable for " + this.mToken.a().b() + "; Processor.stopWork = " + zT);
    }
}
