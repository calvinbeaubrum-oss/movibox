package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: compiled from: source.java */
    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f7789a;

        public a(@NonNull Handler handler) {
            this.f7789a = (Handler) androidx.core.util.i.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (this.f7789a.post((Runnable) androidx.core.util.i.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f7789a + " is shutting down");
        }
    }

    @NonNull
    public static Executor a(@NonNull Handler handler) {
        return new a(handler);
    }
}
