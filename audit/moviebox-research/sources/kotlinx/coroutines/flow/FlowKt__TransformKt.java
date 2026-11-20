package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
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
public final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> a<T> a(final a<? extends T> aVar, final Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new a<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @SourceDebugExtension
            public static final class AnonymousClass2<T> implements b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f69353a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Function2 f69354b;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {219, 220}, m = "emit")
                @SourceDebugExtension
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(b bVar, Function2 function2) {
                    this.f69353a = bVar;
                    this.f69354b = function2;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.b
                public final Object emit(T t11, Continuation<? super Unit> continuation) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    Object obj;
                    b bVar;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i11 = anonymousClass1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i12 = anonymousClass1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            b bVar2 = (b) anonymousClass1.L$1;
                            obj = anonymousClass1.L$0;
                            ResultKt.b(obj2);
                            bVar = bVar2;
                        } else {
                            if (i12 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj2);
                        }
                        return Unit.f68710a;
                    }
                    ResultKt.b(obj2);
                    b bVar3 = this.f69353a;
                    Function2 function2 = this.f69354b;
                    anonymousClass1.L$0 = t11;
                    anonymousClass1.L$1 = bVar3;
                    anonymousClass1.label = 1;
                    InlineMarker.c(6);
                    Object objInvoke = function2.invoke(t11, anonymousClass1);
                    InlineMarker.c(7);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    obj = t11;
                    bVar = bVar3;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                    if (bVar.emit(obj, anonymousClass1) == objE) {
                        return objE;
                    }
                    return Unit.f68710a;
                }
            }

            @Override // kotlinx.coroutines.flow.a
            public Object a(b bVar, Continuation continuation) {
                Object objA = aVar.a(new AnonymousClass2(bVar, function2), continuation);
                return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
            }
        };
    }
}
