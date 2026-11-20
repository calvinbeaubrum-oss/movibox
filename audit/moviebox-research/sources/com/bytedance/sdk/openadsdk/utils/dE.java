package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE {
    private static List<String> pFF() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0091 A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:35:0x0089, B:38:0x0091), top: B:46:0x0089 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x0091, please report this as an issue */
    public static void sc() {
        int i11;
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        if (contextSc != null && com.bytedance.sdk.component.utils.Tf.We()) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "The pangolin sdk access, the environment is debug, the initial configuration detection starts");
            String packageName = contextSc.getPackageName();
            int i12 = contextSc.getApplicationInfo().targetSdkVersion;
            boolean z11 = true;
            try {
                String[] strArr = contextSc.getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr == null || strArr.length <= 0) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "The uses-permission configuration in AndroidManifest.xml is missing, please refer to the access documentation");
                } else {
                    List<String> listPFF = pFF();
                    for (String str : strArr) {
                        if (str != null) {
                            listPFF.remove(str);
                        }
                    }
                    if (listPFF.isEmpty()) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "AndroidManifest.xml permissions configuration is normal");
                    } else {
                        Iterator<String> it = listPFF.iterator();
                        while (it.hasNext()) {
                            try {
                                com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "    May be missing permissions：" + it.next() + "，Please refer to the access documentation");
                                z11 = false;
                            } catch (Throwable th2) {
                                th = th2;
                                z11 = false;
                                com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "The usage-permission configuration error in AndroidManifest.xml, please refer to the access documentation", th);
                                i11 = Build.VERSION.SDK_INT;
                                if (i11 >= 23) {
                                    com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i12 + "&phone=" + i11 + ", require=23");
                                } else {
                                    com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i12 + "&phone=" + i11 + ", require=23");
                                }
                                if (!z11) {
                                    com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion");
                                }
                                com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "End of pangolin sdk initial configuration test");
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                i11 = Build.VERSION.SDK_INT;
                if (i11 >= 23 || i12 < 23) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i12 + "&phone=" + i11 + ", require=23");
                }
            } catch (Throwable th4) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "The dynamic permission is abnormal. Please check and read the access document in detail： ", th4);
            }
            if (!z11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion");
            }
            com.bytedance.sdk.component.utils.Tf.sc("TTAdSdk-InitChecker", "End of pangolin sdk initial configuration test");
        }
    }
}
