package com.tn.tranpay.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.blankj.utilcode.util.Utils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.gson.Gson;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.bean.CreateOrderResultContent;
import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.d;
import com.tn.tranpay.network.RetrofitClient;
import gq.b;
import java.util.Locale;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;
import org.json.JSONObject;

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
@SourceDebugExtension
public final class PaymentViewModel extends t0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1 f50194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50196d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f50200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50202k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f50203l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f50193a = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.tn.tranpay.viewmodel.PaymentViewModel$iPaymentApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) RetrofitClient.f50182a.d().b(b.class);
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Gson f50204m = new Gson();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0<LoadConfigContent> f50205n = new c0<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0<CreateOrderResultContent> f50206o = new c0<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0<dq.b> f50207p = new c0<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c0<Boolean> f50208q = new c0<>();

    public static /* synthetic */ void H(PaymentViewModel paymentViewModel, String str, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 5000;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = TTAdConstant.AD_MAX_EVENT_TIME;
        }
        paymentViewModel.G(str, j13, j12);
    }

    public static /* synthetic */ void h(PaymentViewModel paymentViewModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        paymentViewModel.g(str, str2, str3);
    }

    public static /* synthetic */ void k(PaymentViewModel paymentViewModel, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        paymentViewModel.j(str, str2, str3, z11);
    }

    public final String A() {
        return this.f50195c;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object B(String str, String str2, String str3, Continuation<? super QueryOrderResultContent> continuation) throws Throwable {
        PaymentViewModel$handleCancelPay$1 paymentViewModel$handleCancelPay$1;
        if (continuation instanceof PaymentViewModel$handleCancelPay$1) {
            paymentViewModel$handleCancelPay$1 = (PaymentViewModel$handleCancelPay$1) continuation;
            int i11 = paymentViewModel$handleCancelPay$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentViewModel$handleCancelPay$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentViewModel$handleCancelPay$1 = new PaymentViewModel$handleCancelPay$1(this, continuation);
            }
        } else {
            paymentViewModel$handleCancelPay$1 = new PaymentViewModel$handleCancelPay$1(this, continuation);
        }
        Object objD = paymentViewModel$handleCancelPay$1.result;
        Object objE = a.e();
        int i12 = paymentViewModel$handleCancelPay$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objD);
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("txnId", str);
                jSONObject.put("bindToken", str3);
                jSONObject.put("reason", str2);
                com.tn.tranpay.helper.b.a aVar = com.tn.tranpay.helper.b.f50179a;
                String string = jSONObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA == null) {
                    return null;
                }
                b bVarV = v();
                paymentViewModel$handleCancelPay$1.label = 1;
                objD = bVarV.d(requestBodyA, paymentViewModel$handleCancelPay$1);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objD);
            }
            return (QueryOrderResultContent) objD;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2)));
            if (thM166exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            fq.a.e(fq.a.f65215a, "CancelOrder error is " + thM166exceptionOrNullimpl.getMessage(), null, 2, null);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object C(String str, String str2, String str3, String str4, Continuation<? super CreateOrderResultContent> continuation) throws Throwable {
        PaymentViewModel$handleCashierPay$1 paymentViewModel$handleCashierPay$1;
        PaymentViewModel paymentViewModel;
        String mobileCode;
        if (continuation instanceof PaymentViewModel$handleCashierPay$1) {
            paymentViewModel$handleCashierPay$1 = (PaymentViewModel$handleCashierPay$1) continuation;
            int i11 = paymentViewModel$handleCashierPay$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentViewModel$handleCashierPay$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentViewModel$handleCashierPay$1 = new PaymentViewModel$handleCashierPay$1(this, continuation);
            }
        } else {
            paymentViewModel$handleCashierPay$1 = new PaymentViewModel$handleCashierPay$1(this, continuation);
        }
        Object objD = paymentViewModel$handleCashierPay$1.result;
        Object objE = a.e();
        int i12 = paymentViewModel$handleCashierPay$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    str4 = (String) paymentViewModel$handleCashierPay$1.L$4;
                    str3 = (String) paymentViewModel$handleCashierPay$1.L$3;
                    str2 = (String) paymentViewModel$handleCashierPay$1.L$2;
                    str = (String) paymentViewModel$handleCashierPay$1.L$1;
                    paymentViewModel = (PaymentViewModel) paymentViewModel$handleCashierPay$1.L$0;
                    ResultKt.b(objD);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objD);
                }
                return (CreateOrderResultContent) objD;
            }
            ResultKt.b(objD);
            Result.Companion companion = Result.Companion;
            TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f50046a;
            paymentViewModel$handleCashierPay$1.L$0 = this;
            paymentViewModel$handleCashierPay$1.L$1 = str;
            paymentViewModel$handleCashierPay$1.L$2 = str2;
            paymentViewModel$handleCashierPay$1.L$3 = str3;
            paymentViewModel$handleCashierPay$1.L$4 = str4;
            paymentViewModel$handleCashierPay$1.label = 1;
            objD = tranPayConfiguration.d(paymentViewModel$handleCashierPay$1);
            if (objD == objE) {
                return objE;
            }
            paymentViewModel = this;
            CurrencyInfoBean currencyInfoBean = (CurrencyInfoBean) objD;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("txnId", str);
            jSONObject.put("payMethod", str2);
            JSONObject jSONObject2 = new JSONObject();
            if (str3 != null) {
                LoadConfigContent loadConfigContentF = paymentViewModel.f50205n.f();
                if ((loadConfigContentF == null || (mobileCode = loadConfigContentF.getAreaCode()) == null) && (currencyInfoBean == null || (mobileCode = currencyInfoBean.getMobileCode()) == null)) {
                    mobileCode = "";
                }
                jSONObject2.put("Phone", mobileCode + str3);
            }
            if (str4 != null) {
                jSONObject2.put("CNIC", str4);
            }
            jSONObject.put("payInput", jSONObject2);
            jSONObject.put("pfId", UUID.randomUUID().toString());
            com.tn.tranpay.helper.b.a aVar = com.tn.tranpay.helper.b.f50179a;
            String string = jSONObject.toString();
            Intrinsics.f(string, "json.toString()");
            RequestBody requestBodyA = aVar.a(string);
            if (requestBodyA == null) {
                return null;
            }
            b bVarV = paymentViewModel.v();
            paymentViewModel$handleCashierPay$1.L$0 = null;
            paymentViewModel$handleCashierPay$1.L$1 = null;
            paymentViewModel$handleCashierPay$1.L$2 = null;
            paymentViewModel$handleCashierPay$1.L$3 = null;
            paymentViewModel$handleCashierPay$1.L$4 = null;
            paymentViewModel$handleCashierPay$1.label = 2;
            objD = bVarV.c(requestBodyA, paymentViewModel$handleCashierPay$1);
            if (objD == objE) {
                return objE;
            }
            return (CreateOrderResultContent) objD;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2)));
            if (thM166exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            fq.a.e(fq.a.f65215a, "CashierPay error is " + thM166exceptionOrNullimpl.getMessage(), null, 2, null);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object D(String str, Continuation<? super QueryOrderResultContent> continuation) throws Throwable {
        PaymentViewModel$handleQuery$1 paymentViewModel$handleQuery$1;
        if (continuation instanceof PaymentViewModel$handleQuery$1) {
            paymentViewModel$handleQuery$1 = (PaymentViewModel$handleQuery$1) continuation;
            int i11 = paymentViewModel$handleQuery$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentViewModel$handleQuery$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentViewModel$handleQuery$1 = new PaymentViewModel$handleQuery$1(this, continuation);
            }
        } else {
            paymentViewModel$handleQuery$1 = new PaymentViewModel$handleQuery$1(this, continuation);
        }
        Object objA = paymentViewModel$handleQuery$1.result;
        Object objE = a.e();
        int i12 = paymentViewModel$handleQuery$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objA);
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("txnId", str);
                com.tn.tranpay.helper.b.a aVar = com.tn.tranpay.helper.b.f50179a;
                String string = jSONObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA == null) {
                    return null;
                }
                b bVarV = v();
                paymentViewModel$handleQuery$1.label = 1;
                objA = bVarV.a(requestBodyA, paymentViewModel$handleQuery$1);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objA);
            }
            return (QueryOrderResultContent) objA;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2)));
            if (thM166exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            fq.a.e(fq.a.f65215a, "Query error is " + thM166exceptionOrNullimpl.getMessage(), null, 2, null);
            return null;
        }
    }

    public final void E(BillingParams billingParams) {
        j.d(l0.a(w0.c()), null, null, new PaymentViewModel$loadConfig$1(this, billingParams, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object F(String str, String str2, Continuation<? super LoadConfigContent> continuation) throws Throwable {
        PaymentViewModel$loadConfigBean$1 paymentViewModel$loadConfigBean$1;
        if (continuation instanceof PaymentViewModel$loadConfigBean$1) {
            paymentViewModel$loadConfigBean$1 = (PaymentViewModel$loadConfigBean$1) continuation;
            int i11 = paymentViewModel$loadConfigBean$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                paymentViewModel$loadConfigBean$1.label = i11 - Integer.MIN_VALUE;
            } else {
                paymentViewModel$loadConfigBean$1 = new PaymentViewModel$loadConfigBean$1(this, continuation);
            }
        } else {
            paymentViewModel$loadConfigBean$1 = new PaymentViewModel$loadConfigBean$1(this, continuation);
        }
        Object objB = paymentViewModel$loadConfigBean$1.result;
        Object objE = a.e();
        int i12 = paymentViewModel$loadConfigBean$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objB);
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("txnId", str);
                if (str2 != null) {
                    jSONObject.put("language", str2);
                } else {
                    Application applicationA = Utils.a();
                    if (applicationA != null) {
                        jSONObject.put("language", r(applicationA).getLanguage().toString());
                    }
                }
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                com.tn.tranpay.helper.b.a aVar = com.tn.tranpay.helper.b.f50179a;
                String string = jSONObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA == null) {
                    return null;
                }
                b bVarV = v();
                paymentViewModel$loadConfigBean$1.label = 1;
                objB = bVarV.b(requestBodyA, paymentViewModel$loadConfigBean$1);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objB);
            }
            return (LoadConfigContent) objB;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2)));
            if (thM166exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            fq.a.e(fq.a.f65215a, "LoadConfigFailed error is " + thM166exceptionOrNullimpl.getMessage(), null, 2, null);
            return null;
        }
    }

    public final void G(String txnId, long j11, long j12) {
        Intrinsics.g(txnId, "txnId");
        this.f50194b = j.d(l0.a(w0.c()), null, null, new PaymentViewModel$query$1(j11, j12, this, txnId, null), 3, null);
    }

    public final void I(String str) {
        j.d(l0.a(w0.c()), null, null, new PaymentViewModel$queryOnce$1(this, str, null), 3, null);
    }

    public final void J() {
        q1 q1Var = this.f50194b;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        String str = this.f50195c;
        if (str != null) {
            I(str);
        }
    }

    public final void K(d dVar) {
        this.f50203l = dVar;
    }

    public final void L(boolean z11) {
        this.f50202k = z11;
    }

    public final void M(boolean z11) {
        this.f50201j = z11;
    }

    public final void N(String str) {
        this.f50196d = str;
    }

    public final void O(String str) {
        this.f50200i = str;
    }

    public final void P(String str) {
        this.f50195c = str;
    }

    public final void g(String txnId, String reason, String str) {
        Intrinsics.g(txnId, "txnId");
        Intrinsics.g(reason, "reason");
        j.d(l0.a(w0.c()), null, null, new PaymentViewModel$cancelPay$1(this, txnId, reason, str, null), 3, null);
    }

    public final void i() {
        q1 q1Var = this.f50194b;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
    }

    public final void j(String payMethod, String str, String str2, boolean z11) {
        Intrinsics.g(payMethod, "payMethod");
        this.f50197f = str;
        this.f50198g = str2;
        this.f50199h = z11;
        this.f50208q.n(Boolean.TRUE);
        j.d(l0.a(w0.c()), null, null, new PaymentViewModel$cashierPay$1(this, payMethod, str, str2, null), 3, null);
    }

    public final void l(BillingParams params) {
        Intrinsics.g(params, "params");
        E(params);
    }

    public final String m() {
        String mobileCode;
        String areaCode;
        LoadConfigContent loadConfigContentF = this.f50205n.f();
        if (loadConfigContentF != null && (areaCode = loadConfigContentF.getAreaCode()) != null) {
            return areaCode;
        }
        CurrencyInfoBean currencyInfoBeanK = TranPayConfiguration.f50046a.k();
        return (currencyInfoBeanK == null || (mobileCode = currencyInfoBeanK.getMobileCode()) == null) ? "" : mobileCode;
    }

    public final boolean n() {
        return this.f50199h;
    }

    public final d o() {
        return this.f50203l;
    }

    public final String p() {
        return this.f50198g;
    }

    public final c0<LoadConfigContent> q() {
        return this.f50205n;
    }

    public final Locale r(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = configuration.getLocales().get(0);
            Intrinsics.f(locale, "{\n            configuration.locales[0]\n        }");
            return locale;
        }
        Locale locale2 = configuration.locale;
        Intrinsics.f(locale2, "{\n            configuration.locale\n        }");
        return locale2;
    }

    public final c0<CreateOrderResultContent> s() {
        return this.f50206o;
    }

    public final boolean t() {
        return this.f50202k;
    }

    public final boolean u() {
        return this.f50201j;
    }

    public final b v() {
        Object value = this.f50193a.getValue();
        Intrinsics.f(value, "<get-iPaymentApi>(...)");
        return (b) value;
    }

    public final c0<Boolean> w() {
        return this.f50208q;
    }

    public final String x() {
        return this.f50200i;
    }

    public final String y() {
        return this.f50197f;
    }

    public final c0<dq.b> z() {
        return this.f50207p;
    }
}
