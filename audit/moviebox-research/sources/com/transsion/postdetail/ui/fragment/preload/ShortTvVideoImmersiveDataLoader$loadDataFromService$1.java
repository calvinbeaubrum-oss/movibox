package com.transsion.postdetail.ui.fragment.preload;

import androidx.core.view.MotionEventCompat;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;
import xv.d;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1", f = "ShortTvVideoImmersiveDataLoader.kt", l = {MotionEventCompat.AXIS_GENERIC_14}, m = "invokeSuspend")
public final class ShortTvVideoImmersiveDataLoader$loadDataFromService$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShortTvVideoImmersiveDataLoader this$0;

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$1", f = "ShortTvVideoImmersiveDataLoader.kt", l = {33, 35, 37, 39}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super ShortTVRespData>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShortTvVideoImmersiveDataLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = shortTvVideoImmersiveDataLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super ShortTVRespData> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x009a  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a4 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            Unit unit;
            b bVar2;
            Object objE = a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar2 = (b) this.L$0;
                    ResultKt.b(obj);
                } else if (i11 == 2 || i11 == 3) {
                    bVar2 = (b) this.L$0;
                    ResultKt.b(obj);
                    bVar = bVar2;
                    unit = Unit.f68710a;
                    if (unit == null) {
                        this.L$0 = null;
                        this.label = 4;
                        if (bVar.emit(null, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (b) this.L$0;
            ip.b.a aVar = ip.b.f67591a;
            String strJ = n.j(this.this$0.m());
            Intrinsics.f(strJ, "toJson(requestEntity)");
            RequestBody requestBodyA = aVar.a(strJ);
            if (requestBodyA != null) {
                d dVarN = this.this$0.n();
                String strA = cp.a.f62775a.a();
                this.L$0 = bVar;
                this.label = 1;
                Object objC = dVarN.c(strA, requestBodyA, this);
                if (objC == objE) {
                    return objE;
                }
                bVar2 = bVar;
                obj = objC;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.L$0 = null;
                this.label = 4;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                Object data = baseDto.getData();
                this.L$0 = bVar2;
                this.label = 3;
                if (bVar2.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                this.L$0 = bVar2;
                this.label = 2;
                if (bVar2.emit(null, this) == objE) {
                    return objE;
                }
            }
            bVar = bVar2;
            unit = Unit.f68710a;
            if (unit == null) {
                this.L$0 = null;
                this.label = 4;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$2", f = "ShortTvVideoImmersiveDataLoader.kt", l = {41}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super ShortTVRespData>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super ShortTVRespData> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                b bVar = (b) this.L$0;
                this.label = 1;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$3", f = "ShortTvVideoImmersiveDataLoader.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<b<? super ShortTVRespData>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShortTvVideoImmersiveDataLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.this$0 = shortTvVideoImmersiveDataLoader;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super ShortTVRespData> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
            anonymousClass3.L$0 = th2;
            return anonymousClass3.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Throwable th2 = (Throwable) this.L$0;
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.this$0.b();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, String.valueOf(th2.getMessage()), false, 4, null);
            this.this$0.c(null);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass4<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTvVideoImmersiveDataLoader f55912a;

        public AnonymousClass4(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader) {
            this.f55912a = shortTvVideoImmersiveDataLoader;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(ShortTVRespData shortTVRespData, Continuation<? super Unit> continuation) throws Throwable {
            ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1 shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1;
            AnonymousClass4<T> anonymousClass4;
            if (continuation instanceof ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1) {
                shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1 = (ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1) continuation;
                int i11 = shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1 = new ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1(this, continuation);
                }
            } else {
                shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1 = new ShortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1(this, continuation);
            }
            Object obj = shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.result;
            Object objE = a.e();
            int i12 = shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.label;
            if (i12 == 0) {
                ResultKt.b(obj);
                ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.f55912a;
                shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.L$0 = this;
                shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.L$1 = shortTVRespData;
                shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.label = 1;
                if (shortTvVideoImmersiveDataLoader.o(shortTVRespData, shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1) == objE) {
                    return objE;
                }
                anonymousClass4 = this;
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                shortTVRespData = (ShortTVRespData) shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.L$1;
                anonymousClass4 = (AnonymousClass4) shortTvVideoImmersiveDataLoader$loadDataFromService$1$4$emit$1.L$0;
                ResultKt.b(obj);
            }
            anonymousClass4.f55912a.d(shortTVRespData);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoImmersiveDataLoader$loadDataFromService$1(ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader, Continuation<? super ShortTvVideoImmersiveDataLoader$loadDataFromService$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvVideoImmersiveDataLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvVideoImmersiveDataLoader$loadDataFromService$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvVideoImmersiveDataLoader$loadDataFromService$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.e(c.q(c.o(new AnonymousClass1(this.this$0, null)), w0.b()), new AnonymousClass2(null)), new AnonymousClass3(this.this$0, null));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0);
            this.label = 1;
            if (aVarE.a(anonymousClass4, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
