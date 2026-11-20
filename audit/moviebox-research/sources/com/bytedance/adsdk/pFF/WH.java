package com.bytedance.adsdk.pFF;

import android.graphics.Bitmap;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {
    private final String ExN;
    private final int[][] Ol;
    private final String Qj;
    private final String TRI;
    private Bitmap UFX;
    private final JSONArray WH;
    private final String We;
    private final int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final List<sc> f26159qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f26160sc;
    private final String zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public int ExN;
        public int TRI;
        public String We;
        public int pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        public String f26161qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f26162sc;
        public String zY;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public WH(int i11, int i12, String str, String str2, String str3, String str4, List<sc> list, String str5, int[][] iArr, JSONArray jSONArray) {
        this.f26160sc = i11;
        this.pFF = i12;
        this.zY = str;
        this.We = str2;
        this.ExN = str3;
        this.TRI = str4;
        this.f26159qr = list;
        this.Qj = str5;
        this.Ol = iArr;
        this.WH = jSONArray;
    }

    public String ExN() {
        return this.Qj;
    }

    public String Ol() {
        return this.We;
    }

    public String Qj() {
        return this.zY;
    }

    public int[][] TRI() {
        return this.Ol;
    }

    public Bitmap UFX() {
        return this.UFX;
    }

    public String WH() {
        return this.ExN;
    }

    public String We() {
        return this.TRI;
    }

    public int pFF() {
        return this.pFF;
    }

    public JSONArray qr() {
        return this.WH;
    }

    public int sc() {
        return this.f26160sc;
    }

    public void sc(Bitmap bitmap) {
        this.UFX = bitmap;
    }

    public List<sc> zY() {
        return this.f26159qr;
    }
}
