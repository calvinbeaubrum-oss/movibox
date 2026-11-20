package u0;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f78113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f78114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78115c = true;

    public boolean a(View view) {
        b bVar = this.f78114b;
        return bVar != null ? bVar.a(view) : x0.b.e(view, this.f78113a, this.f78115c);
    }

    public boolean b(View view) {
        b bVar = this.f78114b;
        return bVar != null ? bVar.b(view) : x0.b.d(view, this.f78113a);
    }
}
