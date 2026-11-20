package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.b;
import androidx.compose.ui.semantics.c;
import androidx.compose.ui.semantics.l;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.h;

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
public final class CollectionInfo_androidKt {
    public static final boolean a(List<SemanticsNode> list) {
        List listL;
        long jV;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            listL = g.l();
        } else {
            listL = new ArrayList();
            SemanticsNode semanticsNode = list.get(0);
            int iN = g.n(list);
            int i11 = 0;
            while (i11 < iN) {
                i11++;
                SemanticsNode semanticsNode2 = list.get(i11);
                SemanticsNode semanticsNode3 = semanticsNode2;
                SemanticsNode semanticsNode4 = semanticsNode;
                listL.add(y1.g.d(h.a(Math.abs(y1.g.m(semanticsNode4.i().d()) - y1.g.m(semanticsNode3.i().d())), Math.abs(y1.g.n(semanticsNode4.i().d()) - y1.g.n(semanticsNode3.i().d())))));
                semanticsNode = semanticsNode2;
            }
        }
        if (listL.size() == 1) {
            jV = ((y1.g) CollectionsKt___CollectionsKt.e0(listL)).v();
        } else {
            if (listL.isEmpty()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object objE0 = CollectionsKt___CollectionsKt.e0(listL);
            int iN2 = g.n(listL);
            if (1 <= iN2) {
                int i12 = 1;
                while (true) {
                    objE0 = y1.g.d(y1.g.r(((y1.g) objE0).v(), ((y1.g) listL.get(i12)).v()));
                    if (i12 == iN2) {
                        break;
                    }
                    i12++;
                }
            }
            jV = ((y1.g) objE0).v();
        }
        return y1.g.n(jV) < y1.g.m(jV);
    }

    public static final boolean b(SemanticsNode semanticsNode) {
        l lVarN = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        return (SemanticsConfigurationKt.a(lVarN, semanticsProperties.a()) == null && SemanticsConfigurationKt.a(semanticsNode.n(), semanticsProperties.y()) == null) ? false : true;
    }

    public static final boolean c(b bVar) {
        return bVar.b() < 0 || bVar.a() < 0;
    }

    public static final void d(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        l lVarN = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        b bVar = (b) SemanticsConfigurationKt.a(lVarN, semanticsProperties.a());
        if (bVar != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(f(bVar));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.a(semanticsNode.n(), semanticsProperties.y()) != null) {
            List<SemanticsNode> listT = semanticsNode.t();
            int size = listT.size();
            for (int i11 = 0; i11 < size; i11++) {
                SemanticsNode semanticsNode2 = listT.get(i11);
                if (semanticsNode2.n().f(SemanticsProperties.f5594a.z())) {
                    arrayList.add(semanticsNode2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            boolean zA = a(arrayList);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(zA ? 1 : arrayList.size(), zA ? arrayList.size() : 1, false, 0));
        }
    }

    public static final void e(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        l lVarN = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        c cVar = (c) SemanticsConfigurationKt.a(lVarN, semanticsProperties.b());
        if (cVar != null) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(g(cVar, semanticsNode));
        }
        SemanticsNode semanticsNodeR = semanticsNode.r();
        if (semanticsNodeR == null || SemanticsConfigurationKt.a(semanticsNodeR.n(), semanticsProperties.y()) == null) {
            return;
        }
        b bVar = (b) SemanticsConfigurationKt.a(semanticsNodeR.n(), semanticsProperties.a());
        if ((bVar == null || !c(bVar)) && semanticsNode.n().f(semanticsProperties.z())) {
            ArrayList arrayList = new ArrayList();
            List<SemanticsNode> listT = semanticsNodeR.t();
            int size = listT.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                SemanticsNode semanticsNode2 = listT.get(i12);
                if (semanticsNode2.n().f(SemanticsProperties.f5594a.z())) {
                    arrayList.add(semanticsNode2);
                    if (semanticsNode2.q().i0() < semanticsNode.q().i0()) {
                        i11++;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                boolean zA = a(arrayList);
                AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompatObtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(zA ? 0 : i11, 1, zA ? i11 : 0, 1, false, ((Boolean) semanticsNode.n().r(SemanticsProperties.f5594a.z(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt$setCollectionItemInfo$itemInfo$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.FALSE;
                    }
                })).booleanValue());
                if (collectionItemInfoCompatObtain != null) {
                    accessibilityNodeInfoCompat.setCollectionItemInfo(collectionItemInfoCompatObtain);
                }
            }
        }
    }

    public static final AccessibilityNodeInfoCompat.CollectionInfoCompat f(b bVar) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(bVar.b(), bVar.a(), false, 0);
    }

    public static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat g(c cVar, SemanticsNode semanticsNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(cVar.c(), cVar.d(), cVar.a(), cVar.b(), false, ((Boolean) semanticsNode.n().r(SemanticsProperties.f5594a.z(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt$toAccessibilityCollectionItemInfo$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue());
    }
}
