package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class II {
    private static volatile boolean We = true;
    private static String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28733sc;
    private static String zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends com.bytedance.sdk.component.Qj.Qj {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public static AtomicBoolean f28734sc = new AtomicBoolean(false);
        private static final AtomicLong pFF = new AtomicLong(0);

        public sc(String str, int i11) {
            super(str, i11);
        }

        public static void sc() {
            if (f28734sc.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = pFF;
            if (jCurrentTimeMillis - atomicLong.get() < TTAdConstant.AD_MAX_EVENT_TIME) {
                return;
            }
            atomicLong.set(jCurrentTimeMillis);
            Cb.pFF((com.bytedance.sdk.component.Qj.Qj) new sc("UpdateSimStatusTask", 5));
        }

        @Override // java.lang.Runnable
        public void run() {
            f28734sc.set(true);
            II.ExN();
            f28734sc.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ExN() {
        String simOperatorName;
        String simOperator;
        String strSubstring;
        if (com.bytedance.sdk.openadsdk.core.Xc.sc() == null) {
            return;
        }
        We = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.Xc.sc().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0 || simState == 1) {
                    We = false;
                }
                com.bytedance.sdk.component.utils.Tf.sc("MCC", We ? "Have SIM card" : "No SIM card");
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("SimUtils", th2.getMessage());
            }
            String str = null;
            try {
                simOperatorName = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                simOperatorName = null;
            }
            try {
                simOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                simOperator = null;
            }
            if (simOperator == null || simOperator.length() < 5) {
                try {
                    simOperator = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 4) {
                strSubstring = null;
            } else {
                String strSubstring2 = simOperator.substring(0, 3);
                strSubstring = simOperator.substring(3);
                str = strSubstring2;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                f28733sc = simOperatorName;
            }
            if (!TextUtils.isEmpty(str)) {
                pFF = str;
            }
            if (TextUtils.isEmpty(strSubstring)) {
                return;
            }
            zY = strSubstring;
        } catch (Throwable unused4) {
        }
    }

    public static String pFF() {
        try {
            sc.sc();
            if (!We) {
                StringBuilder sb2 = new StringBuilder("getMCC");
                sb2.append(We ? "Have SIM card" : "No SIM card, MCC returns null");
                com.bytedance.sdk.component.utils.Tf.sc("MCC", sb2.toString());
                return null;
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.Xc.sc().getResources().getConfiguration();
            int i11 = configuration.mcc;
            String strValueOf = i11 != 0 ? String.valueOf(i11) : pFF;
            com.bytedance.sdk.component.utils.Tf.sc("MCC", "config=" + configuration.mcc + ",sMCC=" + pFF);
            return strValueOf;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("SimUtils", th2.getMessage());
            return null;
        }
    }

    public static String sc() {
        sc.sc();
        return f28733sc;
    }

    public static String zY() {
        sc.sc();
        return zY;
    }
}
