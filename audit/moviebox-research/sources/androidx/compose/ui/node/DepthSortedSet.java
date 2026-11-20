package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class DepthSortedSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f4931b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<Map<LayoutNode, Integer>>() { // from class: androidx.compose.ui.node.DepthSortedSet$mapOfOriginalDepth$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<LayoutNode, Integer> invoke() {
            return new LinkedHashMap();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator<LayoutNode> f4932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TreeSet<LayoutNode> f4933d;

    public DepthSortedSet(boolean z11) {
        this.f4930a = z11;
        Comparator<LayoutNode> comparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
                int i11 = Intrinsics.i(layoutNode.I(), layoutNode2.I());
                return i11 != 0 ? i11 : Intrinsics.i(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        };
        this.f4932c = comparator;
        this.f4933d = new TreeSet<>(comparator);
    }

    public final void a(LayoutNode layoutNode) {
        if (!layoutNode.D0()) {
            h2.a.b("DepthSortedSet.add called on an unattached node");
        }
        if (this.f4930a) {
            Integer num = c().get(layoutNode);
            if (num == null) {
                c().put(layoutNode, Integer.valueOf(layoutNode.I()));
            } else {
                if (!(num.intValue() == layoutNode.I())) {
                    h2.a.b("invalid node depth");
                }
            }
        }
        this.f4933d.add(layoutNode);
    }

    public final boolean b(LayoutNode layoutNode) {
        boolean zContains = this.f4933d.contains(layoutNode);
        if (this.f4930a) {
            if (!(zContains == c().containsKey(layoutNode))) {
                h2.a.b("inconsistency in TreeSet");
            }
        }
        return zContains;
    }

    public final Map<LayoutNode, Integer> c() {
        return (Map) this.f4931b.getValue();
    }

    public final boolean d() {
        return this.f4933d.isEmpty();
    }

    public final LayoutNode e() {
        LayoutNode layoutNodeFirst = this.f4933d.first();
        f(layoutNodeFirst);
        return layoutNodeFirst;
    }

    public final boolean f(LayoutNode layoutNode) {
        if (!layoutNode.D0()) {
            h2.a.b("DepthSortedSet.remove called on an unattached node");
        }
        boolean zRemove = this.f4933d.remove(layoutNode);
        if (this.f4930a) {
            if (!Intrinsics.b(c().remove(layoutNode), zRemove ? Integer.valueOf(layoutNode.I()) : null)) {
                h2.a.b("invalid node depth");
            }
        }
        return zRemove;
    }

    public String toString() {
        return this.f4933d.toString();
    }
}
