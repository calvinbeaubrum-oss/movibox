package qn;

import android.content.Context;
import com.iab.omid.library.vungle.b.d;
import com.iab.omid.library.vungle.b.f;
import un.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f74865a;

    public void a(Context context) {
        c(context);
        if (d()) {
            return;
        }
        b(true);
        f.a().b(context);
        com.iab.omid.library.vungle.b.b.a().b(context);
        un.b.c(context);
        d.a().b(context);
    }

    public void b(boolean z11) {
        this.f74865a = z11;
    }

    public final void c(Context context) {
        e.c(context, "Application Context cannot be null");
    }

    public boolean d() {
        return this.f74865a;
    }
}
