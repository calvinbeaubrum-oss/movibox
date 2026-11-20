package a3;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class C0018a {
        @Nullable
        public static Signature[] a(@NonNull SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        public static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        @Nullable
        public static Signature[] c(@NonNull SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        public static boolean d(@NonNull SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        public static boolean e(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i11) {
            return packageManager.hasSigningCertificate(str, bArr, i11);
        }
    }

    public static long a(@NonNull PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? C0018a.b(packageInfo) : packageInfo.versionCode;
    }
}
