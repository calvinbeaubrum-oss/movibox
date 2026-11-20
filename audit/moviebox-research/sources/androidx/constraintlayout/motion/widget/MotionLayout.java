package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.AdError;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public boolean A;
    public boolean A0;
    public x2.b B;
    public RectF B0;
    public b C;
    public View C0;
    public androidx.constraintlayout.motion.widget.b D;
    public Matrix D0;
    public boolean E;
    public ArrayList<Integer> E0;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public float K;
    public float L;
    public long M;
    public float N;
    public boolean O;
    public ArrayList<MotionHelper> P;
    public ArrayList<MotionHelper> Q;
    public ArrayList<MotionHelper> R;
    public CopyOnWriteArrayList<h> S;
    public int T;
    public long U;
    public float V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f6764a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f6765a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f6766b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f6767b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f6768c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f6769c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6770d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f6771d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f6772e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6773f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f6774f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6775g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f6776g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6777h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f6778h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6779i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f6780i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6781j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f6782j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6783k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.d f6784k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<View, m> f6785l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f6786l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6787m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public g f6788m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6789n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public Runnable f6790n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6791o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int[] f6792o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6793p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f6794p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f6795q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f6796q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6797r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f6798r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6799s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public HashMap<View, x2.e> f6800s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6801t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f6802t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6803u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f6804u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f6805v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f6806v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6807w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public Rect f6808w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f6809x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f6810x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6811y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public TransitionState f6812y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f6813z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public d f6814z0;

    /* JADX INFO: compiled from: source.java */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6815a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f6815a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6815a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6815a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6815a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6816a = 0.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6817b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6818c;

        public b() {
        }

        @Override // androidx.constraintlayout.motion.widget.n
        public float a() {
            return MotionLayout.this.f6770d;
        }

        public void b(float f11, float f12, float f13) {
            this.f6816a = f11;
            this.f6817b = f12;
            this.f6818c = f13;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12;
            float f13;
            float f14 = this.f6816a;
            if (f14 > 0.0f) {
                float f15 = this.f6818c;
                if (f14 / f15 < f11) {
                    f11 = f14 / f15;
                }
                MotionLayout.this.f6770d = f14 - (f15 * f11);
                f12 = (f14 * f11) - (((f15 * f11) * f11) / 2.0f);
                f13 = this.f6817b;
            } else {
                float f16 = this.f6818c;
                if ((-f14) / f16 < f11) {
                    f11 = (-f14) / f16;
                }
                MotionLayout.this.f6770d = (f16 * f11) + f14;
                f12 = (f14 * f11) + (((f16 * f11) * f11) / 2.0f);
                f13 = this.f6817b;
            }
            return f12 + f13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f6820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f6821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f6822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Path f6823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f6824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Paint f6825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Paint f6826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Paint f6827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Paint f6828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f6829j;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public DashPathEffect f6835p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6836q;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f6839t;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f6830k = -21965;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f6831l = -2067046;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f6832m = -13391360;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f6833n = 1996488704;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f6834o = 10;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Rect f6837r = new Rect();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f6838s = false;

        public c() {
            this.f6839t = 1;
            Paint paint = new Paint();
            this.f6824e = paint;
            paint.setAntiAlias(true);
            this.f6824e.setColor(-21965);
            this.f6824e.setStrokeWidth(2.0f);
            Paint paint2 = this.f6824e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f6825f = paint3;
            paint3.setAntiAlias(true);
            this.f6825f.setColor(-2067046);
            this.f6825f.setStrokeWidth(2.0f);
            this.f6825f.setStyle(style);
            Paint paint4 = new Paint();
            this.f6826g = paint4;
            paint4.setAntiAlias(true);
            this.f6826g.setColor(-13391360);
            this.f6826g.setStrokeWidth(2.0f);
            this.f6826g.setStyle(style);
            Paint paint5 = new Paint();
            this.f6827h = paint5;
            paint5.setAntiAlias(true);
            this.f6827h.setColor(-13391360);
            this.f6827h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f6829j = new float[8];
            Paint paint6 = new Paint();
            this.f6828i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f6835p = dashPathEffect;
            this.f6826g.setPathEffect(dashPathEffect);
            this.f6822c = new float[100];
            this.f6821b = new int[50];
            if (this.f6838s) {
                this.f6824e.setStrokeWidth(8.0f);
                this.f6828i.setStrokeWidth(8.0f);
                this.f6825f.setStrokeWidth(8.0f);
                this.f6839t = 4;
            }
        }

        public void a(Canvas canvas, HashMap<View, m> map, int i11, int i12) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i12 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f6777h) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f6827h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f6824e);
            }
            for (m mVar : map.values()) {
                int iM = mVar.m();
                if (i12 > 0 && iM == 0) {
                    iM = 1;
                }
                if (iM != 0) {
                    this.f6836q = mVar.c(this.f6822c, this.f6821b);
                    if (iM >= 1) {
                        int i13 = i11 / 16;
                        float[] fArr = this.f6820a;
                        if (fArr == null || fArr.length != i13 * 2) {
                            this.f6820a = new float[i13 * 2];
                            this.f6823d = new Path();
                        }
                        int i14 = this.f6839t;
                        canvas.translate(i14, i14);
                        this.f6824e.setColor(1996488704);
                        this.f6828i.setColor(1996488704);
                        this.f6825f.setColor(1996488704);
                        this.f6826g.setColor(1996488704);
                        mVar.d(this.f6820a, i13);
                        b(canvas, iM, this.f6836q, mVar);
                        this.f6824e.setColor(-21965);
                        this.f6825f.setColor(-2067046);
                        this.f6828i.setColor(-2067046);
                        this.f6826g.setColor(-13391360);
                        int i15 = this.f6839t;
                        canvas.translate(-i15, -i15);
                        b(canvas, iM, this.f6836q, mVar);
                        if (iM == 5) {
                            j(canvas, mVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i11, int i12, m mVar) {
            if (i11 == 4) {
                d(canvas);
            }
            if (i11 == 2) {
                g(canvas);
            }
            if (i11 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i11, i12, mVar);
        }

        public final void c(Canvas canvas) {
            canvas.drawLines(this.f6820a, this.f6824e);
        }

        public final void d(Canvas canvas) {
            boolean z11 = false;
            boolean z12 = false;
            for (int i11 = 0; i11 < this.f6836q; i11++) {
                int i12 = this.f6821b[i11];
                if (i12 == 1) {
                    z11 = true;
                }
                if (i12 == 0) {
                    z12 = true;
                }
            }
            if (z11) {
                g(canvas);
            }
            if (z12) {
                e(canvas);
            }
        }

        public final void e(Canvas canvas) {
            float[] fArr = this.f6820a;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[fArr.length - 2];
            float f14 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f11, f13), Math.max(f12, f14), Math.max(f11, f13), Math.max(f12, f14), this.f6826g);
            canvas.drawLine(Math.min(f11, f13), Math.min(f12, f14), Math.min(f11, f13), Math.max(f12, f14), this.f6826g);
        }

        public final void f(Canvas canvas, float f11, float f12) {
            float[] fArr = this.f6820a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float fMin = Math.min(f13, f15);
            float fMax = Math.max(f14, f16);
            float fMin2 = f11 - Math.min(f13, f15);
            float fMax2 = Math.max(f14, f16) - f12;
            String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f15 - f13))) + 0.5d)) / 100.0f);
            l(str, this.f6827h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.f6837r.width() / 2)) + fMin, f12 - 20.0f, this.f6827h);
            canvas.drawLine(f11, f12, Math.min(f13, f15), f12, this.f6826g);
            String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f16 - f14))) + 0.5d)) / 100.0f);
            l(str2, this.f6827h);
            canvas.drawText(str2, f11 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.f6837r.height() / 2)), this.f6827h);
            canvas.drawLine(f11, f12, f11, Math.max(f14, f16), this.f6826g);
        }

        public final void g(Canvas canvas) {
            float[] fArr = this.f6820a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f6826g);
        }

        public final void h(Canvas canvas, float f11, float f12) {
            float[] fArr = this.f6820a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f13 - f15, f14 - f16);
            float f17 = f15 - f13;
            float f18 = f16 - f14;
            float f19 = (((f11 - f13) * f17) + ((f12 - f14) * f18)) / (fHypot * fHypot);
            float f21 = f13 + (f17 * f19);
            float f22 = f14 + (f19 * f18);
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f21, f22);
            float fHypot2 = (float) Math.hypot(f21 - f11, f22 - f12);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            l(str, this.f6827h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f6837r.width() / 2), -20.0f, this.f6827h);
            canvas.drawLine(f11, f12, f21, f22, this.f6826g);
        }

        public final void i(Canvas canvas, float f11, float f12, int i11, int i12) {
            String str = "" + (((int) (((double) (((f11 - (i11 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i11))) + 0.5d)) / 100.0f);
            l(str, this.f6827h);
            canvas.drawText(str, ((f11 / 2.0f) - (this.f6837r.width() / 2)) + 0.0f, f12 - 20.0f, this.f6827h);
            canvas.drawLine(f11, f12, Math.min(0.0f, 1.0f), f12, this.f6826g);
            String str2 = "" + (((int) (((double) (((f12 - (i12 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i12))) + 0.5d)) / 100.0f);
            l(str2, this.f6827h);
            canvas.drawText(str2, f11 + 5.0f, 0.0f - ((f12 / 2.0f) - (this.f6837r.height() / 2)), this.f6827h);
            canvas.drawLine(f11, f12, f11, Math.max(0.0f, 1.0f), this.f6826g);
        }

        public final void j(Canvas canvas, m mVar) {
            this.f6823d.reset();
            for (int i11 = 0; i11 <= 50; i11++) {
                mVar.e(i11 / 50, this.f6829j, 0);
                Path path = this.f6823d;
                float[] fArr = this.f6829j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f6823d;
                float[] fArr2 = this.f6829j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f6823d;
                float[] fArr3 = this.f6829j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f6823d;
                float[] fArr4 = this.f6829j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f6823d.close();
            }
            this.f6824e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f6823d, this.f6824e);
            canvas.translate(-2.0f, -2.0f);
            this.f6824e.setColor(FlowLayout.SPACING_AUTO);
            canvas.drawPath(this.f6823d, this.f6824e);
        }

        public final void k(Canvas canvas, int i11, int i12, m mVar) {
            int width;
            int height;
            View view = mVar.f6993b;
            if (view != null) {
                width = view.getWidth();
                height = mVar.f6993b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i13 = 1; i13 < i12 - 1; i13++) {
                if (i11 != 4 || this.f6821b[i13 - 1] != 0) {
                    float[] fArr = this.f6822c;
                    int i14 = i13 * 2;
                    float f11 = fArr[i14];
                    float f12 = fArr[i14 + 1];
                    this.f6823d.reset();
                    this.f6823d.moveTo(f11, f12 + 10.0f);
                    this.f6823d.lineTo(f11 + 10.0f, f12);
                    this.f6823d.lineTo(f11, f12 - 10.0f);
                    this.f6823d.lineTo(f11 - 10.0f, f12);
                    this.f6823d.close();
                    int i15 = i13 - 1;
                    mVar.q(i15);
                    if (i11 == 4) {
                        int i16 = this.f6821b[i15];
                        if (i16 == 1) {
                            h(canvas, f11 - 0.0f, f12 - 0.0f);
                        } else if (i16 == 0) {
                            f(canvas, f11 - 0.0f, f12 - 0.0f);
                        } else {
                            if (i16 == 2) {
                                i(canvas, f11 - 0.0f, f12 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.f6823d, this.f6828i);
                        }
                        canvas.drawPath(this.f6823d, this.f6828i);
                    } else {
                        f12 = f12;
                        f11 = f11;
                    }
                    if (i11 == 2) {
                        h(canvas, f11 - 0.0f, f12 - 0.0f);
                    }
                    if (i11 == 3) {
                        f(canvas, f11 - 0.0f, f12 - 0.0f);
                    }
                    if (i11 == 6) {
                        i(canvas, f11 - 0.0f, f12 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.f6823d, this.f6828i);
                }
            }
            float[] fArr2 = this.f6820a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f6825f);
                float[] fArr3 = this.f6820a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f6825f);
            }
        }

        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f6837r);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.d f6841a = new androidx.constraintlayout.core.widgets.d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.d f6842b = new androidx.constraintlayout.core.widgets.d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f6843c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f6844d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6846f;

        public d() {
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:26:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:27:0x0108  */
        /* JADX WARN: Code duplicated, block: B:29:0x010e  */
        /* JADX WARN: Code duplicated, block: B:42:0x013c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:44:0x013c A[SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:29:0x010e, please report this as an issue */
        public void a() {
            ConstraintWidget constraintWidgetD;
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f6785l.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = MotionLayout.this.getChildAt(i11);
                m mVar = new m(childAt);
                int id2 = childAt.getId();
                iArr[i11] = id2;
                sparseArray.put(id2, mVar);
                MotionLayout.this.f6785l.put(childAt, mVar);
            }
            int i12 = 0;
            while (i12 < childCount) {
                View childAt2 = MotionLayout.this.getChildAt(i12);
                m mVar2 = MotionLayout.this.f6785l.get(childAt2);
                if (mVar2 == null) {
                    sparseArray = sparseArray;
                } else {
                    if (this.f6843c != null) {
                        ConstraintWidget constraintWidgetD2 = d(this.f6841a, childAt2);
                        if (constraintWidgetD2 != null) {
                            mVar2.F(MotionLayout.this.S(constraintWidgetD2), this.f6843c, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.f6811y != 0) {
                            Log.e("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + "no widget for  " + androidx.constraintlayout.motion.widget.a.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    } else {
                        if (MotionLayout.this.f6796q0) {
                            x2.e eVar = MotionLayout.this.f6800s0.get(childAt2);
                            MotionLayout motionLayout = MotionLayout.this;
                            mVar2.G(eVar, childAt2, motionLayout.f6798r0, motionLayout.f6802t0, MotionLayout.this.f6804u0);
                        }
                        if (this.f6844d == null) {
                            constraintWidgetD = d(this.f6842b, childAt2);
                            if (constraintWidgetD != null) {
                                mVar2.C(MotionLayout.this.S(constraintWidgetD), this.f6844d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                            } else if (MotionLayout.this.f6811y != 0) {
                                Log.e("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + "no widget for  " + androidx.constraintlayout.motion.widget.a.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                            }
                        }
                    }
                    if (this.f6844d == null) {
                        constraintWidgetD = d(this.f6842b, childAt2);
                        if (constraintWidgetD != null) {
                            mVar2.C(MotionLayout.this.S(constraintWidgetD), this.f6844d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.f6811y != 0) {
                            Log.e("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + "no widget for  " + androidx.constraintlayout.motion.widget.a.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
                i12++;
                sparseArray = sparseArray;
            }
            SparseArray sparseArray2 = sparseArray;
            int i13 = 0;
            while (i13 < childCount) {
                SparseArray sparseArray3 = sparseArray2;
                m mVar3 = (m) sparseArray3.get(iArr[i13]);
                int iH = mVar3.h();
                if (iH != -1) {
                    mVar3.J((m) sparseArray3.get(iH));
                }
                i13++;
                sparseArray2 = sparseArray3;
            }
        }

        public final void b(int i11, int i12) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f6775g == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar = this.f6842b;
                androidx.constraintlayout.widget.b bVar = this.f6844d;
                motionLayout2.resolveSystem(dVar, optimizationLevel, (bVar == null || bVar.f7373d == 0) ? i11 : i12, (bVar == null || bVar.f7373d == 0) ? i12 : i11);
                androidx.constraintlayout.widget.b bVar2 = this.f6843c;
                if (bVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f6841a;
                    int i13 = bVar2.f7373d;
                    int i14 = i13 == 0 ? i11 : i12;
                    if (i13 == 0) {
                        i11 = i12;
                    }
                    motionLayout3.resolveSystem(dVar2, optimizationLevel, i14, i11);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.b bVar3 = this.f6843c;
            if (bVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar3 = this.f6841a;
                int i15 = bVar3.f7373d;
                motionLayout4.resolveSystem(dVar3, optimizationLevel, i15 == 0 ? i11 : i12, i15 == 0 ? i12 : i11);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            androidx.constraintlayout.core.widgets.d dVar4 = this.f6842b;
            androidx.constraintlayout.widget.b bVar4 = this.f6844d;
            int i16 = (bVar4 == null || bVar4.f7373d == 0) ? i11 : i12;
            if (bVar4 == null || bVar4.f7373d == 0) {
                i11 = i12;
            }
            motionLayout5.resolveSystem(dVar4, optimizationLevel, i16, i11);
        }

        public void c(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.core.widgets.d dVar2) {
            ConstraintWidget bVar;
            ArrayList<ConstraintWidget> arrayListV1 = dVar.v1();
            HashMap<ConstraintWidget, ConstraintWidget> map = new HashMap<>();
            map.put(dVar, dVar2);
            dVar2.v1().clear();
            dVar2.n(dVar, map);
            for (ConstraintWidget constraintWidget : arrayListV1) {
                if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
                    bVar = new androidx.constraintlayout.core.widgets.a();
                } else if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                    bVar = new androidx.constraintlayout.core.widgets.f();
                } else if (constraintWidget instanceof androidx.constraintlayout.core.widgets.e) {
                    bVar = new androidx.constraintlayout.core.widgets.e();
                } else if (constraintWidget instanceof androidx.constraintlayout.core.widgets.h) {
                    bVar = new androidx.constraintlayout.core.widgets.h();
                } else {
                    bVar = constraintWidget instanceof v2.a ? new v2.b() : new ConstraintWidget();
                }
                dVar2.a(bVar);
                map.put(constraintWidget, bVar);
            }
            for (ConstraintWidget constraintWidget2 : arrayListV1) {
                map.get(constraintWidget2).n(constraintWidget2, map);
            }
        }

        public ConstraintWidget d(androidx.constraintlayout.core.widgets.d dVar, View view) {
            if (dVar.u() == view) {
                return dVar;
            }
            ArrayList<ConstraintWidget> arrayListV1 = dVar.v1();
            int size = arrayListV1.size();
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget = arrayListV1.get(i11);
                if (constraintWidget.u() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void e(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.b bVar, androidx.constraintlayout.widget.b bVar2) {
            this.f6843c = bVar;
            this.f6844d = bVar2;
            this.f6841a = new androidx.constraintlayout.core.widgets.d();
            this.f6842b = new androidx.constraintlayout.core.widgets.d();
            this.f6841a.a2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.N1());
            this.f6842b.a2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.N1());
            this.f6841a.y1();
            this.f6842b.y1();
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f6841a);
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f6842b);
            if (MotionLayout.this.f6793p > 0.5d) {
                if (bVar != null) {
                    j(this.f6841a, bVar);
                }
                j(this.f6842b, bVar2);
            } else {
                j(this.f6842b, bVar2);
                if (bVar != null) {
                    j(this.f6841a, bVar);
                }
            }
            this.f6841a.d2(MotionLayout.this.isRtl());
            this.f6841a.f2();
            this.f6842b.d2(MotionLayout.this.isRtl());
            this.f6842b.f2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f6841a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar2.T0(dimensionBehaviour);
                    this.f6842b.T0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.core.widgets.d dVar3 = this.f6841a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar3.k1(dimensionBehaviour2);
                    this.f6842b.k1(dimensionBehaviour2);
                }
            }
        }

        public boolean f(int i11, int i12) {
            return (i11 == this.f6845e && i12 == this.f6846f) ? false : true;
        }

        public void g(int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f6778h0 = mode;
            motionLayout.f6780i0 = mode2;
            motionLayout.getOptimizationLevel();
            b(i11, i12);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i11, i12);
                MotionLayout.this.f6771d0 = this.f6841a.Y();
                MotionLayout.this.f6772e0 = this.f6841a.z();
                MotionLayout.this.f6774f0 = this.f6842b.Y();
                MotionLayout.this.f6776g0 = this.f6842b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.f6769c0 = (motionLayout2.f6771d0 == motionLayout2.f6774f0 && motionLayout2.f6772e0 == motionLayout2.f6776g0) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i13 = motionLayout3.f6771d0;
            int i14 = motionLayout3.f6772e0;
            int i15 = motionLayout3.f6778h0;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                i13 = (int) (i13 + (motionLayout3.f6782j0 * (motionLayout3.f6774f0 - i13)));
            }
            int i16 = i13;
            int i17 = motionLayout3.f6780i0;
            if (i17 == Integer.MIN_VALUE || i17 == 0) {
                i14 = (int) (i14 + (motionLayout3.f6782j0 * (motionLayout3.f6776g0 - i14)));
            }
            MotionLayout.this.resolveMeasuredDimension(i11, i12, i16, i14, this.f6841a.V1() || this.f6842b.V1(), this.f6841a.T1() || this.f6842b.T1());
        }

        public void h() {
            g(MotionLayout.this.f6779i, MotionLayout.this.f6781j);
            MotionLayout.this.R();
        }

        public void i(int i11, int i12) {
            this.f6845e = i11;
            this.f6846f = i12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void j(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.b bVar) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.a aVar = new Constraints.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, dVar);
            sparseArray.put(MotionLayout.this.getId(), dVar);
            if (bVar != null && bVar.f7373d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f6842b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            for (ConstraintWidget constraintWidget : dVar.v1()) {
                constraintWidget.D0(true);
                sparseArray.put(((View) constraintWidget.u()).getId(), constraintWidget);
            }
            for (ConstraintWidget constraintWidget2 : dVar.v1()) {
                View view = (View) constraintWidget2.u();
                bVar.l(view.getId(), aVar);
                constraintWidget2.o1(bVar.D(view.getId()));
                constraintWidget2.P0(bVar.y(view.getId()));
                if (view instanceof ConstraintHelper) {
                    bVar.j((ConstraintHelper) view, constraintWidget2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, constraintWidget2, aVar, sparseArray);
                if (bVar.C(view.getId()) == 1) {
                    constraintWidget2.n1(view.getVisibility());
                } else {
                    constraintWidget2.n1(bVar.B(view.getId()));
                }
            }
            for (ConstraintWidget constraintWidget3 : dVar.v1()) {
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) constraintWidget3.u();
                    v2.a aVar2 = (v2.a) constraintWidget3;
                    constraintHelper.updatePreLayout(dVar, aVar2, sparseArray);
                    ((androidx.constraintlayout.core.widgets.i) aVar2).y1();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(MotionEvent motionEvent);

        float b();

        float c();

        void d(int i11);

        void recycle();
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static f f6848b = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f6849a;

        public static f e() {
            f6848b.f6849a = VelocityTracker.obtain();
            return f6848b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f6849a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public float b() {
            VelocityTracker velocityTracker = this.f6849a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public float c() {
            VelocityTracker velocityTracker = this.f6849a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public void d(int i11) {
            VelocityTracker velocityTracker = this.f6849a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i11);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public void recycle() {
            VelocityTracker velocityTracker = this.f6849a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f6849a = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6850a = Float.NaN;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6851b = Float.NaN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6852c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6853d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f6854e = "motion.progress";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f6855f = "motion.velocity";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f6856g = "motion.StartState";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f6857h = "motion.EndState";

        public g() {
        }

        public void a() {
            int i11 = this.f6852c;
            if (i11 != -1 || this.f6853d != -1) {
                if (i11 == -1) {
                    MotionLayout.this.transitionToState(this.f6853d);
                } else {
                    int i12 = this.f6853d;
                    if (i12 == -1) {
                        MotionLayout.this.setState(i11, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i11, i12);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f6851b)) {
                if (Float.isNaN(this.f6850a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f6850a);
            } else {
                MotionLayout.this.setProgress(this.f6850a, this.f6851b);
                this.f6850a = Float.NaN;
                this.f6851b = Float.NaN;
                this.f6852c = -1;
                this.f6853d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f6850a);
            bundle.putFloat("motion.velocity", this.f6851b);
            bundle.putInt("motion.StartState", this.f6852c);
            bundle.putInt("motion.EndState", this.f6853d);
            return bundle;
        }

        public void c() {
            this.f6853d = MotionLayout.this.f6777h;
            this.f6852c = MotionLayout.this.f6773f;
            this.f6851b = MotionLayout.this.getVelocity();
            this.f6850a = MotionLayout.this.getProgress();
        }

        public void d(int i11) {
            this.f6853d = i11;
        }

        public void e(float f11) {
            this.f6850a = f11;
        }

        public void f(int i11) {
            this.f6852c = i11;
        }

        public void g(Bundle bundle) {
            this.f6850a = bundle.getFloat("motion.progress");
            this.f6851b = bundle.getFloat("motion.velocity");
            this.f6852c = bundle.getInt("motion.StartState");
            this.f6853d = bundle.getInt("motion.EndState");
        }

        public void h(float f11) {
            this.f6851b = f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface h {
        void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11);

        void onTransitionCompleted(MotionLayout motionLayout, int i11);

        void onTransitionStarted(MotionLayout motionLayout, int i11, int i12);

        void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11);
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.f6768c = null;
        this.f6770d = 0.0f;
        this.f6773f = -1;
        this.f6775g = -1;
        this.f6777h = -1;
        this.f6779i = 0;
        this.f6781j = 0;
        this.f6783k = true;
        this.f6785l = new HashMap<>();
        this.f6787m = 0L;
        this.f6789n = 1.0f;
        this.f6791o = 0.0f;
        this.f6793p = 0.0f;
        this.f6797r = 0.0f;
        this.f6801t = false;
        this.f6803u = false;
        this.f6811y = 0;
        this.A = false;
        this.B = new x2.b();
        this.C = new b();
        this.E = true;
        this.J = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.U = -1L;
        this.V = 0.0f;
        this.W = 0;
        this.f6765a0 = 0.0f;
        this.f6767b0 = false;
        this.f6769c0 = false;
        this.f6784k0 = new androidx.constraintlayout.core.motion.utils.d();
        this.f6786l0 = false;
        this.f6790n0 = null;
        this.f6792o0 = null;
        this.f6794p0 = 0;
        this.f6796q0 = false;
        this.f6798r0 = 0;
        this.f6800s0 = new HashMap<>();
        this.f6808w0 = new Rect();
        this.f6810x0 = false;
        this.f6812y0 = TransitionState.UNDEFINED;
        this.f6814z0 = new d();
        this.A0 = false;
        this.B0 = new RectF();
        this.C0 = null;
        this.D0 = null;
        this.E0 = new ArrayList<>();
        N(null);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6768c = null;
        this.f6770d = 0.0f;
        this.f6773f = -1;
        this.f6775g = -1;
        this.f6777h = -1;
        this.f6779i = 0;
        this.f6781j = 0;
        this.f6783k = true;
        this.f6785l = new HashMap<>();
        this.f6787m = 0L;
        this.f6789n = 1.0f;
        this.f6791o = 0.0f;
        this.f6793p = 0.0f;
        this.f6797r = 0.0f;
        this.f6801t = false;
        this.f6803u = false;
        this.f6811y = 0;
        this.A = false;
        this.B = new x2.b();
        this.C = new b();
        this.E = true;
        this.J = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.U = -1L;
        this.V = 0.0f;
        this.W = 0;
        this.f6765a0 = 0.0f;
        this.f6767b0 = false;
        this.f6769c0 = false;
        this.f6784k0 = new androidx.constraintlayout.core.motion.utils.d();
        this.f6786l0 = false;
        this.f6790n0 = null;
        this.f6792o0 = null;
        this.f6794p0 = 0;
        this.f6796q0 = false;
        this.f6798r0 = 0;
        this.f6800s0 = new HashMap<>();
        this.f6808w0 = new Rect();
        this.f6810x0 = false;
        this.f6812y0 = TransitionState.UNDEFINED;
        this.f6814z0 = new d();
        this.A0 = false;
        this.B0 = new RectF();
        this.C0 = null;
        this.D0 = null;
        this.E0 = new ArrayList<>();
        N(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f6768c = null;
        this.f6770d = 0.0f;
        this.f6773f = -1;
        this.f6775g = -1;
        this.f6777h = -1;
        this.f6779i = 0;
        this.f6781j = 0;
        this.f6783k = true;
        this.f6785l = new HashMap<>();
        this.f6787m = 0L;
        this.f6789n = 1.0f;
        this.f6791o = 0.0f;
        this.f6793p = 0.0f;
        this.f6797r = 0.0f;
        this.f6801t = false;
        this.f6803u = false;
        this.f6811y = 0;
        this.A = false;
        this.B = new x2.b();
        this.C = new b();
        this.E = true;
        this.J = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.U = -1L;
        this.V = 0.0f;
        this.W = 0;
        this.f6765a0 = 0.0f;
        this.f6767b0 = false;
        this.f6769c0 = false;
        this.f6784k0 = new androidx.constraintlayout.core.motion.utils.d();
        this.f6786l0 = false;
        this.f6790n0 = null;
        this.f6792o0 = null;
        this.f6794p0 = 0;
        this.f6796q0 = false;
        this.f6798r0 = 0;
        this.f6800s0 = new HashMap<>();
        this.f6808w0 = new Rect();
        this.f6810x0 = false;
        this.f6812y0 = TransitionState.UNDEFINED;
        this.f6814z0 = new d();
        this.A0 = false;
        this.B0 = new RectF();
        this.C0 = null;
        this.D0 = null;
        this.E0 = new ArrayList<>();
        N(attributeSet);
    }

    public static boolean T(float f11, float f12, float f13) {
        if (f11 > 0.0f) {
            float f14 = f11 / f13;
            return f12 + ((f11 * f14) - (((f13 * f14) * f14) / 2.0f)) > 1.0f;
        }
        float f15 = (-f11) / f13;
        return f12 + ((f11 * f15) + (((f13 * f15) * f15) / 2.0f)) < 0.0f;
    }

    public final boolean A(View view, MotionEvent motionEvent, float f11, float f12) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f11, f12);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f11, -f12);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f11, f12);
        if (this.D0 == null) {
            this.D0 = new Matrix();
        }
        matrix.invert(this.D0);
        motionEventObtain.transform(this.D0);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    public final void B() {
        p pVar = this.f6764a;
        if (pVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int iG = pVar.G();
        p pVar2 = this.f6764a;
        C(iG, pVar2.m(pVar2.G()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        for (p.b bVar : this.f6764a.p()) {
            if (bVar == this.f6764a.f7041c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            D(bVar);
            int iA = bVar.A();
            int iY = bVar.y();
            String strC = androidx.constraintlayout.motion.widget.a.c(getContext(), iA);
            String strC2 = androidx.constraintlayout.motion.widget.a.c(getContext(), iY);
            if (sparseIntArray.get(iA) == iY) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + strC + "->" + strC2);
            }
            if (sparseIntArray2.get(iY) == iA) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + strC + "->" + strC2);
            }
            sparseIntArray.put(iA, iY);
            sparseIntArray2.put(iY, iA);
            if (this.f6764a.m(iA) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + strC);
            }
            if (this.f6764a.m(iY) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + strC);
            }
        }
    }

    public final void C(int i11, androidx.constraintlayout.widget.b bVar) {
        String strC = androidx.constraintlayout.motion.widget.a.c(getContext(), i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + strC + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (bVar.x(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + strC + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.d(childAt));
            }
        }
        int[] iArrZ = bVar.z();
        for (int i13 = 0; i13 < iArrZ.length; i13++) {
            int i14 = iArrZ[i13];
            String strC2 = androidx.constraintlayout.motion.widget.a.c(getContext(), i14);
            if (findViewById(iArrZ[i13]) == null) {
                Log.w("MotionLayout", "CHECK: " + strC + " NO View matches id " + strC2);
            }
            if (bVar.y(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + strC + "(" + strC2 + ") no LAYOUT_HEIGHT");
            }
            if (bVar.D(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + strC + "(" + strC2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    public final void D(p.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    public final void E() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            m mVar = this.f6785l.get(childAt);
            if (mVar != null) {
                mVar.E(childAt);
            }
        }
    }

    public void F(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            m mVar = this.f6785l.get(getChildAt(i11));
            if (mVar != null) {
                mVar.f(z11);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:127:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:143:0x0227  */
    /* JADX WARN: Code duplicated, block: B:180:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e6 A[PHI: r2
  0x00e6: PHI (r2v48 float) = (r2v47 float), (r2v49 float), (r2v49 float) binds: [B:47:0x00ae, B:58:0x00da, B:60:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x0116  */
    /* JADX WARN: Code duplicated, block: B:74:0x011d  */
    /* JADX WARN: Code duplicated, block: B:86:0x013d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0154  */
    /* JADX WARN: Code duplicated, block: B:90:0x0156  */
    /* JADX WARN: Code duplicated, block: B:93:0x015e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0175  */
    /* JADX WARN: Code duplicated, block: B:98:0x0185  */
    public void G(boolean z11) {
        boolean z12;
        char c11;
        int childCount;
        long nanoTime;
        Interpolator interpolator;
        float interpolation;
        Interpolator interpolator2;
        int i11;
        int i12;
        int i13;
        int i14;
        View childAt;
        m mVar;
        boolean z13;
        if (this.f6795q == -1) {
            this.f6795q = getNanoTime();
        }
        float f11 = this.f6793p;
        if (f11 > 0.0f && f11 < 1.0f) {
            this.f6775g = -1;
        }
        boolean z14 = false;
        if (this.O || (this.f6801t && (z11 || this.f6797r != f11))) {
            float fSignum = Math.signum(this.f6797r - f11);
            long nanoTime2 = getNanoTime();
            Interpolator interpolator3 = this.f6766b;
            float f12 = !(interpolator3 instanceof n) ? (((nanoTime2 - this.f6795q) * fSignum) * 1.0E-9f) / this.f6789n : 0.0f;
            float f13 = this.f6793p + f12;
            if (this.f6799s) {
                f13 = this.f6797r;
            }
            if ((fSignum <= 0.0f || f13 < this.f6797r) && (fSignum > 0.0f || f13 > this.f6797r)) {
                z12 = false;
            } else {
                f13 = this.f6797r;
                this.f6801t = false;
                z12 = true;
            }
            this.f6793p = f13;
            this.f6791o = f13;
            this.f6795q = nanoTime2;
            if (interpolator3 == null || z12) {
                this.f6770d = f12;
            } else {
                if (this.A) {
                    float interpolation2 = interpolator3.getInterpolation((nanoTime2 - this.f6787m) * 1.0E-9f);
                    Interpolator interpolator4 = this.f6766b;
                    x2.b bVar = this.B;
                    c11 = interpolator4 == bVar ? bVar.c() ? (char) 2 : (char) 1 : (char) 0;
                    this.f6793p = interpolation2;
                    this.f6795q = nanoTime2;
                    Interpolator interpolator5 = this.f6766b;
                    if (interpolator5 instanceof n) {
                        float fA = ((n) interpolator5).a();
                        this.f6770d = fA;
                        if (Math.abs(fA) * this.f6789n <= 1.0E-5f && c11 == 2) {
                            this.f6801t = false;
                        }
                        if (fA > 0.0f && interpolation2 >= 1.0f) {
                            this.f6793p = 1.0f;
                            this.f6801t = false;
                            interpolation2 = 1.0f;
                        }
                        if (fA >= 0.0f || interpolation2 > 0.0f) {
                            f13 = interpolation2;
                        } else {
                            this.f6793p = 0.0f;
                            this.f6801t = false;
                            f13 = 0.0f;
                        }
                    } else {
                        f13 = interpolation2;
                    }
                } else {
                    float interpolation3 = interpolator3.getInterpolation(f13);
                    Interpolator interpolator6 = this.f6766b;
                    if (interpolator6 instanceof n) {
                        this.f6770d = ((n) interpolator6).a();
                    } else {
                        this.f6770d = ((interpolator6.getInterpolation(f13 + f12) - interpolation3) * fSignum) / f12;
                    }
                    f13 = interpolation3;
                }
                if (Math.abs(this.f6770d) > 1.0E-5f) {
                    setState(TransitionState.MOVING);
                }
                if (c11 != 1) {
                    if ((fSignum <= 0.0f && f13 >= this.f6797r) || (fSignum <= 0.0f && f13 <= this.f6797r)) {
                        f13 = this.f6797r;
                        this.f6801t = false;
                    }
                    if (f13 < 1.0f || f13 <= 0.0f) {
                        this.f6801t = false;
                        setState(TransitionState.FINISHED);
                    }
                }
                childCount = getChildCount();
                this.O = false;
                nanoTime = getNanoTime();
                this.f6782j0 = f13;
                interpolator = this.f6768c;
                if (interpolator == null) {
                    interpolation = f13;
                } else {
                    interpolation = interpolator.getInterpolation(f13);
                }
                interpolator2 = this.f6768c;
                if (interpolator2 != null) {
                    float interpolation4 = interpolator2.getInterpolation((fSignum / this.f6789n) + f13);
                    this.f6770d = interpolation4;
                    this.f6770d = interpolation4 - this.f6768c.getInterpolation(f13);
                }
                for (i11 = 0; i11 < childCount; i11++) {
                    childAt = getChildAt(i11);
                    mVar = this.f6785l.get(childAt);
                    if (mVar != null) {
                        this.O = mVar.x(childAt, interpolation, nanoTime, this.f6784k0) | this.O;
                    }
                }
                boolean z15 = (fSignum <= 0.0f && f13 >= this.f6797r) || (fSignum <= 0.0f && f13 <= this.f6797r);
                if (!this.O && !this.f6801t && z15) {
                    setState(TransitionState.FINISHED);
                }
                if (this.f6769c0) {
                    requestLayout();
                }
                this.O = (!z15) | this.O;
                if (f13 <= 0.0f && (i14 = this.f6773f) != -1 && this.f6775g != i14) {
                    this.f6775g = i14;
                    this.f6764a.m(i14).g(this);
                    setState(TransitionState.FINISHED);
                    z14 = true;
                }
                if (f13 >= 1.0d) {
                    i12 = this.f6775g;
                    i13 = this.f6777h;
                    if (i12 != i13) {
                        this.f6775g = i13;
                        this.f6764a.m(i13).g(this);
                        setState(TransitionState.FINISHED);
                        z14 = true;
                    }
                }
                if (!this.O || this.f6801t) {
                    invalidate();
                } else if ((fSignum > 0.0f && f13 == 1.0f) || (fSignum < 0.0f && f13 == 0.0f)) {
                    setState(TransitionState.FINISHED);
                }
                if (!this.O && !this.f6801t && ((fSignum > 0.0f && f13 == 1.0f) || (fSignum < 0.0f && f13 == 0.0f))) {
                    P();
                }
            }
            c11 = 0;
            if (Math.abs(this.f6770d) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if (c11 != 1) {
                if (fSignum <= 0.0f) {
                    f13 = this.f6797r;
                    this.f6801t = false;
                } else {
                    f13 = this.f6797r;
                    this.f6801t = false;
                }
                if (f13 < 1.0f) {
                    this.f6801t = false;
                    setState(TransitionState.FINISHED);
                } else {
                    this.f6801t = false;
                    setState(TransitionState.FINISHED);
                }
            }
            childCount = getChildCount();
            this.O = false;
            nanoTime = getNanoTime();
            this.f6782j0 = f13;
            interpolator = this.f6768c;
            if (interpolator == null) {
                interpolation = f13;
            } else {
                interpolation = interpolator.getInterpolation(f13);
            }
            interpolator2 = this.f6768c;
            if (interpolator2 != null) {
                float interpolation5 = interpolator2.getInterpolation((fSignum / this.f6789n) + f13);
                this.f6770d = interpolation5;
                this.f6770d = interpolation5 - this.f6768c.getInterpolation(f13);
            }
            while (i11 < childCount) {
                childAt = getChildAt(i11);
                mVar = this.f6785l.get(childAt);
                if (mVar != null) {
                    this.O = mVar.x(childAt, interpolation, nanoTime, this.f6784k0) | this.O;
                }
            }
            if (fSignum <= 0.0f) {
            }
            if (!this.O) {
                setState(TransitionState.FINISHED);
            }
            if (this.f6769c0) {
                requestLayout();
            }
            this.O = (!z15) | this.O;
            if (f13 <= 0.0f) {
                this.f6775g = i14;
                this.f6764a.m(i14).g(this);
                setState(TransitionState.FINISHED);
                z14 = true;
            }
            if (f13 >= 1.0d) {
                i12 = this.f6775g;
                i13 = this.f6777h;
                if (i12 != i13) {
                    this.f6775g = i13;
                    this.f6764a.m(i13).g(this);
                    setState(TransitionState.FINISHED);
                    z14 = true;
                }
            }
            if (this.O) {
                invalidate();
            } else {
                invalidate();
            }
            if (!this.O) {
                P();
            }
        }
        float f14 = this.f6793p;
        if (f14 < 1.0f) {
            if (f14 <= 0.0f) {
                int i15 = this.f6775g;
                int i16 = this.f6773f;
                z13 = i15 == i16 ? z14 : true;
                this.f6775g = i16;
            }
            this.A0 |= z14;
            if (z14 && !this.f6786l0) {
                requestLayout();
            }
            this.f6791o = this.f6793p;
        }
        int i17 = this.f6775g;
        int i18 = this.f6777h;
        z13 = i17 == i18 ? z14 : true;
        this.f6775g = i18;
        z14 = z13;
        this.A0 |= z14;
        if (z14) {
            requestLayout();
        }
        this.f6791o = this.f6793p;
    }

    public final void H() {
        boolean z11;
        float fSignum = Math.signum(this.f6797r - this.f6793p);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f6766b;
        float interpolation = this.f6793p + (!(interpolator instanceof x2.b) ? (((nanoTime - this.f6795q) * fSignum) * 1.0E-9f) / this.f6789n : 0.0f);
        if (this.f6799s) {
            interpolation = this.f6797r;
        }
        if ((fSignum <= 0.0f || interpolation < this.f6797r) && (fSignum > 0.0f || interpolation > this.f6797r)) {
            z11 = false;
        } else {
            interpolation = this.f6797r;
            z11 = true;
        }
        if (interpolator != null && !z11) {
            interpolation = this.A ? interpolator.getInterpolation((nanoTime - this.f6787m) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.f6797r) || (fSignum <= 0.0f && interpolation <= this.f6797r)) {
            interpolation = this.f6797r;
        }
        this.f6782j0 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f6768c;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            m mVar = this.f6785l.get(childAt);
            if (mVar != null) {
                mVar.x(childAt, interpolation, nanoTime2, this.f6784k0);
            }
        }
        if (this.f6769c0) {
            requestLayout();
        }
    }

    public final void I() {
        CopyOnWriteArrayList<h> copyOnWriteArrayList;
        if ((this.f6805v == null && ((copyOnWriteArrayList = this.S) == null || copyOnWriteArrayList.isEmpty())) || this.f6765a0 == this.f6791o) {
            return;
        }
        if (this.W != -1) {
            h hVar = this.f6805v;
            if (hVar != null) {
                hVar.onTransitionStarted(this, this.f6773f, this.f6777h);
            }
            CopyOnWriteArrayList<h> copyOnWriteArrayList2 = this.S;
            if (copyOnWriteArrayList2 != null) {
                Iterator<h> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.f6773f, this.f6777h);
                }
            }
            this.f6767b0 = true;
        }
        this.W = -1;
        float f11 = this.f6791o;
        this.f6765a0 = f11;
        h hVar2 = this.f6805v;
        if (hVar2 != null) {
            hVar2.onTransitionChange(this, this.f6773f, this.f6777h, f11);
        }
        CopyOnWriteArrayList<h> copyOnWriteArrayList3 = this.S;
        if (copyOnWriteArrayList3 != null) {
            Iterator<h> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.f6773f, this.f6777h, this.f6791o);
            }
        }
        this.f6767b0 = true;
    }

    public void J() {
        int iIntValue;
        CopyOnWriteArrayList<h> copyOnWriteArrayList;
        if ((this.f6805v != null || ((copyOnWriteArrayList = this.S) != null && !copyOnWriteArrayList.isEmpty())) && this.W == -1) {
            this.W = this.f6775g;
            if (this.E0.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.E0;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i11 = this.f6775g;
            if (iIntValue != i11 && i11 != -1) {
                this.E0.add(Integer.valueOf(i11));
            }
        }
        Q();
        Runnable runnable = this.f6790n0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f6792o0;
        if (iArr == null || this.f6794p0 <= 0) {
            return;
        }
        transitionToState(iArr[0]);
        int[] iArr2 = this.f6792o0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f6794p0--;
    }

    public void K(int i11, float f11, float f12, float f13, float[] fArr) {
        String resourceName;
        HashMap<View, m> map = this.f6785l;
        View viewById = getViewById(i11);
        m mVar = map.get(viewById);
        if (mVar != null) {
            mVar.l(f11, f12, f13, fArr);
            float y11 = viewById.getY();
            this.f6807w = f11;
            this.f6809x = y11;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i11;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i11);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    public m L(int i11) {
        return this.f6785l.get(findViewById(i11));
    }

    public final boolean M(float f11, float f12, View view, MotionEvent motionEvent) {
        boolean z11;
        if (!(view instanceof ViewGroup)) {
            z11 = false;
            break;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                z11 = false;
                break;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (M((childAt.getLeft() + f11) - view.getScrollX(), (childAt.getTop() + f12) - view.getScrollY(), childAt, motionEvent)) {
                z11 = true;
                break;
            }
            childCount--;
        }
        if (!z11) {
            this.B0.set(f11, f12, (view.getRight() + f11) - view.getLeft(), (view.getBottom() + f12) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.B0.contains(motionEvent.getX(), motionEvent.getY())) && A(view, motionEvent, -f11, -f12)) {
                return true;
            }
        }
        return z11;
    }

    public final void N(AttributeSet attributeSet) {
        p pVar;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z11 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.f6764a = new p(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.f6775g = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.f6797r = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.f6801t = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.f6811y == 0) {
                        this.f6811y = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.f6811y = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.f6764a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z11) {
                this.f6764a = null;
            }
        }
        if (this.f6811y != 0) {
            B();
        }
        if (this.f6775g != -1 || (pVar = this.f6764a) == null) {
            return;
        }
        this.f6775g = pVar.G();
        this.f6773f = this.f6764a.G();
        this.f6777h = this.f6764a.r();
    }

    public e O() {
        return f.e();
    }

    public void P() {
        p pVar = this.f6764a;
        if (pVar == null) {
            return;
        }
        if (pVar.h(this, this.f6775g)) {
            requestLayout();
            return;
        }
        int i11 = this.f6775g;
        if (i11 != -1) {
            this.f6764a.f(this, i11);
        }
        if (this.f6764a.d0()) {
            this.f6764a.b0();
        }
    }

    public final void Q() {
        CopyOnWriteArrayList<h> copyOnWriteArrayList;
        if (this.f6805v == null && ((copyOnWriteArrayList = this.S) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f6767b0 = false;
        for (Integer num : this.E0) {
            h hVar = this.f6805v;
            if (hVar != null) {
                hVar.onTransitionCompleted(this, num.intValue());
            }
            CopyOnWriteArrayList<h> copyOnWriteArrayList2 = this.S;
            if (copyOnWriteArrayList2 != null) {
                Iterator<h> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionCompleted(this, num.intValue());
                }
            }
        }
        this.E0.clear();
    }

    public final void R() {
        int childCount = getChildCount();
        this.f6814z0.a();
        this.f6801t = true;
        SparseArray sparseArray = new SparseArray();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            sparseArray.put(childAt.getId(), this.f6785l.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iK = this.f6764a.k();
        if (iK != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                m mVar = this.f6785l.get(getChildAt(i13));
                if (mVar != null) {
                    mVar.D(iK);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f6785l.size()];
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            m mVar2 = this.f6785l.get(getChildAt(i15));
            if (mVar2.h() != -1) {
                sparseBooleanArray.put(mVar2.h(), true);
                iArr[i14] = mVar2.h();
                i14++;
            }
        }
        if (this.R != null) {
            for (int i16 = 0; i16 < i14; i16++) {
                m mVar3 = this.f6785l.get(findViewById(iArr[i16]));
                if (mVar3 != null) {
                    this.f6764a.u(mVar3);
                }
            }
            Iterator<MotionHelper> it = this.R.iterator();
            while (it.hasNext()) {
                it.next().onPreSetup(this, this.f6785l);
            }
            for (int i17 = 0; i17 < i14; i17++) {
                m mVar4 = this.f6785l.get(findViewById(iArr[i17]));
                if (mVar4 != null) {
                    mVar4.I(width, height, this.f6789n, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < i14; i18++) {
                m mVar5 = this.f6785l.get(findViewById(iArr[i18]));
                if (mVar5 != null) {
                    this.f6764a.u(mVar5);
                    mVar5.I(width, height, this.f6789n, getNanoTime());
                }
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            m mVar6 = this.f6785l.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && mVar6 != null) {
                this.f6764a.u(mVar6);
                mVar6.I(width, height, this.f6789n, getNanoTime());
            }
        }
        float F = this.f6764a.F();
        if (F != 0.0f) {
            boolean z11 = ((double) F) < 0.0d;
            float fAbs = Math.abs(F);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMin2 = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            for (int i21 = 0; i21 < childCount; i21++) {
                m mVar7 = this.f6785l.get(getChildAt(i21));
                if (!Float.isNaN(mVar7.f7004m)) {
                    for (int i22 = 0; i22 < childCount; i22++) {
                        m mVar8 = this.f6785l.get(getChildAt(i22));
                        if (!Float.isNaN(mVar8.f7004m)) {
                            fMin = Math.min(fMin, mVar8.f7004m);
                            fMax = Math.max(fMax, mVar8.f7004m);
                        }
                    }
                    while (i11 < childCount) {
                        m mVar9 = this.f6785l.get(getChildAt(i11));
                        if (!Float.isNaN(mVar9.f7004m)) {
                            mVar9.f7006o = 1.0f / (1.0f - fAbs);
                            if (z11) {
                                mVar9.f7005n = fAbs - (((fMax - mVar9.f7004m) / (fMax - fMin)) * fAbs);
                            } else {
                                mVar9.f7005n = fAbs - (((mVar9.f7004m - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i11++;
                    }
                    return;
                }
                float fN = mVar7.n();
                float fO = mVar7.o();
                float f11 = z11 ? fO - fN : fO + fN;
                fMin2 = Math.min(fMin2, f11);
                fMax2 = Math.max(fMax2, f11);
            }
            while (i11 < childCount) {
                m mVar10 = this.f6785l.get(getChildAt(i11));
                float fN2 = mVar10.n();
                float fO2 = mVar10.o();
                float f12 = z11 ? fO2 - fN2 : fO2 + fN2;
                mVar10.f7006o = 1.0f / (1.0f - fAbs);
                mVar10.f7005n = fAbs - (((f12 - fMin2) * fAbs) / (fMax2 - fMin2));
                i11++;
            }
        }
    }

    public final Rect S(ConstraintWidget constraintWidget) {
        this.f6808w0.top = constraintWidget.a0();
        this.f6808w0.left = constraintWidget.Z();
        Rect rect = this.f6808w0;
        int iY = constraintWidget.Y();
        Rect rect2 = this.f6808w0;
        rect.right = iY + rect2.left;
        int iZ = constraintWidget.z();
        Rect rect3 = this.f6808w0;
        rect2.bottom = iZ + rect3.top;
        return rect3;
    }

    public void addTransitionListener(h hVar) {
        if (this.S == null) {
            this.S = new CopyOnWriteArrayList<>();
        }
        this.S.add(hVar);
    }

    public boolean applyViewTransition(int i11, m mVar) {
        p pVar = this.f6764a;
        if (pVar != null) {
            return pVar.g(i11, mVar);
        }
        return false;
    }

    public androidx.constraintlayout.widget.b cloneConstraintSet(int i11) {
        p pVar = this.f6764a;
        if (pVar == null) {
            return null;
        }
        androidx.constraintlayout.widget.b bVarM = pVar.m(i11);
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.q(bVarM);
        return bVar;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        t tVar;
        ArrayList<MotionHelper> arrayList = this.R;
        if (arrayList != null) {
            Iterator<MotionHelper> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onPreDraw(canvas);
            }
        }
        G(false);
        p pVar = this.f6764a;
        if (pVar != null && (tVar = pVar.f7057s) != null) {
            tVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.f6764a == null) {
            return;
        }
        if ((this.f6811y & 1) == 1 && !isInEditMode()) {
            this.T++;
            long nanoTime = getNanoTime();
            long j11 = this.U;
            if (j11 != -1) {
                long j12 = nanoTime - j11;
                if (j12 > 200000000) {
                    this.V = ((int) ((this.T / (j12 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.T = 0;
                    this.U = nanoTime;
                }
            } else {
                this.U = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float progress = ((int) (getProgress() * 1000.0f)) / 10.0f;
            String str = this.V + " fps " + androidx.constraintlayout.motion.widget.a.e(this, this.f6773f) + " -> ";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(androidx.constraintlayout.motion.widget.a.e(this, this.f6777h));
            sb2.append(" (progress: ");
            sb2.append(progress);
            sb2.append(" ) state=");
            int i11 = this.f6775g;
            sb2.append(i11 == -1 ? AdError.UNDEFINED_DOMAIN : androidx.constraintlayout.motion.widget.a.e(this, i11));
            String string = sb2.toString();
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.f6811y > 1) {
            if (this.f6813z == null) {
                this.f6813z = new c();
            }
            this.f6813z.a(canvas, this.f6785l, this.f6764a.q(), this.f6811y);
        }
        ArrayList<MotionHelper> arrayList2 = this.R;
        if (arrayList2 != null) {
            Iterator<MotionHelper> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onPostDraw(canvas);
            }
        }
    }

    public void enableTransition(int i11, boolean z11) {
        p.b transition = getTransition(i11);
        if (z11) {
            transition.F(true);
            return;
        }
        p pVar = this.f6764a;
        if (transition == pVar.f7041c) {
            for (p.b bVar : pVar.I(this.f6775g)) {
                if (bVar.C()) {
                    this.f6764a.f7041c = bVar;
                    break;
                }
            }
        }
        transition.F(false);
    }

    public void enableViewTransition(int i11, boolean z11) {
        p pVar = this.f6764a;
        if (pVar != null) {
            pVar.j(i11, z11);
        }
    }

    public void fireTrigger(int i11, boolean z11, float f11) {
        h hVar = this.f6805v;
        if (hVar != null) {
            hVar.onTransitionTrigger(this, i11, z11, f11);
        }
        CopyOnWriteArrayList<h> copyOnWriteArrayList = this.S;
        if (copyOnWriteArrayList != null) {
            Iterator<h> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i11, z11, f11);
            }
        }
    }

    public androidx.constraintlayout.widget.b getConstraintSet(int i11) {
        p pVar = this.f6764a;
        if (pVar == null) {
            return null;
        }
        return pVar.m(i11);
    }

    public int[] getConstraintSetIds() {
        p pVar = this.f6764a;
        if (pVar == null) {
            return null;
        }
        return pVar.o();
    }

    public int getCurrentState() {
        return this.f6775g;
    }

    public void getDebugMode(boolean z11) {
        this.f6811y = z11 ? 2 : 1;
        invalidate();
    }

    public ArrayList<p.b> getDefinedTransitions() {
        p pVar = this.f6764a;
        if (pVar == null) {
            return null;
        }
        return pVar.p();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.D == null) {
            this.D = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.D;
    }

    public int getEndState() {
        return this.f6777h;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f6793p;
    }

    public p getScene() {
        return this.f6764a;
    }

    public int getStartState() {
        return this.f6773f;
    }

    public float getTargetPosition() {
        return this.f6797r;
    }

    public p.b getTransition(int i11) {
        return this.f6764a.H(i11);
    }

    public Bundle getTransitionState() {
        if (this.f6788m0 == null) {
            this.f6788m0 = new g();
        }
        this.f6788m0.c();
        return this.f6788m0.b();
    }

    public long getTransitionTimeMs() {
        p pVar = this.f6764a;
        if (pVar != null) {
            this.f6789n = pVar.q() / 1000.0f;
        }
        return (long) (this.f6789n * 1000.0f);
    }

    public float getVelocity() {
        return this.f6770d;
    }

    public void getViewVelocity(View view, float f11, float f12, float[] fArr, int i11) {
        float interpolation;
        float fA = this.f6770d;
        float f13 = this.f6793p;
        if (this.f6766b != null) {
            float fSignum = Math.signum(this.f6797r - f13);
            float interpolation2 = this.f6766b.getInterpolation(this.f6793p + 1.0E-5f);
            interpolation = this.f6766b.getInterpolation(this.f6793p);
            fA = (fSignum * ((interpolation2 - interpolation) / 1.0E-5f)) / this.f6789n;
        } else {
            interpolation = f13;
        }
        Interpolator interpolator = this.f6766b;
        if (interpolator instanceof n) {
            fA = ((n) interpolator).a();
        }
        m mVar = this.f6785l.get(view);
        if ((i11 & 1) == 0) {
            mVar.r(interpolation, view.getWidth(), view.getHeight(), f11, f12, fArr);
        } else {
            mVar.l(interpolation, f11, f12, fArr);
        }
        if (i11 < 2) {
            fArr[0] = fArr[0] * fA;
            fArr[1] = fArr[1] * fA;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.f6810x0;
    }

    public boolean isInRotation() {
        return this.f6796q0;
    }

    public boolean isInteractionEnabled() {
        return this.f6783k;
    }

    public boolean isViewTransitionEnabled(int i11) {
        p pVar = this.f6764a;
        if (pVar != null) {
            return pVar.L(i11);
        }
        return false;
    }

    public void jumpToState(int i11) {
        if (!isAttachedToWindow()) {
            this.f6775g = i11;
        }
        if (this.f6773f == i11) {
            setProgress(0.0f);
        } else if (this.f6777h == i11) {
            setProgress(1.0f);
        } else {
            setTransition(i11, i11);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i11) {
        p.b bVar;
        if (i11 == 0) {
            this.f6764a = null;
            return;
        }
        try {
            p pVar = new p(getContext(), this, i11);
            this.f6764a = pVar;
            if (this.f6775g == -1) {
                this.f6775g = pVar.G();
                this.f6773f = this.f6764a.G();
                this.f6777h = this.f6764a.r();
            }
            if (!isAttachedToWindow()) {
                this.f6764a = null;
                return;
            }
            try {
                Display display = getDisplay();
                this.f6806v0 = display == null ? 0 : display.getRotation();
                p pVar2 = this.f6764a;
                if (pVar2 != null) {
                    androidx.constraintlayout.widget.b bVarM = pVar2.m(this.f6775g);
                    this.f6764a.V(this);
                    ArrayList<MotionHelper> arrayList = this.R;
                    if (arrayList != null) {
                        Iterator<MotionHelper> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().onFinishedMotionScene(this);
                        }
                    }
                    if (bVarM != null) {
                        bVarM.i(this);
                    }
                    this.f6773f = this.f6775g;
                }
                P();
                g gVar = this.f6788m0;
                if (gVar != null) {
                    if (this.f6810x0) {
                        post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MotionLayout.this.f6788m0.a();
                            }
                        });
                        return;
                    } else {
                        gVar.a();
                        return;
                    }
                }
                p pVar3 = this.f6764a;
                if (pVar3 == null || (bVar = pVar3.f7041c) == null || bVar.x() != 4) {
                    return;
                }
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e11) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e11);
            }
        } catch (Exception e12) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e12);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        p.b bVar;
        int i11;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f6806v0 = display.getRotation();
        }
        p pVar = this.f6764a;
        if (pVar != null && (i11 = this.f6775g) != -1) {
            androidx.constraintlayout.widget.b bVarM = pVar.m(i11);
            this.f6764a.V(this);
            ArrayList<MotionHelper> arrayList = this.R;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onFinishedMotionScene(this);
                }
            }
            if (bVarM != null) {
                bVarM.i(this);
            }
            this.f6773f = this.f6775g;
        }
        P();
        g gVar = this.f6788m0;
        if (gVar != null) {
            if (this.f6810x0) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.f6788m0.a();
                    }
                });
                return;
            } else {
                gVar.a();
                return;
            }
        }
        p pVar2 = this.f6764a;
        if (pVar2 == null || (bVar = pVar2.f7041c) == null || bVar.x() != 4) {
            return;
        }
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q qVarB;
        int iQ;
        RectF rectFP;
        p pVar = this.f6764a;
        if (pVar != null && this.f6783k) {
            t tVar = pVar.f7057s;
            if (tVar != null) {
                tVar.j(motionEvent);
            }
            p.b bVar = this.f6764a.f7041c;
            if (bVar != null && bVar.C() && (qVarB = bVar.B()) != null && ((motionEvent.getAction() != 0 || (rectFP = qVarB.p(this, new RectF())) == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) && (iQ = qVarB.q()) != -1)) {
                View view = this.C0;
                if (view == null || view.getId() != iQ) {
                    this.C0 = findViewById(iQ);
                }
                View view2 = this.C0;
                if (view2 != null) {
                    this.B0.set(view2.getLeft(), this.C0.getTop(), this.C0.getRight(), this.C0.getBottom());
                    if (this.B0.contains(motionEvent.getX(), motionEvent.getY()) && !M(this.C0.getLeft(), this.C0.getTop(), this.C0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f6786l0 = true;
        try {
            if (this.f6764a == null) {
                super.onLayout(z11, i11, i12, i13, i14);
                return;
            }
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (this.H != i15 || this.I != i16) {
                rebuildScene();
                G(true);
            }
            this.H = i15;
            this.I = i16;
            this.F = i15;
            this.G = i16;
        } finally {
            this.f6786l0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f6764a == null) {
            super.onMeasure(i11, i12);
            return;
        }
        boolean z11 = false;
        boolean z12 = (this.f6779i == i11 && this.f6781j == i12) ? false : true;
        if (this.A0) {
            this.A0 = false;
            P();
            Q();
            z12 = true;
        }
        if (this.mDirtyHierarchy) {
            z12 = true;
        }
        this.f6779i = i11;
        this.f6781j = i12;
        int iG = this.f6764a.G();
        int iR = this.f6764a.r();
        if ((z12 || this.f6814z0.f(iG, iR)) && this.f6773f != -1) {
            super.onMeasure(i11, i12);
            this.f6814z0.e(this.mLayoutWidget, this.f6764a.m(iG), this.f6764a.m(iR));
            this.f6814z0.h();
            this.f6814z0.i(iG, iR);
        } else {
            if (z12) {
                super.onMeasure(i11, i12);
            }
            z11 = true;
        }
        if (this.f6769c0 || z11) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iY = this.mLayoutWidget.Y() + getPaddingLeft() + getPaddingRight();
            int iZ = this.mLayoutWidget.z() + paddingTop;
            int i13 = this.f6778h0;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                int i14 = this.f6771d0;
                iY = (int) (i14 + (this.f6782j0 * (this.f6774f0 - i14)));
                requestLayout();
            }
            int i15 = this.f6780i0;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                int i16 = this.f6772e0;
                iZ = (int) (i16 + (this.f6782j0 * (this.f6776g0 - i16)));
                requestLayout();
            }
            setMeasuredDimension(iY, iZ);
        }
        H();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f11, float f12) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull final View view, int i11, int i12, @NonNull int[] iArr, int i13) {
        p.b bVar;
        q qVarB;
        int iQ;
        p pVar = this.f6764a;
        if (pVar == null || (bVar = pVar.f7041c) == null || !bVar.C()) {
            return;
        }
        int i14 = -1;
        if (!bVar.C() || (qVarB = bVar.B()) == null || (iQ = qVarB.q()) == -1 || view.getId() == iQ) {
            if (pVar.x()) {
                q qVarB2 = bVar.B();
                if (qVarB2 != null && (qVarB2.e() & 4) != 0) {
                    i14 = i12;
                }
                float f11 = this.f6791o;
                if ((f11 == 1.0f || f11 == 0.0f) && view.canScrollVertically(i14)) {
                    return;
                }
            }
            if (bVar.B() != null && (bVar.B().e() & 1) != 0) {
                float fY = pVar.y(i11, i12);
                float f12 = this.f6793p;
                if ((f12 <= 0.0f && fY < 0.0f) || (f12 >= 1.0f && fY > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable(this) { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f13 = this.f6791o;
            long nanoTime = getNanoTime();
            float f14 = i11;
            this.K = f14;
            float f15 = i12;
            this.L = f15;
            this.N = (float) ((nanoTime - this.M) * 1.0E-9d);
            this.M = nanoTime;
            pVar.R(f14, f15);
            if (f13 != this.f6791o) {
                iArr[0] = i11;
                iArr[1] = i12;
            }
            G(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.J = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (this.J || i11 != 0 || i12 != 0) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
        }
        this.J = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11, int i12) {
        this.M = getNanoTime();
        this.N = 0.0f;
        this.K = 0.0f;
        this.L = 0.0f;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        p pVar = this.f6764a;
        if (pVar != null) {
            pVar.Y(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11, int i12) {
        p.b bVar;
        p pVar = this.f6764a;
        return (pVar == null || (bVar = pVar.f7041c) == null || bVar.B() == null || (this.f6764a.f7041c.B().e() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i11) {
        p pVar = this.f6764a;
        if (pVar != null) {
            float f11 = this.N;
            if (f11 == 0.0f) {
                return;
            }
            pVar.S(this.K / f11, this.L / f11);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p pVar = this.f6764a;
        if (pVar == null || !this.f6783k || !pVar.d0()) {
            return super.onTouchEvent(motionEvent);
        }
        p.b bVar = this.f6764a.f7041c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f6764a.T(motionEvent, getCurrentState(), this);
        if (this.f6764a.f7041c.D(4)) {
            return this.f6764a.f7041c.B().r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.S == null) {
                this.S = new CopyOnWriteArrayList<>();
            }
            this.S.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.P == null) {
                    this.P = new ArrayList<>();
                }
                this.P.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.Q == null) {
                    this.Q = new ArrayList<>();
                }
                this.Q.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.R == null) {
                    this.R = new ArrayList<>();
                }
                this.R.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.P;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.Q;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.f6814z0.h();
        invalidate();
    }

    public boolean removeTransitionListener(h hVar) {
        CopyOnWriteArrayList<h> copyOnWriteArrayList = this.S;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(hVar);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        p pVar;
        p.b bVar;
        if (!this.f6769c0 && this.f6775g == -1 && (pVar = this.f6764a) != null && (bVar = pVar.f7041c) != null) {
            int iZ = bVar.z();
            if (iZ == 0) {
                return;
            }
            if (iZ == 2) {
                int childCount = getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    this.f6785l.get(getChildAt(i11)).z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    @RequiresApi(api = 17)
    public void rotateTo(int i11, int i12) {
        this.f6796q0 = true;
        this.f6802t0 = getWidth();
        this.f6804u0 = getHeight();
        int rotation = getDisplay().getRotation();
        this.f6798r0 = (rotation + 1) % 4 <= (this.f6806v0 + 1) % 4 ? 2 : 1;
        this.f6806v0 = rotation;
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            x2.e eVar = this.f6800s0.get(childAt);
            if (eVar == null) {
                eVar = new x2.e();
                this.f6800s0.put(childAt, eVar);
            }
            eVar.a(childAt);
        }
        this.f6773f = -1;
        this.f6777h = i11;
        this.f6764a.Z(-1, i11);
        this.f6814z0.e(this.mLayoutWidget, null, this.f6764a.m(this.f6777h));
        this.f6791o = 0.0f;
        this.f6793p = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MotionLayout.this.f6796q0 = false;
            }
        });
        if (i12 > 0) {
            this.f6789n = i12 / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i11) {
        if (getCurrentState() == -1) {
            transitionToState(i11);
            return;
        }
        int[] iArr = this.f6792o0;
        if (iArr == null) {
            this.f6792o0 = new int[4];
        } else if (iArr.length <= this.f6794p0) {
            this.f6792o0 = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f6792o0;
        int i12 = this.f6794p0;
        this.f6794p0 = i12 + 1;
        iArr2[i12] = i11;
    }

    public void setDebugMode(int i11) {
        this.f6811y = i11;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z11) {
        this.f6810x0 = z11;
    }

    public void setInteractionEnabled(boolean z11) {
        this.f6783k = z11;
    }

    public void setInterpolatedProgress(float f11) {
        if (this.f6764a != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolatorT = this.f6764a.t();
            if (interpolatorT != null) {
                setProgress(interpolatorT.getInterpolation(f11));
                return;
            }
        }
        setProgress(f11);
    }

    public void setOnHide(float f11) {
        ArrayList<MotionHelper> arrayList = this.Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.Q.get(i11).setProgress(f11);
            }
        }
    }

    public void setOnShow(float f11) {
        ArrayList<MotionHelper> arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.P.get(i11).setProgress(f11);
            }
        }
    }

    public void setProgress(float f11) {
        if (f11 < 0.0f || f11 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f6788m0 == null) {
                this.f6788m0 = new g();
            }
            this.f6788m0.e(f11);
            return;
        }
        if (f11 <= 0.0f) {
            if (this.f6793p == 1.0f && this.f6775g == this.f6777h) {
                setState(TransitionState.MOVING);
            }
            this.f6775g = this.f6773f;
            if (this.f6793p == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f11 >= 1.0f) {
            if (this.f6793p == 0.0f && this.f6775g == this.f6773f) {
                setState(TransitionState.MOVING);
            }
            this.f6775g = this.f6777h;
            if (this.f6793p == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f6775g = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f6764a == null) {
            return;
        }
        this.f6799s = true;
        this.f6797r = f11;
        this.f6791o = f11;
        this.f6795q = -1L;
        this.f6787m = -1L;
        this.f6766b = null;
        this.f6801t = true;
        invalidate();
    }

    public void setProgress(float f11, float f12) {
        if (!isAttachedToWindow()) {
            if (this.f6788m0 == null) {
                this.f6788m0 = new g();
            }
            this.f6788m0.e(f11);
            this.f6788m0.h(f12);
            return;
        }
        setProgress(f11);
        setState(TransitionState.MOVING);
        this.f6770d = f12;
        if (f12 != 0.0f) {
            z(f12 <= 0.0f ? 0.0f : 1.0f);
        } else {
            if (f11 == 0.0f || f11 == 1.0f) {
                return;
            }
            z(f11 <= 0.5f ? 0.0f : 1.0f);
        }
    }

    public void setScene(p pVar) {
        this.f6764a = pVar;
        pVar.Y(isRtl());
        rebuildScene();
    }

    public void setStartState(int i11) {
        if (isAttachedToWindow()) {
            this.f6775g = i11;
            return;
        }
        if (this.f6788m0 == null) {
            this.f6788m0 = new g();
        }
        this.f6788m0.f(i11);
        this.f6788m0.d(i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i11, int i12, int i13) {
        setState(TransitionState.SETUP);
        this.f6775g = i11;
        this.f6773f = -1;
        this.f6777h = -1;
        androidx.constraintlayout.widget.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.d(i11, i12, i13);
            return;
        }
        p pVar = this.f6764a;
        if (pVar != null) {
            pVar.m(i11).i(this);
        }
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.f6775g == -1) {
            return;
        }
        TransitionState transitionState3 = this.f6812y0;
        this.f6812y0 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            I();
        }
        int i11 = a.f6815a[transitionState3.ordinal()];
        if (i11 != 1 && i11 != 2) {
            if (i11 == 3 && transitionState == transitionState2) {
                J();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            I();
        }
        if (transitionState == transitionState2) {
            J();
        }
    }

    public void setTransition(int i11) {
        float f11;
        if (this.f6764a != null) {
            p.b transition = getTransition(i11);
            this.f6773f = transition.A();
            this.f6777h = transition.y();
            if (!isAttachedToWindow()) {
                if (this.f6788m0 == null) {
                    this.f6788m0 = new g();
                }
                this.f6788m0.f(this.f6773f);
                this.f6788m0.d(this.f6777h);
                return;
            }
            int i12 = this.f6775g;
            if (i12 == this.f6773f) {
                f11 = 0.0f;
            } else {
                f11 = i12 == this.f6777h ? 1.0f : Float.NaN;
            }
            this.f6764a.a0(transition);
            this.f6814z0.e(this.mLayoutWidget, this.f6764a.m(this.f6773f), this.f6764a.m(this.f6777h));
            rebuildScene();
            if (this.f6793p != f11) {
                if (f11 == 0.0f) {
                    F(true);
                    this.f6764a.m(this.f6773f).i(this);
                } else if (f11 == 1.0f) {
                    F(false);
                    this.f6764a.m(this.f6777h).i(this);
                }
            }
            this.f6793p = Float.isNaN(f11) ? 0.0f : f11;
            if (!Float.isNaN(f11)) {
                setProgress(f11);
                return;
            }
            Log.v("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + " transitionToStart ");
            transitionToStart();
        }
    }

    public void setTransition(int i11, int i12) {
        if (!isAttachedToWindow()) {
            if (this.f6788m0 == null) {
                this.f6788m0 = new g();
            }
            this.f6788m0.f(i11);
            this.f6788m0.d(i12);
            return;
        }
        p pVar = this.f6764a;
        if (pVar != null) {
            this.f6773f = i11;
            this.f6777h = i12;
            pVar.Z(i11, i12);
            this.f6814z0.e(this.mLayoutWidget, this.f6764a.m(i11), this.f6764a.m(i12));
            rebuildScene();
            this.f6793p = 0.0f;
            transitionToStart();
        }
    }

    public void setTransition(p.b bVar) {
        this.f6764a.a0(bVar);
        setState(TransitionState.SETUP);
        if (this.f6775g == this.f6764a.r()) {
            this.f6793p = 1.0f;
            this.f6791o = 1.0f;
            this.f6797r = 1.0f;
        } else {
            this.f6793p = 0.0f;
            this.f6791o = 0.0f;
            this.f6797r = 0.0f;
        }
        this.f6795q = bVar.D(1) ? -1L : getNanoTime();
        int iG = this.f6764a.G();
        int iR = this.f6764a.r();
        if (iG == this.f6773f && iR == this.f6777h) {
            return;
        }
        this.f6773f = iG;
        this.f6777h = iR;
        this.f6764a.Z(iG, iR);
        this.f6814z0.e(this.mLayoutWidget, this.f6764a.m(this.f6773f), this.f6764a.m(this.f6777h));
        this.f6814z0.i(this.f6773f, this.f6777h);
        this.f6814z0.h();
        rebuildScene();
    }

    public void setTransitionDuration(int i11) {
        p pVar = this.f6764a;
        if (pVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            pVar.X(i11);
        }
    }

    public void setTransitionListener(h hVar) {
        this.f6805v = hVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f6788m0 == null) {
            this.f6788m0 = new g();
        }
        this.f6788m0.g(bundle);
        if (isAttachedToWindow()) {
            this.f6788m0.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.c(context, this.f6773f) + "->" + androidx.constraintlayout.motion.widget.a.c(context, this.f6777h) + " (pos:" + this.f6793p + " Dpos/Dt:" + this.f6770d;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0  */
    public void touchAnimateTo(int i11, float f11, float f12) {
        if (this.f6764a == null || this.f6793p == f11) {
            return;
        }
        this.A = true;
        this.f6787m = getNanoTime();
        this.f6789n = this.f6764a.q() / 1000.0f;
        this.f6797r = f11;
        this.f6801t = true;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            if (i11 != 1 || i11 == 7) {
                f11 = 0.0f;
            } else if (i11 == 2 || i11 == 6) {
                f11 = 1.0f;
            }
            if (this.f6764a.l() == 0) {
                this.B.b(this.f6793p, f11, f12, this.f6789n, this.f6764a.v(), this.f6764a.w());
            } else {
                this.B.d(this.f6793p, f11, f12, this.f6764a.C(), this.f6764a.D(), this.f6764a.B(), this.f6764a.E(), this.f6764a.A());
            }
            int i12 = this.f6775g;
            this.f6797r = f11;
            this.f6775g = i12;
            this.f6766b = this.B;
        } else if (i11 == 4) {
            this.C.b(f12, this.f6793p, this.f6764a.v());
            this.f6766b = this.C;
        } else if (i11 != 5) {
            if (i11 == 6 || i11 == 7) {
                if (i11 != 1) {
                    f11 = 0.0f;
                } else {
                    f11 = 0.0f;
                }
                if (this.f6764a.l() == 0) {
                    this.B.b(this.f6793p, f11, f12, this.f6789n, this.f6764a.v(), this.f6764a.w());
                } else {
                    this.B.d(this.f6793p, f11, f12, this.f6764a.C(), this.f6764a.D(), this.f6764a.B(), this.f6764a.E(), this.f6764a.A());
                }
                int i13 = this.f6775g;
                this.f6797r = f11;
                this.f6775g = i13;
                this.f6766b = this.B;
            }
        } else if (T(f12, this.f6793p, this.f6764a.v())) {
            this.C.b(f12, this.f6793p, this.f6764a.v());
            this.f6766b = this.C;
        } else {
            this.B.b(this.f6793p, f11, f12, this.f6789n, this.f6764a.v(), this.f6764a.w());
            this.f6770d = 0.0f;
            int i14 = this.f6775g;
            this.f6797r = f11;
            this.f6775g = i14;
            this.f6766b = this.B;
        }
        this.f6799s = false;
        this.f6787m = getNanoTime();
        invalidate();
    }

    public void touchSpringTo(float f11, float f12) {
        if (this.f6764a == null || this.f6793p == f11) {
            return;
        }
        this.A = true;
        this.f6787m = getNanoTime();
        this.f6789n = this.f6764a.q() / 1000.0f;
        this.f6797r = f11;
        this.f6801t = true;
        this.B.d(this.f6793p, f11, f12, this.f6764a.C(), this.f6764a.D(), this.f6764a.B(), this.f6764a.E(), this.f6764a.A());
        int i11 = this.f6775g;
        this.f6797r = f11;
        this.f6775g = i11;
        this.f6766b = this.B;
        this.f6799s = false;
        this.f6787m = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        z(1.0f);
        this.f6790n0 = null;
    }

    public void transitionToEnd(Runnable runnable) {
        z(1.0f);
        this.f6790n0 = runnable;
    }

    public void transitionToStart() {
        z(0.0f);
    }

    public void transitionToState(int i11) {
        if (isAttachedToWindow()) {
            transitionToState(i11, -1, -1);
            return;
        }
        if (this.f6788m0 == null) {
            this.f6788m0 = new g();
        }
        this.f6788m0.d(i11);
    }

    public void transitionToState(int i11, int i12) {
        if (isAttachedToWindow()) {
            transitionToState(i11, -1, -1, i12);
            return;
        }
        if (this.f6788m0 == null) {
            this.f6788m0 = new g();
        }
        this.f6788m0.d(i11);
    }

    public void transitionToState(int i11, int i12, int i13) {
        transitionToState(i11, i12, i13, -1);
    }

    public void transitionToState(int i11, int i12, int i13, int i14) {
        androidx.constraintlayout.widget.e eVar;
        int iA;
        p pVar = this.f6764a;
        if (pVar != null && (eVar = pVar.f7040b) != null && (iA = eVar.a(this.f6775g, i11, i12, i13)) != -1) {
            i11 = iA;
        }
        int i15 = this.f6775g;
        if (i15 == i11) {
            return;
        }
        if (this.f6773f == i11) {
            z(0.0f);
            if (i14 > 0) {
                this.f6789n = i14 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f6777h == i11) {
            z(1.0f);
            if (i14 > 0) {
                this.f6789n = i14 / 1000.0f;
                return;
            }
            return;
        }
        this.f6777h = i11;
        if (i15 != -1) {
            setTransition(i15, i11);
            z(1.0f);
            this.f6793p = 0.0f;
            transitionToEnd();
            if (i14 > 0) {
                this.f6789n = i14 / 1000.0f;
                return;
            }
            return;
        }
        this.A = false;
        this.f6797r = 1.0f;
        this.f6791o = 0.0f;
        this.f6793p = 0.0f;
        this.f6795q = getNanoTime();
        this.f6787m = getNanoTime();
        this.f6799s = false;
        this.f6766b = null;
        if (i14 == -1) {
            this.f6789n = this.f6764a.q() / 1000.0f;
        }
        this.f6773f = -1;
        this.f6764a.Z(-1, this.f6777h);
        SparseArray sparseArray = new SparseArray();
        if (i14 == 0) {
            this.f6789n = this.f6764a.q() / 1000.0f;
        } else if (i14 > 0) {
            this.f6789n = i14 / 1000.0f;
        }
        int childCount = getChildCount();
        this.f6785l.clear();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            this.f6785l.put(childAt, new m(childAt));
            sparseArray.put(childAt.getId(), this.f6785l.get(childAt));
        }
        this.f6801t = true;
        this.f6814z0.e(this.mLayoutWidget, null, this.f6764a.m(i11));
        rebuildScene();
        this.f6814z0.a();
        E();
        int width = getWidth();
        int height = getHeight();
        if (this.R != null) {
            for (int i17 = 0; i17 < childCount; i17++) {
                m mVar = this.f6785l.get(getChildAt(i17));
                if (mVar != null) {
                    this.f6764a.u(mVar);
                }
            }
            Iterator<MotionHelper> it = this.R.iterator();
            while (it.hasNext()) {
                it.next().onPreSetup(this, this.f6785l);
            }
            for (int i18 = 0; i18 < childCount; i18++) {
                m mVar2 = this.f6785l.get(getChildAt(i18));
                if (mVar2 != null) {
                    mVar2.I(width, height, this.f6789n, getNanoTime());
                }
            }
        } else {
            for (int i19 = 0; i19 < childCount; i19++) {
                m mVar3 = this.f6785l.get(getChildAt(i19));
                if (mVar3 != null) {
                    this.f6764a.u(mVar3);
                    mVar3.I(width, height, this.f6789n, getNanoTime());
                }
            }
        }
        float F = this.f6764a.F();
        if (F != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i21 = 0; i21 < childCount; i21++) {
                m mVar4 = this.f6785l.get(getChildAt(i21));
                float fO = mVar4.o() + mVar4.n();
                fMin = Math.min(fMin, fO);
                fMax = Math.max(fMax, fO);
            }
            for (int i22 = 0; i22 < childCount; i22++) {
                m mVar5 = this.f6785l.get(getChildAt(i22));
                float fN = mVar5.n();
                float fO2 = mVar5.o();
                mVar5.f7006o = 1.0f / (1.0f - F);
                mVar5.f7005n = F - ((((fN + fO2) - fMin) * F) / (fMax - fMin));
            }
        }
        this.f6791o = 0.0f;
        this.f6793p = 0.0f;
        this.f6801t = true;
        invalidate();
    }

    public void updateState() {
        this.f6814z0.e(this.mLayoutWidget, this.f6764a.m(this.f6773f), this.f6764a.m(this.f6777h));
        rebuildScene();
    }

    public void updateState(int i11, androidx.constraintlayout.widget.b bVar) {
        p pVar = this.f6764a;
        if (pVar != null) {
            pVar.W(i11, bVar);
        }
        updateState();
        if (this.f6775g == i11) {
            bVar.i(this);
        }
    }

    public void updateStateAnimate(int i11, androidx.constraintlayout.widget.b bVar, int i12) {
        if (this.f6764a != null && this.f6775g == i11) {
            updateState(R$id.view_transition, getConstraintSet(i11));
            setState(R$id.view_transition, -1, -1);
            updateState(i11, bVar);
            p.b bVar2 = new p.b(-1, this.f6764a, R$id.view_transition, i11);
            bVar2.E(i12);
            setTransition(bVar2);
            transitionToEnd();
        }
    }

    public void viewTransition(int i11, View... viewArr) {
        p pVar = this.f6764a;
        if (pVar != null) {
            pVar.e0(i11, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    public void z(float f11) {
        p pVar = this.f6764a;
        if (pVar == null) {
            return;
        }
        float f12 = this.f6793p;
        float f13 = this.f6791o;
        if (f12 != f13 && this.f6799s) {
            this.f6793p = f13;
        }
        float f14 = this.f6793p;
        if (f14 == f11) {
            return;
        }
        this.A = false;
        this.f6797r = f11;
        this.f6789n = pVar.q() / 1000.0f;
        setProgress(this.f6797r);
        this.f6766b = null;
        this.f6768c = this.f6764a.t();
        this.f6799s = false;
        this.f6787m = getNanoTime();
        this.f6801t = true;
        this.f6791o = f14;
        this.f6793p = f14;
        invalidate();
    }
}
