package athena;

import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x0 f13769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Handler f13770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Thread f13771c;

    public abstract void a();

    public void a(@NonNull x0 x0Var) {
        this.f13769a = x0Var;
        this.f13770b = x0Var.d();
    }

    public String b() {
        return "Task-Athena-" + d();
    }

    public void c() {
    }

    public abstract String d();

    @Override // java.lang.Runnable
    public void run() {
        Thread threadCurrentThread = Thread.currentThread();
        this.f13771c = threadCurrentThread;
        String name = threadCurrentThread.getName();
        this.f13771c.setName(b());
        try {
            try {
                a();
                x0 x0Var = this.f13769a;
                if (x0Var != null) {
                    x0Var.i(this);
                }
            } catch (Exception e11) {
                a0.d("execute task exception : %s", e11.getMessage());
                if (this.f13769a != null) {
                    this.f13769a.i(this);
                }
            }
            this.f13771c.setName(name);
        } catch (Throwable th2) {
            x0 x0Var2 = this.f13769a;
            if (x0Var2 != null) {
                x0Var2.i(this);
            }
            this.f13771c.setName(name);
            throw th2;
        }
    }
}
