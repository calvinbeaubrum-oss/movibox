package j2;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class a {
        public static AutofillId a(View view) {
            return view.getAutofillId();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static ContentCaptureSession a(View view) {
            return view.getContentCaptureSession();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class c {
        public static void a(View view, int i11) {
            view.setImportantForContentCapture(i11);
        }
    }

    @Nullable
    public static j2.b a(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j2.b.b(a.a(view));
        }
        return null;
    }

    @Nullable
    public static e b(@NonNull View view) {
        ContentCaptureSession contentCaptureSessionA;
        if (Build.VERSION.SDK_INT < 29 || (contentCaptureSessionA = b.a(view)) == null) {
            return null;
        }
        return e.f(contentCaptureSessionA, view);
    }

    public static void c(@NonNull View view, int i11) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(view, i11);
        }
    }
}
