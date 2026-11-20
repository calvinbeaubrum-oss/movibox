package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.e0;
import androidx.compose.runtime.i1;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlinx.coroutines.k0;

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
public final class LazyListMeasureKt {
    public static final List<n> a(List<n> list, List<n> list2, List<n> list3, int i11, int i12, int i13, int i14, int i15, boolean z11, androidx.compose.foundation.layout.b.k kVar, androidx.compose.foundation.layout.b.d dVar, boolean z12, q2.e eVar) {
        int i16 = z11 ? i12 : i11;
        boolean z13 = i13 < Math.min(i16, i14);
        if (z13 && i15 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset".toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z13) {
            int size = list2.size();
            int iH = i15;
            for (int i17 = 0; i17 < size; i17++) {
                n nVar = list2.get(i17);
                iH -= nVar.h();
                nVar.r(iH, i11, i12);
                arrayList.add(nVar);
            }
            int size2 = list.size();
            int iH2 = i15;
            for (int i18 = 0; i18 < size2; i18++) {
                n nVar2 = list.get(i18);
                nVar2.r(iH2, i11, i12);
                arrayList.add(nVar2);
                iH2 += nVar2.h();
            }
            int size3 = list3.size();
            for (int i19 = 0; i19 < size3; i19++) {
                n nVar3 = list3.get(i19);
                nVar3.r(iH2, i11, i12);
                arrayList.add(nVar3);
                iH2 += nVar3.h();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items".toString());
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i21 = 0; i21 < size4; i21++) {
                iArr[i21] = list.get(b(i21, z12, size4)).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i22 = 0; i22 < size4; i22++) {
                iArr2[i22] = 0;
            }
            if (z11) {
                if (kVar == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                }
                kVar.b(eVar, i16, iArr, iArr2);
            } else {
                if (dVar == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                }
                dVar.c(eVar, i16, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression intProgressionQ = kotlin.collections.d.Q(iArr2);
            if (z12) {
                intProgressionQ = kotlin.ranges.a.p(intProgressionQ);
            }
            int iG = intProgressionQ.g();
            int i23 = intProgressionQ.i();
            int iR = intProgressionQ.r();
            if ((iR > 0 && iG <= i23) || (iR < 0 && i23 <= iG)) {
                while (true) {
                    int size5 = iArr2[iG];
                    n nVar4 = list.get(b(iG, z12, size4));
                    if (z12) {
                        size5 = (i16 - size5) - nVar4.getSize();
                    }
                    nVar4.r(size5, i11, i12);
                    arrayList.add(nVar4);
                    if (iG == i23) {
                        break;
                    }
                    iG += iR;
                }
            }
        }
        return arrayList;
    }

    public static final int b(int i11, boolean z11, int i12) {
        return !z11 ? i11 : (i12 - i11) - 1;
    }

    public static final List<n> c(List<n> list, o oVar, int i11, int i12, List<Integer> list2, float f11, boolean z11, l lVar) {
        ArrayList arrayList;
        j jVar;
        n nVar;
        n nVar2;
        int iH;
        n nVar3;
        int index;
        int iMin;
        n nVar4;
        n nVar5;
        int i13 = i11 - 1;
        int iMin2 = Math.min(((n) CollectionsKt___CollectionsKt.q0(list)).getIndex() + i12, i13);
        int index2 = ((n) CollectionsKt___CollectionsKt.q0(list)).getIndex() + 1;
        if (index2 <= iMin2) {
            ArrayList arrayList2 = null;
            while (true) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList = arrayList2;
                arrayList.add(o.e(oVar, index2, 0L, 2, null));
                if (index2 == iMin2) {
                    break;
                }
                index2++;
                arrayList2 = arrayList;
            }
        } else {
            arrayList = null;
        }
        if (z11 && lVar != null && (!lVar.h().isEmpty())) {
            List<j> listH = lVar.h();
            int size = listH.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    jVar = null;
                    break;
                }
                if (listH.get(size).getIndex() > iMin2 && (size == 0 || listH.get(size - 1).getIndex() <= iMin2)) {
                    jVar = listH.get(size);
                    break;
                }
            }
            j jVar2 = (j) CollectionsKt___CollectionsKt.q0(lVar.h());
            if (jVar != null && (index = jVar.getIndex()) <= (iMin = Math.min(jVar2.getIndex(), i13))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i14 = 0;
                        while (true) {
                            if (i14 >= size2) {
                                nVar5 = null;
                                break;
                            }
                            nVar5 = arrayList.get(i14);
                            if (nVar5.getIndex() == index) {
                                break;
                            }
                            i14++;
                        }
                        nVar4 = nVar5;
                    } else {
                        nVar4 = null;
                    }
                    if (nVar4 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(o.e(oVar, index, 0L, 2, null));
                    }
                    if (index == iMin) {
                        break;
                    }
                    index++;
                }
            }
            float fC = ((lVar.c() - jVar2.g()) - jVar2.getSize()) - f11;
            if (fC > 0.0f) {
                int index3 = jVar2.getIndex() + 1;
                int i15 = 0;
                while (index3 < i11 && i15 < fC) {
                    if (index3 <= iMin2) {
                        int size3 = list.size();
                        int i16 = 0;
                        while (true) {
                            if (i16 >= size3) {
                                nVar3 = null;
                                break;
                            }
                            nVar3 = list.get(i16);
                            if (nVar3.getIndex() == index3) {
                                break;
                            }
                            i16++;
                        }
                        nVar = nVar3;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i17 = 0;
                        while (true) {
                            if (i17 >= size4) {
                                nVar2 = null;
                                break;
                            }
                            nVar2 = arrayList.get(i17);
                            if (nVar2.getIndex() == index3) {
                                break;
                            }
                            i17++;
                        }
                        nVar = nVar2;
                    } else {
                        nVar = null;
                    }
                    if (nVar != null) {
                        index3++;
                        iH = nVar.h();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(o.e(oVar, index3, 0L, 2, null));
                        index3++;
                        iH = ((n) CollectionsKt___CollectionsKt.q0(arrayList)).h();
                    }
                    i15 += iH;
                }
            }
        }
        if (arrayList != null && ((n) CollectionsKt___CollectionsKt.q0(arrayList)).getIndex() > iMin2) {
            iMin2 = ((n) CollectionsKt___CollectionsKt.q0(arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i18 = 0; i18 < size5; i18++) {
            int iIntValue = list2.get(i18).intValue();
            if (iIntValue > iMin2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(o.e(oVar, iIntValue, 0L, 2, null));
            }
        }
        return arrayList == null ? kotlin.collections.g.l() : arrayList;
    }

    public static final List<n> d(int i11, o oVar, int i12, List<Integer> list) {
        int iMax = Math.max(0, i11 - i12);
        int i13 = i11 - 1;
        ArrayList arrayList = null;
        if (iMax <= i13) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(o.e(oVar, i13, 0L, 2, null));
                if (i13 == iMax) {
                    break;
                }
                i13--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i14 = size - 1;
                int iIntValue = list.get(size).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(o.e(oVar, iIntValue, 0L, 2, null));
                }
                if (i14 < 0) {
                    break;
                }
                size = i14;
            }
        }
        return arrayList == null ? kotlin.collections.g.l() : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:132:0x037c  */
    /* JADX WARN: Code duplicated, block: B:147:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:148:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:150:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:159:0x040e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0413  */
    public static final m e(int i11, o oVar, int i12, int i13, int i14, int i15, int i16, int i17, float f11, long j11, boolean z11, List<Integer> list, androidx.compose.foundation.layout.b.k kVar, androidx.compose.foundation.layout.b.d dVar, boolean z12, q2.e eVar, LazyLayoutItemAnimator<n> lazyLayoutItemAnimator, int i18, List<Integer> list2, boolean z13, boolean z14, l lVar, k0 k0Var, final i1<Unit> i1Var, c4 c4Var, Function3<? super Integer, ? super Integer, ? super Function1<? super androidx.compose.ui.layout.k0.a, Unit>, ? extends androidx.compose.ui.layout.w> function3) {
        int i19;
        int i21;
        int iMax;
        int i22;
        int i23;
        int i24;
        int i25;
        n nVar;
        int i26;
        int iH;
        int i27;
        final boolean z15;
        boolean z16;
        int size;
        int i28;
        List<n> list3;
        n nVar2;
        Orientation orientation;
        int i29;
        int i31;
        if (i13 < 0) {
            throw new IllegalArgumentException("invalid beforeContentPadding".toString());
        }
        if (i14 < 0) {
            throw new IllegalArgumentException("invalid afterContentPadding".toString());
        }
        if (i11 <= 0) {
            int iN = q2.b.n(j11);
            int iM = q2.b.m(j11);
            lazyLayoutItemAnimator.m(0, iN, iM, new ArrayList(), oVar.g(), oVar, z11, z14, 1, z13, 0, 0, k0Var, c4Var);
            if (!z14) {
                long jI = lazyLayoutItemAnimator.i();
                if (!q2.t.e(jI, q2.t.f74253b.a())) {
                    iN = q2.c.i(j11, q2.t.g(jI));
                    iM = q2.c.h(j11, q2.t.f(jI));
                }
            }
            return new m(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iN), Integer.valueOf(iM), new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.compose.ui.layout.k0.a aVar) {
                }
            }), 0.0f, false, k0Var, eVar, oVar.f(), kotlin.collections.g.l(), -i13, i12 + i14, 0, z12, z11 ? Orientation.Vertical : Orientation.Horizontal, i14, i15, null);
        }
        int i32 = 0;
        int i33 = i16;
        if (i33 >= i11) {
            i33 = i11 - 1;
            i19 = 0;
        } else {
            i19 = i17;
        }
        int iRound = Math.round(f11);
        int i34 = i19 - iRound;
        if (i33 == 0 && i34 < 0) {
            iRound += i34;
            i34 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i35 = -i13;
        int i36 = (i15 < 0 ? i15 : 0) + i35;
        int iH2 = i34 + i36;
        int iMax2 = 0;
        while (iH2 < 0 && i33 > 0) {
            i33--;
            n nVarE = o.e(oVar, i33, 0L, 2, null);
            arrayDeque.add(i32, nVarE);
            iMax2 = Math.max(iMax2, nVarE.m());
            iH2 += nVarE.h();
            i32 = 0;
        }
        if (iH2 < i36) {
            iRound += iH2;
            iH2 = i36;
        }
        int i37 = iH2 - i36;
        int i38 = i12 + i14;
        int i39 = i33;
        int iD = kotlin.ranges.a.d(i38, 0);
        int i40 = i39;
        int i41 = iMax2;
        int iH3 = -i37;
        int i42 = 0;
        boolean z17 = false;
        while (i42 < arrayDeque.size()) {
            if (iH3 >= iD) {
                arrayDeque.remove(i42);
                z17 = true;
            } else {
                i40++;
                iH3 += ((n) arrayDeque.get(i42)).h();
                i42++;
            }
        }
        int iH4 = i37;
        int iH5 = iH3;
        boolean z18 = z17;
        int i43 = i40;
        int iMax3 = i41;
        while (i43 < i11 && (iH5 < iD || iH5 <= 0 || arrayDeque.isEmpty())) {
            int i44 = iD;
            n nVarE2 = o.e(oVar, i43, 0L, 2, null);
            iH5 += nVarE2.h();
            if (iH5 <= i36) {
                i29 = i36;
                if (i43 != i11 - 1) {
                    i31 = i43 + 1;
                    iH4 -= nVarE2.h();
                    z18 = true;
                }
                i43++;
                iD = i44;
                i39 = i31;
                i36 = i29;
            } else {
                i29 = i36;
            }
            iMax3 = Math.max(iMax3, nVarE2.m());
            arrayDeque.add(nVarE2);
            i31 = i39;
            i43++;
            iD = i44;
            i39 = i31;
            i36 = i29;
        }
        if (iH5 < i12) {
            int i45 = i12 - iH5;
            iH4 -= i45;
            int i46 = iH5 + i45;
            iMax = iMax3;
            i24 = i39;
            while (iH4 < i13 && i24 > 0) {
                int i47 = i24 - 1;
                n nVarE3 = o.e(oVar, i47, 0L, 2, null);
                arrayDeque.add(0, nVarE3);
                iMax = Math.max(iMax, nVarE3.m());
                iH4 += nVarE3.h();
                i24 = i47;
                i38 = i38;
            }
            i21 = i38;
            i22 = i45 + iRound;
            if (iH4 < 0) {
                i22 += iH4;
                i23 = i46 + iH4;
                iH4 = 0;
            } else {
                i23 = i46;
            }
        } else {
            i21 = i38;
            iMax = iMax3;
            i22 = iRound;
            i23 = iH5;
            i24 = i39;
        }
        int i48 = iMax;
        float f12 = (a20.b.a(Math.round(f11)) != a20.b.a(i22) || Math.abs(Math.round(f11)) < Math.abs(i22)) ? f11 : i22;
        float f13 = f11 - f12;
        float f14 = (!z14 || i22 <= iRound || f13 > 0.0f) ? 0.0f : (i22 - iRound) + f13;
        if (iH4 < 0) {
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
        }
        int i49 = -iH4;
        n nVar3 = (n) arrayDeque.first();
        if (i13 > 0 || i15 < 0) {
            int size2 = arrayDeque.size();
            n nVar4 = nVar3;
            int i50 = iH4;
            int i51 = 0;
            while (true) {
                if (i51 < size2) {
                    int i52 = size2;
                    int iH6 = ((n) arrayDeque.get(i51)).h();
                    if (i50 != 0 && iH6 <= i50) {
                        i25 = i49;
                        if (i51 == kotlin.collections.g.n(arrayDeque)) {
                            break;
                        }
                        i50 -= iH6;
                        i51++;
                        nVar4 = (n) arrayDeque.get(i51);
                        i49 = i25;
                        size2 = i52;
                    }
                }
                i25 = i49;
                break;
            }
            nVar = nVar4;
            i26 = i50;
        } else {
            i25 = i49;
            i26 = iH4;
            nVar = nVar3;
        }
        List<n> listD = d(i24, oVar, i18, list2);
        int i53 = i43;
        int i54 = 0;
        int iMax4 = i48;
        for (int size3 = listD.size(); i54 < size3; size3 = size3) {
            iMax4 = Math.max(iMax4, listD.get(i54).m());
            i54++;
        }
        float f15 = f12;
        n nVar5 = nVar;
        List<n> listC = c(arrayDeque, oVar, i11, i18, list2, f15, z14, lVar);
        int size4 = listC.size();
        for (int i55 = 0; i55 < size4; i55++) {
            iMax4 = Math.max(iMax4, listC.get(i55).m());
        }
        boolean z19 = Intrinsics.b(nVar5, arrayDeque.first()) && listD.isEmpty() && listC.isEmpty();
        int i56 = q2.c.i(j11, z11 ? iMax4 : i23);
        if (z11) {
            iMax4 = i23;
        }
        int iH7 = q2.c.h(j11, iMax4);
        int i57 = i21;
        int i58 = i23;
        final List<n> listA = a(arrayDeque, listD, listC, i56, iH7, i23, i12, i25, z11, kVar, dVar, z12, eVar);
        lazyLayoutItemAnimator.m((int) f15, i56, iH7, listA, oVar.g(), oVar, z11, z14, 1, z13, i26, i58, k0Var, c4Var);
        if (z14) {
            iH = iH7;
            i27 = i56;
        } else {
            long jI2 = lazyLayoutItemAnimator.i();
            if (q2.t.e(jI2, q2.t.f74253b.a())) {
                iH = iH7;
                i27 = i56;
            } else {
                int i59 = z11 ? iH7 : i56;
                int i60 = q2.c.i(j11, Math.max(i56, q2.t.g(jI2)));
                iH = q2.c.h(j11, Math.max(iH7, q2.t.f(jI2)));
                int i61 = z11 ? iH : i60;
                if (i61 != i59) {
                    int size5 = listA.size();
                    for (int i62 = 0; i62 < size5; i62++) {
                        listA.get(i62).s(i61);
                    }
                }
                i27 = i60;
            }
        }
        final n nVarA = list.isEmpty() ^ true ? h.a(listA, oVar, list, i13, i27, iH) : null;
        if (i53 >= i11) {
            z15 = z14;
            if (i58 <= i12) {
                z16 = false;
            }
            androidx.compose.ui.layout.w wVarInvoke = function3.invoke(Integer.valueOf(i27), Integer.valueOf(iH), new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.compose.ui.layout.k0.a aVar) {
                    List<n> list4 = listA;
                    n nVar6 = nVarA;
                    boolean z21 = z15;
                    int size6 = list4.size();
                    for (int i63 = 0; i63 < size6; i63++) {
                        n nVar7 = list4.get(i63);
                        if (nVar7 != nVar6) {
                            nVar7.q(aVar, z21);
                        }
                    }
                    n nVar8 = nVarA;
                    if (nVar8 != null) {
                        nVar8.q(aVar, z15);
                    }
                    e0.a(i1Var);
                }
            });
            if (z19) {
                list3 = listA;
            } else {
                ArrayList arrayList = new ArrayList(listA.size());
                size = listA.size();
                for (i28 = 0; i28 < size; i28++) {
                    n nVar6 = listA.get(i28);
                    nVar2 = nVar6;
                    if ((nVar2.getIndex() < ((n) arrayDeque.first()).getIndex() && nVar2.getIndex() <= ((n) arrayDeque.last()).getIndex()) || nVar2 == nVarA) {
                        arrayList.add(nVar6);
                    }
                }
                list3 = arrayList;
            }
            if (z11) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            return new m(nVar5, i26, z16, f15, wVarInvoke, f14, z18, k0Var, eVar, oVar.f(), list3, i35, i57, i11, z12, orientation, i14, i15, null);
        }
        z15 = z14;
        z16 = true;
        androidx.compose.ui.layout.w wVarInvoke2 = function3.invoke(Integer.valueOf(i27), Integer.valueOf(iH), new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(androidx.compose.ui.layout.k0.a aVar) {
                List<n> list4 = listA;
                n nVar7 = nVarA;
                boolean z21 = z15;
                int size6 = list4.size();
                for (int i63 = 0; i63 < size6; i63++) {
                    n nVar8 = list4.get(i63);
                    if (nVar8 != nVar7) {
                        nVar8.q(aVar, z21);
                    }
                }
                n nVar9 = nVarA;
                if (nVar9 != null) {
                    nVar9.q(aVar, z15);
                }
                e0.a(i1Var);
            }
        });
        if (z19) {
            list3 = listA;
        } else {
            ArrayList arrayList2 = new ArrayList(listA.size());
            size = listA.size();
            while (i28 < size) {
                n nVar7 = listA.get(i28);
                nVar2 = nVar7;
                if (nVar2.getIndex() < ((n) arrayDeque.first()).getIndex()) {
                }
            }
            list3 = arrayList2;
        }
        if (z11) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        return new m(nVar5, i26, z16, f15, wVarInvoke2, f14, z18, k0Var, eVar, oVar.f(), list3, i35, i57, i11, z12, orientation, i14, i15, null);
    }
}
