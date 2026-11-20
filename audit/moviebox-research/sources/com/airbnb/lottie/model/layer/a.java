package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c7.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.content.Mask;
import d7.c;
import d7.f;
import f7.j;
import g7.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x6.e;
import y6.d;
import y6.h;
import y6.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e, y6.a.b, a7.e {

    @Nullable
    public Paint A;
    public float B;

    @Nullable
    public BlurMaskFilter C;

    @Nullable
    public w6.a D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f15231a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f15232b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f15233c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f15234d = new w6.a(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f15235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f15236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f15237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f15238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f15239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f15240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f15241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f15242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f15243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f15244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Matrix f15245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LottieDrawable f15246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Layer f15247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public h f15248r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public d f15249s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public a f15250t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public a f15251u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<a> f15252v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<y6.a<?, ?>> f15253w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p f15254x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15255y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f15256z;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0159a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15258b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f15258b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15258b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15258b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15258b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f15257a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15257a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15257a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15257a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15257a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15257a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15257a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public a(LottieDrawable lottieDrawable, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f15235e = new w6.a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f15236f = new w6.a(1, mode2);
        w6.a aVar = new w6.a(1);
        this.f15237g = aVar;
        this.f15238h = new w6.a(PorterDuff.Mode.CLEAR);
        this.f15239i = new RectF();
        this.f15240j = new RectF();
        this.f15241k = new RectF();
        this.f15242l = new RectF();
        this.f15243m = new RectF();
        this.f15245o = new Matrix();
        this.f15253w = new ArrayList();
        this.f15255y = true;
        this.B = 0.0f;
        this.f15246p = lottieDrawable;
        this.f15247q = layer;
        this.f15244n = layer.j() + "#draw";
        if (layer.i() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        p pVarB = layer.x().b();
        this.f15254x = pVarB;
        pVarB.b(this);
        if (layer.h() != null && !layer.h().isEmpty()) {
            h hVar = new h(layer.h());
            this.f15248r = hVar;
            Iterator<y6.a<i, Path>> it = hVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (y6.a<Integer, Integer> aVar2 : this.f15248r.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        O();
    }

    @Nullable
    public static a u(b bVar, Layer layer, LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar) {
        switch (C0159a.f15257a[layer.g().ordinal()]) {
            case 1:
                return new d7.d(lottieDrawable, layer, bVar, hVar);
            case 2:
                return new b(lottieDrawable, layer, hVar.o(layer.n()), hVar);
            case 3:
                return new d7.e(lottieDrawable, layer);
            case 4:
                return new d7.b(lottieDrawable, layer);
            case 5:
                return new c(lottieDrawable, layer);
            case 6:
                return new f(lottieDrawable, layer);
            default:
                g7.f.c("Unknown layer type " + layer.g());
                return null;
        }
    }

    public boolean A() {
        h hVar = this.f15248r;
        return (hVar == null || hVar.a().isEmpty()) ? false : true;
    }

    public boolean B() {
        return this.f15250t != null;
    }

    public final void C(RectF rectF, Matrix matrix) {
        this.f15241k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (A()) {
            int size = this.f15248r.b().size();
            for (int i11 = 0; i11 < size; i11++) {
                Mask mask = this.f15248r.b().get(i11);
                Path pathH = this.f15248r.a().get(i11).h();
                if (pathH != null) {
                    this.f15231a.set(pathH);
                    this.f15231a.transform(matrix);
                    int i12 = C0159a.f15258b[mask.a().ordinal()];
                    if (i12 == 1 || i12 == 2) {
                        return;
                    }
                    if ((i12 == 3 || i12 == 4) && mask.d()) {
                        return;
                    }
                    this.f15231a.computeBounds(this.f15243m, false);
                    if (i11 == 0) {
                        this.f15241k.set(this.f15243m);
                    } else {
                        RectF rectF2 = this.f15241k;
                        rectF2.set(Math.min(rectF2.left, this.f15243m.left), Math.min(this.f15241k.top, this.f15243m.top), Math.max(this.f15241k.right, this.f15243m.right), Math.max(this.f15241k.bottom, this.f15243m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f15241k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void D(RectF rectF, Matrix matrix) {
        if (B() && this.f15247q.i() != Layer.MatteType.INVERT) {
            this.f15242l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f15250t.f(this.f15242l, matrix, true);
            if (rectF.intersect(this.f15242l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void E() {
        this.f15246p.invalidateSelf();
    }

    public final /* synthetic */ void F() {
        N(this.f15249s.q() == 1.0f);
    }

    public final void G(float f11) {
        this.f15246p.O().n().a(this.f15247q.j(), f11);
    }

    public void H(y6.a<?, ?> aVar) {
        this.f15253w.remove(aVar);
    }

    public void I(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
    }

    public void J(@Nullable a aVar) {
        this.f15250t = aVar;
    }

    public void K(boolean z11) {
        if (z11 && this.A == null) {
            this.A = new w6.a();
        }
        this.f15256z = z11;
    }

    public void L(@Nullable a aVar) {
        this.f15251u = aVar;
    }

    public void M(float f11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseLayer#setProgress");
            com.airbnb.lottie.d.b("BaseLayer#setProgress.transform");
        }
        this.f15254x.j(f11);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseLayer#setProgress.transform");
        }
        if (this.f15248r != null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("BaseLayer#setProgress.mask");
            }
            for (int i11 = 0; i11 < this.f15248r.a().size(); i11++) {
                this.f15248r.a().get(i11).n(f11);
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseLayer#setProgress.mask");
            }
        }
        if (this.f15249s != null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("BaseLayer#setProgress.inout");
            }
            this.f15249s.n(f11);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseLayer#setProgress.inout");
            }
        }
        if (this.f15250t != null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("BaseLayer#setProgress.matte");
            }
            this.f15250t.M(f11);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseLayer#setProgress.matte");
            }
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseLayer#setProgress.animations." + this.f15253w.size());
        }
        for (int i12 = 0; i12 < this.f15253w.size(); i12++) {
            this.f15253w.get(i12).n(f11);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseLayer#setProgress.animations." + this.f15253w.size());
            com.airbnb.lottie.d.c("BaseLayer#setProgress");
        }
    }

    public final void N(boolean z11) {
        if (z11 != this.f15255y) {
            this.f15255y = z11;
            E();
        }
    }

    public final void O() {
        if (this.f15247q.f().isEmpty()) {
            N(true);
            return;
        }
        d dVar = new d(this.f15247q.f());
        this.f15249s = dVar;
        dVar.m();
        this.f15249s.a(new y6.a.b() { // from class: d7.a
            @Override // y6.a.b
            public final void b() {
                this.f62935a.F();
            }
        });
        N(this.f15249s.h().floatValue() == 1.0f);
        i(this.f15249s);
    }

    @Override // y6.a.b
    public void b() {
        E();
    }

    @Override // x6.c
    public void c(List<x6.c> list, List<x6.c> list2) {
    }

    @Override // a7.e
    @CallSuper
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        this.f15254x.c(t11, cVar);
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        a aVar = this.f15250t;
        if (aVar != null) {
            a7.d dVarA = dVar2.a(aVar.getName());
            if (dVar.c(this.f15250t.getName(), i11)) {
                list.add(dVarA.i(this.f15250t));
            }
            if (dVar.h(getName(), i11)) {
                this.f15250t.I(dVar, dVar.e(this.f15250t.getName(), i11) + i11, list, dVarA);
            }
        }
        if (dVar.g(getName(), i11)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i11)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i11)) {
                I(dVar, i11 + dVar.e(getName(), i11), list, dVar2);
            }
        }
    }

    @Override // x6.e
    @CallSuper
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        this.f15239i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f15245o.set(matrix);
        if (z11) {
            List<a> list = this.f15252v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f15245o.preConcat(this.f15252v.get(size).f15254x.f());
                }
            } else {
                a aVar = this.f15251u;
                if (aVar != null) {
                    this.f15245o.preConcat(aVar.f15254x.f());
                }
            }
        }
        this.f15245o.preConcat(this.f15254x.f());
    }

    @Override // x6.c
    public String getName() {
        return this.f15247q.j();
    }

    @Override // x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        Paint paint;
        Integer numH;
        com.airbnb.lottie.d.b(this.f15244n);
        if (!this.f15255y || this.f15247q.y()) {
            com.airbnb.lottie.d.c(this.f15244n);
            return;
        }
        r();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#parentMatrix");
        }
        this.f15232b.reset();
        this.f15232b.set(matrix);
        for (int size = this.f15252v.size() - 1; size >= 0; size--) {
            this.f15232b.preConcat(this.f15252v.get(size).f15254x.f());
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#parentMatrix");
        }
        y6.a<?, Integer> aVarH = this.f15254x.h();
        int iIntValue = (int) ((((i11 / 255.0f) * ((aVarH == null || (numH = aVarH.h()) == null) ? 100 : numH.intValue())) / 100.0f) * 255.0f);
        if (!B() && !A() && v() == LBlendMode.NORMAL) {
            this.f15232b.preConcat(this.f15254x.f());
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#drawLayer");
            }
            t(canvas, this.f15232b, iIntValue);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#drawLayer");
            }
            G(com.airbnb.lottie.d.c(this.f15244n));
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#computeBounds");
        }
        f(this.f15239i, this.f15232b, false);
        D(this.f15239i, matrix);
        this.f15232b.preConcat(this.f15254x.f());
        C(this.f15239i, this.f15232b);
        this.f15240j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.f15233c);
        if (!this.f15233c.isIdentity()) {
            Matrix matrix2 = this.f15233c;
            matrix2.invert(matrix2);
            this.f15233c.mapRect(this.f15240j);
        }
        if (!this.f15239i.intersect(this.f15240j)) {
            this.f15239i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#computeBounds");
        }
        if (this.f15239i.width() >= 1.0f && this.f15239i.height() >= 1.0f) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#saveLayer");
            }
            this.f15234d.setAlpha(255);
            c3.d.c(this.f15234d, v().toNativeBlendMode());
            l.n(canvas, this.f15239i, this.f15234d);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#saveLayer");
            }
            if (v() != LBlendMode.MULTIPLY) {
                s(canvas);
            } else {
                if (this.D == null) {
                    w6.a aVar = new w6.a();
                    this.D = aVar;
                    aVar.setColor(-1);
                }
                RectF rectF = this.f15239i;
                canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.D);
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#drawLayer");
            }
            t(canvas, this.f15232b, iIntValue);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#drawLayer");
            }
            if (A()) {
                o(canvas, this.f15232b);
            }
            if (B()) {
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.b("Layer#drawMatte");
                    com.airbnb.lottie.d.b("Layer#saveLayer");
                }
                l.o(canvas, this.f15239i, this.f15237g, 19);
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("Layer#saveLayer");
                }
                s(canvas);
                this.f15250t.h(canvas, matrix, iIntValue);
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.b("Layer#restoreLayer");
                }
                canvas.restore();
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("Layer#restoreLayer");
                    com.airbnb.lottie.d.c("Layer#drawMatte");
                }
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#restoreLayer");
            }
            canvas.restore();
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#restoreLayer");
            }
        }
        if (this.f15256z && (paint = this.A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.A.setColor(-251901);
            this.A.setStrokeWidth(4.0f);
            canvas.drawRect(this.f15239i, this.A);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setColor(1357638635);
            canvas.drawRect(this.f15239i, this.A);
        }
        G(com.airbnb.lottie.d.c(this.f15244n));
    }

    public void i(@Nullable y6.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.f15253w.add(aVar);
    }

    public final void j(Canvas canvas, Matrix matrix, y6.a<i, Path> aVar, y6.a<Integer, Integer> aVar2) {
        this.f15231a.set(aVar.h());
        this.f15231a.transform(matrix);
        this.f15234d.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f15231a, this.f15234d);
    }

    public final void k(Canvas canvas, Matrix matrix, y6.a<i, Path> aVar, y6.a<Integer, Integer> aVar2) {
        l.n(canvas, this.f15239i, this.f15235e);
        this.f15231a.set(aVar.h());
        this.f15231a.transform(matrix);
        this.f15234d.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f15231a, this.f15234d);
        canvas.restore();
    }

    public final void l(Canvas canvas, Matrix matrix, y6.a<i, Path> aVar, y6.a<Integer, Integer> aVar2) {
        l.n(canvas, this.f15239i, this.f15234d);
        canvas.drawRect(this.f15239i, this.f15234d);
        this.f15231a.set(aVar.h());
        this.f15231a.transform(matrix);
        this.f15234d.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f15231a, this.f15236f);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, y6.a<i, Path> aVar, y6.a<Integer, Integer> aVar2) {
        l.n(canvas, this.f15239i, this.f15235e);
        canvas.drawRect(this.f15239i, this.f15234d);
        this.f15236f.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f15231a.set(aVar.h());
        this.f15231a.transform(matrix);
        canvas.drawPath(this.f15231a, this.f15236f);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, y6.a<i, Path> aVar, y6.a<Integer, Integer> aVar2) {
        l.n(canvas, this.f15239i, this.f15236f);
        canvas.drawRect(this.f15239i, this.f15234d);
        this.f15236f.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f15231a.set(aVar.h());
        this.f15231a.transform(matrix);
        canvas.drawPath(this.f15231a, this.f15236f);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#saveLayer");
        }
        l.o(canvas, this.f15239i, this.f15235e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#saveLayer");
        }
        for (int i11 = 0; i11 < this.f15248r.b().size(); i11++) {
            Mask mask = this.f15248r.b().get(i11);
            y6.a<i, Path> aVar = this.f15248r.a().get(i11);
            y6.a<Integer, Integer> aVar2 = this.f15248r.c().get(i11);
            int i12 = C0159a.f15258b[mask.a().ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    if (i11 == 0) {
                        this.f15234d.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f15234d.setAlpha(255);
                        canvas.drawRect(this.f15239i, this.f15234d);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, aVar, aVar2);
                    } else {
                        p(canvas, matrix, aVar);
                    }
                } else if (i12 != 3) {
                    if (i12 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, aVar, aVar2);
                        } else {
                            j(canvas, matrix, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, aVar, aVar2);
                } else {
                    k(canvas, matrix, aVar, aVar2);
                }
            } else if (q()) {
                this.f15234d.setAlpha(255);
                canvas.drawRect(this.f15239i, this.f15234d);
            }
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#restoreLayer");
        }
        canvas.restore();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#restoreLayer");
        }
    }

    public final void p(Canvas canvas, Matrix matrix, y6.a<i, Path> aVar) {
        this.f15231a.set(aVar.h());
        this.f15231a.transform(matrix);
        canvas.drawPath(this.f15231a, this.f15236f);
    }

    public final boolean q() {
        if (this.f15248r.a().isEmpty()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f15248r.b().size(); i11++) {
            if (this.f15248r.b().get(i11).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void r() {
        if (this.f15252v != null) {
            return;
        }
        if (this.f15251u == null) {
            this.f15252v = Collections.emptyList();
            return;
        }
        this.f15252v = new ArrayList();
        for (a aVar = this.f15251u; aVar != null; aVar = aVar.f15251u) {
            this.f15252v.add(aVar);
        }
    }

    public final void s(Canvas canvas) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#clearLayer");
        }
        RectF rectF = this.f15239i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f15238h);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#clearLayer");
        }
    }

    public abstract void t(Canvas canvas, Matrix matrix, int i11);

    public LBlendMode v() {
        return this.f15247q.a();
    }

    @Nullable
    public c7.a w() {
        return this.f15247q.b();
    }

    public BlurMaskFilter x(float f11) {
        if (this.B == f11) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f11 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f11;
        return blurMaskFilter;
    }

    @Nullable
    public j y() {
        return this.f15247q.d();
    }

    public Layer z() {
        return this.f15247q;
    }
}
