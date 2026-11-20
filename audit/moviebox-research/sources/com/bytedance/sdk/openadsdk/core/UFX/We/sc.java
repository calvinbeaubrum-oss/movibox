package com.bytedance.sdk.openadsdk.core.UFX.We;

import com.bytedance.adsdk.ugeno.core.BT;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends Ql {
    private float We;
    private BT pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private JSONObject f28258sc;
    private float zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.UFX.We.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0295sc extends Ql.sc {
        private float We;
        private BT pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private JSONObject f28259sc;
        private float zY;

        public C0295sc pFF(float f11) {
            this.We = f11;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.pFF.Ql.sc
        /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
        public sc sc() {
            return new sc(this);
        }

        public C0295sc sc(float f11) {
            this.zY = f11;
            return this;
        }

        public C0295sc sc(BT bt2) {
            this.pFF = bt2;
            return this;
        }

        public C0295sc sc(JSONObject jSONObject) {
            this.f28259sc = jSONObject;
            return this;
        }
    }

    public sc(C0295sc c0295sc) {
        super(c0295sc);
        this.f28258sc = c0295sc.f28259sc;
        this.pFF = c0295sc.pFF;
        this.zY = c0295sc.zY;
        this.We = c0295sc.We;
    }

    public BT HJN() {
        return this.pFF;
    }

    public float II() {
        return this.We;
    }

    public JSONObject McK() {
        return this.f28258sc;
    }

    public float cvk() {
        return this.zY;
    }
}
