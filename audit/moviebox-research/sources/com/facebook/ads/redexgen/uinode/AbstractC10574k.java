package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10574k {
    public static byte[] A06;
    public static String[] A07 = {"wCFFy4v0UHolBGzubHhtaTK0KlaK5TU8", "WXL", "veTi", "n3", "rW28yUWMMTgiQlEcIz6smwE3e87Fn5Ax", "QU5acghFPGL2KQJts4swUt9W5A9MK8iM", "qIZlYUWuFA6tmX766BSANKSPkXlWbMWT", "RhPzJuizv3JTUr3AZhw4zLdz5ZpO"};
    public InterfaceC10554i A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    static {
        A03();
    }

    public static int A00(AnonymousClass56 anonymousClass56) {
        int i11 = anonymousClass56.A0C & 14;
        if (anonymousClass56.A0Z()) {
            return 4;
        }
        if ((i11 & 4) != 0) {
            return i11;
        }
        int iA0J = anonymousClass56.A0J();
        int iA0G = anonymousClass56.A0G();
        String[] strArr = A07;
        if (strArr[3].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A07[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
        return (iA0J == -1 || iA0G == -1 || iA0J == iA0G) ? i11 : i11 | 2048;
    }

    private final C10564j A01() {
        return new C10564j();
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{85, 84, 123, 84, 83, 87, 91, 78, 83, 85, 84, 73, 124, 83, 84, 83, 73, 82, 95, 94};
    }

    public final long A04() {
        return this.A00;
    }

    public final long A05() {
        return this.A01;
    }

    public final long A06() {
        return this.A02;
    }

    public final long A07() {
        return this.A03;
    }

    public final C10564j A08(AnonymousClass53 anonymousClass53, AnonymousClass56 anonymousClass56) {
        return A01().A01(anonymousClass56);
    }

    public final C10564j A09(AnonymousClass53 anonymousClass53, AnonymousClass56 anonymousClass56, int i11, List<Object> list) {
        return A01().A01(anonymousClass56);
    }

    public final void A0A() {
        if (0 < this.A05.size()) {
            this.A05.get(0);
            throw new NullPointerException(A02(0, 20, 16));
        }
        this.A05.clear();
    }

    public final void A0B(InterfaceC10554i interfaceC10554i) {
        this.A04 = interfaceC10554i;
    }

    public final void A0C(AnonymousClass56 anonymousClass56) {
        InterfaceC10554i interfaceC10554i = this.A04;
        if (interfaceC10554i != null) {
            interfaceC10554i.AAj(anonymousClass56);
        }
    }

    public abstract boolean A0D(AnonymousClass56 anonymousClass56);

    public abstract boolean A0E(AnonymousClass56 anonymousClass56, C10564j c10564j, C10564j c10564j2);

    public abstract boolean A0F(AnonymousClass56 anonymousClass56, C10564j c10564j, C10564j c10564j2);

    public abstract boolean A0G(AnonymousClass56 anonymousClass56, C10564j c10564j, C10564j c10564j2);

    public abstract boolean A0H(AnonymousClass56 anonymousClass56, AnonymousClass56 anonymousClass57, C10564j c10564j, C10564j c10564j2);

    public abstract void A0I();

    public abstract void A0J();

    public abstract void A0K(AnonymousClass56 anonymousClass56);

    public abstract boolean A0L();

    public boolean A0M(AnonymousClass56 anonymousClass56, List<Object> list) {
        return A0D(anonymousClass56);
    }
}
