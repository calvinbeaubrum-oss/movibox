package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final boolean S;
    public static final List<String> T;
    public static final Executor U;
    public Canvas A;
    public Rect B;
    public RectF C;
    public Paint D;
    public Rect E;
    public Rect F;
    public RectF G;
    public RectF H;
    public Matrix I;
    public Matrix J;
    public boolean K;

    @Nullable
    public AsyncUpdates L;
    public final ValueAnimator.AnimatorUpdateListener M;
    public final Semaphore N;
    public Handler O;
    public Runnable P;
    public final Runnable Q;
    public float R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f15038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g7.i f15039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OnVisibleAction f15043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<a> f15044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public z6.b f15045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public String f15046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public z6.a f15047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Map<String, Typeface> f15048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public String f15049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k0 f15050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f15052p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.model.layer.b f15053q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15054r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15055s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15056t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15057u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15058v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RenderMode f15059w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15060x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Matrix f15061y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Bitmap f15062z;

    /* JADX INFO: compiled from: source.java */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        void a(h hVar);
    }

    static {
        S = Build.VERSION.SDK_INT <= 25;
        T = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        U = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new g7.g());
    }

    public LottieDrawable() {
        g7.i iVar = new g7.i();
        this.f15039b = iVar;
        this.f15040c = true;
        this.f15041d = false;
        this.f15042f = false;
        this.f15043g = OnVisibleAction.NONE;
        this.f15044h = new ArrayList<>();
        this.f15050n = new k0();
        this.f15051o = false;
        this.f15052p = true;
        this.f15054r = 255;
        this.f15058v = false;
        this.f15059w = RenderMode.AUTOMATIC;
        this.f15060x = false;
        this.f15061y = new Matrix();
        this.K = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f15324a.p0(valueAnimator);
            }
        };
        this.M = animatorUpdateListener;
        this.N = new Semaphore(1);
        this.Q = new Runnable() { // from class: com.airbnb.lottie.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15074a.r0();
            }
        };
        this.R = -3.4028235E38f;
        iVar.addUpdateListener(animatorUpdateListener);
    }

    public final void A() {
        h hVar = this.f15038a;
        if (hVar == null) {
            return;
        }
        this.f15060x = this.f15059w.useSoftwareRendering(Build.VERSION.SDK_INT, hVar.q(), hVar.m());
    }

    public final /* synthetic */ void A0(int i11, int i12, h hVar) {
        i1(i11, i12);
    }

    public final boolean A1() {
        h hVar = this.f15038a;
        if (hVar == null) {
            return false;
        }
        float f11 = this.R;
        float fL = this.f15039b.l();
        this.R = fL;
        return Math.abs(fL - f11) * hVar.d() >= 50.0f;
    }

    public final void B(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final /* synthetic */ void B0(float f11, float f12, h hVar) {
        l1(f11, f12);
    }

    @Nullable
    public Bitmap B1(String str, @Nullable Bitmap bitmap) {
        z6.b bVarS = S();
        if (bVarS == null) {
            g7.f.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapE = bVarS.e(str, bitmap);
        invalidateSelf();
        return bitmapE;
    }

    public final void C(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final /* synthetic */ void C0(int i11, h hVar) {
        m1(i11);
    }

    public boolean C1() {
        return this.f15048l == null && this.f15038a.c().q() > 0;
    }

    @Deprecated
    public void D() {
    }

    public final /* synthetic */ void D0(String str, h hVar) {
        n1(str);
    }

    public final void E(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        h hVar = this.f15038a;
        if (bVar == null || hVar == null) {
            return;
        }
        this.f15061y.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.f15061y.preScale(bounds.width() / hVar.b().width(), bounds.height() / hVar.b().height());
            this.f15061y.preTranslate(bounds.left, bounds.top);
        }
        bVar.h(canvas, this.f15061y, this.f15054r);
    }

    public final /* synthetic */ void E0(float f11, h hVar) {
        o1(f11);
    }

    public void F(LottieFeatureFlag lottieFeatureFlag, boolean z11) {
        boolean zA = this.f15050n.a(lottieFeatureFlag, z11);
        if (this.f15038a == null || !zA) {
            return;
        }
        x();
    }

    public final /* synthetic */ void F0(float f11, h hVar) {
        r1(f11);
    }

    public void G() {
        this.f15044h.clear();
        this.f15039b.k();
        if (isVisible()) {
            return;
        }
        this.f15043g = OnVisibleAction.NONE;
    }

    public void G0() {
        this.f15044h.clear();
        this.f15039b.s();
        if (isVisible()) {
            return;
        }
        this.f15043g = OnVisibleAction.NONE;
    }

    public final void H(int i11, int i12) {
        Bitmap bitmap = this.f15062z;
        if (bitmap == null || bitmap.getWidth() < i11 || this.f15062z.getHeight() < i12) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.f15062z = bitmapCreateBitmap;
            this.A.setBitmap(bitmapCreateBitmap);
            this.K = true;
            return;
        }
        if (this.f15062z.getWidth() > i11 || this.f15062z.getHeight() > i12) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f15062z, 0, 0, i11, i12);
            this.f15062z = bitmapCreateBitmap2;
            this.A.setBitmap(bitmapCreateBitmap2);
            this.K = true;
        }
    }

    public void H0() {
        if (this.f15053q == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15333a.s0(hVar);
                }
            });
            return;
        }
        A();
        if (w() || c0() == 0) {
            if (isVisible()) {
                this.f15039b.t();
                this.f15043g = OnVisibleAction.NONE;
            } else {
                this.f15043g = OnVisibleAction.PLAY;
            }
        }
        if (w()) {
            return;
        }
        a7.g gVarW = W();
        if (gVarW != null) {
            a1((int) gVarW.f436b);
        } else {
            a1((int) (e0() < 0.0f ? Y() : X()));
        }
        this.f15039b.k();
        if (isVisible()) {
            return;
        }
        this.f15043g = OnVisibleAction.NONE;
    }

    public final void I() {
        if (this.A != null) {
            return;
        }
        this.A = new Canvas();
        this.H = new RectF();
        this.I = new Matrix();
        this.J = new Matrix();
        this.B = new Rect();
        this.C = new RectF();
        this.D = new w6.a();
        this.E = new Rect();
        this.F = new Rect();
        this.G = new RectF();
    }

    public void I0() {
        this.f15039b.removeAllListeners();
    }

    public AsyncUpdates J() {
        AsyncUpdates asyncUpdates = this.L;
        return asyncUpdates != null ? asyncUpdates : d.d();
    }

    public void J0() {
        this.f15039b.removeAllUpdateListeners();
        this.f15039b.addUpdateListener(this.M);
    }

    public boolean K() {
        return J() == AsyncUpdates.ENABLED;
    }

    public void K0(Animator.AnimatorListener animatorListener) {
        this.f15039b.removeListener(animatorListener);
    }

    @Nullable
    public Bitmap L(String str) {
        z6.b bVarS = S();
        if (bVarS != null) {
            return bVarS.a(str);
        }
        return null;
    }

    @RequiresApi(api = 19)
    public void L0(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f15039b.removePauseListener(animatorPauseListener);
    }

    public boolean M() {
        return this.f15058v;
    }

    public void M0(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f15039b.removeUpdateListener(animatorUpdateListener);
    }

    public boolean N() {
        return this.f15052p;
    }

    public final void N0(Canvas canvas, com.airbnb.lottie.model.layer.b bVar) {
        if (this.f15038a == null || bVar == null) {
            return;
        }
        I();
        canvas.getMatrix(this.I);
        canvas.getClipBounds(this.B);
        B(this.B, this.C);
        this.I.mapRect(this.C);
        C(this.C, this.B);
        if (this.f15052p) {
            this.H.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            bVar.f(this.H, null, false);
        }
        this.I.mapRect(this.H);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        R0(this.H, fWidth, fHeight);
        if (!j0()) {
            RectF rectF = this.H;
            Rect rect = this.B;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.H.width());
        int iCeil2 = (int) Math.ceil(this.H.height());
        if (iCeil <= 0 || iCeil2 <= 0) {
            return;
        }
        H(iCeil, iCeil2);
        if (this.K) {
            this.f15061y.set(this.I);
            this.f15061y.preScale(fWidth, fHeight);
            Matrix matrix = this.f15061y;
            RectF rectF2 = this.H;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.f15062z.eraseColor(0);
            bVar.h(this.A, this.f15061y, this.f15054r);
            this.I.invert(this.J);
            this.J.mapRect(this.G, this.H);
            C(this.G, this.F);
        }
        this.E.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.f15062z, this.E, this.F, this.D);
    }

    public h O() {
        return this.f15038a;
    }

    public List<a7.d> O0(a7.d dVar) {
        if (this.f15053q == null) {
            g7.f.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f15053q.e(dVar, 0, arrayList, new a7.d(new String[0]));
        return arrayList;
    }

    @Nullable
    public final Context P() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void P0() {
        if (this.f15053q == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.h0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15119a.t0(hVar);
                }
            });
            return;
        }
        A();
        if (w() || c0() == 0) {
            if (isVisible()) {
                this.f15039b.z();
                this.f15043g = OnVisibleAction.NONE;
            } else {
                this.f15043g = OnVisibleAction.RESUME;
            }
        }
        if (w()) {
            return;
        }
        a1((int) (e0() < 0.0f ? Y() : X()));
        this.f15039b.k();
        if (isVisible()) {
            return;
        }
        this.f15043g = OnVisibleAction.NONE;
    }

    public final z6.a Q() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f15047k == null) {
            z6.a aVar = new z6.a(getCallback(), null);
            this.f15047k = aVar;
            String str = this.f15049m;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.f15047k;
    }

    public void Q0() {
        this.f15039b.A();
    }

    public int R() {
        return (int) this.f15039b.m();
    }

    public final void R0(RectF rectF, float f11, float f12) {
        rectF.set(rectF.left * f11, rectF.top * f12, rectF.right * f11, rectF.bottom * f12);
    }

    public final z6.b S() {
        z6.b bVar = this.f15045i;
        if (bVar != null && !bVar.b(P())) {
            this.f15045i = null;
        }
        if (this.f15045i == null) {
            this.f15045i = new z6.b(getCallback(), this.f15046j, null, this.f15038a.j());
        }
        return this.f15045i;
    }

    public void S0(boolean z11) {
        this.f15057u = z11;
    }

    @Nullable
    public String T() {
        return this.f15046j;
    }

    public void T0(@Nullable AsyncUpdates asyncUpdates) {
        this.L = asyncUpdates;
    }

    @Nullable
    public l0 U(String str) {
        h hVar = this.f15038a;
        if (hVar == null) {
            return null;
        }
        return hVar.j().get(str);
    }

    public void U0(boolean z11) {
        if (z11 != this.f15058v) {
            this.f15058v = z11;
            invalidateSelf();
        }
    }

    public boolean V() {
        return this.f15051o;
    }

    public void V0(boolean z11) {
        if (z11 != this.f15052p) {
            this.f15052p = z11;
            com.airbnb.lottie.model.layer.b bVar = this.f15053q;
            if (bVar != null) {
                bVar.S(z11);
            }
            invalidateSelf();
        }
    }

    public final a7.g W() {
        Iterator<String> it = T.iterator();
        a7.g gVarL = null;
        while (it.hasNext()) {
            gVarL = this.f15038a.l(it.next());
            if (gVarL != null) {
                break;
            }
        }
        return gVarL;
    }

    public boolean W0(h hVar) {
        if (this.f15038a == hVar) {
            return false;
        }
        this.K = true;
        z();
        this.f15038a = hVar;
        x();
        this.f15039b.B(hVar);
        r1(this.f15039b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f15044h).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(hVar);
            }
            it.remove();
        }
        this.f15044h.clear();
        hVar.v(this.f15055s);
        A();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public float X() {
        return this.f15039b.o();
    }

    public void X0(String str) {
        this.f15049m = str;
        z6.a aVarQ = Q();
        if (aVarQ != null) {
            aVarQ.c(str);
        }
    }

    public float Y() {
        return this.f15039b.p();
    }

    public void Y0(com.airbnb.lottie.a aVar) {
        z6.a aVar2 = this.f15047k;
        if (aVar2 != null) {
            aVar2.d(aVar);
        }
    }

    @Nullable
    public PerformanceTracker Z() {
        h hVar = this.f15038a;
        if (hVar != null) {
            return hVar.n();
        }
        return null;
    }

    public void Z0(@Nullable Map<String, Typeface> map) {
        if (map == this.f15048l) {
            return;
        }
        this.f15048l = map;
        invalidateSelf();
    }

    public float a0() {
        return this.f15039b.l();
    }

    public void a1(final int i11) {
        if (this.f15038a == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15334a.u0(i11, hVar);
                }
            });
        } else {
            this.f15039b.C(i11);
        }
    }

    public RenderMode b0() {
        return this.f15060x ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void b1(boolean z11) {
        this.f15041d = z11;
    }

    public int c0() {
        return this.f15039b.getRepeatCount();
    }

    public void c1(b bVar) {
        z6.b bVar2 = this.f15045i;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    @SuppressLint({"WrongConstant"})
    public int d0() {
        return this.f15039b.getRepeatMode();
    }

    public void d1(@Nullable String str) {
        this.f15046j = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float fP;
        float fL;
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        if (bVar == null) {
            return;
        }
        boolean zK = K();
        if (zK) {
            try {
                this.N.acquire();
            } catch (InterruptedException unused) {
                if (!zK) {
                    return;
                } else {
                    if ((fP > fL ? 1 : (fP == fL ? 0 : -1)) == 0) {
                        return;
                    }
                }
            } finally {
                if (d.g()) {
                    d.c("Drawable#draw");
                }
                if (zK) {
                    this.N.release();
                    if (bVar.P() != this.f15039b.l()) {
                        U.execute(this.Q);
                    }
                }
            }
        }
        if (d.g()) {
            d.b("Drawable#draw");
        }
        if (zK && A1()) {
            r1(this.f15039b.l());
        }
        if (this.f15042f) {
            try {
                if (this.f15060x) {
                    N0(canvas, bVar);
                } else {
                    E(canvas);
                }
            } catch (Throwable th2) {
                g7.f.b("Lottie crashed in draw!", th2);
            }
        } else if (this.f15060x) {
            N0(canvas, bVar);
        } else {
            E(canvas);
        }
        this.K = false;
    }

    public float e0() {
        return this.f15039b.q();
    }

    public void e1(boolean z11) {
        this.f15051o = z11;
    }

    @Nullable
    public u0 f0() {
        return null;
    }

    public void f1(final int i11) {
        if (this.f15038a == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.g0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15099a.w0(i11, hVar);
                }
            });
        } else {
            this.f15039b.D(i11 + 0.99f);
        }
    }

    @Nullable
    public Typeface g0(a7.b bVar) {
        Map<String, Typeface> map = this.f15048l;
        if (map != null) {
            String strA = bVar.a();
            if (map.containsKey(strA)) {
                return map.get(strA);
            }
            String strB = bVar.b();
            if (map.containsKey(strB)) {
                return map.get(strB);
            }
            String str = bVar.a() + "-" + bVar.c();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        z6.a aVarQ = Q();
        if (aVarQ != null) {
            return aVarQ.b(bVar);
        }
        return null;
    }

    public void g1(final String str) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.i0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15123a.v0(str, hVar2);
                }
            });
            return;
        }
        a7.g gVarL = hVar.l(str);
        if (gVarL != null) {
            f1((int) (gVarL.f436b + gVarL.f437c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f15054r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        h hVar = this.f15038a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        h hVar = this.f15038a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0() {
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        return bVar != null && bVar.Q();
    }

    public void h1(final float f11) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15331a.x0(f11, hVar2);
                }
            });
        } else {
            this.f15039b.D(g7.k.i(hVar.p(), this.f15038a.f(), f11));
        }
    }

    public boolean i0() {
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        return bVar != null && bVar.R();
    }

    public void i1(final int i11, final int i12) {
        if (this.f15038a == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15336a.A0(i11, i12, hVar);
                }
            });
        } else {
            this.f15039b.E(i11, i12 + 0.99f);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        if (this.K) {
            return;
        }
        this.K = true;
        if ((!S || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return k0();
    }

    public final boolean j0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (parent instanceof ViewGroup) {
            return !((ViewGroup) parent).getClipChildren();
        }
        return false;
    }

    public void j1(final String str) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.z
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15339a.y0(str, hVar2);
                }
            });
            return;
        }
        a7.g gVarL = hVar.l(str);
        if (gVarL != null) {
            int i11 = (int) gVarL.f436b;
            i1(i11, ((int) gVarL.f437c) + i11);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
        }
    }

    public boolean k0() {
        g7.i iVar = this.f15039b;
        if (iVar == null) {
            return false;
        }
        return iVar.isRunning();
    }

    public void k1(final String str, final String str2, final boolean z11) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.j0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15126a.z0(str, str2, z11, hVar2);
                }
            });
            return;
        }
        a7.g gVarL = hVar.l(str);
        if (gVarL == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
        }
        int i11 = (int) gVarL.f436b;
        a7.g gVarL2 = this.f15038a.l(str2);
        if (gVarL2 != null) {
            i1(i11, (int) (gVarL2.f436b + (z11 ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + InstructionFileId.DOT);
    }

    public boolean l0() {
        if (isVisible()) {
            return this.f15039b.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f15043g;
        return onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME;
    }

    public void l1(final float f11, final float f12) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.d0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15088a.B0(f11, f12, hVar2);
                }
            });
        } else {
            i1((int) g7.k.i(hVar.p(), this.f15038a.f(), f11), (int) g7.k.i(this.f15038a.p(), this.f15038a.f(), f12));
        }
    }

    public boolean m0() {
        return this.f15057u;
    }

    public void m1(final int i11) {
        if (this.f15038a == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.e0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15093a.C0(i11, hVar);
                }
            });
        } else {
            this.f15039b.F(i11);
        }
    }

    public boolean n0(LottieFeatureFlag lottieFeatureFlag) {
        return this.f15050n.b(lottieFeatureFlag);
    }

    public void n1(final String str) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15325a.D0(str, hVar2);
                }
            });
            return;
        }
        a7.g gVarL = hVar.l(str);
        if (gVarL != null) {
            m1((int) gVarL.f436b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public final /* synthetic */ void o0(a7.d dVar, Object obj, h7.c cVar, h hVar) {
        v(dVar, obj, cVar);
    }

    public void o1(final float f11) {
        h hVar = this.f15038a;
        if (hVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.f0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    this.f15095a.E0(f11, hVar2);
                }
            });
        } else {
            m1((int) g7.k.i(hVar.p(), this.f15038a.f(), f11));
        }
    }

    public final /* synthetic */ void p0(ValueAnimator valueAnimator) {
        if (K()) {
            invalidateSelf();
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        if (bVar != null) {
            bVar.M(this.f15039b.l());
        }
    }

    public void p1(boolean z11) {
        if (this.f15056t == z11) {
            return;
        }
        this.f15056t = z11;
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        if (bVar != null) {
            bVar.K(z11);
        }
    }

    public final /* synthetic */ void q0() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void q1(boolean z11) {
        this.f15055s = z11;
        h hVar = this.f15038a;
        if (hVar != null) {
            hVar.v(z11);
        }
    }

    public final /* synthetic */ void r0() {
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        if (bVar == null) {
            return;
        }
        try {
            this.N.acquire();
            bVar.M(this.f15039b.l());
            if (S && this.K) {
                if (this.O == null) {
                    this.O = new Handler(Looper.getMainLooper());
                    this.P = new Runnable() { // from class: com.airbnb.lottie.a0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f15073a.q0();
                        }
                    };
                }
                this.O.post(this.P);
            }
        } catch (InterruptedException unused) {
        } finally {
            this.N.release();
        }
    }

    public void r1(final float f11) {
        if (this.f15038a == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.c0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15076a.F0(f11, hVar);
                }
            });
            return;
        }
        if (d.g()) {
            d.b("Drawable#setProgress");
        }
        this.f15039b.C(this.f15038a.h(f11));
        if (d.g()) {
            d.c("Drawable#setProgress");
        }
    }

    public void s(Animator.AnimatorListener animatorListener) {
        this.f15039b.addListener(animatorListener);
    }

    public final /* synthetic */ void s0(h hVar) {
        H0();
    }

    public void s1(RenderMode renderMode) {
        this.f15059w = renderMode;
        A();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f15054r = i11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        g7.f.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        boolean z13 = !isVisible();
        boolean visible = super.setVisible(z11, z12);
        if (z11) {
            OnVisibleAction onVisibleAction = this.f15043g;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                H0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                P0();
            }
        } else if (this.f15039b.isRunning()) {
            G0();
            this.f15043g = OnVisibleAction.RESUME;
        } else if (!z13) {
            this.f15043g = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        H0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        G();
    }

    @RequiresApi(api = 19)
    public void t(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f15039b.addPauseListener(animatorPauseListener);
    }

    public final /* synthetic */ void t0(h hVar) {
        P0();
    }

    public void t1(int i11) {
        this.f15039b.setRepeatCount(i11);
    }

    public void u(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f15039b.addUpdateListener(animatorUpdateListener);
    }

    public final /* synthetic */ void u0(int i11, h hVar) {
        a1(i11);
    }

    public void u1(int i11) {
        this.f15039b.setRepeatMode(i11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public <T> void v(final a7.d dVar, final T t11, @Nullable final h7.c<T> cVar) {
        com.airbnb.lottie.model.layer.b bVar = this.f15053q;
        if (bVar == null) {
            this.f15044h.add(new a() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    this.f15327a.o0(dVar, t11, cVar, hVar);
                }
            });
            return;
        }
        if (dVar == a7.d.f430c) {
            bVar.d(t11, cVar);
        } else if (dVar.d() != null) {
            dVar.d().d(t11, cVar);
        } else {
            List<a7.d> listO0 = O0(dVar);
            for (int i11 = 0; i11 < listO0.size(); i11++) {
                listO0.get(i11).d().d(t11, cVar);
            }
            if (!(!listO0.isEmpty())) {
                return;
            }
        }
        invalidateSelf();
        if (t11 == p0.E) {
            r1(a0());
        }
    }

    public final /* synthetic */ void v0(String str, h hVar) {
        g1(str);
    }

    public void v1(boolean z11) {
        this.f15042f = z11;
    }

    public final boolean w() {
        return this.f15040c || this.f15041d;
    }

    public final /* synthetic */ void w0(int i11, h hVar) {
        f1(i11);
    }

    public void w1(float f11) {
        this.f15039b.G(f11);
    }

    public final void x() {
        h hVar = this.f15038a;
        if (hVar == null) {
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, f7.v.a(hVar), hVar.k(), hVar);
        this.f15053q = bVar;
        if (this.f15056t) {
            bVar.K(true);
        }
        this.f15053q.S(this.f15052p);
    }

    public final /* synthetic */ void x0(float f11, h hVar) {
        h1(f11);
    }

    public void x1(Boolean bool) {
        this.f15040c = bool.booleanValue();
    }

    public void y() {
        this.f15044h.clear();
        this.f15039b.cancel();
        if (isVisible()) {
            return;
        }
        this.f15043g = OnVisibleAction.NONE;
    }

    public final /* synthetic */ void y0(String str, h hVar) {
        j1(str);
    }

    public void y1(u0 u0Var) {
    }

    public void z() {
        if (this.f15039b.isRunning()) {
            this.f15039b.cancel();
            if (!isVisible()) {
                this.f15043g = OnVisibleAction.NONE;
            }
        }
        this.f15038a = null;
        this.f15053q = null;
        this.f15045i = null;
        this.R = -3.4028235E38f;
        this.f15039b.j();
        invalidateSelf();
    }

    public final /* synthetic */ void z0(String str, String str2, boolean z11, h hVar) {
        k1(str, str2, z11);
    }

    public void z1(boolean z11) {
        this.f15039b.H(z11);
    }
}
