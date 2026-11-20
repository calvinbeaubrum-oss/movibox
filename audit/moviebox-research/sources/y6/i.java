package y6;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends h7.a<PointF> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public Path f81259q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h7.a<PointF> f81260r;

    public i(com.airbnb.lottie.h hVar, h7.a<PointF> aVar) {
        super(hVar, aVar.f66350b, aVar.f66351c, aVar.f66352d, aVar.f66353e, aVar.f66354f, aVar.f66355g, aVar.f66356h);
        this.f81260r = aVar;
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        T t11;
        T t12;
        T t13 = this.f66351c;
        boolean z11 = (t13 == 0 || (t12 = this.f66350b) == 0 || !((PointF) t12).equals(((PointF) t13).x, ((PointF) t13).y)) ? false : true;
        T t14 = this.f66350b;
        if (t14 == 0 || (t11 = this.f66351c) == 0 || z11) {
            return;
        }
        h7.a<PointF> aVar = this.f81260r;
        this.f81259q = g7.l.d((PointF) t14, (PointF) t11, aVar.f66363o, aVar.f66364p);
    }

    @Nullable
    public Path k() {
        return this.f81259q;
    }
}
