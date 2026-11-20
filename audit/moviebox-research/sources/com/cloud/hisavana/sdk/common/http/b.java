package com.cloud.hisavana.sdk.common.http;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T extends ResponseBaseListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29453a = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f29454b = null;

    public void a() {
        this.f29454b = null;
    }

    public abstract void b();

    public void c() {
        if (NetStateManager.checkNetworkState()) {
            b();
            return;
        }
        T t11 = this.f29454b;
        if (t11 != null) {
            t11.e(TaErrorCode.ERROR_NETWORK_NOT_CONNECTED);
        }
    }
}
