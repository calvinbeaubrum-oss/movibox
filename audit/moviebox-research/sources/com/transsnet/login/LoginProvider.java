package com.transsnet.login;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.login.constant.LoginMmkvUtil;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import io.reactivex.rxjava3.core.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/Login/Api")
@Metadata
@SourceDebugExtension
public final class LoginProvider implements ILoginApi {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f61428f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<ILoginApi> f61429g = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsnet.login.LoginProvider$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f61430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile UserInfo f61431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<WeakReference<r00.a>> f61432c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f61433d = LazyKt__LazyJVMKt.b(new Function0<o00.a>() { // from class: com.transsnet.login.LoginProvider$iVodApi$2
        @Override // kotlin.jvm.functions.Function0
        public final o00.a invoke() {
            return (o00.a) NetServiceGenerator.f49399d.a().i(o00.a.class);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f61434e = "X-User";

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ILoginApi a() {
            Object value = LoginProvider.f61429g.getValue();
            Intrinsics.f(value, "<get-instance>(...)");
            return (ILoginApi) value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b<T, R> implements k10.h {
        public b() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BaseDto<UserInfo> apply(BaseDto<UserInfo> it) {
            Intrinsics.g(it, "it");
            UserInfo data = it.getData();
            if (data != null) {
                UserInfo userInfo = LoginProvider.this.f61431b;
                data.setToken(userInfo != null ? userInfo.getToken() : null);
            }
            return it;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c<T> implements k10.f {
        public c() {
        }

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto<UserInfo> it) {
            Intrinsics.g(it, "it");
            LoginProvider.this.N1(it.getData());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class d extends zo.a<UserInfo> {
        public d() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            if (userInfo != null) {
                LoginProvider.this.R1(userInfo);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class e<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T, R> f61438a = new e<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(String it) {
            Intrinsics.g(it, "it");
            JsonObject jsonObject = new JsonObject();
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObject.toString();
            Intrinsics.f(string, "json.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class f<T, R> implements k10.h {
        public f() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<UserInfo>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return LoginProvider.this.K1().h(cp.a.f62775a.a(), it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class g extends zo.a<UserInfo> {
        public g() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginProvider.this.Q();
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            LoginProvider.this.Q();
            if (userInfo != null) {
                LoginProvider.this.O1(userInfo);
            }
        }
    }

    public static final void M1(LoginProvider this$0) {
        Intrinsics.g(this$0, "this$0");
        Iterator<T> it = this$0.f61432c.iterator();
        while (it.hasNext()) {
            r00.a aVar = (r00.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onLogout();
            }
        }
    }

    public static final void P1(LoginProvider this$0, UserInfo userInfo) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(userInfo, "$userInfo");
        Iterator<T> it = this$0.f61432c.iterator();
        while (it.hasNext()) {
            r00.a aVar = (r00.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onLogin(userInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        this.f61431b = null;
        LoginMmkvUtil.f61452a.a().putString("login_user", "");
        ip.a.f67589a.h("");
        ThreadUtils.j(new Runnable() { // from class: com.transsnet.login.i
            @Override // java.lang.Runnable
            public final void run() {
                LoginProvider.M1(this.f61524a);
            }
        });
    }

    public static final void S1(LoginProvider this$0, UserInfo userInfo) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(userInfo, "$userInfo");
        Iterator<T> it = this$0.f61432c.iterator();
        while (it.hasNext()) {
            r00.a aVar = (r00.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onUpdateUserInfo(userInfo);
            }
        }
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public Country C() {
        return m00.a.f70582a.b();
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void F(r00.a listener) {
        Intrinsics.g(listener, "listener");
        if (J1(listener) == null) {
            this.f61432c.add(new WeakReference<>(listener));
        }
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void H0(Context context) {
        String userId;
        Intrinsics.g(context, "context");
        this.f61430a = context;
        String string = LoginMmkvUtil.f61452a.a().getString("login_user", "");
        String str = string != null ? string : "";
        UserInfo userInfo = !TextUtils.isEmpty(str) ? (UserInfo) n.d(str, UserInfo.class) : null;
        if (this.f61431b == null) {
            this.f61431b = userInfo;
            if (userInfo == null || (userId = userInfo.getUserId()) == null) {
                return;
            }
            ip.a.f67589a.h(userId);
        }
    }

    public void I1(String str) {
        o00.a aVarK1 = K1();
        if (str == null) {
            str = "";
        }
        o00.a.C0775a.c(aVarK1, str, null, 2, null).r(q10.a.b()).q(new b()).g(new c()).e(zo.d.f82109a.c()).subscribe(new d());
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void J(Response response) {
        Intrinsics.g(response, "response");
        try {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    Q1();
                    return;
                }
                return;
            }
            String str = response.headers().get(this.f61434e);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UserInfo user = (UserInfo) n.d(str, UserInfo.class);
            if (this.f61431b == null) {
                Intrinsics.f(user, "user");
                O1(user);
                return;
            }
            UserInfo userInfo = this.f61431b;
            if (TextUtils.equals(userInfo != null ? userInfo.getToken() : null, user.getToken())) {
                return;
            }
            UserInfo userInfo2 = this.f61431b;
            if (userInfo2 != null) {
                userInfo2.setToken(user.getToken());
            }
            N1(this.f61431b);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final WeakReference<r00.a> J1(r00.a aVar) {
        for (WeakReference<r00.a> weakReference : this.f61432c) {
            r00.a aVar2 = weakReference.get();
            if (aVar2 != null && aVar2 == aVar) {
                return weakReference;
            }
        }
        return null;
    }

    public final o00.a K1() {
        return (o00.a) this.f61433d.getValue();
    }

    public final void L1() {
        io.reactivex.rxjava3.core.j.p("").q(e.f61438a).k(new f()).e(zo.d.f82109a.c()).subscribe(new g());
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public boolean N() {
        UserInfo userInfo;
        return (this.f61431b == null || (userInfo = this.f61431b) == null || userInfo.getUserType() != 1) ? false : true;
    }

    public final synchronized void N1(UserInfo userInfo) {
        String userId;
        try {
            this.f61431b = userInfo;
            uo.b.a.e(uo.b.f78622a, AppLovinEventTypes.USER_LOGGED_IN, "saveUserInfo " + (userInfo != null ? userInfo.getUserId() : null), new Throwable("info"), false, 8, null);
            if (userInfo != null && (userId = userInfo.getUserId()) != null) {
                ip.a.f67589a.h(userId);
            }
            LoginMmkvUtil.f61452a.a().putString("login_user", n.j(userInfo));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void O1(final UserInfo userInfo) {
        N1(userInfo);
        ThreadUtils.j(new Runnable() { // from class: com.transsnet.login.j
            @Override // java.lang.Runnable
            public final void run() {
                LoginProvider.P1(this.f61539a, userInfo);
            }
        });
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public UserInfo P() {
        return this.f61431b;
    }

    public void Q1() {
        Q();
    }

    public final void R1(final UserInfo userInfo) {
        this.f61431b = userInfo;
        ThreadUtils.j(new Runnable() { // from class: com.transsnet.login.k
            @Override // java.lang.Runnable
            public final void run() {
                LoginProvider.S1(this.f61541a, userInfo);
            }
        });
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public Object Y0(UserInfo userInfo, Continuation<? super Unit> continuation) {
        O1(userInfo);
        I1(userInfo.getUserId());
        return Unit.f68710a;
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public String b() {
        String string = Utils.a().getString(R$string.login_success);
        Intrinsics.f(string, "getApp().getString(R.string.login_success)");
        return string;
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void b1(long j11) {
        LoginMmkvUtil.f61452a.a().putLong("login_launch_first_state", j11);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void e() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            L1();
        } else {
            Q();
        }
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public long g1() {
        return LoginMmkvUtil.f61452a.a().getLong("login_launch_first_state", 0L);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        Intrinsics.g(context, "context");
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public Intent o1(Context context) {
        Intrinsics.g(context, "context");
        return new Intent(context, (Class<?>) LoginLikeActivity.class);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void t1(r00.a listener) {
        Intrinsics.g(listener, "listener");
        List<WeakReference<r00.a>> list = this.f61432c;
        TypeIntrinsics.a(list).remove(J1(listener));
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void w0(Context context) {
        Intrinsics.g(context, "context");
        Intent intent = new Intent(context, (Class<?>) LoginLikeActivity.class);
        intent.setFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }
}
