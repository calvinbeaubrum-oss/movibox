package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Intent f1830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Bundle f1831b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(api = 24)
    public static class a {
        @Nullable
        public static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public ArrayList<Bundle> f1834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Bundle f1835d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public ArrayList<Bundle> f1836e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public SparseArray<Bundle> f1837f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public Bundle f1838g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f1832a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.browser.customtabs.b.a f1833b = new androidx.browser.customtabs.b.a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1839h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1840i = true;

        public b() {
        }

        public b(@Nullable j jVar) {
            if (jVar != null) {
                g(jVar);
            }
        }

        @NonNull
        public d a() {
            if (!this.f1832a.hasExtra("android.support.customtabs.extra.SESSION")) {
                h(null, null);
            }
            ArrayList<Bundle> arrayList = this.f1834c;
            if (arrayList != null) {
                this.f1832a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1836e;
            if (arrayList2 != null) {
                this.f1832a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1832a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1840i);
            this.f1832a.putExtras(this.f1833b.a().a());
            Bundle bundle = this.f1838g;
            if (bundle != null) {
                this.f1832a.putExtras(bundle);
            }
            if (this.f1837f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f1837f);
                this.f1832a.putExtras(bundle2);
            }
            this.f1832a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f1839h);
            if (Build.VERSION.SDK_INT >= 24) {
                c();
            }
            return new d(this.f1832a, this.f1835d);
        }

        @NonNull
        public b b(int i11, @NonNull androidx.browser.customtabs.b bVar) {
            if (i11 < 0 || i11 > 2 || i11 == 0) {
                throw new IllegalArgumentException("Invalid colorScheme: " + i11);
            }
            if (this.f1837f == null) {
                this.f1837f = new SparseArray<>();
            }
            this.f1837f.put(i11, bVar.a());
            return this;
        }

        @RequiresApi(api = 24)
        public final void c() {
            String strA = a.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f1832a.hasExtra("com.android.browser.headers") ? this.f1832a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f1832a.putExtra("com.android.browser.headers", bundleExtra);
        }

        @NonNull
        public b d(@NonNull androidx.browser.customtabs.b bVar) {
            this.f1838g = bVar.a();
            return this;
        }

        @NonNull
        public b e(@NonNull Context context, int i11, int i12) {
            this.f1832a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", androidx.core.app.b.a(context, i11, i12).b());
            return this;
        }

        @NonNull
        public b f(boolean z11) {
            this.f1840i = z11;
            return this;
        }

        @NonNull
        public b g(@NonNull j jVar) {
            this.f1832a.setPackage(jVar.f().getPackageName());
            h(jVar.e(), jVar.g());
            return this;
        }

        public final void h(@Nullable IBinder iBinder, @Nullable PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            androidx.core.app.e.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f1832a.putExtras(bundle);
        }

        @NonNull
        public b i(int i11) {
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.f1839h = i11;
            if (i11 == 1) {
                this.f1832a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            } else if (i11 == 2) {
                this.f1832a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
            } else {
                this.f1832a.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
            }
            return this;
        }

        @NonNull
        public b j(boolean z11) {
            this.f1832a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z11 ? 1 : 0);
            return this;
        }

        @NonNull
        public b k(@NonNull Context context, int i11, int i12) {
            this.f1835d = androidx.core.app.b.a(context, i11, i12).b();
            return this;
        }

        @NonNull
        public b l(boolean z11) {
            this.f1832a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", z11);
            return this;
        }
    }

    public d(@NonNull Intent intent, @Nullable Bundle bundle) {
        this.f1830a = intent;
        this.f1831b = bundle;
    }

    public void a(@NonNull Context context, @NonNull Uri uri) {
        this.f1830a.setData(uri);
        z2.a.startActivity(context, this.f1830a, this.f1831b);
    }
}
