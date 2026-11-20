package yi;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p[] f81448a = new p[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f81449b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f81450c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f81451d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f81452e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f81453f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f81454g = new p();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f81455h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f81456i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f81457j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f81458k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f81459l = true;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f81460a = new o();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(p pVar, Matrix matrix, int i11);

        void b(p pVar, Matrix matrix, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final n f81461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final Path f81462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final RectF f81463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final b f81464d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f81465e;

        public c(@NonNull n nVar, float f11, RectF rectF, @Nullable b bVar, Path path) {
            this.f81464d = bVar;
            this.f81461a = nVar;
            this.f81465e = f11;
            this.f81463c = rectF;
            this.f81462b = path;
        }
    }

    public o() {
        for (int i11 = 0; i11 < 4; i11++) {
            this.f81448a[i11] = new p();
            this.f81449b[i11] = new Matrix();
            this.f81450c[i11] = new Matrix();
        }
    }

    @NonNull
    public static o k() {
        return a.f81460a;
    }

    public final float a(int i11) {
        return ((i11 + 1) % 4) * 90;
    }

    public final void b(@NonNull c cVar, int i11) {
        this.f81455h[0] = this.f81448a[i11].k();
        this.f81455h[1] = this.f81448a[i11].l();
        this.f81449b[i11].mapPoints(this.f81455h);
        if (i11 == 0) {
            Path path = cVar.f81462b;
            float[] fArr = this.f81455h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f81462b;
            float[] fArr2 = this.f81455h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f81448a[i11].d(this.f81449b[i11], cVar.f81462b);
        b bVar = cVar.f81464d;
        if (bVar != null) {
            bVar.a(this.f81448a[i11], this.f81449b[i11], i11);
        }
    }

    public final void c(@NonNull c cVar, int i11) {
        int i12 = (i11 + 1) % 4;
        this.f81455h[0] = this.f81448a[i11].i();
        this.f81455h[1] = this.f81448a[i11].j();
        this.f81449b[i11].mapPoints(this.f81455h);
        this.f81456i[0] = this.f81448a[i12].k();
        this.f81456i[1] = this.f81448a[i12].l();
        this.f81449b[i12].mapPoints(this.f81456i);
        float[] fArr = this.f81455h;
        float f11 = fArr[0];
        float[] fArr2 = this.f81456i;
        float fMax = Math.max(((float) Math.hypot(f11 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f81463c, i11);
        this.f81454g.n(0.0f, 0.0f);
        g gVarJ = j(i11, cVar.f81461a);
        gVarJ.b(fMax, fI, cVar.f81465e, this.f81454g);
        this.f81457j.reset();
        this.f81454g.d(this.f81450c[i11], this.f81457j);
        if (this.f81459l && (gVarJ.a() || l(this.f81457j, i11) || l(this.f81457j, i12))) {
            Path path = this.f81457j;
            path.op(path, this.f81453f, Path.Op.DIFFERENCE);
            this.f81455h[0] = this.f81454g.k();
            this.f81455h[1] = this.f81454g.l();
            this.f81450c[i11].mapPoints(this.f81455h);
            Path path2 = this.f81452e;
            float[] fArr3 = this.f81455h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f81454g.d(this.f81450c[i11], this.f81452e);
        } else {
            this.f81454g.d(this.f81450c[i11], cVar.f81462b);
        }
        b bVar = cVar.f81464d;
        if (bVar != null) {
            bVar.b(this.f81454g, this.f81450c[i11], i11);
        }
    }

    public void d(n nVar, float f11, RectF rectF, @NonNull Path path) {
        e(nVar, f11, rectF, null, path);
    }

    public void e(n nVar, float f11, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f81452e.rewind();
        this.f81453f.rewind();
        this.f81453f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(nVar, f11, rectF, bVar, path);
        for (int i11 = 0; i11 < 4; i11++) {
            m(cVar, i11);
            n(i11);
        }
        for (int i12 = 0; i12 < 4; i12++) {
            b(cVar, i12);
            c(cVar, i12);
        }
        path.close();
        this.f81452e.close();
        if (this.f81452e.isEmpty()) {
            return;
        }
        path.op(this.f81452e, Path.Op.UNION);
    }

    public final void f(int i11, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i11 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i11 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i11 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    public final d g(int i11, @NonNull n nVar) {
        if (i11 == 1) {
            return nVar.l();
        }
        if (i11 != 2) {
            return i11 != 3 ? nVar.t() : nVar.r();
        }
        return nVar.j();
    }

    public final e h(int i11, @NonNull n nVar) {
        if (i11 == 1) {
            return nVar.k();
        }
        if (i11 != 2) {
            return i11 != 3 ? nVar.s() : nVar.q();
        }
        return nVar.i();
    }

    public final float i(@NonNull RectF rectF, int i11) {
        float[] fArr = this.f81455h;
        p pVar = this.f81448a[i11];
        fArr[0] = pVar.f81468c;
        fArr[1] = pVar.f81469d;
        this.f81449b[i11].mapPoints(fArr);
        return (i11 == 1 || i11 == 3) ? Math.abs(rectF.centerX() - this.f81455h[0]) : Math.abs(rectF.centerY() - this.f81455h[1]);
    }

    public final g j(int i11, @NonNull n nVar) {
        if (i11 == 1) {
            return nVar.h();
        }
        if (i11 != 2) {
            return i11 != 3 ? nVar.o() : nVar.p();
        }
        return nVar.n();
    }

    @RequiresApi(19)
    public final boolean l(Path path, int i11) {
        this.f81458k.reset();
        this.f81448a[i11].d(this.f81449b[i11], this.f81458k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f81458k.computeBounds(rectF, true);
        path.op(this.f81458k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final void m(@NonNull c cVar, int i11) {
        h(i11, cVar.f81461a).b(this.f81448a[i11], 90.0f, cVar.f81465e, cVar.f81463c, g(i11, cVar.f81461a));
        float fA = a(i11);
        this.f81449b[i11].reset();
        f(i11, cVar.f81463c, this.f81451d);
        Matrix matrix = this.f81449b[i11];
        PointF pointF = this.f81451d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f81449b[i11].preRotate(fA);
    }

    public final void n(int i11) {
        this.f81455h[0] = this.f81448a[i11].i();
        this.f81455h[1] = this.f81448a[i11].j();
        this.f81449b[i11].mapPoints(this.f81455h);
        float fA = a(i11);
        this.f81450c[i11].reset();
        Matrix matrix = this.f81450c[i11];
        float[] fArr = this.f81455h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f81450c[i11].preRotate(fA);
    }
}
