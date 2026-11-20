package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<GifDrawable> f73930a;

    public f(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.f73930a = new WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        GifDrawable gifDrawable = this.f73930a.get();
        if (gifDrawable == null) {
            return;
        }
        if (message.what == -1) {
            gifDrawable.invalidateSelf();
            return;
        }
        Iterator<a> it = gifDrawable.f73895i.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }
}
