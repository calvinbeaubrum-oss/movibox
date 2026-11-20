package androidx.dynamicanimation.animation;

import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class AnimationHandler$FrameCallbackProvider14$1 implements Runnable {
    final /* synthetic */ a.d this$0;

    public AnimationHandler$FrameCallbackProvider14$1(a.d dVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.f8233b = SystemClock.uptimeMillis();
        this.this$0.f8232a.a();
    }
}
