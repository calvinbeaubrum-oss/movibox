package com.transsion.payment.lib;

import android.app.Application;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog;
import com.transsion.payment.lib.strategy.GoogleStrategy;
import com.transsion.payment.lib.strategy.PaynicornStrategy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PaymentManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f54037b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<PaymentManager> f54038c = LazyKt__LazyJVMKt.b(new Function0<PaymentManager>() { // from class: com.transsion.payment.lib.PaymentManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentManager invoke() {
            return new PaymentManager();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.payment.lib.strategy.d f54039a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaymentManager a() {
            return (PaymentManager) PaymentManager.f54038c.getValue();
        }
    }

    public PaymentManager() {
        fp.b.a aVar = fp.b.f65208a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        String strE = aVar.e(applicationA);
        com.transsion.payment.lib.strategy.d googleStrategy = TextUtils.equals(strE, "gp") ? new GoogleStrategy() : new PaynicornStrategy();
        this.f54039a = googleStrategy;
        d.f54044a.a("PaymentManager() --> init{} --> channel = " + strE + " -- payStrategy = " + googleStrategy.getClass().getSimpleName());
    }

    public final void b(AppCompatActivity activity, String productId, String str, boolean z11, b payCallback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(productId, "productId");
        Intrinsics.g(payCallback, "payCallback");
        CreateOrderReq createOrderReq = new CreateOrderReq(productId, str, z11);
        fp.b.a aVar = fp.b.f65208a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (TextUtils.equals(aVar.e(applicationA), "gp")) {
            com.transsion.payment.lib.strategy.d dVar = this.f54039a;
            if (dVar != null) {
                dVar.a(activity, createOrderReq, z11, payCallback);
                return;
            }
            return;
        }
        PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog = new PaynicornDuringThePaymentDialog();
        paynicornDuringThePaymentDialog.I0(payCallback);
        paynicornDuringThePaymentDialog.J0(createOrderReq);
        paynicornDuringThePaymentDialog.j0(activity, "PaynicornDuringThePaymentDialog");
    }

    public final void c() {
        Application it = Utils.a();
        com.transsion.payment.lib.strategy.d dVar = this.f54039a;
        if (dVar != null) {
            Intrinsics.f(it, "it");
            dVar.init(it);
        }
    }
}
