package com.applovin.impl;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c6 implements o8 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f18095n = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Constructor f18096o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f18097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18105j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18107l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18106k = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18108m = 112800;

    static {
        Constructor constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.applovin.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.applovin.exoplayer2.ext.flac.FlacExtractor").asSubclass(k8.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e11) {
            throw new RuntimeException("Error instantiating FLAC extension", e11);
        }
        f18096o = constructor;
    }

    private void a(int i11, List list) {
        switch (i11) {
            case 0:
                list.add(new i());
                return;
            case 1:
                list.add(new l());
                return;
            case 2:
                list.add(new j0((this.f18098c ? 2 : 0) | ((this.f18099d | (this.f18097b ? 1 : 0)) == true ? 1 : 0)));
                return;
            case 3:
                list.add(new q0((this.f18098c ? 2 : 0) | this.f18100e | (this.f18097b ? 1 : 0)));
                return;
            case 4:
                Constructor constructor = f18096o;
                if (constructor == null) {
                    list.add(new v8(this.f18101f));
                    return;
                }
                try {
                    list.add((k8) constructor.newInstance(Integer.valueOf(this.f18101f)));
                    return;
                } catch (Exception e11) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e11);
                }
            case 5:
                list.add(new e9());
                return;
            case 6:
                list.add(new yc(this.f18102g));
                return;
            case 7:
                list.add(new of((this.f18098c ? 2 : 0) | this.f18105j | (this.f18097b ? 1 : 0)));
                return;
            case 8:
                list.add(new j9(this.f18104i));
                list.add(new pf(this.f18103h));
                return;
            case 9:
                list.add(new hg());
                return;
            case 10:
                list.add(new ii());
                return;
            case 11:
                list.add(new cp(this.f18106k, this.f18107l, this.f18108m));
                return;
            case 12:
                list.add(new lr());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new yb());
                return;
        }
    }

    @Override // com.applovin.impl.o8
    public synchronized k8[] a() {
        return a(Uri.EMPTY, new HashMap());
    }

    @Override // com.applovin.impl.o8
    public synchronized k8[] a(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(14);
            int iA = q8.a(map);
            if (iA != -1) {
                a(iA, arrayList);
            }
            int iA2 = q8.a(uri);
            if (iA2 != -1 && iA2 != iA) {
                a(iA2, arrayList);
            }
            for (int i11 : f18095n) {
                if (i11 != iA && i11 != iA2) {
                    a(i11, arrayList);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (k8[]) arrayList.toArray(new k8[arrayList.size()]);
    }
}
