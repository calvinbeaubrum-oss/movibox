package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class JPJ {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, JPJ> f28025sc = new ConcurrentHashMap<>();
    private int ExN;
    private String TRI;
    private int We;
    private String pFF = "";
    private String zY = "";

    private void TRI() {
        this.pFF = "";
        this.zY = "";
        this.We = 0;
        this.ExN = 0;
    }

    public static void pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null || TextUtils.isEmpty(sfl.mD())) {
            return;
        }
        Integer numValueOf = Integer.valueOf(sfl.QT());
        if (numValueOf.intValue() == 0) {
            return;
        }
        if (f28025sc == null) {
            f28025sc = new ConcurrentHashMap<>();
        }
        JPJ jpj = f28025sc.containsKey(numValueOf) ? f28025sc.get(numValueOf) : null;
        if (jpj == null) {
            jpj = new JPJ();
        }
        String strOfL = sfl.ofL();
        if (TextUtils.isEmpty(strOfL) || !strOfL.equals(jpj.sc())) {
            jpj.TRI();
            jpj.sc(sfl);
            f28025sc.put(numValueOf, jpj);
        }
    }

    public static void zY(int i11) {
        JPJ jpj;
        if (i11 == 0) {
            return;
        }
        if (f28025sc == null) {
            f28025sc = new ConcurrentHashMap<>();
        }
        if (!f28025sc.containsKey(Integer.valueOf(i11)) || (jpj = f28025sc.get(Integer.valueOf(i11))) == null) {
            return;
        }
        jpj.pFF(1);
    }

    public static void zY(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        JPJ jpj;
        if (sfl == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(sfl.QT());
        if (numValueOf.intValue() == 0) {
            return;
        }
        if (f28025sc == null) {
            f28025sc = new ConcurrentHashMap<>();
        }
        if (!f28025sc.containsKey(numValueOf) || (jpj = f28025sc.get(numValueOf)) == null) {
            return;
        }
        jpj.sc(1);
    }

    public int ExN() {
        return this.ExN;
    }

    public int We() {
        return this.We;
    }

    public String pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.ExN = i11;
    }

    public String sc() {
        return this.TRI;
    }

    public void sc(int i11) {
        this.We = i11;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl != null) {
            String strOfL = sfl.ofL();
            if (!TextUtils.isEmpty(strOfL)) {
                this.TRI = strOfL;
            }
            String strKo = sfl.ko();
            if (TextUtils.isEmpty(strKo) && sfl.ymG()) {
                strKo = sfl.GOt().Ol();
            }
            if (!TextUtils.isEmpty(strKo)) {
                String[] strArrSplit = strKo.split("/");
                if (strArrSplit.length >= 3) {
                    this.pFF = strArrSplit[2];
                }
            }
            if (sfl.NP() == null || TextUtils.isEmpty(sfl.NP().zY())) {
                return;
            }
            this.zY = sfl.NP().zY();
        }
    }

    public String zY() {
        return this.zY;
    }
}
