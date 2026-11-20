package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1.i f5495a = new y1.i(0.0f, 0.0f, 10.0f, 10.0f);

    public static final f2 a(List<f2> list, int i11) {
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (list.get(i12).d() == i11) {
                return list.get(i12);
            }
        }
        return null;
    }

    public static final androidx.collection.n<h2> b(androidx.compose.ui.semantics.p pVar) {
        SemanticsNode semanticsNodeA = pVar.a();
        androidx.collection.c0 c0VarB = androidx.collection.o.b();
        if (semanticsNodeA.q().k() && semanticsNodeA.q().D0()) {
            y1.i iVarI = semanticsNodeA.i();
            c(new Region(Math.round(iVarI.f()), Math.round(iVarI.i()), Math.round(iVarI.g()), Math.round(iVarI.c())), semanticsNodeA, c0VarB, semanticsNodeA, new Region());
        }
        return c0VarB;
    }

    public static final void c(Region region, SemanticsNode semanticsNode, androidx.collection.c0<h2> c0Var, SemanticsNode semanticsNode2, Region region2) {
        androidx.compose.ui.layout.o oVarP;
        boolean z11 = (semanticsNode2.q().k() && semanticsNode2.q().D0()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.o() == semanticsNode.o()) {
            if (!z11 || semanticsNode2.x()) {
                y1.i iVarV = semanticsNode2.v();
                int iRound = Math.round(iVarV.f());
                int iRound2 = Math.round(iVarV.i());
                int iRound3 = Math.round(iVarV.g());
                int iRound4 = Math.round(iVarV.c());
                region2.set(iRound, iRound2, iRound3, iRound4);
                int iO = semanticsNode2.o() == semanticsNode.o() ? -1 : semanticsNode2.o();
                if (!region2.op(region, Region.Op.INTERSECT)) {
                    if (semanticsNode2.x()) {
                        SemanticsNode semanticsNodeR = semanticsNode2.r();
                        y1.i iVarI = (semanticsNodeR == null || (oVarP = semanticsNodeR.p()) == null || !oVarP.k()) ? f5495a : semanticsNodeR.i();
                        c0Var.t(iO, new h2(semanticsNode2, new Rect(Math.round(iVarI.f()), Math.round(iVarI.i()), Math.round(iVarI.g()), Math.round(iVarI.c()))));
                        return;
                    } else {
                        if (iO == -1) {
                            c0Var.t(iO, new h2(semanticsNode2, region2.getBounds()));
                            return;
                        }
                        return;
                    }
                }
                c0Var.t(iO, new h2(semanticsNode2, region2.getBounds()));
                List<SemanticsNode> listT = semanticsNode2.t();
                for (int size = listT.size() - 1; -1 < size; size--) {
                    c(region, semanticsNode, c0Var, listT.get(size), region2);
                }
                if (f(semanticsNode2)) {
                    region.op(iRound, iRound2, iRound3, iRound4, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    @SuppressLint({"PrimitiveInCollection"})
    public static final Float d(androidx.compose.ui.semantics.l lVar) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        androidx.compose.ui.semantics.a aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVar, androidx.compose.ui.semantics.k.f5661a.h());
        if (aVar == null || (function1 = (Function1) aVar.a()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final androidx.compose.ui.text.a0 e(androidx.compose.ui.semantics.l lVar) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        androidx.compose.ui.semantics.a aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVar, androidx.compose.ui.semantics.k.f5661a.i());
        if (aVar == null || (function1 = (Function1) aVar.a()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (androidx.compose.ui.text.a0) arrayList.get(0);
    }

    public static final boolean f(SemanticsNode semanticsNode) {
        return semanticsNode.w().v() || semanticsNode.w().g();
    }

    public static final View g(AndroidViewsHandler androidViewsHandler, int i11) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((LayoutNode) ((Map.Entry) next).getKey()).j0() != i11);
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    public static final String h(int i11) {
        androidx.compose.ui.semantics.i.a aVar = androidx.compose.ui.semantics.i.f5649b;
        if (androidx.compose.ui.semantics.i.k(i11, aVar.a())) {
            return "android.widget.Button";
        }
        if (androidx.compose.ui.semantics.i.k(i11, aVar.b())) {
            return "android.widget.CheckBox";
        }
        if (androidx.compose.ui.semantics.i.k(i11, aVar.e())) {
            return "android.widget.RadioButton";
        }
        if (androidx.compose.ui.semantics.i.k(i11, aVar.d())) {
            return "android.widget.ImageView";
        }
        if (androidx.compose.ui.semantics.i.k(i11, aVar.c())) {
            return "android.widget.Spinner";
        }
        return null;
    }
}
