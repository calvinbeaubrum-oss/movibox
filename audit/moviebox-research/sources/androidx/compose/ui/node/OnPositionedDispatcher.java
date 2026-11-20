package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class OnPositionedDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f5058c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5059d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<LayoutNode> f5060a = new androidx.compose.runtime.collection.b<>(new LayoutNode[16], 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutNode[] f5061b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class DepthComparator implements Comparator<LayoutNode> {
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            @Override // java.util.Comparator
            public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
                int i11 = Intrinsics.i(layoutNode2.I(), layoutNode.I());
                return i11 != 0 ? i11 : Intrinsics.i(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a() {
        this.f5060a.E(Companion.DepthComparator.INSTANCE);
        int iR = this.f5060a.r();
        LayoutNode[] layoutNodeArr = this.f5061b;
        if (layoutNodeArr == null || layoutNodeArr.length < iR) {
            layoutNodeArr = new LayoutNode[Math.max(16, this.f5060a.r())];
        }
        this.f5061b = null;
        for (int i11 = 0; i11 < iR; i11++) {
            layoutNodeArr[i11] = this.f5060a.q()[i11];
        }
        this.f5060a.i();
        while (true) {
            iR--;
            if (-1 >= iR) {
                this.f5061b = layoutNodeArr;
                return;
            }
            LayoutNode layoutNode = layoutNodeArr[iR];
            Intrinsics.d(layoutNode);
            if (layoutNode.d0()) {
                b(layoutNode);
            }
        }
    }

    public final void b(LayoutNode layoutNode) {
        layoutNode.x();
        int i11 = 0;
        layoutNode.p1(false);
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            do {
                b(layoutNodeArrQ[i11]);
                i11++;
            } while (i11 < iR);
        }
    }

    public final boolean c() {
        return this.f5060a.u();
    }

    public final void d(LayoutNode layoutNode) {
        this.f5060a.b(layoutNode);
        layoutNode.p1(true);
    }

    public final void e(LayoutNode layoutNode) {
        this.f5060a.i();
        this.f5060a.b(layoutNode);
        layoutNode.p1(true);
    }

    public final void f(LayoutNode layoutNode) {
        this.f5060a.x(layoutNode);
    }
}
