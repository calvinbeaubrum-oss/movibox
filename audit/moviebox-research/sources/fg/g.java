package fg;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f64867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final og.a f64868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final og.a f64869c;

    public g(Context context, og.a aVar, og.a aVar2) {
        this.f64867a = context;
        this.f64868b = aVar;
        this.f64869c = aVar2;
    }

    public f a(String str) {
        return f.a(this.f64867a, this.f64868b, this.f64869c, str);
    }
}
