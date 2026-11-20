package com.google.android.ump;

import android.app.Activity;
import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface ConsentInformation {

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConsentStatus {
        public static final int NOT_REQUIRED = 1;
        public static final int OBTAINED = 3;
        public static final int REQUIRED = 2;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: source.java */
    public interface OnConsentInfoUpdateFailureListener {
        void onConsentInfoUpdateFailure(@RecentlyNonNull FormError formError);
    }

    /* JADX INFO: compiled from: source.java */
    public interface OnConsentInfoUpdateSuccessListener {
        void onConsentInfoUpdateSuccess();
    }

    /* JADX INFO: compiled from: source.java */
    public enum PrivacyOptionsRequirementStatus {
        UNKNOWN,
        NOT_REQUIRED,
        REQUIRED
    }

    boolean canRequestAds();

    int getConsentStatus();

    @RecentlyNonNull
    PrivacyOptionsRequirementStatus getPrivacyOptionsRequirementStatus();

    boolean isConsentFormAvailable();

    void requestConsentInfoUpdate(@RecentlyNonNull Activity activity, @RecentlyNonNull ConsentRequestParameters consentRequestParameters, @RecentlyNonNull OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, @RecentlyNonNull OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener);

    void reset();
}
