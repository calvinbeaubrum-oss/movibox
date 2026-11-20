package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10614o {
    public static byte[] A0I;
    public static String[] A0J = {"NGwI4w5wjKKwr8vIXUEBgcadgt82Mvhc", "UEWVJJvMFTFlt7hH7ERCIJOXwkHPD", "VrTEPZjwbsMyuvHOm", "2WwBzOWctlsBfaK16SO", "SN9IkStz5", "kDHla2kaeJhueA2usdy0jZceB2KGO", "Oz8ehwpCKAgd43CqPtwSSE9zN5", "pRsAYaXPUkY6EiG3qKZOmbtQ8"};
    public int A00;
    public C4C A01;
    public AnonymousClass51 A02;
    public C1278Eb A03;
    public C5B A04;
    public C5B A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public boolean A0E;
    public boolean A0F;
    public final AnonymousClass59 A0G;
    public final AnonymousClass59 A0H;

    static {
        A08();
    }

    public AbstractC10614o() {
        C1813Zg c1813Zg = new C1813Zg(this);
        this.A0G = c1813Zg;
        C1812Zf c1812Zf = new C1812Zf(this);
        this.A0H = c1812Zf;
        this.A04 = new C5B(c1813Zg);
        this.A05 = new C5B(c1812Zf);
        this.A09 = false;
        this.A07 = false;
        this.A06 = false;
        this.A0F = true;
        this.A0E = true;
    }

    public static int A00(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(size, Math.max(i12, i13));
            case 1073741824:
                return size;
            default:
                return Math.max(i12, i13);
        }
    }

    public static int A01(int i11, int i12, int i13, int i14, boolean z11) {
        int iMax = Math.max(0, i11 - i13);
        int i15 = 0;
        int i16 = 0;
        if (z11) {
            if (i14 >= 0) {
                i15 = i14;
                String[] strArr = A0J;
                if (strArr[5].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                A0J[6] = "ru0BYCJI67FO4KgBABZqajada";
                i16 = 1073741824;
            } else if (i14 == -1) {
                switch (i12) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i15 = iMax;
                        i16 = i12;
                        break;
                    case 0:
                        i15 = 0;
                        if (A0J[3].length() == 28) {
                            i16 = 0;
                        } else {
                            A0J[7] = "Nw";
                            i16 = 0;
                        }
                        break;
                }
            } else if (i14 == -2) {
                i15 = 0;
                i16 = 0;
            }
        } else if (i14 >= 0) {
            i15 = i14;
            i16 = 1073741824;
        } else if (i14 == -1) {
            i15 = iMax;
            i16 = i12;
        } else if (i14 == -2) {
            i15 = iMax;
            i16 = (i12 == Integer.MIN_VALUE || i12 == 1073741824) ? Integer.MIN_VALUE : 0;
        }
        return View.MeasureSpec.makeMeasureSpec(i15, i16);
    }

    private final int A02(View view) {
        return ((C10624p) view.getLayoutParams()).A03.bottom;
    }

    private final int A03(View view) {
        return ((C10624p) view.getLayoutParams()).A03.left;
    }

    private final int A04(View view) {
        return ((C10624p) view.getLayoutParams()).A03.right;
    }

    private final int A05(View view) {
        return ((C10624p) view.getLayoutParams()).A03.top;
    }

    private final int A06(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return 0;
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        byte[] bArr = {-2, 33, 33, 34, 33, -35, 19, 38, 34, 52, -35, 37, Ascii.RS, 48, -35, Ascii.SI, 34, 32, 54, 32, 41, 34, 47, 19, 38, 34, 52, -35, Ascii.RS, 48, -35, 45, Ascii.RS, 47, 34, 43, 49, -35, Ascii.US, 50, 49, -35, 51, 38, 34, 52, -35, 38, 48, -35, 43, 44, 49, -35, Ascii.RS, -35, 47, 34, Ascii.RS, 41, -35, 32, 37, 38, 41, 33, -21, -35, Ascii.DC2, 43, 35, 38, 41, 49, 34, 47, 34, 33, -35, 38, 43, 33, 34, 53, -9, -35, -5, 8, 8, 9, Ascii.SO, -70, 7, 9, Ascii.DLE, -1, -70, -5, -70, -3, 2, 3, 6, -2, -70, 0, Ascii.FF, 9, 7, -70, 8, 9, 8, -57, -1, Ascii.DC2, 3, Ascii.CR, Ascii.SO, 3, 8, 1, -70, 3, 8, -2, -1, Ascii.DC2, -44};
        String[] strArr = A0J;
        if (strArr[2].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A0J[6] = "kyP20liVKsmkdJ";
        A0I = bArr;
    }

    private final void A09(int i11) {
        A0C(i11, A0t(i11));
    }

    private final void A0A(int i11) {
        if (A0t(i11) != null) {
            this.A01.A0D(i11);
        }
    }

    private final void A0B(int i11, int i12) {
        View viewA0t = A0t(i11);
        if (viewA0t == null) {
            throw new IllegalArgumentException(A07(85, 44, 79) + i11 + this.A03.toString());
        }
        A09(i11);
        A0E(viewA0t, i12);
    }

    private void A0C(int i11, View view) {
        this.A01.A0C(i11);
    }

    private final void A0D(View view) {
        this.A01.A0F(view);
    }

    private final void A0E(View view, int i11) {
        A0F(view, i11, (C10624p) view.getLayoutParams());
    }

    private final void A0F(View view, int i11, C10624p c10624p) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        if (anonymousClass56A0F.A0a()) {
            this.A03.A0t.A09(anonymousClass56A0F);
        } else {
            C5E c5e = this.A03.A0t;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[0] = "mtQ3Ck4zhf6OC1ISSa3eadAcnNcPftbe";
            c5e.A0A(anonymousClass56A0F);
        }
        this.A01.A0H(view, i11, c10624p, anonymousClass56A0F.A0a());
    }

    private void A0G(View view, int i11, boolean z11) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        if (z11 || anonymousClass56A0F.A0a()) {
            this.A03.A0t.A09(anonymousClass56A0F);
        } else {
            this.A03.A0t.A0A(anonymousClass56A0F);
        }
        C10624p c10624p = (C10624p) view.getLayoutParams();
        if (anonymousClass56A0F.A0g() || anonymousClass56A0F.A0b()) {
            if (anonymousClass56A0F.A0b()) {
                anonymousClass56A0F.A0S();
            } else {
                anonymousClass56A0F.A0O();
            }
            this.A01.A0H(view, i11, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            C1278Eb c1278Eb = this.A03;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[7] = "5ABI9jSeQ";
            if (parent == c1278Eb) {
                int iA07 = this.A01.A07(view);
                if (i11 == -1) {
                    i11 = this.A01.A05();
                }
                if (iA07 == -1) {
                    throw new IllegalStateException(A07(0, 85, 114) + this.A03.indexOfChild(view) + this.A03.A1H());
                }
                if (iA07 != i11) {
                    this.A03.A06.A0B(iA07, i11);
                }
            } else {
                this.A01.A0I(view, i11, false);
                c10624p.A01 = true;
                AnonymousClass51 anonymousClass51 = this.A02;
                if (anonymousClass51 != null && anonymousClass51.A0F()) {
                    this.A02.A0C(view);
                }
            }
        }
        if (c10624p.A02) {
            anonymousClass56A0F.A0H.invalidate();
            c10624p.A02 = false;
        }
    }

    private final void A0H(View view, Rect rect) {
        C1278Eb.A0o(view, rect);
    }

    private void A0J(C10684w c10684w, int i11, View view) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        if (anonymousClass56A0F.A0f()) {
            return;
        }
        if (anonymousClass56A0F.A0Z() && !anonymousClass56A0F.A0a() && !this.A03.A04.A0A()) {
            A0A(i11);
            c10684w.A0X(anonymousClass56A0F);
        } else {
            A09(i11);
            c10684w.A0S(view);
            this.A03.A0t.A0C(anonymousClass56A0F);
        }
    }

    private final void A0K(C10684w c10684w, AnonymousClass53 anonymousClass53, AccessibilityEvent accessibilityEvent) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb == null || accessibilityEvent == null) {
            return;
        }
        boolean z11 = true;
        if (A0J[6].length() == 1) {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[2] = "A1LbQwkKC8kdEmdjm";
        strArr[4] = "mpAFCzQjd";
        if (!c1278Eb.canScrollVertically(1) && !this.A03.canScrollVertically(-1) && !this.A03.canScrollHorizontally(-1) && !this.A03.canScrollHorizontally(1)) {
            z11 = false;
        }
        accessibilityEvent.setScrollable(z11);
        if (A0J[7].length() != 8) {
            A0J[0] = "LKoEdNrfwYhRE769hHSL4lsoF7TmWWKx";
            if (this.A03.A04 == null) {
                return;
            }
        } else if (this.A03.A04 == null) {
            return;
        }
        accessibilityEvent.setItemCount(this.A03.A04.A0E());
    }

    private final void A0L(C10684w c10684w, AnonymousClass53 anonymousClass53, C10403s c10403s) {
        if (this.A03.canScrollVertically(-1) || this.A03.canScrollHorizontally(-1)) {
            c10403s.A0N(8192);
            c10403s.A0R(true);
        }
        if (this.A03.canScrollVertically(1) || this.A03.canScrollHorizontally(1)) {
            c10403s.A0N(4096);
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[2] = "WKK7ZU1nOyoZ4isR3";
            strArr2[4] = "S1xUaVTVF";
            c10403s.A0R(true);
        }
        c10403s.A0P(C10373p.A00(A0r(c10684w, anonymousClass53), A0q(c10684w, anonymousClass53), A0P(c10684w, anonymousClass53), A06(c10684w, anonymousClass53)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(AnonymousClass51 anonymousClass51) {
        if (this.A02 == anonymousClass51) {
            this.A02 = null;
        }
    }

    private final boolean A0N() {
        AnonymousClass51 anonymousClass51 = this.A02;
        return anonymousClass51 != null && anonymousClass51.A0F();
    }

    public static boolean A0O(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (i13 > 0 && i11 != i13) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                return size >= i11;
            case 0:
                return true;
            case 1073741824:
                return size == i11;
            default:
                return false;
        }
    }

    private final boolean A0P(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return false;
    }

    private final boolean A0Q(C10684w c10684w, AnonymousClass53 anonymousClass53, int i11, Bundle bundle) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb == null) {
            return false;
        }
        int iA0X = 0;
        int iA0h = 0;
        switch (i11) {
            case 4096:
                iA0X = c1278Eb.canScrollVertically(1) ? (A0X() - A0g()) - A0d() : 0;
                if (this.A03.canScrollHorizontally(1)) {
                    iA0h = (A0h() - A0e()) - A0f();
                }
                break;
            case 8192:
                iA0X = c1278Eb.canScrollVertically(-1) ? -((A0X() - A0g()) - A0d()) : 0;
                if (this.A03.canScrollHorizontally(-1)) {
                    iA0h = -((A0h() - A0e()) - A0f());
                }
                break;
        }
        if (iA0X == 0 && iA0h == 0) {
            return false;
        }
        C1278Eb c1278Eb2 = this.A03;
        if (A0J[7].length() == 8) {
            throw new RuntimeException();
        }
        A0J[7] = "6TTpYbQ6a4";
        c1278Eb2.scrollBy(iA0h, iA0X);
        return true;
    }

    private final boolean A0R(C10684w c10684w, AnonymousClass53 anonymousClass53, View view, int i11, Bundle bundle) {
        return false;
    }

    private boolean A0S(C1278Eb c1278Eb, int i11, int i12) {
        View focusedChild = c1278Eb.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int iA0e = A0e();
        int iA0g = A0g();
        int iA0h = A0h() - A0f();
        int iA0X = A0X() - A0d();
        Rect rect = this.A03.A0p;
        A0H(focusedChild, rect);
        if (rect.left - i11 >= iA0h || rect.right - i11 <= iA0e || rect.top - i12 >= iA0X || rect.bottom - i12 <= iA0g) {
            return false;
        }
        if (A0J[3].length() == 28) {
            throw new RuntimeException();
        }
        A0J[0] = "D1nd79aIos3YYe4Hq7EzCaafqnQh2NEe";
        return true;
    }

    @Deprecated
    private final boolean A0T(C1278Eb c1278Eb, View view, View view2) {
        return A0N() || c1278Eb.A1q();
    }

    private int[] A0U(View view, Rect rect) {
        int[] iArr = new int[2];
        int iA0e = A0e();
        int iA0g = A0g();
        int iA0h = A0h() - A0f();
        int iA0X = A0X() - A0d();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int iWidth = rect.width() + left;
        int iHeight = rect.height() + top;
        int iMin = Math.min(0, left - iA0e);
        int iMin2 = Math.min(0, top - iA0g);
        int iMax = Math.max(0, iWidth - iA0h);
        int iMax2 = Math.max(0, iHeight - iA0X);
        if (A0a() != 1) {
            iMax = iMin != 0 ? iMin : Math.min(left - iA0e, iMax);
        } else if (iMax == 0) {
            iMax = Math.max(iMin, iWidth - iA0h);
        }
        if (iMin2 == 0) {
            iMin2 = Math.min(top - iA0g, iMax2);
        }
        iArr[0] = iMax;
        iArr[1] = iMin2;
        if (A0J[0].charAt(31) == 'p') {
            throw new RuntimeException();
        }
        A0J[0] = "97vXAXgJ0WxvI5IvBZpOR2Ky1DZNuVnu";
        return iArr;
    }

    public final int A0V() {
        return -1;
    }

    public final int A0W() {
        C4C c4c = this.A01;
        if (c4c != null) {
            return c4c.A05();
        }
        return 0;
    }

    public final int A0X() {
        return this.A0A;
    }

    public final int A0Y() {
        return this.A0B;
    }

    public final int A0Z() {
        C1278Eb c1278Eb = this.A03;
        AbstractC10494c adapter = c1278Eb != null ? c1278Eb.getAdapter() : null;
        if (adapter != null) {
            return adapter.A0E();
        }
        return 0;
    }

    public final int A0a() {
        return C3T.A01(this.A03);
    }

    public final int A0b() {
        return C3T.A02(this.A03);
    }

    public final int A0c() {
        return C3T.A03(this.A03);
    }

    public final int A0d() {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            return c1278Eb.getPaddingBottom();
        }
        return 0;
    }

    public final int A0e() {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            return c1278Eb.getPaddingLeft();
        }
        return 0;
    }

    public final int A0f() {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            return c1278Eb.getPaddingRight();
        }
        return 0;
    }

    public final int A0g() {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            return c1278Eb.getPaddingTop();
        }
        return 0;
    }

    public final int A0h() {
        return this.A0C;
    }

    public final int A0i() {
        return this.A0D;
    }

    public final int A0j(View view) {
        return view.getBottom() + A02(view);
    }

    public final int A0k(View view) {
        return view.getLeft() - A03(view);
    }

    public final int A0l(View view) {
        Rect rect = ((C10624p) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0m(View view) {
        Rect rect = ((C10624p) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0n(View view) {
        return view.getRight() + A04(view);
    }

    public final int A0o(View view) {
        return view.getTop() - A05(view);
    }

    public final int A0p(View view) {
        return ((C10624p) view.getLayoutParams()).A00();
    }

    public int A0q(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb == null || c1278Eb.A04 == null || !A20()) {
            return 1;
        }
        return this.A03.A04.A0E();
    }

    public int A0r(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb == null || c1278Eb.A04 == null || !A21()) {
            return 1;
        }
        return this.A03.A04.A0E();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005b A[RETURN] */
    public final View A0s() {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb == null) {
            return null;
        }
        View focusedChild = c1278Eb.getFocusedChild();
        String[] strArr = A0J;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0J[3] = "iiKud1wfkCloFGZ1U";
        if (focusedChild != null) {
            C4C c4c = this.A01;
            String[] strArr2 = A0J;
            if (strArr2[5].length() != strArr2[1].length()) {
                A0J[0] = "7ET4ZuKdeEmot2qkcvXky1gJdqYIXUUX";
                if (!c4c.A0K(focusedChild)) {
                    return focusedChild;
                }
            } else {
                A0J[7] = "xPYIlKgRfeB9qWlMIQGlIgoODb";
                if (!c4c.A0K(focusedChild)) {
                    return focusedChild;
                }
            }
        }
        return null;
    }

    public final View A0t(int i11) {
        C4C c4c = this.A01;
        if (c4c != null) {
            return c4c.A09(i11);
        }
        return null;
    }

    public final View A0u(View view, int i11) {
        return null;
    }

    public C10624p A0v(Context context, AttributeSet attributeSet) {
        return new C10624p(context, attributeSet);
    }

    public C10624p A0w(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C10624p) {
            return new C10624p((C10624p) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C10624p((ViewGroup.MarginLayoutParams) layoutParams) : new C10624p(layoutParams);
    }

    public final void A0x() {
        AnonymousClass51 anonymousClass51 = this.A02;
        if (anonymousClass51 != null) {
            anonymousClass51.A09();
        }
    }

    public final void A0y() {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            c1278Eb.requestLayout();
        }
    }

    public final void A0z(int i11) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            c1278Eb.A1T(i11);
        }
    }

    public final void A10(int i11) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            c1278Eb.A1U(i11);
        }
    }

    public final void A11(int i11, int i12) {
        this.A0C = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        this.A0D = mode;
        if (mode == 0 && !C1278Eb.A1B) {
            this.A0C = 0;
        }
        this.A0A = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        this.A0B = mode2;
        if (mode2 != 0 || C1278Eb.A1B) {
            return;
        }
        this.A0A = 0;
    }

    public final void A12(int i11, int i12) {
        int iA0W = A0W();
        if (iA0W == 0) {
            this.A03.A1a(i11, i12);
            return;
        }
        int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i15 = Integer.MIN_VALUE;
        int i16 = Integer.MIN_VALUE;
        for (int i17 = 0; i17 < iA0W; i17++) {
            View viewA0t = A0t(i17);
            Rect rect = this.A03.A0p;
            A0H(viewA0t, rect);
            if (rect.left < i13) {
                i13 = rect.left;
            }
            if (rect.right > i15) {
                i15 = rect.right;
            }
            if (rect.top < i14) {
                i14 = rect.top;
            }
            if (rect.bottom > i16) {
                i16 = rect.bottom;
            }
        }
        this.A03.A0p.set(i13, i14, i15, i16);
        String[] strArr = A0J;
        if (strArr[2].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[2] = "hT857kPIBtMq0qM94";
        strArr2[4] = "qfhhOTku3";
        A15(this.A03.A0p, i11, i12);
    }

    public final void A13(int i11, int i12) {
        this.A03.setMeasuredDimension(i11, i12);
    }

    public final void A14(int i11, C10684w c10684w) {
        View viewA0t = A0t(i11);
        A0A(i11);
        c10684w.A0T(viewA0t);
    }

    public void A15(Rect rect, int i11, int i12) {
        A13(A00(i11, rect.width() + A0e() + A0f(), A0c()), A00(i12, rect.height() + A0g() + A0d(), A0b()));
    }

    public final void A16(View view) {
        A18(view, -1);
    }

    public final void A17(View view) {
        A19(view, -1);
    }

    public final void A18(View view, int i11) {
        A0G(view, i11, true);
    }

    public final void A19(View view, int i11) {
        A0G(view, i11, false);
    }

    public final void A1A(View view, int i11, int i12) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        Rect rectA1D = this.A03.A1D(view);
        int i13 = i11 + rectA1D.left + rectA1D.right;
        int i14 = i12 + rectA1D.top + rectA1D.bottom;
        int iA01 = A01(A0h(), A0i(), A0e() + A0f() + c10624p.leftMargin + c10624p.rightMargin + i13, c10624p.width, A20());
        int iA02 = A01(A0X(), A0Y(), A0g() + A0d() + c10624p.topMargin + c10624p.bottomMargin + i14, c10624p.height, A21());
        if (A1W(view, iA01, iA02, c10624p)) {
            view.measure(iA01, iA02);
        }
    }

    public final void A1B(View view, int i11, int i12, int i13, int i14) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        Rect rect = c10624p.A03;
        view.layout(rect.left + i11 + c10624p.leftMargin, rect.top + i12 + c10624p.topMargin, (i13 - rect.right) - c10624p.rightMargin, (i14 - rect.bottom) - c10624p.bottomMargin);
    }

    public final void A1C(View view, C10403s c10403s) {
        AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(view);
        if (anonymousClass56A0F == null || anonymousClass56A0F.A0a() || this.A01.A0K(anonymousClass56A0F.A0H)) {
            return;
        }
        A1K(this.A03.A0r, this.A03.A0s, view, c10403s);
    }

    public final void A1D(View view, C10684w c10684w) {
        A0D(view);
        c10684w.A0T(view);
    }

    public final void A1E(View view, boolean z11, Rect rect) {
        Matrix matrix;
        if (z11) {
            Rect rect2 = ((C10624p) view.getLayoutParams()).A03;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.A03 != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.A03.A0q;
            rectF.set(rect);
            matrix.mapRect(rectF);
            int iFloor = (int) Math.floor(rectF.left);
            int iFloor2 = (int) Math.floor(rectF.top);
            float f11 = rectF.right;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[7] = "WbBFuKAltYM";
            rect.set(iFloor, iFloor2, (int) Math.ceil(f11), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void A1F(C10403s c10403s) {
        A0L(this.A03.A0r, this.A03.A0s, c10403s);
    }

    public final void A1G(C10684w c10684w) {
        int iA0E = c10684w.A0E();
        for (int i11 = iA0E - 1; i11 >= 0; i11--) {
            View viewA0F = c10684w.A0F(i11);
            AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(viewA0F);
            if (!anonymousClass56A0F.A0f()) {
                anonymousClass56A0F.A0X(false);
                if (anonymousClass56A0F.A0c()) {
                    this.A03.removeDetachedView(viewA0F, false);
                }
                if (this.A03.A05 != null) {
                    this.A03.A05.A0K(anonymousClass56A0F);
                }
                anonymousClass56A0F.A0X(true);
                c10684w.A0R(viewA0F);
            }
        }
        c10684w.A0L();
        if (iA0E > 0) {
            this.A03.invalidate();
        }
    }

    public final void A1H(C10684w c10684w) {
        for (int iA0W = A0W() - 1; iA0W >= 0; iA0W--) {
            A0J(c10684w, iA0W, A0t(iA0W));
        }
    }

    public final void A1I(C10684w c10684w) {
        for (int iA0W = A0W() - 1; iA0W >= 0; iA0W--) {
            if (!C1278Eb.A0F(A0t(iA0W)).A0f()) {
                A14(iA0W, c10684w);
            }
        }
    }

    public void A1J(C10684w c10684w, AnonymousClass53 anonymousClass53, int i11, int i12) {
        this.A03.A1a(i11, i12);
    }

    public void A1K(C10684w c10684w, AnonymousClass53 anonymousClass53, View view, C10403s c10403s) {
        int iA0p = A21() ? A0p(view) : 0;
        int iA0p2 = A20() ? A0p(view) : 0;
        String[] strArr = A0J;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0J[3] = "h476R5jl";
        c10403s.A0Q(C10383q.A00(iA0p, 1, iA0p2, 1, false, false));
    }

    public final void A1L(AnonymousClass51 anonymousClass51) {
        AnonymousClass51 anonymousClass52 = this.A02;
        if (anonymousClass52 != null && anonymousClass51 != anonymousClass52 && anonymousClass52.A0F()) {
            this.A02.A09();
        }
        this.A02 = anonymousClass51;
        anonymousClass51.A0D(this.A03, this);
    }

    public void A1M(C1278Eb c1278Eb) {
    }

    public final void A1N(C1278Eb c1278Eb) {
        this.A07 = true;
    }

    public final void A1O(C1278Eb c1278Eb) {
        A11(View.MeasureSpec.makeMeasureSpec(c1278Eb.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(c1278Eb.getHeight(), 1073741824));
    }

    public final void A1P(C1278Eb c1278Eb) {
        if (c1278Eb == null) {
            this.A03 = null;
            this.A01 = null;
            this.A0C = 0;
            this.A0A = 0;
        } else {
            this.A03 = c1278Eb;
            this.A01 = c1278Eb.A01;
            this.A0C = c1278Eb.getWidth();
            this.A0A = c1278Eb.getHeight();
        }
        this.A0D = 1073741824;
        this.A0B = 1073741824;
    }

    public final void A1Q(C1278Eb c1278Eb, C10684w c10684w) {
        this.A07 = false;
        A1w(c1278Eb, c10684w);
    }

    public final void A1R(boolean z11) {
        this.A06 = z11;
    }

    public final boolean A1S() {
        int iA0W = A0W();
        for (int i11 = 0; i11 < iA0W; i11++) {
            ViewGroup.LayoutParams layoutParams = A0t(i11).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean A1T() {
        C1278Eb c1278Eb = this.A03;
        return c1278Eb != null && c1278Eb.A0B;
    }

    public final boolean A1U() {
        return this.A0E;
    }

    public final boolean A1V(int i11, Bundle bundle) {
        return A0Q(this.A03.A0r, this.A03.A0s, i11, bundle);
    }

    public final boolean A1W(View view, int i11, int i12, C10624p c10624p) {
        return (!view.isLayoutRequested() && this.A0F && A0O(view.getWidth(), i11, c10624p.width) && A0O(view.getHeight(), i12, c10624p.height)) ? false : true;
    }

    public final boolean A1X(View view, int i11, Bundle bundle) {
        return A0R(this.A03.A0r, this.A03.A0s, view, i11, bundle);
    }

    public boolean A1Y(C10624p c10624p) {
        return c10624p != null;
    }

    public final boolean A1Z(C1278Eb c1278Eb, View view, Rect rect, boolean z11) {
        return A1a(c1278Eb, view, rect, z11, false);
    }

    public final boolean A1a(C1278Eb c1278Eb, View view, Rect rect, boolean z11, boolean z12) {
        int[] iArrA0U = A0U(view, rect);
        int i11 = iArrA0U[0];
        int i12 = iArrA0U[1];
        if ((z12 && !A0S(c1278Eb, i11, i12)) || (i11 == 0 && i12 == 0)) {
            return false;
        }
        if (z11) {
            c1278Eb.scrollBy(i11, i12);
        } else {
            c1278Eb.A1c(i11, i12);
        }
        return true;
    }

    public final boolean A1b(C1278Eb c1278Eb, AnonymousClass53 anonymousClass53, View view, View view2) {
        return A0T(c1278Eb, view, view2);
    }

    public final boolean A1c(C1278Eb c1278Eb, ArrayList<View> arrayList, int i11, int i12) {
        return false;
    }

    public abstract int A1d(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53);

    public abstract int A1e(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53);

    public abstract int A1f(AnonymousClass53 anonymousClass53);

    public abstract int A1g(AnonymousClass53 anonymousClass53);

    public abstract int A1h(AnonymousClass53 anonymousClass53);

    public abstract int A1i(AnonymousClass53 anonymousClass53);

    public abstract int A1j(AnonymousClass53 anonymousClass53);

    public abstract int A1k(AnonymousClass53 anonymousClass53);

    public abstract Parcelable A1l();

    public View A1m(int i11) {
        int iA0W = A0W();
        for (int i12 = 0; i12 < iA0W; i12++) {
            View viewA0t = A0t(i12);
            AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(viewA0t);
            if (anonymousClass56A0F != null && anonymousClass56A0F.A0I() == i11 && !anonymousClass56A0F.A0f() && (this.A03.A0s.A07() || !anonymousClass56A0F.A0a())) {
                return viewA0t;
            }
        }
        return null;
    }

    public abstract View A1n(View view, int i11, C10684w c10684w, AnonymousClass53 anonymousClass53);

    public abstract C10624p A1o();

    public abstract void A1p(int i11);

    public abstract void A1q(int i11, int i12, AnonymousClass53 anonymousClass53, InterfaceC10594m interfaceC10594m);

    public abstract void A1r(int i11, InterfaceC10594m interfaceC10594m);

    public abstract void A1s(Parcelable parcelable);

    public void A1t(AccessibilityEvent accessibilityEvent) {
        A0K(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public abstract void A1u(C10684w c10684w, AnonymousClass53 anonymousClass53);

    public void A1v(AnonymousClass53 anonymousClass53) {
    }

    public void A1w(C1278Eb c1278Eb, C10684w c10684w) {
    }

    public abstract void A1x(C1278Eb c1278Eb, AnonymousClass53 anonymousClass53, int i11);

    public void A1y(String str) {
        C1278Eb c1278Eb = this.A03;
        if (c1278Eb != null) {
            c1278Eb.A1l(str);
        }
    }

    public abstract boolean A1z();

    public abstract boolean A20();

    public abstract boolean A21();

    public abstract boolean A22();
}
