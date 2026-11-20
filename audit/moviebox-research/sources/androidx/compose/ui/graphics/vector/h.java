package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f4531a = new float[0];

    public static final void a(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        double d21 = d13;
        double d22 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d19 * d22) / 3.141592653589793d));
        double dCos = Math.cos(d17);
        double dSin = Math.sin(d17);
        double dCos2 = Math.cos(d18);
        double dSin2 = Math.sin(d18);
        double d23 = -d21;
        double d24 = d23 * dCos;
        double d25 = d14 * dSin;
        double d26 = (d24 * dSin2) - (d25 * dCos2);
        double d27 = d23 * dSin;
        double d28 = d14 * dCos;
        double d29 = (dSin2 * d27) + (dCos2 * d28);
        double d31 = d19 / ((double) iCeil);
        double d32 = d15;
        double d33 = d18;
        double d34 = d29;
        double d35 = d26;
        int i11 = 0;
        double d36 = d16;
        while (i11 < iCeil) {
            double d37 = d33 + d31;
            double dSin3 = Math.sin(d37);
            double dCos3 = Math.cos(d37);
            int i12 = iCeil;
            double d38 = (d11 + ((d21 * dCos) * dCos3)) - (d25 * dSin3);
            double d39 = d12 + (d21 * dSin * dCos3) + (d28 * dSin3);
            double d40 = (d24 * dSin3) - (d25 * dCos3);
            double d41 = (dSin3 * d27) + (dCos3 * d28);
            double d42 = d37 - d33;
            double dTan = Math.tan(d42 / ((double) 2));
            double dSin4 = (Math.sin(d42) * (Math.sqrt(d22 + ((3.0d * dTan) * dTan)) - ((double) 1))) / ((double) 3);
            path.k((float) (d32 + (d35 * dSin4)), (float) (d36 + (d34 * dSin4)), (float) (d38 - (dSin4 * d40)), (float) (d39 - (dSin4 * d41)), (float) d38, (float) d39);
            i11++;
            d31 = d31;
            dSin = dSin;
            d32 = d38;
            d27 = d27;
            d33 = d37;
            d34 = d41;
            d22 = d22;
            d35 = d40;
            dCos = dCos;
            iCeil = i12;
            d36 = d39;
            d21 = d13;
        }
    }

    public static final void b(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, boolean z11, boolean z12) {
        double d18;
        double d19;
        double d21 = (d17 / ((double) 180)) * 3.141592653589793d;
        double dCos = Math.cos(d21);
        double dSin = Math.sin(d21);
        double d22 = ((d11 * dCos) + (d12 * dSin)) / d15;
        double d23 = (((-d11) * dSin) + (d12 * dCos)) / d16;
        double d24 = ((d13 * dCos) + (d14 * dSin)) / d15;
        double d25 = (((-d13) * dSin) + (d14 * dCos)) / d16;
        double d26 = d22 - d24;
        double d27 = d23 - d25;
        double d28 = 2;
        double d29 = (d22 + d24) / d28;
        double d31 = (d23 + d25) / d28;
        double d32 = (d26 * d26) + (d27 * d27);
        if (d32 == 0.0d) {
            return;
        }
        double d33 = (1.0d / d32) - 0.25d;
        if (d33 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d32) / 1.99999d);
            b(path, d11, d12, d13, d14, d15 * dSqrt, d16 * dSqrt, d17, z11, z12);
            return;
        }
        double dSqrt2 = Math.sqrt(d33);
        double d34 = d26 * dSqrt2;
        double d35 = dSqrt2 * d27;
        if (z11 == z12) {
            d18 = d29 - d35;
            d19 = d31 + d34;
        } else {
            d18 = d29 + d35;
            d19 = d31 - d34;
        }
        double dAtan2 = Math.atan2(d23 - d19, d22 - d18);
        double dAtan3 = Math.atan2(d25 - d19, d24 - d18) - dAtan2;
        if (z12 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d36 = d18 * d15;
        double d37 = d19 * d16;
        a(path, (d36 * dCos) - (d37 * dSin), (d36 * dSin) + (d37 * dCos), d15, d16, d11, d12, d21, dAtan2, dAtan3);
    }

    public static final Path c(List<? extends e> list, Path path) {
        float f11;
        float f12;
        float fC;
        float fE;
        float fD;
        float fD2;
        float f13;
        float f14;
        float f15;
        float f16;
        float fE2;
        float fD3;
        float f17;
        float f18;
        float f19;
        List<? extends e> list2 = list;
        Path path2 = path;
        int i11 = path.i();
        path.rewind();
        path2.d(i11);
        e eVar = list.isEmpty() ? e.b.f4478c : list2.get(0);
        int size = list.size();
        float f21 = 0.0f;
        float fC2 = 0.0f;
        float fD4 = 0.0f;
        float fC3 = 0.0f;
        float fD5 = 0.0f;
        int i12 = 0;
        float f22 = 0.0f;
        float f23 = 0.0f;
        while (i12 < size) {
            e eVar2 = list2.get(i12);
            if (eVar2 instanceof e.b) {
                path.close();
                fC2 = f22;
                fC3 = fC2;
                fD4 = f23;
                fD5 = fD4;
            } else {
                if (eVar2 instanceof e.n) {
                    e.n nVar = (e.n) eVar2;
                    fC3 += nVar.c();
                    fD5 += nVar.d();
                    path2.b(nVar.c(), nVar.d());
                    f22 = fC3;
                } else {
                    if (eVar2 instanceof e.f) {
                        e.f fVar = (e.f) eVar2;
                        float fC4 = fVar.c();
                        float fD6 = fVar.d();
                        path2.j(fVar.c(), fVar.d());
                        fC3 = fC4;
                        f22 = fC3;
                        fD5 = fD6;
                    } else {
                        if (eVar2 instanceof e.m) {
                            e.m mVar = (e.m) eVar2;
                            path2.m(mVar.c(), mVar.d());
                            fC3 += mVar.c();
                            f14 = mVar.d();
                        } else {
                            if (eVar2 instanceof e.C0057e) {
                                e.C0057e c0057e = (e.C0057e) eVar2;
                                path2.n(c0057e.c(), c0057e.d());
                                fD2 = c0057e.c();
                                f13 = c0057e.d();
                            } else if (eVar2 instanceof e.l) {
                                e.l lVar = (e.l) eVar2;
                                path2.m(lVar.c(), f21);
                                fC3 += lVar.c();
                            } else if (eVar2 instanceof e.d) {
                                e.d dVar = (e.d) eVar2;
                                path2.n(dVar.c(), fD5);
                                fC3 = dVar.c();
                            } else if (eVar2 instanceof e.r) {
                                e.r rVar = (e.r) eVar2;
                                path2.m(f21, rVar.c());
                                f14 = rVar.c();
                            } else if (eVar2 instanceof e.s) {
                                e.s sVar = (e.s) eVar2;
                                path2.n(fC3, sVar.c());
                                fD5 = sVar.c();
                            } else {
                                if (eVar2 instanceof e.k) {
                                    e.k kVar = (e.k) eVar2;
                                    path.c(kVar.c(), kVar.f(), kVar.d(), kVar.g(), kVar.e(), kVar.h());
                                    fC = kVar.d() + fC3;
                                    fE = kVar.g() + fD5;
                                    fC3 += kVar.e();
                                    fD = kVar.h();
                                } else {
                                    if (eVar2 instanceof e.c) {
                                        e.c cVar = (e.c) eVar2;
                                        path.k(cVar.c(), cVar.f(), cVar.d(), cVar.g(), cVar.e(), cVar.h());
                                        fC = cVar.d();
                                        fE2 = cVar.g();
                                        fD3 = cVar.e();
                                        f17 = cVar.h();
                                    } else if (eVar2 instanceof e.p) {
                                        if (eVar.a()) {
                                            f19 = fD5 - fD4;
                                            f18 = fC3 - fC2;
                                        } else {
                                            f18 = 0.0f;
                                            f19 = 0.0f;
                                        }
                                        e.p pVar = (e.p) eVar2;
                                        path.c(f18, f19, pVar.c(), pVar.e(), pVar.d(), pVar.f());
                                        fC = pVar.c() + fC3;
                                        fE = pVar.e() + fD5;
                                        fC3 += pVar.d();
                                        fD = pVar.f();
                                    } else if (eVar2 instanceof e.h) {
                                        if (eVar.a()) {
                                            float f24 = 2;
                                            f16 = (f24 * fD5) - fD4;
                                            f15 = (fC3 * f24) - fC2;
                                        } else {
                                            f15 = fC3;
                                            f16 = fD5;
                                        }
                                        e.h hVar = (e.h) eVar2;
                                        path.k(f15, f16, hVar.c(), hVar.e(), hVar.d(), hVar.f());
                                        fC = hVar.c();
                                        fE2 = hVar.e();
                                        fD3 = hVar.d();
                                        f17 = hVar.f();
                                    } else if (eVar2 instanceof e.o) {
                                        e.o oVar = (e.o) eVar2;
                                        path2.f(oVar.c(), oVar.e(), oVar.d(), oVar.f());
                                        fC2 = oVar.c() + fC3;
                                        fD4 = oVar.e() + fD5;
                                        fC3 += oVar.d();
                                        f14 = oVar.f();
                                    } else if (eVar2 instanceof e.g) {
                                        e.g gVar = (e.g) eVar2;
                                        path2.e(gVar.c(), gVar.e(), gVar.d(), gVar.f());
                                        fC2 = gVar.c();
                                        fD4 = gVar.e();
                                        fD2 = gVar.d();
                                        f13 = gVar.f();
                                    } else if (eVar2 instanceof e.q) {
                                        if (eVar.b()) {
                                            f11 = fC3 - fC2;
                                            f12 = fD5 - fD4;
                                        } else {
                                            f11 = 0.0f;
                                            f12 = 0.0f;
                                        }
                                        e.q qVar = (e.q) eVar2;
                                        path2.f(f11, f12, qVar.c(), qVar.d());
                                        fC = f11 + fC3;
                                        fE = f12 + fD5;
                                        fC3 += qVar.c();
                                        fD = qVar.d();
                                    } else if (eVar2 instanceof e.i) {
                                        if (eVar.b()) {
                                            float f25 = 2;
                                            fC3 = (fC3 * f25) - fC2;
                                            fD5 = (f25 * fD5) - fD4;
                                        }
                                        e.i iVar = (e.i) eVar2;
                                        path2.e(fC3, fD5, iVar.c(), iVar.d());
                                        float fC5 = iVar.c();
                                        fD4 = fD5;
                                        eVar2 = eVar2;
                                        i12 = i12;
                                        size = size;
                                        fD5 = iVar.d();
                                        float f26 = fC3;
                                        fC3 = fC5;
                                        fC2 = f26;
                                    } else if (eVar2 instanceof e.j) {
                                        e.j jVar = (e.j) eVar2;
                                        float fC6 = jVar.c() + fC3;
                                        float fD7 = jVar.d() + fD5;
                                        eVar2 = eVar2;
                                        i12 = i12;
                                        size = size;
                                        b(path, fC3, fD5, fC6, fD7, jVar.e(), jVar.g(), jVar.f(), jVar.h(), jVar.i());
                                        fD4 = fD7;
                                        fD5 = fD4;
                                        fC2 = fC6;
                                        fC3 = fC2;
                                    } else {
                                        eVar2 = eVar2;
                                        i12 = i12;
                                        size = size;
                                        if (eVar2 instanceof e.a) {
                                            e.a aVar = (e.a) eVar2;
                                            b(path, fC3, fD5, aVar.c(), aVar.d(), aVar.e(), aVar.g(), aVar.f(), aVar.h(), aVar.i());
                                            fC3 = aVar.c();
                                            fD4 = aVar.d();
                                            fD5 = fD4;
                                            fC2 = fC3;
                                        }
                                    }
                                    fC3 = fD3;
                                    fD5 = f17;
                                    fD4 = fE2;
                                    fC2 = fC;
                                }
                                fD5 += fD;
                                fD4 = fE;
                                fC2 = fC;
                            }
                            fD5 = f13;
                            fC3 = fD2;
                        }
                        fD5 += f14;
                    }
                    i12++;
                    path2 = path;
                    eVar = eVar2;
                    size = size;
                    f21 = 0.0f;
                    list2 = list;
                }
                f23 = fD5;
            }
            i12++;
            path2 = path;
            eVar = eVar2;
            size = size;
            f21 = 0.0f;
            list2 = list;
        }
        return path;
    }
}
