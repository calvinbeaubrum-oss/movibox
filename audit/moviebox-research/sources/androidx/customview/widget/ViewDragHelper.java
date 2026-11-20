package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.logging.type.LogSeverity;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ViewDragHelper {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Interpolator f8110x = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8112b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f8114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f8115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f8116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f8117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f8118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f8119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f8120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f8122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f8123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f8124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f8126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OverScroller f8128r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f8129s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f8130t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8131u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f8132v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8113c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f8133w = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.M(0);
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public abstract int a(@NonNull View view, int i11, int i12);

        public int b(@NonNull View view, int i11, int i12) {
            return 0;
        }

        public int c(int i11) {
            return i11;
        }

        public int d(@NonNull View view) {
            return 0;
        }

        public int e(@NonNull View view) {
            return 0;
        }

        public void f(int i11, int i12) {
        }

        public boolean g(int i11) {
            return false;
        }

        public void h(int i11, int i12) {
        }

        public void i(@NonNull View view, int i11) {
        }

        public void j(int i11) {
        }

        public void k(@NonNull View view, int i11, int i12, int i13, int i14) {
        }

        public abstract void l(@NonNull View view, float f11, float f12);

        public abstract boolean m(@NonNull View view, int i11);
    }

    public ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull b bVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f8132v = viewGroup;
        this.f8129s = bVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i11 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f8126p = i11;
        this.f8125o = i11;
        this.f8112b = viewConfiguration.getScaledTouchSlop();
        this.f8123m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f8124n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8128r = new OverScroller(context, f8110x);
    }

    public static ViewDragHelper o(@NonNull ViewGroup viewGroup, float f11, @NonNull b bVar) {
        ViewDragHelper viewDragHelperP = p(viewGroup, bVar);
        viewDragHelperP.f8112b = (int) (viewDragHelperP.f8112b * (1.0f / f11));
        return viewDragHelperP;
    }

    public static ViewDragHelper p(@NonNull ViewGroup viewGroup, @NonNull b bVar) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, bVar);
    }

    public int A() {
        return this.f8112b;
    }

    public int B() {
        return this.f8111a;
    }

    public boolean C(int i11, int i12) {
        return G(this.f8130t, i11, i12);
    }

    public boolean D(int i11, int i12) {
        return E(i12) && (i11 & this.f8118h[i12]) != 0;
    }

    public boolean E(int i11) {
        return ((1 << i11) & this.f8121k) != 0;
    }

    public final boolean F(int i11) {
        if (E(i11)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i11 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean G(@Nullable View view, int i11, int i12) {
        return view != null && i11 >= view.getLeft() && i11 < view.getRight() && i12 >= view.getTop() && i12 < view.getBottom();
    }

    public void H(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f8122l == null) {
            this.f8122l = VelocityTracker.obtain();
        }
        this.f8122l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewU = u((int) x11, (int) y11);
            K(x11, y11, pointerId);
            T(viewU, pointerId);
            int i12 = this.f8118h[pointerId];
            int i13 = this.f8127q;
            if ((i12 & i13) != 0) {
                this.f8129s.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f8111a == 1) {
                I();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.f8111a == 1) {
                if (F(this.f8113c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f8113c);
                    float x12 = motionEvent.getX(iFindPointerIndex);
                    float y12 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f8116f;
                    int i14 = this.f8113c;
                    int i15 = (int) (x12 - fArr[i14]);
                    int i16 = (int) (y12 - this.f8117g[i14]);
                    s(this.f8130t.getLeft() + i15, this.f8130t.getTop() + i16, i15, i16);
                    L(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i11 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i11);
                if (F(pointerId2)) {
                    float x13 = motionEvent.getX(i11);
                    float y13 = motionEvent.getY(i11);
                    float f11 = x13 - this.f8114d[pointerId2];
                    float f12 = y13 - this.f8115e[pointerId2];
                    J(f11, f12, pointerId2);
                    if (this.f8111a != 1) {
                        View viewU2 = u((int) x13, (int) y13);
                        if (g(viewU2, f11, f12) && T(viewU2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            L(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f8111a == 1) {
                q(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x14 = motionEvent.getX(actionIndex);
            float y14 = motionEvent.getY(actionIndex);
            K(x14, y14, pointerId3);
            if (this.f8111a != 0) {
                if (C((int) x14, (int) y14)) {
                    T(this.f8130t, pointerId3);
                    return;
                }
                return;
            } else {
                T(u((int) x14, (int) y14), pointerId3);
                int i17 = this.f8118h[pointerId3];
                int i18 = this.f8127q;
                if ((i17 & i18) != 0) {
                    this.f8129s.h(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f8111a == 1 && pointerId4 == this.f8113c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i11 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f8113c) {
                    View viewU3 = u((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f8130t;
                    if (viewU3 == view && T(view, pointerId5)) {
                        if (this.f8113c == -1) {
                            break;
                        }
                    }
                }
                i11++;
            }
            I();
        }
        k(pointerId4);
    }

    public final void I() {
        this.f8122l.computeCurrentVelocity(1000, this.f8123m);
        q(h(this.f8122l.getXVelocity(this.f8113c), this.f8124n, this.f8123m), h(this.f8122l.getYVelocity(this.f8113c), this.f8124n, this.f8123m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$b] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void J(float f11, float f12, int i11) {
        int i12;
        boolean zD = d(f11, f12, i11, 1);
        ?? r11 = zD;
        if (d(f12, f11, i11, 4)) {
            r11 = (zD ? 1 : 0) | 4;
        }
        ?? r12 = r11;
        if (d(f11, f12, i11, 2)) {
            r12 = (r11 == true ? 1 : 0) | 2;
        }
        ?? r13 = r12;
        if (d(f12, f11, i11, 8)) {
            i12 = (r12 == true ? 1 : 0) | 8;
        }
        if (r13 == 0) {
            r13 = i12;
            return;
        }
        r13 = i12;
        int[] iArr = this.f8119i;
        iArr[i11] = (iArr[i11] | r13) == true ? 1 : 0;
        this.f8129s.f(r13, i11);
    }

    public final void K(float f11, float f12, int i11) {
        t(i11);
        float[] fArr = this.f8114d;
        this.f8116f[i11] = f11;
        fArr[i11] = f11;
        float[] fArr2 = this.f8115e;
        this.f8117g[i11] = f12;
        fArr2[i11] = f12;
        this.f8118h[i11] = z((int) f11, (int) f12);
        this.f8121k |= 1 << i11;
    }

    public final void L(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i11 = 0; i11 < pointerCount; i11++) {
            int pointerId = motionEvent.getPointerId(i11);
            if (F(pointerId)) {
                float x11 = motionEvent.getX(i11);
                float y11 = motionEvent.getY(i11);
                this.f8116f[pointerId] = x11;
                this.f8117g[pointerId] = y11;
            }
        }
    }

    public void M(int i11) {
        this.f8132v.removeCallbacks(this.f8133w);
        if (this.f8111a != i11) {
            this.f8111a = i11;
            this.f8129s.j(i11);
            if (this.f8111a == 0) {
                this.f8130t = null;
            }
        }
    }

    public void N(int i11) {
        this.f8125o = i11;
    }

    public void O(int i11) {
        this.f8127q = i11;
    }

    public void P(float f11) {
        this.f8124n = f11;
    }

    public boolean Q(int i11, int i12) {
        if (this.f8131u) {
            return v(i11, i12, (int) this.f8122l.getXVelocity(this.f8113c), (int) this.f8122l.getYVelocity(this.f8113c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean R(@NonNull MotionEvent motionEvent) {
        boolean z11;
        View viewU;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f8122l == null) {
            this.f8122l = VelocityTracker.obtain();
        }
        this.f8122l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                b();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    b();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x11 = motionEvent.getX(actionIndex);
                    float y11 = motionEvent.getY(actionIndex);
                    K(x11, y11, pointerId);
                    int i11 = this.f8111a;
                    if (i11 == 0) {
                        int i12 = this.f8118h[pointerId];
                        int i13 = this.f8127q;
                        if ((i12 & i13) != 0) {
                            this.f8129s.h(i12 & i13, pointerId);
                        }
                    } else if (i11 == 2 && (viewU = u((int) x11, (int) y11)) == this.f8130t) {
                        T(viewU, pointerId);
                    }
                } else if (actionMasked == 6) {
                    k(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f8114d != null && this.f8115e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i14 = 0; i14 < pointerCount; i14++) {
                    int pointerId2 = motionEvent.getPointerId(i14);
                    if (F(pointerId2)) {
                        float x12 = motionEvent.getX(i14);
                        float y12 = motionEvent.getY(i14);
                        float f11 = x12 - this.f8114d[pointerId2];
                        float f12 = y12 - this.f8115e[pointerId2];
                        View viewU2 = u((int) x12, (int) y12);
                        boolean z12 = viewU2 != null && g(viewU2, f11, f12);
                        if (!z12) {
                            J(f11, f12, pointerId2);
                            if (this.f8111a != 1) {
                                break;
                            }
                        } else {
                            int left = viewU2.getLeft();
                            int i15 = (int) f11;
                            int iA = this.f8129s.a(viewU2, left + i15, i15);
                            int top = viewU2.getTop();
                            int i16 = (int) f12;
                            int iB = this.f8129s.b(viewU2, top + i16, i16);
                            int iD = this.f8129s.d(viewU2);
                            int iE = this.f8129s.e(viewU2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            J(f11, f12, pointerId2);
                            if (this.f8111a != 1 || (z12 && T(viewU2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                L(motionEvent);
            }
            z11 = false;
        } else {
            float x13 = motionEvent.getX();
            float y13 = motionEvent.getY();
            z11 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            K(x13, y13, pointerId3);
            View viewU3 = u((int) x13, (int) y13);
            if (viewU3 == this.f8130t && this.f8111a == 2) {
                T(viewU3, pointerId3);
            }
            int i17 = this.f8118h[pointerId3];
            int i18 = this.f8127q;
            if ((i17 & i18) != 0) {
                this.f8129s.h(i17 & i18, pointerId3);
            }
        }
        if (this.f8111a == 1) {
            return true;
        }
        return z11;
    }

    public boolean S(@NonNull View view, int i11, int i12) {
        this.f8130t = view;
        this.f8113c = -1;
        boolean zV = v(i11, i12, 0, 0);
        if (!zV && this.f8111a == 0 && this.f8130t != null) {
            this.f8130t = null;
        }
        return zV;
    }

    public boolean T(View view, int i11) {
        if (view == this.f8130t && this.f8113c == i11) {
            return true;
        }
        if (view == null || !this.f8129s.m(view, i11)) {
            return false;
        }
        this.f8113c = i11;
        c(view, i11);
        return true;
    }

    public void a() {
        b();
        if (this.f8111a == 2) {
            int currX = this.f8128r.getCurrX();
            int currY = this.f8128r.getCurrY();
            this.f8128r.abortAnimation();
            int currX2 = this.f8128r.getCurrX();
            int currY2 = this.f8128r.getCurrY();
            this.f8129s.k(this.f8130t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        M(0);
    }

    public void b() {
        this.f8113c = -1;
        j();
        VelocityTracker velocityTracker = this.f8122l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8122l = null;
        }
    }

    public void c(@NonNull View view, int i11) {
        if (view.getParent() == this.f8132v) {
            this.f8130t = view;
            this.f8113c = i11;
            this.f8129s.i(view, i11);
            M(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f8132v + ")");
    }

    public final boolean d(float f11, float f12, int i11, int i12) {
        float fAbs = Math.abs(f11);
        float fAbs2 = Math.abs(f12);
        if ((this.f8118h[i11] & i12) != i12 || (this.f8127q & i12) == 0 || (this.f8120j[i11] & i12) == i12 || (this.f8119i[i11] & i12) == i12) {
            return false;
        }
        int i13 = this.f8112b;
        if (fAbs <= i13 && fAbs2 <= i13) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f8129s.g(i12)) {
            return (this.f8119i[i11] & i12) == 0 && fAbs > ((float) this.f8112b);
        }
        int[] iArr = this.f8120j;
        iArr[i11] = iArr[i11] | i12;
        return false;
    }

    public boolean e(int i11) {
        int length = this.f8114d.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (f(i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i11, int i12) {
        if (!E(i12)) {
            return false;
        }
        boolean z11 = (i11 & 1) == 1;
        boolean z12 = (i11 & 2) == 2;
        float f11 = this.f8116f[i12] - this.f8114d[i12];
        float f12 = this.f8117g[i12] - this.f8115e[i12];
        if (z11 && z12) {
            float f13 = (f11 * f11) + (f12 * f12);
            int i13 = this.f8112b;
            return f13 > ((float) (i13 * i13));
        }
        if (z11) {
            return Math.abs(f11) > ((float) this.f8112b);
        }
        return z12 && Math.abs(f12) > ((float) this.f8112b);
    }

    public final boolean g(View view, float f11, float f12) {
        if (view == null) {
            return false;
        }
        boolean z11 = this.f8129s.d(view) > 0;
        boolean z12 = this.f8129s.e(view) > 0;
        if (z11 && z12) {
            float f13 = (f11 * f11) + (f12 * f12);
            int i11 = this.f8112b;
            return f13 > ((float) (i11 * i11));
        }
        if (z11) {
            return Math.abs(f11) > ((float) this.f8112b);
        }
        return z12 && Math.abs(f12) > ((float) this.f8112b);
    }

    public final float h(float f11, float f12, float f13) {
        float fAbs = Math.abs(f11);
        if (fAbs < f12) {
            return 0.0f;
        }
        if (fAbs > f13) {
            return f11 > 0.0f ? f13 : -f13;
        }
        return f11;
    }

    public final int i(int i11, int i12, int i13) {
        int iAbs = Math.abs(i11);
        if (iAbs < i12) {
            return 0;
        }
        if (iAbs > i13) {
            return i11 > 0 ? i13 : -i13;
        }
        return i11;
    }

    public final void j() {
        float[] fArr = this.f8114d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f8115e, 0.0f);
        Arrays.fill(this.f8116f, 0.0f);
        Arrays.fill(this.f8117g, 0.0f);
        Arrays.fill(this.f8118h, 0);
        Arrays.fill(this.f8119i, 0);
        Arrays.fill(this.f8120j, 0);
        this.f8121k = 0;
    }

    public final void k(int i11) {
        if (this.f8114d == null || !E(i11)) {
            return;
        }
        this.f8114d[i11] = 0.0f;
        this.f8115e[i11] = 0.0f;
        this.f8116f[i11] = 0.0f;
        this.f8117g[i11] = 0.0f;
        this.f8118h[i11] = 0;
        this.f8119i[i11] = 0;
        this.f8120j[i11] = 0;
        this.f8121k = (~(1 << i11)) & this.f8121k;
    }

    public final int l(int i11, int i12, int i13) {
        if (i11 == 0) {
            return 0;
        }
        int width = this.f8132v.getWidth();
        float f11 = width / 2;
        float fR = f11 + (r(Math.min(1.0f, Math.abs(i11) / width)) * f11);
        int iAbs = Math.abs(i12);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fR / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i11) / i13) + 1.0f) * 256.0f), LogSeverity.CRITICAL_VALUE);
    }

    public final int m(View view, int i11, int i12, int i13, int i14) {
        float f11;
        float f12;
        float f13;
        float f14;
        int i15 = i(i13, (int) this.f8124n, (int) this.f8123m);
        int i16 = i(i14, (int) this.f8124n, (int) this.f8123m);
        int iAbs = Math.abs(i11);
        int iAbs2 = Math.abs(i12);
        int iAbs3 = Math.abs(i15);
        int iAbs4 = Math.abs(i16);
        int i17 = iAbs3 + iAbs4;
        int i18 = iAbs + iAbs2;
        if (i15 != 0) {
            f11 = iAbs3;
            f12 = i17;
        } else {
            f11 = iAbs;
            f12 = i18;
        }
        float f15 = f11 / f12;
        if (i16 != 0) {
            f13 = iAbs4;
            f14 = i17;
        } else {
            f13 = iAbs2;
            f14 = i18;
        }
        return (int) ((l(i11, i15, this.f8129s.d(view)) * f15) + (l(i12, i16, this.f8129s.e(view)) * (f13 / f14)));
    }

    public boolean n(boolean z11) {
        if (this.f8111a == 2) {
            boolean zComputeScrollOffset = this.f8128r.computeScrollOffset();
            int currX = this.f8128r.getCurrX();
            int currY = this.f8128r.getCurrY();
            int left = currX - this.f8130t.getLeft();
            int top = currY - this.f8130t.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.f8130t, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.f8130t, top);
            }
            if (left != 0 || top != 0) {
                this.f8129s.k(this.f8130t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f8128r.getFinalX() && currY == this.f8128r.getFinalY()) {
                this.f8128r.abortAnimation();
            } else if (!zComputeScrollOffset) {
            }
            if (z11) {
                this.f8132v.post(this.f8133w);
            } else {
                M(0);
            }
        }
        return this.f8111a == 2;
    }

    public final void q(float f11, float f12) {
        this.f8131u = true;
        this.f8129s.l(this.f8130t, f11, f12);
        this.f8131u = false;
        if (this.f8111a == 1) {
            M(0);
        }
    }

    public final float r(float f11) {
        return (float) Math.sin((f11 - 0.5f) * 0.47123894f);
    }

    public final void s(int i11, int i12, int i13, int i14) {
        int left = this.f8130t.getLeft();
        int top = this.f8130t.getTop();
        if (i13 != 0) {
            i11 = this.f8129s.a(this.f8130t, i11, i13);
            ViewCompat.offsetLeftAndRight(this.f8130t, i11 - left);
        }
        int i15 = i11;
        if (i14 != 0) {
            i12 = this.f8129s.b(this.f8130t, i12, i14);
            ViewCompat.offsetTopAndBottom(this.f8130t, i12 - top);
        }
        int i16 = i12;
        if (i13 == 0 && i14 == 0) {
            return;
        }
        this.f8129s.k(this.f8130t, i15, i16, i15 - left, i16 - top);
    }

    public final void t(int i11) {
        float[] fArr = this.f8114d;
        if (fArr == null || fArr.length <= i11) {
            int i12 = i11 + 1;
            float[] fArr2 = new float[i12];
            float[] fArr3 = new float[i12];
            float[] fArr4 = new float[i12];
            float[] fArr5 = new float[i12];
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int[] iArr3 = new int[i12];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f8115e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f8116f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f8117g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f8118h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f8119i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f8120j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f8114d = fArr2;
            this.f8115e = fArr3;
            this.f8116f = fArr4;
            this.f8117g = fArr5;
            this.f8118h = iArr;
            this.f8119i = iArr2;
            this.f8120j = iArr3;
        }
    }

    @Nullable
    public View u(int i11, int i12) {
        for (int childCount = this.f8132v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f8132v.getChildAt(this.f8129s.c(childCount));
            if (i11 >= childAt.getLeft() && i11 < childAt.getRight() && i12 >= childAt.getTop() && i12 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean v(int i11, int i12, int i13, int i14) {
        int left = this.f8130t.getLeft();
        int top = this.f8130t.getTop();
        int i15 = i11 - left;
        int i16 = i12 - top;
        if (i15 == 0 && i16 == 0) {
            this.f8128r.abortAnimation();
            M(0);
            return false;
        }
        this.f8128r.startScroll(left, top, i15, i16, m(this.f8130t, i15, i16, i13, i14));
        M(2);
        return true;
    }

    @Nullable
    public View w() {
        return this.f8130t;
    }

    public int x() {
        return this.f8126p;
    }

    public int y() {
        return this.f8125o;
    }

    public final int z(int i11, int i12) {
        int i13 = i11 < this.f8132v.getLeft() + this.f8125o ? 1 : 0;
        if (i12 < this.f8132v.getTop() + this.f8125o) {
            i13 |= 4;
        }
        if (i11 > this.f8132v.getRight() - this.f8125o) {
            i13 |= 2;
        }
        return i12 > this.f8132v.getBottom() - this.f8125o ? i13 | 8 : i13;
    }
}
