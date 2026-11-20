package com.mbridge.msdk.newreward.function.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f46149a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f46150b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f46151c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f46152d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f46153e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.d.a.b f46154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f46155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46156h = 21;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46157i = f46150b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<String> f46158j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f46159k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f46160l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<String> f46161m = new ArrayList();

    public final com.mbridge.msdk.newreward.function.d.a.b a() {
        return this.f46154f;
    }

    public final void a(int i11) {
        this.f46157i = i11;
    }

    public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar) {
        this.f46154f = bVar;
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f46158j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String b() {
        return this.f46155g;
    }

    public final void b(String str) {
        try {
            List<String> list = this.f46159k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String c() {
        ArrayList<String> arrayList = this.f46158j;
        return arrayList == null ? "" : arrayList.toString();
    }

    public final void c(String str) {
        try {
            List<String> list = this.f46160l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String d() {
        List<String> list = this.f46159k;
        return list == null ? "" : list.toString();
    }

    public final void d(String str) {
        this.f46155g = str;
    }

    public final String e() {
        List<String> list = this.f46160l;
        return list == null ? "" : list.toString();
    }

    public final String f() {
        List<String> list = this.f46161m;
        return list == null ? "" : list.toString();
    }

    public final int g() {
        return this.f46156h;
    }

    public final int h() {
        return this.f46157i;
    }
}
