package z3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f0 implements d {
    @Override // z3.d
    public void a() {
    }

    @Override // z3.d
    public j createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new g0(new Handler(looper, callback));
    }

    @Override // z3.d
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // z3.d
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // z3.d
    public long nanoTime() {
        return System.nanoTime();
    }

    @Override // z3.d
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
