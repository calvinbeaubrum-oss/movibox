package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C09781i {
    public static byte[] A05;
    public static String[] A06 = {"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    public C11006c A00;
    public EnumC1512Nm A01 = EnumC1512Nm.A06;
    public ArrayList<PB> A02 = new ArrayList<>();
    public final C1F A03;
    public final InterfaceC09771h A04;

    static {
        A06();
    }

    public C09781i(C1795Yn c1795Yn, C09911v c09911v, InterfaceC09771h interfaceC09771h, String str) {
        this.A03 = A01(c1795Yn, c09911v, str, c09911v.A03());
        this.A04 = interfaceC09771h;
    }

    private AdError A00(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5) {
        if (abstractC1898b5 != null && !abstractC1898b5.A14().isEmpty()) {
            return null;
        }
        c1795Yn.A07().A9a(A04(62, 3, 18), C8A.A0Z, new C8B(A04(5, 43, 6)));
        return AdError.internalError(2006);
    }

    public static C1F A01(C1795Yn c1795Yn, C09911v c09911v, String str, JSONObject jSONObject) {
        C1F c1fA02 = null;
        if (jSONObject.has(A04(65, 12, 2))) {
            try {
                c1fA02 = C1896b3.A03(jSONObject, c1795Yn, true);
                c1fA02.A0e(true);
                c1fA02.A0b(A04(96, 12, 17));
            } catch (JSONException unused) {
            }
        }
        if (c1fA02 == null) {
            c1fA02 = FU.A02(jSONObject, c1795Yn);
        }
        c1fA02.A0a(str);
        C8T c8tA01 = c09911v.A01();
        if (c8tA01 != null) {
            c1fA02.A0W(c8tA01.A06());
        }
        return c1fA02;
    }

    private C11006c A03(C1795Yn c1795Yn) {
        C11006c c11006c = this.A00;
        return c11006c != null ? c11006c : new C11006c(c1795Yn);
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, Ascii.US, 34, Ascii.GS, 34, Ascii.US, 50, Ascii.US, Ascii.GS, 32, 51, 44, 34, 42, 35, -45, -30, -37, -59, -54, -61, -53, -48, -63, -46, -61, -44, -61, -49, -43, -42, -37, -44, -36, -31, -40, -41, -76, -41, -73, -44, -25, -44, -75, -24, -31, -41, -33, -40, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35};
    }

    private void A08(C1795Yn c1795Yn, FU fu2) {
        C09721c c09721cA06 = fu2.A0x().A0D().A06();
        A0B(c09721cA06 != null ? c09721cA06.A0A() : EnumC1512Nm.A06);
        C1887au c1887au = new C1887au(this);
        C11006c c11006c = new C11006c(c1795Yn);
        boolean z11 = C1384Ih.A1n(c1795Yn) && AnonymousClass62.A0A(fu2.A0V());
        if (!z11) {
            AbstractC09881s.A02(c1795Yn, fu2, true, c1887au);
            return;
        }
        AnonymousClass62 anonymousClass62 = new AnonymousClass62(c11006c, fu2.A0V(), fu2.A0P(), fu2.A0S(), z11, new C1886at(this));
        c11006c.A0d(new JA(fu2.A12(), c1795Yn.A09()));
        anonymousClass62.A0B();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0094  */
    private void A09(C1795Yn c1795Yn, EnumSet<CacheFlag> enumSet, AbstractC1898b5 abstractC1898b5, int i11, InterfaceC09771h interfaceC09771h) {
        Iterator<String> it;
        boolean zA0m = abstractC1898b5.A0m();
        C11006c c11006cA03 = A03(c1795Yn);
        c11006cA03.A0d(new JA(abstractC1898b5.A12(), c1795Yn.A09()));
        boolean z11 = C1384Ih.A1n(c1795Yn) && AnonymousClass62.A0A(abstractC1898b5.A0V());
        if (A06[3].length() == 32) {
            throw new RuntimeException();
        }
        A06[5] = "QkQhg";
        if (z11) {
            new AnonymousClass62(c11006cA03, abstractC1898b5.A0V(), abstractC1898b5.A0P(), abstractC1898b5.A0S(), z11, new C1890ax(this, c1795Yn, zA0m, abstractC1898b5, interfaceC09771h)).A0B();
            return;
        }
        String strA04 = A04(96, 12, 17);
        String[] strArr = A06;
        if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
            String[] strArr2 = A06;
            strArr2[1] = "jVhVjw8PHVLop7GyU0UYPYiA56KfUjA6";
            strArr2[0] = "lzrrt2iICm45JkiVqVLOf6p257fg56KP";
            if (zA0m) {
                C6Y c6y = new C6Y(abstractC1898b5.A0M(), abstractC1898b5.A0S(), strA04);
                c6y.A04 = true;
                c6y.A03 = A04(0, 5, 17);
                c11006cA03.A0X(c6y);
            }
        } else {
            String[] strArr3 = A06;
            strArr3[7] = "mMtIDEEqjJJ695eeXDndb9bWh";
            strArr3[4] = "Ebj8lqyUqzLrB8iZ5jF9tO70n";
            if (zA0m) {
                C6Y c6y2 = new C6Y(abstractC1898b5.A0M(), abstractC1898b5.A0S(), strA04);
                c6y2.A04 = true;
                c6y2.A03 = A04(0, 5, 17);
                c11006cA03.A0X(c6y2);
            }
        }
        c11006cA03.A0c(new C10986a(abstractC1898b5.A10().A01(), C1566Po.A04, C1566Po.A04, abstractC1898b5.A0S(), A04(96, 12, 17)));
        boolean zContains = enumSet.contains(CacheFlag.VIDEO);
        int i12 = 0;
        boolean zA2R = C1384Ih.A2R(c1795Yn, C1600Qw.A03());
        for (C1G c1g : abstractC1898b5.A14()) {
            C10986a c10986a = new C10986a(c1g.A0D().A07(), AbstractC09841o.A00(c1g.A0D()), AbstractC09841o.A01(c1g.A0D()), abstractC1898b5.A0S(), A04(96, 12, 17));
            if (i12 == 0) {
                c11006cA03.A0b(c10986a);
            } else {
                c11006cA03.A0c(c10986a);
            }
            List<String> listA01 = c1g.A0G().A01();
            String[] strArr4 = A06;
            if (strArr4[6].length() != strArr4[2].length()) {
                String[] strArr5 = A06;
                strArr5[1] = "D8Za7DAeUKhUMlH0nChh1nyf5MUepOev";
                strArr5[0] = "YMJugZMvnGL61TcEtQKO8oN05ixDNSHw";
                it = listA01.iterator();
            } else {
                it = listA01.iterator();
            }
            while (it.hasNext()) {
                c11006cA03.A0c(new C10986a(it.next(), -1, -1, abstractC1898b5.A0S(), A04(96, 12, 17)));
            }
            if (zContains && !TextUtils.isEmpty(c1g.A0D().A08())) {
                C6Y c6y3 = new C6Y(c1g.A0D().A08(), abstractC1898b5.A0S(), A04(96, 12, 17), c1g.A0D().A05());
                c6y3.A04 = false;
                if (i12 == 0) {
                    if (!zA0m || zA2R) {
                        c11006cA03.A0a(c6y3);
                    } else {
                        c11006cA03.A0X(c6y3);
                    }
                } else if (!zA0m || zA2R) {
                    c11006cA03.A0Z(c6y3);
                } else {
                    c11006cA03.A0Y(c6y3);
                }
            }
            i12++;
        }
        c11006cA03.A0W(new C1888av(this, c1795Yn, zA0m, abstractC1898b5, interfaceC09771h), new C6V(abstractC1898b5.A0S(), strA04, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1795Yn c1795Yn, EnumSet<CacheFlag> enumSet, C1896b3 c1896b3, AbstractC1898b5 abstractC1898b5, int i11, InterfaceC09771h interfaceC09771h) {
        A09(c1795Yn, enumSet, abstractC1898b5, i11, new C1892az(this, c1795Yn, abstractC1898b5, c1896b3, i11, interfaceC09771h, enumSet));
    }

    private void A0B(EnumC1512Nm enumC1512Nm) {
        this.A01 = enumC1512Nm;
    }

    private boolean A0C(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5) {
        AdError adErrorA00 = A00(c1795Yn, abstractC1898b5);
        if (adErrorA00 == null) {
            return false;
        }
        InterfaceC09771h interfaceC09771h = this.A04;
        String[] strArr = A06;
        if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[1] = "Dm6wm58uJ8qXwjtNx8Vtzbsb5Jkw9mit";
        strArr2[0] = "fLwuuFNg4tiwPdo6hP9t6x3v5l5Hcavg";
        interfaceC09771h.AAe(adErrorA00);
        return true;
    }

    public final C1F A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        if (r3 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        return com.facebook.ads.redexgen.uinode.KB.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
    
        if (r3 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        return com.facebook.ads.redexgen.uinode.KB.A0B;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final KB A0E() {
        if (this.A03.A0j()) {
            return KB.A04;
        }
        AbstractC1898b5 abstractC1898b5 = (AbstractC1898b5) this.A03;
        String[] strArr = A06;
        if (strArr[6].length() != strArr[2].length()) {
            A06[3] = "f4kXngrP8CD5dz";
            if (abstractC1898b5.A0m()) {
                return KB.A06;
            }
            if (abstractC1898b5.A14().size() > 1) {
                KB kb2 = KB.A0A;
                String[] strArr2 = A06;
                if (strArr2[7].length() == strArr2[4].length()) {
                    A06[3] = "ny";
                    return kb2;
                }
            } else {
                if (abstractC1898b5.A0x().A0D().A06() != null) {
                    KB kb3 = KB.A0C;
                    String[] strArr3 = A06;
                    if (strArr3[6].length() == strArr3[2].length()) {
                        throw new RuntimeException();
                    }
                    A06[3] = "JH";
                    return kb3;
                }
                boolean zA0L = A0L(abstractC1898b5);
                if (A06[3].length() != 32) {
                    String[] strArr4 = A06;
                    strArr4[1] = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl";
                    strArr4[0] = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9";
                } else {
                    A06[3] = "ySAy4b6nQ";
                }
            }
        }
        throw new RuntimeException();
    }

    public final EnumC1512Nm A0F() {
        return this.A01;
    }

    public final String A0G() {
        return this.A03.A0j() ? ((C1896b3) this.A03).A0y() : ((AbstractC1898b5) this.A03).A12();
    }

    public final void A0H() {
        this.A04.AGm();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A0Y(rewardData);
        this.A03.A0c(str);
        if (A0D().A0j()) {
            intent.putExtra(A04(77, 19, 19), this.A03);
        }
        intent.putExtra(A04(48, 14, 94), this.A03);
    }

    public final void A0J(C1795Yn c1795Yn, EnumSet<CacheFlag> enumSet) {
        if (A0E() == KB.A04) {
            C1896b3 c1896b3 = (C1896b3) this.A03;
            AbstractC1898b5 abstractC1898b5A0u = c1896b3.A0u();
            if (A0C(c1795Yn, abstractC1898b5A0u) || abstractC1898b5A0u == null) {
                return;
            }
            this.A04.AES();
            A0A(c1795Yn, enumSet, c1896b3, abstractC1898b5A0u, 0, this.A04);
            return;
        }
        if (A0C(c1795Yn, (AbstractC1898b5) this.A03)) {
            return;
        }
        this.A04.AES();
        if (A0E() == KB.A0C) {
            A08(c1795Yn, (FU) this.A03);
        } else {
            A09(c1795Yn, enumSet, (FU) this.A03, -1, this.A04);
        }
    }

    public final boolean A0K() {
        return this.A03.A0g();
    }

    public final boolean A0L(AbstractC1898b5 abstractC1898b5) {
        return !TextUtils.isEmpty(abstractC1898b5.A0x().A0D().A08());
    }
}
