package com.bytedance.sdk.component.ExN.zY;

import android.content.Context;
import com.bytedance.sdk.component.ExN.Dl;
import com.bytedance.sdk.component.ExN.Ql;
import com.bytedance.sdk.component.ExN.Sfl;
import com.bytedance.sdk.component.ExN.Tf;
import com.bytedance.sdk.component.ExN.Xc;
import com.bytedance.sdk.component.ExN.wjp;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements Ql {
    private Sfl ExN;
    private Dl Ol;
    private com.bytedance.sdk.component.ExN.pFF Qj;
    private com.bytedance.sdk.component.ExN.zY TRI;
    private wjp We;
    private ExecutorService pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Xc f26501qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Tf f26502sc;
    private com.bytedance.sdk.component.ExN.We zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private Sfl ExN;
        private Dl Ol;
        private com.bytedance.sdk.component.ExN.pFF Qj;
        private com.bytedance.sdk.component.ExN.zY TRI;
        private wjp We;
        private ExecutorService pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private Xc f26503qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private Tf f26504sc;
        private com.bytedance.sdk.component.ExN.We zY;

        public sc sc(Dl dl2) {
            this.Ol = dl2;
            return this;
        }

        public sc sc(com.bytedance.sdk.component.ExN.We we2) {
            this.zY = we2;
            return this;
        }

        public sc sc(com.bytedance.sdk.component.ExN.pFF pff) {
            this.Qj = pff;
            return this;
        }

        public ExN sc() {
            return new ExN(this);
        }
    }

    private ExN(sc scVar) {
        this.f26502sc = scVar.f26504sc;
        this.pFF = scVar.pFF;
        this.zY = scVar.zY;
        this.We = scVar.We;
        this.ExN = scVar.ExN;
        this.TRI = scVar.TRI;
        this.Qj = scVar.Qj;
        this.f26501qr = scVar.f26503qr;
        this.Ol = scVar.Ol;
    }

    public static ExN sc(Context context) {
        return new sc().sc();
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public wjp ExN() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public com.bytedance.sdk.component.ExN.pFF Ol() {
        return this.Qj;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public Xc Qj() {
        return this.f26501qr;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public Sfl TRI() {
        return this.ExN;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public com.bytedance.sdk.component.ExN.We We() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public ExecutorService pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public com.bytedance.sdk.component.ExN.zY qr() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public Tf sc() {
        return this.f26502sc;
    }

    @Override // com.bytedance.sdk.component.ExN.Ql
    public Dl zY() {
        return this.Ol;
    }
}
