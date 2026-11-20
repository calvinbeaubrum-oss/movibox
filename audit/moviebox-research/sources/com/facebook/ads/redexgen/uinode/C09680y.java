package com.facebook.ads.redexgen.uinode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C09680y extends BroadcastReceiver {
    public static byte[] A04;
    public InterfaceC09670x A00;
    public C1916bN A01;
    public C1795Yn A02;
    public String A03;

    static {
        A01();
    }

    public C09680y(C1795Yn c1795Yn, String str, C1916bN c1916bN, InterfaceC09670x interfaceC09670x) {
        this.A02 = c1795Yn;
        this.A03 = str;
        this.A00 = interfaceC09670x;
        this.A01 = c1916bN;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{103, 80, 92, 94, Ascii.GS, 85, 82, 80, 86, 81, 92, 92, 88, Ascii.GS, 82, 87, 64, Ascii.GS, 81, 82, 93, 93, 86, 65, Ascii.GS, 80, 95, 90, 80, 88, 86, 87};
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(1, 31, 80) + A00(0, 1, 62) + this.A03);
        C10102o.A00(this.A02).A06(this, intentFilter);
    }

    public final void A03() {
        C10102o.A00(this.A02).A05(this);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        String action = intent.getAction();
        if (action == null || (str = action.split(A00(0, 1, 62))[0]) == null || !A00(1, 31, 80).equals(str)) {
            return;
        }
        this.A00.AAx(this.A01);
    }
}
