package k6;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f68423a = true;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static int a(ViewGroup viewGroup, int i11) {
            return viewGroup.getChildDrawingOrder(i11);
        }

        public static void b(ViewGroup viewGroup, boolean z11) {
            viewGroup.suppressLayout(z11);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(@NonNull ViewGroup viewGroup, boolean z11) {
        if (f68423a) {
            try {
                a.b(viewGroup, z11);
            } catch (NoSuchMethodError unused) {
                f68423a = false;
            }
        }
    }

    public static void b(@NonNull ViewGroup viewGroup, boolean z11) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z11);
        } else {
            a(viewGroup, z11);
        }
    }
}
