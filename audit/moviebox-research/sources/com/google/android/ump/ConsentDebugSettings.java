package com.google.android.ump;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.consent_sdk.zzcl;
import com.google.android.gms.internal.consent_sdk.zzct;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ConsentDebugSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f38116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38117b;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f38119b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f38121d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f38118a = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38120c = 0;

        public Builder(@RecentlyNonNull Context context) {
            this.f38119b = context.getApplicationContext();
        }

        @RecentlyNonNull
        public Builder addTestDeviceHashedId(@RecentlyNonNull String str) {
            this.f38118a.add(str);
            return this;
        }

        @RecentlyNonNull
        public ConsentDebugSettings build() {
            boolean z11 = true;
            if (!zzct.zza(true) && !this.f38118a.contains(zzcl.zza(this.f38119b)) && !this.f38121d) {
                z11 = false;
            }
            return new ConsentDebugSettings(z11, this, null);
        }

        @RecentlyNonNull
        public Builder setDebugGeography(int i11) {
            this.f38120c = i11;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setForceTesting(boolean z11) {
            this.f38121d = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    public /* synthetic */ ConsentDebugSettings(boolean z11, Builder builder, zza zzaVar) {
        this.f38116a = z11;
        this.f38117b = builder.f38120c;
    }

    public int getDebugGeography() {
        return this.f38117b;
    }

    public boolean isTestDevice() {
        return this.f38116a;
    }
}
