package com.mbridge.msdk.foundation.same.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public static long f44498id;
    public InterfaceC0489a mListener;
    public b mState = b.READY;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.same.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0489a {
        void a(b bVar);
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public a() {
        f44498id++;
    }

    private void setState(b bVar) {
        this.mState = bVar;
        InterfaceC0489a interfaceC0489a = this.mListener;
        if (interfaceC0489a != null) {
            interfaceC0489a.a(bVar);
        }
    }

    public final void cancel() {
        b bVar = this.mState;
        b bVar2 = b.CANCEL;
        if (bVar != bVar2) {
            setState(bVar2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return f44498id;
    }

    public b getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z11);

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mState == b.READY) {
                setState(b.RUNNING);
                runTask();
                setState(b.FINISH);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public abstract void runTask();

    public void setOnStateChangeListener(InterfaceC0489a interfaceC0489a) {
        this.mListener = interfaceC0489a;
    }

    public final void setPause(boolean z11) {
        b bVar = this.mState;
        b bVar2 = b.PAUSE;
        if (bVar == bVar2 || bVar == b.CANCEL || bVar == b.FINISH) {
            return;
        }
        if (z11) {
            setState(bVar2);
        } else {
            setState(b.RUNNING);
        }
        pauseTask(z11);
    }
}
