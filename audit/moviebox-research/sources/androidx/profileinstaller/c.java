package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b6.m;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0114c f12371a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public static final InterfaceC0114c f12372b = new b();

    /* JADX INFO: compiled from: source.java */
    public class a implements InterfaceC0114c {
        @Override // androidx.profileinstaller.c.InterfaceC0114c
        public void a(int i11, @Nullable Object obj) {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0114c
        public void b(int i11, @Nullable Object obj) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements InterfaceC0114c {
        @Override // androidx.profileinstaller.c.InterfaceC0114c
        public void a(int i11, @Nullable Object obj) {
            String str;
            switch (i11) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i11 == 6 || i11 == 7 || i11 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            }
        }

        @Override // androidx.profileinstaller.c.InterfaceC0114c
        public void b(int i11, @Nullable Object obj) {
        }
    }

    /* JADX INFO: renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0114c {
        void a(int i11, @Nullable Object obj);

        void b(int i11, @Nullable Object obj);
    }

    public static boolean b(@NonNull File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(@NonNull Context context, @NonNull Executor executor, @NonNull InterfaceC0114c interfaceC0114c) {
        b(context.getFilesDir());
        g(executor, interfaceC0114c, 11, null);
    }

    public static boolean d(PackageInfo packageInfo, File file, InterfaceC0114c interfaceC0114c) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j11 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z11 = j11 == packageInfo.lastUpdateTime;
                if (z11) {
                    interfaceC0114c.a(2, null);
                }
                return z11;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static void f(@NonNull PackageInfo packageInfo, @NonNull File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th2) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException unused) {
        }
    }

    public static void g(@NonNull Executor executor, @NonNull final InterfaceC0114c interfaceC0114c, final int i11, @Nullable final Object obj) {
        executor.execute(new Runnable() { // from class: c6.f
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0114c.a(i11, obj);
            }
        });
    }

    public static boolean h(@NonNull AssetManager assetManager, @NonNull String str, @NonNull PackageInfo packageInfo, @NonNull File file, @NonNull String str2, @NonNull Executor executor, @NonNull InterfaceC0114c interfaceC0114c) {
        androidx.profileinstaller.b bVar = new androidx.profileinstaller.b(assetManager, executor, interfaceC0114c, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!bVar.e()) {
            return false;
        }
        boolean zN = bVar.i().m().n();
        if (zN) {
            f(packageInfo, file);
        }
        return zN;
    }

    public static void i(@NonNull Context context) {
        j(context, new m(), f12371a);
    }

    public static void j(@NonNull Context context, @NonNull Executor executor, @NonNull InterfaceC0114c interfaceC0114c) {
        k(context, executor, interfaceC0114c, false);
    }

    public static void k(@NonNull Context context, @NonNull Executor executor, @NonNull InterfaceC0114c interfaceC0114c, boolean z11) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z12 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z11 && d(packageInfo, filesDir, interfaceC0114c)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping profile installation for ");
                sb2.append(context.getPackageName());
                e.c(context, false);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Installing profile for ");
            sb3.append(context.getPackageName());
            if (h(assets, packageName, packageInfo, filesDir, name, executor, interfaceC0114c) && z11) {
                z12 = true;
            }
            e.c(context, z12);
        } catch (PackageManager.NameNotFoundException e11) {
            interfaceC0114c.a(7, e11);
            e.c(context, false);
        }
    }

    public static void l(@NonNull Context context, @NonNull Executor executor, @NonNull InterfaceC0114c interfaceC0114c) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, interfaceC0114c, 10, null);
        } catch (PackageManager.NameNotFoundException e11) {
            g(executor, interfaceC0114c, 7, e11);
        }
    }
}
