package com.google.android.play.core.appupdate;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f38044a;

    public static synchronized e a(Context context) {
        try {
            if (f38044a == null) {
                g gVar = new g(null);
                gVar.b(new n(com.google.android.play.core.appupdate.internal.z.a(context)));
                f38044a = gVar.a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f38044a;
    }
}
