package com.transsion.api.gateway.config;

import com.transsion.api.gateway.bean.GatewayHost;
import com.transsion.api.gateway.bean.GatewayStrategy;
import com.transsion.api.gateway.bean.RemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f50704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f50705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f50706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f50707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f50708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f50709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f50710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f50711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f50712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<GatewayHost> f50713j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<GatewayStrategy> f50714k;

    /* JADX INFO: renamed from: com.transsion.api.gateway.config.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0552a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f50715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f50716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f50717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f50718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f50719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f50720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f50721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<String> f50722h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f50723i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<GatewayHost> f50724j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<GatewayStrategy> f50725k;

        public C0552a() {
            this.f50715a = false;
            this.f50716b = false;
            this.f50717c = true;
            this.f50718d = 60000;
            this.f50719e = 3600000L;
            this.f50720f = 3600000L;
            this.f50723i = 0;
            this.f50724j = new ArrayList();
            this.f50725k = new ArrayList();
        }

        public C0552a(a aVar) {
            this.f50715a = aVar.f50704a;
            this.f50716b = aVar.f50705b;
            this.f50717c = aVar.f50706c;
            this.f50718d = aVar.f50707d;
            this.f50719e = aVar.f50708e;
            this.f50720f = aVar.f50710g;
            this.f50724j = aVar.f50713j;
            this.f50725k = aVar.f50714k;
            this.f50723i = aVar.f50709f;
            this.f50721g = aVar.f50711h;
            this.f50722h = aVar.f50712i;
        }

        public C0552a a(RemoteConfig remoteConfig) {
            this.f50715a = remoteConfig.activateGatewayDns;
            this.f50716b = remoteConfig.useGateway;
            this.f50717c = remoteConfig.activateTracking;
            this.f50718d = remoteConfig.requestTimeout;
            this.f50719e = remoteConfig.refreshInterval;
            this.f50720f = remoteConfig.metricsInterval;
            this.f50724j = remoteConfig.useGatewayHostList;
            this.f50725k = remoteConfig.gatewayStrategy;
            this.f50723i = remoteConfig.configVersion;
            this.f50721g = remoteConfig.gatewayHost;
            this.f50722h = remoteConfig.gatewayIp;
            return this;
        }
    }

    public a(C0552a c0552a) {
        this.f50704a = c0552a.f50715a;
        this.f50705b = c0552a.f50716b;
        this.f50706c = c0552a.f50717c;
        this.f50707d = c0552a.f50718d;
        this.f50708e = c0552a.f50719e;
        this.f50709f = c0552a.f50723i;
        this.f50710g = c0552a.f50720f;
        this.f50711h = c0552a.f50721g;
        this.f50712i = c0552a.f50722h;
        this.f50713j = c0552a.f50724j;
        this.f50714k = c0552a.f50725k;
    }

    public String toString() {
        return "GatewayConfig{activateGatewayDns=" + this.f50704a + ", useGateway=" + this.f50705b + ", activateTracking=" + this.f50706c + ", requestTimeout=" + this.f50707d + ", refreshInterval=" + this.f50708e + ", configVersion=" + this.f50709f + ", metricsInterval=" + this.f50710g + ", gatewayHost='" + this.f50711h + "', gatewayIp=" + this.f50712i + ", useGatewayHostList=" + this.f50713j + ", gatewayStrategy=" + this.f50714k + '}';
    }
}
