package bh;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14228a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i11, boolean z11) {
        if ((i11 >>> 8) == 3368816) {
            return true;
        }
        if (i11 == 1751476579 && z11) {
            return true;
        }
        for (int i12 : f14228a) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(tg.m mVar) throws IOException {
        return c(mVar, true, false);
    }

    public static boolean c(tg.m mVar, boolean z11, boolean z12) throws IOException {
        boolean z13;
        boolean z14;
        int i11;
        long length = mVar.getLength();
        long j11 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j12 = -1;
        int i12 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i12 != 0 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j11 = length;
        }
        int i13 = (int) j11;
        c0 c0Var = new c0(64);
        boolean z15 = false;
        int i14 = 0;
        boolean z16 = false;
        while (true) {
            if (i14 < i13) {
                c0Var.L(8);
                if (mVar.peekFully(c0Var.d(), z15 ? 1 : 0, 8, true)) {
                    long jF = c0Var.F();
                    int iN = c0Var.n();
                    if (jF == 1) {
                        mVar.peekFully(c0Var.d(), 8, 8);
                        c0Var.O(16);
                        jF = c0Var.w();
                        i11 = 16;
                    } else {
                        if (jF == 0) {
                            long length2 = mVar.getLength();
                            if (length2 != j12) {
                                jF = (length2 - mVar.getPeekPosition()) + ((long) 8);
                            }
                        }
                        i11 = 8;
                    }
                    long j13 = i11;
                    if (jF < j13) {
                        return z15;
                    }
                    i14 += i11;
                    if (iN == 1836019574) {
                        i13 += (int) jF;
                        if (i12 != 0 && i13 > length) {
                            i13 = (int) length;
                        }
                        j12 = -1;
                    } else {
                        if (iN == 1836019558 || iN == 1836475768) {
                            z13 = true;
                            z14 = true;
                            if (z16 || z11 != z14) {
                                return false;
                            }
                            return z13;
                        }
                        int i15 = i12;
                        if ((((long) i14) + jF) - j13 < i13) {
                            int i16 = (int) (jF - j13);
                            i14 += i16;
                            if (iN == 1718909296) {
                                if (i16 < 8) {
                                    return false;
                                }
                                c0Var.L(i16);
                                mVar.peekFully(c0Var.d(), 0, i16);
                                int i17 = i16 / 4;
                                for (int i18 = 0; i18 < i17; i18++) {
                                    if (i18 != 1) {
                                        if (a(c0Var.n(), z12)) {
                                            z16 = true;
                                            break;
                                        }
                                    } else {
                                        c0Var.Q(4);
                                    }
                                }
                                if (!z16) {
                                    return false;
                                }
                            } else if (i16 != 0) {
                                mVar.advancePeekPosition(i16);
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

    public static boolean d(tg.m mVar, boolean z11) throws IOException {
        return c(mVar, false, z11);
    }
}
