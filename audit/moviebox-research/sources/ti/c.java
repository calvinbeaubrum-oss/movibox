package ti;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final d f77201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ti.b f77202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f77203c;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(33)
    public static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public OnBackInvokedCallback f77204a;

        public b() {
        }

        @Override // ti.c.d
        public void a(@NonNull View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f77204a);
            this.f77204a = null;
        }

        @Override // ti.c.d
        public void b(@NonNull ti.b bVar, @NonNull View view, boolean z11) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f77204a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(bVar);
                this.f77204a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z11 ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        public OnBackInvokedCallback c(@NonNull final ti.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: ti.e
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    bVar.handleBackInvoked();
                }
            };
        }

        public boolean d() {
            return this.f77204a != null;
        }
    }

    /* JADX INFO: renamed from: ti.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(34)
    public static class C0854c extends b {

        /* JADX INFO: renamed from: ti.c$c$a */
        /* JADX INFO: compiled from: source.java */
        public class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ti.b f77205a;

            public a(ti.b bVar) {
                this.f77205a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (C0854c.this.d()) {
                    this.f77205a.cancelBackProgress();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f77205a.handleBackInvoked();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(@NonNull BackEvent backEvent) {
                if (C0854c.this.d()) {
                    this.f77205a.updateBackProgress(new androidx.activity.b(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(@NonNull BackEvent backEvent) {
                if (C0854c.this.d()) {
                    this.f77205a.startBackProgress(new androidx.activity.b(backEvent));
                }
            }
        }

        public C0854c() {
            super();
        }

        @Override // ti.c.b
        public OnBackInvokedCallback c(@NonNull ti.b bVar) {
            return new a(bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(@NonNull View view);

        void b(@NonNull ti.b bVar, @NonNull View view, boolean z11);
    }

    public <T extends View & ti.b> c(@NonNull T t11) {
        this(t11, t11);
    }

    public c(@NonNull ti.b bVar, @NonNull View view) {
        this.f77201a = a();
        this.f77202b = bVar;
        this.f77203c = view;
    }

    @Nullable
    public static d a() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            return new C0854c();
        }
        if (i11 >= 33) {
            return new b();
        }
        return null;
    }

    public boolean b() {
        return this.f77201a != null;
    }

    public void c() {
        d(false);
    }

    public final void d(boolean z11) {
        d dVar = this.f77201a;
        if (dVar != null) {
            dVar.b(this.f77202b, this.f77203c, z11);
        }
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.f77201a;
        if (dVar != null) {
            dVar.a(this.f77203c);
        }
    }
}
