package com.facebook.ads.redexgen.uinode;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VT implements J1 {
    public static byte[] A0D;
    public static String[] A0E = {"uc0mqsrp7zbVSSUmEXyUZJQCGufws", "8g6ahr3vPydrTtk22", "YNqtB8iJmO2uVaHpbt6P5K9KH1grqDjF", "oDfi3coiS1yTvP0yt", "tbJDZpprNJoNbXk4MBqAl5O83qYFAo", "QKETic0g2MOurTT1w7cfpFQ", "PRNEoz9kKM8OadepDD5IPPYNQZFvnMHX", "tq93tXY5KQrS9ibGckbvCktGGZhVZKfr"};
    public static final String A0F;
    public int A00;
    public long A01;
    public final long A02;
    public final long A03;
    public final ConnectivityManager A04;
    public final C1794Ym A06;
    public final J0 A07;
    public final RK A08;
    public volatile boolean A0C;
    public final Runnable A0A = new VV(this);
    public final Runnable A09 = new VU(this);
    public final ThreadPoolExecutor A0B = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public final Handler A05 = new Handler(Looper.getMainLooper());

    static {
        A07();
        A0F = J1.class.getSimpleName();
    }

    public VT(C1794Ym c1794Ym, J0 j11) {
        this.A07 = j11;
        this.A06 = c1794Ym;
        this.A04 = (ConnectivityManager) c1794Ym.getSystemService(A03(293, 12, 10));
        this.A08 = C1606Rc.A01(c1794Ym);
        this.A03 = Ij.A0K(c1794Ym);
        this.A02 = Ij.A0J(c1794Ym);
    }

    public static /* synthetic */ int A00(VT vt2) {
        int i11 = vt2.A00 + 1;
        vt2.A00 = i11;
        return i11;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 88);
        }
        return new String(bArrCopyOfRange);
    }

    private void A05() {
        this.A06.A04().A8z();
        this.A00 = 0;
        this.A01 = 0L;
        if (this.A0B.getQueue().size() == 0) {
            this.A07.AAi();
        }
    }

    private void A06() {
        if (this.A00 >= Ij.A09(this.A06)) {
            A05();
            A5B();
        } else {
            if (this.A00 == 1) {
                this.A01 = Ij.A0I(this.A06);
            } else {
                this.A01 *= 2;
            }
            A5C();
        }
    }

    public static void A07() {
        A0D = new byte[]{-39, -22, -48, -44, -73, -36, -26, -29, -44, -25, -42, -37, -36, -31, -38, -109, -40, -23, -40, -31, -25, -109, -101, -45, 6, -15, -13, -2, 2, -9, -3, -4, -82, 5, -10, -9, -6, -13, -82, -14, -9, 1, -2, -17, 2, -15, -10, -9, -4, -11, -82, -13, 4, -13, -4, 2, 1, -68, -28, -10, 3, 7, -10, 3, -79, 1, 3, 0, -12, -10, 4, 4, -10, -11, -79, 1, -14, 3, 5, -6, -14, -3, -79, -13, -14, 5, -12, -7, -67, -79, -12, 0, -1, 5, -6, -1, 6, -6, -1, -8, -79, 5, 0, -79, -1, -10, 9, 5, -79, 0, -1, -10, -65, Ascii.ESC, 45, 58, 62, 45, 58, -24, 58, 45, 59, 56, 55, 54, 59, 45, -24, 49, 59, -24, 45, 53, 56, 60, 65, -10, -17, 1, Ascii.SO, Ascii.DC2, 1, Ascii.SO, -68, Ascii.SO, 1, Ascii.DLE, 17, Ascii.SO, 10, 1, 0, -68, -3, -68, 10, Ascii.VT, 10, -55, Ascii.SI, 17, -1, -1, 1, Ascii.SI, Ascii.SI, 2, 17, 8, -68, Ascii.SI, Ascii.DLE, -3, Ascii.DLE, 17, Ascii.SI, -68, -1, Ascii.VT, 0, 1, -68, Ascii.VT, 2, -68, -61, -43, -30, -26, -43, -30, -112, -25, -47, -29, -112, -27, -34, -47, -46, -36, -43, -112, -28, -33, -112, -32, -30, -33, -45, -43, -29, -29, -112, -47, -36, -36, -112, -43, -26, -43, -34, -28, -29, -100, -112, -28, -30, -23, -39, -34, -41, -112, -47, -41, -47, -39, -34, -98, -17, 7, 5, Ascii.FF, Ascii.FF, 5, 10, 3, -68, 0, 5, Ascii.SI, Ascii.FF, -3, Ascii.DLE, -1, 4, -68, 0, 17, 1, -68, Ascii.DLE, Ascii.VT, -68, 8, -3, -1, 7, -68, Ascii.VT, 2, -68, -1, Ascii.VT, 10, 10, 1, -1, Ascii.DLE, 5, Ascii.DC2, 5, Ascii.DLE, Ascii.NAK, -54, -31, -12, -12, -27, -19, -16, -12, -59, -47, -48, -48, -57, -59, -42, -53, -40, -53, -42, -37, 47, 44, Utf8.REPLACEMENT_BYTE, 44, -22, -5, -22, -13, -7, -8, 36, Ascii.NAK, 45, 32, 35, Ascii.NAK, Ascii.CAN};
    }

    private void A08(long j11) {
        this.A05.postDelayed(this.A09, j11);
    }

    private void A09(JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, String> entry : this.A06.A03().A4n().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    public final void A0B() {
        try {
            NetworkInfo activeNetworkInfo = this.A04.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                if (this.A06.A04().A8z()) {
                    Log.e(A0F, A03(240, 46, 68));
                }
                A08(this.A02);
                return;
            }
            this.A06.A04().A8z();
            JSONObject jSONObjectA4a = this.A07.A4a();
            if (jSONObjectA4a == null) {
                this.A06.A04().A8z();
                A05();
                return;
            }
            boolean zA8z = this.A06.A04().A8z();
            String strA03 = A03(309, 6, 45);
            if (zA8z && jSONObjectA4a.has(strA03)) {
                JSONArray jSONArray = jSONObjectA4a.getJSONArray(strA03);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    String str = A03(4, 19, 27) + i11 + A03(0, 3, 88) + jSONArray.get(i11);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A03(286, 7, 40), String.valueOf(this.A00));
            A09(jSONObject);
            jSONObjectA4a.put(A03(305, 4, 115), jSONObject);
            RY ry2 = new RY();
            ry2.put(A03(315, 7, 92), jSONObjectA4a.toString());
            RJ rjADz = this.A08.ADz(this.A06.A04().A73(), ry2.A08());
            String strA69 = rjADz != null ? rjADz.A69() : null;
            if (!TextUtils.isEmpty(strA69) && rjADz != null) {
                if (rjADz.A83() == 200) {
                    if (!this.A07.ABJ(new JSONArray(strA69))) {
                        if (this.A06.A04().A8z()) {
                            Log.w(A0F, A03(186, 54, 24));
                        }
                        A06();
                        return;
                    } else {
                        if (!this.A07.A9A()) {
                            A05();
                            return;
                        }
                        if (this.A06.A04().A8z()) {
                            Log.i(A0F, A03(58, 55, 57));
                        }
                        A06();
                        return;
                    }
                }
                if (this.A06.A04().A8z()) {
                    Log.e(A0F, A03(TsExtractor.TS_STREAM_TYPE_DTS, 48, 68) + rjADz.A83() + A03(3, 1, 78));
                }
                int iA83 = rjADz.A83();
                if (A0E[4].length() == 29) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[1] = "880m74azdbQx5kAj6";
                strArr[3] = "QSHShLBOeb5hWYBY9";
                if (iA83 == 413 && C1384Ih.A22(this.A06)) {
                    this.A07.ACo();
                    A05();
                    return;
                } else {
                    if (jSONObjectA4a.has(strA03)) {
                        this.A07.ABI(jSONObjectA4a.getJSONArray(strA03));
                    }
                    A06();
                    return;
                }
            }
            if (this.A06.A04().A8z()) {
                Log.e(A0F, A03(113, 25, 112));
            }
            if (C1384Ih.A1t(this.A06) && jSONObjectA4a.has(strA03)) {
                this.A07.ABI(jSONObjectA4a.getJSONArray(strA03));
            }
            A06();
        } catch (Exception e11) {
            if (this.A06.A04().A8z()) {
                Log.e(A0F, A03(23, 35, 54), e11);
            }
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.J1
    public final void A5B() {
        if (this.A0C) {
            return;
        }
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.J1
    public final void A5C() {
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A03);
    }
}
