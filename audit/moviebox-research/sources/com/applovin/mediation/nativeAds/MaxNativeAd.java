package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.mediation.nativeAds.MaxNativeAdImpl;
import com.applovin.mediation.MaxAdFormat;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxNativeAd extends MaxNativeAdImpl {
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final MaxAdFormat format;
    private final MaxNativeAdImage icon;
    private final View iconView;
    private boolean isExpired;
    private final MaxNativeAdImage mainImage;
    private final float mediaContentAspectRatio;
    private final View mediaView;
    private MaxNativeAdView nativeAdView;
    private final View optionsView;
    private final Double starRating;
    private final String title;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MaxAdFormat f24966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f24967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f24968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f24969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f24970e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MaxNativeAdImage f24971f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View f24972g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View f24973h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private View f24974i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private MaxNativeAdImage f24975j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f24976k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Double f24977l;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f24966a = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.f24968c = str;
            return this;
        }

        public Builder setBody(String str) {
            this.f24969d = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f24970e = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f24971f = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f24972g = view;
            return this;
        }

        public Builder setMainImage(MaxNativeAdImage maxNativeAdImage) {
            this.f24975j = maxNativeAdImage;
            return this;
        }

        public Builder setMediaContentAspectRatio(float f11) {
            this.f24976k = f11;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f24974i = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f24973h = view;
            return this;
        }

        public Builder setStarRating(Double d11) {
            this.f24977l = d11;
            return this;
        }

        public Builder setTitle(String str) {
            this.f24967b = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class MaxNativeAdImage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f24978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f24979b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f24978a = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f24979b = uri;
        }

        @Nullable
        public Drawable getDrawable() {
            return this.f24978a;
        }

        @Nullable
        public Uri getUri() {
            return this.f24979b;
        }
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.f24966a;
        this.title = builder.f24967b;
        this.advertiser = builder.f24968c;
        this.body = builder.f24969d;
        this.callToAction = builder.f24970e;
        this.icon = builder.f24971f;
        this.iconView = builder.f24972g;
        this.optionsView = builder.f24973h;
        this.mediaView = builder.f24974i;
        this.mainImage = builder.f24975j;
        this.mediaContentAspectRatio = builder.f24976k;
        Double d11 = builder.f24977l;
        this.starRating = (d11 == null || d11.doubleValue() < 3.0d) ? null : d11;
    }

    @Nullable
    public final String getAdvertiser() {
        return this.advertiser;
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final String getCallToAction() {
        return this.callToAction;
    }

    @NonNull
    public final MaxAdFormat getFormat() {
        return this.format;
    }

    @Nullable
    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    @Nullable
    public final View getIconView() {
        return this.iconView;
    }

    @Nullable
    public final MaxNativeAdImage getMainImage() {
        return this.mainImage;
    }

    public final float getMediaContentAspectRatio() {
        return this.mediaContentAspectRatio;
    }

    @Nullable
    public final View getMediaView() {
        return this.mediaView;
    }

    @Nullable
    public final View getOptionsView() {
        return this.optionsView;
    }

    @Nullable
    public final Double getStarRating() {
        return this.starRating;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public boolean isContainerClickable() {
        return false;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public void performClick() {
        Button callToActionButton;
        MaxNativeAdView maxNativeAdView = this.nativeAdView;
        if (maxNativeAdView == null || (callToActionButton = maxNativeAdView.getCallToActionButton()) == null) {
            return;
        }
        callToActionButton.performClick();
    }

    public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
        return false;
    }

    @Deprecated
    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }

    public void setExpired() {
        this.isExpired = true;
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.nativeAdView = maxNativeAdView;
    }

    public boolean shouldPrepareViewForInteractionOnMainThread() {
        return true;
    }
}
