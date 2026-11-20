package androidx.compose.ui.focus;

import androidx.compose.ui.node.s0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class FocusRequester {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3908b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FocusRequester f3909c = new FocusRequester();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FocusRequester f3910d = new FocusRequester();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<t> f3911a = new androidx.compose.runtime.collection.b<>(new t[16], 0);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FocusRequester a() {
            return FocusRequester.f3910d;
        }

        public final FocusRequester b() {
            return FocusRequester.f3909c;
        }
    }

    public final boolean c(Function1<? super FocusTargetNode, Boolean> function1) {
        a aVar = f3908b;
        if (this == aVar.b()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
        if (this == aVar.a()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
        if (!this.f3911a.u()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        androidx.compose.runtime.collection.b<t> bVar = this.f3911a;
        int iR = bVar.r();
        if (iR <= 0) {
            return false;
        }
        t[] tVarArrQ = bVar.q();
        int i11 = 0;
        boolean z11 = false;
        do {
            t tVar = tVarArrQ[i11];
            int iA = s0.a(1024);
            if (!tVar.getNode().o1()) {
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            }
            androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
            androidx.compose.ui.f.c cVarF1 = tVar.getNode().f1();
            if (cVarF1 == null) {
                androidx.compose.ui.node.g.c(bVar2, tVar.getNode());
            } else {
                bVar2.b(cVarF1);
            }
            while (bVar2.u()) {
                androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar2.z(bVar2.r() - 1);
                if ((cVarG.e1() & iA) == 0) {
                    androidx.compose.ui.node.g.c(bVar2, cVarG);
                } else {
                    while (cVarG != null) {
                        if ((cVarG.j1() & iA) != 0) {
                            androidx.compose.runtime.collection.b bVar3 = null;
                            while (cVarG != null) {
                                if (cVarG instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode = (FocusTargetNode) cVarG;
                                    if (focusTargetNode.M1().t() ? function1.invoke(focusTargetNode).booleanValue() : TwoDimensionalFocusSearchKt.k(focusTargetNode, b.f3922b.b(), function1)) {
                                        z11 = true;
                                        break;
                                    }
                                } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                    int i12 = 0;
                                    for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                        if ((cVarI1.j1() & iA) != 0) {
                                            i12++;
                                            if (i12 == 1) {
                                                cVarG = cVarI1;
                                            } else {
                                                if (bVar3 == null) {
                                                    bVar3 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                                }
                                                if (cVarG != null) {
                                                    bVar3.b(cVarG);
                                                    cVarG = null;
                                                }
                                                bVar3.b(cVarI1);
                                            }
                                        }
                                    }
                                    if (i12 == 1) {
                                    }
                                }
                                cVarG = androidx.compose.ui.node.g.g(bVar3);
                            }
                            break;
                        }
                        cVarG = cVarG.f1();
                    }
                }
            }
            i11++;
        } while (i11 < iR);
        return z11;
    }

    public final boolean d() {
        return c(new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequester$focus$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(FocusTransactionsKt.j(focusTargetNode));
            }
        });
    }

    public final androidx.compose.runtime.collection.b<t> e() {
        return this.f3911a;
    }
}
