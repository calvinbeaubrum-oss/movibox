package com.google.android.ump;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ConsentRequestParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f38122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f38123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ConsentDebugSettings f38124c;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f38126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public ConsentDebugSettings f38127c;

        @RecentlyNonNull
        public ConsentRequestParameters build() {
            return new ConsentRequestParameters(this, null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdMobAppId(@Nullable String str) {
            this.f38126b = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setConsentDebugSettings(@Nullable ConsentDebugSettings consentDebugSettings) {
            this.f38127c = consentDebugSettings;
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForUnderAgeOfConsent(boolean z11) {
            this.f38125a = z11;
            return this;
        }
    }

    public /* synthetic */ ConsentRequestParameters(Builder builder, zzb zzbVar) {
        this.f38122a = builder.f38125a;
        this.f38123b = builder.f38126b;
        this.f38124c = builder.f38127c;
    }

    @RecentlyNullable
    public ConsentDebugSettings getConsentDebugSettings() {
        return this.f38124c;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.f38122a;
    }

    @RecentlyNullable
    public final String zza() {
        return this.f38123b;
    }
}
