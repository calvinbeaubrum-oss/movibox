package com.applovin.mediation.nativeAds;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxNativeAdViewBinder {
    protected final int advertiserTextViewId;
    protected final int bodyTextViewId;
    protected final int callToActionButtonId;
    protected final int iconContentViewId;
    protected final int iconImageViewId;
    protected final int layoutResourceId;
    protected final View mainView;
    protected final int mediaContentFrameLayoutId;
    protected final int mediaContentViewGroupId;
    protected final int optionsContentFrameLayoutId;
    protected final int optionsContentViewGroupId;
    protected final int starRatingContentViewGroupId;
    protected final String templateType;
    protected final int titleTextViewId;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f24997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f24999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f25000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f25001e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f25002f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25003g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f25004h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f25005i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f25006j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f25007k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f25008l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f25009m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f25010n;

        public Builder(int i11) {
            this(i11, null);
        }

        private Builder(int i11, View view) {
            this.f24999c = -1;
            this.f25000d = -1;
            this.f25001e = -1;
            this.f25002f = -1;
            this.f25003g = -1;
            this.f25004h = -1;
            this.f25005i = -1;
            this.f25006j = -1;
            this.f25007k = -1;
            this.f25008l = -1;
            this.f25009m = -1;
            this.f24998b = i11;
            this.f24997a = view;
        }

        public Builder(View view) {
            this(-1, view);
        }

        public MaxNativeAdViewBinder build() {
            return new MaxNativeAdViewBinder(this.f24997a, this.f24998b, this.f24999c, this.f25000d, this.f25001e, this.f25002f, this.f25003g, this.f25006j, this.f25004h, this.f25005i, this.f25007k, this.f25008l, this.f25009m, this.f25010n);
        }

        public Builder setAdvertiserTextViewId(int i11) {
            this.f25000d = i11;
            return this;
        }

        public Builder setBodyTextViewId(int i11) {
            this.f25001e = i11;
            return this;
        }

        public Builder setCallToActionButtonId(int i11) {
            this.f25009m = i11;
            return this;
        }

        @Deprecated
        public Builder setIconContentViewId(int i11) {
            this.f25003g = i11;
            return this;
        }

        public Builder setIconImageViewId(int i11) {
            this.f25002f = i11;
            return this;
        }

        @Deprecated
        public Builder setMediaContentFrameLayoutId(int i11) {
            this.f25008l = i11;
            return this;
        }

        public Builder setMediaContentViewGroupId(int i11) {
            this.f25007k = i11;
            return this;
        }

        @Deprecated
        public Builder setOptionsContentFrameLayoutId(int i11) {
            this.f25005i = i11;
            return this;
        }

        public Builder setOptionsContentViewGroupId(int i11) {
            this.f25004h = i11;
            return this;
        }

        public Builder setStarRatingContentViewGroupId(int i11) {
            this.f25006j = i11;
            return this;
        }

        public Builder setTemplateType(String str) {
            this.f25010n = str;
            return this;
        }

        public Builder setTitleTextViewId(int i11) {
            this.f24999c = i11;
            return this;
        }
    }

    private MaxNativeAdViewBinder(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, String str) {
        this.mainView = view;
        this.layoutResourceId = i11;
        this.titleTextViewId = i12;
        this.advertiserTextViewId = i13;
        this.bodyTextViewId = i14;
        this.iconImageViewId = i15;
        this.iconContentViewId = i16;
        this.starRatingContentViewGroupId = i17;
        this.optionsContentViewGroupId = i18;
        this.optionsContentFrameLayoutId = i19;
        this.mediaContentViewGroupId = i21;
        this.mediaContentFrameLayoutId = i22;
        this.callToActionButtonId = i23;
        this.templateType = str;
    }
}
