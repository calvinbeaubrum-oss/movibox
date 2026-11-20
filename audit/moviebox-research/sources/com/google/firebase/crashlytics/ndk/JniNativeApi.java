package com.google.firebase.crashlytics.ndk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import gk.f;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rk.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
class JniNativeApi implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f40584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FilenameFilter f40585c = new FilenameFilter() { // from class: com.google.firebase.crashlytics.ndk.b
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return JniNativeApi.g(file, str);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40586a;

    static {
        boolean z11;
        try {
            System.loadLibrary("crashlytics");
            z11 = true;
        } catch (UnsatisfiedLinkError e11) {
            f.f().d("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n" + e11.getLocalizedMessage());
            z11 = false;
        }
        f40584b = z11;
    }

    public JniNativeApi(Context context) {
        this.f40586a = context;
    }

    @TargetApi(21)
    public static void c(List<String> list, PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            Collections.addAll(list, strArr);
        }
        File file = new File(applicationInfo.dataDir, String.format("files/splitcompat/%s/verified-splits", e(packageInfo)));
        if (!file.exists()) {
            f.f().b("No dynamic features found at " + file.getAbsolutePath());
            return;
        }
        File[] fileArrListFiles = file.listFiles(f40585c);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        f.f().b("Found " + fileArrListFiles.length + " APKs in " + file.getAbsolutePath());
        for (File file2 : fileArrListFiles) {
            f.f().b("Adding " + file2.getName() + " to classpath.");
            list.add(file2.getAbsolutePath());
        }
    }

    public static int d() {
        return Build.VERSION.SDK_INT >= 24 ? 9216 : 1024;
    }

    public static String e(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }

    public static boolean f() {
        return true;
    }

    public static /* synthetic */ boolean g(File file, String str) {
        return str.toLowerCase().endsWith(".apk");
    }

    private native boolean nativeInit(String[] strArr, Object obj);

    @Override // rk.e
    public boolean a(String str, AssetManager assetManager) {
        String[] strArrH = h(Build.CPU_ABI);
        if (strArrH.length < 2) {
            return false;
        }
        return f40584b && nativeInit(new String[]{strArrH[0], strArrH[1], str}, assetManager);
    }

    public String[] h(String str) {
        try {
            PackageInfo packageInfo = this.f40586a.getPackageManager().getPackageInfo(this.f40586a.getPackageName(), d());
            ArrayList<String> arrayList = new ArrayList(10);
            arrayList.add(packageInfo.applicationInfo.sourceDir);
            if (f()) {
                c(arrayList, packageInfo);
            }
            String[] strArr = packageInfo.applicationInfo.sharedLibraryFiles;
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            ArrayList arrayList2 = new ArrayList(10);
            File parentFile = new File(packageInfo.applicationInfo.nativeLibraryDir).getParentFile();
            if (parentFile != null) {
                arrayList2.add(new File(parentFile, str).getPath());
                if (str.startsWith("arm64")) {
                    arrayList2.add(new File(parentFile, "arm64").getPath());
                } else if (str.startsWith("arm")) {
                    arrayList2.add(new File(parentFile, "arm").getPath());
                }
            }
            for (String str2 : arrayList) {
                if (str2.endsWith(".apk")) {
                    arrayList2.add(str2 + "!/lib/" + str);
                }
            }
            arrayList2.add(System.getProperty("java.library.path"));
            arrayList2.add(packageInfo.applicationInfo.nativeLibraryDir);
            String str3 = File.pathSeparator;
            return new String[]{TextUtils.join(str3, arrayList), TextUtils.join(str3, arrayList2)};
        } catch (PackageManager.NameNotFoundException e11) {
            f.f().e("Unable to compose package paths", e11);
            throw new RuntimeException(e11);
        }
    }
}
