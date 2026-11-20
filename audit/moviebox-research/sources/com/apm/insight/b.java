package com.apm.insight;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ICrashCallback, IOOMCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOOMCallback f16601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICrashCallback f16602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16603c;

    public b(String str, ICrashCallback iCrashCallback) {
        this.f16603c = str;
        this.f16602b = iCrashCallback;
    }

    public b(String str, IOOMCallback iOOMCallback) {
        this.f16603c = str;
        this.f16601a = iOOMCallback;
    }

    public final void a(@NonNull CrashType crashType, @Nullable String str, @Nullable String str2, String str3) {
        d dVarA;
        if (this.f16602b == null || (dVarA = d.a(this.f16603c)) == null || !dVarA.a(str3, str2)) {
            return;
        }
        this.f16602b.onCrash(crashType, str, null);
    }

    public final void a(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread, JSONArray jSONArray) {
        if (this.f16602b == null || jSONArray == null) {
            return;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i11), "header", "aid"), this.f16603c)) {
                this.f16602b.onCrash(crashType, str, thread);
            }
        }
    }

    public final void a(@NonNull CrashType crashType, @Nullable Throwable th2, @Nullable Thread thread, long j11, JSONArray jSONArray) {
        if (this.f16601a == null || jSONArray == null) {
            return;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i11), "header", "aid"), this.f16603c)) {
                this.f16601a.onCrash(crashType, th2, thread, j11);
            }
        }
    }

    @Override // com.apm.insight.ICrashCallback
    public final void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
    }

    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(@NonNull CrashType crashType, @Nullable Throwable th2, @Nullable Thread thread, long j11) {
    }
}
