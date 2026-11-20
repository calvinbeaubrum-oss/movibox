package com.facebook.ads.redexgen.uinode;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1462Lo {
    public static byte[] A00;
    public static String[] A01 = {"T9yeGAB86XK0vsZmNpfh4sIozppRZOgX", "Zi2TG3AXo50avc5D0Zq9wx", "JqBKj5K49VPZ3Gy9qBscEl", "4Ni4MdhmG8L", "r65r3", "RNCTQQIFlAbprT7c08Eivsd0jPtRWtbK", "BqjiC5lxzxq0feSMCCnGMnwMzT1DFPOJ", "3asmvLId1fZdr9gBLrqbDNcfpMudytXC"};
    public static final int A02;
    public static final int A03;
    public static final ConcurrentHashMap<Integer, Integer> A04;
    public static final AtomicInteger A05;

    static {
        A0E();
        A03 = AbstractC10112p.A01(-1, 0);
        A02 = AbstractC10112p.A01(ViewCompat.MEASURED_STATE_MASK, 115);
        A05 = new AtomicInteger(1);
        A04 = new ConcurrentHashMap<>();
    }

    public static int A00() {
        AtomicInteger atomicInteger;
        int i11;
        int i12;
        do {
            atomicInteger = A05;
            i11 = atomicInteger.get();
            i12 = i11 + 1;
            if (i12 > 16777215) {
                i12 = 1;
            }
        } while (!atomicInteger.compareAndSet(i11, i12));
        return i11;
    }

    public static int A01(int i11) {
        return (int) TypedValue.applyDimension(2, i11, LD.A03);
    }

    public static int A02(int i11) {
        return A0b(i11) ? AbstractC10112p.A02(i11, -1, 0.4f) : AbstractC10112p.A02(i11, ViewCompat.MEASURED_STATE_MASK, 0.2f);
    }

    public static int A03(TextView textView) {
        Layout layout;
        int lineCount;
        if (textView == null || textView.getLayout() == null || (lineCount = (layout = textView.getLayout()).getLineCount()) <= 0) {
            return 0;
        }
        double ellipsisCount = layout.getEllipsisCount(lineCount - 1);
        return (int) Math.ceil(ellipsisCount / (((double) textView.getText().length()) - ellipsisCount));
    }

    public static int A04(TextView textView, int i11) {
        int iA03 = A03(textView);
        int i12 = 0;
        int lineHeight = textView.getLineHeight();
        while (i11 > lineHeight && i12 < iA03) {
            i12++;
            i11 -= lineHeight;
        }
        return i12;
    }

    public static Drawable A05(int i11, int i12) {
        return A08(i11, A02(i11), i12);
    }

    public static Drawable A06(int i11, int i12) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i11);
        gradientDrawable.setCornerRadius(i12);
        return gradientDrawable;
    }

    public static Drawable A07(int i11, int i12) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, i12);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i11);
        return shapeDrawable;
    }

    public static Drawable A08(int i11, int i12, int i13) {
        return A09(i11, i12, i11, i13);
    }

    public static Drawable A09(int i11, int i12, int i13, int i14) {
        return Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(ColorStateList.valueOf(i12), A06(i11, i14), A07(i13, i14)) : A0A(i11, i12, i14);
    }

    public static StateListDrawable A0A(int i11, int i12, int i13) {
        return A0B(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i12, i11}, i13);
    }

    public static StateListDrawable A0B(int[][] iArr, int[] iArr2, int i11) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int i12 = 0; i12 < iArr.length; i12++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr2[i12]);
            gradientDrawable.setCornerRadius(i11);
            stateListDrawable.addState(iArr[i12], gradientDrawable);
        }
        return stateListDrawable;
    }

    public static TextView A0C(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                A0C((ViewGroup) childAt);
            }
        }
        return null;
    }

    public static String A0D(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A00 = new byte[]{-24, -26, -15, -15, -22, -9, -39, -2, -11, -22, Ascii.NAK, Ascii.RS, Ascii.ESC, Ascii.NAK, Ascii.GS, 17, 37, 33, 39, 36, Ascii.NAK, Ascii.ETB, 58, 61, 64, 72, 57, 70, 57, 56, 51, 55, 64, 61, 55, Utf8.REPLACEMENT_BYTE, 51, 56, 57, 64, 53, 77, 51, 65, 71, 46, 51, 57, 42, 55, 56, 57, 46, 57, 46, 38, 49, 33, 43, Ascii.ETB, Ascii.ESC, 42, Ascii.GS, Ascii.EM, 44, 33, 46, Ascii.GS, Ascii.ETB, Ascii.EM, 43, Ascii.ETB, Ascii.ESC, 44, Ascii.EM, Ascii.ETB, 46, -22, -11, -24, -6, -28, -11, -25, -24, -25, -30, -7, -20, -25, -24, -14, -8, -26, -13, -8, -78, -8, -22, -9, -18, -21, -78, -14, -22, -23, -18, -6, -14, -52, -59, -64, -56, -52, -68, -96, -69, -33, -35, -49, -36, -51, -42, -45, -51, -43};
    }

    public static void A0F(int i11, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(i11 / 3);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration((i11 / 3) * 2);
        scaleAnimation2.setInterpolator(new BounceInterpolator());
        scaleAnimation.setAnimationListener(new C1684Uc(view, scaleAnimation2));
        view.startAnimation(scaleAnimation);
    }

    public static void A0G(int i11, View view) {
        Integer num = A04.get(Integer.valueOf(i11));
        if (num != null) {
            view.setId(num.intValue());
        } else {
            A0K(view);
        }
    }

    public static void A0H(View view) {
        A0N(view, 8);
    }

    public static void A0I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return;
        }
        A0T((ViewGroup) parent);
    }

    public static void A0J(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public static void A0K(View view) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            view.setId(View.generateViewId());
        } else {
            view.setId(A00());
        }
    }

    public static void A0L(View view) {
        A0N(view, 0);
    }

    public static void A0M(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(new ColorDrawable(i11));
        } else {
            view.setBackgroundDrawable(new ColorDrawable(i11));
        }
    }

    public static void A0N(View view, int i11) {
        if (view != null) {
            view.setVisibility(i11);
        }
    }

    public static void A0O(View view, int i11, int i12) {
        A0S(view, A08(i11, A02(i11), i12));
    }

    public static void A0P(View view, int i11, int i12, int i13) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(i11);
        gradientDrawable.setStroke(i12, i13);
        A0S(view, gradientDrawable);
    }

    public static void A0Q(View view, int i11, int i12, int i13) {
        A0S(view, A09(i11, A02(i11), i12, i13));
    }

    public static void A0R(View view, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(0.0f);
        A0S(view, gradientDrawable);
    }

    public static void A0S(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void A0T(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT > 19) {
            A0U(viewGroup, 200);
        }
    }

    public static void A0U(ViewGroup viewGroup, int i11) {
        if (Build.VERSION.SDK_INT > 19) {
            A0W(viewGroup, new AutoTransition(), i11);
        }
    }

    public static void A0V(ViewGroup viewGroup, Transition transition) {
        if (Build.VERSION.SDK_INT > 19) {
            A0W(viewGroup, transition, 200);
        }
    }

    public static void A0W(ViewGroup viewGroup, Transition transition, int i11) {
        transition.setDuration(i11);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(viewGroup, transition);
    }

    public static void A0X(TextView textView, boolean z11, int i11) {
        Typeface typefaceCreate;
        if (z11) {
            typefaceCreate = Build.VERSION.SDK_INT >= 21 ? Typeface.create(A0D(92, 17, 46), 0) : Typeface.create(Typeface.SANS_SERIF, 1);
        } else {
            typefaceCreate = Typeface.create(Typeface.SANS_SERIF, 0);
        }
        textView.setTypeface(typefaceCreate);
        textView.setTextSize(2, i11);
    }

    public static void A0Y(Toast toast, String str, int i11, int i12, int i13) {
        if (toast == null) {
            return;
        }
        toast.setGravity(i11, i12, i13);
        TextView textViewA0C = A0C((ViewGroup) toast.getView());
        if (textViewA0C != null) {
            textViewA0C.setText(str);
            textViewA0C.setGravity(17);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0055  */
    /* JADX WARN: Code duplicated, block: B:6:0x000e  */
    public static void A0Z(Map<String, String> map, AbstractC1898b5 abstractC1898b5) {
        byte b11;
        if (abstractC1898b5 == null) {
            return;
        }
        String strA0P = abstractC1898b5.A0P();
        switch (strA0P.hashCode()) {
            case -1364000502:
                if (!strA0P.equals(A0D(78, 14, 44))) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 604727084:
                String[] strArr = A01;
                if (strArr[6].charAt(11) == strArr[7].charAt(11)) {
                    String[] strArr2 = A01;
                    strArr2[0] = "RlCCOSKS3krO76Z8d8aans18JsIjD59L";
                    strArr2[5] = "r3TWBb0uAOb49M7fooTivsHeogrthYcU";
                    if (!strA0P.equals(A0D(45, 8, 48))) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                } else {
                    A01[4] = "QpMMj";
                    if (!strA0P.equals(A0D(45, 12, Worker.WHAT_QUIT))) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                }
                break;
            default:
                b11 = -1;
                break;
        }
        String[] strArr3 = A01;
        if (strArr3[0].charAt(21) != strArr3[5].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr4 = A01;
        strArr4[0] = "n4EWq8cbMgSrFIIPy3PtZs3ykG3gLNVv";
        strArr4[5] = "w61oSRwyzhyXZmY3tLRPvspfZwiCeo8H";
        String strA0D = A0D(0, 10, 46);
        switch (b11) {
            case 0:
                map.put(strA0D, AdPlacementType.INTERSTITIAL.name());
                break;
            case 1:
                map.put(strA0D, AdPlacementType.REWARDED_VIDEO.name());
                break;
        }
        map.put(A0D(109, 8, 0), abstractC1898b5.A0K());
        map.put(A0D(57, 21, 97), String.valueOf(abstractC1898b5.A0l()));
        map.put(A0D(22, 23, 125), String.valueOf(abstractC1898b5.A0H()));
    }

    public static void A0a(View... viewArr) {
        for (View view : viewArr) {
            A0J(view);
        }
    }

    public static boolean A0b(int i11) {
        return AbstractC10112p.A00(i11) < 0.5d;
    }

    public static boolean A0c(EnumC09510g enumC09510g, Map<String, String> map) {
        String str = map.get(A0D(10, 12, 91));
        return (str != null && !A0D(117, 9, 19).equals(str)) && (enumC09510g != EnumC09510g.A07);
    }

    public static boolean A0d(C1795Yn c1795Yn, EnumC09510g enumC09510g) {
        return enumC09510g == EnumC09510g.A07 && C1384Ih.A2N(c1795Yn);
    }

    public static boolean A0e(C1795Yn c1795Yn, EnumC09510g enumC09510g, Map<String, String> map) {
        String str = map.get(A0D(57, 21, 97));
        if (str != null && str.equals(Boolean.TRUE.toString())) {
            boolean zA0d = A0d(c1795Yn, enumC09510g);
            String[] strArr = A01;
            if (strArr[6].charAt(11) == strArr[7].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "u8VsnBmPWVphPllKxtlQdK";
            strArr2[2] = "HE77zV2Ng27gpeh0j3drVs";
            if (zA0d || A0c(enumC09510g, map)) {
                return true;
            }
        }
        return false;
    }
}
