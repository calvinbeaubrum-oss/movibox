package com.applovin.impl;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class lk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f20474a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i11, boolean z11) {
        if ((i11 >>> 8) == 3368816) {
            return true;
        }
        if (i11 == 1751476579 && z11) {
            return true;
        }
        for (int i12 : f20474a) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(l8 l8Var) {
        return a(l8Var, true, false);
    }

    public static boolean a(l8 l8Var, boolean z11) {
        return a(l8Var, false, z11);
    }

    private static boolean a(l8 l8Var, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        int i11;
        long jA = l8Var.a();
        long j11 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j12 = -1;
        int i12 = (jA > (-1L) ? 1 : (jA == (-1L) ? 0 : -1));
        if (i12 != 0 && jA <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j11 = jA;
        }
        int i13 = (int) j11;
        bh bhVar = new bh(64);
        boolean z15 = false;
        int i14 = 0;
        boolean z16 = false;
        while (true) {
            if (i14 < i13) {
                bhVar.d(8);
                if (l8Var.b(bhVar.c(), z15 ? 1 : 0, 8, true)) {
                    long jY = bhVar.y();
                    int iJ = bhVar.j();
                    if (jY == 1) {
                        l8Var.c(bhVar.c(), 8, 8);
                        bhVar.e(16);
                        jY = bhVar.s();
                        i11 = 16;
                    } else {
                        if (jY == 0) {
                            long jA2 = l8Var.a();
                            if (jA2 != j12) {
                                jY = (jA2 - l8Var.d()) + ((long) 8);
                            }
                        }
                        i11 = 8;
                    }
                    long j13 = i11;
                    if (jY < j13) {
                        return z15;
                    }
                    i14 += i11;
                    if (iJ == 1836019574) {
                        i13 += (int) jY;
                        if (i12 != 0 && i13 > jA) {
                            i13 = (int) jA;
                        }
                        j12 = -1;
                    } else {
                        if (iJ == 1836019558 || iJ == 1836475768) {
                            z13 = true;
                            z14 = true;
                            if (z16 || z11 != z14) {
                                return false;
                            }
                            return z13;
                        }
                        int i15 = i12;
                        if ((((long) i14) + jY) - j13 < i13) {
                            int i16 = (int) (jY - j13);
                            i14 += i16;
                            if (iJ == 1718909296) {
                                if (i16 < 8) {
                                    return false;
                                }
                                bhVar.d(i16);
                                l8Var.c(bhVar.c(), 0, i16);
                                int i17 = i16 / 4;
                                for (int i18 = 0; i18 < i17; i18++) {
                                    if (i18 != 1) {
                                        if (a(bhVar.j(), z12)) {
                                            z16 = true;
                                            break;
                                        }
                                    } else {
                                        bhVar.g(4);
                                    }
                                }
                                if (!z16) {
                                    return false;
                                }
                            } else if (i16 != 0) {
                                l8Var.c(i16);
                            }
                            i12 = i15;
                            j12 = -1;
                            z15 = false;
                        }
                    }
                }
            }
            z13 = true;
            z14 = false;
            if (z16) {
            }
            return false;
        }
    }
}
