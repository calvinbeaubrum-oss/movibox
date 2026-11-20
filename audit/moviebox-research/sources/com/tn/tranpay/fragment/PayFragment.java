package com.tn.tranpay.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.google.gson.Gson;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.activity.TranPayWebActivity;
import com.tn.tranpay.bean.CreateOrderResultContent;
import com.tn.tranpay.bean.HandleResultType;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import com.tn.tranpay.event.AppScopeVMlProvider;
import com.tn.tranpay.event.FlowEventBus;
import com.tn.tranpay.helper.PayUtils;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;

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
public final class PayFragment extends DialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f50100j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f50101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1 f50102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BillingParams f50103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.tn.tranpay.d f50104d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoadConfigContent f50105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f50106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f50107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50108i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayFragment a(BillingParams params, LoadConfigContent loadConfigContent, com.tn.tranpay.d dVar) {
            Intrinsics.g(params, "params");
            PayFragment payFragment = new PayFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", params);
            bundle.putParcelable("configBean", loadConfigContent);
            payFragment.setArguments(bundle);
            payFragment.f50103c = params;
            payFragment.f50105f = loadConfigContent;
            payFragment.f50104d = dVar;
            return payFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f50109a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f50109a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f50109a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f50109a.invoke(obj);
        }
    }

    public PayFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f50106g = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$2
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
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$3
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
    }

    public static final boolean D0(PayFragment this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.x0();
        return true;
    }

    private final void F0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.f(attributes, "it.attributes");
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = f0.a(533.0f);
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    public static /* synthetic */ void s0(PayFragment payFragment, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str2 = null;
        }
        payFragment.r0(i11, str, str2);
    }

    public final void A0(String str) {
        Application applicationA = Utils.a();
        if (applicationA != null) {
            Intent intent = new Intent();
            intent.putExtra("url", str);
            BillingParams billingParams = this.f50103c;
            intent.putExtra("cpFrontPage", billingParams != null ? billingParams.getCpFrontPage() : null);
            BillingParams billingParams2 = this.f50103c;
            intent.putExtra("shouldOpenCpFrontPage", billingParams2 != null ? Boolean.valueOf(billingParams2.getShouldOpenCpFrontPage()) : null);
            intent.setClass(applicationA, TranPayWebActivity.class);
            intent.addFlags(ASTNode.DEOP);
            Application applicationA2 = Utils.a();
            if (applicationA2 != null) {
                applicationA2.startActivity(intent);
            }
        }
    }

    public final void B0() {
        final Gson gson = new Gson();
        Transformations.a(v0().s()).j(getViewLifecycleOwner(), new c(new Function1<CreateOrderResultContent, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CreateOrderResultContent createOrderResultContent) {
                invoke2(createOrderResultContent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CreateOrderResultContent createOrderResultContent) {
                fq.a aVar = fq.a.f65215a;
                fq.a.g(aVar, "resultContent is " + gson.toJson(createOrderResultContent) + ", " + (createOrderResultContent != null ? createOrderResultContent.getStatus() : null), null, 2, null);
                PayFragment.b bVarU0 = this.u0();
                if (bVarU0 != null) {
                    bVarU0.a();
                }
                if (this.v0().u()) {
                    return;
                }
                if (createOrderResultContent == null) {
                    this.v0().w().n(Boolean.FALSE);
                    hq.g.f66780a.k(false, this.v0().y(), this.v0().p(), this.v0().n());
                    PayFragment.s0(this, 5, "Create order failed", null, 4, null);
                    return;
                }
                if (!Intrinsics.b(createOrderResultContent.getCode(), "0000") || Intrinsics.b(createOrderResultContent.getStatus(), "0") || createOrderResultContent.getTxnId() == null) {
                    this.v0().w().n(Boolean.FALSE);
                    hq.g.f66780a.k(false, this.v0().y(), this.v0().p(), this.v0().n());
                    this.r0(5, createOrderResultContent.getMessage(), createOrderResultContent.getCode());
                    return;
                }
                this.v0().M(true);
                fq.a.g(aVar, "createOrderResultLiveData: " + gson.toJson(createOrderResultContent), null, 2, null);
                hq.g.f66780a.k(true, this.v0().y(), this.v0().p(), this.v0().n());
                HandleResultType handleResultTypeZ0 = this.z0(createOrderResultContent);
                if (handleResultTypeZ0 != HandleResultType.APP_LINK && handleResultTypeZ0 != HandleResultType.OPERATOR) {
                    this.v0().w().n(Boolean.FALSE);
                    return;
                }
                PaymentViewModel paymentViewModelV0 = this.v0();
                String txnId = createOrderResultContent.getTxnId();
                Intrinsics.d(txnId);
                PaymentViewModel.H(paymentViewModelV0, txnId, 0L, 0L, 6, null);
            }
        }));
        v0().z().j(getViewLifecycleOwner(), new c(new Function1<dq.b, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$2

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f50110a;

                static {
                    int[] iArr = new int[QueryStatus.values().length];
                    try {
                        iArr[QueryStatus.FAILURE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[QueryStatus.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[QueryStatus.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[QueryStatus.PROCESSING.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[QueryStatus.CANCELLED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f50110a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(dq.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(dq.b bVar) {
                String message;
                String message2;
                fq.a aVar = fq.a.f65215a;
                fq.a.g(aVar, "resultContent is " + gson.toJson(bVar) + ", " + (bVar != null ? bVar.b() : null), null, 2, null);
                if (bVar != null) {
                    PayFragment payFragment = this;
                    QueryOrderResultContent queryOrderResultContentA = bVar.a();
                    int i11 = a.f50110a[bVar.b().ordinal()];
                    if (i11 == 1) {
                        fq.a.g(aVar, "支付失败", null, 2, null);
                        if (queryOrderResultContentA == null || (message = queryOrderResultContentA.getMessage()) == null) {
                            message = "Payment failed";
                        }
                        Intrinsics.d(queryOrderResultContentA);
                        payFragment.r0(6, message, queryOrderResultContentA.getCode());
                        return;
                    }
                    if (i11 == 2) {
                        fq.a.g(aVar, "支付成功", null, 2, null);
                        PaymentMMKV.f50174a.a().putString("k_pay_method_code", payFragment.v0().x());
                        if (queryOrderResultContentA == null || (message2 = queryOrderResultContentA.getMessage()) == null) {
                            message2 = "Payment success";
                        }
                        PayFragment.s0(payFragment, 0, message2, null, 4, null);
                        return;
                    }
                    if (i11 == 3) {
                        fq.a.g(aVar, "支付异常", null, 2, null);
                        PayFragment.s0(payFragment, 2, "Payment error", null, 4, null);
                    } else if (i11 == 4) {
                        fq.a.g(aVar, "支付处理中", null, 2, null);
                        PayFragment.s0(payFragment, 4, "Payment processing", null, 4, null);
                    } else {
                        if (i11 != 5) {
                            return;
                        }
                        fq.a.g(aVar, "取消轮询", null, 2, null);
                    }
                }
            }
        }));
        Transformations.a(v0().w()).j(getViewLifecycleOwner(), new c(new Function1<Boolean, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.f(it, "it");
                if (!it.booleanValue() || this.this$0.f50108i) {
                    FrameLayout frameLayout = this.this$0.f50107h;
                    if (frameLayout == null) {
                        return;
                    }
                    frameLayout.setVisibility(8);
                    return;
                }
                FrameLayout frameLayout2 = this.this$0.f50107h;
                if (frameLayout2 == null) {
                    return;
                }
                frameLayout2.setVisibility(0);
            }
        }));
    }

    public final void C0() {
        Function1<com.tn.tranpay.event.b, Unit> function1 = new Function1<com.tn.tranpay.event.b, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observerEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tn.tranpay.event.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tn.tranpay.event.b event) {
                Intrinsics.g(event, "event");
                fq.a aVar = fq.a.f65215a;
                fq.a.c(aVar, "PaymentEvent: " + event, null, 2, null);
                if (event.a() < 0) {
                    fq.a.g(aVar, "支付取消", null, 2, null);
                    String strA = this.this$0.v0().A();
                    if (strA != null) {
                        PaymentViewModel.h(this.this$0.v0(), strA, "USER CANCEL", null, 4, null);
                    }
                    PayFragment.s0(this.this$0, 1, "Payment cancelled", null, 4, null);
                } else {
                    fq.a.g(aVar, "三方收银台页面关闭或完成，调整轮询时间继续查询", null, 2, null);
                    this.this$0.v0().J();
                }
                q1 q1Var = this.this$0.f50102b;
                if (q1Var != null) {
                    q1.a.b(q1Var, null, 1, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = com.tn.tranpay.event.b.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        this.f50102b = flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void E0(b bVar) {
        this.f50101a = bVar;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (getActivity() == null) {
            throw new IllegalStateException("Activity cannot be null");
        }
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.f(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tn.tranpay.fragment.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                return PayFragment.D0(this.f50162a, dialogInterface, i11, keyEvent);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.tran_fragment_payment_layout, viewGroup, false);
        if (bundle == null) {
            LoadConfigContent loadConfigContent = this.f50105f;
            if (t0(loadConfigContent != null ? loadConfigContent.getMedium() : null)) {
                hq.g.f66780a.l("main_tab_page");
                return viewInflate;
            }
            BillingParams billingParams = this.f50103c;
            if (billingParams != null) {
                getChildFragmentManager().beginTransaction().replace(R$id.fragment_container, PayMainFragment.f50120h.a(billingParams, this.f50105f)).commit();
                b bVar = this.f50101a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        b bVar = this.f50101a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        F0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        BillingParams billingParams;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (billingParams = (BillingParams) arguments.getParcelable("paymentParams")) == null) {
            return;
        }
        this.f50103c = billingParams;
        Bundle arguments2 = getArguments();
        this.f50105f = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        PaymentViewModel paymentViewModelV0 = v0();
        BillingParams billingParams2 = this.f50103c;
        paymentViewModelV0.N(billingParams2 != null ? billingParams2.getOrderId() : null);
        PaymentViewModel paymentViewModelV1 = v0();
        BillingParams billingParams3 = this.f50103c;
        paymentViewModelV1.P(billingParams3 != null ? billingParams3.getTxnId() : null);
        if (v0().o() == null) {
            v0().K(this.f50104d);
        }
        this.f50107h = (FrameLayout) view.findViewById(R$id.loading_layout);
        ((ProgressBar) view.findViewById(R$id.loading_progress)).setIndeterminateTintList(ColorStateList.valueOf(com.tn.tranpay.e.f50084c.b().d()));
        C0();
        B0();
        y0();
    }

    public final void r0(int i11, String str, String str2) {
        BillingParams billingParams;
        com.tn.tranpay.c cVar = (v0().A() == null || (billingParams = this.f50103c) == null) ? null : new com.tn.tranpay.c(billingParams.getOrderId(), billingParams.getOrderDesc(), billingParams.getAmount(), v0().A(), billingParams.getPayByLocalCurrency());
        if (com.tn.tranpay.a.f50061a.a(i11)) {
            hq.g.f(hq.g.f66780a, 1, null, 2, null);
        } else if (i11 == 1) {
            hq.g.f66780a.e(0, Boolean.TRUE);
        } else {
            hq.g.f66780a.e(0, Boolean.FALSE);
        }
        com.tn.tranpay.b bVarA = com.tn.tranpay.b.f50070c.a(i11, str, str2);
        com.tn.tranpay.d dVarO = v0().o();
        if (dVarO != null) {
            dVarO.a(bVarA, cVar);
        }
        v0().K(null);
        v0().i();
        dismissAllowingStateLoss();
    }

    public final boolean t0(List<MediumInputBean> list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        List<InputInfoBean> inputs = list.get(0).getInputs();
        return inputs == null || inputs.isEmpty();
    }

    public final b u0() {
        return this.f50101a;
    }

    public final PaymentViewModel v0() {
        return (PaymentViewModel) this.f50106g.getValue();
    }

    public final boolean w0(String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            PayUtils payUtils = PayUtils.f50173a;
            if (!PayUtils.d(payUtils, str2, null, 2, null)) {
                fq.a.g(fq.a.f65215a, "handleAppLink: " + str2 + " not installed", null, 2, null);
                return false;
            }
            if (str != null && str.length() != 0) {
                return payUtils.e(str);
            }
        }
        return false;
    }

    public final void x0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            PayUtils.f50173a.i(activity, new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$handleDismiss$1$1
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
                    fq.a.c(fq.a.f65215a, "用户点击了支付后的留存提示", null, 2, null);
                    hq.g.f66780a.i();
                    String strA = this.this$0.v0().A();
                    if (strA != null) {
                        PaymentViewModel.h(this.this$0.v0(), strA, "USER CANCEL", null, 4, null);
                    }
                    BillingParams billingParams = this.this$0.f50103c;
                    if (billingParams != null) {
                        PayFragment payFragment = this.this$0;
                        com.tn.tranpay.d dVarO = payFragment.v0().o();
                        if (dVarO != null) {
                            dVarO.a(com.tn.tranpay.b.a.b(com.tn.tranpay.b.f50070c, 1, "User cancelled", null, 4, null), new com.tn.tranpay.c(billingParams.getOrderId(), billingParams.getOrderDesc(), billingParams.getAmount(), payFragment.v0().A(), billingParams.getPayByLocalCurrency()));
                        }
                    }
                    this.this$0.dismissAllowingStateLoss();
                }
            }, new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$handleDismiss$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    hq.g.f66780a.g();
                    fq.a.c(fq.a.f65215a, "用户拒绝了支付后的留存提示", null, 2, null);
                }
            });
            hq.g.f66780a.h();
        }
    }

    public final void y0() {
        this.f50108i = false;
        LoadConfigContent loadConfigContent = this.f50105f;
        if (!t0(loadConfigContent != null ? loadConfigContent.getMedium() : null) || v0().t()) {
            return;
        }
        this.f50108i = true;
        v0().L(true);
        LoadConfigContent loadConfigContent2 = this.f50105f;
        List<MediumInputBean> medium = loadConfigContent2 != null ? loadConfigContent2.getMedium() : null;
        Intrinsics.d(medium);
        String code = medium.get(0).getCode();
        if (code == null) {
            code = "";
        }
        String str = code;
        hq.g.f66780a.a(str, false, false, true);
        PaymentViewModel.k(v0(), str, null, null, true, 6, null);
    }

    public final HandleResultType z0(CreateOrderResultContent createOrderResultContent) {
        String rnUrl = createOrderResultContent.getRnUrl();
        createOrderResultContent.getPayInstruction();
        String webUrl = createOrderResultContent.getWebUrl();
        try {
            Result.Companion companion = Result.Companion;
            if (w0(rnUrl, null)) {
                fq.a.g(fq.a.f65215a, "handleAppLink: " + ((String) null) + " installed", null, 2, null);
                hq.g.f66780a.d(1, webUrl, rnUrl, null, v0().n());
                return HandleResultType.APP_LINK;
            }
            if (webUrl == null) {
                fq.a.g(fq.a.f65215a, "rnUrl and webUrl is null that don't need to handle anything", null, 2, null);
                hq.g.f66780a.d(2, null, rnUrl, null, v0().n());
                return HandleResultType.OPERATOR;
            }
            fq.a.g(fq.a.f65215a, "handleWebUrl: " + webUrl, null, 2, null);
            A0(webUrl);
            hq.g.f66780a.d(0, webUrl, rnUrl, null, v0().n());
            return HandleResultType.WEB;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2)));
            if (thM166exceptionOrNullimpl == null) {
                return HandleResultType.EXCEPTION;
            }
            fq.a.e(fq.a.f65215a, "handleResult: " + thM166exceptionOrNullimpl, null, 2, null);
            hq.g.f66780a.d(-1, webUrl, rnUrl, null, v0().n());
            return HandleResultType.EXCEPTION;
        }
    }
}
