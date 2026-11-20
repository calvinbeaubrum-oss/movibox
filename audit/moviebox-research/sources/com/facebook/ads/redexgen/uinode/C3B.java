package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3B {
    public static String[] A05 = {"efs8eZdEWHsCfUb6qOzicmMnQm4SneBY", "GPD1kjm6fR3i7blABsL8PkfqVt5tQ0ec", "1ZMAOqgxiysbgCK2QhJ8YR6mzQdOOVTU", "tADzoHnDRwqyF4JfOWpRm", "", "2dCxtsKJi8key4A0", "YZUwpVg0T4azRRaUQd2X9mlkfrI9cQeh", "C6BrW2LKkOXM7XSn"};
    public ViewParent A00;
    public ViewParent A01;
    public boolean A02;
    public int[] A03;
    public final View A04;

    public C3B(View view) {
        this.A04 = view;
    }

    private ViewParent A00(int i11) {
        switch (i11) {
            case 0:
                return this.A01;
            case 1:
                return this.A00;
            default:
                return null;
        }
    }

    private void A01(int i11, ViewParent viewParent) {
        switch (i11) {
            case 0:
                this.A01 = viewParent;
                break;
            case 1:
                this.A00 = viewParent;
                break;
        }
    }

    public final void A02() {
        A03(0);
    }

    public final void A03(int i11) {
        ViewParent viewParentA00 = A00(i11);
        if (viewParentA00 != null) {
            AbstractC10313j.A02(viewParentA00, this.A04, i11);
            A01(i11, null);
        }
    }

    public final void A04(boolean z11) {
        if (this.A02) {
            C3T.A08(this.A04);
        }
        this.A02 = z11;
    }

    public final boolean A05() {
        return A09(0);
    }

    public final boolean A06() {
        return this.A02;
    }

    public final boolean A07(float f11, float f12) {
        ViewParent viewParentA00;
        if (!A06() || (viewParentA00 = A00(0)) == null) {
            return false;
        }
        return AbstractC10313j.A06(viewParentA00, this.A04, f11, f12);
    }

    public final boolean A08(float f11, float f12, boolean z11) {
        ViewParent viewParentA00;
        if (!A06() || (viewParentA00 = A00(0)) == null) {
            return false;
        }
        return AbstractC10313j.A07(viewParentA00, this.A04, f11, f12, z11);
    }

    public final boolean A09(int i11) {
        return A00(i11) != null;
    }

    public final boolean A0A(int i11) {
        return A0B(i11, 0);
    }

    public final boolean A0B(int i11, int i12) {
        if (A09(i12)) {
            return true;
        }
        if (!A06()) {
            return false;
        }
        if (A05[0].charAt(13) == 't') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[6] = "WHooJguTbRSPJrOooyt3LEnarcCTCzBe";
        strArr[1] = "8Bjeqw0rr3DdKBFvYwfvH0FxnGa8049d";
        View view = this.A04;
        for (ViewParent parent = this.A04.getParent(); parent != null; parent = parent.getParent()) {
            if (AbstractC10313j.A08(parent, view, this.A04, i11, i12)) {
                A01(i12, parent);
                AbstractC10313j.A05(parent, view, this.A04, i11, i12);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public final boolean A0C(int i11, int i12, int i13, int i14, int[] iArr) {
        return A0D(i11, i12, i13, i14, iArr, 0);
    }

    public final boolean A0D(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        ViewParent viewParentA00;
        if (!A06() || (viewParentA00 = A00(i15)) == null) {
            return false;
        }
        if (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        int i16 = 0;
        int i17 = 0;
        if (iArr != null) {
            this.A04.getLocationInWindow(iArr);
            i16 = iArr[0];
            i17 = iArr[1];
        }
        AbstractC10313j.A03(viewParentA00, this.A04, i11, i12, i13, i14, i15);
        if (iArr != null) {
            this.A04.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i16;
            iArr[1] = iArr[1] - i17;
        }
        return true;
    }

    public final boolean A0E(int i11, int i12, int[] iArr, int[] iArr2) {
        return A0F(i11, i12, iArr, iArr2, 0);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0060  */
    public final boolean A0F(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        ViewParent viewParentA00;
        int[] iArr3 = iArr;
        if (!A06() || (viewParentA00 = A00(i13)) == null) {
            return false;
        }
        if (i11 == 0 && i12 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        int i14 = 0;
        int i15 = 0;
        if (A05[3].length() == 9) {
            throw new RuntimeException();
        }
        A05[0] = "3VbjZKhXDsexEmt2meqPVZABMNEQkFPW";
        if (iArr2 != null) {
            this.A04.getLocationInWindow(iArr2);
            i14 = iArr2[0];
            i15 = iArr2[1];
        }
        if (iArr3 == null) {
            int[] iArr4 = this.A03;
            String[] strArr = A05;
            if (strArr[5].length() != strArr[7].length()) {
                A05[4] = "";
                if (iArr4 == null) {
                    this.A03 = new int[2];
                }
            } else {
                String[] strArr2 = A05;
                strArr2[5] = "gHL5QaZEq3qu3ZW6";
                strArr2[7] = "on2hgQBHubksAtN0";
                if (iArr4 == null) {
                    this.A03 = new int[2];
                }
            }
            iArr3 = this.A03;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        AbstractC10313j.A04(viewParentA00, this.A04, i11, i12, iArr3, i13);
        if (iArr2 != null) {
            this.A04.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i14;
            iArr2[1] = iArr2[1] - i15;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }
}
