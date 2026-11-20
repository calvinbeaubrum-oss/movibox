package com.transsion.web.fragment;

import com.blankj.utilcode.util.n;
import com.transsion.web.bean.ApiRequestData;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.b0;

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
@DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1", f = "WebFragmentV2.kt", l = {303}, m = "invokeSuspend")
public final class WebFragmentV2$addJsInterface$2$request$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callbackId;
    final /* synthetic */ ApiRequestData $requestData;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ WebFragmentV2 this$0;

    /* JADX INFO: renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$1", f = "WebFragmentV2.kt", l = {285, 289, 296, 298}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApiRequestData $requestData;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WebFragmentV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApiRequestData apiRequestData, WebFragmentV2 webFragmentV2, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestData = apiRequestData;
            this.this$0 = webFragmentV2;
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestData, this.this$0, this.$url, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super String> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f4 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlinx.coroutines.flow.b bVar;
            RequestBody requestBodyA;
            b0 b0Var;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                String upperCase = this.$requestData.getMethods().toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
                if (Intrinsics.b(upperCase, "POST")) {
                    if (this.$requestData.getQueryParams() != null) {
                        ip.b.a aVar = ip.b.f67591a;
                        String strJ = n.j(this.$requestData.getQueryParams());
                        Intrinsics.f(strJ, "toJson(requestData.queryParams)");
                        requestBodyA = aVar.a(strJ);
                    } else {
                        requestBodyA = null;
                    }
                    b00.a aVarW0 = this.this$0.W0();
                    String str = this.$url;
                    Map<String, String> headers = this.$requestData.getHeaders();
                    if (headers == null) {
                        headers = new LinkedHashMap<>();
                    }
                    this.L$0 = bVar;
                    this.label = 1;
                    obj = aVarW0.a(str, headers, requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    b0Var = (b0) obj;
                    if (b0Var.e()) {
                        this.L$0 = null;
                        this.label = 4;
                        if (bVar.emit(null, this) == objE) {
                            return objE;
                        }
                    } else {
                        this.L$0 = null;
                        this.label = 4;
                        if (bVar.emit(null, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    b00.a aVarW1 = this.this$0.W0();
                    String str2 = this.$url;
                    Map<String, String> headers2 = this.$requestData.getHeaders();
                    if (headers2 == null) {
                        headers2 = new LinkedHashMap<>();
                    }
                    Map<String, Object> queryParams = this.$requestData.getQueryParams();
                    if (queryParams == null) {
                        queryParams = new LinkedHashMap<>();
                    }
                    this.L$0 = bVar;
                    this.label = 2;
                    obj = aVarW1.b(str2, headers2, queryParams, this);
                    if (obj == objE) {
                        return objE;
                    }
                    b0Var = (b0) obj;
                    if (b0Var.e()) {
                        this.L$0 = null;
                        this.label = 4;
                        if (bVar.emit(null, this) == objE) {
                            return objE;
                        }
                    } else {
                        this.L$0 = null;
                        this.label = 4;
                        if (bVar.emit(null, this) == objE) {
                            return objE;
                        }
                    }
                }
            } else if (i11 == 1) {
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                b0Var = (b0) obj;
                if (b0Var.e()) {
                    this.L$0 = null;
                    this.label = 4;
                    if (bVar.emit(null, this) == objE) {
                        return objE;
                    }
                } else {
                    this.L$0 = null;
                    this.label = 4;
                    if (bVar.emit(null, this) == objE) {
                        return objE;
                    }
                }
            } else if (i11 == 2) {
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                b0Var = (b0) obj;
                if (b0Var.e() || b0Var.a() == null) {
                    this.L$0 = null;
                    this.label = 4;
                    if (bVar.emit(null, this) == objE) {
                        return objE;
                    }
                } else {
                    Object objA = b0Var.a();
                    Intrinsics.d(objA);
                    String strString = ((ResponseBody) objA).string();
                    this.L$0 = null;
                    this.label = 3;
                    if (bVar.emit(strString, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 3 && i11 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$2", f = "WebFragmentV2.kt", l = {302}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super String>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super String> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            anonymousClass2.L$1 = th2;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                uo.b.a aVar = uo.b.f78622a;
                String TAG = WebFragmentV2.f60174r.a();
                Intrinsics.f(TAG, "TAG");
                aVar.c(TAG, "requestApiData, error :" + th2, true);
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

    /* JADX INFO: renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass3<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebFragmentV2 f60185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f60186b;

        /* JADX INFO: renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$request$1$3$1", f = "WebFragmentV2.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f68710a;
            }
        }

        public AnonymousClass3(WebFragmentV2 webFragmentV2, String str) {
            this.f60185a = webFragmentV2;
            this.f60186b = str;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(String str, Continuation<? super Unit> continuation) throws Throwable {
            WebFragmentV2$addJsInterface$2$request$1$3$emit$1 webFragmentV2$addJsInterface$2$request$1$3$emit$1;
            AnonymousClass3<T> anonymousClass3;
            if (continuation instanceof WebFragmentV2$addJsInterface$2$request$1$3$emit$1) {
                webFragmentV2$addJsInterface$2$request$1$3$emit$1 = (WebFragmentV2$addJsInterface$2$request$1$3$emit$1) continuation;
                int i11 = webFragmentV2$addJsInterface$2$request$1$3$emit$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    webFragmentV2$addJsInterface$2$request$1$3$emit$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    webFragmentV2$addJsInterface$2$request$1$3$emit$1 = new WebFragmentV2$addJsInterface$2$request$1$3$emit$1(this, continuation);
                }
            } else {
                webFragmentV2$addJsInterface$2$request$1$3$emit$1 = new WebFragmentV2$addJsInterface$2$request$1$3$emit$1(this, continuation);
            }
            Object obj = webFragmentV2$addJsInterface$2$request$1$3$emit$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = webFragmentV2$addJsInterface$2$request$1$3$emit$1.label;
            if (i12 == 0) {
                ResultKt.b(obj);
                a2 a2VarC = w0.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                webFragmentV2$addJsInterface$2$request$1$3$emit$1.L$0 = this;
                webFragmentV2$addJsInterface$2$request$1$3$emit$1.L$1 = str;
                webFragmentV2$addJsInterface$2$request$1$3$emit$1.label = 1;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, webFragmentV2$addJsInterface$2$request$1$3$emit$1) == objE) {
                    return objE;
                }
                anonymousClass3 = this;
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) webFragmentV2$addJsInterface$2$request$1$3$emit$1.L$1;
                anonymousClass3 = (AnonymousClass3) webFragmentV2$addJsInterface$2$request$1$3$emit$1.L$0;
                ResultKt.b(obj);
            }
            if (str == null || str.length() == 0) {
                anonymousClass3.f60185a.s0().sendResponse("", anonymousClass3.f60186b);
            } else {
                uo.b.a aVar = uo.b.f78622a;
                String TAG = WebFragmentV2.f60174r.a();
                Intrinsics.f(TAG, "TAG");
                aVar.c(TAG, "requestApiData, success :" + str, true);
                anonymousClass3.f60185a.s0().sendResponse(str, anonymousClass3.f60186b);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragmentV2$addJsInterface$2$request$1(ApiRequestData apiRequestData, WebFragmentV2 webFragmentV2, String str, String str2, Continuation<? super WebFragmentV2$addJsInterface$2$request$1> continuation) {
        super(2, continuation);
        this.$requestData = apiRequestData;
        this.this$0 = webFragmentV2;
        this.$url = str;
        this.$callbackId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebFragmentV2$addJsInterface$2$request$1(this.$requestData, this.this$0, this.$url, this.$callbackId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WebFragmentV2$addJsInterface$2$request$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.$requestData, this.this$0, this.$url, null)), new AnonymousClass2(null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$callbackId);
            this.label = 1;
            if (aVarE.a(anonymousClass3, this) == objE) {
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
