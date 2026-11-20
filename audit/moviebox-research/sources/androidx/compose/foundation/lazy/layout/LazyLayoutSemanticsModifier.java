package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class LazyLayoutSemanticsModifier extends androidx.compose.ui.node.l0<LazyLayoutSemanticsModifierNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<m> f2652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f2653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Orientation f2654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2656f;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutSemanticsModifier(Function0<? extends m> function0, z zVar, Orientation orientation, boolean z11, boolean z12) {
        this.f2652b = function0;
        this.f2653c = zVar;
        this.f2654d = orientation;
        this.f2655e = z11;
        this.f2656f = z12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutSemanticsModifier)) {
            return false;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = (LazyLayoutSemanticsModifier) obj;
        return this.f2652b == lazyLayoutSemanticsModifier.f2652b && Intrinsics.b(this.f2653c, lazyLayoutSemanticsModifier.f2653c) && this.f2654d == lazyLayoutSemanticsModifier.f2654d && this.f2655e == lazyLayoutSemanticsModifier.f2655e && this.f2656f == lazyLayoutSemanticsModifier.f2656f;
    }

    public int hashCode() {
        return (((((((this.f2652b.hashCode() * 31) + this.f2653c.hashCode()) * 31) + this.f2654d.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f2655e)) * 31) + androidx.compose.foundation.e.a(this.f2656f);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public LazyLayoutSemanticsModifierNode a() {
        return new LazyLayoutSemanticsModifierNode(this.f2652b, this.f2653c, this.f2654d, this.f2655e, this.f2656f);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode) {
        lazyLayoutSemanticsModifierNode.L1(this.f2652b, this.f2653c, this.f2654d, this.f2655e, this.f2656f);
    }
}
