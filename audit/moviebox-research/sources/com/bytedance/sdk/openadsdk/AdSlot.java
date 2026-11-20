package com.bytedance.sdk.openadsdk;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Tf;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import v8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_OPEN_AD = 3;
    public static final int TYPE_REWARD_VIDEO = 7;
    private String BT;
    private int Dl;
    private float ExN;
    private JSONArray FI;
    private boolean II;
    private int JPJ;
    private Map<String, Object> McK;
    private int Ol;
    private String Qj;
    private boolean Ql;
    private boolean SR;
    private String Sfl;
    private int TRI;
    private int Tf;
    private String UFX;
    private String WH;
    private Bundle WP;
    private float We;
    private String Xc;
    private int YIK;
    private String cvk;
    private String dE;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f27046qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27047sc;
    private int uEA;
    private String wjp;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {
        private String BT;
        private Bundle Dl;
        private int JPJ;
        private String Qj;
        private boolean Ql;
        private String SR;
        private float Tf;
        private float UFX;
        private int WH;
        private String Xc;
        private String dE;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f27049sc;
        private String uEA;
        private String wjp;
        private int pFF = 640;
        private int zY = 320;
        private final boolean We = true;
        private int ExN = 1;
        private final String TRI = "";

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private final int f27048qr = 0;
        private String Ol = "defaultUser";
        private boolean Sfl = true;
        private Map<String, Object> YIK = null;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f27047sc = this.f27049sc;
            adSlot.TRI = this.ExN;
            adSlot.f27046qr = true;
            adSlot.pFF = this.pFF;
            adSlot.zY = this.zY;
            float f11 = this.UFX;
            if (f11 <= 0.0f) {
                adSlot.We = this.pFF;
                adSlot.ExN = this.zY;
            } else {
                adSlot.We = f11;
                adSlot.ExN = this.Tf;
            }
            adSlot.Qj = "";
            adSlot.Ol = 0;
            adSlot.WH = this.Qj;
            adSlot.UFX = this.Ol;
            adSlot.Tf = this.WH;
            adSlot.Ql = this.Sfl;
            adSlot.SR = this.Ql;
            adSlot.BT = this.SR;
            adSlot.dE = this.BT;
            adSlot.Xc = this.dE;
            adSlot.wjp = this.Xc;
            adSlot.Sfl = this.wjp;
            adSlot.McK = this.YIK;
            adSlot.cvk = this.uEA;
            adSlot.JPJ = this.JPJ;
            return adSlot;
        }

        public Builder isExpressAd(boolean z11) {
            this.Ql = z11;
            return this;
        }

        public Builder setAdCount(int i11) {
            if (i11 <= 0) {
                i11 = 1;
            }
            if (i11 > 20) {
                i11 = 20;
            }
            this.ExN = i11;
            return this;
        }

        public Builder setAdId(String str) {
            this.BT = str;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f27049sc = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.dE = str;
            return this;
        }

        public Builder setDurationSlotType(int i11) {
            this.JPJ = i11;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f11, float f12) {
            this.UFX = f11;
            this.Tf = f12;
            return this;
        }

        public Builder setExt(String str) {
            this.Xc = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i11, int i12) {
            this.pFF = i11;
            this.zY = i12;
            return this;
        }

        public Builder setIsAutoPlay(boolean z11) {
            this.Sfl = z11;
            return this;
        }

        public Builder setLinkId(String str) {
            this.uEA = str;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.Qj = str;
            return this;
        }

        public Builder setNativeAdType(int i11) {
            this.WH = i11;
            return this;
        }

        public Builder setNetworkExtrasBundle(Bundle bundle) {
            this.Dl = bundle;
            return this;
        }

        public Builder setRequestExtraMap(Map<String, Object> map) {
            this.YIK = map;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i11) {
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z11) {
            return this;
        }

        public Builder setUserData(String str) {
            this.wjp = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.Ol = str;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (Tf.We()) {
                a.a(str);
            }
            this.SR = str;
            return this;
        }
    }

    private AdSlot() {
        this.Ql = true;
        this.SR = false;
        this.YIK = 0;
        this.Dl = 0;
        this.uEA = 0;
    }

    public static int getPosition(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return (i11 == 3 || i11 == 4 || i11 == 7 || i11 == 8) ? 5 : 3;
        }
        return 4;
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 320);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(iOptInt, iOptInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(dOptDouble).floatValue(), Double.valueOf(dOptDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
            builder.setAdId(jSONObject.optString("mAdId"));
            builder.setCreativeId(jSONObject.optString("mCreativeId"));
            builder.setExt(jSONObject.optString("mExt"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra"));
        } catch (Exception unused) {
        }
        AdSlot adSlotBuild = builder.build();
        adSlotBuild.setDurationSlotType(jSONObject.optInt("mDurationSlotType"));
        return adSlotBuild;
    }

    public int getAdCount() {
        return this.TRI;
    }

    public String getAdId() {
        return this.dE;
    }

    public String getBidAdm() {
        return this.BT;
    }

    public JSONArray getBiddingTokens() {
        return this.FI;
    }

    public String getCodeId() {
        return this.f27047sc;
    }

    public String getCreativeId() {
        return this.Xc;
    }

    public int getDurationSlotType() {
        return this.JPJ;
    }

    public float getExpressViewAcceptedHeight() {
        return this.ExN;
    }

    public float getExpressViewAcceptedWidth() {
        return this.We;
    }

    public String getExt() {
        return this.wjp;
    }

    public int getImgAcceptedHeight() {
        return this.zY;
    }

    public int getImgAcceptedWidth() {
        return this.pFF;
    }

    public int getIsRotateBanner() {
        return this.YIK;
    }

    public String getLinkId() {
        return this.cvk;
    }

    public String getMediaExtra() {
        return this.WH;
    }

    public int getNativeAdType() {
        return this.Tf;
    }

    public Bundle getNetworkExtrasBundle() {
        return this.WP;
    }

    @Nullable
    public Map<String, Object> getRequestExtraMap() {
        return this.McK;
    }

    @Deprecated
    public int getRewardAmount() {
        return this.Ol;
    }

    @Deprecated
    public String getRewardName() {
        return this.Qj;
    }

    public int getRotateOrder() {
        return this.uEA;
    }

    public int getRotateTime() {
        return this.Dl;
    }

    public String getUserData() {
        return this.Sfl;
    }

    public String getUserID() {
        return this.UFX;
    }

    public boolean isAutoPlay() {
        return this.Ql;
    }

    public boolean isExpressAd() {
        return this.SR;
    }

    public boolean isPreload() {
        return this.II;
    }

    public boolean isSupportDeepLink() {
        return this.f27046qr;
    }

    public void setAdCount(int i11) {
        this.TRI = i11;
    }

    public void setBiddingTokens(JSONArray jSONArray) {
        this.FI = jSONArray;
    }

    public void setDurationSlotType(int i11) {
        this.JPJ = i11;
    }

    public void setIsRotateBanner(int i11) {
        this.YIK = i11;
    }

    public void setNativeAdType(int i11) {
        this.Tf = i11;
    }

    public void setPreload(boolean z11) {
        this.II = z11;
    }

    public void setRotateOrder(int i11) {
        this.uEA = i11;
    }

    public void setRotateTime(int i11) {
        this.Dl = i11;
    }

    public void setUserData(String str) {
        this.Sfl = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f27047sc);
            jSONObject.put("mAdCount", this.TRI);
            jSONObject.put("mIsAutoPlay", this.Ql);
            jSONObject.put("mImgAcceptedWidth", this.pFF);
            jSONObject.put("mImgAcceptedHeight", this.zY);
            jSONObject.put("mExpressViewAcceptedWidth", this.We);
            jSONObject.put("mExpressViewAcceptedHeight", this.ExN);
            jSONObject.put("mSupportDeepLink", this.f27046qr);
            jSONObject.put("mRewardName", this.Qj);
            jSONObject.put("mRewardAmount", this.Ol);
            jSONObject.put("mMediaExtra", this.WH);
            jSONObject.put("mUserID", this.UFX);
            jSONObject.put("mNativeAdType", this.Tf);
            jSONObject.put("mIsExpressAd", this.SR);
            jSONObject.put("mAdId", this.dE);
            jSONObject.put("mCreativeId", this.Xc);
            jSONObject.put("mExt", this.wjp);
            jSONObject.put("mBidAdm", this.BT);
            jSONObject.put("mUserData", this.Sfl);
            jSONObject.put("mDurationSlotType", this.JPJ);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
