package com.transsnet.login.phone;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsnet.login.LoginActivity;
import com.transsnet.login.R$string;
import com.transsnet.login.constant.LoginType;
import com.transsnet.login.country.LoginSelectCountryActivity;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.loginapi.bean.Country;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class LoginPhoneFragment extends BaseFragment<n00.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginPhoneViewModel f61559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Country f61560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f61561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61562d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f61564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b1.b<IntentSenderRequest> f61565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b1.b<Intent> f61566i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b1.b<Intent> f61567j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LoginSmsCodeRequest f61563f = new LoginSmsCodeRequest();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f61568k = new Runnable() { // from class: com.transsnet.login.phone.o
        @Override // java.lang.Runnable
        public final void run() {
            LoginPhoneFragment.E0(this.f61660a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n00.j f61569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoginPhoneFragment f61570b;

        public a(n00.j jVar, LoginPhoneFragment loginPhoneFragment) {
            this.f61569a = jVar;
            this.f61570b = loginPhoneFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            n00.j mViewBinding;
            AppCompatTextView tvTips;
            AppCompatTextView appCompatTextView;
            if (editable == null || editable.length() == 0) {
                this.f61569a.f71433c.setVisibility(8);
            } else {
                this.f61569a.f71433c.setVisibility(0);
            }
            try {
                n00.j mViewBinding2 = this.f61570b.getMViewBinding();
                if (!Intrinsics.b((mViewBinding2 == null || (appCompatTextView = mViewBinding2.f71440k) == null) ? null : appCompatTextView.getText(), this.f61570b.getString(R$string.login_phone_err)) || (mViewBinding = this.f61570b.getMViewBinding()) == null || (tvTips = mViewBinding.f71440k) == null) {
                    return;
                }
                Intrinsics.f(tvTips, "tvTips");
                so.c.g(tvTips);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61571a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61571a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61571a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f61571a.invoke(obj);
        }
    }

    private final void A0() {
        this.f61566i = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.phone.p
            @Override // b1.a
            public final void a(Object obj) {
                LoginPhoneFragment.B0(this.f61661a, (ActivityResult) obj);
            }
        });
        this.f61565h = registerForActivityResult(new c1.k(), new b1.a() { // from class: com.transsnet.login.phone.q
            @Override // b1.a
            public final void a(Object obj) {
                LoginPhoneFragment.C0(this.f61662a, (ActivityResult) obj);
            }
        });
        this.f61567j = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.phone.r
            @Override // b1.a
            public final void a(Object obj) {
                LoginPhoneFragment.D0(this.f61663a, (ActivityResult) obj);
            }
        });
    }

    public static final void B0(LoginPhoneFragment this$0, ActivityResult activityResult) {
        Intent data;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        Serializable serializableExtra = data.getSerializableExtra("countryCode");
        if (serializableExtra instanceof Country) {
            this$0.M0((Country) serializableExtra);
        }
    }

    public static final void C0(LoginPhoneFragment this$0, ActivityResult activityResult) {
        Intent data;
        LoginPhoneViewModel loginPhoneViewModel;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            Credential credential = (Credential) data.getParcelableExtra(Credential.EXTRA_KEY);
            String id2 = credential != null ? credential.getId() : null;
            if (id2 != null && (loginPhoneViewModel = this$0.f61559a) != null) {
                loginPhoneViewModel.q(id2);
            }
        }
        this$0.f61561c = true;
    }

    public static final void D0(LoginPhoneFragment this$0, ActivityResult activityResult) {
        FragmentActivity activity;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (activity = this$0.getActivity()) == null) {
            return;
        }
        activity.setResult(-1);
        activity.finish();
    }

    public static final void E0(LoginPhoneFragment this$0) {
        AppCompatEditText appCompatEditText;
        Intrinsics.g(this$0, "this$0");
        n00.j mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (appCompatEditText = mViewBinding.f71436g) == null) {
            return;
        }
        appCompatEditText.clearFocus();
        appCompatEditText.requestFocus();
        KeyboardUtils.i(appCompatEditText);
    }

    public static final void F0(LoginPhoneFragment this$0, n00.j this_apply, View view) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        com.transsion.baselib.report.m.f51277a.m(this$0.getPageName(), "click", new HashMap());
        if (this$0.f61560b == null) {
            n00.j mViewBinding = this$0.getMViewBinding();
            if (mViewBinding != null && (appCompatTextView4 = mViewBinding.f71440k) != null) {
                appCompatTextView4.setText(R$string.login_select_country_code_tips);
            }
            n00.j mViewBinding2 = this$0.getMViewBinding();
            if (mViewBinding2 == null || (appCompatTextView3 = mViewBinding2.f71440k) == null) {
                return;
            }
            so.c.k(appCompatTextView3);
            return;
        }
        Editable text = this_apply.f71436g.getText();
        if (text == null || text.length() == 0) {
            n00.j mViewBinding3 = this$0.getMViewBinding();
            if (mViewBinding3 != null && (appCompatTextView2 = mViewBinding3.f71440k) != null) {
                appCompatTextView2.setText(R$string.login_phone_err);
            }
            n00.j mViewBinding4 = this$0.getMViewBinding();
            if (mViewBinding4 == null || (appCompatTextView = mViewBinding4.f71440k) == null) {
                return;
            }
            so.c.k(appCompatTextView);
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.login_net_err);
            return;
        }
        this$0.L0();
        this$0.f61563f.setPhone(String.valueOf(this_apply.f71436g.getText()));
        LoginSmsCodeRequest loginSmsCodeRequest = this$0.f61563f;
        Country country = this$0.f61560b;
        loginSmsCodeRequest.setCc(country != null ? country.getCode() : null);
        LoginPhoneViewModel loginPhoneViewModel = this$0.f61559a;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.p(this$0.f61563f);
        }
    }

    public static final void G0(LoginPhoneFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    public static final void H0(LoginPhoneFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.d(this$0.requireActivity());
    }

    public static final void I0(n00.j this_apply, LoginPhoneFragment this$0, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        this_apply.f71436g.clearFocus();
        KeyboardUtils.e(this_apply.f71436g);
        b1.b<Intent> bVar = this$0.f61566i;
        if (bVar != null) {
            bVar.a(new Intent(this$0.getContext(), (Class<?>) LoginSelectCountryActivity.class));
        }
    }

    public static final void J0(LoginPhoneFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || !(activity instanceof LoginActivity)) {
            return;
        }
        ((LoginActivity) activity).M(LoginType.EMAIL);
    }

    public static final void K0(n00.j this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.f71436g.setText("");
        this_apply.f71433c.setVisibility(8);
    }

    private final void L0() {
        if (this.f61562d == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            this.f61562d = new com.transsion.baseui.dialog.b(contextRequireContext);
        }
        com.transsion.baseui.dialog.b bVar = this.f61562d;
        if (bVar != null) {
            bVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(Country country) {
        n00.j mViewBinding;
        AppCompatTextView tvTips;
        AppCompatTextView appCompatTextView;
        if (country != null) {
            this.f61560b = country;
            String str = country.getCountry_s() + " + " + country.getCode();
            n00.j mViewBinding2 = getMViewBinding();
            CharSequence text = null;
            AppCompatTextView appCompatTextView2 = mViewBinding2 != null ? mViewBinding2.f71438i : null;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(str);
            }
            n00.j mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (appCompatTextView = mViewBinding3.f71440k) != null) {
                text = appCompatTextView.getText();
            }
            if (!Intrinsics.b(text, getString(R$string.login_select_country_code_tips)) || (mViewBinding = getMViewBinding()) == null || (tvTips = mViewBinding.f71440k) == null) {
                return;
            }
            Intrinsics.f(tvTips, "tvTips");
            so.c.g(tvTips);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(String str) {
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        n00.j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatEditText2 = mViewBinding.f71436g) != null) {
            appCompatEditText2.setText(str);
        }
        n00.j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (appCompatEditText = mViewBinding2.f71436g) == null) {
            return;
        }
        appCompatEditText.setSelection(str != null ? str.length() : 0);
    }

    private final void initViewModel() {
        final LoginPhoneViewModel loginPhoneViewModel = (LoginPhoneViewModel) new v0(this).a(LoginPhoneViewModel.class);
        this.f61559a = loginPhoneViewModel;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.x().j(getViewLifecycleOwner(), new b(new Function1<Country, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneFragment$initViewModel$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Country country) {
                    invoke2(country);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Country country) {
                    this.this$0.M0(country);
                }
            }));
            loginPhoneViewModel.B().j(getViewLifecycleOwner(), new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneFragment$initViewModel$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    this.this$0.N0(str);
                }
            }));
            loginPhoneViewModel.F().j(getViewLifecycleOwner(), new b(new Function1<LoginSmsCodeRequest, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneFragment$initViewModel$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LoginSmsCodeRequest loginSmsCodeRequest) {
                    invoke2(loginSmsCodeRequest);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LoginSmsCodeRequest loginSmsCodeRequest) {
                    this.this$0.y0();
                    if (loginSmsCodeRequest != null) {
                        LoginPhoneViewModel loginPhoneViewModel2 = loginPhoneViewModel;
                        LoginPhoneFragment loginPhoneFragment = this.this$0;
                        LoginCheckPhoneExistResult loginCheckPhoneExistResultF = loginPhoneViewModel2.t().f();
                        if (loginCheckPhoneExistResultF != null) {
                            Intent intent = new Intent(loginPhoneFragment.requireContext(), (Class<?>) LoginPhoneCodeActivity.class);
                            intent.putExtra("requestData", loginSmsCodeRequest);
                            intent.putExtra("checkPhoneData", loginCheckPhoneExistResultF);
                            intent.putExtra("source", loginPhoneFragment.f61564g);
                            b1.b bVar = loginPhoneFragment.f61567j;
                            if (bVar != null) {
                                bVar.a(intent);
                            }
                        }
                    }
                }
            }));
            loginPhoneViewModel.t().j(getViewLifecycleOwner(), new b(new Function1<LoginCheckPhoneExistResult, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneFragment$initViewModel$1$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
                    invoke2(loginCheckPhoneExistResult);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
                    if (loginCheckPhoneExistResult == null) {
                        this.this$0.y0();
                        return;
                    }
                    if (!loginCheckPhoneExistResult.getExists() || !loginCheckPhoneExistResult.getHasPassword()) {
                        if (!loginCheckPhoneExistResult.getExists() || loginCheckPhoneExistResult.getHasPassword()) {
                            LoginPhoneViewModel.E(loginPhoneViewModel, this.this$0.f61563f, 0, 2, null);
                            return;
                        } else {
                            loginPhoneViewModel.D(this.this$0.f61563f, 2);
                            return;
                        }
                    }
                    this.this$0.y0();
                    Intent intent = new Intent(this.this$0.requireContext(), (Class<?>) LoginPwdActivity.class);
                    intent.putExtra("requestData", this.this$0.f61563f);
                    intent.putExtra(PlaceTypes.COUNTRY, this.this$0.f61560b);
                    intent.putExtra("source", this.this$0.f61564g);
                    b1.b bVar = this.this$0.f61567j;
                    if (bVar != null) {
                        bVar.a(intent);
                    }
                    com.tn.lib.widget.toast.core.h.f50034a.k(R$string.login_existed);
                }
            }));
            loginPhoneViewModel.s().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneFragment$initViewModel$1$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    AppCompatTextView tvTips;
                    if (str != null) {
                        LoginPhoneFragment loginPhoneFragment = this.this$0;
                        n00.j mViewBinding = loginPhoneFragment.getMViewBinding();
                        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f71440k : null;
                        if (appCompatTextView != null) {
                            appCompatTextView.setText(str);
                        }
                        n00.j mViewBinding2 = loginPhoneFragment.getMViewBinding();
                        if (mViewBinding2 == null || (tvTips = mViewBinding2.f71440k) == null) {
                            return;
                        }
                        Intrinsics.f(tvTips, "tvTips");
                        so.c.k(tvTips);
                    }
                }
            }));
        }
    }

    private final void x0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            try {
                HintRequest hintRequestBuild = new HintRequest.Builder().setPhoneNumberIdentifierSupported(true).build();
                Intrinsics.f(hintRequestBuild, "Builder()\n              …                 .build()");
                PendingIntent hintPickerIntent = Credentials.getClient((Activity) activity).getHintPickerIntent(hintRequestBuild);
                Intrinsics.f(hintPickerIntent, "getClient(it).getHintPickerIntent(hintRequest)");
                IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.a(hintPickerIntent).a();
                b1.b<IntentSenderRequest> bVar = this.f61565h;
                if (bVar != null) {
                    bVar.a(intentSenderRequestA);
                }
            } catch (Exception unused) {
                this.f61561c = true;
                n00.j mViewBinding = getMViewBinding();
                AppCompatEditText appCompatEditText = mViewBinding != null ? mViewBinding.f71436g : null;
                Intrinsics.d(appCompatEditText);
                KeyboardUtils.i(appCompatEditText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        com.transsion.baseui.dialog.b bVar = this.f61562d;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public final String getPageName() {
        return "phone_enter";
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        LoginPhoneViewModel loginPhoneViewModel = this.f61559a;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.v();
        }
        x0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b1.b<IntentSenderRequest> bVar = this.f61565h;
        if (bVar != null) {
            bVar.c();
        }
        b1.b<Intent> bVar2 = this.f61566i;
        if (bVar2 != null) {
            bVar2.c();
        }
        b1.b<Intent> bVar3 = this.f61567j;
        if (bVar3 != null) {
            bVar3.c();
        }
        y0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        AppCompatEditText appCompatEditText;
        super.onPause();
        n00.j mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatEditText = mViewBinding.f71436g) == null) {
            return;
        }
        appCompatEditText.removeCallbacks(this.f61568k);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        n00.j mViewBinding;
        AppCompatEditText appCompatEditText;
        super.onResume();
        if (!this.f61561c || (mViewBinding = getMViewBinding()) == null || (appCompatEditText = mViewBinding.f71436g) == null) {
            return;
        }
        appCompatEditText.postDelayed(this.f61568k, 500L);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        HashMap<String, String> mapG;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("source")) == null) {
            string = null;
        } else {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("source", string);
            }
        }
        this.f61564g = string;
        this.f61563f.setAuthType(0);
        final n00.j mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f71435f.setSelected(true);
            mViewBinding.f71435f.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginPhoneFragment.F0(this.f61649a, mViewBinding, view2);
                }
            });
            mViewBinding.f71432b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginPhoneFragment.G0(this.f61652a, view2);
                }
            });
            mViewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginPhoneFragment.H0(this.f61655a, view2);
                }
            });
            mViewBinding.f71438i.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginPhoneFragment.I0(mViewBinding, this, view2);
                }
            });
            AppCompatEditText etPhone = mViewBinding.f71436g;
            Intrinsics.f(etPhone, "etPhone");
            etPhone.addTextChangedListener(new a(mViewBinding, this));
            AppCompatButton btnEmail = mViewBinding.f71434d;
            Intrinsics.f(btnEmail, "btnEmail");
            com.transsion.baseui.util.n.a(btnEmail, com.blankj.utilcode.util.i.e(8.0f));
            mViewBinding.f71434d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginPhoneFragment.J0(this.f61658a, view2);
                }
            });
            mViewBinding.f71433c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginPhoneFragment.K0(mViewBinding, view2);
                }
            });
            com.transsnet.login.l lVar = com.transsnet.login.l.f61543a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            AppCompatTextView tvPrivacy = mViewBinding.f71439j;
            Intrinsics.f(tvPrivacy, "tvPrivacy");
            lVar.a(contextRequireContext, tvPrivacy);
        }
        A0();
        initViewModel();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public n00.j getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        n00.j jVarC = n00.j.c(inflater);
        Intrinsics.f(jVarC, "inflate(inflater)");
        return jVarC;
    }
}
