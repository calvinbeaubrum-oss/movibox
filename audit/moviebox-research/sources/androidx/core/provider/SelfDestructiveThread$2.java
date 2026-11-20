package androidx.core.provider;

import android.os.Handler;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class SelfDestructiveThread$2 implements Runnable {
    final /* synthetic */ h this$0;
    final /* synthetic */ Callable val$callable;
    final /* synthetic */ Handler val$calleeHandler;
    final /* synthetic */ h.a val$reply;

    public SelfDestructiveThread$2(h hVar, Callable callable, Handler handler, h.a aVar) {
        this.val$callable = callable;
        this.val$calleeHandler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        final Object objCall;
        try {
            objCall = this.val$callable.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.val$calleeHandler.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread$2.1
            @Override // java.lang.Runnable
            public void run() {
                SelfDestructiveThread$2.this.getClass();
                throw null;
            }
        });
    }
}
