package yi;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f81466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f81467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f81468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f81469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f81470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f81471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<f> f81472g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<g> f81473h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f81474i;

    /* JADX INFO: compiled from: source.java */
    public class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f81475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f81476d;

        public a(List list, Matrix matrix) {
            this.f81475c = list;
            this.f81476d = matrix;
        }

        @Override // yi.p.g
        public void a(Matrix matrix, xi.a aVar, int i11, Canvas canvas) {
            Iterator it = this.f81475c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f81476d, aVar, i11, canvas);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f81478c;

        public b(d dVar) {
            this.f81478c = dVar;
        }

        @Override // yi.p.g
        public void a(Matrix matrix, @NonNull xi.a aVar, int i11, @NonNull Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f81478c.k(), this.f81478c.o(), this.f81478c.l(), this.f81478c.j()), i11, this.f81478c.m(), this.f81478c.n());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f81479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f81480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f81481e;

        public c(e eVar, float f11, float f12) {
            this.f81479c = eVar;
            this.f81480d = f11;
            this.f81481e = f12;
        }

        @Override // yi.p.g
        public void a(Matrix matrix, @NonNull xi.a aVar, int i11, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f81479c.f81490c - this.f81481e, this.f81479c.f81489b - this.f81480d), 0.0f);
            this.f81493a.set(matrix);
            this.f81493a.preTranslate(this.f81480d, this.f81481e);
            this.f81493a.preRotate(c());
            aVar.b(canvas, this.f81493a, rectF, i11);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f81479c.f81490c - this.f81481e) / (this.f81479c.f81489b - this.f81480d)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RectF f81482h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f81483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f81484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f81485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f81486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f81487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f81488g;

        public d(float f11, float f12, float f13, float f14) {
            q(f11);
            u(f12);
            r(f13);
            p(f14);
        }

        @Override // yi.p.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f81491a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f81482h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f81486e;
        }

        public final float k() {
            return this.f81483b;
        }

        public final float l() {
            return this.f81485d;
        }

        public final float m() {
            return this.f81487f;
        }

        public final float n() {
            return this.f81488g;
        }

        public final float o() {
            return this.f81484c;
        }

        public final void p(float f11) {
            this.f81486e = f11;
        }

        public final void q(float f11) {
            this.f81483b = f11;
        }

        public final void r(float f11) {
            this.f81485d = f11;
        }

        public final void s(float f11) {
            this.f81487f = f11;
        }

        public final void t(float f11) {
            this.f81488g = f11;
        }

        public final void u(float f11) {
            this.f81484c = f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f81489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f81490c;

        @Override // yi.p.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f81491a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f81489b, this.f81490c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f81491a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Matrix f81492b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f81493a = new Matrix();

        public abstract void a(Matrix matrix, xi.a aVar, int i11, Canvas canvas);

        public final void b(xi.a aVar, int i11, Canvas canvas) {
            a(f81492b, aVar, i11, canvas);
        }
    }

    public p() {
        n(0.0f, 0.0f);
    }

    public void a(float f11, float f12, float f13, float f14, float f15, float f16) {
        d dVar = new d(f11, f12, f13, f14);
        dVar.s(f15);
        dVar.t(f16);
        this.f81472g.add(dVar);
        b bVar = new b(dVar);
        float f17 = f15 + f16;
        boolean z11 = f16 < 0.0f;
        if (z11) {
            f15 = (f15 + 180.0f) % 360.0f;
        }
        c(bVar, f15, z11 ? (180.0f + f17) % 360.0f : f17);
        double d11 = f17;
        r(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.cos(Math.toRadians(d11)))));
        s(((f12 + f14) * 0.5f) + (((f14 - f12) / 2.0f) * ((float) Math.sin(Math.toRadians(d11)))));
    }

    public final void b(float f11) {
        if (g() == f11) {
            return;
        }
        float fG = ((f11 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f81473h.add(new b(dVar));
        p(f11);
    }

    public final void c(g gVar, float f11, float f12) {
        b(f11);
        this.f81473h.add(gVar);
        p(f12);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f81472g.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f81472g.get(i11).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f81474i;
    }

    @NonNull
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f81473h), new Matrix(matrix));
    }

    public final float g() {
        return this.f81470e;
    }

    public final float h() {
        return this.f81471f;
    }

    public float i() {
        return this.f81468c;
    }

    public float j() {
        return this.f81469d;
    }

    public float k() {
        return this.f81466a;
    }

    public float l() {
        return this.f81467b;
    }

    public void m(float f11, float f12) {
        e eVar = new e();
        eVar.f81489b = f11;
        eVar.f81490c = f12;
        this.f81472g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f11);
        s(f12);
    }

    public void n(float f11, float f12) {
        o(f11, f12, 270.0f, 0.0f);
    }

    public void o(float f11, float f12, float f13, float f14) {
        t(f11);
        u(f12);
        r(f11);
        s(f12);
        p(f13);
        q((f13 + f14) % 360.0f);
        this.f81472g.clear();
        this.f81473h.clear();
        this.f81474i = false;
    }

    public final void p(float f11) {
        this.f81470e = f11;
    }

    public final void q(float f11) {
        this.f81471f = f11;
    }

    public final void r(float f11) {
        this.f81468c = f11;
    }

    public final void s(float f11) {
        this.f81469d = f11;
    }

    public final void t(float f11) {
        this.f81466a = f11;
    }

    public final void u(float f11) {
        this.f81467b = f11;
    }
}
