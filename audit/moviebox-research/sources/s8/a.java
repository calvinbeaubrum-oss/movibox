package s8;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<SurfaceHolder.Callback> f76260a;

    public a(SurfaceHolder.Callback callback) {
        this.f76260a = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback a() {
        return this.f76260a.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        SurfaceHolder.Callback callback = this.f76260a.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i11, i12, i13);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f76260a.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f76260a.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
