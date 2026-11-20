package com.facebook.ads.redexgen.uinode;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1321Fu {
    public static String[] A08 = {"XC7eQ7mnDigGIQL7dx0KfLpc2FT", "IUrjEkKy3b2jJtDJZ33sGt", "", "4VXLd4NK2UMSrr9tKiehY90A", "S2gwvpBwwRoio7AP3LwECfAaRkk6O4ZY", "9TUF7Ks7YtQxur", "s5iWH5PZ", "Ea283cgdBM89En3yGupwQHUZzzjf5u4Q"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public final List<C1320Ft> A06 = new ArrayList();
    public final List<SpannableString> A07 = new ArrayList();
    public final StringBuilder A05 = new StringBuilder();

    public C1321Fu(int i11, int i12) {
        A09(i11);
        A0A(i12);
    }

    private final SpannableString A00() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.A05);
        int length = spannableStringBuilder.length();
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        int i14 = -1;
        boolean z11 = false;
        int i15 = -1;
        for (int i16 = 0; i16 < this.A06.size(); i16++) {
            C1320Ft c1320Ft = this.A06.get(i16);
            boolean z12 = c1320Ft.A02;
            int i17 = c1320Ft.A01;
            if (i17 != 8) {
                z11 = i17 == 7;
                if (i17 != 7) {
                    i15 = C5A.A0K[i17];
                }
            }
            int i18 = c1320Ft.A00;
            if (A08[1].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[6] = "A7DJ6NHY";
            strArr[5] = "4roHVg72rzpV8d";
            if (i18 != (i16 + 1 < this.A06.size() ? this.A06.get(i16 + 1).A00 : length)) {
                if (i11 != -1 && !z12) {
                    A02(spannableStringBuilder, i11, i18);
                    i11 = -1;
                } else if (i11 == -1 && z12) {
                    i11 = i18;
                }
                if (i12 != -1 && !z11) {
                    A01(spannableStringBuilder, i12, i18);
                    i12 = -1;
                } else if (i12 == -1 && z11) {
                    i12 = i18;
                }
                if (i15 != i14) {
                    A03(spannableStringBuilder, i13, i18, i14);
                    i14 = i15;
                    i13 = i18;
                }
            }
        }
        if (i11 != -1 && i11 != length) {
            A02(spannableStringBuilder, i11, length);
        }
        if (i12 != -1 && i12 != length) {
            A01(spannableStringBuilder, i12, length);
        }
        if (i13 != length) {
            A03(spannableStringBuilder, i13, length, i14);
        }
        return new SpannableString(spannableStringBuilder);
    }

    public static void A01(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
        spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, 33);
    }

    public static void A02(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
        spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
    }

    public static void A03(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13) {
        if (i13 == -1) {
            return;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i11, i12, 33);
    }

    public final int A04() {
        return this.A03;
    }

    public final C1314Fn A05() {
        float f11;
        int i11;
        int i12;
        int i13;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i14 = 0; i14 < this.A07.size(); i14++) {
            spannableStringBuilder.append((CharSequence) this.A07.get(i14));
            spannableStringBuilder.append('\n');
        }
        spannableStringBuilder.append((CharSequence) A00());
        if (A08[2].length() != 4) {
            A08[4] = "XUGi3jQBIuRQftqARNMB36bn2TyuzRos";
            if (spannableStringBuilder.length() == 0) {
                if (A08[1].length() != 22) {
                    A08[1] = "sMaadG1MTySiyP3TGzo1T4";
                    return null;
                }
                A08[1] = "nS4SC9sWxiUu8g9Arai4ZN";
                return null;
            }
            int i15 = this.A02;
            int i16 = this.A04;
            if (A08[7].charAt(3) != 'N') {
                A08[4] = "yDKFp8g0FkQkvFDtr9inWFZi093Wo6Xo";
                int i17 = i15 + i16;
                int length = (32 - i17) - spannableStringBuilder.length();
                int i18 = i17 - length;
                if (this.A00 == 2 && (Math.abs(i18) < 3 || length < 0)) {
                    f11 = 0.5f;
                    i11 = 1;
                } else if (this.A00 != 2 || i18 <= 0) {
                    f11 = (0.8f * (i17 / 32.0f)) + 0.1f;
                    i11 = 0;
                } else {
                    int i19 = 32 - length;
                    if (A08[4].charAt(13) == 'W') {
                        throw new RuntimeException();
                    }
                    A08[2] = "dWj1xsuyJgYxC";
                    f11 = (0.8f * (i19 / 32.0f)) + 0.1f;
                    i11 = 2;
                }
                if (this.A00 == 1 || this.A03 > 7) {
                    i12 = 2;
                    i13 = (this.A03 - 15) - 2;
                } else {
                    i12 = 0;
                    i13 = this.A03;
                }
                return new C1314Fn(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i13, 1, i12, f11, i11, Float.MIN_VALUE);
            }
        }
        throw new RuntimeException();
    }

    public final void A06() {
        int length = this.A05.length();
        if (length > 0) {
            this.A05.delete(length - 1, length);
            for (int size = this.A06.size() - 1; size >= 0; size--) {
                C1320Ft c1320Ft = this.A06.get(size);
                if (c1320Ft.A00 != length) {
                    return;
                }
                c1320Ft.A00--;
            }
        }
    }

    public final void A07() {
        this.A07.add(A00());
        this.A05.setLength(0);
        this.A06.clear();
        int iMin = Math.min(this.A01, this.A03);
        while (true) {
            int size = this.A07.size();
            String[] strArr = A08;
            if (strArr[6].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[6] = "4Kk3waKD";
            strArr2[5] = "8nOP5N7C4Kf2hN";
            if (size < iMin) {
                return;
            } else {
                this.A07.remove(0);
            }
        }
    }

    public final void A08(char c11) {
        this.A05.append(c11);
    }

    public final void A09(int i11) {
        this.A00 = i11;
        this.A06.clear();
        this.A07.clear();
        this.A05.setLength(0);
        this.A03 = 15;
        this.A02 = 0;
        this.A04 = 0;
    }

    public final void A0A(int i11) {
        this.A01 = i11;
    }

    public final void A0B(int i11) {
        this.A02 = i11;
    }

    public final void A0C(int i11) {
        this.A03 = i11;
    }

    public final void A0D(int i11) {
        this.A04 = i11;
    }

    public final void A0E(int i11, boolean z11) {
        this.A06.add(new C1320Ft(i11, z11, this.A05.length()));
    }

    public final boolean A0F() {
        return this.A06.isEmpty() && this.A07.isEmpty() && this.A05.length() == 0;
    }

    public final String toString() {
        return this.A05.toString();
    }
}
