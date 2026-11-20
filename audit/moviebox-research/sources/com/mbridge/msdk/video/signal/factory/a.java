package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a.e;
import com.mbridge.msdk.video.signal.a.h;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a implements IJSFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.video.signal.b f48415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected d f48416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected j f48417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected g f48418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected f f48419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected i f48420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected c f48421g;

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getActivityProxy() {
        if (this.f48415a == null) {
            this.f48415a = new com.mbridge.msdk.video.signal.a.b();
        }
        return this.f48415a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.f48420f == null) {
            this.f48420f = new com.mbridge.msdk.video.signal.a.g();
        }
        return this.f48420f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSBTModule() {
        if (this.f48421g == null) {
            this.f48421g = new com.mbridge.msdk.video.signal.a.c();
        }
        return this.f48421g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        if (this.f48416b == null) {
            this.f48416b = new com.mbridge.msdk.video.signal.a.d();
        }
        return this.f48416b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        if (this.f48419e == null) {
            this.f48419e = new e();
        }
        return this.f48419e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.f48418d == null) {
            this.f48418d = new com.mbridge.msdk.video.signal.a.f();
        }
        return this.f48418d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        if (this.f48417c == null) {
            this.f48417c = new h();
        }
        return this.f48417c;
    }
}
