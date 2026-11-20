package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(33)
    public static class a {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    @NonNull
    public static androidx.core.os.h a(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return androidx.core.os.h.c(c.b(context));
        }
        Object objB = b(context);
        return objB != null ? androidx.core.os.h.j(a.a(objB)) : androidx.core.os.h.e();
    }

    @RequiresApi(33)
    public static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
