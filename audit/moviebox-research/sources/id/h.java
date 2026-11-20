package id;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface h {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static int a(h hVar, int i11) {
            return z2.a.getColor(hVar.getContext(), i11);
        }

        public static Drawable b(h hVar, int i11) {
            return z2.a.getDrawable(hVar.getContext(), i11);
        }

        public static Resources c(h hVar) {
            Resources resources = hVar.getContext().getResources();
            Intrinsics.f(resources, "getContext().resources");
            return resources;
        }

        public static String d(h hVar, @StringRes int i11) {
            return hVar.getContext().getString(i11);
        }

        public static <S> S e(h hVar, Class<S> serviceClass) {
            Intrinsics.g(serviceClass, "serviceClass");
            S s11 = (S) z2.a.getSystemService(hVar.getContext(), serviceClass);
            Intrinsics.d(s11);
            return s11;
        }
    }

    Context getContext();
}
