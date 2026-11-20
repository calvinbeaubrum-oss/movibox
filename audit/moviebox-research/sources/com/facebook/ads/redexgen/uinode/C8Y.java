package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8Y {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"qrNp1wG", "4f9SKAEMWw8LBpPH9ClfYFaSVVluVAOE", "62aVnpwn360RV3u8SEcmxFYidJmBvefX", "Gce9ySP9MgoEln4cNVrEo5sJO8CSkBrv", "GAv6eBsy68sSiadtgyjEU9blJSusD372", "OMedkGV5dbFzDsS0dZcen", "wlEAAxVLaYYUt0VSnPi", "2B4l1t7rFez9Iyb0KdS6JKEUq9HBo8Fu"};
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;
    public static final AtomicBoolean A06;

    static {
        A03();
        A06 = new AtomicBoolean();
        A04 = new AtomicBoolean();
        A05 = new AtomicBoolean();
    }

    public static YX A00() {
        return new YX();
    }

    public static YW A01(C1794Ym c1794Ym) {
        return new YW(c1794Ym);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[1].charAt(3) == 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "IDfTBPjSyvL4biEe7dLkbKSavqcQmadb";
            strArr[2] = "Oy3yacq1X2KDRnpIDSUXWs28RTZJmhMt";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 60);
            i14++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-55, -11, -55, -57, -12, -59, -54, -53, -66, -70, -71, -19, -36, -31, -35, -26, -37, -35, -58, -35, -20, -17, -25, -22, -29, -62, -77, -70, -113, -40, -35, -40, -29, -40, -48, -37, -40, -23, -48, -29, -40, -34, -35, -113, -30, -29, -48, -31, -29, -44, -45, -60, -43, -36, -111, -24, -46, -28, -111, -46, -35, -29, -42, -46, -43, -22, -111, -38, -33, -38, -27, -38, -46, -35, -38, -21, -42, -43, -110, -111, -60, -36, -38, -31, -31, -38, -33, -40, -97, -62, -40, -34, -119, -51, -40, -41, -112, -35, -119, -52, -54, -43, -43, -119, -86, -34, -51, -46, -50, -41, -52, -50, -73, -50, -35, -32, -40, -37, -44, -86, -51, -36, -105, -46, -41, -46, -35, -46, -54, -43, -46, -29, -50, -111, -110, -105, -119, -68, -40, -42, -50, -119, -49, -34, -41, -52, -35, -46, -40, -41, -54, -43, -46, -35, -30, -119, -42, -54, -30, -119, -41, -40, -35, -119, -32, -40, -37, -44, -119, -39, -37, -40, -39, -50, -37, -43, -30, -105, -66, -51, -58, -31, -33, -24, -33, -20, -29, -35, -9, -4, -9, 2, -9, -17, -6, -9, 8, -13, 5, 10, 5, Ascii.DLE, 5, -3, 8, 5, Ascii.SYN, 1, -60, -59, -68, 10, Ascii.VT, Ascii.DLE, -68, -1, -3, 8, 8, 1, 0, -54};
    }

    public static void A04(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        ExecutorC1456Li.A01.execute(new YY(initListener, initResult));
    }

    public static void A06(C1794Ym c1794Ym) {
        if (!Ij.A0P(c1794Ym) || A05.getAndSet(true)) {
            return;
        }
        try {
            Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass80(Thread.getDefaultUncaughtExceptionHandler(), c1794Ym, new YU()));
        } catch (Exception e11) {
            c1794Ym.A07().A9a(A02(181, 7, 62), C8A.A1X, new C8B(e11));
        }
    }

    public static void A07(C1794Ym c1794Ym) {
        A0G(c1794Ym, null, null, 3);
    }

    public static void A08(C1794Ym c1794Ym) {
        A0G(c1794Ym, null, null, 3);
    }

    public static void A09(C1794Ym c1794Ym) {
        if (C1384Ih.A1u(c1794Ym)) {
            A0E(c1794Ym, 0);
        }
        if (C1384Ih.A21(c1794Ym)) {
            A0B(c1794Ym);
        }
    }

    public static void A0A(C1794Ym c1794Ym) {
        if (C1384Ih.A1v(c1794Ym)) {
            A0F(c1794Ym, null, 3);
        }
    }

    public static void A0B(C1794Ym c1794Ym) {
        ExecutorC1467Lt.A06.execute(new YZ(c1794Ym));
    }

    public static void A0C(C1794Ym c1794Ym) {
        if (AbstractC1386Ik.A0A(c1794Ym)) {
            new C2C(c1794Ym).A0A(AbstractC1386Ik.A01.get());
        }
        AnonymousClass84.A0C(c1794Ym, new YT(c1794Ym), new C1785Yd(), BuildConfigApi.isDebug());
        c1794Ym.A09();
    }

    public static void A0E(C1794Ym c1794Ym, int i11) {
        AbstractC11227e.A01(c1794Ym);
        if (A04.getAndSet(true)) {
            return;
        }
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
            AbstractC1414Jp.A02();
        }
        A06(c1794Ym);
        KW.A00(C1384Ih.A0l(c1794Ym), BuildConfigApi.isDebug(), A00(), A01(c1794Ym));
        C6N.A03(C1384Ih.A03(c1794Ym));
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            C1606Rc.A09(new YV(c1794Ym));
        }
        if (i11 == 3) {
            Log.e(A02(8, 17, 60), A02(89, 89, 45));
            c1794Ym.A07().AA2(A02(178, 3, 33), C8A.A0R, new C8B(A02(198, 24, 96)));
        }
        ActivityUtils.A04(c1794Ym, AudienceNetworkActivity.class);
        ExecutorC1467Lt.A05(c1794Ym);
        JD.A05(c1794Ym);
        C09660w.A01(c1794Ym);
        if (C1384Ih.A0x(c1794Ym)) {
            C5J.A00(c1794Ym);
        }
        if (C1384Ih.A1W(c1794Ym)) {
            YL.A02().A7s(c1794Ym);
        }
    }

    public static void A0F(C1794Ym c1794Ym, AudienceNetworkAds.InitListener initListener, int i11) {
        AbstractC11227e.A01(c1794Ym);
        boolean z11 = false;
        synchronized (C8Y.class) {
            if (!A00) {
                if (i11 == 1 || i11 == 2) {
                    A00 = true;
                    z11 = true;
                } else if (i11 == 3 && !A01) {
                    A01 = true;
                    z11 = true;
                }
            }
        }
        if (z11) {
            A0E(c1794Ym, i11);
            ExecutorC1467Lt.A08.execute(new C1782Ya(c1794Ym, initListener));
        } else if (i11 == 1) {
            String strA02 = A02(51, 38, 53);
            if (initListener != null) {
                A04(initListener, new C8X(true, strA02));
            } else {
                Log.w(A02(8, 17, 60), strA02);
            }
        }
    }

    public static void A0G(C1794Ym c1794Ym, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener, int i11) {
        AbstractC1414Jp.A05(A02(188, 10, 82), A02(25, 26, 51), A02(0, 8, 87));
        C1606Rc.A06();
        A0F(c1794Ym, initListener, i11);
    }

    public static synchronized boolean A0H() {
        return A00;
    }
}
