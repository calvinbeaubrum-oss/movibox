package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.f0;
import com.google.firebase.crashlytics.internal.common.l;
import com.google.firebase.crashlytics.internal.common.m;
import com.google.firebase.crashlytics.internal.common.o;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import nk.f;
import ok.b;
import ok.c;
import ok.d;
import ok.e;
import ok.g;
import ok.h;
import ok.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f40575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f40576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f40577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ok.a f40578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f40579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f40580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<d> f40581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference<TaskCompletionSource<d>> f40582i;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.settings.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0442a implements SuccessContinuation<Void, Void> {
        public C0442a() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> then(@Nullable Void r11) throws Exception {
            JSONObject jSONObjectA = a.this.f40579f.a(a.this.f40575b, true);
            if (jSONObjectA != null) {
                d dVarB = a.this.f40576c.b(jSONObjectA);
                a.this.f40578e.c(dVarB.f72458c, jSONObjectA);
                a.this.q(jSONObjectA, "Loaded settings: ");
                a aVar = a.this;
                aVar.r(aVar.f40575b.f72474f);
                a.this.f40581h.set(dVarB);
                ((TaskCompletionSource) a.this.f40582i.get()).trySetResult(dVarB);
            }
            return Tasks.forResult(null);
        }
    }

    public a(Context context, h hVar, l lVar, e eVar, ok.a aVar, i iVar, m mVar) {
        AtomicReference<d> atomicReference = new AtomicReference<>();
        this.f40581h = atomicReference;
        this.f40582i = new AtomicReference<>(new TaskCompletionSource());
        this.f40574a = context;
        this.f40575b = hVar;
        this.f40577d = lVar;
        this.f40576c = eVar;
        this.f40578e = aVar;
        this.f40579f = iVar;
        this.f40580g = mVar;
        atomicReference.set(b.b(lVar));
    }

    public static a l(Context context, String str, o oVar, mk.b bVar, String str2, String str3, f fVar, m mVar) {
        String strG = oVar.g();
        f0 f0Var = new f0();
        return new a(context, new h(str, oVar.h(), oVar.i(), oVar.j(), oVar, CommonUtils.h(CommonUtils.n(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(strG).getId()), f0Var, new e(f0Var), new ok.a(fVar), new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), mVar);
    }

    @Override // ok.g
    public Task<d> a() {
        return this.f40582i.get().getTask();
    }

    @Override // ok.g
    public d b() {
        return this.f40581h.get();
    }

    public boolean k() {
        return !n().equals(this.f40575b.f72474f);
    }

    public final d m(SettingsCacheBehavior settingsCacheBehavior) throws Throwable {
        d dVar = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject jSONObjectB = this.f40578e.b();
                if (jSONObjectB != null) {
                    d dVarB = this.f40576c.b(jSONObjectB);
                    if (dVarB != null) {
                        q(jSONObjectB, "Loaded cached settings: ");
                        long jA = this.f40577d.a();
                        if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !dVarB.a(jA)) {
                            try {
                                gk.f.f().i("Returning cached settings.");
                                dVar = dVarB;
                            } catch (Exception e11) {
                                e = e11;
                                dVar = dVarB;
                                gk.f.f().e("Failed to get cached settings", e);
                            }
                        } else {
                            gk.f.f().i("Cached settings have expired.");
                        }
                    } else {
                        gk.f.f().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    gk.f.f().b("No cached settings data found.");
                }
            }
        } catch (Exception e12) {
            e = e12;
        }
        return dVar;
    }

    public final String n() {
        return CommonUtils.r(this.f40574a).getString("existing_instance_identifier", "");
    }

    public Task<Void> o(SettingsCacheBehavior settingsCacheBehavior, Executor executor) throws Throwable {
        d dVarM;
        if (!k() && (dVarM = m(settingsCacheBehavior)) != null) {
            this.f40581h.set(dVarM);
            this.f40582i.get().trySetResult(dVarM);
            return Tasks.forResult(null);
        }
        d dVarM2 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (dVarM2 != null) {
            this.f40581h.set(dVarM2);
            this.f40582i.get().trySetResult(dVarM2);
        }
        return this.f40580g.j(executor).onSuccessTask(executor, new C0442a());
    }

    public Task<Void> p(Executor executor) {
        return o(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public final void q(JSONObject jSONObject, String str) throws JSONException {
        gk.f.f().b(str + jSONObject.toString());
    }

    @SuppressLint({"CommitPrefEdits"})
    public final boolean r(String str) {
        SharedPreferences.Editor editorEdit = CommonUtils.r(this.f40574a).edit();
        editorEdit.putString("existing_instance_identifier", str);
        editorEdit.apply();
        return true;
    }
}
