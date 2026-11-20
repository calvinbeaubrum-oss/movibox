package jn;

import android.content.Context;
import com.iab.omid.library.mmadbridge.internal.f;
import com.iab.omid.library.mmadbridge.internal.h;
import nn.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f68105a;

    public void a(Context context) {
        c(context);
        if (d()) {
            return;
        }
        b(true);
        h.d().b(context);
        com.iab.omid.library.mmadbridge.internal.b.k().a(context);
        nn.a.b(context);
        nn.c.d(context);
        nn.e.c(context);
        f.c().b(context);
        com.iab.omid.library.mmadbridge.internal.a.a().b(context);
    }

    public void b(boolean z11) {
        this.f68105a = z11;
    }

    public final void c(Context context) {
        g.c(context, "Application Context cannot be null");
    }

    public boolean d() {
        return this.f68105a;
    }
}
