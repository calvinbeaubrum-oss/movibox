package com.transsion.ga;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import athena.a0;
import athena.j0;
import athena.r0;
import com.applovin.sdk.AppLovinMediationProvider;
import com.transsion.core.deviceinfo.DeviceInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f51964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f51965b = "";

    /* JADX INFO: compiled from: source.java */
    public class a implements Comparator<r0> {
        @Override // java.util.Comparator
        public int compare(r0 r0Var, r0 r0Var2) {
            return r0Var2.f13741e - r0Var.f13741e;
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(f51964a)) {
            return f51964a;
        }
        try {
            String string = Settings.Secure.getString(ws.a.a().getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                String strTrim = string.trim();
                String strA = TextUtils.isEmpty(strTrim) ? "" : com.transsion.core.utils.c.a(strTrim);
                f51964a = strA;
                return strA;
            }
        } catch (Exception e11) {
            a0.c(e11.getMessage());
        }
        return "";
    }

    public static String b(int i11) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ws.a.a().getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i11));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i11));
            }
            return !TextUtils.isEmpty(str) ? com.transsion.core.utils.c.a(str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    @RequiresPermission("android.permission.ACCESS_COARSE_LOCATION")
    public static List<r0> c(Context context) {
        String strSubstring;
        String strSubstring2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator)) {
            strSubstring = "";
            strSubstring2 = "";
        } else {
            strSubstring = networkOperator.substring(0, 3);
            strSubstring2 = networkOperator.substring(3);
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        ArrayList arrayList = new ArrayList();
        if (allCellInfo != null) {
            r0 r0Var = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                    int asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity.getCid() > 0 && cellIdentity.getLac() > 0 && asuLevel != 99) {
                        r0Var = (cellIdentity.getMcc() == Integer.MAX_VALUE || cellIdentity.getMnc() == Integer.MAX_VALUE) ? new r0(strSubstring, strSubstring2, cellIdentity.getCid(), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered()) : new r0(j0.d(cellIdentity.getMcc()), j0.d(cellIdentity.getMnc()), cellIdentity.getCid(), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered());
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                    int asuLevel2 = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity2.getCid() > 0 && cellIdentity2.getLac() > 0 && asuLevel2 != 99) {
                        r0Var = (cellIdentity2.getMcc() == Integer.MAX_VALUE || cellIdentity2.getMnc() == Integer.MAX_VALUE) ? new r0(strSubstring, strSubstring2, cellIdentity2.getCid(), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered()) : new r0(j0.d(cellIdentity2.getMcc()), j0.d(cellIdentity2.getMnc()), cellIdentity2.getCid(), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered());
                    }
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    int asuLevel3 = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity3.getCi() > 0 && cellIdentity3.getTac() > 0 && asuLevel3 != 99) {
                        r0Var = (cellIdentity3.getMcc() == Integer.MAX_VALUE || cellIdentity3.getMnc() == Integer.MAX_VALUE) ? new r0(strSubstring, strSubstring2, cellIdentity3.getCi(), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered()) : new r0(j0.d(cellIdentity3.getMcc()), j0.d(cellIdentity3.getMnc()), cellIdentity3.getCi(), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered());
                    }
                }
                if (r0Var != null && !arrayList.contains(r0Var)) {
                    arrayList.add(r0Var);
                }
                if (arrayList.size() == 10) {
                    break;
                }
            }
        }
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public static String d() {
        try {
            return ws.a.a().getPackageManager().getInstallerPackageName(com.transsion.core.utils.a.a());
        } catch (Exception e11) {
            a0.c(e11.getMessage());
            return "";
        }
    }

    public static String e(int i11) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ws.a.a().getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i11));
            return !TextUtils.isEmpty(str) ? com.transsion.core.utils.c.a(str) : "";
        } catch (Exception e11) {
            a0.c(e11.getMessage());
            return "";
        }
    }

    public static String f(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName)) {
                return processName;
            }
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            String str = (String) declaredMethod.invoke(null, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } catch (Throwable th2) {
            a0.c(th2.getMessage());
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e11) {
            a0.c(e11.getMessage());
        }
        return null;
    }

    public static String g() {
        String strF = DeviceInfo.f();
        return (TextUtils.isEmpty(strF) || strF.length() < 3) ? "" : strF.substring(0, 3);
    }

    public static String h() {
        String strF = DeviceInfo.f();
        return (TextUtils.isEmpty(strF) || strF.length() < 3) ? "" : strF.substring(3);
    }

    public static String i() {
        if (TextUtils.isEmpty(f51965b)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, "ro.tranos.version", "");
                f51965b = str;
                if (TextUtils.isEmpty(str)) {
                    f51965b = (String) method.invoke(null, "ro.os_product.version", "");
                }
            } catch (Exception e11) {
                a0.c(e11.getMessage());
            }
        }
        return f51965b;
    }

    public static String j() {
        String serial;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                serial = Build.getSerial();
            } catch (Exception unused) {
                serial = "";
            }
        } else {
            serial = Build.SERIAL;
        }
        try {
            if (TextUtils.isEmpty(serial) || AppLovinMediationProvider.UNKNOWN.equals(serial)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                serial = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            }
        } catch (Exception e11) {
            a0.c(e11.getMessage());
        }
        return TextUtils.isEmpty(serial) ? "" : com.transsion.core.utils.c.a(serial);
    }
}
