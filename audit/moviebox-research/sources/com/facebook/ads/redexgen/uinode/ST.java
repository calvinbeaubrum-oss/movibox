package com.facebook.ads.redexgen.uinode;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ST extends AbstractC10494c<SN> {
    public static String[] A0H = {"U2dBX20JaeRgS8KUkn4U", "4wbYdEjd6EY1wYpAHERmBQ5UbLFk3rIE", "poCzv8x7tLJqIV5ZIWq", "9iyDRDGf0xWQ70I4mtfqA0IQycZfZ47C", "v2glKkwlOEfR0MfsI3TqmdNecXONmhZ3", "6XdF3RdtkhprEZiVEVCq65KOMzsBziM7", "2OiOSmaAlP7OTnmHwLOjTjXlL7jeDPuL", "nkMLdycTxYcJ5galJfvG8bjM9rVBse8i"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public MB A04;
    public MC A05;
    public String A06;
    public List<C1567Pp> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC1898b5 A0A;
    public final C11006c A0B;
    public final C1795Yn A0C;
    public final J2 A0D;
    public final C1454Lg A0E;
    public final C1631Sb A0F;
    public final RE A0G;

    public ST(C1795Yn c1795Yn, List<C1567Pp> list, AbstractC1898b5 abstractC1898b5, J2 j11, C11006c c11006c, RE re2, C1454Lg c1454Lg, MC mc2, String str, int i11, int i12, int i13, int i14, C1631Sb c1631Sb, MB mb2) {
        this.A0C = c1795Yn;
        this.A0D = j11;
        this.A0B = c11006c;
        this.A0G = re2;
        this.A0E = c1454Lg;
        this.A05 = mc2;
        this.A0A = abstractC1898b5;
        this.A07 = list;
        this.A00 = i11;
        this.A03 = i14;
        this.A06 = str;
        this.A01 = i13;
        this.A02 = i12;
        this.A0F = c1631Sb;
        this.A04 = mb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final SN A0C(ViewGroup viewGroup, int i11) {
        return new SN(AbstractC1549Ox.A00(new OO(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0H(this.A04).A0K(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A0y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0D(SN sn2, int i11) {
        sn2.A0j(this.A07.get(i11), this.A0D, this.A0B, this.A0E, this.A06);
        if (this.A08 || i11 != 0) {
            return;
        }
        sn2.AFr();
        String[] strArr = A0H;
        if (strArr[3].charAt(29) == strArr[6].charAt(29)) {
            throw new RuntimeException();
        }
        A0H[1] = "f5MkbcX2dFxcVTBDK6f4VKhLC7wzzoeI";
        this.A08 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    public final int A0E() {
        return this.A07.size();
    }
}
