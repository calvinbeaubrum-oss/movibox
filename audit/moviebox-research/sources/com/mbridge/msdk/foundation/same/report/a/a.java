package com.mbridge.msdk.foundation.same.report.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f44735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected h f44736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.db.h f44737c;

    public a(h hVar) {
        Context context;
        this.f44737c = null;
        this.f44736b = hVar;
        Context contextC = c.m().c();
        this.f44735a = contextC;
        this.f44737c = com.mbridge.msdk.foundation.db.h.a(contextC);
        if (this.f44736b == null || (context = this.f44735a) == null) {
            return;
        }
        int iL = z.l(context);
        this.f44736b.d(iL);
        this.f44736b.c(z.a(this.f44735a, iL));
    }

    public final void a() {
        if (this.f44736b != null) {
            l.a(this.f44737c).a(this.f44736b);
        }
    }

    public final void a(int i11) {
        h hVar = this.f44736b;
        if (hVar != null) {
            hVar.b(i11);
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44736b.a(str);
    }

    public final void b(int i11) {
        h hVar = this.f44736b;
        if (hVar != null) {
            hVar.a(i11);
        }
    }

    public final void b(String str) {
        h hVar = this.f44736b;
        if (hVar != null) {
            hVar.b(str);
        }
    }

    public final void c(int i11) {
        h hVar = this.f44736b;
        if (hVar != null) {
            hVar.c(i11);
        }
    }
}
