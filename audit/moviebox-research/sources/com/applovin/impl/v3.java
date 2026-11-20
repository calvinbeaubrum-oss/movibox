package com.applovin.impl;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v3 extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f23734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.a f23735i;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z11) {
            super(aVar, jVar, z11);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            this.f24689a.p().a(v3.this.f23734h, v3.this.f23735i.f(), i11, jSONObject, str2, false);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            this.f24689a.p().a(v3.this.f23734h, v3.this.f23735i.f(), i11, jSONObject, null, true);
        }
    }

    public v3(String str, com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
        super("CommunicatorRequestTask", jVar, str);
        this.f23734h = str;
        this.f23735i = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24689a.j0().a(new a(this.f23735i, this.f24689a, d()));
    }
}
