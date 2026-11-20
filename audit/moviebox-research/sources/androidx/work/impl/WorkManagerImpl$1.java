package androidx.work.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class WorkManagerImpl$1 implements Runnable {
    final /* synthetic */ d0 this$0;
    final /* synthetic */ androidx.work.impl.utils.futures.a val$future;
    final /* synthetic */ androidx.work.impl.utils.o val$preferenceUtils;

    public WorkManagerImpl$1(d0 d0Var, androidx.work.impl.utils.futures.a aVar, androidx.work.impl.utils.o oVar) {
        this.this$0 = d0Var;
        this.val$future = aVar;
        this.val$preferenceUtils = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$future.t(Long.valueOf(this.val$preferenceUtils.a()));
        } catch (Throwable th2) {
            this.val$future.u(th2);
        }
    }
}
