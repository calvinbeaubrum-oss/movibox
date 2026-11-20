package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.concurrent.futures.b<c> f12375a = androidx.concurrent.futures.b.z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12376b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static c f12377c = null;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(33)
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f12380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f12381d;

        public b(int i11, int i12, long j11, long j12) {
            this.f12378a = i11;
            this.f12379b = i12;
            this.f12380c = j11;
            this.f12381d = j12;
        }

        public static b a(@NonNull File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public void b(@NonNull File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f12378a);
                dataOutputStream.writeInt(this.f12379b);
                dataOutputStream.writeLong(this.f12380c);
                dataOutputStream.writeLong(this.f12381d);
                dataOutputStream.close();
            } catch (Throwable th2) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12379b == bVar.f12379b && this.f12380c == bVar.f12380c && this.f12378a == bVar.f12378a && this.f12381d == bVar.f12381d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f12379b), Long.valueOf(this.f12380c), Integer.valueOf(this.f12378a), Long.valueOf(this.f12381d));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f12383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12384c;

        public c(int i11, boolean z11, boolean z12) {
            this.f12382a = i11;
            this.f12384c = z12;
            this.f12383b = z11;
        }
    }

    public static long a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i11, boolean z11, boolean z12) {
        c cVar = new c(i11, z11, z12);
        f12377c = cVar;
        f12375a.v(cVar);
        return f12377c;
    }

    @NonNull
    public static c c(@NonNull Context context, boolean z11) {
        b bVarA;
        int i11;
        c cVar;
        if (!z11 && (cVar = f12377c) != null) {
            return cVar;
        }
        synchronized (f12376b) {
            if (!z11) {
                try {
                    c cVar2 = f12377c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            int i12 = Build.VERSION.SDK_INT;
            int i13 = 0;
            if (i12 >= 28 && i12 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z12 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z13 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(131072, z12, z13);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f12380c == jA && (i11 = bVarA.f12379b) != 2) {
                        i13 = i11;
                    } else if (z12) {
                        i13 = 1;
                    } else if (z13) {
                        i13 = 2;
                    }
                    if (z11 && z13 && i13 != 1) {
                        i13 = 2;
                    }
                    if (bVarA != null && bVarA.f12379b == 2 && i13 == 1 && length < bVarA.f12381d) {
                        i13 = 3;
                    }
                    b bVar = new b(1, i13, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i13 = 196608;
                        }
                    }
                    return b(i13, z12, z13);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z12, z13);
                }
            }
            return b(262144, false, false);
        }
    }
}
