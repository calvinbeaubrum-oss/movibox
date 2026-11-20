package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends d {
    public HashMap<String, Method> A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6946g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6947h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f6953n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6954o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6955p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6956q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6957r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6958s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6959t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6960u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6961v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6962w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6963x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RectF f6964y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RectF f6965z;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f6966a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6966a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
            f6966a.append(R$styleable.KeyTrigger_onCross, 4);
            f6966a.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            f6966a.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            f6966a.append(R$styleable.KeyTrigger_motionTarget, 7);
            f6966a.append(R$styleable.KeyTrigger_triggerId, 6);
            f6966a.append(R$styleable.KeyTrigger_triggerSlack, 5);
            f6966a.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f6966a.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f6966a.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            f6966a.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            f6966a.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f6966a.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(k kVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f6966a.get(index)) {
                    case 1:
                        kVar.f6949j = typedArray.getString(index);
                        break;
                    case 2:
                        kVar.f6950k = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f6966a.get(index));
                        break;
                    case 4:
                        kVar.f6947h = typedArray.getString(index);
                        break;
                    case 5:
                        kVar.f6954o = typedArray.getFloat(index, kVar.f6954o);
                        break;
                    case 6:
                        kVar.f6951l = typedArray.getResourceId(index, kVar.f6951l);
                        break;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, kVar.f6868b);
                            kVar.f6868b = resourceId;
                            if (resourceId == -1) {
                                kVar.f6869c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            kVar.f6869c = typedArray.getString(index);
                        } else {
                            kVar.f6868b = typedArray.getResourceId(index, kVar.f6868b);
                        }
                        break;
                    case 8:
                        int integer = typedArray.getInteger(index, kVar.f6867a);
                        kVar.f6867a = integer;
                        kVar.f6958s = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        kVar.f6952m = typedArray.getResourceId(index, kVar.f6952m);
                        break;
                    case 10:
                        kVar.f6960u = typedArray.getBoolean(index, kVar.f6960u);
                        break;
                    case 11:
                        kVar.f6948i = typedArray.getResourceId(index, kVar.f6948i);
                        break;
                    case 12:
                        kVar.f6963x = typedArray.getResourceId(index, kVar.f6963x);
                        break;
                    case 13:
                        kVar.f6961v = typedArray.getResourceId(index, kVar.f6961v);
                        break;
                    case 14:
                        kVar.f6962w = typedArray.getResourceId(index, kVar.f6962w);
                        break;
                }
            }
        }
    }

    public k() {
        int i11 = d.f6866f;
        this.f6948i = i11;
        this.f6949j = null;
        this.f6950k = null;
        this.f6951l = i11;
        this.f6952m = i11;
        this.f6953n = null;
        this.f6954o = 0.1f;
        this.f6955p = true;
        this.f6956q = true;
        this.f6957r = true;
        this.f6958s = Float.NaN;
        this.f6960u = false;
        this.f6961v = i11;
        this.f6962w = i11;
        this.f6963x = i11;
        this.f6964y = new RectF();
        this.f6965z = new RectF();
        this.A = new HashMap<>();
        this.f6870d = 5;
        this.f6871e = new HashMap<>();
    }

    public final void A(String str, View view) {
        boolean z11 = str.length() == 1;
        if (!z11) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f6871e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z11 || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = this.f6871e.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.a(view);
                }
            }
        }
    }

    public final void B(RectF rectF, View view, boolean z11) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z11) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, x2.d> map) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* JADX INFO: renamed from: b */
    public d clone() {
        return new k().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        k kVar = (k) dVar;
        this.f6946g = kVar.f6946g;
        this.f6947h = kVar.f6947h;
        this.f6948i = kVar.f6948i;
        this.f6949j = kVar.f6949j;
        this.f6950k = kVar.f6950k;
        this.f6951l = kVar.f6951l;
        this.f6952m = kVar.f6952m;
        this.f6953n = kVar.f6953n;
        this.f6954o = kVar.f6954o;
        this.f6955p = kVar.f6955p;
        this.f6956q = kVar.f6956q;
        this.f6957r = kVar.f6957r;
        this.f6958s = kVar.f6958s;
        this.f6959t = kVar.f6959t;
        this.f6960u = kVar.f6960u;
        this.f6964y = kVar.f6964y;
        this.f6965z = kVar.f6965z;
        this.A = kVar.A;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger), context);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00df  */
    public void y(float f11, View view) {
        boolean z11;
        boolean z12;
        boolean z13;
        float f12;
        float f13;
        boolean z14;
        boolean z15;
        float f14;
        float f15;
        boolean z16;
        if (this.f6952m != d.f6866f) {
            if (this.f6953n == null) {
                this.f6953n = ((ViewGroup) view.getParent()).findViewById(this.f6952m);
            }
            B(this.f6964y, this.f6953n, this.f6960u);
            B(this.f6965z, view, this.f6960u);
            if (this.f6964y.intersect(this.f6965z)) {
                if (this.f6955p) {
                    this.f6955p = false;
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (this.f6957r) {
                    this.f6957r = false;
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f6956q = true;
                z15 = z16;
                z13 = false;
            } else {
                if (this.f6955p) {
                    z11 = false;
                } else {
                    this.f6955p = true;
                    z11 = true;
                }
                if (this.f6956q) {
                    this.f6956q = false;
                    z13 = true;
                } else {
                    z13 = false;
                }
                this.f6957r = true;
                z15 = false;
            }
        } else {
            if (this.f6955p) {
                float f16 = this.f6958s;
                if ((f11 - f16) * (this.f6959t - f16) < 0.0f) {
                    this.f6955p = false;
                    z11 = true;
                }
                if (this.f6956q) {
                    f14 = this.f6958s;
                    f15 = f11 - f14;
                    if ((this.f6959t - f14) * f15 >= 0.0f && f15 < 0.0f) {
                        this.f6956q = false;
                        z12 = true;
                    }
                    if (this.f6957r) {
                        f12 = this.f6958s;
                        f13 = f11 - f12;
                        if ((this.f6959t - f12) * f13 < 0.0f || f13 <= 0.0f) {
                            z14 = false;
                        } else {
                            this.f6957r = false;
                            z14 = true;
                        }
                        boolean z17 = z12;
                        z15 = z14;
                        z13 = z17;
                    } else {
                        if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                            this.f6957r = true;
                        }
                        z13 = z12;
                        z15 = false;
                    }
                } else if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                    this.f6956q = true;
                }
                z12 = false;
                if (this.f6957r) {
                    f12 = this.f6958s;
                    f13 = f11 - f12;
                    if ((this.f6959t - f12) * f13 < 0.0f) {
                        z14 = false;
                    } else {
                        z14 = false;
                    }
                    boolean z18 = z12;
                    z15 = z14;
                    z13 = z18;
                } else {
                    if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                        this.f6957r = true;
                    }
                    z13 = z12;
                    z15 = false;
                }
            } else if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                this.f6955p = true;
            }
            z11 = false;
            if (this.f6956q) {
                f14 = this.f6958s;
                f15 = f11 - f14;
                if ((this.f6959t - f14) * f15 >= 0.0f) {
                }
                if (this.f6957r) {
                    f12 = this.f6958s;
                    f13 = f11 - f12;
                    if ((this.f6959t - f12) * f13 < 0.0f) {
                        z14 = false;
                    } else {
                        z14 = false;
                    }
                    boolean z19 = z12;
                    z15 = z14;
                    z13 = z19;
                } else {
                    if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                        this.f6957r = true;
                    }
                    z13 = z12;
                    z15 = false;
                }
            } else if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                this.f6956q = true;
            }
            z12 = false;
            if (this.f6957r) {
                f12 = this.f6958s;
                f13 = f11 - f12;
                if ((this.f6959t - f12) * f13 < 0.0f) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                boolean z110 = z12;
                z15 = z14;
                z13 = z110;
            } else {
                if (Math.abs(f11 - this.f6958s) > this.f6954o) {
                    this.f6957r = true;
                }
                z13 = z12;
                z15 = false;
            }
        }
        this.f6959t = f11;
        if (z13 || z11 || z15) {
            ((MotionLayout) view.getParent()).fireTrigger(this.f6951l, z15, f11);
        }
        View viewFindViewById = this.f6948i == d.f6866f ? view : ((MotionLayout) view.getParent()).findViewById(this.f6948i);
        if (z13) {
            String str = this.f6949j;
            if (str != null) {
                z(str, viewFindViewById);
            }
            if (this.f6961v != d.f6866f) {
                ((MotionLayout) view.getParent()).viewTransition(this.f6961v, viewFindViewById);
            }
        }
        if (z15) {
            String str2 = this.f6950k;
            if (str2 != null) {
                z(str2, viewFindViewById);
            }
            if (this.f6962w != d.f6866f) {
                ((MotionLayout) view.getParent()).viewTransition(this.f6962w, viewFindViewById);
            }
        }
        if (z11) {
            String str3 = this.f6947h;
            if (str3 != null) {
                z(str3, viewFindViewById);
            }
            if (this.f6963x != d.f6866f) {
                ((MotionLayout) view.getParent()).viewTransition(this.f6963x, viewFindViewById);
            }
        }
    }

    public final void z(String str, View view) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(InstructionFileId.DOT)) {
            A(str, view);
            return;
        }
        if (this.A.containsKey(str)) {
            method = this.A.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, new Class[0]);
                this.A.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.A.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + androidx.constraintlayout.motion.widget.a.d(view));
                return;
            }
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.f6947h + "\"on class " + view.getClass().getSimpleName() + " " + androidx.constraintlayout.motion.widget.a.d(view));
        }
    }
}
