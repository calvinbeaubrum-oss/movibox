package h3;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean a(@NonNull ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
