package androidx.compose.foundation;

import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.layout.j0;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

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
public final class FocusablePinnableContainerNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.d, u0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j0.a f2242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2243p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f2244q;

    public final j0 H1() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        v0.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.FocusablePinnableContainerNode$retrievePinnableContainer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                objectRef.element = androidx.compose.ui.node.e.a(this, PinnableContainerKt.a());
            }
        });
        return (j0) objectRef.element;
    }

    public final void I1(boolean z11) {
        if (z11) {
            j0 j0VarH1 = H1();
            this.f2242o = j0VarH1 != null ? j0VarH1.a() : null;
        } else {
            j0.a aVar = this.f2242o;
            if (aVar != null) {
                aVar.release();
            }
            this.f2242o = null;
        }
        this.f2243p = z11;
    }

    @Override // androidx.compose.ui.node.u0
    public void g0() {
        j0 j0VarH1 = H1();
        if (this.f2243p) {
            j0.a aVar = this.f2242o;
            if (aVar != null) {
                aVar.release();
            }
            this.f2242o = j0VarH1 != null ? j0VarH1.a() : null;
        }
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2244q;
    }

    @Override // androidx.compose.ui.f.c
    public void t1() {
        j0.a aVar = this.f2242o;
        if (aVar != null) {
            aVar.release();
        }
        this.f2242o = null;
    }
}
