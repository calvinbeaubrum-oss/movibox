package com.transsion.moviedetailapi;

import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.LikeBean;
import com.transsnet.flow.event.sync.SyncManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1", f = "AbsSubjectListViewModel.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend")
public final class AbsSubjectListViewModel$like$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ int $reqType;
    int label;
    final /* synthetic */ AbsSubjectListViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$1", f = "AbsSubjectListViewModel.kt", l = {121, 123}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super LikeBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        final /* synthetic */ int $reqType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AbsSubjectListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, int i11, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$postId = str;
            this.$reqType = i11;
            this.this$0 = absSubjectListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$postId, this.$reqType, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super LikeBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0090  */
        /* JADX WARN: Code duplicated, block: B:25:0x00a4 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            String str;
            LikeBean likeBean;
            Object data;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                b bVar2 = (b) this.L$0;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("postId", this.$postId);
                jsonObject.addProperty("reqType", Boxing.d(this.$reqType));
                if (this.$postId != null) {
                    SyncManager.f61414a.a().e(this.$reqType, this.$postId);
                }
                ip.b.a aVar = ip.b.f67591a;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA != null) {
                    AbsSubjectListViewModel absSubjectListViewModel = this.this$0;
                    String str2 = this.$postId;
                    yu.a aVarQ = absSubjectListViewModel.q();
                    String strA = cp.a.f62775a.a();
                    this.L$0 = bVar2;
                    this.L$1 = str2;
                    this.label = 1;
                    Object objA = aVarQ.a(strA, requestBodyA, this);
                    if (objA == objE) {
                        return objE;
                    }
                    bVar = bVar2;
                    obj = objA;
                    str = str2;
                    BaseDto baseDto = (BaseDto) obj;
                    likeBean = (LikeBean) baseDto.getData();
                    if (likeBean != null) {
                        likeBean.setPostId(str);
                    }
                    data = baseDto.getData();
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    if (bVar.emit(data, this) == objE) {
                        return objE;
                    }
                }
            } else if (i11 == 1) {
                str = (String) this.L$1;
                bVar = (b) this.L$0;
                ResultKt.b(obj);
                BaseDto baseDto2 = (BaseDto) obj;
                likeBean = (LikeBean) baseDto2.getData();
                if (likeBean != null) {
                    likeBean.setPostId(str);
                }
                data = baseDto2.getData();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (bVar.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$2", f = "AbsSubjectListViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super LikeBean>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super LikeBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            uo.b.a.g(uo.b.f78622a, "like error", false, 2, null);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f53876a = new a<>();

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(LikeBean likeBean, Continuation<? super Unit> continuation) {
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsSubjectListViewModel$like$1(String str, int i11, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super AbsSubjectListViewModel$like$1> continuation) {
        super(2, continuation);
        this.$postId = str;
        this.$reqType = i11;
        this.this$0 = absSubjectListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsSubjectListViewModel$like$1(this.$postId, this.$reqType, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AbsSubjectListViewModel$like$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.q(c.o(new AnonymousClass1(this.$postId, this.$reqType, this.this$0, null)), w0.b()), new AnonymousClass2(null));
            Object obj2 = a.f53876a;
            this.label = 1;
            if (aVarE.a(obj2, this) == objE) {
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
