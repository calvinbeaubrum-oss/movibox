package com.transsion.payment.lib;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.HttpErrorBodyBean;
import com.transsion.payment.lib.bean.SkuData;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.HttpException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaymentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f54040a = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.payment.lib.PaymentService$payServerApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    public final String a() {
        String simpleName = PaymentService.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final a b() {
        return (a) this.f54040a.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0069, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x00b1, please report this as an issue */
    public final Object c(Continuation<? super BaseDto<SkuData>> continuation) throws Throwable {
        PaymentService$getSkuList$1 paymentService$getSkuList$1;
        PaymentService paymentService;
        Throwable thM166exceptionOrNullimpl;
        if (continuation instanceof PaymentService$getSkuList$1) {
            paymentService$getSkuList$1 = (PaymentService$getSkuList$1) continuation;
            int i11 = paymentService$getSkuList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentService$getSkuList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentService$getSkuList$1 = new PaymentService$getSkuList$1(this, continuation);
            }
        } else {
            paymentService$getSkuList$1 = new PaymentService$getSkuList$1(this, continuation);
        }
        Object objE = paymentService$getSkuList$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i12 = paymentService$getSkuList$1.label;
        if (i12 != 0) {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            paymentService = (PaymentService) paymentService$getSkuList$1.L$0;
            try {
                ResultKt.b(objE);
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> getSkuList() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> getSkuList() --> code = " + httpException.code() + " -- message = " + httpException.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException.code()), null, "");
            }
        }
        ResultKt.b(objE);
        try {
            Result.Companion companion2 = Result.Companion;
            a aVarB = b();
            String strA = cp.a.f62775a.a();
            paymentService$getSkuList$1.L$0 = this;
            paymentService$getSkuList$1.label = 1;
            objE = aVarB.e(strA, paymentService$getSkuList$1);
            return objE == objE2 ? objE2 : objE;
        } catch (Throwable th3) {
            th = th3;
            paymentService = this;
            Result.Companion companion3 = Result.Companion;
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
            if (thM166exceptionOrNullimpl != null) {
                throw new KotlinNothingValueException();
            }
            if (thM166exceptionOrNullimpl instanceof HttpException) {
                d.f54044a.b(paymentService.a() + " --> getSkuList() --> error = " + thM166exceptionOrNullimpl.getMessage());
                return null;
            }
            HttpException httpException2 = (HttpException) thM166exceptionOrNullimpl;
            d.f54044a.b(paymentService.a() + " --> getSkuList() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
            return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException2.code()), null, "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:31:0x008d  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:47:0x00b9, please report this as an issue */
    public final Object d(String str, Continuation<? super BaseDto<CheckPaymentBean>> continuation) throws Throwable {
        PaymentService$orderCheck4Paynicorn$1 paymentService$orderCheck4Paynicorn$1;
        PaymentService paymentService;
        Throwable thM166exceptionOrNullimpl;
        HttpErrorBodyBean httpErrorBodyBeanA;
        String str2;
        String message;
        String code;
        String reason;
        if (continuation instanceof PaymentService$orderCheck4Paynicorn$1) {
            paymentService$orderCheck4Paynicorn$1 = (PaymentService$orderCheck4Paynicorn$1) continuation;
            int i11 = paymentService$orderCheck4Paynicorn$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentService$orderCheck4Paynicorn$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentService$orderCheck4Paynicorn$1 = new PaymentService$orderCheck4Paynicorn$1(this, continuation);
            }
        } else {
            paymentService$orderCheck4Paynicorn$1 = new PaymentService$orderCheck4Paynicorn$1(this, continuation);
        }
        Object objA = paymentService$orderCheck4Paynicorn$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = paymentService$orderCheck4Paynicorn$1.label;
        if (i12 == 0) {
            ResultKt.b(objA);
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("tradingOrderId", str);
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string, MediaType.Companion.parse("application/json"));
                a aVarB = b();
                String strA = cp.a.f62775a.a();
                paymentService$orderCheck4Paynicorn$1.L$0 = this;
                paymentService$orderCheck4Paynicorn$1.label = 1;
                objA = aVarB.a(strA, requestBodyCreate, paymentService$orderCheck4Paynicorn$1);
                if (objA == objE) {
                    return objE;
                }
                paymentService = this;
            } catch (Throwable th2) {
                th = th2;
                paymentService = this;
                Result.Companion companion3 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> orderCheck4Paynicorn() --> it = " + thM166exceptionOrNullimpl);
                    return null;
                }
                httpErrorBodyBeanA = HttpErrorBodyBean.Companion.a((HttpException) thM166exceptionOrNullimpl);
                str2 = "";
                if (httpErrorBodyBeanA != null || (message = httpErrorBodyBeanA.getMessage()) == null) {
                    message = "";
                }
                if (httpErrorBodyBeanA != null || (code = httpErrorBodyBeanA.getCode()) == null) {
                    code = "";
                }
                if (httpErrorBodyBeanA != null && (reason = httpErrorBodyBeanA.getReason()) != null) {
                    str2 = reason;
                }
                return new BaseDto(message, code, null, str2);
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            paymentService = (PaymentService) paymentService$orderCheck4Paynicorn$1.L$0;
            try {
                ResultKt.b(objA);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion4 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> orderCheck4Paynicorn() --> it = " + thM166exceptionOrNullimpl);
                    return null;
                }
                httpErrorBodyBeanA = HttpErrorBodyBean.Companion.a((HttpException) thM166exceptionOrNullimpl);
                str2 = "";
                if (httpErrorBodyBeanA != null) {
                    message = "";
                } else {
                    message = "";
                }
                if (httpErrorBodyBeanA != null) {
                    code = "";
                } else {
                    code = "";
                }
                if (httpErrorBodyBeanA != null) {
                    str2 = reason;
                }
                return new BaseDto(message, code, null, str2);
            }
        }
        return (BaseDto) objA;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0097  */
    /* JADX WARN: Code duplicated, block: B:31:0x009c  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:35:0x0106  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x009c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00e4, please report this as an issue */
    public final Object e(String str, String str2, String str3, String str4, Continuation<? super BaseDto<CheckPaymentBean>> continuation) throws Throwable {
        PaymentService$paymentOrderCheck$1 paymentService$paymentOrderCheck$1;
        PaymentService paymentService;
        Throwable thM166exceptionOrNullimpl;
        if (continuation instanceof PaymentService$paymentOrderCheck$1) {
            paymentService$paymentOrderCheck$1 = (PaymentService$paymentOrderCheck$1) continuation;
            int i11 = paymentService$paymentOrderCheck$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentService$paymentOrderCheck$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentService$paymentOrderCheck$1 = new PaymentService$paymentOrderCheck$1(this, continuation);
            }
        } else {
            paymentService$paymentOrderCheck$1 = new PaymentService$paymentOrderCheck$1(this, continuation);
        }
        Object objC = paymentService$paymentOrderCheck$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = paymentService$paymentOrderCheck$1.label;
        if (i12 == 0) {
            ResultKt.b(objC);
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("skuId", str);
                jsonObject.addProperty("purchaseToken", str2);
                jsonObject.addProperty("tradingOrderId", str3);
                jsonObject.addProperty("gpOrderId", str4);
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string, MediaType.Companion.parse("application/json"));
                a aVarB = b();
                String strA = cp.a.f62775a.a();
                paymentService$paymentOrderCheck$1.L$0 = this;
                paymentService$paymentOrderCheck$1.label = 1;
                objC = aVarB.c(strA, requestBodyCreate, paymentService$paymentOrderCheck$1);
                if (objC == objE) {
                    return objE;
                }
                paymentService = this;
            } catch (Throwable th2) {
                th = th2;
                paymentService = this;
                Result.Companion companion3 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> paymentOrderCheck() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> paymentOrderCheck() --> code = " + httpException.code() + " -- message = " + httpException.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException.code()), null, "");
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            paymentService = (PaymentService) paymentService$paymentOrderCheck$1.L$0;
            try {
                ResultKt.b(objC);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion4 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> paymentOrderCheck() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException2 = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> paymentOrderCheck() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException2.code()), null, "");
            }
        }
        return (BaseDto) objC;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:33:0x00da  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x0092, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00da, please report this as an issue */
    public final Object f(String str, String str2, Continuation<? super BaseDto<CreateOrderRes>> continuation) throws Throwable {
        PaymentService$paymentOrderCreate4Gp$1 paymentService$paymentOrderCreate4Gp$1;
        PaymentService paymentService;
        Throwable thM166exceptionOrNullimpl;
        if (continuation instanceof PaymentService$paymentOrderCreate4Gp$1) {
            paymentService$paymentOrderCreate4Gp$1 = (PaymentService$paymentOrderCreate4Gp$1) continuation;
            int i11 = paymentService$paymentOrderCreate4Gp$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentService$paymentOrderCreate4Gp$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentService$paymentOrderCreate4Gp$1 = new PaymentService$paymentOrderCreate4Gp$1(this, continuation);
            }
        } else {
            paymentService$paymentOrderCreate4Gp$1 = new PaymentService$paymentOrderCreate4Gp$1(this, continuation);
        }
        Object objB = paymentService$paymentOrderCreate4Gp$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = paymentService$paymentOrderCreate4Gp$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("skuId", str);
                jsonObject.addProperty("cpFrontPage", str2);
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string, MediaType.Companion.parse("application/json"));
                a aVarB = b();
                String strA = cp.a.f62775a.a();
                paymentService$paymentOrderCreate4Gp$1.L$0 = this;
                paymentService$paymentOrderCreate4Gp$1.label = 1;
                objB = aVarB.b(strA, requestBodyCreate, paymentService$paymentOrderCreate4Gp$1);
                if (objB == objE) {
                    return objE;
                }
                paymentService = this;
            } catch (Throwable th2) {
                th = th2;
                paymentService = this;
                Result.Companion companion3 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Gp() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Gp() --> code = " + httpException.code() + " -- message = " + httpException.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException.code()), null, "");
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            paymentService = (PaymentService) paymentService$paymentOrderCreate4Gp$1.L$0;
            try {
                ResultKt.b(objB);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion4 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Gp() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException2 = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Gp() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException2.code()), null, "");
            }
        }
        return (BaseDto) objB;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:33:0x00da  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x0092, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00da, please report this as an issue */
    public final Object g(String str, String str2, Continuation<? super BaseDto<CreateOrderRes>> continuation) throws Throwable {
        PaymentService$paymentOrderCreate4Paynicorn$1 paymentService$paymentOrderCreate4Paynicorn$1;
        PaymentService paymentService;
        Throwable thM166exceptionOrNullimpl;
        if (continuation instanceof PaymentService$paymentOrderCreate4Paynicorn$1) {
            paymentService$paymentOrderCreate4Paynicorn$1 = (PaymentService$paymentOrderCreate4Paynicorn$1) continuation;
            int i11 = paymentService$paymentOrderCreate4Paynicorn$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentService$paymentOrderCreate4Paynicorn$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentService$paymentOrderCreate4Paynicorn$1 = new PaymentService$paymentOrderCreate4Paynicorn$1(this, continuation);
            }
        } else {
            paymentService$paymentOrderCreate4Paynicorn$1 = new PaymentService$paymentOrderCreate4Paynicorn$1(this, continuation);
        }
        Object objD = paymentService$paymentOrderCreate4Paynicorn$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = paymentService$paymentOrderCreate4Paynicorn$1.label;
        if (i12 == 0) {
            ResultKt.b(objD);
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("skuId", str);
                jsonObject.addProperty("cpFrontPage", str2);
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string, MediaType.Companion.parse("application/json"));
                a aVarB = b();
                String strA = cp.a.f62775a.a();
                paymentService$paymentOrderCreate4Paynicorn$1.L$0 = this;
                paymentService$paymentOrderCreate4Paynicorn$1.label = 1;
                objD = aVarB.d(strA, requestBodyCreate, paymentService$paymentOrderCreate4Paynicorn$1);
                if (objD == objE) {
                    return objE;
                }
                paymentService = this;
            } catch (Throwable th2) {
                th = th2;
                paymentService = this;
                Result.Companion companion3 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Paynicorn() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Paynicorn() --> code = " + httpException.code() + " -- message = " + httpException.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException.code()), null, "");
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            paymentService = (PaymentService) paymentService$paymentOrderCreate4Paynicorn$1.L$0;
            try {
                ResultKt.b(objD);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion4 = Result.Companion;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th)));
                if (thM166exceptionOrNullimpl != null) {
                    throw new KotlinNothingValueException();
                }
                if (thM166exceptionOrNullimpl instanceof HttpException) {
                    d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Paynicorn() --> error = " + thM166exceptionOrNullimpl.getMessage());
                    return null;
                }
                HttpException httpException2 = (HttpException) thM166exceptionOrNullimpl;
                d.f54044a.b(paymentService.a() + " --> paymentOrderCreate4Paynicorn() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
                return new BaseDto(String.valueOf(thM166exceptionOrNullimpl.getMessage()), String.valueOf(httpException2.code()), null, "");
            }
        }
        return (BaseDto) objD;
    }
}
