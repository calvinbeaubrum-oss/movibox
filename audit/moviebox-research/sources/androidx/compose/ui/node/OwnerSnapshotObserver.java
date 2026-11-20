package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class OwnerSnapshotObserver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5062i = SnapshotStateObserver.f3618k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SnapshotStateObserver f5063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5064b = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.d1(layoutNode, false, false, false, 7, null);
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5065c = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingMeasure$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.h1(layoutNode, false, false, false, 7, null);
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5066d = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingSemantics$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                layoutNode.B0();
            }
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5067e = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.f1(layoutNode, false, 1, null);
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5068f = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.f1(layoutNode, false, 1, null);
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5069g = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.b1(layoutNode, false, 1, null);
            }
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<LayoutNode, Unit> f5070h = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookahead$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
            invoke2(layoutNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.b1(layoutNode, false, 1, null);
            }
        }
    };

    public OwnerSnapshotObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.f5063a = new SnapshotStateObserver(function1);
    }

    public static /* synthetic */ void d(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        ownerSnapshotObserver.c(layoutNode, z11, function0);
    }

    public static /* synthetic */ void f(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        ownerSnapshotObserver.e(layoutNode, z11, function0);
    }

    public static /* synthetic */ void h(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        ownerSnapshotObserver.g(layoutNode, z11, function0);
    }

    public final void a(Object obj) {
        this.f5063a.k(obj);
    }

    public final void b() {
        this.f5063a.l(new Function1<Object, Boolean>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.node.OwnerScope");
                return Boolean.valueOf(!((z0) obj).isValidOwnerScope());
            }
        });
    }

    public final void c(LayoutNode layoutNode, boolean z11, Function0<Unit> function0) {
        if (!z11 || layoutNode.V() == null) {
            i(layoutNode, this.f5068f, function0);
        } else {
            i(layoutNode, this.f5069g, function0);
        }
    }

    public final void e(LayoutNode layoutNode, boolean z11, Function0<Unit> function0) {
        if (!z11 || layoutNode.V() == null) {
            i(layoutNode, this.f5067e, function0);
        } else {
            i(layoutNode, this.f5070h, function0);
        }
    }

    public final void g(LayoutNode layoutNode, boolean z11, Function0<Unit> function0) {
        if (!z11 || layoutNode.V() == null) {
            i(layoutNode, this.f5065c, function0);
        } else {
            i(layoutNode, this.f5064b, function0);
        }
    }

    public final <T extends z0> void i(T t11, Function1<? super T, Unit> function1, Function0<Unit> function0) {
        this.f5063a.o(t11, function1, function0);
    }

    public final void j(LayoutNode layoutNode, Function0<Unit> function0) {
        i(layoutNode, this.f5066d, function0);
    }

    public final void k() {
        this.f5063a.s();
    }

    public final void l() {
        this.f5063a.t();
        this.f5063a.j();
    }
}
