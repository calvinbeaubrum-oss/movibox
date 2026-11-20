package com.transsion.photoview;

import android.annotation.SuppressLint;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PhotoViewAttachment implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f54111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GestureDetector f54112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsion.photoview.b f54113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f54114l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View.OnClickListener f54120r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View.OnLongClickListener f54121s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FlingRunnable f54122t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f54125w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.transsion.photoview.c f54128z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Interpolator f54104a = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54105b = 200;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f54106c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f54107d = 1.75f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f54108f = 3.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54109g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54110h = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f54115m = new Matrix();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f54116n = new Matrix();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Matrix f54117o = new Matrix();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f54118p = new RectF();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float[] f54119q = new float[9];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f54123u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f54124v = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f54126x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView.ScaleType f54127y = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: compiled from: source.java */
    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f11, float f12, float f13, float f14) {
            this.mFocalX = f13;
            this.mFocalY = f14;
            this.mZoomStart = f11;
            this.mZoomEnd = f12;
        }

        private float interpolate() {
            return PhotoViewAttachment.this.f54104a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.mStartTime) * 1.0f) / PhotoViewAttachment.this.f54105b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fInterpolate = interpolate();
            float f11 = this.mZoomStart;
            PhotoViewAttachment.this.f54128z.d((f11 + ((this.mZoomEnd - f11) * fInterpolate)) / PhotoViewAttachment.this.M(), this.mFocalX, this.mFocalY);
            if (fInterpolate < 1.0f) {
                com.transsion.photoview.a.a(PhotoViewAttachment.this.f54111i, this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i11, int i12, int i13, int i14) {
            int i15;
            int iRound;
            int i16;
            int iRound2;
            RectF rectFD = PhotoViewAttachment.this.D();
            if (rectFD == null) {
                return;
            }
            int iRound3 = Math.round(-rectFD.left);
            float f11 = i11;
            if (f11 < rectFD.width()) {
                iRound = Math.round(rectFD.width() - f11);
                i15 = 0;
            } else {
                i15 = iRound3;
                iRound = i15;
            }
            int iRound4 = Math.round(-rectFD.top);
            float f12 = i12;
            if (f12 < rectFD.height()) {
                iRound2 = Math.round(rectFD.height() - f12);
                i16 = 0;
            } else {
                i16 = iRound4;
                iRound2 = i16;
            }
            this.mCurrentX = iRound3;
            this.mCurrentY = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.mScroller.fling(iRound3, iRound4, i13, i14, i15, iRound, i16, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttachment.this.f54117o.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttachment.this.A();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                com.transsion.photoview.a.a(PhotoViewAttachment.this.f54111i, this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements com.transsion.photoview.c {
        public a() {
        }

        @Override // com.transsion.photoview.c
        public void b(float f11, float f12) {
            if (PhotoViewAttachment.this.f54113k.g()) {
                return;
            }
            PhotoViewAttachment.j(PhotoViewAttachment.this);
            PhotoViewAttachment.this.f54117o.postTranslate(f11, f12);
            PhotoViewAttachment.this.A();
            ViewParent parent = PhotoViewAttachment.this.f54111i.getParent();
            if (!PhotoViewAttachment.this.f54109g || PhotoViewAttachment.this.f54113k.g() || PhotoViewAttachment.this.f54110h) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((PhotoViewAttachment.this.f54123u == 2 || ((PhotoViewAttachment.this.f54123u == 0 && f11 >= 1.0f) || ((PhotoViewAttachment.this.f54123u == 1 && f11 <= -1.0f) || ((PhotoViewAttachment.this.f54124v == 0 && f12 >= 1.0f) || (PhotoViewAttachment.this.f54124v == 1 && f12 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
                PhotoViewAttachment.this.f54114l.e(PhotoViewAttachment.this.M(), PhotoViewAttachment.this.f54113k.d(), PhotoViewAttachment.this.f54113k.e());
            }
        }

        @Override // com.transsion.photoview.c
        public void c(float f11, float f12, float f13, float f14, float f15) {
            if (PhotoViewAttachment.this.f54114l.h()) {
                return;
            }
            if (PhotoViewAttachment.this.M() < PhotoViewAttachment.this.f54108f || f11 < 1.0f) {
                PhotoViewAttachment.m(PhotoViewAttachment.this);
                PhotoViewAttachment.this.f54117o.postScale(f11, f11, f12, f13);
                PhotoViewAttachment.this.f54117o.postTranslate(f14, f15);
                PhotoViewAttachment.this.A();
            }
        }

        @Override // com.transsion.photoview.c
        public void d(float f11, float f12, float f13) {
            c(f11, f12, f13, 0.0f, 0.0f);
        }

        @Override // com.transsion.photoview.c
        public void e(float f11, float f12, float f13, float f14) {
            PhotoViewAttachment photoViewAttachment = PhotoViewAttachment.this;
            photoViewAttachment.f54122t = photoViewAttachment.new FlingRunnable(photoViewAttachment.f54111i.getContext());
            FlingRunnable flingRunnable = PhotoViewAttachment.this.f54122t;
            PhotoViewAttachment photoViewAttachment2 = PhotoViewAttachment.this;
            int I = photoViewAttachment2.I(photoViewAttachment2.f54111i);
            PhotoViewAttachment photoViewAttachment3 = PhotoViewAttachment.this;
            flingRunnable.fling(I, photoViewAttachment3.H(photoViewAttachment3.f54111i), (int) f13, (int) f14);
            PhotoViewAttachment.this.f54111i.post(PhotoViewAttachment.this.f54122t);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            PhotoViewAttachment.o(PhotoViewAttachment.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttachment.this.f54121s != null) {
                PhotoViewAttachment.this.f54121s.onLongClick(PhotoViewAttachment.this.f54111i);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fM = PhotoViewAttachment.this.M();
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                if (fM < PhotoViewAttachment.this.K()) {
                    PhotoViewAttachment photoViewAttachment = PhotoViewAttachment.this;
                    photoViewAttachment.m0(photoViewAttachment.K(), x11, y11, true);
                } else if (fM < PhotoViewAttachment.this.K() || fM >= PhotoViewAttachment.this.J()) {
                    PhotoViewAttachment photoViewAttachment2 = PhotoViewAttachment.this;
                    photoViewAttachment2.m0(photoViewAttachment2.L(), x11, y11, true);
                } else {
                    PhotoViewAttachment photoViewAttachment3 = PhotoViewAttachment.this;
                    photoViewAttachment3.m0(photoViewAttachment3.J(), x11, y11, true);
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
            if (PhotoViewAttachment.this.f54120r != null) {
                PhotoViewAttachment.this.f54120r.onClick(PhotoViewAttachment.this.f54111i);
            }
            RectF rectFD = PhotoViewAttachment.this.D();
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            PhotoViewAttachment.r(PhotoViewAttachment.this);
            if (rectFD == null) {
                return false;
            }
            if (!rectFD.contains(x11, y11)) {
                PhotoViewAttachment.k(PhotoViewAttachment.this);
                return false;
            }
            rectFD.width();
            rectFD.height();
            PhotoViewAttachment.l(PhotoViewAttachment.this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54132a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f54132a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54132a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54132a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f54132a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public PhotoViewAttachment(ImageView imageView) {
        a aVar = new a();
        this.f54128z = aVar;
        this.f54111i = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f54125w = 0.0f;
        this.f54113k = new com.transsion.photoview.b(imageView.getContext(), aVar);
        Q(imageView);
        this.f54114l = new n(imageView);
    }

    public static /* bridge */ /* synthetic */ j j(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ e k(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ f l(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ g m(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ h o(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ k r(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    public final void A() {
        if (B()) {
            V(F());
        }
    }

    public final boolean B() {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        RectF rectFE = E(F());
        if (rectFE == null) {
            return false;
        }
        float fHeight = rectFE.height();
        float fWidth = rectFE.width();
        float fH = H(this.f54111i);
        float f16 = 0.0f;
        if (fHeight <= fH) {
            int i11 = d.f54132a[this.f54127y.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f14 = (fH - fHeight) / 2.0f;
                    f15 = rectFE.top;
                } else {
                    f14 = fH - fHeight;
                    f15 = rectFE.top;
                }
                f11 = f14 - f15;
            } else {
                f11 = -rectFE.top;
            }
            this.f54124v = 2;
        } else {
            float f17 = rectFE.top;
            if (f17 > 0.0f) {
                this.f54124v = 0;
                f11 = -f17;
            } else {
                float f18 = rectFE.bottom;
                if (f18 < fH) {
                    this.f54124v = 1;
                    f11 = fH - f18;
                } else {
                    this.f54124v = -1;
                    f11 = 0.0f;
                }
            }
        }
        float fI = I(this.f54111i);
        if (fWidth <= fI) {
            int i12 = d.f54132a[this.f54127y.ordinal()];
            if (i12 != 2) {
                if (i12 != 3) {
                    f12 = (fI - fWidth) / 2.0f;
                    f13 = rectFE.left;
                } else {
                    f12 = fI - fWidth;
                    f13 = rectFE.left;
                }
                f16 = f12 - f13;
            } else {
                f16 = -rectFE.left;
            }
            this.f54123u = 2;
        } else {
            float f19 = rectFE.left;
            if (f19 > 0.0f) {
                this.f54123u = 0;
                f16 = -f19;
            } else {
                float f21 = rectFE.right;
                if (f21 < fI) {
                    f16 = fI - f21;
                    this.f54123u = 1;
                } else {
                    this.f54123u = -1;
                }
            }
        }
        this.f54117o.postTranslate(f16, f11);
        return true;
    }

    public void C(Matrix matrix) {
        matrix.set(F());
    }

    public RectF D() {
        B();
        return E(F());
    }

    public final RectF E(Matrix matrix) {
        Drawable drawable = this.f54111i.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f54118p.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.f54118p);
        return this.f54118p;
    }

    public final Matrix F() {
        this.f54116n.set(this.f54115m);
        this.f54116n.postConcat(this.f54117o);
        return this.f54116n;
    }

    public Matrix G() {
        return this.f54116n;
    }

    public final int H(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int I(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingStart()) - imageView.getPaddingEnd();
    }

    public float J() {
        return this.f54108f;
    }

    public float K() {
        return this.f54107d;
    }

    public float L() {
        return this.f54106c;
    }

    public float M() {
        return (float) Math.sqrt(((float) Math.pow(P(this.f54117o, 0), 2.0d)) + ((float) Math.pow(P(this.f54117o, 3), 2.0d)));
    }

    public ImageView.ScaleType N() {
        return this.f54127y;
    }

    public void O(Matrix matrix) {
        matrix.set(this.f54117o);
    }

    public final float P(Matrix matrix, int i11) {
        matrix.getValues(this.f54119q);
        return this.f54119q[i11];
    }

    public final void Q(ImageView imageView) {
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f54112j = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public boolean R() {
        return this.f54126x;
    }

    public final void S() {
        this.f54117o.reset();
        j0(this.f54125w);
        V(F());
        B();
    }

    public void T(boolean z11) {
        this.f54109g = z11;
    }

    public boolean U(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f54111i.getDrawable() == null) {
            return false;
        }
        this.f54117o.set(matrix);
        A();
        return true;
    }

    public final void V(Matrix matrix) {
        this.f54111i.setImageMatrix(matrix);
    }

    public void W(float f11) {
        o.a(this.f54106c, this.f54107d, f11);
        this.f54108f = f11;
    }

    public void X(float f11) {
        o.a(this.f54106c, f11, this.f54108f);
        this.f54107d = f11;
    }

    public void Y(float f11) {
        o.a(f11, this.f54107d, this.f54108f);
        this.f54106c = f11;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.f54120r = onClickListener;
    }

    public void a0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f54112j.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void b0(View.OnLongClickListener onLongClickListener) {
        this.f54121s = onLongClickListener;
    }

    public void c0(com.transsion.photoview.d dVar) {
    }

    public void d0(e eVar) {
    }

    public void e0(f fVar) {
    }

    public void f0(g gVar) {
    }

    public void g0(h hVar) {
    }

    public void h0(j jVar) {
    }

    public void i0(k kVar) {
    }

    public void j0(float f11) {
        this.f54117o.postRotate(f11 % 360.0f);
        A();
    }

    public void k0(float f11) {
        this.f54117o.setRotate(f11 % 360.0f);
        A();
    }

    public void l0(float f11) {
        n0(f11, false);
    }

    public void m0(float f11, float f12, float f13, boolean z11) {
        if (f11 < this.f54106c || f11 > this.f54108f) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z11) {
            this.f54111i.post(new AnimatedZoomRunnable(M(), f11, f12, f13));
        } else {
            this.f54117o.setScale(f11, f11, f12, f13);
            A();
        }
    }

    public void n0(float f11, boolean z11) {
        m0(f11, this.f54111i.getRight() / 2.0f, this.f54111i.getBottom() / 2.0f, z11);
    }

    public void o0(float f11, float f12, float f13) {
        o.a(f11, f12, f13);
        this.f54106c = f11;
        this.f54107d = f12;
        this.f54108f = f13;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 == i15 && i12 == i16 && i13 == i17 && i14 == i18) {
            return;
        }
        u0(this.f54111i.getDrawable());
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00af  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b9  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11;
        com.transsion.photoview.b bVar;
        boolean z12;
        GestureDetector gestureDetector;
        boolean zG;
        boolean zF;
        boolean z13;
        boolean z14;
        RectF rectFD;
        boolean z15 = false;
        if (!this.f54126x || !o.d((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (M() < this.f54106c) {
                    RectF rectFD2 = D();
                    if (rectFD2 != null) {
                        view.post(new AnimatedZoomRunnable(M(), this.f54106c, rectFD2.centerX(), rectFD2.centerY()));
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (M() <= this.f54108f || (rectFD = D()) == null) {
                    z11 = false;
                } else {
                    view.post(new AnimatedZoomRunnable(M(), this.f54108f, rectFD.centerX(), rectFD.centerY()));
                    z11 = true;
                }
                this.f54114l.d();
            }
            bVar = this.f54113k;
            if (bVar != null) {
                zG = bVar.g();
                zF = this.f54113k.f();
                boolean zH = this.f54113k.h(motionEvent);
                if (!zG || this.f54113k.g()) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!zF || this.f54113k.f()) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (z13 && z14) {
                    z15 = true;
                }
                this.f54110h = z15;
                z12 = zH;
            } else {
                z12 = z11;
            }
            gestureDetector = this.f54112j;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        z();
        z11 = false;
        bVar = this.f54113k;
        if (bVar != null) {
            zG = bVar.g();
            zF = this.f54113k.f();
            boolean zH2 = this.f54113k.h(motionEvent);
            if (zG) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (zF) {
                z14 = false;
            } else {
                z14 = false;
            }
            if (z13) {
                z15 = true;
            }
            this.f54110h = z15;
            z12 = zH2;
        } else {
            z12 = z11;
        }
        gestureDetector = this.f54112j;
        return gestureDetector == null ? z12 : z12;
    }

    public void p0(ImageView.ScaleType scaleType) {
        if (!o.e(scaleType) || scaleType == this.f54127y) {
            return;
        }
        this.f54127y = scaleType;
        t0();
    }

    public void q0(i iVar) {
        n nVar = this.f54114l;
        if (nVar != null) {
            nVar.k(iVar);
        }
    }

    public void r0(int i11) {
        this.f54105b = i11;
    }

    public void s0(boolean z11) {
        this.f54126x = z11;
        t0();
    }

    public void t0() {
        if (this.f54126x) {
            u0(this.f54111i.getDrawable());
        } else {
            S();
        }
    }

    public final void u0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fI = I(this.f54111i);
        float fH = H(this.f54111i);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f54115m.reset();
        float f11 = intrinsicWidth;
        float f12 = fI / f11;
        float f13 = intrinsicHeight;
        float f14 = fH / f13;
        ImageView.ScaleType scaleType = this.f54127y;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f54115m.postTranslate((fI - f11) / 2.0f, (fH - f13) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f12, f14);
            this.f54115m.postScale(fMax, fMax);
            this.f54115m.postTranslate((fI - (f11 * fMax)) / 2.0f, (fH - (f13 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f12, f14));
            this.f54115m.postScale(fMin, fMin);
            this.f54115m.postTranslate((fI - (f11 * fMin)) / 2.0f, (fH - (f13 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f11, f13);
            RectF rectF2 = new RectF(0.0f, 0.0f, fI, fH);
            if (((int) this.f54125w) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f13, f11);
            }
            int i11 = d.f54132a[this.f54127y.ordinal()];
            if (i11 == 1) {
                this.f54115m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i11 == 2) {
                this.f54115m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i11 == 3) {
                this.f54115m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i11 == 4) {
                this.f54115m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        S();
    }

    public final void z() {
        FlingRunnable flingRunnable = this.f54122t;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.f54122t = null;
        }
    }
}
