package com.facebook.ads.redexgen.uinode;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$DecorView;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C10293h extends ViewGroup {
    public static byte[] A0s;
    public static String[] A0t = {"Pb5dMBpLoD8olSqqN3M1wt71s6WfJWWx", "mawes8eGWKEfT5kg0DwbKE", "yCX0UAcI", "nBGVAWTalDrx8Q3Q0HTp4hPpqgaJoZ5h", "", "", "gKpLqM1fc4CgqUT7jB7tIrf4xsKdVFyY", "wKHjR3FqXT8StRIGs0zAAfuJmbbhub4H"};
    public static final int[] A0u;
    public static final Interpolator A0v;
    public static final C10283g A0w;
    public static final Comparator<C3Z> A0x;
    public int A00;
    public C3E A01;
    public float A02;
    public float A03;
    public float A04;
    public float A05;
    public float A06;
    public float A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public int A0I;
    public int A0J;
    public int A0K;
    public int A0L;
    public int A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public Drawable A0S;
    public Parcelable A0T;
    public VelocityTracker A0U;
    public EdgeEffect A0V;
    public EdgeEffect A0W;
    public Scroller A0X;
    public InterfaceC10243c A0Y;
    public C10263e A0Z;
    public ClassLoader A0a;
    public ArrayList<View> A0b;
    public List<ViewPager.OnAdapterChangeListener> A0c;
    public List<InterfaceC10243c> A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public boolean A0n;
    public final Rect A0o;
    public final C3Z A0p;
    public final Runnable A0q;
    public final ArrayList<C3Z> A0r;

    /* JADX WARN: Type inference failed for: r0v13, types: [com.facebook.ads.redexgen.X.3g] */
    static {
        A0C();
        A0u = new int[]{R.attr.layout_gravity};
        A0x = new Comparator<C3Z>() { // from class: com.facebook.ads.redexgen.X.3V
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(C3Z c3z, C3Z c3z2) {
                return c3z.A02 - c3z2.A02;
            }
        };
        A0v = new Interpolator() { // from class: com.facebook.ads.redexgen.X.3W
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f11) {
                float f12 = f11 - 1.0f;
                return (f12 * f12 * f12 * f12 * f12) + 1.0f;
            }
        };
        A0w = new Comparator<View>() { // from class: com.facebook.ads.redexgen.X.3g
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(View view, View view2) {
                C10223a c10223a = (C10223a) view.getLayoutParams();
                C10223a c10223a2 = (C10223a) view2.getLayoutParams();
                if (c10223a.A05 != c10223a2.A05) {
                    return c10223a.A05 ? 1 : -1;
                }
                return c10223a.A02 - c10223a2.A02;
            }
        };
    }

    public C10293h(Context context) {
        super(context);
        this.A0r = new ArrayList<>();
        this.A0p = new C3Z();
        this.A0o = new Rect();
        this.A0O = -1;
        this.A0T = null;
        this.A0a = null;
        this.A02 = -3.4028235E38f;
        this.A07 = Float.MAX_VALUE;
        this.A0L = 1;
        this.A08 = -1;
        this.A0g = true;
        this.A0l = false;
        this.A0q = new Runnable() { // from class: com.facebook.ads.redexgen.X.3X
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.setScrollState(0);
                this.A00.A0f();
            }
        };
        this.A0P = 0;
        A0D();
    }

    private final float A00(float f11) {
        return (float) Math.sin((f11 - 0.5f) * 0.47123894f);
    }

    private int A01(int i11, float f11, int i12, int i13) {
        if (Math.abs(i13) <= this.A0H || Math.abs(i12) <= this.A0K) {
            i11 = ((int) (f11 + (i11 >= this.A00 ? 0.4f : 0.6f))) + i11;
        } else if (i12 <= 0) {
            i11++;
        }
        if (this.A0r.size() <= 0) {
            return i11;
        }
        C3Z c3z = this.A0r.get(0);
        ArrayList<C3Z> arrayList = this.A0r;
        return Math.max(c3z.A02, Math.min(i11, arrayList.get(arrayList.size() - 1).A02));
    }

    private Rect A02(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private C3Z A03() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f11 = clientWidth > 0 ? this.A0M / clientWidth : 0.0f;
        int i11 = -1;
        float f12 = 0.0f;
        float f13 = 0.0f;
        boolean z11 = true;
        C3Z c3z = null;
        int i12 = 0;
        while (i12 < this.A0r.size()) {
            C3Z c3z2 = this.A0r.get(i12);
            if (!z11 && c3z2.A02 != i11 + 1) {
                c3z2 = this.A0p;
                c3z2.A00 = f12 + f13 + f11;
                c3z2.A02 = i11 + 1;
                c3z2.A01 = this.A01.A00(c3z2.A02);
                i12--;
            }
            f12 = c3z2.A00;
            float f14 = c3z2.A01 + f12 + f11;
            if (!z11) {
                String[] strArr = A0t;
                if (strArr[4].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0t;
                strArr2[3] = "VrUwTTzuyHD2SkMMCenWDHvarMqbXCCI";
                strArr2[6] = "LX2NnyEsDXWEx3dFbPH8p7fzI1U1dTZ8";
                if (scrollX < f12) {
                    return c3z;
                }
            }
            if (scrollX >= f14) {
                int size = this.A0r.size() - 1;
                String[] strArr3 = A0t;
                if (strArr3[3].charAt(15) != strArr3[6].charAt(15)) {
                    A0t[2] = "sbP3P6ChvdnfvWI";
                    if (i12 != size) {
                        z11 = false;
                        i11 = c3z2.A02;
                        f13 = c3z2.A01;
                        c3z = c3z2;
                        i12++;
                    }
                } else {
                    A0t[1] = "kvGf4Zg53U8bz7GLeUNnCLzy4o";
                    if (i12 != size) {
                        z11 = false;
                        i11 = c3z2.A02;
                        f13 = c3z2.A01;
                        c3z = c3z2;
                        i12++;
                    }
                }
            }
            return c3z2;
        }
        return c3z;
    }

    private final C3Z A04(int i11) {
        for (int i12 = 0; i12 < this.A0r.size(); i12++) {
            C3Z c3z = this.A0r.get(i12);
            if (c3z.A02 == i11) {
                return c3z;
            }
        }
        return null;
    }

    private final C3Z A05(int i11, int i12) {
        C3Z c3z = new C3Z();
        c3z.A02 = i11;
        c3z.A03 = this.A01.A04(this, i11);
        c3z.A01 = this.A01.A00(i11);
        if (i12 < 0 || i12 >= this.A0r.size()) {
            this.A0r.add(c3z);
        } else {
            this.A0r.add(i12, c3z);
        }
        return c3z;
    }

    private final C3Z A06(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return A07(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    private final C3Z A07(View view) {
        for (int i11 = 0; i11 < this.A0r.size(); i11++) {
            C3Z c3z = this.A0r.get(i11);
            if (this.A01.A08(view, c3z.A03)) {
                return c3z;
            }
        }
        String[] strArr = A0t;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A0t[1] = "T6ty";
        return null;
    }

    public static String A08(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0s, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 104);
        }
        return new String(bArrCopyOfRange);
    }

    private void A09() {
        this.A0i = false;
        this.A0k = false;
        VelocityTracker velocityTracker = this.A0U;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            String[] strArr = A0t;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0t[1] = "yoRarqzFlsm2scdQtgnfRphmjo";
            this.A0U = null;
        }
    }

    private void A0A() {
        int i11 = 0;
        while (i11 < getChildCount()) {
            if (!((C10223a) getChildAt(i11).getLayoutParams()).A05) {
                removeViewAt(i11);
                i11--;
            }
            i11++;
        }
    }

    private void A0B() {
        if (this.A0F != 0) {
            ArrayList<View> arrayList = this.A0b;
            if (arrayList == null) {
                this.A0b = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                this.A0b.add(getChildAt(i11));
            }
            Collections.sort(this.A0b, A0w);
        }
    }

    public static void A0C() {
        A0s = new byte[]{-99, -70, -69, -99, -62, -14, 3, 9, 7, Ascii.DC4, -62, 5, Ascii.SO, 3, Ascii.NAK, Ascii.NAK, -36, -62, -48, 0, 17, Ascii.ETB, Ascii.NAK, 34, -48, Ascii.EM, Ascii.DC4, -22, -48, -34, Ascii.SO, 48, 45, 32, 42, 35, 43, Ascii.US, 50, 39, 33, -34, Ascii.US, 34, Ascii.US, 46, 50, 35, 48, -8, -34, -30, 54, 49, 49, -30, 53, 47, 35, 46, 46, -3, -30, 38, 39, 40, 35, 55, 46, 54, 43, 48, 41, -30, 54, 49, -30, -66, -78, -8, 1, 7, 0, -10, -52, -78, -69, -39, -26, -26, -25, -20, -104, -39, -36, -36, -104, -24, -39, -33, -35, -22, -104, -36, -35, -37, -25, -22, -104, -18, -31, -35, -17, -104, -36, -19, -22, -31, -26, -33, -104, -28, -39, -15, -25, -19, -20, -10, 9, Ascii.NAK, Ascii.EM, 9, Ascii.ETB, Ascii.CAN, 9, 8, -60, 19, 10, 10, Ascii.ETB, 7, Ascii.SYN, 9, 9, Ascii.DC2, -60, Ascii.DC4, 5, Ascii.VT, 9, -60, Ascii.DLE, Ascii.CR, 17, Ascii.CR, Ascii.CAN, -60, -10, 10, 7, -62, 3, Ascii.DC2, Ascii.DC2, Ascii.SO, Ascii.VT, 5, 3, Ascii.SYN, Ascii.VT, 17, Ascii.DLE, -55, Ascii.NAK, -62, -14, 3, 9, 7, Ascii.DC4, -29, 6, 3, Ascii.DC2, Ascii.SYN, 7, Ascii.DC4, -62, 5, 10, 3, Ascii.DLE, 9, 7, 6, -62, Ascii.SYN, 10, 7, -62, 3, 6, 3, Ascii.DC2, Ascii.SYN, 7, Ascii.DC4, -55, Ascii.NAK, -62, 5, 17, Ascii.DLE, Ascii.SYN, 7, Ascii.DLE, Ascii.SYN, Ascii.NAK, -62, Ascii.EM, Ascii.VT, Ascii.SYN, 10, 17, Ascii.ETB, Ascii.SYN, -62, 5, 3, Ascii.SO, Ascii.SO, Ascii.VT, Ascii.DLE, 9, -62, -14, 3, 9, 7, Ascii.DC4, -29, 6, 3, Ascii.DC2, Ascii.SYN, 7, Ascii.DC4, -59, Ascii.DLE, 17, Ascii.SYN, Ascii.VT, 8, Ascii.ESC, -26, 3, Ascii.SYN, 3, -11, 7, Ascii.SYN, -27, 10, 3, Ascii.DLE, 9, 7, 6, -61, -62, -25, Ascii.SUB, Ascii.DC2, 7, 5, Ascii.SYN, 7, 6, -62, 3, 6, 3, Ascii.DC2, Ascii.SYN, 7, Ascii.DC4, -62, Ascii.VT, Ascii.SYN, 7, Ascii.SI, -62, 5, 17, Ascii.ETB, Ascii.DLE, Ascii.SYN, -36, -62, -19, 0, -4, Ascii.SO, -25, -8, -2, -4, 9, Ascii.EM, 42, 42, 39, 47, Ascii.VT, Ascii.ESC, 42, 39, 36, 36, -40, 44, 42, 33, Ascii.GS, Ascii.FS, -40, 44, 39, -40, Ascii.RS, 33, 38, Ascii.FS, -40, Ascii.RS, 39, Ascii.ESC, 45, 43, -40, Ascii.SUB, Ascii.EM, 43, Ascii.GS, Ascii.FS, -40, 39, 38, -40, 38, 39, 38, -27, Ascii.ESC, 32, 33, 36, Ascii.FS, -40, Ascii.ESC, 45, 42, 42, Ascii.GS, 38, 44, -40, Ascii.RS, 39, Ascii.ESC, 45, 43, Ascii.GS, Ascii.FS, -40, 46, 33, Ascii.GS, 47, -40, 76, 75, Ascii.RS, 65, 62, 77, 81, 66, 79, 32, 69, 62, 75, 68, 66, 65, 19, Ascii.DC2, -12, 5, Ascii.VT, 9, -9, 7, Ascii.SYN, 19, Ascii.DLE, Ascii.DLE, 9, 8, -60, 8, Ascii.CR, 8, -60, Ascii.DC2, 19, Ascii.CAN, -60, 7, 5, Ascii.DLE, Ascii.DLE, -60, Ascii.ETB, Ascii.EM, Ascii.DC4, 9, Ascii.SYN, 7, Ascii.DLE, 5, Ascii.ETB, Ascii.ETB, -60, Ascii.CR, 17, Ascii.DC4, Ascii.DLE, 9, 17, 9, Ascii.DC2, Ascii.CAN, 5, Ascii.CAN, Ascii.CR, 19, Ascii.DC2, 85, 83, 66, 79, 84, 71, 80, 83, 78, 49, 66, 72, 70};
    }

    private final void A0D() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.A0X = new Scroller(context, A0v);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.A0R = viewConfiguration.getScaledPagingTouchSlop();
        this.A0K = (int) (400.0f * f11);
        this.A0J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.A0V = new EdgeEffect(context);
        this.A0W = new EdgeEffect(context);
        this.A0H = (int) (25.0f * f11);
        this.A0C = (int) (2.0f * f11);
        this.A0E = (int) (16.0f * f11);
        C3T.A0B(this, new C1831Zz(this));
        if (C3T.A00(this) == 0) {
            C3T.A09(this, 1);
        }
        C3T.A0C(this, new C1832a0(this));
    }

    private void A0E(int i11) {
        List<InterfaceC10243c> list = this.A0d;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                this.A0d.get(i12);
            }
        }
    }

    private void A0F(int i11) {
        List<InterfaceC10243c> list = this.A0d;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                this.A0d.get(i12);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x013b  */
    private final void A0G(int i11) {
        String hexString;
        C3Z c3z;
        float f11;
        C3Z c3zA04 = null;
        int i12 = this.A00;
        if (i12 != i11) {
            c3zA04 = A04(i12);
            this.A00 = i11;
        }
        if (this.A01 == null) {
            A0B();
            return;
        }
        if (this.A0m) {
            A0B();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i13 = this.A0L;
        int iMax = Math.max(0, this.A00 - i13);
        int iA01 = this.A01.A01();
        int iMin = Math.min(iA01 - 1, this.A00 + i13);
        if (iA01 != this.A0G) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
                if (A0t[2].length() != 14) {
                    A0t[2] = "3cJ8G";
                }
                throw new RuntimeException();
            }
            throw new IllegalStateException(A08(158, 142, 58) + this.A0G + A08(77, 9, 42) + iA01 + A08(18, 11, 72) + hexString + A08(4, 14, 58) + getClass() + A08(29, 22, 86) + this.A01.getClass());
        }
        C3Z c3zA05 = null;
        if (A0t[2].length() != 14) {
            A0t[1] = "Tot0RAE";
            int i14 = 0;
            while (i14 < this.A0r.size()) {
                C3Z c3z2 = this.A0r.get(i14);
                if (c3z2.A02 >= this.A00) {
                    if (c3z2.A02 != this.A00) {
                        break;
                    }
                    c3zA05 = c3z2;
                    break;
                }
                i14++;
            }
            if (c3zA05 == null && iA01 > 0) {
                int i15 = this.A00;
                if (A0t[1].length() != 12) {
                    A0t[2] = "0";
                    c3zA05 = A05(i15, i14);
                } else {
                    String[] strArr = A0t;
                    strArr[4] = "";
                    strArr[5] = "";
                    c3zA05 = A05(i15, i14);
                }
            }
            if (c3zA05 != null) {
                float f12 = 0.0f;
                int i16 = i14 - 1;
                if (i16 >= 0) {
                    C3Z c3z3 = this.A0r.get(i16);
                    String[] strArr2 = A0t;
                    if (strArr2[3].charAt(15) != strArr2[6].charAt(15)) {
                        A0t[1] = "VNMCyWdkMCax4jTa2KYBa9F64T8dlp";
                        c3z = c3z3;
                    }
                } else {
                    c3z = null;
                }
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - c3zA05.A01) + (getPaddingLeft() / clientWidth);
                for (int i17 = this.A00 - 1; i17 >= 0; i17--) {
                    if (f12 >= paddingLeft && i17 < iMax) {
                        if (c3z == null) {
                            break;
                        }
                        if (i17 == c3z.A02 && !c3z.A04) {
                            this.A0r.remove(i16);
                            this.A01.A07(this, i17, c3z.A03);
                            i16--;
                            i14--;
                            c3z = i16 >= 0 ? this.A0r.get(i16) : null;
                        }
                    } else if (c3z == null || i17 != c3z.A02) {
                        f12 += A05(i17, i16 + 1).A01;
                        i14++;
                        c3z = i16 >= 0 ? this.A0r.get(i16) : null;
                    } else {
                        f12 += c3z.A01;
                        String[] strArr3 = A0t;
                        if (strArr3[7].charAt(10) == strArr3[0].charAt(10)) {
                            String[] strArr4 = A0t;
                            strArr4[4] = "";
                            strArr4[5] = "";
                            i16--;
                            c3z = i16 >= 0 ? this.A0r.get(i16) : null;
                        }
                    }
                }
                float f13 = c3zA05.A01;
                int i18 = i14 + 1;
                if (f13 < 2.0f) {
                    C3Z c3z4 = i18 < this.A0r.size() ? this.A0r.get(i18) : null;
                    if (clientWidth <= 0) {
                        f11 = 0.0f;
                    } else {
                        float paddingRight = getPaddingRight();
                        float f14 = clientWidth;
                        String[] strArr5 = A0t;
                        if (strArr5[4].length() != strArr5[5].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr6 = A0t;
                        strArr6[4] = "";
                        strArr6[5] = "";
                        f11 = (paddingRight / f14) + 2.0f;
                    }
                    for (int i19 = this.A00 + 1; i19 < iA01; i19++) {
                        if (f13 >= f11 && i19 > iMin) {
                            if (c3z4 == null) {
                                break;
                            }
                            if (i19 == c3z4.A02 && !c3z4.A04) {
                                this.A0r.remove(i18);
                                this.A01.A07(this, i19, c3z4.A03);
                                c3z4 = i18 < this.A0r.size() ? this.A0r.get(i18) : null;
                            }
                        } else if (c3z4 == null || i19 != c3z4.A02) {
                            C3Z c3zA06 = A05(i19, i18);
                            i18++;
                            f13 += c3zA06.A01;
                            c3z4 = i18 < this.A0r.size() ? this.A0r.get(i18) : null;
                        } else {
                            f13 += c3z4.A01;
                            i18++;
                            c3z4 = i18 < this.A0r.size() ? this.A0r.get(i18) : null;
                        }
                    }
                }
                A0Q(c3zA05, i14, c3zA04);
            }
            int childCount = getChildCount();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt = getChildAt(i21);
                C10223a c10223a = (C10223a) childAt.getLayoutParams();
                c10223a.A01 = i21;
                if (!c10223a.A05 && c10223a.A00 == 0.0f) {
                    C3Z c3zA07 = A07(childAt);
                    String[] strArr7 = A0t;
                    if (strArr7[7].charAt(10) == strArr7[0].charAt(10)) {
                        A0t[1] = "EEa7ILjnbFiKaMBJBW0FEjvS9loAIL";
                        if (c3zA07 != null) {
                            c10223a.A00 = c3zA07.A01;
                            c10223a.A02 = c3zA07.A02;
                        }
                    } else if (c3zA07 != null) {
                        c10223a.A00 = c3zA07.A01;
                        c10223a.A02 = c3zA07.A02;
                    }
                }
            }
            A0B();
            String[] strArr8 = A0t;
            if (strArr8[4].length() != strArr8[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr9 = A0t;
            strArr9[7] = "fAvJTe45YQ8jwRLJzle6w88GhXZAW5fe";
            strArr9[0] = "XHTmtVqtTM8ykl9XiQ4ZuPNQzfhQsr72";
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                String[] strArr10 = A0t;
                if (strArr10[3].charAt(15) == strArr10[6].charAt(15)) {
                    throw new RuntimeException();
                }
                String[] strArr11 = A0t;
                strArr11[3] = "98nQxxcA6vj5924MyChW7mkeiNJnWKv2";
                strArr11[6] = "ju5RZqhAYuaQhiOPGNIJcLOaoEeV3OP8";
                C3Z c3zA08 = viewFindFocus != null ? A06(viewFindFocus) : null;
                if (c3zA08 == null || c3zA08.A02 != this.A00) {
                    for (int i22 = 0; i22 < getChildCount(); i22++) {
                        View childAt2 = getChildAt(i22);
                        C3Z c3zA09 = A07(childAt2);
                        if (c3zA09 != null && c3zA09.A02 == this.A00 && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0H(int i11, float f11, int i12) {
        List<InterfaceC10243c> list = this.A0d;
        if (list != null) {
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                this.A0d.get(i13);
            }
        }
    }

    private final void A0I(int i11, float f11, int i12) {
        int iMax;
        if (this.A0D > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            if (A0t[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[3] = "hSwONVQ9BwzgmNPK4tziO3X6uj4eQvsQ";
            strArr[6] = "gKhZoL4mhYlFRC9fFMXnjqdiW6EOuKfZ";
            int width = getWidth();
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                C10223a c10223a = (C10223a) childAt.getLayoutParams();
                if (c10223a.A05) {
                    switch (c10223a.A04 & 7) {
                        case 1:
                            iMax = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            iMax = paddingLeft;
                            break;
                        case 3:
                            iMax = paddingLeft;
                            paddingLeft += childAt.getWidth();
                            break;
                        case 5:
                            iMax = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            break;
                    }
                    int left = (iMax + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                }
            }
        }
        A0H(i11, f11, i12);
        if (0 != 0) {
            getScrollX();
            int childCount2 = getChildCount();
            for (int i14 = 0; i14 < childCount2; i14++) {
                View childAt2 = getChildAt(i14);
                if (!((C10223a) childAt2.getLayoutParams()).A05) {
                    childAt2.getLeft();
                    getClientWidth();
                    throw new NullPointerException(A08(450, 13, 121));
                }
            }
        }
        this.A0e = true;
    }

    private final void A0J(int i11, int i12, int i13) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.A0X;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.A0j ? this.A0X.getCurrX() : this.A0X.getStartX();
            this.A0X.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i14 = i11 - scrollX;
        int i15 = i12 - scrollY;
        if (i14 == 0 && i15 == 0) {
            A0R(false);
            A0f();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i16 = clientWidth / 2;
        float fA00 = i16 + (i16 * A00(Math.min(1.0f, (Math.abs(i14) * 1.0f) / clientWidth)));
        int iAbs2 = Math.abs(i13);
        if (iAbs2 > 0) {
            float f11 = fA00 / iAbs2;
            if (A0t[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[4] = "";
            strArr[5] = "";
            iAbs = Math.round(Math.abs(f11) * 1000.0f) * 4;
        } else {
            iAbs = (int) ((1.0f + (Math.abs(i14) / (this.A0M + (clientWidth * this.A01.A00(this.A00))))) * 100.0f);
        }
        int iMin = Math.min(iAbs, LogSeverity.CRITICAL_VALUE);
        this.A0j = false;
        this.A0X.startScroll(scrollX, scrollY, i14, i15, iMin);
        C3T.A07(this);
    }

    private void A0K(int i11, int i12, int i13, int i14) {
        if (i12 > 0) {
            ArrayList<C3Z> arrayList = this.A0r;
            String[] strArr = A0t;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0t[1] = "xS6wP2kv8Ukjp2mlI4OFB7EI";
            if (!arrayList.isEmpty()) {
                boolean zIsFinished = this.A0X.isFinished();
                if (A0t[1].length() == 12) {
                    throw new RuntimeException();
                }
                A0t[2] = "M3IvNYMGgF0qb538wmgDMK0nNkgqAt";
                if (!zIsFinished) {
                    this.A0X.setFinalX(getCurrentItem() * getClientWidth());
                    return;
                } else {
                    scrollTo((int) ((((i11 - getPaddingLeft()) - getPaddingRight()) + i13) * (getScrollX() / (((i12 - getPaddingLeft()) - getPaddingRight()) + i14))), getScrollY());
                    return;
                }
            }
        }
        C3Z c3zA04 = A04(this.A00);
        int paddingLeft = (int) (((i11 - getPaddingLeft()) - getPaddingRight()) * (c3zA04 != null ? Math.min(c3zA04.A00, this.A07) : 0.0f));
        if (paddingLeft != getScrollX()) {
            A0R(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private final void A0L(int i11, boolean z11) {
        this.A0m = false;
        A0N(i11, z11, false);
    }

    private void A0M(int i11, boolean z11, int i12, boolean z12) {
        C3Z c3zA04 = A04(i11);
        int clientWidth = c3zA04 != null ? (int) (getClientWidth() * Math.max(this.A02, Math.min(c3zA04.A00, this.A07))) : 0;
        if (A0t[2].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A0t;
        strArr[3] = "qWyJthdIKprwmupmlWytZXkwKuTz6nwm";
        strArr[6] = "fDmSwMvEmt93O90vXMKXMmFP8biUMO95";
        if (z11) {
            A0J(clientWidth, 0, i12);
            if (z12) {
                A0E(i11);
                return;
            }
            return;
        }
        if (z12) {
            A0E(i11);
        }
        A0R(false);
        scrollTo(clientWidth, 0);
        A0Z(clientWidth);
    }

    private final void A0N(int i11, boolean z11, boolean z12) {
        A0O(i11, z11, z12, 0);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    /* JADX WARN: Code duplicated, block: B:32:0x0070 A[LOOP:0: B:30:0x0068->B:32:0x0070, LOOP_END] */
    private final void A0O(int i11, boolean z11, boolean z12, int i12) {
        int i13;
        C3E c3e = this.A01;
        if (c3e == null || c3e.A01() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z12 && this.A00 == i11 && this.A0r.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 >= this.A01.A01()) {
            i11 = this.A01.A01() - 1;
        }
        int i14 = this.A0L;
        int i15 = this.A00;
        if (i11 <= i15 + i14) {
            int i16 = i15 - i14;
            String[] strArr = A0t;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0t;
            strArr2[3] = "HdD8kb8A1NTv0LjA3C8pNf8B8Uhf5Rjf";
            strArr2[6] = "hEPxY7plOgAB5ujpSYVhyDABeqG0KedF";
            if (i11 < i16) {
                for (i13 = 0; i13 < this.A0r.size(); i13++) {
                    this.A0r.get(i13).A04 = true;
                }
            }
        } else {
            while (i13 < this.A0r.size()) {
                this.A0r.get(i13).A04 = true;
            }
        }
        boolean z13 = this.A00 != i11;
        if (!this.A0g) {
            A0G(i11);
            A0M(i11, z11, i12, z13);
        } else {
            this.A00 = i11;
            if (z13) {
                A0E(i11);
            }
            requestLayout();
        }
    }

    private void A0P(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A08) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.A05 = motionEvent.getX(i11);
            String[] strArr = A0t;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0t;
            strArr2[4] = "";
            strArr2[5] = "";
            this.A08 = motionEvent.getPointerId(i11);
            VelocityTracker velocityTracker = this.A0U;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x018b  */
    private void A0Q(C3Z c3z, int i11, C3Z c3z2) {
        C3Z c3z3;
        C3Z c3z4;
        int iA01 = this.A01.A01();
        int clientWidth = getClientWidth();
        float f11 = clientWidth > 0 ? this.A0M / clientWidth : 0.0f;
        if (c3z2 != null) {
            int i12 = c3z2.A02;
            if (i12 < c3z.A02) {
                int i13 = 0;
                float fA00 = c3z2.A00 + c3z2.A01 + f11;
                int i14 = i12 + 1;
                while (i14 <= c3z.A02 && i13 < this.A0r.size()) {
                    C3Z c3z5 = this.A0r.get(i13);
                    while (true) {
                        c3z4 = c3z5;
                        if (i14 <= c3z4.A02 || i13 >= this.A0r.size() - 1) {
                            break;
                        }
                        i13++;
                        c3z5 = this.A0r.get(i13);
                    }
                    while (i14 < c3z4.A02) {
                        C3E c3e = this.A01;
                        if (A0t[2].length() == 14) {
                            throw new RuntimeException();
                        }
                        A0t[2] = "unjnr1JPHveRA3A";
                        fA00 += c3e.A00(i14) + f11;
                        i14++;
                    }
                    c3z4.A00 = fA00;
                    fA00 += c3z4.A01 + f11;
                    i14++;
                }
            } else if (i12 > c3z.A02) {
                int size = this.A0r.size() - 1;
                float fA01 = c3z2.A00;
                int i15 = i12 - 1;
                while (i15 >= c3z.A02 && size >= 0) {
                    C3Z c3z6 = this.A0r.get(size);
                    while (true) {
                        c3z3 = c3z6;
                        if (i15 >= c3z3.A02 || size <= 0) {
                            break;
                        }
                        size--;
                        c3z6 = this.A0r.get(size);
                    }
                    while (true) {
                        int i16 = c3z3.A02;
                        String[] strArr = A0t;
                        if (strArr[4].length() == strArr[5].length()) {
                            A0t[2] = "eK1wjFwqyv9CJUk";
                            if (i15 <= i16) {
                                break;
                            }
                            fA01 -= this.A01.A00(i15) + f11;
                            i15--;
                        } else {
                            A0t[1] = "tUoZSKhLB59JJ";
                            if (i15 <= i16) {
                                break;
                            }
                            fA01 -= this.A01.A00(i15) + f11;
                            i15--;
                        }
                    }
                    fA01 -= c3z3.A01 + f11;
                    c3z3.A00 = fA01;
                    i15--;
                }
            }
        }
        int size2 = this.A0r.size();
        float fA02 = c3z.A00;
        int i17 = c3z.A02 - 1;
        this.A02 = c3z.A02 == 0 ? c3z.A00 : -3.4028235E38f;
        this.A07 = c3z.A02 == iA01 + (-1) ? (c3z.A00 + c3z.A01) - 1.0f : Float.MAX_VALUE;
        int i18 = i11 - 1;
        while (i18 >= 0) {
            C3Z c3z7 = this.A0r.get(i18);
            while (i17 > c3z7.A02) {
                fA02 -= this.A01.A00(i17) + f11;
                i17--;
            }
            fA02 -= c3z7.A01 + f11;
            c3z7.A00 = fA02;
            if (c3z7.A02 == 0) {
                this.A02 = fA02;
            }
            i18--;
            i17--;
        }
        float fA03 = c3z.A00 + c3z.A01 + f11;
        int i19 = c3z.A02 + 1;
        int i21 = i11 + 1;
        while (i21 < size2) {
            C3Z c3z8 = this.A0r.get(i21);
            while (i19 < c3z8.A02) {
                fA03 += this.A01.A00(i19) + f11;
                i19++;
            }
            int i22 = c3z8.A02;
            if (A0t[2].length() != 14) {
                String[] strArr2 = A0t;
                strArr2[3] = "LKMrFShf3NXE5XfaxsCGHUW3hns0S8Wh";
                strArr2[6] = "xptjAJKkekqR5TDnJjimQZvUd22mQJJ9";
                if (i22 == iA01 - 1) {
                    this.A07 = (c3z8.A01 + fA03) - 1.0f;
                }
            } else if (i22 == iA01 - 1) {
                this.A07 = (c3z8.A01 + fA03) - 1.0f;
            }
            c3z8.A00 = fA03;
            fA03 += c3z8.A01 + f11;
            i21++;
            i19++;
        }
        this.A0l = false;
    }

    private void A0R(boolean z11) {
        boolean z12 = this.A0P == 2;
        if (z12) {
            setScrollingCacheEnabled(false);
            if (!this.A0X.isFinished()) {
                this.A0X.abortAnimation();
                if (A0t[1].length() == 12) {
                    throw new RuntimeException();
                }
                A0t[1] = "La7";
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.A0X.getCurrX();
                int currY = this.A0X.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        A0Z(currX);
                    }
                }
            }
        }
        this.A0m = false;
        for (int i11 = 0; i11 < this.A0r.size(); i11++) {
            C3Z c3z = this.A0r.get(i11);
            if (c3z.A04) {
                z12 = true;
                c3z.A04 = false;
            }
        }
        if (z12) {
            if (z11) {
                C3T.A0D(this, this.A0q);
            } else {
                this.A0q.run();
            }
        }
    }

    private void A0S(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            getChildAt(i11).setLayerType(z11 ? this.A0N : 0, null);
        }
    }

    private void A0T(boolean z11) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    private boolean A0U() {
        this.A08 = -1;
        A09();
        this.A0V.onRelease();
        this.A0W.onRelease();
        return this.A0V.isFinished() || this.A0W.isFinished();
    }

    private final boolean A0V() {
        int i11 = this.A00;
        if (i11 <= 0) {
            return false;
        }
        A0L(i11 - 1, true);
        return true;
    }

    private final boolean A0W() {
        C3E c3e = this.A01;
        if (c3e != null && this.A00 < c3e.A01() - 1) {
            A0L(this.A00 + 1, true);
            return true;
        }
        if (A0t[2].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A0t;
        strArr[7] = "AXA5EDUbYu85ntxkUdYhY3hIIlQIUQar";
        strArr[0] = "7HhQN1X94o8BEMOAnE9vO9t08zapWTmy";
        return false;
    }

    private boolean A0X(float f11) {
        boolean z11 = false;
        float f12 = this.A05 - f11;
        this.A05 = f11;
        float scrollX = getScrollX() + f12;
        int clientWidth = getClientWidth();
        float f13 = clientWidth * this.A02;
        float f14 = clientWidth * this.A07;
        boolean z12 = true;
        boolean z13 = true;
        C3Z c3z = this.A0r.get(0);
        ArrayList<C3Z> arrayList = this.A0r;
        C3Z c3z2 = arrayList.get(arrayList.size() - 1);
        if (c3z.A02 != 0) {
            z12 = false;
            float f15 = c3z.A00;
            if (A0t[1].length() == 12) {
                throw new RuntimeException();
            }
            A0t[1] = "a";
            f13 = f15 * clientWidth;
        }
        if (c3z2.A02 != this.A01.A01() - 1) {
            z13 = false;
            f14 = c3z2.A00 * clientWidth;
        }
        if (scrollX < f13) {
            if (z12) {
                this.A0V.onPull(Math.abs(f13 - scrollX) / clientWidth);
                z11 = true;
            }
            scrollX = f13;
        } else if (scrollX > f14) {
            if (z13) {
                EdgeEffect edgeEffect = this.A0W;
                float fAbs = Math.abs(scrollX - f14);
                float f16 = clientWidth;
                String[] strArr = A0t;
                if (strArr[4].length() != strArr[5].length()) {
                    edgeEffect.onPull(fAbs / f16);
                    z11 = true;
                } else {
                    A0t[1] = "TwKB2lBmR";
                    edgeEffect.onPull(fAbs / f16);
                    z11 = true;
                }
            }
            scrollX = f14;
        }
        this.A05 += scrollX - ((int) scrollX);
        scrollTo((int) scrollX, getScrollY());
        A0Z((int) scrollX);
        return z11;
    }

    private final boolean A0Y(float f11, float f12) {
        if (f11 >= this.A0I || f12 <= 0.0f) {
            if (f11 > getWidth() - this.A0I) {
                if (A0t[2].length() == 14) {
                    throw new RuntimeException();
                }
                String[] strArr = A0t;
                strArr[3] = "LoLbwLodEQ0RZhoADzk4YxqyeMxGbPNe";
                strArr[6] = "uXFtlpuRRgamX4n9Zkql1HjWorEkSQ7b";
                if (f12 < 0.0f) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean A0Z(int i11) {
        int size = this.A0r.size();
        String strA08 = A08(397, 53, 60);
        if (size != 0) {
            C3Z c3zA03 = A03();
            int clientWidth = getClientWidth();
            int i12 = this.A0M;
            int i13 = c3zA03.A02;
            float f11 = ((i11 / clientWidth) - c3zA03.A00) / (c3zA03.A01 + (i12 / clientWidth));
            this.A0e = false;
            A0I(i13, f11, (int) ((clientWidth + i12) * f11));
            if (this.A0e) {
                return true;
            }
            throw new IllegalStateException(strA08);
        }
        if (this.A0g) {
            return false;
        }
        this.A0e = false;
        A0I(0, 0.0f, 0);
        String[] strArr = A0t;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A0t[2] = "c3ramapljB1reDSufYjA";
        if (this.A0e) {
            return false;
        }
        throw new IllegalStateException(strA08);
    }

    private final boolean A0a(int i11) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            boolean z11 = false;
            for (ViewParent parent = viewFindFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (parent == this) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb2.append(A08(0, 4, 21)).append(parent2.getClass().getSimpleName());
                }
                Log.e(A08(LogSeverity.NOTICE_VALUE, 9, 47), A08(309, 72, 80) + sb2.toString());
                viewFindFocus = null;
            }
        }
        boolean zA0V = false;
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i11);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i11 == 17 || i11 == 1) {
                zA0V = A0V();
            } else if (i11 == 66 || i11 == 2) {
                zA0V = A0W();
            }
        } else if (i11 == 17) {
            zA0V = (viewFindFocus == null || A02(this.A0o, viewFindNextFocus).left < A02(this.A0o, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : A0V();
        } else if (i11 == 66) {
            zA0V = (viewFindFocus == null || A02(this.A0o, viewFindNextFocus).left > A02(this.A0o, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : A0W();
        }
        if (zA0V) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i11));
        }
        return zA0V;
    }

    private final boolean A0b(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return keyEvent.hasModifiers(2) ? A0V() : A0a(17);
            case 22:
                boolean zHasModifiers = keyEvent.hasModifiers(2);
                String[] strArr = A0t;
                if (strArr[4].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                A0t[1] = "lC1XoLB2bpdljamdt6Vm";
                return zHasModifiers ? A0W() : A0a(66);
            case 61:
                if (keyEvent.hasNoModifiers()) {
                    return A0a(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return A0a(1);
                }
                return false;
            default:
                return false;
        }
    }

    public static boolean A0c(View view) {
        return view.getClass().getAnnotation(ViewPager$DecorView.class) != null;
    }

    private final boolean A0d(View view, boolean z11, int i11, int i12, int i13) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i12 + scrollX >= childAt.getLeft() && i12 + scrollX < childAt.getRight() && i13 + scrollY >= childAt.getTop() && i13 + scrollY < childAt.getBottom()) {
                    int left = (i12 + scrollX) - childAt.getLeft();
                    int i14 = i13 + scrollY;
                    if (A0t[1].length() == 12) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0t;
                    strArr[4] = "";
                    strArr[5] = "";
                    if (A0d(childAt, true, i11, left, i14 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z11 && view.canScrollHorizontally(-i11);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z11) {
        if (this.A0n != z11) {
            this.A0n = z11;
        }
    }

    public final void A0e() {
        int iA01 = this.A01.A01();
        this.A0G = iA01;
        boolean z11 = this.A0r.size() < (this.A0L * 2) + 1 && this.A0r.size() < iA01;
        int iMax = this.A00;
        boolean z12 = false;
        int i11 = 0;
        while (i11 < this.A0r.size()) {
            C3Z c3z = this.A0r.get(i11);
            int iA02 = this.A01.A02(c3z.A03);
            if (iA02 != -1) {
                if (iA02 == -2) {
                    this.A0r.remove(i11);
                    i11--;
                    if (!z12) {
                        z12 = true;
                    }
                    this.A01.A07(this, c3z.A02, c3z.A03);
                    z11 = true;
                    if (this.A00 == c3z.A02) {
                        iMax = Math.max(0, Math.min(this.A00, iA01 - 1));
                        z11 = true;
                    }
                } else if (c3z.A02 != iA02) {
                    if (c3z.A02 == this.A00) {
                        iMax = iA02;
                    }
                    c3z.A02 = iA02;
                    z11 = true;
                }
            }
            i11++;
        }
        Collections.sort(this.A0r, A0x);
        if (z11) {
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                C10223a c10223a = (C10223a) getChildAt(i12).getLayoutParams();
                if (!c10223a.A05) {
                    c10223a.A00 = 0.0f;
                }
            }
            A0N(iMax, false, true);
            if (A0t[2].length() == 14) {
                throw new RuntimeException();
            }
            A0t[2] = "iBz2AIJ6C";
            requestLayout();
        }
    }

    public final void A0f() {
        A0G(this.A00);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        C3Z c3zA07;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 0 && (c3zA07 = A07(childAt)) != null && c3zA07.A02 == this.A00) {
                    childAt.addFocusables(arrayList, i11, i12);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i12 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> arrayList) {
        C3Z c3zA07;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (c3zA07 = A07(childAt)) != null && c3zA07.A02 == this.A00) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C10223a c10223a = (C10223a) layoutParams;
        c10223a.A05 |= A0c(view);
        if (!this.A0h) {
            super.addView(view, i11, layoutParams);
            return;
        }
        if (c10223a != null && c10223a.A05) {
            throw new IllegalStateException(A08(86, 41, 16));
        }
        c10223a.A03 = true;
        if (A0t[2].length() == 14) {
            throw new RuntimeException();
        }
        A0t[1] = "XL6oa3uLuKs2IOpHyjfCXdHiJnTalh";
        addViewInLayout(view, i11, layoutParams);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i11) {
        if (this.A01 == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i11 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.A02));
        }
        return i11 > 0 && scrollX < ((int) (((float) clientWidth) * this.A07));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C10223a) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.A0j = true;
        if (this.A0X.isFinished() || !this.A0X.computeScrollOffset()) {
            A0R(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.A0X.getCurrX();
        int currY = this.A0X.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!A0Z(currX)) {
                this.A0X.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C3T.A07(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || A0b(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C3Z c3zA07;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (c3zA07 = A07(childAt)) != null) {
                int i12 = c3zA07.A02;
                String[] strArr = A0t;
                if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0t;
                strArr2[4] = "";
                strArr2[5] = "";
                if (i12 == this.A00 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x004b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    /* JADX WARN: Code duplicated, block: B:21:0x0094  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d5  */
    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean zIsFinished;
        super.draw(canvas);
        boolean zDraw = false;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0) {
            zIsFinished = this.A0V.isFinished();
            if (A0t[1].length() != 12) {
                A0t[1] = "sR19g1oBfMrUqPxbyG4ArbsnA";
                if (!zIsFinished) {
                    int iSave = canvas.save();
                    int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                    int width = getWidth();
                    canvas.rotate(270.0f);
                    canvas.translate((-height) + getPaddingTop(), this.A02 * width);
                    this.A0V.setSize(height, width);
                    zDraw = false | this.A0V.draw(canvas);
                    canvas.restoreToCount(iSave);
                }
            } else {
                String[] strArr = A0t;
                strArr[4] = "";
                strArr[5] = "";
                if (!zIsFinished) {
                    int iSave2 = canvas.save();
                    int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                    int width2 = getWidth();
                    canvas.rotate(270.0f);
                    canvas.translate((-height2) + getPaddingTop(), this.A02 * width2);
                    this.A0V.setSize(height2, width2);
                    zDraw = false | this.A0V.draw(canvas);
                    canvas.restoreToCount(iSave2);
                }
            }
            if (!this.A0W.isFinished()) {
                int iSave3 = canvas.save();
                int width3 = getWidth();
                int height3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.A07 + 1.0f)) * width3);
                this.A0W.setSize(height3, width3);
                zDraw |= this.A0W.draw(canvas);
                canvas.restoreToCount(iSave3);
            }
        } else {
            if (overScrollMode == 1) {
                C3E c3e = this.A01;
                String[] strArr2 = A0t;
                if (strArr2[7].charAt(10) != strArr2[0].charAt(10)) {
                    throw new RuntimeException();
                }
                A0t[1] = "uCo1AgFx4bPu4bwpitwpleYcuNfeFds";
                if (c3e != null && c3e.A01() > 1) {
                    zIsFinished = this.A0V.isFinished();
                    if (A0t[1].length() != 12) {
                        A0t[1] = "sR19g1oBfMrUqPxbyG4ArbsnA";
                        if (!zIsFinished) {
                            int iSave4 = canvas.save();
                            int height4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                            int width4 = getWidth();
                            canvas.rotate(270.0f);
                            canvas.translate((-height4) + getPaddingTop(), this.A02 * width4);
                            this.A0V.setSize(height4, width4);
                            zDraw = false | this.A0V.draw(canvas);
                            canvas.restoreToCount(iSave4);
                        }
                    } else {
                        String[] strArr3 = A0t;
                        strArr3[4] = "";
                        strArr3[5] = "";
                        if (!zIsFinished) {
                            int iSave5 = canvas.save();
                            int height5 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                            int width5 = getWidth();
                            canvas.rotate(270.0f);
                            canvas.translate((-height5) + getPaddingTop(), this.A02 * width5);
                            this.A0V.setSize(height5, width5);
                            zDraw = false | this.A0V.draw(canvas);
                            canvas.restoreToCount(iSave5);
                        }
                    }
                    if (!this.A0W.isFinished()) {
                        int iSave6 = canvas.save();
                        int width6 = getWidth();
                        int height6 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                        canvas.rotate(90.0f);
                        canvas.translate(-getPaddingTop(), (-(this.A07 + 1.0f)) * width6);
                        this.A0W.setSize(height6, width6);
                        zDraw |= this.A0W.draw(canvas);
                        canvas.restoreToCount(iSave6);
                    }
                }
            }
            this.A0V.finish();
            this.A0W.finish();
        }
        if (zDraw) {
            C3T.A07(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A0S;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C10223a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C10223a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public C3E getAdapter() {
        return this.A01;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i11, int i12) {
        return ((C10223a) this.A0b.get(this.A0F == 2 ? (i11 - 1) - i12 : i12).getLayoutParams()).A01;
    }

    public int getCurrentItem() {
        return this.A00;
    }

    public int getOffscreenPageLimit() {
        return this.A0L;
    }

    public int getPageMargin() {
        return this.A0M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.A0q);
        Scroller scroller = this.A0X;
        if (scroller != null && !scroller.isFinished()) {
            this.A0X.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f11;
        super.onDraw(canvas);
        if (this.A0M <= 0 || this.A0S == null || this.A0r.size() <= 0 || this.A01 == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f12 = this.A0M / width;
        int i11 = 0;
        C3Z c3z = this.A0r.get(0);
        float f13 = c3z.A00;
        int size = this.A0r.size();
        int i12 = this.A0r.get(size - 1).A02;
        for (int i13 = c3z.A02; i13 < i12; i13++) {
            while (i13 > c3z.A02 && i11 < size) {
                i11++;
                C3Z c3z2 = this.A0r.get(i11);
                String[] strArr = A0t;
                if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                    throw new RuntimeException();
                }
                A0t[2] = "Qpfq";
                c3z = c3z2;
            }
            if (i13 == c3z.A02) {
                f11 = (c3z.A00 + c3z.A01) * width;
                f13 = c3z.A00 + c3z.A01 + f12;
            } else {
                float fA00 = this.A01.A00(i13);
                f11 = (f13 + fA00) * width;
                f13 += fA00 + f12;
            }
            if (this.A0M + f11 > scrollX) {
                this.A0S.setBounds(Math.round(f11), this.A0Q, Math.round(this.A0M + f11), this.A09);
                Drawable drawable = this.A0S;
                String[] strArr2 = A0t;
                if (strArr2[7].charAt(10) != strArr2[0].charAt(10)) {
                    A0t[1] = "";
                    drawable.draw(canvas);
                } else {
                    String[] strArr3 = A0t;
                    strArr3[4] = "";
                    strArr3[5] = "";
                    drawable.draw(canvas);
                }
            }
            int i14 = scrollX + width;
            if (A0t[1].length() == 12) {
                throw new RuntimeException();
            }
            A0t[1] = "DrXdt";
            if (f11 > i14) {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f11;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            A0U();
            String[] strArr = A0t;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0t[2] = "iW5W";
            return false;
        }
        if (action != 0) {
            if (this.A0i) {
                return true;
            }
            if (this.A0k) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x11 = motionEvent.getX();
                this.A03 = x11;
                this.A05 = x11;
                float y11 = motionEvent.getY();
                this.A04 = y11;
                this.A06 = y11;
                this.A08 = motionEvent.getPointerId(0);
                this.A0k = false;
                this.A0j = true;
                this.A0X.computeScrollOffset();
                if (this.A0P == 2 && Math.abs(this.A0X.getFinalX() - this.A0X.getCurrX()) > this.A0C) {
                    this.A0X.abortAnimation();
                    this.A0m = false;
                    A0f();
                    this.A0i = true;
                    A0T(true);
                    setScrollState(1);
                } else {
                    A0R(false);
                    this.A0i = false;
                }
                break;
            case 2:
                int i11 = this.A08;
                if (i11 != -1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i11);
                    float x12 = motionEvent.getX(iFindPointerIndex);
                    float f12 = x12 - this.A05;
                    float fAbs = Math.abs(f12);
                    float y12 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y12 - this.A04);
                    if (f12 != 0.0f && !A0Y(this.A05, f12) && A0d(this, false, (int) f12, (int) x12, (int) y12)) {
                        this.A05 = x12;
                        this.A06 = y12;
                        this.A0k = true;
                        return false;
                    }
                    int i12 = this.A0R;
                    if (fAbs > i12 && 0.5f * fAbs > fAbs2) {
                        this.A0i = true;
                        A0T(true);
                        setScrollState(1);
                        if (f12 > 0.0f) {
                            float f13 = this.A03;
                            int i13 = this.A0R;
                            String[] strArr2 = A0t;
                            if (strArr2[7].charAt(10) != strArr2[0].charAt(10)) {
                                f11 = f13 + i13;
                            } else {
                                String[] strArr3 = A0t;
                                strArr3[7] = "WpQimEPBWZ8vG05HKhTxshBMY3NNEur0";
                                strArr3[0] = "BEtp4ufX6D8x3OZlDxdpMoFh1oKQqP0t";
                                f11 = f13 + i13;
                            }
                        } else {
                            f11 = this.A03 - this.A0R;
                        }
                        this.A05 = f11;
                        this.A06 = y12;
                        setScrollingCacheEnabled(true);
                    } else if (fAbs2 > i12) {
                        this.A0k = true;
                    }
                    if (this.A0i && A0X(x12)) {
                        C3T.A07(this);
                    }
                }
                break;
            case 6:
                A0P(motionEvent);
                break;
        }
        VelocityTracker velocityTracker = this.A0U;
        if (A0t[2].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0t;
        strArr4[3] = "qZEBvpK5WM51NnTYZj9Wv9V85vPNkfCF";
        strArr4[6] = "8DoAZte0LwUXg2aXlHvSBWFBy3vUeqDy";
        if (velocityTracker == null) {
            this.A0U = VelocityTracker.obtain();
        }
        this.A0U.addMovement(motionEvent);
        return this.A0i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean z12;
        C3Z c3zA07;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = 8;
            String[] strArr = A0t;
            if (strArr[4].length() == strArr[5].length()) {
                A0t[1] = "";
                if (i18 >= childCount) {
                    int i21 = (i15 - paddingLeft) - paddingRight;
                    int i22 = 0;
                    while (i22 < childCount) {
                        View childAt = getChildAt(i22);
                        if (childAt.getVisibility() != i19) {
                            C10223a c10223a = (C10223a) childAt.getLayoutParams();
                            if (!c10223a.A05 && (c3zA07 = A07(childAt)) != null) {
                                int i23 = paddingLeft + ((int) (i21 * c3zA07.A00));
                                if (c10223a.A03) {
                                    c10223a.A03 = false;
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (i21 * c10223a.A00), 1073741824), View.MeasureSpec.makeMeasureSpec((i16 - paddingTop) - paddingBottom, 1073741824));
                                }
                                int i24 = paddingTop;
                                childAt.layout(i23, i24, childAt.getMeasuredWidth() + i23, childAt.getMeasuredHeight() + i24);
                            }
                        }
                        i22++;
                        i19 = 8;
                    }
                    this.A0Q = paddingTop;
                    this.A09 = i16 - paddingBottom;
                    this.A0D = i17;
                    if (this.A0g) {
                        int i25 = this.A00;
                        z12 = false;
                        String[] strArr2 = A0t;
                        if (strArr2[4].length() != strArr2[5].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A0t;
                        strArr3[4] = "";
                        strArr3[5] = "";
                        A0M(i25, false, 0, false);
                    } else {
                        z12 = false;
                    }
                    this.A0g = z12;
                    return;
                }
                View childAt2 = getChildAt(i18);
                if (childAt2.getVisibility() != 8) {
                    C10223a c10223a2 = (C10223a) childAt2.getLayoutParams();
                    if (c10223a2.A05) {
                        int i26 = c10223a2.A04 & 7;
                        int i27 = c10223a2.A04 & 112;
                        switch (i26) {
                            case 1:
                                iMax = Math.max((i15 - childAt2.getMeasuredWidth()) / 2, paddingLeft);
                                break;
                            case 2:
                            case 4:
                            default:
                                iMax = paddingLeft;
                                break;
                            case 3:
                                iMax = paddingLeft;
                                paddingLeft += childAt2.getMeasuredWidth();
                                break;
                            case 5:
                                int i28 = i15 - paddingRight;
                                int measuredWidth = childAt2.getMeasuredWidth();
                                String[] strArr4 = A0t;
                                if (strArr4[7].charAt(10) == strArr4[0].charAt(10)) {
                                    A0t[1] = "51Hkg";
                                    iMax = i28 - measuredWidth;
                                    paddingRight += childAt2.getMeasuredWidth();
                                }
                                break;
                        }
                        switch (i27) {
                            case 16:
                                iMax2 = Math.max((i16 - childAt2.getMeasuredHeight()) / 2, paddingTop);
                                break;
                            case 48:
                                iMax2 = paddingTop;
                                paddingTop += childAt2.getMeasuredHeight();
                                break;
                            case 80:
                                iMax2 = (i16 - paddingBottom) - childAt2.getMeasuredHeight();
                                paddingBottom += childAt2.getMeasuredHeight();
                                break;
                            default:
                                iMax2 = paddingTop;
                                break;
                        }
                        int i29 = iMax + scrollX;
                        childAt2.layout(i29, iMax2, i29 + childAt2.getMeasuredWidth(), childAt2.getMeasuredHeight() + iMax2);
                        i17++;
                    } else {
                        continue;
                    }
                }
                i18++;
            }
        }
        throw new RuntimeException();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        C10223a c10223a;
        int i13;
        int i14;
        setMeasuredDimension(getDefaultSize(0, i11), getDefaultSize(0, i12));
        int measuredWidth = getMeasuredWidth();
        this.A0I = Math.min(measuredWidth / 10, this.A0E);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                C10223a c10223a2 = (C10223a) childAt.getLayoutParams();
                if (A0t[1].length() == 12) {
                    throw new RuntimeException();
                }
                String[] strArr = A0t;
                strArr[4] = "";
                strArr[5] = "";
                if (c10223a2 != null && c10223a2.A05) {
                    int i16 = c10223a2.A04 & 7;
                    int i17 = c10223a2.A04 & 112;
                    int i18 = Integer.MIN_VALUE;
                    int i19 = Integer.MIN_VALUE;
                    boolean z11 = i17 == 48 || i17 == 80;
                    boolean z12 = i16 == 3 || i16 == 5;
                    if (z11) {
                        i18 = 1073741824;
                    } else if (z12) {
                        i19 = 1073741824;
                    }
                    if (c10223a2.width != -2) {
                        i18 = 1073741824;
                        i13 = c10223a2.width != -1 ? c10223a2.width : paddingLeft;
                    } else {
                        i13 = paddingLeft;
                    }
                    if (c10223a2.height != -2) {
                        i19 = 1073741824;
                        if (c10223a2.height != -1) {
                            i14 = c10223a2.height;
                            if (A0t[1].length() != 12) {
                                A0t[1] = "VKsSzAx6pk9J5wmYrW5ACp";
                            }
                        } else {
                            i14 = measuredHeight;
                        }
                    } else {
                        i14 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i18), View.MeasureSpec.makeMeasureSpec(i14, i19));
                    if (z11) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z12) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.A0B = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.A0A = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.A0h = true;
        A0f();
        this.A0h = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((c10223a = (C10223a) childAt2.getLayoutParams()) == null || !c10223a.A05)) {
                float f11 = paddingLeft;
                String[] strArr2 = A0t;
                if (strArr2[4].length() != strArr2[5].length()) {
                    throw new RuntimeException();
                }
                A0t[1] = "11cm9STM7FlxGR3";
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f11 * c10223a.A00), 1073741824), this.A0A);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i11, Rect rect) {
        int i12;
        int i13;
        C3Z c3zA07;
        int childCount = getChildCount();
        if ((i11 & 2) != 0) {
            i12 = 0;
            i13 = 1;
        } else {
            i12 = childCount - 1;
            i13 = -1;
            childCount = -1;
        }
        while (i12 != childCount) {
            View childAt = getChildAt(i12);
            if (A0t[2].length() == 14) {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[3] = "wvs0VrXDMEHK1ZrgMliCmQkmYIqFRPYZ";
            strArr[6] = "yeuyy9yC0QSIfk9tyj8D1No5khczL5F7";
            if (childAt.getVisibility() == 0 && (c3zA07 = A07(childAt)) != null && c3zA07.A02 == this.A00 && childAt.requestFocus(i11, rect)) {
                return true;
            }
            i12 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            Context context = getContext();
            String[] strArr = A0t;
            if (strArr[3].charAt(15) == strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0t;
            strArr2[7] = "Ly8LvMv3iU8o2fiJAVqvd6K7Aqz3gZKY";
            strArr2[0] = "HcNmsPXina8Ul250FP3kUGj1pgK53N1r";
            classLoader = context.getClassLoader();
        }
        Parcelable parcelableUnwrap = ((WrappedParcelable) parcelable).unwrap(classLoader);
        if (!(parcelableUnwrap instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(parcelableUnwrap);
            return;
        }
        ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState) parcelableUnwrap;
        super.onRestoreInstanceState(viewPager$SavedState.A02());
        if (this.A01 != null) {
            A0N(viewPager$SavedState.A00, false, true);
            return;
        }
        this.A0O = viewPager$SavedState.A00;
        this.A0T = viewPager$SavedState.A01;
        this.A0a = viewPager$SavedState.A02;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(super.onSaveInstanceState());
        viewPager$SavedState.A00 = this.A00;
        C3E c3e = this.A01;
        if (c3e != null) {
            viewPager$SavedState.A01 = c3e.A03();
        }
        return new WrappedParcelable(viewPager$SavedState);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            int i15 = this.A0M;
            A0K(i11, i13, i15, i15);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00cb  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C3E c3e;
        if (this.A0f) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (c3e = this.A01) == null || c3e.A01() == 0) {
            return false;
        }
        if (this.A0U == null) {
            this.A0U = VelocityTracker.obtain();
        }
        this.A0U.addMovement(motionEvent);
        boolean zA0U = false;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.A0X.abortAnimation();
                this.A0m = false;
                A0f();
                float x11 = motionEvent.getX();
                this.A03 = x11;
                this.A05 = x11;
                float y11 = motionEvent.getY();
                this.A04 = y11;
                this.A06 = y11;
                this.A08 = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.A0i) {
                    VelocityTracker velocityTracker = this.A0U;
                    velocityTracker.computeCurrentVelocity(1000, this.A0J);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.A08);
                    this.A0m = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C3Z c3zA03 = A03();
                    A0O(A01(c3zA03.A02, ((scrollX / clientWidth) - c3zA03.A00) / (c3zA03.A01 + (this.A0M / clientWidth)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.A08)) - this.A03)), true, true, xVelocity);
                    zA0U = A0U();
                }
                break;
            case 2:
                if (!this.A0i) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.A08);
                    if (iFindPointerIndex != -1) {
                        float x12 = motionEvent.getX(iFindPointerIndex);
                        float fAbs = Math.abs(x12 - this.A05);
                        float y12 = motionEvent.getY(iFindPointerIndex);
                        float fAbs2 = Math.abs(y12 - this.A06);
                        if (fAbs > this.A0R && fAbs > fAbs2) {
                            this.A0i = true;
                            A0T(true);
                            float f11 = this.A03;
                            this.A05 = x12 - f11 > 0.0f ? f11 + this.A0R : f11 - this.A0R;
                            this.A06 = y12;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                        if (this.A0i) {
                            zA0U = false | A0X(motionEvent.getX(motionEvent.findPointerIndex(this.A08)));
                        }
                    } else {
                        zA0U = A0U();
                    }
                } else if (this.A0i) {
                    zA0U = false | A0X(motionEvent.getX(motionEvent.findPointerIndex(this.A08)));
                }
                break;
            case 3:
                if (this.A0i) {
                    A0M(this.A00, true, 0, false);
                    zA0U = A0U();
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.A05 = motionEvent.getX(actionIndex);
                this.A08 = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                A0P(motionEvent);
                this.A05 = motionEvent.getX(motionEvent.findPointerIndex(this.A08));
                break;
        }
        if (zA0U) {
            C3T.A07(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.A0h) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.facebook.ads.redexgen.X.3e] */
    public void setAdapter(C3E c3e) {
        C3E c3e2 = this.A01;
        if (c3e2 != null) {
            c3e2.A06(null);
            for (int i11 = 0; i11 < this.A0r.size(); i11++) {
                C3Z c3z = this.A0r.get(i11);
                this.A01.A07(this, c3z.A02, c3z.A03);
            }
            this.A0r.clear();
            A0A();
            this.A00 = 0;
            scrollTo(0, 0);
        }
        this.A01 = c3e;
        this.A0G = 0;
        if (c3e != null) {
            if (this.A0Z == null) {
                this.A0Z = new DataSetObserver() { // from class: com.facebook.ads.redexgen.X.3e
                    @Override // android.database.DataSetObserver
                    public final void onChanged() {
                        this.A00.A0e();
                    }

                    @Override // android.database.DataSetObserver
                    public final void onInvalidated() {
                        this.A00.A0e();
                    }
                };
            }
            this.A01.A06(this.A0Z);
            this.A0m = false;
            boolean z11 = this.A0g;
            this.A0g = true;
            this.A0G = this.A01.A01();
            if (this.A0O >= 0) {
                A0N(this.A0O, false, true);
                this.A0O = -1;
                this.A0T = null;
                this.A0a = null;
            } else if (z11) {
                requestLayout();
            } else {
                A0f();
            }
        }
        List<ViewPager.OnAdapterChangeListener> list = this.A0c;
        if (list == null || list.isEmpty() || 0 >= this.A0c.size()) {
            return;
        }
        this.A0c.get(0);
        throw new NullPointerException(A08(381, 16, 117));
    }

    public void setCurrentItem(int i11) {
        this.A0m = false;
        A0N(i11, !this.A0g, false);
    }

    public void setOffscreenPageLimit(int i11) {
        if (i11 < 1) {
            Log.w(A08(LogSeverity.NOTICE_VALUE, 9, 47), A08(127, 31, 60) + i11 + A08(51, 26, 90) + 1);
            i11 = 1;
        }
        if (i11 != this.A0L) {
            this.A0L = i11;
            A0f();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC10243c interfaceC10243c) {
        this.A0Y = interfaceC10243c;
    }

    public void setPageMargin(int i11) {
        int i12 = this.A0M;
        this.A0M = i11;
        int width = getWidth();
        A0K(width, width, i11, i12);
        requestLayout();
    }

    public void setPageMarginDrawable(int i11) {
        setPageMarginDrawable(AbstractC10062k.A00(getContext(), i11));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.A0S = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i11) {
        if (this.A0P == i11) {
            return;
        }
        this.A0P = i11;
        if (0 != 0) {
            A0S(i11 != 0);
        }
        A0F(i11);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A0S;
    }
}
