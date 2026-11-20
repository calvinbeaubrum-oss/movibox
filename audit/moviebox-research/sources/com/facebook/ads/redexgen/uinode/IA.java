package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IA {
    public static String[] A07 = {"5DRquCQGg5fv0P6nja7IsOodPXBGhUeG", "CLJKgVN4XJask5diLy7MGSBxba0Pch5a", "wHftqcE0jDwIdOqBDBC3mNx0B5SBQznZ", "ol9v552kFRhJ1T6A32CtEuz", "A1CuUzQu9jwyUqSqJ17msfwDUTn6GREa", "TbNgrGyLzvQfDvkF0WCoqwQu2K", "lR0XC8VxWttqZJTwOmQs4gh4fjIE6f", "2mBuumTUpjmiSXNoBcdi8fBRoWPOanRf"};
    public static final Comparator<I9> A08 = new I7();
    public static final Comparator<I9> A09 = new I8();
    public int A01;
    public int A02;
    public int A03;
    public final int A04;
    public final I9[] A06 = new I9[5];
    public final ArrayList<I9> A05 = new ArrayList<>();
    public int A00 = -1;

    public IA(int i11) {
        this.A04 = i11;
    }

    private void A00() {
        if (this.A00 != 1) {
            Collections.sort(this.A05, A08);
            this.A00 = 1;
        }
    }

    private void A01() {
        if (this.A00 != 0) {
            Collections.sort(this.A05, A09);
            this.A00 = 0;
        }
    }

    public final float A02(float f11) {
        A01();
        float f12 = this.A03 * f11;
        int i11 = 0;
        for (int i12 = 0; i12 < this.A05.size(); i12++) {
            I9 i13 = this.A05.get(i12);
            i11 += i13.A02;
            if (i11 >= f12) {
                return i13.A00;
            }
        }
        if (this.A05.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<I9> arrayList = this.A05;
        int size = arrayList.size();
        if (A07[3].length() == 12) {
            throw new RuntimeException();
        }
        A07[3] = "XkLaJBoD11zWycQ";
        return arrayList.get(size - 1).A00;
    }

    public final void A03(int i11, float f11) {
        I9 i12;
        A00();
        int i13 = this.A02;
        if (i13 > 0) {
            I9[] i9Arr = this.A06;
            int i14 = i13 - 1;
            this.A02 = i14;
            i12 = i9Arr[i14];
        } else {
            i12 = new I9(null);
        }
        int i15 = this.A01;
        this.A01 = i15 + 1;
        i12.A01 = i15;
        i12.A02 = i11;
        i12.A00 = f11;
        this.A05.add(i12);
        this.A03 += i11;
        while (true) {
            int i16 = this.A03;
            int i17 = this.A04;
            if (i16 <= i17) {
                return;
            }
            int i18 = i16 - i17;
            I9 i19 = this.A05.get(0);
            if (i19.A02 <= i18) {
                int i21 = this.A03;
                int i22 = i19.A02;
                if (A07[5].length() != 26) {
                    throw new RuntimeException();
                }
                A07[6] = "uvvU8EqEwFGMOcNu2z1EziqDegtCkn";
                this.A03 = i21 - i22;
                this.A05.remove(0);
                int i23 = this.A02;
                if (i23 < 5) {
                    I9[] i9Arr2 = this.A06;
                    this.A02 = i23 + 1;
                    i9Arr2[i23] = i19;
                }
            } else {
                i19.A02 -= i18;
                this.A03 -= i18;
            }
        }
    }
}
