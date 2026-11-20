package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(@NonNull Configuration configuration, @NonNull h hVar) {
            configuration.setLocales((LocaleList) hVar.i());
        }
    }

    @NonNull
    public static h a(@NonNull Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? h.j(a.a(configuration)) : h.a(configuration.locale);
    }

    public static void b(@NonNull Configuration configuration, @NonNull h hVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(configuration, hVar);
        } else {
            if (hVar.f()) {
                return;
            }
            configuration.setLocale(hVar.d(0));
        }
    }
}
