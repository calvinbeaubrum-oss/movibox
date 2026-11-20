package com.tmc.network.stat;

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
@b(id = "700", name = "connect")
public final class ConnectStat extends c {

    @a
    private long connTime;
    private long connectStart;
    private long dnsStart;

    @a
    private long dnsTime;

    @a
    private int errCode;

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
    private int ret;

    @a
    private long tcpTime;
    private long tlsStart;

    @a
    private long tlsTime;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    @a
    private String f49353ip = "";

    @a
    private String host = "";

    @a
    private String protocol = "";

    @a
    private String errMsg = "";

    @a
    private String appName = "";

    @a
    private String networkType = "";

    @a
    private int step = -1;

    @a
    private String tlsVersion = "";

    public final String getAppName() {
        return this.appName;
    }

    public final long getConnTime() {
        return this.connTime;
    }

    public final long getConnectStart() {
        return this.connectStart;
    }

    public final long getDnsStart() {
        return this.dnsStart;
    }

    public final long getDnsTime() {
        return this.dnsTime;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getIp() {
        return this.f49353ip;
    }

    public final int getNetStatus() {
        return this.netStatus;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getStep() {
        return this.step;
    }

    public final long getTcpTime() {
        return this.tcpTime;
    }

    public final long getTlsStart() {
        return this.tlsStart;
    }

    public final long getTlsTime() {
        return this.tlsTime;
    }

    public final String getTlsVersion() {
        return this.tlsVersion;
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

    public final void setConnTime(long j11) {
        this.connTime = j11;
    }

    public final void setConnectStart(long j11) {
        this.connectStart = j11;
    }

    public final void setDnsStart(long j11) {
        this.dnsStart = j11;
    }

    public final void setDnsTime(long j11) {
        this.dnsTime = j11;
    }

    public final void setErrCode(int i11) {
        this.errCode = i11;
    }

    public final void setErrMsg(String str) {
        this.errMsg = str;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final void setIp(String str) {
        this.f49353ip = str;
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

    public final void setPinning(boolean z11) {
        this.isPinning = z11;
    }

    public final void setPre(boolean z11) {
        this.isPre = z11;
    }

    public final void setProtocol(String str) {
        this.protocol = str;
    }

    public final void setRet(int i11) {
        this.ret = i11;
    }

    public final void setStep(int i11) {
        this.step = i11;
    }

    public final void setTcpTime(long j11) {
        this.tcpTime = j11;
    }

    public final void setTlsStart(long j11) {
        this.tlsStart = j11;
    }

    public final void setTlsTime(long j11) {
        this.tlsTime = j11;
    }

    public final void setTlsVersion(String str) {
        this.tlsVersion = str;
    }

    public String toString() {
        return "ConnectStat(ip=" + ((Object) this.f49353ip) + ", host=" + ((Object) this.host) + ", protocol=" + ((Object) this.protocol) + ", ret=" + this.ret + ", connTime=" + this.connTime + ", dnsStart=" + this.dnsStart + ", dnsTime=" + this.dnsTime + ", tcpTime=" + this.tcpTime + ", tlsStart=" + this.tlsStart + ", tlsTime=" + this.tlsTime + ", isPinning=" + this.isPinning + ", errCode=" + this.errCode + ", errMsg=" + ((Object) this.errMsg) + ", isNetworkConnected=" + this.isNetworkConnected + ", appName=" + ((Object) this.appName) + ", networkType=" + ((Object) this.networkType) + ", isPre=" + this.isPre + ", isNetworkImprove=" + this.isNetworkImprove + ", step=" + this.step + ", netStatus=" + this.netStatus + ", tlsVersion=" + ((Object) this.tlsVersion) + ')';
    }
}
