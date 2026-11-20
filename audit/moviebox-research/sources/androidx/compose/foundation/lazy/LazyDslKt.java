package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
public final class LazyDslKt {
    /* JADX WARN: Code duplicated, block: B:102:0x0115  */
    /* JADX WARN: Code duplicated, block: B:106:0x012c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0139  */
    /* JADX WARN: Code duplicated, block: B:121:0x0161 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x0163  */
    /* JADX WARN: Code duplicated, block: B:123:0x0166  */
    /* JADX WARN: Code duplicated, block: B:126:0x016d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0175  */
    /* JADX WARN: Code duplicated, block: B:129:0x0179  */
    /* JADX WARN: Code duplicated, block: B:130:0x0183  */
    /* JADX WARN: Code duplicated, block: B:133:0x0187  */
    /* JADX WARN: Code duplicated, block: B:136:0x018c  */
    /* JADX WARN: Code duplicated, block: B:138:0x0190  */
    /* JADX WARN: Code duplicated, block: B:139:0x0195  */
    /* JADX WARN: Code duplicated, block: B:141:0x019c  */
    /* JADX WARN: Code duplicated, block: B:143:0x019f  */
    /* JADX WARN: Code duplicated, block: B:144:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:151:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:154:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:157:0x021d  */
    /* JADX WARN: Code duplicated, block: B:161:0x022a  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00da  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:93:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:95:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:97:0x0104  */
    /* JADX WARN: Code duplicated, block: B:98:0x0107  */
    public static final void a(androidx.compose.ui.f fVar, LazyListState lazyListState, androidx.compose.foundation.layout.t tVar, boolean z11, androidx.compose.foundation.layout.b.k kVar, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, androidx.compose.foundation.gestures.g gVar, boolean z12, final Function1<? super u, Unit> function1, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.foundation.layout.t tVar2;
        int i14;
        boolean z13;
        int i15;
        androidx.compose.foundation.layout.b.k kVar2;
        int i16;
        androidx.compose.ui.b.InterfaceC0052b interfaceC0052b2;
        int i17;
        androidx.compose.foundation.gestures.g gVar2;
        int i18;
        int i19;
        int i21;
        androidx.compose.ui.f fVar2;
        LazyListState lazyListStateC;
        androidx.compose.foundation.layout.t tVarA;
        boolean z14;
        androidx.compose.foundation.layout.b.k kVarA;
        androidx.compose.ui.b.InterfaceC0052b interfaceC0052bI;
        androidx.compose.foundation.gestures.g gVarA;
        boolean z15;
        androidx.compose.foundation.layout.b bVar;
        final boolean z16;
        final androidx.compose.foundation.layout.b.k kVar3;
        final androidx.compose.foundation.gestures.g gVar3;
        boolean z17;
        g2 g2VarJ;
        androidx.compose.runtime.i iVarG = iVar.g(-740714857);
        int i22 = i12 & 1;
        if (i22 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= ((i12 & 2) == 0 && iVarG.Q(lazyListState)) ? 32 : 16;
        }
        int i23 = i12 & 4;
        if (i23 == 0) {
            if ((i11 & 384) == 0) {
                tVar2 = tVar;
                i13 |= iVarG.Q(tVar2) ? 256 : 128;
            }
            i14 = i12 & 8;
            if (i14 != 0) {
                if ((i11 & 3072) == 0) {
                    z13 = z11;
                    if (iVarG.a(z13)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i13 |= i15;
                }
                if ((i11 & 24576) == 0) {
                    if ((i12 & 16) == 0) {
                        kVar2 = kVar;
                        int i24 = iVarG.Q(kVar2) ? 16384 : 8192;
                        i13 |= i24;
                    } else {
                        kVar2 = kVar;
                    }
                    i13 |= i24;
                } else {
                    kVar2 = kVar;
                }
                i16 = i12 & 32;
                if (i16 != 0) {
                    if ((196608 & i11) == 0) {
                        interfaceC0052b2 = interfaceC0052b;
                        if (iVarG.Q(interfaceC0052b2)) {
                            i17 = 131072;
                        } else {
                            i17 = 65536;
                        }
                        i13 |= i17;
                    }
                    if ((1572864 & i11) == 0) {
                        if ((i12 & 64) == 0) {
                            gVar2 = gVar;
                            int i25 = iVarG.Q(gVar2) ? 1048576 : 524288;
                            i13 |= i25;
                        } else {
                            gVar2 = gVar;
                        }
                        i13 |= i25;
                    } else {
                        gVar2 = gVar;
                    }
                    i18 = i12 & 128;
                    if (i18 != 0) {
                        i13 |= 12582912;
                    } else if ((i11 & 12582912) == 0) {
                        if (iVarG.a(z12)) {
                            i19 = 8388608;
                        } else {
                            i19 = 4194304;
                        }
                        i13 |= i19;
                    }
                    if ((i12 & 256) != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (iVarG.A(function1)) {
                                i21 = 67108864;
                            } else {
                                i21 = ASTNode.PCTX_STORED;
                            }
                            i13 |= i21;
                        }
                        if ((i13 & 38347923) == 38347922 || !iVarG.h()) {
                            iVarG.B();
                            if ((i11 & 1) != 0 || iVarG.J()) {
                                if (i22 != 0) {
                                    fVar2 = androidx.compose.ui.f.f3863a;
                                } else {
                                    fVar2 = fVar;
                                }
                                if ((i12 & 2) != 0) {
                                    lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                    i13 &= -113;
                                } else {
                                    lazyListStateC = lazyListState;
                                }
                                if (i23 != 0) {
                                    tVarA = PaddingKt.a(q2.i.h(0));
                                } else {
                                    tVarA = tVar2;
                                }
                                z14 = i14 == 0 ? z13 : false;
                                if ((i12 & 16) != 0) {
                                    bVar = androidx.compose.foundation.layout.b.f2478a;
                                    if (z14) {
                                        kVarA = bVar.a();
                                    } else {
                                        kVarA = bVar.d();
                                    }
                                    i13 &= -57345;
                                } else {
                                    kVarA = kVar2;
                                }
                                if (i16 != 0) {
                                    interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                                } else {
                                    interfaceC0052bI = interfaceC0052b2;
                                }
                                if ((i12 & 64) != 0) {
                                    gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                    i13 &= -3670017;
                                } else {
                                    gVarA = gVar2;
                                }
                                if (i18 != 0) {
                                    z15 = true;
                                } else {
                                    z15 = z12;
                                }
                            } else {
                                iVarG.H();
                                if ((i12 & 2) != 0) {
                                    i13 &= -113;
                                }
                                if ((i12 & 16) != 0) {
                                    i13 &= -57345;
                                }
                                if ((i12 & 64) != 0) {
                                    i13 &= -3670017;
                                }
                                fVar2 = fVar;
                                lazyListStateC = lazyListState;
                                z15 = z12;
                                tVarA = tVar2;
                                z14 = z13;
                                kVarA = kVar2;
                                interfaceC0052bI = interfaceC0052b2;
                                gVarA = gVar2;
                            }
                            iVarG.s();
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                            }
                            int i26 = i13 >> 3;
                            LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i26) | (i26 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.R();
                            }
                            z16 = z14;
                            kVar3 = kVarA;
                            gVar3 = gVarA;
                            z17 = z15;
                        } else {
                            iVarG.H();
                            fVar2 = fVar;
                            lazyListStateC = lazyListState;
                            tVarA = tVar2;
                            z16 = z13;
                            kVar3 = kVar2;
                            interfaceC0052bI = interfaceC0052b2;
                            gVar3 = gVar2;
                            z17 = z12;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            final androidx.compose.ui.f fVar3 = fVar2;
                            final LazyListState lazyListState2 = lazyListStateC;
                            final androidx.compose.foundation.layout.t tVar3 = tVarA;
                            final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b3 = interfaceC0052bI;
                            final boolean z18 = z17;
                            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(androidx.compose.runtime.i iVar2, int i27) {
                                    LazyDslKt.a(fVar3, lazyListState2, tVar3, z16, kVar3, interfaceC0052b3, gVar3, z18, function1, iVar2, v1.a(i11 | 1), i12);
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    if ((i13 & 38347923) == 38347922) {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i27 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i27) | (i27 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    } else {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i28 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i28) | (i28 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        final androidx.compose.ui.f fVar4 = fVar2;
                        final LazyListState lazyListState3 = lazyListStateC;
                        final androidx.compose.foundation.layout.t tVar4 = tVarA;
                        final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b4 = interfaceC0052bI;
                        final boolean z19 = z17;
                        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar2, int i29) {
                                LazyDslKt.a(fVar4, lazyListState3, tVar4, z16, kVar3, interfaceC0052b4, gVar3, z19, function1, iVar2, v1.a(i11 | 1), i12);
                            }
                        });
                    }
                }
                i13 |= 196608;
                interfaceC0052b2 = interfaceC0052b;
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        gVar2 = gVar;
                        if (iVarG.Q(gVar2)) {
                        }
                        i13 |= i25;
                    } else {
                        gVar2 = gVar;
                    }
                    i13 |= i25;
                } else {
                    gVar2 = gVar;
                }
                i18 = i12 & 128;
                if (i18 != 0) {
                    i13 |= 12582912;
                } else if ((i11 & 12582912) == 0) {
                    if (iVarG.a(z12)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i13 |= i19;
                }
                if ((i12 & 256) != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (iVarG.A(function1)) {
                            i21 = 67108864;
                        } else {
                            i21 = ASTNode.PCTX_STORED;
                        }
                        i13 |= i21;
                    }
                    if ((i13 & 38347923) == 38347922) {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i29 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i29) | (i29 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    } else {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i210 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i210) | (i210 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        final androidx.compose.ui.f fVar5 = fVar2;
                        final LazyListState lazyListState4 = lazyListStateC;
                        final androidx.compose.foundation.layout.t tVar5 = tVarA;
                        final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b5 = interfaceC0052bI;
                        final boolean z110 = z17;
                        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar2, int i211) {
                                LazyDslKt.a(fVar5, lazyListState4, tVar5, z16, kVar3, interfaceC0052b5, gVar3, z110, function1, iVar2, v1.a(i11 | 1), i12);
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) == 38347922) {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i211 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i211) | (i211 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                } else {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i212 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i212) | (i212 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar6 = fVar2;
                    final LazyListState lazyListState5 = lazyListStateC;
                    final androidx.compose.foundation.layout.t tVar6 = tVarA;
                    final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b6 = interfaceC0052bI;
                    final boolean z111 = z17;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i213) {
                            LazyDslKt.a(fVar6, lazyListState5, tVar6, z16, kVar3, interfaceC0052b6, gVar3, z111, function1, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 3072;
            z13 = z11;
            if ((i11 & 24576) == 0) {
                if ((i12 & 16) == 0) {
                    kVar2 = kVar;
                    if (iVarG.Q(kVar2)) {
                    }
                    i13 |= i24;
                } else {
                    kVar2 = kVar;
                }
                i13 |= i24;
            } else {
                kVar2 = kVar;
            }
            i16 = i12 & 32;
            if (i16 != 0) {
                if ((196608 & i11) == 0) {
                    interfaceC0052b2 = interfaceC0052b;
                    if (iVarG.Q(interfaceC0052b2)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i13 |= i17;
                }
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        gVar2 = gVar;
                        if (iVarG.Q(gVar2)) {
                        }
                        i13 |= i25;
                    } else {
                        gVar2 = gVar;
                    }
                    i13 |= i25;
                } else {
                    gVar2 = gVar;
                }
                i18 = i12 & 128;
                if (i18 != 0) {
                    i13 |= 12582912;
                } else if ((i11 & 12582912) == 0) {
                    if (iVarG.a(z12)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i13 |= i19;
                }
                if ((i12 & 256) != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (iVarG.A(function1)) {
                            i21 = 67108864;
                        } else {
                            i21 = ASTNode.PCTX_STORED;
                        }
                        i13 |= i21;
                    }
                    if ((i13 & 38347923) == 38347922) {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i213 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i213) | (i213 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    } else {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i214 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i214) | (i214 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        final androidx.compose.ui.f fVar7 = fVar2;
                        final LazyListState lazyListState6 = lazyListStateC;
                        final androidx.compose.foundation.layout.t tVar7 = tVarA;
                        final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b7 = interfaceC0052bI;
                        final boolean z112 = z17;
                        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar2, int i215) {
                                LazyDslKt.a(fVar7, lazyListState6, tVar7, z16, kVar3, interfaceC0052b7, gVar3, z112, function1, iVar2, v1.a(i11 | 1), i12);
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) == 38347922) {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i215 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i215) | (i215 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                } else {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i216 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i216) | (i216 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar8 = fVar2;
                    final LazyListState lazyListState7 = lazyListStateC;
                    final androidx.compose.foundation.layout.t tVar8 = tVarA;
                    final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b8 = interfaceC0052bI;
                    final boolean z113 = z17;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i217) {
                            LazyDslKt.a(fVar8, lazyListState7, tVar8, z16, kVar3, interfaceC0052b8, gVar3, z113, function1, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 196608;
            interfaceC0052b2 = interfaceC0052b;
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    gVar2 = gVar;
                    if (iVarG.Q(gVar2)) {
                    }
                    i13 |= i25;
                } else {
                    gVar2 = gVar;
                }
                i13 |= i25;
            } else {
                gVar2 = gVar;
            }
            i18 = i12 & 128;
            if (i18 != 0) {
                i13 |= 12582912;
            } else if ((i11 & 12582912) == 0) {
                if (iVarG.a(z12)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i13 |= i19;
            }
            if ((i12 & 256) != 0) {
                if ((i11 & 100663296) == 0) {
                    if (iVarG.A(function1)) {
                        i21 = 67108864;
                    } else {
                        i21 = ASTNode.PCTX_STORED;
                    }
                    i13 |= i21;
                }
                if ((i13 & 38347923) == 38347922) {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i217 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i217) | (i217 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                } else {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i218 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i218) | (i218 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar9 = fVar2;
                    final LazyListState lazyListState8 = lazyListStateC;
                    final androidx.compose.foundation.layout.t tVar9 = tVarA;
                    final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b9 = interfaceC0052bI;
                    final boolean z114 = z17;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i219) {
                            LazyDslKt.a(fVar9, lazyListState8, tVar9, z16, kVar3, interfaceC0052b9, gVar3, z114, function1, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) == 38347922) {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i219 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i219) | (i219 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            } else {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i2110 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2110) | (i2110 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                final androidx.compose.ui.f fVar10 = fVar2;
                final LazyListState lazyListState9 = lazyListStateC;
                final androidx.compose.foundation.layout.t tVar10 = tVarA;
                final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b10 = interfaceC0052bI;
                final boolean z115 = z17;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar2, int i2111) {
                        LazyDslKt.a(fVar10, lazyListState9, tVar10, z16, kVar3, interfaceC0052b10, gVar3, z115, function1, iVar2, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 384;
        tVar2 = tVar;
        i14 = i12 & 8;
        if (i14 != 0) {
            if ((i11 & 3072) == 0) {
                z13 = z11;
                if (iVarG.a(z13)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i13 |= i15;
            }
            if ((i11 & 24576) == 0) {
                if ((i12 & 16) == 0) {
                    kVar2 = kVar;
                    if (iVarG.Q(kVar2)) {
                    }
                    i13 |= i24;
                } else {
                    kVar2 = kVar;
                }
                i13 |= i24;
            } else {
                kVar2 = kVar;
            }
            i16 = i12 & 32;
            if (i16 != 0) {
                if ((196608 & i11) == 0) {
                    interfaceC0052b2 = interfaceC0052b;
                    if (iVarG.Q(interfaceC0052b2)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i13 |= i17;
                }
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        gVar2 = gVar;
                        if (iVarG.Q(gVar2)) {
                        }
                        i13 |= i25;
                    } else {
                        gVar2 = gVar;
                    }
                    i13 |= i25;
                } else {
                    gVar2 = gVar;
                }
                i18 = i12 & 128;
                if (i18 != 0) {
                    i13 |= 12582912;
                } else if ((i11 & 12582912) == 0) {
                    if (iVarG.a(z12)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i13 |= i19;
                }
                if ((i12 & 256) != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (iVarG.A(function1)) {
                            i21 = 67108864;
                        } else {
                            i21 = ASTNode.PCTX_STORED;
                        }
                        i13 |= i21;
                    }
                    if ((i13 & 38347923) == 38347922) {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i2111 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2111) | (i2111 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    } else {
                        iVarG.B();
                        if ((i11 & 1) != 0) {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        } else {
                            if (i22 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if ((i12 & 2) != 0) {
                                lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                                i13 &= -113;
                            } else {
                                lazyListStateC = lazyListState;
                            }
                            if (i23 != 0) {
                                tVarA = PaddingKt.a(q2.i.h(0));
                            } else {
                                tVarA = tVar2;
                            }
                            if (i14 == 0) {
                            }
                            if ((i12 & 16) != 0) {
                                bVar = androidx.compose.foundation.layout.b.f2478a;
                                if (z14) {
                                    kVarA = bVar.d();
                                } else {
                                    kVarA = bVar.a();
                                }
                                i13 &= -57345;
                            } else {
                                kVarA = kVar2;
                            }
                            if (i16 != 0) {
                                interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                            } else {
                                interfaceC0052bI = interfaceC0052b2;
                            }
                            if ((i12 & 64) != 0) {
                                gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                                i13 &= -3670017;
                            } else {
                                gVarA = gVar2;
                            }
                            if (i18 != 0) {
                                z15 = true;
                            } else {
                                z15 = z12;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                        }
                        int i2112 = i13 >> 3;
                        LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2112) | (i2112 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        z16 = z14;
                        kVar3 = kVarA;
                        gVar3 = gVarA;
                        z17 = z15;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        final androidx.compose.ui.f fVar11 = fVar2;
                        final LazyListState lazyListState10 = lazyListStateC;
                        final androidx.compose.foundation.layout.t tVar11 = tVarA;
                        final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b11 = interfaceC0052bI;
                        final boolean z116 = z17;
                        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar2, int i2113) {
                                LazyDslKt.a(fVar11, lazyListState10, tVar11, z16, kVar3, interfaceC0052b11, gVar3, z116, function1, iVar2, v1.a(i11 | 1), i12);
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) == 38347922) {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i2113 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2113) | (i2113 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                } else {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i2114 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2114) | (i2114 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar12 = fVar2;
                    final LazyListState lazyListState11 = lazyListStateC;
                    final androidx.compose.foundation.layout.t tVar12 = tVarA;
                    final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b12 = interfaceC0052bI;
                    final boolean z117 = z17;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i2115) {
                            LazyDslKt.a(fVar12, lazyListState11, tVar12, z16, kVar3, interfaceC0052b12, gVar3, z117, function1, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 196608;
            interfaceC0052b2 = interfaceC0052b;
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    gVar2 = gVar;
                    if (iVarG.Q(gVar2)) {
                    }
                    i13 |= i25;
                } else {
                    gVar2 = gVar;
                }
                i13 |= i25;
            } else {
                gVar2 = gVar;
            }
            i18 = i12 & 128;
            if (i18 != 0) {
                i13 |= 12582912;
            } else if ((i11 & 12582912) == 0) {
                if (iVarG.a(z12)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i13 |= i19;
            }
            if ((i12 & 256) != 0) {
                if ((i11 & 100663296) == 0) {
                    if (iVarG.A(function1)) {
                        i21 = 67108864;
                    } else {
                        i21 = ASTNode.PCTX_STORED;
                    }
                    i13 |= i21;
                }
                if ((i13 & 38347923) == 38347922) {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i2115 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2115) | (i2115 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                } else {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i2116 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2116) | (i2116 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar13 = fVar2;
                    final LazyListState lazyListState12 = lazyListStateC;
                    final androidx.compose.foundation.layout.t tVar13 = tVarA;
                    final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b13 = interfaceC0052bI;
                    final boolean z118 = z17;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i2117) {
                            LazyDslKt.a(fVar13, lazyListState12, tVar13, z16, kVar3, interfaceC0052b13, gVar3, z118, function1, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) == 38347922) {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i2117 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2117) | (i2117 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            } else {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i2118 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2118) | (i2118 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                final androidx.compose.ui.f fVar14 = fVar2;
                final LazyListState lazyListState13 = lazyListStateC;
                final androidx.compose.foundation.layout.t tVar14 = tVarA;
                final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b14 = interfaceC0052bI;
                final boolean z119 = z17;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar2, int i2119) {
                        LazyDslKt.a(fVar14, lazyListState13, tVar14, z16, kVar3, interfaceC0052b14, gVar3, z119, function1, iVar2, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 3072;
        z13 = z11;
        if ((i11 & 24576) == 0) {
            if ((i12 & 16) == 0) {
                kVar2 = kVar;
                if (iVarG.Q(kVar2)) {
                }
                i13 |= i24;
            } else {
                kVar2 = kVar;
            }
            i13 |= i24;
        } else {
            kVar2 = kVar;
        }
        i16 = i12 & 32;
        if (i16 != 0) {
            if ((196608 & i11) == 0) {
                interfaceC0052b2 = interfaceC0052b;
                if (iVarG.Q(interfaceC0052b2)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i13 |= i17;
            }
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    gVar2 = gVar;
                    if (iVarG.Q(gVar2)) {
                    }
                    i13 |= i25;
                } else {
                    gVar2 = gVar;
                }
                i13 |= i25;
            } else {
                gVar2 = gVar;
            }
            i18 = i12 & 128;
            if (i18 != 0) {
                i13 |= 12582912;
            } else if ((i11 & 12582912) == 0) {
                if (iVarG.a(z12)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i13 |= i19;
            }
            if ((i12 & 256) != 0) {
                if ((i11 & 100663296) == 0) {
                    if (iVarG.A(function1)) {
                        i21 = 67108864;
                    } else {
                        i21 = ASTNode.PCTX_STORED;
                    }
                    i13 |= i21;
                }
                if ((i13 & 38347923) == 38347922) {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i2119 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i2119) | (i2119 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                } else {
                    iVarG.B();
                    if ((i11 & 1) != 0) {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    } else {
                        if (i22 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if ((i12 & 2) != 0) {
                            lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                            i13 &= -113;
                        } else {
                            lazyListStateC = lazyListState;
                        }
                        if (i23 != 0) {
                            tVarA = PaddingKt.a(q2.i.h(0));
                        } else {
                            tVarA = tVar2;
                        }
                        if (i14 == 0) {
                        }
                        if ((i12 & 16) != 0) {
                            bVar = androidx.compose.foundation.layout.b.f2478a;
                            if (z14) {
                                kVarA = bVar.d();
                            } else {
                                kVarA = bVar.a();
                            }
                            i13 &= -57345;
                        } else {
                            kVarA = kVar2;
                        }
                        if (i16 != 0) {
                            interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                        } else {
                            interfaceC0052bI = interfaceC0052b2;
                        }
                        if ((i12 & 64) != 0) {
                            gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                            i13 &= -3670017;
                        } else {
                            gVarA = gVar2;
                        }
                        if (i18 != 0) {
                            z15 = true;
                        } else {
                            z15 = z12;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                    }
                    int i21110 = i13 >> 3;
                    LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21110) | (i21110 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    z16 = z14;
                    kVar3 = kVarA;
                    gVar3 = gVarA;
                    z17 = z15;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    final androidx.compose.ui.f fVar15 = fVar2;
                    final LazyListState lazyListState14 = lazyListStateC;
                    final androidx.compose.foundation.layout.t tVar15 = tVarA;
                    final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b15 = interfaceC0052bI;
                    final boolean z1110 = z17;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar2, int i21111) {
                            LazyDslKt.a(fVar15, lazyListState14, tVar15, z16, kVar3, interfaceC0052b15, gVar3, z1110, function1, iVar2, v1.a(i11 | 1), i12);
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) == 38347922) {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i21111 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21111) | (i21111 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            } else {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i21112 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21112) | (i21112 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                final androidx.compose.ui.f fVar16 = fVar2;
                final LazyListState lazyListState15 = lazyListStateC;
                final androidx.compose.foundation.layout.t tVar16 = tVarA;
                final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b16 = interfaceC0052bI;
                final boolean z1111 = z17;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar2, int i21113) {
                        LazyDslKt.a(fVar16, lazyListState15, tVar16, z16, kVar3, interfaceC0052b16, gVar3, z1111, function1, iVar2, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 196608;
        interfaceC0052b2 = interfaceC0052b;
        if ((1572864 & i11) == 0) {
            if ((i12 & 64) == 0) {
                gVar2 = gVar;
                if (iVarG.Q(gVar2)) {
                }
                i13 |= i25;
            } else {
                gVar2 = gVar;
            }
            i13 |= i25;
        } else {
            gVar2 = gVar;
        }
        i18 = i12 & 128;
        if (i18 != 0) {
            i13 |= 12582912;
        } else if ((i11 & 12582912) == 0) {
            if (iVarG.a(z12)) {
                i19 = 8388608;
            } else {
                i19 = 4194304;
            }
            i13 |= i19;
        }
        if ((i12 & 256) != 0) {
            if ((i11 & 100663296) == 0) {
                if (iVarG.A(function1)) {
                    i21 = 67108864;
                } else {
                    i21 = ASTNode.PCTX_STORED;
                }
                i13 |= i21;
            }
            if ((i13 & 38347923) == 38347922) {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i21113 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21113) | (i21113 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            } else {
                iVarG.B();
                if ((i11 & 1) != 0) {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                } else {
                    if (i22 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if ((i12 & 2) != 0) {
                        lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                        i13 &= -113;
                    } else {
                        lazyListStateC = lazyListState;
                    }
                    if (i23 != 0) {
                        tVarA = PaddingKt.a(q2.i.h(0));
                    } else {
                        tVarA = tVar2;
                    }
                    if (i14 == 0) {
                    }
                    if ((i12 & 16) != 0) {
                        bVar = androidx.compose.foundation.layout.b.f2478a;
                        if (z14) {
                            kVarA = bVar.d();
                        } else {
                            kVarA = bVar.a();
                        }
                        i13 &= -57345;
                    } else {
                        kVarA = kVar2;
                    }
                    if (i16 != 0) {
                        interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                    } else {
                        interfaceC0052bI = interfaceC0052b2;
                    }
                    if ((i12 & 64) != 0) {
                        gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                        i13 &= -3670017;
                    } else {
                        gVarA = gVar2;
                    }
                    if (i18 != 0) {
                        z15 = true;
                    } else {
                        z15 = z12;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                }
                int i21114 = i13 >> 3;
                LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21114) | (i21114 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                z16 = z14;
                kVar3 = kVarA;
                gVar3 = gVarA;
                z17 = z15;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                final androidx.compose.ui.f fVar17 = fVar2;
                final LazyListState lazyListState16 = lazyListStateC;
                final androidx.compose.foundation.layout.t tVar17 = tVarA;
                final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b17 = interfaceC0052bI;
                final boolean z1112 = z17;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar2, int i21115) {
                        LazyDslKt.a(fVar17, lazyListState16, tVar17, z16, kVar3, interfaceC0052b17, gVar3, z1112, function1, iVar2, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 100663296;
        if ((i13 & 38347923) == 38347922) {
            iVarG.B();
            if ((i11 & 1) != 0) {
                if (i22 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if ((i12 & 2) != 0) {
                    lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                    i13 &= -113;
                } else {
                    lazyListStateC = lazyListState;
                }
                if (i23 != 0) {
                    tVarA = PaddingKt.a(q2.i.h(0));
                } else {
                    tVarA = tVar2;
                }
                if (i14 == 0) {
                }
                if ((i12 & 16) != 0) {
                    bVar = androidx.compose.foundation.layout.b.f2478a;
                    if (z14) {
                        kVarA = bVar.d();
                    } else {
                        kVarA = bVar.a();
                    }
                    i13 &= -57345;
                } else {
                    kVarA = kVar2;
                }
                if (i16 != 0) {
                    interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                } else {
                    interfaceC0052bI = interfaceC0052b2;
                }
                if ((i12 & 64) != 0) {
                    gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                    i13 &= -3670017;
                } else {
                    gVarA = gVar2;
                }
                if (i18 != 0) {
                    z15 = true;
                } else {
                    z15 = z12;
                }
            } else {
                if (i22 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if ((i12 & 2) != 0) {
                    lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                    i13 &= -113;
                } else {
                    lazyListStateC = lazyListState;
                }
                if (i23 != 0) {
                    tVarA = PaddingKt.a(q2.i.h(0));
                } else {
                    tVarA = tVar2;
                }
                if (i14 == 0) {
                }
                if ((i12 & 16) != 0) {
                    bVar = androidx.compose.foundation.layout.b.f2478a;
                    if (z14) {
                        kVarA = bVar.d();
                    } else {
                        kVarA = bVar.a();
                    }
                    i13 &= -57345;
                } else {
                    kVarA = kVar2;
                }
                if (i16 != 0) {
                    interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                } else {
                    interfaceC0052bI = interfaceC0052b2;
                }
                if ((i12 & 64) != 0) {
                    gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                    i13 &= -3670017;
                } else {
                    gVarA = gVar2;
                }
                if (i18 != 0) {
                    z15 = true;
                } else {
                    z15 = z12;
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
            }
            int i21115 = i13 >> 3;
            LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21115) | (i21115 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            z16 = z14;
            kVar3 = kVarA;
            gVar3 = gVarA;
            z17 = z15;
        } else {
            iVarG.B();
            if ((i11 & 1) != 0) {
                if (i22 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if ((i12 & 2) != 0) {
                    lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                    i13 &= -113;
                } else {
                    lazyListStateC = lazyListState;
                }
                if (i23 != 0) {
                    tVarA = PaddingKt.a(q2.i.h(0));
                } else {
                    tVarA = tVar2;
                }
                if (i14 == 0) {
                }
                if ((i12 & 16) != 0) {
                    bVar = androidx.compose.foundation.layout.b.f2478a;
                    if (z14) {
                        kVarA = bVar.d();
                    } else {
                        kVarA = bVar.a();
                    }
                    i13 &= -57345;
                } else {
                    kVarA = kVar2;
                }
                if (i16 != 0) {
                    interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                } else {
                    interfaceC0052bI = interfaceC0052b2;
                }
                if ((i12 & 64) != 0) {
                    gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                    i13 &= -3670017;
                } else {
                    gVarA = gVar2;
                }
                if (i18 != 0) {
                    z15 = true;
                } else {
                    z15 = z12;
                }
            } else {
                if (i22 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if ((i12 & 2) != 0) {
                    lazyListStateC = LazyListStateKt.c(0, 0, iVarG, 0, 3);
                    i13 &= -113;
                } else {
                    lazyListStateC = lazyListState;
                }
                if (i23 != 0) {
                    tVarA = PaddingKt.a(q2.i.h(0));
                } else {
                    tVarA = tVar2;
                }
                if (i14 == 0) {
                }
                if ((i12 & 16) != 0) {
                    bVar = androidx.compose.foundation.layout.b.f2478a;
                    if (z14) {
                        kVarA = bVar.d();
                    } else {
                        kVarA = bVar.a();
                    }
                    i13 &= -57345;
                } else {
                    kVarA = kVar2;
                }
                if (i16 != 0) {
                    interfaceC0052bI = androidx.compose.ui.b.f3770a.i();
                } else {
                    interfaceC0052bI = interfaceC0052b2;
                }
                if ((i12 & 64) != 0) {
                    gVarA = androidx.compose.foundation.gestures.m.f2370a.a(iVarG, 6);
                    i13 &= -3670017;
                } else {
                    gVarA = gVar2;
                }
                if (i18 != 0) {
                    z15 = true;
                } else {
                    z15 = z12;
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-740714857, i13, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
            }
            int i21116 = i13 >> 3;
            LazyListKt.a(fVar2, lazyListStateC, tVarA, z14, true, gVarA, z15, 0, interfaceC0052bI, kVarA, null, null, function1, iVarG, (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (458752 & i21116) | (i21116 & 3670016) | ((i13 << 9) & 234881024) | ((i13 << 15) & 1879048192), (i13 >> 18) & 896, 3200);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            z16 = z14;
            kVar3 = kVarA;
            gVar3 = gVarA;
            z17 = z15;
        }
        g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            final androidx.compose.ui.f fVar18 = fVar2;
            final LazyListState lazyListState17 = lazyListStateC;
            final androidx.compose.foundation.layout.t tVar18 = tVarA;
            final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b18 = interfaceC0052bI;
            final boolean z1113 = z17;
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i21117) {
                    LazyDslKt.a(fVar18, lazyListState17, tVar18, z16, kVar3, interfaceC0052b18, gVar3, z1113, function1, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
