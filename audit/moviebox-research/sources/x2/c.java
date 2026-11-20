package x2;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends KeyCycleOscillator {

    /* JADX INFO: compiled from: source.java */
    public static class a extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setAlpha(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f79843h = new float[1];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ConstraintAttribute f79844i;

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void c(Object obj) {
            this.f79844i = (ConstraintAttribute) obj;
        }

        @Override // x2.c
        public void j(View view, float f11) {
            this.f79843h[0] = a(f11);
            x2.a.b(this.f79844i, view, this.f79843h);
        }
    }

    /* JADX INFO: renamed from: x2.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0897c extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setElevation(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends c {
        @Override // x2.c
        public void j(View view, float f11) {
        }

        public void k(View view, float f11, double d11, double d12) {
            view.setRotation(a(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f79845h = false;

        @Override // x2.c
        public void j(View view, float f11) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f11));
                return;
            }
            if (this.f79845h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f79845h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f11)));
                } catch (IllegalAccessException e11) {
                    Log.e("ViewOscillator", "unable to setProgress", e11);
                } catch (InvocationTargetException e12) {
                    Log.e("ViewOscillator", "unable to setProgress", e12);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setRotation(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setRotationX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setRotationY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setScaleX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setScaleY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setTranslationX(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setTranslationY(a(f11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m extends c {
        @Override // x2.c
        public void j(View view, float f11) {
            view.setTranslationZ(a(f11));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static c i(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    b11 = 9;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b11 = 10;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b11 = Ascii.VT;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b11 = Ascii.FF;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b11 = Ascii.CR;
                }
                break;
        }
        switch (b11) {
            case 0:
                return new g();
            case 1:
                return new h();
            case 2:
                return new k();
            case 3:
                return new l();
            case 4:
                return new m();
            case 5:
                return new e();
            case 6:
                return new i();
            case 7:
                return new j();
            case 8:
                return new a();
            case 9:
                return new f();
            case 10:
                return new C0897c();
            case 11:
                return new d();
            case 12:
                return new a();
            case 13:
                return new a();
            default:
                return null;
        }
    }

    public abstract void j(View view, float f11);
}
