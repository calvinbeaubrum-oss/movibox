package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1853a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0.b f1854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0.a f1855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ComponentName f1856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final PendingIntent f1857e;

    /* JADX INFO: compiled from: source.java */
    public class a extends z0.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f1858a = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f1859b;

        public a(l lVar) {
            this.f1859b = lVar;
        }

        @Override // z0.c
        public void onGreatestScrollPercentageIncreased(final int i11, final Bundle bundle) {
            Handler handler = this.f1858a;
            final l lVar = this.f1859b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.i
                @Override // java.lang.Runnable
                public final void run() {
                    lVar.onGreatestScrollPercentageIncreased(i11, bundle);
                }
            });
        }

        @Override // z0.c
        public void onSessionEnded(final boolean z11, final Bundle bundle) {
            Handler handler = this.f1858a;
            final l lVar = this.f1859b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.h
                @Override // java.lang.Runnable
                public final void run() {
                    lVar.onSessionEnded(z11, bundle);
                }
            });
        }

        @Override // z0.c
        public void onVerticalScrollEvent(final boolean z11, final Bundle bundle) {
            Handler handler = this.f1858a;
            final l lVar = this.f1859b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.g
                @Override // java.lang.Runnable
                public final void run() {
                    lVar.onVerticalScrollEvent(z11, bundle);
                }
            });
        }
    }

    public j(z0.b bVar, z0.a aVar, ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this.f1854b = bVar;
        this.f1855c = aVar;
        this.f1856d = componentName;
        this.f1857e = pendingIntent;
    }

    public final void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f1857e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    public final Bundle b(@Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    public final z0.c.a c(@NonNull l lVar) {
        return new a(lVar);
    }

    @Nullable
    public final Bundle d(@Nullable Uri uri) {
        Bundle bundle = new Bundle();
        if (uri != null) {
            bundle.putParcelable("target_origin", uri);
        }
        if (this.f1857e != null) {
            a(bundle);
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public IBinder e() {
        return this.f1855c.asBinder();
    }

    public ComponentName f() {
        return this.f1856d;
    }

    @Nullable
    public PendingIntent g() {
        return this.f1857e;
    }

    public boolean h(@NonNull Bundle bundle) throws RemoteException {
        try {
            return this.f1854b.a(this.f1855c, bundle);
        } catch (SecurityException e11) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e11);
        }
    }

    public boolean i(@Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
        try {
            return this.f1854b.e(this.f1855c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int j(@NonNull String str, @Nullable Bundle bundle) {
        int iP;
        Bundle bundleB = b(bundle);
        synchronized (this.f1853a) {
            try {
                try {
                    iP = this.f1854b.P(this.f1855c, str, bundleB);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iP;
    }

    public boolean k(@NonNull Uri uri) {
        return l(uri, null, new Bundle());
    }

    public boolean l(@NonNull Uri uri, @Nullable Uri uri2, @NonNull Bundle bundle) {
        try {
            Bundle bundleD = d(uri2);
            if (bundleD == null) {
                return this.f1854b.B(this.f1855c, uri);
            }
            bundle.putAll(bundleD);
            return this.f1854b.q(this.f1855c, uri, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean m(@NonNull l lVar, @NonNull Bundle bundle) throws RemoteException {
        try {
            return this.f1854b.z(this.f1855c, c(lVar).asBinder(), bundle);
        } catch (SecurityException e11) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e11);
        }
    }

    public boolean n(int i11, @NonNull Uri uri, @Nullable Bundle bundle) {
        if (i11 >= 1 && i11 <= 2) {
            try {
                return this.f1854b.w(this.f1855c, i11, uri, b(bundle));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }
}
