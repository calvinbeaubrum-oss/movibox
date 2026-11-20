package com.cloud.hisavana.sdk.common.constant;

import android.text.TextUtils;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.newreward.function.common.MBridgeError;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class TaErrorCode {
    public static final int CODE_ADM_SCALE_TAKE_FAILED = 3006;
    public static final int CODE_ADS_ARE_FILTERED = 4005;
    public static final int CODE_AD_DATA_IS_NULL = 4002;
    public static final int CODE_AD_MATERIAL_TAKE_FAILED = 3002;
    public static final int CODE_AD_TYPE_MISMATCH = 4004;
    public static final int CODE_INTERVAL_NOT_REACHED = 2005;
    public static final int CODE_MEDIA_LOAD_TIME_OUT = 4001;
    public static final int CODE_NETWORK_NOT_CONNECTED = 2004;
    public static final int CODE_NETWORK_REQUEST_TIME_OUT = 2003;
    public static final int CODE_PLACEMENT_ID_MISMATCH = 4003;
    public static final int CODE_RESPONSE_IS_NULL = 2002;
    public static final int CODE_RESPONSE_PARSING_FAILED = 2001;
    public static final int CODE_SPLASH_MATERIAL_LOAD_FAILED = 3001;
    public static final int CODE_STORE_MATERIAL_TAKE_FAILED = 3003;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNKNOWN = -1;
    public static final int CODE_ZIP_MATERIAL_DECOMPRESS_FAILED = 3005;
    public static final int CODE_ZIP_MATERIAL_TAKE_FAILED = 3004;
    public static final int VAST_VIDEO_PLAY_ERROR = 3011;
    private final int errorCode;
    private final String errorMessage;
    public static final TaErrorCode ERROR_UNKNOWN = new TaErrorCode(-1, MBridgeError.ERROR_MESSAGE_UN_KNOWN);
    public static final TaErrorCode ERROR_RESPONSE_PARSING_FAILED = new TaErrorCode(2001, "response parse failed");
    public static final TaErrorCode ERROR_RESPONSE_IS_NULL = new TaErrorCode(2002, "response is null");
    public static final TaErrorCode ERROR_NETWORK_REQUEST_TIME_OUT = new TaErrorCode(2003, "network request timeout");
    public static final TaErrorCode ERROR_NETWORK_NOT_CONNECTED = new TaErrorCode(2004, "network is not connected");
    public static final TaErrorCode ERROR_AD_MATERIAL_TAKE_FAILED = new TaErrorCode(3002, "creative url is empty or download failed");
    public static final TaErrorCode ERROR_STORE_MATERIAL_TAKE_FAILED = new TaErrorCode(3003, "store material url is empty or download failed");
    public static final TaErrorCode ERROR_ZIP_MATERIAL_TAKE_FAILED = new TaErrorCode(3004, "material zip load failed");
    public static final TaErrorCode ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED = new TaErrorCode(3005, "material zip decompress failed");
    public static final TaErrorCode ERROR_ADM_SCALE_TAKE_FAILED = new TaErrorCode(3006, "adm scales is not fit");
    public static final int CODE_BITMAP_TAKE_FAILED = 3007;
    public static final TaErrorCode ERROR_BITMAP_TAKE_FAILED = new TaErrorCode(CODE_BITMAP_TAKE_FAILED, "image acquisition failed");
    private static final int NO_MAIN_VIDEO_DATA = 3008;
    public static final TaErrorCode NO_MAIN_VIDEO_DATA_ERROR = new TaErrorCode(NO_MAIN_VIDEO_DATA, "video resource is empty");
    private static final int MAIN_VIDEO_DOWNLOAD_FAIL = 3009;
    public static final TaErrorCode MAIN_VIDEO_DOWNLOAD_FAIL_ERROR = new TaErrorCode(MAIN_VIDEO_DOWNLOAD_FAIL, "video resource is empty");
    private static final int NO_MAIN_IMG_DATA = 3010;
    public static final TaErrorCode NO_MAIN_IMG_DATA_ERROR = new TaErrorCode(NO_MAIN_IMG_DATA, "image resource is null");
    private static final int MATERIAL_TYPE_IS_NOT_VIDEO = 3012;
    public static final TaErrorCode MATERIAL_TYPE_IS_NOT_VIDEO_ERROR = new TaErrorCode(MATERIAL_TYPE_IS_NOT_VIDEO, "material type is not video");
    public static final int CODE_INTERSTITIAL_MISS_ELEMENT = 3013;
    public static final TaErrorCode ERROR_INTERSTITIAL_MISS_ELEMENT = new TaErrorCode(CODE_INTERSTITIAL_MISS_ELEMENT, "Missing necessary elements");
    public static final int CODE_INVALID_TYPE = 3014;
    public static final TaErrorCode ERROR_INVALID_TYPE = new TaErrorCode(CODE_INVALID_TYPE, "Invalid type");
    public static final int CODE_ADM_LOAD_FAILED = 3015;
    public static final TaErrorCode ERROR_ADM_LOAD_FAILED = new TaErrorCode(CODE_ADM_LOAD_FAILED, "Adm load failed");
    public static final int CODE_BITMAP_TOO_LARGE = 3016;
    public static final TaErrorCode ERROR_BITMAP_TOO_LARGE = new TaErrorCode(CODE_BITMAP_TOO_LARGE, "image is too large");
    public static final int CODE_FILE_NO_SUPPORT = 3017;
    public static final TaErrorCode ERROR_FILE_NO_SUPPORT = new TaErrorCode(CODE_FILE_NO_SUPPORT, "file format is not support on this device");
    public static final TaErrorCode ERROR_MEDIA_LOAD_TIME_OUT = new TaErrorCode(4001, "Media load ad timeout");
    public static final TaErrorCode ERROR_AD_DATA_IS_NULL = new TaErrorCode(4002, "ad data is null");
    public static final TaErrorCode ERROR_PLACEMENT_ID_MISMATCH = new TaErrorCode(4003, "ad slot id does not match");
    public static final TaErrorCode ERROR_AD_TYPE_MISMATCH = new TaErrorCode(4004, "ad type does not match");
    public static final TaErrorCode ERROR_ADS_ARE_FILTERED = new TaErrorCode(4005, "returned ads are filtered");
    public static final int CODE_TAKE_AD_FAILED = 4006;
    public static final TaErrorCode ERROR_TAKE_AD_FAILED = new TaErrorCode(CODE_TAKE_AD_FAILED, "no ads available");
    public static final int CODE_AD_IMPRESSION_LIMIT = 4008;
    public static final TaErrorCode ERROR_AD_IMPRESSION_LIMIT = new TaErrorCode(CODE_AD_IMPRESSION_LIMIT, "ad impression limit");
    public static final int CODE_AD_SHOW_NOT_IN_INTERVAL = 4009;
    public static final TaErrorCode ERROR_AD_SHOW_NOT_IN_INTERVAL = new TaErrorCode(CODE_AD_SHOW_NOT_IN_INTERVAL, "ad show not in interval");
    public static final int CODE_DESTROY_BEFORE_FILLING = 4010;
    public static final TaErrorCode ERROR_DESTROY_BEFORE_FILLING = new TaErrorCode(CODE_DESTROY_BEFORE_FILLING, "destroyed before filling");
    public static final int CODE_AD_UNIT_CONFIG_IS_EMPTY = 4011;
    public static final TaErrorCode ERROR_AD_UNIT_CONFIG_IS_EMPTY = new TaErrorCode(CODE_AD_UNIT_CONFIG_IS_EMPTY, "unable to obtain valid ad code seat id");
    public static final int CODE_LOAD_FAILED_CAUSE_DESTROY = 4012;
    public static final TaErrorCode ERROR_LOAD_FAILED_CAUSE_DESTROY = new TaErrorCode(CODE_LOAD_FAILED_CAUSE_DESTROY, "load ad failed，because destroyed");
    public static final int CODE_LOAD_FAILED_CAUSE_LOADING = 4013;
    public static final TaErrorCode ERROR_LOAD_FAILED_CAUSE_LOADING = new TaErrorCode(CODE_LOAD_FAILED_CAUSE_LOADING, "load ad failed，because loading");
    public static final int CODE_INIT_ERROR = 4014;
    public static final TaErrorCode ERROR_INIT_ERROR = new TaErrorCode(CODE_INIT_ERROR, "Not initialized");

    public TaErrorCode(int i11, String str) {
        str = TextUtils.isEmpty(str) ? TAdErrorCode.EMPTY_MSG : str;
        this.errorCode = i11;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        return "TaErrorCode{errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + "'}";
    }
}
