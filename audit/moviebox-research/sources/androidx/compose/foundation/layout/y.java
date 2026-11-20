package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class y {
    public static final androidx.compose.ui.layout.w a(x xVar, int i11, int i12, int i13, int i14, int i15, androidx.compose.ui.layout.y yVar, List<? extends androidx.compose.ui.layout.t> list, k0[] k0VarArr, int i16, int i17, int[] iArr, int i18) throws Throwable {
        int[] iArr2;
        long j11;
        long j12;
        String str;
        String str2;
        int i19;
        Integer num;
        int i21;
        int iK;
        int i22;
        String str3;
        int i23;
        float f11;
        String str4;
        long j13;
        int i24;
        int i25;
        float f12;
        long j14;
        String str5;
        int i26;
        int i27;
        float f13;
        String str6;
        long j15;
        int i28;
        String str7;
        String str8;
        int i29;
        int i31;
        int i32;
        int[] iArr3;
        List<? extends androidx.compose.ui.layout.t> list2 = list;
        int i33 = i17;
        int i34 = i33 - i16;
        int i35 = 0;
        int i36 = i16;
        int[] iArr4 = new int[i34];
        long j16 = i15;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        float f14 = 0.0f;
        boolean z11 = false;
        while (true) {
            int iD = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i36 >= i33) {
                break;
            }
            int i41 = i40;
            androidx.compose.ui.layout.t tVar = list2.get(i36);
            z zVarC = v.c(tVar);
            float fE = v.e(zVarC);
            z11 = z11 || v.f(zVarC);
            if (fE > 0.0f) {
                float f15 = f14 + fE;
                i39++;
                i36 = i36;
                j16 = j16;
                iArr3 = iArr4;
                i34 = i34;
                f14 = f15;
            } else {
                if (i14 != Integer.MAX_VALUE && zVarC != null) {
                    zVarC.c();
                }
                int i42 = i13 - i38;
                k0 k0VarL = k0VarArr[i36];
                if (k0VarL == null) {
                    if (i13 != Integer.MAX_VALUE) {
                        iD = kotlin.ranges.a.d(i42, i35);
                    }
                    k0VarL = tVar.L(w.a(xVar, 0, 0, iD, i14, false, 16, null));
                }
                k0 k0Var = k0VarL;
                int iE = xVar.e(k0Var);
                int iF = xVar.f(k0Var);
                iArr3 = iArr4;
                iArr3[i36 - i16] = iE;
                int iMin = Math.min(i15, kotlin.ranges.a.d(i42 - iE, 0));
                i38 = iE + iMin + i38;
                int iMax = Math.max(i41, iF);
                k0VarArr[i36] = k0Var;
                i41 = iMax;
                i37 = iMin;
                i39 = i39;
            }
            i36++;
            iArr4 = iArr3;
            f14 = f14;
            i34 = i34;
            i40 = i41;
            j16 = j16;
            i35 = 0;
        }
        int i43 = i38;
        int i44 = i40;
        long j17 = j16;
        int[] iArr5 = iArr4;
        int i45 = i34;
        float f16 = f14;
        int i46 = i39;
        if (i46 == 0) {
            i22 = i43 - i37;
            iArr2 = iArr5;
            i19 = i11;
            i21 = i44;
            num = null;
            iK = 0;
        } else {
            int i47 = i13 != Integer.MAX_VALUE ? i13 : i11;
            iArr2 = iArr5;
            long j18 = ((long) (i46 - 1)) * j17;
            long jE = kotlin.ranges.a.e(((long) (i47 - i43)) - j18, 0L);
            float f17 = jE / f16;
            int i48 = i16;
            long jRound = jE;
            while (true) {
                j11 = jE;
                j12 = j18;
                str = "arrangementSpacingPx ";
                str2 = "targetSpace ";
                if (i48 >= i33) {
                    break;
                }
                float fE2 = v.e(v.c(list2.get(i48)));
                float f18 = f17 * fE2;
                try {
                    jRound -= (long) Math.round(f18);
                    i48++;
                    list2 = list;
                    i33 = i17;
                    jE = j11;
                    j18 = j12;
                } catch (IllegalArgumentException e11) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i13 + "mainAxisMin " + i11 + "targetSpace " + i47 + "arrangementSpacingPx " + j17 + "weightChildrenCount " + i46 + "fixedSpace " + i43 + "arrangementSpacingTotal " + j12 + "remainingToTarget " + j11 + "totalWeight " + f16 + "weightUnitSpace " + f17 + "itemWeight " + fE2 + "weightedSize " + f18).initCause(e11);
                }
            }
            i19 = i11;
            float f19 = f16;
            String str9 = "weightedSize ";
            String str10 = "weightUnitSpace ";
            String str11 = "totalWeight ";
            long j19 = j11;
            String str12 = "remainingToTarget ";
            long j21 = j12;
            String str13 = "arrangementSpacingTotal ";
            long j22 = j17;
            int i49 = i44;
            int i50 = 0;
            int i51 = i16;
            while (i51 < i17) {
                if (k0VarArr[i51] == null) {
                    androidx.compose.ui.layout.t tVar2 = list.get(i51);
                    z zVarC2 = v.c(tVar2);
                    float fE3 = v.e(zVarC2);
                    String str14 = str;
                    int i52 = i47;
                    if (i14 != Integer.MAX_VALUE && zVarC2 != null) {
                        zVarC2.c();
                    }
                    if (fE3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int iB = a20.b.b(jRound);
                    String str15 = str2;
                    jRound -= (long) iB;
                    float f21 = f17 * fE3;
                    int iMax2 = Math.max(0, Math.round(f21) + iB);
                    try {
                        j15 = j21;
                        str7 = str14;
                        i29 = iMax2;
                        str8 = str15;
                        i28 = i52;
                        i26 = i46;
                        i27 = i43;
                        str6 = str9;
                        f12 = f19;
                        j14 = j22;
                        f13 = f17;
                        try {
                            k0 k0VarL2 = tVar2.L(xVar.a((!v.b(zVarC2) || iMax2 == Integer.MAX_VALUE) ? 0 : iMax2, 0, i29, i14, true));
                            int iE2 = xVar.e(k0VarL2);
                            int iF2 = xVar.f(k0VarL2);
                            iArr2[i51 - i16] = iE2;
                            i50 += iE2;
                            int iMax3 = Math.max(i49, iF2);
                            k0VarArr[i51] = k0VarL2;
                            i49 = iMax3;
                            str4 = str6;
                            f11 = f13;
                            j13 = j15;
                            str3 = str7;
                            str5 = str8;
                            i24 = i28;
                            i25 = i26;
                            i23 = i27;
                        } catch (IllegalArgumentException e12) {
                            e = e12;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i13 + "mainAxisMin " + i19 + str8 + i28 + str7 + j14 + "weightChildrenCount " + i26 + "fixedSpace " + i27 + str13 + j15 + str12 + j19 + str11 + f12 + str10 + f13 + "weight " + fE3 + str6 + f21 + "crossAxisDesiredSize " + ((Object) null) + "remainderUnit " + iB + "childMainAxisSize " + i29).initCause(e);
                        }
                    } catch (IllegalArgumentException e13) {
                        e = e13;
                        i26 = i46;
                        i27 = i43;
                        f13 = f17;
                        str6 = str9;
                        j15 = j21;
                        i28 = i52;
                        str7 = str14;
                        str8 = str15;
                        i29 = iMax2;
                        f12 = f19;
                        j14 = j22;
                    }
                } else {
                    str3 = str;
                    i23 = i43;
                    f11 = f17;
                    str4 = str9;
                    j13 = j21;
                    i24 = i47;
                    i25 = i46;
                    f12 = f19;
                    j14 = j22;
                    str5 = str2;
                }
                i51++;
                str2 = str5;
                i47 = i24;
                str = str3;
                i46 = i25;
                i43 = i23;
                j19 = j19;
                f17 = f11;
                str10 = str10;
                str11 = str11;
                str12 = str12;
                str13 = str13;
                j22 = j14;
                f19 = f12;
                j21 = j13;
                str9 = str4;
            }
            int i53 = i43;
            num = null;
            i21 = i49;
            iK = kotlin.ranges.a.k((int) (((long) i50) + j21), 0, i13 - i53);
            i22 = i53;
        }
        if (z11) {
            int iMax4 = 0;
            int iMax5 = 0;
            for (int i54 = i16; i54 < i17; i54++) {
                k0 k0Var2 = k0VarArr[i54];
                Intrinsics.d(k0Var2);
                m mVarA = v.a(v.d(k0Var2));
                Integer numB = mVarA != null ? mVarA.b(k0Var2) : num;
                if (numB != null) {
                    int iIntValue = numB.intValue();
                    int iF3 = xVar.f(k0Var2);
                    iMax4 = Math.max(iMax4, iIntValue != Integer.MIN_VALUE ? numB.intValue() : 0);
                    if (iIntValue == Integer.MIN_VALUE) {
                        iIntValue = iF3;
                    }
                    iMax5 = Math.max(iMax5, iF3 - iIntValue);
                }
            }
            i31 = iMax5;
            i32 = iMax4;
        } else {
            i31 = 0;
            i32 = 0;
        }
        int iMax6 = Math.max(kotlin.ranges.a.d(i22 + iK, 0), i19);
        int iMax7 = Math.max(i21, Math.max(i12, i31 + i32));
        int[] iArr6 = new int[i45];
        for (int i55 = 0; i55 < i45; i55++) {
            iArr6[i55] = 0;
        }
        xVar.b(iMax6, iArr2, iArr6, yVar);
        return xVar.d(k0VarArr, yVar, i32, iArr6, iMax6, iMax7, iArr, i18, i16, i17);
    }
}
