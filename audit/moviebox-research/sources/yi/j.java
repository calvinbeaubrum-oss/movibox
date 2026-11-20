package yi;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.f0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {
    @NonNull
    public static e a(int i11) {
        if (i11 != 0) {
            return i11 != 1 ? b() : new f();
        }
        return new m();
    }

    @NonNull
    public static e b() {
        return new m();
    }

    @NonNull
    public static g c() {
        return new g();
    }

    public static void d(@NonNull View view, float f11) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            ((i) background).c0(f11);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            f(view, (i) background);
        }
    }

    public static void f(@NonNull View view, @NonNull i iVar) {
        if (iVar.U()) {
            iVar.h0(f0.n(view));
        }
    }
}
