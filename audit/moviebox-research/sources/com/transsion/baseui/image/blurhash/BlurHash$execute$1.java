package com.transsion.baseui.image.blurhash;

import android.graphics.drawable.BitmapDrawable;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsion.baseui.image.blurhash.BlurHash$execute$1", f = "BlurHash.kt", l = {VungleException.WEB_CRASH}, m = "invokeSuspend")
public final class BlurHash$execute$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $blurString;
    final /* synthetic */ int $height;
    final /* synthetic */ Function1<BitmapDrawable, Unit> $response;
    final /* synthetic */ int $width;
    Object L$0;
    int label;
    final /* synthetic */ BlurHash this$0;

    /* JADX INFO: renamed from: com.transsion.baseui.image.blurhash.BlurHash$execute$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.baseui.image.blurhash.BlurHash$execute$1$1", f = "BlurHash.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Object>, Object> {
        final /* synthetic */ Ref.ObjectRef<BitmapDrawable> $blurBitmap;
        final /* synthetic */ String $blurString;
        final /* synthetic */ int $height;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlurHash this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref.ObjectRef<BitmapDrawable> objectRef, String str, int i11, int i12, BlurHash blurHash, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$blurBitmap = objectRef;
            this.$blurString = str;
            this.$width = i11;
            this.$height = i12;
            this.this$0 = blurHash;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$blurBitmap, this.$blurString, this.$width, this.$height, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(k0 k0Var, Continuation<? super Object> continuation) {
            return invoke2(k0Var, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(k0 k0Var, Continuation<Object> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.drawable.BitmapDrawable, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Ref.ObjectRef<BitmapDrawable> objectRef = this.$blurBitmap;
            BitmapDrawable bitmapDrawable = objectRef.element;
            if (bitmapDrawable != null) {
                return bitmapDrawable;
            }
            String str = this.$blurString;
            int i11 = this.$width;
            int i12 = this.$height;
            BlurHash blurHash = this.this$0;
            ?? bitmapDrawable2 = new BitmapDrawable(blurHash.f51387a.getResources(), a.f51394a.b(str, i11, i12, blurHash.f51388b, false));
            objectRef.element = bitmapDrawable2;
            Intrinsics.d(bitmapDrawable2);
            blurHash.e(str, bitmapDrawable2);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlurHash$execute$1(BlurHash blurHash, String str, Function1<? super BitmapDrawable, Unit> function1, int i11, int i12, Continuation<? super BlurHash$execute$1> continuation) {
        super(2, continuation);
        this.this$0 = blurHash;
        this.$blurString = str;
        this.$response = function1;
        this.$width = i11;
        this.$height = i12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BlurHash$execute$1(this.this$0, this.$blurString, this.$response, this.$width, this.$height, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((BlurHash$execute$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.graphics.drawable.BitmapDrawable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = this.this$0.g(this.$blurString);
            CoroutineDispatcher coroutineDispatcherB = w0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef2, this.$blurString, this.$width, this.$height, this.this$0, null);
            this.L$0 = objectRef2;
            this.label = 1;
            if (h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
                return objE;
            }
            objectRef = objectRef2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.b(obj);
        }
        Function1<BitmapDrawable, Unit> function1 = this.$response;
        T t11 = objectRef.element;
        Intrinsics.d(t11);
        function1.invoke(t11);
        return Unit.f68710a;
    }
}
