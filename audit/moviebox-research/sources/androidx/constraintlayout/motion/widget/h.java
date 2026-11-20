package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6913h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6914i = d.f6866f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6915j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6916k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6917l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6918m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6919n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6920o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6921p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6922q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6923r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6924s = Float.NaN;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f6925a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6925a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            f6925a.append(R$styleable.KeyPosition_framePosition, 2);
            f6925a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f6925a.append(R$styleable.KeyPosition_curveFit, 4);
            f6925a.append(R$styleable.KeyPosition_drawPath, 5);
            f6925a.append(R$styleable.KeyPosition_percentX, 6);
            f6925a.append(R$styleable.KeyPosition_percentY, 7);
            f6925a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f6925a.append(R$styleable.KeyPosition_sizePercent, 8);
            f6925a.append(R$styleable.KeyPosition_percentWidth, 11);
            f6925a.append(R$styleable.KeyPosition_percentHeight, 12);
            f6925a.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void b(h hVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f6925a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, hVar.f6868b);
                            hVar.f6868b = resourceId;
                            if (resourceId == -1) {
                                hVar.f6869c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            hVar.f6869c = typedArray.getString(index);
                        } else {
                            hVar.f6868b = typedArray.getResourceId(index, hVar.f6868b);
                        }
                        break;
                    case 2:
                        hVar.f6867a = typedArray.getInt(index, hVar.f6867a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            hVar.f6913h = typedArray.getString(index);
                        } else {
                            hVar.f6913h = androidx.constraintlayout.core.motion.utils.c.f6441c[typedArray.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        hVar.f6926g = typedArray.getInteger(index, hVar.f6926g);
                        break;
                    case 5:
                        hVar.f6915j = typedArray.getInt(index, hVar.f6915j);
                        break;
                    case 6:
                        hVar.f6918m = typedArray.getFloat(index, hVar.f6918m);
                        break;
                    case 7:
                        hVar.f6919n = typedArray.getFloat(index, hVar.f6919n);
                        break;
                    case 8:
                        float f11 = typedArray.getFloat(index, hVar.f6917l);
                        hVar.f6916k = f11;
                        hVar.f6917l = f11;
                        break;
                    case 9:
                        hVar.f6922q = typedArray.getInt(index, hVar.f6922q);
                        break;
                    case 10:
                        hVar.f6914i = typedArray.getInt(index, hVar.f6914i);
                        break;
                    case 11:
                        hVar.f6916k = typedArray.getFloat(index, hVar.f6916k);
                        break;
                    case 12:
                        hVar.f6917l = typedArray.getFloat(index, hVar.f6917l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f6925a.get(index));
                        break;
                }
            }
            if (hVar.f6867a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public h() {
        this.f6870d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, x2.d> map) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* JADX INFO: renamed from: b */
    public d clone() {
        return new h().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        h hVar = (h) dVar;
        this.f6913h = hVar.f6913h;
        this.f6914i = hVar.f6914i;
        this.f6915j = hVar.f6915j;
        this.f6916k = hVar.f6916k;
        this.f6917l = Float.NaN;
        this.f6918m = hVar.f6918m;
        this.f6919n = hVar.f6919n;
        this.f6920o = hVar.f6920o;
        this.f6921p = hVar.f6921p;
        this.f6923r = hVar.f6923r;
        this.f6924s = hVar.f6924s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition));
    }

    public void m(int i11) {
        this.f6922q = i11;
    }

    public void n(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.f6913h = obj.toString();
                break;
            case "percentWidth":
                this.f6916k = k(obj);
                break;
            case "percentHeight":
                this.f6917l = k(obj);
                break;
            case "drawPath":
                this.f6915j = l(obj);
                break;
            case "sizePercent":
                float fK = k(obj);
                this.f6916k = fK;
                this.f6917l = fK;
                break;
            case "percentX":
                this.f6918m = k(obj);
                break;
            case "percentY":
                this.f6919n = k(obj);
                break;
        }
    }
}
