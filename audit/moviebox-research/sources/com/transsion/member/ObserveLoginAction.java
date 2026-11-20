package com.transsion.member;

import com.transsion.memberapi.IMemberApi;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ObserveLoginAction implements r00.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f53214c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f53215d = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ObserveLoginAction f53216f = new ObserveLoginAction();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f53217a = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.member.ObserveLoginAction$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<su.e> f53218b = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ObserveLoginAction a() {
            return ObserveLoginAction.f53216f;
        }
    }

    private final String f() {
        String simpleName = ObserveLoginAction.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final ILoginApi g() {
        return (ILoginApi) this.f53217a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        com.transsion.member.a.f53220a.a(f() + " --> onLogin() --> 监听到用户登录行为 --> 获取会员权益 --> refresh() --> 刷新UI");
        j.d(l0.a(w0.c()), null, null, new ObserveLoginAction$refresh$1(this, null), 3, null);
    }

    public final void d(su.e listener) {
        Intrinsics.g(listener, "listener");
        this.f53218b.add(listener);
    }

    public final void e() {
        com.transsion.member.a.f53220a.c(f() + " --> addLoginListener() --> 设置用户登录状态监听");
        ILoginApi iLoginApiG = g();
        if (iLoginApiG != null) {
            iLoginApiG.F(this);
        }
    }

    public final void h() {
        j.d(l0.a(w0.c()), null, null, new ObserveLoginAction$getMemberSuccess$1(this, null), 3, null);
    }

    public final void i() {
        f53216f.e();
    }

    public final void k(su.e listener) {
        Intrinsics.g(listener, "listener");
        this.f53218b.remove(listener);
    }

    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        r00.a.C0822a.a(this, user);
        com.transsion.member.a.f53220a.a(f() + " --> onLogin() --> 监听到用户登录行为 --> 获取会员权益");
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).h1(new Function0<Unit>() { // from class: com.transsion.member.ObserveLoginAction.onLogin.1
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
                ObserveLoginAction.this.j();
            }
        });
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
        com.transsion.member.a.f53220a.a(f() + " --> onLogout() --> 监听到用户登出行为 --> 获取会员权益");
        MemberKV.f53157a.a().putBoolean("kv_is_skip_ad", false);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }
}
