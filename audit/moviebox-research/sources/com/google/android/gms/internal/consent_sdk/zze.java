package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zze {
    private final Executor zza;

    public zze(Executor executor) {
        this.zza = executor;
    }

    public final Executor zza() {
        return this.zza;
    }

    public final void zzb(@Nullable final String str, @Nullable final String str2, final zzd... zzdVarArr) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzc
            @Override // java.lang.Runnable
            public final void run() {
                final JSONObject jSONObject;
                String str3 = str;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                String str4 = str2;
                final String lowerCase = str3.toLowerCase();
                if (TextUtils.isEmpty(str4)) {
                    jSONObject = new JSONObject();
                } else {
                    try {
                        jSONObject = new JSONObject(str4);
                    } catch (JSONException unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Action[");
                        sb2.append(lowerCase);
                        sb2.append("]: failed to parse args: ");
                        sb2.append(str4);
                        return;
                    }
                }
                zzd[] zzdVarArr2 = zzdVarArr;
                String string = jSONObject.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Action[");
                sb3.append(lowerCase);
                sb3.append("]: ");
                sb3.append(string);
                for (final zzd zzdVar : zzdVarArr2) {
                    FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.android.gms.internal.consent_sdk.zzb
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return Boolean.valueOf(zzdVar.zzb(lowerCase, jSONObject));
                        }
                    });
                    zzdVar.zza().execute(futureTask);
                    try {
                        if (((Boolean) futureTask.get()).booleanValue()) {
                            return;
                        }
                    } catch (InterruptedException unused2) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Thread interrupted for Action[");
                        sb4.append(lowerCase);
                        sb4.append("]: ");
                    } catch (ExecutionException e11) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Failed to run Action[");
                        sb5.append(lowerCase);
                        sb5.append("]: ");
                        e11.getCause();
                    }
                }
            }
        });
    }
}
