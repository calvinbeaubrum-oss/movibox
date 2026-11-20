package androidx.compose.foundation;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class BackgroundElement extends l0<BackgroundNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1 f2187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f2188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c5 f2189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<e1, Unit> f2190f;

    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundElement(long j11, l1 l1Var, float f11, c5 c5Var, Function1<? super e1, Unit> function1) {
        this.f2186b = j11;
        this.f2187c = l1Var;
        this.f2188d = f11;
        this.f2189e = c5Var;
        this.f2190f = function1;
    }

    public /* synthetic */ BackgroundElement(long j11, l1 l1Var, float f11, c5 c5Var, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? w1.f4564b.e() : j11, (i11 & 2) != 0 ? null : l1Var, f11, c5Var, function1, null);
    }

    public /* synthetic */ BackgroundElement(long j11, l1 l1Var, float f11, c5 c5Var, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, l1Var, f11, c5Var, function1);
    }

    public boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && w1.m(this.f2186b, backgroundElement.f2186b) && Intrinsics.b(this.f2187c, backgroundElement.f2187c) && this.f2188d == backgroundElement.f2188d && Intrinsics.b(this.f2189e, backgroundElement.f2189e);
    }

    public int hashCode() {
        int iS = w1.s(this.f2186b) * 31;
        l1 l1Var = this.f2187c;
        return ((((iS + (l1Var != null ? l1Var.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f2188d)) * 31) + this.f2189e.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public BackgroundNode a() {
        return new BackgroundNode(this.f2186b, this.f2187c, this.f2188d, this.f2189e, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(BackgroundNode backgroundNode) {
        backgroundNode.M1(this.f2186b);
        backgroundNode.L1(this.f2187c);
        backgroundNode.setAlpha(this.f2188d);
        backgroundNode.K0(this.f2189e);
    }
}
