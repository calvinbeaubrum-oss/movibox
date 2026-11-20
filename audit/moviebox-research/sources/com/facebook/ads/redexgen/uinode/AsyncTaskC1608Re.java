package com.facebook.ads.redexgen.uinode;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Re, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC1608Re extends AsyncTask<String, Void, C1609Rf> {
    public static byte[] A05;
    public static String[] A06 = {"iMGBqiSHm2uYyOurEO", "JHkNge3qKUrOixxb", "Efd0ZU7p6XsOViiGEn9FTnCEMV0phXsZ", "Qqux8MYyckh5CceEy", "ksejtLtP", "6qwv67", "yXEFufBpuo", "JuPO8KFa"};
    public static final String A07;
    public static final Set<String> A08;
    public C11237f A00;
    public RJ A01;
    public InterfaceC1607Rd A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    static {
        A04();
        A07 = AsyncTaskC1608Re.class.getSimpleName();
        HashSet hashSet = new HashSet();
        A08 = hashSet;
        hashSet.add(A01(0, 1, 73));
        hashSet.add(A01(29, 4, 24));
    }

    public AsyncTaskC1608Re(C11237f c11237f) {
        this(c11237f, null, null);
    }

    public AsyncTaskC1608Re(C11237f c11237f, Map<String, String> map) {
        this(c11237f, map, null);
    }

    public AsyncTaskC1608Re(C11237f c11237f, Map<String, String> map, Map<String, String> map2) {
        this.A00 = c11237f;
        this.A03 = map != null ? new HashMap(map) : null;
        this.A04 = map2 != null ? new HashMap(map2) : null;
    }

    private final C1609Rf A00(String... strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A08.contains(str)) {
                String strA02 = A02(str);
                Map<String, String> map = this.A03;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        strA02 = A03(strA02, entry.getKey(), entry.getValue());
                    }
                }
                int i11 = 1;
                while (true) {
                    int i12 = i11 + 1;
                    if (i11 > 2) {
                        return null;
                    }
                    if (A06(strA02)) {
                        return new C1609Rf(this.A01);
                    }
                    i11 = i12;
                }
            }
            return null;
        } catch (Throwable th2) {
            KL.A00(th2, this);
            return null;
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 90);
        }
        return new String(bArrCopyOfRange);
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 65), LJ.A01(this.A00.A03().A61()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String strA01 = A01(3, 1, 92);
        if (str.contains(strA01)) {
            strA01 = A01(1, 1, 124);
        }
        return str + strA01 + str2 + A01(2, 1, 100) + URLEncoder.encode(str3);
    }

    public static void A04() {
        A05 = new byte[]{48, 0, 3, 57, 33, Ascii.SYN, Ascii.SYN, Ascii.VT, Ascii.SYN, 68, Ascii.VT, Ascii.DC4, 1, 10, Ascii.CR, 10, 3, 68, 17, Ascii.SYN, 8, 94, 68, 122, 117, 122, 119, 116, 124, 44, 55, 46, 46};
    }

    private final void A05(C1609Rf c1609Rf) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            InterfaceC1607Rd interfaceC1607Rd = this.A02;
            if (interfaceC1607Rd != null) {
                interfaceC1607Rd.AEC(c1609Rf);
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    private boolean A06(String str) {
        RJ rjADy;
        RK rkA00 = C1606Rc.A00(this.A00);
        try {
            Map<String, String> map = this.A04;
            if (map == null || map.size() == 0) {
                rjADy = rkA00.ADy(str, new RY());
            } else {
                RY ry2 = new RY();
                ry2.A05(this.A04);
                rjADy = rkA00.ADz(str, ry2.A08());
            }
            this.A01 = rjADy;
        } catch (Exception e11) {
            Log.e(A07, A01(4, 19, 62) + str, e11);
        }
        RJ rj2 = this.A01;
        String[] strArr = A06;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A06[2] = "iiLT70HajwBiOF9fGWlLisdNhF1wiwwV";
        return rj2 != null && rj2.A83() == 200;
    }

    public final void A07(InterfaceC1607Rd interfaceC1607Rd) {
        this.A02 = interfaceC1607Rd;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ C1609Rf doInBackground(String[] strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th2) {
            KL.A00(th2, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        InterfaceC1607Rd interfaceC1607Rd = this.A02;
        if (interfaceC1607Rd != null) {
            interfaceC1607Rd.AEA();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(C1609Rf c1609Rf) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(c1609Rf);
        } catch (Throwable th2) {
            if (A06[3].length() != 17) {
                throw new RuntimeException();
            }
            A06[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
            KL.A00(th2, this);
        }
    }
}
