package com.bytedance.adsdk.pFF;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {
    private Map<String, com.bytedance.adsdk.pFF.zY.zY> ExN;
    private List<com.bytedance.adsdk.pFF.zY.zY.ExN> Ol;
    private LongSparseArray<com.bytedance.adsdk.pFF.zY.zY.ExN> Qj;
    private float Ql;
    private boolean SR;
    private pFF Sfl;
    private List<com.bytedance.adsdk.pFF.zY.TRI> TRI;
    private float Tf;
    private float UFX;
    private Rect WH;
    private Map<String, WH> We;
    private zY dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private SparseArray<com.bytedance.adsdk.pFF.zY.We> f26172qr;
    private sc wjp;
    private Map<String, List<com.bytedance.adsdk.pFF.zY.zY.ExN>> zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final wjp f26173sc = new wjp();
    private final HashSet<String> pFF = new HashSet<>();
    private int BT = 0;
    private String Xc = "";

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        public int[][] pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public String f26174sc;
        public JSONArray zY;
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public int ExN;
        public String TRI;
        public int We;
        public Map<String, Object> pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        public JSONArray f26175qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f26176sc;
        public Map<String, Object> zY;
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY {
        public int[] ExN;
        public String TRI;
        public String We;
        public String pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        public JSONArray f26177qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f26178sc;
        public String zY;
    }

    public Map<String, com.bytedance.adsdk.pFF.zY.zY> BT() {
        return this.ExN;
    }

    public float ExN() {
        return (long) ((Xc() / this.Ql) * 1000.0f);
    }

    public String Ol() {
        return this.Xc;
    }

    public zY Qj() {
        return this.dE;
    }

    public List<com.bytedance.adsdk.pFF.zY.zY.ExN> Ql() {
        return this.Ol;
    }

    public SparseArray<com.bytedance.adsdk.pFF.zY.We> SR() {
        return this.f26172qr;
    }

    public float TRI() {
        return this.UFX;
    }

    public float Tf() {
        return this.Ql;
    }

    public sc UFX() {
        return this.wjp;
    }

    public pFF WH() {
        return this.Sfl;
    }

    public Rect We() {
        return this.WH;
    }

    public float Xc() {
        return this.Tf - this.UFX;
    }

    public Map<String, WH> dE() {
        return this.We;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int pFF() {
        return this.BT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.bytedance.adsdk.pFF.zY.zY.ExN> pFF(String str) {
        return this.zY.get(str);
    }

    public void pFF(boolean z11) {
        this.f26173sc.sc(z11);
    }

    public float qr() {
        return this.Tf;
    }

    public float sc(float f11) {
        return com.bytedance.adsdk.pFF.TRI.ExN.sc(this.UFX, this.Tf, f11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.bytedance.adsdk.pFF.zY.zY.ExN sc(long j11) {
        return this.Qj.get(j11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void sc(int i11) {
        this.BT += i11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void sc(Rect rect, float f11, float f12, float f13, List<com.bytedance.adsdk.pFF.zY.zY.ExN> list, LongSparseArray<com.bytedance.adsdk.pFF.zY.zY.ExN> longSparseArray, Map<String, List<com.bytedance.adsdk.pFF.zY.zY.ExN>> map, Map<String, WH> map2, SparseArray<com.bytedance.adsdk.pFF.zY.We> sparseArray, Map<String, com.bytedance.adsdk.pFF.zY.zY> map3, List<com.bytedance.adsdk.pFF.zY.TRI> list2, zY zYVar, String str, sc scVar, pFF pff) {
        this.WH = rect;
        this.UFX = f11;
        this.Tf = f12;
        this.Ql = f13;
        this.Ol = list;
        this.Qj = longSparseArray;
        this.zY = map;
        this.We = map2;
        this.f26172qr = sparseArray;
        this.ExN = map3;
        this.TRI = list2;
        this.dE = zYVar;
        this.Xc = str;
        this.wjp = scVar;
        this.Sfl = pff;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void sc(String str) {
        this.pFF.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void sc(boolean z11) {
        this.SR = z11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean sc() {
        return this.SR;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.pFF.zY.zY.ExN> it = this.Ol.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().sc("\t"));
        }
        return sb2.toString();
    }

    public wjp zY() {
        return this.f26173sc;
    }

    public com.bytedance.adsdk.pFF.zY.TRI zY(String str) {
        int size = this.TRI.size();
        for (int i11 = 0; i11 < size; i11++) {
            com.bytedance.adsdk.pFF.zY.TRI tri = this.TRI.get(i11);
            if (tri.sc(str)) {
                return tri;
            }
        }
        return null;
    }
}
