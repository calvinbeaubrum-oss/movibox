package com.vungle.warren.utility.platform;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.model.d;
import com.vungle.warren.model.j;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.u;
import com.vungle.warren.utility.w;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AndroidPlatform implements com.vungle.warren.utility.platform.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PowerManager f62626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f62627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Repository f62628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f62629d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f62631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f62632g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f62634i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f62630e = AndroidPlatform.class.getSimpleName();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f62633h = null;

    /* JADX INFO: compiled from: source.java */
    public class a implements OnSuccessListener<AppSetIdInfo> {
        public a() {
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NonNull AppSetIdInfo appSetIdInfo) {
            if (appSetIdInfo != null) {
                AndroidPlatform.this.f62632g = appSetIdInfo.getId();
                if (TextUtils.isEmpty(AndroidPlatform.this.f62632g)) {
                    return;
                }
                j jVar = new j("appSetIdCookie");
                jVar.e("appSetId", AndroidPlatform.this.f62632g);
                AndroidPlatform.this.f62628c.j0(jVar, null, false);
            }
        }
    }

    public AndroidPlatform(Context context, Repository repository, w wVar, u uVar) {
        this.f62627b = context;
        this.f62626a = (PowerManager) context.getSystemService("power");
        this.f62628c = repository;
        this.f62629d = wVar;
        this.f62631f = uVar;
        q();
    }

    @Override // com.vungle.warren.utility.platform.a
    @Nullable
    public String a() {
        j jVar = (j) this.f62628c.T("userAgent", j.class).get();
        if (jVar == null) {
            return System.getProperty("http.agent");
        }
        String strD = jVar.d("userAgent");
        return TextUtils.isEmpty(strD) ? System.getProperty("http.agent") : strD;
    }

    @Override // com.vungle.warren.utility.platform.a
    @NonNull
    @SuppressLint({"HardwareIds", "NewApi"})
    public d b() {
        d dVar = this.f62633h;
        if (dVar != null && !TextUtils.isEmpty(dVar.f62162a)) {
            return this.f62633h;
        }
        this.f62633h = new d();
        try {
            if ("Amazon".equals(Build.MANUFACTURER)) {
                try {
                    ContentResolver contentResolver = this.f62627b.getContentResolver();
                    d dVar2 = this.f62633h;
                    boolean z11 = true;
                    if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                        z11 = false;
                    }
                    dVar2.f62163b = z11;
                    this.f62633h.f62162a = Settings.Secure.getString(contentResolver, "advertising_id");
                } catch (Settings.SettingNotFoundException e11) {
                    Log.w(this.f62630e, "Error getting Amazon advertising info", e11);
                }
            } else {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f62627b);
                    if (advertisingIdInfo != null) {
                        this.f62633h.f62162a = advertisingIdInfo.getId();
                        this.f62633h.f62163b = advertisingIdInfo.isLimitAdTrackingEnabled();
                    }
                } catch (GooglePlayServicesNotAvailableException e12) {
                    Log.e(this.f62630e, "Play services Not available: " + e12.getLocalizedMessage());
                } catch (NoClassDefFoundError e13) {
                    Log.e(this.f62630e, "Play services Not available: " + e13.getLocalizedMessage());
                    this.f62633h.f62162a = Settings.Secure.getString(this.f62627b.getContentResolver(), "advertising_id");
                }
            }
        } catch (Exception unused) {
            Log.e(this.f62630e, "Cannot load Advertising ID");
        }
        return this.f62633h;
    }

    @Override // com.vungle.warren.utility.platform.a
    public void c(boolean z11) {
        this.f62634i = z11;
    }

    @Override // com.vungle.warren.utility.platform.a
    public String d() {
        if (TextUtils.isEmpty(this.f62632g)) {
            j jVar = (j) this.f62628c.T("appSetIdCookie", j.class).get(this.f62631f.a(), TimeUnit.MILLISECONDS);
            this.f62632g = jVar != null ? jVar.d("appSetId") : null;
        }
        return this.f62632g;
    }

    @Override // com.vungle.warren.utility.platform.a
    public double e() {
        AudioManager audioManager = (AudioManager) this.f62627b.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return ((double) audioManager.getStreamVolume(3)) / ((double) audioManager.getStreamMaxVolume(3));
    }

    @Override // com.vungle.warren.utility.platform.a
    public boolean f() {
        return this.f62626a.isPowerSaveMode();
    }

    @Override // com.vungle.warren.utility.platform.a
    public boolean g() {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                return Settings.Secure.getInt(this.f62627b.getContentResolver(), "install_non_market_apps") == 1;
            } catch (Settings.SettingNotFoundException unused) {
                return false;
            }
        }
        if (this.f62627b.checkCallingOrSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") == 0) {
            return this.f62627b.getApplicationContext().getPackageManager().canRequestPackageInstalls();
        }
        return false;
    }

    @Override // com.vungle.warren.utility.platform.a
    public String h() {
        return this.f62634i ? "" : Settings.Secure.getString(this.f62627b.getContentResolver(), "android_id");
    }

    @Override // com.vungle.warren.utility.platform.a
    public boolean i() {
        return true;
    }

    @Override // com.vungle.warren.utility.platform.a
    public void j(final androidx.core.util.a<String> aVar) {
        this.f62629d.execute(new Runnable() { // from class: com.vungle.warren.utility.platform.AndroidPlatform.1
            @Override // java.lang.Runnable
            public void run() {
                new b(AndroidPlatform.this.f62627b, AndroidPlatform.this.f62628c).b(aVar);
            }
        });
    }

    @Override // com.vungle.warren.utility.platform.a
    public boolean k() {
        return ((AudioManager) this.f62627b.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3) > 0;
    }

    @Override // com.vungle.warren.utility.platform.a
    public boolean l() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public final void q() {
        try {
            AppSet.getClient(this.f62627b).getAppSetIdInfo().addOnSuccessListener(new a());
        } catch (NoClassDefFoundError e11) {
            Log.e(this.f62630e, "Required libs to get AppSetID Not available: " + e11.getLocalizedMessage());
        }
    }
}
