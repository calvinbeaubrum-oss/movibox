package com.bytedance.adsdk.ugeno.sc;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private long ExN;
    private JSONObject Qj;
    private sc TRI;
    private String We;
    private long pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f26448qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Map<String, TreeMap<Float, String>> f26449sc;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public String f26450sc;
    }

    public String ExN() {
        return this.We;
    }

    public String Qj() {
        return this.f26448qr;
    }

    public long TRI() {
        return this.ExN;
    }

    public int We() {
        return this.zY;
    }

    public Map<String, TreeMap<Float, String>> pFF() {
        return this.f26449sc;
    }

    public void pFF(long j11) {
        this.ExN = j11;
    }

    public void pFF(String str) {
        this.f26448qr = str;
    }

    public sc qr() {
        return this.TRI;
    }

    public JSONObject sc() {
        return this.Qj;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public void sc(long j11) {
        this.pFF = j11;
    }

    public void sc(sc scVar) {
        this.TRI = scVar;
    }

    public void sc(String str) {
        this.We = str;
    }

    public void sc(Map<String, TreeMap<Float, String>> map) {
        this.f26449sc = map;
    }

    public void sc(JSONObject jSONObject) {
        this.Qj = jSONObject;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.f26449sc + ", mDuration=" + this.pFF + ", mPlayCount=" + this.zY + ", mPlayDirection=" + this.We + ", mDelay=" + this.ExN + ", mTransformOrigin='" + this.TRI + "', mTimingFunction='" + this.f26448qr + "'}";
    }

    public long zY() {
        return this.pFF;
    }
}
