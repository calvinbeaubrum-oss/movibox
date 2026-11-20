package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(api = 21)
    public static class C0113a {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(api = 24)
    public static class b {
        public static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z11 = true;
        for (File file2 : fileArrListFiles) {
            z11 = a(file2) && z11;
        }
        return z11;
    }

    public static void b(@NonNull Context context, @NonNull ProfileInstallReceiver.a aVar) {
        File fileA;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            fileA = b.a(context);
        } else {
            fileA = i11 >= 23 ? C0113a.a(context) : context.getCacheDir();
        }
        if (a(fileA)) {
            aVar.a(14, null);
        } else {
            aVar.a(15, null);
        }
    }
}
