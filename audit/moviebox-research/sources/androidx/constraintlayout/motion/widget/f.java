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
public class f extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6890g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6891h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6892i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6893j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6894k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6895l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6896m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6897n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6898o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6899p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6900q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6901r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6902s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6903t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6904u = Float.NaN;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6905v = Float.NaN;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6906w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f6907x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6908y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6909z = Float.NaN;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f6910a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6910a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
            f6910a.append(R$styleable.KeyCycle_framePosition, 2);
            f6910a.append(R$styleable.KeyCycle_transitionEasing, 3);
            f6910a.append(R$styleable.KeyCycle_curveFit, 4);
            f6910a.append(R$styleable.KeyCycle_waveShape, 5);
            f6910a.append(R$styleable.KeyCycle_wavePeriod, 6);
            f6910a.append(R$styleable.KeyCycle_waveOffset, 7);
            f6910a.append(R$styleable.KeyCycle_waveVariesBy, 8);
            f6910a.append(R$styleable.KeyCycle_android_alpha, 9);
            f6910a.append(R$styleable.KeyCycle_android_elevation, 10);
            f6910a.append(R$styleable.KeyCycle_android_rotation, 11);
            f6910a.append(R$styleable.KeyCycle_android_rotationX, 12);
            f6910a.append(R$styleable.KeyCycle_android_rotationY, 13);
            f6910a.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            f6910a.append(R$styleable.KeyCycle_android_scaleX, 15);
            f6910a.append(R$styleable.KeyCycle_android_scaleY, 16);
            f6910a.append(R$styleable.KeyCycle_android_translationX, 17);
            f6910a.append(R$styleable.KeyCycle_android_translationY, 18);
            f6910a.append(R$styleable.KeyCycle_android_translationZ, 19);
            f6910a.append(R$styleable.KeyCycle_motionProgress, 20);
            f6910a.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        public static void b(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f6910a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, fVar.f6868b);
                            fVar.f6868b = resourceId;
                            if (resourceId == -1) {
                                fVar.f6869c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            fVar.f6869c = typedArray.getString(index);
                        } else {
                            fVar.f6868b = typedArray.getResourceId(index, fVar.f6868b);
                        }
                        break;
                    case 2:
                        fVar.f6867a = typedArray.getInt(index, fVar.f6867a);
                        break;
                    case 3:
                        fVar.f6890g = typedArray.getString(index);
                        break;
                    case 4:
                        fVar.f6891h = typedArray.getInteger(index, fVar.f6891h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            fVar.f6893j = typedArray.getString(index);
                            fVar.f6892i = 7;
                        } else {
                            fVar.f6892i = typedArray.getInt(index, fVar.f6892i);
                        }
                        break;
                    case 6:
                        fVar.f6894k = typedArray.getFloat(index, fVar.f6894k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            fVar.f6895l = typedArray.getDimension(index, fVar.f6895l);
                        } else {
                            fVar.f6895l = typedArray.getFloat(index, fVar.f6895l);
                        }
                        break;
                    case 8:
                        fVar.f6898o = typedArray.getInt(index, fVar.f6898o);
                        break;
                    case 9:
                        fVar.f6899p = typedArray.getFloat(index, fVar.f6899p);
                        break;
                    case 10:
                        fVar.f6900q = typedArray.getDimension(index, fVar.f6900q);
                        break;
                    case 11:
                        fVar.f6901r = typedArray.getFloat(index, fVar.f6901r);
                        break;
                    case 12:
                        fVar.f6903t = typedArray.getFloat(index, fVar.f6903t);
                        break;
                    case 13:
                        fVar.f6904u = typedArray.getFloat(index, fVar.f6904u);
                        break;
                    case 14:
                        fVar.f6902s = typedArray.getFloat(index, fVar.f6902s);
                        break;
                    case 15:
                        fVar.f6905v = typedArray.getFloat(index, fVar.f6905v);
                        break;
                    case 16:
                        fVar.f6906w = typedArray.getFloat(index, fVar.f6906w);
                        break;
                    case 17:
                        fVar.f6907x = typedArray.getDimension(index, fVar.f6907x);
                        break;
                    case 18:
                        fVar.f6908y = typedArray.getDimension(index, fVar.f6908y);
                        break;
                    case 19:
                        fVar.f6909z = typedArray.getDimension(index, fVar.f6909z);
                        break;
                    case 20:
                        fVar.f6897n = typedArray.getFloat(index, fVar.f6897n);
                        break;
                    case 21:
                        fVar.f6896m = typedArray.getFloat(index, fVar.f6896m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f6910a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f6870d = 4;
        this.f6871e = new HashMap<>();
    }

    public void Y(HashMap<String, x2.c> map) {
        x2.c cVar;
        x2.c cVar2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.f6871e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.d() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (cVar = map.get(str)) != null) {
                    cVar.e(this.f6867a, this.f6892i, this.f6893j, this.f6898o, this.f6894k, this.f6895l, this.f6896m, constraintAttribute.e(), constraintAttribute);
                }
            } else {
                float fZ = Z(str);
                if (!Float.isNaN(fZ) && (cVar2 = map.get(str)) != null) {
                    cVar2.d(this.f6867a, this.f6892i, this.f6893j, this.f6898o, this.f6894k, this.f6895l, this.f6896m, fZ);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public float Z(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    b11 = 0;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b11 = 1;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b11 = 2;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b11 = 3;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b11 = 4;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    b11 = 5;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b11 = 6;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b11 = 7;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b11 = 8;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b11 = 9;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b11 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b11 = Ascii.VT;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b11 = Ascii.FF;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    b11 = Ascii.CR;
                }
                break;
        }
        switch (b11) {
            case 0:
                return this.f6903t;
            case 1:
                return this.f6904u;
            case 2:
                return this.f6907x;
            case 3:
                return this.f6908y;
            case 4:
                return this.f6909z;
            case 5:
                return this.f6897n;
            case 6:
                return this.f6905v;
            case 7:
                return this.f6906w;
            case 8:
                return this.f6901r;
            case 9:
                return this.f6900q;
            case 10:
                return this.f6902s;
            case 11:
                return this.f6899p;
            case 12:
                return this.f6895l;
            case 13:
                return this.f6896m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, x2.d> map) {
        androidx.constraintlayout.motion.widget.a.g("KeyCycle", "add " + map.size() + " values", 2);
        for (String str : map.keySet()) {
            x2.d dVar = map.get(str);
            if (dVar != null) {
                str.hashCode();
                byte b11 = -1;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            b11 = 0;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            b11 = 1;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            b11 = 2;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            b11 = 3;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            b11 = 4;
                        }
                        break;
                    case -1001078227:
                        if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                            b11 = 5;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            b11 = 6;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            b11 = 7;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            b11 = 8;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            b11 = 9;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            b11 = 10;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            b11 = Ascii.VT;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            b11 = Ascii.FF;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            b11 = Ascii.CR;
                        }
                        break;
                }
                switch (b11) {
                    case 0:
                        dVar.c(this.f6867a, this.f6903t);
                        break;
                    case 1:
                        dVar.c(this.f6867a, this.f6904u);
                        break;
                    case 2:
                        dVar.c(this.f6867a, this.f6907x);
                        break;
                    case 3:
                        dVar.c(this.f6867a, this.f6908y);
                        break;
                    case 4:
                        dVar.c(this.f6867a, this.f6909z);
                        break;
                    case 5:
                        dVar.c(this.f6867a, this.f6897n);
                        break;
                    case 6:
                        dVar.c(this.f6867a, this.f6905v);
                        break;
                    case 7:
                        dVar.c(this.f6867a, this.f6906w);
                        break;
                    case 8:
                        dVar.c(this.f6867a, this.f6901r);
                        break;
                    case 9:
                        dVar.c(this.f6867a, this.f6900q);
                        break;
                    case 10:
                        dVar.c(this.f6867a, this.f6902s);
                        break;
                    case 11:
                        dVar.c(this.f6867a, this.f6899p);
                        break;
                    case 12:
                        dVar.c(this.f6867a, this.f6895l);
                        break;
                    case 13:
                        dVar.c(this.f6867a, this.f6896m);
                        break;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                        }
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* JADX INFO: renamed from: b */
    public d clone() {
        return new f().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        f fVar = (f) dVar;
        this.f6890g = fVar.f6890g;
        this.f6891h = fVar.f6891h;
        this.f6892i = fVar.f6892i;
        this.f6893j = fVar.f6893j;
        this.f6894k = fVar.f6894k;
        this.f6895l = fVar.f6895l;
        this.f6896m = fVar.f6896m;
        this.f6897n = fVar.f6897n;
        this.f6898o = fVar.f6898o;
        this.f6899p = fVar.f6899p;
        this.f6900q = fVar.f6900q;
        this.f6901r = fVar.f6901r;
        this.f6902s = fVar.f6902s;
        this.f6903t = fVar.f6903t;
        this.f6904u = fVar.f6904u;
        this.f6905v = fVar.f6905v;
        this.f6906w = fVar.f6906w;
        this.f6907x = fVar.f6907x;
        this.f6908y = fVar.f6908y;
        this.f6909z = fVar.f6909z;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f6899p)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f6900q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f6901r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f6903t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f6904u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f6905v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f6906w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f6902s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f6907x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f6908y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f6909z)) {
            hashSet.add("translationZ");
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
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyCycle));
    }
}
