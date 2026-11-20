package com.tn.tranpay.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;
import com.tn.lib.tranpay.R$string;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class PayMainFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f50120h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BillingParams f50121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoadConfigContent f50122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cq.b f50123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f50124d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f50125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50126g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayMainFragment a(BillingParams params, LoadConfigContent loadConfigContent) {
            Intrinsics.g(params, "params");
            PayMainFragment payMainFragment = new PayMainFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", params);
            bundle.putParcelable("configBean", loadConfigContent);
            payMainFragment.setArguments(bundle);
            return payMainFragment;
        }
    }

    public PayMainFragment() {
        super(R$layout.tran_fragment_main_layout);
        final Function0<y0> function0 = new Function0<y0>() { // from class: com.tn.tranpay.fragment.PayMainFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final y0 invoke() {
                Fragment fragmentRequireParentFragment = this.this$0.requireParentFragment();
                Intrinsics.f(fragmentRequireParentFragment, "requireParentFragment()");
                return fragmentRequireParentFragment;
            }
        };
        this.f50124d = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PayMainFragment$special$$inlined$viewModels$default$1
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
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PayMainFragment$special$$inlined$viewModels$default$2
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
        this.f50125f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel l0() {
        return (PaymentViewModel) this.f50124d.getValue();
    }

    public static final void o0(PayMainFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        PayFragment payFragment = parentFragment instanceof PayFragment ? (PayFragment) parentFragment : null;
        if (payFragment != null) {
            payFragment.x0();
        }
    }

    public final boolean k0(List<MediumInputBean> list) {
        if (list == null) {
            return false;
        }
        List<MediumInputBean> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(((MediumInputBean) it.next()).getCode(), this.f50126g)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006f A[EDGE_INSN: B:22:0x006f->B:23:0x0070 BREAK  A[LOOP:0: B:17:0x0055->B:56:?]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a4 A[EDGE_INSN: B:36:0x00a4->B:37:0x00a5 BREAK  A[LOOP:1: B:31:0x008a->B:59:?]] */
    public final void m0(MediumInputBean mediumInputBean, View view, String str, String str2) {
        boolean z11;
        boolean z12;
        if (!this.f50125f) {
            fq.a.g(fq.a.f65215a, "It's illegal that the method is not payable", null, 2, null);
            return;
        }
        fq.a.g(fq.a.f65215a, "Choose method " + mediumInputBean.getCode(), null, 2, null);
        if (com.tn.tranpay.helper.a.f50176a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this.f50125f = false;
        List<InputInfoBean> inputs = mediumInputBean.getInputs();
        if (inputs == null) {
            z11 = false;
            break;
        }
        List<InputInfoBean> list = inputs;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                } else if (Intrinsics.b(((InputInfoBean) it.next()).getType(), "Phone")) {
                    z11 = true;
                    break;
                }
            }
        } else {
            z11 = false;
            break;
        }
        List<InputInfoBean> inputs2 = mediumInputBean.getInputs();
        if (inputs2 == null) {
            z12 = false;
            break;
        }
        List<InputInfoBean> list2 = inputs2;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z12 = false;
                    break;
                } else if (Intrinsics.b(((InputInfoBean) it2.next()).getType(), "CNIC")) {
                    z12 = true;
                    break;
                }
            }
        } else {
            z12 = false;
            break;
        }
        hq.g gVar = hq.g.f66780a;
        String code = mediumInputBean.getCode();
        if (code == null) {
            code = "";
        }
        gVar.a(code, z11, z12, false);
        if (z11 && z12) {
            n0(mediumInputBean, str, str2, true);
            return;
        }
        if (z11) {
            n0(mediumInputBean, str, str2, false);
        } else {
            if (z12) {
                fq.a.e(fq.a.f65215a, "It's illegal that doesn't exist only cnic", null, 2, null);
                return;
            }
            PaymentViewModel paymentViewModelL0 = l0();
            String code2 = mediumInputBean.getCode();
            PaymentViewModel.k(paymentViewModelL0, code2 == null ? "" : code2, null, null, false, 14, null);
        }
    }

    public final void n0(MediumInputBean mediumInputBean, String str, String str2, boolean z11) {
        BillingParams billingParams = this.f50121a;
        if (billingParams != null) {
            PaySubFragment.a aVar = PaySubFragment.f50127o;
            LoadConfigContent loadConfigContent = this.f50122b;
            List<InputInfoBean> inputs = mediumInputBean.getInputs();
            if (inputs == null) {
                inputs = kotlin.collections.g.l();
            }
            List<InputInfoBean> list = inputs;
            String name = mediumInputBean.getName();
            String str3 = name == null ? "" : name;
            String code = mediumInputBean.getCode();
            if (code == null) {
                code = "";
            }
            PaySubFragment paySubFragmentA = aVar.a(billingParams, loadConfigContent, z11, list, str3, code, str, str2);
            paySubFragmentA.x0(new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayMainFragment$navigateToSubFragment$1$1$1
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
                    this.this$0.f50125f = true;
                    this.this$0.l0().w().n(Boolean.FALSE);
                    fq.a.g(fq.a.f65215a, "PaySubFragment popped", null, 2, null);
                }
            });
            getParentFragmentManager().beginTransaction().replace(R$id.fragment_container, paySubFragmentA).addToBackStack(null).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f50121a = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
        Bundle arguments2 = getArguments();
        this.f50122b = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        ((AppCompatImageView) view.findViewById(R$id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayMainFragment.o0(this.f50163a, view2);
            }
        });
        String string = PaymentMMKV.f50174a.a().getString("k_pay_method_code", null);
        this.f50126g = string;
        fq.a.g(fq.a.f65215a, "The used method code is " + string, null, 2, null);
        View viewFindViewById = view.findViewById(R$id.iv_recycler);
        Intrinsics.f(viewFindViewById, "view.findViewById(R.id.iv_recycler)");
        r0((RecyclerView) viewFindViewById);
        if (isAdded()) {
            LoadConfigContent loadConfigContent = this.f50122b;
            q0(loadConfigContent != null ? loadConfigContent.getMedium() : null);
            p0(this.f50122b);
        }
        hq.g.f66780a.l("main_tab_page");
    }

    public final void p0(LoadConfigContent loadConfigContent) {
        View view;
        if (loadConfigContent == null || (view = getView()) == null) {
            return;
        }
        ((AppCompatTextView) view.findViewById(R$id.iv_company)).setText(loadConfigContent.getCpName());
        ((AppCompatTextView) view.findViewById(R$id.iv_amount)).setText(view.getContext().getString(R$string.pay_amount, loadConfigContent.getSymbol()));
        ((AppCompatTextView) view.findViewById(R$id.iv_desc)).setText(view.getContext().getString(R$string.pay_desc, loadConfigContent.getSymbol(), loadConfigContent.getCpName()));
        ((AppCompatTextView) view.findViewById(R$id.iv_order_id)).setText(view.getContext().getString(R$string.pay_order, loadConfigContent.getOrderId()));
    }

    public final void q0(List<MediumInputBean> list) {
        if (list != null) {
            PaymentMMKV paymentMMKV = PaymentMMKV.f50174a;
            cq.b bVar = null;
            final String string = paymentMMKV.a().getString("k_phone_number", null);
            final String string2 = paymentMMKV.a().getString("k_cnic_number", null);
            cq.b bVar2 = new cq.b(CollectionsKt___CollectionsKt.M0(list), k0(list), this.f50126g);
            bVar2.i(R$id.item_root);
            bVar2.J0(new Function2<MediumInputBean, View, Unit>() { // from class: com.tn.tranpay.fragment.PayMainFragment$setPayMethodList$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MediumInputBean mediumInputBean, View view) {
                    invoke2(mediumInputBean, view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MediumInputBean item, View view) {
                    Intrinsics.g(item, "item");
                    Intrinsics.g(view, "view");
                    this.this$0.m0(item, view, string, string2);
                }
            });
            this.f50123c = bVar2;
            View view = getView();
            RecyclerView recyclerView = view != null ? (RecyclerView) view.findViewById(R$id.iv_recycler) : null;
            if (recyclerView == null) {
                return;
            }
            cq.b bVar3 = this.f50123c;
            if (bVar3 == null) {
                Intrinsics.y("payMethodAdapter");
            } else {
                bVar = bVar3;
            }
            recyclerView.setAdapter(bVar);
        }
    }

    public final void r0(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }
}
