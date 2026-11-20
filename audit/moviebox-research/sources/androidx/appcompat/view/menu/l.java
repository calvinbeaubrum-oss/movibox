package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(@NonNull f fVar, boolean z11);

        boolean c(@NonNull f fVar);
    }

    void b(f fVar, boolean z11);

    boolean c(f fVar, h hVar);

    void d(a aVar);

    void e(Parcelable parcelable);

    boolean f(q qVar);

    Parcelable g();

    int getId();

    void h(boolean z11);

    boolean i();

    boolean j(f fVar, h hVar);

    void k(Context context, f fVar);
}
