package sn;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static a a(b bVar, c cVar) {
        un.e.a();
        un.e.c(bVar, "AdSessionConfiguration is null");
        un.e.c(cVar, "AdSessionContext is null");
        return new f(bVar, cVar);
    }

    public abstract void b();

    public abstract void c(View view);

    public abstract void d();
}
