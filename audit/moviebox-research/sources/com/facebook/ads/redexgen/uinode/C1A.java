package com.facebook.ads.redexgen.uinode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Serializable;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1A extends BroadcastReceiver {
    public static byte[] A03;
    public static String[] A04 = {"X1IVw5mZrPwWgp59pDL9aLZ3Fov3W2Wm", "N1AsLxATz8LfRIPBbwS0prqi9bKFNGwZ", "KvfN8PD7zJtQDsMeVTqT5dRzLvhiPQFs", "CwJ4sBopjGul5sxVyPsrv7O0APgi12j8", "riYYfsMk5nddhbnpPSj9znzkTr5bDpPf", "Be1xHvNUMQ0R9QZ", "t7JwnvsmbbV8km6q46", "oSYhwD14tF3vT8zAS1lFRiV2H2FAfEUD"};
    public Context A00;
    public C1215Ba A01;
    public boolean A02 = false;

    static {
        A01();
    }

    public C1A(C1215Ba c1215Ba, Context context) {
        this.A01 = c1215Ba;
        this.A00 = context;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{Ascii.EM, 3, Ascii.SI, Ascii.CR, 78, 6, 1, 3, 5, 2, Ascii.SI, Ascii.SI, Ascii.VT, 78, 1, 4, 19, 78, 9, Ascii.SO, Ascii.DC4, 5, Ascii.DC2, 19, Ascii.DC4, 9, Ascii.DC4, 9, 1, Ascii.FF, 78, 4, 9, 19, Ascii.DLE, Ascii.FF, 1, Ascii.EM, 5, 4, 19, Ascii.US, Ascii.GS, 94, Ascii.SYN, 17, 19, Ascii.NAK, Ascii.DC2, Ascii.US, Ascii.US, Ascii.ESC, 94, 17, Ascii.DC4, 3, 94, Ascii.EM, Ascii.RS, 4, Ascii.NAK, 2, 3, 4, Ascii.EM, 4, Ascii.EM, 17, Ascii.FS, 94, Ascii.DC4, Ascii.EM, 3, 0, Ascii.FS, 17, 9, Ascii.NAK, Ascii.DC4, 74, Ascii.DC2, 1, Ascii.DC2, Ascii.EM, 3, 81, 68, 83, 71, 78, 83, 76, 98, 85, 64, 98, 77, 72, 66, 74, 83, 70, 81, 69, 76, 81, 78, 96, 87, 66, 96, 79, 74, 64, 72, Ascii.EM, 45, 50, Utf8.REPLACEMENT_BYTE, 62, 52, Ascii.DC2, 53, 47, 62, 41, 40, 47, 50, 47, 58, 55, Ascii.RS, 45, 62, 53, 47, 2, Ascii.GS, Ascii.DLE, 17, Ascii.ESC, 61, Ascii.SUB, 0, 17, 6, 7, 0, Ascii.GS, 0, Ascii.NAK, Ascii.CAN, 49, 2, 17, Ascii.SUB, 0, 78};
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(40, 40, 17) + this.A01.getUniqueId());
        intentFilter.addAction(A00(137, 22, 21) + this.A01.getUniqueId());
        intentFilter.addAction(A00(100, 16, 66) + this.A01.getUniqueId());
        C10102o.A00(this.A00).A06(this, intentFilter);
    }

    public final void A03() {
        try {
            C10102o.A00(this.A00).A05(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String[] strArrSplit = intent.getAction().split(A00(0, 1, 66));
        if (strArrSplit.length == 2 && strArrSplit[1].equals(this.A01.getUniqueId())) {
            if (strArrSplit[0].equals(A00(1, 39, 1))) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().ABP();
                    this.A01.getListener().ADi();
                    return;
                }
                return;
            }
            String str = strArrSplit[0];
            if (A04[2].charAt(17) != 'T') {
                throw new RuntimeException();
            }
            A04[7] = "czH1g8WXqBVBzZgoSLVA20jYFFcQLh15";
            if (!str.equals(A00(116, 21, 58))) {
                if (strArrSplit[0].equals(A00(85, 15, 64))) {
                    this.A01.A0m();
                    return;
                }
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(A00(80, 5, 22));
            if (serializableExtra instanceof C1491Mr) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().ABV();
                    this.A01.getListener().ADi();
                }
                if (this.A02) {
                    this.A01.A0Y(1);
                } else {
                    this.A01.A0Y(((C1491Mr) serializableExtra).A01());
                }
                this.A01.setVisibility(0);
                this.A01.A0b(QM.A04, 1);
                return;
            }
            if (serializableExtra instanceof C1562Pk) {
                if (this.A01.getListener() != null) {
                    MP listener = this.A01.getListener();
                    if (A04[4].charAt(15) != 'p') {
                        throw new RuntimeException();
                    }
                    A04[0] = "WizhEabCQfIhxCPZxjxQrLo8096TZ2te";
                    listener.ABc();
                    return;
                }
                return;
            }
            if (serializableExtra instanceof P5) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().ABe();
                    return;
                }
                return;
            }
            if (serializableExtra instanceof C9H) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().AB8();
                }
                this.A02 = true;
            } else {
                if (!(serializableExtra instanceof O8)) {
                    if (!(serializableExtra instanceof AnonymousClass98) || this.A01.getListener() == null) {
                        return;
                    }
                    this.A01.getListener().onPause();
                    return;
                }
                if (this.A01.getListener() != null) {
                    MP listener2 = this.A01.getListener();
                    if (A04[5].length() != 15) {
                        A04[5] = "OhpiyJuLhpOH2Z5";
                        listener2.ACY();
                    } else {
                        A04[1] = "rjxpcIZarLCWG40Y5u8euDt94bevKfNO";
                        listener2.ACY();
                    }
                }
                this.A02 = false;
            }
        }
    }
}
