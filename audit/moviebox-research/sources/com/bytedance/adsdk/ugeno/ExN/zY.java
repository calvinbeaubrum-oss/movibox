package com.bytedance.adsdk.ugeno.ExN;

import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    int BT;
    int ExN;
    int Ol;
    int Qj;
    int Ql;
    int TRI;
    int Tf;
    float UFX;
    float WH;
    boolean Xc;
    int dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    int f26319qr;
    boolean wjp;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    int f26320sc = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    int pFF = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    int zY = Integer.MIN_VALUE;
    int We = Integer.MIN_VALUE;
    List<Integer> SR = new ArrayList();

    public int pFF() {
        return this.Qj - this.Ol;
    }

    public int sc() {
        return this.f26319qr;
    }

    public void sc(View view, int i11, int i12, int i13, int i14) {
        pFF pff = (pFF) view.getLayoutParams();
        this.f26320sc = Math.min(this.f26320sc, (view.getLeft() - pff.Ql()) - i11);
        this.pFF = Math.min(this.pFF, (view.getTop() - pff.SR()) - i12);
        this.zY = Math.max(this.zY, view.getRight() + pff.BT() + i13);
        this.We = Math.max(this.We, view.getBottom() + pff.dE() + i14);
    }
}
