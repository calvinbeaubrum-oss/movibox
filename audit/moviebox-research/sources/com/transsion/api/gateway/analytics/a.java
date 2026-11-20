package com.transsion.api.gateway.analytics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f50694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f50696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f50699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f50700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f50701j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50702k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f50693b = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50692a = String.valueOf(System.currentTimeMillis());

    public String toString() {
        return "RequestAnalyticsData{requestId='" + this.f50692a + "', requestSubId='" + ((String) null) + "', requestStartTime=" + this.f50693b + ", subRequestStartTime=0, isIpConnect=" + this.f50694c + ", isGateway=" + this.f50695d + ", requestSize=" + this.f50696e + ", responseSize=0, ip='" + ((String) null) + "', host='" + this.f50697f + "', netQuality=0, path='" + this.f50698g + "', originUrl='" + this.f50699h + "', originHost='" + this.f50700i + "', domain='" + ((String) null) + "', result='" + ((String) null) + "', retryTime=" + this.f50701j + ", responseCode=" + this.f50702k + '}';
    }
}
