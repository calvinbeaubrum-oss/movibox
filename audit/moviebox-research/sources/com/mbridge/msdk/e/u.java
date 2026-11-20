package com.mbridge.msdk.e;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.hisavana.common.constant.ComConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class u<T> extends com.mbridge.msdk.e.a.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f43949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.e.a.p.b f43950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.e.a.r.b<T> f43951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v f43952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.e.a.f f43953e;

    public u(String str, int i11) {
        super(i11, str);
    }

    public u(String str, int i11, int i12) {
        super(i11, str, i12);
    }

    @Override // com.mbridge.msdk.e.a.p
    public final com.mbridge.msdk.e.a.r<T> a(com.mbridge.msdk.e.a.m mVar) {
        return this.f43952d.a(mVar);
    }

    @Override // com.mbridge.msdk.e.a.p
    public final Map<String, String> a() {
        return this.f43949a;
    }

    public final void a(com.mbridge.msdk.e.a.p.b bVar) {
        this.f43950b = bVar;
    }

    public final void a(com.mbridge.msdk.e.a.r.b<T> bVar) {
        this.f43951c = bVar;
    }

    public final void a(v vVar) {
        this.f43952d = vVar;
    }

    @Override // com.mbridge.msdk.e.a.p
    public final void a(T t11) {
        com.mbridge.msdk.e.a.r.b<T> bVar = this.f43951c;
        this.f43951c = bVar;
        if (bVar != null) {
            bVar.a(t11);
        }
    }

    public final void a(Map<String, String> map) {
        this.f43949a = map;
    }

    @Override // com.mbridge.msdk.e.a.p
    public final com.mbridge.msdk.e.a.v b() {
        if (y.a(this.f43953e)) {
            this.f43953e = new com.mbridge.msdk.e.a.f(ComConstants.AD_TIMEOUT_MILLIS, 5, 1.0f);
        }
        return this.f43953e;
    }

    @Override // com.mbridge.msdk.e.a.p
    public final Map<String, String> d() {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        return map;
    }

    @Override // com.mbridge.msdk.e.a.p
    public final com.mbridge.msdk.e.a.p.b e() {
        return this.f43950b;
    }
}
