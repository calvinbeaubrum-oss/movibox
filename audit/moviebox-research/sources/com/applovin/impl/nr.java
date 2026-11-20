package com.applovin.impl;

import android.util.Pair;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class nr {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f21420b;

        private a(int i11, long j11) {
            this.f21419a = i11;
            this.f21420b = j11;
        }

        public static a a(l8 l8Var, bh bhVar) {
            l8Var.c(bhVar.c(), 0, 8);
            bhVar.f(0);
            return new a(bhVar.j(), bhVar.p());
        }
    }

    public static mr a(l8 l8Var) {
        byte[] bArr;
        b1.a(l8Var);
        bh bhVar = new bh(16);
        if (a.a(l8Var, bhVar).f21419a != 1380533830) {
            return null;
        }
        l8Var.c(bhVar.c(), 0, 4);
        bhVar.f(0);
        int iJ = bhVar.j();
        if (iJ != 1463899717) {
            pc.b("WavHeaderReader", "Unsupported RIFF format: " + iJ);
            return null;
        }
        a aVarA = a.a(l8Var, bhVar);
        while (aVarA.f21419a != 1718449184) {
            l8Var.c((int) aVarA.f21420b);
            aVarA = a.a(l8Var, bhVar);
        }
        b1.b(aVarA.f21420b >= 16);
        l8Var.c(bhVar.c(), 0, 16);
        bhVar.f(0);
        int iR = bhVar.r();
        int iR2 = bhVar.r();
        int iQ = bhVar.q();
        int iQ2 = bhVar.q();
        int iR3 = bhVar.r();
        int iR4 = bhVar.r();
        int i11 = ((int) aVarA.f21420b) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            l8Var.c(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = xp.f24377f;
        }
        return new mr(iR, iR2, iQ, iQ2, iR3, iR4, bArr);
    }

    public static Pair b(l8 l8Var) throws dh {
        b1.a(l8Var);
        l8Var.b();
        bh bhVar = new bh(8);
        a aVarA = a.a(l8Var, bhVar);
        while (true) {
            int i11 = aVarA.f21419a;
            if (i11 == 1684108385) {
                l8Var.a(8);
                long jF = l8Var.f();
                long j11 = aVarA.f21420b + jF;
                long jA = l8Var.a();
                if (jA != -1 && j11 > jA) {
                    pc.d("WavHeaderReader", "Data exceeds input length: " + j11 + ", " + jA);
                    j11 = jA;
                }
                return Pair.create(Long.valueOf(jF), Long.valueOf(j11));
            }
            if (i11 != 1380533830 && i11 != 1718449184) {
                pc.d("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f21419a);
            }
            long j12 = aVarA.f21420b + 8;
            if (aVarA.f21419a == 1380533830) {
                j12 = 12;
            }
            if (j12 > 2147483647L) {
                throw dh.a("Chunk is too large (~2GB+) to skip; id: " + aVarA.f21419a);
            }
            l8Var.a((int) j12);
            aVarA = a.a(l8Var, bhVar);
        }
    }
}
