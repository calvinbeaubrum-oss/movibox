package x2;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends androidx.constraintlayout.core.motion.utils.i {

    /* JADX INFO: compiled from: source.java */
    public static class a extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setAlpha(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f79846f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f79847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f79848h;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f79846f = str.split(",")[1];
            this.f79847g = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.i
        public void c(int i11, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.i
        public void e(int i11) {
            int size = this.f79847g.size();
            int iH = this.f79847g.valueAt(0).h();
            double[] dArr = new double[size];
            this.f79848h = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iH);
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = this.f79847g.keyAt(i12);
                ConstraintAttribute constraintAttributeValueAt = this.f79847g.valueAt(i12);
                dArr[i12] = ((double) iKeyAt) * 0.01d;
                constraintAttributeValueAt.f(this.f79848h);
                int i13 = 0;
                while (true) {
                    float[] fArr = this.f79848h;
                    if (i13 < fArr.length) {
                        dArr2[i12][i13] = fArr[i13];
                        i13++;
                    }
                }
            }
            this.f6470a = androidx.constraintlayout.core.motion.utils.b.a(i11, dArr, dArr2);
        }

        @Override // x2.d
        public void h(View view, float f11) {
            this.f6470a.e(f11, this.f79848h);
            x2.a.b(this.f79847g.valueAt(0), view, this.f79848h);
        }

        public void i(int i11, ConstraintAttribute constraintAttribute) {
            this.f79847g.append(i11, constraintAttribute);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setElevation(a(f11));
        }
    }

    /* JADX INFO: renamed from: x2.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0898d extends d {
        @Override // x2.d
        public void h(View view, float f11) {
        }

        public void i(View view, float f11, double d11, double d12) {
            view.setRotation(a(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setPivotX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setPivotY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f79849f = false;

        @Override // x2.d
        public void h(View view, float f11) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f11));
                return;
            }
            if (this.f79849f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f79849f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f11)));
                } catch (IllegalAccessException e11) {
                    Log.e("ViewSpline", "unable to setProgress", e11);
                } catch (InvocationTargetException e12) {
                    Log.e("ViewSpline", "unable to setProgress", e12);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setRotation(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setRotationX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setRotationY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setScaleX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setScaleY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setTranslationX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setTranslationY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o extends d {
        @Override // x2.d
        public void h(View view, float f11) {
            view.setTranslationZ(a(f11));
        }
    }

    public static d f(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static d g(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    b11 = Ascii.SI;
                }
                break;
        }
        switch (b11) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case 8:
                return new a();
            case 9:
                return new e();
            case 10:
                return new f();
            case 11:
                return new h();
            case 12:
                return new c();
            case 13:
                return new C0898d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f11);
}
