package x6;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r implements m, y6.a.b, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f80402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f80403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieDrawable f80404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y6.m f80405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f80406f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80401a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f80407g = new b();

    public r(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.l lVar) {
        this.f80402b = lVar.b();
        this.f80403c = lVar.d();
        this.f80404d = lottieDrawable;
        y6.m mVarA = lVar.c().a();
        this.f80405e = mVarA;
        aVar.i(mVarA);
        mVarA.a(this);
    }

    private void g() {
        this.f80406f = false;
        this.f80404d.invalidateSelf();
    }

    @Override // y6.a.b
    public void b() {
        g();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f80407g.a(uVar);
                    uVar.d(this);
                } else if (!(cVar instanceof s)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((s) cVar);
                }
            } else if (!(cVar instanceof s)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f80405e.r(arrayList);
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        if (t11 == p0.P) {
            this.f80405e.o(cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        g7.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // x6.c
    public String getName() {
        return this.f80402b;
    }

    @Override // x6.m
    public Path getPath() {
        if (this.f80406f && !this.f80405e.k()) {
            return this.f80401a;
        }
        this.f80401a.reset();
        if (this.f80403c) {
            this.f80406f = true;
            return this.f80401a;
        }
        Path pathH = this.f80405e.h();
        if (pathH == null) {
            return this.f80401a;
        }
        this.f80401a.set(pathH);
        this.f80401a.setFillType(Path.FillType.EVEN_ODD);
        this.f80407g.b(this.f80401a);
        this.f80406f = true;
        return this.f80401a;
    }
}
