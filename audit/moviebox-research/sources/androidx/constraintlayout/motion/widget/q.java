package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static final float[][] G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f7099r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f7100s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MotionLayout f7101t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7082a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7083b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7084c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7085d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7086e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7087f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7088g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7089h = 0.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f7090i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f7091j = 0.5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7092k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7093l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7094m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7095n = 1.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7096o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f7097p = new float[2];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f7098q = new int[2];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f7102u = 4.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f7103v = 1.2f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7104w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f7105x = 1.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7106y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f7107z = 10.0f;
    public float A = 10.0f;
    public float B = 1.0f;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public int E = 0;
    public int F = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnTouchListener {
        public a(q qVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements NestedScrollView.d {
        public b(q qVar) {
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        }
    }

    public q(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f7101t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    public void A() {
        View viewFindViewById;
        int i11 = this.f7085d;
        if (i11 != -1) {
            viewFindViewById = this.f7101t.findViewById(i11);
            if (viewFindViewById == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + androidx.constraintlayout.motion.widget.a.c(this.f7101t.getContext(), this.f7085d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    public float a(float f11, float f12) {
        return (f11 * this.f7094m) + (f12 * this.f7095n);
    }

    public final void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (index == R$styleable.OnSwipe_touchAnchorId) {
                this.f7085d = typedArray.getResourceId(index, this.f7085d);
            } else if (index == R$styleable.OnSwipe_touchAnchorSide) {
                int i12 = typedArray.getInt(index, this.f7082a);
                this.f7082a = i12;
                float[] fArr = G[i12];
                this.f7089h = fArr[0];
                this.f7088g = fArr[1];
            } else if (index == R$styleable.OnSwipe_dragDirection) {
                int i13 = typedArray.getInt(index, this.f7083b);
                this.f7083b = i13;
                float[][] fArr2 = H;
                if (i13 < fArr2.length) {
                    float[] fArr3 = fArr2[i13];
                    this.f7094m = fArr3[0];
                    this.f7095n = fArr3[1];
                } else {
                    this.f7095n = Float.NaN;
                    this.f7094m = Float.NaN;
                    this.f7093l = true;
                }
            } else if (index == R$styleable.OnSwipe_maxVelocity) {
                this.f7102u = typedArray.getFloat(index, this.f7102u);
            } else if (index == R$styleable.OnSwipe_maxAcceleration) {
                this.f7103v = typedArray.getFloat(index, this.f7103v);
            } else if (index == R$styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f7104w = typedArray.getBoolean(index, this.f7104w);
            } else if (index == R$styleable.OnSwipe_dragScale) {
                this.f7105x = typedArray.getFloat(index, this.f7105x);
            } else if (index == R$styleable.OnSwipe_dragThreshold) {
                this.f7107z = typedArray.getFloat(index, this.f7107z);
            } else if (index == R$styleable.OnSwipe_touchRegionId) {
                this.f7086e = typedArray.getResourceId(index, this.f7086e);
            } else if (index == R$styleable.OnSwipe_onTouchUp) {
                this.f7084c = typedArray.getInt(index, this.f7084c);
            } else if (index == R$styleable.OnSwipe_nestedScrollFlags) {
                this.f7106y = typedArray.getInteger(index, 0);
            } else if (index == R$styleable.OnSwipe_limitBoundsTo) {
                this.f7087f = typedArray.getResourceId(index, 0);
            } else if (index == R$styleable.OnSwipe_rotationCenterId) {
                this.f7092k = typedArray.getResourceId(index, this.f7092k);
            } else if (index == R$styleable.OnSwipe_springDamping) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == R$styleable.OnSwipe_springMass) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == R$styleable.OnSwipe_springStiffness) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R$styleable.OnSwipe_springStopThreshold) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R$styleable.OnSwipe_springBoundary) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == R$styleable.OnSwipe_autoCompleteMode) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OnSwipe);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.f7106y;
    }

    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i11 = this.f7087f;
        if (i11 == -1 || (viewFindViewById = viewGroup.findViewById(i11)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public float g() {
        return this.f7103v;
    }

    public float h() {
        return this.f7102u;
    }

    public boolean i() {
        return this.f7104w;
    }

    public float j(float f11, float f12) {
        this.f7101t.K(this.f7085d, this.f7101t.getProgress(), this.f7089h, this.f7088g, this.f7097p);
        float f13 = this.f7094m;
        if (f13 != 0.0f) {
            float[] fArr = this.f7097p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f11 * f13) / fArr[0];
        }
        float[] fArr2 = this.f7097p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f12 * this.f7095n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    public RectF p(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i11 = this.f7086e;
        if (i11 == -1 || (viewFindViewById = viewGroup.findViewById(i11)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public int q() {
        return this.f7086e;
    }

    public boolean r() {
        return this.f7096o;
    }

    public void s(MotionEvent motionEvent, MotionLayout.e eVar, int i11, p pVar) {
        int i12;
        if (this.f7093l) {
            t(motionEvent, eVar, i11, pVar);
            return;
        }
        eVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f7099r = motionEvent.getRawX();
            this.f7100s = motionEvent.getRawY();
            this.f7096o = false;
            return;
        }
        if (action == 1) {
            this.f7096o = false;
            eVar.d(1000);
            float fC = eVar.c();
            float fB = eVar.b();
            float progress = this.f7101t.getProgress();
            int i13 = this.f7085d;
            if (i13 != -1) {
                this.f7101t.K(i13, progress, this.f7089h, this.f7088g, this.f7097p);
            } else {
                float fMin = Math.min(this.f7101t.getWidth(), this.f7101t.getHeight());
                float[] fArr = this.f7097p;
                fArr[1] = this.f7095n * fMin;
                fArr[0] = fMin * this.f7094m;
            }
            float f11 = this.f7094m;
            float[] fArr2 = this.f7097p;
            float fAbs = f11 != 0.0f ? fC / fArr2[0] : fB / fArr2[1];
            float f12 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress : progress;
            if (f12 == 0.0f || f12 == 1.0f || (i12 = this.f7084c) == 3) {
                if (0.0f >= f12 || 1.0f <= f12) {
                    this.f7101t.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f13 = ((double) f12) < 0.5d ? 0.0f : 1.0f;
            if (i12 == 6) {
                if (progress + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f13 = 1.0f;
            }
            if (this.f7084c == 7) {
                if (progress + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f13 = 0.0f;
            }
            this.f7101t.touchAnimateTo(this.f7084c, f13, fAbs);
            if (0.0f >= progress || 1.0f <= progress) {
                this.f7101t.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.f7100s;
        float rawX = motionEvent.getRawX() - this.f7099r;
        if (Math.abs((this.f7094m * rawX) + (this.f7095n * rawY)) > this.f7107z || this.f7096o) {
            float progress2 = this.f7101t.getProgress();
            if (!this.f7096o) {
                this.f7096o = true;
                this.f7101t.setProgress(progress2);
            }
            int i14 = this.f7085d;
            if (i14 != -1) {
                this.f7101t.K(i14, progress2, this.f7089h, this.f7088g, this.f7097p);
            } else {
                float fMin2 = Math.min(this.f7101t.getWidth(), this.f7101t.getHeight());
                float[] fArr3 = this.f7097p;
                fArr3[1] = this.f7095n * fMin2;
                fArr3[0] = fMin2 * this.f7094m;
            }
            float f14 = this.f7094m;
            float[] fArr4 = this.f7097p;
            if (Math.abs(((f14 * fArr4[0]) + (this.f7095n * fArr4[1])) * this.f7105x) < 0.01d) {
                float[] fArr5 = this.f7097p;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float fMax = Math.max(Math.min(progress2 + (this.f7094m != 0.0f ? rawX / this.f7097p[0] : rawY / this.f7097p[1]), 1.0f), 0.0f);
            if (this.f7084c == 6) {
                fMax = Math.max(fMax, 0.01f);
            }
            if (this.f7084c == 7) {
                fMax = Math.min(fMax, 0.99f);
            }
            float progress3 = this.f7101t.getProgress();
            if (fMax != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.f7101t.F(progress3 == 0.0f);
                }
                this.f7101t.setProgress(fMax);
                eVar.d(1000);
                this.f7101t.f6770d = this.f7094m != 0.0f ? eVar.c() / this.f7097p[0] : eVar.b() / this.f7097p[1];
            } else {
                this.f7101t.f6770d = 0.0f;
            }
            this.f7099r = motionEvent.getRawX();
            this.f7100s = motionEvent.getRawY();
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0273  */
    /* JADX WARN: Code duplicated, block: B:58:0x0297  */
    /* JADX WARN: Code duplicated, block: B:61:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x02c3  */
    public void t(MotionEvent motionEvent, MotionLayout.e eVar, int i11, p pVar) {
        float left;
        float f11;
        int top;
        int bottom;
        int i12;
        float degrees;
        float f12;
        int i13;
        eVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f7099r = motionEvent.getRawX();
            this.f7100s = motionEvent.getRawY();
            this.f7096o = false;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            motionEvent.getRawY();
            motionEvent.getRawX();
            float width = this.f7101t.getWidth() / 2.0f;
            float height = this.f7101t.getHeight() / 2.0f;
            int i14 = this.f7092k;
            if (i14 != -1) {
                View viewFindViewById = this.f7101t.findViewById(i14);
                this.f7101t.getLocationOnScreen(this.f7098q);
                float left2 = this.f7098q[0] + ((viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2.0f);
                height = ((viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2.0f) + this.f7098q[1];
                width = left2;
            } else {
                int i15 = this.f7085d;
                if (i15 != -1) {
                    View viewFindViewById2 = this.f7101t.findViewById(this.f7101t.L(i15).h());
                    if (viewFindViewById2 == null) {
                        Log.e("TouchResponse", "could not find view to animate to");
                    } else {
                        this.f7101t.getLocationOnScreen(this.f7098q);
                        width = this.f7098q[0] + ((viewFindViewById2.getLeft() + viewFindViewById2.getRight()) / 2.0f);
                        height = this.f7098q[1] + ((viewFindViewById2.getTop() + viewFindViewById2.getBottom()) / 2.0f);
                    }
                }
            }
            float rawX = motionEvent.getRawX() - width;
            float rawY = motionEvent.getRawY() - height;
            double dAtan2 = Math.atan2(motionEvent.getRawY() - height, motionEvent.getRawX() - width);
            float fAtan2 = (float) (((dAtan2 - Math.atan2(this.f7100s - height, this.f7099r - width)) * 180.0d) / 3.141592653589793d);
            if (fAtan2 > 330.0f) {
                fAtan2 -= 360.0f;
            } else if (fAtan2 < -330.0f) {
                fAtan2 += 360.0f;
            }
            if (Math.abs(fAtan2) > 0.01d || this.f7096o) {
                float progress = this.f7101t.getProgress();
                if (!this.f7096o) {
                    this.f7096o = true;
                    this.f7101t.setProgress(progress);
                }
                int i16 = this.f7085d;
                if (i16 != -1) {
                    this.f7101t.K(i16, progress, this.f7089h, this.f7088g, this.f7097p);
                    float[] fArr = this.f7097p;
                    fArr[1] = (float) Math.toDegrees(fArr[1]);
                } else {
                    this.f7097p[1] = 360.0f;
                }
                float fMax = Math.max(Math.min(progress + ((fAtan2 * this.f7105x) / this.f7097p[1]), 1.0f), 0.0f);
                float progress2 = this.f7101t.getProgress();
                if (fMax != progress2) {
                    if (progress2 == 0.0f || progress2 == 1.0f) {
                        this.f7101t.F(progress2 == 0.0f);
                    }
                    this.f7101t.setProgress(fMax);
                    eVar.d(1000);
                    float fC = eVar.c();
                    double dB = eVar.b();
                    double d11 = fC;
                    this.f7101t.f6770d = (float) Math.toDegrees((float) ((Math.hypot(dB, d11) * Math.sin(Math.atan2(dB, d11) - dAtan2)) / Math.hypot(rawX, rawY)));
                } else {
                    this.f7101t.f6770d = 0.0f;
                }
                this.f7099r = motionEvent.getRawX();
                this.f7100s = motionEvent.getRawY();
                return;
            }
            return;
        }
        this.f7096o = false;
        eVar.d(16);
        float fC2 = eVar.c();
        float fB = eVar.b();
        float progress3 = this.f7101t.getProgress();
        float width2 = this.f7101t.getWidth() / 2.0f;
        float height2 = this.f7101t.getHeight() / 2.0f;
        int i17 = this.f7092k;
        if (i17 == -1) {
            int i18 = this.f7085d;
            if (i18 != -1) {
                View viewFindViewById3 = this.f7101t.findViewById(this.f7101t.L(i18).h());
                this.f7101t.getLocationOnScreen(this.f7098q);
                left = this.f7098q[0] + ((viewFindViewById3.getLeft() + viewFindViewById3.getRight()) / 2.0f);
                f11 = this.f7098q[1];
                top = viewFindViewById3.getTop();
                bottom = viewFindViewById3.getBottom();
            }
            float rawX2 = motionEvent.getRawX() - width2;
            float rawY2 = motionEvent.getRawY() - height2;
            double degrees2 = Math.toDegrees(Math.atan2(rawY2, rawX2));
            i12 = this.f7085d;
            if (i12 != -1) {
                this.f7101t.K(i12, progress3, this.f7089h, this.f7088g, this.f7097p);
                float[] fArr2 = this.f7097p;
                fArr2[1] = (float) Math.toDegrees(fArr2[1]);
            } else {
                this.f7097p[1] = 360.0f;
            }
            degrees = ((float) (Math.toDegrees(Math.atan2(fB + rawY2, fC2 + rawX2)) - degrees2)) * 62.5f;
            if (Float.isNaN(degrees)) {
                f12 = progress3;
            } else {
                f12 = (((degrees * 3.0f) * this.f7105x) / this.f7097p[1]) + progress3;
            }
            if (f12 != 0.0f || f12 == 1.0f || (i13 = this.f7084c) == 3) {
                if (0.0f < f12 || 1.0f <= f12) {
                    this.f7101t.setState(MotionLayout.TransitionState.FINISHED);
                }
                return;
            }
            float fAbs = (degrees * this.f7105x) / this.f7097p[1];
            float f13 = ((double) f12) < 0.5d ? 0.0f : 1.0f;
            if (i13 == 6) {
                if (progress3 + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f13 = 1.0f;
            }
            if (this.f7084c == 7) {
                if (progress3 + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f13 = 0.0f;
            }
            this.f7101t.touchAnimateTo(this.f7084c, f13, fAbs * 3.0f);
            if (0.0f >= progress3 || 1.0f <= progress3) {
                this.f7101t.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        View viewFindViewById4 = this.f7101t.findViewById(i17);
        this.f7101t.getLocationOnScreen(this.f7098q);
        left = this.f7098q[0] + ((viewFindViewById4.getLeft() + viewFindViewById4.getRight()) / 2.0f);
        f11 = this.f7098q[1];
        top = viewFindViewById4.getTop();
        bottom = viewFindViewById4.getBottom();
        height2 = f11 + ((top + bottom) / 2.0f);
        width2 = left;
        float rawX3 = motionEvent.getRawX() - width2;
        float rawY3 = motionEvent.getRawY() - height2;
        double degrees3 = Math.toDegrees(Math.atan2(rawY3, rawX3));
        i12 = this.f7085d;
        if (i12 != -1) {
            this.f7101t.K(i12, progress3, this.f7089h, this.f7088g, this.f7097p);
            float[] fArr3 = this.f7097p;
            fArr3[1] = (float) Math.toDegrees(fArr3[1]);
        } else {
            this.f7097p[1] = 360.0f;
        }
        degrees = ((float) (Math.toDegrees(Math.atan2(fB + rawY3, fC2 + rawX3)) - degrees3)) * 62.5f;
        if (Float.isNaN(degrees)) {
            f12 = (((degrees * 3.0f) * this.f7105x) / this.f7097p[1]) + progress3;
        } else {
            f12 = progress3;
        }
        if (f12 != 0.0f) {
        }
        if (0.0f < f12) {
        }
        this.f7101t.setState(MotionLayout.TransitionState.FINISHED);
    }

    public String toString() {
        if (Float.isNaN(this.f7094m)) {
            return "rotation";
        }
        return this.f7094m + " , " + this.f7095n;
    }

    public void u(float f11, float f12) {
        float progress = this.f7101t.getProgress();
        if (!this.f7096o) {
            this.f7096o = true;
            this.f7101t.setProgress(progress);
        }
        this.f7101t.K(this.f7085d, progress, this.f7089h, this.f7088g, this.f7097p);
        float f13 = this.f7094m;
        float[] fArr = this.f7097p;
        if (Math.abs((f13 * fArr[0]) + (this.f7095n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f7097p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f14 = this.f7094m;
        float fMax = Math.max(Math.min(progress + (f14 != 0.0f ? (f11 * f14) / this.f7097p[0] : (f12 * this.f7095n) / this.f7097p[1]), 1.0f), 0.0f);
        if (fMax != this.f7101t.getProgress()) {
            this.f7101t.setProgress(fMax);
        }
    }

    public void v(float f11, float f12) {
        this.f7096o = false;
        float progress = this.f7101t.getProgress();
        this.f7101t.K(this.f7085d, progress, this.f7089h, this.f7088g, this.f7097p);
        float f13 = this.f7094m;
        float[] fArr = this.f7097p;
        float f14 = f13 != 0.0f ? (f11 * f13) / fArr[0] : (f12 * this.f7095n) / fArr[1];
        if (!Float.isNaN(f14)) {
            progress += f14 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z11 = progress != 1.0f;
            int i11 = this.f7084c;
            if ((i11 != 3) && z11) {
                this.f7101t.touchAnimateTo(i11, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f14);
            }
        }
    }

    public void w(float f11, float f12) {
        this.f7099r = f11;
        this.f7100s = f12;
    }

    public void x(boolean z11) {
        if (z11) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = G[this.f7082a];
        this.f7089h = fArr5[0];
        this.f7088g = fArr5[1];
        int i11 = this.f7083b;
        float[][] fArr6 = H;
        if (i11 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i11];
        this.f7094m = fArr7[0];
        this.f7095n = fArr7[1];
    }

    public void y(int i11) {
        this.f7084c = i11;
    }

    public void z(float f11, float f12) {
        this.f7099r = f11;
        this.f7100s = f12;
        this.f7096o = false;
    }
}
