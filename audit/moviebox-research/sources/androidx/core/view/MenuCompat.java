package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class MenuCompat {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class a {
        public static void a(Menu menu, boolean z11) {
            menu.setGroupDividerEnabled(z11);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(@NonNull Menu menu, boolean z11) {
        if (menu instanceof e3.a) {
            ((e3.a) menu).setGroupDividerEnabled(z11);
        } else if (Build.VERSION.SDK_INT >= 28) {
            a.a(menu, z11);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i11) {
        menuItem.setShowAsAction(i11);
    }
}
