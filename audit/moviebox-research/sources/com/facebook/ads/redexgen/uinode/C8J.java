package com.facebook.ads.redexgen.uinode;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8J, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8J {
    public static Sensor A00;
    public static Sensor A01;
    public static SensorEventListener A02;
    public static SensorEventListener A03;
    public static SensorManager A04;
    public static Map<String, String> A05;
    public static byte[] A06;
    public static String[] A07 = {"b6J5OF3acjfDP5XdyeFWlX714gZNNS0V", "bvdY52fd394YA8DHF2AacKmBhwZUhhl0", "30Yy9fi50QmMl9Boio33GGJ", "ecsdrzPzIBVEjJjtjF1fiRSY0Jbv5jtj", "QghajC4mni0N20aoGlTyG9Kdg8iFV0DW", "aGbfNp7N5f3KMLUY6R1I1ytOxUov95yg", "", ""};
    public static String[] A08;
    public static final AtomicReference<String> A09;
    public static volatile float[] A0A;
    public static volatile float[] A0B;

    static {
        A03();
        A04 = null;
        A00 = null;
        A01 = null;
        A05 = new ConcurrentHashMap();
        A08 = new String[]{A01(152, 1, 74), A01(153, 1, 74), A01(154, 1, 7)};
        A09 = new AtomicReference<>();
    }

    public static String A00() {
        return A09.get();
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static Map<String, String> A02() {
        HashMap map = new HashMap();
        map.putAll(A05);
        A0C(map);
        return map;
    }

    public static void A03() {
        A06 = new byte[]{-97, -12, -16, -14, -14, -12, -5, -12, 1, -2, -4, -12, 3, -12, 1, -18, -67, -65, -48, -59, -46, -59, -48, -43, 41, 54, 44, 58, 55, 49, 44, -10, 49, 54, 60, 45, 54, 60, -10, 41, 43, 60, 49, 55, 54, -10, 10, 9, Ascii.FS, Ascii.FS, Ascii.CR, Ascii.SUB, 33, 39, Ascii.VT, Ascii.DLE, 9, Ascii.SYN, Ascii.SI, Ascii.CR, Ascii.FF, Ascii.ETB, 44, Ascii.ETB, Ascii.US, 34, Ascii.ETB, Ascii.CAN, 34, Ascii.ESC, Ascii.NAK, 35, Ascii.ESC, 35, 37, 40, 47, 33, 32, 51, 51, 36, 49, 56, -4, 1, -6, Ascii.VT, 0, 2, 7, 0, 35, 47, 34, 34, Ascii.FS, 48, 45, Ascii.RS, 32, 34, -18, -20, -11, -20, -7, -16, -22, 19, Ascii.FF, Ascii.GS, Ascii.FF, 19, -60, -63, -58, -77, -58, -69, -63, -64, -79, -60, -76, -78, -67, -74, 4, -10, -1, 4, 0, 3, 8, 9, -10, 9, 10, 8, 45, 40, 45, Ascii.SUB, 37, Ascii.CAN, 38, Ascii.RS, 38, 40, 43, 50, Ascii.DLE, 17, -49};
    }

    public static synchronized void A06() {
        SensorManager sensorManager = A04;
        if (sensorManager != null) {
            sensorManager.unregisterListener(A02);
        }
        A02 = null;
    }

    public static synchronized void A07() {
        SensorManager sensorManager = A04;
        if (sensorManager != null) {
            sensorManager.unregisterListener(A03);
        }
        A03 = null;
    }

    public static void A08(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String strValueOf = String.valueOf(((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        A09.set(strValueOf);
        A05.put(A01(92, 10, 111), strValueOf);
    }

    public static void A09(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(A01(16, 8, 14))).getMemoryInfo(memoryInfo);
        A05.put(A01(61, 16, 104), String.valueOf(memoryInfo.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            A05.put(A01(140, 12, 107), String.valueOf(memoryInfo.totalMem));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context, com.facebook.ads.redexgen.X.7f] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.facebook.ads.redexgen.X.7f] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.content.Intent] */
    public static void A0A(C11237f c11237f) {
        try {
            c11237f = AbstractC1445Kx.A00(c11237f, null, new IntentFilter(A01(24, 37, 122)));
            if (c11237f == 0) {
                return;
            }
            int intExtra = c11237f.getIntExtra(A01(109, 5, 89), -1);
            int intExtra2 = c11237f.getIntExtra(A01(123, 5, 3), -1);
            int intExtra3 = c11237f.getIntExtra(A01(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 6, 71), -1);
            boolean z11 = intExtra3 == 2 || intExtra3 == 5;
            String[] strArr = A07;
            if (strArr[0].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "GHijperGL49tDJqi3Nx4WNVKDHMQfhGE";
            strArr2[3] = "9fIc9CBmAIH6SFr3nVJHHtzAM5Z6ICxj";
            A05.put(A01(77, 7, 113), String.valueOf(intExtra2 > 0 ? (intExtra / intExtra2) * 100.0f : 0.0f));
            A05.put(A01(84, 8, 75), z11 ? A01(1, 1, 117) : A01(0, 1, 33));
        } catch (IllegalArgumentException e11) {
            c11237f.A07().A9a(A01(102, 7, 57), C8A.A1T, new C8B(e11));
        }
    }

    public static synchronized void A0B(C11237f c11237f) {
        A09(c11237f);
        A0A(c11237f);
        if (A04 == null) {
            SensorManager sensorManager = (SensorManager) c11237f.getSystemService(A01(128, 6, 67));
            A04 = sensorManager;
            if (sensorManager == null) {
                return;
            }
        }
        if (A00 == null) {
            A00 = A04.getDefaultSensor(1);
        }
        if (A01 == null) {
            A01 = A04.getDefaultSensor(4);
        }
        C8G c8g = null;
        if (A02 == null) {
            C8H c8h = new C8H();
            A02 = c8h;
            Sensor sensor = A00;
            if (sensor != null) {
                A04.registerListener(c8h, sensor, 3);
            }
        }
        if (A03 == null) {
            C8I c8i = new C8I();
            A03 = c8i;
            Sensor sensor2 = A01;
            if (sensor2 != null) {
                A04.registerListener(c8i, sensor2, 3);
            }
        }
    }

    public static void A0C(Map<String, String> map) {
        float[] fArr = A0A;
        float[] fArr2 = A0B;
        if (fArr != null) {
            int iMin = Math.min(A08.length, fArr.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                map.put(A01(2, 14, 65) + A08[i11], String.valueOf(fArr[i11]));
            }
        }
        if (fArr2 != null) {
            int iMin2 = Math.min(A08.length, fArr2.length);
            for (int i12 = 0; i12 < iMin2; i12++) {
                map.put(A01(114, 9, 4) + A08[i12], String.valueOf(fArr2[i12]));
            }
        }
    }
}
