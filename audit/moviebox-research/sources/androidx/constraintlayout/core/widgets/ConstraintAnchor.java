package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w2.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f6522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f6523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f6524f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable f6527i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f6519a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6525g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6526h = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: source.java */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6528a;

        static {
            int[] iArr = new int[Type.values().length];
            f6528a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6528a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6528a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6528a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6528a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6528a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6528a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6528a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6528a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f6522d = constraintWidget;
        this.f6523e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i11) {
        return b(constraintAnchor, i11, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i11, int i12, boolean z11) {
        if (constraintAnchor == null) {
            q();
            return true;
        }
        if (!z11 && !p(constraintAnchor)) {
            return false;
        }
        this.f6524f = constraintAnchor;
        if (constraintAnchor.f6519a == null) {
            constraintAnchor.f6519a = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.f6524f.f6519a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f6525g = i11;
        this.f6526h = i12;
        return true;
    }

    public void c(int i11, ArrayList<j> arrayList, j jVar) {
        HashSet<ConstraintAnchor> hashSet = this.f6519a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                w2.g.a(it.next().f6522d, i11, arrayList, jVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> d() {
        return this.f6519a;
    }

    public int e() {
        if (this.f6521c) {
            return this.f6520b;
        }
        return 0;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f6522d.X() == 8) {
            return 0;
        }
        return (this.f6526h == Integer.MIN_VALUE || (constraintAnchor = this.f6524f) == null || constraintAnchor.f6522d.X() != 8) ? this.f6525g : this.f6526h;
    }

    public final ConstraintAnchor g() {
        switch (a.f6528a[this.f6523e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f6522d.S;
            case 3:
                return this.f6522d.Q;
            case 4:
                return this.f6522d.T;
            case 5:
                return this.f6522d.R;
            default:
                throw new AssertionError(this.f6523e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f6522d;
    }

    public SolverVariable i() {
        return this.f6527i;
    }

    public ConstraintAnchor j() {
        return this.f6524f;
    }

    public Type k() {
        return this.f6523e;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f6519a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f6519a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.f6521c;
    }

    public boolean o() {
        return this.f6524f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type typeK = constraintAnchor.k();
        Type type = this.f6523e;
        if (typeK == type) {
            return type != Type.BASELINE || (constraintAnchor.h().b0() && h().b0());
        }
        switch (a.f6528a[type.ordinal()]) {
            case 1:
                return (typeK == Type.BASELINE || typeK == Type.CENTER_X || typeK == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z11 = typeK == Type.LEFT || typeK == Type.RIGHT;
                if (constraintAnchor.h() instanceof f) {
                    return z11 || typeK == Type.CENTER_X;
                }
                return z11;
            case 4:
            case 5:
                boolean z12 = typeK == Type.TOP || typeK == Type.BOTTOM;
                if (constraintAnchor.h() instanceof f) {
                    return z12 || typeK == Type.CENTER_Y;
                }
                return z12;
            case 6:
                return (typeK == Type.LEFT || typeK == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f6523e.name());
        }
    }

    public void q() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f6524f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f6519a) != null) {
            hashSet.remove(this);
            if (this.f6524f.f6519a.size() == 0) {
                this.f6524f.f6519a = null;
            }
        }
        this.f6519a = null;
        this.f6524f = null;
        this.f6525g = 0;
        this.f6526h = Integer.MIN_VALUE;
        this.f6521c = false;
        this.f6520b = 0;
    }

    public void r() {
        this.f6521c = false;
        this.f6520b = 0;
    }

    public void s(androidx.constraintlayout.core.c cVar) {
        SolverVariable solverVariable = this.f6527i;
        if (solverVariable == null) {
            this.f6527i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.e();
        }
    }

    public void t(int i11) {
        this.f6520b = i11;
        this.f6521c = true;
    }

    public String toString() {
        return this.f6522d.v() + ":" + this.f6523e.toString();
    }

    public void u(int i11) {
        if (o()) {
            this.f6526h = i11;
        }
    }
}
