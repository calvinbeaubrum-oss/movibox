package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.n0;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.CheckableImageButton;
import com.vungle.warren.error.VungleException;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    public static final int D0 = R$style.Widget_Design_TextInputLayout;
    public static final int[][] E0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;

    @Nullable
    public ColorStateList A;
    public boolean A0;

    @Nullable
    public ColorStateList B;
    public boolean B0;

    @Nullable
    public ColorStateList C;
    public boolean C0;
    public boolean D;
    public CharSequence E;
    public boolean F;

    @Nullable
    public yi.i G;
    public yi.i H;
    public StateListDrawable I;
    public boolean J;

    @Nullable
    public yi.i K;

    @Nullable
    public yi.i L;

    @NonNull
    public yi.n M;
    public boolean N;
    public final int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public final Rect W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37678a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Rect f37679a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final y f37680b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final RectF f37681b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final r f37682c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Typeface f37683c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f37684d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @Nullable
    public Drawable f37685d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f37686e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f37687f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final LinkedHashSet<e> f37688f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f37689g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @Nullable
    public Drawable f37690g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37691h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f37692h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f37693i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Drawable f37694i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37695j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public ColorStateList f37696j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f37697k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public ColorStateList f37698k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37699l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f37700l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f37701m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f37702m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f37703n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f37704n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public d f37705o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public ColorStateList f37706o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public TextView f37707p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f37708p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f37709q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f37710q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f37711r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f37712r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f37713s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f37714s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f37715t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f37716t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f37717u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f37718u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public ColorStateList f37719v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f37720v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37721w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final com.google.android.material.internal.b f37722w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public k6.c f37723x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f37724x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public k6.c f37725y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f37726y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public ColorStateList f37727z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ValueAnimator f37728z0;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f37729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37730b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f37729a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f37730b = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f37729a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            TextUtils.writeToParcel(this.f37729a, parcel, i11);
            parcel.writeInt(this.f37730b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f37732b;

        public a(EditText editText) {
            this.f37732b = editText;
            this.f37731a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.o0(!textInputLayout.B0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f37699l) {
                textInputLayout2.e0(editable);
            }
            if (TextInputLayout.this.f37715t) {
                TextInputLayout.this.s0(editable);
            }
            int lineCount = this.f37732b.getLineCount();
            int i11 = this.f37731a;
            if (lineCount != i11) {
                if (lineCount < i11) {
                    int minimumHeight = ViewCompat.getMinimumHeight(this.f37732b);
                    int i12 = TextInputLayout.this.f37718u0;
                    if (minimumHeight != i12) {
                        this.f37732b.setMinimumHeight(i12);
                    }
                }
                this.f37731a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.f37722w0.z0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextInputLayout f37735a;

        public c(@NonNull TextInputLayout textInputLayout) {
            this.f37735a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f37735a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f37735a.getHint();
            CharSequence error = this.f37735a.getError();
            CharSequence placeholderText = this.f37735a.getPlaceholderText();
            int counterMaxLength = this.f37735a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f37735a.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean z11 = !zIsEmpty;
            boolean z12 = true;
            boolean z13 = !TextUtils.isEmpty(hint);
            boolean z14 = !this.f37735a.L();
            boolean z15 = !TextUtils.isEmpty(error);
            if (!z15 && TextUtils.isEmpty(counterOverflowDescription)) {
                z12 = false;
            }
            String string = z13 ? hint.toString() : "";
            this.f37735a.f37680b.B(accessibilityNodeInfoCompat);
            if (z11) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.setText(string);
                if (z14 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(string);
                } else {
                    if (z11) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.setText(string);
                }
                accessibilityNodeInfoCompat.setShowingHintText(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z12) {
                if (!z15) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            View viewT = this.f37735a.f37697k.t();
            if (viewT != null) {
                accessibilityNodeInfoCompat.setLabelFor(viewT);
            }
            this.f37735a.f37682c.o().o(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f37735a.f37682c.o().p(view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        int a(@Nullable Editable editable);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(@NonNull TextInputLayout textInputLayout, int i11);
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = D0;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f37689g = -1;
        this.f37691h = -1;
        this.f37693i = -1;
        this.f37695j = -1;
        this.f37697k = new u(this);
        this.f37705o = new d() { // from class: com.google.android.material.textfield.i0
            @Override // com.google.android.material.textfield.TextInputLayout.d
            public final int a(Editable editable) {
                return TextInputLayout.O(editable);
            }
        };
        this.W = new Rect();
        this.f37679a0 = new Rect();
        this.f37681b0 = new RectF();
        this.f37688f0 = new LinkedHashSet<>();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f37722w0 = bVar;
        this.C0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f37678a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = ii.b.f67201a;
        bVar.M0(timeInterpolator);
        bVar.H0(timeInterpolator);
        bVar.k0(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        n0 n0VarJ = com.google.android.material.internal.b0.j(context2, attributeSet, R$styleable.TextInputLayout, i11, i12, R$styleable.TextInputLayout_counterTextAppearance, R$styleable.TextInputLayout_counterOverflowTextAppearance, R$styleable.TextInputLayout_errorTextAppearance, R$styleable.TextInputLayout_helperTextTextAppearance, R$styleable.TextInputLayout_hintTextAppearance);
        y yVar = new y(this, n0VarJ);
        this.f37680b = yVar;
        this.D = n0VarJ.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(n0VarJ.p(R$styleable.TextInputLayout_android_hint));
        this.f37726y0 = n0VarJ.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f37724x0 = n0VarJ.a(R$styleable.TextInputLayout_expandedHintEnabled, true);
        if (n0VarJ.s(R$styleable.TextInputLayout_android_minEms)) {
            setMinEms(n0VarJ.k(R$styleable.TextInputLayout_android_minEms, -1));
        } else if (n0VarJ.s(R$styleable.TextInputLayout_android_minWidth)) {
            setMinWidth(n0VarJ.f(R$styleable.TextInputLayout_android_minWidth, -1));
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_android_maxEms)) {
            setMaxEms(n0VarJ.k(R$styleable.TextInputLayout_android_maxEms, -1));
        } else if (n0VarJ.s(R$styleable.TextInputLayout_android_maxWidth)) {
            setMaxWidth(n0VarJ.f(R$styleable.TextInputLayout_android_maxWidth, -1));
        }
        this.M = yi.n.e(context2, attributeSet, i11, i12).m();
        this.O = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.Q = n0VarJ.e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.S = n0VarJ.f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.T = n0VarJ.f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.R = this.S;
        float fD = n0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = n0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = n0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = n0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        yi.n.b bVarV = this.M.v();
        if (fD >= 0.0f) {
            bVarV.H(fD);
        }
        if (fD2 >= 0.0f) {
            bVarV.M(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarV.B(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarV.w(fD4);
        }
        this.M = bVarV.m();
        ColorStateList colorStateListB = vi.d.b(context2, n0VarJ, R$styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f37708p0 = defaultColor;
            this.V = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f37710q0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f37712r0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f37714s0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f37712r0 = this.f37708p0;
                ColorStateList colorStateListA = d1.a.a(context2, R$color.mtrl_filled_background_color);
                this.f37710q0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f37714s0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.V = 0;
            this.f37708p0 = 0;
            this.f37710q0 = 0;
            this.f37712r0 = 0;
            this.f37714s0 = 0;
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListC = n0VarJ.c(R$styleable.TextInputLayout_android_textColorHint);
            this.f37698k0 = colorStateListC;
            this.f37696j0 = colorStateListC;
        }
        ColorStateList colorStateListB2 = vi.d.b(context2, n0VarJ, R$styleable.TextInputLayout_boxStrokeColor);
        this.f37704n0 = n0VarJ.b(R$styleable.TextInputLayout_boxStrokeColor, 0);
        this.f37700l0 = z2.a.getColor(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.f37716t0 = z2.a.getColor(context2, R$color.mtrl_textinput_disabled_color);
        this.f37702m0 = z2.a.getColor(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(vi.d.b(context2, n0VarJ, R$styleable.TextInputLayout_boxStrokeErrorColor));
        }
        if (n0VarJ.n(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(n0VarJ.n(R$styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.B = n0VarJ.c(R$styleable.TextInputLayout_cursorColor);
        this.C = n0VarJ.c(R$styleable.TextInputLayout_cursorErrorColor);
        int iN = n0VarJ.n(R$styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence charSequenceP = n0VarJ.p(R$styleable.TextInputLayout_errorContentDescription);
        int iK = n0VarJ.k(R$styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean zA = n0VarJ.a(R$styleable.TextInputLayout_errorEnabled, false);
        int iN2 = n0VarJ.n(R$styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = n0VarJ.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceP2 = n0VarJ.p(R$styleable.TextInputLayout_helperText);
        int iN3 = n0VarJ.n(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceP3 = n0VarJ.p(R$styleable.TextInputLayout_placeholderText);
        boolean zA3 = n0VarJ.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(n0VarJ.k(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.f37711r = n0VarJ.n(R$styleable.TextInputLayout_counterTextAppearance, 0);
        this.f37709q = n0VarJ.n(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(n0VarJ.k(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.f37709q);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f37711r);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        if (n0VarJ.s(R$styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(n0VarJ.c(R$styleable.TextInputLayout_errorTextColor));
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(n0VarJ.c(R$styleable.TextInputLayout_helperTextTextColor));
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(n0VarJ.c(R$styleable.TextInputLayout_hintTextColor));
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(n0VarJ.c(R$styleable.TextInputLayout_counterTextColor));
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(n0VarJ.c(R$styleable.TextInputLayout_counterOverflowTextColor));
        }
        if (n0VarJ.s(R$styleable.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(n0VarJ.c(R$styleable.TextInputLayout_placeholderTextColor));
        }
        r rVar = new r(this, n0VarJ);
        this.f37682c = rVar;
        boolean zA4 = n0VarJ.a(R$styleable.TextInputLayout_android_enabled, true);
        n0VarJ.x();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
        frameLayout.addView(yVar);
        frameLayout.addView(rVar);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
    }

    public static Drawable G(yi.i iVar, int i11, int i12, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{com.google.android.material.color.b.k(i12, i11, 0.1f), i11}), iVar, iVar);
    }

    public static Drawable J(Context context, yi.i iVar, int i11, int[][] iArr) {
        int iC = com.google.android.material.color.b.c(context, R$attr.colorSurface, "TextInputLayout");
        yi.i iVar2 = new yi.i(iVar.G());
        int iK = com.google.android.material.color.b.k(i11, iC, 0.1f);
        iVar2.d0(new ColorStateList(iArr, new int[]{iK, 0}));
        iVar2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iK, iC});
        yi.i iVar3 = new yi.i(iVar.G());
        iVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar2, iVar3), iVar});
    }

    public static /* synthetic */ int O(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    public static void T(@NonNull ViewGroup viewGroup, boolean z11) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            childAt.setEnabled(z11);
            if (childAt instanceof ViewGroup) {
                T((ViewGroup) childAt, z11);
            }
        }
    }

    public static void f0(@NonNull Context context, @NonNull TextView textView, int i11, int i12, boolean z11) {
        textView.setContentDescription(context.getString(z11 ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i11), Integer.valueOf(i12)));
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f37684d;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.G;
        }
        int iD = com.google.android.material.color.b.d(this.f37684d, R$attr.colorControlHighlight);
        int i11 = this.P;
        if (i11 == 2) {
            return J(getContext(), this.G, iD, E0);
        }
        if (i11 == 1) {
            return G(this.G, this.V, iD, E0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.I.addState(new int[0], F(false));
        }
        return this.I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.H == null) {
            this.H = F(true);
        }
        return this.H;
    }

    private void setEditText(EditText editText) {
        if (this.f37684d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3) {
            boolean z11 = editText instanceof TextInputEditText;
        }
        this.f37684d = editText;
        int i11 = this.f37689g;
        if (i11 != -1) {
            setMinEms(i11);
        } else {
            setMinWidth(this.f37693i);
        }
        int i12 = this.f37691h;
        if (i12 != -1) {
            setMaxEms(i12);
        } else {
            setMaxWidth(this.f37695j);
        }
        this.J = false;
        Q();
        setTextInputAccessibilityDelegate(new c(this));
        this.f37722w0.O0(this.f37684d.getTypeface());
        this.f37722w0.w0(this.f37684d.getTextSize());
        int i13 = Build.VERSION.SDK_INT;
        this.f37722w0.r0(this.f37684d.getLetterSpacing());
        int gravity = this.f37684d.getGravity();
        this.f37722w0.k0((gravity & (-113)) | 48);
        this.f37722w0.v0(gravity);
        this.f37718u0 = ViewCompat.getMinimumHeight(editText);
        this.f37684d.addTextChangedListener(new a(editText));
        if (this.f37696j0 == null) {
            this.f37696j0 = this.f37684d.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.f37684d.getHint();
                this.f37687f = hint;
                setHint(hint);
                this.f37684d.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (i13 >= 29) {
            h0();
        }
        if (this.f37707p != null) {
            e0(this.f37684d.getText());
        }
        j0();
        this.f37697k.f();
        this.f37680b.bringToFront();
        this.f37682c.bringToFront();
        B();
        this.f37682c.D0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        p0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        this.f37722w0.L0(charSequence);
        if (this.f37720v0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z11) {
        if (this.f37715t == z11) {
            return;
        }
        if (z11) {
            i();
        } else {
            U();
            this.f37717u = null;
        }
        this.f37715t = z11;
    }

    public final boolean A() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof h);
    }

    public final void B() {
        Iterator<e> it = this.f37688f0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void C(Canvas canvas) {
        yi.i iVar;
        if (this.L == null || (iVar = this.K) == null) {
            return;
        }
        iVar.draw(canvas);
        if (this.f37684d.isFocused()) {
            Rect bounds = this.L.getBounds();
            Rect bounds2 = this.K.getBounds();
            float F = this.f37722w0.F();
            int iCenterX = bounds2.centerX();
            bounds.left = ii.b.c(iCenterX, bounds2.left, F);
            bounds.right = ii.b.c(iCenterX, bounds2.right, F);
            this.L.draw(canvas);
        }
    }

    public final void D(@NonNull Canvas canvas) {
        if (this.D) {
            this.f37722w0.l(canvas);
        }
    }

    public final void E(boolean z11) {
        ValueAnimator valueAnimator = this.f37728z0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f37728z0.cancel();
        }
        if (z11 && this.f37726y0) {
            k(0.0f);
        } else {
            this.f37722w0.z0(0.0f);
        }
        if (A() && ((h) this.G).v0()) {
            x();
        }
        this.f37720v0 = true;
        K();
        this.f37680b.m(true);
        this.f37682c.L(true);
    }

    public final yi.i F(boolean z11) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float f11 = z11 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f37684d;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R$dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        yi.n nVarM = yi.n.a().H(f11).M(f11).w(dimensionPixelOffset).B(dimensionPixelOffset).m();
        EditText editText2 = this.f37684d;
        yi.i iVarO = yi.i.o(getContext(), popupElevation, editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null);
        iVarO.setShapeAppearanceModel(nVarM);
        iVarO.f0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return iVarO;
    }

    public final int H(int i11, boolean z11) {
        int compoundPaddingLeft;
        if (z11 || getPrefixText() == null) {
            compoundPaddingLeft = (!z11 || getSuffixText() == null) ? this.f37684d.getCompoundPaddingLeft() : this.f37682c.A();
        } else {
            compoundPaddingLeft = this.f37680b.c();
        }
        return i11 + compoundPaddingLeft;
    }

    public final int I(int i11, boolean z11) {
        int compoundPaddingRight;
        if (z11 || getSuffixText() == null) {
            compoundPaddingRight = (!z11 || getPrefixText() == null) ? this.f37684d.getCompoundPaddingRight() : this.f37680b.c();
        } else {
            compoundPaddingRight = this.f37682c.A();
        }
        return i11 - compoundPaddingRight;
    }

    public final void K() {
        TextView textView = this.f37717u;
        if (textView == null || !this.f37715t) {
            return;
        }
        textView.setText((CharSequence) null);
        k6.s.a(this.f37678a, this.f37725y);
        this.f37717u.setVisibility(4);
    }

    public final boolean L() {
        return this.f37720v0;
    }

    public final boolean M() {
        return X() || (this.f37707p != null && this.f37703n);
    }

    public final boolean N() {
        return this.P == 1 && this.f37684d.getMinLines() <= 1;
    }

    public final /* synthetic */ void P() {
        this.f37684d.requestLayout();
    }

    public final void Q() {
        o();
        l0();
        u0();
        b0();
        j();
        if (this.P != 0) {
            n0();
        }
        V();
    }

    public final void R() {
        if (A()) {
            RectF rectF = this.f37681b0;
            this.f37722w0.o(rectF, this.f37684d.getWidth(), this.f37684d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.R);
            ((h) this.G).y0(rectF);
        }
    }

    public final void S() {
        if (!A() || this.f37720v0) {
            return;
        }
        x();
        R();
    }

    public final void U() {
        TextView textView = this.f37717u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void V() {
        EditText editText = this.f37684d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i11 = this.P;
                if (i11 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i11 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public void W(@NonNull TextView textView, int i11) {
        try {
            androidx.core.widget.m.p(textView, i11);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.m.p(textView, R$style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(z2.a.getColor(getContext(), R$color.design_error));
    }

    public boolean X() {
        return this.f37697k.l();
    }

    public final boolean Y() {
        return (this.f37682c.J() || ((this.f37682c.C() && isEndIconVisible()) || this.f37682c.y() != null)) && this.f37682c.getMeasuredWidth() > 0;
    }

    public final boolean Z() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f37680b.getMeasuredWidth() > 0;
    }

    public final void a0() {
        if (this.f37717u == null || !this.f37715t || TextUtils.isEmpty(this.f37713s)) {
            return;
        }
        this.f37717u.setText(this.f37713s);
        k6.s.a(this.f37678a, this.f37723x);
        this.f37717u.setVisibility(0);
        this.f37717u.bringToFront();
        announceForAccessibility(this.f37713s);
    }

    public void addOnEditTextAttachedListener(@NonNull e eVar) {
        this.f37688f0.add(eVar);
        if (this.f37684d != null) {
            eVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull f fVar) {
        this.f37682c.g(fVar);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i11, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i11, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f37678a.addView(view, layoutParams2);
        this.f37678a.setLayoutParams(layoutParams);
        n0();
        setEditText((EditText) view);
    }

    public final void b0() {
        if (this.P == 1) {
            if (vi.d.k(getContext())) {
                this.Q = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (vi.d.j(getContext())) {
                this.Q = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    public final void c0(@NonNull Rect rect) {
        yi.i iVar = this.K;
        if (iVar != null) {
            int i11 = rect.bottom;
            iVar.setBounds(rect.left, i11 - this.S, rect.right, i11);
        }
        yi.i iVar2 = this.L;
        if (iVar2 != null) {
            int i12 = rect.bottom;
            iVar2.setBounds(rect.left, i12 - this.T, rect.right, i12);
        }
    }

    public void clearOnEditTextAttachedListeners() {
        this.f37688f0.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.f37682c.j();
    }

    public final void d0() {
        if (this.f37707p != null) {
            EditText editText = this.f37684d;
            e0(editText == null ? null : editText.getText());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i11) {
        EditText editText = this.f37684d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i11);
            return;
        }
        if (this.f37687f != null) {
            boolean z11 = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.f37684d.setHint(this.f37687f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i11);
                return;
            } finally {
                this.f37684d.setHint(hint);
                this.F = z11;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i11);
        onProvideAutofillVirtualStructure(viewStructure, i11);
        viewStructure.setChildCount(this.f37678a.getChildCount());
        for (int i12 = 0; i12 < this.f37678a.getChildCount(); i12++) {
            View childAt = this.f37678a.getChildAt(i12);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i12);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i11);
            if (childAt == this.f37684d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.B0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.A0) {
            return;
        }
        this.A0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.b bVar = this.f37722w0;
        boolean zJ0 = bVar != null ? bVar.J0(drawableState) : false;
        if (this.f37684d != null) {
            o0(ViewCompat.isLaidOut(this) && isEnabled());
        }
        j0();
        u0();
        if (zJ0) {
            invalidate();
        }
        this.A0 = false;
    }

    public void e0(@Nullable Editable editable) {
        int iA = this.f37705o.a(editable);
        boolean z11 = this.f37703n;
        int i11 = this.f37701m;
        if (i11 == -1) {
            this.f37707p.setText(String.valueOf(iA));
            this.f37707p.setContentDescription(null);
            this.f37703n = false;
        } else {
            this.f37703n = iA > i11;
            f0(getContext(), this.f37707p, iA, this.f37701m, this.f37703n);
            if (z11 != this.f37703n) {
                g0();
            }
            this.f37707p.setText(androidx.core.text.a.c().j(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(iA), Integer.valueOf(this.f37701m))));
        }
        if (this.f37684d == null || z11 == this.f37703n) {
            return;
        }
        o0(false);
        u0();
        j0();
    }

    public final void g0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f37707p;
        if (textView != null) {
            W(textView, this.f37703n ? this.f37709q : this.f37711r);
            if (!this.f37703n && (colorStateList2 = this.f37727z) != null) {
                this.f37707p.setTextColor(colorStateList2);
            }
            if (!this.f37703n || (colorStateList = this.A) == null) {
                return;
            }
            this.f37707p.setTextColor(colorStateList);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f37684d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    @NonNull
    public yi.i getBoxBackground() {
        int i11 = this.P;
        if (i11 == 1 || i11 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.V;
    }

    public int getBoxBackgroundMode() {
        return this.P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.f0.p(this) ? this.M.j().a(this.f37681b0) : this.M.l().a(this.f37681b0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.f0.p(this) ? this.M.l().a(this.f37681b0) : this.M.j().a(this.f37681b0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.f0.p(this) ? this.M.r().a(this.f37681b0) : this.M.t().a(this.f37681b0);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.f0.p(this) ? this.M.t().a(this.f37681b0) : this.M.r().a(this.f37681b0);
    }

    public int getBoxStrokeColor() {
        return this.f37704n0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f37706o0;
    }

    public int getBoxStrokeWidth() {
        return this.S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.f37701m;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f37699l && this.f37703n && (textView = this.f37707p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f37727z;
    }

    @Nullable
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public ColorStateList getCursorColor() {
        return this.B;
    }

    @Nullable
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public ColorStateList getCursorErrorColor() {
        return this.C;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f37696j0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f37684d;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f37682c.n();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f37682c.p();
    }

    public int getEndIconMinSize() {
        return this.f37682c.q();
    }

    public int getEndIconMode() {
        return this.f37682c.r();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f37682c.s();
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f37682c.t();
    }

    @Nullable
    public CharSequence getError() {
        if (this.f37697k.A()) {
            return this.f37697k.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f37697k.n();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f37697k.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f37697k.q();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f37682c.u();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f37697k.B()) {
            return this.f37697k.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f37697k.u();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f37722w0.r();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f37722w0.w();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f37698k0;
    }

    @NonNull
    public d getLengthCounter() {
        return this.f37705o;
    }

    public int getMaxEms() {
        return this.f37691h;
    }

    public int getMaxWidth() {
        return this.f37695j;
    }

    public int getMinEms() {
        return this.f37689g;
    }

    public int getMinWidth() {
        return this.f37693i;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f37682c.w();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f37682c.x();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f37715t) {
            return this.f37713s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f37721w;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f37719v;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f37680b.a();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f37680b.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f37680b.d();
    }

    @NonNull
    public yi.n getShapeAppearanceModel() {
        return this.M;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f37680b.e();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f37680b.f();
    }

    public int getStartIconMinSize() {
        return this.f37680b.g();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f37680b.h();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f37682c.y();
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f37682c.z();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f37682c.B();
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f37683c0;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void h0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListH = this.B;
        if (colorStateListH == null) {
            colorStateListH = com.google.android.material.color.b.h(getContext(), R$attr.colorControlActivated);
        }
        EditText editText = this.f37684d;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = d3.a.r(this.f37684d.getTextCursorDrawable()).mutate();
        if (M() && (colorStateList = this.C) != null) {
            colorStateListH = colorStateList;
        }
        d3.a.o(drawableMutate, colorStateListH);
    }

    public final void i() {
        TextView textView = this.f37717u;
        if (textView != null) {
            this.f37678a.addView(textView);
            this.f37717u.setVisibility(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public boolean i0() {
        boolean z11;
        if (this.f37684d == null) {
            return false;
        }
        boolean z12 = true;
        if (Z()) {
            int measuredWidth = this.f37680b.getMeasuredWidth() - this.f37684d.getPaddingLeft();
            if (this.f37685d0 == null || this.f37686e0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f37685d0 = colorDrawable;
                this.f37686e0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = androidx.core.widget.m.a(this.f37684d);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.f37685d0;
            if (drawable != drawable2) {
                androidx.core.widget.m.j(this.f37684d, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z11 = true;
            } else {
                z11 = false;
            }
        } else if (this.f37685d0 != null) {
            Drawable[] drawableArrA2 = androidx.core.widget.m.a(this.f37684d);
            androidx.core.widget.m.j(this.f37684d, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
            this.f37685d0 = null;
            z11 = true;
        } else {
            z11 = false;
        }
        if (Y()) {
            int measuredWidth2 = this.f37682c.B().getMeasuredWidth() - this.f37684d.getPaddingRight();
            CheckableImageButton checkableImageButtonM = this.f37682c.m();
            if (checkableImageButtonM != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonM.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) checkableImageButtonM.getLayoutParams());
            }
            Drawable[] drawableArrA3 = androidx.core.widget.m.a(this.f37684d);
            Drawable drawable3 = this.f37690g0;
            if (drawable3 == null || this.f37692h0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f37690g0 = colorDrawable2;
                    this.f37692h0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.f37690g0;
                if (drawable4 != drawable5) {
                    this.f37694i0 = drawable4;
                    androidx.core.widget.m.j(this.f37684d, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z12 = z11;
                }
            } else {
                this.f37692h0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.m.j(this.f37684d, drawableArrA3[0], drawableArrA3[1], this.f37690g0, drawableArrA3[3]);
            }
        } else {
            if (this.f37690g0 == null) {
                return z11;
            }
            Drawable[] drawableArrA4 = androidx.core.widget.m.a(this.f37684d);
            if (drawableArrA4[2] == this.f37690g0) {
                androidx.core.widget.m.j(this.f37684d, drawableArrA4[0], drawableArrA4[1], this.f37694i0, drawableArrA4[3]);
            } else {
                z12 = z11;
            }
            this.f37690g0 = null;
        }
        return z12;
    }

    public boolean isCounterEnabled() {
        return this.f37699l;
    }

    public boolean isEndIconCheckable() {
        return this.f37682c.G();
    }

    public boolean isEndIconVisible() {
        return this.f37682c.I();
    }

    public boolean isErrorEnabled() {
        return this.f37697k.A();
    }

    public boolean isExpandedHintEnabled() {
        return this.f37724x0;
    }

    public boolean isHelperTextEnabled() {
        return this.f37697k.B();
    }

    public boolean isHintAnimationEnabled() {
        return this.f37726y0;
    }

    public boolean isHintEnabled() {
        return this.D;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.f37682c.K();
    }

    public boolean isProvidingHint() {
        return this.F;
    }

    public boolean isStartIconCheckable() {
        return this.f37680b.k();
    }

    public boolean isStartIconVisible() {
        return this.f37680b.l();
    }

    public final void j() {
        if (this.f37684d == null || this.P != 1) {
            return;
        }
        if (vi.d.k(getContext())) {
            EditText editText = this.f37684d;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f37684d), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (vi.d.j(getContext())) {
            EditText editText2 = this.f37684d;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f37684d), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    public void j0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f37684d;
        if (editText == null || this.P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.b0.a(background)) {
            background = background.mutate();
        }
        if (X()) {
            background.setColorFilter(androidx.appcompat.widget.f.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f37703n && (textView = this.f37707p) != null) {
            background.setColorFilter(androidx.appcompat.widget.f.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            d3.a.c(background);
            this.f37684d.refreshDrawableState();
        }
    }

    public void k(float f11) {
        if (this.f37722w0.F() == f11) {
            return;
        }
        if (this.f37728z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f37728z0 = valueAnimator;
            valueAnimator.setInterpolator(ti.j.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, ii.b.f67202b));
            this.f37728z0.setDuration(ti.j.f(getContext(), R$attr.motionDurationMedium4, 167));
            this.f37728z0.addUpdateListener(new b());
        }
        this.f37728z0.setFloatValues(this.f37722w0.F(), f11);
        this.f37728z0.start();
    }

    public final void k0() {
        ViewCompat.setBackground(this.f37684d, getEditTextBoxBackground());
    }

    public final void l() {
        yi.i iVar = this.G;
        if (iVar == null) {
            return;
        }
        yi.n nVarG = iVar.G();
        yi.n nVar = this.M;
        if (nVarG != nVar) {
            this.G.setShapeAppearanceModel(nVar);
        }
        if (v()) {
            this.G.l0(this.R, this.U);
        }
        int iP = p();
        this.V = iP;
        this.G.d0(ColorStateList.valueOf(iP));
        m();
        l0();
    }

    public void l0() {
        EditText editText = this.f37684d;
        if (editText == null || this.G == null) {
            return;
        }
        if ((this.J || editText.getBackground() == null) && this.P != 0) {
            k0();
            this.J = true;
        }
    }

    public final void m() {
        if (this.K == null || this.L == null) {
            return;
        }
        if (w()) {
            this.K.d0(this.f37684d.isFocused() ? ColorStateList.valueOf(this.f37700l0) : ColorStateList.valueOf(this.U));
            this.L.d0(ColorStateList.valueOf(this.U));
        }
        invalidate();
    }

    public final boolean m0() {
        int iMax;
        if (this.f37684d == null || this.f37684d.getMeasuredHeight() >= (iMax = Math.max(this.f37682c.getMeasuredHeight(), this.f37680b.getMeasuredHeight()))) {
            return false;
        }
        this.f37684d.setMinimumHeight(iMax);
        return true;
    }

    public final void n(@NonNull RectF rectF) {
        float f11 = rectF.left;
        int i11 = this.O;
        rectF.left = f11 - i11;
        rectF.right += i11;
    }

    public final void n0() {
        if (this.P != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f37678a.getLayoutParams();
            int iU = u();
            if (iU != layoutParams.topMargin) {
                layoutParams.topMargin = iU;
                this.f37678a.requestLayout();
            }
        }
    }

    public final void o() {
        int i11 = this.P;
        if (i11 == 0) {
            this.G = null;
            this.K = null;
            this.L = null;
            return;
        }
        if (i11 == 1) {
            this.G = new yi.i(this.M);
            this.K = new yi.i();
            this.L = new yi.i();
        } else {
            if (i11 != 2) {
                throw new IllegalArgumentException(this.P + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.D || (this.G instanceof h)) {
                this.G = new yi.i(this.M);
            } else {
                this.G = h.u0(this.M);
            }
            this.K = null;
            this.L = null;
        }
    }

    public void o0(boolean z11) {
        p0(z11, false);
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f37722w0.Z(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f37682c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.C0 = false;
        boolean zM0 = m0();
        boolean zI0 = i0();
        if (zM0 || zI0) {
            this.f37684d.post(new Runnable() { // from class: com.google.android.material.textfield.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f37753a.P();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        EditText editText = this.f37684d;
        if (editText != null) {
            Rect rect = this.W;
            com.google.android.material.internal.d.a(this, editText, rect);
            c0(rect);
            if (this.D) {
                this.f37722w0.w0(this.f37684d.getTextSize());
                int gravity = this.f37684d.getGravity();
                this.f37722w0.k0((gravity & (-113)) | 48);
                this.f37722w0.v0(gravity);
                this.f37722w0.g0(q(rect));
                this.f37722w0.q0(t(rect));
                this.f37722w0.b0();
                if (!A() || this.f37720v0) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!this.C0) {
            this.f37682c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.C0 = true;
        }
        q0();
        this.f37682c.D0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f37729a);
        if (savedState.f37730b) {
            post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f37682c.i();
                }
            });
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i11) {
        super.onRtlPropertiesChanged(i11);
        boolean z11 = i11 == 1;
        if (z11 != this.N) {
            float fA = this.M.r().a(this.f37681b0);
            float fA2 = this.M.t().a(this.f37681b0);
            yi.n nVarM = yi.n.a().G(this.M.s()).L(this.M.q()).v(this.M.k()).A(this.M.i()).H(fA2).M(fA).w(this.M.l().a(this.f37681b0)).B(this.M.j().a(this.f37681b0)).m();
            this.N = z11;
            setShapeAppearanceModel(nVarM);
        }
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (X()) {
            savedState.f37729a = getError();
        }
        savedState.f37730b = this.f37682c.H();
        return savedState;
    }

    public final int p() {
        return this.P == 1 ? com.google.android.material.color.b.j(com.google.android.material.color.b.e(this, R$attr.colorSurface, 0), this.V) : this.V;
    }

    public final void p0(boolean z11, boolean z12) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f37684d;
        boolean z13 = false;
        boolean z14 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f37684d;
        if (editText2 != null && editText2.hasFocus()) {
            z13 = true;
        }
        ColorStateList colorStateList2 = this.f37696j0;
        if (colorStateList2 != null) {
            this.f37722w0.e0(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f37696j0;
            this.f37722w0.e0(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f37716t0) : this.f37716t0));
        } else if (X()) {
            this.f37722w0.e0(this.f37697k.r());
        } else if (this.f37703n && (textView = this.f37707p) != null) {
            this.f37722w0.e0(textView.getTextColors());
        } else if (z13 && (colorStateList = this.f37698k0) != null) {
            this.f37722w0.j0(colorStateList);
        }
        if (z14 || !this.f37724x0 || (isEnabled() && z13)) {
            if (z12 || this.f37720v0) {
                y(z11);
                return;
            }
            return;
        }
        if (z12 || !this.f37720v0) {
            E(z11);
        }
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z11) {
        this.f37682c.A0(z11);
    }

    @NonNull
    public final Rect q(@NonNull Rect rect) {
        if (this.f37684d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f37679a0;
        boolean zP = com.google.android.material.internal.f0.p(this);
        rect2.bottom = rect.bottom;
        int i11 = this.P;
        if (i11 == 1) {
            rect2.left = H(rect.left, zP);
            rect2.top = rect.top + this.Q;
            rect2.right = I(rect.right, zP);
            return rect2;
        }
        if (i11 != 2) {
            rect2.left = H(rect.left, zP);
            rect2.top = getPaddingTop();
            rect2.right = I(rect.right, zP);
            return rect2;
        }
        rect2.left = rect.left + this.f37684d.getPaddingLeft();
        rect2.top = rect.top - u();
        rect2.right = rect.right - this.f37684d.getPaddingRight();
        return rect2;
    }

    public final void q0() {
        EditText editText;
        if (this.f37717u == null || (editText = this.f37684d) == null) {
            return;
        }
        this.f37717u.setGravity(editText.getGravity());
        this.f37717u.setPadding(this.f37684d.getCompoundPaddingLeft(), this.f37684d.getCompoundPaddingTop(), this.f37684d.getCompoundPaddingRight(), this.f37684d.getCompoundPaddingBottom());
    }

    public final int r(@NonNull Rect rect, @NonNull Rect rect2, float f11) {
        return N() ? (int) (rect2.top + f11) : rect.bottom - this.f37684d.getCompoundPaddingBottom();
    }

    public final void r0() {
        EditText editText = this.f37684d;
        s0(editText == null ? null : editText.getText());
    }

    public void refreshEndIconDrawableState() {
        this.f37682c.N();
    }

    public void refreshErrorIconDrawableState() {
        this.f37682c.O();
    }

    public void refreshStartIconDrawableState() {
        this.f37680b.n();
    }

    public void removeOnEditTextAttachedListener(@NonNull e eVar) {
        this.f37688f0.remove(eVar);
    }

    public void removeOnEndIconChangedListener(@NonNull f fVar) {
        this.f37682c.Q(fVar);
    }

    public final int s(@NonNull Rect rect, float f11) {
        return N() ? (int) (rect.centerY() - (f11 / 2.0f)) : rect.top + this.f37684d.getCompoundPaddingTop();
    }

    public final void s0(@Nullable Editable editable) {
        if (this.f37705o.a(editable) != 0 || this.f37720v0) {
            K();
        } else {
            a0();
        }
    }

    public void setBoxBackgroundColor(int i11) {
        if (this.V != i11) {
            this.V = i11;
            this.f37708p0 = i11;
            this.f37712r0 = i11;
            this.f37714s0 = i11;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i11) {
        setBoxBackgroundColor(z2.a.getColor(getContext(), i11));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f37708p0 = defaultColor;
        this.V = defaultColor;
        this.f37710q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f37712r0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f37714s0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i11) {
        if (i11 == this.P) {
            return;
        }
        this.P = i11;
        if (this.f37684d != null) {
            Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i11) {
        this.Q = i11;
    }

    public void setBoxCornerFamily(int i11) {
        this.M = this.M.v().F(i11, this.M.r()).K(i11, this.M.t()).u(i11, this.M.j()).z(i11, this.M.l()).m();
        l();
    }

    public void setBoxCornerRadii(float f11, float f12, float f13, float f14) {
        boolean zP = com.google.android.material.internal.f0.p(this);
        this.N = zP;
        float f15 = zP ? f12 : f11;
        if (!zP) {
            f11 = f12;
        }
        float f16 = zP ? f14 : f13;
        if (!zP) {
            f13 = f14;
        }
        yi.i iVar = this.G;
        if (iVar != null && iVar.L() == f15 && this.G.M() == f11 && this.G.u() == f16 && this.G.v() == f13) {
            return;
        }
        this.M = this.M.v().H(f15).M(f11).w(f16).B(f13).m();
        l();
    }

    public void setBoxCornerRadiiResources(int i11, int i12, int i13, int i14) {
        setBoxCornerRadii(getContext().getResources().getDimension(i11), getContext().getResources().getDimension(i12), getContext().getResources().getDimension(i14), getContext().getResources().getDimension(i13));
    }

    public void setBoxStrokeColor(int i11) {
        if (this.f37704n0 != i11) {
            this.f37704n0 = i11;
            u0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f37700l0 = colorStateList.getDefaultColor();
            this.f37716t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f37702m0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f37704n0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f37704n0 != colorStateList.getDefaultColor()) {
            this.f37704n0 = colorStateList.getDefaultColor();
        }
        u0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f37706o0 != colorStateList) {
            this.f37706o0 = colorStateList;
            u0();
        }
    }

    public void setBoxStrokeWidth(int i11) {
        this.S = i11;
        u0();
    }

    public void setBoxStrokeWidthFocused(int i11) {
        this.T = i11;
        u0();
    }

    public void setBoxStrokeWidthFocusedResource(int i11) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i11));
    }

    public void setBoxStrokeWidthResource(int i11) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i11));
    }

    public void setCounterEnabled(boolean z11) {
        if (this.f37699l != z11) {
            if (z11) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f37707p = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.f37683c0;
                if (typeface != null) {
                    this.f37707p.setTypeface(typeface);
                }
                this.f37707p.setMaxLines(1);
                this.f37697k.e(this.f37707p, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f37707p.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                g0();
                d0();
            } else {
                this.f37697k.C(this.f37707p, 2);
                this.f37707p = null;
            }
            this.f37699l = z11;
        }
    }

    public void setCounterMaxLength(int i11) {
        if (this.f37701m != i11) {
            if (i11 > 0) {
                this.f37701m = i11;
            } else {
                this.f37701m = -1;
            }
            if (this.f37699l) {
                d0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i11) {
        if (this.f37709q != i11) {
            this.f37709q = i11;
            g0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            g0();
        }
    }

    public void setCounterTextAppearance(int i11) {
        if (this.f37711r != i11) {
            this.f37711r = i11;
            g0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f37727z != colorStateList) {
            this.f37727z = colorStateList;
            g0();
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            h0();
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (M()) {
                h0();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f37696j0 = colorStateList;
        this.f37698k0 = colorStateList;
        if (this.f37684d != null) {
            o0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z11) {
        T(this, z11);
        super.setEnabled(z11);
    }

    public void setEndIconActivated(boolean z11) {
        this.f37682c.S(z11);
    }

    public void setEndIconCheckable(boolean z11) {
        this.f37682c.T(z11);
    }

    public void setEndIconContentDescription(@StringRes int i11) {
        this.f37682c.U(i11);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        this.f37682c.V(charSequence);
    }

    public void setEndIconDrawable(int i11) {
        this.f37682c.W(i11);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.f37682c.X(drawable);
    }

    public void setEndIconMinSize(int i11) {
        this.f37682c.Y(i11);
    }

    public void setEndIconMode(int i11) {
        this.f37682c.Z(i11);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f37682c.a0(onClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f37682c.b0(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f37682c.c0(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37682c.d0(colorStateList);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f37682c.e0(mode);
    }

    public void setEndIconVisible(boolean z11) {
        this.f37682c.f0(z11);
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f37697k.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f37697k.w();
        } else {
            this.f37697k.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i11) {
        this.f37697k.E(i11);
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f37697k.F(charSequence);
    }

    public void setErrorEnabled(boolean z11) {
        this.f37697k.G(z11);
    }

    public void setErrorIconDrawable(int i11) {
        this.f37682c.g0(i11);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f37682c.h0(drawable);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f37682c.i0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f37682c.j0(onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37682c.k0(colorStateList);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f37682c.l0(mode);
    }

    public void setErrorTextAppearance(int i11) {
        this.f37697k.H(i11);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f37697k.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z11) {
        if (this.f37724x0 != z11) {
            this.f37724x0 = z11;
            o0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.f37697k.R(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f37697k.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z11) {
        this.f37697k.K(z11);
    }

    public void setHelperTextTextAppearance(int i11) {
        this.f37697k.J(i11);
    }

    public void setHint(@StringRes int i11) {
        setHint(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z11) {
        this.f37726y0 = z11;
    }

    public void setHintEnabled(boolean z11) {
        if (z11 != this.D) {
            this.D = z11;
            if (z11) {
                CharSequence hint = this.f37684d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f37684d.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f37684d.getHint())) {
                    this.f37684d.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.f37684d != null) {
                n0();
            }
        }
    }

    public void setHintTextAppearance(int i11) {
        this.f37722w0.h0(i11);
        this.f37698k0 = this.f37722w0.p();
        if (this.f37684d != null) {
            o0(false);
            n0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f37698k0 != colorStateList) {
            if (this.f37696j0 == null) {
                this.f37722w0.j0(colorStateList);
            }
            this.f37698k0 = colorStateList;
            if (this.f37684d != null) {
                o0(false);
            }
        }
    }

    public void setLengthCounter(@NonNull d dVar) {
        this.f37705o = dVar;
    }

    public void setMaxEms(int i11) {
        this.f37691h = i11;
        EditText editText = this.f37684d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMaxEms(i11);
    }

    public void setMaxWidth(int i11) {
        this.f37695j = i11;
        EditText editText = this.f37684d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMaxWidth(i11);
    }

    public void setMaxWidthResource(int i11) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i11));
    }

    public void setMinEms(int i11) {
        this.f37689g = i11;
        EditText editText = this.f37684d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMinEms(i11);
    }

    public void setMinWidth(int i11) {
        this.f37693i = i11;
        EditText editText = this.f37684d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMinWidth(i11);
    }

    public void setMinWidthResource(int i11) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i11));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i11) {
        this.f37682c.n0(i11);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f37682c.o0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i11) {
        this.f37682c.p0(i11);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f37682c.q0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z11) {
        this.f37682c.r0(z11);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.f37682c.s0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.f37682c.t0(mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f37717u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f37717u = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            ViewCompat.setImportantForAccessibility(this.f37717u, 2);
            k6.c cVarZ = z();
            this.f37723x = cVarZ;
            cVarZ.f0(67L);
            this.f37725y = z();
            setPlaceholderTextAppearance(this.f37721w);
            setPlaceholderTextColor(this.f37719v);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f37715t) {
                setPlaceholderTextEnabled(true);
            }
            this.f37713s = charSequence;
        }
        r0();
    }

    public void setPlaceholderTextAppearance(int i11) {
        this.f37721w = i11;
        TextView textView = this.f37717u;
        if (textView != null) {
            androidx.core.widget.m.p(textView, i11);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f37719v != colorStateList) {
            this.f37719v = colorStateList;
            TextView textView = this.f37717u;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.f37680b.o(charSequence);
    }

    public void setPrefixTextAppearance(int i11) {
        this.f37680b.p(i11);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f37680b.q(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull yi.n nVar) {
        yi.i iVar = this.G;
        if (iVar == null || iVar.G() == nVar) {
            return;
        }
        this.M = nVar;
        l();
    }

    public void setStartIconCheckable(boolean z11) {
        this.f37680b.r(z11);
    }

    public void setStartIconContentDescription(@StringRes int i11) {
        setStartIconContentDescription(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.f37680b.s(charSequence);
    }

    public void setStartIconDrawable(int i11) {
        setStartIconDrawable(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f37680b.t(drawable);
    }

    public void setStartIconMinSize(int i11) {
        this.f37680b.u(i11);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f37680b.v(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f37680b.w(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f37680b.x(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37680b.y(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f37680b.z(mode);
    }

    public void setStartIconVisible(boolean z11) {
        this.f37680b.A(z11);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.f37682c.u0(charSequence);
    }

    public void setSuffixTextAppearance(int i11) {
        this.f37682c.v0(i11);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f37682c.w0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable c cVar) {
        EditText editText = this.f37684d;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, cVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f37683c0) {
            this.f37683c0 = typeface;
            this.f37722w0.O0(typeface);
            this.f37697k.N(typeface);
            TextView textView = this.f37707p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    @NonNull
    public final Rect t(@NonNull Rect rect) {
        if (this.f37684d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f37679a0;
        float fC = this.f37722w0.C();
        rect2.left = rect.left + this.f37684d.getCompoundPaddingLeft();
        rect2.top = s(rect, fC);
        rect2.right = rect.right - this.f37684d.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, fC);
        return rect2;
    }

    public final void t0(boolean z11, boolean z12) {
        int defaultColor = this.f37706o0.getDefaultColor();
        int colorForState = this.f37706o0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f37706o0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z11) {
            this.U = colorForState2;
        } else if (z12) {
            this.U = colorForState;
        } else {
            this.U = defaultColor;
        }
    }

    public final int u() {
        float fR;
        if (!this.D) {
            return 0;
        }
        int i11 = this.P;
        if (i11 == 0) {
            fR = this.f37722w0.r();
        } else {
            if (i11 != 2) {
                return 0;
            }
            fR = this.f37722w0.r() / 2.0f;
        }
        return (int) fR;
    }

    public void u0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G == null || this.P == 0) {
            return;
        }
        boolean z11 = false;
        boolean z12 = isFocused() || ((editText2 = this.f37684d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f37684d) != null && editText.isHovered())) {
            z11 = true;
        }
        if (!isEnabled()) {
            this.U = this.f37716t0;
        } else if (X()) {
            if (this.f37706o0 != null) {
                t0(z12, z11);
            } else {
                this.U = getErrorCurrentTextColors();
            }
        } else if (!this.f37703n || (textView = this.f37707p) == null) {
            if (z12) {
                this.U = this.f37704n0;
            } else if (z11) {
                this.U = this.f37702m0;
            } else {
                this.U = this.f37700l0;
            }
        } else if (this.f37706o0 != null) {
            t0(z12, z11);
        } else {
            this.U = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            h0();
        }
        this.f37682c.M();
        refreshStartIconDrawableState();
        if (this.P == 2) {
            int i11 = this.R;
            if (z12 && isEnabled()) {
                this.R = this.T;
            } else {
                this.R = this.S;
            }
            if (this.R != i11) {
                S();
            }
        }
        if (this.P == 1) {
            if (!isEnabled()) {
                this.V = this.f37710q0;
            } else if (z11 && !z12) {
                this.V = this.f37714s0;
            } else if (z12) {
                this.V = this.f37712r0;
            } else {
                this.V = this.f37708p0;
            }
        }
        l();
    }

    public final boolean v() {
        return this.P == 2 && w();
    }

    public final boolean w() {
        return this.R > -1 && this.U != 0;
    }

    public final void x() {
        if (A()) {
            ((h) this.G).w0();
        }
    }

    public final void y(boolean z11) {
        ValueAnimator valueAnimator = this.f37728z0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f37728z0.cancel();
        }
        if (z11 && this.f37726y0) {
            k(1.0f);
        } else {
            this.f37722w0.z0(1.0f);
        }
        this.f37720v0 = false;
        if (A()) {
            R();
        }
        r0();
        this.f37680b.m(false);
        this.f37682c.L(false);
    }

    public final k6.c z() {
        k6.c cVar = new k6.c();
        cVar.a0(ti.j.f(getContext(), R$attr.motionDurationShort2, 87));
        cVar.c0(ti.j.g(getContext(), R$attr.motionEasingLinearInterpolator, ii.b.f67201a));
        return cVar;
    }
}
