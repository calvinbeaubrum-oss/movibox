package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.s1;
import androidx.compose.runtime.v1;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.q;
import androidx.compose.ui.text.font.r;
import androidx.compose.ui.text.font.u;
import androidx.compose.ui.text.style.n;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.x;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;
import q2.w;

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
public final class TextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<e0> f3195a = CompositionLocalKt.c(r2.j(), new Function0<e0>() { // from class: androidx.compose.material3.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final e0 invoke() {
            return q1.e.a();
        }
    });

    /* JADX WARN: Code duplicated, block: B:101:0x0141  */
    /* JADX WARN: Code duplicated, block: B:102:0x0144  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0151  */
    /* JADX WARN: Code duplicated, block: B:109:0x0157  */
    /* JADX WARN: Code duplicated, block: B:111:0x015d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0160  */
    /* JADX WARN: Code duplicated, block: B:114:0x0165  */
    /* JADX WARN: Code duplicated, block: B:117:0x016b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0170  */
    /* JADX WARN: Code duplicated, block: B:121:0x0174  */
    /* JADX WARN: Code duplicated, block: B:123:0x017c  */
    /* JADX WARN: Code duplicated, block: B:124:0x017f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0184  */
    /* JADX WARN: Code duplicated, block: B:129:0x018b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0190  */
    /* JADX WARN: Code duplicated, block: B:133:0x0194  */
    /* JADX WARN: Code duplicated, block: B:135:0x019c  */
    /* JADX WARN: Code duplicated, block: B:136:0x019f  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:152:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:154:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:161:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:163:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:165:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:166:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:170:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:172:0x0204  */
    /* JADX WARN: Code duplicated, block: B:175:0x020d  */
    /* JADX WARN: Code duplicated, block: B:177:0x0212  */
    /* JADX WARN: Code duplicated, block: B:180:0x021e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0253  */
    /* JADX WARN: Code duplicated, block: B:188:0x025a  */
    /* JADX WARN: Code duplicated, block: B:195:0x028a A[PHI: r0 r1 r4 r6 r7 r8 r9 r10 r12 r15 r16 r17 r19 r21 r22 r23
  0x028a: PHI (r0v13 androidx.compose.ui.text.style.i) = (r0v5 androidx.compose.ui.text.style.i), (r0v15 androidx.compose.ui.text.style.i) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r1v8 int) = (r1v3 int), (r1v9 int) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r4v11 long) = (r4v8 long), (r4v12 long) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r6v5 androidx.compose.ui.f) = (r6v2 androidx.compose.ui.f), (r6v6 androidx.compose.ui.f) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r7v17 int) = (r7v4 int), (r7v18 int) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r8v17 int) = (r8v12 int), (r8v19 int) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r9v8 boolean) = (r9v4 boolean), (r9v9 boolean) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r10v11 long) = (r10v6 long), (r10v12 long) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r12v7 int) = (r12v3 int), (r12v8 int) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r15v7 androidx.compose.ui.text.style.h) = (r15v3 androidx.compose.ui.text.style.h), (r15v8 androidx.compose.ui.text.style.h) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r16v12 kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.a0, kotlin.Unit>) = 
  (r16v8 kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.a0, kotlin.Unit>)
  (r16v13 kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.a0, kotlin.Unit>)
 binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r17v10 androidx.compose.ui.text.font.q) = (r17v6 androidx.compose.ui.text.font.q), (r17v11 androidx.compose.ui.text.font.q) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r19v12 long) = (r19v9 long), (r19v13 long) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r21v5 androidx.compose.ui.text.font.u) = (r21v1 androidx.compose.ui.text.font.u), (r21v6 androidx.compose.ui.text.font.u) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r22v10 androidx.compose.ui.text.font.i) = (r22v6 androidx.compose.ui.text.font.i), (r22v11 androidx.compose.ui.text.font.i) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]
  0x028a: PHI (r23v8 long) = (r23v4 long), (r23v9 long) binds: [B:244:0x030d, B:194:0x026c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:196:0x028f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:197:0x0291  */
    /* JADX WARN: Code duplicated, block: B:198:0x0294  */
    /* JADX WARN: Code duplicated, block: B:200:0x0298  */
    /* JADX WARN: Code duplicated, block: B:201:0x029f  */
    /* JADX WARN: Code duplicated, block: B:203:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:204:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:207:0x02af  */
    /* JADX WARN: Code duplicated, block: B:208:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:210:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:211:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:213:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:214:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:216:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:217:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:219:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:220:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:223:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:225:0x02da  */
    /* JADX WARN: Code duplicated, block: B:226:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:228:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:229:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:232:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:233:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:235:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:236:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:239:0x0300  */
    /* JADX WARN: Code duplicated, block: B:241:0x0304  */
    /* JADX WARN: Code duplicated, block: B:242:0x0307  */
    /* JADX WARN: Code duplicated, block: B:245:0x030f  */
    /* JADX WARN: Code duplicated, block: B:248:0x0329  */
    /* JADX WARN: Code duplicated, block: B:249:0x0334  */
    /* JADX WARN: Code duplicated, block: B:252:0x0346  */
    /* JADX WARN: Code duplicated, block: B:253:0x0349  */
    /* JADX WARN: Code duplicated, block: B:256:0x0356  */
    /* JADX WARN: Code duplicated, block: B:260:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:265:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x009a  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:81:0x0102  */
    /* JADX WARN: Code duplicated, block: B:82:0x0105  */
    /* JADX WARN: Code duplicated, block: B:86:0x010d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0114  */
    /* JADX WARN: Code duplicated, block: B:89:0x011c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0122  */
    /* JADX WARN: Code duplicated, block: B:92:0x0125  */
    /* JADX WARN: Code duplicated, block: B:96:0x012c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0133  */
    /* JADX WARN: Code duplicated, block: B:99:0x013b  */
    public static final void a(final String text, androidx.compose.ui.f fVar, long j11, long j12, q qVar, u uVar, androidx.compose.ui.text.font.i iVar, long j13, androidx.compose.ui.text.style.i iVar2, androidx.compose.ui.text.style.h hVar, long j14, int i11, boolean z11, int i12, int i13, Function1<? super a0, Unit> function1, e0 e0Var, androidx.compose.runtime.i iVar3, final int i14, final int i15, final int i16) {
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
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        androidx.compose.ui.f fVar2;
        long jE;
        long jA;
        q qVar2;
        u uVar2;
        androidx.compose.ui.text.font.i iVar4;
        long jA2;
        androidx.compose.ui.text.style.i iVar5;
        androidx.compose.ui.text.style.h hVar2;
        long jA3;
        int iA;
        boolean z12;
        int i48;
        int i49;
        Function1<? super a0, Unit> function2;
        androidx.compose.ui.text.style.i iVar6;
        int i50;
        e0 e0Var2;
        w1.a aVar;
        long jH;
        long j15;
        final int i51;
        final androidx.compose.ui.text.style.h hVar3;
        final q qVar3;
        final androidx.compose.ui.text.style.i iVar7;
        final long j16;
        final boolean z13;
        final long j17;
        final androidx.compose.ui.text.font.i iVar8;
        final long j18;
        e0 e0Var3;
        Function1<? super a0, Unit> function3;
        final u uVar3;
        int i52;
        final int i53;
        g2 g2VarJ;
        int i54;
        Intrinsics.g(text, "text");
        androidx.compose.runtime.i iVarG = iVar3.g(-2055108902);
        if ((i16 & 1) != 0) {
            i17 = i14 | 6;
        } else if ((i14 & 14) == 0) {
            i17 = (iVarG.Q(text) ? 4 : 2) | i14;
        } else {
            i17 = i14;
        }
        int i55 = i16 & 2;
        if (i55 == 0) {
            if ((i14 & 112) == 0) {
                i17 |= iVarG.Q(fVar) ? 32 : 16;
            }
            i18 = i16 & 4;
            if (i18 != 0) {
                i17 |= 384;
            } else if ((i14 & 896) == 0) {
                if (iVarG.d(j11)) {
                    i19 = 256;
                } else {
                    i19 = 128;
                }
                i17 |= i19;
            }
            i21 = i16 & 8;
            if (i21 != 0) {
                i17 |= 3072;
            } else if ((i14 & 7168) == 0) {
                if (iVarG.d(j12)) {
                    i22 = 2048;
                } else {
                    i22 = 1024;
                }
                i17 |= i22;
            }
            i23 = i16 & 16;
            if (i23 != 0) {
                i17 |= 24576;
            } else if ((i14 & 57344) == 0) {
                if (iVarG.Q(qVar)) {
                    i24 = 16384;
                } else {
                    i24 = 8192;
                }
                i17 |= i24;
            }
            i25 = i16 & 32;
            if (i25 != 0) {
                i17 |= 196608;
            } else if ((i14 & 458752) == 0) {
                if (iVarG.Q(uVar)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i17 |= i26;
            }
            i27 = i16 & 64;
            if (i27 != 0) {
                i17 |= 1572864;
            } else if ((i14 & 3670016) == 0) {
                if (iVarG.Q(iVar)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i17 |= i28;
            }
            i29 = i16 & 128;
            if (i29 != 0) {
                i17 |= 12582912;
            } else if ((i14 & 29360128) == 0) {
                if (iVarG.d(j13)) {
                    i31 = 8388608;
                } else {
                    i31 = 4194304;
                }
                i17 |= i31;
            }
            i32 = i16 & 256;
            if (i32 != 0) {
                i17 |= 100663296;
            } else if ((i14 & 234881024) == 0) {
                if (iVarG.Q(iVar2)) {
                    i33 = 67108864;
                } else {
                    i33 = ASTNode.PCTX_STORED;
                }
                i17 |= i33;
            }
            i34 = i16 & 512;
            if (i34 != 0) {
                i17 |= 805306368;
            } else if ((i14 & 1879048192) == 0) {
                if (iVarG.Q(hVar)) {
                    i35 = ASTNode.DISCARD;
                } else {
                    i35 = ASTNode.DEOP;
                }
                i17 |= i35;
            }
            i36 = i16 & 1024;
            if (i36 != 0) {
                i37 = i15 | 6;
            } else if ((i15 & 14) == 0) {
                if (iVarG.d(j14)) {
                    i38 = 4;
                } else {
                    i38 = 2;
                }
                i37 = i15 | i38;
            } else {
                i37 = i15;
            }
            i39 = i16 & 2048;
            if (i39 != 0) {
                i37 |= 48;
            } else if ((i15 & 112) != 0) {
                if (iVarG.c(i11)) {
                    i40 = 32;
                } else {
                    i40 = 16;
                }
                i37 |= i40;
            }
            i41 = i37;
            i42 = i16 & 4096;
            if (i42 != 0) {
                if ((i15 & 896) == 0) {
                    if (iVarG.a(z11)) {
                        i43 = 256;
                    } else {
                        i43 = 128;
                    }
                    i41 |= i43;
                }
                i44 = i16 & 8192;
                if (i44 != 0) {
                    if ((i15 & 7168) == 0) {
                        i41 |= iVarG.c(i12) ? 2048 : 1024;
                    }
                    i45 = i16 & 16384;
                    if (i45 != 0) {
                        if ((i15 & 57344) == 0) {
                            i41 |= iVarG.c(i13) ? 16384 : 8192;
                        }
                        i46 = i16 & 32768;
                        if (i46 != 0) {
                            i41 |= 196608;
                        } else if ((i15 & 458752) == 0) {
                            if (iVarG.A(function1)) {
                                i47 = 131072;
                            } else {
                                i47 = 65536;
                            }
                            i41 |= i47;
                        }
                        if ((i15 & 3670016) != 0) {
                            if ((i16 & 65536) == 0 || !iVarG.Q(e0Var)) {
                                i54 = 524288;
                            } else {
                                i54 = 1048576;
                            }
                            i41 |= i54;
                        }
                        if ((i17 & 1533916891) != 306783378 && (2995931 & i41) == 599186 && iVarG.h()) {
                            iVarG.H();
                            fVar2 = fVar;
                            j17 = j11;
                            jA = j12;
                            qVar3 = qVar;
                            uVar3 = uVar;
                            iVar8 = iVar;
                            j18 = j13;
                            iVar7 = iVar2;
                            hVar3 = hVar;
                            j16 = j14;
                            i53 = i11;
                            z13 = z11;
                            i51 = i12;
                            i52 = i13;
                            function3 = function1;
                            e0Var3 = e0Var;
                        } else {
                            iVarG.B();
                            if ((i14 & 1) != 0 || iVarG.J()) {
                                if (i55 != 0) {
                                    fVar2 = androidx.compose.ui.f.f3863a;
                                } else {
                                    fVar2 = fVar;
                                }
                                if (i18 != 0) {
                                    jE = w1.f4564b.e();
                                } else {
                                    jE = j11;
                                }
                                if (i21 != 0) {
                                    jA = w.f74257b.a();
                                } else {
                                    jA = j12;
                                }
                                if (i23 != 0) {
                                    qVar2 = null;
                                } else {
                                    qVar2 = qVar;
                                }
                                if (i25 != 0) {
                                    uVar2 = null;
                                } else {
                                    uVar2 = uVar;
                                }
                                if (i27 != 0) {
                                    iVar4 = null;
                                } else {
                                    iVar4 = iVar;
                                }
                                if (i29 != 0) {
                                    jA2 = w.f74257b.a();
                                } else {
                                    jA2 = j13;
                                }
                                if (i32 != 0) {
                                    iVar5 = null;
                                } else {
                                    iVar5 = iVar2;
                                }
                                hVar2 = i34 == 0 ? hVar : null;
                                if (i36 != 0) {
                                    jA3 = w.f74257b.a();
                                } else {
                                    jA3 = j14;
                                }
                                if (i39 != 0) {
                                    iA = p.f6143a.a();
                                } else {
                                    iA = i11;
                                }
                                if (i42 != 0) {
                                    z12 = true;
                                } else {
                                    z12 = z11;
                                }
                                if (i44 != 0) {
                                    i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                                } else {
                                    i48 = i12;
                                }
                                i49 = i45 == 0 ? i13 : 1;
                                if (i46 != 0) {
                                    function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                            invoke2(a0Var);
                                            return Unit.f68710a;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(a0 it) {
                                            Intrinsics.g(it, "it");
                                        }
                                    };
                                } else {
                                    function2 = function1;
                                }
                                iVar6 = iVar5;
                                if ((i16 & 65536) != 0) {
                                    i50 = i41 & (-3670017);
                                    e0Var2 = (e0) iVarG.l(f3195a);
                                    iVar5 = iVar6;
                                }
                                iVarG.s();
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                                }
                                iVarG.x(79582822);
                                aVar = w1.f4564b;
                                if (jE != aVar.e()) {
                                    j15 = jE;
                                } else {
                                    jH = e0Var2.h();
                                    if (jH == aVar.e()) {
                                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                                    }
                                    j15 = jH;
                                }
                                iVarG.P();
                                int i56 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                                int i57 = i50 << 9;
                                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i56 | (i57 & 57344) | (i57 & 458752) | (i57 & 3670016) | (i57 & 29360128), 0);
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.R();
                                }
                                i51 = i48;
                                hVar3 = hVar2;
                                qVar3 = qVar2;
                                iVar7 = iVar5;
                                j16 = jA3;
                                z13 = z12;
                                j17 = jE;
                                iVar8 = iVar4;
                                j18 = jA2;
                                e0Var3 = e0Var2;
                                function3 = function2;
                                uVar3 = uVar2;
                                i52 = i49;
                                i53 = iA;
                            } else {
                                iVarG.H();
                                if ((i16 & 65536) != 0) {
                                    i41 &= -3670017;
                                }
                                fVar2 = fVar;
                                jE = j11;
                                jA = j12;
                                qVar2 = qVar;
                                uVar2 = uVar;
                                iVar4 = iVar;
                                jA2 = j13;
                                iVar5 = iVar2;
                                hVar2 = hVar;
                                jA3 = j14;
                                iA = i11;
                                z12 = z11;
                                i48 = i12;
                                i49 = i13;
                                function2 = function1;
                            }
                            i50 = i41;
                            e0Var2 = e0Var;
                            iVarG.s();
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                            }
                            iVarG.x(79582822);
                            aVar = w1.f4564b;
                            if (jE != aVar.e()) {
                                j15 = jE;
                            } else {
                                jH = e0Var2.h();
                                if (jH == aVar.e()) {
                                    jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                                }
                                j15 = jH;
                            }
                            iVarG.P();
                            int i58 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                            int i59 = i50 << 9;
                            BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i58 | (i59 & 57344) | (i59 & 458752) | (i59 & 3670016) | (i59 & 29360128), 0);
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.R();
                            }
                            i51 = i48;
                            hVar3 = hVar2;
                            qVar3 = qVar2;
                            iVar7 = iVar5;
                            j16 = jA3;
                            z13 = z12;
                            j17 = jE;
                            iVar8 = iVar4;
                            j18 = jA2;
                            e0Var3 = e0Var2;
                            function3 = function2;
                            uVar3 = uVar2;
                            i52 = i49;
                            i53 = iA;
                        }
                        g2VarJ = iVarG.j();
                        if (g2VarJ == null) {
                            return;
                        }
                        final androidx.compose.ui.f fVar3 = fVar2;
                        final long j19 = jA;
                        final int i60 = i52;
                        final Function1<? super a0, Unit> function4 = function3;
                        final e0 e0Var4 = e0Var3;
                        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                                invoke(iVar9, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar9, int i61) {
                                TextKt.a(text, fVar3, j17, j19, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i60, function4, e0Var4, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                            }
                        });
                    }
                    i41 |= 24576;
                    i46 = i16 & 32768;
                    if (i46 != 0) {
                        i41 |= 196608;
                    } else if ((i15 & 458752) == 0) {
                        if (iVarG.A(function1)) {
                            i47 = 131072;
                        } else {
                            i47 = 65536;
                        }
                        i41 |= i47;
                    }
                    if ((i15 & 3670016) != 0) {
                        if ((i16 & 65536) == 0) {
                            i54 = 524288;
                        } else {
                            i54 = 524288;
                        }
                        i41 |= i54;
                    }
                    if ((i17 & 1533916891) != 306783378) {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i510 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i511 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i510 | (i511 & 57344) | (i511 & 458752) | (i511 & 3670016) | (i511 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    } else {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i512 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i513 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i512 | (i513 & 57344) | (i513 & 458752) | (i513 & 3670016) | (i513 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ == null) {
                        return;
                    }
                    final androidx.compose.ui.f fVar4 = fVar2;
                    final long j110 = jA;
                    final int i61 = i52;
                    final Function1<? super a0, Unit> function5 = function3;
                    final e0 e0Var5 = e0Var3;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                            invoke(iVar9, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar9, int i62) {
                            TextKt.a(text, fVar4, j17, j110, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i61, function5, e0Var5, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                        }
                    });
                }
                i41 |= 3072;
                i45 = i16 & 16384;
                if (i45 != 0) {
                    if ((i15 & 57344) == 0) {
                        i41 |= iVarG.c(i13) ? 16384 : 8192;
                    }
                    i46 = i16 & 32768;
                    if (i46 != 0) {
                        i41 |= 196608;
                    } else if ((i15 & 458752) == 0) {
                        if (iVarG.A(function1)) {
                            i47 = 131072;
                        } else {
                            i47 = 65536;
                        }
                        i41 |= i47;
                    }
                    if ((i15 & 3670016) != 0) {
                        if ((i16 & 65536) == 0) {
                            i54 = 524288;
                        } else {
                            i54 = 524288;
                        }
                        i41 |= i54;
                    }
                    if ((i17 & 1533916891) != 306783378) {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i514 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i515 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i514 | (i515 & 57344) | (i515 & 458752) | (i515 & 3670016) | (i515 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    } else {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i516 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i517 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i516 | (i517 & 57344) | (i517 & 458752) | (i517 & 3670016) | (i517 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ == null) {
                        return;
                    }
                    final androidx.compose.ui.f fVar5 = fVar2;
                    final long j111 = jA;
                    final int i62 = i52;
                    final Function1<? super a0, Unit> function6 = function3;
                    final e0 e0Var6 = e0Var3;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                            invoke(iVar9, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar9, int i63) {
                            TextKt.a(text, fVar5, j17, j111, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i62, function6, e0Var6, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                        }
                    });
                }
                i41 |= 24576;
                i46 = i16 & 32768;
                if (i46 != 0) {
                    i41 |= 196608;
                } else if ((i15 & 458752) == 0) {
                    if (iVarG.A(function1)) {
                        i47 = 131072;
                    } else {
                        i47 = 65536;
                    }
                    i41 |= i47;
                }
                if ((i15 & 3670016) != 0) {
                    if ((i16 & 65536) == 0) {
                        i54 = 524288;
                    } else {
                        i54 = 524288;
                    }
                    i41 |= i54;
                }
                if ((i17 & 1533916891) != 306783378) {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i518 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i519 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i518 | (i519 & 57344) | (i519 & 458752) | (i519 & 3670016) | (i519 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                } else {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i5110 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i5111 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5110 | (i5111 & 57344) | (i5111 & 458752) | (i5111 & 3670016) | (i5111 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ == null) {
                    return;
                }
                final androidx.compose.ui.f fVar6 = fVar2;
                final long j112 = jA;
                final int i63 = i52;
                final Function1<? super a0, Unit> function7 = function3;
                final e0 e0Var7 = e0Var3;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i64) {
                        TextKt.a(text, fVar6, j17, j112, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i63, function7, e0Var7, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                    }
                });
            }
            i41 |= 384;
            i44 = i16 & 8192;
            if (i44 != 0) {
                if ((i15 & 7168) == 0) {
                    i41 |= iVarG.c(i12) ? 2048 : 1024;
                }
                i45 = i16 & 16384;
                if (i45 != 0) {
                    if ((i15 & 57344) == 0) {
                        i41 |= iVarG.c(i13) ? 16384 : 8192;
                    }
                    i46 = i16 & 32768;
                    if (i46 != 0) {
                        i41 |= 196608;
                    } else if ((i15 & 458752) == 0) {
                        if (iVarG.A(function1)) {
                            i47 = 131072;
                        } else {
                            i47 = 65536;
                        }
                        i41 |= i47;
                    }
                    if ((i15 & 3670016) != 0) {
                        if ((i16 & 65536) == 0) {
                            i54 = 524288;
                        } else {
                            i54 = 524288;
                        }
                        i41 |= i54;
                    }
                    if ((i17 & 1533916891) != 306783378) {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i5112 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i5113 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5112 | (i5113 & 57344) | (i5113 & 458752) | (i5113 & 3670016) | (i5113 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    } else {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i5114 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i5115 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5114 | (i5115 & 57344) | (i5115 & 458752) | (i5115 & 3670016) | (i5115 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ == null) {
                        return;
                    }
                    final androidx.compose.ui.f fVar7 = fVar2;
                    final long j113 = jA;
                    final int i64 = i52;
                    final Function1<? super a0, Unit> function8 = function3;
                    final e0 e0Var8 = e0Var3;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                            invoke(iVar9, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar9, int i65) {
                            TextKt.a(text, fVar7, j17, j113, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i64, function8, e0Var8, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                        }
                    });
                }
                i41 |= 24576;
                i46 = i16 & 32768;
                if (i46 != 0) {
                    i41 |= 196608;
                } else if ((i15 & 458752) == 0) {
                    if (iVarG.A(function1)) {
                        i47 = 131072;
                    } else {
                        i47 = 65536;
                    }
                    i41 |= i47;
                }
                if ((i15 & 3670016) != 0) {
                    if ((i16 & 65536) == 0) {
                        i54 = 524288;
                    } else {
                        i54 = 524288;
                    }
                    i41 |= i54;
                }
                if ((i17 & 1533916891) != 306783378) {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i5116 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i5117 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5116 | (i5117 & 57344) | (i5117 & 458752) | (i5117 & 3670016) | (i5117 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                } else {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i5118 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i5119 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5118 | (i5119 & 57344) | (i5119 & 458752) | (i5119 & 3670016) | (i5119 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ == null) {
                    return;
                }
                final androidx.compose.ui.f fVar8 = fVar2;
                final long j114 = jA;
                final int i65 = i52;
                final Function1<? super a0, Unit> function9 = function3;
                final e0 e0Var9 = e0Var3;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i66) {
                        TextKt.a(text, fVar8, j17, j114, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i65, function9, e0Var9, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                    }
                });
            }
            i41 |= 3072;
            i45 = i16 & 16384;
            if (i45 != 0) {
                if ((i15 & 57344) == 0) {
                    i41 |= iVarG.c(i13) ? 16384 : 8192;
                }
                i46 = i16 & 32768;
                if (i46 != 0) {
                    i41 |= 196608;
                } else if ((i15 & 458752) == 0) {
                    if (iVarG.A(function1)) {
                        i47 = 131072;
                    } else {
                        i47 = 65536;
                    }
                    i41 |= i47;
                }
                if ((i15 & 3670016) != 0) {
                    if ((i16 & 65536) == 0) {
                        i54 = 524288;
                    } else {
                        i54 = 524288;
                    }
                    i41 |= i54;
                }
                if ((i17 & 1533916891) != 306783378) {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i51110 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i51111 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51110 | (i51111 & 57344) | (i51111 & 458752) | (i51111 & 3670016) | (i51111 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                } else {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i51112 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i51113 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51112 | (i51113 & 57344) | (i51113 & 458752) | (i51113 & 3670016) | (i51113 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ == null) {
                    return;
                }
                final androidx.compose.ui.f fVar9 = fVar2;
                final long j115 = jA;
                final int i66 = i52;
                final Function1<? super a0, Unit> function10 = function3;
                final e0 e0Var10 = e0Var3;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i67) {
                        TextKt.a(text, fVar9, j17, j115, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i66, function10, e0Var10, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                    }
                });
            }
            i41 |= 24576;
            i46 = i16 & 32768;
            if (i46 != 0) {
                i41 |= 196608;
            } else if ((i15 & 458752) == 0) {
                if (iVarG.A(function1)) {
                    i47 = 131072;
                } else {
                    i47 = 65536;
                }
                i41 |= i47;
            }
            if ((i15 & 3670016) != 0) {
                if ((i16 & 65536) == 0) {
                    i54 = 524288;
                } else {
                    i54 = 524288;
                }
                i41 |= i54;
            }
            if ((i17 & 1533916891) != 306783378) {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i51114 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i51115 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51114 | (i51115 & 57344) | (i51115 & 458752) | (i51115 & 3670016) | (i51115 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            } else {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i51116 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i51117 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51116 | (i51117 & 57344) | (i51117 & 458752) | (i51117 & 3670016) | (i51117 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ == null) {
                return;
            }
            final androidx.compose.ui.f fVar10 = fVar2;
            final long j116 = jA;
            final int i67 = i52;
            final Function1<? super a0, Unit> function11 = function3;
            final e0 e0Var11 = e0Var3;
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                    invoke(iVar9, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar9, int i68) {
                    TextKt.a(text, fVar10, j17, j116, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i67, function11, e0Var11, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                }
            });
        }
        i17 |= 48;
        i18 = i16 & 4;
        if (i18 != 0) {
            i17 |= 384;
        } else if ((i14 & 896) == 0) {
            if (iVarG.d(j11)) {
                i19 = 256;
            } else {
                i19 = 128;
            }
            i17 |= i19;
        }
        i21 = i16 & 8;
        if (i21 != 0) {
            i17 |= 3072;
        } else if ((i14 & 7168) == 0) {
            if (iVarG.d(j12)) {
                i22 = 2048;
            } else {
                i22 = 1024;
            }
            i17 |= i22;
        }
        i23 = i16 & 16;
        if (i23 != 0) {
            i17 |= 24576;
        } else if ((i14 & 57344) == 0) {
            if (iVarG.Q(qVar)) {
                i24 = 16384;
            } else {
                i24 = 8192;
            }
            i17 |= i24;
        }
        i25 = i16 & 32;
        if (i25 != 0) {
            i17 |= 196608;
        } else if ((i14 & 458752) == 0) {
            if (iVarG.Q(uVar)) {
                i26 = 131072;
            } else {
                i26 = 65536;
            }
            i17 |= i26;
        }
        i27 = i16 & 64;
        if (i27 != 0) {
            i17 |= 1572864;
        } else if ((i14 & 3670016) == 0) {
            if (iVarG.Q(iVar)) {
                i28 = 1048576;
            } else {
                i28 = 524288;
            }
            i17 |= i28;
        }
        i29 = i16 & 128;
        if (i29 != 0) {
            i17 |= 12582912;
        } else if ((i14 & 29360128) == 0) {
            if (iVarG.d(j13)) {
                i31 = 8388608;
            } else {
                i31 = 4194304;
            }
            i17 |= i31;
        }
        i32 = i16 & 256;
        if (i32 != 0) {
            i17 |= 100663296;
        } else if ((i14 & 234881024) == 0) {
            if (iVarG.Q(iVar2)) {
                i33 = 67108864;
            } else {
                i33 = ASTNode.PCTX_STORED;
            }
            i17 |= i33;
        }
        i34 = i16 & 512;
        if (i34 != 0) {
            i17 |= 805306368;
        } else if ((i14 & 1879048192) == 0) {
            if (iVarG.Q(hVar)) {
                i35 = ASTNode.DISCARD;
            } else {
                i35 = ASTNode.DEOP;
            }
            i17 |= i35;
        }
        i36 = i16 & 1024;
        if (i36 != 0) {
            i37 = i15 | 6;
        } else if ((i15 & 14) == 0) {
            if (iVarG.d(j14)) {
                i38 = 4;
            } else {
                i38 = 2;
            }
            i37 = i15 | i38;
        } else {
            i37 = i15;
        }
        i39 = i16 & 2048;
        if (i39 != 0) {
            i37 |= 48;
        } else if ((i15 & 112) != 0) {
            if (iVarG.c(i11)) {
                i40 = 32;
            } else {
                i40 = 16;
            }
            i37 |= i40;
        }
        i41 = i37;
        i42 = i16 & 4096;
        if (i42 != 0) {
            if ((i15 & 896) == 0) {
                if (iVarG.a(z11)) {
                    i43 = 256;
                } else {
                    i43 = 128;
                }
                i41 |= i43;
            }
            i44 = i16 & 8192;
            if (i44 != 0) {
                if ((i15 & 7168) == 0) {
                    i41 |= iVarG.c(i12) ? 2048 : 1024;
                }
                i45 = i16 & 16384;
                if (i45 != 0) {
                    if ((i15 & 57344) == 0) {
                        i41 |= iVarG.c(i13) ? 16384 : 8192;
                    }
                    i46 = i16 & 32768;
                    if (i46 != 0) {
                        i41 |= 196608;
                    } else if ((i15 & 458752) == 0) {
                        if (iVarG.A(function1)) {
                            i47 = 131072;
                        } else {
                            i47 = 65536;
                        }
                        i41 |= i47;
                    }
                    if ((i15 & 3670016) != 0) {
                        if ((i16 & 65536) == 0) {
                            i54 = 524288;
                        } else {
                            i54 = 524288;
                        }
                        i41 |= i54;
                    }
                    if ((i17 & 1533916891) != 306783378) {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i51118 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i51119 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51118 | (i51119 & 57344) | (i51119 & 458752) | (i51119 & 3670016) | (i51119 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    } else {
                        iVarG.B();
                        if ((i14 & 1) != 0) {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        } else {
                            if (i55 != 0) {
                                fVar2 = androidx.compose.ui.f.f3863a;
                            } else {
                                fVar2 = fVar;
                            }
                            if (i18 != 0) {
                                jE = w1.f4564b.e();
                            } else {
                                jE = j11;
                            }
                            if (i21 != 0) {
                                jA = w.f74257b.a();
                            } else {
                                jA = j12;
                            }
                            if (i23 != 0) {
                                qVar2 = null;
                            } else {
                                qVar2 = qVar;
                            }
                            if (i25 != 0) {
                                uVar2 = null;
                            } else {
                                uVar2 = uVar;
                            }
                            if (i27 != 0) {
                                iVar4 = null;
                            } else {
                                iVar4 = iVar;
                            }
                            if (i29 != 0) {
                                jA2 = w.f74257b.a();
                            } else {
                                jA2 = j13;
                            }
                            if (i32 != 0) {
                                iVar5 = null;
                            } else {
                                iVar5 = iVar2;
                            }
                            if (i34 == 0) {
                            }
                            if (i36 != 0) {
                                jA3 = w.f74257b.a();
                            } else {
                                jA3 = j14;
                            }
                            if (i39 != 0) {
                                iA = p.f6143a.a();
                            } else {
                                iA = i11;
                            }
                            if (i42 != 0) {
                                z12 = true;
                            } else {
                                z12 = z11;
                            }
                            if (i44 != 0) {
                                i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                i48 = i12;
                            }
                            if (i45 == 0) {
                            }
                            if (i46 != 0) {
                                function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                        invoke2(a0Var);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(a0 it) {
                                        Intrinsics.g(it, "it");
                                    }
                                };
                            } else {
                                function2 = function1;
                            }
                            iVar6 = iVar5;
                            if ((i16 & 65536) != 0) {
                                i50 = i41 & (-3670017);
                                e0Var2 = (e0) iVarG.l(f3195a);
                                iVar5 = iVar6;
                            } else {
                                i50 = i41;
                                e0Var2 = e0Var;
                            }
                        }
                        iVarG.s();
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                        }
                        iVarG.x(79582822);
                        aVar = w1.f4564b;
                        if (jE != aVar.e()) {
                            j15 = jE;
                        } else {
                            jH = e0Var2.h();
                            if (jH == aVar.e()) {
                                jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                            }
                            j15 = jH;
                        }
                        iVarG.P();
                        int i511110 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                        int i511111 = i50 << 9;
                        BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i511110 | (i511111 & 57344) | (i511111 & 458752) | (i511111 & 3670016) | (i511111 & 29360128), 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                        i51 = i48;
                        hVar3 = hVar2;
                        qVar3 = qVar2;
                        iVar7 = iVar5;
                        j16 = jA3;
                        z13 = z12;
                        j17 = jE;
                        iVar8 = iVar4;
                        j18 = jA2;
                        e0Var3 = e0Var2;
                        function3 = function2;
                        uVar3 = uVar2;
                        i52 = i49;
                        i53 = iA;
                    }
                    g2VarJ = iVarG.j();
                    if (g2VarJ == null) {
                        return;
                    }
                    final androidx.compose.ui.f fVar11 = fVar2;
                    final long j117 = jA;
                    final int i68 = i52;
                    final Function1<? super a0, Unit> function12 = function3;
                    final e0 e0Var12 = e0Var3;
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                            invoke(iVar9, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar9, int i69) {
                            TextKt.a(text, fVar11, j17, j117, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i68, function12, e0Var12, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                        }
                    });
                }
                i41 |= 24576;
                i46 = i16 & 32768;
                if (i46 != 0) {
                    i41 |= 196608;
                } else if ((i15 & 458752) == 0) {
                    if (iVarG.A(function1)) {
                        i47 = 131072;
                    } else {
                        i47 = 65536;
                    }
                    i41 |= i47;
                }
                if ((i15 & 3670016) != 0) {
                    if ((i16 & 65536) == 0) {
                        i54 = 524288;
                    } else {
                        i54 = 524288;
                    }
                    i41 |= i54;
                }
                if ((i17 & 1533916891) != 306783378) {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i511112 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i511113 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i511112 | (i511113 & 57344) | (i511113 & 458752) | (i511113 & 3670016) | (i511113 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                } else {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i511114 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i511115 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i511114 | (i511115 & 57344) | (i511115 & 458752) | (i511115 & 3670016) | (i511115 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ == null) {
                    return;
                }
                final androidx.compose.ui.f fVar12 = fVar2;
                final long j118 = jA;
                final int i69 = i52;
                final Function1<? super a0, Unit> function13 = function3;
                final e0 e0Var13 = e0Var3;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i610) {
                        TextKt.a(text, fVar12, j17, j118, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i69, function13, e0Var13, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                    }
                });
            }
            i41 |= 3072;
            i45 = i16 & 16384;
            if (i45 != 0) {
                if ((i15 & 57344) == 0) {
                    i41 |= iVarG.c(i13) ? 16384 : 8192;
                }
                i46 = i16 & 32768;
                if (i46 != 0) {
                    i41 |= 196608;
                } else if ((i15 & 458752) == 0) {
                    if (iVarG.A(function1)) {
                        i47 = 131072;
                    } else {
                        i47 = 65536;
                    }
                    i41 |= i47;
                }
                if ((i15 & 3670016) != 0) {
                    if ((i16 & 65536) == 0) {
                        i54 = 524288;
                    } else {
                        i54 = 524288;
                    }
                    i41 |= i54;
                }
                if ((i17 & 1533916891) != 306783378) {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i511116 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i511117 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i511116 | (i511117 & 57344) | (i511117 & 458752) | (i511117 & 3670016) | (i511117 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                } else {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i511118 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i511119 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i511118 | (i511119 & 57344) | (i511119 & 458752) | (i511119 & 3670016) | (i511119 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ == null) {
                    return;
                }
                final androidx.compose.ui.f fVar13 = fVar2;
                final long j119 = jA;
                final int i610 = i52;
                final Function1<? super a0, Unit> function14 = function3;
                final e0 e0Var14 = e0Var3;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i611) {
                        TextKt.a(text, fVar13, j17, j119, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i610, function14, e0Var14, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                    }
                });
            }
            i41 |= 24576;
            i46 = i16 & 32768;
            if (i46 != 0) {
                i41 |= 196608;
            } else if ((i15 & 458752) == 0) {
                if (iVarG.A(function1)) {
                    i47 = 131072;
                } else {
                    i47 = 65536;
                }
                i41 |= i47;
            }
            if ((i15 & 3670016) != 0) {
                if ((i16 & 65536) == 0) {
                    i54 = 524288;
                } else {
                    i54 = 524288;
                }
                i41 |= i54;
            }
            if ((i17 & 1533916891) != 306783378) {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i5111110 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i5111111 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5111110 | (i5111111 & 57344) | (i5111111 & 458752) | (i5111111 & 3670016) | (i5111111 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            } else {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i5111112 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i5111113 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5111112 | (i5111113 & 57344) | (i5111113 & 458752) | (i5111113 & 3670016) | (i5111113 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ == null) {
                return;
            }
            final androidx.compose.ui.f fVar14 = fVar2;
            final long j1110 = jA;
            final int i611 = i52;
            final Function1<? super a0, Unit> function15 = function3;
            final e0 e0Var15 = e0Var3;
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                    invoke(iVar9, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar9, int i612) {
                    TextKt.a(text, fVar14, j17, j1110, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i611, function15, e0Var15, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                }
            });
        }
        i41 |= 384;
        i44 = i16 & 8192;
        if (i44 != 0) {
            if ((i15 & 7168) == 0) {
                i41 |= iVarG.c(i12) ? 2048 : 1024;
            }
            i45 = i16 & 16384;
            if (i45 != 0) {
                if ((i15 & 57344) == 0) {
                    i41 |= iVarG.c(i13) ? 16384 : 8192;
                }
                i46 = i16 & 32768;
                if (i46 != 0) {
                    i41 |= 196608;
                } else if ((i15 & 458752) == 0) {
                    if (iVarG.A(function1)) {
                        i47 = 131072;
                    } else {
                        i47 = 65536;
                    }
                    i41 |= i47;
                }
                if ((i15 & 3670016) != 0) {
                    if ((i16 & 65536) == 0) {
                        i54 = 524288;
                    } else {
                        i54 = 524288;
                    }
                    i41 |= i54;
                }
                if ((i17 & 1533916891) != 306783378) {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i5111114 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i5111115 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5111114 | (i5111115 & 57344) | (i5111115 & 458752) | (i5111115 & 3670016) | (i5111115 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                } else {
                    iVarG.B();
                    if ((i14 & 1) != 0) {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    } else {
                        if (i55 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        } else {
                            fVar2 = fVar;
                        }
                        if (i18 != 0) {
                            jE = w1.f4564b.e();
                        } else {
                            jE = j11;
                        }
                        if (i21 != 0) {
                            jA = w.f74257b.a();
                        } else {
                            jA = j12;
                        }
                        if (i23 != 0) {
                            qVar2 = null;
                        } else {
                            qVar2 = qVar;
                        }
                        if (i25 != 0) {
                            uVar2 = null;
                        } else {
                            uVar2 = uVar;
                        }
                        if (i27 != 0) {
                            iVar4 = null;
                        } else {
                            iVar4 = iVar;
                        }
                        if (i29 != 0) {
                            jA2 = w.f74257b.a();
                        } else {
                            jA2 = j13;
                        }
                        if (i32 != 0) {
                            iVar5 = null;
                        } else {
                            iVar5 = iVar2;
                        }
                        if (i34 == 0) {
                        }
                        if (i36 != 0) {
                            jA3 = w.f74257b.a();
                        } else {
                            jA3 = j14;
                        }
                        if (i39 != 0) {
                            iA = p.f6143a.a();
                        } else {
                            iA = i11;
                        }
                        if (i42 != 0) {
                            z12 = true;
                        } else {
                            z12 = z11;
                        }
                        if (i44 != 0) {
                            i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        } else {
                            i48 = i12;
                        }
                        if (i45 == 0) {
                        }
                        if (i46 != 0) {
                            function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                    invoke2(a0Var);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(a0 it) {
                                    Intrinsics.g(it, "it");
                                }
                            };
                        } else {
                            function2 = function1;
                        }
                        iVar6 = iVar5;
                        if ((i16 & 65536) != 0) {
                            i50 = i41 & (-3670017);
                            e0Var2 = (e0) iVarG.l(f3195a);
                            iVar5 = iVar6;
                        } else {
                            i50 = i41;
                            e0Var2 = e0Var;
                        }
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                    }
                    iVarG.x(79582822);
                    aVar = w1.f4564b;
                    if (jE != aVar.e()) {
                        j15 = jE;
                    } else {
                        jH = e0Var2.h();
                        if (jH == aVar.e()) {
                            jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                        }
                        j15 = jH;
                    }
                    iVarG.P();
                    int i5111116 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                    int i5111117 = i50 << 9;
                    BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5111116 | (i5111117 & 57344) | (i5111117 & 458752) | (i5111117 & 3670016) | (i5111117 & 29360128), 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    i51 = i48;
                    hVar3 = hVar2;
                    qVar3 = qVar2;
                    iVar7 = iVar5;
                    j16 = jA3;
                    z13 = z12;
                    j17 = jE;
                    iVar8 = iVar4;
                    j18 = jA2;
                    e0Var3 = e0Var2;
                    function3 = function2;
                    uVar3 = uVar2;
                    i52 = i49;
                    i53 = iA;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ == null) {
                    return;
                }
                final androidx.compose.ui.f fVar15 = fVar2;
                final long j1111 = jA;
                final int i612 = i52;
                final Function1<? super a0, Unit> function16 = function3;
                final e0 e0Var16 = e0Var3;
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i613) {
                        TextKt.a(text, fVar15, j17, j1111, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i612, function16, e0Var16, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                    }
                });
            }
            i41 |= 24576;
            i46 = i16 & 32768;
            if (i46 != 0) {
                i41 |= 196608;
            } else if ((i15 & 458752) == 0) {
                if (iVarG.A(function1)) {
                    i47 = 131072;
                } else {
                    i47 = 65536;
                }
                i41 |= i47;
            }
            if ((i15 & 3670016) != 0) {
                if ((i16 & 65536) == 0) {
                    i54 = 524288;
                } else {
                    i54 = 524288;
                }
                i41 |= i54;
            }
            if ((i17 & 1533916891) != 306783378) {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i5111118 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i5111119 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i5111118 | (i5111119 & 57344) | (i5111119 & 458752) | (i5111119 & 3670016) | (i5111119 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            } else {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i51111110 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i51111111 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51111110 | (i51111111 & 57344) | (i51111111 & 458752) | (i51111111 & 3670016) | (i51111111 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ == null) {
                return;
            }
            final androidx.compose.ui.f fVar16 = fVar2;
            final long j1112 = jA;
            final int i613 = i52;
            final Function1<? super a0, Unit> function17 = function3;
            final e0 e0Var17 = e0Var3;
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                    invoke(iVar9, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar9, int i614) {
                    TextKt.a(text, fVar16, j17, j1112, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i613, function17, e0Var17, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                }
            });
        }
        i41 |= 3072;
        i45 = i16 & 16384;
        if (i45 != 0) {
            if ((i15 & 57344) == 0) {
                i41 |= iVarG.c(i13) ? 16384 : 8192;
            }
            i46 = i16 & 32768;
            if (i46 != 0) {
                i41 |= 196608;
            } else if ((i15 & 458752) == 0) {
                if (iVarG.A(function1)) {
                    i47 = 131072;
                } else {
                    i47 = 65536;
                }
                i41 |= i47;
            }
            if ((i15 & 3670016) != 0) {
                if ((i16 & 65536) == 0) {
                    i54 = 524288;
                } else {
                    i54 = 524288;
                }
                i41 |= i54;
            }
            if ((i17 & 1533916891) != 306783378) {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i51111112 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i51111113 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51111112 | (i51111113 & 57344) | (i51111113 & 458752) | (i51111113 & 3670016) | (i51111113 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            } else {
                iVarG.B();
                if ((i14 & 1) != 0) {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                } else {
                    if (i55 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    } else {
                        fVar2 = fVar;
                    }
                    if (i18 != 0) {
                        jE = w1.f4564b.e();
                    } else {
                        jE = j11;
                    }
                    if (i21 != 0) {
                        jA = w.f74257b.a();
                    } else {
                        jA = j12;
                    }
                    if (i23 != 0) {
                        qVar2 = null;
                    } else {
                        qVar2 = qVar;
                    }
                    if (i25 != 0) {
                        uVar2 = null;
                    } else {
                        uVar2 = uVar;
                    }
                    if (i27 != 0) {
                        iVar4 = null;
                    } else {
                        iVar4 = iVar;
                    }
                    if (i29 != 0) {
                        jA2 = w.f74257b.a();
                    } else {
                        jA2 = j13;
                    }
                    if (i32 != 0) {
                        iVar5 = null;
                    } else {
                        iVar5 = iVar2;
                    }
                    if (i34 == 0) {
                    }
                    if (i36 != 0) {
                        jA3 = w.f74257b.a();
                    } else {
                        jA3 = j14;
                    }
                    if (i39 != 0) {
                        iA = p.f6143a.a();
                    } else {
                        iA = i11;
                    }
                    if (i42 != 0) {
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (i44 != 0) {
                        i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i48 = i12;
                    }
                    if (i45 == 0) {
                    }
                    if (i46 != 0) {
                        function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                                invoke2(a0Var);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a0 it) {
                                Intrinsics.g(it, "it");
                            }
                        };
                    } else {
                        function2 = function1;
                    }
                    iVar6 = iVar5;
                    if ((i16 & 65536) != 0) {
                        i50 = i41 & (-3670017);
                        e0Var2 = (e0) iVarG.l(f3195a);
                        iVar5 = iVar6;
                    } else {
                        i50 = i41;
                        e0Var2 = e0Var;
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
                }
                iVarG.x(79582822);
                aVar = w1.f4564b;
                if (jE != aVar.e()) {
                    j15 = jE;
                } else {
                    jH = e0Var2.h();
                    if (jH == aVar.e()) {
                        jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                    }
                    j15 = jH;
                }
                iVarG.P();
                int i51111114 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
                int i51111115 = i50 << 9;
                BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51111114 | (i51111115 & 57344) | (i51111115 & 458752) | (i51111115 & 3670016) | (i51111115 & 29360128), 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                i51 = i48;
                hVar3 = hVar2;
                qVar3 = qVar2;
                iVar7 = iVar5;
                j16 = jA3;
                z13 = z12;
                j17 = jE;
                iVar8 = iVar4;
                j18 = jA2;
                e0Var3 = e0Var2;
                function3 = function2;
                uVar3 = uVar2;
                i52 = i49;
                i53 = iA;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ == null) {
                return;
            }
            final androidx.compose.ui.f fVar17 = fVar2;
            final long j1113 = jA;
            final int i614 = i52;
            final Function1<? super a0, Unit> function18 = function3;
            final e0 e0Var18 = e0Var3;
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                    invoke(iVar9, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar9, int i615) {
                    TextKt.a(text, fVar17, j17, j1113, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i614, function18, e0Var18, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
                }
            });
        }
        i41 |= 24576;
        i46 = i16 & 32768;
        if (i46 != 0) {
            i41 |= 196608;
        } else if ((i15 & 458752) == 0) {
            if (iVarG.A(function1)) {
                i47 = 131072;
            } else {
                i47 = 65536;
            }
            i41 |= i47;
        }
        if ((i15 & 3670016) != 0) {
            if ((i16 & 65536) == 0) {
                i54 = 524288;
            } else {
                i54 = 524288;
            }
            i41 |= i54;
        }
        if ((i17 & 1533916891) != 306783378) {
            iVarG.B();
            if ((i14 & 1) != 0) {
                if (i55 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i18 != 0) {
                    jE = w1.f4564b.e();
                } else {
                    jE = j11;
                }
                if (i21 != 0) {
                    jA = w.f74257b.a();
                } else {
                    jA = j12;
                }
                if (i23 != 0) {
                    qVar2 = null;
                } else {
                    qVar2 = qVar;
                }
                if (i25 != 0) {
                    uVar2 = null;
                } else {
                    uVar2 = uVar;
                }
                if (i27 != 0) {
                    iVar4 = null;
                } else {
                    iVar4 = iVar;
                }
                if (i29 != 0) {
                    jA2 = w.f74257b.a();
                } else {
                    jA2 = j13;
                }
                if (i32 != 0) {
                    iVar5 = null;
                } else {
                    iVar5 = iVar2;
                }
                if (i34 == 0) {
                }
                if (i36 != 0) {
                    jA3 = w.f74257b.a();
                } else {
                    jA3 = j14;
                }
                if (i39 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i11;
                }
                if (i42 != 0) {
                    z12 = true;
                } else {
                    z12 = z11;
                }
                if (i44 != 0) {
                    i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i48 = i12;
                }
                if (i45 == 0) {
                }
                if (i46 != 0) {
                    function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                            invoke2(a0Var);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(a0 it) {
                            Intrinsics.g(it, "it");
                        }
                    };
                } else {
                    function2 = function1;
                }
                iVar6 = iVar5;
                if ((i16 & 65536) != 0) {
                    i50 = i41 & (-3670017);
                    e0Var2 = (e0) iVarG.l(f3195a);
                    iVar5 = iVar6;
                } else {
                    i50 = i41;
                    e0Var2 = e0Var;
                }
            } else {
                if (i55 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i18 != 0) {
                    jE = w1.f4564b.e();
                } else {
                    jE = j11;
                }
                if (i21 != 0) {
                    jA = w.f74257b.a();
                } else {
                    jA = j12;
                }
                if (i23 != 0) {
                    qVar2 = null;
                } else {
                    qVar2 = qVar;
                }
                if (i25 != 0) {
                    uVar2 = null;
                } else {
                    uVar2 = uVar;
                }
                if (i27 != 0) {
                    iVar4 = null;
                } else {
                    iVar4 = iVar;
                }
                if (i29 != 0) {
                    jA2 = w.f74257b.a();
                } else {
                    jA2 = j13;
                }
                if (i32 != 0) {
                    iVar5 = null;
                } else {
                    iVar5 = iVar2;
                }
                if (i34 == 0) {
                }
                if (i36 != 0) {
                    jA3 = w.f74257b.a();
                } else {
                    jA3 = j14;
                }
                if (i39 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i11;
                }
                if (i42 != 0) {
                    z12 = true;
                } else {
                    z12 = z11;
                }
                if (i44 != 0) {
                    i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i48 = i12;
                }
                if (i45 == 0) {
                }
                if (i46 != 0) {
                    function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                            invoke2(a0Var);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(a0 it) {
                            Intrinsics.g(it, "it");
                        }
                    };
                } else {
                    function2 = function1;
                }
                iVar6 = iVar5;
                if ((i16 & 65536) != 0) {
                    i50 = i41 & (-3670017);
                    e0Var2 = (e0) iVarG.l(f3195a);
                    iVar5 = iVar6;
                } else {
                    i50 = i41;
                    e0Var2 = e0Var;
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
            }
            iVarG.x(79582822);
            aVar = w1.f4564b;
            if (jE != aVar.e()) {
                j15 = jE;
            } else {
                jH = e0Var2.h();
                if (jH == aVar.e()) {
                    jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                }
                j15 = jH;
            }
            iVarG.P();
            int i51111116 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
            int i51111117 = i50 << 9;
            BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51111116 | (i51111117 & 57344) | (i51111117 & 458752) | (i51111117 & 3670016) | (i51111117 & 29360128), 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            i51 = i48;
            hVar3 = hVar2;
            qVar3 = qVar2;
            iVar7 = iVar5;
            j16 = jA3;
            z13 = z12;
            j17 = jE;
            iVar8 = iVar4;
            j18 = jA2;
            e0Var3 = e0Var2;
            function3 = function2;
            uVar3 = uVar2;
            i52 = i49;
            i53 = iA;
        } else {
            iVarG.B();
            if ((i14 & 1) != 0) {
                if (i55 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i18 != 0) {
                    jE = w1.f4564b.e();
                } else {
                    jE = j11;
                }
                if (i21 != 0) {
                    jA = w.f74257b.a();
                } else {
                    jA = j12;
                }
                if (i23 != 0) {
                    qVar2 = null;
                } else {
                    qVar2 = qVar;
                }
                if (i25 != 0) {
                    uVar2 = null;
                } else {
                    uVar2 = uVar;
                }
                if (i27 != 0) {
                    iVar4 = null;
                } else {
                    iVar4 = iVar;
                }
                if (i29 != 0) {
                    jA2 = w.f74257b.a();
                } else {
                    jA2 = j13;
                }
                if (i32 != 0) {
                    iVar5 = null;
                } else {
                    iVar5 = iVar2;
                }
                if (i34 == 0) {
                }
                if (i36 != 0) {
                    jA3 = w.f74257b.a();
                } else {
                    jA3 = j14;
                }
                if (i39 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i11;
                }
                if (i42 != 0) {
                    z12 = true;
                } else {
                    z12 = z11;
                }
                if (i44 != 0) {
                    i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i48 = i12;
                }
                if (i45 == 0) {
                }
                if (i46 != 0) {
                    function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                            invoke2(a0Var);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(a0 it) {
                            Intrinsics.g(it, "it");
                        }
                    };
                } else {
                    function2 = function1;
                }
                iVar6 = iVar5;
                if ((i16 & 65536) != 0) {
                    i50 = i41 & (-3670017);
                    e0Var2 = (e0) iVarG.l(f3195a);
                    iVar5 = iVar6;
                } else {
                    i50 = i41;
                    e0Var2 = e0Var;
                }
            } else {
                if (i55 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                } else {
                    fVar2 = fVar;
                }
                if (i18 != 0) {
                    jE = w1.f4564b.e();
                } else {
                    jE = j11;
                }
                if (i21 != 0) {
                    jA = w.f74257b.a();
                } else {
                    jA = j12;
                }
                if (i23 != 0) {
                    qVar2 = null;
                } else {
                    qVar2 = qVar;
                }
                if (i25 != 0) {
                    uVar2 = null;
                } else {
                    uVar2 = uVar;
                }
                if (i27 != 0) {
                    iVar4 = null;
                } else {
                    iVar4 = iVar;
                }
                if (i29 != 0) {
                    jA2 = w.f74257b.a();
                } else {
                    jA2 = j13;
                }
                if (i32 != 0) {
                    iVar5 = null;
                } else {
                    iVar5 = iVar2;
                }
                if (i34 == 0) {
                }
                if (i36 != 0) {
                    jA3 = w.f74257b.a();
                } else {
                    jA3 = j14;
                }
                if (i39 != 0) {
                    iA = p.f6143a.a();
                } else {
                    iA = i11;
                }
                if (i42 != 0) {
                    z12 = true;
                } else {
                    z12 = z11;
                }
                if (i44 != 0) {
                    i48 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i48 = i12;
                }
                if (i45 == 0) {
                }
                if (i46 != 0) {
                    function2 = new Function1<a0, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(a0 a0Var) {
                            invoke2(a0Var);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(a0 it) {
                            Intrinsics.g(it, "it");
                        }
                    };
                } else {
                    function2 = function1;
                }
                iVar6 = iVar5;
                if ((i16 & 65536) != 0) {
                    i50 = i41 & (-3670017);
                    e0Var2 = (e0) iVarG.l(f3195a);
                    iVar5 = iVar6;
                } else {
                    i50 = i41;
                    e0Var2 = e0Var;
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-2055108902, i17, i50, "androidx.compose.material3.Text (Text.kt:91)");
            }
            iVarG.x(79582822);
            aVar = w1.f4564b;
            if (jE != aVar.e()) {
                j15 = jE;
            } else {
                jH = e0Var2.h();
                if (jH == aVar.e()) {
                    jH = ((w1) iVarG.l(ContentColorKt.a())).u();
                }
                j15 = jH;
            }
            iVarG.P();
            int i51111118 = (i17 & 112) | (i17 & 14) | ((i50 >> 6) & 7168);
            int i51111119 = i50 << 9;
            BasicTextKt.a(text, fVar2, e0Var2.I(new e0(j15, jA, uVar2, qVar2, (r) null, iVar4, (String) null, jA2, (androidx.compose.ui.text.style.a) null, (androidx.compose.ui.text.style.m) null, (p2.i) null, 0L, iVar5, (b5) null, hVar2, (androidx.compose.ui.text.style.j) null, jA3, (n) null, (x) null, (androidx.compose.ui.text.style.g) null, (androidx.compose.ui.text.style.e) null, (androidx.compose.ui.text.style.d) null, 4108112, (DefaultConstructorMarker) null)), function2, iA, z12, i48, i49, iVarG, i51111118 | (i51111119 & 57344) | (i51111119 & 458752) | (i51111119 & 3670016) | (i51111119 & 29360128), 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            i51 = i48;
            hVar3 = hVar2;
            qVar3 = qVar2;
            iVar7 = iVar5;
            j16 = jA3;
            z13 = z12;
            j17 = jE;
            iVar8 = iVar4;
            j18 = jA2;
            e0Var3 = e0Var2;
            function3 = function2;
            uVar3 = uVar2;
            i52 = i49;
            i53 = iA;
        }
        g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        final androidx.compose.ui.f fVar18 = fVar2;
        final long j1114 = jA;
        final int i615 = i52;
        final Function1<? super a0, Unit> function19 = function3;
        final e0 e0Var19 = e0Var3;
        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                invoke(iVar9, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.runtime.i iVar9, int i616) {
                TextKt.a(text, fVar18, j17, j1114, qVar3, uVar3, iVar8, j18, iVar7, hVar3, j16, i53, z13, i51, i615, function19, e0Var19, iVar9, v1.a(i14 | 1), v1.a(i15), i16);
            }
        });
    }
}
