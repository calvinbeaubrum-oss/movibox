package com.applovin.exoplayer2.ui;

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
import com.applovin.impl.b1;
import com.applovin.impl.xp;
import com.applovin.sdk.R;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends View implements i {
    private final float A;
    private int B;
    private long C;
    private int D;
    private Rect E;
    private ValueAnimator F;
    private float G;
    private boolean H;
    private boolean I;
    private long J;
    private long K;
    private long L;
    private long M;
    private int N;
    private long[] O;
    private boolean[] P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f17267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f17268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f17269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f17270d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f17271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f17272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f17273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f17274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f17275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Paint f17276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Drawable f17277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f17278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f17279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f17280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f17281p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f17282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f17283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f17284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f17285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f17286u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final StringBuilder f17287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Formatter f17288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Runnable f17289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final CopyOnWriteArraySet f17290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Point f17291z;

    public b(Context context, AttributeSet attributeSet, int i11, AttributeSet attributeSet2) {
        this(context, attributeSet, i11, attributeSet2, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i11, AttributeSet attributeSet2, int i12) {
        super(context, attributeSet, i11);
        this.f17267a = new Rect();
        this.f17268b = new Rect();
        this.f17269c = new Rect();
        this.f17270d = new Rect();
        Paint paint = new Paint();
        this.f17271f = paint;
        Paint paint2 = new Paint();
        this.f17272g = paint2;
        Paint paint3 = new Paint();
        this.f17273h = paint3;
        Paint paint4 = new Paint();
        this.f17274i = paint4;
        Paint paint5 = new Paint();
        this.f17275j = paint5;
        Paint paint6 = new Paint();
        this.f17276k = paint6;
        paint6.setAntiAlias(true);
        this.f17290y = new CopyOnWriteArraySet();
        this.f17291z = new Point();
        float f11 = context.getResources().getDisplayMetrics().density;
        this.A = f11;
        this.f17286u = a(f11, -50);
        int iA = a(f11, 4);
        int iA2 = a(f11, 26);
        int iA3 = a(f11, 4);
        int iA4 = a(f11, 12);
        int iA5 = a(f11, 0);
        int iA6 = a(f11, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinDefaultTimeBar, i11, i12);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.AppLovinDefaultTimeBar_al_scrubber_drawable);
                this.f17277l = drawable;
                if (drawable != null) {
                    a(drawable);
                    iA2 = Math.max(drawable.getMinimumHeight(), iA2);
                }
                this.f17278m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_bar_height, iA);
                this.f17279n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_touch_target_height, iA2);
                this.f17280o = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_bar_gravity, 0);
                this.f17281p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_width, iA3);
                this.f17282q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_enabled_size, iA4);
                this.f17283r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_disabled_size, iA5);
                this.f17284s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_dragged_size, iA6);
                int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_color, -1);
                int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_scrubber_color, -1);
                int i15 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_buffered_color, -855638017);
                int i16 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_unplayed_color, 872415231);
                int i17 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_color, -1291845888);
                int i18 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_ad_marker_color, 872414976);
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
            this.f17278m = iA;
            this.f17279n = iA2;
            this.f17280o = 0;
            this.f17281p = iA3;
            this.f17282q = iA4;
            this.f17283r = iA5;
            this.f17284s = iA6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f17277l = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f17287v = sb2;
        this.f17288w = new Formatter(sb2, Locale.getDefault());
        this.f17289x = new Runnable() { // from class: com.applovin.exoplayer2.ui.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f17398a.a();
            }
        };
        Drawable drawable2 = this.f17277l;
        if (drawable2 != null) {
            this.f17285t = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f17285t = (Math.max(this.f17283r, Math.max(this.f17282q, this.f17284s)) + 1) / 2;
        }
        this.G = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.F = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.applovin.exoplayer2.ui.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f17399a.a(valueAnimator2);
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

    private static int a(float f11, int i11) {
        return (int) ((i11 * f11) + 0.5f);
    }

    private Point a(MotionEvent motionEvent) {
        this.f17291z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f17291z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        a(false);
    }

    private void a(float f11) {
        Rect rect = this.f17270d;
        Rect rect2 = this.f17268b;
        rect.right = xp.a((int) f11, rect2.left, rect2.right);
    }

    private void a(int i11, int i12) {
        Rect rect = this.E;
        if (rect != null && rect.width() == i11 && this.E.height() == i12) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i11, i12);
        this.E = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f17267a);
    }

    private void a(Canvas canvas) {
        int i11;
        if (this.K <= 0) {
            return;
        }
        Rect rect = this.f17270d;
        int iA = xp.a(rect.right, rect.left, this.f17268b.right);
        int iCenterY = this.f17270d.centerY();
        Drawable drawable = this.f17277l;
        if (drawable == null) {
            if (this.I || isFocused()) {
                i11 = this.f17284s;
            } else {
                i11 = isEnabled() ? this.f17282q : this.f17283r;
            }
            canvas.drawCircle(iA, iCenterY, (int) ((i11 * this.G) / 2.0f), this.f17276k);
            return;
        }
        int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.G)) / 2;
        int intrinsicHeight = ((int) (this.f17277l.getIntrinsicHeight() * this.G)) / 2;
        this.f17277l.setBounds(iA - intrinsicWidth, iCenterY - intrinsicHeight, iA + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f17277l.draw(canvas);
    }

    private void a(boolean z11) {
        removeCallbacks(this.f17289x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f17290y.iterator();
        while (it.hasNext()) {
            ((i.a) it.next()).a(this, this.J, z11);
        }
    }

    private boolean a(float f11, float f12) {
        return this.f17267a.contains((int) f11, (int) f12);
    }

    private boolean a(long j11) {
        long j12 = this.K;
        if (j12 <= 0) {
            return false;
        }
        long j13 = this.I ? this.J : this.L;
        long jB = xp.b(j13 + j11, 0L, j12);
        if (jB == j13) {
            return false;
        }
        if (this.I) {
            c(jB);
        } else {
            b(jB);
        }
        b();
        return true;
    }

    private boolean a(Drawable drawable) {
        return xp.f24372a >= 23 && a(drawable, getLayoutDirection());
    }

    private static boolean a(Drawable drawable, int i11) {
        return xp.f24372a >= 23 && drawable.setLayoutDirection(i11);
    }

    private static int b(float f11, int i11) {
        return (int) (i11 / f11);
    }

    private void b() {
        this.f17269c.set(this.f17268b);
        this.f17270d.set(this.f17268b);
        long j11 = this.I ? this.J : this.L;
        if (this.K > 0) {
            int iWidth = (int) ((((long) this.f17268b.width()) * this.M) / this.K);
            Rect rect = this.f17269c;
            Rect rect2 = this.f17268b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f17268b.width()) * j11) / this.K);
            Rect rect3 = this.f17270d;
            Rect rect4 = this.f17268b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f17269c;
            int i11 = this.f17268b.left;
            rect5.right = i11;
            this.f17270d.right = i11;
        }
        invalidate(this.f17267a);
    }

    private void b(long j11) {
        this.J = j11;
        this.I = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f17290y.iterator();
        while (it.hasNext()) {
            ((i.a) it.next()).a(this, j11);
        }
    }

    private void b(Canvas canvas) {
        int iHeight = this.f17268b.height();
        int iCenterY = this.f17268b.centerY() - (iHeight / 2);
        int i11 = iHeight + iCenterY;
        if (this.K <= 0) {
            Rect rect = this.f17268b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i11, this.f17273h);
            return;
        }
        Rect rect2 = this.f17269c;
        int i12 = rect2.left;
        int i13 = rect2.right;
        int iMax = Math.max(Math.max(this.f17268b.left, i13), this.f17270d.right);
        int i14 = this.f17268b.right;
        if (iMax < i14) {
            canvas.drawRect(iMax, iCenterY, i14, i11, this.f17273h);
        }
        int iMax2 = Math.max(i12, this.f17270d.right);
        if (i13 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i13, i11, this.f17272g);
        }
        if (this.f17270d.width() > 0) {
            Rect rect3 = this.f17270d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i11, this.f17271f);
        }
        if (this.N == 0) {
            return;
        }
        long[] jArr = (long[]) b1.a(this.O);
        boolean[] zArr = (boolean[]) b1.a(this.P);
        int i15 = this.f17281p / 2;
        for (int i16 = 0; i16 < this.N; i16++) {
            int iWidth = ((int) ((((long) this.f17268b.width()) * xp.b(jArr[i16], 0L, this.K)) / this.K)) - i15;
            Rect rect4 = this.f17268b;
            int iMin = rect4.left + Math.min(rect4.width() - this.f17281p, Math.max(0, iWidth));
            canvas.drawRect(iMin, iCenterY, iMin + this.f17281p, i11, zArr[i16] ? this.f17275j : this.f17274i);
        }
    }

    private void c() {
        Drawable drawable = this.f17277l;
        if (drawable != null && drawable.isStateful() && this.f17277l.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void c(long j11) {
        if (this.J == j11) {
            return;
        }
        this.J = j11;
        Iterator it = this.f17290y.iterator();
        while (it.hasNext()) {
            ((i.a) it.next()).b(this, j11);
        }
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
        return xp.a(this.f17287v, this.f17288w, this.L);
    }

    private long getScrubberPosition() {
        if (this.f17268b.width() <= 0 || this.K == C.TIME_UNSET) {
            return 0L;
        }
        return (((long) this.f17270d.width()) * this.K) / ((long) this.f17268b.width());
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void a(i.a aVar) {
        b1.a(aVar);
        this.f17290y.add(aVar);
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void a(long[] jArr, boolean[] zArr, int i11) {
        b1.a(i11 == 0 || !(jArr == null || zArr == null));
        this.N = i11;
        this.O = jArr;
        this.P = zArr;
        b();
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c();
    }

    @Override // com.applovin.exoplayer2.ui.i
    public long getPreferredUpdateDelay() {
        int iB = b(this.A, this.f17268b.width());
        if (iB != 0) {
            long j11 = this.K;
            if (j11 != 0 && j11 != C.TIME_UNSET) {
                return j11 / ((long) iB);
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f17277l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        b(canvas);
        a(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        if (!this.I || z11) {
            return;
        }
        a(false);
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
        if (xp.f24372a >= 21) {
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
                        if (a(positionIncrement)) {
                            removeCallbacks(this.f17289x);
                            postDelayed(this.f17289x, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (a(positionIncrement)) {
                            removeCallbacks(this.f17289x);
                            postDelayed(this.f17289x, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.I) {
                            a(false);
                            return true;
                        }
                        break;
                }
            } else if (this.I) {
                a(false);
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
        int i17 = this.H ? 0 : this.f17285t;
        if (this.f17280o == 1) {
            paddingBottom = (i16 - getPaddingBottom()) - this.f17279n;
            int paddingBottom2 = i16 - getPaddingBottom();
            int i18 = this.f17278m;
            iMax = (paddingBottom2 - i18) - Math.max(i17 - (i18 / 2), 0);
        } else {
            paddingBottom = (i16 - this.f17279n) / 2;
            iMax = (i16 - this.f17278m) / 2;
        }
        this.f17267a.set(paddingLeft, paddingBottom, paddingRight, this.f17279n + paddingBottom);
        Rect rect = this.f17268b;
        Rect rect2 = this.f17267a;
        rect.set(rect2.left + i17, iMax, rect2.right - i17, this.f17278m + iMax);
        if (xp.f24372a >= 29) {
            a(i15, i16);
        }
        b();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (mode == 0) {
            size = this.f17279n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f17279n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i11), size);
        c();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        Drawable drawable = this.f17277l;
        if (drawable == null || !a(drawable, i11)) {
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
            Point pointA = a(motionEvent);
            int i11 = pointA.x;
            int i12 = pointA.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f11 = i11;
                if (a(f11, i12)) {
                    a(f11);
                    b(getScrubberPosition());
                    b();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.I) {
                    a(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.I) {
                        a(motionEvent.getAction() == 3);
                        return true;
                    }
                }
            } else if (this.I) {
                if (i12 < this.f17286u) {
                    int i13 = this.D;
                    a(i13 + ((i11 - i13) / 3));
                } else {
                    this.D = i11;
                    a(i11);
                }
                c(getScrubberPosition());
                b();
                invalidate();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i11, Bundle bundle) {
        if (super.performAccessibilityAction(i11, bundle)) {
            return true;
        }
        if (this.K <= 0) {
            return false;
        }
        if (i11 == 8192) {
            if (a(-getPositionIncrement())) {
                a(false);
            }
        } else {
            if (i11 != 4096) {
                return false;
            }
            if (a(getPositionIncrement())) {
                a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(int i11) {
        this.f17274i.setColor(i11);
        invalidate(this.f17267a);
    }

    public void setBufferedColor(int i11) {
        this.f17272g.setColor(i11);
        invalidate(this.f17267a);
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void setBufferedPosition(long j11) {
        if (this.M == j11) {
            return;
        }
        this.M = j11;
        b();
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void setDuration(long j11) {
        if (this.K == j11) {
            return;
        }
        this.K = j11;
        if (this.I && j11 == C.TIME_UNSET) {
            a(true);
        }
        b();
    }

    @Override // android.view.View, com.applovin.exoplayer2.ui.i
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        if (!this.I || z11) {
            return;
        }
        a(true);
    }

    public void setKeyCountIncrement(int i11) {
        b1.a(i11 > 0);
        this.B = i11;
        this.C = C.TIME_UNSET;
    }

    public void setKeyTimeIncrement(long j11) {
        b1.a(j11 > 0);
        this.B = -1;
        this.C = j11;
    }

    public void setPlayedAdMarkerColor(int i11) {
        this.f17275j.setColor(i11);
        invalidate(this.f17267a);
    }

    public void setPlayedColor(int i11) {
        this.f17271f.setColor(i11);
        invalidate(this.f17267a);
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void setPosition(long j11) {
        if (this.L == j11) {
            return;
        }
        this.L = j11;
        setContentDescription(getProgressText());
        b();
    }

    public void setScrubberColor(int i11) {
        this.f17276k.setColor(i11);
        invalidate(this.f17267a);
    }

    public void setUnplayedColor(int i11) {
        this.f17273h.setColor(i11);
        invalidate(this.f17267a);
    }
}
