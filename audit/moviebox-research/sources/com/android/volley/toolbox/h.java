package com.android.volley.toolbox;

import android.graphics.Bitmap;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Request<?> f16578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f16579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public VolleyError f16580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<b> f16581d;

        public VolleyError c() {
            return this.f16580c;
        }

        public boolean d(b bVar) {
            this.f16581d.remove(bVar);
            if (this.f16581d.size() != 0) {
                return false;
            }
            this.f16578a.cancel();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f16582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f16583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f16585d;

        public void c() {
            n.a();
            if (this.f16583b == null) {
                return;
            }
            a aVar = (a) h.a(null).get(this.f16584c);
            if (aVar != null) {
                if (aVar.d(this)) {
                    h.a(null).remove(this.f16584c);
                    return;
                }
                return;
            }
            a aVar2 = (a) h.b(null).get(this.f16584c);
            if (aVar2 != null) {
                aVar2.d(this);
                if (aVar2.f16581d.size() == 0) {
                    h.b(null).remove(this.f16584c);
                }
            }
        }

        public Bitmap d() {
            return this.f16582a;
        }

        public String e() {
            return this.f16585d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c extends com.android.volley.i.a {
        void a(b bVar, boolean z11);
    }

    public static /* synthetic */ HashMap a(h hVar) {
        throw null;
    }

    public static /* synthetic */ HashMap b(h hVar) {
        throw null;
    }

    public static /* synthetic */ Runnable c(h hVar, Runnable runnable) {
        throw null;
    }
}
