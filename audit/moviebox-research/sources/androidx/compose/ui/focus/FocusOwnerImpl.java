package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.g0;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class FocusOwnerImpl implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<b, y1.i, Boolean> f3884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<b, Boolean> f3885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f3886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<y1.i> f3887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<LayoutDirection> f3888e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FocusInvalidationManager f3890g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g0 f3893j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FocusTargetNode f3889f = new FocusTargetNode();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f3891h = new y();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.compose.ui.f f3892i = n.a(androidx.compose.ui.f.f3863a, new Function1<m, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
            invoke2(mVar);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(m mVar) {
            mVar.r(false);
        }
    }).f(new l0<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        public boolean equals(Object obj) {
            return obj == this;
        }

        public int hashCode() {
            return this.f3895b.q().hashCode();
        }

        @Override // androidx.compose.ui.node.l0
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public FocusTargetNode a() {
            return this.f3895b.q();
        }

        @Override // androidx.compose.ui.node.l0
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void o(FocusTargetNode focusTargetNode) {
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3894a;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3894a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1, Function2<? super b, ? super y1.i, Boolean> function2, Function1<? super b, Boolean> function3, Function0<Unit> function0, Function0<y1.i> function4, Function0<? extends LayoutDirection> function5) {
        this.f3884a = function2;
        this.f3885b = function3;
        this.f3886c = function0;
        this.f3887d = function4;
        this.f3888e = function5;
        this.f3890g = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    @Override // androidx.compose.ui.focus.k
    public Boolean a(int i11, y1.i iVar, final Function1<? super FocusTargetNode, Boolean> function1) {
        final FocusTargetNode focusTargetNodeB = z.b(this.f3889f);
        if (focusTargetNodeB != null) {
            FocusRequester focusRequesterA = z.a(focusTargetNodeB, i11, this.f3888e.invoke());
            FocusRequester.a aVar = FocusRequester.f3908b;
            if (Intrinsics.b(focusRequesterA, aVar.a())) {
                return null;
            }
            if (!Intrinsics.b(focusRequesterA, aVar.b())) {
                return Boolean.valueOf(focusRequesterA.c(function1));
            }
        } else {
            focusTargetNodeB = null;
        }
        return z.e(this.f3889f, i11, this.f3888e.invoke(), iVar, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean zBooleanValue;
                if (Intrinsics.b(focusTargetNode, focusTargetNodeB)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.b(focusTargetNode, this.q())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    zBooleanValue = function1.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    @Override // androidx.compose.ui.focus.k
    public void b(d dVar) {
        this.f3890g.e(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.k
    public boolean c(g2.c r15) {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.c(g2.c):boolean");
    }

    @Override // androidx.compose.ui.focus.k
    public y d() {
        return this.f3891h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.k
    public boolean e(android.view.KeyEvent r15) {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.e(android.view.KeyEvent):boolean");
    }

    @Override // androidx.compose.ui.focus.k
    public void f(FocusTargetNode focusTargetNode) {
        this.f3890g.g(focusTargetNode);
    }

    @Override // androidx.compose.ui.focus.k
    public androidx.compose.ui.f g() {
        return this.f3892i;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0171  */
    /* JADX WARN: Code duplicated, block: B:104:0x0176  */
    /* JADX WARN: Code duplicated, block: B:228:0x031c  */
    /* JADX WARN: Code duplicated, block: B:304:0x016d A[EDGE_INSN: B:304:0x016d->B:101:0x016d BREAK  A[LOOP:14: B:62:0x00f0->B:309:0x00f0, LOOP_LABEL: LOOP:14: B:62:0x00f0->B:309:0x00f0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:65:0x0101 A[ADDED_TO_REGION, LOOP:15: B:65:0x0101->B:93:0x0154, LOOP_START, PHI: r10
  0x0101: PHI (r10v9 androidx.compose.ui.f$c) = (r10v4 androidx.compose.ui.f$c), (r10v10 androidx.compose.ui.f$c) binds: [B:64:0x00ff, B:93:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0103  */
    /* JADX WARN: Code duplicated, block: B:68:0x010a  */
    /* JADX WARN: Code duplicated, block: B:70:0x010e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0113  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r11v65 */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r5v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.k
    public boolean h(android.view.KeyEvent r17, kotlin.jvm.functions.Function0<java.lang.Boolean> r18) {
        /*
            Method dump skipped, instruction units count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.h(android.view.KeyEvent, kotlin.jvm.functions.Function0):boolean");
    }

    @Override // androidx.compose.ui.focus.k
    public boolean i(boolean z11, boolean z12, boolean z13, int i11) {
        boolean zC;
        y yVarD = d();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        try {
            if (yVarD.f3940c) {
                yVarD.g();
            }
            yVarD.f();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                yVarD.f3939b.b(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!z11) {
                int i12 = a.f3894a[FocusTransactionsKt.e(this.f3889f, i11).ordinal()];
                zC = (i12 == 1 || i12 == 2 || i12 == 3) ? false : FocusTransactionsKt.c(this.f3889f, z11, z12);
            }
            yVarD.h();
            if (zC && z13) {
                this.f3886c.invoke();
            }
            return zC;
        } catch (Throwable th2) {
            yVarD.h();
            throw th2;
        }
    }

    @Override // androidx.compose.ui.focus.k
    public u j() {
        return this.f3889f.O1();
    }

    @Override // androidx.compose.ui.focus.k
    public void k(o oVar) {
        this.f3890g.f(oVar);
    }

    @Override // androidx.compose.ui.focus.k
    public y1.i l() {
        FocusTargetNode focusTargetNodeB = z.b(this.f3889f);
        if (focusTargetNodeB != null) {
            return z.d(focusTargetNodeB);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.k
    public boolean m(b bVar, y1.i iVar) {
        return this.f3884a.invoke(bVar, iVar).booleanValue();
    }

    @Override // androidx.compose.ui.focus.k
    public void n() {
        y yVarD = d();
        if (yVarD.f3940c) {
            FocusTransactionsKt.c(this.f3889f, true, true);
            return;
        }
        try {
            yVarD.f();
            FocusTransactionsKt.c(this.f3889f, true, true);
        } finally {
            yVarD.h();
        }
    }

    @Override // androidx.compose.ui.focus.h
    public void o(boolean z11) {
        i(z11, true, true, b.f3922b.c());
    }

    public final FocusTargetNode q() {
        return this.f3889f;
    }

    public final void r() {
        if (this.f3889f.O1() == FocusStateImpl.Inactive) {
            this.f3886c.invoke();
        }
    }

    public final androidx.compose.ui.f.c s(androidx.compose.ui.node.f fVar) {
        int iA = s0.a(1024) | s0.a(8192);
        if (!fVar.getNode().o1()) {
            h2.a.b("visitLocalDescendants called on an unattached node");
        }
        androidx.compose.ui.f.c node = fVar.getNode();
        androidx.compose.ui.f.c cVar = null;
        if ((node.e1() & iA) != 0) {
            for (androidx.compose.ui.f.c cVarF1 = node.f1(); cVarF1 != null; cVarF1 = cVarF1.f1()) {
                if ((cVarF1.j1() & iA) != 0) {
                    if ((s0.a(1024) & cVarF1.j1()) != 0) {
                        return cVar;
                    }
                    cVar = cVarF1;
                }
            }
        }
        return cVar;
    }

    public final boolean t(KeyEvent keyEvent) {
        long jA = e2.d.a(keyEvent);
        int iB = e2.d.b(keyEvent);
        e2.c.a aVar = e2.c.f63782a;
        if (e2.c.e(iB, aVar.a())) {
            g0 g0Var = this.f3893j;
            if (g0Var == null) {
                g0Var = new g0(3);
                this.f3893j = g0Var;
            }
            g0Var.l(jA);
        } else if (e2.c.e(iB, aVar.b())) {
            g0 g0Var2 = this.f3893j;
            if (g0Var2 == null || !g0Var2.a(jA)) {
                return false;
            }
            g0 g0Var3 = this.f3893j;
            if (g0Var3 != null) {
                g0Var3.m(jA);
            }
        }
        return true;
    }
}
