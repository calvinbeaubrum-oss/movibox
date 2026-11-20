package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SwitchCompat extends CompoundButton {
    public static final Property<SwitchCompat, Float> T = new a(Float.class, "thumbPos");
    public static final int[] U = {R.attr.state_checked};
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public final TextPaint J;
    public ColorStateList K;
    public Layout L;
    public Layout M;

    @Nullable
    public TransformationMethod N;
    public ObjectAnimator O;
    public final AppCompatTextHelper P;

    @NonNull
    public h Q;

    @Nullable
    public b R;
    public final Rect S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f1552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f1553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1555d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f1558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f1559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f1566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f1567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f1568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f1569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1570t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1571u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1572v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1573w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f1574x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public VelocityTracker f1575y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1576z;

    /* JADX INFO: compiled from: source.java */
    public class a extends Property<SwitchCompat, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.A);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f11) {
            switchCompat.setThumbPosition(f11.floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends EmojiCompat.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<SwitchCompat> f1577a;

        public b(SwitchCompat switchCompat) {
            this.f1577a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void a(@Nullable Throwable th2) {
            SwitchCompat switchCompat = this.f1577a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            SwitchCompat switchCompat = this.f1577a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(@NonNull Context context) {
        this(context, null);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1553b = null;
        this.f1554c = null;
        this.f1555d = false;
        this.f1556f = false;
        this.f1558h = null;
        this.f1559i = null;
        this.f1560j = false;
        this.f1561k = false;
        this.f1575y = VelocityTracker.obtain();
        this.I = true;
        this.S = new Rect();
        i0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.J = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        n0 n0VarV = n0.v(context, attributeSet, R$styleable.SwitchCompat, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.SwitchCompat, attributeSet, n0VarV.r(), i11, 0);
        Drawable drawableG = n0VarV.g(R$styleable.SwitchCompat_android_thumb);
        this.f1552a = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = n0VarV.g(R$styleable.SwitchCompat_track);
        this.f1557g = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(n0VarV.p(R$styleable.SwitchCompat_android_textOn));
        setTextOffInternal(n0VarV.p(R$styleable.SwitchCompat_android_textOff));
        this.f1570t = n0VarV.a(R$styleable.SwitchCompat_showText, true);
        this.f1562l = n0VarV.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1563m = n0VarV.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.f1564n = n0VarV.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.f1565o = n0VarV.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListC = n0VarV.c(R$styleable.SwitchCompat_thumbTint);
        if (colorStateListC != null) {
            this.f1553b = colorStateListC;
            this.f1555d = true;
        }
        PorterDuff.Mode modeE = b0.e(n0VarV.k(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f1554c != modeE) {
            this.f1554c = modeE;
            this.f1556f = true;
        }
        if (this.f1555d || this.f1556f) {
            b();
        }
        ColorStateList colorStateListC2 = n0VarV.c(R$styleable.SwitchCompat_trackTint);
        if (colorStateListC2 != null) {
            this.f1558h = colorStateListC2;
            this.f1560j = true;
        }
        PorterDuff.Mode modeE2 = b0.e(n0VarV.k(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f1559i != modeE2) {
            this.f1559i = modeE2;
            this.f1561k = true;
        }
        if (this.f1560j || this.f1561k) {
            c();
        }
        int iN = n0VarV.n(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (iN != 0) {
            setSwitchTextAppearance(context, iN);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.P = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i11);
        n0VarV.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1572v = viewConfiguration.getScaledTouchSlop();
        this.f1576z = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i11);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public static float f(float f11, float f12, float f13) {
        if (f11 < f12) {
            return f12;
        }
        return f11 > f13 ? f13 : f11;
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.Q == null) {
            this.Q = new h(this);
        }
        return this.Q;
    }

    private boolean getTargetCheckedState() {
        return this.A > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((y0.b(this) ? 1.0f - this.A : this.A) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1557g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.S;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1552a;
        Rect rectD = drawable2 != null ? b0.d(drawable2) : b0.f1617c;
        return ((((this.B - this.D) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1568r = charSequence;
        this.f1569s = g(charSequence);
        this.M = null;
        if (this.f1570t) {
            n();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1566p = charSequence;
        this.f1567q = g(charSequence);
        this.L = null;
        if (this.f1570t) {
            n();
        }
    }

    public final void a(boolean z11) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, T, z11 ? 1.0f : 0.0f);
        this.O = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.O.setAutoCancel(true);
        this.O.start();
    }

    public final void b() {
        Drawable drawable = this.f1552a;
        if (drawable != null) {
            if (this.f1555d || this.f1556f) {
                Drawable drawableMutate = d3.a.r(drawable).mutate();
                this.f1552a = drawableMutate;
                if (this.f1555d) {
                    d3.a.o(drawableMutate, this.f1553b);
                }
                if (this.f1556f) {
                    d3.a.p(this.f1552a, this.f1554c);
                }
                if (this.f1552a.isStateful()) {
                    this.f1552a.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.f1557g;
        if (drawable != null) {
            if (this.f1560j || this.f1561k) {
                Drawable drawableMutate = d3.a.r(drawable).mutate();
                this.f1557g = drawableMutate;
                if (this.f1560j) {
                    d3.a.o(drawableMutate, this.f1558h);
                }
                if (this.f1561k) {
                    d3.a.p(this.f1557g, this.f1559i);
                }
                if (this.f1557g.isStateful()) {
                    this.f1557g.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i11;
        int i12;
        Rect rect = this.S;
        int i13 = this.E;
        int i14 = this.F;
        int i15 = this.G;
        int i16 = this.H;
        int thumbOffset = getThumbOffset() + i13;
        Drawable drawable = this.f1552a;
        Rect rectD = drawable != null ? b0.d(drawable) : b0.f1617c;
        Drawable drawable2 = this.f1557g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i17 = rect.left;
            thumbOffset += i17;
            if (rectD != null) {
                int i18 = rectD.left;
                if (i18 > i17) {
                    i13 += i18 - i17;
                }
                int i19 = rectD.top;
                int i21 = rect.top;
                i11 = i19 > i21 ? (i19 - i21) + i14 : i14;
                int i22 = rectD.right;
                int i23 = rect.right;
                if (i22 > i23) {
                    i15 -= i22 - i23;
                }
                int i24 = rectD.bottom;
                int i25 = rect.bottom;
                if (i24 > i25) {
                    i12 = i16 - (i24 - i25);
                }
                this.f1557g.setBounds(i13, i11, i15, i12);
            } else {
                i11 = i14;
            }
            i12 = i16;
            this.f1557g.setBounds(i13, i11, i15, i12);
        }
        Drawable drawable3 = this.f1552a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i26 = thumbOffset - rect.left;
            int i27 = thumbOffset + this.D + rect.right;
            this.f1552a.setBounds(i26, i14, i27, i16);
            Drawable background = getBackground();
            if (background != null) {
                d3.a.l(background, i26, i14, i27, i16);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f11, float f12) {
        super.drawableHotspotChanged(f11, f12);
        Drawable drawable = this.f1552a;
        if (drawable != null) {
            d3.a.k(drawable, f11, f12);
        }
        Drawable drawable2 = this.f1557g;
        if (drawable2 != null) {
            d3.a.k(drawable2, f11, f12);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1552a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f1557g;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Nullable
    public final CharSequence g(@Nullable CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.N);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!y0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1564n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (y0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1564n : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.m.r(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1570t;
    }

    public boolean getSplitTrack() {
        return this.f1565o;
    }

    public int getSwitchMinWidth() {
        return this.f1563m;
    }

    public int getSwitchPadding() {
        return this.f1564n;
    }

    public CharSequence getTextOff() {
        return this.f1568r;
    }

    public CharSequence getTextOn() {
        return this.f1566p;
    }

    public Drawable getThumbDrawable() {
        return this.f1552a;
    }

    public final float getThumbPosition() {
        return this.A;
    }

    public int getThumbTextPadding() {
        return this.f1562l;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f1553b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1554c;
    }

    public Drawable getTrackDrawable() {
        return this.f1557g;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f1558h;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1559i;
    }

    public final boolean h(float f11, float f12) {
        if (this.f1552a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1552a.getPadding(this.S);
        int i11 = this.F;
        int i12 = this.f1572v;
        int i13 = i11 - i12;
        int i14 = (this.E + thumbOffset) - i12;
        int i15 = this.D + i14;
        Rect rect = this.S;
        return f11 > ((float) i14) && f11 < ((float) (((i15 + rect.left) + rect.right) + i12)) && f12 > ((float) i13) && f12 < ((float) (this.H + i12));
    }

    public final Layout i(CharSequence charSequence) {
        TextPaint textPaint = this.J;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public void j() {
        setTextOnInternal(this.f1566p);
        setTextOffInternal(this.f1568r);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1552a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1557g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.O.end();
        this.O = null;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f1568r;
            if (string == null) {
                string = getResources().getString(R$string.abc_capital_off);
            }
            ViewCompat.setStateDescription(this, string);
        }
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f1566p;
            if (string == null) {
                string = getResources().getString(R$string.abc_capital_on);
            }
            ViewCompat.setStateDescription(this, string);
        }
    }

    public final void m(int i11, int i12) {
        Typeface typeface;
        if (i11 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i11 != 2) {
            typeface = i11 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        setSwitchTypeface(typeface, i12);
    }

    public final void n() {
        if (this.R == null && this.Q.b() && EmojiCompat.i()) {
            EmojiCompat emojiCompatC = EmojiCompat.c();
            int iE = emojiCompatC.e();
            if (iE == 3 || iE == 0) {
                b bVar = new b(this);
                this.R = bVar;
                emojiCompatC.t(bVar);
            }
        }
    }

    public final void o(MotionEvent motionEvent) {
        this.f1571u = 0;
        boolean targetCheckedState = true;
        boolean z11 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z11) {
            this.f1575y.computeCurrentVelocity(1000);
            float xVelocity = this.f1575y.getXVelocity();
            if (Math.abs(xVelocity) <= this.f1576z) {
                targetCheckedState = getTargetCheckedState();
            } else if (!y0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, U);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.S;
        Drawable drawable = this.f1557g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i11 = this.F;
        int i12 = this.H;
        int i13 = i11 + rect.top;
        int i14 = i12 - rect.bottom;
        Drawable drawable2 = this.f1552a;
        if (drawable != null) {
            if (!this.f1565o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = b0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.L : this.M;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.K;
            if (colorStateList != null) {
                this.J.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.J.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i13 + i14) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f1566p : this.f1568r;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(' ');
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int iMax;
        int width;
        int paddingLeft;
        int i15;
        int paddingTop;
        int height;
        super.onLayout(z11, i11, i12, i13, i14);
        int iMax2 = 0;
        if (this.f1552a != null) {
            Rect rect = this.S;
            Drawable drawable = this.f1557g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = b0.d(this.f1552a);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (y0.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.B + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.B) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i15 = this.C;
            } else {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.C;
            }
            this.E = paddingLeft;
            this.F = paddingTop;
            this.H = height;
            this.G = width;
        }
        int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        i15 = this.C;
        paddingTop = paddingTop2 - (i15 / 2);
        height = i15 + paddingTop;
        this.E = paddingLeft;
        this.F = paddingTop;
        this.H = height;
        this.G = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f1570t) {
            if (this.L == null) {
                this.L = i(this.f1567q);
            }
            if (this.M == null) {
                this.M = i(this.f1569s);
            }
        }
        Rect rect = this.S;
        Drawable drawable = this.f1552a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f1552a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1552a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.D = Math.max(this.f1570t ? Math.max(this.L.getWidth(), this.M.getWidth()) + (this.f1562l * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f1557g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f1557g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f1552a;
        if (drawable3 != null) {
            Rect rectD = b0.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.I ? Math.max(this.f1563m, (this.D * 2) + iMax + iMax2) : this.f1563m;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.B = iMax3;
        this.C = iMax4;
        super.onMeasure(i11, i12);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1566p : this.f1568r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f11;
        this.f1575y.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (isEnabled() && h(x11, y11)) {
                this.f1571u = 1;
                this.f1573w = x11;
                this.f1574x = y11;
            }
        } else if (actionMasked == 1) {
            if (this.f1571u == 2) {
                o(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f1571u = 0;
            this.f1575y.clear();
        } else if (actionMasked == 2) {
            int i11 = this.f1571u;
            if (i11 == 1) {
                float x12 = motionEvent.getX();
                float y12 = motionEvent.getY();
                if (Math.abs(x12 - this.f1573w) > this.f1572v || Math.abs(y12 - this.f1574x) > this.f1572v) {
                    this.f1571u = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.f1573w = x12;
                    this.f1574x = y12;
                    return true;
                }
            } else if (i11 == 2) {
                float x13 = motionEvent.getX();
                int thumbScrollRange = getThumbScrollRange();
                float f12 = x13 - this.f1573w;
                if (thumbScrollRange != 0) {
                    f11 = f12 / thumbScrollRange;
                } else {
                    f11 = f12 > 0.0f ? 1.0f : -1.0f;
                }
                if (y0.b(this)) {
                    f11 = -f11;
                }
                float f13 = f(this.A + f11, 0.0f, 1.0f);
                if (f13 != this.A) {
                    this.f1573w = x13;
                    setThumbPosition(f13);
                }
                return true;
            }
        } else if (actionMasked == 3) {
            if (this.f1571u == 2) {
                o(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f1571u = 0;
            this.f1575y.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z11) {
        super.setAllCaps(z11);
        getEmojiTextViewHelper().d(z11);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z11) {
        super.setChecked(z11);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.s(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        getEmojiTextViewHelper().e(z11);
        setTextOnInternal(this.f1566p);
        setTextOffInternal(this.f1568r);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z11) {
        this.I = z11;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z11) {
        if (this.f1570t != z11) {
            this.f1570t = z11;
            requestLayout();
            if (z11) {
                n();
            }
        }
    }

    public void setSplitTrack(boolean z11) {
        this.f1565o = z11;
        invalidate();
    }

    public void setSwitchMinWidth(int i11) {
        this.f1563m = i11;
        requestLayout();
    }

    public void setSwitchPadding(int i11) {
        this.f1564n = i11;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i11) {
        n0 n0VarT = n0.t(context, i11, R$styleable.TextAppearance);
        ColorStateList colorStateListC = n0VarT.c(R$styleable.TextAppearance_android_textColor);
        if (colorStateListC != null) {
            this.K = colorStateListC;
        } else {
            this.K = getTextColors();
        }
        int iF = n0VarT.f(R$styleable.TextAppearance_android_textSize, 0);
        if (iF != 0) {
            float f11 = iF;
            if (f11 != this.J.getTextSize()) {
                this.J.setTextSize(f11);
                requestLayout();
            }
        }
        m(n0VarT.k(R$styleable.TextAppearance_android_typeface, -1), n0VarT.k(R$styleable.TextAppearance_android_textStyle, -1));
        if (n0VarT.a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.N = new f1.a(getContext());
        } else {
            this.N = null;
        }
        setTextOnInternal(this.f1566p);
        setTextOffInternal(this.f1568r);
        n0VarT.x();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.J.getTypeface() == null || this.J.getTypeface().equals(typeface)) && (this.J.getTypeface() != null || typeface == null)) {
            return;
        }
        this.J.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setSwitchTypeface(Typeface typeface, int i11) {
        if (i11 <= 0) {
            this.J.setFakeBoldText(false);
            this.J.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typeface, i11);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i12 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i11;
            this.J.setFakeBoldText((i12 & 1) != 0);
            this.J.setTextSkewX((i12 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1552a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1552a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f11) {
        this.A = f11;
        invalidate();
    }

    public void setThumbResource(int i11) {
        setThumbDrawable(d1.a.b(getContext(), i11));
    }

    public void setThumbTextPadding(int i11) {
        this.f1562l = i11;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f1553b = colorStateList;
        this.f1555d = true;
        b();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1554c = mode;
        this.f1556f = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1557g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1557g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i11) {
        setTrackDrawable(d1.a.b(getContext(), i11));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f1558h = colorStateList;
        this.f1560j = true;
        c();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1559i = mode;
        this.f1561k = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1552a || drawable == this.f1557g;
    }
}
