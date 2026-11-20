package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final z0.a f1861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final PendingIntent f1862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final c f1863c;

    /* JADX INFO: compiled from: source.java */
    public class a extends c {
        public a() {
        }

        @Override // androidx.browser.customtabs.c
        public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
            try {
                k.this.f1861a.s(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        @NonNull
        public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
            try {
                return k.this.f1861a.h(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                return null;
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onActivityResized(int i11, int i12, @NonNull Bundle bundle) {
            try {
                k.this.f1861a.M(i11, i12, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onMessageChannelReady(@Nullable Bundle bundle) {
            try {
                k.this.f1861a.Y(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onNavigationEvent(int i11, @Nullable Bundle bundle) {
            try {
                k.this.f1861a.S(i11, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
            try {
                k.this.f1861a.X(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onRelationshipValidationResult(int i11, @NonNull Uri uri, boolean z11, @Nullable Bundle bundle) {
            try {
                k.this.f1861a.a0(i11, uri, z11, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    public k(@Nullable z0.a aVar, @Nullable PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f1861a = aVar;
        this.f1862b = pendingIntent;
        this.f1863c = aVar == null ? null : new a();
    }

    @Nullable
    public IBinder a() {
        z0.a aVar = this.f1861a;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    public final IBinder b() {
        z0.a aVar = this.f1861a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    @Nullable
    public PendingIntent c() {
        return this.f1862b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        PendingIntent pendingIntentC = kVar.c();
        PendingIntent pendingIntent = this.f1862b;
        if ((pendingIntent == null) != (pendingIntentC == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(pendingIntentC) : b().equals(kVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f1862b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
