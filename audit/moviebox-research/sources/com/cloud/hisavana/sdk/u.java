package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface u {
    void a(List<AdsDTO> list);

    void a(List<AdsDTO> list, TaErrorCode taErrorCode, AdxImpBean adxImpBean);
}
