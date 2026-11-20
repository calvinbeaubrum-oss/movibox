package com.facebook.ads.redexgen.uinode;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1427Kc {
    public static byte[] A05;
    public static String[] A06 = {"urwRhK0CK5UGRnO4iaICZFZb7qAlGy", "mzilr1wfe", "SZ9FDPGAkZBACw9tkVUtj7pHN9rS5abx", "dtKk7mnbAbd37arB17jMrf2UHdnm8GOF", "aS5", "gZFI9Tloea", "2aa2EaIeNK", "B3GaWiA9eOHa"};
    public static final Object A07;
    public static final Map<String, String> A08;
    public static final AtomicBoolean A09;
    public final SharedPreferences A00;
    public final C11237f A01;
    public final C8K A02;
    public final String A03;
    public final String A04;

    static {
        A04();
        A08 = new HashMap();
        A07 = new Object();
        A09 = new AtomicBoolean();
    }

    public C1427Kc(C11237f c11237f, String str) {
        this.A01 = c11237f;
        this.A03 = str;
        C8K c8k = new C8K(c11237f, str);
        this.A02 = c8k;
        this.A00 = KE.A00(c11237f);
        this.A04 = A01(1, 4, 27) + str + A01(0, 1, Worker.WHAT_SYNC_DATA) + c8k.A06();
    }

    private final String A00() {
        return this.A00.getString(this.A04, null);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(C11237f c11237f, String str) {
        try {
            PackageManager packageManager = c11237f.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return LG.A03(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e11) {
            if (A09.compareAndSet(false, true)) {
                c11237f.A07().A9a(A01(40, 7, 73), C8A.A1P, new C8B(e11));
            }
            return null;
        }
    }

    public static String A03(String str) {
        String str2;
        synchronized (A07) {
            str2 = A08.get(str);
        }
        return str2;
    }

    public static void A04() {
        String[] strArr = A06;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A06[1] = "McQY2w52D3qLTV4IvOql";
        A05 = new byte[]{116, 114, 117, 99, 8, 92, 121, 119, 106, 121, 105, 80, 92, 94, Ascii.GS, 82, 93, 87, 65, 92, 90, 87, Ascii.GS, 69, 86, 93, 87, 90, 93, 84, 71, 87, 69, 84, 77, 82, 66, 93, 86, 82, 6, 4, Ascii.SI, 4, 19, 8, 2};
    }

    public final void A05() throws JSONException {
        String strA01 = null;
        if ((Build.VERSION.SDK_INT >= 31 || A01(5, 1, 39).equals(Build.VERSION.CODENAME)) && C1384Ih.A2G(this.A01) && A01(11, 19, 27).equals(this.A02.A0B())) {
            strA01 = LG.A01(this.A01, this.A03);
        }
        if (strA01 == null) {
            strA01 = A02(this.A01, this.A03);
        } else if (C1384Ih.A1I(this.A01)) {
            String strA02 = A02(this.A01, this.A03);
            C8B c8b = new C8B(A01(6, 5, 50));
            c8b.A05(1);
            c8b.A06(1);
            c8b.A0A(false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A01(30, 5, 12), strA01);
            jSONObject.put(A01(35, 5, 25), strA02);
            c8b.A07(jSONObject);
            this.A01.A07().A9b(A01(40, 7, 73), C8A.A1I, c8b);
        }
        synchronized (A07) {
            A08.put(this.A03, strA01);
        }
        this.A00.edit().putString(this.A04, strA01).apply();
    }

    public final void A06() {
        String strA00 = A00();
        synchronized (A07) {
            A08.put(this.A03, strA00);
        }
    }
}
