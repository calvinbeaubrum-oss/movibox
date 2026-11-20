package com.tn.tranpay;

import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.network.BaseDto;
import com.tn.tranpay.network.RetrofitClient;
import hq.g;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class TranPayConfiguration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f50047b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f50050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f50051f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f50053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f50054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f50055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f50056k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f50057l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f50058m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static CurrencyInfoBean f50059n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TranPayConfiguration f50046a = new TranPayConfiguration();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f50048c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f50049d = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f50052g = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f50060o = LazyKt__LazyJVMKt.b(new Function0<gq.b>() { // from class: com.tn.tranpay.TranPayConfiguration$iPaymentApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final gq.b invoke() {
            return (gq.b) RetrofitClient.f50182a.d().b(gq.b.class);
        }
    });

    public final void A() {
        j.d(l0.a(w0.c()), null, null, new TranPayConfiguration$updateCurrencyInfo$1(null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(boolean z11, Continuation<? super CurrencyInfoBean> continuation) throws Throwable {
        TranPayConfiguration$fetchAndUpdateCurrencyInfo$1 tranPayConfiguration$fetchAndUpdateCurrencyInfo$1;
        if (continuation instanceof TranPayConfiguration$fetchAndUpdateCurrencyInfo$1) {
            tranPayConfiguration$fetchAndUpdateCurrencyInfo$1 = (TranPayConfiguration$fetchAndUpdateCurrencyInfo$1) continuation;
            int i11 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label = i11 - Integer.MIN_VALUE;
            } else {
                tranPayConfiguration$fetchAndUpdateCurrencyInfo$1 = new TranPayConfiguration$fetchAndUpdateCurrencyInfo$1(this, continuation);
            }
        } else {
            tranPayConfiguration$fetchAndUpdateCurrencyInfo$1 = new TranPayConfiguration$fetchAndUpdateCurrencyInfo$1(this, continuation);
        }
        Object objL = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label;
        if (i12 == 0) {
            ResultKt.b(objL);
            tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.Z$0 = z11;
            tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label = 1;
            objL = l(tranPayConfiguration$fetchAndUpdateCurrencyInfo$1);
            if (objL == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z11 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.Z$0;
            ResultKt.b(objL);
        }
        BaseDto baseDto = (BaseDto) objL;
        if ((baseDto != null ? (CurrencyInfoBean) baseDto.getData() : null) == null) {
            if (z11) {
                g.f66780a.c(false);
            }
            fq.a.e(fq.a.f65215a, "Failed to update currency info", null, 2, null);
            return null;
        }
        f50059n = (CurrencyInfoBean) baseDto.getData();
        if (z11) {
            g.f66780a.c(true);
        }
        fq.a.g(fq.a.f65215a, "Currency info updated successfully: " + f50059n, null, 2, null);
        CurrencyInfoBean currencyInfoBean = f50059n;
        f50055j = currencyInfoBean != null ? currencyInfoBean.getCountryCode() : null;
        CurrencyInfoBean currencyInfoBean2 = f50059n;
        f50056k = currencyInfoBean2 != null ? currencyInfoBean2.getCurrency() : null;
        return f50059n;
    }

    public final Object d(Continuation<? super CurrencyInfoBean> continuation) {
        CurrencyInfoBean currencyInfoBean = f50059n;
        return currencyInfoBean == null ? c(false, continuation) : currencyInfoBean;
    }

    public final String e() {
        return f50057l;
    }

    public final String f() {
        return f50048c;
    }

    public final String g() {
        return f50049d;
    }

    public final String h() {
        return f50055j;
    }

    public final String i() {
        return f50047b;
    }

    public final String j() {
        return f50056k;
    }

    public final CurrencyInfoBean k() {
        return f50059n;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l(Continuation<? super BaseDto<CurrencyInfoBean>> continuation) throws Throwable {
        TranPayConfiguration$getCurrencyInfoBean$1 tranPayConfiguration$getCurrencyInfoBean$1;
        Object objM163constructorimpl;
        if (continuation instanceof TranPayConfiguration$getCurrencyInfoBean$1) {
            tranPayConfiguration$getCurrencyInfoBean$1 = (TranPayConfiguration$getCurrencyInfoBean$1) continuation;
            int i11 = tranPayConfiguration$getCurrencyInfoBean$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                tranPayConfiguration$getCurrencyInfoBean$1.label = i11 - Integer.MIN_VALUE;
            } else {
                tranPayConfiguration$getCurrencyInfoBean$1 = new TranPayConfiguration$getCurrencyInfoBean$1(this, continuation);
            }
        } else {
            tranPayConfiguration$getCurrencyInfoBean$1 = new TranPayConfiguration$getCurrencyInfoBean$1(this, continuation);
        }
        Object objE = tranPayConfiguration$getCurrencyInfoBean$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i12 = tranPayConfiguration$getCurrencyInfoBean$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objE);
                Result.Companion companion = Result.Companion;
                gq.b bVarN = f50046a.n();
                String str = f50050e;
                tranPayConfiguration$getCurrencyInfoBean$1.label = 1;
                objE = bVarN.e(str, tranPayConfiguration$getCurrencyInfoBean$1);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objE);
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) objE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return objM163constructorimpl;
        }
        fq.a.e(fq.a.f65215a, "Error fetching currency info: " + thM166exceptionOrNullimpl.getMessage(), null, 2, null);
        return null;
    }

    public final boolean m() {
        return f50058m;
    }

    public final gq.b n() {
        Object value = f50060o.getValue();
        Intrinsics.f(value, "<get-iPaymentApi>(...)");
        return (gq.b) value;
    }

    public final String o() {
        return f50053h;
    }

    public final String p() {
        return f50054i;
    }

    public final boolean q() {
        return f50052g;
    }

    public final void r(String str) {
        Intrinsics.g(str, "<set-?>");
        f50048c = str;
    }

    public final void s(String str) {
        Intrinsics.g(str, "<set-?>");
        f50049d = str;
    }

    public final void t(String str) {
        f50047b = str;
    }

    public final void u(boolean z11) {
        f50051f = z11;
    }

    public final void v(boolean z11) {
        f50058m = z11;
    }

    public final void w(boolean z11) {
        f50052g = z11;
    }

    public final void x(String str) {
        f50050e = str;
    }

    public final void y() {
        A();
    }

    public final void z(BillingParams params) {
        Intrinsics.g(params, "params");
        f50053h = params.getOrderId();
        f50056k = params.getCurrency();
        f50057l = params.getAmount();
        f50054i = params.getTxnId();
    }
}
