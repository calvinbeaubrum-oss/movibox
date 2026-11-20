package com.transsion.payment.lib.strategy;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.c0;
import com.transsion.payment.lib.PaymentClientHelper;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.SkuBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
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
public final class PaynicornStrategy implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<List<SkuBean>> f54072a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f54073b = LazyKt__LazyJVMKt.b(new Function0<PaymentService>() { // from class: com.transsion.payment.lib.strategy.PaynicornStrategy$paymentService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentService invoke() {
            return new PaymentService();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f54074c = l0.a(w0.b());

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentService h() {
        return (PaymentService) this.f54073b.getValue();
    }

    @Override // com.transsion.payment.lib.strategy.d
    public void a(AppCompatActivity activity, CreateOrderReq orderRequest, boolean z11, com.transsion.payment.lib.b payCallback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(orderRequest, "orderRequest");
        Intrinsics.g(payCallback, "payCallback");
        com.transsion.payment.lib.d.f54044a.a(g() + " --> requestPay() --> 请求接口创建订单....");
        payCallback.b(true);
        j.d(this.f54074c, null, null, new PaynicornStrategy$requestPay$1(this, orderRequest, activity, payCallback, null), 3, null);
    }

    @Override // com.transsion.payment.lib.strategy.d
    public void b(Boolean bool, com.transsion.payment.lib.b bVar, Function0<Unit> function0) {
        f();
    }

    public void f() {
        j.d(this.f54074c, null, null, new PaynicornStrategy$fetchSkuList$1(this, null), 3, null);
    }

    public String g() {
        return d.a.a(this);
    }

    public final void i(AppCompatActivity appCompatActivity, CreateOrderRes createOrderRes, com.transsion.payment.lib.b bVar) {
        PaymentClientHelper.f54031a.d(appCompatActivity, createOrderRes, bVar, h());
    }

    @Override // com.transsion.payment.lib.strategy.d
    public void init(Application application) {
        Intrinsics.g(application, "application");
        PaymentClientHelper.f54031a.c();
    }
}
