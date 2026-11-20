package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.browser.trusted.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0034a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parcelable[] f1870a;

        public C0034a(Parcelable[] parcelableArr) {
            this.f1870a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f1870a);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1872b;

        public b(String str, int i11) {
            this.f1871a = str;
            this.f1872b = i11;
        }

        public static b a(Bundle bundle) {
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1873a;

        public c(String str) {
            this.f1873a = str;
        }

        public static c a(Bundle bundle) {
            a.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Notification f1876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f1877d;

        public d(String str, int i11, Notification notification, String str2) {
            this.f1874a = str;
            this.f1875b = i11;
            this.f1876c = notification;
            this.f1877d = str2;
        }

        public static d a(Bundle bundle) {
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            a.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            a.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1878a;

        public e(boolean z11) {
            this.f1878a = z11;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f1878a);
            return bundle;
        }
    }

    public static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}
