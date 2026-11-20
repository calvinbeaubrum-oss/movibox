package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements Comparable<l> {
    public static String[] E = {RequestParameters.POSITION, "x", "y", "width", "height", "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6969c;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.c f6982q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6984s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6985t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6986u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6987v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6988w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6967a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6968b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6970d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6971f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6972g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6973h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6974i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6975j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6976k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6977l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6978m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6979n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6980o = 0.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6981p = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6983r = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f6989x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6990y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6991z = -1;
    public LinkedHashMap<String, ConstraintAttribute> A = new LinkedHashMap<>();
    public int B = 0;
    public double[] C = new double[18];
    public double[] D = new double[18];

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap<String, x2.d> map, int i11) {
        for (String str : map.keySet()) {
            x2.d dVar = map.get(str);
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        b11 = 8;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        b11 = 9;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        b11 = 10;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b11 = Ascii.VT;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b11 = Ascii.FF;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b11 = Ascii.CR;
                    }
                    break;
            }
            switch (b11) {
                case 0:
                    dVar.c(i11, Float.isNaN(this.f6973h) ? 0.0f : this.f6973h);
                    break;
                case 1:
                    dVar.c(i11, Float.isNaN(this.f6974i) ? 0.0f : this.f6974i);
                    break;
                case 2:
                    dVar.c(i11, Float.isNaN(this.f6979n) ? 0.0f : this.f6979n);
                    break;
                case 3:
                    dVar.c(i11, Float.isNaN(this.f6980o) ? 0.0f : this.f6980o);
                    break;
                case 4:
                    dVar.c(i11, Float.isNaN(this.f6981p) ? 0.0f : this.f6981p);
                    break;
                case 5:
                    dVar.c(i11, Float.isNaN(this.f6990y) ? 0.0f : this.f6990y);
                    break;
                case 6:
                    dVar.c(i11, Float.isNaN(this.f6975j) ? 1.0f : this.f6975j);
                    break;
                case 7:
                    dVar.c(i11, Float.isNaN(this.f6976k) ? 1.0f : this.f6976k);
                    break;
                case 8:
                    dVar.c(i11, Float.isNaN(this.f6977l) ? 0.0f : this.f6977l);
                    break;
                case 9:
                    dVar.c(i11, Float.isNaN(this.f6978m) ? 0.0f : this.f6978m);
                    break;
                case 10:
                    dVar.c(i11, Float.isNaN(this.f6972g) ? 0.0f : this.f6972g);
                    break;
                case 11:
                    dVar.c(i11, Float.isNaN(this.f6971f) ? 0.0f : this.f6971f);
                    break;
                case 12:
                    dVar.c(i11, Float.isNaN(this.f6989x) ? 0.0f : this.f6989x);
                    break;
                case 13:
                    dVar.c(i11, Float.isNaN(this.f6967a) ? 1.0f : this.f6967a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.A.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.A.get(str2);
                            if (dVar instanceof x2.d.b) {
                                ((x2.d.b) dVar).i(i11, constraintAttribute);
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i11 + ", value" + constraintAttribute.e() + dVar);
                            }
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void b(View view) {
        this.f6969c = view.getVisibility();
        this.f6967a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f6970d = false;
        this.f6971f = view.getElevation();
        this.f6972g = view.getRotation();
        this.f6973h = view.getRotationX();
        this.f6974i = view.getRotationY();
        this.f6975j = view.getScaleX();
        this.f6976k = view.getScaleY();
        this.f6977l = view.getPivotX();
        this.f6978m = view.getPivotY();
        this.f6979n = view.getTranslationX();
        this.f6980o = view.getTranslationY();
        this.f6981p = view.getTranslationZ();
    }

    public void c(androidx.constraintlayout.widget.b.a aVar) {
        androidx.constraintlayout.widget.b.d dVar = aVar.f7379c;
        int i11 = dVar.f7458c;
        this.f6968b = i11;
        int i12 = dVar.f7457b;
        this.f6969c = i12;
        this.f6967a = (i12 == 0 || i11 != 0) ? dVar.f7459d : 0.0f;
        androidx.constraintlayout.widget.b.e eVar = aVar.f7382f;
        this.f6970d = eVar.f7474m;
        this.f6971f = eVar.f7475n;
        this.f6972g = eVar.f7463b;
        this.f6973h = eVar.f7464c;
        this.f6974i = eVar.f7465d;
        this.f6975j = eVar.f7466e;
        this.f6976k = eVar.f7467f;
        this.f6977l = eVar.f7468g;
        this.f6978m = eVar.f7469h;
        this.f6979n = eVar.f7471j;
        this.f6980o = eVar.f7472k;
        this.f6981p = eVar.f7473l;
        this.f6982q = androidx.constraintlayout.core.motion.utils.c.c(aVar.f7380d.f7445d);
        androidx.constraintlayout.widget.b.c cVar = aVar.f7380d;
        this.f6989x = cVar.f7450i;
        this.f6983r = cVar.f7447f;
        this.f6991z = cVar.f7443b;
        this.f6990y = aVar.f7379c.f7460e;
        for (String str : aVar.f7383g.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f7383g.get(str);
            if (constraintAttribute.g()) {
                this.A.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return Float.compare(this.f6984s, lVar.f6984s);
    }

    public final boolean e(float f11, float f12) {
        if (Float.isNaN(f11) || Float.isNaN(f12)) {
            return Float.isNaN(f11) != Float.isNaN(f12);
        }
        return Math.abs(f11 - f12) > 1.0E-6f;
    }

    public void h(l lVar, HashSet<String> hashSet) {
        if (e(this.f6967a, lVar.f6967a)) {
            hashSet.add("alpha");
        }
        if (e(this.f6971f, lVar.f6971f)) {
            hashSet.add("elevation");
        }
        int i11 = this.f6969c;
        int i12 = lVar.f6969c;
        if (i11 != i12 && this.f6968b == 0 && (i11 == 0 || i12 == 0)) {
            hashSet.add("alpha");
        }
        if (e(this.f6972g, lVar.f6972g)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f6989x) || !Float.isNaN(lVar.f6989x)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f6990y) || !Float.isNaN(lVar.f6990y)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (e(this.f6973h, lVar.f6973h)) {
            hashSet.add("rotationX");
        }
        if (e(this.f6974i, lVar.f6974i)) {
            hashSet.add("rotationY");
        }
        if (e(this.f6977l, lVar.f6977l)) {
            hashSet.add("transformPivotX");
        }
        if (e(this.f6978m, lVar.f6978m)) {
            hashSet.add("transformPivotY");
        }
        if (e(this.f6975j, lVar.f6975j)) {
            hashSet.add("scaleX");
        }
        if (e(this.f6976k, lVar.f6976k)) {
            hashSet.add("scaleY");
        }
        if (e(this.f6979n, lVar.f6979n)) {
            hashSet.add("translationX");
        }
        if (e(this.f6980o, lVar.f6980o)) {
            hashSet.add("translationY");
        }
        if (e(this.f6981p, lVar.f6981p)) {
            hashSet.add("translationZ");
        }
    }

    public void i(float f11, float f12, float f13, float f14) {
        this.f6985t = f11;
        this.f6986u = f12;
        this.f6987v = f13;
        this.f6988w = f14;
    }

    public void j(Rect rect, View view, int i11, float f11) {
        i(rect.left, rect.top, rect.width(), rect.height());
        b(view);
        this.f6977l = Float.NaN;
        this.f6978m = Float.NaN;
        if (i11 == 1) {
            this.f6972g = f11 - 90.0f;
        } else {
            if (i11 != 2) {
                return;
            }
            this.f6972g = f11 + 90.0f;
        }
    }

    public void k(Rect rect, androidx.constraintlayout.widget.b bVar, int i11, int i12) {
        i(rect.left, rect.top, rect.width(), rect.height());
        c(bVar.A(i12));
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return;
                    }
                }
            }
            float f11 = this.f6972g + 90.0f;
            this.f6972g = f11;
            if (f11 > 180.0f) {
                this.f6972g = f11 - 360.0f;
                return;
            }
            return;
        }
        this.f6972g -= 90.0f;
    }

    public void l(View view) {
        i(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }
}
