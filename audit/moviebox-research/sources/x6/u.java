package x6;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class u implements c, y6.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f80414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<y6.a.b> f80415c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShapeTrimPath.Type f80416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y6.a<?, Float> f80417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y6.a<?, Float> f80418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y6.a<?, Float> f80419g;

    public u(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f80413a = shapeTrimPath.c();
        this.f80414b = shapeTrimPath.g();
        this.f80416d = shapeTrimPath.f();
        y6.d dVarA = shapeTrimPath.e().a();
        this.f80417e = dVarA;
        y6.d dVarA2 = shapeTrimPath.b().a();
        this.f80418f = dVarA2;
        y6.d dVarA3 = shapeTrimPath.d().a();
        this.f80419g = dVarA3;
        aVar.i(dVarA);
        aVar.i(dVarA2);
        aVar.i(dVarA3);
        dVarA.a(this);
        dVarA2.a(this);
        dVarA3.a(this);
    }

    @Override // y6.a.b
    public void b() {
        for (int i11 = 0; i11 < this.f80415c.size(); i11++) {
            this.f80415c.get(i11).b();
        }
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
    }

    public void d(y6.a.b bVar) {
        this.f80415c.add(bVar);
    }

    public y6.a<?, Float> e() {
        return this.f80418f;
    }

    public y6.a<?, Float> g() {
        return this.f80419g;
    }

    public y6.a<?, Float> i() {
        return this.f80417e;
    }

    public ShapeTrimPath.Type j() {
        return this.f80416d;
    }

    public boolean k() {
        return this.f80414b;
    }
}
