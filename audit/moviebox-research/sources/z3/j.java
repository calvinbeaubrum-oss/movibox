package z3;

import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();
    }

    boolean a(int i11);

    boolean b(a aVar);

    Looper getLooper();

    a obtainMessage(int i11);

    a obtainMessage(int i11, int i12, int i13);

    a obtainMessage(int i11, int i12, int i13, @Nullable Object obj);

    a obtainMessage(int i11, @Nullable Object obj);

    boolean post(Runnable runnable);

    void removeCallbacksAndMessages(@Nullable Object obj);

    void removeMessages(int i11);

    boolean sendEmptyMessage(int i11);

    boolean sendEmptyMessageAtTime(int i11, long j11);
}
