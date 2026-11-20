package k6;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(22)
public class h0 extends f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f68345h = true;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static void a(View view, int i11, int i12, int i13, int i14) {
            view.setLeftTopRightBottom(i11, i12, i13, i14);
        }
    }

    @Override // k6.c0
    @SuppressLint({"NewApi"})
    public void e(@NonNull View view, int i11, int i12, int i13, int i14) {
        if (f68345h) {
            try {
                a.a(view, i11, i12, i13, i14);
            } catch (NoSuchMethodError unused) {
                f68345h = false;
            }
        }
    }
}
