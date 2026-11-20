package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ej extends xl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f18747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f18748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long[] f18749d;

    public ej() {
        super(new i7());
        this.f18747b = C.TIME_UNSET;
        this.f18748c = new long[0];
        this.f18749d = new long[0];
    }

    private static Object a(bh bhVar, int i11) {
        if (i11 == 8) {
            return e(bhVar);
        }
        if (i11 == 10) {
            return g(bhVar);
        }
        if (i11 == 11) {
            return c(bhVar);
        }
        if (i11 == 0) {
            return d(bhVar);
        }
        if (i11 == 1) {
            return b(bhVar);
        }
        if (i11 == 2) {
            return h(bhVar);
        }
        if (i11 != 3) {
            return null;
        }
        return f(bhVar);
    }

    private static Boolean b(bh bhVar) {
        return Boolean.valueOf(bhVar.w() == 1);
    }

    private static Date c(bh bhVar) {
        Date date = new Date((long) d(bhVar).doubleValue());
        bhVar.g(2);
        return date;
    }

    private static Double d(bh bhVar) {
        return Double.valueOf(Double.longBitsToDouble(bhVar.s()));
    }

    private static HashMap e(bh bhVar) {
        int iA = bhVar.A();
        HashMap map = new HashMap(iA);
        for (int i11 = 0; i11 < iA; i11++) {
            String strH = h(bhVar);
            Object objA = a(bhVar, i(bhVar));
            if (objA != null) {
                map.put(strH, objA);
            }
        }
        return map;
    }

    private static HashMap f(bh bhVar) {
        HashMap map = new HashMap();
        while (true) {
            String strH = h(bhVar);
            int i11 = i(bhVar);
            if (i11 == 9) {
                return map;
            }
            Object objA = a(bhVar, i11);
            if (objA != null) {
                map.put(strH, objA);
            }
        }
    }

    private static ArrayList g(bh bhVar) {
        int iA = bhVar.A();
        ArrayList arrayList = new ArrayList(iA);
        for (int i11 = 0; i11 < iA; i11++) {
            Object objA = a(bhVar, i(bhVar));
            if (objA != null) {
                arrayList.add(objA);
            }
        }
        return arrayList;
    }

    private static String h(bh bhVar) {
        int iC = bhVar.C();
        int iD = bhVar.d();
        bhVar.g(iC);
        return new String(bhVar.c(), iD, iC);
    }

    private static int i(bh bhVar) {
        return bhVar.w();
    }

    public long a() {
        return this.f18747b;
    }

    @Override // com.applovin.impl.xl
    public boolean a(bh bhVar) {
        return true;
    }

    @Override // com.applovin.impl.xl
    public boolean b(bh bhVar, long j11) {
        if (i(bhVar) != 2 || !"onMetaData".equals(h(bhVar)) || i(bhVar) != 8) {
            return false;
        }
        HashMap mapE = e(bhVar);
        Object obj = mapE.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f18747b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapE.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f18748c = new long[size];
                this.f18749d = new long[size];
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj5 = list.get(i11);
                    Object obj6 = list2.get(i11);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f18748c = new long[0];
                        this.f18749d = new long[0];
                        break;
                    }
                    this.f18748c[i11] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f18749d[i11] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long[] b() {
        return this.f18749d;
    }

    public long[] c() {
        return this.f18748c;
    }
}
