package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v0;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomTabsService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<IBinder, IBinder.DeathRecipient> f1817a = new v0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z0.b.a f1818b = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends z0.b.a {
        public a() {
        }

        @Override // z0.b
        public boolean B(@NonNull z0.a aVar, @NonNull Uri uri) {
            return CustomTabsService.this.i(new k(aVar, null), uri, null, new Bundle());
        }

        @Override // z0.b
        public boolean C(@NonNull z0.a aVar, @NonNull Uri uri, int i11, @Nullable Bundle bundle) {
            return CustomTabsService.this.g(new k(aVar, g0(bundle)), uri, i11, bundle);
        }

        @Override // z0.b
        public boolean K(long j11) {
            return CustomTabsService.this.m(j11);
        }

        @Override // z0.b
        public int P(@NonNull z0.a aVar, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.f(new k(aVar, g0(bundle)), str, bundle);
        }

        @Override // z0.b
        public boolean a(z0.a aVar, @NonNull Bundle bundle) {
            return CustomTabsService.this.c(new k(aVar, g0(bundle)), bundle);
        }

        @Override // z0.b
        public boolean d(@NonNull z0.a aVar) {
            return j0(aVar, null);
        }

        @Override // z0.b
        public boolean d0(@NonNull z0.a aVar, @Nullable Bundle bundle) {
            return j0(aVar, g0(bundle));
        }

        @Override // z0.b
        public boolean e(@Nullable z0.a aVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.d(new k(aVar, g0(bundle)), uri, bundle, list);
        }

        @Nullable
        public final PendingIntent g0(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        @Nullable
        public final Uri h0(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 33 ? (Uri) androidx.browser.customtabs.a.a(bundle, "target_origin", Uri.class) : (Uri) bundle.getParcelable("target_origin");
        }

        @Override // z0.b
        public Bundle i(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        public final /* synthetic */ void i0(k kVar) {
            CustomTabsService.this.a(kVar);
        }

        @Override // z0.b
        public boolean j(@NonNull z0.a aVar, @Nullable Bundle bundle) {
            return CustomTabsService.this.k(new k(aVar, g0(bundle)), bundle);
        }

        public final boolean j0(@NonNull z0.a aVar, @Nullable PendingIntent pendingIntent) {
            final k kVar = new k(aVar, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.e
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.f1841a.i0(kVar);
                    }
                };
                synchronized (CustomTabsService.this.f1817a) {
                    aVar.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f1817a.put(aVar.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.e(kVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // z0.b
        public boolean q(@NonNull z0.a aVar, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.i(new k(aVar, g0(bundle)), uri, h0(bundle), bundle);
        }

        @Override // z0.b
        public boolean w(@NonNull z0.a aVar, int i11, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.l(new k(aVar, g0(bundle)), i11, uri, bundle);
        }

        @Override // z0.b
        public boolean z(@NonNull z0.a aVar, @NonNull IBinder iBinder, @NonNull Bundle bundle) {
            return CustomTabsService.this.j(new k(aVar, g0(bundle)), m.a(iBinder), bundle);
        }
    }

    public boolean a(@NonNull k kVar) {
        try {
            synchronized (this.f1817a) {
                try {
                    IBinder iBinderA = kVar.a();
                    if (iBinderA == null) {
                        return false;
                    }
                    iBinderA.unlinkToDeath(this.f1817a.get(iBinderA), 0);
                    this.f1817a.remove(iBinderA);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    @Nullable
    public abstract Bundle b(@NonNull String str, @Nullable Bundle bundle);

    public boolean c(@NonNull k kVar, @NonNull Bundle bundle) {
        return false;
    }

    public abstract boolean d(@NonNull k kVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list);

    public abstract boolean e(@NonNull k kVar);

    public abstract int f(@NonNull k kVar, @NonNull String str, @Nullable Bundle bundle);

    public abstract boolean g(@NonNull k kVar, @NonNull Uri uri, int i11, @Nullable Bundle bundle);

    public abstract boolean h(@NonNull k kVar, @NonNull Uri uri);

    public boolean i(@NonNull k kVar, @NonNull Uri uri, @Nullable Uri uri2, @NonNull Bundle bundle) {
        return h(kVar, uri);
    }

    public boolean j(@NonNull k kVar, @NonNull l lVar, @NonNull Bundle bundle) {
        return false;
    }

    public abstract boolean k(@NonNull k kVar, @Nullable Bundle bundle);

    public abstract boolean l(@NonNull k kVar, int i11, @NonNull Uri uri, @Nullable Bundle bundle);

    public abstract boolean m(long j11);

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.f1818b;
    }
}
