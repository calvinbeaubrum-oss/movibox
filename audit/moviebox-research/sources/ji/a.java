package ji;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: ji.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0730a {
        void a(@NonNull Canvas canvas);
    }

    public static int a(@NonNull Canvas canvas, float f11, float f12, float f13, float f14, int i11) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f11, f12, f13, f14, i11) : canvas.saveLayerAlpha(f11, f12, f13, f14, i11, 31);
    }
}
