package com.tn.tranpay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.tn.lib.tranpay.R$layout;
import com.tn.lib.tranpay.R$string;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
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
@SourceDebugExtension
public final class PaySubFragment extends Fragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f50127o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BillingParams f50128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadConfigContent f50130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50131d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<InputInfoBean> f50132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f50134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f50135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f50136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public np.b f50137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f50138l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f50139m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f50140n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaySubFragment a(BillingParams params, LoadConfigContent loadConfigContent, boolean z11, List<InputInfoBean> inputs, String payMethod, String payMethodCode, String str, String str2) {
            Intrinsics.g(params, "params");
            Intrinsics.g(inputs, "inputs");
            Intrinsics.g(payMethod, "payMethod");
            Intrinsics.g(payMethodCode, "payMethodCode");
            PaySubFragment paySubFragment = new PaySubFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", params);
            bundle.putParcelable("configBean", loadConfigContent);
            bundle.putBoolean("needCnic", z11);
            bundle.putParcelableArrayList("inputs", new ArrayList<>(inputs));
            bundle.putString("payMethod", payMethod);
            bundle.putString("payMethodCode", payMethodCode);
            bundle.putString("phone", str);
            bundle.putString("cnic", str2);
            paySubFragment.setArguments(bundle);
            return paySubFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f50141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PaySubFragment f50142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f50143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppCompatTextView f50144d;

        public b(AppCompatImageView appCompatImageView, PaySubFragment paySubFragment, String str, AppCompatTextView appCompatTextView) {
            this.f50141a = appCompatImageView;
            this.f50142b = paySubFragment;
            this.f50143c = str;
            this.f50144d = appCompatTextView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f50144d.setVisibility(this.f50142b.I0(this.f50143c, String.valueOf(editable)) ? 8 : 0);
            this.f50142b.H0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f50141a.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
        }
    }

    public PaySubFragment() {
        super(R$layout.tran_fragment_sub_layout);
        this.f50132f = kotlin.collections.g.l();
        this.f50133g = "";
        this.f50134h = "";
        final Function0<y0> function0 = new Function0<y0>() { // from class: com.tn.tranpay.fragment.PaySubFragment$viewModel$2
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
        this.f50138l = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PaySubFragment$special$$inlined$viewModels$default$1
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
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PaySubFragment$special$$inlined$viewModels$default$2
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
        this.f50140n = true;
    }

    public static final void A0(np.b this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Editable text = this_apply.f72105d.getText();
        if (text != null) {
            text.clear();
        }
    }

    public static final void C0(PaySubFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new PaySubFragment$setupPayButtonListener$1$1(this$0, null), 3, null);
    }

    public static final void F0(PaySubFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        PayFragment payFragment = parentFragment instanceof PayFragment ? (PayFragment) parentFragment : null;
        if (payFragment != null) {
            payFragment.x0();
        }
    }

    public static final void G0(PaySubFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel t0() {
        return (PaymentViewModel) this.f50138l.getValue();
    }

    private final void w0(LoadConfigContent loadConfigContent) {
        if (loadConfigContent != null) {
            np.b bVar = this.f50137k;
            if (bVar == null) {
                Intrinsics.y("viewBinding");
                bVar = null;
            }
            bVar.f72112l.setText(loadConfigContent.getCpName());
            AppCompatTextView appCompatTextView = bVar.f72107g;
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R$string.pay_amount, loadConfigContent.getSymbol()) : null);
            AppCompatTextView appCompatTextView2 = bVar.f72113m;
            Context context2 = getContext();
            appCompatTextView2.setText(context2 != null ? context2.getString(R$string.pay_desc, loadConfigContent.getSymbol(), loadConfigContent.getCpName()) : null);
            AppCompatTextView appCompatTextView3 = bVar.f72116p;
            Context context3 = getContext();
            appCompatTextView3.setText(context3 != null ? context3.getString(R$string.pay_order, loadConfigContent.getOrderId()) : null);
        }
    }

    public static final void z0(np.b this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Editable text = this_apply.f72106f.getText();
        if (text != null) {
            text.clear();
        }
    }

    public final void B0() {
        np.b bVar = this.f50137k;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        bVar.f72117q.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.C0(this.f50164a, view);
            }
        });
    }

    public final void D0() {
        Object next;
        Object next2;
        np.b bVar = this.f50137k;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        AppCompatEditText appCompatEditText = bVar.f72106f;
        AppCompatImageView clearPhoneButton = bVar.f72104c;
        Intrinsics.f(clearPhoneButton, "clearPhoneButton");
        AppCompatTextView ivInputPhoneError = bVar.f72115o;
        Intrinsics.f(ivInputPhoneError, "ivInputPhoneError");
        Iterator<T> it = this.f50132f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((InputInfoBean) next).getType(), "Phone"));
        InputInfoBean inputInfoBean = (InputInfoBean) next;
        appCompatEditText.addTextChangedListener(r0(clearPhoneButton, ivInputPhoneError, inputInfoBean != null ? inputInfoBean.getReg() : null));
        AppCompatEditText appCompatEditText2 = bVar.f72105d;
        AppCompatImageView clearCnicButton = bVar.f72103b;
        Intrinsics.f(clearCnicButton, "clearCnicButton");
        AppCompatTextView ivInputCnicError = bVar.f72114n;
        Intrinsics.f(ivInputCnicError, "ivInputCnicError");
        Iterator<T> it2 = this.f50132f.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!Intrinsics.b(((InputInfoBean) next2).getType(), "CNIC"));
        InputInfoBean inputInfoBean2 = (InputInfoBean) next2;
        appCompatEditText2.addTextChangedListener(r0(clearCnicButton, ivInputCnicError, inputInfoBean2 != null ? inputInfoBean2.getReg() : null));
    }

    public final void E0() {
        np.b bVar = this.f50137k;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        bVar.f72109i.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.F0(this.f50167a, view);
            }
        });
        bVar.f72108h.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.G0(this.f50168a, view);
            }
        });
        bVar.f72110j.setVisibility(this.f50131d ? 0 : 8);
        AppCompatTextView appCompatTextView = bVar.f72119s;
        Context context = getContext();
        appCompatTextView.setText(context != null ? context.getString(R$string.pay_phone_code, this.f50129b) : null);
        AppCompatTextView appCompatTextView2 = bVar.f72118r;
        Context context2 = getContext();
        appCompatTextView2.setText(context2 != null ? context2.getString(R$string.pay_method, this.f50133g) : null);
        AppCompatEditText inputPhone = bVar.f72106f;
        Intrinsics.f(inputPhone, "inputPhone");
        AppCompatTextView ivInputPhoneError = bVar.f72115o;
        Intrinsics.f(ivInputPhoneError, "ivInputPhoneError");
        u0("Phone", inputPhone, ivInputPhoneError, this.f50135i);
        AppCompatEditText inputCnic = bVar.f72105d;
        Intrinsics.f(inputCnic, "inputCnic");
        AppCompatTextView ivInputCnicError = bVar.f72114n;
        Intrinsics.f(ivInputCnicError, "ivInputCnicError");
        u0("CNIC", inputCnic, ivInputCnicError, this.f50136j);
        H0();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002e  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    public final void H0() {
        boolean z11;
        boolean z12;
        np.b bVar = this.f50137k;
        np.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        Editable text = bVar.f72106f.getText();
        boolean z13 = false;
        if (text == null || text.length() == 0) {
            z11 = false;
        } else {
            np.b bVar3 = this.f50137k;
            if (bVar3 == null) {
                Intrinsics.y("viewBinding");
                bVar3 = null;
            }
            if (bVar3.f72115o.getVisibility() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (this.f50131d) {
            np.b bVar4 = this.f50137k;
            if (bVar4 == null) {
                Intrinsics.y("viewBinding");
                bVar4 = null;
            }
            Editable text2 = bVar4.f72105d.getText();
            if (text2 != null && text2.length() != 0) {
                np.b bVar5 = this.f50137k;
                if (bVar5 == null) {
                    Intrinsics.y("viewBinding");
                    bVar5 = null;
                }
                z12 = bVar5.f72114n.getVisibility() != 0;
            }
        }
        np.b bVar6 = this.f50137k;
        if (bVar6 == null) {
            Intrinsics.y("viewBinding");
        } else {
            bVar2 = bVar6;
        }
        AppCompatTextView appCompatTextView = bVar2.f72117q;
        if (z11 && z12) {
            z13 = true;
        }
        appCompatTextView.setEnabled(z13);
    }

    public final boolean I0(String str, String str2) {
        return (str != null && new Regex(str).matches(String.valueOf(str2))) || str2 == null || str2.length() == 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.tran_fragment_sub_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        np.b bVarA = np.b.a(view);
        Intrinsics.f(bVarA, "bind(view)");
        this.f50137k = bVarA;
        Bundle arguments = getArguments();
        BillingParams billingParams = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
        if (billingParams == null) {
            return;
        }
        this.f50128a = billingParams;
        Bundle arguments2 = getArguments();
        this.f50130c = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        Bundle arguments3 = getArguments();
        this.f50131d = arguments3 != null ? arguments3.getBoolean("needCnic") : false;
        Bundle arguments4 = getArguments();
        List<InputInfoBean> parcelableArrayList = arguments4 != null ? arguments4.getParcelableArrayList("inputs") : null;
        if (parcelableArrayList == null) {
            parcelableArrayList = kotlin.collections.g.l();
        }
        this.f50132f = parcelableArrayList;
        Bundle arguments5 = getArguments();
        String string = arguments5 != null ? arguments5.getString("payMethod") : null;
        if (string == null) {
            string = "";
        }
        this.f50133g = string;
        Bundle arguments6 = getArguments();
        String string2 = arguments6 != null ? arguments6.getString("payMethodCode") : null;
        this.f50134h = string2 != null ? string2 : "";
        Bundle arguments7 = getArguments();
        this.f50135i = arguments7 != null ? arguments7.getString("phone") : null;
        Bundle arguments8 = getArguments();
        this.f50136j = arguments8 != null ? arguments8.getString("cnic") : null;
        this.f50129b = t0().m();
        E0();
        D0();
        y0();
        B0();
        if (isAdded()) {
            w0(this.f50130c);
        }
        hq.g.f66780a.l("sub_tab_page");
    }

    public final b r0(AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, String str) {
        return new b(appCompatImageView, this, str, appCompatTextView);
    }

    public final String s0() {
        return this.f50134h;
    }

    public final void u0(String str, AppCompatEditText appCompatEditText, AppCompatTextView appCompatTextView, String str2) {
        Object next;
        Iterator<T> it = this.f50132f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((InputInfoBean) next).getType(), str));
        InputInfoBean inputInfoBean = (InputInfoBean) next;
        if (inputInfoBean != null) {
            if (I0(inputInfoBean.getReg(), str2)) {
                if (str2 == null) {
                    str2 = "";
                }
                appCompatEditText.setText(str2);
            }
            appCompatEditText.setHint(inputInfoBean.getRealHint());
            appCompatTextView.setText(inputInfoBean.getRealTips());
        }
    }

    public final void v0() {
        Function0<Unit> function0 = this.f50139m;
        if (function0 != null) {
            function0.invoke();
        }
        getParentFragmentManager().popBackStack();
    }

    public final void x0(Function0<Unit> function0) {
        this.f50139m = function0;
    }

    public final void y0() {
        final np.b bVar = this.f50137k;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        bVar.f72104c.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.z0(bVar, view);
            }
        });
        bVar.f72103b.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.A0(bVar, view);
            }
        });
    }
}
