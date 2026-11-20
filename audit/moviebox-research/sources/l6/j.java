package l6;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b3.k;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends l6.i {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final PorterDuff.Mode f70002l = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f70003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f70004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorFilter f70005d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f70006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f70007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable.ConstantState f70008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f70009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f70010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f70011k;

    /* JADX INFO: compiled from: source.java */
    public static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f70038b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f70037a = c3.e.d(string2);
            }
            this.f70039c = k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // l6.j.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.j(xmlPullParser, "pathData")) {
                TypedArray typedArrayK = k.k(resources, theme, attributeSet, l6.a.f69973d);
                f(typedArrayK, xmlPullParser);
                typedArrayK.recycle();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f70012e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b3.d f70013f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f70014g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b3.d f70015h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f70016i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f70017j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f70018k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f70019l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f70020m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Paint.Cap f70021n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Paint.Join f70022o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f70023p;

        public c() {
            this.f70014g = 0.0f;
            this.f70016i = 1.0f;
            this.f70017j = 1.0f;
            this.f70018k = 0.0f;
            this.f70019l = 1.0f;
            this.f70020m = 0.0f;
            this.f70021n = Paint.Cap.BUTT;
            this.f70022o = Paint.Join.MITER;
            this.f70023p = 4.0f;
        }

        public c(c cVar) {
            super(cVar);
            this.f70014g = 0.0f;
            this.f70016i = 1.0f;
            this.f70017j = 1.0f;
            this.f70018k = 0.0f;
            this.f70019l = 1.0f;
            this.f70020m = 0.0f;
            this.f70021n = Paint.Cap.BUTT;
            this.f70022o = Paint.Join.MITER;
            this.f70023p = 4.0f;
            this.f70012e = cVar.f70012e;
            this.f70013f = cVar.f70013f;
            this.f70014g = cVar.f70014g;
            this.f70016i = cVar.f70016i;
            this.f70015h = cVar.f70015h;
            this.f70039c = cVar.f70039c;
            this.f70017j = cVar.f70017j;
            this.f70018k = cVar.f70018k;
            this.f70019l = cVar.f70019l;
            this.f70020m = cVar.f70020m;
            this.f70021n = cVar.f70021n;
            this.f70022o = cVar.f70022o;
            this.f70023p = cVar.f70023p;
        }

        @Override // l6.j.e
        public boolean a() {
            return this.f70015h.i() || this.f70013f.i();
        }

        @Override // l6.j.e
        public boolean b(int[] iArr) {
            return this.f70013f.j(iArr) | this.f70015h.j(iArr);
        }

        public final Paint.Cap e(int i11, Paint.Cap cap) {
            if (i11 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i11 != 1) {
                return i11 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        public final Paint.Join f(int i11, Paint.Join join) {
            if (i11 == 0) {
                return Paint.Join.MITER;
            }
            if (i11 != 1) {
                return i11 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = k.k(resources, theme, attributeSet, l6.a.f69972c);
            h(typedArrayK, xmlPullParser, theme);
            typedArrayK.recycle();
        }

        public float getFillAlpha() {
            return this.f70017j;
        }

        public int getFillColor() {
            return this.f70015h.e();
        }

        public float getStrokeAlpha() {
            return this.f70016i;
        }

        public int getStrokeColor() {
            return this.f70013f.e();
        }

        public float getStrokeWidth() {
            return this.f70014g;
        }

        public float getTrimPathEnd() {
            return this.f70019l;
        }

        public float getTrimPathOffset() {
            return this.f70020m;
        }

        public float getTrimPathStart() {
            return this.f70018k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f70012e = null;
            if (k.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f70038b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f70037a = c3.e.d(string2);
                }
                this.f70015h = k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f70017j = k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f70017j);
                this.f70021n = e(k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f70021n);
                this.f70022o = f(k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f70022o);
                this.f70023p = k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f70023p);
                this.f70013f = k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f70016i = k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f70016i);
                this.f70014g = k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f70014g);
                this.f70019l = k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f70019l);
                this.f70020m = k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f70020m);
                this.f70018k = k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f70018k);
                this.f70039c = k.g(typedArray, xmlPullParser, "fillType", 13, this.f70039c);
            }
        }

        public void setFillAlpha(float f11) {
            this.f70017j = f11;
        }

        public void setFillColor(int i11) {
            this.f70015h.k(i11);
        }

        public void setStrokeAlpha(float f11) {
            this.f70016i = f11;
        }

        public void setStrokeColor(int i11) {
            this.f70013f.k(i11);
        }

        public void setStrokeWidth(float f11) {
            this.f70014g = f11;
        }

        public void setTrimPathEnd(float f11) {
            this.f70019l = f11;
        }

        public void setTrimPathOffset(float f11) {
            this.f70020m = f11;
        }

        public void setTrimPathStart(float f11) {
            this.f70018k = f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f70024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f70025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f70026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f70027d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f70028e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f70029f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f70030g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f70031h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f70032i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Matrix f70033j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f70034k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int[] f70035l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f70036m;

        public d() {
            super();
            this.f70024a = new Matrix();
            this.f70025b = new ArrayList<>();
            this.f70026c = 0.0f;
            this.f70027d = 0.0f;
            this.f70028e = 0.0f;
            this.f70029f = 1.0f;
            this.f70030g = 1.0f;
            this.f70031h = 0.0f;
            this.f70032i = 0.0f;
            this.f70033j = new Matrix();
            this.f70036m = null;
        }

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            f bVar;
            super();
            this.f70024a = new Matrix();
            this.f70025b = new ArrayList<>();
            this.f70026c = 0.0f;
            this.f70027d = 0.0f;
            this.f70028e = 0.0f;
            this.f70029f = 1.0f;
            this.f70030g = 1.0f;
            this.f70031h = 0.0f;
            this.f70032i = 0.0f;
            Matrix matrix = new Matrix();
            this.f70033j = matrix;
            this.f70036m = null;
            this.f70026c = dVar.f70026c;
            this.f70027d = dVar.f70027d;
            this.f70028e = dVar.f70028e;
            this.f70029f = dVar.f70029f;
            this.f70030g = dVar.f70030g;
            this.f70031h = dVar.f70031h;
            this.f70032i = dVar.f70032i;
            this.f70035l = dVar.f70035l;
            String str = dVar.f70036m;
            this.f70036m = str;
            this.f70034k = dVar.f70034k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f70033j);
            ArrayList<e> arrayList = dVar.f70025b;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                e eVar = arrayList.get(i11);
                if (eVar instanceof d) {
                    this.f70025b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f70025b.add(bVar);
                    String str2 = bVar.f70038b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        @Override // l6.j.e
        public boolean a() {
            for (int i11 = 0; i11 < this.f70025b.size(); i11++) {
                if (this.f70025b.get(i11).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // l6.j.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i11 = 0; i11 < this.f70025b.size(); i11++) {
                zB |= this.f70025b.get(i11).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = k.k(resources, theme, attributeSet, l6.a.f69971b);
            e(typedArrayK, xmlPullParser);
            typedArrayK.recycle();
        }

        public final void d() {
            this.f70033j.reset();
            this.f70033j.postTranslate(-this.f70027d, -this.f70028e);
            this.f70033j.postScale(this.f70029f, this.f70030g);
            this.f70033j.postRotate(this.f70026c, 0.0f, 0.0f);
            this.f70033j.postTranslate(this.f70031h + this.f70027d, this.f70032i + this.f70028e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f70035l = null;
            this.f70026c = k.f(typedArray, xmlPullParser, "rotation", 5, this.f70026c);
            this.f70027d = typedArray.getFloat(1, this.f70027d);
            this.f70028e = typedArray.getFloat(2, this.f70028e);
            this.f70029f = k.f(typedArray, xmlPullParser, "scaleX", 3, this.f70029f);
            this.f70030g = k.f(typedArray, xmlPullParser, "scaleY", 4, this.f70030g);
            this.f70031h = k.f(typedArray, xmlPullParser, "translateX", 6, this.f70031h);
            this.f70032i = k.f(typedArray, xmlPullParser, "translateY", 7, this.f70032i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f70036m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f70036m;
        }

        public Matrix getLocalMatrix() {
            return this.f70033j;
        }

        public float getPivotX() {
            return this.f70027d;
        }

        public float getPivotY() {
            return this.f70028e;
        }

        public float getRotation() {
            return this.f70026c;
        }

        public float getScaleX() {
            return this.f70029f;
        }

        public float getScaleY() {
            return this.f70030g;
        }

        public float getTranslateX() {
            return this.f70031h;
        }

        public float getTranslateY() {
            return this.f70032i;
        }

        public void setPivotX(float f11) {
            if (f11 != this.f70027d) {
                this.f70027d = f11;
                d();
            }
        }

        public void setPivotY(float f11) {
            if (f11 != this.f70028e) {
                this.f70028e = f11;
                d();
            }
        }

        public void setRotation(float f11) {
            if (f11 != this.f70026c) {
                this.f70026c = f11;
                d();
            }
        }

        public void setScaleX(float f11) {
            if (f11 != this.f70029f) {
                this.f70029f = f11;
                d();
            }
        }

        public void setScaleY(float f11) {
            if (f11 != this.f70030g) {
                this.f70030g = f11;
                d();
            }
        }

        public void setTranslateX(float f11) {
            if (f11 != this.f70031h) {
                this.f70031h = f11;
                d();
            }
        }

        public void setTranslateY(float f11) {
            if (f11 != this.f70032i) {
                this.f70032i = f11;
                d();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c3.e.b[] f70037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f70038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f70039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f70040d;

        public f() {
            super();
            this.f70037a = null;
            this.f70039c = 0;
        }

        public f(f fVar) {
            super();
            this.f70037a = null;
            this.f70039c = 0;
            this.f70038b = fVar.f70038b;
            this.f70040d = fVar.f70040d;
            this.f70037a = c3.e.f(fVar.f70037a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c3.e.b[] bVarArr = this.f70037a;
            if (bVarArr != null) {
                c3.e.b.i(bVarArr, path);
            }
        }

        public c3.e.b[] getPathData() {
            return this.f70037a;
        }

        public String getPathName() {
            return this.f70038b;
        }

        public void setPathData(c3.e.b[] bVarArr) {
            if (c3.e.b(this.f70037a, bVarArr)) {
                c3.e.k(this.f70037a, bVarArr);
            } else {
                this.f70037a = c3.e.f(bVarArr);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Matrix f70041q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f70042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f70043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f70044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f70045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f70046e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PathMeasure f70047f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f70048g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final d f70049h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f70050i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f70051j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f70052k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f70053l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f70054m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f70055n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Boolean f70056o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final androidx.collection.a<String, Object> f70057p;

        public g() {
            this.f70044c = new Matrix();
            this.f70050i = 0.0f;
            this.f70051j = 0.0f;
            this.f70052k = 0.0f;
            this.f70053l = 0.0f;
            this.f70054m = 255;
            this.f70055n = null;
            this.f70056o = null;
            this.f70057p = new androidx.collection.a<>();
            this.f70049h = new d();
            this.f70042a = new Path();
            this.f70043b = new Path();
        }

        public g(g gVar) {
            this.f70044c = new Matrix();
            this.f70050i = 0.0f;
            this.f70051j = 0.0f;
            this.f70052k = 0.0f;
            this.f70053l = 0.0f;
            this.f70054m = 255;
            this.f70055n = null;
            this.f70056o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f70057p = aVar;
            this.f70049h = new d(gVar.f70049h, aVar);
            this.f70042a = new Path(gVar.f70042a);
            this.f70043b = new Path(gVar.f70043b);
            this.f70050i = gVar.f70050i;
            this.f70051j = gVar.f70051j;
            this.f70052k = gVar.f70052k;
            this.f70053l = gVar.f70053l;
            this.f70048g = gVar.f70048g;
            this.f70054m = gVar.f70054m;
            this.f70055n = gVar.f70055n;
            String str = gVar.f70055n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f70056o = gVar.f70056o;
        }

        public static float a(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        public void b(Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            c(this.f70049h, f70041q, canvas, i11, i12, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            dVar.f70024a.set(matrix);
            dVar.f70024a.preConcat(dVar.f70033j);
            canvas.save();
            for (int i13 = 0; i13 < dVar.f70025b.size(); i13++) {
                e eVar = dVar.f70025b.get(i13);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f70024a, canvas, i11, i12, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i11, i12, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(d dVar, f fVar, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            float f11 = i11 / this.f70052k;
            float f12 = i12 / this.f70053l;
            float fMin = Math.min(f11, f12);
            Matrix matrix = dVar.f70024a;
            this.f70044c.set(matrix);
            this.f70044c.postScale(f11, f12);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.d(this.f70042a);
            Path path = this.f70042a;
            this.f70043b.reset();
            if (fVar.c()) {
                this.f70043b.setFillType(fVar.f70039c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f70043b.addPath(path, this.f70044c);
                canvas.clipPath(this.f70043b);
                return;
            }
            c cVar = (c) fVar;
            float f13 = cVar.f70018k;
            if (f13 != 0.0f || cVar.f70019l != 1.0f) {
                float f14 = cVar.f70020m;
                float f15 = (f13 + f14) % 1.0f;
                float f16 = (cVar.f70019l + f14) % 1.0f;
                if (this.f70047f == null) {
                    this.f70047f = new PathMeasure();
                }
                this.f70047f.setPath(this.f70042a, false);
                float length = this.f70047f.getLength();
                float f17 = f15 * length;
                float f18 = f16 * length;
                path.reset();
                if (f17 > f18) {
                    this.f70047f.getSegment(f17, length, path, true);
                    this.f70047f.getSegment(0.0f, f18, path, true);
                } else {
                    this.f70047f.getSegment(f17, f18, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f70043b.addPath(path, this.f70044c);
            if (cVar.f70015h.l()) {
                b3.d dVar2 = cVar.f70015h;
                if (this.f70046e == null) {
                    Paint paint = new Paint(1);
                    this.f70046e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f70046e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f70044c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f70017j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(j.a(dVar2.e(), cVar.f70017j));
                }
                paint2.setColorFilter(colorFilter);
                this.f70043b.setFillType(cVar.f70039c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f70043b, paint2);
            }
            if (cVar.f70013f.l()) {
                b3.d dVar3 = cVar.f70013f;
                if (this.f70045d == null) {
                    Paint paint3 = new Paint(1);
                    this.f70045d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f70045d;
                Paint.Join join = cVar.f70022o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f70021n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f70023p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f70044c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f70016i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(j.a(dVar3.e(), cVar.f70016i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f70014g * fMin * fE);
                canvas.drawPath(this.f70043b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f70056o == null) {
                this.f70056o = Boolean.valueOf(this.f70049h.a());
            }
            return this.f70056o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f70049h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f70054m;
        }

        public void setAlpha(float f11) {
            setRootAlpha((int) (f11 * 255.0f));
        }

        public void setRootAlpha(int i11) {
            this.f70054m = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f70058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f70059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f70060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f70061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f70062e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f70063f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f70064g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f70065h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f70066i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f70067j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f70068k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Paint f70069l;

        public h() {
            this.f70060c = null;
            this.f70061d = j.f70002l;
            this.f70059b = new g();
        }

        public h(h hVar) {
            this.f70060c = null;
            this.f70061d = j.f70002l;
            if (hVar != null) {
                this.f70058a = hVar.f70058a;
                g gVar = new g(hVar.f70059b);
                this.f70059b = gVar;
                if (hVar.f70059b.f70046e != null) {
                    gVar.f70046e = new Paint(hVar.f70059b.f70046e);
                }
                if (hVar.f70059b.f70045d != null) {
                    this.f70059b.f70045d = new Paint(hVar.f70059b.f70045d);
                }
                this.f70060c = hVar.f70060c;
                this.f70061d = hVar.f70061d;
                this.f70062e = hVar.f70062e;
            }
        }

        public boolean a(int i11, int i12) {
            return i11 == this.f70063f.getWidth() && i12 == this.f70063f.getHeight();
        }

        public boolean b() {
            return !this.f70068k && this.f70064g == this.f70060c && this.f70065h == this.f70061d && this.f70067j == this.f70062e && this.f70066i == this.f70059b.getRootAlpha();
        }

        public void c(int i11, int i12) {
            if (this.f70063f == null || !a(i11, i12)) {
                this.f70063f = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
                this.f70068k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f70063f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f70069l == null) {
                Paint paint = new Paint();
                this.f70069l = paint;
                paint.setFilterBitmap(true);
            }
            this.f70069l.setAlpha(this.f70059b.getRootAlpha());
            this.f70069l.setColorFilter(colorFilter);
            return this.f70069l;
        }

        public boolean f() {
            return this.f70059b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f70059b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f70058a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f70059b.g(iArr);
            this.f70068k |= zG;
            return zG;
        }

        public void i() {
            this.f70064g = this.f70060c;
            this.f70065h = this.f70061d;
            this.f70066i = this.f70059b.getRootAlpha();
            this.f70067j = this.f70062e;
            this.f70068k = false;
        }

        public void j(int i11, int i12) {
            this.f70063f.eraseColor(0);
            this.f70059b.b(new Canvas(this.f70063f), i11, i12, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new j(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new j(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f70070a;

        public i(Drawable.ConstantState constantState) {
            this.f70070a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f70070a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f70070a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            j jVar = new j();
            jVar.f70001a = (VectorDrawable) this.f70070a.newDrawable();
            return jVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            j jVar = new j();
            jVar.f70001a = (VectorDrawable) this.f70070a.newDrawable(resources);
            return jVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            j jVar = new j();
            jVar.f70001a = (VectorDrawable) this.f70070a.newDrawable(resources, theme);
            return jVar;
        }
    }

    public j() {
        this.f70007g = true;
        this.f70009i = new float[9];
        this.f70010j = new Matrix();
        this.f70011k = new Rect();
        this.f70003b = new h();
    }

    public j(@NonNull h hVar) {
        this.f70007g = true;
        this.f70009i = new float[9];
        this.f70010j = new Matrix();
        this.f70011k = new Rect();
        this.f70003b = hVar;
        this.f70004c = j(this.f70004c, hVar.f70060c, hVar.f70061d);
    }

    public static int a(int i11, float f11) {
        return (i11 & 16777215) | (((int) (Color.alpha(i11) * f11)) << 24);
    }

    @Nullable
    public static j b(@NonNull Resources resources, int i11, @Nullable Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            j jVar = new j();
            jVar.f70001a = b3.h.e(resources, i11, theme);
            jVar.f70008h = new i(jVar.f70001a.getConstantState());
            return jVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i11);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e11) {
            Log.e("VectorDrawableCompat", "parser error", e11);
            return null;
        } catch (XmlPullParserException e12) {
            Log.e("VectorDrawableCompat", "parser error", e12);
            return null;
        }
    }

    public static j c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        j jVar = new j();
        jVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return jVar;
    }

    public static PorterDuff.Mode g(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f70001a;
        if (drawable == null) {
            return false;
        }
        d3.a.b(drawable);
        return false;
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public Object d(String str) {
        return this.f70003b.f70059b.f70057p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f70011k);
        if (this.f70011k.width() <= 0 || this.f70011k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f70005d;
        if (colorFilter == null) {
            colorFilter = this.f70004c;
        }
        canvas.getMatrix(this.f70010j);
        this.f70010j.getValues(this.f70009i);
        float fAbs = Math.abs(this.f70009i[0]);
        float fAbs2 = Math.abs(this.f70009i[4]);
        float fAbs3 = Math.abs(this.f70009i[1]);
        float fAbs4 = Math.abs(this.f70009i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (this.f70011k.width() * fAbs);
        int iHeight = (int) (this.f70011k.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f70011k;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f70011k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f70011k.offsetTo(0, 0);
        this.f70003b.c(iMin, iMin2);
        if (!this.f70007g) {
            this.f70003b.j(iMin, iMin2);
        } else if (!this.f70003b.b()) {
            this.f70003b.j(iMin, iMin2);
            this.f70003b.i();
        }
        this.f70003b.d(canvas, colorFilter, this.f70011k);
        canvas.restoreToCount(iSave);
    }

    public final void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f70003b;
        g gVar = hVar.f70059b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f70049h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z11 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (MBridgeConstans.DYNAMIC_VIEW_WX_PATH.equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f70025b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f70057p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f70058a = cVar.f70040d | hVar.f70058a;
                    z11 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f70025b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f70057p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f70058a = bVar.f70040d | hVar.f70058a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f70025b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f70057p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f70058a = dVar2.f70034k | hVar.f70058a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z11) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public final boolean f() {
        return isAutoMirrored() && d3.a.f(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f70001a;
        return drawable != null ? d3.a.d(drawable) : this.f70003b.f70059b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f70003b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f70001a;
        return drawable != null ? d3.a.e(drawable) : this.f70005d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f70001a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f70001a.getConstantState());
        }
        this.f70003b.f70058a = getChangingConfigurations();
        return this.f70003b;
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f70003b.f70059b.f70051j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f70003b.f70059b.f70050i;
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void h(boolean z11) {
        this.f70007g = z11;
    }

    public final void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f70003b;
        g gVar = hVar.f70059b;
        hVar.f70061d = g(k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            hVar.f70060c = colorStateListC;
        }
        hVar.f70062e = k.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f70062e);
        gVar.f70052k = k.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f70052k);
        float f11 = k.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f70053l);
        gVar.f70053l = f11;
        if (gVar.f70052k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f11 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f70050i = typedArray.getDimension(3, gVar.f70050i);
        float dimension = typedArray.getDimension(2, gVar.f70051j);
        gVar.f70051j = dimension;
        if (gVar.f70050i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(k.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f70055n = string;
            gVar.f70057p.put(string, gVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f70003b;
        hVar.f70059b = new g();
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, l6.a.f69970a);
        i(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
        hVar.f70058a = getChangingConfigurations();
        hVar.f70068k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f70004c = j(this.f70004c, hVar.f70060c, hVar.f70061d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f70001a;
        return drawable != null ? d3.a.h(drawable) : this.f70003b.f70062e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f70003b) != null && (hVar.g() || ((colorStateList = this.f70003b.f70060c) != null && colorStateList.isStateful())));
    }

    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f70006f && super.mutate() == this) {
            this.f70003b = new h(this.f70003b);
            this.f70006f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z11;
        PorterDuff.Mode mode;
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f70003b;
        ColorStateList colorStateList = hVar.f70060c;
        if (colorStateList == null || (mode = hVar.f70061d) == null) {
            z11 = false;
        } else {
            this.f70004c = j(this.f70004c, colorStateList, mode);
            invalidateSelf();
            z11 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z11;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j11);
        } else {
            super.scheduleSelf(runnable, j11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else if (this.f70003b.f70059b.getRootAlpha() != i11) {
            this.f70003b.f70059b.setRootAlpha(i11);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.j(drawable, z11);
        } else {
            this.f70003b.f70062e = z11;
        }
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f70005d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z11) {
        super.setFilterBitmap(z11);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.n(drawable, i11);
        } else {
            setTintList(ColorStateList.valueOf(i11));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f70003b;
        if (hVar.f70060c != colorStateList) {
            hVar.f70060c = colorStateList;
            this.f70004c = j(this.f70004c, colorStateList, hVar.f70061d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.p(drawable, mode);
            return;
        }
        h hVar = this.f70003b;
        if (hVar.f70061d != mode) {
            hVar.f70061d = mode;
            this.f70004c = j(this.f70004c, hVar.f70060c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.setVisible(z11, z12) : super.setVisible(z11, z12);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
