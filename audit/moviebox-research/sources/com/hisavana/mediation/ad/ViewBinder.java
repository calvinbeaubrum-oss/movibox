package com.hisavana.mediation.ad;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ViewBinder {
    public final List<Integer> actionIds;
    public View actionView;
    public final int adBadgeView;
    public final int adChoicesView;
    public final int adCloseView;
    public final int adDisclaimerView;
    public final int adStoreMarkView;
    public final int callToActionId;
    public final int descriptionId;
    public final int domainId;
    public final int downloadsId;
    public final int feedbackId;
    public Drawable iconDrawable;
    public final int iconId;
    public View layout;
    public final int layoutId;
    public final int likesId;
    public final int mediaId;
    public final int mode;
    public final int priceId;
    public final int ratingId;
    public final int sponsoredId;
    public final int titleId;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41874a;
        public View actionView;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f41877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f41878e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41879f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41880g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f41881h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f41882i;
        public Drawable iconDrawable;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f41883j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f41884k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f41885l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f41886m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f41887n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f41888o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List<Integer> f41889p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public View f41890q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f41891r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f41892s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f41893t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f41894u;

        public Builder(int i11) {
            this.f41874a = i11;
        }

        public Builder(@NonNull View view) {
            this.f41890q = view;
        }

        @NonNull
        public final Builder actionIds(Integer... numArr) {
            this.f41889p = Arrays.asList(numArr);
            return this;
        }

        public final Builder adBadgeView(int i11) {
            this.f41886m = i11;
            return this;
        }

        @NonNull
        public final Builder adChoicesView(int i11) {
            this.f41887n = i11;
            return this;
        }

        public final Builder adCloseView(int i11) {
            this.f41888o = i11;
            return this;
        }

        public final Builder adDisclaimerView(int i11) {
            this.f41885l = i11;
            return this;
        }

        @NonNull
        public final ViewBinder build() {
            return new ViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i11) {
            this.f41877d = i11;
            return this;
        }

        public final Builder contextMode(int i11) {
            this.f41891r = i11;
            return this;
        }

        @NonNull
        public final Builder descriptionId(int i11) {
            this.f41879f = i11;
            return this;
        }

        public final Builder domainView(int i11) {
            this.f41893t = i11;
            return this;
        }

        @NonNull
        public final Builder downloadsId(int i11) {
            this.f41884k = i11;
            return this;
        }

        public final Builder feedbackView(int i11) {
            this.f41894u = i11;
            return this;
        }

        public final Builder iconDrawable(Drawable drawable) {
            this.iconDrawable = drawable;
            return this;
        }

        @NonNull
        public final Builder iconId(int i11) {
            this.f41876c = i11;
            return this;
        }

        @NonNull
        public final Builder likesId(int i11) {
            this.f41882i = i11;
            return this;
        }

        @NonNull
        public final Builder mediaId(int i11) {
            this.f41878e = i11;
            return this;
        }

        @NonNull
        public final Builder priceId(int i11) {
            this.f41883j = i11;
            return this;
        }

        @NonNull
        public final Builder ratingId(int i11) {
            this.f41881h = i11;
            return this;
        }

        public Builder setActionView(View view) {
            this.actionView = view;
            return this;
        }

        @NonNull
        public final Builder sponsoredId(int i11) {
            this.f41880g = i11;
            return this;
        }

        public final Builder storeMarkView(int i11) {
            this.f41892s = i11;
            return this;
        }

        @NonNull
        public final Builder titleId(int i11) {
            this.f41875b = i11;
            return this;
        }
    }

    public ViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.f41874a;
        this.layout = builder.f41890q;
        this.titleId = builder.f41875b;
        this.callToActionId = builder.f41877d;
        this.iconId = builder.f41876c;
        this.mediaId = builder.f41878e;
        this.descriptionId = builder.f41879f;
        this.sponsoredId = builder.f41880g;
        this.ratingId = builder.f41881h;
        this.likesId = builder.f41882i;
        this.priceId = builder.f41883j;
        this.downloadsId = builder.f41884k;
        this.actionIds = builder.f41889p;
        this.mode = builder.f41891r;
        this.adDisclaimerView = builder.f41885l;
        this.adBadgeView = builder.f41886m;
        this.adChoicesView = builder.f41887n;
        this.adCloseView = builder.f41888o;
        this.adStoreMarkView = builder.f41892s;
        this.domainId = builder.f41893t;
        this.feedbackId = builder.f41894u;
        this.iconDrawable = builder.iconDrawable;
        this.actionView = builder.actionView;
    }
}
