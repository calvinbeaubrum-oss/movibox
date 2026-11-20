package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR implements com.bytedance.sdk.component.adexpress.zY {
    public final boolean BT;
    public final long ExN;
    public final int Ol;
    public final int Qj;
    public JSONObject Ql;
    public SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> SR;
    public final long TRI;
    public int Tf;
    public final String UFX;
    public final int WH;
    public final float We;
    public JSONObject Xc;
    public int dE;
    public final float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public final int f28399qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final float f28400sc;
    public boolean wjp;
    public final float zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private int BT;
        private float ExN;
        private int Ol;
        private int Qj;
        private int Ql;
        private JSONObject SR;
        private float TRI;
        private String Tf;
        private int UFX;
        private int WH;
        private float We;
        private JSONObject dE;
        private long pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private float f28401qr;
        private boolean wjp;
        private long zY;
        private boolean Xc = false;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        protected SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> f28402sc = new SparseArray<>();

        public sc ExN(int i11) {
            this.WH = i11;
            return this;
        }

        public sc TRI(int i11) {
            this.UFX = i11;
            return this;
        }

        public sc We(float f11) {
            this.f28401qr = f11;
            return this;
        }

        public sc We(int i11) {
            this.Ol = i11;
            return this;
        }

        public sc pFF(float f11) {
            this.ExN = f11;
            return this;
        }

        public sc pFF(int i11) {
            this.Ql = i11;
            return this;
        }

        public sc pFF(long j11) {
            this.zY = j11;
            return this;
        }

        public sc pFF(JSONObject jSONObject) {
            this.dE = jSONObject;
            return this;
        }

        public sc pFF(boolean z11) {
            this.Xc = z11;
            return this;
        }

        public sc sc(float f11) {
            this.We = f11;
            return this;
        }

        public sc sc(int i11) {
            this.BT = i11;
            return this;
        }

        public sc sc(long j11) {
            this.pFF = j11;
            return this;
        }

        public sc sc(SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray) {
            this.f28402sc = sparseArray;
            return this;
        }

        public sc sc(String str) {
            this.Tf = str;
            return this;
        }

        public sc sc(JSONObject jSONObject) {
            this.SR = jSONObject;
            return this;
        }

        public sc sc(boolean z11) {
            this.wjp = z11;
            return this;
        }

        public SR sc() {
            return new SR(this);
        }

        public sc zY(float f11) {
            this.TRI = f11;
            return this;
        }

        public sc zY(int i11) {
            this.Qj = i11;
            return this;
        }
    }

    private SR(@NonNull sc scVar) {
        this.wjp = false;
        this.f28400sc = scVar.f28401qr;
        this.pFF = scVar.TRI;
        this.zY = scVar.ExN;
        this.We = scVar.We;
        this.ExN = scVar.zY;
        this.TRI = scVar.pFF;
        this.f28399qr = scVar.Qj;
        this.Qj = scVar.Ol;
        this.Ol = scVar.WH;
        this.WH = scVar.UFX;
        this.UFX = scVar.Tf;
        this.SR = scVar.f28402sc;
        this.BT = scVar.wjp;
        this.Tf = scVar.Ql;
        this.Ql = scVar.SR;
        this.dE = scVar.BT;
        this.Xc = scVar.dE;
        this.wjp = scVar.Xc;
    }
}
