package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VW implements C2K {
    public static VW A01;
    public static byte[] A02;
    public static String[] A03 = {"F9VPCRzHFTAYh6WHGcx0Jd90Enb3hSh2", "fH8nu2kqsRdgHbOq", "0ARAQCTuMPQjF7tJb0MjvB18yGPry4Qu", "N48QVONPfFEZdhqNPTKHT8FFB7x206Ht", "sPSH6DBrw2hyfCGwQm6LEVZ2ITL2jpSj", "gRA8laRbRDS4iSEHtkOaasMfi52gbS0", "x", "ATQcDE"};
    public static final String A04;
    public final LinkedHashMap<String, C1395Iu> A00 = new LinkedHashMap<>();

    static {
        A02();
        A04 = VW.class.getSimpleName();
    }

    public static VW A00() {
        VW vw2 = A01;
        if (A03[3].charAt(18) != 'K') {
            throw new RuntimeException();
        }
        A03[1] = "1qA3QfWMYYAsctqz";
        if (vw2 == null) {
            A01 = new VW();
        }
        VW vw3 = A01;
        String[] strArr = A03;
        if (strArr[5].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A03[3] = "jddXnAGVDmATkeoPPEKFEO5X5Iu6IeIG";
        return vw3;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{19, 4, Ascii.US, Ascii.NAK, Ascii.GS, Ascii.DC4, Ascii.SO, Ascii.DC4, 9, 5, 3, Ascii.DLE, 2, Ascii.SO, Ascii.SUB, Ascii.DC4, 8, 66, 99, 117, 114, 116, 105, Ascii.DEL, 99, 98, 38, 71, 98, 38, 84, 83, 85, 88, 70, 67, 88, 78, 67, 88, 76, 66, 94};
    }

    public final AnonymousClass23 A03(String str) {
        C1395Iu c1395Iu = this.A00.get(str);
        if (c1395Iu != null) {
            return c1395Iu.A00;
        }
        return null;
    }

    public final C1395Iu A04(String str) {
        return this.A00.get(str);
    }

    public final C1395Iu A05(String str, Messenger messenger, String str2) {
        C1395Iu c1395Iu = new C1395Iu(str, messenger, str2);
        this.A00.put(str, c1395Iu);
        return c1395Iu;
    }

    public final void A06() {
        Iterator<Map.Entry<String, C1395Iu>> it = this.A00.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C1395Iu> next = it.next();
            if (A03[0].charAt(11) == 'O') {
                throw new RuntimeException();
            }
            A03[1] = "vlvRe5nph1i3Qvfj";
            AnonymousClass23 anonymousClass23 = next.getValue().A00;
            if (anonymousClass23 != null) {
                anonymousClass23.destroy();
            }
            it.remove();
        }
    }

    public final void A07(int i11, String str, Bundle bundle, Messenger messenger) {
        try {
            Message messageObtain = Message.obtain((Handler) null, i11);
            if (str != null) {
                messageObtain.getData().putString(A01(30, 13, 6), str);
            }
            if (bundle != null) {
                messageObtain.getData().putBundle(A01(0, 17, 80), bundle);
            }
            messenger.send(messageObtain);
        } catch (RemoteException unused) {
            if (str != null) {
                A08(str);
            }
        }
    }

    public final void A08(String str) {
        C1395Iu c1395Iu = this.A00.get(str);
        if (c1395Iu == null || c1395Iu.A00 == null) {
            return;
        }
        String str2 = A01(17, 13, 7) + str;
        c1395Iu.A00.destroy();
        this.A00.remove(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.C2K
    public final void ACJ(int i11, String str, Bundle bundle) {
        C1395Iu c1395IuA04 = A04(str);
        if (c1395IuA04 != null) {
            A07(i11, str, bundle, c1395IuA04.A01);
        }
        Iterator<Map.Entry<String, C1395Iu>> it = this.A00.entrySet().iterator();
        while (it.hasNext()) {
            C1395Iu value = it.next().getValue();
            try {
                value.A01.send(Message.obtain((Handler) null, 3));
            } catch (RemoteException unused) {
                A08(value.A02);
            }
        }
    }
}
