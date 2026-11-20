package com.android.volley.toolbox;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: compiled from: source.java */
    public class a implements c.InterfaceC0164c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f16589a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f16590b;

        public a(Context context) {
            this.f16590b = context;
        }

        @Override // com.android.volley.toolbox.c.InterfaceC0164c
        public File get() {
            if (this.f16589a == null) {
                this.f16589a = new File(this.f16590b.getCacheDir(), "volley");
            }
            return this.f16589a;
        }
    }

    @NonNull
    public static com.android.volley.h a(Context context) {
        return c(context, null);
    }

    @NonNull
    public static com.android.volley.h b(Context context, com.android.volley.f fVar) {
        com.android.volley.h hVar = new com.android.volley.h(new c(new a(context.getApplicationContext())), fVar);
        hVar.g();
        return hVar;
    }

    @NonNull
    public static com.android.volley.h c(Context context, com.android.volley.toolbox.a aVar) {
        return b(context, aVar == null ? new b(new g()) : new b(aVar));
    }
}
