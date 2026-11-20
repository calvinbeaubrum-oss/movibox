package com.iab.omid.library.mmadbridge.internal;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static b f42354d = new b();

    public static b k() {
        return f42354d;
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d
    public void f(boolean z11) {
        Iterator<kn.g> it = c.e().c().iterator();
        while (it.hasNext()) {
            it.next().w().n(z11);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d
    public boolean h() {
        Iterator<kn.g> it = c.e().a().iterator();
        while (it.hasNext()) {
            View viewO = it.next().o();
            if (viewO != null && viewO.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
