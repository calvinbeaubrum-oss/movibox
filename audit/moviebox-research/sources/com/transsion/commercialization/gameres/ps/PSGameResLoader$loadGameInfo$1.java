package com.transsion.commercialization.gameres.ps;

import android.content.Context;
import android.view.View;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

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
@DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1", f = "PSGameResLoader.kt", l = {62}, m = "invokeSuspend")
@SourceDebugExtension
public final class PSGameResLoader$loadGameInfo$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<View, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $itemId;
    final /* synthetic */ String $pageName;
    int label;
    final /* synthetic */ PSGameResLoader this$0;

    /* JADX INFO: renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$3", f = "PSGameResLoader.kt", l = {52, 54, DownloadBean.STATUS_COMPLETED_REMOVED}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super List<RecommendInfo>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RequestBody $body;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PSGameResLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(PSGameResLoader pSGameResLoader, RequestBody requestBody, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = pSGameResLoader;
            this.$body = requestBody;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$body, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super List<RecommendInfo>> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlinx.coroutines.flow.b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (kotlinx.coroutines.flow.b) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (kotlinx.coroutines.flow.b) this.L$0;
            a aVarF = this.this$0.f();
            RequestBody requestBody = this.$body;
            String strE = this.this$0.e();
            this.L$0 = bVar;
            this.label = 1;
            obj = aVarF.a(requestBody, strE, this);
            if (obj == objE) {
                return objE;
            }
            PsLinkDto psLinkDto = (PsLinkDto) obj;
            if (psLinkDto.getCode() == 0) {
                List<RecommendInfo> data = psLinkDto.getData();
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                uo.b.f78622a.c("GameResLoader", "PSGameRes fail, code:" + psLinkDto.getCode() + ", msg:" + psLinkDto.getMsg(), true);
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$4", f = "PSGameResLoader.kt", l = {61}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super List<RecommendInfo>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super List<RecommendInfo>> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = bVar;
            anonymousClass4.L$1 = th2;
            return anonymousClass4.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                uo.b.f78622a.c("GameResLoader", "PSGameRes error:" + th2, true);
                this.L$0 = null;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PSGameResLoader$loadGameInfo$1(String str, PSGameResLoader pSGameResLoader, Function1<? super View, Unit> function1, Context context, String str2, Continuation<? super PSGameResLoader$loadGameInfo$1> continuation) {
        super(2, continuation);
        this.$itemId = str;
        this.this$0 = pSGameResLoader;
        this.$callback = function1;
        this.$context = context;
        this.$pageName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PSGameResLoader$loadGameInfo$1(this.$itemId, this.this$0, this.$callback, this.$context, this.$pageName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PSGameResLoader$loadGameInfo$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.$itemId);
            Unit unit = Unit.f68710a;
            jSONObject.put("itemIds", jSONArray);
            for (Map.Entry<String, Object> entry : com.transsion.ad.ps.a.f50553a.a(System.currentTimeMillis()).entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            String string = jSONObject.toString();
            Intrinsics.f(string, "jsonObject.toString()");
            uo.b.f78622a.c("GameResLoader", "PSGameRes loadGameInfo,bodyStr:" + string + " ", true);
            kotlinx.coroutines.flow.a aVarE = c.e(c.o(new AnonymousClass3(this.this$0, ip.b.f67591a.a(string), null)), new AnonymousClass4(null));
            final Function1<View, Unit> function1 = this.$callback;
            final PSGameResLoader pSGameResLoader = this.this$0;
            final Context context = this.$context;
            final String str = this.$pageName;
            final String str2 = this.$itemId;
            kotlinx.coroutines.flow.b bVar = new kotlinx.coroutines.flow.b() { // from class: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1.5

                /* JADX INFO: renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$5$1, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$5$1", f = "PSGameResLoader.kt", l = {}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<View, Unit> $callback;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ String $itemId;
                    final /* synthetic */ String $pageName;
                    final /* synthetic */ List<RecommendInfo> $response;
                    int label;
                    final /* synthetic */ PSGameResLoader this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(List<RecommendInfo> list, Function1<? super View, Unit> function1, PSGameResLoader pSGameResLoader, Context context, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$response = list;
                        this.$callback = function1;
                        this.this$0 = pSGameResLoader;
                        this.$context = context;
                        this.$pageName = str;
                        this.$itemId = str2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$response, this.$callback, this.this$0, this.$context, this.$pageName, this.$itemId, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        RecommendInfo recommendInfo;
                        Unit unit;
                        kotlin.coroutines.intrinsics.a.e();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        List<RecommendInfo> list = this.$response;
                        if (list == null || list.isEmpty() || (recommendInfo = (RecommendInfo) CollectionsKt___CollectionsKt.g0(this.$response)) == null || !Intrinsics.b(recommendInfo.getExists(), Boxing.a(true))) {
                            this.$callback.invoke(null);
                        } else {
                            RecommendInfo recommendInfo2 = (RecommendInfo) CollectionsKt___CollectionsKt.g0(this.$response);
                            if (recommendInfo2 != null) {
                                Function1<View, Unit> function1 = this.$callback;
                                PSGameResLoader pSGameResLoader = this.this$0;
                                Context context = this.$context;
                                String str = this.$pageName;
                                String str2 = this.$itemId;
                                uo.b.a.f(uo.b.f78622a, "GameResLoader", "PSGameRes getGameInfo, success:" + recommendInfo2, false, 4, null);
                                function1.invoke(pSGameResLoader.d(context, pSGameResLoader.c(str, str2, recommendInfo2)));
                                unit = Unit.f68710a;
                            } else {
                                unit = null;
                            }
                            if (unit == null) {
                                this.$callback.invoke(null);
                            }
                        }
                        return Unit.f68710a;
                    }
                }

                @Override // kotlinx.coroutines.flow.b
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(List<RecommendInfo> list, Continuation<? super Unit> continuation) {
                    Object objG = h.g(w0.c(), new AnonymousClass1(list, function1, pSGameResLoader, context, str, str2, null), continuation);
                    return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
                }
            };
            this.label = 1;
            if (aVarE.a(bVar, this) == objE) {
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
