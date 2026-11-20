package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5V implements AudienceNetworkActivityApi, Repairable {
    public static byte[] A0P;
    public static String[] A0Q = {"6hyfNvrTK6t0uOk4ZUiKTcly4lO9QIT3", "Cx5XWQG9gTlQcsVl0OO6K9WlulTSTZ", "4fLDdlgMQ2q", "AM05mUF2qaDkDYU3MyDNTK", "rN7iVf06fBiMXo1UDWoI2bEJDxOmVmjv", "9bqAz3M9pAQkcUJXzFdGLS", "1D1uNCEUmAwDpqE", "h0QQnxfLOYpp7kAK6sPhgGYv8wQTA65G"};
    public int A00;
    public int A02;
    public long A03;
    public long A04;
    public Intent A05;
    public RelativeLayout A06;
    public KB A07;
    public MD A08;
    public AbstractC1488Mo A09;
    public C1506Ng A0A;
    public C1575Px A0B;
    public String A0C;
    public String A0D;
    public String A0E;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final AudienceNetworkActivity A0L;
    public final AudienceNetworkActivityApi A0M;
    public final C1795Yn A0N;
    public final List<C5T> A0O = new ArrayList();
    public int A01 = -1;
    public boolean A0F = false;

    static {
        A0B();
    }

    public C5V(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        this.A0L = audienceNetworkActivity;
        this.A0M = audienceNetworkActivityApi;
        C1795Yn c1795YnA02 = C10745c.A02(audienceNetworkActivity);
        this.A0N = c1795YnA02;
        c1795YnA02.A0L(this);
    }

    private int A00() {
        Rect rect = new Rect();
        Window window = this.A0L.getWindow();
        if (window == null) {
            return 2;
        }
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return (rect.top >= 200 || rect.left >= 200) ? 0 : 1;
    }

    private MD A02(Intent intent) {
        C5S c5s = new C5S(this, intent, this.A0N.A09(), this.A0N, null);
        if (this.A07 == null) {
            return null;
        }
        switch (C5R.A00[this.A07.ordinal()]) {
            case 1:
                return c5s.A0I(this.A06);
            case 2:
                return c5s.A0R();
            case 3:
                MD mdA0P = c5s.A0P();
                if (A0Q[6].length() != 15) {
                    throw new RuntimeException();
                }
                A0Q[2] = "9AjKOltSNiH";
                return mdA0P;
            case 4:
                return c5s.A0H();
            case 5:
                return c5s.A02();
            case 6:
                return c5s.A0O();
            case 7:
                return c5s.A0N();
            case 8:
                return c5s.A0Q();
            case 9:
                MD mdA0G = c5s.A0G();
                if (A0Q[1].length() != 0) {
                    A0Q[1] = "wwrXZHO6We2";
                    return mdA0G;
                }
                A0Q[1] = "bd05r2lrBXgQHiU8zhW56DndFWzJq";
                return mdA0G;
            case 10:
                return c5s.A0L();
            case 11:
                MD mdA0J = c5s.A0J();
                if (A0Q[2].length() == 25) {
                    throw new RuntimeException();
                }
                A0Q[7] = "st3v0TpfdqXoPWlO02nQcse4uCAIapoF";
                return mdA0J;
            case 12:
                return c5s.A0K();
            case 13:
            case 14:
                MD mdA0M = c5s.A0M(this.A07);
                if (A0Q[7].charAt(27) == 'B') {
                    throw new RuntimeException();
                }
                A0Q[1] = "x";
                return mdA0M;
            case 15:
                return c5s.A0U();
            default:
                return null;
        }
    }

    private String A05() {
        KB kb2 = this.A07;
        String strA02 = kb2 != null ? kb2.A02() : null;
        return strA02 != null ? strA02 : A06(429, 4, 120);
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0P, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    private void A08() {
        String str = this.A0E;
        if (str != null) {
            C1575Px c1575PxA01 = AbstractC1574Pw.A01(this.A0N, str);
            this.A0B = c1575PxA01;
            if (c1575PxA01 != null) {
                this.A06.addView(this.A0B, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void A09() {
        if ((this.A0N.A0F().A01() || C1384Ih.A1c(this.A0N)) && Build.VERSION.SDK_INT >= 24) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.5Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A0M();
                }
            }, 1000L);
        }
    }

    private void A0A() {
        boolean z11 = !this.A0J || C1384Ih.A1a(this.A0N);
        if (this.A0I || !z11) {
            return;
        }
        if (A0I()) {
            A0G(QP.A03.A02());
        } else {
            A0G(A06(149, 48, 61));
        }
        this.A0I = true;
    }

    public static void A0B() {
        A0P = new byte[]{-3, 38, 71, 68, 87, 73, -36, -11, -24, -23, -13, -20, -89, -5, -10, -89, -16, -11, -19, -20, -7, -89, -3, -16, -20, -2, -37, 0, -9, -20, -89, -19, -7, -10, -12, -89, -16, -11, -5, -20, -11, -5, -89, -10, -7, -89, -6, -24, -3, -20, -21, -48, -11, -6, -5, -24, -11, -22, -20, -38, -5, -24, -5, -20, -12, 1, -14, -12, -10, 7, -4, 9, -4, 7, Ascii.FF, -44, -46, -35, -35, -42, -29, -59, -22, -31, -42, 1, 10, 7, 3, Ascii.FF, Ascii.DC2, -14, Ascii.CR, 9, 3, Ascii.FF, -32, -20, -22, -85, -29, -34, -32, -30, -33, -20, -20, -24, -85, -34, -31, -16, -85, -34, -31, -17, -30, -19, -20, -17, -15, -26, -21, -28, -85, -61, -58, -53, -58, -48, -59, -36, -66, -63, -36, -49, -62, -51, -52, -49, -47, -58, -53, -60, -36, -61, -55, -52, -44, Ascii.SI, Ascii.ESC, Ascii.EM, -38, Ascii.DC2, Ascii.CR, Ascii.SI, 17, Ascii.SO, Ascii.ESC, Ascii.ESC, Ascii.ETB, -38, Ascii.CR, Ascii.DLE, Ascii.US, -38, Ascii.NAK, Ascii.SUB, 32, 17, Ascii.RS, Ascii.US, 32, Ascii.NAK, 32, Ascii.NAK, Ascii.CR, Ascii.CAN, -38, Ascii.CR, Ascii.SI, 32, Ascii.NAK, 34, Ascii.NAK, 32, 37, Ascii.VT, Ascii.DLE, 17, Ascii.US, 32, Ascii.RS, Ascii.ESC, 37, 17, Ascii.DLE, -23, -11, -13, -76, -20, -25, -23, -21, -24, -11, -11, -15, -76, -25, -22, -7, -76, -17, -12, -6, -21, -8, -7, -6, -17, -6, -17, -25, -14, -76, -22, -17, -7, -13, -17, -7, -7, -21, -22, Ascii.DLE, Ascii.FS, Ascii.SUB, -37, 19, Ascii.SO, Ascii.DLE, Ascii.DC2, Ascii.SI, Ascii.FS, Ascii.FS, Ascii.CAN, -37, Ascii.SO, 17, 32, -37, Ascii.SYN, Ascii.ESC, 33, Ascii.DC2, Ascii.US, 32, 33, Ascii.SYN, 33, Ascii.SYN, Ascii.SO, Ascii.EM, -37, 17, Ascii.SYN, 32, Ascii.GS, Ascii.EM, Ascii.SO, 38, Ascii.DC2, 17, 54, 66, 64, 1, 57, 52, 54, 56, 53, 66, 66, 62, 1, 52, 55, 70, 1, 60, 65, 71, 56, 69, 70, 71, 60, 71, 60, 52, Utf8.REPLACEMENT_BYTE, 1, 56, 69, 69, 66, 69, 75, 87, 85, Ascii.SYN, 78, 73, 75, 77, 74, 87, 87, 83, Ascii.SYN, 73, 76, 91, Ascii.SYN, 81, 86, 92, 77, 90, 91, 92, 81, 92, 81, 73, 84, Ascii.SYN, 78, 81, 86, 81, 91, 80, 71, 73, 75, 92, 81, 94, 81, 92, 97, 40, 52, 50, -13, 43, 38, 40, 42, 39, 52, 52, 48, -13, 38, 41, 56, -13, 46, 51, 57, 42, 55, 56, 57, 46, 57, 46, 38, 49, -13, 46, 50, 53, 55, 42, 56, 56, 46, 52, 51, -13, 49, 52, 44, 44, 42, 41, 61, 78, 61, 70, 76, Ascii.SO, 3, Ascii.DLE, 6, Ascii.NAK, 5, 3, Ascii.DC2, 7, -10, -18, -19, -14, -22, -3, -14, -8, -9, -51, -22, -3, -22, 85, 92, 83, 83, 75, 82, 65, 78, 78, 69, 64, 65, 32, 81, 73, 76, 79, 85, 79, -10, -14, -25, -23, -21, -13, -21, -12, -6, -49, -22, 41, 40, 43, 45, 43, Ascii.SUB, 34, 45, -16, -14, -27, -28, -27, -26, -23, -18, -27, -28, -49, -14, -23, -27, -18, -12, -31, -12, -23, -17, -18, -53, -27, -7, 54, 41, 53, 57, 41, 55, 56, Ascii.CAN, 45, 49, 41, 87, 79, 77, 84, 37, 74, 88, 73, 86, 55, 73, 71, 83, 82, 72, 87, -4, -9, -25, -9, -6, -15, -19, -10, -4, -23, -4, -15, -9, -10, 95, 88, 83, 91, 95, 79, 51, 78, -17, -30, -34, -16, -51, -14, -23, -34};
    }

    private void A0C(Intent intent) {
        if (C1384Ih.A11(this.A0L)) {
            KB kb2 = this.A07;
            KB kb3 = KB.A03;
            if (A0Q[2].length() == 25) {
                throw new RuntimeException();
            }
            A0Q[1] = "ROWUzhbvPevH2";
            if (kb2 == kb3 || Build.VERSION.SDK_INT < 18) {
                return;
            }
            this.A0A = new C1506Ng();
            this.A0A.A0C(intent.getStringExtra(A06(448, 11, 23)));
            this.A0A.A0B(this.A0L.getPackageName());
            long longExtra = intent.getLongExtra(A06(491, 11, 85), 0L);
            if (longExtra != 0) {
                this.A0A.A09(longExtra);
            }
            TextView textView = new TextView(this.A0L);
            textView.setText(A06(1, 5, 115));
            textView.setTextColor(-1);
            AbstractC1462Lo.A0M(textView, Color.argb(160, 0, 0, 0));
            textView.setPadding(5, 5, 5, 5);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            textView.setLayoutParams(layoutParams);
            C5U c5u = new C5U(this, null);
            textView.setOnLongClickListener(c5u);
            this.A06.setOnLongClickListener(c5u);
            this.A06.getOverlay().add(this.A0A);
        }
    }

    private void A0D(Intent intent, Bundle bundle) {
        String strA06 = A06(540, 8, 10);
        String strA07 = A06(532, 8, 123);
        String strA08 = A06(467, 24, 17);
        if (bundle != null) {
            Bundle bundleA02 = C1433Kj.A02(bundle, DynamicLoaderImpl.class.getClassLoader());
            this.A01 = bundleA02.getInt(strA08, -1);
            this.A0C = bundleA02.getString(strA07);
            this.A07 = (KB) bundleA02.getSerializable(strA06);
            return;
        }
        this.A01 = intent.getIntExtra(strA08, -1);
        this.A0C = intent.getStringExtra(strA07);
        this.A07 = (KB) intent.getSerializableExtra(strA06);
        this.A02 = intent.getIntExtra(A06(502, 16, 117), 0) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    public void A0G(String str) {
        if (A06(355, 47, 86).equals(str) || QP.A0A.A02().equals(str)) {
            this.A0H = true;
        }
        if (A06(275, 35, 100).equals(str)) {
            this.A0G = true;
        } else {
            String strA02 = QP.A09.A02();
            if (A0Q[6].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0Q;
            strArr[5] = "BsUqgJlN3izr4734FAkiK4";
            strArr[3] = "DZ4pb9dksBh2p0w2isnwDh";
            if (strA02.equals(str)) {
                this.A0G = true;
            }
        }
        if (A06(96, 53, 14).equals(str)) {
            finish(9);
        } else if (A06(310, 45, 121).equals(str)) {
            finish(10);
        } else {
            A0P(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(String str, C09701a c09701a) {
        if (this.A08 == null) {
            return;
        }
        if (this.A09 == null) {
            C1795Yn c1795Yn = this.A0N;
            this.A09 = AbstractC1489Mp.A02(c1795Yn, c1795Yn.A09(), str, c09701a, this.A08, new ZW(this, null));
            this.A09.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        AbstractC1462Lo.A0J(this.A09);
        AbstractC1462Lo.A0T(this.A06);
        this.A06.addView(this.A09);
        this.A09.A0K();
    }

    private boolean A0I() {
        return this.A07 == KB.A0H || this.A07 == KB.A0G || this.A07 == KB.A08 || this.A07 == KB.A05 || this.A07 == KB.A0F;
    }

    public final AudienceNetworkActivity A0J() {
        return this.A0L;
    }

    public final C1795Yn A0K() {
        return this.A0N;
    }

    public final void A0L() {
        if (A0I()) {
            A0G(QP.A09.A02());
        } else {
            A0G(A06(275, 35, 100));
        }
    }

    public final /* synthetic */ void A0M() {
        if (this.A0L.isInMultiWindowMode()) {
            this.A0N.A0E().AA6(A00());
        }
    }

    public final void A0N(C5T c5t) {
        this.A0O.add(c5t);
    }

    public final void A0O(C5T c5t) {
        this.A0O.remove(c5t);
    }

    public final void A0P(String str, C11558q c11558q) {
        Intent intent = new Intent(str + A06(0, 1, 84) + this.A0C);
        if (c11558q != null) {
            intent.putExtra(A06(402, 5, 105), c11558q);
        }
        C10102o.A00(this.A0L).A07(intent);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AbstractC1439Kr.A00();
        if (0 != 0) {
            throw new NullPointerException(A06(433, 15, 109));
        }
        this.A0M.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void finish(int i11) {
        this.A0N.A0E().A2c(String.valueOf(A0J().hashCode()), i11, A05());
        if (this.A0L.isFinishing()) {
            return;
        }
        if (C1384Ih.A1U(this.A0N) && !this.A0H && !this.A0G) {
            this.A0N.A0E().AAX();
            A0L();
        }
        if (!A0I() || this.A0F) {
            A0G(A06(197, 39, 23));
        } else {
            A0G(QP.A05.A02());
        }
        this.A0J = true;
        A0A();
        this.A0M.finish(i11);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onActivityResult(int i11, int i12, Intent intent) {
        MD md2 = this.A08;
        if (md2 == null || !md2.onActivityResult(i11, i12, intent)) {
            U1.A09(i11, i12, intent);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onBackPressed() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = this.A03 + (jCurrentTimeMillis - this.A04);
        this.A03 = j11;
        this.A04 = jCurrentTimeMillis;
        if (j11 > this.A02) {
            boolean z11 = false;
            Iterator<C5T> it = this.A0O.iterator();
            while (it.hasNext()) {
                if (it.next().A8u()) {
                    z11 = true;
                }
            }
            if (z11) {
                return;
            }
            this.A0M.onBackPressed();
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.A00 != configuration.orientation) {
            HashMap map = new HashMap();
            int i11 = configuration.orientation;
            String strA06 = A06(518, 14, 25);
            if (i11 == 1) {
                map.put(strA06, A06(459, 8, 74));
            } else {
                map.put(strA06, A06(TTAdConstant.DOWNLOAD_APP_INFO_CODE, 9, 51));
            }
            J9 j11 = J9.A0K;
            MD md2 = this.A08;
            JA.A02(j11, map, md2 == null ? A06(0, 0, 50) : md2.getCurrentClientToken(), this.A0N.A09());
            this.A00 = configuration.orientation;
            A09();
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onCreate(Bundle bundle) {
        AbstractC1464Lq.A02();
        if (C1384Ih.A1p(this.A0L)) {
            Window window = this.A0L.getWindow();
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            A0Q[6] = "7njofUp2AYjKONZ";
            window.setFlags(16777216, 16777216);
        }
        Intent intentA01 = C1433Kj.A01(this.A0L.getIntent(), DynamicLoaderImpl.class.getClassLoader());
        this.A05 = intentA01;
        C1795Yn c1795YnA03 = C1433Kj.A03(intentA01);
        if (c1795YnA03 != null) {
            this.A0N.A0J(c1795YnA03.A0E());
            this.A0N.A0C(c1795YnA03.A0B());
            this.A0N.A0M(c1795YnA03.A0G());
        }
        A0D(this.A05, bundle);
        this.A0N.A0E().A2d(String.valueOf(A0J().hashCode()), A05());
        String stringExtra = this.A05.getStringExtra(A06(75, 10, 2));
        boolean z11 = stringExtra == null || !(stringExtra.equals(AdPlacementType.INTERSTITIAL.name()) || stringExtra.equals(AdPlacementType.REWARDED_VIDEO.name()));
        if (C1384Ih.A2N(this.A0N) && this.A07 == KB.A03 && z11) {
            this.A0L.getWindow().setFlags(512, 512);
        } else {
            this.A0L.requestWindowFeature(1);
            this.A0L.getWindow().setFlags(1024, 1024);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.A0L);
        this.A06 = relativeLayout;
        AbstractC1462Lo.A0M(relativeLayout, 0);
        this.A0L.setContentView(this.A06, new RelativeLayout.LayoutParams(-1, -1));
        MD mdA02 = A02(this.A05);
        this.A08 = mdA02;
        if (mdA02 == null) {
            this.A0N.A07().A9a(A06(64, 11, 36), C8A.A0A, new C8B(A06(6, 58, 24)));
            A0L();
            finish(7);
            return;
        }
        mdA02.A9Q(this.A05, bundle, this);
        A0G(A06(236, 39, 62));
        this.A04 = System.currentTimeMillis();
        this.A0E = this.A05.getStringExtra(A06(TTAdConstant.PACKAGE_NAME_CODE, 13, 26));
        A08();
        A0C(this.A05);
        this.A00 = this.A0L.getResources().getConfiguration().orientation;
        String strA06 = A06(85, 11, 47);
        if (bundle != null) {
            this.A0D = bundle.getString(strA06);
        } else {
            this.A0D = this.A05.getStringExtra(strA06);
        }
        if (!C1384Ih.A1x(this.A0L) || this.A0L.getWindow() == null) {
            return;
        }
        this.A0L.getWindow().addFlags(128);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0066  */
    /* JADX WARN: Code duplicated, block: B:17:0x006e  */
    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onDestroy() {
        this.A0N.A0E().A2e(String.valueOf(A0J().hashCode()), A05());
        A0A();
        RelativeLayout relativeLayout = this.A06;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        MD md2 = this.A08;
        if (md2 != null) {
            md2.onDestroy();
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            A0Q[1] = "BK5JyIukG";
            this.A08 = null;
        }
        C1506Ng c1506Ng = this.A0A;
        String[] strArr2 = A0Q;
        if (strArr2[0].charAt(26) == strArr2[4].charAt(26)) {
            A0Q[2] = "VoJV9dI9dal5KZ60JkB8i5Bpps";
            if (c1506Ng != null) {
                if (C1384Ih.A11(this.A0L)) {
                    this.A0A.A07();
                }
            }
        } else if (c1506Ng != null) {
            if (C1384Ih.A11(this.A0L)) {
                this.A0A.A07();
            }
        }
        AbstractC1488Mo abstractC1488Mo = this.A09;
        if (A0Q[2].length() != 25) {
            String[] strArr3 = A0Q;
            strArr3[5] = "rHb3ILEFnyWtMYiOwcguj0";
            strArr3[3] = "XKBHK5KZoSEcfbvzOM5yLt";
            if (abstractC1488Mo == null) {
                return;
            }
        } else if (abstractC1488Mo == null) {
            return;
        }
        abstractC1488Mo.A0J();
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onPause() {
        this.A0N.A0E().A2f(String.valueOf(A0J().hashCode()), A05());
        this.A03 += System.currentTimeMillis() - this.A04;
        MD md2 = this.A08;
        if (md2 != null) {
            md2.ACW(false);
            if (this.A0L.isFinishing()) {
                return;
            }
            JA.A02(J9.A0E, null, this.A08.getCurrentClientToken(), this.A0N.A09());
            this.A0K = true;
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onResume() {
        this.A0N.A0E().A2g(String.valueOf(A0J().hashCode()), A05());
        this.A04 = System.currentTimeMillis();
        MD md2 = this.A08;
        if (md2 != null) {
            md2.ACu(false);
            if (this.A0K) {
                JA.A02(J9.A0F, null, this.A08.getCurrentClientToken(), this.A0N.A09());
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        MD md2 = this.A08;
        if (md2 != null) {
            md2.AFT(bundle2);
        }
        bundle2.putInt(A06(467, 24, 17), this.A01);
        bundle2.putString(A06(532, 8, 123), this.A0C);
        bundle2.putString(A06(85, 11, 47), this.A0D);
        bundle2.putSerializable(A06(540, 8, 10), this.A07);
        C1433Kj.A09(bundle, bundle2);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStart() {
        this.A0N.A0E().A2h(String.valueOf(A0J().hashCode()), A05());
        int i11 = this.A01;
        if (i11 != -1) {
            M7.A02(this.A0L, i11, this.A0N);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStop() {
        this.A0N.A0E().A2i(String.valueOf(A0J().hashCode()), A05());
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.A0M.onTouchEvent(motionEvent);
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th2) {
        A0L();
        finish(5);
    }
}
