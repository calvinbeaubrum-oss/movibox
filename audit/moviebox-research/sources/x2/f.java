package x2;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.n;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends n {

    /* JADX INFO: compiled from: source.java */
    public static class a extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setAlpha(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f79855l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f79856m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public SparseArray<float[]> f79857n = new SparseArray<>();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float[] f79858o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float[] f79859p;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f79855l = str.split(",")[1];
            this.f79856m = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.n
        public void b(int i11, float f11, float f12, int i12, float f13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.n
        public void e(int i11) {
            int size = this.f79856m.size();
            int iH = this.f79856m.valueAt(0).h();
            double[] dArr = new double[size];
            int i12 = iH + 2;
            this.f79858o = new float[i12];
            this.f79859p = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i12);
            for (int i13 = 0; i13 < size; i13++) {
                int iKeyAt = this.f79856m.keyAt(i13);
                ConstraintAttribute constraintAttributeValueAt = this.f79856m.valueAt(i13);
                float[] fArrValueAt = this.f79857n.valueAt(i13);
                dArr[i13] = ((double) iKeyAt) * 0.01d;
                constraintAttributeValueAt.f(this.f79858o);
                int i14 = 0;
                while (true) {
                    float[] fArr = this.f79858o;
                    if (i14 < fArr.length) {
                        dArr2[i13][i14] = fArr[i14];
                        i14++;
                    }
                }
                double[] dArr3 = dArr2[i13];
                dArr3[iH] = fArrValueAt[0];
                dArr3[iH + 1] = fArrValueAt[1];
            }
            this.f6503a = androidx.constraintlayout.core.motion.utils.b.a(i11, dArr, dArr2);
        }

        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            this.f6503a.e(f11, this.f79858o);
            float[] fArr = this.f79858o;
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            long j12 = j11 - this.f6511i;
            if (Float.isNaN(this.f6512j)) {
                float fA = dVar.a(view, this.f79855l, 0);
                this.f6512j = fA;
                if (Float.isNaN(fA)) {
                    this.f6512j = 0.0f;
                }
            }
            float f14 = (float) ((((double) this.f6512j) + ((j12 * 1.0E-9d) * ((double) f12))) % 1.0d);
            this.f6512j = f14;
            this.f6511i = j11;
            float fA2 = a(f14);
            this.f6510h = false;
            int i11 = 0;
            while (true) {
                float[] fArr2 = this.f79859p;
                if (i11 >= fArr2.length) {
                    break;
                }
                boolean z11 = this.f6510h;
                float f15 = this.f79858o[i11];
                this.f6510h = z11 | (((double) f15) != 0.0d);
                fArr2[i11] = (f15 * fA2) + f13;
                i11++;
            }
            x2.a.b(this.f79856m.valueAt(0), view, this.f79859p);
            if (f12 != 0.0f) {
                this.f6510h = true;
            }
            return this.f6510h;
        }

        public void j(int i11, ConstraintAttribute constraintAttribute, float f11, int i12, float f12) {
            this.f79856m.append(i11, constraintAttribute);
            this.f79857n.append(i11, new float[]{f11, f12});
            this.f6504b = Math.max(this.f6504b, i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setElevation(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            return this.f6510h;
        }

        public boolean j(View view, androidx.constraintlayout.core.motion.utils.d dVar, float f11, long j11, double d11, double d12) {
            view.setRotation(f(f11, j11, view, dVar) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f79860l = false;

        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(f(f11, j11, view, dVar));
            } else {
                if (this.f79860l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f79860l = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(f(f11, j11, view, dVar)));
                    } catch (IllegalAccessException e11) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e12);
                    }
                }
            }
            return this.f6510h;
        }
    }

    /* JADX INFO: renamed from: x2.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0899f extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setRotation(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setRotationX(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setRotationY(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setScaleX(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setScaleY(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setTranslationX(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setTranslationY(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m extends f {
        @Override // x2.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setTranslationZ(f(f11, j11, view, dVar));
            return this.f6510h;
        }
    }

    public static f g(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static f h(String str, long j11) {
        f gVar;
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
        }
        switch (b11) {
            case 0:
                gVar = new g();
                break;
            case 1:
                gVar = new h();
                break;
            case 2:
                gVar = new k();
                break;
            case 3:
                gVar = new l();
                break;
            case 4:
                gVar = new m();
                break;
            case 5:
                gVar = new e();
                break;
            case 6:
                gVar = new i();
                break;
            case 7:
                gVar = new j();
                break;
            case 8:
                gVar = new C0899f();
                break;
            case 9:
                gVar = new c();
                break;
            case 10:
                gVar = new d();
                break;
            case 11:
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.c(j11);
        return gVar;
    }

    public float f(float f11, long j11, View view, androidx.constraintlayout.core.motion.utils.d dVar) {
        this.f6503a.e(f11, this.f6509g);
        float[] fArr = this.f6509g;
        float f12 = fArr[1];
        if (f12 == 0.0f) {
            this.f6510h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f6512j)) {
            float fA = dVar.a(view, this.f6508f, 0);
            this.f6512j = fA;
            if (Float.isNaN(fA)) {
                this.f6512j = 0.0f;
            }
        }
        float f13 = (float) ((((double) this.f6512j) + (((j11 - this.f6511i) * 1.0E-9d) * ((double) f12))) % 1.0d);
        this.f6512j = f13;
        dVar.b(view, this.f6508f, 0, f13);
        this.f6511i = j11;
        float f14 = this.f6509g[0];
        float fA2 = (a(this.f6512j) * f14) + this.f6509g[2];
        this.f6510h = (f14 == 0.0f && f12 == 0.0f) ? false : true;
        return fA2;
    }

    public abstract boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar);
}
