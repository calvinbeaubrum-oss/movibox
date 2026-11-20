package com.facebook.ads.redexgen.uinode;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1322Fv {
    public static byte[] A0M;
    public static String[] A0N = {"bEAjJCvVtkePzUcw9rvynCWhWZ7YtTC", "sFv5If9m5Sphdt63zNjPhUbGsirLMRkb", "dm26J1OSzusJji0dpgrnr09k5LC689lq", "Nx5OZNPL7zWyatFSZAWV1dERcLRuFkfb", "8nXEVS4hfg5ng3YQnnC7NT8u0hAmIJYk", "i1gAYPXKkwHe1sE5BOr5igG8IxAvgiYs", "Y1prefJax7dGS9GUqUH50jWlMMgJtsPr", "K9Y4TfEKpnP3QqzXtNTgN9rOyJLVMPLw"};
    public static final int A0O;
    public static final int A0P;
    public static final int A0Q;
    public static final int[] A0R;
    public static final int[] A0S;
    public static final int[] A0T;
    public static final int[] A0U;
    public static final int[] A0V;
    public static final int[] A0W;
    public static final int[] A0X;
    public static final boolean[] A0Y;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final List<SpannableString> A0L = new ArrayList();
    public final SpannableStringBuilder A0K = new SpannableStringBuilder();

    static {
        A04();
        A0P = A01(2, 2, 2, 0);
        int iA01 = A01(0, 0, 0, 0);
        A0O = iA01;
        int iA02 = A01(0, 0, 0, 3);
        A0Q = iA02;
        A0V = new int[]{0, 0, 0, 0, 0, 2, 0};
        A0W = new int[]{0, 0, 0, 0, 0, 0, 2};
        A0X = new int[]{3, 3, 3, 3, 3, 3, 1};
        A0Y = new boolean[]{false, false, false, true, true, true, false};
        A0U = new int[]{iA01, iA02, iA01, iA01, iA02, iA01, iA01};
        A0T = new int[]{0, 1, 2, 3, 4, 3, 4};
        A0S = new int[]{0, 0, 0, 0, 0, 3, 3};
        A0R = new int[]{iA01, iA01, iA01, iA01, iA01, iA02, iA02};
    }

    public C1322Fv() {
        A08();
    }

    public static int A00(int i11, int i12, int i13) {
        return A01(i11, i12, i13, 0);
    }

    public static int A01(int i11, int i12, int i13, int i14) {
        int i15;
        AbstractC1351Ha.A00(i11, 0, 4);
        AbstractC1351Ha.A00(i12, 0, 4);
        AbstractC1351Ha.A00(i13, 0, 4);
        AbstractC1351Ha.A00(i14, 0, 4);
        switch (i14) {
            case 0:
            case 1:
                i15 = 255;
                break;
            case 2:
                i15 = 127;
                break;
            case 3:
                i15 = 0;
                break;
            default:
                i15 = 255;
                break;
        }
        return Color.argb(i15, i11 > 1 ? 255 : 0, i12 > 1 ? 255 : 0, i13 > 1 ? 255 : 0);
    }

    private final SpannableString A02() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.A0K);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.A06 != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.A06, length, 33);
            }
            if (this.A0C != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.A0C, length, 33);
            }
            int i11 = this.A04;
            if (A0N[0].length() != 31) {
                throw new RuntimeException();
            }
            A0N[4] = "UcnYu1PwHAGC3vbuX83YmC5zO9IPxpwr";
            if (i11 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.A03), this.A04, length, 33);
            }
            if (this.A02 != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.A01), this.A02, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0M = new byte[]{81, 106, 97, 124, 116, 97, 103, 112, 97, 96, 36, 110, 113, 119, 112, 109, 98, 109, 103, 101, 112, 109, 107, 106, 36, 114, 101, 104, 113, 97, 62, 36};
    }

    public final WJ A05() {
        Layout.Alignment alignment;
        float f11;
        float f12;
        if (A0H()) {
            if (A0N[3].charAt(10) != 'W') {
                throw new RuntimeException();
            }
            A0N[6] = "XXMrNDw86HMhGPknailYt8C4YmEezPlD";
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i11 = 0; i11 < this.A0L.size(); i11++) {
            spannableStringBuilder.append((CharSequence) this.A0L.get(i11));
            spannableStringBuilder.append('\n');
        }
        spannableStringBuilder.append((CharSequence) A02());
        switch (this.A07) {
            case 0:
            case 3:
                alignment = Layout.Alignment.ALIGN_NORMAL;
                break;
            case 1:
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                if (A0N[3].charAt(10) != 'W') {
                    A0N[1] = "GUzkX8UKOS2SBWNLmpbuPvYZfRUrk3bC";
                } else {
                    A0N[1] = "qTQORRfF62rpJvlAVACWybIcEIDyrroZ";
                }
                break;
            case 2:
                alignment = Layout.Alignment.ALIGN_CENTER;
                break;
            default:
                throw new IllegalArgumentException(A03(0, 32, 89) + this.A07);
        }
        if (this.A0H) {
            f11 = this.A05 / 99.0f;
            f12 = this.A0D / 99.0f;
        } else {
            f11 = this.A05 / 209.0f;
            f12 = this.A0D / 74.0f;
        }
        float f13 = (f11 * 0.9f) + 0.05f;
        float f14 = (0.9f * f12) + 0.05f;
        int i12 = this.A00;
        int i13 = i12 % 3 == 0 ? 0 : i12 % 3 == 1 ? 1 : 2;
        int i14 = i12 / 3 == 0 ? 0 : i12 / 3 == 1 ? 1 : 2;
        int i15 = this.A0E;
        return new WJ(spannableStringBuilder, alignment, f14, 0, i13, f13, i14, Float.MIN_VALUE, i15 != A0O, i15, this.A09);
    }

    public final void A06() {
        int length = this.A0K.length();
        if (length > 0) {
            this.A0K.delete(length - 1, length);
        }
    }

    public final void A07() {
        this.A0L.clear();
        this.A0K.clear();
        this.A06 = -1;
        this.A0C = -1;
        this.A04 = -1;
        this.A02 = -1;
        this.A0A = 0;
    }

    public final void A08() {
        A07();
        this.A0G = false;
        this.A0J = false;
        this.A09 = 4;
        this.A0H = false;
        this.A0D = 0;
        this.A05 = 0;
        this.A00 = 0;
        this.A0B = 15;
        this.A0I = true;
        this.A07 = 0;
        this.A0F = 0;
        this.A08 = 0;
        int i11 = A0O;
        this.A0E = i11;
        this.A03 = A0P;
        this.A01 = i11;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0060 A[SYNTHETIC] */
    public final void A09(char c11) {
        if (c11 != '\n') {
            this.A0K.append(c11);
            return;
        }
        this.A0L.add(A02());
        this.A0K.clear();
        if (this.A06 != -1) {
            this.A06 = 0;
        }
        if (this.A0C != -1) {
            this.A0C = 0;
        }
        if (this.A04 != -1) {
            this.A04 = 0;
        }
        if (this.A02 != -1) {
            this.A02 = 0;
        }
        while (true) {
            if (this.A0I) {
                int size = this.A0L.size();
                int i11 = this.A0B;
                if (A0N[3].charAt(10) != 'W') {
                    throw new RuntimeException();
                }
                A0N[0] = "z94yFfaTy8Odmt8n2fLZMjDbCxUThPz";
                if (size >= i11) {
                    continue;
                } else if (this.A0L.size() >= 15) {
                    return;
                }
            } else if (this.A0L.size() >= 15) {
                return;
            }
            this.A0L.remove(0);
        }
    }

    public final void A0A(int i11, int i12) {
        if (this.A0A != i11) {
            A09('\n');
        }
        this.A0A = i11;
    }

    public final void A0B(int i11, int i12, int i13) {
        if (this.A04 != -1 && this.A03 != i11) {
            this.A0K.setSpan(new ForegroundColorSpan(this.A03), this.A04, this.A0K.length(), 33);
        }
        if (i11 != A0P) {
            this.A04 = this.A0K.length();
            this.A03 = i11;
        }
        if (this.A02 != -1 && this.A01 != i12) {
            this.A0K.setSpan(new BackgroundColorSpan(this.A01), this.A02, this.A0K.length(), 33);
        }
        if (i12 != A0O) {
            this.A02 = this.A0K.length();
            this.A01 = i12;
        }
    }

    public final void A0C(int i11, int i12, int i13, boolean z11, boolean z12, int i14, int i15) {
        if (this.A06 != -1) {
            if (!z11) {
                this.A0K.setSpan(new StyleSpan(2), this.A06, this.A0K.length(), 33);
                this.A06 = -1;
            }
        } else if (z11) {
            this.A06 = this.A0K.length();
        }
        int i16 = this.A0C;
        if (A0N[3].charAt(10) != 'W') {
            throw new RuntimeException();
        }
        A0N[3] = "GaQXCBjIxpWixMOvnA1JS7CVs7IBjZSt";
        if (i16 == -1) {
            if (z12) {
                this.A0C = this.A0K.length();
            }
        } else {
            if (z12) {
                return;
            }
            this.A0K.setSpan(new UnderlineSpan(), this.A0C, this.A0K.length(), 33);
            this.A0C = -1;
        }
    }

    public final void A0D(int i11, int i12, boolean z11, int i13, int i14, int i15, int i16) {
        this.A0E = i11;
        this.A07 = i16;
    }

    public final void A0E(boolean z11) {
        this.A0J = z11;
    }

    public final void A0F(boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.A0G = true;
        this.A0J = z11;
        this.A0I = z12;
        this.A09 = i11;
        this.A0H = z14;
        this.A0D = i12;
        this.A05 = i13;
        this.A00 = i16;
        if (this.A0B != i14 + 1) {
            int i19 = i14 + 1;
            if (A0N[1].charAt(10) == 's') {
                throw new RuntimeException();
            }
            A0N[5] = "GL1AptVbsbHBPnQiC9PDsuTMTdKpKMZ4";
            this.A0B = i19;
            while (true) {
                if ((!z12 || this.A0L.size() < this.A0B) && this.A0L.size() < 15) {
                    break;
                } else {
                    this.A0L.remove(0);
                }
            }
        }
        if (i17 != 0 && this.A0F != i17) {
            this.A0F = i17;
            int i21 = i17 - 1;
            A0D(A0U[i21], A0Q, A0Y[i21], 0, A0W[i21], A0X[i21], A0V[i21]);
        }
        if (i18 == 0 || this.A08 == i18) {
            return;
        }
        this.A08 = i18;
        int i22 = i18 - 1;
        A0C(0, 1, 1, false, false, A0S[i22], A0T[i22]);
        A0B(A0P, A0R[i22], A0O);
    }

    public final boolean A0G() {
        return this.A0G;
    }

    public final boolean A0H() {
        return !A0G() || (this.A0L.isEmpty() && this.A0K.length() == 0);
    }

    public final boolean A0I() {
        return this.A0J;
    }
}
