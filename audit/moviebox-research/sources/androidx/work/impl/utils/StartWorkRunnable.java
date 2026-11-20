package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkerParameters;
import androidx.work.impl.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class StartWorkRunnable implements Runnable {
    private WorkerParameters.a mRuntimeExtras;
    private d0 mWorkManagerImpl;
    private androidx.work.impl.u mWorkSpecId;

    public StartWorkRunnable(@NonNull d0 d0Var, @NonNull androidx.work.impl.u uVar, @Nullable WorkerParameters.a aVar) {
        this.mWorkManagerImpl = d0Var;
        this.mWorkSpecId = uVar;
        this.mRuntimeExtras = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkManagerImpl.r().q(this.mWorkSpecId, this.mRuntimeExtras);
    }
}
