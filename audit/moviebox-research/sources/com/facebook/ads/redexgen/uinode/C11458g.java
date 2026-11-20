package com.facebook.ads.redexgen.uinode;

import android.content.SharedPreferences;
import android.os.Build;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11458g {
    public static String A00;
    public static LA A01;
    public static byte[] A02;
    public static String[] A03 = {"pgH9SdtSFWTXX0l", "vxegEtvJMZ23RgjyHpc", "ulS7n8X7nNx1Irtm69lPCCFagtwQ2KXJ", "SMp4Mt4DU3EtKobKtaKcK4J1Rc2yK13N", "2t39yg7rltV6biRCRlaAvBIZnsjhSKww", "tY1PV27PV17ox8mww3so5aazg5RDJQQX", "2fotvTqtzlir49zwNSe", "KHZMFPmOyKnxl7a"};
    public static final Map<String, Integer> A04;
    public static final AtomicInteger A05;

    static {
        A05();
        A00 = null;
        A05 = new AtomicInteger(0);
        A04 = new HashMap();
    }

    public static synchronized LA A00(C11237f c11237f) {
        if (A01 == null) {
            A01 = LB.A00(c11237f);
        }
        return A01;
    }

    public static Integer A01(String str) {
        Map<String, Integer> map = A04;
        synchronized (map) {
            Integer num = map.get(str);
            if (num == null) {
                return 0;
            }
            return num;
        }
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A02 = new byte[]{-87, -56, -51, -41};
    }

    public static void A06(C11237f c11237f, String str, Map<String, String> map) {
        String strA03 = A0A(c11237f) ? C1427Kc.A03(str) : A00;
        if (strA03 != null) {
            map.put(A02(1, 3, 55), strA03);
        }
    }

    public static void A07(final C11237f c11237f, boolean z11) {
        if (A05.compareAndSet(0, 1)) {
            A00(c11237f);
            try {
                final SharedPreferences sharedPreferencesA00 = KE.A00(c11237f);
                final C8K c8k = new C8K(c11237f);
                final String str = Build.FINGERPRINT + A02(0, 1, 30) + c8k.A06();
                A00 = sharedPreferencesA00.getString(str, null);
                FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.facebook.ads.redexgen.X.8f
                    public static byte[] A04;
                    public static String[] A05 = {"CoyLTTqL9oN", "BQ7yf8H5Dy6", "lyn", "mKjKy3YozjHGjndyHmGPrtRgt1Zkpmof", "kCMvlxHItYqHUu0uJG5AXtsVRpKoPm5F", "PZWzUgGQe3CdPYsrWXqgA6txhpTzavVR", "1z7bJiu6sIQ4w4e4OAYhOvPnvUYdbbgv", "yc5QaeADf08N4Bq6BgqF"};

                    static {
                        A02();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                    public final Boolean call() throws Exception {
                        String strA01 = null;
                        if ((Build.VERSION.SDK_INT >= 31 || A01(0, 1, 52).equals(Build.VERSION.CODENAME)) && C1384Ih.A2G(c11237f)) {
                            if (A01(6, 19, 13).equals(c8k.A0B())) {
                                C11237f c11237f2 = c11237f;
                                strA01 = LG.A01(c11237f2, c11237f2.getPackageName());
                            }
                        }
                        if (A05[7].length() != 20) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A05;
                        strArr[0] = "qQmXUpBlhYC";
                        strArr[1] = "2roBSgd9zyy";
                        if (strA01 == null) {
                            C11237f c11237f3 = c11237f;
                            C11458g.A00 = C1427Kc.A02(c11237f3, c11237f3.getPackageName());
                        } else {
                            if (C1384Ih.A1I(c11237f)) {
                                C11237f c11237f4 = c11237f;
                                String strA02 = C1427Kc.A02(c11237f4, c11237f4.getPackageName());
                                C8B c8b = new C8B(A01(1, 5, 33));
                                c8b.A05(1);
                                c8b.A06(1);
                                c8b.A0A(false);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(A01(25, 5, 120), strA01);
                                jSONObject.put(A01(30, 5, 108), strA02);
                                c8b.A07(jSONObject);
                                c11237f.A07().A9b(A01(35, 7, 106), C8A.A1I, c8b);
                            }
                            C11458g.A00 = strA01;
                        }
                        sharedPreferencesA00.edit().putString(str, C11458g.A00).apply();
                        C11458g.A05.set(2);
                        return true;
                    }

                    public static String A01(int i11, int i12, int i13) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
                        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 127);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    public static void A02() {
                        A04 = new byte[]{Ascii.CAN, 61, 51, 46, 61, 45, 17, Ascii.GS, Ascii.US, 92, 19, Ascii.FS, Ascii.SYN, 0, Ascii.GS, Ascii.ESC, Ascii.SYN, 92, 4, Ascii.ETB, Ascii.FS, Ascii.SYN, Ascii.ESC, Ascii.FS, Ascii.NAK, 100, 116, 102, 119, 110, 112, 96, Ascii.DEL, 116, 112, 114, 112, 123, 112, 103, 124, 118};
                    }
                });
                Executors.newSingleThreadExecutor().submit(futureTask);
                if (z11) {
                    futureTask.get();
                }
            } catch (Exception unused) {
                AtomicInteger atomicInteger = A05;
                String[] strArr = A03;
                if (strArr[1].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[7] = "qnCKfAZ4ZrzI6TW";
                strArr2[0] = "3RwSqq6UclGHbC0";
                atomicInteger.set(0);
            }
        }
    }

    public static void A08(C11237f c11237f, boolean z11, String str) {
        if (A0A(c11237f)) {
            A09(c11237f, z11, str);
        } else {
            A07(c11237f, z11);
        }
    }

    public static void A09(C11237f c11237f, boolean z11, final String str) {
        if (str == null) {
            str = c11237f.getPackageName();
        }
        if (A0B(str)) {
            return;
        }
        A00(c11237f);
        final C1427Kc c1427Kc = new C1427Kc(c11237f, str);
        try {
            c1427Kc.A06();
            FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.facebook.ads.redexgen.X.8e
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                public final Boolean call() throws Exception {
                    c1427Kc.A05();
                    synchronized (C11458g.A04) {
                        C11458g.A04.put(str, 2);
                    }
                    return true;
                }
            });
            Executors.newSingleThreadExecutor().submit(futureTask);
            if (z11) {
                futureTask.get();
            }
        } catch (Exception unused) {
            Map<String, Integer> map = A04;
            synchronized (map) {
                map.put(str, 0);
            }
        }
    }

    public static boolean A0A(C11237f c11237f) {
        return ProcessUtils.isRemoteRenderingProcess() || C1384Ih.A2L(c11237f);
    }

    public static boolean A0B(String str) {
        Map<String, Integer> map = A04;
        synchronized (map) {
            if (A01(str).intValue() != 0) {
                return true;
            }
            map.put(str, 1);
            return false;
        }
    }
}
