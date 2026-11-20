package com.blankj.utilcode.util;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25336a = System.getProperty("line.separator");

    /* JADX INFO: compiled from: source.java */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean b(String str) {
        return a(h(str));
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? e(file) : f(file);
    }

    public static boolean d(File file) {
        return g(file, new a());
    }

    public static boolean e(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !e(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean f(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean g(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !e(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static File h(String str) {
        if (j0.C(str)) {
            return null;
        }
        return new File(str);
    }

    public static String i(String str) {
        if (j0.C(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || str.lastIndexOf(File.separator) >= iLastIndexOf) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static long j(File file) {
        if (n(file)) {
            return file.length();
        }
        return -1L;
    }

    public static long k(String str) {
        if (str.matches("[a-zA-z]+://[^\\s]*")) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return httpsURLConnection.getContentLength();
                }
                return -1L;
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return j(h(str));
    }

    public static long l(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static long m(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static boolean n(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean o(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return p(file.getAbsolutePath());
    }

    public static boolean p(String str) {
        File fileH = h(str);
        if (fileH == null) {
            return false;
        }
        if (fileH.exists()) {
            return true;
        }
        return q(str);
    }

    public static boolean q(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = Utils.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }
}
