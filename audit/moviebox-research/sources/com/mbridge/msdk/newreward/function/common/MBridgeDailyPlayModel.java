package com.mbridge.msdk.newreward.function.common;

import android.text.TextUtils;
import com.hisavana.common.constant.ComConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeDailyPlayModel {
    private final int mAdType;
    private final String mCountKey;
    private int mMaxDailyCap = 0;
    private final String mPlacementID;
    private final String mTimeKey;
    private final String mUnitID;

    public MBridgeDailyPlayModel(int i11, String str, String str2) {
        this.mAdType = i11;
        str = TextUtils.isEmpty(str) ? "null" : str;
        this.mPlacementID = str;
        str2 = TextUtils.isEmpty(str2) ? "null" : str2;
        this.mUnitID = str2;
        String str3 = i11 + "_" + str + "_" + str2;
        this.mCountKey = str3 + "_count";
        this.mTimeKey = str3 + "_time";
    }

    public void insertDailyCap() {
        long j11 = MBridgeSharedPreferenceModel.getInstance().getLong(this.mTimeKey, 0L);
        int integer = MBridgeSharedPreferenceModel.getInstance().getInteger(this.mCountKey, 0) + 1;
        if (j11 != 0 && System.currentTimeMillis() - j11 <= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            MBridgeSharedPreferenceModel.getInstance().putInteger(this.mCountKey, integer);
        } else {
            MBridgeSharedPreferenceModel.getInstance().putLong(this.mTimeKey, System.currentTimeMillis());
            MBridgeSharedPreferenceModel.getInstance().putInteger(this.mCountKey, integer);
        }
    }

    public boolean isOverDailyCap() {
        if (this.mMaxDailyCap <= 0) {
            return false;
        }
        long j11 = MBridgeSharedPreferenceModel.getInstance().getLong(this.mTimeKey, 0L);
        if (j11 == 0) {
            return false;
        }
        if (System.currentTimeMillis() - j11 <= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            return MBridgeSharedPreferenceModel.getInstance().getInteger(this.mCountKey, 0) >= this.mMaxDailyCap;
        }
        MBridgeSharedPreferenceModel.getInstance().putLong(this.mTimeKey, 0L);
        MBridgeSharedPreferenceModel.getInstance().putInteger(this.mCountKey, 0);
        return false;
    }

    public void setMaxPlayCount(int i11) {
        this.mMaxDailyCap = i11;
    }
}
