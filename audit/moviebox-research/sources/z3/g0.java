package z3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f81780b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f81781a;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Message f81782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public g0 f81783b;

        public b() {
        }

        @Override // z3.j.a
        public void a() {
            ((Message) z3.a.e(this.f81782a)).sendToTarget();
            b();
        }

        public final void b() {
            this.f81782a = null;
            this.f81783b = null;
            g0.e(this);
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) z3.a.e(this.f81782a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public b d(Message message, g0 g0Var) {
            this.f81782a = message;
            this.f81783b = g0Var;
            return this;
        }
    }

    public g0(Handler handler) {
        this.f81781a = handler;
    }

    public static b d() {
        b bVar;
        List<b> list = f81780b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : list.remove(list.size() - 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public static void e(b bVar) {
        List<b> list = f81780b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // z3.j
    public boolean a(int i11) {
        return this.f81781a.hasMessages(i11);
    }

    @Override // z3.j
    public boolean b(j.a aVar) {
        return ((b) aVar).c(this.f81781a);
    }

    @Override // z3.j
    public Looper getLooper() {
        return this.f81781a.getLooper();
    }

    @Override // z3.j
    public j.a obtainMessage(int i11) {
        return d().d(this.f81781a.obtainMessage(i11), this);
    }

    @Override // z3.j
    public j.a obtainMessage(int i11, int i12, int i13) {
        return d().d(this.f81781a.obtainMessage(i11, i12, i13), this);
    }

    @Override // z3.j
    public j.a obtainMessage(int i11, int i12, int i13, @Nullable Object obj) {
        return d().d(this.f81781a.obtainMessage(i11, i12, i13, obj), this);
    }

    @Override // z3.j
    public j.a obtainMessage(int i11, @Nullable Object obj) {
        return d().d(this.f81781a.obtainMessage(i11, obj), this);
    }

    @Override // z3.j
    public boolean post(Runnable runnable) {
        return this.f81781a.post(runnable);
    }

    @Override // z3.j
    public void removeCallbacksAndMessages(@Nullable Object obj) {
        this.f81781a.removeCallbacksAndMessages(obj);
    }

    @Override // z3.j
    public void removeMessages(int i11) {
        this.f81781a.removeMessages(i11);
    }

    @Override // z3.j
    public boolean sendEmptyMessage(int i11) {
        return this.f81781a.sendEmptyMessage(i11);
    }

    @Override // z3.j
    public boolean sendEmptyMessageAtTime(int i11, long j11) {
        return this.f81781a.sendEmptyMessageAtTime(i11, j11);
    }
}
