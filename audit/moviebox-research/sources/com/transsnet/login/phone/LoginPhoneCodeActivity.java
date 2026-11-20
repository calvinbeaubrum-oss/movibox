package com.transsnet.login.phone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.R$color;
import com.transsnet.login.R$string;
import com.transsnet.login.constant.LoginSmsCodeMmkvUtil;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.widget.LoginProgressBar;
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
public final class LoginPhoneCodeActivity extends BaseActivity<n00.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginSmsCodeRequest f61546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoginCheckPhoneExistResult f61547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoginPhoneViewModel f61548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61549d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b1.b<Intent> f61550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f61551g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f61555k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f61552h = 60;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f61553i = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f61554j = new Runnable() { // from class: com.transsnet.login.phone.f
        @Override // java.lang.Runnable
        public final void run() {
            LoginPhoneCodeActivity.u0(this.f61643a);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f61556l = new Runnable() { // from class: com.transsnet.login.phone.g
        @Override // java.lang.Runnable
        public final void run() {
            LoginPhoneCodeActivity.v0(this.f61645a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LoginPhoneCodeActivity.this.h0();
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
        public final /* synthetic */ Function1 f61558a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61558a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61558a;
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
            this.f61558a.invoke(obj);
        }
    }

    private final void initView() {
        String mail;
        String cc2;
        String phone;
        LoginCheckPhoneExistResult loginCheckPhoneExistResult;
        LoginCheckPhoneExistResult loginCheckPhoneExistResult2 = this.f61547b;
        if (loginCheckPhoneExistResult2 == null || loginCheckPhoneExistResult2.getExists() || ((loginCheckPhoneExistResult = this.f61547b) != null && loginCheckPhoneExistResult.getReset())) {
            AppCompatTextView appCompatTextView = ((n00.f) getMViewBinding()).f71400g.f71450d;
            Intrinsics.f(appCompatTextView, "mViewBinding.title.tvProgress");
            so.c.g(appCompatTextView);
            LoginProgressBar loginProgressBar = ((n00.f) getMViewBinding()).f71400g.f71449c;
            Intrinsics.f(loginProgressBar, "mViewBinding.title.progress");
            so.c.g(loginProgressBar);
            LoginCheckPhoneExistResult loginCheckPhoneExistResult3 = this.f61547b;
            if (loginCheckPhoneExistResult3 != null && loginCheckPhoneExistResult3.getReset()) {
                ((n00.f) getMViewBinding()).f71400g.f71451f.setText(R$string.login_pwd_find);
            }
        } else {
            AppCompatTextView appCompatTextView2 = ((n00.f) getMViewBinding()).f71400g.f71450d;
            Intrinsics.f(appCompatTextView2, "mViewBinding.title.tvProgress");
            so.c.k(appCompatTextView2);
            LoginProgressBar loginProgressBar2 = ((n00.f) getMViewBinding()).f71400g.f71449c;
            Intrinsics.f(loginProgressBar2, "mViewBinding.title.progress");
            so.c.k(loginProgressBar2);
            ((n00.f) getMViewBinding()).f71400g.f71449c.setProgress(2);
            ((n00.f) getMViewBinding()).f71400g.f71450d.setText("2/3");
            ((n00.f) getMViewBinding()).f71400g.f71449c.setProgress(LogSeverity.NOTICE_VALUE, LogSeverity.CRITICAL_VALUE);
        }
        ((n00.f) getMViewBinding()).f71396b.setSelected(true);
        ((n00.f) getMViewBinding()).f71400g.f71448b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.o0(this.f61632a, view);
            }
        });
        ((n00.f) getMViewBinding()).f71396b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.p0(this.f61634a, view);
            }
        });
        ((n00.f) getMViewBinding()).f71397c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.q0(this.f61637a, view);
            }
        });
        AppCompatEditText appCompatEditText = ((n00.f) getMViewBinding()).f71398d;
        Intrinsics.f(appCompatEditText, "mViewBinding.etCode");
        appCompatEditText.addTextChangedListener(new a());
        ((n00.f) getMViewBinding()).f71398d.post(new Runnable() { // from class: com.transsnet.login.phone.d
            @Override // java.lang.Runnable
            public final void run() {
                LoginPhoneCodeActivity.r0(this.f61639a);
            }
        });
        ((n00.f) getMViewBinding()).getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.s0(this.f61641a, view);
            }
        });
        LoginSmsCodeRequest loginSmsCodeRequest = this.f61546a;
        String str = "";
        if (loginSmsCodeRequest == null || loginSmsCodeRequest.getAuthType() != 0) {
            LoginSmsCodeRequest loginSmsCodeRequest2 = this.f61546a;
            if (loginSmsCodeRequest2 != null && (mail = loginSmsCodeRequest2.getMail()) != null) {
                str = mail;
            }
        } else {
            LoginSmsCodeRequest loginSmsCodeRequest3 = this.f61546a;
            if (loginSmsCodeRequest3 == null || (cc2 = loginSmsCodeRequest3.getCc()) == null) {
                cc2 = "";
            }
            LoginSmsCodeRequest loginSmsCodeRequest4 = this.f61546a;
            if (loginSmsCodeRequest4 != null && (phone = loginSmsCodeRequest4.getPhone()) != null) {
                str = phone;
            }
            str = "+" + cc2 + " " + str;
        }
        LoginCheckPhoneExistResult loginCheckPhoneExistResult4 = this.f61547b;
        if (loginCheckPhoneExistResult4 == null || !loginCheckPhoneExistResult4.getReset()) {
            LoginSmsCodeRequest loginSmsCodeRequest5 = this.f61546a;
            if (loginSmsCodeRequest5 == null || loginSmsCodeRequest5.getAuthType() != 0) {
                ((n00.f) getMViewBinding()).f71401h.setText(getString(R$string.login_email_code_tips, str));
            } else {
                ((n00.f) getMViewBinding()).f71401h.setText(getString(R$string.login_phone_code_tips, str));
            }
        } else {
            ((n00.f) getMViewBinding()).f71401h.setText(getString(R$string.login_verify_code_tips, str));
        }
        ((n00.f) getMViewBinding()).f71401h.setTextColor(z2.a.getColor(this, R$color.base_color_999999));
        this.f61553i.post(this.f61554j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        com.transsion.baseui.dialog.b bVar = this.f61549d;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    private final void m0() {
        this.f61550f = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.phone.h
            @Override // b1.a
            public final void a(Object obj) {
                LoginPhoneCodeActivity.n0(this.f61647a, (ActivityResult) obj);
            }
        });
    }

    public static final void n0(LoginPhoneCodeActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.setResult(-1);
            this$0.finish();
        }
    }

    public static final void o0(LoginPhoneCodeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p0(LoginPhoneCodeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.f61555k || this$0.f61546a == null) {
            this$0.x0(this$0.getString(R$string.login_verifcation_err));
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.login_net_err);
            return;
        }
        this$0.showLoading();
        LoginSmsCodeRequest loginSmsCodeRequest = this$0.f61546a;
        if (loginSmsCodeRequest != null) {
            loginSmsCodeRequest.setVerificationCode(String.valueOf(((n00.f) this$0.getMViewBinding()).f71398d.getText()));
        }
        LoginPhoneViewModel loginPhoneViewModel = this$0.f61548c;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.K(this$0.f61546a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void q0(LoginPhoneCodeActivity this$0, View view) {
        LoginCheckPhoneExistResult loginCheckPhoneExistResult;
        Intrinsics.g(this$0, "this$0");
        if (this$0.f61552h > 0) {
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.login_net_err);
            return;
        }
        this$0.showLoading();
        LoginSmsCodeRequest loginSmsCodeRequest = this$0.f61546a;
        if (loginSmsCodeRequest != null) {
            loginSmsCodeRequest.setVerificationCode(String.valueOf(((n00.f) this$0.getMViewBinding()).f71398d.getText()));
        }
        LoginPhoneViewModel loginPhoneViewModel = this$0.f61548c;
        if (loginPhoneViewModel != null) {
            LoginSmsCodeRequest loginSmsCodeRequest2 = this$0.f61546a;
            LoginCheckPhoneExistResult loginCheckPhoneExistResult2 = this$0.f61547b;
            int i11 = 1;
            if ((loginCheckPhoneExistResult2 != null && loginCheckPhoneExistResult2.getExists()) || ((loginCheckPhoneExistResult = this$0.f61547b) != null && loginCheckPhoneExistResult.getReset())) {
                i11 = 2;
            }
            loginPhoneViewModel.D(loginSmsCodeRequest2, i11);
        }
        HashMap map = new HashMap();
        map.put("is_login", "true");
        String str = this$0.f61551g;
        if (str == null) {
            str = "";
        }
        map.put("source", str);
        com.transsion.baselib.report.m.f51277a.m(this$0.getPageName(), "click", map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void r0(LoginPhoneCodeActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        ((n00.f) this$0.getMViewBinding()).f71398d.requestFocus();
    }

    public static final void s0(LoginPhoneCodeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.d(this$0);
    }

    private final void showLoading() {
        if (this.f61549d == null) {
            this.f61549d = new com.transsion.baseui.dialog.b(this);
        }
        com.transsion.baseui.dialog.b bVar = this.f61549d;
        if (bVar != null) {
            bVar.show();
        }
    }

    private final void t0() {
        LoginPhoneViewModel loginPhoneViewModel = (LoginPhoneViewModel) new v0(this).a(LoginPhoneViewModel.class);
        loginPhoneViewModel.u().j(this, new b(new Function1<Boolean, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneCodeActivity$initViewModel$1$1
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
                this.this$0.j0();
                Intrinsics.f(it, "it");
                if (it.booleanValue()) {
                    Intent intent = new Intent(this.this$0, (Class<?>) LoginSetPwdActivity.class);
                    intent.putExtra("requestData", this.this$0.f61546a);
                    intent.putExtra("checkPhoneData", this.this$0.f61547b);
                    intent.putExtra("source", this.this$0.f61551g);
                    b1.b bVar = this.this$0.f61550f;
                    if (bVar != null) {
                        bVar.a(intent);
                    }
                }
            }
        }));
        loginPhoneViewModel.F().j(this, new b(new Function1<LoginSmsCodeRequest, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneCodeActivity$initViewModel$1$2
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
                this.this$0.j0();
                if (loginSmsCodeRequest != null) {
                    LoginPhoneCodeActivity loginPhoneCodeActivity = this.this$0;
                    loginPhoneCodeActivity.f61552h = loginPhoneCodeActivity.k0();
                    loginPhoneCodeActivity.f61553i.post(loginPhoneCodeActivity.f61554j);
                    HashMap map = new HashMap();
                    map.put("is_login", "true");
                    String str = loginPhoneCodeActivity.f61551g;
                    if (str != null) {
                        map.put("source", str);
                    }
                    com.transsion.baselib.report.m.f51277a.m(loginPhoneCodeActivity.getPageName(), "click", map);
                }
            }
        }));
        loginPhoneViewModel.z().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginPhoneCodeActivity$initViewModel$1$3
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
                this.this$0.x0(str);
                HashMap map = new HashMap();
                map.put(TrackingKey.ERROR_CODE, String.valueOf(str));
                String str2 = this.this$0.f61551g;
                if (str2 != null) {
                    map.put("source", str2);
                }
                com.transsion.baselib.report.m.f51277a.m(this.this$0.getPageName(), "click", map);
            }
        }));
        this.f61548c = loginPhoneViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void u0(LoginPhoneCodeActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        long j11 = this$0.f61552h - 1;
        this$0.f61552h = j11;
        if (j11 <= 0) {
            this$0.w0();
            return;
        }
        ((n00.f) this$0.getMViewBinding()).f71397c.setEnabled(false);
        ((n00.f) this$0.getMViewBinding()).f71397c.setText(this$0.getString(R$string.login_seconds, Long.valueOf(this$0.f61552h)));
        this$0.i0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void v0(LoginPhoneCodeActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        AppCompatEditText appCompatEditText = ((n00.f) this$0.getMViewBinding()).f71398d;
        appCompatEditText.clearFocus();
        appCompatEditText.requestFocus();
        KeyboardUtils.i(appCompatEditText);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "code_enter";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0() {
        Editable text = ((n00.f) getMViewBinding()).f71398d.getText();
        boolean z11 = false;
        if (text != null && text.length() == 6) {
            z11 = true;
        }
        this.f61555k = z11;
        if (z11) {
            x0(null);
        }
    }

    public final void i0() {
        this.f61553i.postDelayed(this.f61554j, 1000L);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !com.transsion.baselib.utils.o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    public final long k0() {
        String strAccount;
        LoginSmsCodeRequest loginSmsCodeRequest = this.f61546a;
        if (loginSmsCodeRequest == null || (strAccount = loginSmsCodeRequest.account()) == null) {
            strAccount = "";
        }
        return 60 - ((SystemClock.elapsedRealtime() - LoginSmsCodeMmkvUtil.f61454a.a().getLong(strAccount, SystemClock.elapsedRealtime())) / ((long) 1000));
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public n00.f getViewBinding() {
        n00.f fVarC = n00.f.c(getLayoutInflater());
        Intrinsics.f(fVarC, "inflate(layoutInflater)");
        return fVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        HashMap<String, String> mapG;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("source")) == null) {
            stringExtra = null;
        } else {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("source", stringExtra);
            }
        }
        this.f61551g = stringExtra;
        this.f61546a = (LoginSmsCodeRequest) getIntent().getSerializableExtra("requestData");
        this.f61547b = (LoginCheckPhoneExistResult) getIntent().getSerializableExtra("checkPhoneData");
        this.f61552h = k0();
        initView();
        t0();
        m0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((n00.f) getMViewBinding()).f71398d.removeCallbacks(this.f61556l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((n00.f) getMViewBinding()).f71398d.postDelayed(this.f61556l, 500L);
        LoginProgressBar it = ((n00.f) getMViewBinding()).f71400g.f71449c;
        Intrinsics.f(it, "it");
        if (!so.c.i(it) || it.getProgress() > it.getStartProgress()) {
            return;
        }
        it.startProgressIncrease();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w0() {
        ((n00.f) getMViewBinding()).f71397c.setText(R$string.login_phone_code_resend);
        ((n00.f) getMViewBinding()).f71397c.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(String str) {
        if (str == null || str.length() == 0) {
            AppCompatTextView appCompatTextView = ((n00.f) getMViewBinding()).f71402i;
            Intrinsics.f(appCompatTextView, "mViewBinding.tvTips");
            so.c.g(appCompatTextView);
        } else {
            AppCompatTextView appCompatTextView2 = ((n00.f) getMViewBinding()).f71402i;
            Intrinsics.f(appCompatTextView2, "mViewBinding.tvTips");
            so.c.k(appCompatTextView2);
            ((n00.f) getMViewBinding()).f71402i.setText(str);
        }
    }
}
