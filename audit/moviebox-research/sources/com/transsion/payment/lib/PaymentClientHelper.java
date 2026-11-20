package com.transsion.payment.lib;

import android.app.Application;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayClient;
import com.tn.tranpay.e;
import com.tn.tranpay.logger.LogLevel;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.PrePayInfo;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaymentClientHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PaymentClientHelper f54031a = new PaymentClientHelper();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.tn.tranpay.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<Integer, String, Unit> f54032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f54033b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Integer, ? super String, Unit> function2, Function0<Unit> function0) {
            this.f54032a = function2;
            this.f54033b = function0;
        }

        @Override // com.tn.tranpay.d
        public void a(com.tn.tranpay.b result, com.tn.tranpay.c cVar) {
            Intrinsics.g(result, "result");
            d dVar = d.f54044a;
            dVar.a("onPurchasesUpdated " + result + ", " + cVar);
            if (com.tn.tranpay.a.f50061a.a(result.b()) && cVar != null) {
                dVar.a(PaymentClientHelper.f54031a.b() + " --> observe() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                this.f54033b.invoke();
                return;
            }
            PaymentClientHelper paymentClientHelper = PaymentClientHelper.f54031a;
            dVar.b(paymentClientHelper.b() + " --> realPay() --> paynicorn result is cancel");
            int iB = result.b();
            if (iB == 1) {
                this.f54032a.invoke(1002, "observe() --> 取消支付");
                return;
            }
            if (iB != 4) {
                this.f54032a.invoke(1004, "observe() --> 支付失败");
                return;
            }
            dVar.a(paymentClientHelper.b() + " --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
            this.f54032a.invoke(1003, "observe() --> 支付进行中");
        }
    }

    public final String b() {
        String simpleName = PaymentClientHelper.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void c() {
        String upperCase;
        String str;
        String string;
        MMKV mmkvC = ip.a.f67589a.c();
        String upperCase2 = null;
        if (mmkvC == null || (string = mmkvC.getString("custom_local_iso", "")) == null) {
            upperCase = null;
        } else {
            upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase, "toUpperCase(...)");
        }
        if (TextUtils.isEmpty(upperCase)) {
            String strF = TNDeviceHelper.f49455a.f();
            if (strF != null) {
                upperCase2 = strF.toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase2, "toUpperCase(...)");
            }
            str = upperCase2;
        } else {
            str = upperCase;
        }
        fp.b.a aVar = fp.b.f65208a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        String strE = aVar.e(applicationA);
        if (strE == null) {
            strE = "gp";
        }
        String str2 = strE;
        TranPay tranPay = TranPay.f50043a;
        Application applicationA2 = Utils.a();
        Intrinsics.f(applicationA2, "getApp()");
        tranPay.b(applicationA2, "3100484", c.f54041a.b(), str2, (320 & 16) != 0 ? LogLevel.INFO : LogLevel.DEBUG, (320 & 32) != 0 ? false : false, (320 & 64) != 0, (320 & 128) != 0 ? null : str, (320 & 256) != 0 ? e.f50084c.b() : null);
        tranPay.a(new PayLoggerPlugin());
    }

    public final void d(AppCompatActivity activity, final CreateOrderRes orderRequest, final b payCallback, final PaymentService paymentService) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(orderRequest, "orderRequest");
        Intrinsics.g(payCallback, "payCallback");
        Intrinsics.g(paymentService, "paymentService");
        d.f54044a.a(b() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        PrePayInfo prePayInfo = orderRequest.getPrePayInfo();
        if ((prePayInfo != null ? prePayInfo.getOrderId() : null) == null || prePayInfo.getDescription() == null) {
            b.a.a(payCallback, 1001, "订单信息异常", false, null, 8, null);
            return;
        }
        payCallback.b(false);
        String price = prePayInfo.getPrice();
        if (price == null) {
            price = "0";
        }
        String str = price;
        String orderId = prePayInfo.getOrderId();
        String str2 = orderId == null ? "" : orderId;
        String description = prePayInfo.getDescription();
        String str3 = description == null ? "" : description;
        String txnId = orderRequest.getTxnId();
        String currency = prePayInfo.getCurrency();
        String referenceNo = prePayInfo.getReferenceNo();
        String str4 = referenceNo == null ? "" : referenceNo;
        String memo = prePayInfo.getMemo();
        Boolean payByLocalCurrency = prePayInfo.getPayByLocalCurrency();
        TranPayClient.f50044a.b(activity, new BillingParams(str, str2, str3, txnId, currency, str4, memo, null, null, false, payByLocalCurrency != null ? payByLocalCurrency.booleanValue() : false, 384, null), new com.tn.tranpay.d() { // from class: com.transsion.payment.lib.PaymentClientHelper$realPay$1
            @Override // com.tn.tranpay.d
            public void a(com.tn.tranpay.b result, com.tn.tranpay.c cVar) {
                Intrinsics.g(result, "result");
                d dVar = d.f54044a;
                dVar.a("onPurchasesUpdated " + result + ", " + cVar);
                if (com.tn.tranpay.a.f50061a.a(result.b()) && cVar != null) {
                    dVar.a(PaymentClientHelper.f54031a.b() + " --> realPay() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                    payCallback.b(true);
                    j.d(l0.a(w0.b()), null, null, new PaymentClientHelper$realPay$1$onPurchasesUpdated$1(payCallback, orderRequest, paymentService, null), 3, null);
                    return;
                }
                PaymentClientHelper paymentClientHelper = PaymentClientHelper.f54031a;
                dVar.b(paymentClientHelper.b() + " --> realPay() --> paynicorn result is cancel");
                payCallback.b(false);
                int iB = result.b();
                if (iB == 1) {
                    payCallback.a(1002, result.a(), false, orderRequest.getTradingOrderId());
                    return;
                }
                if (iB != 4) {
                    payCallback.a(1004, "observe() --> 支付失败", false, orderRequest.getTradingOrderId());
                    return;
                }
                dVar.a(paymentClientHelper.b() + " --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
                payCallback.a(1003, "orderCheck4Paynicorn() --> code = 400 -- 支付未完成", false, orderRequest.getTradingOrderId());
            }
        });
    }

    public final void e(AppCompatActivity appCompatActivity, CreateOrderRes createOrderRes, Function2<? super Integer, ? super String, Unit> payFail, Function0<Unit> orderCheck4Paynicorn) {
        Intrinsics.g(payFail, "payFail");
        Intrinsics.g(orderCheck4Paynicorn, "orderCheck4Paynicorn");
        d.f54044a.a(b() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        PrePayInfo prePayInfo = createOrderRes != null ? createOrderRes.getPrePayInfo() : null;
        if ((prePayInfo != null ? prePayInfo.getOrderId() : null) == null || prePayInfo.getDescription() == null) {
            payFail.invoke(1001, "realPay() --> 打开端内WebView --> 展示收银台 -- > activity == null");
            return;
        }
        String price = prePayInfo.getPrice();
        if (price == null) {
            price = "0";
        }
        String str = price;
        String orderId = prePayInfo.getOrderId();
        String str2 = orderId == null ? "" : orderId;
        String description = prePayInfo.getDescription();
        String str3 = description == null ? "" : description;
        String txnId = createOrderRes.getTxnId();
        String currency = prePayInfo.getCurrency();
        String referenceNo = prePayInfo.getReferenceNo();
        String memo = prePayInfo.getMemo();
        Boolean payByLocalCurrency = prePayInfo.getPayByLocalCurrency();
        BillingParams billingParams = new BillingParams(str, str2, str3, txnId, currency, referenceNo, memo, null, null, false, payByLocalCurrency != null ? payByLocalCurrency.booleanValue() : false, 384, null);
        if (appCompatActivity != null) {
            TranPayClient.f50044a.b(appCompatActivity, billingParams, new a(payFail, orderCheck4Paynicorn));
        }
    }
}
