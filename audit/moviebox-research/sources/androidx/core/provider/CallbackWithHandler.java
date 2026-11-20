package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class CallbackWithHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final g.c f7805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Handler f7806b;

    public CallbackWithHandler(@NonNull g.c cVar, @NonNull Handler handler) {
        this.f7805a = cVar;
        this.f7806b = handler;
    }

    public final void a(final int i11) {
        final g.c cVar = this.f7805a;
        this.f7806b.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(i11);
            }
        });
    }

    public void b(@NonNull f.e eVar) {
        if (eVar.a()) {
            c(eVar.f7832a);
        } else {
            a(eVar.f7833b);
        }
    }

    public final void c(@NonNull final Typeface typeface) {
        final g.c cVar = this.f7805a;
        this.f7806b.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.b(typeface);
            }
        });
    }
}
