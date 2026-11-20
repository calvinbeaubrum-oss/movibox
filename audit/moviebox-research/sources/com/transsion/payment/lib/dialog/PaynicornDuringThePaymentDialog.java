package com.transsion.payment.lib.dialog;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.payment.lib.PaymentClientHelper;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.d;
import com.transsion.wrapperad.R$drawable;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import j00.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.j;
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
@SourceDebugExtension
public final class PaynicornDuringThePaymentDialog extends BaseMemberLoadingDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CreateOrderRes f54045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CreateOrderReq f54046d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f54047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f54048g = LazyKt__LazyJVMKt.b(new Function0<PaymentService>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$paymentService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentService invoke() {
            return new PaymentService();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f54049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f54050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f54051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f54052k;

    public PaynicornDuringThePaymentDialog() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f54049h = FragmentViewModelLazyKt.a(this, Reflection.b(a.class), new Function0<x0>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f54051j = 3000L;
        this.f54052k = 3000L;
    }

    public static /* synthetic */ void H0(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = PointerIconCompat.TYPE_CROSSHAIR;
        }
        paynicornDuringThePaymentDialog.G0(str, i11);
    }

    public final a A0() {
        return (a) this.f54049h.getValue();
    }

    public final void B0() {
        j.d(v.a(this), null, null, new PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1(this, null), 3, null);
    }

    public final void C0(int i11, String str) {
        d.f54044a.b(g0() + " --> payFail() --> msg = " + str);
        b bVarB = A0().b();
        if (bVarB != null) {
            b.a.a(bVarB, Integer.valueOf(i11), g0() + " --> payFail() --> msg = " + str, false, null, 8, null);
        }
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    public final void D0(BaseDto<CheckPaymentBean> baseDto) {
        String balanceCoin;
        String addCoin;
        d.f54044a.a(g0() + " --> orderCheck4Paynicorn() --> paynicorn 发货成功");
        b bVarB = A0().b();
        if (bVarB != null) {
            CheckPaymentBean data = baseDto.getData();
            int i11 = (data == null || (addCoin = data.getAddCoin()) == null) ? 0 : Integer.parseInt(addCoin);
            CheckPaymentBean data2 = baseDto.getData();
            if (data2 == null || (balanceCoin = data2.getBalanceCoin()) == null) {
                balanceCoin = "";
            }
            CreateOrderRes createOrderRes = this.f54045c;
            bVarB.c(i11, balanceCoin, createOrderRes != null ? createOrderRes.getTradingOrderId() : null);
        }
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    public final void E0(CreateOrderRes createOrderRes) {
        d.f54044a.a(g0() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        this.f54045c = createOrderRes;
        PaymentClientHelper paymentClientHelper = PaymentClientHelper.f54031a;
        FragmentActivity activity = getActivity();
        paymentClientHelper.e(activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null, createOrderRes, new Function2<Integer, String, Unit>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$realPay$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.f68710a;
            }

            public final void invoke(int i11, String msg) {
                Intrinsics.g(msg, "msg");
                this.this$0.C0(i11, msg);
            }
        }, new Function0<Unit>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$realPay$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.B0();
            }
        });
    }

    public final void F0() {
        d.f54044a.a(g0() + " --> requestPay() --> 请求接口创建订单....");
        j.d(v.a(this), null, null, new PaynicornDuringThePaymentDialog$requestPay$1(this, null), 3, null);
    }

    public final void G0(String str, int i11) {
        int i12 = this.f54050i;
        if (i12 >= 3) {
            C0(i11, str);
            return;
        }
        this.f54050i = i12 + 1;
        d.f54044a.a(g0() + " --> retry() --> msg = " + str + " --> retryCount = " + this.f54050i);
        j.d(v.a(this), null, null, new PaynicornDuringThePaymentDialog$retry$1(this, SystemClock.elapsedRealtime(), null), 3, null);
    }

    public final void I0(b callback) {
        Intrinsics.g(callback, "callback");
        this.f54047f = callback;
    }

    public final void J0(CreateOrderReq orderRequest) {
        Intrinsics.g(orderRequest, "orderRequest");
        this.f54046d = orderRequest;
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog
    public void n0(View view, ProgressBar viewLoad, TextView tvLoading) {
        Intrinsics.g(viewLoad, "viewLoad");
        Intrinsics.g(tvLoading, "tvLoading");
        super.n0(view, viewLoad, tvLoading);
        if (view != null) {
            view.setBackgroundResource(R$drawable.ad_shape_dp_8);
        }
        tvLoading.setTextColor(getResources().getColor(R$color.color_d6101114));
        viewLoad.setIndeterminateTintList(ColorStateList.valueOf(getResources().getColor(R$color.base_color_999999)));
    }

    public final void observe() {
        Lifecycle.State state = Lifecycle.State.CREATED;
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog.observe.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e it) {
                Intrinsics.g(it, "it");
                if (it.a() < 0) {
                    PaynicornDuringThePaymentDialog.this.C0(1002, "observe() --> 取消支付");
                    return;
                }
                d.f54044a.a(PaynicornDuringThePaymentDialog.this.g0() + " --> observe() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                PaynicornDuringThePaymentDialog.this.B0();
            }
        };
        a2 a2VarQ = w0.c().q();
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = e.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, state, a2VarQ, false, function1);
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.f54044a.a(g0() + " --> onCreate()");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f54047f = null;
        this.f54046d = null;
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        if (A0().b() == null) {
            A0().c(this.f54047f);
        }
        observe();
        F0();
    }

    public final PaymentService z0() {
        return (PaymentService) this.f54048g.getValue();
    }
}
