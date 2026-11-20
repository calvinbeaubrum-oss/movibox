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
public class j extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6928h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6929i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6930j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6931k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6932l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6933m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6934n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6935o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6936p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6937q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6938r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6939s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6940t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6941u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f6942v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6943w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f6944x = 0.0f;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f6945a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6945a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTimeCycle_android_alpha, 1);
            f6945a.append(R$styleable.KeyTimeCycle_android_elevation, 2);
            f6945a.append(R$styleable.KeyTimeCycle_android_rotation, 4);
            f6945a.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
            f6945a.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
            f6945a.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
            f6945a.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
            f6945a.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
            f6945a.append(R$styleable.KeyTimeCycle_motionTarget, 10);
            f6945a.append(R$styleable.KeyTimeCycle_framePosition, 12);
            f6945a.append(R$styleable.KeyTimeCycle_curveFit, 13);
            f6945a.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
            f6945a.append(R$styleable.KeyTimeCycle_android_translationX, 15);
            f6945a.append(R$styleable.KeyTimeCycle_android_translationY, 16);
            f6945a.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
            f6945a.append(R$styleable.KeyTimeCycle_motionProgress, 18);
            f6945a.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
            f6945a.append(R$styleable.KeyTimeCycle_waveOffset, 21);
            f6945a.append(R$styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(j jVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f6945a.get(index)) {
                    case 1:
                        jVar.f6929i = typedArray.getFloat(index, jVar.f6929i);
                        break;
                    case 2:
                        jVar.f6930j = typedArray.getDimension(index, jVar.f6930j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f6945a.get(index));
                        break;
                    case 4:
                        jVar.f6931k = typedArray.getFloat(index, jVar.f6931k);
                        break;
                    case 5:
                        jVar.f6932l = typedArray.getFloat(index, jVar.f6932l);
                        break;
                    case 6:
                        jVar.f6933m = typedArray.getFloat(index, jVar.f6933m);
                        break;
                    case 7:
                        jVar.f6935o = typedArray.getFloat(index, jVar.f6935o);
                        break;
                    case 8:
                        jVar.f6934n = typedArray.getFloat(index, jVar.f6934n);
                        break;
                    case 9:
                        jVar.f6927g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, jVar.f6868b);
                            jVar.f6868b = resourceId;
                            if (resourceId == -1) {
                                jVar.f6869c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            jVar.f6869c = typedArray.getString(index);
                        } else {
                            jVar.f6868b = typedArray.getResourceId(index, jVar.f6868b);
                        }
                        break;
                    case 12:
                        jVar.f6867a = typedArray.getInt(index, jVar.f6867a);
                        break;
                    case 13:
                        jVar.f6928h = typedArray.getInteger(index, jVar.f6928h);
                        break;
                    case 14:
                        jVar.f6936p = typedArray.getFloat(index, jVar.f6936p);
                        break;
                    case 15:
                        jVar.f6937q = typedArray.getDimension(index, jVar.f6937q);
                        break;
                    case 16:
                        jVar.f6938r = typedArray.getDimension(index, jVar.f6938r);
                        break;
                    case 17:
                        jVar.f6939s = typedArray.getDimension(index, jVar.f6939s);
                        break;
                    case 18:
                        jVar.f6940t = typedArray.getFloat(index, jVar.f6940t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            jVar.f6942v = typedArray.getString(index);
                            jVar.f6941u = 7;
                        } else {
                            jVar.f6941u = typedArray.getInt(index, jVar.f6941u);
                        }
                        break;
                    case 20:
                        jVar.f6943w = typedArray.getFloat(index, jVar.f6943w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            jVar.f6944x = typedArray.getDimension(index, jVar.f6944x);
                        } else {
                            jVar.f6944x = typedArray.getFloat(index, jVar.f6944x);
                        }
                        break;
                }
            }
        }
    }

    public j() {
        this.f6870d = 3;
        this.f6871e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x004d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void U(HashMap<String, x2.f> map) {
        for (String str : map.keySet()) {
            x2.f fVar = map.get(str);
            if (fVar != null) {
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
                        case -40300674:
                            if (str.equals("rotation")) {
                                b11 = 8;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                b11 = 9;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                b11 = 10;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                b11 = Ascii.VT;
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
                            if (!Float.isNaN(this.f6932l)) {
                                fVar.b(this.f6867a, this.f6932l, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f6933m)) {
                                fVar.b(this.f6867a, this.f6933m, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.f6937q)) {
                                fVar.b(this.f6867a, this.f6937q, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.f6938r)) {
                                fVar.b(this.f6867a, this.f6938r, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f6939s)) {
                                fVar.b(this.f6867a, this.f6939s, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.f6940t)) {
                                fVar.b(this.f6867a, this.f6940t, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.f6935o)) {
                                fVar.b(this.f6867a, this.f6935o, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.f6936p)) {
                                fVar.b(this.f6867a, this.f6936p, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f6931k)) {
                                fVar.b(this.f6867a, this.f6931k, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f6930j)) {
                                fVar.b(this.f6867a, this.f6930j, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.f6934n)) {
                                fVar.b(this.f6867a, this.f6934n, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.f6929i)) {
                                fVar.b(this.f6867a, this.f6929i, this.f6943w, this.f6941u, this.f6944x);
                            }
                            break;
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = this.f6871e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((x2.f.b) fVar).j(this.f6867a, constraintAttribute, this.f6943w, this.f6941u, this.f6944x);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, x2.d> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* JADX INFO: renamed from: b */
    public d clone() {
        return new j().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        j jVar = (j) dVar;
        this.f6927g = jVar.f6927g;
        this.f6928h = jVar.f6928h;
        this.f6941u = jVar.f6941u;
        this.f6943w = jVar.f6943w;
        this.f6944x = jVar.f6944x;
        this.f6940t = jVar.f6940t;
        this.f6929i = jVar.f6929i;
        this.f6930j = jVar.f6930j;
        this.f6931k = jVar.f6931k;
        this.f6934n = jVar.f6934n;
        this.f6932l = jVar.f6932l;
        this.f6933m = jVar.f6933m;
        this.f6935o = jVar.f6935o;
        this.f6936p = jVar.f6936p;
        this.f6937q = jVar.f6937q;
        this.f6938r = jVar.f6938r;
        this.f6939s = jVar.f6939s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f6929i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f6930j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f6931k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f6932l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f6933m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f6937q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f6938r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f6939s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f6934n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f6935o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f6936p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f6940t)) {
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
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void h(HashMap<String, Integer> map) {
        if (this.f6928h == -1) {
            return;
        }
        if (!Float.isNaN(this.f6929i)) {
            map.put("alpha", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6930j)) {
            map.put("elevation", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6931k)) {
            map.put("rotation", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6932l)) {
            map.put("rotationX", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6933m)) {
            map.put("rotationY", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6937q)) {
            map.put("translationX", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6938r)) {
            map.put("translationY", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6939s)) {
            map.put("translationZ", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6934n)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6935o)) {
            map.put("scaleX", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6935o)) {
            map.put("scaleY", Integer.valueOf(this.f6928h));
        }
        if (!Float.isNaN(this.f6940t)) {
            map.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.f6928h));
        }
        if (this.f6871e.size() > 0) {
            Iterator<String> it = this.f6871e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f6928h));
            }
        }
    }
}
