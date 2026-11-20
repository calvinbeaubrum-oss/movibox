package l1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class a implements c {
    @Override // l1.c
    public void a(b bVar, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        bVar.b(new d(colorStateList, f11));
        View viewF = bVar.f();
        viewF.setClipToOutline(true);
        viewF.setElevation(f12);
        c(bVar, f13);
    }

    @Override // l1.c
    public void b(b bVar) {
        c(bVar, j(bVar));
    }

    @Override // l1.c
    public void c(b bVar, float f11) {
        p(bVar).g(f11, bVar.c(), bVar.e());
        e(bVar);
    }

    @Override // l1.c
    public void d(b bVar, float f11) {
        p(bVar).h(f11);
    }

    @Override // l1.c
    public void e(b bVar) {
        if (!bVar.c()) {
            bVar.a(0, 0, 0, 0);
            return;
        }
        float fJ = j(bVar);
        float fH = h(bVar);
        int iCeil = (int) Math.ceil(e.a(fJ, fH, bVar.e()));
        int iCeil2 = (int) Math.ceil(e.b(fJ, fH, bVar.e()));
        bVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // l1.c
    public void f(b bVar, float f11) {
        bVar.f().setElevation(f11);
    }

    @Override // l1.c
    public float g(b bVar) {
        return h(bVar) * 2.0f;
    }

    @Override // l1.c
    public float h(b bVar) {
        return p(bVar).d();
    }

    @Override // l1.c
    public void i(b bVar) {
        c(bVar, j(bVar));
    }

    @Override // l1.c
    public float j(b bVar) {
        return p(bVar).c();
    }

    @Override // l1.c
    public float k(b bVar) {
        return h(bVar) * 2.0f;
    }

    @Override // l1.c
    public void l(b bVar, @Nullable ColorStateList colorStateList) {
        p(bVar).f(colorStateList);
    }

    @Override // l1.c
    public ColorStateList m(b bVar) {
        return p(bVar).b();
    }

    @Override // l1.c
    public void n() {
    }

    @Override // l1.c
    public float o(b bVar) {
        return bVar.f().getElevation();
    }

    public final d p(b bVar) {
        return (d) bVar.d();
    }
}
