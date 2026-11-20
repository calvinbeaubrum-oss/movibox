package com.transsnet.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baselib.report.m;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.activity.BaseCommonActivity;
import com.transsion.baseui.util.n;
import com.transsnet.login.constant.LoginMmkvUtil;
import com.transsnet.login.email.LoginEmailPwdActivity;
import com.transsnet.login.phone.LoginPwdActivity;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LoginLikeActivity extends BaseActivity<n00.e> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f61419i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b1.b<Intent> f61420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f61421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f61422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoginViewModel f61423d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f61424f = LazyKt__LazyJVMKt.b(new Function0<GoogleSignInOptions>() { // from class: com.transsnet.login.LoginLikeActivity$gso$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GoogleSignInOptions invoke() {
            GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(this.this$0.getString(R$string.google_client_token)).requestEmail().requestProfile().build();
            Intrinsics.f(googleSignInOptionsBuild, "Builder(GoogleSignInOpti….requestProfile().build()");
            return googleSignInOptionsBuild;
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f61425g = LazyKt__LazyJVMKt.b(new Function0<GoogleSignInClient>() { // from class: com.transsnet.login.LoginLikeActivity$mGoogleSignInClient$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GoogleSignInClient invoke() {
            LoginLikeActivity loginLikeActivity = this.this$0;
            GoogleSignInClient client = GoogleSignIn.getClient((Activity) loginLikeActivity, loginLikeActivity.Y());
            Intrinsics.f(client, "getClient(this, gso)");
            return client;
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61426h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61427a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61427a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61427a;
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
            this.f61427a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        com.transsion.baseui.dialog.b bVar = this.f61426h;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public static final void f0(LoginLikeActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.setResult(-1);
            this$0.finish();
            return;
        }
        if (activityResult.getResultCode() == 10086) {
            Intent data = activityResult.getData();
            if (Intrinsics.b(data != null ? data.getStringExtra("KEY_LOGIN_TYPE") : null, "PHONE")) {
                b1.b<Intent> bVar = this$0.f61420a;
                if (bVar != null) {
                    Intent intent = new Intent(this$0, (Class<?>) LoginPwdActivity.class);
                    intent.putExtra("source", this$0.f61421b);
                    bVar.a(intent);
                    return;
                }
                return;
            }
            b1.b<Intent> bVar2 = this$0.f61420a;
            if (bVar2 != null) {
                Intent intent2 = new Intent(this$0, (Class<?>) LoginEmailPwdActivity.class);
                intent2.putExtra("source", this$0.f61421b);
                bVar2.a(intent2);
            }
        }
    }

    public static final void g0(LoginLikeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        String string = LoginMmkvUtil.f61452a.a().getString("login_last_login_type", null);
        HashMap map = new HashMap();
        if (Intrinsics.b(string, "PHONE")) {
            b1.b<Intent> bVar = this$0.f61420a;
            if (bVar != null) {
                Intent intent = new Intent(this$0, (Class<?>) LoginPwdActivity.class);
                intent.putExtra("source", this$0.f61421b);
                bVar.a(intent);
            }
            map.put("module_name", "sign up with phone number");
        } else {
            b1.b<Intent> bVar2 = this$0.f61420a;
            if (bVar2 != null) {
                Intent intent2 = new Intent(this$0, (Class<?>) LoginEmailPwdActivity.class);
                intent2.putExtra("source", this$0.f61421b);
                bVar2.a(intent2);
            }
            map.put("module_name", "sign_up_email");
        }
        String str = this$0.f61421b;
        if (str != null) {
            map.put("source", str);
        }
        m.f51277a.m("sign_up_dialog", "click", map);
    }

    public static final void h0(LoginLikeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.W();
    }

    public static final void i0(LoginLikeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str = this.f61422c;
        if (str != null && str.length() != 0) {
            ((n00.e) getMViewBinding()).f71393i.setText(this.f61422c);
        }
        ((n00.e) getMViewBinding()).f71394j.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.i0(this.f61474a, view);
            }
        });
        ((n00.e) getMViewBinding()).f71389d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.j0(this.f61475a, view);
            }
        });
        ((n00.e) getMViewBinding()).f71387b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.k0(this.f61521a, view);
            }
        });
        AppCompatTextView appCompatTextView = ((n00.e) getMViewBinding()).f71391g;
        Intrinsics.f(appCompatTextView, "mViewBinding.tvLogIn");
        n.a(appCompatTextView, com.blankj.utilcode.util.i.e(8.0f));
        ((n00.e) getMViewBinding()).f71391g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.g0(this.f61522a, view);
            }
        });
        l lVar = l.f61543a;
        AppCompatTextView appCompatTextView2 = ((n00.e) getMViewBinding()).f71392h;
        Intrinsics.f(appCompatTextView2, "mViewBinding.tvPrivacy");
        lVar.a(this, appCompatTextView2);
        ((n00.e) getMViewBinding()).f71388c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.h0(this.f61523a, view);
            }
        });
    }

    public static final void j0(LoginLikeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k0(LoginLikeActivity this$0, View view) {
        b1.b<Intent> bVar;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(((n00.e) this$0.getMViewBinding()).f71387b.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (bVar = this$0.f61420a) == null) {
            return;
        }
        Intent intent = new Intent(this$0, (Class<?>) LoginActivity.class);
        intent.putExtra("source", this$0.f61421b);
        bVar.a(intent);
    }

    private final void showLoading() {
        if (this.f61426h == null) {
            this.f61426h = new com.transsion.baseui.dialog.b(this);
        }
        com.transsion.baseui.dialog.b bVar = this.f61426h;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void W() {
        HashMap map = new HashMap();
        map.put("module_name", "google");
        String str = this.f61421b;
        if (str != null) {
            map.put("source", str);
        }
        m.f51277a.m("sign_up_dialog", "click", map);
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (lastSignedInAccount != null) {
            Scope[] scopeArray = Y().getScopeArray();
            if (GoogleSignIn.hasPermissions(lastSignedInAccount, (Scope[]) Arrays.copyOf(scopeArray, scopeArray.length)) && !lastSignedInAccount.isExpired()) {
                c0(lastSignedInAccount);
                return;
            }
        }
        b0();
    }

    public final GoogleSignInOptions Y() {
        return (GoogleSignInOptions) this.f61424f.getValue();
    }

    public final GoogleSignInClient Z() {
        return (GoogleSignInClient) this.f61425g.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public n00.e getViewBinding() {
        n00.e eVarC = n00.e.c(getLayoutInflater());
        Intrinsics.f(eVarC, "inflate(layoutInflater)");
        return eVarC;
    }

    public final void b0() {
        Intent signInIntent = Z().getSignInIntent();
        Intrinsics.f(signInIntent, "mGoogleSignInClient.signInIntent");
        startActivityForResult(signInIntent, 10010);
    }

    public final void c0(GoogleSignInAccount googleSignInAccount) {
        String idToken;
        if (googleSignInAccount == null || (idToken = googleSignInAccount.getIdToken()) == null) {
            return;
        }
        showLoading();
        LoginViewModel loginViewModel = this.f61423d;
        if (loginViewModel != null) {
            loginViewModel.g(idToken);
        }
    }

    public final void d0(Task<GoogleSignInAccount> task) {
        try {
            c0(task.getResult(ApiException.class));
        } catch (ApiException e11) {
            Log.w(BaseCommonActivity.TAG, "signInResult:failed code=" + e11.getStatusCode());
        }
    }

    public final void e0() {
        this.f61420a = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.c
            @Override // b1.a
            public final void a(Object obj) {
                LoginLikeActivity.f0(this.f61451a, (ActivityResult) obj);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "sign_up_dialog";
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    public final void l0() {
        LoginViewModel loginViewModel = (LoginViewModel) new v0(this).a(LoginViewModel.class);
        loginViewModel.f().j(this, new b(new Function1<UserInfo, Unit>() { // from class: com.transsnet.login.LoginLikeActivity$initViewMode$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserInfo userInfo) {
                invoke2(userInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfo userInfo) {
                this.this$0.X();
                if (userInfo != null) {
                    this.this$0.finish();
                }
            }
        }));
        this.f61423d = loginViewModel;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 10010) {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
            Intrinsics.f(signedInAccountFromIntent, "getSignedInAccountFromIntent(data)");
            d0(signedInAccountFromIntent);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra != null) {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("source", stringExtra);
            }
        } else {
            stringExtra = null;
        }
        this.f61421b = stringExtra;
        this.f61422c = getIntent().getStringExtra("title_name");
        l0();
        initView();
        e0();
    }
}
