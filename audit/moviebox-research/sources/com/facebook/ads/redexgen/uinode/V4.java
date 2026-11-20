package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class V4 implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, InterfaceC11197b {
    public static byte[] A02;
    public final C1795Yn A00;
    public final /* synthetic */ V2 A01;

    static {
        A02();
    }

    public V4(V2 v11, C1795Yn c1795Yn) {
        this.A01 = v11;
        this.A00 = c1795Yn;
    }

    public /* synthetic */ V4(V2 v11, C1795Yn c1795Yn, VD vd2) {
        this(v11, c1795Yn);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    private Map<String, String> A01() {
        Map<String, String> mapA05 = new C1508Ni().A03(this.A01.A0R).A02(this.A01.A0f).A05();
        if (this.A01.A0I != null) {
            mapA05.put(A00(201, 3, 11), String.valueOf(this.A01.A0I.A04()));
        }
        if (this.A01.A0W) {
            mapA05.put(A00(198, 3, 116), String.valueOf(this.A01.A0W));
        }
        return mapA05;
    }

    public static void A02() {
        A02 = new byte[]{43, Ascii.SO, 74, 9, Ascii.VT, 4, 4, 5, Ascii.RS, 74, 8, Ascii.SI, 74, 9, 6, 3, 9, 1, Ascii.SI, Ascii.SO, 74, 8, Ascii.SI, Ascii.FF, 5, Ascii.CAN, Ascii.SI, 74, 3, Ascii.RS, 74, 3, Ascii.EM, 74, Ascii.FS, 3, Ascii.SI, Ascii.GS, Ascii.SI, Ascii.SO, 68, 66, 109, 104, 98, 106, 114, 33, 105, 96, 113, 113, 100, 111, 100, 101, 33, 117, 110, 110, 33, 103, 96, 114, 117, 47, Ascii.DC4, Ascii.DLE, 19, 39, 54, 59, 55, 60, 49, 55, Ascii.FS, 55, 38, 37, 61, 32, 57, 56, Ascii.EM, 86, 2, Ascii.EM, 3, Ascii.NAK, Ascii.RS, 86, Ascii.DC2, Ascii.ETB, 2, Ascii.ETB, 86, 4, 19, Ascii.NAK, Ascii.EM, 4, Ascii.DC2, 19, Ascii.DC2, 90, 86, 6, Ascii.SUB, 19, Ascii.ETB, 5, 19, 86, 19, Ascii.CAN, 5, 3, 4, 19, 86, 2, Ascii.EM, 3, Ascii.NAK, Ascii.RS, 86, 19, 0, 19, Ascii.CAN, 2, 5, 86, 4, 19, Ascii.ETB, Ascii.NAK, Ascii.RS, 86, 2, Ascii.RS, 19, 86, Ascii.ETB, Ascii.DC2, 86, 32, Ascii.US, 19, 1, 86, Ascii.DC4, Ascii.SI, 86, 4, 19, 2, 3, 4, Ascii.CAN, Ascii.US, Ascii.CAN, 17, 86, Ascii.DLE, Ascii.ETB, Ascii.SUB, 5, 19, 86, Ascii.US, Ascii.DLE, 86, Ascii.SI, Ascii.EM, 3, 86, Ascii.US, Ascii.CAN, 2, 19, 4, Ascii.NAK, 19, 6, 2, 86, 2, Ascii.RS, 19, 86, 19, 0, 19, Ascii.CAN, 2, 88, 33, 39, 60, 94, 68, 89};
    }

    private void A03(Map<String, String> map) {
        if (this.A01.A0a != null) {
            this.A01.A0a.A0M(map);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11197b
    public final C1795Yn A5t() {
        return this.A00;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            boolean zA08 = this.A01.A0f.A08();
            String strA00 = A00(66, 17, 105);
            if (!zA08) {
                Log.e(strA00, A00(83, 115, 77));
            }
            int iA0G = C1384Ih.A0G(this.A01.A0c);
            if (iA0G >= 0 && this.A01.A0f.A03() < iA0G) {
                if (this.A01.A0f.A07()) {
                    Log.e(strA00, A00(41, 25, 58));
                    return;
                } else {
                    Log.e(strA00, A00(0, 41, 81));
                    return;
                }
            }
            if (!this.A01.A0f.A09(this.A01.A0c)) {
                A03(A01());
            } else if (this.A01.A0a != null) {
                this.A01.A0a.A0N(A01());
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A01.A04 == null || this.A01.A0L == null) {
            return false;
        }
        this.A01.A0L.setBounds(0, 0, this.A01.A04.getWidth(), this.A01.A04.getHeight());
        this.A01.A0L.A0D(!this.A01.A0L.A0E());
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A01.A0f.A06(this.A01.A0c, motionEvent, this.A01.A04, view);
        return this.A01.A02 != null && this.A01.A02.onTouch(view, motionEvent);
    }
}
