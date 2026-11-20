package k6;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public class j0 extends h0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f68387i = true;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static void a(View view, int i11) {
            view.setTransitionVisibility(i11);
        }
    }

    @Override // k6.c0
    @SuppressLint({"NewApi"})
    public void g(@NonNull View view, int i11) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i11);
        } else if (f68387i) {
            try {
                a.a(view, i11);
            } catch (NoSuchMethodError unused) {
                f68387i = false;
            }
        }
    }
}
