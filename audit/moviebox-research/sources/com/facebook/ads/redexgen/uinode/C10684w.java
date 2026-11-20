package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4w, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10684w {
    public static byte[] A09;
    public static String[] A0A = {"ulA9tMpXJ0Fgz3L6", "kmBp6JcSqPlb9eogqvbvj6g5ppHVaWSS", "klPqAM4BpBJNr6xIOjiQhoS6UO4TrOHS", "7VyM9GgXJuu8YzSYQI3HrMroeBYRJajD", "jF2bnw6E6wYHKm8plX11kYiLrSAbSJmD", "6pBnRch9VxXRPJwtqH0gd323b09mKXXU", "Clk2oRExhn8z5HC1wWkAqM8aEwWEfAA8", "Myq33IQdIYqIzBMhSJhfspyke76FBM0c"};
    public int A00;
    public C4v A01;
    public ArrayList<AnonymousClass56> A02;
    public int A03;
    public AnonymousClass54 A04;
    public final ArrayList<AnonymousClass56> A05;
    public final ArrayList<AnonymousClass56> A06;
    public final List<AnonymousClass56> A07;
    public final /* synthetic */ C1278Eb A08;

    static {
        A05();
    }

    public C10684w(C1278Eb c1278Eb) {
        this.A08 = c1278Eb;
        ArrayList<AnonymousClass56> arrayList = new ArrayList<>();
        this.A05 = arrayList;
        this.A02 = null;
        this.A06 = new ArrayList<>();
        this.A07 = Collections.unmodifiableList(arrayList);
        this.A03 = 2;
        this.A00 = 2;
    }

    private final View A00(int i11, boolean z11) {
        return A0I(i11, z11, Long.MAX_VALUE).A0H;
    }

    private final AnonymousClass56 A01(int i11) {
        int size;
        int iA04;
        ArrayList<AnonymousClass56> arrayList = this.A02;
        if (arrayList == null || (size = arrayList.size()) == 0) {
            return null;
        }
        for (int i12 = 0; i12 < size; i12++) {
            AnonymousClass56 anonymousClass56 = this.A02.get(i12);
            if (!anonymousClass56.A0g() && anonymousClass56.A0I() == i11) {
                anonymousClass56.A0T(32);
                return anonymousClass56;
            }
        }
        if (this.A08.A04.A0A() && (iA04 = this.A08.A00.A04(i11)) > 0 && iA04 < this.A08.A04.A0E()) {
            long jA04 = this.A08.A04.A04(iA04);
            for (int i13 = 0; i13 < size; i13++) {
                AnonymousClass56 anonymousClass57 = this.A02.get(i13);
                if (!anonymousClass57.A0g() && anonymousClass57.A0K() == jA04) {
                    anonymousClass57.A0T(32);
                    return anonymousClass57;
                }
            }
        }
        return null;
    }

    private final AnonymousClass56 A02(int i11, boolean z11) {
        View viewA08;
        int size = this.A05.size();
        for (int i12 = 0; i12 < size; i12++) {
            AnonymousClass56 anonymousClass56 = this.A05.get(i12);
            if (!anonymousClass56.A0g() && anonymousClass56.A0I() == i11 && !anonymousClass56.A0Z() && (this.A08.A0s.A09 || !anonymousClass56.A0a())) {
                anonymousClass56.A0T(32);
                return anonymousClass56;
            }
        }
        if (!z11 && (viewA08 = this.A08.A01.A08(i11)) != null) {
            AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(viewA08);
            this.A08.A01.A0G(viewA08);
            int iA07 = this.A08.A01.A07(viewA08);
            if (iA07 == -1) {
                throw new IllegalStateException(A04(565, 52, 17) + anonymousClass56A0F + this.A08.A1H());
            }
            this.A08.A01.A0C(iA07);
            A0S(viewA08);
            anonymousClass56A0F.A0T(8224);
            return anonymousClass56A0F;
        }
        int size2 = this.A06.size();
        for (int i13 = 0; i13 < size2; i13++) {
            AnonymousClass56 anonymousClass57 = this.A06.get(i13);
            if (!anonymousClass57.A0Z() && anonymousClass57.A0I() == i11) {
                if (!z11) {
                    this.A06.remove(i13);
                }
                return anonymousClass57;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009a  */
    /* JADX WARN: Code duplicated, block: B:31:0x00af  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x0130  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ec A[SYNTHETIC] */
    private final AnonymousClass56 A03(long j11, int i11, boolean z11) {
        ArrayList<AnonymousClass56> arrayList;
        String[] strArr;
        String[] strArr2;
        for (int size = this.A05.size() - 1; size >= 0; size--) {
            AnonymousClass56 anonymousClass56 = this.A05.get(size);
            if (anonymousClass56.A0K() == j11 && !anonymousClass56.A0g()) {
                if (i11 == anonymousClass56.A0H()) {
                    anonymousClass56.A0T(32);
                    if (anonymousClass56.A0a()) {
                        C1278Eb c1278Eb = this.A08;
                        if (A0A[4].charAt(3) == 'b') {
                            A0A[0] = "q3aWXTgT7NsVf007";
                            if (!c1278Eb.A0s.A07()) {
                                String[] strArr3 = A0A;
                                if (strArr3[2].charAt(0) != strArr3[1].charAt(0)) {
                                    A0A[4] = "NC6bFXUosLdTEwJsXrsHGkbXBsQUMG7q";
                                    anonymousClass56.A0U(2, 14);
                                } else {
                                    String[] strArr4 = A0A;
                                    strArr4[2] = "kBSMDIkt47Rx4hHhTamY1xnSrMWRxYxp";
                                    strArr4[1] = "kToZLwND7zKVFlbtf8XZb6UwHA5zPLAu";
                                    anonymousClass56.A0U(2, 14);
                                }
                            }
                        }
                        throw new RuntimeException();
                    }
                    return anonymousClass56;
                }
                if (!z11) {
                    this.A05.remove(size);
                    this.A08.removeDetachedView(anonymousClass56.A0H, false);
                    A0R(anonymousClass56.A0H);
                }
            }
        }
        for (int size2 = this.A06.size() - 1; size2 >= 0; size2--) {
            AnonymousClass56 anonymousClass57 = this.A06.get(size2);
            if (anonymousClass57.A0K() == j11) {
                int iA0H = anonymousClass57.A0H();
                if (A0A[0].length() != 16) {
                    String[] strArr5 = A0A;
                    strArr5[7] = "lrD7iCy3KBiO8gA6PsFToJiVZrW1xMAl";
                    strArr5[6] = "amz9CZtibeJcU8bEqG7a4ZYgRNeZgxWk";
                    if (i11 == iA0H) {
                        if (!z11) {
                            arrayList = this.A06;
                            strArr = A0A;
                            if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                                String[] strArr6 = A0A;
                                strArr6[5] = "or4YmCu0ppqzW1VFAnuQtpcwvOCNSyKL";
                                strArr6[3] = "x7G8xrEgau2heO3LEdjWfX9qC3RDyC0d";
                                arrayList.remove(size2);
                            } else {
                                arrayList.remove(size2);
                            }
                        }
                        return anonymousClass57;
                    }
                    if (!z11) {
                        A07(size2);
                        strArr2 = A0A;
                        if (strArr2[2].charAt(0) == strArr2[1].charAt(0)) {
                            A0A[4] = "2lrbY7WLbUziAPe6QkcwvBQ2VEr9QFta";
                            return null;
                        }
                        throw new RuntimeException();
                    }
                } else {
                    String[] strArr7 = A0A;
                    strArr7[2] = "kYzWBiiTSiU3KogqfJ4EJctPAodLTQqF";
                    strArr7[1] = "kIBKgO4naDZyukeXVXxcwMENrZxoY36q";
                    if (i11 == iA0H) {
                        if (!z11) {
                            arrayList = this.A06;
                            strArr = A0A;
                            if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                                String[] strArr8 = A0A;
                                strArr8[5] = "or4YmCu0ppqzW1VFAnuQtpcwvOCNSyKL";
                                strArr8[3] = "x7G8xrEgau2heO3LEdjWfX9qC3RDyC0d";
                                arrayList.remove(size2);
                            } else {
                                arrayList.remove(size2);
                            }
                        }
                        return anonymousClass57;
                    }
                    if (!z11) {
                        A07(size2);
                        strArr2 = A0A;
                        if (strArr2[2].charAt(0) == strArr2[1].charAt(0)) {
                            A0A[4] = "2lrbY7WLbUziAPe6QkcwvBQ2VEr9QFta";
                            return null;
                        }
                        throw new RuntimeException();
                    }
                }
            }
        }
        return null;
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A09 = new byte[]{-91, -18, -8, -58, -7, -7, -26, -24, -19, -22, -23, -65, -59, -32, 39, Ascii.RS, Ascii.RS, 43, Ascii.GS, 44, -14, -53, -48, -62, -21, Ascii.SYN, 7, Ascii.SI, -62, 5, 17, Ascii.ETB, Ascii.DLE, Ascii.SYN, -36, -38, -33, 36, 37, Ascii.DC2, 37, Ascii.SYN, -21, -99, -69, -58, -58, -65, -66, 122, -51, -67, -52, -69, -54, 122, -48, -61, -65, -47, 122, -47, -61, -50, -62, 122, -69, -56, 122, -61, -56, -48, -69, -58, -61, -66, 122, -48, -61, -65, -47, -120, 122, -93, -56, -48, -69, -58, -61, -66, 122, -48, -61, -65, -47, -51, 122, -67, -69, -56, -56, -55, -50, 122, -68, -65, 122, -52, -65, -49, -51, -65, -66, 122, -64, -52, -55, -57, 122, -51, -67, -52, -69, -54, -122, 122, -50, -62, -65, -45, 122, -51, -62, -55, -49, -58, -66, 122, -52, -65, -68, -55, -49, -56, -66, 122, -64, -52, -55, -57, 122, -52, -65, -67, -45, -67, -58, -65, -52, 122, -54, -55, -55, -58, -120, -7, Ascii.RS, 19, Ascii.US, Ascii.RS, 35, Ascii.EM, 35, 36, Ascii.NAK, Ascii.RS, 19, 41, -48, Ascii.DC4, Ascii.NAK, 36, Ascii.NAK, 19, 36, Ascii.NAK, Ascii.DC4, -34, -48, -7, Ascii.RS, 38, 17, Ascii.FS, Ascii.EM, Ascii.DC4, -48, Ascii.EM, 36, Ascii.NAK, Ascii.GS, -48, 32, Ascii.US, 35, Ascii.EM, 36, Ascii.EM, Ascii.US, Ascii.RS, -48, -13, Ascii.CAN, Ascii.CR, Ascii.EM, Ascii.CAN, Ascii.GS, 19, Ascii.GS, Ascii.RS, Ascii.SI, Ascii.CAN, Ascii.CR, 35, -54, Ascii.SO, Ascii.SI, Ascii.RS, Ascii.SI, Ascii.CR, Ascii.RS, Ascii.SI, Ascii.SO, -40, -54, -13, Ascii.CAN, 32, Ascii.VT, Ascii.SYN, 19, Ascii.SO, -54, 32, 19, Ascii.SI, 33, -54, Ascii.DC2, Ascii.EM, Ascii.SYN, Ascii.SO, Ascii.SI, Ascii.FS, -54, Ascii.VT, Ascii.SO, Ascii.VT, Ascii.SUB, Ascii.RS, Ascii.SI, Ascii.FS, -54, Ascii.SUB, Ascii.EM, Ascii.GS, 19, Ascii.RS, 19, Ascii.EM, Ascii.CAN, -125, -88, -80, -101, -90, -93, -98, 90, -93, -82, -97, -89, 90, -86, -87, -83, -93, -82, -93, -87, -88, 90, -63, -47, -32, -49, -34, -34, -45, -46, -114, -35, -32, -114, -49, -30, -30, -49, -47, -42, -45, -46, -114, -28, -41, -45, -27, -31, -114, -37, -49, -25, -114, -36, -35, -30, -114, -48, -45, -114, -32, -45, -47, -25, -47, -38, -45, -46, -100, -114, -41, -31, -63, -47, -32, -49, -34, -88, -35, -10, -7, -87, -19, -18, -3, -22, -20, -15, -18, -19, -87, -1, -14, -18, 0, -87, -4, -15, -8, -2, -11, -19, -87, -21, -18, -87, -5, -18, -10, -8, -1, -18, -19, -87, -17, -5, -8, -10, -87, -37, -18, -20, 2, -20, -11, -18, -5, -33, -14, -18, 0, -87, -21, -18, -17, -8, -5, -18, -87, -14, -3, -87, -20, -22, -9, -87, -21, -18, -87, -5, -18, -20, 2, -20, -11, -18, -19, -61, -87, -102, -72, -65, -81, -76, -83, 102, -70, -75, 102, -72, -85, -87, -65, -87, -78, -85, 102, -89, -76, 102, -81, -83, -76, -75, -72, -85, -86, 102, -68, -81, -85, -67, 102, -82, -75, -78, -86, -85, -72, 116, 102, -97, -75, -69, 102, -71, -82, -75, -69, -78, -86, 102, -84, -81, -72, -71, -70, 102, -87, -89, -78, -78, 102, -71, -70, -75, -74, -113, -83, -76, -75, -72, -81, -76, -83, -100, -81, -85, -67, 110, -68, -81, -85, -67, 111, 102, -88, -85, -84, -75, -72, -85, 102, -87, -89, -78, -78, -81, -76, -83, 102, -72, -85, -87, -65, -87, -78, -85, 116, -19, -21, -6, -36, -17, -21, -3, -52, -11, -8, -42, -11, -7, -17, -6, -17, -11, -12, -57, -12, -22, -38, -1, -10, -21, -73, -84, -60, -70, -64, -65, 107, -76, -71, -81, -80, -61, 107, -66, -77, -70, -64, -73, -81, 107, -71, -70, -65, 107, -83, -80, 107, 120, 124, 107, -84, -79, -65, -80, -67, 107, -64, -71, -77, -76, -81, -76, -71, -78, 107, -84, 107, -63, -76, -80, -62, -123, -60, -61, -85, -66, -70, -52, -89, -70, -72, -50, -72, -63, -70, -71};
    }

    private final void A06() {
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            A07(size);
        }
        this.A06.clear();
        if (C1278Eb.A1E) {
            this.A08.A02.A02();
        }
    }

    private final void A07(int i11) {
        A0Z(this.A06.get(i11), true);
        this.A06.remove(i11);
    }

    private void A08(ViewGroup viewGroup, boolean z11) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                String[] strArr = A0A;
                if (strArr[7].charAt(8) == strArr[6].charAt(8)) {
                    throw new RuntimeException();
                }
                A0A[4] = "0ZJbYELQTNKw4GYvMFOIJ2JFgvUoupt2";
                A08((ViewGroup) childAt, true);
            }
        }
        if (z11) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }

    private void A09(AnonymousClass56 anonymousClass56) {
        if (this.A08.A1o()) {
            View view = anonymousClass56.A0H;
            if (C3T.A00(view) == 0) {
                C3T.A09(view, 1);
            }
            if (C3T.A0F(view)) {
                return;
            }
            anonymousClass56.A0T(16384);
            C3T.A0B(view, this.A08.A09.A0A());
        }
    }

    private void A0A(AnonymousClass56 anonymousClass56) {
        if (anonymousClass56.A0H instanceof ViewGroup) {
            A08((ViewGroup) anonymousClass56.A0H, false);
        }
    }

    private final void A0B(AnonymousClass56 anonymousClass56) {
        if (0 != 0) {
            throw new NullPointerException(A04(617, 14, 27));
        }
        if (this.A08.A0s != null) {
            this.A08.A0t.A0B(anonymousClass56);
        }
    }

    private final boolean A0C(AnonymousClass56 anonymousClass56) {
        if (anonymousClass56.A0a()) {
            return this.A08.A0s.A07();
        }
        if (anonymousClass56.A03 < 0 || anonymousClass56.A03 >= this.A08.A04.A0E()) {
            throw new IndexOutOfBoundsException(A04(211, 60, 112) + anonymousClass56 + this.A08.A1H());
        }
        if (this.A08.A0s.A07() || this.A08.A04.A03(anonymousClass56.A03) == anonymousClass56.A0H()) {
            return !this.A08.A04.A0A() || anonymousClass56.A0K() == this.A08.A04.A04(anonymousClass56.A03);
        }
        return false;
    }

    private boolean A0D(AnonymousClass56 anonymousClass56, int i11, int i12, long j11) {
        anonymousClass56.A08 = this.A08;
        int iA0H = anonymousClass56.A0H();
        long nanoTime = this.A08.getNanoTime();
        if (j11 != Long.MAX_VALUE) {
            C4v c4v = this.A01;
            String[] strArr = A0A;
            if (strArr[5].charAt(0) == strArr[3].charAt(0)) {
                throw new RuntimeException();
            }
            A0A[0] = "We3abAYlnqMpJzTP";
            if (!c4v.A0A(iA0H, nanoTime, j11)) {
                return false;
            }
        }
        this.A08.A04.A09(anonymousClass56, i11);
        this.A01.A05(anonymousClass56.A0H(), this.A08.getNanoTime() - nanoTime);
        A09(anonymousClass56);
        if (!this.A08.A0s.A07()) {
            return true;
        }
        anonymousClass56.A04 = i12;
        return true;
    }

    public final int A0E() {
        return this.A05.size();
    }

    public final View A0F(int i11) {
        return this.A05.get(i11).A0H;
    }

    public final View A0G(int i11) {
        return A00(i11, false);
    }

    public final C4v A0H() {
        if (this.A01 == null) {
            this.A01 = new C4v();
        }
        return this.A01;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0246  */
    /* JADX WARN: Code duplicated, block: B:102:0x024c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0264  */
    /* JADX WARN: Code duplicated, block: B:106:0x026d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0273  */
    /* JADX WARN: Code duplicated, block: B:110:0x028f  */
    /* JADX WARN: Code duplicated, block: B:111:0x02a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0180 A[DONT_INVERT, PHI: r7 r9
  0x0180: PHI (r7v3 boolean) = (r7v2 boolean), (r7v4 boolean), (r7v4 boolean) binds: [B:24:0x0052, B:50:0x00c5, B:66:0x0173] A[DONT_GENERATE, DONT_INLINE]
  0x0180: PHI (r9v3 com.facebook.ads.redexgen.X.56) = (r9v2 com.facebook.ads.redexgen.X.56), (r9v5 com.facebook.ads.redexgen.X.56), (r9v6 com.facebook.ads.redexgen.X.56) binds: [B:24:0x0052, B:50:0x00c5, B:66:0x0173] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0182  */
    /* JADX WARN: Code duplicated, block: B:74:0x019f  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cd A[PHI: r6
  0x01cd: PHI (r6v3 boolean) = (r6v2 boolean), (r6v1 boolean), (r6v1 boolean) binds: [B:110:0x028f, B:107:0x0271, B:79:0x01cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:84:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x0206 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:92:0x020b  */
    /* JADX WARN: Code duplicated, block: B:93:0x020d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0215  */
    /* JADX WARN: Code duplicated, block: B:98:0x022f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0243  */
    public final AnonymousClass56 A0I(int i11, boolean z11, long j11) {
        boolean zA0D;
        int iA04;
        String[] strArr;
        boolean zA0e;
        String[] strArr2;
        View view;
        ViewGroup.LayoutParams layoutParams;
        C10624p c10624p;
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams;
        String[] strArr3;
        C1278Eb c1278EbA0H;
        if (i11 < 0 || i11 >= this.A08.A0s.A03()) {
            throw new IndexOutOfBoundsException(A04(271, 22, 0) + i11 + A04(12, 1, 99) + i11 + A04(21, 14, 104) + this.A08.A0s.A03() + this.A08.A1H());
        }
        boolean z12 = false;
        AnonymousClass56 anonymousClass56A05 = null;
        if (this.A08.A0s.A07()) {
            anonymousClass56A05 = A01(i11);
            z12 = anonymousClass56A05 != null;
        }
        if (anonymousClass56A05 == null && (anonymousClass56A05 = A02(i11, z11)) != null) {
            if (A0C(anonymousClass56A05)) {
                z12 = true;
            } else {
                if (!z11) {
                    anonymousClass56A05.A0T(4);
                    if (anonymousClass56A05.A0b()) {
                        this.A08.removeDetachedView(anonymousClass56A05.A0H, false);
                        anonymousClass56A05.A0S();
                    } else if (anonymousClass56A05.A0g()) {
                        anonymousClass56A05.A0O();
                    }
                    A0X(anonymousClass56A05);
                }
                anonymousClass56A05 = null;
            }
        }
        if (anonymousClass56A05 != null) {
            if (z12 && !this.A08.A0s.A07() && anonymousClass56A05.A0i(8192)) {
                anonymousClass56A05.A0U(0, 8192);
                if (this.A08.A0s.A0C) {
                    this.A08.A1i(anonymousClass56A05, this.A08.A05.A09(this.A08.A0s, anonymousClass56A05, AbstractC10574k.A00(anonymousClass56A05) | 4096, anonymousClass56A05.A0L()));
                }
            }
            zA0D = false;
            if (!this.A08.A0s.A07() && anonymousClass56A05.A0Y()) {
                anonymousClass56A05.A04 = i11;
            } else if (anonymousClass56A05.A0Y()) {
                zA0e = anonymousClass56A05.A0e();
                strArr2 = A0A;
                if (strArr2[7].charAt(8) != strArr2[6].charAt(8)) {
                    A0A[0] = "CFgmPUuP3iY97c6j";
                    if (!zA0e) {
                        if (anonymousClass56A05.A0Z()) {
                        }
                    }
                } else if (!zA0e) {
                    if (anonymousClass56A05.A0Z()) {
                    }
                }
                iA04 = this.A08.A00.A04(i11);
                strArr = A0A;
                if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                    String[] strArr4 = A0A;
                    strArr4[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                    strArr4[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                    zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                }
            } else {
                iA04 = this.A08.A00.A04(i11);
                strArr = A0A;
                if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                    String[] strArr5 = A0A;
                    strArr5[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                    strArr5[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                    zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                }
            }
            view = anonymousClass56A05.A0H;
            if (A0A[4].charAt(3) == 'b') {
                String[] strArr6 = A0A;
                strArr6[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                strArr6[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                } else if (this.A08.checkLayoutParams(layoutParams)) {
                    c10624p = (C10624p) layoutParams;
                } else {
                    layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                    strArr3 = A0A;
                    if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                        String[] strArr7 = A0A;
                        strArr7[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                        strArr7[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                        c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                    }
                }
                c10624p.A00 = anonymousClass56A05;
                c10624p.A02 = !z12 && zA0D;
                return anonymousClass56A05;
            }
        } else {
            int iA05 = this.A08.A00.A04(i11);
            if (iA05 < 0 || iA05 >= this.A08.A04.A0E()) {
                throw new IndexOutOfBoundsException(A04(165, 46, 118) + i11 + A04(13, 8, WebSocketProtocol.PAYLOAD_SHORT) + iA05 + A04(35, 8, 119) + this.A08.A0s.A03() + this.A08.A1H());
            }
            int iA03 = this.A08.A04.A03(iA05);
            if (this.A08.A04.A0A() && (anonymousClass56A05 = A03(this.A08.A04.A04(iA05), iA03, z11)) != null) {
                anonymousClass56A05.A03 = iA05;
                z12 = true;
            }
            if (anonymousClass56A05 == null && 0 != 0) {
                throw new NullPointerException(A04(540, 25, 76));
            }
            if (anonymousClass56A05 == null && (anonymousClass56A05 = A0H().A03(iA03)) != null) {
                anonymousClass56A05.A0Q();
                if (C1278Eb.A1C) {
                    A0A(anonymousClass56A05);
                }
            }
            if (anonymousClass56A05 == null) {
                long nanoTime = this.A08.getNanoTime();
                if (j11 == Long.MAX_VALUE || this.A01.A0B(iA03, nanoTime, j11)) {
                    anonymousClass56A05 = this.A08.A04.A05(this.A08, iA03);
                    if (C1278Eb.A1E && (c1278EbA0H = C1278Eb.A0H(anonymousClass56A05.A0H)) != null) {
                        anonymousClass56A05.A09 = new WeakReference<>(c1278EbA0H);
                    }
                    this.A01.A06(iA03, this.A08.getNanoTime() - nanoTime);
                    if (z12) {
                        anonymousClass56A05.A0U(0, 8192);
                        if (this.A08.A0s.A0C) {
                            this.A08.A1i(anonymousClass56A05, this.A08.A05.A09(this.A08.A0s, anonymousClass56A05, AbstractC10574k.A00(anonymousClass56A05) | 4096, anonymousClass56A05.A0L()));
                        }
                    }
                    zA0D = false;
                    if (!this.A08.A0s.A07()) {
                        if (anonymousClass56A05.A0Y()) {
                            zA0e = anonymousClass56A05.A0e();
                            strArr2 = A0A;
                            if (strArr2[7].charAt(8) != strArr2[6].charAt(8)) {
                                A0A[0] = "CFgmPUuP3iY97c6j";
                                if (!zA0e) {
                                    if (anonymousClass56A05.A0Z()) {
                                        view = anonymousClass56A05.A0H;
                                        if (A0A[4].charAt(3) == 'b') {
                                            String[] strArr8 = A0A;
                                            strArr8[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                            strArr8[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                            layoutParams = view.getLayoutParams();
                                            if (layoutParams == null) {
                                                c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                                anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                            } else if (this.A08.checkLayoutParams(layoutParams)) {
                                                layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                                strArr3 = A0A;
                                                if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                                    String[] strArr9 = A0A;
                                                    strArr9[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                                    strArr9[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                                    c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                                }
                                            } else {
                                                c10624p = (C10624p) layoutParams;
                                            }
                                            c10624p.A00 = anonymousClass56A05;
                                            c10624p.A02 = !z12 && zA0D;
                                            return anonymousClass56A05;
                                        }
                                    }
                                }
                            } else if (!zA0e) {
                                if (anonymousClass56A05.A0Z()) {
                                    view = anonymousClass56A05.A0H;
                                    if (A0A[4].charAt(3) == 'b') {
                                        String[] strArr10 = A0A;
                                        strArr10[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                        strArr10[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                        layoutParams = view.getLayoutParams();
                                        if (layoutParams == null) {
                                            c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        } else if (this.A08.checkLayoutParams(layoutParams)) {
                                            layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                            strArr3 = A0A;
                                            if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                                String[] strArr11 = A0A;
                                                strArr11[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                                strArr11[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                                c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                                anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                            }
                                        } else {
                                            c10624p = (C10624p) layoutParams;
                                        }
                                        c10624p.A00 = anonymousClass56A05;
                                        c10624p.A02 = !z12 && zA0D;
                                        return anonymousClass56A05;
                                    }
                                }
                            }
                            iA04 = this.A08.A00.A04(i11);
                            strArr = A0A;
                            if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                                String[] strArr12 = A0A;
                                strArr12[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                                strArr12[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                                zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                                view = anonymousClass56A05.A0H;
                                if (A0A[4].charAt(3) == 'b') {
                                    String[] strArr13 = A0A;
                                    strArr13[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                    strArr13[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                    layoutParams = view.getLayoutParams();
                                    if (layoutParams == null) {
                                        c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    } else if (this.A08.checkLayoutParams(layoutParams)) {
                                        layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                        strArr3 = A0A;
                                        if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                            String[] strArr14 = A0A;
                                            strArr14[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                            strArr14[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                            c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        }
                                    } else {
                                        c10624p = (C10624p) layoutParams;
                                    }
                                    c10624p.A00 = anonymousClass56A05;
                                    c10624p.A02 = !z12 && zA0D;
                                    return anonymousClass56A05;
                                }
                            }
                        } else {
                            iA04 = this.A08.A00.A04(i11);
                            strArr = A0A;
                            if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                                String[] strArr15 = A0A;
                                strArr15[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                                strArr15[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                                zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                                view = anonymousClass56A05.A0H;
                                if (A0A[4].charAt(3) == 'b') {
                                    String[] strArr16 = A0A;
                                    strArr16[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                    strArr16[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                    layoutParams = view.getLayoutParams();
                                    if (layoutParams == null) {
                                        c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    } else if (this.A08.checkLayoutParams(layoutParams)) {
                                        layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                        strArr3 = A0A;
                                        if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                            String[] strArr17 = A0A;
                                            strArr17[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                            strArr17[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                            c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        }
                                    } else {
                                        c10624p = (C10624p) layoutParams;
                                    }
                                    c10624p.A00 = anonymousClass56A05;
                                    c10624p.A02 = !z12 && zA0D;
                                    return anonymousClass56A05;
                                }
                            }
                        }
                    } else if (anonymousClass56A05.A0Y()) {
                        zA0e = anonymousClass56A05.A0e();
                        strArr2 = A0A;
                        if (strArr2[7].charAt(8) != strArr2[6].charAt(8)) {
                            A0A[0] = "CFgmPUuP3iY97c6j";
                            if (!zA0e) {
                                if (anonymousClass56A05.A0Z()) {
                                    view = anonymousClass56A05.A0H;
                                    if (A0A[4].charAt(3) == 'b') {
                                        String[] strArr18 = A0A;
                                        strArr18[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                        strArr18[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                        layoutParams = view.getLayoutParams();
                                        if (layoutParams == null) {
                                            c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        } else if (this.A08.checkLayoutParams(layoutParams)) {
                                            layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                            strArr3 = A0A;
                                            if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                                String[] strArr19 = A0A;
                                                strArr19[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                                strArr19[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                                c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                                anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                            }
                                        } else {
                                            c10624p = (C10624p) layoutParams;
                                        }
                                        c10624p.A00 = anonymousClass56A05;
                                        c10624p.A02 = !z12 && zA0D;
                                        return anonymousClass56A05;
                                    }
                                }
                            }
                        } else if (!zA0e) {
                            if (anonymousClass56A05.A0Z()) {
                                view = anonymousClass56A05.A0H;
                                if (A0A[4].charAt(3) == 'b') {
                                    String[] strArr110 = A0A;
                                    strArr110[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                    strArr110[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                    layoutParams = view.getLayoutParams();
                                    if (layoutParams == null) {
                                        c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    } else if (this.A08.checkLayoutParams(layoutParams)) {
                                        layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                        strArr3 = A0A;
                                        if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                            String[] strArr111 = A0A;
                                            strArr111[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                            strArr111[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                            c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        }
                                    } else {
                                        c10624p = (C10624p) layoutParams;
                                    }
                                    c10624p.A00 = anonymousClass56A05;
                                    c10624p.A02 = !z12 && zA0D;
                                    return anonymousClass56A05;
                                }
                            }
                        }
                        iA04 = this.A08.A00.A04(i11);
                        strArr = A0A;
                        if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                            String[] strArr112 = A0A;
                            strArr112[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                            strArr112[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                            zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                            view = anonymousClass56A05.A0H;
                            if (A0A[4].charAt(3) == 'b') {
                                String[] strArr113 = A0A;
                                strArr113[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                strArr113[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                layoutParams = view.getLayoutParams();
                                if (layoutParams == null) {
                                    c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                } else if (this.A08.checkLayoutParams(layoutParams)) {
                                    layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                    strArr3 = A0A;
                                    if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                        String[] strArr114 = A0A;
                                        strArr114[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                        strArr114[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                        c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    }
                                } else {
                                    c10624p = (C10624p) layoutParams;
                                }
                                c10624p.A00 = anonymousClass56A05;
                                c10624p.A02 = !z12 && zA0D;
                                return anonymousClass56A05;
                            }
                        }
                    } else {
                        iA04 = this.A08.A00.A04(i11);
                        strArr = A0A;
                        if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                            String[] strArr115 = A0A;
                            strArr115[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                            strArr115[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                            zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                            view = anonymousClass56A05.A0H;
                            if (A0A[4].charAt(3) == 'b') {
                                String[] strArr116 = A0A;
                                strArr116[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                strArr116[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                layoutParams = view.getLayoutParams();
                                if (layoutParams == null) {
                                    c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                } else if (this.A08.checkLayoutParams(layoutParams)) {
                                    layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                    strArr3 = A0A;
                                    if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                        String[] strArr117 = A0A;
                                        strArr117[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                        strArr117[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                        c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    }
                                } else {
                                    c10624p = (C10624p) layoutParams;
                                }
                                c10624p.A00 = anonymousClass56A05;
                                c10624p.A02 = !z12 && zA0D;
                                return anonymousClass56A05;
                            }
                        }
                    }
                } else {
                    String[] strArr20 = A0A;
                    if (strArr20[7].charAt(8) != strArr20[6].charAt(8)) {
                        A0A[4] = "fdYbLns5cH4Uqi6qZhk44zURNmgZymnf";
                        return null;
                    }
                }
            } else {
                if (z12) {
                    anonymousClass56A05.A0U(0, 8192);
                    if (this.A08.A0s.A0C) {
                        this.A08.A1i(anonymousClass56A05, this.A08.A05.A09(this.A08.A0s, anonymousClass56A05, AbstractC10574k.A00(anonymousClass56A05) | 4096, anonymousClass56A05.A0L()));
                    }
                }
                zA0D = false;
                if (!this.A08.A0s.A07()) {
                    if (anonymousClass56A05.A0Y()) {
                        zA0e = anonymousClass56A05.A0e();
                        strArr2 = A0A;
                        if (strArr2[7].charAt(8) != strArr2[6].charAt(8)) {
                            A0A[0] = "CFgmPUuP3iY97c6j";
                            if (!zA0e) {
                                if (anonymousClass56A05.A0Z()) {
                                    view = anonymousClass56A05.A0H;
                                    if (A0A[4].charAt(3) == 'b') {
                                        String[] strArr118 = A0A;
                                        strArr118[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                        strArr118[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                        layoutParams = view.getLayoutParams();
                                        if (layoutParams == null) {
                                            c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        } else if (this.A08.checkLayoutParams(layoutParams)) {
                                            layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                            strArr3 = A0A;
                                            if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                                String[] strArr119 = A0A;
                                                strArr119[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                                strArr119[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                                c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                                anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                            }
                                        } else {
                                            c10624p = (C10624p) layoutParams;
                                        }
                                        c10624p.A00 = anonymousClass56A05;
                                        c10624p.A02 = !z12 && zA0D;
                                        return anonymousClass56A05;
                                    }
                                }
                            }
                        } else if (!zA0e) {
                            if (anonymousClass56A05.A0Z()) {
                                view = anonymousClass56A05.A0H;
                                if (A0A[4].charAt(3) == 'b') {
                                    String[] strArr1110 = A0A;
                                    strArr1110[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                    strArr1110[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                    layoutParams = view.getLayoutParams();
                                    if (layoutParams == null) {
                                        c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    } else if (this.A08.checkLayoutParams(layoutParams)) {
                                        layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                        strArr3 = A0A;
                                        if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                            String[] strArr1111 = A0A;
                                            strArr1111[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                            strArr1111[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                            c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        }
                                    } else {
                                        c10624p = (C10624p) layoutParams;
                                    }
                                    c10624p.A00 = anonymousClass56A05;
                                    c10624p.A02 = !z12 && zA0D;
                                    return anonymousClass56A05;
                                }
                            }
                        }
                        iA04 = this.A08.A00.A04(i11);
                        strArr = A0A;
                        if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                            String[] strArr1112 = A0A;
                            strArr1112[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                            strArr1112[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                            zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                            view = anonymousClass56A05.A0H;
                            if (A0A[4].charAt(3) == 'b') {
                                String[] strArr1113 = A0A;
                                strArr1113[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                strArr1113[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                layoutParams = view.getLayoutParams();
                                if (layoutParams == null) {
                                    c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                } else if (this.A08.checkLayoutParams(layoutParams)) {
                                    layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                    strArr3 = A0A;
                                    if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                        String[] strArr1114 = A0A;
                                        strArr1114[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                        strArr1114[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                        c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    }
                                } else {
                                    c10624p = (C10624p) layoutParams;
                                }
                                c10624p.A00 = anonymousClass56A05;
                                c10624p.A02 = !z12 && zA0D;
                                return anonymousClass56A05;
                            }
                        }
                    } else {
                        iA04 = this.A08.A00.A04(i11);
                        strArr = A0A;
                        if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                            String[] strArr1115 = A0A;
                            strArr1115[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                            strArr1115[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                            zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                            view = anonymousClass56A05.A0H;
                            if (A0A[4].charAt(3) == 'b') {
                                String[] strArr1116 = A0A;
                                strArr1116[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                strArr1116[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                layoutParams = view.getLayoutParams();
                                if (layoutParams == null) {
                                    c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                } else if (this.A08.checkLayoutParams(layoutParams)) {
                                    layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                    strArr3 = A0A;
                                    if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                        String[] strArr1117 = A0A;
                                        strArr1117[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                        strArr1117[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                        c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    }
                                } else {
                                    c10624p = (C10624p) layoutParams;
                                }
                                c10624p.A00 = anonymousClass56A05;
                                c10624p.A02 = !z12 && zA0D;
                                return anonymousClass56A05;
                            }
                        }
                    }
                } else if (anonymousClass56A05.A0Y()) {
                    zA0e = anonymousClass56A05.A0e();
                    strArr2 = A0A;
                    if (strArr2[7].charAt(8) != strArr2[6].charAt(8)) {
                        A0A[0] = "CFgmPUuP3iY97c6j";
                        if (!zA0e) {
                            if (anonymousClass56A05.A0Z()) {
                                view = anonymousClass56A05.A0H;
                                if (A0A[4].charAt(3) == 'b') {
                                    String[] strArr1118 = A0A;
                                    strArr1118[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                    strArr1118[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                    layoutParams = view.getLayoutParams();
                                    if (layoutParams == null) {
                                        c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    } else if (this.A08.checkLayoutParams(layoutParams)) {
                                        layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                        strArr3 = A0A;
                                        if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                            String[] strArr1119 = A0A;
                                            strArr1119[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                            strArr1119[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                            c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                            anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                        }
                                    } else {
                                        c10624p = (C10624p) layoutParams;
                                    }
                                    c10624p.A00 = anonymousClass56A05;
                                    c10624p.A02 = !z12 && zA0D;
                                    return anonymousClass56A05;
                                }
                            }
                        }
                    } else if (!zA0e) {
                        if (anonymousClass56A05.A0Z()) {
                            view = anonymousClass56A05.A0H;
                            if (A0A[4].charAt(3) == 'b') {
                                String[] strArr11110 = A0A;
                                strArr11110[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                                strArr11110[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                                layoutParams = view.getLayoutParams();
                                if (layoutParams == null) {
                                    c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                } else if (this.A08.checkLayoutParams(layoutParams)) {
                                    layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                    strArr3 = A0A;
                                    if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                        String[] strArr11111 = A0A;
                                        strArr11111[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                        strArr11111[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                        c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                        anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                    }
                                } else {
                                    c10624p = (C10624p) layoutParams;
                                }
                                c10624p.A00 = anonymousClass56A05;
                                c10624p.A02 = !z12 && zA0D;
                                return anonymousClass56A05;
                            }
                        }
                    }
                    iA04 = this.A08.A00.A04(i11);
                    strArr = A0A;
                    if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                        String[] strArr11112 = A0A;
                        strArr11112[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                        strArr11112[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                        zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                        view = anonymousClass56A05.A0H;
                        if (A0A[4].charAt(3) == 'b') {
                            String[] strArr11113 = A0A;
                            strArr11113[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                            strArr11113[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                            layoutParams = view.getLayoutParams();
                            if (layoutParams == null) {
                                c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                anonymousClass56A05.A0H.setLayoutParams(c10624p);
                            } else if (this.A08.checkLayoutParams(layoutParams)) {
                                layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                strArr3 = A0A;
                                if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                    String[] strArr11114 = A0A;
                                    strArr11114[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                    strArr11114[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                    c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                }
                            } else {
                                c10624p = (C10624p) layoutParams;
                            }
                            c10624p.A00 = anonymousClass56A05;
                            c10624p.A02 = !z12 && zA0D;
                            return anonymousClass56A05;
                        }
                    }
                } else {
                    iA04 = this.A08.A00.A04(i11);
                    strArr = A0A;
                    if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                        String[] strArr11115 = A0A;
                        strArr11115[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                        strArr11115[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                        zA0D = A0D(anonymousClass56A05, iA04, i11, j11);
                        view = anonymousClass56A05.A0H;
                        if (A0A[4].charAt(3) == 'b') {
                            String[] strArr11116 = A0A;
                            strArr11116[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                            strArr11116[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                            layoutParams = view.getLayoutParams();
                            if (layoutParams == null) {
                                c10624p = (C10624p) this.A08.generateDefaultLayoutParams();
                                anonymousClass56A05.A0H.setLayoutParams(c10624p);
                            } else if (this.A08.checkLayoutParams(layoutParams)) {
                                layoutParamsGenerateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                                strArr3 = A0A;
                                if (strArr3[2].charAt(0) == strArr3[1].charAt(0)) {
                                    String[] strArr11117 = A0A;
                                    strArr11117[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                                    strArr11117[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                                    c10624p = (C10624p) layoutParamsGenerateLayoutParams;
                                    anonymousClass56A05.A0H.setLayoutParams(c10624p);
                                }
                            } else {
                                c10624p = (C10624p) layoutParams;
                            }
                            c10624p.A00 = anonymousClass56A05;
                            c10624p.A02 = !z12 && zA0D;
                            return anonymousClass56A05;
                        }
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    public final List<AnonymousClass56> A0J() {
        return this.A07;
    }

    public final void A0K() {
        int size = this.A06.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.A06.get(i11).A0M();
        }
        int size2 = this.A05.size();
        for (int i12 = 0; i12 < size2; i12++) {
            this.A05.get(i12).A0M();
        }
        ArrayList<AnonymousClass56> arrayList = this.A02;
        String[] strArr = A0A;
        if (strArr[2].charAt(0) != strArr[1].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[7] = "w7WcMXH384MQxArKBWq9tfOfmOANhXYh";
        strArr2[6] = "ji6HgViVTGyvfONq8Vqt8Uaju4D1iJHU";
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i13 = 0; i13 < size3; i13++) {
                this.A02.get(i13).A0M();
            }
        }
    }

    public final void A0L() {
        this.A05.clear();
        ArrayList<AnonymousClass56> arrayList = this.A02;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final void A0M() {
        int size = this.A06.size();
        for (int i11 = 0; i11 < size; i11++) {
            C10624p c10624p = (C10624p) this.A06.get(i11).A0H.getLayoutParams();
            if (c10624p != null) {
                c10624p.A01 = true;
            }
        }
    }

    public final void A0N() {
        if (this.A08.A04 == null || !this.A08.A04.A0A()) {
            A06();
            return;
        }
        int size = this.A06.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnonymousClass56 anonymousClass56 = this.A06.get(i11);
            if (A0A[0].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[2] = "kx9etu5Uswf3mlSSd54JM5SDJxoMGNTv";
            strArr[1] = "kxxNK4Rys8aPJuu822sP3fs8sDM7v1G0";
            if (anonymousClass56 != null) {
                anonymousClass56.A0T(6);
                anonymousClass56.A0W(null);
            }
        }
    }

    public final void A0O() {
        int i11;
        if (this.A08.A06 != null) {
            AbstractC10614o abstractC10614o = this.A08.A06;
            if (A0A[0].length() == 16) {
                String[] strArr = A0A;
                strArr[2] = "kSelswvDf1EbxUzrii1mBr6dHJR0d4zj";
                strArr[1] = "kcuGN1lunmBh6z5P1vsNJWvgiUTpOK0Q";
                i11 = abstractC10614o.A00;
            }
            throw new RuntimeException();
        }
        i11 = 0;
        this.A00 = this.A03 + i11;
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            int size2 = this.A06.size();
            String[] strArr2 = A0A;
            if (strArr2[2].charAt(0) != strArr2[1].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0A;
            strArr3[2] = "kpxxdOz3cEfo3MLV8RPQuR2Jasv2n6jF";
            strArr3[1] = "kgO1H2GjmHeLX2ZusVi9gFRUJKE1zGI0";
            if (size2 <= this.A00) {
                return;
            }
            A07(size);
        }
    }

    public final void A0P() {
        this.A05.clear();
        A06();
    }

    public final void A0Q(int i11) {
        this.A03 = i11;
        A0O();
    }

    public final void A0R(View view) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        anonymousClass56A0F.A0F = null;
        anonymousClass56A0F.A0G = false;
        anonymousClass56A0F.A0O();
        A0X(anonymousClass56A0F);
    }

    public final void A0S(View view) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        if (!anonymousClass56A0F.A0i(12) && anonymousClass56A0F.A0d() && !this.A08.A1w(anonymousClass56A0F)) {
            if (this.A02 == null) {
                this.A02 = new ArrayList<>();
            }
            anonymousClass56A0F.A0V(this, true);
            this.A02.add(anonymousClass56A0F);
            return;
        }
        boolean zA0Z = anonymousClass56A0F.A0Z();
        if (A0A[0].length() != 16) {
            throw new RuntimeException();
        }
        String[] strArr = A0A;
        strArr[5] = "cscHAR4ImnAFzAxZJ9yqjMNa91RcN8Vb";
        strArr[3] = "pspTzLDNU823NSI2ymIgIumCpfqVQlal";
        if (zA0Z && !anonymousClass56A0F.A0a() && !this.A08.A04.A0A()) {
            throw new IllegalArgumentException(A04(43, 122, 32) + this.A08.A1H());
        }
        anonymousClass56A0F.A0V(this, false);
        this.A05.add(anonymousClass56A0F);
    }

    public final void A0T(View view) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        if (anonymousClass56A0F.A0c()) {
            this.A08.removeDetachedView(view, false);
        }
        if (anonymousClass56A0F.A0b()) {
            anonymousClass56A0F.A0S();
        } else if (anonymousClass56A0F.A0g()) {
            anonymousClass56A0F.A0O();
        }
        A0X(anonymousClass56A0F);
    }

    public final void A0U(AbstractC10494c abstractC10494c, AbstractC10494c abstractC10494c2, boolean z11) {
        A0P();
        A0H().A08(abstractC10494c, abstractC10494c2, z11);
    }

    public final void A0V(C4v c4v) {
        C4v c4v2 = this.A01;
        if (c4v2 != null) {
            c4v2.A04();
        }
        this.A01 = c4v;
        if (c4v != null) {
            c4v.A07(this.A08.getAdapter());
        }
    }

    public final void A0W(AnonymousClass54 anonymousClass54) {
        this.A04 = anonymousClass54;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:58:0x0128 A[LOOP:0: B:45:0x00f3->B:58:0x0128, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0109 A[EDGE_INSN: B:68:0x0109->B:48:0x0109 BREAK  A[LOOP:0: B:45:0x00f3->B:58:0x0128], SYNTHETIC] */
    public final void A0X(AnonymousClass56 anonymousClass56) {
        int size;
        int i11;
        if (anonymousClass56.A0b() || anonymousClass56.A0H.getParent() != null) {
            throw new IllegalArgumentException(A04(293, 56, 52) + anonymousClass56.A0b() + A04(0, 12, 75) + (anonymousClass56.A0H.getParent() != null) + this.A08.A1H());
        }
        boolean zA0c = anonymousClass56.A0c();
        String[] strArr = A0A;
        if (strArr[2].charAt(0) != strArr[1].charAt(0)) {
            throw new RuntimeException();
        }
        A0A[4] = "QZZbfikyhDCMiV1imXgamooHNWBI4VfH";
        if (zA0c) {
            throw new IllegalArgumentException(A04(349, 81, 79) + anonymousClass56 + this.A08.A1H());
        }
        if (anonymousClass56.A0f()) {
            throw new IllegalArgumentException(A04(430, Worker.WHAT_QUIT, 12) + this.A08.A1H());
        }
        boolean zA09 = anonymousClass56.A09();
        boolean z11 = false;
        boolean z12 = false;
        if ((this.A08.A04 != null && zA09 && this.A08.A04.A0B(anonymousClass56)) || anonymousClass56.A0h()) {
            int i12 = this.A00;
            String[] strArr2 = A0A;
            if (strArr2[2].charAt(0) != strArr2[1].charAt(0)) {
                A0A[4] = "JXkbPmQXP2BcwiEI3FqqjfiGok6rwhAB";
                if (i12 > 0) {
                    if (!anonymousClass56.A0i(526)) {
                        size = this.A06.size();
                        if (size >= this.A00 && size > 0) {
                            A07(0);
                            size--;
                        }
                        if (C1278Eb.A1E && size > 0 && !this.A08.A02.A05(anonymousClass56.A03)) {
                            i11 = size - 1;
                            while (i11 >= 0) {
                                if (!this.A08.A02.A05(this.A06.get(i11).A03)) {
                                    break;
                                } else {
                                    i11--;
                                }
                            }
                            size = i11 + 1;
                        }
                        this.A06.add(size, anonymousClass56);
                        z11 = true;
                    }
                }
            } else {
                A0A[4] = "iMRb6lH7bzEtCSJD4TfZYArDATXy6kqw";
                if (i12 > 0) {
                    if (!anonymousClass56.A0i(526)) {
                        size = this.A06.size();
                        if (size >= this.A00) {
                            A07(0);
                            size--;
                        }
                        if (C1278Eb.A1E) {
                            i11 = size - 1;
                            while (i11 >= 0) {
                                if (!this.A08.A02.A05(this.A06.get(i11).A03)) {
                                    break;
                                    break;
                                }
                                i11--;
                            }
                            size = i11 + 1;
                        }
                        this.A06.add(size, anonymousClass56);
                        z11 = true;
                    }
                }
            }
            if (!z11) {
                A0Z(anonymousClass56, true);
                z12 = true;
            }
        }
        this.A08.A0t.A0B(anonymousClass56);
        if (z11 || z12 || !zA09) {
            return;
        }
        anonymousClass56.A08 = null;
    }

    public final void A0Y(AnonymousClass56 anonymousClass56) {
        if (anonymousClass56.A0G) {
            this.A02.remove(anonymousClass56);
        } else {
            this.A05.remove(anonymousClass56);
        }
        anonymousClass56.A0F = null;
        anonymousClass56.A0G = false;
        anonymousClass56.A0O();
    }

    public final void A0Z(AnonymousClass56 anonymousClass56, boolean z11) {
        C1278Eb.A0s(anonymousClass56);
        if (anonymousClass56.A0i(16384)) {
            anonymousClass56.A0U(0, 16384);
            C3T.A0B(anonymousClass56.A0H, null);
        }
        if (z11) {
            A0B(anonymousClass56);
        }
        anonymousClass56.A08 = null;
        A0H().A09(anonymousClass56);
    }
}
