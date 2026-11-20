package p013OoooO0;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import q0.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o00Oo0 implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GestureDetector f244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q0.a f245l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f251r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View.OnClickListener f252s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View.OnLongClickListener f253t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public OooOO0 f254u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Interpolator f235a = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f236b = 200;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f237c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f238d = 1.75f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f239f = 3.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f240g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f241h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f242i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f246m = new Matrix();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f247n = new Matrix();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Matrix f248o = new Matrix();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f249p = new RectF();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float[] f250q = new float[9];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f255v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f256w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f257x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView.ScaleType f258y = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public q0.b f259z = new a();

    /* JADX INFO: compiled from: source.java */
    public class OooO implements Runnable {
        public final float OooO00o;
        public final float OooO0O0;
        public final long OooO0OO = System.currentTimeMillis();

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final float f260OooO0Oo;

        /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
        public final float f262OooO0o0;

        public OooO(float f11, float f12, float f13, float f14) {
            this.OooO00o = f13;
            this.OooO0O0 = f14;
            this.f260OooO0Oo = f11;
            this.f262OooO0o0 = f12;
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolation = o00Oo0.this.f235a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.OooO0OO) * 1.0f) / o00Oo0.this.f236b));
            float f11 = this.f260OooO0Oo;
            ((a) o00Oo0.this.f259z).a((((this.f262OooO0o0 - f11) * interpolation) + f11) / o00Oo0.this.k(), this.OooO00o, this.OooO0O0, 0.0f, 0.0f);
            if (interpolation < 1.0f) {
                o00Oo0.this.f243j.postOnAnimation(this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class OooOO0 implements Runnable {
        public final OverScroller OooO00o;
        public int OooO0O0;
        public int OooO0OO;

        public OooOO0(Context context) {
            this.OooO00o = new OverScroller(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.OooO00o.isFinished() && this.OooO00o.computeScrollOffset()) {
                int currX = this.OooO00o.getCurrX();
                int currY = this.OooO00o.getCurrY();
                o00Oo0.this.f248o.postTranslate(this.OooO0O0 - currX, this.OooO0OO - currY);
                o00Oo0.this.c();
                this.OooO0O0 = currX;
                this.OooO0OO = currY;
                o00Oo0.this.f243j.postOnAnimation(this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements q0.b {
        public a() {
        }

        public void a(float f11, float f12, float f13, float f14, float f15) {
            float fK = o00Oo0.this.k();
            o00Oo0 o00oo0 = o00Oo0.this;
            if (fK < o00oo0.f239f || f11 < 1.0f) {
                o00oo0.f248o.postScale(f11, f11, f12, f13);
                o00Oo0.this.f248o.postTranslate(f14, f15);
                o00Oo0.this.c();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            o00Oo0.this.getClass();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            o00Oo0 o00oo0 = o00Oo0.this;
            View.OnLongClickListener onLongClickListener = o00oo0.f253t;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(o00oo0.f243j);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0029 A[Catch: ArrayIndexOutOfBoundsException -> 0x002e, TRY_LEAVE, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x002e, blocks: (B:3:0x0001, B:5:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029), top: B:15:0x0001 }] */
        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fK = o00Oo0.this.k();
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                o00Oo0 o00oo0 = o00Oo0.this;
                float f11 = o00oo0.f238d;
                if (fK < f11) {
                    o00oo0.d(f11, x11, y11, true);
                } else if (fK >= f11) {
                    float f12 = o00oo0.f239f;
                    if (fK < f12) {
                        o00oo0.d(f12, x11, y11, true);
                    } else {
                        o00oo0.d(o00oo0.f237c, x11, y11, true);
                    }
                } else {
                    o00oo0.d(o00oo0.f237c, x11, y11, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            o00Oo0 o00oo0 = o00Oo0.this;
            View.OnClickListener onClickListener = o00oo0.f252s;
            if (onClickListener != null) {
                onClickListener.onClick(o00oo0.f243j);
            }
            RectF rectFH = o00Oo0.this.h();
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            o00Oo0 o00oo1 = o00Oo0.this;
            h hVar = o00oo1.f251r;
            if (hVar != null) {
                hVar.a(o00oo1.f243j, x11, y11);
            }
            if (rectFH == null) {
                return false;
            }
            if (!rectFH.contains(x11, y11)) {
                o00Oo0.this.getClass();
                return false;
            }
            rectFH.width();
            rectFH.height();
            o00Oo0.this.getClass();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f267a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f267a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f267a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f267a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f267a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public o00Oo0(ImageView imageView) {
        this.f243j = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f245l = new q0.a(imageView.getContext(), this.f259z);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f244k = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public final int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final RectF b(Matrix matrix) {
        Drawable drawable = this.f243j.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f249p.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.f249p);
        return this.f249p;
    }

    public final void c() {
        if (g()) {
            this.f243j.setImageMatrix(i());
        }
    }

    public void d(float f11, float f12, float f13, boolean z11) {
        if (f11 < this.f237c || f11 > this.f239f) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z11) {
            this.f243j.post(new OooO(k(), f11, f12, f13));
        } else {
            this.f248o.setScale(f11, f11, f12, f13);
            c();
        }
    }

    public final void e(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float f11 = f(this.f243j);
        float fA = a(this.f243j);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f246m.reset();
        float f12 = intrinsicWidth;
        float f13 = f11 / f12;
        float f14 = intrinsicHeight;
        float f15 = fA / f14;
        ImageView.ScaleType scaleType = this.f258y;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f246m.postTranslate((f11 - f12) / 2.0f, (fA - f14) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f13, f15);
            this.f246m.postScale(fMax, fMax);
            this.f246m.postTranslate((f11 - (f12 * fMax)) / 2.0f, (fA - (f14 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f13, f15));
            this.f246m.postScale(fMin, fMin);
            this.f246m.postTranslate((f11 - (f12 * fMin)) / 2.0f, (fA - (f14 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f12, f14);
            RectF rectF2 = new RectF(0.0f, 0.0f, f11, fA);
            if (((int) 0.0f) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f14, f12);
            }
            int i11 = d.f267a[this.f258y.ordinal()];
            if (i11 == 1) {
                this.f246m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i11 == 2) {
                this.f246m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i11 == 3) {
                this.f246m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i11 == 4) {
                this.f246m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        j();
    }

    public final int f(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final boolean g() {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        RectF rectFB = b(i());
        if (rectFB == null) {
            return false;
        }
        float fHeight = rectFB.height();
        float fWidth = rectFB.width();
        float fA = a(this.f243j);
        float f16 = 0.0f;
        if (fHeight <= fA) {
            int i11 = d.f267a[this.f258y.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f14 = (fA - fHeight) / 2.0f;
                    f15 = rectFB.top;
                } else {
                    f14 = fA - fHeight;
                    f15 = rectFB.top;
                }
                f11 = f14 - f15;
            } else {
                f11 = -rectFB.top;
            }
            this.f256w = 2;
        } else {
            float f17 = rectFB.top;
            if (f17 > 0.0f) {
                this.f256w = 0;
                f11 = -f17;
            } else {
                float f18 = rectFB.bottom;
                if (f18 < fA) {
                    this.f256w = 1;
                    f11 = fA - f18;
                } else {
                    this.f256w = -1;
                    f11 = 0.0f;
                }
            }
        }
        float f19 = f(this.f243j);
        if (fWidth <= f19) {
            int i12 = d.f267a[this.f258y.ordinal()];
            if (i12 != 2) {
                if (i12 != 3) {
                    f12 = (f19 - fWidth) / 2.0f;
                    f13 = rectFB.left;
                } else {
                    f12 = f19 - fWidth;
                    f13 = rectFB.left;
                }
                f16 = f12 - f13;
            } else {
                f16 = -rectFB.left;
            }
            this.f255v = 2;
        } else {
            float f21 = rectFB.left;
            if (f21 > 0.0f) {
                this.f255v = 0;
                f16 = -f21;
            } else {
                float f22 = rectFB.right;
                if (f22 < f19) {
                    f16 = f19 - f22;
                    this.f255v = 1;
                } else {
                    this.f255v = -1;
                }
            }
        }
        this.f248o.postTranslate(f16, f11);
        return true;
    }

    public RectF h() {
        g();
        return b(i());
    }

    public final Matrix i() {
        this.f247n.set(this.f246m);
        this.f247n.postConcat(this.f248o);
        return this.f247n;
    }

    public final void j() {
        this.f248o.reset();
        this.f248o.postRotate(0.0f);
        c();
        this.f243j.setImageMatrix(i());
        g();
    }

    public float k() {
        this.f248o.getValues(this.f250q);
        float fPow = (float) Math.pow(this.f250q[0], 2.0d);
        this.f248o.getValues(this.f250q);
        return (float) Math.sqrt(fPow + ((float) Math.pow(this.f250q[3], 2.0d)));
    }

    public void l() {
        if (this.f257x) {
            e(this.f243j.getDrawable());
        } else {
            j();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 == i15 && i12 == i16 && i13 == i17 && i14 == i18) {
            return;
        }
        e(this.f243j.getDrawable());
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d1  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11;
        q0.a aVar;
        GestureDetector gestureDetector;
        boolean zIsInProgress;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        RectF rectFH;
        if (!this.f257x || ((ImageView) view).getDrawable() == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (k() < this.f237c) {
                    RectF rectFH2 = h();
                    if (rectFH2 != null) {
                        view.post(new OooO(k(), this.f237c, rectFH2.centerX(), rectFH2.centerY()));
                        z11 = true;
                    }
                } else if (k() > this.f239f && (rectFH = h()) != null) {
                    view.post(new OooO(k(), this.f239f, rectFH.centerX(), rectFH.centerY()));
                    z11 = true;
                }
            }
            aVar = this.f245l;
            if (aVar != null) {
                zIsInProgress = aVar.f74107c.isInProgress();
                q0.a aVar2 = this.f245l;
                z12 = aVar2.f74109e;
                try {
                    aVar2.f74107c.onTouchEvent(motionEvent);
                    aVar2.c(motionEvent);
                } catch (IllegalArgumentException unused) {
                }
                if (!zIsInProgress || this.f245l.f74107c.isInProgress()) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z12 || this.f245l.f74109e) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (z13 || !z14) {
                    z15 = false;
                } else {
                    z15 = true;
                }
                this.f241h = z15;
                z11 = true;
            }
            gestureDetector = this.f244k;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                z11 = true;
            }
            this.f242i = motionEvent.getPointerCount() > 1;
            return z11;
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        OooOO0 oooOO0 = this.f254u;
        if (oooOO0 != null) {
            oooOO0.OooO00o.forceFinished(true);
            this.f254u = null;
        }
        z11 = false;
        aVar = this.f245l;
        if (aVar != null) {
            zIsInProgress = aVar.f74107c.isInProgress();
            q0.a aVar3 = this.f245l;
            z12 = aVar3.f74109e;
            aVar3.f74107c.onTouchEvent(motionEvent);
            aVar3.c(motionEvent);
            if (zIsInProgress) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (z12) {
                z14 = false;
            } else {
                z14 = false;
            }
            if (z13) {
                z15 = false;
            } else {
                z15 = false;
            }
            this.f241h = z15;
            z11 = true;
        }
        gestureDetector = this.f244k;
        if (gestureDetector != null) {
            z11 = true;
        }
        this.f242i = motionEvent.getPointerCount() > 1;
        return z11;
    }
}
