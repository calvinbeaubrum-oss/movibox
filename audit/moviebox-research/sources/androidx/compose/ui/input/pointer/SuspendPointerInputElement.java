package androidx.compose.ui.input.pointer;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
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
public final class SuspendPointerInputElement extends androidx.compose.ui.node.l0<SuspendingPointerInputModifierNodeImpl> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object[] f4648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<h0, Continuation<? super Unit>, Object> f4649e;

    /* JADX WARN: Multi-variable type inference failed */
    public SuspendPointerInputElement(Object obj, Object obj2, Object[] objArr, Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f4646b = obj;
        this.f4647c = obj2;
        this.f4648d = objArr;
        this.f4649e = function2;
    }

    public /* synthetic */ SuspendPointerInputElement(Object obj, Object obj2, Object[] objArr, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : obj, (i11 & 2) != 0 ? null : obj2, (i11 & 4) != 0 ? null : objArr, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        if (!Intrinsics.b(this.f4646b, suspendPointerInputElement.f4646b) || !Intrinsics.b(this.f4647c, suspendPointerInputElement.f4647c)) {
            return false;
        }
        Object[] objArr = this.f4648d;
        if (objArr != null) {
            Object[] objArr2 = suspendPointerInputElement.f4648d;
            if (objArr2 == null || !Arrays.equals(objArr, objArr2)) {
                return false;
            }
        } else if (suspendPointerInputElement.f4648d != null) {
            return false;
        }
        return this.f4649e == suspendPointerInputElement.f4649e;
    }

    public int hashCode() {
        Object obj = this.f4646b;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f4647c;
        int iHashCode2 = (iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object[] objArr = this.f4648d;
        return ((iHashCode2 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31) + this.f4649e.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public SuspendingPointerInputModifierNodeImpl a() {
        return new SuspendingPointerInputModifierNodeImpl(this.f4646b, this.f4647c, this.f4648d, this.f4649e);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl) {
        suspendingPointerInputModifierNodeImpl.M1(this.f4646b, this.f4647c, this.f4648d, this.f4649e);
    }
}
