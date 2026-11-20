package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.h;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class AsyncLayoutInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f1797a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler.Callback f1800d = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f1798b = new Handler(this.f1800d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InflateThread f1799c = InflateThread.getInstance();

    /* JADX INFO: compiled from: source.java */
    public static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<c> mQueue = new ArrayBlockingQueue<>(10);
        private h<c> mRequestPool = new h<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(c cVar) {
            try {
                this.mQueue.put(cVar);
            } catch (InterruptedException e11) {
                throw new RuntimeException("Failed to enqueue async inflate request", e11);
            }
        }

        public c obtainRequest() {
            c cVarAcquire = this.mRequestPool.acquire();
            return cVarAcquire == null ? new c() : cVarAcquire;
        }

        public void releaseRequest(c cVar) {
            cVar.f1807e = null;
            cVar.f1803a = null;
            cVar.f1804b = null;
            cVar.f1805c = 0;
            cVar.f1806d = null;
            this.mRequestPool.release(cVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                c cVarTake = this.mQueue.take();
                try {
                    cVarTake.f1806d = cVarTake.f1803a.f1797a.inflate(cVarTake.f1805c, cVarTake.f1804b, false);
                } catch (RuntimeException e11) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e11);
                }
                Message.obtain(cVarTake.f1803a.f1798b, 0, cVarTake).sendToTarget();
            } catch (InterruptedException e12) {
                Log.w("AsyncLayoutInflater", e12);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.f1806d == null) {
                cVar.f1806d = AsyncLayoutInflater.this.f1797a.inflate(cVar.f1805c, cVar.f1804b, false);
            }
            cVar.f1807e.a(cVar.f1806d, cVar.f1805c, cVar.f1804b);
            AsyncLayoutInflater.this.f1799c.releaseRequest(cVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends LayoutInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f1802a = {"android.widget.", "android.webkit.", "android.app."};

        public b(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            for (String str2 : f1802a) {
                try {
                    View viewCreateView = createView(str, str2, attributeSet);
                    if (viewCreateView != null) {
                        return viewCreateView;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AsyncLayoutInflater f1803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f1804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f1806d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f1807e;
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(@NonNull View view, int i11, @Nullable ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.f1797a = new b(context);
    }

    public void a(int i11, @Nullable ViewGroup viewGroup, @NonNull d dVar) {
        if (dVar == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        c cVarObtainRequest = this.f1799c.obtainRequest();
        cVarObtainRequest.f1803a = this;
        cVarObtainRequest.f1805c = i11;
        cVarObtainRequest.f1804b = viewGroup;
        cVarObtainRequest.f1807e = dVar;
        this.f1799c.enqueue(cVarObtainRequest);
    }
}
