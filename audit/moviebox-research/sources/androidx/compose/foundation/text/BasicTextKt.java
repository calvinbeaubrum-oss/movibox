package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.foundation.text.selection.j;
import androidx.compose.foundation.text.selection.m;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.s;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.d4;
import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.t;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
public final class BasicTextKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:101:0x0123  */
    /* JADX WARN: Code duplicated, block: B:103:0x0126  */
    /* JADX WARN: Code duplicated, block: B:104:0x012d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0131  */
    /* JADX WARN: Code duplicated, block: B:108:0x0133  */
    /* JADX WARN: Code duplicated, block: B:110:0x0136  */
    /* JADX WARN: Code duplicated, block: B:111:0x013d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0142  */
    /* JADX WARN: Code duplicated, block: B:117:0x014a  */
    /* JADX WARN: Code duplicated, block: B:120:0x018b  */
    /* JADX WARN: Code duplicated, block: B:124:0x019c  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:94:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x0118  */
    @Deprecated
    public static final /* synthetic */ void a(final String str, f fVar, e0 e0Var, Function1 function1, int i11, boolean z11, int i12, int i13, i iVar, final int i14, final int i15) {
        int i16;
        int i17;
        e0 e0VarA;
        int i18;
        int i19;
        Function1 function2;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z12;
        int i26;
        int i27;
        int i28;
        int i29;
        int i31;
        final f fVar2;
        final Function1 function3;
        final int iA;
        boolean z13;
        int i32;
        final e0 e0Var2;
        final int i33;
        final int i34;
        final boolean z14;
        g2 g2VarJ;
        i iVarG = iVar.g(1542716361);
        if ((i15 & 1) != 0) {
            i16 = i14 | 6;
        } else if ((i14 & 6) == 0) {
            i16 = (iVarG.Q(str) ? 4 : 2) | i14;
        } else {
            i16 = i14;
        }
        int i35 = i15 & 2;
        if (i35 == 0) {
            if ((i14 & 48) == 0) {
                i16 |= iVarG.Q(fVar) ? 32 : 16;
            }
            i17 = i15 & 4;
            if (i17 != 0) {
                if ((i14 & 384) == 0) {
                    e0VarA = e0Var;
                    if (iVarG.Q(e0VarA)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i16 |= i18;
                }
                i19 = i15 & 8;
                if (i19 != 0) {
                    if ((i14 & 3072) == 0) {
                        function2 = function1;
                        if (iVarG.A(function2)) {
                            i21 = 2048;
                        } else {
                            i21 = 1024;
                        }
                        i16 |= i21;
                    }
                    i22 = i15 & 16;
                    if (i22 != 0) {
                        if ((i14 & 24576) == 0) {
                            i23 = i11;
                            if (iVarG.c(i23)) {
                                i24 = 16384;
                            } else {
                                i24 = 8192;
                            }
                            i16 |= i24;
                        }
                        i25 = i15 & 32;
                        if (i25 != 0) {
                            if ((196608 & i14) == 0) {
                                z12 = z11;
                                if (iVarG.a(z12)) {
                                    i26 = 131072;
                                } else {
                                    i26 = 65536;
                                }
                                i16 |= i26;
                            }
                            i27 = i15 & 64;
                            if (i27 != 0) {
                                i16 |= 1572864;
                            } else if ((i14 & 1572864) == 0) {
                                if (iVarG.c(i12)) {
                                    i28 = 1048576;
                                } else {
                                    i28 = 524288;
                                }
                                i16 |= i28;
                            }
                            i29 = i15 & 128;
                            if (i29 != 0) {
                                i16 |= 12582912;
                            } else if ((i14 & 12582912) == 0) {
                                if (iVarG.c(i13)) {
                                    i31 = 8388608;
                                } else {
                                    i31 = 4194304;
                                }
                                i16 |= i31;
                            }
                            if ((i16 & 4793491) == 4793490 || !iVarG.h()) {
                                if (i35 != 0) {
                                    fVar2 = f.f3863a;
                                } else {
                                    fVar2 = fVar;
                                }
                                if (i17 != 0) {
                                    e0VarA = e0.f5774d.a();
                                }
                                if (i19 != 0) {
                                    function3 = null;
                                } else {
                                    function3 = function2;
                                }
                                if (i22 != 0) {
                                    iA = p.f6143a.a();
                                } else {
                                    iA = i23;
                                }
                                if (i25 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z12;
                                }
                                if (i27 != 0) {
                                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                                } else {
                                    i32 = i12;
                                }
                                int i36 = i29 == 0 ? i13 : 1;
                                if (k.J()) {
                                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                                }
                                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                                if (k.J()) {
                                    k.R();
                                }
                                e0Var2 = e0VarA;
                                i33 = i32;
                                boolean z15 = z13;
                                i34 = i36;
                                z14 = z15;
                            } else {
                                iVarG.H();
                                fVar2 = fVar;
                                i34 = i13;
                                e0Var2 = e0VarA;
                                function3 = function2;
                                iA = i23;
                                z14 = z12;
                                i33 = i12;
                            }
                            g2VarJ = iVarG.j();
                            if (g2VarJ != null) {
                                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                        invoke(iVar2, num.intValue());
                                        return Unit.f68710a;
                                    }

                                    public final void invoke(i iVar2, int i37) {
                                        BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                                    }
                                });
                            }
                        }
                        i16 |= 196608;
                        z12 = z11;
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        if ((i16 & 4793491) == 4793490) {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z16 = z13;
                            i34 = i36;
                            z14 = z16;
                        } else {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z17 = z13;
                            i34 = i36;
                            z14 = z17;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i37) {
                                    BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 24576;
                    i23 = i11;
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        if ((i16 & 4793491) == 4793490) {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z18 = z13;
                            i34 = i36;
                            z14 = z18;
                        } else {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z19 = z13;
                            i34 = i36;
                            z14 = z19;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i37) {
                                    BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z110 = z13;
                        i34 = i36;
                        z14 = z110;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z111 = z13;
                        i34 = i36;
                        z14 = z111;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 3072;
                function2 = function1;
                i22 = i15 & 16;
                if (i22 != 0) {
                    if ((i14 & 24576) == 0) {
                        i23 = i11;
                        if (iVarG.c(i23)) {
                            i24 = 16384;
                        } else {
                            i24 = 8192;
                        }
                        i16 |= i24;
                    }
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        if ((i16 & 4793491) == 4793490) {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z112 = z13;
                            i34 = i36;
                            z14 = z112;
                        } else {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z113 = z13;
                            i34 = i36;
                            z14 = z113;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i37) {
                                    BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z114 = z13;
                        i34 = i36;
                        z14 = z114;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z115 = z13;
                        i34 = i36;
                        z14 = z115;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 24576;
                i23 = i11;
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z116 = z13;
                        i34 = i36;
                        z14 = z116;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z117 = z13;
                        i34 = i36;
                        z14 = z117;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z118 = z13;
                    i34 = i36;
                    z14 = z118;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z119 = z13;
                    i34 = i36;
                    z14 = z119;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 384;
            e0VarA = e0Var;
            i19 = i15 & 8;
            if (i19 != 0) {
                if ((i14 & 3072) == 0) {
                    function2 = function1;
                    if (iVarG.A(function2)) {
                        i21 = 2048;
                    } else {
                        i21 = 1024;
                    }
                    i16 |= i21;
                }
                i22 = i15 & 16;
                if (i22 != 0) {
                    if ((i14 & 24576) == 0) {
                        i23 = i11;
                        if (iVarG.c(i23)) {
                            i24 = 16384;
                        } else {
                            i24 = 8192;
                        }
                        i16 |= i24;
                    }
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        if ((i16 & 4793491) == 4793490) {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z1110 = z13;
                            i34 = i36;
                            z14 = z1110;
                        } else {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z1111 = z13;
                            i34 = i36;
                            z14 = z1111;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i37) {
                                    BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1112 = z13;
                        i34 = i36;
                        z14 = z1112;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1113 = z13;
                        i34 = i36;
                        z14 = z1113;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 24576;
                i23 = i11;
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1114 = z13;
                        i34 = i36;
                        z14 = z1114;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1115 = z13;
                        i34 = i36;
                        z14 = z1115;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z1116 = z13;
                    i34 = i36;
                    z14 = z1116;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z1117 = z13;
                    i34 = i36;
                    z14 = z1117;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 3072;
            function2 = function1;
            i22 = i15 & 16;
            if (i22 != 0) {
                if ((i14 & 24576) == 0) {
                    i23 = i11;
                    if (iVarG.c(i23)) {
                        i24 = 16384;
                    } else {
                        i24 = 8192;
                    }
                    i16 |= i24;
                }
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1118 = z13;
                        i34 = i36;
                        z14 = z1118;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1119 = z13;
                        i34 = i36;
                        z14 = z1119;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z11110 = z13;
                    i34 = i36;
                    z14 = z11110;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z11111 = z13;
                    i34 = i36;
                    z14 = z11111;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 24576;
            i23 = i11;
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z11112 = z13;
                    i34 = i36;
                    z14 = z11112;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z11113 = z13;
                    i34 = i36;
                    z14 = z11113;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            if ((i16 & 4793491) == 4793490) {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z11114 = z13;
                i34 = i36;
                z14 = z11114;
            } else {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z11115 = z13;
                i34 = i36;
                z14 = z11115;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i37) {
                        BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 48;
        i17 = i15 & 4;
        if (i17 != 0) {
            if ((i14 & 384) == 0) {
                e0VarA = e0Var;
                if (iVarG.Q(e0VarA)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i16 |= i18;
            }
            i19 = i15 & 8;
            if (i19 != 0) {
                if ((i14 & 3072) == 0) {
                    function2 = function1;
                    if (iVarG.A(function2)) {
                        i21 = 2048;
                    } else {
                        i21 = 1024;
                    }
                    i16 |= i21;
                }
                i22 = i15 & 16;
                if (i22 != 0) {
                    if ((i14 & 24576) == 0) {
                        i23 = i11;
                        if (iVarG.c(i23)) {
                            i24 = 16384;
                        } else {
                            i24 = 8192;
                        }
                        i16 |= i24;
                    }
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        if ((i16 & 4793491) == 4793490) {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z11116 = z13;
                            i34 = i36;
                            z14 = z11116;
                        } else {
                            if (i35 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            }
                            if (i19 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i32 = i12;
                            }
                            if (i29 == 0) {
                            }
                            if (k.J()) {
                                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                            }
                            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                            if (k.J()) {
                                k.R();
                            }
                            e0Var2 = e0VarA;
                            i33 = i32;
                            boolean z11117 = z13;
                            i34 = i36;
                            z14 = z11117;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i37) {
                                    BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z11118 = z13;
                        i34 = i36;
                        z14 = z11118;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z11119 = z13;
                        i34 = i36;
                        z14 = z11119;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 24576;
                i23 = i11;
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z111110 = z13;
                        i34 = i36;
                        z14 = z111110;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z111111 = z13;
                        i34 = i36;
                        z14 = z111111;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z111112 = z13;
                    i34 = i36;
                    z14 = z111112;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z111113 = z13;
                    i34 = i36;
                    z14 = z111113;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 3072;
            function2 = function1;
            i22 = i15 & 16;
            if (i22 != 0) {
                if ((i14 & 24576) == 0) {
                    i23 = i11;
                    if (iVarG.c(i23)) {
                        i24 = 16384;
                    } else {
                        i24 = 8192;
                    }
                    i16 |= i24;
                }
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z111114 = z13;
                        i34 = i36;
                        z14 = z111114;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z111115 = z13;
                        i34 = i36;
                        z14 = z111115;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z111116 = z13;
                    i34 = i36;
                    z14 = z111116;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z111117 = z13;
                    i34 = i36;
                    z14 = z111117;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 24576;
            i23 = i11;
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z111118 = z13;
                    i34 = i36;
                    z14 = z111118;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z111119 = z13;
                    i34 = i36;
                    z14 = z111119;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            if ((i16 & 4793491) == 4793490) {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z1111110 = z13;
                i34 = i36;
                z14 = z1111110;
            } else {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z1111111 = z13;
                i34 = i36;
                z14 = z1111111;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i37) {
                        BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 384;
        e0VarA = e0Var;
        i19 = i15 & 8;
        if (i19 != 0) {
            if ((i14 & 3072) == 0) {
                function2 = function1;
                if (iVarG.A(function2)) {
                    i21 = 2048;
                } else {
                    i21 = 1024;
                }
                i16 |= i21;
            }
            i22 = i15 & 16;
            if (i22 != 0) {
                if ((i14 & 24576) == 0) {
                    i23 = i11;
                    if (iVarG.c(i23)) {
                        i24 = 16384;
                    } else {
                        i24 = 8192;
                    }
                    i16 |= i24;
                }
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    if ((i16 & 4793491) == 4793490) {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1111112 = z13;
                        i34 = i36;
                        z14 = z1111112;
                    } else {
                        if (i35 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        }
                        if (i19 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i32 = i12;
                        }
                        if (i29 == 0) {
                        }
                        if (k.J()) {
                            k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                        }
                        b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                        if (k.J()) {
                            k.R();
                        }
                        e0Var2 = e0VarA;
                        i33 = i32;
                        boolean z1111113 = z13;
                        i34 = i36;
                        z14 = z1111113;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i37) {
                                BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z1111114 = z13;
                    i34 = i36;
                    z14 = z1111114;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z1111115 = z13;
                    i34 = i36;
                    z14 = z1111115;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 24576;
            i23 = i11;
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z1111116 = z13;
                    i34 = i36;
                    z14 = z1111116;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z1111117 = z13;
                    i34 = i36;
                    z14 = z1111117;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            if ((i16 & 4793491) == 4793490) {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z1111118 = z13;
                i34 = i36;
                z14 = z1111118;
            } else {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z1111119 = z13;
                i34 = i36;
                z14 = z1111119;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i37) {
                        BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 3072;
        function2 = function1;
        i22 = i15 & 16;
        if (i22 != 0) {
            if ((i14 & 24576) == 0) {
                i23 = i11;
                if (iVarG.c(i23)) {
                    i24 = 16384;
                } else {
                    i24 = 8192;
                }
                i16 |= i24;
            }
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                if ((i16 & 4793491) == 4793490) {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z11111110 = z13;
                    i34 = i36;
                    z14 = z11111110;
                } else {
                    if (i35 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    }
                    if (i19 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i32 = i12;
                    }
                    if (i29 == 0) {
                    }
                    if (k.J()) {
                        k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                    }
                    b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                    if (k.J()) {
                        k.R();
                    }
                    e0Var2 = e0VarA;
                    i33 = i32;
                    boolean z11111111 = z13;
                    i34 = i36;
                    z14 = z11111111;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i37) {
                            BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            if ((i16 & 4793491) == 4793490) {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z11111112 = z13;
                i34 = i36;
                z14 = z11111112;
            } else {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z11111113 = z13;
                i34 = i36;
                z14 = z11111113;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i37) {
                        BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 24576;
        i23 = i11;
        i25 = i15 & 32;
        if (i25 != 0) {
            if ((196608 & i14) == 0) {
                z12 = z11;
                if (iVarG.a(z12)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i16 |= i26;
            }
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            if ((i16 & 4793491) == 4793490) {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z11111114 = z13;
                i34 = i36;
                z14 = z11111114;
            } else {
                if (i35 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                }
                if (i19 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i32 = i12;
                }
                if (i29 == 0) {
                }
                if (k.J()) {
                    k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
                if (k.J()) {
                    k.R();
                }
                e0Var2 = e0VarA;
                i33 = i32;
                boolean z11111115 = z13;
                i34 = i36;
                z14 = z11111115;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i37) {
                        BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 196608;
        z12 = z11;
        i27 = i15 & 64;
        if (i27 != 0) {
            i16 |= 1572864;
        } else if ((i14 & 1572864) == 0) {
            if (iVarG.c(i12)) {
                i28 = 1048576;
            } else {
                i28 = 524288;
            }
            i16 |= i28;
        }
        i29 = i15 & 128;
        if (i29 != 0) {
            i16 |= 12582912;
        } else if ((i14 & 12582912) == 0) {
            if (iVarG.c(i13)) {
                i31 = 8388608;
            } else {
                i31 = 4194304;
            }
            i16 |= i31;
        }
        if ((i16 & 4793491) == 4793490) {
            if (i35 != 0) {
                fVar2 = f.f3863a;
            } else {
                fVar2 = fVar;
            }
            if (i17 != 0) {
                e0VarA = e0.f5774d.a();
            }
            if (i19 != 0) {
                function3 = null;
            } else {
                function3 = function2;
            }
            if (i22 != 0) {
                iA = p.f6143a.a();
            } else {
                iA = i23;
            }
            if (i25 != 0) {
                z13 = true;
            } else {
                z13 = z12;
            }
            if (i27 != 0) {
                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else {
                i32 = i12;
            }
            if (i29 == 0) {
            }
            if (k.J()) {
                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
            }
            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
            if (k.J()) {
                k.R();
            }
            e0Var2 = e0VarA;
            i33 = i32;
            boolean z11111116 = z13;
            i34 = i36;
            z14 = z11111116;
        } else {
            if (i35 != 0) {
                fVar2 = f.f3863a;
            } else {
                fVar2 = fVar;
            }
            if (i17 != 0) {
                e0VarA = e0.f5774d.a();
            }
            if (i19 != 0) {
                function3 = null;
            } else {
                function3 = function2;
            }
            if (i22 != 0) {
                iA = p.f6143a.a();
            } else {
                iA = i23;
            }
            if (i25 != 0) {
                z13 = true;
            } else {
                z13 = z12;
            }
            if (i27 != 0) {
                i32 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else {
                i32 = i12;
            }
            if (i29 == 0) {
            }
            if (k.J()) {
                k.S(1542716361, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
            }
            b(str, fVar2, e0VarA, function3, iA, z13, i32, i36, null, iVarG, (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 256);
            if (k.J()) {
                k.R();
            }
            e0Var2 = e0VarA;
            i33 = i32;
            boolean z11111117 = z13;
            i34 = i36;
            z14 = z11111117;
        }
        g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i37) {
                    BasicTextKt.a(str, fVar2, e0Var2, function3, iA, z14, i33, i34, iVar2, v1.a(i14 | 1), i15);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0117  */
    /* JADX WARN: Code duplicated, block: B:104:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0132  */
    /* JADX WARN: Code duplicated, block: B:106:0x0135  */
    /* JADX WARN: Code duplicated, block: B:108:0x0139  */
    /* JADX WARN: Code duplicated, block: B:109:0x0140  */
    /* JADX WARN: Code duplicated, block: B:112:0x0145  */
    /* JADX WARN: Code duplicated, block: B:114:0x0148  */
    /* JADX WARN: Code duplicated, block: B:115:0x014f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0153  */
    /* JADX WARN: Code duplicated, block: B:119:0x0156  */
    /* JADX WARN: Code duplicated, block: B:121:0x015a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0161  */
    /* JADX WARN: Code duplicated, block: B:124:0x0165  */
    /* JADX WARN: Code duplicated, block: B:125:0x0167  */
    /* JADX WARN: Code duplicated, block: B:127:0x016b  */
    /* JADX WARN: Code duplicated, block: B:128:0x016d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0175  */
    /* JADX WARN: Code duplicated, block: B:134:0x018e  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01be  */
    /* JADX WARN: Code duplicated, block: B:141:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:143:0x0200  */
    /* JADX WARN: Code duplicated, block: B:145:0x0222  */
    /* JADX WARN: Code duplicated, block: B:147:0x022d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x022f  */
    /* JADX WARN: Code duplicated, block: B:153:0x031b  */
    /* JADX WARN: Code duplicated, block: B:156:0x0327  */
    /* JADX WARN: Code duplicated, block: B:157:0x032b  */
    /* JADX WARN: Code duplicated, block: B:160:0x0351  */
    /* JADX WARN: Code duplicated, block: B:162:0x035f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0376  */
    /* JADX WARN: Code duplicated, block: B:169:0x038b  */
    /* JADX WARN: Code duplicated, block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x0100  */
    /* JADX WARN: Code duplicated, block: B:95:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x0109  */
    public static final void b(final String str, f fVar, e0 e0Var, Function1<? super a0, Unit> function1, int i11, boolean z11, int i12, int i13, z1 z1Var, i iVar, final int i14, final int i15) {
        int i16;
        int i17;
        int i18;
        int i19;
        Function1<? super a0, Unit> function2;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z12;
        int i26;
        int i27;
        int i28;
        int i29;
        int i31;
        int i32;
        int i33;
        f fVar2;
        e0 e0VarA;
        SelectionController selectionController;
        int iA;
        boolean z13;
        int i34;
        int i35;
        z1 z1Var2;
        final j jVar;
        int i36;
        int i37;
        f fVarD;
        int iA2;
        Function0<ComposeUiNode> function0A;
        i iVarA;
        Function2<ComposeUiNode, Integer, Unit> function2B;
        final int i38;
        final e0 e0Var2;
        final int i39;
        final int i40;
        final boolean z14;
        final z1 z1Var3;
        final f fVar3;
        final Function1<? super a0, Unit> function3;
        long jA;
        boolean zA;
        Object objY;
        long jLongValue;
        boolean zD;
        Object objY2;
        g2 g2VarJ;
        i iVarG = iVar.g(-1186827822);
        if ((i15 & 1) != 0) {
            i16 = i14 | 6;
        } else if ((i14 & 6) == 0) {
            i16 = (iVarG.Q(str) ? 4 : 2) | i14;
        } else {
            i16 = i14;
        }
        int i41 = i15 & 2;
        if (i41 == 0) {
            if ((i14 & 48) == 0) {
                i16 |= iVarG.Q(fVar) ? 32 : 16;
            }
            i17 = i15 & 4;
            if (i17 != 0) {
                if ((i14 & 384) == 0) {
                    if (iVarG.Q(e0Var)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i16 |= i18;
                }
                i19 = i15 & 8;
                if (i19 != 0) {
                    if ((i14 & 3072) == 0) {
                        function2 = function1;
                        if (iVarG.A(function2)) {
                            i21 = 2048;
                        } else {
                            i21 = 1024;
                        }
                        i16 |= i21;
                    }
                    i22 = i15 & 16;
                    if (i22 != 0) {
                        if ((i14 & 24576) == 0) {
                            i23 = i11;
                            if (iVarG.c(i23)) {
                                i24 = 16384;
                            } else {
                                i24 = 8192;
                            }
                            i16 |= i24;
                        }
                        i25 = i15 & 32;
                        if (i25 != 0) {
                            if ((196608 & i14) == 0) {
                                z12 = z11;
                                if (iVarG.a(z12)) {
                                    i26 = 131072;
                                } else {
                                    i26 = 65536;
                                }
                                i16 |= i26;
                            }
                            i27 = i15 & 64;
                            if (i27 != 0) {
                                i16 |= 1572864;
                            } else if ((i14 & 1572864) == 0) {
                                if (iVarG.c(i12)) {
                                    i28 = 1048576;
                                } else {
                                    i28 = 524288;
                                }
                                i16 |= i28;
                            }
                            i29 = i15 & 128;
                            if (i29 != 0) {
                                i16 |= 12582912;
                            } else if ((i14 & 12582912) == 0) {
                                if (iVarG.c(i13)) {
                                    i31 = 8388608;
                                } else {
                                    i31 = 4194304;
                                }
                                i16 |= i31;
                            }
                            i32 = i15 & 256;
                            if (i32 != 0) {
                                i16 |= 100663296;
                            } else if ((i14 & 100663296) == 0) {
                                if (iVarG.A(z1Var)) {
                                    i33 = 67108864;
                                } else {
                                    i33 = ASTNode.PCTX_STORED;
                                }
                                i16 |= i33;
                            }
                            if ((i16 & 38347923) == 38347922 || !iVarG.h()) {
                                if (i41 != 0) {
                                    fVar2 = f.f3863a;
                                } else {
                                    fVar2 = fVar;
                                }
                                if (i17 != 0) {
                                    e0VarA = e0.f5774d.a();
                                } else {
                                    e0VarA = e0Var;
                                }
                                selectionController = null;
                                if (i19 != 0) {
                                    function2 = null;
                                }
                                if (i22 != 0) {
                                    iA = p.f6143a.a();
                                } else {
                                    iA = i23;
                                }
                                if (i25 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z12;
                                }
                                if (i27 != 0) {
                                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                                } else {
                                    i34 = i12;
                                }
                                if (i29 != 0) {
                                    i35 = 1;
                                } else {
                                    i35 = i13;
                                }
                                if (i32 != 0) {
                                    z1Var2 = null;
                                } else {
                                    z1Var2 = z1Var;
                                }
                                if (k.J()) {
                                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                                }
                                a.a(i35, i34);
                                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                                if (jVar != null) {
                                    iVarG.R(-1589202404);
                                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                    Object[] objArr = {jVar};
                                    androidx.compose.runtime.saveable.d<Long, Long> dVarC = c(jVar);
                                    zA = iVarG.A(jVar);
                                    objY = iVarG.y();
                                    if (zA || objY == i.f3413a.a()) {
                                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Long invoke() {
                                                return Long.valueOf(jVar.a());
                                            }
                                        };
                                        iVarG.p(objY);
                                    }
                                    jLongValue = ((Number) RememberSaveableKt.c(objArr, dVarC, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                    objY2 = iVarG.y();
                                    if (zD || objY2 == i.f3413a.a()) {
                                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                        iVarG.p(objY2);
                                    }
                                    iVarG.L();
                                    selectionController = (SelectionController) objY2;
                                } else {
                                    iVarG.R(-1588686502);
                                    iVarG.L();
                                }
                                if (selectionController == null || function2 != null) {
                                    i36 = i34;
                                    i37 = 0;
                                    iVarG.R(-1588564052);
                                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                    iVarG.L();
                                } else {
                                    iVarG.R(-1587866335);
                                    i37 = 0;
                                    i36 = i34;
                                    fVarD = d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null).f(new TextStringSimpleElement(str, e0VarA, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), iA, z13, i36, i35, z1Var2, null));
                                    iVarG.L();
                                }
                                EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.f2861a;
                                iA2 = g.a(iVarG, i37);
                                f fVarE = ComposedModifierKt.e(iVarG, fVarD);
                                s sVarN = iVarG.n();
                                ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
                                function0A = companion.a();
                                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                    g.b();
                                }
                                iVarG.D();
                                if (iVarG.e()) {
                                    iVarG.G(function0A);
                                } else {
                                    iVarG.o();
                                }
                                iVarA = f3.a(iVarG);
                                f3.b(iVarA, emptyMeasurePolicy, companion.c());
                                f3.b(iVarA, sVarN, companion.e());
                                f3.b(iVarA, fVarE, companion.d());
                                function2B = companion.b();
                                if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA2))) {
                                    iVarA.p(Integer.valueOf(iA2));
                                    iVarA.k(Integer.valueOf(iA2), function2B);
                                }
                                iVarG.r();
                                if (k.J()) {
                                    k.R();
                                }
                                i38 = i35;
                                e0Var2 = e0VarA;
                                i39 = iA;
                                i40 = i36;
                                z14 = z13;
                                Function1<? super a0, Unit> function4 = function2;
                                z1Var3 = z1Var2;
                                fVar3 = fVar2;
                                function3 = function4;
                            } else {
                                iVarG.H();
                                fVar3 = fVar;
                                e0Var2 = e0Var;
                                i40 = i12;
                                i38 = i13;
                                function3 = function2;
                                i39 = i23;
                                z14 = z12;
                                z1Var3 = z1Var;
                            }
                            g2VarJ = iVarG.j();
                            if (g2VarJ != null) {
                                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                        invoke(iVar2, num.intValue());
                                        return Unit.f68710a;
                                    }

                                    public final void invoke(i iVar2, int i42) {
                                        BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                                    }
                                });
                            }
                        }
                        i16 |= 196608;
                        z12 = z11;
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        i32 = i15 & 256;
                        if (i32 != 0) {
                            i16 |= 100663296;
                        } else if ((i14 & 100663296) == 0) {
                            if (iVarG.A(z1Var)) {
                                i33 = 67108864;
                            } else {
                                i33 = ASTNode.PCTX_STORED;
                            }
                            i16 |= i33;
                        }
                        if ((i16 & 38347923) == 38347922) {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr2 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC2 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr2, dVarC2, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy2 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE2 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN2 = iVarG.n();
                            ComposeUiNode.Companion companion2 = ComposeUiNode.f4919a8;
                            function0A = companion2.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy2, companion2.c());
                            f3.b(iVarA, sVarN2, companion2.e());
                            f3.b(iVarA, fVarE2, companion2.d());
                            function2B = companion2.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function5 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function5;
                        } else {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr3 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC3 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr3, dVarC3, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy3 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE3 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN3 = iVarG.n();
                            ComposeUiNode.Companion companion3 = ComposeUiNode.f4919a8;
                            function0A = companion3.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy3, companion3.c());
                            f3.b(iVarA, sVarN3, companion3.e());
                            f3.b(iVarA, fVarE3, companion3.d());
                            function2B = companion3.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function6 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function6;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i42) {
                                    BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 24576;
                    i23 = i11;
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        i32 = i15 & 256;
                        if (i32 != 0) {
                            i16 |= 100663296;
                        } else if ((i14 & 100663296) == 0) {
                            if (iVarG.A(z1Var)) {
                                i33 = 67108864;
                            } else {
                                i33 = ASTNode.PCTX_STORED;
                            }
                            i16 |= i33;
                        }
                        if ((i16 & 38347923) == 38347922) {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr4 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC4 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr4, dVarC4, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy4 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE4 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN4 = iVarG.n();
                            ComposeUiNode.Companion companion4 = ComposeUiNode.f4919a8;
                            function0A = companion4.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy4, companion4.c());
                            f3.b(iVarA, sVarN4, companion4.e());
                            f3.b(iVarA, fVarE4, companion4.d());
                            function2B = companion4.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function7 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function7;
                        } else {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr5 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC5 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr5, dVarC5, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy5 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE5 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN5 = iVarG.n();
                            ComposeUiNode.Companion companion5 = ComposeUiNode.f4919a8;
                            function0A = companion5.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy5, companion5.c());
                            f3.b(iVarA, sVarN5, companion5.e());
                            f3.b(iVarA, fVarE5, companion5.d());
                            function2B = companion5.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function8 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function8;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i42) {
                                    BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr6 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC6 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr6, dVarC6, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy6 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE6 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN6 = iVarG.n();
                        ComposeUiNode.Companion companion6 = ComposeUiNode.f4919a8;
                        function0A = companion6.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy6, companion6.c());
                        f3.b(iVarA, sVarN6, companion6.e());
                        f3.b(iVarA, fVarE6, companion6.d());
                        function2B = companion6.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function9 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function9;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr7 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC7 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr7, dVarC7, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy7 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE7 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN7 = iVarG.n();
                        ComposeUiNode.Companion companion7 = ComposeUiNode.f4919a8;
                        function0A = companion7.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy7, companion7.c());
                        f3.b(iVarA, sVarN7, companion7.e());
                        f3.b(iVarA, fVarE7, companion7.d());
                        function2B = companion7.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function10 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function10;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 3072;
                function2 = function1;
                i22 = i15 & 16;
                if (i22 != 0) {
                    if ((i14 & 24576) == 0) {
                        i23 = i11;
                        if (iVarG.c(i23)) {
                            i24 = 16384;
                        } else {
                            i24 = 8192;
                        }
                        i16 |= i24;
                    }
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        i32 = i15 & 256;
                        if (i32 != 0) {
                            i16 |= 100663296;
                        } else if ((i14 & 100663296) == 0) {
                            if (iVarG.A(z1Var)) {
                                i33 = 67108864;
                            } else {
                                i33 = ASTNode.PCTX_STORED;
                            }
                            i16 |= i33;
                        }
                        if ((i16 & 38347923) == 38347922) {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr8 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC8 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr8, dVarC8, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy8 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE8 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN8 = iVarG.n();
                            ComposeUiNode.Companion companion8 = ComposeUiNode.f4919a8;
                            function0A = companion8.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy8, companion8.c());
                            f3.b(iVarA, sVarN8, companion8.e());
                            f3.b(iVarA, fVarE8, companion8.d());
                            function2B = companion8.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function11 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function11;
                        } else {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr9 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC9 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr9, dVarC9, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy9 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE9 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN9 = iVarG.n();
                            ComposeUiNode.Companion companion9 = ComposeUiNode.f4919a8;
                            function0A = companion9.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy9, companion9.c());
                            f3.b(iVarA, sVarN9, companion9.e());
                            f3.b(iVarA, fVarE9, companion9.d());
                            function2B = companion9.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function12 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function12;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i42) {
                                    BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr10 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC10 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr10, dVarC10, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy10 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE10 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN10 = iVarG.n();
                        ComposeUiNode.Companion companion10 = ComposeUiNode.f4919a8;
                        function0A = companion10.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy10, companion10.c());
                        f3.b(iVarA, sVarN10, companion10.e());
                        f3.b(iVarA, fVarE10, companion10.d());
                        function2B = companion10.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function13 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function13;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr11 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC11 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr11, dVarC11, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy11 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE11 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN11 = iVarG.n();
                        ComposeUiNode.Companion companion11 = ComposeUiNode.f4919a8;
                        function0A = companion11.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy11, companion11.c());
                        f3.b(iVarA, sVarN11, companion11.e());
                        f3.b(iVarA, fVarE11, companion11.d());
                        function2B = companion11.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function14 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function14;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 24576;
                i23 = i11;
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr12 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC12 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr12, dVarC12, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy12 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE12 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN12 = iVarG.n();
                        ComposeUiNode.Companion companion12 = ComposeUiNode.f4919a8;
                        function0A = companion12.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy12, companion12.c());
                        f3.b(iVarA, sVarN12, companion12.e());
                        f3.b(iVarA, fVarE12, companion12.d());
                        function2B = companion12.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function15 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function15;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr13 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC13 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr13, dVarC13, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy13 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE13 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN13 = iVarG.n();
                        ComposeUiNode.Companion companion13 = ComposeUiNode.f4919a8;
                        function0A = companion13.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy13, companion13.c());
                        f3.b(iVarA, sVarN13, companion13.e());
                        f3.b(iVarA, fVarE13, companion13.d());
                        function2B = companion13.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function16 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function16;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr14 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC14 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr14, dVarC14, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy14 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE14 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN14 = iVarG.n();
                    ComposeUiNode.Companion companion14 = ComposeUiNode.f4919a8;
                    function0A = companion14.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy14, companion14.c());
                    f3.b(iVarA, sVarN14, companion14.e());
                    f3.b(iVarA, fVarE14, companion14.d());
                    function2B = companion14.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function17 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function17;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr15 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC15 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr15, dVarC15, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy15 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE15 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN15 = iVarG.n();
                    ComposeUiNode.Companion companion15 = ComposeUiNode.f4919a8;
                    function0A = companion15.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy15, companion15.c());
                    f3.b(iVarA, sVarN15, companion15.e());
                    f3.b(iVarA, fVarE15, companion15.d());
                    function2B = companion15.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function18 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function18;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 384;
            i19 = i15 & 8;
            if (i19 != 0) {
                if ((i14 & 3072) == 0) {
                    function2 = function1;
                    if (iVarG.A(function2)) {
                        i21 = 2048;
                    } else {
                        i21 = 1024;
                    }
                    i16 |= i21;
                }
                i22 = i15 & 16;
                if (i22 != 0) {
                    if ((i14 & 24576) == 0) {
                        i23 = i11;
                        if (iVarG.c(i23)) {
                            i24 = 16384;
                        } else {
                            i24 = 8192;
                        }
                        i16 |= i24;
                    }
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        i32 = i15 & 256;
                        if (i32 != 0) {
                            i16 |= 100663296;
                        } else if ((i14 & 100663296) == 0) {
                            if (iVarG.A(z1Var)) {
                                i33 = 67108864;
                            } else {
                                i33 = ASTNode.PCTX_STORED;
                            }
                            i16 |= i33;
                        }
                        if ((i16 & 38347923) == 38347922) {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr16 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC16 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr16, dVarC16, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy16 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE16 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN16 = iVarG.n();
                            ComposeUiNode.Companion companion16 = ComposeUiNode.f4919a8;
                            function0A = companion16.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy16, companion16.c());
                            f3.b(iVarA, sVarN16, companion16.e());
                            f3.b(iVarA, fVarE16, companion16.d());
                            function2B = companion16.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function19 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function19;
                        } else {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr17 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC17 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr17, dVarC17, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy17 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE17 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN17 = iVarG.n();
                            ComposeUiNode.Companion companion17 = ComposeUiNode.f4919a8;
                            function0A = companion17.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy17, companion17.c());
                            f3.b(iVarA, sVarN17, companion17.e());
                            f3.b(iVarA, fVarE17, companion17.d());
                            function2B = companion17.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function110 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function110;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i42) {
                                    BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr18 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC18 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr18, dVarC18, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy18 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE18 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN18 = iVarG.n();
                        ComposeUiNode.Companion companion18 = ComposeUiNode.f4919a8;
                        function0A = companion18.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy18, companion18.c());
                        f3.b(iVarA, sVarN18, companion18.e());
                        f3.b(iVarA, fVarE18, companion18.d());
                        function2B = companion18.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function111 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function111;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr19 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC19 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr19, dVarC19, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy19 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE19 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN19 = iVarG.n();
                        ComposeUiNode.Companion companion19 = ComposeUiNode.f4919a8;
                        function0A = companion19.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy19, companion19.c());
                        f3.b(iVarA, sVarN19, companion19.e());
                        f3.b(iVarA, fVarE19, companion19.d());
                        function2B = companion19.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function112 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function112;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 24576;
                i23 = i11;
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr110 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC110 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr110, dVarC110, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy110 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE110 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN110 = iVarG.n();
                        ComposeUiNode.Companion companion110 = ComposeUiNode.f4919a8;
                        function0A = companion110.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy110, companion110.c());
                        f3.b(iVarA, sVarN110, companion110.e());
                        f3.b(iVarA, fVarE110, companion110.d());
                        function2B = companion110.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function113 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function113;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr111 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC111 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr111, dVarC111, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy111 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE111 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN111 = iVarG.n();
                        ComposeUiNode.Companion companion111 = ComposeUiNode.f4919a8;
                        function0A = companion111.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy111, companion111.c());
                        f3.b(iVarA, sVarN111, companion111.e());
                        f3.b(iVarA, fVarE111, companion111.d());
                        function2B = companion111.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function114 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function114;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr112 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC112 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr112, dVarC112, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy112 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE112 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN112 = iVarG.n();
                    ComposeUiNode.Companion companion112 = ComposeUiNode.f4919a8;
                    function0A = companion112.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy112, companion112.c());
                    f3.b(iVarA, sVarN112, companion112.e());
                    f3.b(iVarA, fVarE112, companion112.d());
                    function2B = companion112.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function115 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function115;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr113 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC113 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr113, dVarC113, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy113 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE113 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN113 = iVarG.n();
                    ComposeUiNode.Companion companion113 = ComposeUiNode.f4919a8;
                    function0A = companion113.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy113, companion113.c());
                    f3.b(iVarA, sVarN113, companion113.e());
                    f3.b(iVarA, fVarE113, companion113.d());
                    function2B = companion113.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function116 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function116;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 3072;
            function2 = function1;
            i22 = i15 & 16;
            if (i22 != 0) {
                if ((i14 & 24576) == 0) {
                    i23 = i11;
                    if (iVarG.c(i23)) {
                        i24 = 16384;
                    } else {
                        i24 = 8192;
                    }
                    i16 |= i24;
                }
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr114 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC114 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr114, dVarC114, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy114 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE114 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN114 = iVarG.n();
                        ComposeUiNode.Companion companion114 = ComposeUiNode.f4919a8;
                        function0A = companion114.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy114, companion114.c());
                        f3.b(iVarA, sVarN114, companion114.e());
                        f3.b(iVarA, fVarE114, companion114.d());
                        function2B = companion114.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function117 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function117;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr115 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC115 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr115, dVarC115, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy115 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE115 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN115 = iVarG.n();
                        ComposeUiNode.Companion companion115 = ComposeUiNode.f4919a8;
                        function0A = companion115.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy115, companion115.c());
                        f3.b(iVarA, sVarN115, companion115.e());
                        f3.b(iVarA, fVarE115, companion115.d());
                        function2B = companion115.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function118 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function118;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr116 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC116 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr116, dVarC116, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy116 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE116 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN116 = iVarG.n();
                    ComposeUiNode.Companion companion116 = ComposeUiNode.f4919a8;
                    function0A = companion116.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy116, companion116.c());
                    f3.b(iVarA, sVarN116, companion116.e());
                    f3.b(iVarA, fVarE116, companion116.d());
                    function2B = companion116.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function119 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function119;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr117 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC117 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr117, dVarC117, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy117 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE117 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN117 = iVarG.n();
                    ComposeUiNode.Companion companion117 = ComposeUiNode.f4919a8;
                    function0A = companion117.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy117, companion117.c());
                    f3.b(iVarA, sVarN117, companion117.e());
                    f3.b(iVarA, fVarE117, companion117.d());
                    function2B = companion117.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function1110 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function1110;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 24576;
            i23 = i11;
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr118 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC118 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr118, dVarC118, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy118 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE118 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN118 = iVarG.n();
                    ComposeUiNode.Companion companion118 = ComposeUiNode.f4919a8;
                    function0A = companion118.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy118, companion118.c());
                    f3.b(iVarA, sVarN118, companion118.e());
                    f3.b(iVarA, fVarE118, companion118.d());
                    function2B = companion118.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function1111 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function1111;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr119 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC119 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr119, dVarC119, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy119 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE119 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN119 = iVarG.n();
                    ComposeUiNode.Companion companion119 = ComposeUiNode.f4919a8;
                    function0A = companion119.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy119, companion119.c());
                    f3.b(iVarA, sVarN119, companion119.e());
                    f3.b(iVarA, fVarE119, companion119.d());
                    function2B = companion119.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function1112 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function1112;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            i32 = i15 & 256;
            if (i32 != 0) {
                i16 |= 100663296;
            } else if ((i14 & 100663296) == 0) {
                if (iVarG.A(z1Var)) {
                    i33 = 67108864;
                } else {
                    i33 = ASTNode.PCTX_STORED;
                }
                i16 |= i33;
            }
            if ((i16 & 38347923) == 38347922) {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr1110 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC1110 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr1110, dVarC1110, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy1110 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE1110 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN1110 = iVarG.n();
                ComposeUiNode.Companion companion1110 = ComposeUiNode.f4919a8;
                function0A = companion1110.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy1110, companion1110.c());
                f3.b(iVarA, sVarN1110, companion1110.e());
                f3.b(iVarA, fVarE1110, companion1110.d());
                function2B = companion1110.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function1113 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function1113;
            } else {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr1111 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC1111 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr1111, dVarC1111, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy1111 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE1111 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN1111 = iVarG.n();
                ComposeUiNode.Companion companion1111 = ComposeUiNode.f4919a8;
                function0A = companion1111.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy1111, companion1111.c());
                f3.b(iVarA, sVarN1111, companion1111.e());
                f3.b(iVarA, fVarE1111, companion1111.d());
                function2B = companion1111.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function1114 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function1114;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i42) {
                        BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 48;
        i17 = i15 & 4;
        if (i17 != 0) {
            if ((i14 & 384) == 0) {
                if (iVarG.Q(e0Var)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i16 |= i18;
            }
            i19 = i15 & 8;
            if (i19 != 0) {
                if ((i14 & 3072) == 0) {
                    function2 = function1;
                    if (iVarG.A(function2)) {
                        i21 = 2048;
                    } else {
                        i21 = 1024;
                    }
                    i16 |= i21;
                }
                i22 = i15 & 16;
                if (i22 != 0) {
                    if ((i14 & 24576) == 0) {
                        i23 = i11;
                        if (iVarG.c(i23)) {
                            i24 = 16384;
                        } else {
                            i24 = 8192;
                        }
                        i16 |= i24;
                    }
                    i25 = i15 & 32;
                    if (i25 != 0) {
                        if ((196608 & i14) == 0) {
                            z12 = z11;
                            if (iVarG.a(z12)) {
                                i26 = 131072;
                            } else {
                                i26 = 65536;
                            }
                            i16 |= i26;
                        }
                        i27 = i15 & 64;
                        if (i27 != 0) {
                            i16 |= 1572864;
                        } else if ((i14 & 1572864) == 0) {
                            if (iVarG.c(i12)) {
                                i28 = 1048576;
                            } else {
                                i28 = 524288;
                            }
                            i16 |= i28;
                        }
                        i29 = i15 & 128;
                        if (i29 != 0) {
                            i16 |= 12582912;
                        } else if ((i14 & 12582912) == 0) {
                            if (iVarG.c(i13)) {
                                i31 = 8388608;
                            } else {
                                i31 = 4194304;
                            }
                            i16 |= i31;
                        }
                        i32 = i15 & 256;
                        if (i32 != 0) {
                            i16 |= 100663296;
                        } else if ((i14 & 100663296) == 0) {
                            if (iVarG.A(z1Var)) {
                                i33 = 67108864;
                            } else {
                                i33 = ASTNode.PCTX_STORED;
                            }
                            i16 |= i33;
                        }
                        if ((i16 & 38347923) == 38347922) {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr1112 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC1112 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr1112, dVarC1112, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy1112 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE1112 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN1112 = iVarG.n();
                            ComposeUiNode.Companion companion1112 = ComposeUiNode.f4919a8;
                            function0A = companion1112.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy1112, companion1112.c());
                            f3.b(iVarA, sVarN1112, companion1112.e());
                            f3.b(iVarA, fVarE1112, companion1112.d());
                            function2B = companion1112.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function1115 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function1115;
                        } else {
                            if (i41 != 0) {
                                fVar2 = f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i17 != 0) {
                                e0VarA = e0.f5774d.a();
                            } else {
                                e0VarA = e0Var;
                            }
                            selectionController = null;
                            if (i19 != 0) {
                                function2 = null;
                            }
                            if (i22 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i23;
                            }
                            if (i25 != 0) {
                                z13 = true;
                            } else {
                                z13 = z12;
                            }
                            if (i27 != 0) {
                                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i34 = i12;
                            }
                            if (i29 != 0) {
                                i35 = 1;
                            } else {
                                i35 = i13;
                            }
                            if (i32 != 0) {
                                z1Var2 = null;
                            } else {
                                z1Var2 = z1Var;
                            }
                            if (k.J()) {
                                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                            }
                            a.a(i35, i34);
                            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                            if (jVar != null) {
                                iVarG.R(-1589202404);
                                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                                Object[] objArr1113 = {jVar};
                                androidx.compose.runtime.saveable.d<Long, Long> dVarC1113 = c(jVar);
                                zA = iVarG.A(jVar);
                                objY = iVarG.y();
                                if (zA) {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                } else {
                                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Long invoke() {
                                            return Long.valueOf(jVar.a());
                                        }
                                    };
                                    iVarG.p(objY);
                                }
                                jLongValue = ((Number) RememberSaveableKt.c(objArr1113, dVarC1113, null, (Function0) objY, iVarG, 0, 4)).longValue();
                                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                                objY2 = iVarG.y();
                                if (zD) {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                } else {
                                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                    iVarG.p(objY2);
                                }
                                iVarG.L();
                                selectionController = (SelectionController) objY2;
                            } else {
                                iVarG.R(-1588686502);
                                iVarG.L();
                            }
                            if (selectionController == null) {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            } else {
                                i36 = i34;
                                i37 = 0;
                                iVarG.R(-1588564052);
                                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                                iVarG.L();
                            }
                            EmptyMeasurePolicy emptyMeasurePolicy1113 = EmptyMeasurePolicy.f2861a;
                            iA2 = g.a(iVarG, i37);
                            f fVarE1113 = ComposedModifierKt.e(iVarG, fVarD);
                            s sVarN1113 = iVarG.n();
                            ComposeUiNode.Companion companion1113 = ComposeUiNode.f4919a8;
                            function0A = companion1113.a();
                            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                                g.b();
                            }
                            iVarG.D();
                            if (iVarG.e()) {
                                iVarG.G(function0A);
                            } else {
                                iVarG.o();
                            }
                            iVarA = f3.a(iVarG);
                            f3.b(iVarA, emptyMeasurePolicy1113, companion1113.c());
                            f3.b(iVarA, sVarN1113, companion1113.e());
                            f3.b(iVarA, fVarE1113, companion1113.d());
                            function2B = companion1113.b();
                            if (iVarA.e()) {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            } else {
                                iVarA.p(Integer.valueOf(iA2));
                                iVarA.k(Integer.valueOf(iA2), function2B);
                            }
                            iVarG.r();
                            if (k.J()) {
                                k.R();
                            }
                            i38 = i35;
                            e0Var2 = e0VarA;
                            i39 = iA;
                            i40 = i36;
                            z14 = z13;
                            Function1<? super a0, Unit> function1116 = function2;
                            z1Var3 = z1Var2;
                            fVar3 = fVar2;
                            function3 = function1116;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ != null) {
                            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(i iVar2, int i42) {
                                    BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                                }
                            });
                        }
                    }
                    i16 |= 196608;
                    z12 = z11;
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr1114 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC1114 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr1114, dVarC1114, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy1114 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE1114 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN1114 = iVarG.n();
                        ComposeUiNode.Companion companion1114 = ComposeUiNode.f4919a8;
                        function0A = companion1114.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy1114, companion1114.c());
                        f3.b(iVarA, sVarN1114, companion1114.e());
                        f3.b(iVarA, fVarE1114, companion1114.d());
                        function2B = companion1114.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function1117 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function1117;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr1115 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC1115 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr1115, dVarC1115, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy1115 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE1115 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN1115 = iVarG.n();
                        ComposeUiNode.Companion companion1115 = ComposeUiNode.f4919a8;
                        function0A = companion1115.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy1115, companion1115.c());
                        f3.b(iVarA, sVarN1115, companion1115.e());
                        f3.b(iVarA, fVarE1115, companion1115.d());
                        function2B = companion1115.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function1118 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function1118;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 24576;
                i23 = i11;
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr1116 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC1116 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr1116, dVarC1116, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy1116 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE1116 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN1116 = iVarG.n();
                        ComposeUiNode.Companion companion1116 = ComposeUiNode.f4919a8;
                        function0A = companion1116.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy1116, companion1116.c());
                        f3.b(iVarA, sVarN1116, companion1116.e());
                        f3.b(iVarA, fVarE1116, companion1116.d());
                        function2B = companion1116.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function1119 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function1119;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr1117 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC1117 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr1117, dVarC1117, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy1117 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE1117 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN1117 = iVarG.n();
                        ComposeUiNode.Companion companion1117 = ComposeUiNode.f4919a8;
                        function0A = companion1117.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy1117, companion1117.c());
                        f3.b(iVarA, sVarN1117, companion1117.e());
                        f3.b(iVarA, fVarE1117, companion1117.d());
                        function2B = companion1117.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function11110 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function11110;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr1118 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC1118 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr1118, dVarC1118, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy1118 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE1118 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN1118 = iVarG.n();
                    ComposeUiNode.Companion companion1118 = ComposeUiNode.f4919a8;
                    function0A = companion1118.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy1118, companion1118.c());
                    f3.b(iVarA, sVarN1118, companion1118.e());
                    f3.b(iVarA, fVarE1118, companion1118.d());
                    function2B = companion1118.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function11111 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function11111;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr1119 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC1119 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr1119, dVarC1119, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy1119 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE1119 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN1119 = iVarG.n();
                    ComposeUiNode.Companion companion1119 = ComposeUiNode.f4919a8;
                    function0A = companion1119.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy1119, companion1119.c());
                    f3.b(iVarA, sVarN1119, companion1119.e());
                    f3.b(iVarA, fVarE1119, companion1119.d());
                    function2B = companion1119.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function11112 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function11112;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 3072;
            function2 = function1;
            i22 = i15 & 16;
            if (i22 != 0) {
                if ((i14 & 24576) == 0) {
                    i23 = i11;
                    if (iVarG.c(i23)) {
                        i24 = 16384;
                    } else {
                        i24 = 8192;
                    }
                    i16 |= i24;
                }
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr11110 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC11110 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr11110, dVarC11110, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy11110 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE11110 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN11110 = iVarG.n();
                        ComposeUiNode.Companion companion11110 = ComposeUiNode.f4919a8;
                        function0A = companion11110.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy11110, companion11110.c());
                        f3.b(iVarA, sVarN11110, companion11110.e());
                        f3.b(iVarA, fVarE11110, companion11110.d());
                        function2B = companion11110.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function11113 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function11113;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr11111 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC11111 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr11111, dVarC11111, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy11111 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE11111 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN11111 = iVarG.n();
                        ComposeUiNode.Companion companion11111 = ComposeUiNode.f4919a8;
                        function0A = companion11111.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy11111, companion11111.c());
                        f3.b(iVarA, sVarN11111, companion11111.e());
                        f3.b(iVarA, fVarE11111, companion11111.d());
                        function2B = companion11111.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function11114 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function11114;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr11112 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC11112 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr11112, dVarC11112, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy11112 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE11112 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN11112 = iVarG.n();
                    ComposeUiNode.Companion companion11112 = ComposeUiNode.f4919a8;
                    function0A = companion11112.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy11112, companion11112.c());
                    f3.b(iVarA, sVarN11112, companion11112.e());
                    f3.b(iVarA, fVarE11112, companion11112.d());
                    function2B = companion11112.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function11115 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function11115;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr11113 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC11113 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr11113, dVarC11113, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy11113 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE11113 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN11113 = iVarG.n();
                    ComposeUiNode.Companion companion11113 = ComposeUiNode.f4919a8;
                    function0A = companion11113.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy11113, companion11113.c());
                    f3.b(iVarA, sVarN11113, companion11113.e());
                    f3.b(iVarA, fVarE11113, companion11113.d());
                    function2B = companion11113.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function11116 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function11116;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 24576;
            i23 = i11;
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr11114 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC11114 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr11114, dVarC11114, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy11114 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE11114 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN11114 = iVarG.n();
                    ComposeUiNode.Companion companion11114 = ComposeUiNode.f4919a8;
                    function0A = companion11114.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy11114, companion11114.c());
                    f3.b(iVarA, sVarN11114, companion11114.e());
                    f3.b(iVarA, fVarE11114, companion11114.d());
                    function2B = companion11114.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function11117 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function11117;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr11115 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC11115 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr11115, dVarC11115, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy11115 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE11115 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN11115 = iVarG.n();
                    ComposeUiNode.Companion companion11115 = ComposeUiNode.f4919a8;
                    function0A = companion11115.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy11115, companion11115.c());
                    f3.b(iVarA, sVarN11115, companion11115.e());
                    f3.b(iVarA, fVarE11115, companion11115.d());
                    function2B = companion11115.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function11118 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function11118;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            i32 = i15 & 256;
            if (i32 != 0) {
                i16 |= 100663296;
            } else if ((i14 & 100663296) == 0) {
                if (iVarG.A(z1Var)) {
                    i33 = 67108864;
                } else {
                    i33 = ASTNode.PCTX_STORED;
                }
                i16 |= i33;
            }
            if ((i16 & 38347923) == 38347922) {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr11116 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC11116 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr11116, dVarC11116, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy11116 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE11116 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN11116 = iVarG.n();
                ComposeUiNode.Companion companion11116 = ComposeUiNode.f4919a8;
                function0A = companion11116.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy11116, companion11116.c());
                f3.b(iVarA, sVarN11116, companion11116.e());
                f3.b(iVarA, fVarE11116, companion11116.d());
                function2B = companion11116.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function11119 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function11119;
            } else {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr11117 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC11117 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr11117, dVarC11117, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy11117 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE11117 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN11117 = iVarG.n();
                ComposeUiNode.Companion companion11117 = ComposeUiNode.f4919a8;
                function0A = companion11117.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy11117, companion11117.c());
                f3.b(iVarA, sVarN11117, companion11117.e());
                f3.b(iVarA, fVarE11117, companion11117.d());
                function2B = companion11117.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function111110 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function111110;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i42) {
                        BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 384;
        i19 = i15 & 8;
        if (i19 != 0) {
            if ((i14 & 3072) == 0) {
                function2 = function1;
                if (iVarG.A(function2)) {
                    i21 = 2048;
                } else {
                    i21 = 1024;
                }
                i16 |= i21;
            }
            i22 = i15 & 16;
            if (i22 != 0) {
                if ((i14 & 24576) == 0) {
                    i23 = i11;
                    if (iVarG.c(i23)) {
                        i24 = 16384;
                    } else {
                        i24 = 8192;
                    }
                    i16 |= i24;
                }
                i25 = i15 & 32;
                if (i25 != 0) {
                    if ((196608 & i14) == 0) {
                        z12 = z11;
                        if (iVarG.a(z12)) {
                            i26 = 131072;
                        } else {
                            i26 = 65536;
                        }
                        i16 |= i26;
                    }
                    i27 = i15 & 64;
                    if (i27 != 0) {
                        i16 |= 1572864;
                    } else if ((i14 & 1572864) == 0) {
                        if (iVarG.c(i12)) {
                            i28 = 1048576;
                        } else {
                            i28 = 524288;
                        }
                        i16 |= i28;
                    }
                    i29 = i15 & 128;
                    if (i29 != 0) {
                        i16 |= 12582912;
                    } else if ((i14 & 12582912) == 0) {
                        if (iVarG.c(i13)) {
                            i31 = 8388608;
                        } else {
                            i31 = 4194304;
                        }
                        i16 |= i31;
                    }
                    i32 = i15 & 256;
                    if (i32 != 0) {
                        i16 |= 100663296;
                    } else if ((i14 & 100663296) == 0) {
                        if (iVarG.A(z1Var)) {
                            i33 = 67108864;
                        } else {
                            i33 = ASTNode.PCTX_STORED;
                        }
                        i16 |= i33;
                    }
                    if ((i16 & 38347923) == 38347922) {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr11118 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC11118 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr11118, dVarC11118, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy11118 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE11118 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN11118 = iVarG.n();
                        ComposeUiNode.Companion companion11118 = ComposeUiNode.f4919a8;
                        function0A = companion11118.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy11118, companion11118.c());
                        f3.b(iVarA, sVarN11118, companion11118.e());
                        f3.b(iVarA, fVarE11118, companion11118.d());
                        function2B = companion11118.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function111111 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function111111;
                    } else {
                        if (i41 != 0) {
                            fVar2 = f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i17 != 0) {
                            e0VarA = e0.f5774d.a();
                        } else {
                            e0VarA = e0Var;
                        }
                        selectionController = null;
                        if (i19 != 0) {
                            function2 = null;
                        }
                        if (i22 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i23;
                        }
                        if (i25 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if (i27 != 0) {
                            i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i34 = i12;
                        }
                        if (i29 != 0) {
                            i35 = 1;
                        } else {
                            i35 = i13;
                        }
                        if (i32 != 0) {
                            z1Var2 = null;
                        } else {
                            z1Var2 = z1Var;
                        }
                        if (k.J()) {
                            k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                        }
                        a.a(i35, i34);
                        jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                        if (jVar != null) {
                            iVarG.R(-1589202404);
                            jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                            Object[] objArr11119 = {jVar};
                            androidx.compose.runtime.saveable.d<Long, Long> dVarC11119 = c(jVar);
                            zA = iVarG.A(jVar);
                            objY = iVarG.y();
                            if (zA) {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            } else {
                                objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Long invoke() {
                                        return Long.valueOf(jVar.a());
                                    }
                                };
                                iVarG.p(objY);
                            }
                            jLongValue = ((Number) RememberSaveableKt.c(objArr11119, dVarC11119, null, (Function0) objY, iVarG, 0, 4)).longValue();
                            zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                            objY2 = iVarG.y();
                            if (zD) {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            } else {
                                objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                                iVarG.p(objY2);
                            }
                            iVarG.L();
                            selectionController = (SelectionController) objY2;
                        } else {
                            iVarG.R(-1588686502);
                            iVarG.L();
                        }
                        if (selectionController == null) {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        } else {
                            i36 = i34;
                            i37 = 0;
                            iVarG.R(-1588564052);
                            fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                            iVarG.L();
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy11119 = EmptyMeasurePolicy.f2861a;
                        iA2 = g.a(iVarG, i37);
                        f fVarE11119 = ComposedModifierKt.e(iVarG, fVarD);
                        s sVarN11119 = iVarG.n();
                        ComposeUiNode.Companion companion11119 = ComposeUiNode.f4919a8;
                        function0A = companion11119.a();
                        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                            g.b();
                        }
                        iVarG.D();
                        if (iVarG.e()) {
                            iVarG.G(function0A);
                        } else {
                            iVarG.o();
                        }
                        iVarA = f3.a(iVarG);
                        f3.b(iVarA, emptyMeasurePolicy11119, companion11119.c());
                        f3.b(iVarA, sVarN11119, companion11119.e());
                        f3.b(iVarA, fVarE11119, companion11119.d());
                        function2B = companion11119.b();
                        if (iVarA.e()) {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        } else {
                            iVarA.p(Integer.valueOf(iA2));
                            iVarA.k(Integer.valueOf(iA2), function2B);
                        }
                        iVarG.r();
                        if (k.J()) {
                            k.R();
                        }
                        i38 = i35;
                        e0Var2 = e0VarA;
                        i39 = iA;
                        i40 = i36;
                        z14 = z13;
                        Function1<? super a0, Unit> function111112 = function2;
                        z1Var3 = z1Var2;
                        fVar3 = fVar2;
                        function3 = function111112;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ != null) {
                        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                                invoke(iVar2, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(i iVar2, int i42) {
                                BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                            }
                        });
                    }
                }
                i16 |= 196608;
                z12 = z11;
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr111110 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC111110 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr111110, dVarC111110, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy111110 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE111110 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN111110 = iVarG.n();
                    ComposeUiNode.Companion companion111110 = ComposeUiNode.f4919a8;
                    function0A = companion111110.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy111110, companion111110.c());
                    f3.b(iVarA, sVarN111110, companion111110.e());
                    f3.b(iVarA, fVarE111110, companion111110.d());
                    function2B = companion111110.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function111113 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function111113;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr111111 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC111111 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr111111, dVarC111111, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy111111 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE111111 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN111111 = iVarG.n();
                    ComposeUiNode.Companion companion111111 = ComposeUiNode.f4919a8;
                    function0A = companion111111.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy111111, companion111111.c());
                    f3.b(iVarA, sVarN111111, companion111111.e());
                    f3.b(iVarA, fVarE111111, companion111111.d());
                    function2B = companion111111.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function111114 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function111114;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 24576;
            i23 = i11;
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr111112 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC111112 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr111112, dVarC111112, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy111112 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE111112 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN111112 = iVarG.n();
                    ComposeUiNode.Companion companion111112 = ComposeUiNode.f4919a8;
                    function0A = companion111112.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy111112, companion111112.c());
                    f3.b(iVarA, sVarN111112, companion111112.e());
                    f3.b(iVarA, fVarE111112, companion111112.d());
                    function2B = companion111112.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function111115 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function111115;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr111113 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC111113 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr111113, dVarC111113, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy111113 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE111113 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN111113 = iVarG.n();
                    ComposeUiNode.Companion companion111113 = ComposeUiNode.f4919a8;
                    function0A = companion111113.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy111113, companion111113.c());
                    f3.b(iVarA, sVarN111113, companion111113.e());
                    f3.b(iVarA, fVarE111113, companion111113.d());
                    function2B = companion111113.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function111116 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function111116;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            i32 = i15 & 256;
            if (i32 != 0) {
                i16 |= 100663296;
            } else if ((i14 & 100663296) == 0) {
                if (iVarG.A(z1Var)) {
                    i33 = 67108864;
                } else {
                    i33 = ASTNode.PCTX_STORED;
                }
                i16 |= i33;
            }
            if ((i16 & 38347923) == 38347922) {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr111114 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC111114 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr111114, dVarC111114, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy111114 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE111114 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN111114 = iVarG.n();
                ComposeUiNode.Companion companion111114 = ComposeUiNode.f4919a8;
                function0A = companion111114.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy111114, companion111114.c());
                f3.b(iVarA, sVarN111114, companion111114.e());
                f3.b(iVarA, fVarE111114, companion111114.d());
                function2B = companion111114.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function111117 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function111117;
            } else {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr111115 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC111115 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr111115, dVarC111115, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy111115 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE111115 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN111115 = iVarG.n();
                ComposeUiNode.Companion companion111115 = ComposeUiNode.f4919a8;
                function0A = companion111115.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy111115, companion111115.c());
                f3.b(iVarA, sVarN111115, companion111115.e());
                f3.b(iVarA, fVarE111115, companion111115.d());
                function2B = companion111115.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function111118 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function111118;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i42) {
                        BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 3072;
        function2 = function1;
        i22 = i15 & 16;
        if (i22 != 0) {
            if ((i14 & 24576) == 0) {
                i23 = i11;
                if (iVarG.c(i23)) {
                    i24 = 16384;
                } else {
                    i24 = 8192;
                }
                i16 |= i24;
            }
            i25 = i15 & 32;
            if (i25 != 0) {
                if ((196608 & i14) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i16 |= i26;
                }
                i27 = i15 & 64;
                if (i27 != 0) {
                    i16 |= 1572864;
                } else if ((i14 & 1572864) == 0) {
                    if (iVarG.c(i12)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i16 |= i28;
                }
                i29 = i15 & 128;
                if (i29 != 0) {
                    i16 |= 12582912;
                } else if ((i14 & 12582912) == 0) {
                    if (iVarG.c(i13)) {
                        i31 = 8388608;
                    } else {
                        i31 = 4194304;
                    }
                    i16 |= i31;
                }
                i32 = i15 & 256;
                if (i32 != 0) {
                    i16 |= 100663296;
                } else if ((i14 & 100663296) == 0) {
                    if (iVarG.A(z1Var)) {
                        i33 = 67108864;
                    } else {
                        i33 = ASTNode.PCTX_STORED;
                    }
                    i16 |= i33;
                }
                if ((i16 & 38347923) == 38347922) {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr111116 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC111116 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr111116, dVarC111116, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy111116 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE111116 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN111116 = iVarG.n();
                    ComposeUiNode.Companion companion111116 = ComposeUiNode.f4919a8;
                    function0A = companion111116.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy111116, companion111116.c());
                    f3.b(iVarA, sVarN111116, companion111116.e());
                    f3.b(iVarA, fVarE111116, companion111116.d());
                    function2B = companion111116.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function111119 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function111119;
                } else {
                    if (i41 != 0) {
                        fVar2 = f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i17 != 0) {
                        e0VarA = e0.f5774d.a();
                    } else {
                        e0VarA = e0Var;
                    }
                    selectionController = null;
                    if (i19 != 0) {
                        function2 = null;
                    }
                    if (i22 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i23;
                    }
                    if (i25 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if (i27 != 0) {
                        i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i34 = i12;
                    }
                    if (i29 != 0) {
                        i35 = 1;
                    } else {
                        i35 = i13;
                    }
                    if (i32 != 0) {
                        z1Var2 = null;
                    } else {
                        z1Var2 = z1Var;
                    }
                    if (k.J()) {
                        k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                    }
                    a.a(i35, i34);
                    jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                    if (jVar != null) {
                        iVarG.R(-1589202404);
                        jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                        Object[] objArr111117 = {jVar};
                        androidx.compose.runtime.saveable.d<Long, Long> dVarC111117 = c(jVar);
                        zA = iVarG.A(jVar);
                        objY = iVarG.y();
                        if (zA) {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        } else {
                            objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(jVar.a());
                                }
                            };
                            iVarG.p(objY);
                        }
                        jLongValue = ((Number) RememberSaveableKt.c(objArr111117, dVarC111117, null, (Function0) objY, iVarG, 0, 4)).longValue();
                        zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                        objY2 = iVarG.y();
                        if (zD) {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        } else {
                            objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                            iVarG.p(objY2);
                        }
                        iVarG.L();
                        selectionController = (SelectionController) objY2;
                    } else {
                        iVarG.R(-1588686502);
                        iVarG.L();
                    }
                    if (selectionController == null) {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    } else {
                        i36 = i34;
                        i37 = 0;
                        iVarG.R(-1588564052);
                        fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                        iVarG.L();
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy111117 = EmptyMeasurePolicy.f2861a;
                    iA2 = g.a(iVarG, i37);
                    f fVarE111117 = ComposedModifierKt.e(iVarG, fVarD);
                    s sVarN111117 = iVarG.n();
                    ComposeUiNode.Companion companion111117 = ComposeUiNode.f4919a8;
                    function0A = companion111117.a();
                    if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    iVarG.D();
                    if (iVarG.e()) {
                        iVarG.G(function0A);
                    } else {
                        iVarG.o();
                    }
                    iVarA = f3.a(iVarG);
                    f3.b(iVarA, emptyMeasurePolicy111117, companion111117.c());
                    f3.b(iVarA, sVarN111117, companion111117.e());
                    f3.b(iVarA, fVarE111117, companion111117.d());
                    function2B = companion111117.b();
                    if (iVarA.e()) {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    } else {
                        iVarA.p(Integer.valueOf(iA2));
                        iVarA.k(Integer.valueOf(iA2), function2B);
                    }
                    iVarG.r();
                    if (k.J()) {
                        k.R();
                    }
                    i38 = i35;
                    e0Var2 = e0VarA;
                    i39 = iA;
                    i40 = i36;
                    z14 = z13;
                    Function1<? super a0, Unit> function1111110 = function2;
                    z1Var3 = z1Var2;
                    fVar3 = fVar2;
                    function3 = function1111110;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                            invoke(iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(i iVar2, int i42) {
                            BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                        }
                    });
                }
            }
            i16 |= 196608;
            z12 = z11;
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            i32 = i15 & 256;
            if (i32 != 0) {
                i16 |= 100663296;
            } else if ((i14 & 100663296) == 0) {
                if (iVarG.A(z1Var)) {
                    i33 = 67108864;
                } else {
                    i33 = ASTNode.PCTX_STORED;
                }
                i16 |= i33;
            }
            if ((i16 & 38347923) == 38347922) {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr111118 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC111118 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr111118, dVarC111118, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy111118 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE111118 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN111118 = iVarG.n();
                ComposeUiNode.Companion companion111118 = ComposeUiNode.f4919a8;
                function0A = companion111118.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy111118, companion111118.c());
                f3.b(iVarA, sVarN111118, companion111118.e());
                f3.b(iVarA, fVarE111118, companion111118.d());
                function2B = companion111118.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function1111111 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function1111111;
            } else {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr111119 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC111119 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr111119, dVarC111119, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy111119 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE111119 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN111119 = iVarG.n();
                ComposeUiNode.Companion companion111119 = ComposeUiNode.f4919a8;
                function0A = companion111119.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy111119, companion111119.c());
                f3.b(iVarA, sVarN111119, companion111119.e());
                f3.b(iVarA, fVarE111119, companion111119.d());
                function2B = companion111119.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function1111112 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function1111112;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i42) {
                        BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 24576;
        i23 = i11;
        i25 = i15 & 32;
        if (i25 != 0) {
            if ((196608 & i14) == 0) {
                z12 = z11;
                if (iVarG.a(z12)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i16 |= i26;
            }
            i27 = i15 & 64;
            if (i27 != 0) {
                i16 |= 1572864;
            } else if ((i14 & 1572864) == 0) {
                if (iVarG.c(i12)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i16 |= i28;
            }
            i29 = i15 & 128;
            if (i29 != 0) {
                i16 |= 12582912;
            } else if ((i14 & 12582912) == 0) {
                if (iVarG.c(i13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i16 |= i31;
            }
            i32 = i15 & 256;
            if (i32 != 0) {
                i16 |= 100663296;
            } else if ((i14 & 100663296) == 0) {
                if (iVarG.A(z1Var)) {
                    i33 = 67108864;
                } else {
                    i33 = ASTNode.PCTX_STORED;
                }
                i16 |= i33;
            }
            if ((i16 & 38347923) == 38347922) {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr1111110 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC1111110 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr1111110, dVarC1111110, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy1111110 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE1111110 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN1111110 = iVarG.n();
                ComposeUiNode.Companion companion1111110 = ComposeUiNode.f4919a8;
                function0A = companion1111110.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy1111110, companion1111110.c());
                f3.b(iVarA, sVarN1111110, companion1111110.e());
                f3.b(iVarA, fVarE1111110, companion1111110.d());
                function2B = companion1111110.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function1111113 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function1111113;
            } else {
                if (i41 != 0) {
                    fVar2 = f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i17 != 0) {
                    e0VarA = e0.f5774d.a();
                } else {
                    e0VarA = e0Var;
                }
                selectionController = null;
                if (i19 != 0) {
                    function2 = null;
                }
                if (i22 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i23;
                }
                if (i25 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if (i27 != 0) {
                    i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i34 = i12;
                }
                if (i29 != 0) {
                    i35 = 1;
                } else {
                    i35 = i13;
                }
                if (i32 != 0) {
                    z1Var2 = null;
                } else {
                    z1Var2 = z1Var;
                }
                if (k.J()) {
                    k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                a.a(i35, i34);
                jVar = (j) iVarG.l(SelectionRegistrarKt.a());
                if (jVar != null) {
                    iVarG.R(-1589202404);
                    jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                    Object[] objArr1111111 = {jVar};
                    androidx.compose.runtime.saveable.d<Long, Long> dVarC1111111 = c(jVar);
                    zA = iVarG.A(jVar);
                    objY = iVarG.y();
                    if (zA) {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    } else {
                        objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Long invoke() {
                                return Long.valueOf(jVar.a());
                            }
                        };
                        iVarG.p(objY);
                    }
                    jLongValue = ((Number) RememberSaveableKt.c(objArr1111111, dVarC1111111, null, (Function0) objY, iVarG, 0, 4)).longValue();
                    zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                    objY2 = iVarG.y();
                    if (zD) {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    } else {
                        objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                        iVarG.p(objY2);
                    }
                    iVarG.L();
                    selectionController = (SelectionController) objY2;
                } else {
                    iVarG.R(-1588686502);
                    iVarG.L();
                }
                if (selectionController == null) {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                } else {
                    i36 = i34;
                    i37 = 0;
                    iVarG.R(-1588564052);
                    fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                    iVarG.L();
                }
                EmptyMeasurePolicy emptyMeasurePolicy1111111 = EmptyMeasurePolicy.f2861a;
                iA2 = g.a(iVarG, i37);
                f fVarE1111111 = ComposedModifierKt.e(iVarG, fVarD);
                s sVarN1111111 = iVarG.n();
                ComposeUiNode.Companion companion1111111 = ComposeUiNode.f4919a8;
                function0A = companion1111111.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A);
                } else {
                    iVarG.o();
                }
                iVarA = f3.a(iVarG);
                f3.b(iVarA, emptyMeasurePolicy1111111, companion1111111.c());
                f3.b(iVarA, sVarN1111111, companion1111111.e());
                f3.b(iVarA, fVarE1111111, companion1111111.d());
                function2B = companion1111111.b();
                if (iVarA.e()) {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                } else {
                    iVarA.p(Integer.valueOf(iA2));
                    iVarA.k(Integer.valueOf(iA2), function2B);
                }
                iVarG.r();
                if (k.J()) {
                    k.R();
                }
                i38 = i35;
                e0Var2 = e0VarA;
                i39 = iA;
                i40 = i36;
                z14 = z13;
                Function1<? super a0, Unit> function1111114 = function2;
                z1Var3 = z1Var2;
                fVar3 = fVar2;
                function3 = function1111114;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                        invoke(iVar2, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar2, int i42) {
                        BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                    }
                });
            }
        }
        i16 |= 196608;
        z12 = z11;
        i27 = i15 & 64;
        if (i27 != 0) {
            i16 |= 1572864;
        } else if ((i14 & 1572864) == 0) {
            if (iVarG.c(i12)) {
                i28 = 1048576;
            } else {
                i28 = 524288;
            }
            i16 |= i28;
        }
        i29 = i15 & 128;
        if (i29 != 0) {
            i16 |= 12582912;
        } else if ((i14 & 12582912) == 0) {
            if (iVarG.c(i13)) {
                i31 = 8388608;
            } else {
                i31 = 4194304;
            }
            i16 |= i31;
        }
        i32 = i15 & 256;
        if (i32 != 0) {
            i16 |= 100663296;
        } else if ((i14 & 100663296) == 0) {
            if (iVarG.A(z1Var)) {
                i33 = 67108864;
            } else {
                i33 = ASTNode.PCTX_STORED;
            }
            i16 |= i33;
        }
        if ((i16 & 38347923) == 38347922) {
            if (i41 != 0) {
                fVar2 = f.f3863a;
            } else {
                fVar2 = fVar;
            }
            if (i17 != 0) {
                e0VarA = e0.f5774d.a();
            } else {
                e0VarA = e0Var;
            }
            selectionController = null;
            if (i19 != 0) {
                function2 = null;
            }
            if (i22 != 0) {
                iA = p.f6143a.a();
            } else {
                iA = i23;
            }
            if (i25 != 0) {
                z13 = true;
            } else {
                z13 = z12;
            }
            if (i27 != 0) {
                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else {
                i34 = i12;
            }
            if (i29 != 0) {
                i35 = 1;
            } else {
                i35 = i13;
            }
            if (i32 != 0) {
                z1Var2 = null;
            } else {
                z1Var2 = z1Var;
            }
            if (k.J()) {
                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
            }
            a.a(i35, i34);
            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
            if (jVar != null) {
                iVarG.R(-1589202404);
                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                Object[] objArr1111112 = {jVar};
                androidx.compose.runtime.saveable.d<Long, Long> dVarC1111112 = c(jVar);
                zA = iVarG.A(jVar);
                objY = iVarG.y();
                if (zA) {
                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(jVar.a());
                        }
                    };
                    iVarG.p(objY);
                } else {
                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(jVar.a());
                        }
                    };
                    iVarG.p(objY);
                }
                jLongValue = ((Number) RememberSaveableKt.c(objArr1111112, dVarC1111112, null, (Function0) objY, iVarG, 0, 4)).longValue();
                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                objY2 = iVarG.y();
                if (zD) {
                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                    iVarG.p(objY2);
                } else {
                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                    iVarG.p(objY2);
                }
                iVarG.L();
                selectionController = (SelectionController) objY2;
            } else {
                iVarG.R(-1588686502);
                iVarG.L();
            }
            if (selectionController == null) {
                i36 = i34;
                i37 = 0;
                iVarG.R(-1588564052);
                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                iVarG.L();
            } else {
                i36 = i34;
                i37 = 0;
                iVarG.R(-1588564052);
                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                iVarG.L();
            }
            EmptyMeasurePolicy emptyMeasurePolicy1111112 = EmptyMeasurePolicy.f2861a;
            iA2 = g.a(iVarG, i37);
            f fVarE1111112 = ComposedModifierKt.e(iVarG, fVarD);
            s sVarN1111112 = iVarG.n();
            ComposeUiNode.Companion companion1111112 = ComposeUiNode.f4919a8;
            function0A = companion1111112.a();
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            iVarA = f3.a(iVarG);
            f3.b(iVarA, emptyMeasurePolicy1111112, companion1111112.c());
            f3.b(iVarA, sVarN1111112, companion1111112.e());
            f3.b(iVarA, fVarE1111112, companion1111112.d());
            function2B = companion1111112.b();
            if (iVarA.e()) {
                iVarA.p(Integer.valueOf(iA2));
                iVarA.k(Integer.valueOf(iA2), function2B);
            } else {
                iVarA.p(Integer.valueOf(iA2));
                iVarA.k(Integer.valueOf(iA2), function2B);
            }
            iVarG.r();
            if (k.J()) {
                k.R();
            }
            i38 = i35;
            e0Var2 = e0VarA;
            i39 = iA;
            i40 = i36;
            z14 = z13;
            Function1<? super a0, Unit> function1111115 = function2;
            z1Var3 = z1Var2;
            fVar3 = fVar2;
            function3 = function1111115;
        } else {
            if (i41 != 0) {
                fVar2 = f.f3863a;
            } else {
                fVar2 = fVar;
            }
            if (i17 != 0) {
                e0VarA = e0.f5774d.a();
            } else {
                e0VarA = e0Var;
            }
            selectionController = null;
            if (i19 != 0) {
                function2 = null;
            }
            if (i22 != 0) {
                iA = p.f6143a.a();
            } else {
                iA = i23;
            }
            if (i25 != 0) {
                z13 = true;
            } else {
                z13 = z12;
            }
            if (i27 != 0) {
                i34 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else {
                i34 = i12;
            }
            if (i29 != 0) {
                i35 = 1;
            } else {
                i35 = i13;
            }
            if (i32 != 0) {
                z1Var2 = null;
            } else {
                z1Var2 = z1Var;
            }
            if (k.J()) {
                k.S(-1186827822, i16, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
            }
            a.a(i35, i34);
            jVar = (j) iVarG.l(SelectionRegistrarKt.a());
            if (jVar != null) {
                iVarG.R(-1589202404);
                jA = ((m) iVarG.l(TextSelectionColorsKt.b())).a();
                Object[] objArr1111113 = {jVar};
                androidx.compose.runtime.saveable.d<Long, Long> dVarC1111113 = c(jVar);
                zA = iVarG.A(jVar);
                objY = iVarG.y();
                if (zA) {
                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(jVar.a());
                        }
                    };
                    iVarG.p(objY);
                } else {
                    objY = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(jVar.a());
                        }
                    };
                    iVarG.p(objY);
                }
                jLongValue = ((Number) RememberSaveableKt.c(objArr1111113, dVarC1111113, null, (Function0) objY, iVarG, 0, 4)).longValue();
                zD = iVarG.d(jLongValue) | iVarG.Q(jVar) | iVarG.d(jA);
                objY2 = iVarG.y();
                if (zD) {
                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                    iVarG.p(objY2);
                } else {
                    objY2 = new SelectionController(jLongValue, jVar, jA, null, 8, null);
                    iVarG.p(objY2);
                }
                iVarG.L();
                selectionController = (SelectionController) objY2;
            } else {
                iVarG.R(-1588686502);
                iVarG.L();
            }
            if (selectionController == null) {
                i36 = i34;
                i37 = 0;
                iVarG.R(-1588564052);
                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                iVarG.L();
            } else {
                i36 = i34;
                i37 = 0;
                iVarG.R(-1588564052);
                fVarD = d(d4.b(fVar2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), e0VarA, function2, iA, z13, i36, i35, (androidx.compose.ui.text.font.i.b) iVarG.l(CompositionLocalsKt.d()), null, null, selectionController, z1Var2, null);
                iVarG.L();
            }
            EmptyMeasurePolicy emptyMeasurePolicy1111113 = EmptyMeasurePolicy.f2861a;
            iA2 = g.a(iVarG, i37);
            f fVarE1111113 = ComposedModifierKt.e(iVarG, fVarD);
            s sVarN1111113 = iVarG.n();
            ComposeUiNode.Companion companion1111113 = ComposeUiNode.f4919a8;
            function0A = companion1111113.a();
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            iVarA = f3.a(iVarG);
            f3.b(iVarA, emptyMeasurePolicy1111113, companion1111113.c());
            f3.b(iVarA, sVarN1111113, companion1111113.e());
            f3.b(iVarA, fVarE1111113, companion1111113.d());
            function2B = companion1111113.b();
            if (iVarA.e()) {
                iVarA.p(Integer.valueOf(iA2));
                iVarA.k(Integer.valueOf(iA2), function2B);
            } else {
                iVarA.p(Integer.valueOf(iA2));
                iVarA.k(Integer.valueOf(iA2), function2B);
            }
            iVarG.r();
            if (k.J()) {
                k.R();
            }
            i38 = i35;
            e0Var2 = e0VarA;
            i39 = iA;
            i40 = i36;
            z14 = z13;
            Function1<? super a0, Unit> function1111116 = function2;
            z1Var3 = z1Var2;
            fVar3 = fVar2;
            function3 = function1111116;
        }
        g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i42) {
                    BasicTextKt.b(str, fVar3, e0Var2, function3, i39, z14, i40, i38, z1Var3, iVar2, v1.a(i14 | 1), i15);
                }
            });
        }
    }

    public static final androidx.compose.runtime.saveable.d<Long, Long> c(final j jVar) {
        return SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$1
            {
                super(2);
            }

            public final Long invoke(androidx.compose.runtime.saveable.e eVar, long j11) {
                if (SelectionRegistrarKt.b(jVar, j11)) {
                    return Long.valueOf(j11);
                }
                return null;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(androidx.compose.runtime.saveable.e eVar, Long l11) {
                return invoke(eVar, l11.longValue());
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$2
            public final Long invoke(long j11) {
                return Long.valueOf(j11);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l11) {
                return invoke(l11.longValue());
            }
        });
    }

    public static final f d(f fVar, AnnotatedString annotatedString, e0 e0Var, Function1<? super a0, Unit> function1, int i11, boolean z11, int i12, int i13, androidx.compose.ui.text.font.i.b bVar, List<AnnotatedString.b<t>> list, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, z1 z1Var, Function1<? super TextAnnotatedStringNode.a, Unit> function3) {
        if (selectionController == null) {
            return fVar.f(f.f3863a).f(new TextAnnotatedStringElement(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, null, z1Var, function3, null));
        }
        return fVar.f(selectionController.c()).f(new SelectableTextAnnotatedStringElement(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, selectionController, z1Var, null));
    }
}
