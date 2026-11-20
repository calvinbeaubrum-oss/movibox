package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class mj {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Splitter f21166d = Splitter.on(':');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Splitter f21167e = Splitter.on('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f21168a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21169b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21170c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f21172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21173c;

        public a(int i11, long j11, int i12) {
            this.f21171a = i11;
            this.f21172b = j11;
            this.f21173c = i12;
        }
    }

    private static int a(String str) throws dh {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw dh.a("Invalid SEF name", null);
        }
    }

    private static jk a(bh bhVar, int i11) throws dh {
        ArrayList arrayList = new ArrayList();
        List<String> listSplitToList = f21167e.splitToList(bhVar.c(i11));
        for (int i12 = 0; i12 < listSplitToList.size(); i12++) {
            List<String> listSplitToList2 = f21166d.splitToList(listSplitToList.get(i12));
            if (listSplitToList2.size() != 3) {
                throw dh.a(null, null);
            }
            try {
                arrayList.add(new jk.b(Long.parseLong(listSplitToList2.get(0)), Long.parseLong(listSplitToList2.get(1)), 1 << (Integer.parseInt(listSplitToList2.get(2)) - 1)));
            } catch (NumberFormatException e11) {
                throw dh.a(null, e11);
            }
        }
        return new jk(arrayList);
    }

    private void a(l8 l8Var, th thVar) {
        bh bhVar = new bh(8);
        l8Var.d(bhVar.c(), 0, 8);
        this.f21170c = bhVar.m() + 8;
        if (bhVar.j() != 1397048916) {
            thVar.f23379a = 0L;
        } else {
            thVar.f23379a = l8Var.f() - ((long) (this.f21170c - 12));
            this.f21169b = 2;
        }
    }

    private void a(l8 l8Var, List list) throws dh {
        long jF = l8Var.f();
        int iA = (int) ((l8Var.a() - l8Var.f()) - ((long) this.f21170c));
        bh bhVar = new bh(iA);
        l8Var.d(bhVar.c(), 0, iA);
        for (int i11 = 0; i11 < this.f21168a.size(); i11++) {
            a aVar = (a) this.f21168a.get(i11);
            bhVar.f((int) (aVar.f21172b - jF));
            bhVar.g(4);
            int iM = bhVar.m();
            int iA2 = a(bhVar.c(iM));
            int i12 = aVar.f21173c - (iM + 8);
            if (iA2 == 2192) {
                list.add(a(bhVar, i12));
            } else if (iA2 != 2816 && iA2 != 2817 && iA2 != 2819 && iA2 != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private void b(l8 l8Var, th thVar) {
        long jA = l8Var.a();
        int i11 = this.f21170c - 20;
        bh bhVar = new bh(i11);
        l8Var.d(bhVar.c(), 0, i11);
        for (int i12 = 0; i12 < i11 / 12; i12++) {
            bhVar.g(2);
            short sO = bhVar.o();
            if (sO == 2192 || sO == 2816 || sO == 2817 || sO == 2819 || sO == 2820) {
                this.f21168a.add(new a(sO, (jA - ((long) this.f21170c)) - ((long) bhVar.m()), bhVar.m()));
            } else {
                bhVar.g(8);
            }
        }
        if (this.f21168a.isEmpty()) {
            thVar.f23379a = 0L;
        } else {
            this.f21169b = 3;
            thVar.f23379a = ((a) this.f21168a.get(0)).f21172b;
        }
    }

    public int a(l8 l8Var, th thVar, List list) throws dh {
        int i11 = this.f21169b;
        long j11 = 0;
        if (i11 == 0) {
            long jA = l8Var.a();
            if (jA != -1 && jA >= 8) {
                j11 = jA - 8;
            }
            thVar.f23379a = j11;
            this.f21169b = 1;
        } else if (i11 == 1) {
            a(l8Var, thVar);
        } else if (i11 == 2) {
            b(l8Var, thVar);
        } else {
            if (i11 != 3) {
                throw new IllegalStateException();
            }
            a(l8Var, list);
            thVar.f23379a = 0L;
        }
        return 1;
    }

    public void a() {
        this.f21168a.clear();
        this.f21169b = 0;
    }
}
