package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class DividerKt {
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x006a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:80:0x0115  */
    /* JADX WARN: Code duplicated, block: B:81:0x0134  */
    /* JADX WARN: Code duplicated, block: B:84:0x0164  */
    /* JADX WARN: Code duplicated, block: B:87:0x016f  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    public static final void a(androidx.compose.ui.f fVar, long j11, float f11, float f12, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        androidx.compose.ui.f fVar2;
        int i13;
        long jK;
        float fH;
        int i14;
        float fH2;
        int i15;
        androidx.compose.ui.f fVar3;
        androidx.compose.ui.f fVarI;
        float fH3;
        final float f13;
        final float f14;
        g2 g2VarJ;
        androidx.compose.runtime.i iVarG = iVar.g(-1249392198);
        int i16 = i12 & 1;
        if (i16 != 0) {
            i13 = i11 | 6;
            fVar2 = fVar;
        } else if ((i11 & 6) == 0) {
            fVar2 = fVar;
            i13 = (iVarG.Q(fVar2) ? 4 : 2) | i11;
        } else {
            fVar2 = fVar;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            jK = j11;
            i13 |= ((i12 & 2) == 0 && iVarG.d(jK)) ? 32 : 16;
        } else {
            jK = j11;
        }
        int i17 = i12 & 4;
        if (i17 == 0) {
            if ((i11 & 384) == 0) {
                fH = f11;
                i13 |= iVarG.b(fH) ? 256 : 128;
            }
            i14 = i12 & 8;
            if (i14 != 0) {
                if ((i11 & 3072) == 0) {
                    fH2 = f12;
                    if (iVarG.b(fH2)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i13 |= i15;
                }
                if ((i13 & 1171) == 1170 || !iVarG.h()) {
                    iVarG.B();
                    if ((i11 & 1) != 0 || iVarG.J()) {
                        if (i16 != 0) {
                            fVar3 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar3 = fVar2;
                        }
                        if ((i12 & 2) != 0) {
                            jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                            i13 &= -113;
                        }
                        if (i17 != 0) {
                            fH = q2.i.h(1);
                        }
                        if (i14 != 0) {
                            fH2 = q2.i.h(0);
                        }
                    } else {
                        iVarG.H();
                        if ((i12 & 2) != 0) {
                            i13 &= -113;
                        }
                        fVar3 = fVar2;
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                    }
                    if (fH2 == 0.0f) {
                        fVarI = androidx.compose.ui.f.f3863a;
                    } else {
                        fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    if (q2.i.j(fH, q2.i.f74232b.a())) {
                        iVarG.R(-129374855);
                        fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                        iVarG.L();
                    } else {
                        iVarG.R(-129316234);
                        iVarG.L();
                        fH3 = fH;
                    }
                    BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                } else {
                    iVarG.H();
                    fVar3 = fVar2;
                }
                f13 = fH;
                f14 = fH2;
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar4 = fVar3;
                    final long j12 = jK;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i18) {
                            DividerKt.a(fVar4, j12, f13, f14, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 3072;
            fH2 = f12;
            if ((i13 & 1171) == 1170) {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                } else {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                }
                if (fH2 == 0.0f) {
                    fVarI = androidx.compose.ui.f.f3863a;
                } else {
                    fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if (q2.i.j(fH, q2.i.f74232b.a())) {
                    iVarG.R(-129374855);
                    fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                    iVarG.L();
                } else {
                    iVarG.R(-129316234);
                    iVarG.L();
                    fH3 = fH;
                }
                BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
            } else {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                } else {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                }
                if (fH2 == 0.0f) {
                    fVarI = androidx.compose.ui.f.f3863a;
                } else {
                    fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if (q2.i.j(fH, q2.i.f74232b.a())) {
                    iVarG.R(-129374855);
                    fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                    iVarG.L();
                } else {
                    iVarG.R(-129316234);
                    iVarG.L();
                    fH3 = fH;
                }
                BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
            }
            f13 = fH;
            f14 = fH2;
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                final androidx.compose.ui.f fVar5 = fVar3;
                final long j13 = jK;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar2, int i18) {
                        DividerKt.a(fVar5, j13, f13, f14, iVar2, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 384;
        fH = f11;
        i14 = i12 & 8;
        if (i14 != 0) {
            if ((i11 & 3072) == 0) {
                fH2 = f12;
                if (iVarG.b(fH2)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i13 |= i15;
            }
            if ((i13 & 1171) == 1170) {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                } else {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                }
                if (fH2 == 0.0f) {
                    fVarI = androidx.compose.ui.f.f3863a;
                } else {
                    fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if (q2.i.j(fH, q2.i.f74232b.a())) {
                    iVarG.R(-129374855);
                    fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                    iVarG.L();
                } else {
                    iVarG.R(-129316234);
                    iVarG.L();
                    fH3 = fH;
                }
                BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
            } else {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                } else {
                    if (i16 != 0) {
                        fVar3 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar3 = fVar2;
                    }
                    if ((i12 & 2) != 0) {
                        jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i13 &= -113;
                    }
                    if (i17 != 0) {
                        fH = q2.i.h(1);
                    }
                    if (i14 != 0) {
                        fH2 = q2.i.h(0);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                }
                if (fH2 == 0.0f) {
                    fVarI = androidx.compose.ui.f.f3863a;
                } else {
                    fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if (q2.i.j(fH, q2.i.f74232b.a())) {
                    iVarG.R(-129374855);
                    fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                    iVarG.L();
                } else {
                    iVarG.R(-129316234);
                    iVarG.L();
                    fH3 = fH;
                }
                BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
            }
            f13 = fH;
            f14 = fH2;
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                final androidx.compose.ui.f fVar6 = fVar3;
                final long j14 = jK;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar2, int i18) {
                        DividerKt.a(fVar6, j14, f13, f14, iVar2, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 3072;
        fH2 = f12;
        if ((i13 & 1171) == 1170) {
            iVarG.B();
            if ((i11 & 1) != 0) {
                if (i16 != 0) {
                    fVar3 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar3 = fVar2;
                }
                if ((i12 & 2) != 0) {
                    jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i13 &= -113;
                }
                if (i17 != 0) {
                    fH = q2.i.h(1);
                }
                if (i14 != 0) {
                    fH2 = q2.i.h(0);
                }
            } else {
                if (i16 != 0) {
                    fVar3 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar3 = fVar2;
                }
                if ((i12 & 2) != 0) {
                    jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i13 &= -113;
                }
                if (i17 != 0) {
                    fH = q2.i.h(1);
                }
                if (i14 != 0) {
                    fH2 = q2.i.h(0);
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
            }
            if (fH2 == 0.0f) {
                fVarI = androidx.compose.ui.f.f3863a;
            } else {
                fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
            }
            if (q2.i.j(fH, q2.i.f74232b.a())) {
                iVarG.R(-129374855);
                fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                iVarG.L();
            } else {
                iVarG.R(-129316234);
                iVarG.L();
                fH3 = fH;
            }
            BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        } else {
            iVarG.B();
            if ((i11 & 1) != 0) {
                if (i16 != 0) {
                    fVar3 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar3 = fVar2;
                }
                if ((i12 & 2) != 0) {
                    jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i13 &= -113;
                }
                if (i17 != 0) {
                    fH = q2.i.h(1);
                }
                if (i14 != 0) {
                    fH2 = q2.i.h(0);
                }
            } else {
                if (i16 != 0) {
                    fVar3 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar3 = fVar2;
                }
                if ((i12 & 2) != 0) {
                    jK = w1.k(e.f3086a.a(iVarG, 6).g(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i13 &= -113;
                }
                if (i17 != 0) {
                    fH = q2.i.h(1);
                }
                if (i14 != 0) {
                    fH2 = q2.i.h(0);
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1249392198, i13, -1, "androidx.compose.material.Divider (Divider.kt:48)");
            }
            if (fH2 == 0.0f) {
                fVarI = androidx.compose.ui.f.f3863a;
            } else {
                fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, fH2, 0.0f, 0.0f, 0.0f, 14, null);
            }
            if (q2.i.j(fH, q2.i.f74232b.a())) {
                iVarG.R(-129374855);
                fH3 = q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity());
                iVarG.L();
            } else {
                iVarG.R(-129316234);
                iVarG.L();
                fH3 = fH;
            }
            BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar3.f(fVarI), 0.0f, 1, null), fH3), jK, null, 2, null), iVarG, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        f13 = fH;
        f14 = fH2;
        g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            final androidx.compose.ui.f fVar7 = fVar3;
            final long j15 = jK;
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i18) {
                    DividerKt.a(fVar7, j15, f13, f14, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
