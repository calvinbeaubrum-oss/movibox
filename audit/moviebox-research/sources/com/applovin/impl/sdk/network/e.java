package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sj;
import com.applovin.impl.vi;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends com.applovin.impl.sdk.network.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f22796s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f22797t;

    /* JADX INFO: compiled from: source.java */
    public static class a extends com.applovin.impl.sdk.network.a.C0202a {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f22798r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f22799s;

        public a(j jVar) {
            super(jVar);
            this.f22745h = ((Integer) jVar.a(sj.W2)).intValue();
            this.f22746i = ((Integer) jVar.a(sj.V2)).intValue();
            this.f22747j = ((Integer) jVar.a(sj.f22929c3)).intValue();
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(vi.a aVar) {
            this.f22754q = aVar;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            this.f22744g = obj;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(JSONObject jSONObject) {
            this.f22743f = jSONObject;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a() {
            return new e(this);
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(Map map) {
            this.f22742e = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(int i11) {
            this.f22745h = i11;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(String str) {
            this.f22740c = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b(Map map) {
            this.f22741d = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(int i11) {
            this.f22747j = i11;
            return this;
        }

        public a e(String str) {
            this.f22798r = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a c(int i11) {
            this.f22746i = i11;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a b(String str) {
            this.f22739b = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a c(String str) {
            this.f22738a = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a a(boolean z11) {
            this.f22751n = z11;
            return this;
        }

        public a h(boolean z11) {
            this.f22799s = z11;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0202a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a b(boolean z11) {
            this.f22753p = z11;
            return this;
        }
    }

    public e(a aVar) {
        super(aVar);
        this.f22796s = aVar.f22798r;
        this.f22797t = aVar.f22799s;
    }

    public static a b(j jVar) {
        return new a(jVar);
    }

    public String s() {
        return this.f22796s;
    }

    public boolean t() {
        return this.f22796s != null;
    }

    public boolean u() {
        return this.f22797t;
    }
}
