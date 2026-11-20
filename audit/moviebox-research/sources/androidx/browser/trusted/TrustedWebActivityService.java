package androidx.browser.trusted;

import a1.b;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationManagerCompat;
import java.util.Locale;
import k1.i;
import k1.j;
import k1.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TrustedWebActivityService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f1866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1867b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b.a f1868c = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends b.a {
        public a() {
        }

        @Override // a1.b
        public Bundle D() {
            e0();
            return new androidx.browser.trusted.a.C0034a(TrustedWebActivityService.this.g()).a();
        }

        @Override // a1.b
        public int N() {
            e0();
            return TrustedWebActivityService.this.i();
        }

        @Override // a1.b
        public Bundle O(Bundle bundle) {
            e0();
            return new androidx.browser.trusted.a.e(TrustedWebActivityService.this.d(androidx.browser.trusted.a.c.a(bundle).f1873a)).a();
        }

        @Override // a1.b
        public void R(Bundle bundle) {
            e0();
            androidx.browser.trusted.a.b bVarA = androidx.browser.trusted.a.b.a(bundle);
            TrustedWebActivityService.this.e(bVarA.f1871a, bVarA.f1872b);
        }

        public final void e0() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int i11 = trustedWebActivityService.f1867b;
            if (i11 != -1) {
                if (i11 != Binder.getCallingUid()) {
                    throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
                }
            } else {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                TrustedWebActivityService.this.c();
                throw null;
            }
        }

        @Override // a1.b
        public Bundle l(String str, Bundle bundle, IBinder iBinder) {
            e0();
            return TrustedWebActivityService.this.f(str, bundle, k.a(iBinder));
        }

        @Override // a1.b
        public Bundle o() {
            e0();
            return TrustedWebActivityService.this.h();
        }

        @Override // a1.b
        @RequiresPermission("android.permission.POST_NOTIFICATIONS")
        public Bundle t(Bundle bundle) {
            e0();
            androidx.browser.trusted.a.d dVarA = androidx.browser.trusted.a.d.a(bundle);
            return new androidx.browser.trusted.a.e(TrustedWebActivityService.this.j(dVarA.f1874a, dVarA.f1875b, dVarA.f1876c, dVarA.f1877d)).a();
        }
    }

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public final void b() {
        if (this.f1866a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    @NonNull
    public abstract j c();

    public boolean d(@NonNull String str) {
        b();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return i.b(this.f1866a, a(str));
    }

    public void e(@NonNull String str, int i11) {
        b();
        this.f1866a.cancel(str, i11);
    }

    @Nullable
    public Bundle f(@NonNull String str, @NonNull Bundle bundle, @Nullable k kVar) {
        return null;
    }

    @NonNull
    public Parcelable[] g() {
        b();
        if (Build.VERSION.SDK_INT >= 23) {
            return k1.b.a(this.f1866a);
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    @NonNull
    public Bundle h() {
        int i11 = i();
        Bundle bundle = new Bundle();
        if (i11 == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i11));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public boolean j(@NonNull String str, int i11, @NonNull Notification notification, @NonNull String str2) {
        b();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String strA = a(str2);
            notification = i.a(this, this.f1866a, notification, strA, str2);
            if (!i.b(this.f1866a, strA)) {
                return false;
            }
        }
        this.f1866a.notify(str, i11, notification);
        return true;
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(@Nullable Intent intent) {
        return this.f1868c;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.f1866a = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public final boolean onUnbind(@Nullable Intent intent) {
        this.f1867b = -1;
        return super.onUnbind(intent);
    }
}
