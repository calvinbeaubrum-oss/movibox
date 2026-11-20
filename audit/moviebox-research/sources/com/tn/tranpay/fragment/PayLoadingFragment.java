package com.tn.tranpay.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.NetworkUtils;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;
import com.tn.lib.tranpay.R$style;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PayLoadingFragment extends DialogFragment implements hq.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f50111h = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressBar f50113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.tn.tranpay.d f50114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f50115d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f50112a = LazyKt__LazyJVMKt.b(new Function0<BillingParams>() { // from class: com.tn.tranpay.fragment.PayLoadingFragment$params$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BillingParams invoke() {
            Bundle arguments = this.this$0.getArguments();
            BillingParams billingParams = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
            Intrinsics.d(billingParams);
            return billingParams;
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PaymentViewModel f50116f = new PaymentViewModel();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f50117g = LazyKt__LazyJVMKt.b(new Function0<hq.c>() { // from class: com.tn.tranpay.fragment.PayLoadingFragment$logViewConfig$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final hq.c invoke() {
            return this.this$0.p0();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayLoadingFragment a(BillingParams params, com.tn.tranpay.d dVar) {
            Intrinsics.g(params, "params");
            PayLoadingFragment payLoadingFragment = new PayLoadingFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", params);
            payLoadingFragment.setArguments(bundle);
            payLoadingFragment.f50114c = dVar;
            return payLoadingFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f50118a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f50118a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f50118a;
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
            this.f50118a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements PayFragment.b {
        public c() {
        }

        @Override // com.tn.tranpay.fragment.PayFragment.b
        public void a() {
            PayLoadingFragment.this.hideLoading();
            PayLoadingFragment.this.dismissAllowingStateLoss();
        }

        @Override // com.tn.tranpay.fragment.PayFragment.b
        public void b() {
            if (PayLoadingFragment.this.isAdded()) {
                PayLoadingFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    /* JADX INFO: renamed from: com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$2", f = "PayLoadingFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PayLoadingFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (NetworkUtils.n()) {
                PayLoadingFragment.this.f50116f.P(PayLoadingFragment.this.n0().getTxnId());
                PayLoadingFragment.this.f50116f.l(PayLoadingFragment.this.n0());
            } else {
                PayLoadingFragment.m0(PayLoadingFragment.this, -2, "No network connection", null, 4, null);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        ProgressBar progressBar = this.f50113b;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    private final void logPause() {
        hq.b.a.b(this);
    }

    private final void logResume() {
        hq.b.a.c(this);
    }

    public static /* synthetic */ void m0(PayLoadingFragment payLoadingFragment, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str2 = null;
        }
        payLoadingFragment.l0(i11, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        PayFragment payFragmentA = PayFragment.f50100j.a(n0(), this.f50116f.q().f(), this.f50114c);
        payFragmentA.E0(new c());
        payFragmentA.show(getParentFragmentManager(), "pay_fragment");
    }

    private final void s0() {
        if (com.tn.tranpay.e.f50084c.b().c()) {
            ProgressBar progressBar = this.f50113b;
            if (progressBar == null) {
                return;
            }
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = this.f50113b;
        if (progressBar2 == null) {
            return;
        }
        progressBar2.setVisibility(8);
    }

    @Override // hq.b
    public hq.c getLogViewConfig() {
        return (hq.c) this.f50117g.getValue();
    }

    public final void l0(int i11, String str, String str2) {
        com.tn.tranpay.b bVarA = com.tn.tranpay.b.f50070c.a(i11, str, str2);
        fq.a.e(fq.a.f65215a, "loading error, code: " + i11 + ", message: " + str + ", serverCode: " + str2, null, 2, null);
        com.tn.tranpay.d dVar = this.f50114c;
        if (dVar != null) {
            dVar.a(bVarA, null);
        }
        this.f50114c = null;
        hq.c logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(false);
        }
        hq.g.f66780a.j(false, n0().getOrderDesc(), n0().getPayByLocalCurrency());
        o0();
    }

    public final BillingParams n0() {
        return (BillingParams) this.f50112a.getValue();
    }

    public final void o0() {
        hideLoading();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.tran_fragment_loading_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.f50115d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        logResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        if (!com.tn.tranpay.e.f50084c.b().c()) {
            Dialog dialog = getDialog();
            if (dialog == null || (window = dialog.getWindow()) == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
            return;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null || (window2 = dialog2.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes2 = window2.getAttributes();
        Intrinsics.f(attributes2, "it.attributes");
        attributes2.width = -1;
        attributes2.height = -1;
        window2.setAttributes(attributes2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        com.tn.tranpay.e.a aVar = com.tn.tranpay.e.f50084c;
        if (!aVar.b().c()) {
            setStyle(1, R$style.loading_empty_dialog);
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.loading_progress);
        this.f50113b = progressBar;
        if (progressBar != null) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(aVar.b().d()));
        }
        s0();
        this.f50116f.q().j(getViewLifecycleOwner(), new b(new Function1<LoadConfigContent, Unit>() { // from class: com.tn.tranpay.fragment.PayLoadingFragment.onViewCreated.1

            /* JADX INFO: renamed from: com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$1$1", f = "PayLoadingFragment.kt", l = {}, m = "invokeSuspend")
            public static final class C05451 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PayLoadingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C05451(PayLoadingFragment payLoadingFragment, Continuation<? super C05451> continuation) {
                    super(2, continuation);
                    this.this$0 = payLoadingFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C05451(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((C05451) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    hq.c logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    hq.g.f66780a.j(true, this.this$0.n0().getOrderDesc(), this.this$0.n0().getPayByLocalCurrency());
                    this.this$0.r0();
                    return Unit.f68710a;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoadConfigContent loadConfigContent) {
                invoke2(loadConfigContent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LoadConfigContent loadConfigContent) {
                if (loadConfigContent == null || !Intrinsics.b(loadConfigContent.getCode(), "0000")) {
                    hq.c logViewConfig = PayLoadingFragment.this.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(false);
                    }
                    hq.g.f66780a.j(false, PayLoadingFragment.this.n0().getOrderDesc(), PayLoadingFragment.this.n0().getPayByLocalCurrency());
                    PayLoadingFragment.m0(PayLoadingFragment.this, -1, "loading data is null", null, 4, null);
                    return;
                }
                List<MediumInputBean> medium = loadConfigContent.getMedium();
                if (medium != null && !medium.isEmpty()) {
                    kotlinx.coroutines.j.d(v.a(PayLoadingFragment.this), w0.c(), null, new C05451(PayLoadingFragment.this, null), 2, null);
                    return;
                }
                hq.c logViewConfig2 = PayLoadingFragment.this.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.j(false);
                }
                PayLoadingFragment.m0(PayLoadingFragment.this, 3, "Unavailable pay method", null, 4, null);
            }
        }));
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new AnonymousClass2(null), 3, null);
    }

    public hq.c p0() {
        return new hq.c("cashier_page", false, 2, null);
    }

    public final void q0(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f50115d = listener;
    }
}
