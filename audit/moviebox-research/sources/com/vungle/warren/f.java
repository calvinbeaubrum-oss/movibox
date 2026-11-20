package com.vungle.warren;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.gson.Gson;
import com.vungle.warren.persistence.Repository;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Repository f62012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.vungle.warren.utility.u f62013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f62014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.vungle.warren.utility.platform.a f62015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t00.a f62016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.vungle.warren.model.j f62017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.vungle.warren.model.j f62018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f62019h;

    public f(Repository repository, com.vungle.warren.utility.u uVar, t00.a aVar, com.vungle.warren.utility.platform.a aVar2, Gson gson, com.vungle.warren.utility.p pVar) {
        this.f62014c = gson;
        this.f62013b = uVar;
        this.f62012a = repository;
        this.f62016e = aVar;
        this.f62015d = aVar2;
        PrivacyManager.d().e(pVar.j(), repository);
    }

    public static int e(int i11, String str, String str2) {
        return (int) Math.max(Math.round(((double) ((int) (((Math.floor(((i11 - str.getBytes().length) - ":".getBytes().length) / 4) * 3.0d) - ((double) ":".getBytes().length)) - ((double) str2.getBytes().length)))) / 4.0d) * 4, 0L);
    }

    public static String f(@Nullable com.vungle.warren.model.j jVar) {
        return (jVar != null && "opted_out".equals(jVar.d("ccpa_status"))) ? "opted_out" : "opted_in";
    }

    public final String a(String str, int i11, int i12) {
        String strB = b(str, i11, i12);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(strB.length());
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(strB.getBytes());
            gZIPOutputStream.close();
            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            byteArrayOutputStream.close();
            return "3:" + strEncodeToString;
        } catch (IOException unused) {
            return null;
        }
    }

    public final String b(String str, int i11, int i12) {
        if (this.f62018g == null) {
            this.f62018g = (com.vungle.warren.model.j) this.f62012a.T("ccpaIsImportantToVungle", com.vungle.warren.model.j.class).get(this.f62013b.a(), TimeUnit.MILLISECONDS);
        }
        u00.c cVar = new u00.c(new u00.b(f(this.f62018g)), i(), h());
        u00.f fVar = new u00.f(Boolean.valueOf(this.f62015d.g()), Boolean.valueOf(this.f62015d.l()), Boolean.valueOf(this.f62015d.k()));
        boolean zEquals = "Amazon".equals(Build.MANUFACTURER);
        String str2 = null;
        u00.a aVar = zEquals ? null : new u00.a();
        u00.a aVar2 = zEquals ? new u00.a() : null;
        if (PrivacyManager.d().f()) {
            str2 = this.f62015d.b().f62162a;
            String strH = TextUtils.isEmpty(str2) ? this.f62015d.h() : "";
            if (TextUtils.isEmpty(str2)) {
                str2 = strH;
            }
            if (!TextUtils.isEmpty(strH)) {
                if (zEquals) {
                    aVar2.f78116a = strH;
                } else {
                    aVar.f78116a = strH;
                }
            }
        }
        String str3 = str2;
        if (zEquals) {
            aVar2.f78117b = this.f62015d.d();
        } else {
            aVar.f78117b = this.f62015d.d();
        }
        return this.f62014c.toJson(new com.vungle.warren.model.g(new u00.e(Boolean.valueOf(this.f62015d.f()), this.f62016e.b(), this.f62016e.a(), Double.valueOf(this.f62015d.e()), str3, aVar2, aVar, fVar), new u00.h(g(), Integer.valueOf(i12), d(str, i11, i12), VungleApiClient.l()), cVar));
    }

    @Nullable
    public String c(String str, int i11, int i12) {
        return a(str, i11, i12);
    }

    public final List<String> d(@Nullable String str, int i11, int i12) {
        if (i11 <= 0) {
            i11 = 2147483646;
        }
        return this.f62012a.M(str, e(i11, "2", Integer.toString(i12)), ",".getBytes().length).get();
    }

    @NonNull
    public final String g() {
        com.vungle.warren.model.j jVar;
        if (TextUtils.isEmpty(this.f62019h) && (jVar = (com.vungle.warren.model.j) this.f62012a.T("config_extension", com.vungle.warren.model.j.class).get(this.f62013b.a(), TimeUnit.MILLISECONDS)) != null) {
            this.f62019h = jVar.d("config_extension");
        }
        return this.f62019h;
    }

    @Nullable
    public final u00.d h() {
        PrivacyManager.COPPA coppaC = PrivacyManager.d().c();
        if (coppaC == PrivacyManager.COPPA.COPPA_NOTSET) {
            return null;
        }
        return new u00.d(coppaC.getValue());
    }

    public final u00.g i() {
        com.vungle.warren.model.k kVar;
        if (this.f62017f == null) {
            kVar = new com.vungle.warren.model.k(this.f62012a, this.f62013b);
            if (!AppLovinMediationProvider.UNKNOWN.equals(kVar.b())) {
                this.f62017f = kVar.c();
            }
        } else {
            kVar = new com.vungle.warren.model.k(this.f62017f);
        }
        String strE = kVar.e();
        return new u00.g(kVar.b(), strE, kVar.d(), kVar.f());
    }

    public void j(com.vungle.warren.model.j jVar) {
        if (jVar != null) {
            this.f62018g = jVar;
        }
    }

    public void k(String str) {
        this.f62019h = str;
    }

    public void l(com.vungle.warren.model.j jVar) {
        if (jVar != null) {
            this.f62017f = jVar;
        }
    }
}
