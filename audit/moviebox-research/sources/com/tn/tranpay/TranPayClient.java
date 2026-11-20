package com.tn.tranpay;

import androidx.appcompat.app.AppCompatActivity;
import com.tn.tranpay.fragment.PayLoadingFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public final class TranPayClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TranPayClient f50044a = new TranPayClient();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f50045b;

    public final void b(AppCompatActivity activity, BillingParams params, d callback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(params, "params");
        Intrinsics.g(callback, "callback");
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f50046a;
        if (!tranPayConfiguration.m()) {
            fq.a.e(fq.a.f65215a, "TranPay must be initialized!", null, 2, null);
            callback.a(new b(-1, "TranPay must be initialized!"), null);
            return;
        }
        if (f50045b) {
            return;
        }
        fq.a.g(fq.a.f65215a, "launchBillingFlow and params is " + params, null, 2, null);
        PayLoadingFragment payLoadingFragmentA = PayLoadingFragment.f50111h.a(params, callback);
        payLoadingFragmentA.show(activity.getSupportFragmentManager(), "pay_loading_fragment");
        f50045b = true;
        payLoadingFragmentA.q0(new Function0<Unit>() { // from class: com.tn.tranpay.TranPayClient$launchBillingFlow$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TranPayClient.f50045b = false;
            }
        });
        tranPayConfiguration.z(params);
    }
}
