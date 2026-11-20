package l5;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import u4.t;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f69927a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i11, boolean z11) {
        if ((i11 >>> 8) == 3368816) {
            return true;
        }
        if (i11 == 1751476579 && z11) {
            return true;
        }
        for (int i12 : f69927a) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(t tVar) throws IOException {
        return c(tVar, true, false);
    }

    public static boolean c(t tVar, boolean z11, boolean z12) throws IOException {
        boolean z13;
        boolean z14;
        int i11;
        boolean z15;
        long length = tVar.getLength();
        long j11 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j12 = -1;
        int i12 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i12 != 0 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j11 = length;
        }
        int i13 = (int) j11;
        c0 c0Var = new c0(64);
        boolean z16 = false;
        int i14 = 0;
        boolean z17 = false;
        while (true) {
            if (i14 < i13) {
                c0Var.Q(8);
                if (tVar.peekFully(c0Var.e(), z16 ? 1 : 0, 8, true)) {
                    long J = c0Var.J();
                    int iQ = c0Var.q();
                    if (J == 1) {
                        tVar.peekFully(c0Var.e(), 8, 8);
                        c0Var.T(16);
                        J = c0Var.A();
                        i11 = 16;
                    } else {
                        if (J == 0) {
                            long length2 = tVar.getLength();
                            if (length2 != j12) {
                                J = (length2 - tVar.getPeekPosition()) + ((long) 8);
                            }
                        }
                        i11 = 8;
                    }
                    long j13 = i11;
                    if (J < j13) {
                        return z16;
                    }
                    i14 += i11;
                    if (iQ == 1836019574) {
                        i13 += (int) J;
                        if (i12 != 0 && i13 > length) {
                            i13 = (int) length;
                        }
                        j12 = -1;
                    } else if (iQ == 1836019558 || iQ == 1836475768) {
                        z13 = true;
                        z14 = true;
                    } else {
                        if (iQ == 1835295092) {
                            z17 = true;
                        }
                        if ((((long) i14) + J) - j13 >= i13) {
                            z14 = false;
                            z13 = true;
                        } else {
                            int i15 = (int) (J - j13);
                            i14 += i15;
                            if (iQ == 1718909296) {
                                if (i15 < 8) {
                                    return false;
                                }
                                c0Var.Q(i15);
                                tVar.peekFully(c0Var.e(), 0, i15);
                                int i16 = i15 / 4;
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= i16) {
                                        z15 = z17;
                                        break;
                                    }
                                    if (i17 == 1) {
                                        c0Var.V(4);
                                    } else if (a(c0Var.q(), z12)) {
                                        z15 = true;
                                        break;
                                    }
                                    i17++;
                                }
                                if (!z15) {
                                    return false;
                                }
                                z17 = z15;
                            } else if (i15 != 0) {
                                tVar.advancePeekPosition(i15);
                            }
                            i12 = i12;
                            j12 = -1;
                            z16 = false;
                        }
                    }
                }
                if (z17 || z11 != z14) {
                    return false;
                }
                return z13;
            }
            z13 = true;
            z14 = false;
            if (z17) {
            }
            return false;
        }
    }

    public static boolean d(t tVar, boolean z11) throws IOException {
        return c(tVar, false, z11);
    }
}
