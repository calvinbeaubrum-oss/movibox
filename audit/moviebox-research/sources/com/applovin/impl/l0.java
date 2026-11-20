package com.applovin.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f20298a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f20299b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Collection f20300c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f20301d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f20302e = null;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f20303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f20304b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private EnumC0184a f20305c = EnumC0184a.NOT_SET;

        /* JADX INFO: renamed from: com.applovin.impl.l0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public enum EnumC0184a {
            NOT_SET("dnt_not_set"),
            ON("dnt_on"),
            OFF("dnt_off");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f20310a;

            EnumC0184a(String str) {
                this.f20310a = str;
            }

            public String b() {
                return this.f20310a;
            }
        }

        public String a() {
            return this.f20304b;
        }

        public void a(EnumC0184a enumC0184a) {
            this.f20305c = enumC0184a;
        }

        public void a(String str) {
            this.f20304b = str;
        }

        public void a(boolean z11) {
            this.f20303a = z11;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public EnumC0184a b() {
            return this.f20305c;
        }

        public boolean c() {
            return this.f20303a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this) || c() != aVar.c()) {
                return false;
            }
            String strA = a();
            String strA2 = aVar.a();
            if (strA != null ? !strA.equals(strA2) : strA2 != null) {
                return false;
            }
            EnumC0184a enumC0184aB = b();
            EnumC0184a enumC0184aB2 = aVar.b();
            return enumC0184aB != null ? enumC0184aB.equals(enumC0184aB2) : enumC0184aB2 == null;
        }

        public int hashCode() {
            int i11 = c() ? 79 : 97;
            String strA = a();
            int iHashCode = ((i11 + 59) * 59) + (strA == null ? 43 : strA.hashCode());
            EnumC0184a enumC0184aB = b();
            return (iHashCode * 59) + (enumC0184aB != null ? enumC0184aB.hashCode() : 43);
        }

        public String toString() {
            return "AdvertisingInfoCollector.AdvertisingIdInformation(adTrackingLimited=" + c() + ", advertisingId=" + a() + ", dntCode=" + b() + ")";
        }
    }

    private static a a(Context context) {
        a aVar;
        HashSet hashSet;
        yp.a();
        Object obj = f20299b;
        synchronized (obj) {
            try {
                if (f20301d) {
                    return f20302e;
                }
                Collection collection = f20300c;
                boolean zIsEmpty = collection.isEmpty();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                collection.add(countDownLatch);
                if (zIsEmpty) {
                    a aVarC = c(context);
                    synchronized (obj) {
                        f20301d = true;
                        f20302e = aVarC;
                        hashSet = new HashSet(collection);
                        collection.clear();
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        ((CountDownLatch) it.next()).countDown();
                    }
                }
                try {
                    if (!countDownLatch.await(60L, TimeUnit.SECONDS)) {
                        com.applovin.impl.sdk.n.h("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout");
                    }
                } catch (InterruptedException e11) {
                    com.applovin.impl.sdk.n.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e11);
                }
                synchronized (f20299b) {
                    aVar = f20302e;
                }
                return aVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean a() {
        return yp.a("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    public static a b(Context context) {
        return a(context);
    }

    private static a c(Context context) {
        a aVarCollectGoogleAdvertisingInfo = collectGoogleAdvertisingInfo(context);
        if (aVarCollectGoogleAdvertisingInfo == null) {
            aVarCollectGoogleAdvertisingInfo = collectFireOSAdvertisingInfo(context);
        }
        return aVarCollectGoogleAdvertisingInfo == null ? new a() : aVarCollectGoogleAdvertisingInfo;
    }

    @Nullable
    private static a collectFireOSAdvertisingInfo(Context context) {
        if (f20298a) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                a aVar = new a();
                aVar.a(StringUtils.emptyIfNull(Settings.Secure.getString(contentResolver, "advertising_id")));
                boolean z11 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                aVar.a(z11);
                aVar.a(z11 ? a.EnumC0184a.ON : a.EnumC0184a.OFF);
                return aVar;
            } catch (Settings.SettingNotFoundException e11) {
                com.applovin.impl.sdk.n.c("DataCollector", "Unable to determine if Fire OS limited ad tracking is turned on", e11);
            } catch (Throwable th2) {
                com.applovin.impl.sdk.n.c("DataCollector", "Unable to collect Fire OS IDFA", th2);
            }
        }
        f20298a = false;
        return null;
    }

    @Nullable
    private static a collectGoogleAdvertisingInfo(Context context) {
        yp.a();
        if (!a()) {
            if (AppLovinSdkUtils.isFireOS(context)) {
                return null;
            }
            com.applovin.impl.sdk.n.h("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return null;
        }
        try {
            a aVar = new a();
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
            aVar.a(zIsLimitAdTrackingEnabled);
            aVar.a(zIsLimitAdTrackingEnabled ? a.EnumC0184a.ON : a.EnumC0184a.OFF);
            aVar.a(advertisingIdInfo.getId());
            return aVar;
        } catch (Throwable th2) {
            if (AppLovinSdkUtils.isFireOS(context)) {
                return null;
            }
            com.applovin.impl.sdk.n.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th2);
            return null;
        }
    }
}
