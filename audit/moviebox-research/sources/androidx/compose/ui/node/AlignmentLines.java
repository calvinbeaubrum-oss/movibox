package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLineKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public abstract class AlignmentLines {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f4908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<androidx.compose.ui.layout.a, Integer> f4909i;

    public AlignmentLines(a aVar) {
        this.f4901a = aVar;
        this.f4902b = true;
        this.f4909i = new HashMap();
    }

    public /* synthetic */ AlignmentLines(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final void c(androidx.compose.ui.layout.a aVar, int i11, NodeCoordinator nodeCoordinator) {
        float f11 = i11;
        long jA = y1.h.a(f11, f11);
        while (true) {
            jA = d(nodeCoordinator, jA);
            nodeCoordinator = nodeCoordinator.Z1();
            Intrinsics.d(nodeCoordinator);
            if (Intrinsics.b(nodeCoordinator, this.f4901a.I())) {
                break;
            } else if (e(nodeCoordinator).containsKey(aVar)) {
                float fI = i(nodeCoordinator, aVar);
                jA = y1.h.a(fI, fI);
            }
        }
        int iRound = Math.round(aVar instanceof androidx.compose.ui.layout.i ? y1.g.n(jA) : y1.g.m(jA));
        Map<androidx.compose.ui.layout.a, Integer> map = this.f4909i;
        if (map.containsKey(aVar)) {
            iRound = AlignmentLineKt.c(aVar, ((Number) kotlin.collections.s.i(this.f4909i, aVar)).intValue(), iRound);
        }
        map.put(aVar, Integer.valueOf(iRound));
    }

    public abstract long d(NodeCoordinator nodeCoordinator, long j11);

    public abstract Map<androidx.compose.ui.layout.a, Integer> e(NodeCoordinator nodeCoordinator);

    public final a f() {
        return this.f4901a;
    }

    public final boolean g() {
        return this.f4902b;
    }

    public final Map<androidx.compose.ui.layout.a, Integer> h() {
        return this.f4909i;
    }

    public abstract int i(NodeCoordinator nodeCoordinator, androidx.compose.ui.layout.a aVar);

    public final boolean j() {
        return this.f4903c || this.f4905e || this.f4906f || this.f4907g;
    }

    public final boolean k() {
        o();
        return this.f4908h != null;
    }

    public final boolean l() {
        return this.f4904d;
    }

    public final void m() {
        this.f4902b = true;
        a aVarC = this.f4901a.C();
        if (aVarC == null) {
            return;
        }
        if (this.f4903c) {
            aVarC.W();
        } else if (this.f4905e || this.f4904d) {
            aVarC.requestLayout();
        }
        if (this.f4906f) {
            this.f4901a.W();
        }
        if (this.f4907g) {
            this.f4901a.requestLayout();
        }
        aVarC.l().m();
    }

    public final void n() {
        this.f4909i.clear();
        this.f4901a.S(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.AlignmentLines$recalculate$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a aVar) {
                if (aVar.k()) {
                    if (aVar.l().g()) {
                        aVar.G();
                    }
                    Map map = aVar.l().f4909i;
                    AlignmentLines alignmentLines = this.this$0;
                    for (Map.Entry entry : map.entrySet()) {
                        alignmentLines.c((androidx.compose.ui.layout.a) entry.getKey(), ((Number) entry.getValue()).intValue(), aVar.I());
                    }
                    NodeCoordinator nodeCoordinatorZ1 = aVar.I().Z1();
                    Intrinsics.d(nodeCoordinatorZ1);
                    while (!Intrinsics.b(nodeCoordinatorZ1, this.this$0.f().I())) {
                        Set<androidx.compose.ui.layout.a> setKeySet = this.this$0.e(nodeCoordinatorZ1).keySet();
                        AlignmentLines alignmentLines2 = this.this$0;
                        for (androidx.compose.ui.layout.a aVar2 : setKeySet) {
                            alignmentLines2.c(aVar2, alignmentLines2.i(nodeCoordinatorZ1, aVar2), nodeCoordinatorZ1);
                        }
                        nodeCoordinatorZ1 = nodeCoordinatorZ1.Z1();
                        Intrinsics.d(nodeCoordinatorZ1);
                    }
                }
            }
        });
        this.f4909i.putAll(e(this.f4901a.I()));
        this.f4902b = false;
    }

    public final void o() {
        a aVar;
        AlignmentLines alignmentLinesL;
        AlignmentLines alignmentLinesL2;
        if (j()) {
            aVar = this.f4901a;
        } else {
            a aVarC = this.f4901a.C();
            if (aVarC == null) {
                return;
            }
            aVar = aVarC.l().f4908h;
            if (aVar == null || !aVar.l().j()) {
                a aVar2 = this.f4908h;
                if (aVar2 == null || aVar2.l().j()) {
                    return;
                }
                a aVarC2 = aVar2.C();
                if (aVarC2 != null && (alignmentLinesL2 = aVarC2.l()) != null) {
                    alignmentLinesL2.o();
                }
                a aVarC3 = aVar2.C();
                aVar = (aVarC3 == null || (alignmentLinesL = aVarC3.l()) == null) ? null : alignmentLinesL.f4908h;
            }
        }
        this.f4908h = aVar;
    }

    public final void p() {
        this.f4902b = true;
        this.f4903c = false;
        this.f4905e = false;
        this.f4904d = false;
        this.f4906f = false;
        this.f4907g = false;
        this.f4908h = null;
    }

    public final void q(boolean z11) {
        this.f4905e = z11;
    }

    public final void r(boolean z11) {
        this.f4907g = z11;
    }

    public final void s(boolean z11) {
        this.f4906f = z11;
    }

    public final void t(boolean z11) {
        this.f4904d = z11;
    }

    public final void u(boolean z11) {
        this.f4903c = z11;
    }
}
