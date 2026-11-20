package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HE implements InterfaceC1980cc {
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"IEiXcTkMIl1ap8Zf6qOVAjQ1rvSIicom", "QYAiQp9VSKIcO10LfC8C0oMZ52KCP", "5FnqVZjKRiUcCEiMettDGQkf", "eIcxxbRAXAOJgXUDruK", "Xqq5h503ORagU11Zkm", "kVW5mdc93LjiLmP7jOmm8EZ9ikbuw", "", "Pup9EGwYSaPQ0jjcMKTOfwULbNi8Bcjo"};
    public final InterfaceC1982ce A02;
    public final WeakReference<View> A03;
    public final List<Rect> A04 = new LinkedList();
    public final List<Rect> A05 = new ArrayList();
    public final Rect A01 = new Rect();
    public final Rect A00 = new Rect();

    static {
        A01();
    }

    public HE(View view, InterfaceC1982ce interfaceC1982ce) {
        this.A03 = new WeakReference<>(view);
        this.A02 = interfaceC1982ce;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-50, -52, -37, -86, -45, -48, -41, -71, -52, -54, -37};
    }

    private final void A02(List<Rect> list) {
        list.clear();
        this.A04.clear();
        View view = this.A03.get();
        if (view == null || !view.getGlobalVisibleRect(this.A01) || this.A01.isEmpty()) {
            return;
        }
        List<Rect> list2 = this.A04;
        Rect rect = this.A01;
        String[] strArr = A08;
        if (strArr[2].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A08[4] = "LbYMkqiRG6i19Q3hsX";
        list2.add(rect);
        Iterator<InterfaceC1621Rr> it = this.A02.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A00(0, 11, 39));
        }
        list.addAll(this.A04);
    }

    private final void A03(List<Rect> list) {
        list.clear();
        this.A05.clear();
        View view = this.A03.get();
        if (view == null || !view.getGlobalVisibleRect(this.A01) || this.A01.isEmpty()) {
            return;
        }
        this.A05.add(this.A01);
        if (0 < this.A02.size()) {
            this.A02.A5q(0);
            throw new NullPointerException(A00(0, 11, 39));
        }
        List<Rect> list2 = this.A05;
        String[] strArr = A08;
        if (strArr[2].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[2] = "LXhIn0ySVvfbhvFPsQzIW8Ps";
        strArr2[6] = "";
        list.addAll(list2);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1980cc
    public final void A8O(List<Rect> list) {
        if (A06) {
            A03(list);
        } else {
            A02(list);
        }
    }
}
