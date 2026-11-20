package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FO extends AbstractC1879am {
    public static byte[] A00;
    public static String[] A01 = {"d7tLiGkqyLa7cKOkED7RtvmpIXZH8d0b", "LmA4T64r6T9e", "1EBtOKlPck0twYp3ElEJQmg3d", "uhXcdOUibAChEZNBNQuPqKRIQ2", "Z", "LV0o53GlcsqgEYK9Pr4EwymnJShooL9b", "NLZosIPt4DzrQXhRsvqwWEHVFOTX5bDJ", "MQasnwh7q"};

    static {
        A03();
    }

    public FO(C1795Yn c1795Yn, C09901u c09901u) {
        super(c1795Yn, c09901u);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j11) {
        HashMap map = new HashMap();
        map.put(A00(36, 5, 104), String.valueOf(System.currentTimeMillis() - j11));
        return map;
    }

    public static void A03() {
        A00 = new byte[]{77, 72, Ascii.FF, 69, 95, Ascii.FF, 66, 67, 88, Ascii.FF, 94, 73, 77, 72, 85, Ascii.FF, 67, 94, Ascii.FF, 77, 64, 94, 73, 77, 72, 85, Ascii.FF, 72, 69, 95, 92, 64, 77, 85, 73, 72, 56, 57, 48, 61, 37};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(List<String> list, Map<String, String> map) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A01[0] = "jDIZMq7wlAdnEmkEGDRuOyHBIh8qxobs";
            if (!zHasNext) {
                return;
            }
            new AsyncTaskC1608Re(this.A0B, map).execute(it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1879am
    public final void A0M() {
        C1913bK c1913bK = (C1913bK) this.A01;
        if (!c1913bK.A0R()) {
            throw new IllegalStateException(A00(0, 36, 24));
        }
        if (this.A06 != null) {
            this.A06.A0B(c1913bK);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1879am
    public final void A0O(InterfaceC09590p interfaceC09590p, C8S c8s, C8Q c8q, C09911v c09911v) {
        C1913bK c1913bK = (C1913bK) interfaceC09590p;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1876aj c1876aj = new C1876aj(this, c09911v, c1913bK, jCurrentTimeMillis, c8q);
        A0F().postDelayed(c1876aj, c8s.A05().A05());
        c1913bK.A0L(this.A0B, new C1875ai(this, c1876aj, jCurrentTimeMillis, c8q), this.A08, c09911v, V2.A0K());
    }
}
