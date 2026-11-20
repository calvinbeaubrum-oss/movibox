package nr;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f72144a;

        public a(float f11) {
            this.f72144a = f11;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f72144a);
        }
    }

    public static int a(float f11) {
        return (int) TypedValue.applyDimension(1, f11, Resources.getSystem().getDisplayMetrics());
    }

    public static int b(boolean z11, int i11, int i12) {
        if (!z11) {
            return i11;
        }
        if (i11 == 0) {
            return i12 - 1;
        }
        if (i11 == i12 + 1) {
            return 0;
        }
        return i11 - 1;
    }

    public static void c(View view, float f11) {
        view.setOutlineProvider(new a(f11));
        view.setClipToOutline(true);
    }
}
