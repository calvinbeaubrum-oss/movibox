package androidx.core.os;

import android.os.CancellationSignal;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f7786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7788d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f7785a) {
                    return;
                }
                this.f7785a = true;
                this.f7788d = true;
                a aVar = this.f7786b;
                Object obj = this.f7787c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.f7788d = false;
                            notifyAll();
                            throw th2;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f7788d = false;
                    notifyAll();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void b(@Nullable a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f7786b == aVar) {
                    return;
                }
                this.f7786b = aVar;
                if (this.f7785a && aVar != null) {
                    aVar.onCancel();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        while (this.f7788d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
