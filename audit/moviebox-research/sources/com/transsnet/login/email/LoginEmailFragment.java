package com.transsnet.login.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.z;
import com.google.logging.type.LogSeverity;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsnet.login.phone.LoginPhoneCodeActivity;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.widget.LoginProgressBar;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;

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
public final class LoginEmailFragment extends BaseFragment<n00.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f61476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b1.b<Intent> f61477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoginSmsCodeRequest f61479d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f61480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f61481g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n00.b f61482a;

        public a(n00.b bVar) {
            this.f61482a = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string;
            if (editable == null || (string = editable.toString()) == null) {
                string = "";
            }
            if (z.b(string)) {
                AppCompatTextView tvTips = this.f61482a.f71369h;
                Intrinsics.f(tvTips, "tvTips");
                so.c.g(tvTips);
            }
            if (editable == null || editable.length() == 0) {
                AppCompatImageButton btnClear = this.f61482a.f71364b;
                Intrinsics.f(btnClear, "btnClear");
                so.c.g(btnClear);
            } else {
                AppCompatImageButton btnClear2 = this.f61482a.f71364b;
                Intrinsics.f(btnClear2, "btnClear");
                so.c.k(btnClear2);
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
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61483a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61483a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61483a;
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
            this.f61483a.invoke(obj);
        }
    }

    public LoginEmailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsnet.login.email.LoginEmailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f61476a = FragmentViewModelLazyKt.a(this, Reflection.b(LoginEmailViewModel.class), new Function0<x0>() { // from class: com.transsnet.login.email.LoginEmailFragment$special$$inlined$viewModels$default$2
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
        }, new Function0<v0.c>() { // from class: com.transsnet.login.email.LoginEmailFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f61479d = new LoginSmsCodeRequest();
        this.f61481g = new Runnable() { // from class: com.transsnet.login.email.b
            @Override // java.lang.Runnable
            public final void run() {
                LoginEmailFragment.w0(this.f61505a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        com.transsion.baseui.dialog.b bVar = this.f61478c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public static final void t0(n00.b this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.f71366d.setText("");
    }

    public static final void u0(LoginEmailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public static final void v0(n00.b this_apply, LoginEmailFragment this$0, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        tp.e eVar = tp.e.f77259a;
        Context context = view.getContext();
        Intrinsics.f(context, "it.context");
        if (!eVar.a(context)) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.no_network_tips);
            return;
        }
        Editable text = this_apply.f71366d.getText();
        String string = text != null ? text.toString() : null;
        if (string == null || string.length() == 0 || !z.b(string)) {
            AppCompatTextView tvTips = this_apply.f71369h;
            Intrinsics.f(tvTips, "tvTips");
            so.c.k(tvTips);
            return;
        }
        AppCompatTextView tvTips2 = this_apply.f71369h;
        Intrinsics.f(tvTips2, "tvTips");
        so.c.g(tvTips2);
        this$0.y0();
        LoginSmsCodeRequest loginSmsCodeRequest = this$0.f61479d;
        String string2 = StringsKt__StringsKt.Z0(string).toString();
        this$0.r0().e(string2);
        loginSmsCodeRequest.setMail(string2);
    }

    public static final void w0(LoginEmailFragment this$0) {
        AppCompatEditText appCompatEditText;
        Intrinsics.g(this$0, "this$0");
        n00.b mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (appCompatEditText = mViewBinding.f71366d) == null) {
            return;
        }
        appCompatEditText.clearFocus();
        appCompatEditText.requestFocus();
        KeyboardUtils.i(appCompatEditText);
    }

    public static final void x0(LoginEmailFragment this$0, ActivityResult activityResult) {
        FragmentActivity activity;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (activity = this$0.getActivity()) == null) {
            return;
        }
        activity.setResult(-1);
        activity.finish();
    }

    private final void y0() {
        if (this.f61478c == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            this.f61478c = new com.transsion.baseui.dialog.b(contextRequireContext);
        }
        com.transsion.baseui.dialog.b bVar = this.f61478c;
        if (bVar != null) {
            bVar.show();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        r0().f().j(this, new b(new Function1<LoginCheckPhoneExistResult, Unit>() { // from class: com.transsnet.login.email.LoginEmailFragment.initData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoginCheckPhoneExistResult loginCheckPhoneExistResult) throws JSONException {
                invoke2(loginCheckPhoneExistResult);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LoginCheckPhoneExistResult loginCheckPhoneExistResult) throws JSONException {
                if (loginCheckPhoneExistResult == null) {
                    LoginEmailFragment.this.q0();
                    return;
                }
                String mail = LoginEmailFragment.this.f61479d.getMail();
                if (mail == null || mail.length() == 0) {
                    return;
                }
                if (!loginCheckPhoneExistResult.getExists() || !loginCheckPhoneExistResult.getHasPassword()) {
                    LoginEmailViewModel.h(LoginEmailFragment.this.r0(), mail, 0, 2, null);
                    return;
                }
                LoginEmailFragment.this.q0();
                Intent intent = new Intent(LoginEmailFragment.this.requireContext(), (Class<?>) LoginEmailPwdActivity.class);
                intent.putExtra("requestData", LoginEmailFragment.this.f61479d);
                intent.putExtra("checkPhoneData", loginCheckPhoneExistResult);
                intent.putExtra("source", LoginEmailFragment.this.f61480f);
                b1.b bVar = LoginEmailFragment.this.f61477b;
                if (bVar != null) {
                    bVar.a(intent);
                }
                com.tn.lib.widget.toast.core.h.f50034a.k(com.transsnet.login.R$string.login_existed);
            }
        }));
        r0().i().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.email.LoginEmailFragment.initData.2
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
                if (str != null) {
                    LoginEmailFragment loginEmailFragment = LoginEmailFragment.this;
                    Intent intent = new Intent(loginEmailFragment.requireContext(), (Class<?>) LoginPhoneCodeActivity.class);
                    loginEmailFragment.f61479d.setType(1);
                    intent.putExtra("source", loginEmailFragment.f61480f);
                    intent.putExtra("requestData", loginEmailFragment.f61479d);
                    intent.putExtra("checkPhoneData", loginEmailFragment.r0().f().f());
                    b1.b bVar = loginEmailFragment.f61477b;
                    if (bVar != null) {
                        bVar.a(intent);
                    }
                }
                LoginEmailFragment.this.q0();
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        final n00.b mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f71365c.setSelected(true);
            AppCompatEditText etEmail = mViewBinding.f71366d;
            Intrinsics.f(etEmail, "etEmail");
            etEmail.addTextChangedListener(new a(mViewBinding));
            mViewBinding.f71364b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEmailFragment.t0(mViewBinding, view2);
                }
            });
            mViewBinding.f71367f.f71448b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEmailFragment.u0(this.f61508a, view2);
                }
            });
            mViewBinding.f71367f.f71449c.setProgress(0, LogSeverity.NOTICE_VALUE);
            mViewBinding.f71365c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEmailFragment.v0(mViewBinding, this, view2);
                }
            });
            com.transsnet.login.l lVar = com.transsnet.login.l.f61543a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            AppCompatTextView tvPrivacy = mViewBinding.f71368g;
            Intrinsics.f(tvPrivacy, "tvPrivacy");
            lVar.a(contextRequireContext, tvPrivacy);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        HashMap<String, String> mapG;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("source")) == null) {
            string = null;
        } else {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("source", string);
            }
        }
        this.f61480f = string;
        this.f61477b = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.email.c
            @Override // b1.a
            public final void a(Object obj) {
                LoginEmailFragment.x0(this.f61506a, (ActivityResult) obj);
            }
        });
        this.f61479d.setAuthType(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b1.b<Intent> bVar = this.f61477b;
        if (bVar != null) {
            bVar.c();
        }
        q0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        n00.l lVar;
        LoginProgressBar loginProgressBar;
        AppCompatEditText appCompatEditText;
        super.onResume();
        n00.b mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatEditText = mViewBinding.f71366d) != null) {
            appCompatEditText.postDelayed(this.f61481g, 500L);
        }
        n00.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (lVar = mViewBinding2.f71367f) == null || (loginProgressBar = lVar.f71449c) == null || loginProgressBar.getProgress() > 0) {
            return;
        }
        loginProgressBar.startProgressIncrease();
    }

    public final LoginEmailViewModel r0() {
        return (LoginEmailViewModel) this.f61476a.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public n00.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        n00.b bVarC = n00.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }
}
