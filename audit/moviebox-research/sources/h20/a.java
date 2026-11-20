package h20;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSetObservable f66124a = new DataSetObservable();

    public abstract int a();

    public abstract c b(Context context);

    public abstract d c(Context context, int i11);

    public float d(Context context, int i11) {
        return 1.0f;
    }

    public final void e() {
        this.f66124a.notifyChanged();
    }

    public final void f(DataSetObserver dataSetObserver) {
        this.f66124a.registerObserver(dataSetObserver);
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.f66124a.unregisterObserver(dataSetObserver);
    }
}
