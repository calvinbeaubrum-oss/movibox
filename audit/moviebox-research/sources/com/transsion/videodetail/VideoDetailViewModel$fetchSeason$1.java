package com.transsion.videodetail;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.Worker;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1", f = "VideoDetailViewModel.kt", l = {Worker.WHAT_QUIT}, m = "invokeSuspend")
@SourceDebugExtension
public final class VideoDetailViewModel$fetchSeason$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ VideoDetailViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$2", f = "VideoDetailViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super BaseDto<ResourcesSeasonList>>, Throwable, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(VideoDetailViewModel videoDetailViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = videoDetailViewModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super BaseDto<ResourcesSeasonList>> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.f59859a.q(null);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$3", f = "VideoDetailViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<BaseDto<ResourcesSeasonList>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $subjectId;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(VideoDetailViewModel videoDetailViewModel, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = videoDetailViewModel;
            this.$subjectId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(BaseDto<ResourcesSeasonList> baseDto, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(baseDto, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) this.L$0;
            this.this$0.f59859a.q(baseDto.getData());
            VideoDetailViewModel videoDetailViewModel = this.this$0;
            String str = this.$subjectId;
            ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) baseDto.getData();
            videoDetailViewModel.n(str, resourcesSeasonList != null ? resourcesSeasonList.getSeasons() : null);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailViewModel$fetchSeason$1(String str, VideoDetailViewModel videoDetailViewModel, Continuation<? super VideoDetailViewModel$fetchSeason$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.this$0 = videoDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDetailViewModel$fetchSeason$1(this.$subjectId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoDetailViewModel$fetchSeason$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.a aVarP = kotlinx.coroutines.flow.c.p(this.$subjectId);
            final VideoDetailViewModel videoDetailViewModel = this.this$0;
            final String str = this.$subjectId;
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(FlowKt__ErrorsKt.f(new kotlinx.coroutines.flow.a<BaseDto<ResourcesSeasonList>>() { // from class: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @SourceDebugExtension
                public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ kotlinx.coroutines.flow.b f59873a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ VideoDetailViewModel f59874b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ String f59875c;

                    /* JADX INFO: renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2", f = "VideoDetailViewModel.kt", l = {220, 219}, m = "emit")
                    @SourceDebugExtension
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
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

                    public AnonymousClass2(kotlinx.coroutines.flow.b bVar, VideoDetailViewModel videoDetailViewModel, String str) {
                        this.f59873a = bVar;
                        this.f59874b = videoDetailViewModel;
                        this.f59875c = str;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.b
                    public final Object emit(Object obj, Continuation continuation) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        kotlinx.coroutines.flow.b bVar;
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
                                kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) anonymousClass1.L$0;
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
                        kotlinx.coroutines.flow.b bVar3 = this.f59873a;
                        b bVarX = this.f59874b.x();
                        String str = this.f59875c;
                        anonymousClass1.L$0 = bVar3;
                        anonymousClass1.label = 1;
                        Object objB = b.a.b(bVarX, str, null, anonymousClass1, 2, null);
                        if (objB == objE) {
                            return objE;
                        }
                        obj2 = objB;
                        bVar = bVar3;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        if (bVar.emit(obj2, anonymousClass1) == objE) {
                            return objE;
                        }
                        return Unit.f68710a;
                    }
                }

                @Override // kotlinx.coroutines.flow.a
                public Object a(kotlinx.coroutines.flow.b<? super BaseDto<ResourcesSeasonList>> bVar, Continuation continuation) {
                    Object objA = aVarP.a(new AnonymousClass2(bVar, videoDetailViewModel, str), continuation);
                    return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
                }
            }, 1L, null, 2, null), new AnonymousClass2(this.this$0, null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.c.h(aVarE, anonymousClass3, this) == objE) {
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
