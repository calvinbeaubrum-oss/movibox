package com.bytedance.sdk.component.qr.zY;

import com.transsion.gslb.Utils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public boolean f26986sc = false;
    public boolean pFF = true;
    public Map<String, Integer> zY = null;
    public Map<String, String> We = null;
    public int ExN = 10;
    public int TRI = 1;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public int f26985qr = 1;
    public int Qj = 10;
    public int Ol = 1;
    public int WH = 1;
    public int UFX = 900;
    public int Tf = 120;
    public String Ql = null;
    public int SR = 0;
    public long BT = 0;

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" localEnable: ");
        sb2.append(this.f26986sc);
        sb2.append(" probeEnable: ");
        sb2.append(this.pFF);
        sb2.append(" hostFilter: ");
        Map<String, Integer> map = this.zY;
        sb2.append(map != null ? map.size() : 0);
        sb2.append(" hostMap: ");
        Map<String, String> map2 = this.We;
        sb2.append(map2 != null ? map2.size() : 0);
        sb2.append(" reqTo: ");
        sb2.append(this.ExN);
        sb2.append(Utils.SEPARATOR);
        sb2.append(this.TRI);
        sb2.append(Utils.SEPARATOR);
        sb2.append(this.f26985qr);
        sb2.append(" reqErr: ");
        sb2.append(this.Qj);
        sb2.append(Utils.SEPARATOR);
        sb2.append(this.Ol);
        sb2.append(Utils.SEPARATOR);
        sb2.append(this.WH);
        sb2.append(" updateInterval: ");
        sb2.append(this.UFX);
        sb2.append(" updateRandom: ");
        sb2.append(this.Tf);
        sb2.append(" httpBlack: ");
        sb2.append(this.Ql);
        return sb2.toString();
    }
}
