package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.facebook.ads.RewardData;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ix, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HandlerC1398Ix extends Handler {
    public static byte[] A02;
    public static final String A03;
    public final Context A00;
    public final VW A01;

    static {
        A04();
        A03 = HandlerC1398Ix.class.getSimpleName();
    }

    public HandlerC1398Ix(Context context) {
        super(Looper.getMainLooper());
        this.A00 = context;
        this.A01 = VW.A00();
    }

    public static Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putString(A03(58, 23, 73), A03(0, 6, 6));
        bundle.putString(A03(40, 18, 14), new JSONObject().toString());
        return bundle;
    }

    private C1860aT A01(AnonymousClass26 anonymousClass26, String str) {
        C1860aT c1860aT = new C1860aT(anonymousClass26, this.A01, str);
        c1860aT.A0G(anonymousClass26.A0B(), anonymousClass26.A07());
        return c1860aT;
    }

    private C1857aQ A02(C2F c2f, String str) {
        C1857aQ c1857aQ = new C1857aQ(c2f, this.A01, str);
        c1857aQ.A0J(c2f.A05, c2f.A02, c2f.A08);
        return c1857aQ;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A02 = new byte[]{101, 93, 96, 102, 93, 95, -105, -92, -92, -95, -76, -98, -88, -76, -101, -86, -93, -93, -102, -95, -76, -95, -92, -100, -100, -102, -103, -11, -10, -12, 1, -29, -26, 1, -21, -26, 1, -19, -25, -5, -118, -117, -119, -106, -118, 124, -119, -115, -128, 122, 124, -106, 124, -113, -117, -119, 120, -118, -59, -58, -60, -47, -59, -73, -60, -56, -69, -75, -73, -47, -59, -74, -67, -47, -56, -73, -60, -59, -69, -63, -64};
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        PackageManager packageManager;
        if (KL.A02(this)) {
        }
        try {
            Messenger messenger = message.replyTo;
            if (message.what == 1) {
                if (messenger != null) {
                    VW.A00().A07(2, null, A00(), messenger);
                    return;
                }
                return;
            }
            String string = message.getData().getString(A03(27, 13, 121));
            if (string == null) {
                return;
            }
            C1795Yn c1795YnA05 = C10745c.A05(this.A00, string);
            c1795YnA05.A0E().AG1(message.getData().getBoolean(A03(6, 21, 44), false));
            String nameForUid = null;
            if (Build.VERSION.SDK_INT >= 21 && (packageManager = this.A00.getPackageManager()) != null) {
                nameForUid = packageManager.getNameForUid(message.sendingUid);
            }
            if (nameForUid == null) {
                if (messenger != null) {
                    VW.A00().A07(20, string, null, messenger);
                }
                c1795YnA05.A0E().AEk();
                return;
            }
            switch (message.what) {
                case 1010:
                    if (messenger != null) {
                        C1395Iu c1395IuA04 = VW.A00().A04(string);
                        if (c1395IuA04 == null) {
                            c1395IuA04 = VW.A00().A05(string, messenger, nameForUid);
                        }
                        AnonymousClass26 anonymousClass26A04 = C2L.A04(c1795YnA05, message.getData(), nameForUid);
                        if (c1395IuA04.A00 == null) {
                            c1395IuA04.A00 = A01(anonymousClass26A04, string);
                        } else if (c1395IuA04.A00 instanceof C1860aT) {
                            ((C1860aT) c1395IuA04.A00).A0G(anonymousClass26A04.A0B(), anonymousClass26A04.A07());
                        }
                        VW.A00().A07(1011, string, A00(), messenger);
                        break;
                    }
                    break;
                case 1012:
                case 2002:
                    VW.A00().A08(string);
                    break;
                case 2000:
                    if (messenger != null) {
                        C1395Iu c1395IuA05 = VW.A00().A04(string);
                        if (c1395IuA05 == null) {
                            c1395IuA05 = VW.A00().A05(string, messenger, nameForUid);
                        }
                        C2F c2fA05 = C2L.A05(c1795YnA05, message.getData(), nameForUid);
                        if (c1395IuA05.A00 == null) {
                            c1395IuA05.A00 = A02(c2fA05, string);
                        } else if (c1395IuA05.A00 instanceof C1857aQ) {
                            ((C1857aQ) c1395IuA05.A00).A0J(c2fA05.A05, c2fA05.A02, c2fA05.A08);
                        }
                        VW.A00().A07(2001, string, A00(), messenger);
                        break;
                    }
                    break;
                case 2003:
                    AnonymousClass23 anonymousClass23A03 = VW.A00().A03(string);
                    if (anonymousClass23A03 instanceof C1857aQ) {
                        RewardData rewardDataA01 = C2M.A01(message.getData());
                        C1857aQ c1857aQ = (C1857aQ) anonymousClass23A03;
                        if (rewardDataA01 != null) {
                            c1857aQ.A0I(rewardDataA01);
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
