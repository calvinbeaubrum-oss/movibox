package com.transsion.subroom.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.ad.middle.splash.NonSplashActivity;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.o;
import com.transsion.baseui.activity.BaseCommonActivity;
import com.transsion.commercialization.dialog.MainAppLifecycleObserver;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.subroom.activity.MainActivity;
import com.transsion.subroom.activity.SplashActivity;
import com.transsion.web.api.WebConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;
import zo.d;

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
public final class LaunchViewModel extends androidx.lifecycle.b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f58047d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f58049c;

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
    public static final class b extends zo.a<ILaunchApi.UrlBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Uri f58051f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f58052g;

        public b(Uri uri, Function0<Unit> function0) {
            this.f58051f = uri;
            this.f58052g = function0;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LaunchViewModel launchViewModel = LaunchViewModel.this;
            Uri uri = this.f58051f;
            launchViewModel.j(uri, uri, null, this.f58052g);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ILaunchApi.UrlBean urlBean) {
            String url;
            super.c(urlBean);
            if (urlBean != null) {
                try {
                    url = urlBean.getUrl();
                    if (url == null) {
                        url = "";
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            } else {
                url = "";
            }
            if (!TextUtils.isEmpty(url)) {
                LaunchViewModel.this.j(this.f58051f, Uri.parse(url), null, this.f58052g);
                return;
            }
            LaunchViewModel launchViewModel = LaunchViewModel.this;
            Uri uri = this.f58051f;
            launchViewModel.j(uri, uri, null, this.f58052g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends NavCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f58053a;

        public c(Function0<Unit> function0) {
            this.f58053a = function0;
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onArrival(Postcard postcard) {
            Function0<Unit> function0 = this.f58053a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onInterrupt(Postcard postcard) {
            Function0<Unit> function0 = this.f58053a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onLost(Postcard postcard) {
            Function0<Unit> function0 = this.f58053a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f58048b = LazyKt__LazyJVMKt.b(new Function0<ILaunchApi>() { // from class: com.transsion.subroom.deeplink.LaunchViewModel$mLaunchApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILaunchApi invoke() {
                return (ILaunchApi) NetServiceGenerator.f49399d.a().i(ILaunchApi.class);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(LaunchViewModel launchViewModel, Context context, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        launchViewModel.f(context, function0);
    }

    public final void d(Uri uri, Function0<Unit> function0) {
        ILaunchApi iLaunchApiE = e();
        String string = uri.toString();
        Intrinsics.f(string, "shortUri.toString()");
        ILaunchApi.a.a(iLaunchApiE, string, null, 2, null).e(d.f82109a.c()).subscribe(new b(uri, function0));
    }

    public final ILaunchApi e() {
        return (ILaunchApi) this.f58048b.getValue();
    }

    public final void f(Context context, Function0<Unit> function0) {
        if (!com.transsion.baselib.helper.b.f51184a.c(this.f58049c)) {
            j(null, this.f58049c, context, function0);
            return;
        }
        Uri uri = this.f58049c;
        if (uri != null) {
            d(uri, function0);
        }
    }

    public final void h(Context context, Uri uri, Function0<Unit> onArrival) {
        Intrinsics.g(context, "context");
        Intrinsics.g(uri, "uri");
        Intrinsics.g(onArrival, "onArrival");
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("withoutMain", false);
        boolean booleanQueryParameter2 = uri.getBooleanQueryParameter("withoutAd", false);
        o.f51281a.i(uri);
        this.f58049c = uri;
        try {
            String queryParameter = uri.getQueryParameter("miniapp_deeplink");
            if (queryParameter != null && queryParameter.length() != 0) {
                cs.a.f62808a.b(context, queryParameter);
                return;
            }
        } catch (Throwable unused) {
        }
        if (booleanQueryParameter2) {
            oq.a.f72510a.b();
            MainAppLifecycleObserver.f51629b.b(true);
        }
        if (!i()) {
            f(context, onArrival);
        } else {
            if (booleanQueryParameter) {
                f(context, onArrival);
                return;
            }
            b().registerActivityLifecycleCallbacks(this);
            k(context, booleanQueryParameter2);
            onArrival.invoke();
        }
    }

    public final boolean i() {
        for (Activity activity : RoomActivityLifecycleCallbacks.f51239a.e()) {
            if ((activity instanceof SplashActivity) || (activity instanceof NonSplashActivity) || (activity instanceof MainActivity)) {
                return false;
            }
        }
        return true;
    }

    public final void j(Uri uri, Uri uri2, Context context, Function0<Unit> function0) {
        String string;
        IFissionProvider iFissionProvider;
        String string2;
        String str = "";
        if (uri != null) {
            try {
                string = uri.toString();
                if (string == null) {
                    string = "";
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
            e11.printStackTrace();
            return;
        }
        string = "";
        if (uri2 != null && (string2 = uri2.toString()) != null) {
            str = string2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("toLandingPage short url: ");
        sb2.append(string);
        sb2.append(" whole url ");
        sb2.append(str);
        if (uri2 != null) {
            try {
                String queryParameter = uri2.getQueryParameter("inviteCode");
                if (queryParameter != null && (iFissionProvider = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class)) != null) {
                    iFissionProvider.I(queryParameter);
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        o.f51281a.g(string, str);
        Uri uriD = com.transsion.baselib.helper.b.f51184a.d(uri2);
        if (uriD != null) {
            com.alibaba.android.arouter.launcher.a.d().a(uriD).withBoolean(BaseCommonActivity.EXTRA_SHOW_HOME_BUTTON, uriD.getBooleanQueryParameter(BaseCommonActivity.EXTRA_SHOW_HOME_BUTTON, false)).navigation((Context) null, new c(function0));
        }
    }

    public final void k(Context context, boolean z11) {
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra("from", WebConstants.FIELD_DEEPLINK);
        intent.putExtra("without_ad", z11);
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity p11, Bundle bundle) {
        Intrinsics.g(p11, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity p11) {
        Intrinsics.g(p11, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity p11) {
        Intrinsics.g(p11, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity p11) {
        Intrinsics.g(p11, "p0");
        try {
            if (p11 instanceof MainActivity) {
                b().unregisterActivityLifecycleCallbacks(this);
                g(this, p11, null, 2, null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity p11, Bundle p12) {
        Intrinsics.g(p11, "p0");
        Intrinsics.g(p12, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity p11) {
        Intrinsics.g(p11, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity p11) {
        Intrinsics.g(p11, "p0");
    }
}
