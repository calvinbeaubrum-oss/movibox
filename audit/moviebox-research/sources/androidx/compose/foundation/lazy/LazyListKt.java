package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.i0;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.a0;
import androidx.compose.foundation.lazy.layout.e0;
import androidx.compose.foundation.lazy.layout.z;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
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
public final class LazyListKt {
    /* JADX WARN: Code duplicated, block: B:101:0x011f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0125  */
    /* JADX WARN: Code duplicated, block: B:104:0x0128  */
    /* JADX WARN: Code duplicated, block: B:108:0x0130  */
    /* JADX WARN: Code duplicated, block: B:109:0x0135  */
    /* JADX WARN: Code duplicated, block: B:111:0x013b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0141  */
    /* JADX WARN: Code duplicated, block: B:114:0x0144  */
    /* JADX WARN: Code duplicated, block: B:116:0x0149  */
    /* JADX WARN: Code duplicated, block: B:119:0x014f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0154  */
    /* JADX WARN: Code duplicated, block: B:123:0x015a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0160  */
    /* JADX WARN: Code duplicated, block: B:126:0x0163  */
    /* JADX WARN: Code duplicated, block: B:130:0x016c  */
    /* JADX WARN: Code duplicated, block: B:131:0x016f  */
    /* JADX WARN: Code duplicated, block: B:133:0x0173  */
    /* JADX WARN: Code duplicated, block: B:136:0x017a  */
    /* JADX WARN: Code duplicated, block: B:140:0x0187  */
    /* JADX WARN: Code duplicated, block: B:146:0x01a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:152:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:154:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:155:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:157:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:158:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:160:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:161:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:164:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:167:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:170:0x0286  */
    /* JADX WARN: Code duplicated, block: B:172:0x028a  */
    /* JADX WARN: Code duplicated, block: B:175:0x0329  */
    /* JADX WARN: Code duplicated, block: B:179:0x033b  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x0107  */
    /* JADX WARN: Code duplicated, block: B:94:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x0119  */
    public static final void a(final androidx.compose.ui.f fVar, final LazyListState lazyListState, final androidx.compose.foundation.layout.t tVar, final boolean z11, final boolean z12, final androidx.compose.foundation.gestures.g gVar, final boolean z13, int i11, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, androidx.compose.foundation.layout.b.k kVar, androidx.compose.ui.b.c cVar, androidx.compose.foundation.layout.b.d dVar, final Function1<? super u, Unit> function1, androidx.compose.runtime.i iVar, final int i12, final int i13, final int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i31;
        int i32;
        int i33;
        int i34;
        androidx.compose.ui.b.InterfaceC0052b interfaceC0052b2;
        androidx.compose.foundation.layout.b.k kVar2;
        androidx.compose.ui.b.c cVar2;
        androidx.compose.foundation.layout.b.d dVar2;
        Object objY;
        Orientation orientation;
        androidx.compose.runtime.i iVar2;
        final int i35;
        final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b3;
        final androidx.compose.foundation.layout.b.k kVar3;
        final androidx.compose.ui.b.c cVar3;
        final androidx.compose.foundation.layout.b.d dVar3;
        g2 g2VarJ;
        androidx.compose.runtime.i iVarG = iVar.g(620764179);
        if ((i14 & 1) != 0) {
            i15 = i12 | 6;
        } else if ((i12 & 6) == 0) {
            i15 = (iVarG.Q(fVar) ? 4 : 2) | i12;
        } else {
            i15 = i12;
        }
        if ((i14 & 2) != 0) {
            i15 |= 48;
        } else if ((i12 & 48) == 0) {
            i15 |= iVarG.Q(lazyListState) ? 32 : 16;
        }
        if ((i14 & 4) == 0) {
            if ((i12 & 384) == 0) {
                i15 |= iVarG.Q(tVar) ? 256 : 128;
            }
            if ((i14 & 8) != 0) {
                if ((i12 & 3072) == 0) {
                    if (iVarG.a(z11)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i15 |= i16;
                }
                if ((i14 & 16) != 0) {
                    i15 |= 24576;
                } else if ((i12 & 24576) == 0) {
                    if (iVarG.a(z12)) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i15 |= i17;
                }
                if ((i14 & 32) != 0) {
                    if ((i12 & 196608) == 0) {
                        if (iVarG.Q(gVar)) {
                            i18 = 131072;
                        } else {
                            i18 = 65536;
                        }
                        i15 |= i18;
                    }
                    if ((i14 & 64) != 0) {
                        i15 |= 1572864;
                    } else if ((i12 & 1572864) == 0) {
                        if (iVarG.a(z13)) {
                            i19 = 1048576;
                        } else {
                            i19 = 524288;
                        }
                        i15 |= i19;
                    }
                    i21 = i14 & 128;
                    if (i21 != 0) {
                        i15 |= 12582912;
                    } else if ((i12 & 12582912) == 0) {
                        if (iVarG.c(i11)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i15 |= i22;
                    }
                    i23 = i14 & 256;
                    if (i23 != 0) {
                        i15 |= 100663296;
                    } else if ((i12 & 100663296) == 0) {
                        if (iVarG.Q(interfaceC0052b)) {
                            i24 = 67108864;
                        } else {
                            i24 = ASTNode.PCTX_STORED;
                        }
                        i15 |= i24;
                    }
                    i25 = i14 & 512;
                    if (i25 != 0) {
                        i15 |= 805306368;
                    } else if ((i12 & 805306368) == 0) {
                        if (iVarG.Q(kVar)) {
                            i26 = ASTNode.DISCARD;
                        } else {
                            i26 = ASTNode.DEOP;
                        }
                        i15 |= i26;
                    }
                    i27 = i14 & 1024;
                    if (i27 != 0) {
                        i28 = i13 | 6;
                    } else if ((i13 & 6) == 0) {
                        if (iVarG.Q(cVar)) {
                            i29 = 4;
                        } else {
                            i29 = 2;
                        }
                        i28 = i13 | i29;
                    } else {
                        i28 = i13;
                    }
                    i31 = i14 & 2048;
                    if (i31 != 0) {
                        i28 |= 48;
                    } else if ((i13 & 48) == 0) {
                        if (iVarG.Q(dVar)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                        i28 |= i32;
                    }
                    i33 = i28;
                    if ((i14 & 4096) != 0) {
                        i33 |= 384;
                    } else if ((i13 & 384) == 0) {
                        i33 |= iVarG.A(function1) ? 256 : 128;
                    }
                    if ((306783379 & i15) != 306783378 && (i33 & 147) == 146 && iVarG.h()) {
                        iVarG.H();
                        i35 = i11;
                        interfaceC0052b3 = interfaceC0052b;
                        cVar3 = cVar;
                        dVar3 = dVar;
                        iVar2 = iVarG;
                        kVar3 = kVar;
                    } else {
                        if (i21 != 0) {
                            i34 = 0;
                        } else {
                            i34 = i11;
                        }
                        if (i23 != 0) {
                            interfaceC0052b2 = null;
                        } else {
                            interfaceC0052b2 = interfaceC0052b;
                        }
                        if (i25 != 0) {
                            kVar2 = null;
                        } else {
                            kVar2 = kVar;
                        }
                        if (i27 != 0) {
                            cVar2 = null;
                        } else {
                            cVar2 = cVar;
                        }
                        if (i31 != 0) {
                            dVar2 = null;
                        } else {
                            dVar2 = dVar;
                        }
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                        }
                        int i36 = (i15 >> 3) & 14;
                        Function0<k> function0A = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i36 | ((i33 >> 3) & 112));
                        int i37 = i15 >> 9;
                        z zVarA = w.a(lazyListState, z12, iVarG, i36 | (i37 & 112));
                        objY = iVarG.y();
                        if (objY == androidx.compose.runtime.i.f3413a.a()) {
                            androidx.compose.runtime.v vVar = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                            iVarG.p(vVar);
                            objY = vVar;
                        }
                        int i38 = i15 & 112;
                        int i39 = i15 & 7168;
                        int i40 = i15 >> 6;
                        int i41 = i33 << 21;
                        int i42 = i15;
                        int i43 = i34;
                        Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B = b(function0A, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i38 | (i15 & 896) | i39 | (i15 & 57344) | (i40 & 458752) | (i40 & 3670016) | (29360128 & i41) | (i41 & 234881024) | (1879048192 & i15), 0);
                        if (z12) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation2 = orientation;
                        iVar2 = iVarG;
                        LazyLayoutKt.a(function0A, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A, zVarA, orientation2, z13, z11, iVarG, (i40 & 57344) | ((i42 << 6) & 458752)), f.a(lazyListState, i43, iVar2, i36 | ((i42 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation2, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i39 | (i42 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation2, z13, z11, gVar, lazyListState.r(), null, iVar2, i38 | (i37 & 7168) | ((i42 << 3) & 57344) | (i42 & 458752), 64), lazyListState.z(), function2B, iVar2, 0, 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i35 = i43;
                        interfaceC0052b3 = interfaceC0052b2;
                        kVar3 = kVar2;
                        cVar3 = cVar2;
                        dVar3 = dVar2;
                    }
                    g2VarJ = iVar2.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                                invoke(iVar3, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar3, int i44) {
                                LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                            }
                        });
                    }
                }
                i15 |= 196608;
                if ((i14 & 64) != 0) {
                    i15 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (iVarG.a(z13)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i15 |= i19;
                }
                i21 = i14 & 128;
                if (i21 != 0) {
                    i15 |= 12582912;
                } else if ((i12 & 12582912) == 0) {
                    if (iVarG.c(i11)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i15 |= i22;
                }
                i23 = i14 & 256;
                if (i23 != 0) {
                    i15 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (iVarG.Q(interfaceC0052b)) {
                        i24 = 67108864;
                    } else {
                        i24 = ASTNode.PCTX_STORED;
                    }
                    i15 |= i24;
                }
                i25 = i14 & 512;
                if (i25 != 0) {
                    i15 |= 805306368;
                } else if ((i12 & 805306368) == 0) {
                    if (iVarG.Q(kVar)) {
                        i26 = ASTNode.DISCARD;
                    } else {
                        i26 = ASTNode.DEOP;
                    }
                    i15 |= i26;
                }
                i27 = i14 & 1024;
                if (i27 != 0) {
                    i28 = i13 | 6;
                } else if ((i13 & 6) == 0) {
                    if (iVarG.Q(cVar)) {
                        i29 = 4;
                    } else {
                        i29 = 2;
                    }
                    i28 = i13 | i29;
                } else {
                    i28 = i13;
                }
                i31 = i14 & 2048;
                if (i31 != 0) {
                    i28 |= 48;
                } else if ((i13 & 48) == 0) {
                    if (iVarG.Q(dVar)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                    i28 |= i32;
                }
                i33 = i28;
                if ((i14 & 4096) != 0) {
                    i33 |= 384;
                } else if ((i13 & 384) == 0) {
                    i33 |= iVarG.A(function1) ? 256 : 128;
                }
                if ((306783379 & i15) != 306783378) {
                    if (i21 != 0) {
                        i34 = 0;
                    } else {
                        i34 = i11;
                    }
                    if (i23 != 0) {
                        interfaceC0052b2 = null;
                    } else {
                        interfaceC0052b2 = interfaceC0052b;
                    }
                    if (i25 != 0) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    if (i27 != 0) {
                        cVar2 = null;
                    } else {
                        cVar2 = cVar;
                    }
                    if (i31 != 0) {
                        dVar2 = null;
                    } else {
                        dVar2 = dVar;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    }
                    int i310 = (i15 >> 3) & 14;
                    Function0<k> function0A2 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i310 | ((i33 >> 3) & 112));
                    int i311 = i15 >> 9;
                    z zVarA2 = w.a(lazyListState, z12, iVarG, i310 | (i311 & 112));
                    objY = iVarG.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        androidx.compose.runtime.v vVar2 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                        iVarG.p(vVar2);
                        objY = vVar2;
                    }
                    int i312 = i15 & 112;
                    int i313 = i15 & 7168;
                    int i44 = i15 >> 6;
                    int i45 = i33 << 21;
                    int i46 = i15;
                    int i47 = i34;
                    Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B2 = b(function0A2, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i312 | (i15 & 896) | i313 | (i15 & 57344) | (i44 & 458752) | (i44 & 3670016) | (29360128 & i45) | (i45 & 234881024) | (1879048192 & i15), 0);
                    if (z12) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation3 = orientation;
                    iVar2 = iVarG;
                    LazyLayoutKt.a(function0A2, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A2, zVarA2, orientation3, z13, z11, iVarG, (i44 & 57344) | ((i46 << 6) & 458752)), f.a(lazyListState, i47, iVar2, i310 | ((i46 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation3, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i313 | (i46 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation3, z13, z11, gVar, lazyListState.r(), null, iVar2, i312 | (i311 & 7168) | ((i46 << 3) & 57344) | (i46 & 458752), 64), lazyListState.z(), function2B2, iVar2, 0, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i35 = i47;
                    interfaceC0052b3 = interfaceC0052b2;
                    kVar3 = kVar2;
                    cVar3 = cVar2;
                    dVar3 = dVar2;
                } else {
                    if (i21 != 0) {
                        i34 = 0;
                    } else {
                        i34 = i11;
                    }
                    if (i23 != 0) {
                        interfaceC0052b2 = null;
                    } else {
                        interfaceC0052b2 = interfaceC0052b;
                    }
                    if (i25 != 0) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    if (i27 != 0) {
                        cVar2 = null;
                    } else {
                        cVar2 = cVar;
                    }
                    if (i31 != 0) {
                        dVar2 = null;
                    } else {
                        dVar2 = dVar;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    }
                    int i314 = (i15 >> 3) & 14;
                    Function0<k> function0A3 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i314 | ((i33 >> 3) & 112));
                    int i315 = i15 >> 9;
                    z zVarA3 = w.a(lazyListState, z12, iVarG, i314 | (i315 & 112));
                    objY = iVarG.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        androidx.compose.runtime.v vVar3 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                        iVarG.p(vVar3);
                        objY = vVar3;
                    }
                    int i316 = i15 & 112;
                    int i317 = i15 & 7168;
                    int i48 = i15 >> 6;
                    int i49 = i33 << 21;
                    int i410 = i15;
                    int i411 = i34;
                    Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B3 = b(function0A3, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i316 | (i15 & 896) | i317 | (i15 & 57344) | (i48 & 458752) | (i48 & 3670016) | (29360128 & i49) | (i49 & 234881024) | (1879048192 & i15), 0);
                    if (z12) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation4 = orientation;
                    iVar2 = iVarG;
                    LazyLayoutKt.a(function0A3, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A3, zVarA3, orientation4, z13, z11, iVarG, (i48 & 57344) | ((i410 << 6) & 458752)), f.a(lazyListState, i411, iVar2, i314 | ((i410 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation4, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i317 | (i410 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation4, z13, z11, gVar, lazyListState.r(), null, iVar2, i316 | (i315 & 7168) | ((i410 << 3) & 57344) | (i410 & 458752), 64), lazyListState.z(), function2B3, iVar2, 0, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i35 = i411;
                    interfaceC0052b3 = interfaceC0052b2;
                    kVar3 = kVar2;
                    cVar3 = cVar2;
                    dVar3 = dVar2;
                }
                g2VarJ = iVar2.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                            invoke(iVar3, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar3, int i412) {
                            LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                        }
                    });
                }
            }
            i15 |= 3072;
            if ((i14 & 16) != 0) {
                i15 |= 24576;
            } else if ((i12 & 24576) == 0) {
                if (iVarG.a(z12)) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i15 |= i17;
            }
            if ((i14 & 32) != 0) {
                if ((i12 & 196608) == 0) {
                    if (iVarG.Q(gVar)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i15 |= i18;
                }
                if ((i14 & 64) != 0) {
                    i15 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (iVarG.a(z13)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i15 |= i19;
                }
                i21 = i14 & 128;
                if (i21 != 0) {
                    i15 |= 12582912;
                } else if ((i12 & 12582912) == 0) {
                    if (iVarG.c(i11)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i15 |= i22;
                }
                i23 = i14 & 256;
                if (i23 != 0) {
                    i15 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (iVarG.Q(interfaceC0052b)) {
                        i24 = 67108864;
                    } else {
                        i24 = ASTNode.PCTX_STORED;
                    }
                    i15 |= i24;
                }
                i25 = i14 & 512;
                if (i25 != 0) {
                    i15 |= 805306368;
                } else if ((i12 & 805306368) == 0) {
                    if (iVarG.Q(kVar)) {
                        i26 = ASTNode.DISCARD;
                    } else {
                        i26 = ASTNode.DEOP;
                    }
                    i15 |= i26;
                }
                i27 = i14 & 1024;
                if (i27 != 0) {
                    i28 = i13 | 6;
                } else if ((i13 & 6) == 0) {
                    if (iVarG.Q(cVar)) {
                        i29 = 4;
                    } else {
                        i29 = 2;
                    }
                    i28 = i13 | i29;
                } else {
                    i28 = i13;
                }
                i31 = i14 & 2048;
                if (i31 != 0) {
                    i28 |= 48;
                } else if ((i13 & 48) == 0) {
                    if (iVarG.Q(dVar)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                    i28 |= i32;
                }
                i33 = i28;
                if ((i14 & 4096) != 0) {
                    i33 |= 384;
                } else if ((i13 & 384) == 0) {
                    i33 |= iVarG.A(function1) ? 256 : 128;
                }
                if ((306783379 & i15) != 306783378) {
                    if (i21 != 0) {
                        i34 = 0;
                    } else {
                        i34 = i11;
                    }
                    if (i23 != 0) {
                        interfaceC0052b2 = null;
                    } else {
                        interfaceC0052b2 = interfaceC0052b;
                    }
                    if (i25 != 0) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    if (i27 != 0) {
                        cVar2 = null;
                    } else {
                        cVar2 = cVar;
                    }
                    if (i31 != 0) {
                        dVar2 = null;
                    } else {
                        dVar2 = dVar;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    }
                    int i318 = (i15 >> 3) & 14;
                    Function0<k> function0A4 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i318 | ((i33 >> 3) & 112));
                    int i319 = i15 >> 9;
                    z zVarA4 = w.a(lazyListState, z12, iVarG, i318 | (i319 & 112));
                    objY = iVarG.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        androidx.compose.runtime.v vVar4 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                        iVarG.p(vVar4);
                        objY = vVar4;
                    }
                    int i3110 = i15 & 112;
                    int i3111 = i15 & 7168;
                    int i412 = i15 >> 6;
                    int i413 = i33 << 21;
                    int i414 = i15;
                    int i415 = i34;
                    Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B4 = b(function0A4, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i3110 | (i15 & 896) | i3111 | (i15 & 57344) | (i412 & 458752) | (i412 & 3670016) | (29360128 & i413) | (i413 & 234881024) | (1879048192 & i15), 0);
                    if (z12) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation5 = orientation;
                    iVar2 = iVarG;
                    LazyLayoutKt.a(function0A4, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A4, zVarA4, orientation5, z13, z11, iVarG, (i412 & 57344) | ((i414 << 6) & 458752)), f.a(lazyListState, i415, iVar2, i318 | ((i414 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation5, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i3111 | (i414 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation5, z13, z11, gVar, lazyListState.r(), null, iVar2, i3110 | (i319 & 7168) | ((i414 << 3) & 57344) | (i414 & 458752), 64), lazyListState.z(), function2B4, iVar2, 0, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i35 = i415;
                    interfaceC0052b3 = interfaceC0052b2;
                    kVar3 = kVar2;
                    cVar3 = cVar2;
                    dVar3 = dVar2;
                } else {
                    if (i21 != 0) {
                        i34 = 0;
                    } else {
                        i34 = i11;
                    }
                    if (i23 != 0) {
                        interfaceC0052b2 = null;
                    } else {
                        interfaceC0052b2 = interfaceC0052b;
                    }
                    if (i25 != 0) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    if (i27 != 0) {
                        cVar2 = null;
                    } else {
                        cVar2 = cVar;
                    }
                    if (i31 != 0) {
                        dVar2 = null;
                    } else {
                        dVar2 = dVar;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    }
                    int i3112 = (i15 >> 3) & 14;
                    Function0<k> function0A5 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i3112 | ((i33 >> 3) & 112));
                    int i3113 = i15 >> 9;
                    z zVarA5 = w.a(lazyListState, z12, iVarG, i3112 | (i3113 & 112));
                    objY = iVarG.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        androidx.compose.runtime.v vVar5 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                        iVarG.p(vVar5);
                        objY = vVar5;
                    }
                    int i3114 = i15 & 112;
                    int i3115 = i15 & 7168;
                    int i416 = i15 >> 6;
                    int i417 = i33 << 21;
                    int i418 = i15;
                    int i419 = i34;
                    Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B5 = b(function0A5, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i3114 | (i15 & 896) | i3115 | (i15 & 57344) | (i416 & 458752) | (i416 & 3670016) | (29360128 & i417) | (i417 & 234881024) | (1879048192 & i15), 0);
                    if (z12) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation6 = orientation;
                    iVar2 = iVarG;
                    LazyLayoutKt.a(function0A5, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A5, zVarA5, orientation6, z13, z11, iVarG, (i416 & 57344) | ((i418 << 6) & 458752)), f.a(lazyListState, i419, iVar2, i3112 | ((i418 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation6, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i3115 | (i418 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation6, z13, z11, gVar, lazyListState.r(), null, iVar2, i3114 | (i3113 & 7168) | ((i418 << 3) & 57344) | (i418 & 458752), 64), lazyListState.z(), function2B5, iVar2, 0, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i35 = i419;
                    interfaceC0052b3 = interfaceC0052b2;
                    kVar3 = kVar2;
                    cVar3 = cVar2;
                    dVar3 = dVar2;
                }
                g2VarJ = iVar2.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                            invoke(iVar3, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar3, int i4110) {
                            LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                        }
                    });
                }
            }
            i15 |= 196608;
            if ((i14 & 64) != 0) {
                i15 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (iVarG.a(z13)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i15 |= i19;
            }
            i21 = i14 & 128;
            if (i21 != 0) {
                i15 |= 12582912;
            } else if ((i12 & 12582912) == 0) {
                if (iVarG.c(i11)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i15 |= i22;
            }
            i23 = i14 & 256;
            if (i23 != 0) {
                i15 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (iVarG.Q(interfaceC0052b)) {
                    i24 = 67108864;
                } else {
                    i24 = ASTNode.PCTX_STORED;
                }
                i15 |= i24;
            }
            i25 = i14 & 512;
            if (i25 != 0) {
                i15 |= 805306368;
            } else if ((i12 & 805306368) == 0) {
                if (iVarG.Q(kVar)) {
                    i26 = ASTNode.DISCARD;
                } else {
                    i26 = ASTNode.DEOP;
                }
                i15 |= i26;
            }
            i27 = i14 & 1024;
            if (i27 != 0) {
                i28 = i13 | 6;
            } else if ((i13 & 6) == 0) {
                if (iVarG.Q(cVar)) {
                    i29 = 4;
                } else {
                    i29 = 2;
                }
                i28 = i13 | i29;
            } else {
                i28 = i13;
            }
            i31 = i14 & 2048;
            if (i31 != 0) {
                i28 |= 48;
            } else if ((i13 & 48) == 0) {
                if (iVarG.Q(dVar)) {
                    i32 = 32;
                } else {
                    i32 = 16;
                }
                i28 |= i32;
            }
            i33 = i28;
            if ((i14 & 4096) != 0) {
                i33 |= 384;
            } else if ((i13 & 384) == 0) {
                i33 |= iVarG.A(function1) ? 256 : 128;
            }
            if ((306783379 & i15) != 306783378) {
                if (i21 != 0) {
                    i34 = 0;
                } else {
                    i34 = i11;
                }
                if (i23 != 0) {
                    interfaceC0052b2 = null;
                } else {
                    interfaceC0052b2 = interfaceC0052b;
                }
                if (i25 != 0) {
                    kVar2 = null;
                } else {
                    kVar2 = kVar;
                }
                if (i27 != 0) {
                    cVar2 = null;
                } else {
                    cVar2 = cVar;
                }
                if (i31 != 0) {
                    dVar2 = null;
                } else {
                    dVar2 = dVar;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                }
                int i3116 = (i15 >> 3) & 14;
                Function0<k> function0A6 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i3116 | ((i33 >> 3) & 112));
                int i3117 = i15 >> 9;
                z zVarA6 = w.a(lazyListState, z12, iVarG, i3116 | (i3117 & 112));
                objY = iVarG.y();
                if (objY == androidx.compose.runtime.i.f3413a.a()) {
                    androidx.compose.runtime.v vVar6 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                    iVarG.p(vVar6);
                    objY = vVar6;
                }
                int i3118 = i15 & 112;
                int i3119 = i15 & 7168;
                int i4110 = i15 >> 6;
                int i4111 = i33 << 21;
                int i4112 = i15;
                int i4113 = i34;
                Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B6 = b(function0A6, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i3118 | (i15 & 896) | i3119 | (i15 & 57344) | (i4110 & 458752) | (i4110 & 3670016) | (29360128 & i4111) | (i4111 & 234881024) | (1879048192 & i15), 0);
                if (z12) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation7 = orientation;
                iVar2 = iVarG;
                LazyLayoutKt.a(function0A6, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A6, zVarA6, orientation7, z13, z11, iVarG, (i4110 & 57344) | ((i4112 << 6) & 458752)), f.a(lazyListState, i4113, iVar2, i3116 | ((i4112 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation7, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i3119 | (i4112 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation7, z13, z11, gVar, lazyListState.r(), null, iVar2, i3118 | (i3117 & 7168) | ((i4112 << 3) & 57344) | (i4112 & 458752), 64), lazyListState.z(), function2B6, iVar2, 0, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i35 = i4113;
                interfaceC0052b3 = interfaceC0052b2;
                kVar3 = kVar2;
                cVar3 = cVar2;
                dVar3 = dVar2;
            } else {
                if (i21 != 0) {
                    i34 = 0;
                } else {
                    i34 = i11;
                }
                if (i23 != 0) {
                    interfaceC0052b2 = null;
                } else {
                    interfaceC0052b2 = interfaceC0052b;
                }
                if (i25 != 0) {
                    kVar2 = null;
                } else {
                    kVar2 = kVar;
                }
                if (i27 != 0) {
                    cVar2 = null;
                } else {
                    cVar2 = cVar;
                }
                if (i31 != 0) {
                    dVar2 = null;
                } else {
                    dVar2 = dVar;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                }
                int i31110 = (i15 >> 3) & 14;
                Function0<k> function0A7 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i31110 | ((i33 >> 3) & 112));
                int i31111 = i15 >> 9;
                z zVarA7 = w.a(lazyListState, z12, iVarG, i31110 | (i31111 & 112));
                objY = iVarG.y();
                if (objY == androidx.compose.runtime.i.f3413a.a()) {
                    androidx.compose.runtime.v vVar7 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                    iVarG.p(vVar7);
                    objY = vVar7;
                }
                int i31112 = i15 & 112;
                int i31113 = i15 & 7168;
                int i4114 = i15 >> 6;
                int i4115 = i33 << 21;
                int i4116 = i15;
                int i4117 = i34;
                Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B7 = b(function0A7, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i31112 | (i15 & 896) | i31113 | (i15 & 57344) | (i4114 & 458752) | (i4114 & 3670016) | (29360128 & i4115) | (i4115 & 234881024) | (1879048192 & i15), 0);
                if (z12) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation8 = orientation;
                iVar2 = iVarG;
                LazyLayoutKt.a(function0A7, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A7, zVarA7, orientation8, z13, z11, iVarG, (i4114 & 57344) | ((i4116 << 6) & 458752)), f.a(lazyListState, i4117, iVar2, i31110 | ((i4116 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation8, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i31113 | (i4116 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation8, z13, z11, gVar, lazyListState.r(), null, iVar2, i31112 | (i31111 & 7168) | ((i4116 << 3) & 57344) | (i4116 & 458752), 64), lazyListState.z(), function2B7, iVar2, 0, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i35 = i4117;
                interfaceC0052b3 = interfaceC0052b2;
                kVar3 = kVar2;
                cVar3 = cVar2;
                dVar3 = dVar2;
            }
            g2VarJ = iVar2.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                        invoke(iVar3, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar3, int i4118) {
                        LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                    }
                });
            }
        }
        i15 |= 384;
        if ((i14 & 8) != 0) {
            if ((i12 & 3072) == 0) {
                if (iVarG.a(z11)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i15 |= i16;
            }
            if ((i14 & 16) != 0) {
                i15 |= 24576;
            } else if ((i12 & 24576) == 0) {
                if (iVarG.a(z12)) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i15 |= i17;
            }
            if ((i14 & 32) != 0) {
                if ((i12 & 196608) == 0) {
                    if (iVarG.Q(gVar)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i15 |= i18;
                }
                if ((i14 & 64) != 0) {
                    i15 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (iVarG.a(z13)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i15 |= i19;
                }
                i21 = i14 & 128;
                if (i21 != 0) {
                    i15 |= 12582912;
                } else if ((i12 & 12582912) == 0) {
                    if (iVarG.c(i11)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i15 |= i22;
                }
                i23 = i14 & 256;
                if (i23 != 0) {
                    i15 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (iVarG.Q(interfaceC0052b)) {
                        i24 = 67108864;
                    } else {
                        i24 = ASTNode.PCTX_STORED;
                    }
                    i15 |= i24;
                }
                i25 = i14 & 512;
                if (i25 != 0) {
                    i15 |= 805306368;
                } else if ((i12 & 805306368) == 0) {
                    if (iVarG.Q(kVar)) {
                        i26 = ASTNode.DISCARD;
                    } else {
                        i26 = ASTNode.DEOP;
                    }
                    i15 |= i26;
                }
                i27 = i14 & 1024;
                if (i27 != 0) {
                    i28 = i13 | 6;
                } else if ((i13 & 6) == 0) {
                    if (iVarG.Q(cVar)) {
                        i29 = 4;
                    } else {
                        i29 = 2;
                    }
                    i28 = i13 | i29;
                } else {
                    i28 = i13;
                }
                i31 = i14 & 2048;
                if (i31 != 0) {
                    i28 |= 48;
                } else if ((i13 & 48) == 0) {
                    if (iVarG.Q(dVar)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                    i28 |= i32;
                }
                i33 = i28;
                if ((i14 & 4096) != 0) {
                    i33 |= 384;
                } else if ((i13 & 384) == 0) {
                    i33 |= iVarG.A(function1) ? 256 : 128;
                }
                if ((306783379 & i15) != 306783378) {
                    if (i21 != 0) {
                        i34 = 0;
                    } else {
                        i34 = i11;
                    }
                    if (i23 != 0) {
                        interfaceC0052b2 = null;
                    } else {
                        interfaceC0052b2 = interfaceC0052b;
                    }
                    if (i25 != 0) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    if (i27 != 0) {
                        cVar2 = null;
                    } else {
                        cVar2 = cVar;
                    }
                    if (i31 != 0) {
                        dVar2 = null;
                    } else {
                        dVar2 = dVar;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    }
                    int i31114 = (i15 >> 3) & 14;
                    Function0<k> function0A8 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i31114 | ((i33 >> 3) & 112));
                    int i31115 = i15 >> 9;
                    z zVarA8 = w.a(lazyListState, z12, iVarG, i31114 | (i31115 & 112));
                    objY = iVarG.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        androidx.compose.runtime.v vVar8 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                        iVarG.p(vVar8);
                        objY = vVar8;
                    }
                    int i31116 = i15 & 112;
                    int i31117 = i15 & 7168;
                    int i4118 = i15 >> 6;
                    int i4119 = i33 << 21;
                    int i41110 = i15;
                    int i41111 = i34;
                    Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B8 = b(function0A8, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i31116 | (i15 & 896) | i31117 | (i15 & 57344) | (i4118 & 458752) | (i4118 & 3670016) | (29360128 & i4119) | (i4119 & 234881024) | (1879048192 & i15), 0);
                    if (z12) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation9 = orientation;
                    iVar2 = iVarG;
                    LazyLayoutKt.a(function0A8, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A8, zVarA8, orientation9, z13, z11, iVarG, (i4118 & 57344) | ((i41110 << 6) & 458752)), f.a(lazyListState, i41111, iVar2, i31114 | ((i41110 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation9, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i31117 | (i41110 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation9, z13, z11, gVar, lazyListState.r(), null, iVar2, i31116 | (i31115 & 7168) | ((i41110 << 3) & 57344) | (i41110 & 458752), 64), lazyListState.z(), function2B8, iVar2, 0, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i35 = i41111;
                    interfaceC0052b3 = interfaceC0052b2;
                    kVar3 = kVar2;
                    cVar3 = cVar2;
                    dVar3 = dVar2;
                } else {
                    if (i21 != 0) {
                        i34 = 0;
                    } else {
                        i34 = i11;
                    }
                    if (i23 != 0) {
                        interfaceC0052b2 = null;
                    } else {
                        interfaceC0052b2 = interfaceC0052b;
                    }
                    if (i25 != 0) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    if (i27 != 0) {
                        cVar2 = null;
                    } else {
                        cVar2 = cVar;
                    }
                    if (i31 != 0) {
                        dVar2 = null;
                    } else {
                        dVar2 = dVar;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    }
                    int i31118 = (i15 >> 3) & 14;
                    Function0<k> function0A9 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i31118 | ((i33 >> 3) & 112));
                    int i31119 = i15 >> 9;
                    z zVarA9 = w.a(lazyListState, z12, iVarG, i31118 | (i31119 & 112));
                    objY = iVarG.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        androidx.compose.runtime.v vVar9 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                        iVarG.p(vVar9);
                        objY = vVar9;
                    }
                    int i311110 = i15 & 112;
                    int i311111 = i15 & 7168;
                    int i41112 = i15 >> 6;
                    int i41113 = i33 << 21;
                    int i41114 = i15;
                    int i41115 = i34;
                    Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B9 = b(function0A9, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i311110 | (i15 & 896) | i311111 | (i15 & 57344) | (i41112 & 458752) | (i41112 & 3670016) | (29360128 & i41113) | (i41113 & 234881024) | (1879048192 & i15), 0);
                    if (z12) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation10 = orientation;
                    iVar2 = iVarG;
                    LazyLayoutKt.a(function0A9, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A9, zVarA9, orientation10, z13, z11, iVarG, (i41112 & 57344) | ((i41114 << 6) & 458752)), f.a(lazyListState, i41115, iVar2, i31118 | ((i41114 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation10, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i311111 | (i41114 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation10, z13, z11, gVar, lazyListState.r(), null, iVar2, i311110 | (i31119 & 7168) | ((i41114 << 3) & 57344) | (i41114 & 458752), 64), lazyListState.z(), function2B9, iVar2, 0, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i35 = i41115;
                    interfaceC0052b3 = interfaceC0052b2;
                    kVar3 = kVar2;
                    cVar3 = cVar2;
                    dVar3 = dVar2;
                }
                g2VarJ = iVar2.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                            invoke(iVar3, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar3, int i41116) {
                            LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                        }
                    });
                }
            }
            i15 |= 196608;
            if ((i14 & 64) != 0) {
                i15 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (iVarG.a(z13)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i15 |= i19;
            }
            i21 = i14 & 128;
            if (i21 != 0) {
                i15 |= 12582912;
            } else if ((i12 & 12582912) == 0) {
                if (iVarG.c(i11)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i15 |= i22;
            }
            i23 = i14 & 256;
            if (i23 != 0) {
                i15 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (iVarG.Q(interfaceC0052b)) {
                    i24 = 67108864;
                } else {
                    i24 = ASTNode.PCTX_STORED;
                }
                i15 |= i24;
            }
            i25 = i14 & 512;
            if (i25 != 0) {
                i15 |= 805306368;
            } else if ((i12 & 805306368) == 0) {
                if (iVarG.Q(kVar)) {
                    i26 = ASTNode.DISCARD;
                } else {
                    i26 = ASTNode.DEOP;
                }
                i15 |= i26;
            }
            i27 = i14 & 1024;
            if (i27 != 0) {
                i28 = i13 | 6;
            } else if ((i13 & 6) == 0) {
                if (iVarG.Q(cVar)) {
                    i29 = 4;
                } else {
                    i29 = 2;
                }
                i28 = i13 | i29;
            } else {
                i28 = i13;
            }
            i31 = i14 & 2048;
            if (i31 != 0) {
                i28 |= 48;
            } else if ((i13 & 48) == 0) {
                if (iVarG.Q(dVar)) {
                    i32 = 32;
                } else {
                    i32 = 16;
                }
                i28 |= i32;
            }
            i33 = i28;
            if ((i14 & 4096) != 0) {
                i33 |= 384;
            } else if ((i13 & 384) == 0) {
                i33 |= iVarG.A(function1) ? 256 : 128;
            }
            if ((306783379 & i15) != 306783378) {
                if (i21 != 0) {
                    i34 = 0;
                } else {
                    i34 = i11;
                }
                if (i23 != 0) {
                    interfaceC0052b2 = null;
                } else {
                    interfaceC0052b2 = interfaceC0052b;
                }
                if (i25 != 0) {
                    kVar2 = null;
                } else {
                    kVar2 = kVar;
                }
                if (i27 != 0) {
                    cVar2 = null;
                } else {
                    cVar2 = cVar;
                }
                if (i31 != 0) {
                    dVar2 = null;
                } else {
                    dVar2 = dVar;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                }
                int i311112 = (i15 >> 3) & 14;
                Function0<k> function0A10 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i311112 | ((i33 >> 3) & 112));
                int i311113 = i15 >> 9;
                z zVarA10 = w.a(lazyListState, z12, iVarG, i311112 | (i311113 & 112));
                objY = iVarG.y();
                if (objY == androidx.compose.runtime.i.f3413a.a()) {
                    androidx.compose.runtime.v vVar10 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                    iVarG.p(vVar10);
                    objY = vVar10;
                }
                int i311114 = i15 & 112;
                int i311115 = i15 & 7168;
                int i41116 = i15 >> 6;
                int i41117 = i33 << 21;
                int i41118 = i15;
                int i41119 = i34;
                Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B10 = b(function0A10, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i311114 | (i15 & 896) | i311115 | (i15 & 57344) | (i41116 & 458752) | (i41116 & 3670016) | (29360128 & i41117) | (i41117 & 234881024) | (1879048192 & i15), 0);
                if (z12) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation11 = orientation;
                iVar2 = iVarG;
                LazyLayoutKt.a(function0A10, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A10, zVarA10, orientation11, z13, z11, iVarG, (i41116 & 57344) | ((i41118 << 6) & 458752)), f.a(lazyListState, i41119, iVar2, i311112 | ((i41118 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation11, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i311115 | (i41118 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation11, z13, z11, gVar, lazyListState.r(), null, iVar2, i311114 | (i311113 & 7168) | ((i41118 << 3) & 57344) | (i41118 & 458752), 64), lazyListState.z(), function2B10, iVar2, 0, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i35 = i41119;
                interfaceC0052b3 = interfaceC0052b2;
                kVar3 = kVar2;
                cVar3 = cVar2;
                dVar3 = dVar2;
            } else {
                if (i21 != 0) {
                    i34 = 0;
                } else {
                    i34 = i11;
                }
                if (i23 != 0) {
                    interfaceC0052b2 = null;
                } else {
                    interfaceC0052b2 = interfaceC0052b;
                }
                if (i25 != 0) {
                    kVar2 = null;
                } else {
                    kVar2 = kVar;
                }
                if (i27 != 0) {
                    cVar2 = null;
                } else {
                    cVar2 = cVar;
                }
                if (i31 != 0) {
                    dVar2 = null;
                } else {
                    dVar2 = dVar;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                }
                int i311116 = (i15 >> 3) & 14;
                Function0<k> function0A11 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i311116 | ((i33 >> 3) & 112));
                int i311117 = i15 >> 9;
                z zVarA11 = w.a(lazyListState, z12, iVarG, i311116 | (i311117 & 112));
                objY = iVarG.y();
                if (objY == androidx.compose.runtime.i.f3413a.a()) {
                    androidx.compose.runtime.v vVar11 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                    iVarG.p(vVar11);
                    objY = vVar11;
                }
                int i311118 = i15 & 112;
                int i311119 = i15 & 7168;
                int i411110 = i15 >> 6;
                int i411111 = i33 << 21;
                int i411112 = i15;
                int i411113 = i34;
                Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B11 = b(function0A11, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i311118 | (i15 & 896) | i311119 | (i15 & 57344) | (i411110 & 458752) | (i411110 & 3670016) | (29360128 & i411111) | (i411111 & 234881024) | (1879048192 & i15), 0);
                if (z12) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation12 = orientation;
                iVar2 = iVarG;
                LazyLayoutKt.a(function0A11, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A11, zVarA11, orientation12, z13, z11, iVarG, (i411110 & 57344) | ((i411112 << 6) & 458752)), f.a(lazyListState, i411113, iVar2, i311116 | ((i411112 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation12, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i311119 | (i411112 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation12, z13, z11, gVar, lazyListState.r(), null, iVar2, i311118 | (i311117 & 7168) | ((i411112 << 3) & 57344) | (i411112 & 458752), 64), lazyListState.z(), function2B11, iVar2, 0, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i35 = i411113;
                interfaceC0052b3 = interfaceC0052b2;
                kVar3 = kVar2;
                cVar3 = cVar2;
                dVar3 = dVar2;
            }
            g2VarJ = iVar2.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                        invoke(iVar3, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar3, int i411114) {
                        LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                    }
                });
            }
        }
        i15 |= 3072;
        if ((i14 & 16) != 0) {
            i15 |= 24576;
        } else if ((i12 & 24576) == 0) {
            if (iVarG.a(z12)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i15 |= i17;
        }
        if ((i14 & 32) != 0) {
            if ((i12 & 196608) == 0) {
                if (iVarG.Q(gVar)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i15 |= i18;
            }
            if ((i14 & 64) != 0) {
                i15 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (iVarG.a(z13)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i15 |= i19;
            }
            i21 = i14 & 128;
            if (i21 != 0) {
                i15 |= 12582912;
            } else if ((i12 & 12582912) == 0) {
                if (iVarG.c(i11)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i15 |= i22;
            }
            i23 = i14 & 256;
            if (i23 != 0) {
                i15 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (iVarG.Q(interfaceC0052b)) {
                    i24 = 67108864;
                } else {
                    i24 = ASTNode.PCTX_STORED;
                }
                i15 |= i24;
            }
            i25 = i14 & 512;
            if (i25 != 0) {
                i15 |= 805306368;
            } else if ((i12 & 805306368) == 0) {
                if (iVarG.Q(kVar)) {
                    i26 = ASTNode.DISCARD;
                } else {
                    i26 = ASTNode.DEOP;
                }
                i15 |= i26;
            }
            i27 = i14 & 1024;
            if (i27 != 0) {
                i28 = i13 | 6;
            } else if ((i13 & 6) == 0) {
                if (iVarG.Q(cVar)) {
                    i29 = 4;
                } else {
                    i29 = 2;
                }
                i28 = i13 | i29;
            } else {
                i28 = i13;
            }
            i31 = i14 & 2048;
            if (i31 != 0) {
                i28 |= 48;
            } else if ((i13 & 48) == 0) {
                if (iVarG.Q(dVar)) {
                    i32 = 32;
                } else {
                    i32 = 16;
                }
                i28 |= i32;
            }
            i33 = i28;
            if ((i14 & 4096) != 0) {
                i33 |= 384;
            } else if ((i13 & 384) == 0) {
                i33 |= iVarG.A(function1) ? 256 : 128;
            }
            if ((306783379 & i15) != 306783378) {
                if (i21 != 0) {
                    i34 = 0;
                } else {
                    i34 = i11;
                }
                if (i23 != 0) {
                    interfaceC0052b2 = null;
                } else {
                    interfaceC0052b2 = interfaceC0052b;
                }
                if (i25 != 0) {
                    kVar2 = null;
                } else {
                    kVar2 = kVar;
                }
                if (i27 != 0) {
                    cVar2 = null;
                } else {
                    cVar2 = cVar;
                }
                if (i31 != 0) {
                    dVar2 = null;
                } else {
                    dVar2 = dVar;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                }
                int i3111110 = (i15 >> 3) & 14;
                Function0<k> function0A12 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i3111110 | ((i33 >> 3) & 112));
                int i3111111 = i15 >> 9;
                z zVarA12 = w.a(lazyListState, z12, iVarG, i3111110 | (i3111111 & 112));
                objY = iVarG.y();
                if (objY == androidx.compose.runtime.i.f3413a.a()) {
                    androidx.compose.runtime.v vVar12 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                    iVarG.p(vVar12);
                    objY = vVar12;
                }
                int i3111112 = i15 & 112;
                int i3111113 = i15 & 7168;
                int i411114 = i15 >> 6;
                int i411115 = i33 << 21;
                int i411116 = i15;
                int i411117 = i34;
                Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B12 = b(function0A12, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i3111112 | (i15 & 896) | i3111113 | (i15 & 57344) | (i411114 & 458752) | (i411114 & 3670016) | (29360128 & i411115) | (i411115 & 234881024) | (1879048192 & i15), 0);
                if (z12) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation13 = orientation;
                iVar2 = iVarG;
                LazyLayoutKt.a(function0A12, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A12, zVarA12, orientation13, z13, z11, iVarG, (i411114 & 57344) | ((i411116 << 6) & 458752)), f.a(lazyListState, i411117, iVar2, i3111110 | ((i411116 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation13, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i3111113 | (i411116 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation13, z13, z11, gVar, lazyListState.r(), null, iVar2, i3111112 | (i3111111 & 7168) | ((i411116 << 3) & 57344) | (i411116 & 458752), 64), lazyListState.z(), function2B12, iVar2, 0, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i35 = i411117;
                interfaceC0052b3 = interfaceC0052b2;
                kVar3 = kVar2;
                cVar3 = cVar2;
                dVar3 = dVar2;
            } else {
                if (i21 != 0) {
                    i34 = 0;
                } else {
                    i34 = i11;
                }
                if (i23 != 0) {
                    interfaceC0052b2 = null;
                } else {
                    interfaceC0052b2 = interfaceC0052b;
                }
                if (i25 != 0) {
                    kVar2 = null;
                } else {
                    kVar2 = kVar;
                }
                if (i27 != 0) {
                    cVar2 = null;
                } else {
                    cVar2 = cVar;
                }
                if (i31 != 0) {
                    dVar2 = null;
                } else {
                    dVar2 = dVar;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                }
                int i3111114 = (i15 >> 3) & 14;
                Function0<k> function0A13 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i3111114 | ((i33 >> 3) & 112));
                int i3111115 = i15 >> 9;
                z zVarA13 = w.a(lazyListState, z12, iVarG, i3111114 | (i3111115 & 112));
                objY = iVarG.y();
                if (objY == androidx.compose.runtime.i.f3413a.a()) {
                    androidx.compose.runtime.v vVar13 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                    iVarG.p(vVar13);
                    objY = vVar13;
                }
                int i3111116 = i15 & 112;
                int i3111117 = i15 & 7168;
                int i411118 = i15 >> 6;
                int i411119 = i33 << 21;
                int i4111110 = i15;
                int i4111111 = i34;
                Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B13 = b(function0A13, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i3111116 | (i15 & 896) | i3111117 | (i15 & 57344) | (i411118 & 458752) | (i411118 & 3670016) | (29360128 & i411119) | (i411119 & 234881024) | (1879048192 & i15), 0);
                if (z12) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation14 = orientation;
                iVar2 = iVarG;
                LazyLayoutKt.a(function0A13, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A13, zVarA13, orientation14, z13, z11, iVarG, (i411118 & 57344) | ((i4111110 << 6) & 458752)), f.a(lazyListState, i4111111, iVar2, i3111114 | ((i4111110 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation14, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i3111117 | (i4111110 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation14, z13, z11, gVar, lazyListState.r(), null, iVar2, i3111116 | (i3111115 & 7168) | ((i4111110 << 3) & 57344) | (i4111110 & 458752), 64), lazyListState.z(), function2B13, iVar2, 0, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i35 = i4111111;
                interfaceC0052b3 = interfaceC0052b2;
                kVar3 = kVar2;
                cVar3 = cVar2;
                dVar3 = dVar2;
            }
            g2VarJ = iVar2.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                        invoke(iVar3, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar3, int i4111112) {
                        LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                    }
                });
            }
        }
        i15 |= 196608;
        if ((i14 & 64) != 0) {
            i15 |= 1572864;
        } else if ((i12 & 1572864) == 0) {
            if (iVarG.a(z13)) {
                i19 = 1048576;
            } else {
                i19 = 524288;
            }
            i15 |= i19;
        }
        i21 = i14 & 128;
        if (i21 != 0) {
            i15 |= 12582912;
        } else if ((i12 & 12582912) == 0) {
            if (iVarG.c(i11)) {
                i22 = 8388608;
            } else {
                i22 = 4194304;
            }
            i15 |= i22;
        }
        i23 = i14 & 256;
        if (i23 != 0) {
            i15 |= 100663296;
        } else if ((i12 & 100663296) == 0) {
            if (iVarG.Q(interfaceC0052b)) {
                i24 = 67108864;
            } else {
                i24 = ASTNode.PCTX_STORED;
            }
            i15 |= i24;
        }
        i25 = i14 & 512;
        if (i25 != 0) {
            i15 |= 805306368;
        } else if ((i12 & 805306368) == 0) {
            if (iVarG.Q(kVar)) {
                i26 = ASTNode.DISCARD;
            } else {
                i26 = ASTNode.DEOP;
            }
            i15 |= i26;
        }
        i27 = i14 & 1024;
        if (i27 != 0) {
            i28 = i13 | 6;
        } else if ((i13 & 6) == 0) {
            if (iVarG.Q(cVar)) {
                i29 = 4;
            } else {
                i29 = 2;
            }
            i28 = i13 | i29;
        } else {
            i28 = i13;
        }
        i31 = i14 & 2048;
        if (i31 != 0) {
            i28 |= 48;
        } else if ((i13 & 48) == 0) {
            if (iVarG.Q(dVar)) {
                i32 = 32;
            } else {
                i32 = 16;
            }
            i28 |= i32;
        }
        i33 = i28;
        if ((i14 & 4096) != 0) {
            i33 |= 384;
        } else if ((i13 & 384) == 0) {
            i33 |= iVarG.A(function1) ? 256 : 128;
        }
        if ((306783379 & i15) != 306783378) {
            if (i21 != 0) {
                i34 = 0;
            } else {
                i34 = i11;
            }
            if (i23 != 0) {
                interfaceC0052b2 = null;
            } else {
                interfaceC0052b2 = interfaceC0052b;
            }
            if (i25 != 0) {
                kVar2 = null;
            } else {
                kVar2 = kVar;
            }
            if (i27 != 0) {
                cVar2 = null;
            } else {
                cVar2 = cVar;
            }
            if (i31 != 0) {
                dVar2 = null;
            } else {
                dVar2 = dVar;
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
            }
            int i3111118 = (i15 >> 3) & 14;
            Function0<k> function0A14 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i3111118 | ((i33 >> 3) & 112));
            int i3111119 = i15 >> 9;
            z zVarA14 = w.a(lazyListState, z12, iVarG, i3111118 | (i3111119 & 112));
            objY = iVarG.y();
            if (objY == androidx.compose.runtime.i.f3413a.a()) {
                androidx.compose.runtime.v vVar14 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                iVarG.p(vVar14);
                objY = vVar14;
            }
            int i31111110 = i15 & 112;
            int i31111111 = i15 & 7168;
            int i4111112 = i15 >> 6;
            int i4111113 = i33 << 21;
            int i4111114 = i15;
            int i4111115 = i34;
            Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B14 = b(function0A14, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i31111110 | (i15 & 896) | i31111111 | (i15 & 57344) | (i4111112 & 458752) | (i4111112 & 3670016) | (29360128 & i4111113) | (i4111113 & 234881024) | (1879048192 & i15), 0);
            if (z12) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation15 = orientation;
            iVar2 = iVarG;
            LazyLayoutKt.a(function0A14, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A14, zVarA14, orientation15, z13, z11, iVarG, (i4111112 & 57344) | ((i4111114 << 6) & 458752)), f.a(lazyListState, i4111115, iVar2, i3111118 | ((i4111114 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation15, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i31111111 | (i4111114 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation15, z13, z11, gVar, lazyListState.r(), null, iVar2, i31111110 | (i3111119 & 7168) | ((i4111114 << 3) & 57344) | (i4111114 & 458752), 64), lazyListState.z(), function2B14, iVar2, 0, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            i35 = i4111115;
            interfaceC0052b3 = interfaceC0052b2;
            kVar3 = kVar2;
            cVar3 = cVar2;
            dVar3 = dVar2;
        } else {
            if (i21 != 0) {
                i34 = 0;
            } else {
                i34 = i11;
            }
            if (i23 != 0) {
                interfaceC0052b2 = null;
            } else {
                interfaceC0052b2 = interfaceC0052b;
            }
            if (i25 != 0) {
                kVar2 = null;
            } else {
                kVar2 = kVar;
            }
            if (i27 != 0) {
                cVar2 = null;
            } else {
                cVar2 = cVar;
            }
            if (i31 != 0) {
                dVar2 = null;
            } else {
                dVar2 = dVar;
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(620764179, i15, i33, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
            }
            int i31111112 = (i15 >> 3) & 14;
            Function0<k> function0A15 = LazyListItemProviderKt.a(lazyListState, function1, iVarG, i31111112 | ((i33 >> 3) & 112));
            int i31111113 = i15 >> 9;
            z zVarA15 = w.a(lazyListState, z12, iVarG, i31111112 | (i31111113 & 112));
            objY = iVarG.y();
            if (objY == androidx.compose.runtime.i.f3413a.a()) {
                androidx.compose.runtime.v vVar15 = new androidx.compose.runtime.v(g0.g(EmptyCoroutineContext.INSTANCE, iVarG));
                iVarG.p(vVar15);
                objY = vVar15;
            }
            int i31111114 = i15 & 112;
            int i31111115 = i15 & 7168;
            int i4111116 = i15 >> 6;
            int i4111117 = i33 << 21;
            int i4111118 = i15;
            int i4111119 = i34;
            Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2B15 = b(function0A15, lazyListState, tVar, z11, z12, i34, interfaceC0052b2, cVar2, dVar2, kVar2, ((androidx.compose.runtime.v) objY).a(), (c4) iVarG.l(CompositionLocalsKt.e()), !((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue(), iVarG, i31111114 | (i15 & 896) | i31111115 | (i15 & 57344) | (i4111116 & 458752) | (i4111116 & 3670016) | (29360128 & i4111117) | (i4111117 & 234881024) | (1879048192 & i15), 0);
            if (z12) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation16 = orientation;
            iVar2 = iVarG;
            LazyLayoutKt.a(function0A15, i0.a(androidx.compose.foundation.lazy.layout.g.b(a0.c(fVar.f(lazyListState.B()).f(lazyListState.m()), function0A15, zVarA15, orientation16, z13, z11, iVarG, (i4111116 & 57344) | ((i4111118 << 6) & 458752)), f.a(lazyListState, i4111119, iVar2, i31111112 | ((i4111118 >> 18) & 112)), lazyListState.n(), z11, (LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation16, z13, iVar2, (androidx.compose.runtime.collection.b.f3357d << 6) | i31111115 | (i4111118 & 3670016)).f(lazyListState.s().j()), lazyListState, orientation16, z13, z11, gVar, lazyListState.r(), null, iVar2, i31111114 | (i31111113 & 7168) | ((i4111118 << 3) & 57344) | (i4111118 & 458752), 64), lazyListState.z(), function2B15, iVar2, 0, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            i35 = i4111119;
            interfaceC0052b3 = interfaceC0052b2;
            kVar3 = kVar2;
            cVar3 = cVar2;
            dVar3 = dVar2;
        }
        g2VarJ = iVar2.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                    invoke(iVar3, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar3, int i41111110) {
                    LazyListKt.a(fVar, lazyListState, tVar, z11, z12, gVar, z13, i35, interfaceC0052b3, kVar3, cVar3, dVar3, function1, iVar3, v1.a(i12 | 1), v1.a(i13), i14);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x0101  */
    public static final Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> b(final Function0<? extends k> function0, final LazyListState lazyListState, final androidx.compose.foundation.layout.t tVar, final boolean z11, final boolean z12, final int i11, final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, final androidx.compose.ui.b.c cVar, final androidx.compose.foundation.layout.b.d dVar, final androidx.compose.foundation.layout.b.k kVar, final k0 k0Var, final c4 c4Var, final boolean z13, androidx.compose.runtime.i iVar, int i12, int i13) {
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1972347046, i12, i13, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:170)");
        }
        if (((i12 & 112) ^ 48) > 32 && iVar.Q(lazyListState)) {
            z14 = true;
        } else if ((i12 & 48) == 32) {
            z14 = true;
        } else {
            z14 = false;
        }
        boolean z18 = z14 | ((((i12 & 896) ^ 384) > 256 && iVar.Q(tVar)) || (i12 & 384) == 256) | ((((i12 & 7168) ^ 3072) > 2048 && iVar.a(z11)) || (i12 & 3072) == 2048) | ((((57344 & i12) ^ 24576) > 16384 && iVar.a(z12)) || (i12 & 24576) == 16384) | ((((3670016 & i12) ^ 1572864) > 1048576 && iVar.Q(interfaceC0052b)) || (i12 & 1572864) == 1048576) | ((((29360128 & i12) ^ 12582912) > 8388608 && iVar.Q(cVar)) || (i12 & 12582912) == 8388608);
        if (((234881024 & i12) ^ 100663296) > 67108864 && iVar.Q(dVar)) {
            z15 = true;
        } else if ((100663296 & i12) == 67108864) {
            z15 = true;
        } else {
            z15 = false;
        }
        boolean z19 = z18 | z15;
        if (((1879048192 & i12) ^ 805306368) > 536870912 && iVar.Q(kVar)) {
            z16 = true;
        } else if ((i12 & 805306368) == 536870912) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean zQ = z16 | z19 | iVar.Q(c4Var);
        if (((i13 & 896) ^ 384) > 256 && iVar.a(z13)) {
            z17 = true;
        } else if ((i13 & 384) == 256) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z21 = zQ | z17;
        Object objY = iVar.y();
        if (z21 || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new Function2<androidx.compose.foundation.lazy.layout.q, q2.b, m>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1

                /* JADX INFO: compiled from: source.java */
                @Metadata
                public static final class a extends o {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ boolean f2537d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    public final /* synthetic */ androidx.compose.foundation.lazy.layout.q f2538e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    public final /* synthetic */ int f2539f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ int f2540g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    public final /* synthetic */ androidx.compose.ui.b.InterfaceC0052b f2541h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    public final /* synthetic */ androidx.compose.ui.b.c f2542i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ boolean f2543j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ int f2544k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    public final /* synthetic */ int f2545l;

                    /* JADX INFO: renamed from: m, reason: collision with root package name */
                    public final /* synthetic */ long f2546m;

                    /* JADX INFO: renamed from: n, reason: collision with root package name */
                    public final /* synthetic */ LazyListState f2547n;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public a(long j11, boolean z11, k kVar, androidx.compose.foundation.lazy.layout.q qVar, int i11, int i12, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, androidx.compose.ui.b.c cVar, boolean z12, int i13, int i14, long j12, LazyListState lazyListState) {
                        super(j11, z11, kVar, qVar, null);
                        this.f2537d = z11;
                        this.f2538e = qVar;
                        this.f2539f = i11;
                        this.f2540g = i12;
                        this.f2541h = interfaceC0052b;
                        this.f2542i = cVar;
                        this.f2543j = z12;
                        this.f2544k = i13;
                        this.f2545l = i14;
                        this.f2546m = j12;
                        this.f2547n = lazyListState;
                    }

                    @Override // androidx.compose.foundation.lazy.o
                    public n b(int i11, Object obj, Object obj2, List<? extends androidx.compose.ui.layout.k0> list, long j11) {
                        return new n(i11, list, this.f2537d, this.f2541h, this.f2542i, this.f2538e.getLayoutDirection(), this.f2543j, this.f2544k, this.f2545l, i11 == this.f2539f + (-1) ? 0 : this.f2540g, this.f2546m, obj, obj2, this.f2547n.s(), j11, null);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ m invoke(androidx.compose.foundation.lazy.layout.q qVar, q2.b bVar) {
                    return m29invoke0kLqBqw(qVar, bVar.r());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final m m29invoke0kLqBqw(final androidx.compose.foundation.lazy.layout.q qVar, final long j11) {
                    int i14;
                    float fA;
                    long jA;
                    e0.a(lazyListState.u());
                    boolean z22 = lazyListState.q() || qVar.d0();
                    androidx.compose.foundation.d.a(j11, z12 ? Orientation.Vertical : Orientation.Horizontal);
                    int iK0 = z12 ? qVar.k0(tVar.b(qVar.getLayoutDirection())) : qVar.k0(PaddingKt.e(tVar, qVar.getLayoutDirection()));
                    int iK1 = z12 ? qVar.k0(tVar.c(qVar.getLayoutDirection())) : qVar.k0(PaddingKt.d(tVar, qVar.getLayoutDirection()));
                    int iK2 = qVar.k0(tVar.d());
                    int iK3 = qVar.k0(tVar.a());
                    final int i15 = iK2 + iK3;
                    final int i16 = iK0 + iK1;
                    boolean z23 = z12;
                    int i17 = z23 ? i15 : i16;
                    if (z23 && !z11) {
                        i14 = iK2;
                    } else if (z23 && z11) {
                        i14 = iK3;
                    } else {
                        i14 = (z23 || z11) ? iK1 : iK0;
                    }
                    int i18 = i17 - i14;
                    long jN = q2.c.n(j11, -i16, -i15);
                    k kVarInvoke = function0.invoke();
                    kVarInvoke.d().a(q2.b.l(jN), q2.b.k(jN));
                    if (z12) {
                        androidx.compose.foundation.layout.b.k kVar2 = kVar;
                        if (kVar2 == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                        }
                        fA = kVar2.a();
                    } else {
                        androidx.compose.foundation.layout.b.d dVar2 = dVar;
                        if (dVar2 == null) {
                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false".toString());
                        }
                        fA = dVar2.a();
                    }
                    int iK4 = qVar.k0(fA);
                    int itemCount = kVarInvoke.getItemCount();
                    int iK = z12 ? q2.b.k(j11) - i15 : q2.b.l(j11) - i16;
                    if (!z11 || iK > 0) {
                        jA = q2.q.a(iK0, iK2);
                    } else {
                        boolean z24 = z12;
                        if (!z24) {
                            iK0 += iK;
                        }
                        if (z24) {
                            iK2 += iK;
                        }
                        jA = q2.q.a(iK0, iK2);
                    }
                    a aVar = new a(jN, z12, kVarInvoke, qVar, itemCount, iK4, interfaceC0052b, cVar, z11, i14, i18, jA, lazyListState);
                    androidx.compose.runtime.snapshots.j.a aVar2 = androidx.compose.runtime.snapshots.j.f3684e;
                    LazyListState lazyListState2 = lazyListState;
                    androidx.compose.runtime.snapshots.j jVarD = aVar2.d();
                    Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
                    androidx.compose.runtime.snapshots.j jVarF = aVar2.f(jVarD);
                    try {
                        int iM = lazyListState2.M(kVarInvoke, lazyListState2.o());
                        int iP = lazyListState2.p();
                        Unit unit = Unit.f68710a;
                        aVar2.m(jVarD, jVarF, function1H);
                        List<Integer> listA = androidx.compose.foundation.lazy.layout.i.a(kVarInvoke, lazyListState.w(), lazyListState.n());
                        m mVarE = LazyListMeasureKt.e(itemCount, aVar, iK, i14, i18, iK4, iM, iP, (qVar.d0() || !z22) ? lazyListState.D() : lazyListState.C(), jN, z12, z13 ? kVarInvoke.f() : kotlin.collections.g.l(), kVar, dVar, z11, qVar, lazyListState.s(), i11, listA, z22, qVar.d0(), lazyListState.y(), k0Var, lazyListState.x(), c4Var, new Function3<Integer, Integer, Function1<? super androidx.compose.ui.layout.k0.a, ? extends Unit>, androidx.compose.ui.layout.w>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public final androidx.compose.ui.layout.w invoke(int i19, int i21, Function1<? super androidx.compose.ui.layout.k0.a, Unit> function1) {
                                return qVar.y0(q2.c.i(j11, i19 + i16), q2.c.h(j11, i21 + i15), kotlin.collections.s.h(), function1);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ androidx.compose.ui.layout.w invoke(Integer num, Integer num2, Function1<? super androidx.compose.ui.layout.k0.a, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super androidx.compose.ui.layout.k0.a, Unit>) function1);
                            }
                        });
                        LazyListState.l(lazyListState, mVarE, qVar.d0(), false, 4, null);
                        return mVarE;
                    } catch (Throwable th2) {
                        aVar2.m(jVarD, jVarF, function1H);
                        throw th2;
                    }
                }
            };
            iVar.p(objY);
        }
        Function2<androidx.compose.foundation.lazy.layout.q, q2.b, androidx.compose.ui.layout.w> function2 = (Function2) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return function2;
    }
}
