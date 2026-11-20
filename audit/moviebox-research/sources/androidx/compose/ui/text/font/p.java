package androidx.compose.ui.text.font;

import java.util.ArrayList;
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
public final class p {
    public final List<h> a(List<? extends h> list, u uVar, int i11) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            h hVar = list.get(i13);
            h hVar2 = hVar;
            if (Intrinsics.b(hVar2.b(), uVar) && q.f(hVar2.d(), i11)) {
                arrayList.add(hVar);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i14 = 0; i14 < size2; i14++) {
            h hVar3 = list.get(i14);
            if (q.f(hVar3.d(), i11)) {
                arrayList2.add(hVar3);
            }
        }
        if (!arrayList2.isEmpty()) {
            list = arrayList2;
        }
        List<? extends h> list2 = list;
        u.a aVar = u.f5860b;
        u uVar2 = null;
        if (uVar.compareTo(aVar.b()) < 0) {
            int size3 = list2.size();
            u uVar3 = null;
            for (int i15 = 0; i15 < size3; i15++) {
                u uVarB = list2.get(i15).b();
                if (uVarB.compareTo(uVar) >= 0) {
                    if (uVarB.compareTo(uVar) <= 0) {
                        uVar3 = uVarB;
                        uVar2 = uVar3;
                        break;
                    }
                    if (uVar3 == null || uVarB.compareTo(uVar3) < 0) {
                        uVar3 = uVarB;
                    }
                } else if (uVar2 == null || uVarB.compareTo(uVar2) > 0) {
                    uVar2 = uVarB;
                }
            }
            if (uVar2 != null) {
                uVar3 = uVar2;
            }
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size4 = list2.size();
            while (i12 < size4) {
                h hVar4 = list2.get(i12);
                if (Intrinsics.b(hVar4.b(), uVar3)) {
                    arrayList3.add(hVar4);
                }
                i12++;
            }
            return arrayList3;
        }
        if (uVar.compareTo(aVar.c()) > 0) {
            int size5 = list2.size();
            u uVar4 = null;
            for (int i16 = 0; i16 < size5; i16++) {
                u uVarB2 = list2.get(i16).b();
                if (uVarB2.compareTo(uVar) >= 0) {
                    if (uVarB2.compareTo(uVar) <= 0) {
                        uVar4 = uVarB2;
                        uVar2 = uVar4;
                        break;
                    }
                    if (uVar4 == null || uVarB2.compareTo(uVar4) < 0) {
                        uVar4 = uVarB2;
                    }
                } else if (uVar2 == null || uVarB2.compareTo(uVar2) > 0) {
                    uVar2 = uVarB2;
                }
            }
            if (uVar4 == null) {
                uVar4 = uVar2;
            }
            ArrayList arrayList4 = new ArrayList(list2.size());
            int size6 = list2.size();
            while (i12 < size6) {
                h hVar5 = list2.get(i12);
                if (Intrinsics.b(hVar5.b(), uVar4)) {
                    arrayList4.add(hVar5);
                }
                i12++;
            }
            return arrayList4;
        }
        u uVarC = aVar.c();
        int size7 = list2.size();
        u uVar5 = null;
        u uVar6 = null;
        for (int i17 = 0; i17 < size7; i17++) {
            u uVarB3 = list2.get(i17).b();
            if (uVarC == null || uVarB3.compareTo(uVarC) <= 0) {
                if (uVarB3.compareTo(uVar) >= 0) {
                    if (uVarB3.compareTo(uVar) <= 0) {
                        uVar5 = uVarB3;
                        uVar6 = uVar5;
                        break;
                    }
                    if (uVar6 == null || uVarB3.compareTo(uVar6) < 0) {
                        uVar6 = uVarB3;
                    }
                } else if (uVar5 == null || uVarB3.compareTo(uVar5) > 0) {
                    uVar5 = uVarB3;
                }
            }
        }
        if (uVar6 != null) {
            uVar5 = uVar6;
        }
        ArrayList arrayList5 = new ArrayList(list2.size());
        int size8 = list2.size();
        for (int i18 = 0; i18 < size8; i18++) {
            h hVar6 = list2.get(i18);
            if (Intrinsics.b(hVar6.b(), uVar5)) {
                arrayList5.add(hVar6);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        u uVarC2 = u.f5860b.c();
        int size9 = list2.size();
        u uVar7 = null;
        for (int i19 = 0; i19 < size9; i19++) {
            u uVarB4 = list2.get(i19).b();
            if (uVarC2 == null || uVarB4.compareTo(uVarC2) >= 0) {
                if (uVarB4.compareTo(uVar) >= 0) {
                    if (uVarB4.compareTo(uVar) <= 0) {
                        uVar2 = uVarB4;
                        uVar7 = uVar2;
                        break;
                    }
                    if (uVar7 == null || uVarB4.compareTo(uVar7) < 0) {
                        uVar7 = uVarB4;
                    }
                } else if (uVar2 == null || uVarB4.compareTo(uVar2) > 0) {
                    uVar2 = uVarB4;
                }
            }
        }
        if (uVar7 != null) {
            uVar2 = uVar7;
        }
        ArrayList arrayList6 = new ArrayList(list2.size());
        int size10 = list2.size();
        while (i12 < size10) {
            h hVar7 = list2.get(i12);
            if (Intrinsics.b(hVar7.b(), uVar2)) {
                arrayList6.add(hVar7);
            }
            i12++;
        }
        return arrayList6;
    }
}
