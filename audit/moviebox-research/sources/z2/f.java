package z2;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static int a(@NonNull Context context, @NonNull String str) {
        return b(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int b(@NonNull Context context, @NonNull String str, int i11, int i12, @Nullable String str2) {
        if (context.checkPermission(str, i11, i12) == -1) {
            return -1;
        }
        String strC = androidx.core.app.d.c(str);
        if (strC == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i12);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i12 || !androidx.core.util.d.a(context.getPackageName(), str2)) ? androidx.core.app.d.b(context, strC, str2) : androidx.core.app.d.a(context, i12, strC, str2)) == 0 ? 0 : -2;
    }

    public static int c(@NonNull Context context, @NonNull String str) {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
