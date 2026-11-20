package com.aliyun.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cicada.player.utils.NativeUsed;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@NativeUsed
public class DeviceInfoUtils {
    public static File ALIVC_DATA_FILE = null;
    public static final String DATA_DIRECTORY = "AlivcData";
    private static final int MAX_WRITE_COUNT = 10;
    private static final String UUID_FILE = "alivc_data.txt";
    private static final String UUID_PROP = "UUID";
    private static CpuProcessTracker mCpuTracker;
    private static Context sAppContext;
    private static String sCpuProcessorInfo;
    private static String sDeviceUUID;
    private static String sSessionId;
    private static int sWriteUUIDCount;

    static {
        NativeLoader.loadPlayer();
        ALIVC_DATA_FILE = null;
    }

    public static /* synthetic */ int access$008() {
        int i11 = sWriteUUIDCount;
        sWriteUUIDCount = i11 + 1;
        return i11;
    }

    private static String canGetContext() {
        return getSDKContext() != null ? "true" : "false";
    }

    public static String generateNewSessionId() {
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        sSessionId = strReplace;
        return strReplace;
    }

    public static String getApplicationName() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getSDKContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getSDKContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static String getApplicationVersion() {
        try {
            return getSDKContext() != null ? getSDKContext().getPackageManager().getPackageInfo(getSDKContext().getPackageName(), 0).versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getCPUInfo() {
        String str;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class).invoke(null, "ro.board.platform", "");
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "";
        }
        return str.equals("") ? Build.HARDWARE : str;
    }

    public static String getCPUProcessorInfo() throws Throwable {
        if (!TextUtils.isEmpty(sCpuProcessorInfo)) {
            return sCpuProcessorInfo;
        }
        requestCPUInfo();
        return sCpuProcessorInfo;
    }

    public static String getCPUUsageRatio() {
        if (mCpuTracker == null) {
            mCpuTracker = new CpuProcessTracker();
        }
        return String.valueOf(mCpuTracker.getMyPicCpuPercent());
    }

    private static String getCacheDir() {
        File externalCacheDir;
        return (getSDKContext() == null || (externalCacheDir = getSDKContext().getExternalCacheDir()) == null || !externalCacheDir.exists()) ? "" : externalCacheDir.getAbsolutePath();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    private static String getDeviceFeature() {
        JSONObject jSONObject = new JSONObject();
        if (sAppContext != null) {
            try {
                jSONObject.put("UIModeType", getUIModeType());
            } catch (Exception unused) {
            }
            putFeature(jSONObject, "android.hardware.audio.low_latency");
            putFeature(jSONObject, "android.hardware.bluetooth");
            putFeature(jSONObject, "android.hardware.bluetooth_le");
            putFeature(jSONObject, "android.hardware.screen.landscape");
            putFeature(jSONObject, "android.hardware.screen.portrait");
            int i11 = Build.VERSION.SDK_INT;
            putFeature(jSONObject, "android.hardware.type.watch");
            putFeature(jSONObject, "android.hardware.audio.output");
            putFeature(jSONObject, "android.software.live_tv");
            putFeature(jSONObject, "android.hardware.opengles.aep");
            if (i11 >= 23) {
                putFeature(jSONObject, "android.hardware.audio.pro");
                putFeature(jSONObject, "android.hardware.type.automotive");
                putFeature(jSONObject, "android.hardware.sensor.hifi_sensors");
                putFeature(jSONObject, "android.software.midi");
            }
            if (i11 >= 24) {
                putFeature(jSONObject, "android.software.picture_in_picture");
                putFeature(jSONObject, "android.hardware.vr.high_performance");
                putFeature(jSONObject, "android.hardware.vulkan.level");
                putFeature(jSONObject, "android.hardware.vulkan.version");
            }
            if (i11 >= 27) {
                putFeature(jSONObject, "android.hardware.ram.low");
                putFeature(jSONObject, "android.hardware.ram.normal");
            }
            if (i11 >= 26) {
                putFeature(jSONObject, "android.software.activities_on_secondary_displays");
                putFeature(jSONObject, "android.hardware.type.embedded");
                putFeature(jSONObject, "android.hardware.vr.headtracking");
                putFeature(jSONObject, "android.hardware.vulkan.compute");
            }
            putFeature(jSONObject, "android.hardware.touchscreen");
            putFeature(jSONObject, "android.hardware.faketouch");
            putFeature(jSONObject, "android.hardware.telephony");
            putFeature(jSONObject, "android.hardware.camera");
            putFeature(jSONObject, "android.hardware.nfc");
            putFeature(jSONObject, "android.hardware.location.gps");
            putFeature(jSONObject, "android.hardware.microphone");
            putFeature(jSONObject, "android.hardware.sensor.compass");
        }
        return jSONObject.toString();
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static synchronized String getDeviceUUID() {
        if (!TextUtils.isEmpty(sDeviceUUID)) {
            return sDeviceUUID;
        }
        if (ALIVC_DATA_FILE == null) {
            ALIVC_DATA_FILE = new File(getSDKContext().getCacheDir(), DATA_DIRECTORY);
        }
        File file = new File(ALIVC_DATA_FILE, UUID_FILE);
        try {
            if (ALIVC_DATA_FILE.exists() || ALIVC_DATA_FILE.mkdir()) {
                Properties properties = new Properties();
                FileReader fileReader = new FileReader(file);
                properties.load(fileReader);
                fileReader.close();
                sDeviceUUID = properties.getProperty(UUID_PROP);
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(sDeviceUUID)) {
            sWriteUUIDCount = 0;
            String strReplace = UUID.randomUUID().toString().replace("-", "");
            sDeviceUUID = strReplace;
            writeUUIDToFile(file, strReplace);
        }
        return sDeviceUUID;
    }

    public static String getElectricUsageRatio() {
        if (sAppContext == null) {
            return "0";
        }
        try {
            Intent intentRegisterReceiver = sAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return String.valueOf((int) (((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1) / (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1)) * 100.0f));
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String getGPUInfo() {
        return "";
    }

    public static String getMemoryTotal() {
        try {
            Context context = sAppContext;
            if (context == null) {
                return "0";
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return ((int) (memoryInfo.totalMem / 1048576.0f)) + "";
        } catch (Exception unused) {
            return "0";
        }
    }

    public static String getMemoryUsage() {
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) sAppContext.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo.length == 0) {
            return "0";
        }
        return (processMemoryInfo[0].getTotalPss() / 1024.0f) + "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) sAppContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "NoActive";
            }
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return subtypeName;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return "Mobile:" + subtypeName;
                    }
                    return "3G";
            }
        } catch (Exception unused) {
            return "Unknow";
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getOpenGLVersion() {
        ConfigurationInfo deviceConfigurationInfo;
        Context context = sAppContext;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
                return null;
            }
            return Integer.toHexString(Integer.parseInt(deviceConfigurationInfo.reqGlEsVersion + ""));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getSDKContext() {
        return sAppContext;
    }

    public static String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getTerminalType() {
        try {
            Context context = sAppContext;
            return (context == null || context.getResources() == null || sAppContext.getResources().getConfiguration() == null || (sAppContext.getResources().getConfiguration().screenLayout & 15) < 3) ? "phone" : "pad";
        } catch (Throwable unused) {
            return "phone";
        }
    }

    private static String getUIModeType() throws Exception {
        int currentModeType = ((UiModeManager) sAppContext.getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 1) {
            return "NORMAL";
        }
        if (currentModeType == 2) {
            return "DESK";
        }
        if (currentModeType == 3) {
            return "CAR";
        }
        if (currentModeType == 4) {
            return "TELEVISION";
        }
        if (currentModeType == 6) {
            return "WATCH";
        }
        if (currentModeType != 7) {
            return currentModeType != 15 ? "UNDEFINED" : "MASK";
        }
        return "VR_HEADSET";
    }

    public static void loadClass() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NativeUsed
    private static String native_getDeviceInfo(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -2133529830:
                if (str.equals("device_manufacturer")) {
                    b11 = 0;
                }
                break;
            case -1628011446:
                if (str.equals("cpu_usage")) {
                    b11 = 1;
                }
                break;
            case -1453464803:
                if (str.equals("terminal_type")) {
                    b11 = 2;
                }
                break;
            case -1287148950:
                if (str.equals("application_id")) {
                    b11 = 3;
                }
                break;
            case -1182845946:
                if (str.equals("os_name")) {
                    b11 = 4;
                }
                break;
            case -1117382559:
                if (str.equals("gpu_info")) {
                    b11 = 5;
                }
                break;
            case -1010275000:
                if (str.equals("opengl_version")) {
                    b11 = 6;
                }
                break;
            case -977897239:
                if (str.equals("application_version")) {
                    b11 = 7;
                }
                break;
            case -902394881:
                if (str.equals("electric_usage")) {
                    b11 = 8;
                }
                break;
            case -601148322:
                if (str.equals("device_brand")) {
                    b11 = 9;
                }
                break;
            case -591076352:
                if (str.equals("device_model")) {
                    b11 = 10;
                }
                break;
            case -553266608:
                if (str.equals("cache_dir")) {
                    b11 = Ascii.VT;
                }
                break;
            case -379364393:
                if (str.equals("can_get_context")) {
                    b11 = Ascii.FF;
                }
                break;
            case -19457365:
                if (str.equals("network_type")) {
                    b11 = Ascii.CR;
                }
                break;
            case 589850:
                if (str.equals("application_name")) {
                    b11 = Ascii.SO;
                }
                break;
            case 3601339:
                if (str.equals("uuid")) {
                    b11 = Ascii.SI;
                }
                break;
            case 216651451:
                if (str.equals("cpu_processor")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 501310693:
                if (str.equals("cpu_info")) {
                    b11 = 17;
                }
                break;
            case 672836989:
                if (str.equals("os_version")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 1000114701:
                if (str.equals("device_feature")) {
                    b11 = 19;
                }
                break;
            case 1270116442:
                if (str.equals("mem_total")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 1271141047:
                if (str.equals("mem_usage")) {
                    b11 = Ascii.NAK;
                }
                break;
        }
        switch (b11) {
            case 0:
                return getDeviceManufacturer();
            case 1:
                return getCPUUsageRatio();
            case 2:
                return getTerminalType();
            case 3:
                return getSDKContext().getPackageName();
            case 4:
                return "android";
            case 5:
                return getGPUInfo();
            case 6:
                return getOpenGLVersion();
            case 7:
                return getApplicationVersion();
            case 8:
                return getElectricUsageRatio();
            case 9:
                return getDeviceBrand();
            case 10:
                return getDeviceModel();
            case 11:
                return getCacheDir();
            case 12:
                return canGetContext();
            case 13:
                return getNetworkType();
            case 14:
                return getApplicationName();
            case 15:
                return getDeviceUUID();
            case 16:
                return getCPUProcessorInfo();
            case 17:
                return getCPUInfo();
            case 18:
                return getOSVersion();
            case 19:
                return getDeviceFeature();
            case 20:
                return getMemoryTotal();
            case 21:
                return getMemoryUsage();
            default:
                return "";
        }
    }

    private static void putFeature(JSONObject jSONObject, String str) {
        try {
            jSONObject.put(str, sAppContext.getPackageManager().hasSystemFeature(str) ? "1" : "0");
        } catch (Exception unused) {
        }
    }

    private static void requestCPUInfo() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th2;
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String line = bufferedReader.readLine();
                    int i11 = 0;
                    while (true) {
                        i11++;
                        if (i11 < 30) {
                            String[] strArrSplit = line.split(":\\s+", 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].contains("Processor")) {
                                sCpuProcessorInfo = strArrSplit[1];
                            }
                            if (!TextUtils.isEmpty(sCpuProcessorInfo)) {
                                break;
                            } else {
                                line = bufferedReader.readLine();
                            }
                        } else {
                            break;
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused3) {
                    }
                } catch (Exception unused4) {
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (bufferedReader == null) {
                        return;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (bufferedReader == null) {
                        throw th2;
                    }
                    try {
                        bufferedReader.close();
                        throw th2;
                    } catch (IOException unused7) {
                        throw th2;
                    }
                }
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                th2 = th4;
            }
        } catch (Exception unused9) {
            bufferedReader = null;
        } catch (Throwable th5) {
            bufferedReader = null;
            th2 = th5;
            fileReader = null;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused10) {
        }
    }

    public static void setSDKContext(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        sAppContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(final File file, final String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Timer().schedule(new TimerTask() { // from class: com.aliyun.utils.DeviceInfoUtils.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z11 = false;
                try {
                    boolean z12 = file.exists() || file.createNewFile();
                    Properties properties = new Properties();
                    properties.setProperty(DeviceInfoUtils.UUID_PROP, str);
                    if (z12) {
                        FileWriter fileWriter = new FileWriter(file);
                        properties.store(fileWriter, (String) null);
                        fileWriter.close();
                        z11 = true;
                    }
                } catch (Throwable unused) {
                }
                DeviceInfoUtils.access$008();
                if (z11 || DeviceInfoUtils.sWriteUUIDCount >= 10) {
                    return;
                }
                DeviceInfoUtils.writeUUIDToFile(file, str);
            }
        }, 3000L);
    }
}
