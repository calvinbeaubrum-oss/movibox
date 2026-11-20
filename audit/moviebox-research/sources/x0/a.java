package x0;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements AppBarLayout.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w0.a f79781a;

    public a(w0.a aVar) {
        this.f79781a = aVar;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.b
    public void a(AppBarLayout appBarLayout, int i11) {
        w0.a aVar = this.f79781a;
        boolean z11 = i11 >= 0;
        boolean z12 = appBarLayout.getTotalScrollRange() + i11 <= 0;
        u0.a aVar2 = (u0.a) aVar;
        aVar2.f78110h = z11;
        aVar2.f78111i = z12;
    }
}
