package com.cloud.hisavana.sdk.common.bean;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w9.q;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DiskTrackingBean {
    private String adCreativeId;
    private String advertiserId;
    private String codeSeatId;
    private long createTime;
    private String md5;
    private transient DiskTrackingBean next;
    private String packageName;
    private String requestId;
    private String showId;
    private boolean showTrackingUrlsLogEnable;
    private final String trackingUrl;
    private String triggerId;
    private final transient String TAG = "DiskTrackingBean";
    private AtomicInteger retryTimes = new AtomicInteger(0);
    private String uuid = "";

    public DiskTrackingBean(String str) {
        this.trackingUrl = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        createMd5();
        this.createTime = System.currentTimeMillis();
        this.retryTimes.set(0);
    }

    private final void createMd5() {
        String str = this.trackingUrl;
        if (str != null) {
            this.md5 = q.c(str);
        }
    }

    public final String getAdCreativeId() {
        return this.adCreativeId;
    }

    public final String getAdvertiserId() {
        return this.advertiserId;
    }

    public final String getCodeSeatId() {
        return this.codeSeatId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final DiskTrackingBean getNext() {
        return this.next;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final AtomicInteger getRetryTimes() {
        return this.retryTimes;
    }

    public final String getShowId() {
        return this.showId;
    }

    public final boolean getShowTrackingUrlsLogEnable() {
        return this.showTrackingUrlsLogEnable;
    }

    public final String getTrackingUrl() {
        return this.trackingUrl;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setAdCreativeId(String str) {
        this.adCreativeId = str;
    }

    public final void setAdvertiserId(String str) {
        this.advertiserId = str;
    }

    public final void setCodeSeatId(String str) {
        this.codeSeatId = str;
    }

    public final void setCreateTime(long j11) {
        this.createTime = j11;
    }

    public final void setData(AdsDTO ad2) {
        List<String> logEnable;
        Intrinsics.g(ad2, "ad");
        this.uuid = ad2.getUuid() + this.md5;
        this.showId = ad2.getUuid();
        AdxImpBean impBeanRequest = ad2.getImpBeanRequest();
        this.triggerId = impBeanRequest != null ? impBeanRequest.triggerId : null;
        AdxImpBean impBeanRequest2 = ad2.getImpBeanRequest();
        this.requestId = impBeanRequest2 != null ? impBeanRequest2.requestId : null;
        this.advertiserId = ad2.getAdvertiserId();
        AdxImpBean impBeanRequest3 = ad2.getImpBeanRequest();
        this.codeSeatId = impBeanRequest3 != null ? impBeanRequest3.pmid : null;
        this.adCreativeId = ad2.getAdCreativeId();
        String packageName = ad2.getPackageName();
        this.packageName = (packageName == null || packageName.length() == 0) ? ad2.getPackageName() : ad2.getPsPackageName();
        AdsProtocolBean.Ext ext = ad2.getExt();
        this.showTrackingUrlsLogEnable = (ext == null || (logEnable = ext.getLogEnable()) == null) ? false : logEnable.contains("showTrackingUrlsLogEnable");
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setNext(DiskTrackingBean diskTrackingBean) {
        this.next = diskTrackingBean;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setRetryTimes(AtomicInteger atomicInteger) {
        Intrinsics.g(atomicInteger, "<set-?>");
        this.retryTimes = atomicInteger;
    }

    public final void setShowId(String str) {
        this.showId = str;
    }

    public final void setShowTrackingUrlsLogEnable(boolean z11) {
        this.showTrackingUrlsLogEnable = z11;
    }

    public final void setTriggerId(String str) {
        this.triggerId = str;
    }

    public final void setUuid(String str) {
        Intrinsics.g(str, "<set-?>");
        this.uuid = str;
    }

    public String toString() {
        return "uuid:" + this.uuid + ",urls:" + this.trackingUrl;
    }
}
