package t6;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SerialExecutorImpl f76915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f76916b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f76917c = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            d.this.f76916b.post(runnable);
        }
    }

    public d(@NonNull Executor executor) {
        this.f76915a = new SerialExecutorImpl(executor);
    }

    @Override // t6.c
    @NonNull
    public Executor a() {
        return this.f76917c;
    }

    @Override // t6.c
    public /* synthetic */ void c(Runnable runnable) {
        b.a(this, runnable);
    }

    @Override // t6.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public SerialExecutorImpl b() {
        return this.f76915a;
    }
}
