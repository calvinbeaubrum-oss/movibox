package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.f0;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import oi.f;
import ti.j;
import yi.i;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f37507w0 = "BaseSlider";
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public float O;
    public MotionEvent P;
    public boolean Q;
    public float R;
    public float S;
    public ArrayList<Float> T;
    public int U;
    public int V;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Paint f37511a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float[] f37512a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Paint f37513b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f37514b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Paint f37515c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f37516c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Paint f37517d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f37518d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f37519e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Paint f37520f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f37521f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Paint f37522g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f37523g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Paint f37524h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f37525h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final d f37526i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @NonNull
    public ColorStateList f37527i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AccessibilityManager f37528j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @NonNull
    public ColorStateList f37529j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BaseSlider<S, L, T>.AccessibilityEventSender f37530k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @NonNull
    public ColorStateList f37531k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f37532l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @NonNull
    public ColorStateList f37533l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final List<aj.a> f37534m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @NonNull
    public ColorStateList f37535m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final List<L> f37536n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @NonNull
    public final Path f37537n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final List<T> f37538o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @NonNull
    public final RectF f37539o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f37540p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @NonNull
    public final RectF f37541p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f37542q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @NonNull
    public final i f37543q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f37544r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @Nullable
    public Drawable f37545r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f37546s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @NonNull
    public List<Drawable> f37547s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f37548t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public float f37549t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37550u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f37551u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37552v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    @NonNull
    public final ViewTreeObserver.OnScrollChangedListener f37553v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f37555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f37556y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f37557z;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f37508x0 = R$style.Widget_MaterialComponents_Slider;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f37509y0 = R$attr.motionDurationMedium4;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f37510z0 = R$attr.motionDurationShort3;
    public static final int A0 = R$attr.motionEasingEmphasizedInterpolator;
    public static final int B0 = R$attr.motionEasingEmphasizedAccelerateInterpolator;

    /* JADX INFO: compiled from: source.java */
    public class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        public /* synthetic */ AccessibilityEventSender(BaseSlider baseSlider, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f37526i.J(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int i11) {
            this.virtualViewId = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    /* JADX INFO: compiled from: source.java */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f37558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f37559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Float> f37560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f37561d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f37562f;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i11) {
                return new SliderState[i11];
            }
        }

        public SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.f37558a = parcel.readFloat();
            this.f37559b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f37560c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f37561d = parcel.readFloat();
            this.f37562f = parcel.createBooleanArray()[0];
        }

        public /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeFloat(this.f37558a);
            parcel.writeFloat(this.f37559b);
            parcel.writeList(this.f37560c);
            parcel.writeFloat(this.f37561d);
            parcel.writeBooleanArray(new boolean[]{this.f37562f});
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.f37534m.iterator();
            while (it.hasNext()) {
                ((aj.a) it.next()).D0(fFloatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d0 d0VarK = f0.k(BaseSlider.this);
            Iterator it = BaseSlider.this.f37534m.iterator();
            while (it.hasNext()) {
                d0VarK.b((aj.a) it.next());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37565a;

        static {
            int[] iArr = new int[FullCornerDirection.values().length];
            f37565a = iArr;
            try {
                iArr[FullCornerDirection.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37565a[FullCornerDirection.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37565a[FullCornerDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37565a[FullCornerDirection.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends androidx.customview.widget.a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final BaseSlider<?, ?, ?> f37566n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Rect f37567o;

        public d(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f37567o = new Rect();
            this.f37566n = baseSlider;
        }

        @Override // androidx.customview.widget.a
        public void C(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.f37566n.getValues();
            float fFloatValue = values.get(i11).floatValue();
            float valueFrom = this.f37566n.getValueFrom();
            float valueTo = this.f37566n.getValueTo();
            if (this.f37566n.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (fFloatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, fFloatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb2 = new StringBuilder();
            if (this.f37566n.getContentDescription() != null) {
                sb2.append(this.f37566n.getContentDescription());
                sb2.append(",");
            }
            String strA = this.f37566n.A(fFloatValue);
            String string = this.f37566n.getContext().getString(R$string.material_slider_value);
            if (values.size() > 1) {
                string = L(i11);
            }
            sb2.append(String.format(Locale.US, "%s, %s", string, strA));
            accessibilityNodeInfoCompat.setContentDescription(sb2.toString());
            this.f37566n.m0(i11, this.f37567o);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f37567o);
        }

        @NonNull
        public final String L(int i11) {
            if (i11 == this.f37566n.getValues().size() - 1) {
                return this.f37566n.getContext().getString(R$string.material_slider_range_end);
            }
            return i11 == 0 ? this.f37566n.getContext().getString(R$string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.a
        public int o(float f11, float f12) {
            for (int i11 = 0; i11 < this.f37566n.getValues().size(); i11++) {
                this.f37566n.m0(i11, this.f37567o);
                if (this.f37567o.contains((int) f11, (int) f12)) {
                    return i11;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.a
        public void p(List<Integer> list) {
            for (int i11 = 0; i11 < this.f37566n.getValues().size(); i11++) {
                list.add(Integer.valueOf(i11));
            }
        }

        @Override // androidx.customview.widget.a
        public boolean y(int i11, int i12, Bundle bundle) {
            if (!this.f37566n.isEnabled()) {
                return false;
            }
            if (i12 != 4096 && i12 != 8192) {
                if (i12 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.f37566n.k0(i11, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.f37566n.n0();
                        this.f37566n.postInvalidate();
                        r(i11);
                        return true;
                    }
                }
                return false;
            }
            float fL = this.f37566n.l(20);
            if (i12 == 8192) {
                fL = -fL;
            }
            if (this.f37566n.M()) {
                fL = -fL;
            }
            if (!this.f37566n.k0(i11, g3.a.a(this.f37566n.getValues().get(i11).floatValue() + fL, this.f37566n.getValueFrom(), this.f37566n.getValueTo()))) {
                return false;
            }
            this.f37566n.n0();
            this.f37566n.postInvalidate();
            r(i11);
            return true;
        }
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(zi.a.c(context, attributeSet, i11, f37508x0), attributeSet, i11);
        this.f37534m = new ArrayList();
        this.f37536n = new ArrayList();
        this.f37538o = new ArrayList();
        this.f37540p = false;
        this.J = -1;
        this.K = -1;
        this.Q = false;
        this.T = new ArrayList<>();
        this.U = -1;
        this.V = -1;
        this.W = 0.0f;
        this.f37514b0 = true;
        this.f37523g0 = false;
        this.f37537n0 = new Path();
        this.f37539o0 = new RectF();
        this.f37541p0 = new RectF();
        i iVar = new i();
        this.f37543q0 = iVar;
        this.f37547s0 = Collections.emptyList();
        this.f37551u0 = 0;
        this.f37553v0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f37568a.o0();
            }
        };
        Context context2 = getContext();
        this.f37511a = new Paint();
        this.f37513b = new Paint();
        Paint paint = new Paint(1);
        this.f37515c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.f37517d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f37520f = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f37522g = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.f37524h = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        O(context2.getResources());
        d0(context2, attributeSet, i11);
        setFocusable(true);
        setClickable(true);
        iVar.k0(2);
        this.f37546s = ViewConfiguration.get(context2).getScaledTouchSlop();
        d dVar = new d(this);
        this.f37526i = dVar;
        ViewCompat.setAccessibilityDelegate(this, dVar);
        this.f37528j = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public static float B(ValueAnimator valueAnimator, float f11) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f11;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    public static boolean J(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private float[] getActiveRange() {
        float fFloatValue = this.T.get(0).floatValue();
        ArrayList<Float> arrayList = this.T;
        float fFloatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (this.T.size() == 1) {
            fFloatValue = this.R;
        }
        float fX = X(fFloatValue);
        float fX2 = X(fFloatValue2);
        return M() ? new float[]{fX2, fX} : new float[]{fX, fX2};
    }

    private float getValueOfTouchPosition() {
        double dJ0 = j0(this.f37549t0);
        if (M()) {
            dJ0 = 1.0d - dJ0;
        }
        float f11 = this.S;
        float f12 = this.R;
        return (float) ((dJ0 * ((double) (f11 - f12))) + ((double) f12));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f11 = this.f37549t0;
        if (M()) {
            f11 = 1.0f - f11;
        }
        float f12 = this.S;
        float f13 = this.R;
        return (f11 * (f12 - f13)) + f13;
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.T.size() == arrayList.size() && this.T.equals(arrayList)) {
            return;
        }
        this.T = arrayList;
        this.f37525h0 = true;
        this.V = 0;
        n0();
        o();
        s();
        postInvalidate();
    }

    public final String A(float f11) {
        if (hasLabelFormatter()) {
            throw null;
        }
        return String.format(((float) ((int) f11)) == f11 ? "%.0f" : "%.2f", Float.valueOf(f11));
    }

    public final void A0() {
        float f11 = this.W;
        if (f11 == 0.0f) {
            return;
        }
        if (((int) f11) != f11) {
            Log.w(f37507w0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f11)));
        }
        float f12 = this.R;
        if (((int) f12) != f12) {
            Log.w(f37507w0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f12)));
        }
        float f13 = this.S;
        if (((int) f13) != f13) {
            Log.w(f37507w0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f13)));
        }
    }

    public final float C(int i11, float f11) {
        float minSeparation = getMinSeparation();
        if (this.f37551u0 == 0) {
            minSeparation = q(minSeparation);
        }
        if (M()) {
            minSeparation = -minSeparation;
        }
        int i12 = i11 + 1;
        int i13 = i11 - 1;
        return g3.a.a(f11, i13 < 0 ? this.R : this.T.get(i13).floatValue() + minSeparation, i12 >= this.T.size() ? this.S : this.T.get(i12).floatValue() - minSeparation);
    }

    public final int D(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final float[] E(float f11, float f12) {
        return new float[]{f11, f11, f12, f12, f12, f12, f11, f11};
    }

    public final boolean F() {
        return this.I > 0;
    }

    public final Drawable G(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        h(drawableNewDrawable);
        return drawableNewDrawable;
    }

    public final void H() {
        this.f37511a.setStrokeWidth(this.D);
        this.f37513b.setStrokeWidth(this.D);
    }

    public final boolean I() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean K(double d11) {
        double dDoubleValue = new BigDecimal(Double.toString(d11)).divide(new BigDecimal(Float.toString(this.W)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean L(MotionEvent motionEvent) {
        return !J(motionEvent) && I();
    }

    public final boolean M() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public final boolean N() {
        Rect rect = new Rect();
        f0.j(this).getHitRect(rect);
        return getLocalVisibleRect(rect);
    }

    public final void O(@NonNull Resources resources) {
        this.A = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.f37548t = dimensionPixelOffset;
        this.E = dimensionPixelOffset;
        this.f37550u = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.f37552v = resources.getDimensionPixelSize(R$dimen.mtrl_slider_track_height);
        this.f37554w = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_radius);
        this.f37555x = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_radius);
        this.f37556y = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_min_spacing);
        this.N = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
    }

    public final void P() {
        if (this.W <= 0.0f) {
            return;
        }
        s0();
        int iMin = Math.min((int) (((this.S - this.R) / this.W) + 1.0f), (this.f37519e0 / this.f37556y) + 1);
        float[] fArr = this.f37512a0;
        if (fArr == null || fArr.length != iMin * 2) {
            this.f37512a0 = new float[iMin * 2];
        }
        float f11 = this.f37519e0 / (iMin - 1);
        for (int i11 = 0; i11 < iMin * 2; i11 += 2) {
            float[] fArr2 = this.f37512a0;
            fArr2[i11] = this.E + ((i11 / 2.0f) * f11);
            fArr2[i11 + 1] = m();
        }
    }

    public final void Q(@NonNull Canvas canvas, int i11, int i12) {
        if (h0()) {
            int iX = (int) (this.E + (X(this.T.get(this.V).floatValue()) * i11));
            if (Build.VERSION.SDK_INT < 28) {
                int i13 = this.H;
                canvas.clipRect(iX - i13, i12 - i13, iX + i13, i13 + i12, Region.Op.UNION);
            }
            canvas.drawCircle(iX, i12, this.H, this.f37517d);
        }
    }

    public final void R(@NonNull Canvas canvas, int i11) {
        if (this.L <= 0) {
            return;
        }
        if (this.T.size() >= 1) {
            ArrayList<Float> arrayList = this.T;
            float fFloatValue = arrayList.get(arrayList.size() - 1).floatValue();
            float f11 = this.S;
            if (fFloatValue < f11) {
                canvas.drawPoint(z0(f11), i11, this.f37524h);
            }
        }
        if (this.T.size() > 1) {
            float fFloatValue2 = this.T.get(0).floatValue();
            float f12 = this.R;
            if (fFloatValue2 > f12) {
                canvas.drawPoint(z0(f12), i11, this.f37524h);
            }
        }
    }

    public final void S(@NonNull Canvas canvas) {
        if (!this.f37514b0 || this.W <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int iCeil = (int) Math.ceil(activeRange[0] * ((this.f37512a0.length / 2.0f) - 1.0f));
        int iFloor = (int) Math.floor(activeRange[1] * ((this.f37512a0.length / 2.0f) - 1.0f));
        if (iCeil > 0) {
            canvas.drawPoints(this.f37512a0, 0, iCeil * 2, this.f37520f);
        }
        if (iCeil <= iFloor) {
            canvas.drawPoints(this.f37512a0, iCeil * 2, ((iFloor - iCeil) + 1) * 2, this.f37522g);
        }
        int i11 = (iFloor + 1) * 2;
        float[] fArr = this.f37512a0;
        if (i11 < fArr.length) {
            canvas.drawPoints(fArr, i11, fArr.length - i11, this.f37520f);
        }
    }

    public final boolean T() {
        int iMax = this.f37548t + Math.max(Math.max(Math.max((this.F / 2) - this.f37550u, 0), Math.max((this.D - this.f37552v) / 2, 0)), Math.max(Math.max(this.f37516c0 - this.f37554w, 0), Math.max(this.f37518d0 - this.f37555x, 0)));
        if (this.E == iMax) {
            return false;
        }
        this.E = iMax;
        if (!ViewCompat.isLaidOut(this)) {
            return true;
        }
        q0(getWidth());
        return true;
    }

    public final boolean U() {
        int iMax = Math.max(this.A, Math.max(this.D + getPaddingTop() + getPaddingBottom(), this.G + getPaddingTop() + getPaddingBottom()));
        if (iMax == this.B) {
            return false;
        }
        this.B = iMax;
        return true;
    }

    public final boolean V(int i11) {
        int i12 = this.V;
        int iC = (int) g3.a.c(((long) i12) + ((long) i11), 0L, this.T.size() - 1);
        this.V = iC;
        if (iC == i12) {
            return false;
        }
        if (this.U != -1) {
            this.U = iC;
        }
        n0();
        postInvalidate();
        return true;
    }

    public final boolean W(int i11) {
        if (M()) {
            i11 = i11 == Integer.MIN_VALUE ? Api.BaseClientBuilder.API_PRIORITY_OTHER : -i11;
        }
        return V(i11);
    }

    public final float X(float f11) {
        float f12 = this.R;
        float f13 = (f11 - f12) / (this.S - f12);
        return M() ? 1.0f - f13 : f13;
    }

    @Nullable
    public final Boolean Y(int i11, @NonNull KeyEvent keyEvent) {
        if (i11 == 61) {
            if (keyEvent.hasNoModifiers()) {
                return Boolean.valueOf(V(1));
            }
            return keyEvent.isShiftPressed() ? Boolean.valueOf(V(-1)) : Boolean.FALSE;
        }
        if (i11 != 66) {
            if (i11 != 81) {
                if (i11 == 69) {
                    V(-1);
                    return Boolean.TRUE;
                }
                if (i11 != 70) {
                    switch (i11) {
                        case 21:
                            W(-1);
                            return Boolean.TRUE;
                        case 22:
                            W(1);
                            return Boolean.TRUE;
                        case 23:
                            break;
                        default:
                            return null;
                    }
                }
            }
            V(1);
            return Boolean.TRUE;
        }
        this.U = this.V;
        postInvalidate();
        return Boolean.TRUE;
    }

    public final void Z() {
        Iterator<T> it = this.f37538o.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void a0() {
        Iterator<T> it = this.f37538o.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public void addOnChangeListener(@NonNull L l11) {
        this.f37536n.add(l11);
    }

    public void addOnSliderTouchListener(@NonNull T t11) {
        this.f37538o.add(t11);
    }

    public boolean b0() {
        if (this.U != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fZ0 = z0(valueOfTouchPositionAbsolute);
        this.U = 0;
        float fAbs = Math.abs(this.T.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i11 = 1; i11 < this.T.size(); i11++) {
            float fAbs2 = Math.abs(this.T.get(i11).floatValue() - valueOfTouchPositionAbsolute);
            float fZ1 = z0(this.T.get(i11).floatValue());
            if (Float.compare(fAbs2, fAbs) > 0) {
                break;
            }
            boolean z11 = !M() ? fZ1 - fZ0 >= 0.0f : fZ1 - fZ0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.U = i11;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fZ1 - fZ0) < this.f37546s) {
                        this.U = -1;
                        return false;
                    }
                    if (z11) {
                        this.U = i11;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.U != -1;
    }

    public final void c0(aj.a aVar, float f11) {
        int iX = (this.E + ((int) (X(f11) * this.f37519e0))) - (aVar.getIntrinsicWidth() / 2);
        int iM = m() - (this.N + (this.G / 2));
        aVar.setBounds(iX, iM - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + iX, iM);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.d.c(f0.j(this), this, rect);
        aVar.setBounds(rect);
    }

    public void clearOnChangeListeners() {
        this.f37536n.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.f37538o.clear();
    }

    public final void d0(Context context, AttributeSet attributeSet, int i11) {
        TypedArray typedArrayI = b0.i(context, attributeSet, R$styleable.Slider, i11, f37508x0, new int[0]);
        this.f37532l = typedArrayI.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip);
        this.R = typedArrayI.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.S = typedArrayI.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.R));
        this.W = typedArrayI.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        this.f37557z = (int) Math.ceil(typedArrayI.getDimension(R$styleable.Slider_minTouchTargetSize, (float) Math.ceil(f0.g(getContext(), 48))));
        boolean zHasValue = typedArrayI.hasValue(R$styleable.Slider_trackColor);
        int i12 = zHasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorInactive;
        int i13 = zHasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorActive;
        ColorStateList colorStateListA = vi.d.a(context, typedArrayI, i12);
        if (colorStateListA == null) {
            colorStateListA = d1.a.a(context, R$color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListA);
        ColorStateList colorStateListA2 = vi.d.a(context, typedArrayI, i13);
        if (colorStateListA2 == null) {
            colorStateListA2 = d1.a.a(context, R$color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListA2);
        this.f37543q0.d0(vi.d.a(context, typedArrayI, R$styleable.Slider_thumbColor));
        if (typedArrayI.hasValue(R$styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(vi.d.a(context, typedArrayI, R$styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(typedArrayI.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = vi.d.a(context, typedArrayI, R$styleable.Slider_haloColor);
        if (colorStateListA3 == null) {
            colorStateListA3 = d1.a.a(context, R$color.material_slider_halo_color);
        }
        setHaloTintList(colorStateListA3);
        this.f37514b0 = typedArrayI.getBoolean(R$styleable.Slider_tickVisible, true);
        boolean zHasValue2 = typedArrayI.hasValue(R$styleable.Slider_tickColor);
        int i14 = zHasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorInactive;
        int i15 = zHasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorActive;
        ColorStateList colorStateListA4 = vi.d.a(context, typedArrayI, i14);
        if (colorStateListA4 == null) {
            colorStateListA4 = d1.a.a(context, R$color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListA4);
        ColorStateList colorStateListA5 = vi.d.a(context, typedArrayI, i15);
        if (colorStateListA5 == null) {
            colorStateListA5 = d1.a.a(context, R$color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListA5);
        setThumbTrackGapSize(typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(typedArrayI.getDimensionPixelSize(R$styleable.Slider_trackStopIndicatorSize, 0));
        setTrackInsideCornerSize(typedArrayI.getDimensionPixelSize(R$styleable.Slider_trackInsideCornerSize, 0));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(typedArrayI.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayI.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayI.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        setTickActiveRadius(typedArrayI.getDimensionPixelSize(R$styleable.Slider_tickRadiusActive, this.L / 2));
        setTickInactiveRadius(typedArrayI.getDimensionPixelSize(R$styleable.Slider_tickRadiusInactive, this.L / 2));
        setLabelBehavior(typedArrayI.getInt(R$styleable.Slider_labelBehavior, 0));
        if (!typedArrayI.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayI.recycle();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.f37526i.i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f37511a.setColor(D(this.f37535m0));
        this.f37513b.setColor(D(this.f37533l0));
        this.f37520f.setColor(D(this.f37531k0));
        this.f37522g.setColor(D(this.f37529j0));
        this.f37524h.setColor(D(this.f37533l0));
        for (aj.a aVar : this.f37534m) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.f37543q0.isStateful()) {
            this.f37543q0.setState(getDrawableState());
        }
        this.f37517d.setColor(D(this.f37527i0));
        this.f37517d.setAlpha(63);
    }

    public final void e0(int i11) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.f37530k;
        if (accessibilityEventSender == null) {
            this.f37530k = new AccessibilityEventSender(this, null);
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.f37530k.setVirtualViewId(i11);
        postDelayed(this.f37530k, 200L);
    }

    public final void f0(aj.a aVar, float f11) {
        aVar.E0(A(f11));
        c0(aVar, f11);
        f0.k(this).a(aVar);
    }

    public final boolean g0() {
        return this.C == 3;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f37526i.k();
    }

    public int getActiveThumbIndex() {
        return this.U;
    }

    public int getFocusedThumbIndex() {
        return this.V;
    }

    public int getHaloRadius() {
        return this.H;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.f37527i0;
    }

    public int getLabelBehavior() {
        return this.C;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.W;
    }

    public float getThumbElevation() {
        return this.f37543q0.y();
    }

    public int getThumbHeight() {
        return this.G;
    }

    public int getThumbRadius() {
        return this.F / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f37543q0.H();
    }

    public float getThumbStrokeWidth() {
        return this.f37543q0.J();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.f37543q0.z();
    }

    public int getThumbTrackGapSize() {
        return this.I;
    }

    public int getThumbWidth() {
        return this.F;
    }

    public int getTickActiveRadius() {
        return this.f37516c0;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.f37529j0;
    }

    public int getTickInactiveRadius() {
        return this.f37518d0;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.f37531k0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.f37531k0.equals(this.f37529j0)) {
            return this.f37529j0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.f37533l0;
    }

    public int getTrackHeight() {
        return this.D;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.f37535m0;
    }

    public int getTrackInsideCornerSize() {
        return this.M;
    }

    public int getTrackSidePadding() {
        return this.E;
    }

    public int getTrackStopIndicatorSize() {
        return this.L;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.f37535m0.equals(this.f37533l0)) {
            return this.f37533l0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f37519e0;
    }

    public float getValueFrom() {
        return this.R;
    }

    public float getValueTo() {
        return this.S;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.T);
    }

    public final void h(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.F, this.G);
        } else {
            float fMax = Math.max(this.F, this.G) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final boolean h0() {
        return this.f37521f0 || !(getBackground() instanceof RippleDrawable);
    }

    public boolean hasLabelFormatter() {
        return false;
    }

    public final void i(aj.a aVar) {
        aVar.C0(f0.j(this));
    }

    public final boolean i0(float f11) {
        return k0(this.U, f11);
    }

    public boolean isTickVisible() {
        return this.f37514b0;
    }

    @Nullable
    public final Float j(int i11) {
        float fL = this.f37523g0 ? l(20) : k();
        if (i11 == 21) {
            if (!M()) {
                fL = -fL;
            }
            return Float.valueOf(fL);
        }
        if (i11 == 22) {
            if (M()) {
                fL = -fL;
            }
            return Float.valueOf(fL);
        }
        if (i11 == 69) {
            return Float.valueOf(-fL);
        }
        if (i11 == 70 || i11 == 81) {
            return Float.valueOf(fL);
        }
        return null;
    }

    public final double j0(float f11) {
        float f12 = this.W;
        if (f12 <= 0.0f) {
            return f11;
        }
        int i11 = (int) ((this.S - this.R) / f12);
        return ((double) Math.round(f11 * i11)) / ((double) i11);
    }

    public final float k() {
        float f11 = this.W;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        return f11;
    }

    public final boolean k0(int i11, float f11) {
        this.V = i11;
        if (Math.abs(f11 - this.T.get(i11).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.T.set(i11, Float.valueOf(C(i11, f11)));
        r(i11);
        return true;
    }

    public final float l(int i11) {
        float fK = k();
        float f11 = (this.S - this.R) / fK;
        float f12 = i11;
        return f11 <= f12 ? fK : Math.round(f11 / f12) * fK;
    }

    public final boolean l0() {
        return i0(getValueOfTouchPosition());
    }

    public final int m() {
        return (this.B / 2) + ((this.C == 1 || g0()) ? this.f37534m.get(0).getIntrinsicHeight() : 0);
    }

    public void m0(int i11, Rect rect) {
        int iX = this.E + ((int) (X(getValues().get(i11).floatValue()) * this.f37519e0));
        int iM = m();
        int iMax = Math.max(this.F / 2, this.f37557z / 2);
        int iMax2 = Math.max(this.G / 2, this.f37557z / 2);
        rect.set(iX - iMax, iM - iMax2, iX + iMax, iM + iMax2);
    }

    public final ValueAnimator n(boolean z11) {
        int iF;
        TimeInterpolator timeInterpolatorG;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(B(z11 ? this.f37544r : this.f37542q, z11 ? 0.0f : 1.0f), z11 ? 1.0f : 0.0f);
        if (z11) {
            iF = j.f(getContext(), f37509y0, 83);
            timeInterpolatorG = j.g(getContext(), A0, ii.b.f67205e);
        } else {
            iF = j.f(getContext(), f37510z0, 117);
            timeInterpolatorG = j.g(getContext(), B0, ii.b.f67203c);
        }
        valueAnimatorOfFloat.setDuration(iF);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorG);
        valueAnimatorOfFloat.addUpdateListener(new a());
        return valueAnimatorOfFloat;
    }

    public final void n0() {
        if (h0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iX = (int) ((X(this.T.get(this.V).floatValue()) * this.f37519e0) + this.E);
            int iM = m();
            int i11 = this.H;
            d3.a.l(background, iX - i11, iM - i11, iX + i11, iM + i11);
        }
    }

    public final void o() {
        if (this.f37534m.size() > this.T.size()) {
            List<aj.a> listSubList = this.f37534m.subList(this.T.size(), this.f37534m.size());
            for (aj.a aVar : listSubList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    p(aVar);
                }
            }
            listSubList.clear();
        }
        while (true) {
            if (this.f37534m.size() >= this.T.size()) {
                break;
            }
            aj.a aVarW0 = aj.a.w0(getContext(), null, 0, this.f37532l);
            this.f37534m.add(aVarW0);
            if (ViewCompat.isAttachedToWindow(this)) {
                i(aVarW0);
            }
        }
        int i11 = this.f37534m.size() != 1 ? 1 : 0;
        Iterator<aj.a> it = this.f37534m.iterator();
        while (it.hasNext()) {
            it.next().o0(i11);
        }
    }

    public final void o0() {
        int i11 = this.C;
        if (i11 == 0 || i11 == 1) {
            if (this.U == -1 || !isEnabled()) {
                y();
                return;
            } else {
                x();
                return;
            }
        }
        if (i11 == 2) {
            y();
            return;
        }
        if (i11 != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.C);
        }
        if (isEnabled() && N()) {
            x();
        } else {
            y();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f37553v0);
        Iterator<aj.a> it = this.f37534m.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.f37530k;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.f37540p = false;
        Iterator<aj.a> it = this.f37534m.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.f37553v0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.f37525h0) {
            s0();
            P();
        }
        super.onDraw(canvas);
        int iM = m();
        float fFloatValue = this.T.get(0).floatValue();
        ArrayList<Float> arrayList = this.T;
        float fFloatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (fFloatValue2 < this.S || (this.T.size() > 1 && fFloatValue > this.R)) {
            u(canvas, this.f37519e0, iM);
        }
        if (fFloatValue2 > this.R) {
            t(canvas, this.f37519e0, iM);
        }
        S(canvas);
        R(canvas, iM);
        if ((this.Q || isFocused()) && isEnabled()) {
            Q(canvas, this.f37519e0, iM);
        }
        o0();
        w(canvas, this.f37519e0, iM);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z11, int i11, @Nullable Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        if (z11) {
            z(i11);
            this.f37526i.I(this.V);
        } else {
            this.U = -1;
            this.f37526i.b(this.V);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.T.size() == 1) {
            this.U = 0;
        }
        if (this.U == -1) {
            Boolean boolY = Y(i11, keyEvent);
            return boolY != null ? boolY.booleanValue() : super.onKeyDown(i11, keyEvent);
        }
        this.f37523g0 |= keyEvent.isLongPress();
        Float fJ = j(i11);
        if (fJ != null) {
            if (i0(this.T.get(this.U).floatValue() + fJ.floatValue())) {
                n0();
                postInvalidate();
            }
            return true;
        }
        if (i11 != 23) {
            if (i11 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return V(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return V(-1);
                }
                return false;
            }
            if (i11 != 66) {
                return super.onKeyDown(i11, keyEvent);
            }
        }
        this.U = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, @NonNull KeyEvent keyEvent) {
        this.f37523g0 = false;
        return super.onKeyUp(i11, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(this.B + ((this.C == 1 || g0()) ? this.f37534m.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.R = sliderState.f37558a;
        this.S = sliderState.f37559b;
        setValuesInternal(sliderState.f37560c);
        this.W = sliderState.f37561d;
        if (sliderState.f37562f) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f37558a = this.R;
        sliderState.f37559b = this.S;
        sliderState.f37560c = new ArrayList<>(this.T);
        sliderState.f37561d = this.W;
        sliderState.f37562f = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        q0(i11);
        n0();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5  */
    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int i11;
        if (!isEnabled()) {
            return false;
        }
        float x11 = motionEvent.getX();
        float f11 = (x11 - this.E) / this.f37519e0;
        this.f37549t0 = f11;
        float fMax = Math.max(0.0f, f11);
        this.f37549t0 = fMax;
        this.f37549t0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.O = x11;
            if (!L(motionEvent)) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (b0()) {
                    requestFocus();
                    this.Q = true;
                    l0();
                    n0();
                    if (F()) {
                        int i12 = this.F;
                        this.J = i12;
                        this.K = this.I;
                        int iRound = Math.round(i12 * 0.5f);
                        int i13 = this.F - iRound;
                        setThumbWidth(iRound);
                        setThumbTrackGapSize(this.I - (i13 / 2));
                    }
                    invalidate();
                    Z();
                }
            }
        } else if (actionMasked == 1) {
            this.Q = false;
            motionEvent2 = this.P;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.P.getX() - motionEvent.getX()) <= this.f37546s && Math.abs(this.P.getY() - motionEvent.getY()) <= this.f37546s && b0()) {
                Z();
            }
            if (this.U != -1) {
                l0();
                n0();
                if (F() && (i11 = this.J) != -1 && this.K != -1) {
                    setThumbWidth(i11);
                    setThumbTrackGapSize(this.K);
                }
                this.U = -1;
                a0();
            }
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.Q) {
                if (L(motionEvent) && Math.abs(x11 - this.O) < this.f37546s) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                Z();
            }
            if (b0()) {
                this.Q = true;
                l0();
                n0();
                invalidate();
            }
        } else if (actionMasked == 3) {
            this.Q = false;
            motionEvent2 = this.P;
            if (motionEvent2 != null) {
                Z();
            }
            if (this.U != -1) {
                l0();
                n0();
                if (F()) {
                    setThumbWidth(i11);
                    setThumbTrackGapSize(this.K);
                }
                this.U = -1;
                a0();
            }
            invalidate();
        }
        setPressed(this.Q);
        this.P = MotionEvent.obtain(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        d0 d0VarK;
        super.onVisibilityChanged(view, i11);
        if (i11 == 0 || (d0VarK = f0.k(this)) == null) {
            return;
        }
        Iterator<aj.a> it = this.f37534m.iterator();
        while (it.hasNext()) {
            d0VarK.b(it.next());
        }
    }

    public final void p(aj.a aVar) {
        d0 d0VarK = f0.k(this);
        if (d0VarK != null) {
            d0VarK.b(aVar);
            aVar.y0(f0.j(this));
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    /* JADX WARN: Code duplicated, block: B:14:0x0053  */
    /* JADX WARN: Code duplicated, block: B:16:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0074  */
    /* JADX WARN: Code duplicated, block: B:18:0x0088  */
    /* JADX WARN: Code duplicated, block: B:19:0x0098  */
    public final void p0(Canvas canvas, Paint paint, RectF rectF, FullCornerDirection fullCornerDirection) {
        int i11;
        float fMax;
        int i12;
        int i13 = this.D;
        float f11 = i13 / 2.0f;
        float f12 = i13 / 2.0f;
        int[] iArr = c.f37565a;
        int i14 = iArr[fullCornerDirection.ordinal()];
        if (i14 != 1) {
            if (i14 == 2) {
                i11 = this.M;
            } else if (i14 == 3) {
                f11 = this.M;
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            this.f37537n0.reset();
            if (rectF.width() >= f11 + f12) {
                this.f37537n0.addRoundRect(rectF, E(f11, f12), Path.Direction.CW);
                canvas.drawPath(this.f37537n0, paint);
                return;
            }
            float fMin = Math.min(f11, f12);
            fMax = Math.max(f11, f12);
            canvas.save();
            this.f37537n0.addRoundRect(rectF, fMin, fMin, Path.Direction.CW);
            canvas.clipPath(this.f37537n0);
            i12 = iArr[fullCornerDirection.ordinal()];
            if (i12 != 2) {
                RectF rectF2 = this.f37541p0;
                float f13 = rectF.left;
                rectF2.set(f13, rectF.top, (2.0f * fMax) + f13, rectF.bottom);
            } else if (i12 != 3) {
                this.f37541p0.set(rectF.centerX() - fMax, rectF.top, rectF.centerX() + fMax, rectF.bottom);
            } else {
                RectF rectF3 = this.f37541p0;
                float f14 = rectF.right;
                rectF3.set(f14 - (2.0f * fMax), rectF.top, f14, rectF.bottom);
            }
            canvas.drawRoundRect(this.f37541p0, fMax, fMax, paint);
            canvas.restore();
        }
        i11 = this.M;
        f11 = i11;
        f12 = i11;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        this.f37537n0.reset();
        if (rectF.width() >= f11 + f12) {
            this.f37537n0.addRoundRect(rectF, E(f11, f12), Path.Direction.CW);
            canvas.drawPath(this.f37537n0, paint);
            return;
        }
        float fMin2 = Math.min(f11, f12);
        fMax = Math.max(f11, f12);
        canvas.save();
        this.f37537n0.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CW);
        canvas.clipPath(this.f37537n0);
        i12 = iArr[fullCornerDirection.ordinal()];
        if (i12 != 2) {
            RectF rectF4 = this.f37541p0;
            float f15 = rectF.left;
            rectF4.set(f15, rectF.top, (2.0f * fMax) + f15, rectF.bottom);
        } else if (i12 != 3) {
            this.f37541p0.set(rectF.centerX() - fMax, rectF.top, rectF.centerX() + fMax, rectF.bottom);
        } else {
            RectF rectF5 = this.f37541p0;
            float f16 = rectF.right;
            rectF5.set(f16 - (2.0f * fMax), rectF.top, f16, rectF.bottom);
        }
        canvas.drawRoundRect(this.f37541p0, fMax, fMax, paint);
        canvas.restore();
    }

    public final float q(float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        float f12 = (f11 - this.E) / this.f37519e0;
        float f13 = this.R;
        return (f12 * (f13 - this.S)) + f13;
    }

    public final void q0(int i11) {
        this.f37519e0 = Math.max(i11 - (this.E * 2), 0);
        P();
    }

    public final void r(int i11) {
        Iterator<L> it = this.f37536n.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.T.get(i11).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f37528j;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        e0(i11);
    }

    public final void r0() {
        boolean zU = U();
        boolean zT = T();
        if (zU) {
            requestLayout();
        } else if (zT) {
            postInvalidate();
        }
    }

    public void removeOnChangeListener(@NonNull L l11) {
        this.f37536n.remove(l11);
    }

    public void removeOnSliderTouchListener(@NonNull T t11) {
        this.f37538o.remove(t11);
    }

    public final void s() {
        for (L l11 : this.f37536n) {
            Iterator<Float> it = this.T.iterator();
            while (it.hasNext()) {
                l11.a(this, it.next().floatValue(), false);
            }
        }
    }

    public final void s0() {
        if (this.f37525h0) {
            v0();
            w0();
            u0();
            x0();
            t0();
            A0();
            this.f37525h0 = false;
        }
    }

    public void setActiveThumbIndex(int i11) {
        this.U = i11;
    }

    public void setCustomThumbDrawable(int i11) {
        setCustomThumbDrawable(getResources().getDrawable(i11));
    }

    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        this.f37545r0 = G(drawable);
        this.f37547s0.clear();
        postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(@NonNull int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            drawableArr[i11] = getResources().getDrawable(iArr[i11]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.f37545r0 = null;
        this.f37547s0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.f37547s0.add(G(drawable));
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        setLayerType(z11 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i11) {
        if (i11 < 0 || i11 >= this.T.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.V = i11;
        this.f37526i.I(i11);
        postInvalidate();
    }

    public void setHaloRadius(int i11) {
        if (i11 == this.H) {
            return;
        }
        this.H = i11;
        Drawable background = getBackground();
        if (h0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            f.m((RippleDrawable) background, this.H);
        }
    }

    public void setHaloRadiusResource(int i11) {
        setHaloRadius(getResources().getDimensionPixelSize(i11));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f37527i0)) {
            return;
        }
        this.f37527i0 = colorStateList;
        Drawable background = getBackground();
        if (!h0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f37517d.setColor(D(colorStateList));
        this.f37517d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i11) {
        if (this.C != i11) {
            this.C = i11;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable com.google.android.material.slider.d dVar) {
    }

    public void setSeparationUnit(int i11) {
        this.f37551u0 = i11;
        this.f37525h0 = true;
        postInvalidate();
    }

    public void setStepSize(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f11), Float.valueOf(this.R), Float.valueOf(this.S)));
        }
        if (this.W != f11) {
            this.W = f11;
            this.f37525h0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f11) {
        this.f37543q0.c0(f11);
    }

    public void setThumbElevationResource(int i11) {
        setThumbElevation(getResources().getDimension(i11));
    }

    public void setThumbHeight(int i11) {
        if (i11 == this.G) {
            return;
        }
        this.G = i11;
        this.f37543q0.setBounds(0, 0, this.F, i11);
        Drawable drawable = this.f37545r0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator<Drawable> it = this.f37547s0.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
        r0();
    }

    public void setThumbHeightResource(int i11) {
        setThumbHeight(getResources().getDimensionPixelSize(i11));
    }

    public void setThumbRadius(int i11) {
        int i12 = i11 * 2;
        setThumbWidth(i12);
        setThumbHeight(i12);
    }

    public void setThumbRadiusResource(int i11) {
        setThumbRadius(getResources().getDimensionPixelSize(i11));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f37543q0.n0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i11) {
        if (i11 != 0) {
            setThumbStrokeColor(d1.a.a(getContext(), i11));
        }
    }

    public void setThumbStrokeWidth(float f11) {
        this.f37543q0.o0(f11);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i11) {
        if (i11 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i11));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f37543q0.z())) {
            return;
        }
        this.f37543q0.d0(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(int i11) {
        if (this.I == i11) {
            return;
        }
        this.I = i11;
        invalidate();
    }

    public void setThumbWidth(int i11) {
        if (i11 == this.F) {
            return;
        }
        this.F = i11;
        this.f37543q0.setShapeAppearanceModel(n.a().q(0, this.F / 2.0f).m());
        this.f37543q0.setBounds(0, 0, this.F, this.G);
        Drawable drawable = this.f37545r0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator<Drawable> it = this.f37547s0.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
        r0();
    }

    public void setThumbWidthResource(int i11) {
        setThumbWidth(getResources().getDimensionPixelSize(i11));
    }

    public void setTickActiveRadius(int i11) {
        if (this.f37516c0 != i11) {
            this.f37516c0 = i11;
            this.f37522g.setStrokeWidth(i11 * 2);
            r0();
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f37529j0)) {
            return;
        }
        this.f37529j0 = colorStateList;
        this.f37522g.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i11) {
        if (this.f37518d0 != i11) {
            this.f37518d0 = i11;
            this.f37520f.setStrokeWidth(i11 * 2);
            r0();
        }
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f37531k0)) {
            return;
        }
        this.f37531k0 = colorStateList;
        this.f37520f.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z11) {
        if (this.f37514b0 != z11) {
            this.f37514b0 = z11;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f37533l0)) {
            return;
        }
        this.f37533l0 = colorStateList;
        this.f37513b.setColor(D(colorStateList));
        this.f37524h.setColor(D(this.f37533l0));
        invalidate();
    }

    public void setTrackHeight(int i11) {
        if (this.D != i11) {
            this.D = i11;
            H();
            r0();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f37535m0)) {
            return;
        }
        this.f37535m0 = colorStateList;
        this.f37511a.setColor(D(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i11) {
        if (this.M == i11) {
            return;
        }
        this.M = i11;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i11) {
        if (this.L == i11) {
            return;
        }
        this.L = i11;
        this.f37524h.setStrokeWidth(i11);
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f11) {
        this.R = f11;
        this.f37525h0 = true;
        postInvalidate();
    }

    public void setValueTo(float f11) {
        this.S = f11;
        this.f37525h0 = true;
        postInvalidate();
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b7 A[SYNTHETIC] */
    public final void t(@NonNull Canvas canvas, int i11, int i12) {
        int i13;
        float[] activeRange = getActiveRange();
        int i14 = this.E;
        float f11 = i11;
        float f12 = i14 + (activeRange[1] * f11);
        float fZ0 = i14 + (activeRange[0] * f11);
        if (!F()) {
            this.f37513b.setStyle(Paint.Style.STROKE);
            this.f37513b.setStrokeCap(Paint.Cap.ROUND);
            float f13 = i12;
            canvas.drawLine(fZ0, f13, f12, f13, this.f37513b);
            return;
        }
        FullCornerDirection fullCornerDirection = FullCornerDirection.NONE;
        if (this.T.size() == 1) {
            fullCornerDirection = M() ? FullCornerDirection.RIGHT : FullCornerDirection.LEFT;
        }
        for (int i15 = 0; i15 < this.T.size(); i15++) {
            if (this.T.size() > 1) {
                if (i15 > 0) {
                    fZ0 = z0(this.T.get(i15 - 1).floatValue());
                }
                float fZ1 = z0(this.T.get(i15).floatValue());
                if (M()) {
                    f12 = fZ0;
                    fZ0 = fZ1;
                } else {
                    f12 = fZ1;
                }
            }
            int i16 = c.f37565a[fullCornerDirection.ordinal()];
            if (i16 != 1) {
                if (i16 == 2) {
                    fZ0 -= this.D / 2.0f;
                    i13 = this.I;
                } else if (i16 == 3) {
                    fZ0 += this.I;
                    f12 += this.D / 2.0f;
                }
                if (fZ0 >= f12) {
                    RectF rectF = this.f37539o0;
                    float f14 = i12;
                    int i17 = this.D;
                    rectF.set(fZ0, f14 - (i17 / 2.0f), f12, f14 + (i17 / 2.0f));
                    p0(canvas, this.f37513b, this.f37539o0, fullCornerDirection);
                }
            } else {
                i13 = this.I;
                fZ0 += i13;
            }
            f12 -= i13;
            if (fZ0 >= f12) {
                RectF rectF2 = this.f37539o0;
                float f15 = i12;
                int i18 = this.D;
                rectF2.set(fZ0, f15 - (i18 / 2.0f), f12, f15 + (i18 / 2.0f));
                p0(canvas, this.f37513b, this.f37539o0, fullCornerDirection);
            }
        }
    }

    public final void t0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
        }
        float f11 = this.W;
        if (f11 <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.f37551u0 != 1) {
            throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.W)));
        }
        if (minSeparation < f11 || !K(minSeparation)) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.W), Float.valueOf(this.W)));
        }
    }

    public final void u(@NonNull Canvas canvas, int i11, int i12) {
        float[] activeRange = getActiveRange();
        int i13 = this.E;
        float f11 = i11;
        float f12 = i13 + (activeRange[1] * f11);
        if (f12 < i13 + i11) {
            if (F()) {
                RectF rectF = this.f37539o0;
                float f13 = f12 + this.I;
                float f14 = i12;
                int i14 = this.D;
                rectF.set(f13, f14 - (i14 / 2.0f), this.E + i11 + (i14 / 2.0f), f14 + (i14 / 2.0f));
                p0(canvas, this.f37511a, this.f37539o0, FullCornerDirection.RIGHT);
            } else {
                this.f37511a.setStyle(Paint.Style.STROKE);
                this.f37511a.setStrokeCap(Paint.Cap.ROUND);
                float f15 = i12;
                canvas.drawLine(f12, f15, this.E + i11, f15, this.f37511a);
            }
        }
        int i15 = this.E;
        float f16 = i15 + (activeRange[0] * f11);
        if (f16 > i15) {
            if (!F()) {
                this.f37511a.setStyle(Paint.Style.STROKE);
                this.f37511a.setStrokeCap(Paint.Cap.ROUND);
                float f17 = i12;
                canvas.drawLine(this.E, f17, f16, f17, this.f37511a);
                return;
            }
            RectF rectF2 = this.f37539o0;
            float f18 = this.E;
            int i16 = this.D;
            float f19 = i12;
            rectF2.set(f18 - (i16 / 2.0f), f19 - (i16 / 2.0f), f16 - this.I, f19 + (i16 / 2.0f));
            p0(canvas, this.f37511a, this.f37539o0, FullCornerDirection.LEFT);
        }
    }

    public final void u0() {
        if (this.W > 0.0f && !y0(this.S)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.W), Float.valueOf(this.R), Float.valueOf(this.S)));
        }
    }

    public final void v(@NonNull Canvas canvas, int i11, int i12, float f11, @NonNull Drawable drawable) {
        canvas.save();
        canvas.translate((this.E + ((int) (X(f11) * i11))) - (drawable.getBounds().width() / 2.0f), i12 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void v0() {
        if (this.R >= this.S) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.R), Float.valueOf(this.S)));
        }
    }

    public final void w(@NonNull Canvas canvas, int i11, int i12) {
        for (int i13 = 0; i13 < this.T.size(); i13++) {
            float fFloatValue = this.T.get(i13).floatValue();
            Drawable drawable = this.f37545r0;
            if (drawable != null) {
                v(canvas, i11, i12, fFloatValue, drawable);
            } else if (i13 < this.f37547s0.size()) {
                v(canvas, i11, i12, fFloatValue, this.f37547s0.get(i13));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.E + (X(fFloatValue) * i11), i12, getThumbRadius(), this.f37515c);
                }
                v(canvas, i11, i12, fFloatValue, this.f37543q0);
            }
        }
    }

    public final void w0() {
        if (this.S <= this.R) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.S), Float.valueOf(this.R)));
        }
    }

    public final void x() {
        if (!this.f37540p) {
            this.f37540p = true;
            ValueAnimator valueAnimatorN = n(true);
            this.f37542q = valueAnimatorN;
            this.f37544r = null;
            valueAnimatorN.start();
        }
        Iterator<aj.a> it = this.f37534m.iterator();
        for (int i11 = 0; i11 < this.T.size() && it.hasNext(); i11++) {
            if (i11 != this.V) {
                f0(it.next(), this.T.get(i11).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f37534m.size()), Integer.valueOf(this.T.size())));
        }
        f0(it.next(), this.T.get(this.V).floatValue());
    }

    public final void x0() {
        for (Float f11 : this.T) {
            if (f11.floatValue() < this.R || f11.floatValue() > this.S) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", f11, Float.valueOf(this.R), Float.valueOf(this.S)));
            }
            if (this.W > 0.0f && !y0(f11.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", f11, Float.valueOf(this.R), Float.valueOf(this.W), Float.valueOf(this.W)));
            }
        }
    }

    public final void y() {
        if (this.f37540p) {
            this.f37540p = false;
            ValueAnimator valueAnimatorN = n(false);
            this.f37544r = valueAnimatorN;
            this.f37542q = null;
            valueAnimatorN.addListener(new b());
            this.f37544r.start();
        }
    }

    public final boolean y0(float f11) {
        return K(new BigDecimal(Float.toString(f11)).subtract(new BigDecimal(Float.toString(this.R)), MathContext.DECIMAL64).doubleValue());
    }

    public final void z(int i11) {
        if (i11 == 1) {
            V(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            return;
        }
        if (i11 == 2) {
            V(Integer.MIN_VALUE);
        } else if (i11 == 17) {
            W(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            if (i11 != 66) {
                return;
            }
            W(Integer.MIN_VALUE);
        }
    }

    public final float z0(float f11) {
        return (X(f11) * this.f37519e0) + this.E;
    }
}
