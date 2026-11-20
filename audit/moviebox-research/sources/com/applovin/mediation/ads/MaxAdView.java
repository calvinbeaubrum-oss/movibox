package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.e0;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.zq;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAdView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaxAdViewImpl f24950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f24951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24952c;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        String strA = e0.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String strA2 = e0.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adFormat");
        MaxAdFormat fromString = StringUtils.isValidString(strA2) ? MaxAdFormat.formatFromString(strA2) : e0.a(context);
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (strA == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (isInEditMode()) {
            a(context);
        } else {
            a(strA, fromString, attributeIntValue, AppLovinSdk.getInstance(context), context);
        }
    }

    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context.getApplicationContext());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        a(str, maxAdFormat, 49, appLovinSdk, context);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, e0.a(context), appLovinSdk, context);
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i11 = displayMetrics.widthPixels;
        int i12 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i11, i12);
    }

    private void a(String str, MaxAdFormat maxAdFormat, int i11, AppLovinSdk appLovinSdk, Context context) {
        View view = new View(context.getApplicationContext());
        this.f24951b = view;
        view.setBackgroundColor(0);
        addView(this.f24951b);
        this.f24951b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f24952c = getVisibility();
        this.f24950a = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.f24951b, appLovinSdk.a(), context);
        setGravity(i11);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    public void destroy() {
        this.f24950a.logApiCall("destroy()");
        this.f24950a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f24950a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f24950a.getAdUnitId();
    }

    public String getPlacement() {
        this.f24950a.logApiCall("getPlacement()");
        return this.f24950a.getPlacement();
    }

    public void loadAd() {
        this.f24950a.logApiCall("loadAd()");
        this.f24950a.loadAd();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        if (isInEditMode()) {
            return;
        }
        this.f24950a.logApiCall("onWindowVisibilityChanged(visibility=" + i11 + ")");
        if (this.f24950a != null && zq.a(this.f24952c, i11)) {
            this.f24950a.onWindowVisibilityChanged(i11);
        }
        this.f24952c = i11;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f24950a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f24950a.setAdReviewListener(maxAdReviewListener);
    }

    @Override // android.view.View
    public void setAlpha(float f11) {
        this.f24950a.logApiCall("setAlpha(alpha=" + f11 + ")");
        View view = this.f24951b;
        if (view != null) {
            view.setAlpha(f11);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        this.f24950a.logApiCall("setBackgroundColor(color=" + i11 + ")");
        MaxAdViewImpl maxAdViewImpl = this.f24950a;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i11);
        }
        View view = this.f24951b;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public void setCustomData(String str) {
        this.f24950a.logApiCall("setCustomData(value=" + str + ")");
        this.f24950a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f24950a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f24950a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.f24950a.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f24950a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f24950a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f24950a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f24950a.logApiCall("setPlacement(placement=" + str + ")");
        this.f24950a.setPlacement(str);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f24950a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f24950a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f24950a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f24950a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f24950a.logApiCall("startAutoRefresh()");
        this.f24950a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f24950a.logApiCall("stopAutoRefresh()");
        this.f24950a.stopAutoRefresh();
    }

    @Override // android.view.View
    @NonNull
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f24950a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }
}
