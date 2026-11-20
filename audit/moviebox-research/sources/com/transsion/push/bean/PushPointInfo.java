package com.transsion.push.bean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class PushPointInfo {
    public String evt;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f56835id;

    public PushPointInfo(int i11, String str) {
        this.f56835id = i11;
        this.evt = str;
    }

    public String toString() {
        return "PushPointInfo{id=" + this.f56835id + ", evt='" + this.evt + "'}";
    }
}
