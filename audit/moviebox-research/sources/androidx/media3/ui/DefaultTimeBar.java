package androidx.media3.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.warren.error.VungleException;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultTimeBar extends View implements o0 {
    public static final int BAR_GRAVITY_BOTTOM = 1;
    public static final int BAR_GRAVITY_CENTER = 0;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;
    public final float A;
    public int B;
    public long C;
    public int D;
    public Rect E;
    public ValueAnimator F;
    public float G;
    public boolean H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public long M;
    public int N;

    @Nullable
    public long[] O;

    @Nullable
    public boolean[] P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f11820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f11821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f11822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f11823d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f11824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f11825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f11826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f11827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f11828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f11829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final Drawable f11830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f11832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f11833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f11834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f11835q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f11836r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f11837s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f11838t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11839u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final StringBuilder f11840v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Formatter f11841w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Runnable f11842x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArraySet<o0.a> f11843y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Point f11844z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i11, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2, int i12) {
        super(context, attributeSet, i11);
        this.f11820a = new Rect();
        this.f11821b = new Rect();
        this.f11822c = new Rect();
        this.f11823d = new Rect();
        Paint paint = new Paint();
        this.f11824f = paint;
        Paint paint2 = new Paint();
        this.f11825g = paint2;
        Paint paint3 = new Paint();
        this.f11826h = paint3;
        Paint paint4 = new Paint();
        this.f11827i = paint4;
        Paint paint5 = new Paint();
        this.f11828j = paint5;
        Paint paint6 = new Paint();
        this.f11829k = paint6;
        paint6.setAntiAlias(true);
        this.f11843y = new CopyOnWriteArraySet<>();
        this.f11844z = new Point();
        float f11 = context.getResources().getDisplayMetrics().density;
        this.A = f11;
        this.f11839u = c(f11, -50);
        int iC = c(f11, 4);
        int iC2 = c(f11, 26);
        int iC3 = c(f11, 4);
        int iC4 = c(f11, 12);
        int iC5 = c(f11, 0);
        int iC6 = c(f11, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.DefaultTimeBar, i11, i12);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.f11830l = drawable;
                if (drawable != null) {
                    m(drawable);
                    iC2 = Math.max(drawable.getMinimumHeight(), iC2);
                }
                this.f11831m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, iC);
                this.f11832n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, iC2);
                this.f11833o = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_bar_gravity, 0);
                this.f11834p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, iC3);
                this.f11835q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, iC4);
                this.f11836r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, iC5);
                this.f11837s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, iC6);
                int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, -1);
                int i15 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, -855638017);
                int i16 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i17 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i18 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i13);
                paint6.setColor(i14);
                paint2.setColor(i15);
                paint3.setColor(i16);
                paint4.setColor(i17);
                paint5.setColor(i18);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            this.f11831m = iC;
            this.f11832n = iC2;
            this.f11833o = 0;
            this.f11834p = iC3;
            this.f11835q = iC4;
            this.f11836r = iC5;
            this.f11837s = iC6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f11830l = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f11840v = sb2;
        this.f11841w = new Formatter(sb2, Locale.getDefault());
        this.f11842x = new Runnable() { // from class: androidx.media3.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f12021a.g();
            }
        };
        Drawable drawable2 = this.f11830l;
        if (drawable2 != null) {
            this.f11838t = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f11838t = (Math.max(this.f11836r, Math.max(this.f11835q, this.f11837s)) + 1) / 2;
        }
        this.G = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.F = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f12023a.h(valueAnimator2);
            }
        });
        this.K = C.TIME_UNSET;
        this.C = C.TIME_UNSET;
        this.B = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static int c(float f11, int i11) {
        return (int) ((i11 * f11) + 0.5f);
    }

    private long getPositionIncrement() {
        long j11 = this.C;
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        long j12 = this.K;
        if (j12 == C.TIME_UNSET) {
            return 0L;
        }
        return j12 / ((long) this.B);
    }

    private String getProgressText() {
        return u0.q0(this.f11840v, this.f11841w, this.L);
    }

    private long getScrubberPosition() {
        if (this.f11821b.width() <= 0 || this.K == C.TIME_UNSET) {
            return 0L;
        }
        return (((long) this.f11823d.width()) * this.K) / ((long) this.f11821b.width());
    }

    public static int j(float f11, int i11) {
        return (int) (i11 / f11);
    }

    public static boolean n(Drawable drawable, int i11) {
        return u0.f81838a >= 23 && drawable.setLayoutDirection(i11);
    }

    @Override // androidx.media3.ui.o0
    public void addListener(o0.a aVar) {
        z3.a.e(aVar);
        this.f11843y.add(aVar);
    }

    public final void d(Canvas canvas) {
        int i11;
        if (this.K <= 0) {
            return;
        }
        Rect rect = this.f11823d;
        int iP = u0.p(rect.right, rect.left, this.f11821b.right);
        int iCenterY = this.f11823d.centerY();
        Drawable drawable = this.f11830l;
        if (drawable == null) {
            if (this.I || isFocused()) {
                i11 = this.f11837s;
            } else {
                i11 = isEnabled() ? this.f11835q : this.f11836r;
            }
            canvas.drawCircle(iP, iCenterY, (int) ((i11 * this.G) / 2.0f), this.f11829k);
            return;
        }
        int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.G)) / 2;
        int intrinsicHeight = ((int) (this.f11830l.getIntrinsicHeight() * this.G)) / 2;
        this.f11830l.setBounds(iP - intrinsicWidth, iCenterY - intrinsicHeight, iP + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f11830l.draw(canvas);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        s();
    }

    public final void e(Canvas canvas) {
        int iHeight = this.f11821b.height();
        int iCenterY = this.f11821b.centerY() - (iHeight / 2);
        int i11 = iHeight + iCenterY;
        if (this.K <= 0) {
            Rect rect = this.f11821b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i11, this.f11826h);
            return;
        }
        Rect rect2 = this.f11822c;
        int i12 = rect2.left;
        int i13 = rect2.right;
        int iMax = Math.max(Math.max(this.f11821b.left, i13), this.f11823d.right);
        int i14 = this.f11821b.right;
        if (iMax < i14) {
            canvas.drawRect(iMax, iCenterY, i14, i11, this.f11826h);
        }
        int iMax2 = Math.max(i12, this.f11823d.right);
        if (i13 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i13, i11, this.f11825g);
        }
        if (this.f11823d.width() > 0) {
            Rect rect3 = this.f11823d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i11, this.f11824f);
        }
        if (this.N == 0) {
            return;
        }
        long[] jArr = (long[]) z3.a.e(this.O);
        boolean[] zArr = (boolean[]) z3.a.e(this.P);
        int i15 = this.f11834p / 2;
        for (int i16 = 0; i16 < this.N; i16++) {
            int iWidth = ((int) ((((long) this.f11821b.width()) * u0.q(jArr[i16], 0L, this.K)) / this.K)) - i15;
            Rect rect4 = this.f11821b;
            int iMin = rect4.left + Math.min(rect4.width() - this.f11834p, Math.max(0, iWidth));
            canvas.drawRect(iMin, iCenterY, iMin + this.f11834p, i11, zArr[i16] ? this.f11828j : this.f11827i);
        }
    }

    public final boolean f(float f11, float f12) {
        return this.f11820a.contains((int) f11, (int) f12);
    }

    public final /* synthetic */ void g() {
        q(false);
    }

    @Override // androidx.media3.ui.o0
    public long getPreferredUpdateDelay() {
        int iJ = j(this.A, this.f11821b.width());
        if (iJ != 0) {
            long j11 = this.K;
            if (j11 != 0 && j11 != C.TIME_UNSET) {
                return j11 / ((long) iJ);
            }
        }
        return Long.MAX_VALUE;
    }

    public final /* synthetic */ void h(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f11820a);
    }

    public void hideScrubber(long j11) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.F.setFloatValues(this.G, 0.0f);
        this.F.setDuration(j11);
        this.F.start();
    }

    public void hideScrubber(boolean z11) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = z11;
        this.G = 0.0f;
        invalidate(this.f11820a);
    }

    public final void i(float f11) {
        Rect rect = this.f11823d;
        Rect rect2 = this.f11821b;
        rect.right = u0.p((int) f11, rect2.left, rect2.right);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f11830l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final Point k(MotionEvent motionEvent) {
        this.f11844z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f11844z;
    }

    public final boolean l(long j11) {
        long j12 = this.K;
        if (j12 <= 0) {
            return false;
        }
        long j13 = this.I ? this.J : this.L;
        long jQ = u0.q(j13 + j11, 0L, j12);
        if (jQ == j13) {
            return false;
        }
        if (this.I) {
            t(jQ);
        } else {
            p(jQ);
        }
        r();
        return true;
    }

    public final boolean m(Drawable drawable) {
        return u0.f81838a >= 23 && n(drawable, getLayoutDirection());
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void o(int i11, int i12) {
        Rect rect = this.E;
        if (rect != null && rect.width() == i11 && this.E.height() == i12) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i11, i12);
        this.E = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        e(canvas);
        d(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z11, int i11, @Nullable Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        if (!this.I || z11) {
            return;
        }
        q(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.K <= 0) {
            return;
        }
        if (u0.f81838a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i11 != 66) {
                switch (i11) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (l(positionIncrement)) {
                            removeCallbacks(this.f11842x);
                            postDelayed(this.f11842x, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (l(positionIncrement)) {
                            removeCallbacks(this.f11842x);
                            postDelayed(this.f11842x, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.I) {
                            q(false);
                            return true;
                        }
                        break;
                }
            } else if (this.I) {
                q(false);
                return true;
            }
        }
        return super.onKeyDown(i11, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int paddingBottom;
        int iMax;
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i15 - getPaddingRight();
        int i17 = this.H ? 0 : this.f11838t;
        if (this.f11833o == 1) {
            paddingBottom = (i16 - getPaddingBottom()) - this.f11832n;
            int paddingBottom2 = i16 - getPaddingBottom();
            int i18 = this.f11831m;
            iMax = (paddingBottom2 - i18) - Math.max(i17 - (i18 / 2), 0);
        } else {
            paddingBottom = (i16 - this.f11832n) / 2;
            iMax = (i16 - this.f11831m) / 2;
        }
        this.f11820a.set(paddingLeft, paddingBottom, paddingRight, this.f11832n + paddingBottom);
        Rect rect = this.f11821b;
        Rect rect2 = this.f11820a;
        rect.set(rect2.left + i17, iMax, rect2.right - i17, this.f11831m + iMax);
        if (u0.f81838a >= 29) {
            o(i15, i16);
        }
        r();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (mode == 0) {
            size = this.f11832n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f11832n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i11), size);
        s();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        Drawable drawable = this.f11830l;
        if (drawable == null || !n(drawable, i11)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.K > 0) {
            Point pointK = k(motionEvent);
            int i11 = pointK.x;
            int i12 = pointK.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f11 = i11;
                if (f(f11, i12)) {
                    i(f11);
                    p(getScrubberPosition());
                    r();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.I) {
                    q(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.I) {
                        q(motionEvent.getAction() == 3);
                        return true;
                    }
                }
            } else if (this.I) {
                if (i12 < this.f11839u) {
                    int i13 = this.D;
                    i(i13 + ((i11 - i13) / 3));
                } else {
                    this.D = i11;
                    i(i11);
                }
                t(getScrubberPosition());
                r();
                invalidate();
                return true;
            }
        }
        return false;
    }

    public final void p(long j11) {
        this.J = j11;
        this.I = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<o0.a> it = this.f11843y.iterator();
        while (it.hasNext()) {
            it.next().f(this, j11);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i11, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i11, bundle)) {
            return true;
        }
        if (this.K <= 0) {
            return false;
        }
        if (i11 == 8192) {
            if (l(-getPositionIncrement())) {
                q(false);
            }
        } else {
            if (i11 != 4096) {
                return false;
            }
            if (l(getPositionIncrement())) {
                q(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public final void q(boolean z11) {
        removeCallbacks(this.f11842x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<o0.a> it = this.f11843y.iterator();
        while (it.hasNext()) {
            it.next().r(this, this.J, z11);
        }
    }

    public final void r() {
        this.f11822c.set(this.f11821b);
        this.f11823d.set(this.f11821b);
        long j11 = this.I ? this.J : this.L;
        if (this.K > 0) {
            int iWidth = (int) ((((long) this.f11821b.width()) * this.M) / this.K);
            Rect rect = this.f11822c;
            Rect rect2 = this.f11821b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f11821b.width()) * j11) / this.K);
            Rect rect3 = this.f11823d;
            Rect rect4 = this.f11821b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f11822c;
            int i11 = this.f11821b.left;
            rect5.right = i11;
            this.f11823d.right = i11;
        }
        invalidate(this.f11820a);
    }

    public void removeListener(o0.a aVar) {
        this.f11843y.remove(aVar);
    }

    public final void s() {
        Drawable drawable = this.f11830l;
        if (drawable != null && drawable.isStateful() && this.f11830l.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // androidx.media3.ui.o0
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i11) {
        z3.a.a(i11 == 0 || !(jArr == null || zArr == null));
        this.N = i11;
        this.O = jArr;
        this.P = zArr;
        r();
    }

    public void setAdMarkerColor(int i11) {
        this.f11827i.setColor(i11);
        invalidate(this.f11820a);
    }

    public void setBufferedColor(int i11) {
        this.f11825g.setColor(i11);
        invalidate(this.f11820a);
    }

    @Override // androidx.media3.ui.o0
    public void setBufferedPosition(long j11) {
        if (this.M == j11) {
            return;
        }
        this.M = j11;
        r();
    }

    @Override // androidx.media3.ui.o0
    public void setDuration(long j11) {
        if (this.K == j11) {
            return;
        }
        this.K = j11;
        if (this.I && j11 == C.TIME_UNSET) {
            q(true);
        }
        r();
    }

    @Override // android.view.View, androidx.media3.ui.o0
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        if (!this.I || z11) {
            return;
        }
        q(true);
    }

    public void setKeyCountIncrement(int i11) {
        z3.a.a(i11 > 0);
        this.B = i11;
        this.C = C.TIME_UNSET;
    }

    public void setKeyTimeIncrement(long j11) {
        z3.a.a(j11 > 0);
        this.B = -1;
        this.C = j11;
    }

    public void setPlayedAdMarkerColor(int i11) {
        this.f11828j.setColor(i11);
        invalidate(this.f11820a);
    }

    public void setPlayedColor(int i11) {
        this.f11824f.setColor(i11);
        invalidate(this.f11820a);
    }

    @Override // androidx.media3.ui.o0
    public void setPosition(long j11) {
        if (this.L == j11) {
            return;
        }
        this.L = j11;
        setContentDescription(getProgressText());
        r();
    }

    public void setScrubberColor(int i11) {
        this.f11829k.setColor(i11);
        invalidate(this.f11820a);
    }

    public void setUnplayedColor(int i11) {
        this.f11826h.setColor(i11);
        invalidate(this.f11820a);
    }

    public void showScrubber() {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.G = 1.0f;
        invalidate(this.f11820a);
    }

    public void showScrubber(long j11) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.F.setFloatValues(this.G, 1.0f);
        this.F.setDuration(j11);
        this.F.start();
    }

    public final void t(long j11) {
        if (this.J == j11) {
            return;
        }
        this.J = j11;
        Iterator<o0.a> it = this.f11843y.iterator();
        while (it.hasNext()) {
            it.next().p(this, j11);
        }
    }
}
