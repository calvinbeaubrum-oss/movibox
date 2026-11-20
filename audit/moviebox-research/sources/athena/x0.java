package athena;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<y> f13765a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f13766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f13768d;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Athena Dispatcher");
            thread.setDaemon(false);
            return thread;
        }
    }

    public x0(@NonNull Handler handler, int i11) {
        this.f13768d = handler;
        this.f13767c = i11;
    }

    public static /* synthetic */ boolean g(String str, y yVar) {
        return TextUtils.equals(yVar.b(), str);
    }

    public static /* synthetic */ boolean k(y yVar) {
        return yVar instanceof f0;
    }

    public synchronized int c(final String str) {
        return br.d.a(this.f13765a, new androidx.core.util.j() { // from class: athena.w0
            @Override // androidx.core.util.j
            public final boolean test(Object obj) {
                return x0.g(str, (y) obj);
            }
        });
    }

    public Handler d() {
        return this.f13768d;
    }

    public synchronized void e(int i11) {
        Object[] objArr;
        int i12;
        if (i11 > 0) {
            try {
                if (this.f13766b != null) {
                    synchronized (this) {
                        if (this.f13767c != i11) {
                            objArr = new Object[2];
                            synchronized (this) {
                                i12 = this.f13767c;
                            }
                        }
                    }
                    objArr[0] = Integer.valueOf(i12);
                    objArr[1] = Integer.valueOf(i11);
                    a0.f("Adjust channel size from [%d] to [%d]", objArr);
                    this.f13766b.setCorePoolSize(i11);
                    this.f13766b.setMaximumPoolSize(i11);
                    this.f13767c = i11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void f(y yVar) {
        try {
            if (c(yVar.b()) <= 0 && (!(yVar instanceof e0) || !j())) {
                yVar.a(this);
                this.f13765a.add(yVar);
                synchronized (this) {
                    try {
                        if (this.f13766b == null) {
                            int i11 = this.f13767c;
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 3L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new b());
                            this.f13766b = threadPoolExecutor;
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        }
                        this.f13766b.execute(yVar);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public void h() {
        Iterator<y> it = this.f13765a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public synchronized void i(y yVar) {
        this.f13765a.remove(yVar);
    }

    public final synchronized boolean j() {
        return br.d.a(this.f13765a, new androidx.core.util.j() { // from class: athena.v0
            @Override // androidx.core.util.j
            public final boolean test(Object obj) {
                return x0.k((y) obj);
            }
        }) > 0;
    }
}
