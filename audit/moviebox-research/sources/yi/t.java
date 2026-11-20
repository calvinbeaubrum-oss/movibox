package yi;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(22)
public class t extends r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f81499f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f81500g = 0.0f;

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            t tVar = t.this;
            if (tVar.f81496c == null || tVar.f81497d.isEmpty()) {
                return;
            }
            t tVar2 = t.this;
            RectF rectF = tVar2.f81497d;
            outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, tVar2.f81500g);
        }
    }

    public t(@NonNull View view) {
        n(view);
    }

    private void n(View view) {
        view.setOutlineProvider(new a());
    }

    public static boolean q(n nVar) {
        return (nVar.q() instanceof m) && (nVar.s() instanceof m) && (nVar.i() instanceof m) && (nVar.k() instanceof m);
    }

    @Override // yi.r
    public void b(@NonNull View view) {
        this.f81500g = m();
        this.f81499f = o() || p();
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // yi.r
    public boolean j() {
        return !this.f81499f || this.f81494a;
    }

    public final float m() {
        RectF rectF;
        n nVar = this.f81496c;
        if (nVar == null || (rectF = this.f81497d) == null) {
            return 0.0f;
        }
        return nVar.f81429f.a(rectF);
    }

    public final boolean o() {
        n nVar;
        if (this.f81497d.isEmpty() || (nVar = this.f81496c) == null) {
            return false;
        }
        return nVar.u(this.f81497d);
    }

    public final boolean p() {
        n nVar;
        if (!this.f81497d.isEmpty() && (nVar = this.f81496c) != null && this.f81495b && !nVar.u(this.f81497d) && q(this.f81496c)) {
            float fA = this.f81496c.r().a(this.f81497d);
            float fA2 = this.f81496c.t().a(this.f81497d);
            float fA3 = this.f81496c.j().a(this.f81497d);
            float fA4 = this.f81496c.l().a(this.f81497d);
            if (fA == 0.0f && fA3 == 0.0f && fA2 == fA4) {
                RectF rectF = this.f81497d;
                rectF.set(rectF.left - fA2, rectF.top, rectF.right, rectF.bottom);
                this.f81500g = fA2;
                return true;
            }
            if (fA == 0.0f && fA2 == 0.0f && fA3 == fA4) {
                RectF rectF2 = this.f81497d;
                rectF2.set(rectF2.left, rectF2.top - fA3, rectF2.right, rectF2.bottom);
                this.f81500g = fA3;
                return true;
            }
            if (fA2 == 0.0f && fA4 == 0.0f && fA == fA3) {
                RectF rectF3 = this.f81497d;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + fA, rectF3.bottom);
                this.f81500g = fA;
                return true;
            }
            if (fA3 == 0.0f && fA4 == 0.0f && fA == fA2) {
                RectF rectF4 = this.f81497d;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + fA);
                this.f81500g = fA;
                return true;
            }
        }
        return false;
    }
}
