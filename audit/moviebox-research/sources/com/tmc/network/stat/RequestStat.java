package com.tmc.network.stat;

import com.cloud.tmc.integration.permission.PermissionConstant;
import kotlin.Metadata;
import no.a;
import no.b;
import no.c;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@b(id = "701", name = PermissionConstant.ACTION_REQUEST)
public final class RequestStat extends c {
    private long callStart;

    @a
    private int connRet;

    @a
    private long connWaitTime;

    @a
    private long dnsTime;

    @a
    private int errCode;

    @a
    private long firstDataTime;

    @a
    private boolean isNetworkConnected;

    @a
    private boolean isNetworkImprove;

    @a
    private boolean isPinning;

    @a
    private boolean isPre;

    @a
    private int netStatus;

    @a
    private long onewayTime;

    @a
    private long recvBodySize;

    @a
    private long recvDataTime;
    private long reqBodyStart;
    private long reqBodyTime;
    private long reqHeaderStart;

    @a
    private long reqHeaderTime;
    private long resBodyStart;
    private long resHeaderStart;

    @a
    private long resHeaderTime;

    @a
    private int ret;
    private long sendDataEnd;

    @a
    private long sendDataTime;

    @a
    private long tcpTime;

    @a
    private long tlsTime;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    @a
    private String f49354ip = "";

    @a
    private String host = "";

    @a
    private String url = "";

    @a
    private String protocol = "";

    @a
    private String tlsVersion = "";

    @a
    private String errMsg = "";

    @a
    private String appName = "";

    @a
    private String networkType = "";

    @a
    private String requestChannel = "";

    @a
    private int step = -1;

    @a
    private String xCache = "";

    @a
    private String eagleId = "";

    @a
    private String requestSrc = "";

    @a
    private String requestLLID = "";

    public final String getAppName() {
        return this.appName;
    }

    public final long getCallStart() {
        return this.callStart;
    }

    public final int getConnRet() {
        return this.connRet;
    }

    public final long getConnWaitTime() {
        return this.connWaitTime;
    }

    public final long getDnsTime() {
        return this.dnsTime;
    }

    public final String getEagleId() {
        return this.eagleId;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final long getFirstDataTime() {
        return this.firstDataTime;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getIp() {
        return this.f49354ip;
    }

    public final int getNetStatus() {
        return this.netStatus;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final long getOnewayTime() {
        return this.onewayTime;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final long getRecvBodySize() {
        return this.recvBodySize;
    }

    public final long getRecvDataTime() {
        return this.recvDataTime;
    }

    public final long getReqBodyStart() {
        return this.reqBodyStart;
    }

    public final long getReqBodyTime() {
        return this.reqBodyTime;
    }

    public final long getReqHeaderStart() {
        return this.reqHeaderStart;
    }

    public final long getReqHeaderTime() {
        return this.reqHeaderTime;
    }

    public final String getRequestChannel() {
        return this.requestChannel;
    }

    public final String getRequestLLID() {
        return this.requestLLID;
    }

    public final String getRequestSrc() {
        return this.requestSrc;
    }

    public final long getResBodyStart() {
        return this.resBodyStart;
    }

    public final long getResHeaderStart() {
        return this.resHeaderStart;
    }

    public final long getResHeaderTime() {
        return this.resHeaderTime;
    }

    public final int getRet() {
        return this.ret;
    }

    public final long getSendDataEnd() {
        return this.sendDataEnd;
    }

    public final long getSendDataTime() {
        return this.sendDataTime;
    }

    public final int getStep() {
        return this.step;
    }

    public final long getTcpTime() {
        return this.tcpTime;
    }

    public final long getTlsTime() {
        return this.tlsTime;
    }

    public final String getTlsVersion() {
        return this.tlsVersion;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getXCache() {
        return this.xCache;
    }

    public final boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public final boolean isNetworkImprove() {
        return this.isNetworkImprove;
    }

    public final boolean isPinning() {
        return this.isPinning;
    }

    public final boolean isPre() {
        return this.isPre;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setCallStart(long j11) {
        this.callStart = j11;
    }

    public final void setConnRet(int i11) {
        this.connRet = i11;
    }

    public final void setConnWaitTime(long j11) {
        this.connWaitTime = j11;
    }

    public final void setDnsTime(long j11) {
        this.dnsTime = j11;
    }

    public final void setEagleId(String str) {
        this.eagleId = str;
    }

    public final void setErrCode(int i11) {
        this.errCode = i11;
    }

    public final void setErrMsg(String str) {
        this.errMsg = str;
    }

    public final void setFirstDataTime(long j11) {
        this.firstDataTime = j11;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final void setIp(String str) {
        this.f49354ip = str;
    }

    public final void setNetStatus(int i11) {
        this.netStatus = i11;
    }

    public final void setNetworkConnected(boolean z11) {
        this.isNetworkConnected = z11;
    }

    public final void setNetworkImprove(boolean z11) {
        this.isNetworkImprove = z11;
    }

    public final void setNetworkType(String str) {
        this.networkType = str;
    }

    public final void setOnewayTime(long j11) {
        this.onewayTime = j11;
    }

    public final void setPinning(boolean z11) {
        this.isPinning = z11;
    }

    public final void setPre(boolean z11) {
        this.isPre = z11;
    }

    public final void setProtocol(String str) {
        this.protocol = str;
    }

    public final void setRecvBodySize(long j11) {
        this.recvBodySize = j11;
    }

    public final void setRecvDataTime(long j11) {
        this.recvDataTime = j11;
    }

    public final void setReqBodyStart(long j11) {
        this.reqBodyStart = j11;
    }

    public final void setReqBodyTime(long j11) {
        this.reqBodyTime = j11;
    }

    public final void setReqHeaderStart(long j11) {
        this.reqHeaderStart = j11;
    }

    public final void setReqHeaderTime(long j11) {
        this.reqHeaderTime = j11;
    }

    public final void setRequestChannel(String str) {
        this.requestChannel = str;
    }

    public final void setRequestLLID(String str) {
        this.requestLLID = str;
    }

    public final void setRequestSrc(String str) {
        this.requestSrc = str;
    }

    public final void setResBodyStart(long j11) {
        this.resBodyStart = j11;
    }

    public final void setResHeaderStart(long j11) {
        this.resHeaderStart = j11;
    }

    public final void setResHeaderTime(long j11) {
        this.resHeaderTime = j11;
    }

    public final void setRet(int i11) {
        this.ret = i11;
    }

    public final void setSendDataEnd(long j11) {
        this.sendDataEnd = j11;
    }

    public final void setSendDataTime(long j11) {
        this.sendDataTime = j11;
    }

    public final void setStep(int i11) {
        this.step = i11;
    }

    public final void setTcpTime(long j11) {
        this.tcpTime = j11;
    }

    public final void setTlsTime(long j11) {
        this.tlsTime = j11;
    }

    public final void setTlsVersion(String str) {
        this.tlsVersion = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setXCache(String str) {
        this.xCache = str;
    }

    public String toString() {
        return "RequestStat(ip=" + ((Object) this.f49354ip) + ", host=" + ((Object) this.host) + ", url=" + ((Object) this.url) + ", protocol=" + ((Object) this.protocol) + ", onewayTime=" + this.onewayTime + ", connWaitTime=" + this.connWaitTime + ", dnsTime=" + this.dnsTime + ", tcpTime=" + this.tcpTime + ", tlsTime=" + this.tlsTime + ", tlsVersion=" + ((Object) this.tlsVersion) + ", reqHeaderTime=" + this.reqHeaderTime + ", reqBodyTime=" + this.reqBodyTime + ", resHeaderTime=" + this.resHeaderTime + ", sendDataTime=" + this.sendDataTime + ", recvDataTime=" + this.recvDataTime + ", firstDataTime=" + this.firstDataTime + ", ret=" + this.ret + ", isPinning=" + this.isPinning + ", recvBodySize=" + this.recvBodySize + ", connRet=" + this.connRet + ", errCode=" + this.errCode + ", errMsg=" + ((Object) this.errMsg) + ", isNetworkConnected=" + this.isNetworkConnected + ", appName=" + ((Object) this.appName) + ", networkType=" + ((Object) this.networkType) + ", isPre=" + this.isPre + ", isNetworkImprove=" + this.isNetworkImprove + ", requestChannel=" + ((Object) this.requestChannel) + ", step=" + this.step + ", xCache=" + ((Object) this.xCache) + ", eagleId=" + ((Object) this.eagleId) + ", netStatus=" + this.netStatus + ", requestSrc=" + ((Object) this.requestSrc) + ", requestLLID=" + ((Object) this.requestLLID) + ')';
    }
}
