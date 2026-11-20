package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6873h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6874i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6875j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6876k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6877l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6878m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6879n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6880o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6881p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6882q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6883r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6884s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6885t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6886u = Float.NaN;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6887v = Float.NaN;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6888w = Float.NaN;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f6889a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6889a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            f6889a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f6889a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f6889a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f6889a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f6889a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f6889a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f6889a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f6889a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f6889a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f6889a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f6889a.append(R$styleable.KeyAttribute_framePosition, 12);
            f6889a.append(R$styleable.KeyAttribute_curveFit, 13);
            f6889a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f6889a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f6889a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f6889a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f6889a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(e eVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f6889a.get(index)) {
                    case 1:
                        eVar.f6875j = typedArray.getFloat(index, eVar.f6875j);
                        break;
                    case 2:
                        eVar.f6876k = typedArray.getDimension(index, eVar.f6876k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f6889a.get(index));
                        break;
                    case 4:
                        eVar.f6877l = typedArray.getFloat(index, eVar.f6877l);
                        break;
                    case 5:
                        eVar.f6878m = typedArray.getFloat(index, eVar.f6878m);
                        break;
                    case 6:
                        eVar.f6879n = typedArray.getFloat(index, eVar.f6879n);
                        break;
                    case 7:
                        eVar.f6883r = typedArray.getFloat(index, eVar.f6883r);
                        break;
                    case 8:
                        eVar.f6882q = typedArray.getFloat(index, eVar.f6882q);
                        break;
                    case 9:
                        eVar.f6872g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, eVar.f6868b);
                            eVar.f6868b = resourceId;
                            if (resourceId == -1) {
                                eVar.f6869c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            eVar.f6869c = typedArray.getString(index);
                        } else {
                            eVar.f6868b = typedArray.getResourceId(index, eVar.f6868b);
                        }
                        break;
                    case 12:
                        eVar.f6867a = typedArray.getInt(index, eVar.f6867a);
                        break;
                    case 13:
                        eVar.f6873h = typedArray.getInteger(index, eVar.f6873h);
                        break;
                    case 14:
                        eVar.f6884s = typedArray.getFloat(index, eVar.f6884s);
                        break;
                    case 15:
                        eVar.f6885t = typedArray.getDimension(index, eVar.f6885t);
                        break;
                    case 16:
                        eVar.f6886u = typedArray.getDimension(index, eVar.f6886u);
                        break;
                    case 17:
                        eVar.f6887v = typedArray.getDimension(index, eVar.f6887v);
                        break;
                    case 18:
                        eVar.f6888w = typedArray.getFloat(index, eVar.f6888w);
                        break;
                    case 19:
                        eVar.f6880o = typedArray.getDimension(index, eVar.f6880o);
                        break;
                    case 20:
                        eVar.f6881p = typedArray.getDimension(index, eVar.f6881p);
                        break;
                }
            }
        }
    }

    public e() {
        this.f6870d = 1;
        this.f6871e = new HashMap<>();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void R(String str, Object obj) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    b11 = 0;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    b11 = 1;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    b11 = 2;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b11 = 3;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b11 = 4;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b11 = 5;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b11 = 6;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b11 = 7;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b11 = 8;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    b11 = 9;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    b11 = 10;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b11 = Ascii.VT;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b11 = Ascii.FF;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b11 = Ascii.CR;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b11 = Ascii.SO;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    b11 = Ascii.SI;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b11 = Ascii.DLE;
                }
                break;
        }
        switch (b11) {
            case 0:
                this.f6888w = k(obj);
                break;
            case 1:
                this.f6872g = obj.toString();
                break;
            case 2:
                this.f6878m = k(obj);
                break;
            case 3:
                this.f6879n = k(obj);
                break;
            case 4:
                this.f6885t = k(obj);
                break;
            case 5:
                this.f6886u = k(obj);
                break;
            case 6:
                this.f6887v = k(obj);
                break;
            case 7:
                this.f6883r = k(obj);
                break;
            case 8:
                this.f6884s = k(obj);
                break;
            case 9:
                this.f6880o = k(obj);
                break;
            case 10:
                this.f6881p = k(obj);
                break;
            case 11:
                this.f6877l = k(obj);
                break;
            case 12:
                this.f6876k = k(obj);
                break;
            case 13:
                this.f6882q = k(obj);
                break;
            case 14:
                this.f6875j = k(obj);
                break;
            case 15:
                this.f6873h = l(obj);
                break;
            case 16:
                this.f6874i = j(obj);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, x2.d> map) {
        for (String str : map.keySet()) {
            x2.d dVar = map.get(str);
            if (dVar != null) {
                byte b11 = 7;
                if (!str.startsWith("CUSTOM")) {
                    switch (str.hashCode()) {
                        case -1249320806:
                            if (str.equals("rotationX")) {
                                b11 = 0;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1249320805:
                            if (str.equals("rotationY")) {
                                b11 = 1;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1225497657:
                            if (str.equals("translationX")) {
                                b11 = 2;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1225497656:
                            if (str.equals("translationY")) {
                                b11 = 3;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1225497655:
                            if (str.equals("translationZ")) {
                                b11 = 4;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1001078227:
                            if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                                b11 = 5;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -908189618:
                            if (str.equals("scaleX")) {
                                b11 = 6;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -908189617:
                            if (!str.equals("scaleY")) {
                                b11 = -1;
                            }
                            break;
                        case -760884510:
                            if (str.equals("transformPivotX")) {
                                b11 = 8;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -760884509:
                            if (str.equals("transformPivotY")) {
                                b11 = 9;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -40300674:
                            if (str.equals("rotation")) {
                                b11 = 10;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                b11 = Ascii.VT;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                b11 = Ascii.FF;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                b11 = Ascii.CR;
                            } else {
                                b11 = -1;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    switch (b11) {
                        case 0:
                            if (!Float.isNaN(this.f6878m)) {
                                dVar.c(this.f6867a, this.f6878m);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f6879n)) {
                                dVar.c(this.f6867a, this.f6879n);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.f6885t)) {
                                dVar.c(this.f6867a, this.f6885t);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.f6886u)) {
                                dVar.c(this.f6867a, this.f6886u);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f6887v)) {
                                dVar.c(this.f6867a, this.f6887v);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.f6888w)) {
                                dVar.c(this.f6867a, this.f6888w);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.f6883r)) {
                                dVar.c(this.f6867a, this.f6883r);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.f6884s)) {
                                dVar.c(this.f6867a, this.f6884s);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f6878m)) {
                                dVar.c(this.f6867a, this.f6880o);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f6879n)) {
                                dVar.c(this.f6867a, this.f6881p);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.f6877l)) {
                                dVar.c(this.f6867a, this.f6877l);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.f6876k)) {
                                dVar.c(this.f6867a, this.f6876k);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.f6882q)) {
                                dVar.c(this.f6867a, this.f6882q);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.f6875j)) {
                                dVar.c(this.f6867a, this.f6875j);
                            }
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = this.f6871e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((x2.d.b) dVar).i(this.f6867a, constraintAttribute);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* JADX INFO: renamed from: b */
    public d clone() {
        return new e().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        e eVar = (e) dVar;
        this.f6873h = eVar.f6873h;
        this.f6874i = eVar.f6874i;
        this.f6875j = eVar.f6875j;
        this.f6876k = eVar.f6876k;
        this.f6877l = eVar.f6877l;
        this.f6878m = eVar.f6878m;
        this.f6879n = eVar.f6879n;
        this.f6880o = eVar.f6880o;
        this.f6881p = eVar.f6881p;
        this.f6882q = eVar.f6882q;
        this.f6883r = eVar.f6883r;
        this.f6884s = eVar.f6884s;
        this.f6885t = eVar.f6885t;
        this.f6886u = eVar.f6886u;
        this.f6887v = eVar.f6887v;
        this.f6888w = eVar.f6888w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f6875j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f6876k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f6877l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f6878m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f6879n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f6880o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f6881p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f6885t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f6886u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f6887v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f6882q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f6883r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f6884s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f6888w)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (this.f6871e.size() > 0) {
            Iterator<String> it = this.f6871e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void h(HashMap<String, Integer> map) {
        if (this.f6873h == -1) {
            return;
        }
        if (!Float.isNaN(this.f6875j)) {
            map.put("alpha", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6876k)) {
            map.put("elevation", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6877l)) {
            map.put("rotation", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6878m)) {
            map.put("rotationX", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6879n)) {
            map.put("rotationY", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6880o)) {
            map.put("transformPivotX", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6881p)) {
            map.put("transformPivotY", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6885t)) {
            map.put("translationX", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6886u)) {
            map.put("translationY", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6887v)) {
            map.put("translationZ", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6882q)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6883r)) {
            map.put("scaleX", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6884s)) {
            map.put("scaleY", Integer.valueOf(this.f6873h));
        }
        if (!Float.isNaN(this.f6888w)) {
            map.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.f6873h));
        }
        if (this.f6871e.size() > 0) {
            Iterator<String> it = this.f6871e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f6873h));
            }
        }
    }
}
