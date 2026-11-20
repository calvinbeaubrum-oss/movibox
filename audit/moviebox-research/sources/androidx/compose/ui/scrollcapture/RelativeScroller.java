package androidx.compose.ui.scrollcapture;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
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
public final class RelativeScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Float, Continuation<? super Float>, Object> f5574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5575c;

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeScroller(int i11, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> function2) {
        this.f5573a = i11;
        this.f5574b = function2;
    }

    public final float b() {
        return this.f5575c;
    }

    public final int c(int i11) {
        return kotlin.ranges.a.k(i11 - a20.b.d(this.f5575c), 0, this.f5573a);
    }

    public final void d() {
        this.f5575c = 0.0f;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(float f11, Continuation<? super Unit> continuation) throws Throwable {
        RelativeScroller$scrollBy$1 relativeScroller$scrollBy$1;
        RelativeScroller relativeScroller;
        if (continuation instanceof RelativeScroller$scrollBy$1) {
            relativeScroller$scrollBy$1 = (RelativeScroller$scrollBy$1) continuation;
            int i11 = relativeScroller$scrollBy$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                relativeScroller$scrollBy$1.label = i11 - Integer.MIN_VALUE;
            } else {
                relativeScroller$scrollBy$1 = new RelativeScroller$scrollBy$1(this, continuation);
            }
        } else {
            relativeScroller$scrollBy$1 = new RelativeScroller$scrollBy$1(this, continuation);
        }
        Object objInvoke = relativeScroller$scrollBy$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = relativeScroller$scrollBy$1.label;
        if (i12 == 0) {
            ResultKt.b(objInvoke);
            Function2<Float, Continuation<? super Float>, Object> function2 = this.f5574b;
            Float fC = Boxing.c(f11);
            relativeScroller$scrollBy$1.L$0 = this;
            relativeScroller$scrollBy$1.label = 1;
            objInvoke = function2.invoke(fC, relativeScroller$scrollBy$1);
            if (objInvoke == objE) {
                return objE;
            }
            relativeScroller = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            relativeScroller = (RelativeScroller) relativeScroller$scrollBy$1.L$0;
            ResultKt.b(objInvoke);
        }
        relativeScroller.f5575c += ((Number) objInvoke).floatValue();
        return Unit.f68710a;
    }

    public final Object f(int i11, int i12, Continuation<? super Unit> continuation) throws Throwable {
        if (i11 > i12) {
            throw new IllegalArgumentException(("Expected min=" + i11 + " ≤ max=" + i12).toString());
        }
        int i13 = i12 - i11;
        int i14 = this.f5573a;
        if (i13 > i14) {
            throw new IllegalArgumentException(("Expected range (" + i13 + ") to be ≤ viewportSize=" + this.f5573a).toString());
        }
        float f11 = i11;
        float f12 = this.f5575c;
        if (f11 >= f12 && i12 <= i14 + f12) {
            return Unit.f68710a;
        }
        if (f11 >= f12) {
            i11 = i12 - i14;
        }
        Object objG = g(i11, continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final Object g(float f11, Continuation<? super Unit> continuation) throws Throwable {
        Object objE = e(f11 - this.f5575c, continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }
}
