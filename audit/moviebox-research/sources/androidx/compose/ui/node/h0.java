package androidx.compose.ui.node;

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
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f5078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f5079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<k0.a> f5080c;

    public h0(LayoutNode layoutNode, j jVar, List<k0.a> list) {
        this.f5078a = layoutNode;
        this.f5079b = jVar;
        this.f5080c = list;
    }

    public static final void e(h0 h0Var, StringBuilder sb2, LayoutNode layoutNode, int i11) {
        String strF = h0Var.f(layoutNode);
        if (strF.length() > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                sb2.append("..");
            }
            sb2.append(strF);
            Intrinsics.f(sb2, "append(value)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append('\\n')");
            i11++;
        }
        List<LayoutNode> listE = layoutNode.E();
        int size = listE.size();
        for (int i13 = 0; i13 < size; i13++) {
            e(h0Var, sb2, listE.get(i13), i11);
        }
    }

    public final void a() {
        if (!c(this.f5078a)) {
            System.out.println((Object) d());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    public final boolean b(LayoutNode layoutNode) {
        k0.a aVar;
        LayoutNode layoutNodeH0 = layoutNode.h0();
        k0.a aVar2 = null;
        LayoutNode.LayoutState layoutStateR = layoutNodeH0 != null ? layoutNodeH0.R() : null;
        if (layoutNode.k() || (layoutNode.i0() != Integer.MAX_VALUE && layoutNodeH0 != null && layoutNodeH0.k())) {
            if (layoutNode.Y()) {
                List<k0.a> list = this.f5080c;
                int size = list.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        aVar = null;
                        break;
                    }
                    aVar = list.get(i11);
                    k0.a aVar3 = aVar;
                    if (Intrinsics.b(aVar3.a(), layoutNode) && !aVar3.c()) {
                        break;
                    }
                    i11++;
                }
                if (aVar != null) {
                    return true;
                }
            }
            if (layoutNode.Y()) {
                return this.f5079b.d(layoutNode) || layoutNode.R() == LayoutNode.LayoutState.LookaheadMeasuring || (layoutNodeH0 != null && layoutNodeH0.Y()) || ((layoutNodeH0 != null && layoutNodeH0.T()) || layoutStateR == LayoutNode.LayoutState.Measuring);
            }
            if (layoutNode.Q()) {
                return this.f5079b.d(layoutNode) || layoutNodeH0 == null || layoutNodeH0.Y() || layoutNodeH0.Q() || layoutStateR == LayoutNode.LayoutState.Measuring || layoutStateR == LayoutNode.LayoutState.LayingOut;
            }
        }
        if (Intrinsics.b(layoutNode.G0(), Boolean.TRUE)) {
            if (layoutNode.T()) {
                List<k0.a> list2 = this.f5080c;
                int size2 = list2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    k0.a aVar4 = list2.get(i12);
                    k0.a aVar5 = aVar4;
                    if (Intrinsics.b(aVar5.a(), layoutNode) && aVar5.c()) {
                        aVar2 = aVar4;
                        break;
                    }
                }
                if (aVar2 != null) {
                    return true;
                }
            }
            if (layoutNode.T()) {
                return this.f5079b.e(layoutNode, true) || (layoutNodeH0 != null && layoutNodeH0.T()) || layoutStateR == LayoutNode.LayoutState.LookaheadMeasuring || (layoutNodeH0 != null && layoutNodeH0.Y() && Intrinsics.b(layoutNode.V(), layoutNode));
            }
            return !layoutNode.S() || this.f5079b.e(layoutNode, true) || layoutNodeH0 == null || layoutNodeH0.T() || layoutNodeH0.S() || layoutStateR == LayoutNode.LayoutState.LookaheadMeasuring || layoutStateR == LayoutNode.LayoutState.LookaheadLayingOut || (layoutNodeH0.Q() && Intrinsics.b(layoutNode.V(), layoutNode));
        }
        return true;
    }

    public final boolean c(LayoutNode layoutNode) {
        if (!b(layoutNode)) {
            return false;
        }
        List<LayoutNode> listE = layoutNode.E();
        int size = listE.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!c(listE.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tree state:");
        Intrinsics.f(sb2, "append(value)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append('\\n')");
        e(this, sb2, this.f5078a, 0);
        return sb2.toString();
    }

    public final String f(LayoutNode layoutNode) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(layoutNode);
        StringBuilder sb3 = new StringBuilder();
        sb3.append('[');
        sb3.append(layoutNode.R());
        sb3.append(']');
        sb2.append(sb3.toString());
        if (!layoutNode.k()) {
            sb2.append("[!isPlaced]");
        }
        sb2.append("[measuredByParent=" + layoutNode.a0() + ']');
        if (!b(layoutNode)) {
            sb2.append("[INCONSISTENT]");
        }
        return sb2.toString();
    }
}
