package com.mbridge.msdk.foundation.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f44009a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f44010b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f44011c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f44012d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f44013e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f44014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f44015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f44016h = 21;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f44017i = f44010b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<String> f44018j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f44019k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f44020l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<String> f44021m = new ArrayList();

    public final CopyOnWriteArrayList<CampaignEx> a() {
        return this.f44014f;
    }

    public final void a(int i11) {
        this.f44017i = i11;
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f44018j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f44014f = copyOnWriteArrayList;
    }

    public final String b() {
        return this.f44015g;
    }

    public final void b(String str) {
        try {
            List<String> list = this.f44019k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String c() {
        ArrayList<String> arrayList = this.f44018j;
        return arrayList == null ? "" : arrayList.toString();
    }

    public final void c(String str) {
        try {
            List<String> list = this.f44020l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String d() {
        List<String> list = this.f44019k;
        return list == null ? "" : list.toString();
    }

    public final void d(String str) {
        this.f44015g = str;
    }

    public final String e() {
        List<String> list = this.f44020l;
        return list == null ? "" : list.toString();
    }

    public final String f() {
        List<String> list = this.f44021m;
        return list == null ? "" : list.toString();
    }

    public final int g() {
        return this.f44017i;
    }
}
