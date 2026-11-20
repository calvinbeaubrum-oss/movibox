package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1788Yg implements InterfaceC11357w {
    public static byte[] A04;
    public static String[] A05 = {"D3PJ2GNcgNGI4MtKfCaHjqEOfdHoPcVQ", "EJL0aGmI3i0Imoz4UWgpTxwTxGm9WRxT", "tfWCUNw0WGkvc5ldnWfg2BDK3aY0ceq2", "VYnzwe", "FWw4Dif8pFGferaZg4Cc6MDYh6zRU5", "BYQArfMrHiqwTG3fAjpcYjBOCFZN2nO4", "ZJiZak5asVL", "k4pPkd4ODWsyAa7ylPFb6IMORyuDH4"};
    public Context A00;
    public final C7v A02;
    public final AtomicBoolean A03 = new AtomicBoolean(false);
    public C11337t A01 = A00();

    static {
        A03();
    }

    public C1788Yg(Context context, C7v c7v) {
        this.A00 = context;
        this.A02 = c7v;
    }

    private C11337t A00() {
        return C11337t.A00(KE.A00(this.A00).getString(A01(0, 16, 81), null));
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ WebSocketProtocol.PAYLOAD_SHORT);
        }
        return new String(bArrCopyOfRange);
    }

    private void A02() {
        this.A02.AAQ(new C1789Yh(this));
    }

    public static void A03() {
        A04 = new byte[]{107, Ascii.DEL, 96, 112, 124, 106, 123, 123, 102, 97, 104, 124, 112, 100, 106, 118};
    }

    public final void A04(String[] strArr, Integer num, Integer num2) {
        C11337t c11337t = new C11337t(strArr, num, num2);
        if (c11337t.equals(this.A01)) {
            return;
        }
        this.A01 = c11337t;
        this.A03.set(true);
        SharedPreferences sharedPreferencesA00 = KE.A00(this.A00);
        if (A05[2].charAt(16) != 'n') {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[7] = "txsFPtaRD11LyA3dzoyK5U0Vbdrctz";
        strArr2[4] = "NLpqiEYsaOJ6LGl2A1qehjxsg53G43";
        sharedPreferencesA00.edit().putString(A01(0, 16, 81), this.A01.A07()).apply();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11357w
    public final C11337t A6i() {
        A02();
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11357w
    public final boolean A9F() {
        A02();
        if (this.A01 == null) {
            return false;
        }
        Set<String> setA0W = C1384Ih.A0W(this.A00);
        String strA07 = this.A01.A07();
        Iterator<String> it = setA0W.iterator();
        while (it.hasNext()) {
            if (strA07.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11357w
    public final boolean AGJ() {
        A02();
        return this.A03.getAndSet(false);
    }
}
