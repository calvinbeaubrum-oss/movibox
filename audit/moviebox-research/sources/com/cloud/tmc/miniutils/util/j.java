package com.cloud.tmc.miniutils.util;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31997a = System.getProperty("line.separator");

    /* JADX INFO: compiled from: source.java */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean a(File file, File file2);
    }

    public static boolean A(String str) {
        File fileR = r(str);
        if (fileR == null) {
            return false;
        }
        if (fileR.exists()) {
            return true;
        }
        return B(str);
    }

    public static boolean B(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = e0.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
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

    public static List<File> C(File file, boolean z11) {
        return D(file, z11, null);
    }

    public static List<File> D(File file, boolean z11, Comparator<File> comparator) {
        return G(file, new a(), z11, comparator);
    }

    public static List<File> E(String str) {
        return F(str, null);
    }

    public static List<File> F(String str, Comparator<File> comparator) {
        return D(r(str), false, comparator);
    }

    public static List<File> G(File file, FileFilter fileFilter, boolean z11, Comparator<File> comparator) {
        List<File> listH = H(file, fileFilter, z11);
        if (comparator != null) {
            Collections.sort(listH, comparator);
        }
        return listH;
    }

    public static List<File> H(File file, FileFilter fileFilter, boolean z11) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (w(file) && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z11 && file2.isDirectory()) {
                    arrayList.addAll(H(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    public static void I(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
        e0.a().sendBroadcast(intent);
    }

    public static boolean a(File file, File file2, b bVar) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? c(file, file2, bVar) : d(file, file2, bVar);
    }

    public static boolean b(String str, String str2) {
        return a(r(str), r(str2), null);
    }

    public static boolean c(File file, File file2, b bVar) {
        return e(file, file2, bVar, false);
    }

    public static boolean d(File file, File file2, b bVar) {
        return f(file, file2, bVar, false);
    }

    public static boolean e(File file, File file2, b bVar, boolean z11) {
        if (file == null || file2 == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getPath());
        String str = File.separator;
        sb2.append(str);
        String string = sb2.toString();
        String str2 = file2.getPath() + str;
        if (str2.contains(string) || !file.exists() || !file.isDirectory() || !i(file2)) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file3 : fileArrListFiles) {
                File file4 = new File(str2 + file3.getName());
                if (file3.isFile()) {
                    if (!f(file3, file4, bVar, z11)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !e(file3, file4, bVar, z11)) {
                    return false;
                }
            }
        }
        return !z11 || o(file);
    }

    public static boolean f(File file, File file2, b bVar, boolean z11) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (bVar != null && !bVar.a(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!i(file2.getParentFile())) {
                return false;
            }
            try {
                if (h0.B(file2.getAbsolutePath(), new FileInputStream(file))) {
                    return !z11 || p(file);
                }
                return false;
            } catch (FileNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    public static boolean g(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !i(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean h(String str) {
        return g(r(str));
    }

    public static boolean i(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean j(String str) {
        return i(r(str));
    }

    public static boolean k(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!i(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean l(String str) {
        return k(r(str));
    }

    public static boolean m(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? o(file) : p(file);
    }

    public static boolean n(String str) {
        return m(r(str));
    }

    public static boolean o(File file) {
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
                } else if (file2.isDirectory() && !o(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean p(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static long q(File file) {
        long jQ = 0;
        if (!w(file)) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jQ += file2.isDirectory() ? q(file2) : file2.length();
            }
        }
        return jQ;
    }

    public static File r(String str) {
        if (h0.u(str)) {
            return null;
        }
        return new File(str);
    }

    public static long s(File file) {
        if (y(file)) {
            return file.length();
        }
        return -1L;
    }

    public static long t(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static long u(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static long v(File file) {
        if (file == null) {
            return 0L;
        }
        return file.isDirectory() ? q(file) : s(file);
    }

    public static boolean w(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean x(String str) {
        return w(r(str));
    }

    public static boolean y(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean z(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return A(file.getAbsolutePath());
    }
}
