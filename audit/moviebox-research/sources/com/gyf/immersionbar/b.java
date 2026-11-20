package com.gyf.immersionbar;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b implements Cloneable {
    public View A;
    public View B;
    public int D;
    public int E;
    public w M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41615a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41616b = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41617c = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f41618d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f41619f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f41620g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f41621h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f41622i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41623j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BarHide f41624k = BarHide.FLAG_SHOW_BAR;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f41625l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f41626m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f41627n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f41628o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f41629p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f41630q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f41631r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f41632s = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f41633t = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Map<View, Map<Integer, Integer>> f41634u = new HashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f41635v = 0.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f41636w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f41637x = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f41638y = 0.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f41639z = false;
    public boolean C = true;
    public boolean F = false;
    public boolean G = false;
    public int H = 18;
    public boolean I = true;
    public boolean J = true;
    public boolean K = true;
    public boolean L = true;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
