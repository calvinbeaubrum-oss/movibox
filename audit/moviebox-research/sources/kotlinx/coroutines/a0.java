package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Object f69193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final l f69194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final Function1<Throwable, Unit> f69195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final Object f69196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public final Throwable f69197e;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Object obj, l lVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th2) {
        this.f69193a = obj;
        this.f69194b = lVar;
        this.f69195c = function1;
        this.f69196d = obj2;
        this.f69197e = th2;
    }

    public /* synthetic */ a0(Object obj, l lVar, Function1 function1, Object obj2, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i11 & 2) != 0 ? null : lVar, (i11 & 4) != 0 ? null : function1, (i11 & 8) != 0 ? null : obj2, (i11 & 16) != 0 ? null : th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a0 b(a0 a0Var, Object obj, l lVar, Function1 function1, Object obj2, Throwable th2, int i11, Object obj3) {
        if ((i11 & 1) != 0) {
            obj = a0Var.f69193a;
        }
        if ((i11 & 2) != 0) {
            lVar = a0Var.f69194b;
        }
        l lVar2 = lVar;
        if ((i11 & 4) != 0) {
            function1 = a0Var.f69195c;
        }
        Function1 function2 = function1;
        if ((i11 & 8) != 0) {
            obj2 = a0Var.f69196d;
        }
        Object obj4 = obj2;
        if ((i11 & 16) != 0) {
            th2 = a0Var.f69197e;
        }
        return a0Var.a(obj, lVar2, function2, obj4, th2);
    }

    public final a0 a(Object obj, l lVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th2) {
        return new a0(obj, lVar, function1, obj2, th2);
    }

    public final boolean c() {
        return this.f69197e != null;
    }

    public final void d(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th2) {
        l lVar = this.f69194b;
        if (lVar != null) {
            cancellableContinuationImpl.callCancelHandler(lVar, th2);
        }
        Function1<Throwable, Unit> function1 = this.f69195c;
        if (function1 != null) {
            cancellableContinuationImpl.callOnCancellation(function1, th2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.b(this.f69193a, a0Var.f69193a) && Intrinsics.b(this.f69194b, a0Var.f69194b) && Intrinsics.b(this.f69195c, a0Var.f69195c) && Intrinsics.b(this.f69196d, a0Var.f69196d) && Intrinsics.b(this.f69197e, a0Var.f69197e);
    }

    public int hashCode() {
        Object obj = this.f69193a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        l lVar = this.f69194b;
        int iHashCode2 = (iHashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f69195c;
        int iHashCode3 = (iHashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f69196d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f69197e;
        return iHashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f69193a + ", cancelHandler=" + this.f69194b + ", onCancellation=" + this.f69195c + ", idempotentResume=" + this.f69196d + ", cancelCause=" + this.f69197e + ')';
    }
}
