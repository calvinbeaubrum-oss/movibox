package com.alibaba.android.arouter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.alibaba.android.arouter.facade.template.ILogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ClassUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15377a = "code_cache" + File.separator + "secondary-dexes";

    public static Set<String> a(Context context, final String str) throws InterruptedException, PackageManager.NameNotFoundException, IOException {
        final HashSet hashSet = new HashSet();
        List<String> listC = c(context);
        final CountDownLatch countDownLatch = new CountDownLatch(listC.size());
        for (final String str2 : listC) {
            i7.b.a().execute(new Runnable() { // from class: com.alibaba.android.arouter.utils.ClassUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    DexFile dexFile = null;
                    try {
                        try {
                            if (str2.endsWith(".zip")) {
                                dexFile = DexFile.loadDex(str2, str2 + ".tmp", 0);
                            } else {
                                dexFile = new DexFile(str2);
                            }
                            Enumeration<String> enumerationEntries = dexFile.entries();
                            while (enumerationEntries.hasMoreElements()) {
                                String strNextElement = enumerationEntries.nextElement();
                                if (strNextElement.startsWith(str)) {
                                    hashSet.add(strNextElement);
                                }
                            }
                        } catch (Throwable th2) {
                            try {
                                Log.e("ARouter", "Scan map file in dex files made error.", th2);
                            } finally {
                                if (dexFile != null) {
                                    try {
                                        dexFile.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                countDownLatch.countDown();
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
        countDownLatch.await();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Filter ");
        sb2.append(hashSet.size());
        sb2.append(" classes by packageName <");
        sb2.append(str);
        sb2.append(">");
        return hashSet;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    public static List<String> c(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        if (!d()) {
            int i11 = b(context).getInt("dex.number", 1);
            File file2 = new File(applicationInfo.dataDir, f15377a);
            for (int i12 = 2; i12 <= i11; i12++) {
                File file3 = new File(file2, str + i12 + ".zip");
                if (!file3.isFile()) {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
                arrayList.add(file3.getAbsolutePath());
            }
        }
        if (com.alibaba.android.arouter.launcher.a.c()) {
            arrayList.addAll(f(applicationInfo));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d A[PHI: r1
  0x001d: PHI (r1v8 java.lang.String) = (r1v6 java.lang.String), (r1v6 java.lang.String), (r1v9 java.lang.String) binds: [B:13:0x004a, B:15:0x004e, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean d() {
        boolean z11 = false;
        String str = null;
        try {
            if (e()) {
                str = "'YunOS'";
                if (Integer.valueOf(System.getProperty("ro.build.version.sdk")).intValue() >= 21) {
                    z11 = true;
                }
            } else {
                str = "'Android'";
                String property = System.getProperty("java.vm.version");
                if (property != null) {
                    Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
                    if (matcher.matches()) {
                        int i11 = Integer.parseInt(matcher.group(1));
                        int i12 = Integer.parseInt(matcher.group(2));
                        if (i11 > 2 || (i11 == 2 && i12 >= 1)) {
                            z11 = true;
                        }
                    }
                }
            }
        } catch (NumberFormatException | Exception unused) {
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VM with name ");
        sb2.append(str);
        sb2.append(z11 ? " has multidex support" : " does not have multidex support");
        return z11;
    }

    public static boolean e() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            return (property2 != null && property2.toLowerCase().contains("lemur")) || (property != null && property.trim().length() > 0);
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> f(ApplicationInfo applicationInfo) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            arrayList.addAll(Arrays.asList(strArr));
        } else {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", String.class).invoke(null, applicationInfo.packageName));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(".dex")) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e11) {
                Log.e(ILogger.defaultTag, "InstantRun support error, " + e11.getMessage());
            }
        }
        return arrayList;
    }
}
