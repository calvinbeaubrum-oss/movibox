package androidx.core.app;

import android.app.Service;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class a {
        public static void a(Service service, int i11) {
            service.stopForeground(i11);
        }
    }

    public static void a(@NonNull Service service, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i11);
        } else {
            service.stopForeground((i11 & 1) != 0);
        }
    }
}
