package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8C {
    public static AtomicInteger A00;
    public static byte[] A01;
    public static String[] A02 = {"TEIgz1GSUxi0w6HxI", "WqDufwBE7AlvD41n6qdN4YbCXU2LtDad", "95AkSvnB6didgYS0", "q9Pm9O4XheyxpjJIaV85netzFUNpUTJ1", "laKi0sQOm1cRNFPmXQKezZzTFfBBOlTJ", "R9By8R7rHrFXxi8d0eZrOpOQKJFwFXXr", "DNKj97yZe49oXEmfRz7aINNiwqbkjDQZ", "HsAQREGxpVIGFVt11mTJ2r8ajNtMZb1h"};
    public static final Object A03;
    public static final String A04;
    public static final Map<String, Integer> A05;
    public static final Set<String> A06;

    static {
        A06();
        A04 = C8C.class.getName();
        A03 = new Object();
        A06 = Collections.synchronizedSet(new HashSet());
        A05 = Collections.synchronizedMap(new HashMap());
        A00 = new AtomicInteger();
    }

    public static int A00(Context context) {
        return context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 79), context), 0).getInt(A02(75, 10, 19), 0) - A06.size();
    }

    public static C8E A01(String str, C11237f c11237f, Map<String, String> map) {
        C8E c8e = null;
        try {
            c8e = new C8E(c11237f.A08().A01(), c11237f.A08().A02(), new C11377y(str, map, true).A02());
            A0C(c8e, c11237f);
            return c8e;
        } catch (Exception unused) {
            return c8e;
        }
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static JSONArray A03(C11237f c11237f) {
        return A04(c11237f, -1);
    }

    public static JSONArray A04(C11237f c11237f, int i11) {
        AnonymousClass89 anonymousClass89A07;
        JSONArray jSONArray = new JSONArray();
        synchronized (A03) {
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            try {
                try {
                    if (new File(c11237f.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f)).exists()) {
                        fileInputStreamOpenFileInput = c11237f.openFileInput(ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f));
                        inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null || i11 == 0) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            if (!jSONObject.has(A02(260, 7, 27))) {
                                jSONObject.put(A02(260, 7, 27), String.valueOf(0));
                            }
                            String string = jSONObject.getString(A02(343, 2, WebSocketProtocol.PAYLOAD_SHORT));
                            if (!A06.contains(string)) {
                                int i12 = jSONObject.getInt(A02(260, 7, 27));
                                Map<String, Integer> map = A05;
                                if (map.containsKey(string)) {
                                    jSONObject.put(A02(260, 7, 27), String.valueOf(map.get(string)));
                                } else {
                                    A0E(string, i12);
                                }
                                jSONArray.put(jSONObject);
                                if (i11 > 0) {
                                    i11--;
                                }
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            e = e11;
                            anonymousClass89A07 = c11237f.A07();
                            anonymousClass89A07.A3c(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                } catch (IOException | JSONException e12) {
                    c11237f.A07().A3c(e12);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e13) {
                            e = e13;
                            anonymousClass89A07 = c11237f.A07();
                            anonymousClass89A07.A3c(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e14) {
                        c11237f.A07().A3c(e14);
                        throw th2;
                    }
                }
                if (0 != 0) {
                    inputStreamReader.close();
                }
                if (0 != 0) {
                    fileInputStreamOpenFileInput.close();
                }
                throw th2;
            }
        }
        return jSONArray;
    }

    public static JSONObject A05(C8E c8e) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A02(343, 2, WebSocketProtocol.PAYLOAD_SHORT), UUID.randomUUID().toString());
        jSONObject.put(A02(406, 4, 93), c8e.A03());
        jSONObject.put(A02(402, 4, 127), C1453Lf.A02(c8e.A01()));
        jSONObject.put(A02(355, 12, 71), C1453Lf.A02(c8e.A00()));
        jSONObject.put(A02(345, 10, 113), c8e.A02());
        jSONObject.put(A02(267, 4, 64), c8e.A04() != null ? new JSONObject(c8e.A04()) : new JSONObject());
        jSONObject.put(A02(260, 7, 27), String.valueOf(0));
        return jSONObject;
    }

    public static void A06() {
        A01 = new byte[]{7, 95, 83, 55, 1, Ascii.FS, 3, 48, Ascii.FS, 6, Ascii.GS, 7, Ascii.SYN, 1, 73, 83, Utf8.REPLACEMENT_BYTE, Ascii.GS, Ascii.DC2, 91, 8, 92, Ascii.CAN, Ascii.EM, Ascii.DLE, Ascii.EM, 8, Ascii.EM, 92, Ascii.CAN, Ascii.EM, Ascii.RS, 9, Ascii.ESC, 92, Ascii.EM, 10, Ascii.EM, Ascii.DC2, 8, Ascii.SI, 92, Ascii.SUB, Ascii.NAK, Ascii.DLE, Ascii.EM, 82, Ascii.SO, 44, 35, 106, 57, 109, 41, 40, 33, 40, 57, 40, 109, 43, 36, 33, 40, 108, 119, 118, 113, 102, 116, 108, 99, 97, 118, 117, 42, Ascii.EM, 10, 1, Ascii.ESC, 44, 0, Ascii.SUB, 1, Ascii.ESC, 41, 45, 46, Ascii.SUB, Ascii.VT, 6, 10, 1, Ascii.FF, 10, 33, 10, Ascii.ESC, Ascii.CAN, 0, Ascii.GS, 4, Ascii.US, 58, 61, 40, 42, 111, 43, 42, 45, 58, 40, 111, 42, 57, 42, 33, 59, 60, 111, 41, 38, 35, 42, 97, 69, 9, 38, 35, 42, 111, 60, 38, 53, 42, 117, 111, 111, 87, 85, 76, 76, 89, 88, Ascii.FS, 89, 74, 89, 82, 72, 79, Ascii.DC2, 40, Ascii.DLE, Ascii.DC2, Ascii.VT, Ascii.VT, Ascii.DC2, Ascii.NAK, Ascii.FS, 91, Ascii.CAN, Ascii.DC4, 9, 9, Ascii.SO, Ascii.VT, Ascii.SI, Ascii.RS, Ascii.US, 91, Ascii.US, Ascii.RS, Ascii.EM, Ascii.SO, Ascii.FS, 91, Ascii.RS, Ascii.CR, Ascii.RS, Ascii.NAK, Ascii.SI, 91, Ascii.ETB, Ascii.DC2, Ascii.NAK, Ascii.RS, 85, 98, 68, 79, 95, 88, 81, Ascii.SYN, 66, 89, Ascii.SYN, 67, 70, 82, 87, 66, 83, Ascii.SYN, 67, 88, 68, 83, 85, 89, 68, 82, 83, 82, Ascii.SYN, 82, 83, 84, 67, 81, 122, 89, 81, 115, 64, 83, 88, 66, Ascii.CAN, Ascii.SYN, 87, 82, 82, 95, 88, 81, Ascii.SYN, 66, 89, Ascii.SYN, 121, 88, 81, 89, 95, 88, 81, 115, 64, 83, 88, 66, Ascii.CAN, 58, 17, 0, 8, Ascii.NAK, 6, 19, 19, 2, 10, Ascii.ETB, 19, 88, 93, 72, 93, Ascii.DEL, 126, 68, 119, 116, 124, 124, 114, 117, 124, 43, 42, 45, 58, 40, 35, 32, 40, 60, 91, 84, 83, 84, 78, 85, 88, 89, Ascii.GS, 88, 75, 88, 83, 73, Ascii.GS, 78, 85, 82, 72, 81, 89, Ascii.GS, 83, 82, 73, Ascii.GS, 95, 88, Ascii.GS, 72, 77, 89, 92, 73, 88, 89, Ascii.GS, 73, 82, Ascii.GS, 114, 83, 90, 82, 84, 83, 90, 120, 75, 88, 83, 73, 19, 107, 102, 126, 104, 126, 126, 100, 98, 99, 82, 100, 105, 72, 94, 72, 72, 82, 84, 85, 100, 79, 82, 86, 94, 105, 113, 115, 106, 106, Ascii.DEL, 126, 95, 108, Ascii.DEL, 116, 110, 105, 58, 39, 58, 49, 55, 32, 54, 59, 50, 39, 75, 77, 90, 76, 65, 72, 93, 103, 91, 87, 92, 93, 119, 106, 110, 102, 85, 88, 81, 68};
    }

    public static void A07(Context context) {
        synchronized (A03) {
            File file = new File(context.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 51), context));
            if (file.exists()) {
                file.delete();
            }
            A09(context, 0);
            A06.clear();
            A05.clear();
        }
    }

    public static void A08(Context context) {
        A09(context, context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 79), context), 0).getInt(A02(75, 10, 19), 0) + 1);
    }

    public static void A09(Context context, int i11) {
        context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 79), context), 0).edit().putInt(A02(75, 10, 19), i11 >= 0 ? i11 : 0).apply();
    }

    public static void A0A(C11237f c11237f, String str) {
        File file = new File(c11237f.getFilesDir(), str);
        if (!file.exists() || file.delete()) {
            return;
        }
        c11237f.A07().A3c(new RuntimeException(A02(47, 18, 49)));
    }

    public static void A0B(C1794Ym c1794Ym, String str) {
        Map<String, Integer> map = A05;
        Integer num = map.get(str);
        if (num == null) {
            if (c1794Ym.A04().A8z()) {
                Log.e(A04, A02(PsExtractor.PRIVATE_STREAM_1, 66, 74));
            }
            num = 0;
        } else {
            map.remove(str);
        }
        map.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public static void A0C(C8E c8e, C11237f c11237f) {
        if (c8e == null || c11237f == null) {
            return;
        }
        synchronized (A03) {
            try {
                String processSpecificName = ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f);
                File file = new File(c11237f.getFilesDir(), processSpecificName);
                if (file.exists()) {
                    int iA07 = Ij.A07(c11237f);
                    long length = file.length();
                    if (iA07 > 0 && length > iA07) {
                        boolean zDelete = file.delete();
                        A09(c11237f, 0);
                        A06.clear();
                        A05.clear();
                        if (zDelete) {
                            Map<String, String> mapA4n = c11237f.A03().A4n();
                            mapA4n.put(A02(383, 7, 62), A02(271, 10, Worker.WHAT_SYNC_DATA));
                            mapA4n.put(A02(390, 12, 68), String.valueOf(2401));
                            A01(A02(102, 36, 51) + length + A02(1, 15, 15) + A00.getAndIncrement(), c11237f, mapA4n);
                            return;
                        }
                        Log.e(A02(85, 17, 19), A02(16, 31, 0));
                    }
                }
                JSONObject jSONObjectA05 = A05(c8e);
                FileOutputStream fileOutputStreamOpenFileOutput = c11237f.openFileOutput(processSpecificName, 32768);
                fileOutputStreamOpenFileOutput.write((jSONObjectA05.toString() + A02(0, 1, 113)).getBytes());
                fileOutputStreamOpenFileOutput.close();
                A08(c11237f);
            } catch (Exception e11) {
                c11237f.A07().A3c(e11);
            }
        }
    }

    public static void A0D(String str) {
        A05.remove(str);
        A06.add(str);
    }

    public static void A0E(String str, int i11) {
        if (A06.contains(str)) {
            throw new RuntimeException(A02(290, 53, 65));
        }
        Map<String, Integer> map = A05;
        boolean zContainsKey = map.containsKey(str);
        if (A02[7].charAt(23) == 'F') {
            throw new RuntimeException();
        }
        A02[6] = "rEqe91lv7lznGuMpeMm8YlOivWfc8wjs";
        if (zContainsKey) {
            map.remove(str);
        }
        map.put(str, Integer.valueOf(i11));
    }

    public static boolean A0F(C11237f c11237f) {
        if (Ij.A0O(c11237f)) {
            return A0H(c11237f);
        }
        boolean zA0G = A0G(c11237f);
        String[] strArr = A02;
        if (strArr[0].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "3ABJ1YchwKShiC4YrWnTlA0erUDCQvCN";
        strArr2[1] = "wuaZskSkctYpKQ1vHIoiu3NDqUJM9HRQ";
        return zA0G;
    }

    public static boolean A0G(C11237f c11237f) {
        JSONArray jSONArray = new JSONArray();
        synchronized (A03) {
            int i11 = 0;
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    if (new File(c11237f.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f)).exists()) {
                        fileInputStreamOpenFileInput = c11237f.openFileInput(ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f));
                        inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            String string = jSONObject.getString(A02(343, 2, WebSocketProtocol.PAYLOAD_SHORT));
                            if (!A06.contains(string)) {
                                Map<String, Integer> map = A05;
                                if (map.containsKey(string)) {
                                    Integer num = map.get(string);
                                    Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 0);
                                    int iA02 = Ij.A02(c11237f);
                                    if (iA02 <= -1 || numValueOf.intValue() <= iA02 - 1) {
                                        jSONObject.put(A02(260, 7, 27), String.valueOf(numValueOf));
                                        jSONArray.put(jSONObject);
                                    } else {
                                        A0D(string);
                                        i11++;
                                    }
                                } else {
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        int length = jSONArray.length();
                        for (int i12 = 0; i12 < length; i12++) {
                            sb2.append(jSONArray.getJSONObject(i12).toString()).append('\n');
                        }
                        fileOutputStreamOpenFileOutput = c11237f.openFileOutput(ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f), 0);
                        fileOutputStreamOpenFileOutput.write(sb2.toString().getBytes());
                    }
                    A09(c11237f, A00(c11237f));
                    if (i11 > 0) {
                        c11237f.A07().A9a(A02(271, 10, Worker.WHAT_SYNC_DATA), C8A.A2W, new C8B(A02(TsExtractor.TS_STREAM_TYPE_DTS, 15, 64), A02(367, 16, 102) + i11));
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            c11237f.A07().A3c(e11);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    A06.clear();
                    A05.clear();
                    return true;
                } catch (Throwable th2) {
                    if (0 != 0) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e12) {
                            c11237f.A07().A3c(e12);
                            A06.clear();
                            A05.clear();
                            throw th2;
                        }
                    }
                    if (0 != 0) {
                        inputStreamReader.close();
                    }
                    if (0 != 0) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (0 != 0) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    A06.clear();
                    A05.clear();
                    throw th2;
                }
            } catch (IOException | JSONException e13) {
                c11237f.A07().A3c(e13);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e14) {
                        c11237f.A07().A3c(e14);
                        A06.clear();
                        A05.clear();
                        return false;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStreamOpenFileInput != null) {
                    fileInputStreamOpenFileInput.close();
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
                A06.clear();
                A05.clear();
                return false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0227 A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x022c A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0231 A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0236 A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x023b A[Catch: IOException -> 0x023f, all -> 0x0252, TRY_LEAVE, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x005d A[SYNTHETIC] */
    public static boolean A0H(C11237f c11237f) {
        int iIntValue;
        synchronized (A03) {
            int i11 = 0;
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            FileInputStream fileInputStreamOpenFileInput2 = null;
            FileOutputStream fileOutputStreamOpenFileOutput2 = null;
            try {
                try {
                    String processSpecificName = ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c11237f);
                    File file = new File(c11237f.getFilesDir(), processSpecificName);
                    String str = processSpecificName + A02(255, 5, 25);
                    A0A(c11237f, str);
                    if (file.exists()) {
                        fileOutputStreamOpenFileOutput2 = c11237f.openFileOutput(str, 32768);
                        fileInputStreamOpenFileInput = c11237f.openFileInput(processSpecificName);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        try {
                                            JSONObject jSONObject = new JSONObject(line);
                                            String string = jSONObject.getString(A02(343, 2, WebSocketProtocol.PAYLOAD_SHORT));
                                            if (!A06.contains(string)) {
                                                Map<String, Integer> map = A05;
                                                if (map.containsKey(string)) {
                                                    try {
                                                        Integer num = map.get(string);
                                                        if (num != null) {
                                                            try {
                                                                iIntValue = num.intValue();
                                                            } catch (IOException e11) {
                                                                e = e11;
                                                            } catch (JSONException e12) {
                                                                e = e12;
                                                                if (c11237f.A04().A8z()) {
                                                                    Log.e(A04, A02(153, 36, 7), e);
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                if (bufferedReader != null) {
                                                                    try {
                                                                        bufferedReader.close();
                                                                    } catch (IOException e13) {
                                                                        c11237f.A07().A3c(e13);
                                                                        A06.clear();
                                                                        A05.clear();
                                                                        throw th;
                                                                    }
                                                                }
                                                                if (inputStreamReader != null) {
                                                                    inputStreamReader.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput != null) {
                                                                    fileInputStreamOpenFileInput.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput != null) {
                                                                    fileOutputStreamOpenFileOutput.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput2 != null) {
                                                                    fileInputStreamOpenFileInput2.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput2 != null) {
                                                                    fileOutputStreamOpenFileOutput2.close();
                                                                }
                                                                A06.clear();
                                                                A05.clear();
                                                                throw th;
                                                            }
                                                        } else {
                                                            iIntValue = 0;
                                                        }
                                                        Integer numValueOf = Integer.valueOf(iIntValue);
                                                        int iA02 = Ij.A02(c11237f);
                                                        if (iA02 > -1) {
                                                            try {
                                                                if (numValueOf.intValue() > iA02 - 1) {
                                                                    try {
                                                                        try {
                                                                            A0D(string);
                                                                            i11++;
                                                                        } catch (JSONException e14) {
                                                                            e = e14;
                                                                            if (c11237f.A04().A8z()) {
                                                                                Log.e(A04, A02(153, 36, 7), e);
                                                                            }
                                                                        }
                                                                    } catch (IOException e15) {
                                                                        e = e15;
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        if (bufferedReader != null) {
                                                                            bufferedReader.close();
                                                                        }
                                                                        if (inputStreamReader != null) {
                                                                            inputStreamReader.close();
                                                                        }
                                                                        if (fileInputStreamOpenFileInput != null) {
                                                                            fileInputStreamOpenFileInput.close();
                                                                        }
                                                                        if (fileOutputStreamOpenFileOutput != null) {
                                                                            fileOutputStreamOpenFileOutput.close();
                                                                        }
                                                                        if (fileInputStreamOpenFileInput2 != null) {
                                                                            fileInputStreamOpenFileInput2.close();
                                                                        }
                                                                        if (fileOutputStreamOpenFileOutput2 != null) {
                                                                            fileOutputStreamOpenFileOutput2.close();
                                                                        }
                                                                        A06.clear();
                                                                        A05.clear();
                                                                        throw th;
                                                                    }
                                                                }
                                                            } catch (IOException e16) {
                                                                e = e16;
                                                            } catch (JSONException e17) {
                                                                e = e17;
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                if (bufferedReader != null) {
                                                                    bufferedReader.close();
                                                                }
                                                                if (inputStreamReader != null) {
                                                                    inputStreamReader.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput != null) {
                                                                    fileInputStreamOpenFileInput.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput != null) {
                                                                    fileOutputStreamOpenFileOutput.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput2 != null) {
                                                                    fileInputStreamOpenFileInput2.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput2 != null) {
                                                                    fileOutputStreamOpenFileOutput2.close();
                                                                }
                                                                A06.clear();
                                                                A05.clear();
                                                                throw th;
                                                            }
                                                        }
                                                        jSONObject.put(A02(260, 7, 27), String.valueOf(numValueOf));
                                                        fileOutputStreamOpenFileOutput2.write((jSONObject.toString() + '\n').getBytes());
                                                    } catch (IOException e18) {
                                                        e = e18;
                                                    } catch (JSONException e19) {
                                                        e = e19;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                    }
                                                } else {
                                                    fileOutputStreamOpenFileOutput2.write((jSONObject.toString() + '\n').getBytes());
                                                }
                                            }
                                        } catch (JSONException e21) {
                                            e = e21;
                                        }
                                    } catch (IOException e22) {
                                        e = e22;
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                    c11237f.A07().A3c(e);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e23) {
                                            c11237f.A07().A3c(e23);
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (fileInputStreamOpenFileInput != null) {
                                        fileInputStreamOpenFileInput.close();
                                    }
                                    if (fileOutputStreamOpenFileOutput != null) {
                                        fileOutputStreamOpenFileOutput.close();
                                    }
                                    if (fileInputStreamOpenFileInput2 != null) {
                                        fileInputStreamOpenFileInput2.close();
                                    }
                                    if (fileOutputStreamOpenFileOutput2 != null) {
                                        fileOutputStreamOpenFileOutput2.close();
                                    }
                                    A06.clear();
                                    A05.clear();
                                    return false;
                                }
                                fileInputStreamOpenFileInput2 = c11237f.openFileInput(str);
                                fileOutputStreamOpenFileOutput = c11237f.openFileOutput(processSpecificName, 0);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i12 = fileInputStreamOpenFileInput2.read(bArr);
                                    if (i12 <= 0) {
                                        break;
                                    }
                                    fileOutputStreamOpenFileOutput.write(bArr, 0, i12);
                                }
                                fileInputStreamOpenFileInput2.close();
                                fileOutputStreamOpenFileOutput2.close();
                                A0A(c11237f, str);
                            } catch (IOException e24) {
                                e = e24;
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (IOException e25) {
                            e = e25;
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    }
                    A09(c11237f, A00(c11237f));
                    if (i11 > 0) {
                        c11237f.A07().A9a(A02(271, 10, Worker.WHAT_SYNC_DATA), C8A.A2W, new C8B(A02(TsExtractor.TS_STREAM_TYPE_DTS, 15, 64), A02(367, 16, 102) + i11));
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e26) {
                            c11237f.A07().A3c(e26);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    if (fileInputStreamOpenFileInput2 != null) {
                        fileInputStreamOpenFileInput2.close();
                    }
                    if (fileOutputStreamOpenFileOutput2 != null) {
                        fileOutputStreamOpenFileOutput2.close();
                    }
                    A06.clear();
                    A05.clear();
                    return true;
                } catch (IOException e27) {
                    e = e27;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        }
    }

    public static boolean A0I(String str) {
        return A06.contains(str) || A05.containsKey(str);
    }
}
